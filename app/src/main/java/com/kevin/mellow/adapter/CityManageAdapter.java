package com.kevin.mellow.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.bean.CityManageBean;
import com.kevin.mellow.bean.CitySearchBean;
import com.kevin.mellow.database.CityDataEntity;
import com.kevin.mellow.database.CityManageEntity;
import com.kevin.mellow.listener.OnRecyclerItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/6/11.
 * <h3>
 * Describe:
 * <h3/>
 */
public class CityManageAdapter extends RecyclerView.Adapter<CityManageAdapter.MyViewHolder> {

    private Context context;
    private List<CityManageEntity> data;

    public CityManageAdapter(Context context, List<CityManageEntity> data) {
        this.context = context;
        this.data = data;
    }

    public void updateData(List<CityManageEntity> d) {
        data.clear();
        data.addAll(d);
        notifyDataSetChanged();
    }

    public void clearData() {
        data.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_city_search, parent,
                false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        CityManageEntity cityManageEntity = data.get(position);
        holder.tvText.setText(cityManageEntity.getCityName());
        holder.tvText.setOnClickListener(new View.OnClickListener() {
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
        @BindView(R.id.tv_text)
        TextView tvText;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private OnRecyclerItemClickListener listener;

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener l) {
        this.listener = l;
    }

}
