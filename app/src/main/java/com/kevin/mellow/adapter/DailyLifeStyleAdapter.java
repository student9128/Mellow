package com.kevin.mellow.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.bean.CityLifeStyleBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kevin on 2018/7/12.
 * <p>
 * Blog:https://student9128.github.io/
 * CSDN:https://blog.csdn.net/student9128
 * <p/>
 */
public class DailyLifeStyleAdapter extends RecyclerView.Adapter<DailyLifeStyleAdapter
        .MyViewHolder> {

    private Context context;
    private List<CityLifeStyleBean.HeWeather6Bean.LifestyleBean> data;

    public DailyLifeStyleAdapter(Context context, List<CityLifeStyleBean.HeWeather6Bean
            .LifestyleBean> data) {
        this.context = context;
        this.data = data;
    }

    public void updataLifeStyle(List<CityLifeStyleBean.HeWeather6Bean.LifestyleBean> d) {
        data.clear();
        data.addAll(d);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout
                .adapter_city_daily_liefstyle, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CityLifeStyleBean.HeWeather6Bean.LifestyleBean lifestyleBean = data.get(position);
        String type = lifestyleBean.getType();
        holder.ivLifestyleIcon.setImageResource(getLifeStyleIcon(type));
        holder.tvLifestyleName.setText(getLifeStyleName(type));
        holder.tvLifestyleValue.setText(lifestyleBean.getBrf());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_lifestyle_name)
        TextView tvLifestyleName;
        @BindView(R.id.tv_lifestyle_value)
        TextView tvLifestyleValue;
        @BindView(R.id.iv_lifestyle_icon)
        ImageView ivLifestyleIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private String getLifeStyleName(String name) {
        String x = "";
        switch (name) {
            case "comf":
                x = "舒适度指数";
                break;
            case "drsg":
                x = "穿衣指数";
                break;
            case "flu":
                x = "感冒指数";
                break;
            case "sport":
                x = "运动指数";
                break;
            case "trav":
                x = "旅游指数";
                break;
            case "uv":
                x = "紫外线指数";
                break;
            case "cw":
                x = "洗车指数";
                break;
            case "air":
                x = "空气污染扩散条件指数";
                break;
        }
        return x;
    }

    private int getLifeStyleIcon(String name) {
        int i = -1;
        switch (name) {
            case "comf":
                i = R.drawable.ic_index_comf;
                break;
            case "drsg":
                i = R.drawable.ic_index_drsg;
                break;
            case "flu":
                i = R.drawable.ic_index_flu;
                break;
            case "sport":
                i = R.drawable.ic_index_sport;
                break;
            case "trav":
                i = R.drawable.ic_index_trav;
                break;
            case "uv":
                i = R.drawable.ic_index_uv;
                break;
            case "cw":
                i = R.drawable.ic_index_cw;
                break;
            case "air":
                i = R.drawable.ic_index_air;
                break;
        }
        return i;
    }
}
