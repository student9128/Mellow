package com.kevin.mellow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kevin.mellow.R;
import com.kevin.mellow.bean.TuChongDiscoverBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/5.
 * <h3>
 * Describe:
 * <h3/>
 */
public class TuChongDiscoverHotEventAdapter extends RecyclerView
        .Adapter<TuChongDiscoverHotEventAdapter.MyViewHolder> {
    private Context context;
    private List<TuChongDiscoverBean.HotEventsBean> data;

    public TuChongDiscoverHotEventAdapter(Context context, List<TuChongDiscoverBean.HotEventsBean> data) {
        this.context = context;
        this.data = data;
    }

    public void updateData(List<TuChongDiscoverBean.HotEventsBean> d) {
        data.clear();
        data.addAll(d);
        notifyDataSetChanged();

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_tu_chong_discover_hot_event, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TuChongDiscoverBean.HotEventsBean hotEventsBean = data.get(position);
        holder.tvTopicTitle.setText(hotEventsBean.getTitle());
        holder.tvCreateDate.setText(hotEventsBean.getCreated_at());
        holder.tvCreateDate.setText(hotEventsBean.getEnd_at());
        holder.tvTip.setText(String.valueOf(hotEventsBean.getRemainingDays()));
        String imageUrl = hotEventsBean.getImages().get(0);
        Glide.with(context)
                .load(imageUrl)
                .apply(new RequestOptions().centerCrop())
                .apply(new RequestOptions().placeholder(R.drawable.ic_mellow_place_holder))
                .apply(new RequestOptions().error(R.drawable.ic_failed))
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_topic_title)
        TextView tvTopicTitle;
        @BindView(R.id.tv_create_date)
        TextView tvCreateDate;
        @BindView(R.id.tv_end_date)
        TextView tvEndDate;
        @BindView(R.id.tv_tip)
        TextView tvTip;
        @BindView(R.id.iv_image)
        ImageView ivImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
