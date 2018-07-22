package com.kevin.mellow.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.bean.CityLifeStyleBean;
import com.kevin.mellow.listener.OnRecyclerItemClickListener;
import com.kevin.mellow.utils.LifestyleUtils;

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        CityLifeStyleBean.HeWeather6Bean.LifestyleBean lifestyleBean = data.get(position);
        String type = lifestyleBean.getType();
        holder.ivLifestyleIcon.setImageResource(LifestyleUtils.getLifeStyleIcon(type));
        holder.tvLifestyleName.setText(LifestyleUtils.getLifeStyleName(type));
        holder.tvLifestyleValue.setText(lifestyleBean.getBrf());
        holder.llLifestyleContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onRecyclerItemClick(position);
                }
            }
        });
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
        @BindView(R.id.ll_lifestyle_container)
        LinearLayout llLifestyleContainer;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }



    private OnRecyclerItemClickListener listener;

    public void setOnLifeStyleClickListener(OnRecyclerItemClickListener l) {
        listener = l;
    }
}
