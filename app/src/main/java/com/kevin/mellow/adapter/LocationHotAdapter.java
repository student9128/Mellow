package com.kevin.mellow.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.bean.LocationHotBean;
import com.kevin.mellow.listener.OnLocationItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/24.
 * <h3>
 * Describe:
 * <h3/>
 */
public class LocationHotAdapter extends RecyclerView.Adapter<LocationHotAdapter.MyViewHolder> {
    private Context context;
    private List<LocationHotBean> data;

    public LocationHotAdapter(Context context, List<LocationHotBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public LocationHotAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        View view = View.inflate(parent.getContext(), R.layout.adapter_location_hot_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LocationHotAdapter.MyViewHolder holder, final int position) {
        if (data == null) {
            holder.tvLocationHot.setText("暂无");
        } else {
            holder.tvLocationHot.setText(data.get(position).getCity());
        }
        holder.tvLocationHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onHotLocationClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 1 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_location_hot)
        TextView tvLocationHot;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    private OnLocationItemClickListener listener;
    public void setOnHotLocationClick(OnLocationItemClickListener l) {
        this.listener =l;
    }
}
