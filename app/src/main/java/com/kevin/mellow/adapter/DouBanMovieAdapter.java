package com.kevin.mellow.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kevin.mellow.R;
import com.kevin.mellow.bean.DouBanMovieBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/6.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class DouBanMovieAdapter extends RecyclerView.Adapter<DouBanMovieAdapter.MyViewHolder> {

    private List<DouBanMovieBean.SubjectsBean> data;
    private Context context;

    public DouBanMovieAdapter(Context context, List<DouBanMovieBean.SubjectsBean> data) {
        this.context = context;
        this.data = data;
    }

    public void refreshData(List<DouBanMovieBean.SubjectsBean> d) {
        data.clear();
        data.addAll(d);
        notifyDataSetChanged();
    }

    public void loadMoreData(List<DouBanMovieBean.SubjectsBean> d) {
        data.addAll(d);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_dou_ban_movie, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        DouBanMovieBean.SubjectsBean subjectsBean = data.get(position);
        holder.tvTitle.setText(subjectsBean.getTitle());
        DouBanMovieBean.SubjectsBean.ImagesBean images = subjectsBean.getImages();
        Glide.with(context)
                .load(images.getMedium())
                .apply(new RequestOptions().centerCrop())
                .apply(new RequestOptions().placeholder(R.drawable.ic_mellow_place_holder))
                .apply(new RequestOptions().error(R.drawable.ic_failed))
                .into(holder.ivImage);
        double average = subjectsBean.getRating().getAverage();
        holder.rbRatingBar.setRating((float) (average / 2));
        holder.tvAverage.setText(String.valueOf(average));
        holder.cvCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onRecyclerViewItemClick(position);
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
        @BindView(R.id.rb_rating_bar)
        RatingBar rbRatingBar;
        @BindView(R.id.tv_average)
        TextView tvAverage;
        @BindView(R.id.cv_card_view)
        CardView cvCardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnRecyclerViewItemClickListener(OnRecyclerItemClickListener l) {
        this.listener = l;
    }

    private OnRecyclerItemClickListener listener;

    public interface OnRecyclerItemClickListener {
        void onRecyclerViewItemClick(int position);
    }
}
