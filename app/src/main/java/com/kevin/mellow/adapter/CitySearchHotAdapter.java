package com.kevin.mellow.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/6/11.
 * <h3>
 * Describe:
 * <h3/>
 */
public class CitySearchHotAdapter extends RecyclerView.Adapter<CitySearchHotAdapter.MyViewHolder>{
    @NonNull
    @Override
    public CitySearchHotAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CitySearchHotAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
