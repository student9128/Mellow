package com.kevin.mellow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kevin.mellow.R;
import com.kevin.mellow.bean.ChineseWeekBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/28.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class ChineseWeekAdapter extends RecyclerView.Adapter<ChineseWeekAdapter.MyViewHolder> {
    private Context context;
    private List<ChineseWeekBean> data;

    public ChineseWeekAdapter(Context context, List<ChineseWeekBean> data) {
        this.context = context;
        this.data = data;
    }

    public void updateData(List<ChineseWeekBean> d) {
        d.clear();
        data.addAll(d);
        notifyDataSetChanged();
//        notifyItemRangeInserted(0, d.size());
    }

    @Override
    public ChineseWeekAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_chinese_week, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ChineseWeekAdapter.MyViewHolder holder, int position) {
        ChineseWeekBean chineseWeekBean = data.get(position);
        String authIt = chineseWeekBean.getData().getAuth_it();
        String webUrl = chineseWeekBean.getData().getAuthor().get(0).getWeb_url();
        holder.tvTitle.setText(authIt);
        Glide.with(context).load(webUrl).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;

        @BindView(R.id.iv)
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
