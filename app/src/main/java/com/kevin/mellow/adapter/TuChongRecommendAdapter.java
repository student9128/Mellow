package com.kevin.mellow.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kevin.mellow.R;
import com.kevin.mellow.bean.TuChongFeedBean;
import com.kevin.mellow.utils.LogK;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/3.
 * <h3>
 * Describe:
 * <h3/>
 */
public class TuChongRecommendAdapter extends RecyclerView.Adapter<TuChongRecommendAdapter.MyViewHolder> {


    private Context context;
    private List<TuChongFeedBean.FeedListBean> data;

    public TuChongRecommendAdapter(Context context, List<TuChongFeedBean.FeedListBean> data) {
        this.context = context;
        this.data = data;
    }

    public void refreshData(List<TuChongFeedBean.FeedListBean> d) {
        data.clear();
        data.addAll(d);
//        data=d;
        notifyDataSetChanged();
    }

    public void loadMoreData(List<TuChongFeedBean.FeedListBean> d) {
        data.addAll(d);
        notifyDataSetChanged();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_tu_chong_recommend, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        TuChongFeedBean.FeedListBean feedListBean = data.get(position);
        holder.tvTitle.setText(feedListBean.getTitle());

        TuChongFeedBean.FeedListBean.SiteBean site = feedListBean.getSite();
        holder.tvAuthorName.setText(site.getName());
        holder.tvPassedTime.setText(feedListBean.getPassed_time());
        String excerpt = feedListBean.getExcerpt();
        SpannableString span = new SpannableString("缩进" + excerpt);
        span.setSpan(new ForegroundColorSpan(Color.TRANSPARENT), 0, 2,
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        holder.tvExcerpt.setText(span);
        holder.tvFavorites.setText(String.valueOf(feedListBean.getFavorites()));
        holder.tvComments.setText(String.valueOf(feedListBean.getComments()));
        Glide.with(context)
                .load(site.getIcon())
                .apply(new RequestOptions().circleCrop())
                .apply(new RequestOptions().placeholder(R.drawable.ic_mellow_place_holder))
                .apply(new RequestOptions().error(R.drawable.ic_failed))
                .into(holder.ivAuthorAvatar);

        String authorId = feedListBean.getAuthor_id();
        List<TuChongFeedBean.FeedListBean.ImagesBean> images = feedListBean.getImages();
        double imageCount = feedListBean.getImage_count();
        String str = "";
        if (imageCount > 0) {
            List<TuChongFeedBean.FeedListBean.ImagesBean> images1 = feedListBean.getImages();
            double imgId = images1.get(0).getImg_id();
            int i = new Double(imgId).intValue();
            str = String.valueOf(i);
            String imageUrl = "https://photo.tuchong.com/" + authorId + "/f/" + str + ".jpg";
//        String imageUrl = "https://photo.tuchong.com/1516848/f/26799131.jpg";
            LogK.d("TuChongAdapter-------", imageUrl);
            Glide.with(context)
                    .load(imageUrl)
                    .apply(new RequestOptions().fitCenter())
                    .apply(new RequestOptions().placeholder(R.drawable.ic_mellow_place_holder))
                    .apply(new RequestOptions().error(R.drawable.ic_failed))
                    .into(holder.ivImage);
        } else {
            String url = feedListBean.getTitle_image().getUrl();
            Glide.with(context)
                    .load(url)
                    .apply(new RequestOptions().fitCenter())
                    .apply(new RequestOptions().placeholder(R.drawable.ic_mellow_place_holder))
                    .apply(new RequestOptions().error(R.drawable.ic_failed))
                    .into(holder.ivImage);
        }

        holder.rlAuthorContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onAuthorViewItemClick(position);
                }
            }
        });
        holder.rlImageContaier.setOnClickListener(new View.OnClickListener() {
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
        @BindView(R.id.iv_image)
        ImageView ivImage;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.iv_author_avatar)
        ImageView ivAuthorAvatar;
        @BindView(R.id.tv_author_name)
        TextView tvAuthorName;
        @BindView(R.id.tv_passed_time)
        TextView tvPassedTime;
        @BindView(R.id.tv_excerpt)
        TextView tvExcerpt;
        @BindView(R.id.tv_favorites)
        TextView tvFavorites;
        @BindView(R.id.tv_comments)
        TextView tvComments;
        @BindView(R.id.cv_card_view)
        CardView cvCardView;

        @BindView(R.id.rl_author_container)
        RelativeLayout rlAuthorContainer;
        @BindView(R.id.rl_image_container)
        RelativeLayout rlImageContaier;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public void setOnAuthorViewItemClickListener(OnRecyclerItemClickListener l) {
        this.listener = l;
    }

    public void setOnImageClickListener(OnRecyclerItemClickListener l) {
        this.listener = l;
    }

    private OnRecyclerItemClickListener listener;

    public interface OnRecyclerItemClickListener {
        void onAuthorViewItemClick(int position);

        void onImageClick(int position);
    }
}
