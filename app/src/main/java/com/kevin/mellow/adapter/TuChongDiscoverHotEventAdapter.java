package com.kevin.mellow.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kevin.mellow.R;
import com.kevin.mellow.bean.TuChongDiscoverBean;
import com.kevin.mellow.utils.DateUtils;

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
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        TuChongDiscoverBean.HotEventsBean hotEventsBean = data.get(position);
        holder.tvTopicTitle.setText(hotEventsBean.getTitle());
        String createdAt = hotEventsBean.getCreated_at();
        holder.tvCreateDate.setText("发起日期：" + DateUtils.dateFormat5(createdAt));
        String endAt = hotEventsBean.getEnd_at();
        if (TextUtils.isEmpty(endAt)) {
            holder.tvEndDate.setText("截止日期：无");
        } else {

            holder.tvEndDate.setText("截止日期：" + DateUtils.dateFormat5(endAt));
        }
        int remainDays = new Double(hotEventsBean.getDueDays()).intValue();
        String s = String.valueOf(remainDays);
        int imageCount = new Double(hotEventsBean.getImage_count()).intValue();
        String s1 = String.valueOf(imageCount);
        if (s != null && s1 != null) {
            SpannableString remainStr = new SpannableString("距离截稿还有" + s + "天 共" + s1 + "件作品");
            final int length = remainStr.length();
            remainStr.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.colorPrimary)),
                    6, 6 + s.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            remainStr.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context,
                    R.color.colorPrimary)), length - 3 - s1.length(), length - 3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            remainStr.setSpan(new AbsoluteSizeSpan(20, true), 6, 6 + s.length(),
                    Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            remainStr.setSpan(new AbsoluteSizeSpan(20, true), length - 3 - s1.length(), length - 3,
                    Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            holder.tvTip.setText(remainStr);
        }
        String imageUrl = hotEventsBean.getImages().get(0);
        Glide.with(context)
                .load(imageUrl)
                .apply(new RequestOptions().centerCrop())
                .apply(new RequestOptions().placeholder(R.drawable.ic_mellow_place_holder))
                .apply(new RequestOptions().error(R.drawable.ic_failed))
                .into(holder.ivImage);
        holder.llTopicContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onTopicViewItemClick(position);
                }
            }
        });
        holder.ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onImageClick(position);
                }
            }
        });
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
        @BindView(R.id.ll_topic_container)
        LinearLayout llTopicContainer;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public void setOnTopicViewItemClickListener(OnRecyclerItemClickListener l) {
        this.listener = l;
    }

    public void setOnImageClickListener(OnRecyclerItemClickListener l) {
        this.listener = l;
    }

    private OnRecyclerItemClickListener listener;

    public interface OnRecyclerItemClickListener {
        void onTopicViewItemClick(int position);

        void onImageClick(int position);
    }
}
