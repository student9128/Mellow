package com.kevin.mellow.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kevin.mellow.R;
import com.kevin.mellow.bean.DouBanMovieReviewBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/22.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class DouBanMovieReviewAdapter extends RecyclerView.Adapter<DouBanMovieReviewAdapter.MyViewHolder> {


    private Context context;
    private List<DouBanMovieReviewBean.ReviewsBean> reviews;

    public DouBanMovieReviewAdapter(Context context, List<DouBanMovieReviewBean.ReviewsBean> reviews) {
        this.context = context;
        this.reviews = reviews;
    }

    public void showReviewsData(List<DouBanMovieReviewBean.ReviewsBean> r) {
        reviews.clear();
        reviews.addAll(r);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_dou_ban_movie_review, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DouBanMovieReviewBean.ReviewsBean reviewsBean = reviews.get(position);
        Glide.with(context)
                .load(reviewsBean.getAuthor().getAvatar())
                .apply(new RequestOptions().placeholder(R.drawable.ic_mellow_place_holder))
                .apply(new RequestOptions().error(R.drawable.ic_failed))
                .into(holder.ivImage);
        holder.tvName.setText(reviewsBean.getAuthor().getName());
        holder.tvTitle.setText(reviewsBean.getTitle());
//        holder.tvUsefulCount.setText((int) reviewsBean.getUseful_count() / (int) (reviewsBean.getUseless_count()
//                + reviewsBean.getUseful_count()) + " 有用");
        holder.tvComments.setText(String.valueOf((int) reviewsBean.getComments_count()));
        holder.tvSummary.setText(reviewsBean.getSummary());
        double usefulCount = reviewsBean.getUseful_count();
        double uselessCount = reviewsBean.getUseless_count();
        double v = usefulCount + uselessCount;
        holder.tvUsefulCount.setText(String.valueOf((int) usefulCount) + "/"+String.valueOf((int) v) + " 有用");
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_image)
        ImageView ivImage;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_summary)
        TextView tvSummary;
        @BindView(R.id.tv_useful_count)
        TextView tvUsefulCount;
        @BindView(R.id.iv_comments)
        ImageView ivComments;
        @BindView(R.id.tv_comments)
        TextView tvComments;
        @BindView(R.id.cv_card_view)
        CardView cvCardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
