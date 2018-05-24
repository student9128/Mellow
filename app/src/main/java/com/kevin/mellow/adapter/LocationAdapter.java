package com.kevin.mellow.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.bean.LocationHotBean;
import com.kevin.mellow.database.CityDataEntity;
import com.kevin.mellow.listener.OnLocationItemClickListener;
import com.kevin.mellow.view.GridItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/24.
 * <h3>
 * Describe:
 * <h3/>
 */
public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.MyViewHolder> {
    private static final int TYPE_CURRENT_LOCATION = 100;
    private static final int TYPE_HOT_LOCATION = 101;
    private static final int TYPE_LOCATION = 102;

    private Context context;
    private List<CityDataEntity> mData;
    private List<LocationHotBean> hotCitiesData;
    private LinearLayoutManager linearLayoutManager;


    public LocationAdapter(Context context, List<CityDataEntity> mData) {
        this.context = context;
        this.mData = mData;
    }

    public void addHotCityData(List<LocationHotBean> d) {
        hotCitiesData = d;
    }

    public void setLayoutManager(LinearLayoutManager lm) {
        this.linearLayoutManager = lm;
    }

    public void scrollToSection(String indexText) {
        if (mData == null || mData.isEmpty()) return;
        if (TextUtils.isEmpty(indexText)) return;
        int size = mData.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(indexText.substring(0, 1), mData.get(i).getSectionText()
                    .substring(0,
                            1))) {
                if (linearLayoutManager != null) {
                    linearLayoutManager.scrollToPositionWithOffset(i, 0);
                    return;//滑动到第一个就停止
                }
            }
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case TYPE_CURRENT_LOCATION:
                view = inflater.inflate(R.layout.adapter_location_current, parent,false);
                return new CurrentViewHolder(view);
            case TYPE_HOT_LOCATION:
                view = inflater.inflate(R.layout.adapter_location_hot, parent,false);
                return new HotViewHolder(view);
            case TYPE_LOCATION:
                view = inflater.inflate(R.layout
                        .adapter_location, parent,false);
                return new LocationViewHolder(view);
            default:
                view = inflater.inflate(R.layout
                        .adapter_location, parent,false);
                return new LocationViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.tvLocation.setText(mData.get(position).getCity());
        if (holder == null) return;
        if (holder instanceof LocationViewHolder) {
            final int adapterPosition = holder.getAdapterPosition();
            CityDataEntity dataEntity = mData.get(adapterPosition);
            if (dataEntity == null) return;
            ((LocationViewHolder) holder).tvLocation.setText(dataEntity.getCity());
            ((LocationViewHolder) holder).tvLocation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onLocationClick(adapterPosition);
                    }
                }
            });
        } else if (holder instanceof CurrentViewHolder) {
            int adapterPosition = holder.getAdapterPosition();
            CityDataEntity dataEntity = mData.get(adapterPosition);
            ((CurrentViewHolder) holder).tvLocationCurrent.setText(dataEntity.getCity());
            ((CurrentViewHolder) holder).tvLocationCurrent.setOnClickListener(new View
                    .OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onCurrentLocationClick();
                    }
                }
            });
        } else if (holder instanceof HotViewHolder) {
            int adapterPosition = holder.getAdapterPosition();
            CityDataEntity dataEntity = mData.get(adapterPosition);
            if (dataEntity == null) return;
            LocationHotAdapter adapter = new LocationHotAdapter(context, hotCitiesData);
            ((HotViewHolder) holder).recyclerViewHot.setAdapter(adapter);
            adapter.setOnHotLocationClick(listener);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && TextUtils.equals("定位", mData.get(position).getSectionText())) {
            return TYPE_CURRENT_LOCATION;
        } else if (position == 1 && TextUtils.equals("热门城市", mData.get(position).getSectionText()
        )) {
            return TYPE_HOT_LOCATION;
        } else {
            return TYPE_LOCATION;
        }
//            return super.getItemViewType(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }

    public class HotViewHolder extends MyViewHolder {
        @BindView(R.id.rv_recycler_view_hot)
        RecyclerView recyclerViewHot;

        public HotViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            recyclerViewHot.setLayoutManager(new GridLayoutManager(itemView.getContext(), 3,
                    LinearLayoutManager.VERTICAL, false));
            int pixelSize = itemView.getContext().getResources().getDimensionPixelSize(R
                    .dimen.margin_5);
            recyclerViewHot.addItemDecoration(new GridItemDecoration(3, pixelSize));

        }
    }

    public class CurrentViewHolder extends MyViewHolder {
        @BindView(R.id.tv_location_current)
        TextView tvLocationCurrent;

        public CurrentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class LocationViewHolder extends MyViewHolder {
        @BindView(R.id.tv_location)
        TextView tvLocation;

        public LocationViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    private OnLocationItemClickListener listener;

    public void setOnCurrentLocationClick(OnLocationItemClickListener l) {
        this.listener = l;
    }

    public void setOnHotLocationClick(OnLocationItemClickListener l) {
        this.listener = l;
    }

    public void setOnLocationClick(OnLocationItemClickListener l) {
        this.listener = l;
    }


}
