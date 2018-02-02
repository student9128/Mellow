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
import com.kevin.mellow.bean.DouBanMoviePhotoBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/22.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class DouBanMoviePhotoAdapter extends RecyclerView.Adapter<DouBanMoviePhotoAdapter.MyViewHolder> {
    private Context context;
    private List<DouBanMoviePhotoBean.SubjectBean.CastsBean> casts;
    private List<DouBanMoviePhotoBean.SubjectBean.DirectorsBean> directors;

    public DouBanMoviePhotoAdapter(Context context,
                                   List<DouBanMoviePhotoBean.SubjectBean.CastsBean> casts,
                                   List<DouBanMoviePhotoBean.SubjectBean.DirectorsBean> directors) {
        this.context = context;
        this.casts = casts;
        this.directors = directors;
    }

    public void showAvatar(List<DouBanMoviePhotoBean.SubjectBean.CastsBean> c,
                           List<DouBanMoviePhotoBean.SubjectBean.DirectorsBean> d) {
        casts.clear();
        casts.addAll(c);
        directors.clear();
        directors.addAll(d);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_dou_ban_movie_photo, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DouBanMoviePhotoBean.SubjectBean.CastsBean castsBean = casts.get(position);
//        DouBanMoviePhotoBean.SubjectBean.DirectorsBean directorsBean = directors.get(position);
//        if (position == 0) {
//            Glide.with(context)
//                    .load(directorsBean.getAvatars())
//                    .apply(new RequestOptions().placeholder(R.drawable.ic_mellow_place_holder))
//                    .apply(new RequestOptions().error(R.drawable.ic_failed))
//                    .into(holder.ivImage);
//            holder.tvName.setText(directorsBean.getName());
//        } else {
        Glide.with(context)
                .load(castsBean.getAvatars().getLarge())
                .apply(new RequestOptions().centerCrop())
                .apply(new RequestOptions().placeholder(R.drawable.ic_mellow_place_holder))
                .apply(new RequestOptions().error(R.drawable.ic_failed))
                .into(holder.ivImage);
        holder.tvName.setText(castsBean.getName());
//        }
    }

    @Override
    public int getItemCount() {
//        if (directors.size() > 0 && casts.size() > 0) {
//            return casts.size() + 1;
//        } else if (casts.size() <= 0 && directors.size() > 0) {
//            return 1;
//        } else if (casts.size() > 0 && directors.size() <= 0) {
//            return casts.size();
//        } else {
//            return casts.size();
//        }
        return casts == null ? 0 : casts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_image)
        ImageView ivImage;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.cv_card_view)
        CardView cvCardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
