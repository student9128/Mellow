package com.kevin.mellow.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kevin.mellow.R;
import com.kevin.mellow.bean.TuChongDiscoverBean;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/4.
 * <h3>
 * Describe:
 * <h3/>
 */
public class TuChongDiscoverBannerAdapter extends PagerAdapter {
    private Context context;
    private List<TuChongDiscoverBean.BannersBean> bannerData;

    public TuChongDiscoverBannerAdapter(Context context, List<TuChongDiscoverBean.BannersBean> d) {
        this.context = context;
        this.bannerData = d;
    }

    public void updateBanner(List<TuChongDiscoverBean.BannersBean> d) {
        bannerData.clear();
        bannerData.addAll(d);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bannerData == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_item_tu_chong_discover_banner, null);
        ImageView ivImage = view.findViewById(R.id.iv_image);
        if (bannerData.size() > 0) {
            position %= bannerData.size();
            if (position < 0) {
                position = position + bannerData.size();
            }
            TuChongDiscoverBean.BannersBean tag = bannerData.get(position);
            view.setTag(tag);
            Glide.with(context)
                    .load(tag.getSrc())
                    .apply(new RequestOptions().centerCrop())
                    .apply(new RequestOptions().placeholder(R.drawable.ic_mellow_place_holder))
                    .apply(new RequestOptions().error(R.drawable.ic_failed))
                    .into(ivImage);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        TuChongDiscoverBean.BannersBean tag = (TuChongDiscoverBean.BannersBean) ((View) object).getTag();
        int position = bannerData.indexOf(tag);
        if (position > 0) {
            return position;
        } else {
            return POSITION_NONE;
        }
    }
}
