package com.kevin.mellow.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kevin.mellow.R;
import com.kevin.mellow.bean.WeatherBean;
import com.kevin.mellow.utils.DateUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kevin on 2018/7/2.
 * <p>
 * Blog:https://student9128.github.io/
 * CSDN:https://blog.csdn.net/student9128
 * <p/>
 */
public class DailyForecastAdapter extends RecyclerView.Adapter<DailyForecastAdapter.MyViewHolder> {


    private Context context;
    private List<WeatherBean.HeWeather6Bean.DailyForecastBean> data;

    public DailyForecastAdapter(Context context, List<WeatherBean.HeWeather6Bean
            .DailyForecastBean> data) {
        this.context = context;
        this.data = data;
    }

    public void updateWeather(List<WeatherBean.HeWeather6Bean.DailyForecastBean> d) {
        data.clear();
        data.addAll(d);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_city_daily_forecast,
                parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        boolean night = DateUtils.isNight();
        WeatherBean.HeWeather6Bean.DailyForecastBean dailyForecastBean = data.get(position);
        String week = DateUtils.theDay(dailyForecastBean.getDate());
        holder.tvDateWeek.setText(week);
        holder.tvDate.setText(DateUtils.dateFormat6(dailyForecastBean.getDate()));
        if (night) {
            String condCodeN = dailyForecastBean.getCond_code_n();
            Glide.with(context).load("https://cdn.heweather.com/cond_icon/"+condCodeN+".png")
                    .apply(new RequestOptions().fitCenter())
                    .into(holder.ivWeatherIcon);
            holder.tvWeatherForecast.setText(dailyForecastBean.getCond_txt_n());
//            holder.tvTemperature.setText(dailyForecastBean.getTmp_min() + " ~ " +
//                    dailyForecastBean.getTmp_max() + "℃");
        } else {
            String condCodeD = dailyForecastBean.getCond_code_d();
            Glide.with(context).load("https://cdn.heweather.com/cond_icon/"+condCodeD+".png")
                    .apply(new RequestOptions().fitCenter())
                    .into(holder.ivWeatherIcon);
            holder.tvWeatherForecast.setText(dailyForecastBean.getCond_txt_d());
        }
            holder.tvTemperature.setText(dailyForecastBean.getTmp_max() + " ~ " + dailyForecastBean
                    .getTmp_min() + "℃");

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_date_week)
        TextView tvDateWeek;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.iv_weather_icon)
        ImageView ivWeatherIcon;
        @BindView(R.id.tv_weather_forecast)
        TextView tvWeatherForecast;
        @BindView(R.id.tv_temperature)
        TextView tvTemperature;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
