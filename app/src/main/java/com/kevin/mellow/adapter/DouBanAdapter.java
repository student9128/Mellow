package com.kevin.mellow.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.kevin.mellow.R;
import com.kevin.mellow.adapter.common.CommonRecyclerViewAdapter;
import com.kevin.mellow.adapter.common.CommonRecyclerViewHolder;
import com.kevin.mellow.bean.DouBanMovieBean;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/5.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class DouBanAdapter extends CommonRecyclerViewAdapter<DouBanMovieBean.SubjectsBean> {

    public DouBanAdapter(Context context, List<DouBanMovieBean.SubjectsBean> dataList) {
        super(context, dataList, R.layout.adapter_dou_ban_movie);
    }


    @Override
    protected DouBanMovieBean.SubjectsBean clone(DouBanMovieBean.SubjectsBean data) {
        return null;
    }


    @Override
    protected boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return dataList.get(oldItemPosition).getTitle().equals(dataList.get(newItemPosition).getTitle());
    }

    @Override
    protected boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        String oldTitle = dataList.get(oldItemPosition).getTitle();
        String newTitle = dataList.get(newItemPosition).getTitle();
        double oldAverage = dataList.get(oldItemPosition).getRating().getAverage();
        double newAverage = dataList.get(newItemPosition).getRating().getAverage();

        if (!oldTitle.equals(newTitle)) {
            return false;
        }
        if (oldAverage != newAverage) {
            return false;
        }
        return true;
    }

    @NonNull
    @Override
    protected Bundle getChangePayload(int oldItemPosition, int newItemPosition) {
        Bundle bundle = new Bundle();
        String oldTitle = dataList.get(oldItemPosition).getTitle();
        String newTitle = dataList.get(newItemPosition).getTitle();
        double oldAverage = dataList.get(oldItemPosition).getRating().getAverage();
        double newAverage = dataList.get(newItemPosition).getRating().getAverage();
        long average = Math.round(newAverage / 2);
        if (!oldTitle.equals(newTitle)) {
            bundle.putString("title", newTitle);
        }
        if (oldAverage != newAverage) {
            bundle.putString("rating", String.valueOf(average));
        }
        return bundle;
    }

    @Override
    protected void partialBindData(CommonRecyclerViewHolder holder, @NonNull Bundle bundle) {
        for (String key : bundle.keySet()) {
            switch (key) {
                case "title":
                    holder.setText(R.id.tv_title, bundle.getString(key));
                    break;
                case "rating":
                    holder.setText(R.id.rb_rating_bar, bundle.getString(key));
                    break;
            }
        }
    }

    @Override
    protected void entirelyBindData(CommonRecyclerViewHolder holder, DouBanMovieBean.SubjectsBean data) {
        holder.setText(R.id.tv_title, data.getTitle());
        holder.setText(R.id.rb_rating_bar, String.valueOf(Math.round(data.getRating().getAverage()) / 2));
    }


}
