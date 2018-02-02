package com.kevin.mellow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kevin.mellow.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/22.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class TestAdapter extends RecyclerView.Adapter<TestAdapter.MyViewHolder> {
    private Context context;
    private List<String> data;

    public TestAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    public void addData(List<String> d) {
        data.clear();
        data.addAll(d);
        notifyDataSetChanged();
    }

    @Override
    public TestAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_dou_ban_movie, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(TestAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
