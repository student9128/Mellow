package com.kevin.mellow.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.listener.CommonViewListener;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/6/5.
 * <h3>
 * Describe:
 * <h3/>
 */
public abstract class CommonBaseFragment extends Fragment implements View.OnClickListener {

    enum ViewType {
        /**
         * 显示内容
         */
        TYPE_CONTENT,
        /**
         * 显示进度圈
         */
        TYPE_PROGRESS,
        /**
         * 没有数据
         */
        TYPE_EMPTY,
        /**
         * 网络异常
         */
        TYPE_NET_ERROR
    }

    private ViewType mCurrentViewType = ViewType.TYPE_CONTENT;
    private String mEmptyMsg = "No Data";
    private int mEmptyIcon = R.drawable.ic_empty;

    /**
     * 进度
     */
    private View mProgressContainer,
    /**
     * 内容
     */
    mContentContainer,
    /**
     * 内容视图
     */
    mContentView,
    /**
     * 空视图
     */
    mEmptyView,
    /**
     * 网络异常视图
     */
    mNetErrorView;

    /**
     * 临时保存创建的内容，在onViewCreated之后设置进去
     */
    private View mTempView;

    private ViewStub mProgressStub,
            mEmptyStub,
            mNetErrorStub;
    /**
     * 视图是否已经创建完成
     */
    private boolean isViewCreated = false;

    private CommonViewListener mEmptyListener,
            mNetErrorListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //填充需要的界面
        mTempView = inflater.inflate(getContentLayoutResId(), null, false);

        return inflater.inflate(R.layout.fragment_common_base, container, false);
    }

    public abstract int getContentLayoutResId();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        initAllView();
        setContentView(mTempView);
        if (mCurrentViewType != ViewType.TYPE_CONTENT) {//如果当前显示不是正常内容，则显示相对应类型的内容
            switchView(getCurrentView(), mContentView, false);
        }

    }

    @Override
    public void onDestroyView() {
        mProgressContainer = mContentContainer = mContentView = mEmptyView = mNetErrorView = null;
        mProgressStub = mEmptyStub = mNetErrorStub = null;
        super.onDestroyView();
        isViewCreated = false;
    }

    private void switchView(View showView, View hideView, boolean showAnimate) {
        if (showAnimate) {
            showView.startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim
                    .fade_in));
            hideView.startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim
                    .fade_out));
        } else {
            showView.clearAnimation();
            hideView.clearAnimation();
        }
        showView.setVisibility(View.VISIBLE);
        hideView.setVisibility(View.GONE);
    }

    private void initAllView() {
        if (mContentContainer != null) return;
        View rootView = getView();
        if (rootView == null) {
            throw new IllegalStateException("Content mTempView not yet created");
        }

        mContentContainer = rootView.findViewById(R.id.fl_content_container);
        if (mContentContainer == null) {
            throw new RuntimeException("Your content must have a ViewGroup whose id attribute is " +
                    "'R.id.fl_content_container'");
        }
        //显示进度
        mProgressStub = rootView.findViewById(R.id.vs_progress);
        if (mProgressStub == null) {
            throw new RuntimeException("Your content must have a ViewStub whose id attribute is " +
                    "'R.id.vs_progress'");
        }
        //显示无数据
        mEmptyStub = rootView.findViewById(R.id.vs_empty);
        if (mEmptyStub == null) {
            throw new RuntimeException("Your content must have a ViewStub whose id attribute is " +
                    "'R.id.vs_empty'");
        }
        //显示网络异常
        mNetErrorStub = rootView.findViewById(R.id.vs_net_error);
        if (mNetErrorStub == null) {
            throw new RuntimeException("Your content must have a ViewStub whose id attribute is " +
                    "'R.id.vs_net_error'");
        }
        TextView tvNoData = rootView.findViewById(R.id.tv_no_data);
        TextView tvNetError = rootView.findViewById(R.id.tv_network_error);
        tvNoData.setOnClickListener(this);
        tvNetError.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_no_data:
                if (mEmptyListener != null) {
                    mEmptyListener.onEmptyClick();
                }
                break;
            case R.id.tv_network_error:
                if (mNetErrorListener != null) {
                    mNetErrorListener.onNetErrorClick();
                }
                break;
            default:
                break;
        }
    }

    public void setContentView(@LayoutRes int layoutResId) {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View contentView = layoutInflater.inflate(layoutResId, null);
        setContentView(contentView);
    }

    public void setContentView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("Content mTempView can't be null");
        }
        if (mContentContainer instanceof ViewGroup) {
            ViewGroup contentContainer = (ViewGroup) mContentContainer;
            if (mContentView == null) {
                contentContainer.addView(view);
            } else {
                int index = contentContainer.indexOfChild(mContentView);
                contentContainer.removeView(mContentView);
                contentContainer.addView(view, index);
            }
            mContentView = view;//mContentView为界面正常显示的内容
        } else {
            throw new IllegalStateException("Can't be used with a custom content mTempView");
        }

    }

    private View getCurrentView() {
        View view = null;
        switch (mCurrentViewType) {
            case TYPE_EMPTY:
                view = getEmptyView();
                break;
            case TYPE_CONTENT:
                view = mContentView;
                break;
            case TYPE_PROGRESS:
                view = getProgressView();
                break;
            case TYPE_NET_ERROR:
                view = getNetErrorView();
                break;
        }
        return view;
    }

    private View getProgressView() {
        if (mProgressContainer == null) {
            mProgressContainer = mProgressStub.inflate();
        }
        return mProgressContainer;
    }

    private View getNetErrorView() {
        if (mNetErrorView == null) {
            mNetErrorView = mNetErrorStub.inflate();
        }
        return mNetErrorView;
    }

    private View getEmptyView() {
        if (mEmptyView == null) {
            mEmptyView = mEmptyStub.inflate();
        }
        return mEmptyView;
    }

    /**
     * 在界面上显示进度
     */
    public void showProgress() {
        if (mCurrentViewType == ViewType.TYPE_PROGRESS) return;
        if (isViewCreated) {
            View hideView = getCurrentView();
            View progressView = getProgressView();
            switchView(progressView, hideView, false);
        }
        mCurrentViewType = ViewType.TYPE_PROGRESS;

    }

    /**
     * 在界面上显示内容
     */
    public void showContent() {
        if (mCurrentViewType == ViewType.TYPE_CONTENT) return;
        if (isViewCreated) {
            View hideView = getCurrentView();
            View showView = mContentView;
            switchView(showView, hideView, false);
        }
        mCurrentViewType = ViewType.TYPE_CONTENT;
    }

    public void showNetError() {
        if (mCurrentViewType == ViewType.TYPE_NET_ERROR) return;
        if (isViewCreated) {
            View hideView = getCurrentView();
            View showView = getNetErrorView();
            switchView(showView, hideView, false);
        }
        mCurrentViewType = ViewType.TYPE_NET_ERROR;
    }

    public void showEmpty() {
        if (mCurrentViewType == ViewType.TYPE_EMPTY) return;
        if (isViewCreated) {
            View hideView = getCurrentView();
            View showView = getEmptyView();
            switchView(showView, hideView, false);
        }
        mCurrentViewType = ViewType.TYPE_EMPTY;
    }

    /**
     * 当无数据的时候，点击进行刷新尝试
     * @param l
     */
    public void setOnEmptyClicker(CommonViewListener l) {
        this.mEmptyListener = l;
    }

    /**
     * 当网络异常的时候，点击进行尝试
     * @param l
     */
    public void setOnNetErrorClicker(CommonViewListener l) {
        this.mNetErrorListener = l;
    }

}

