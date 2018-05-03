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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TuChongFeedBean.FeedListBean feedListBean = data.get(position);
        holder.tvTitle.setText(feedListBean.getTitle());

        TuChongFeedBean.FeedListBean.SiteBean site = feedListBean.getSite();
        holder.tvAuthorName.setText(site.getName());
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
        @BindView(R.id.cv_card_view)
        CardView cvCardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
//            ivImage = itemView.findViewById(R.id.iv_image);
//            tvTitle = itemView.findViewById(R.id.tv_title);
//            cvCardView = itemView.findViewById(R.id.cv_card_view);

        }
    }

    public void setOnRecyclerViewItemClickListener(DouBanMovieAdapter.OnRecyclerItemClickListener l) {
        this.listener = l;
    }

    private DouBanMovieAdapter.OnRecyclerItemClickListener listener;

    public interface OnRecyclerItemClickListener {
        void onRecyclerViewItemClick(int position);
    }
}
