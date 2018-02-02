package com.kevin.mellow.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kevin.mellow.R;
import com.kevin.mellow.adapter.DouBanMoviePhotoAdapter;
import com.kevin.mellow.adapter.DouBanMovieReviewAdapter;
import com.kevin.mellow.base.BaseActivity;
import com.kevin.mellow.bean.DouBanMovieDetailBean;
import com.kevin.mellow.bean.DouBanMoviePhotoBean;
import com.kevin.mellow.bean.DouBanMovieReviewBean;
import com.kevin.mellow.contract.DouBanDetailContract;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.presenter.DouBanDetailPresenter;
import com.kevin.mellow.utils.StatusBarUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/6.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class DouBanMovieDetailActivity extends BaseActivity implements DouBanDetailContract.View {
    @BindView(R.id.iv_parallax)
    ImageView ivParallax;
    @BindView(R.id.collapse_tool_bar_layout)
    CollapsingToolbarLayout collapseToolBarLayout;
    @BindView(R.id.nested_scroll_view)
    NestedScrollView nestedScrollView;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_function)
    ImageView ivFunction;
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.tv_movie_title)
    TextView tvMovieTitle;
    @BindView(R.id.tv_rating_average)
    TextView tvRatingAverage;
    @BindView(R.id.rb_rating_bar)
    RatingBar rbRatingBar;
    @BindView(R.id.tv_rating_count)
    TextView tvRatingCount;
    @BindView(R.id.tv_year_genres)
    TextView tvYearGenres;
    @BindView(R.id.tv_original_title)
    TextView tvOriginalTitle;
    @BindView(R.id.tv_pubdates)
    TextView tvPubdates;
    @BindView(R.id.tv_durations)
    TextView tvDurations;
    @BindView(R.id.relationship)
    LinearLayout relationship;
    @BindView(R.id.panel)
    RelativeLayout panel;
    @BindView(R.id.panel_lyt)
    RelativeLayout panelLyt;
    @BindView(R.id.iv_movie_avatar)
    ImageView ivMovieAvatar;
    @BindView(R.id.tv_summary)
    TextView tvSummary;
    @BindView(R.id.rv_recycler_view_photos)
    RecyclerView rvRecyclerViewPhotos;
    @BindView(R.id.rv_recycler_view_reviews)
    RecyclerView rvRecyclerViewReviews;
    private int mOffset = 0;
    private int mScrollY = 0;
    private DouBanDetailContract.Presenter mPresenter;
    private DouBanMoviePhotoAdapter moviePhotoAdapter;
    private DouBanMovieReviewAdapter movieReviewAdapter;
    private List<DouBanMoviePhotoBean.SubjectBean.CastsBean> castsData = new ArrayList<>();
    private List<DouBanMoviePhotoBean.SubjectBean.DirectorsBean> directorsData = new ArrayList<>();
    private List<DouBanMovieReviewBean.ReviewsBean> reviewsData = new ArrayList<>();

    @Override
    public int setLayoutResId() {
        return R.layout.activity_dou_ban_movie_detail;
    }

    @Override
    public void initView() {
        mPresenter = new DouBanDetailPresenter(this, RequestDataSource.getInstance());
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String title = intent.getStringExtra("title");
//        tvTitle.setText(title);
//        tvTitle.setText(title);
        actionBar.setTitle(title);
//        smartRefresh.setOnMultiPurposeListener(new SimpleMultiPurposeListener() {
//            @Override
//            public void onHeaderPulling(RefreshHeader header, float percent, int offset, int headerHeight, int extendHeight) {
////                mOffset = offset / 2;
////                ivParallax.setTranslationY(mOffset - mScrollY);
////                toolBar.setAlpha(1 - Math.min(percent, 1));
//            }
//
//            @Override
//            public void onHeaderReleasing(RefreshHeader header, float percent, int offset, int footerHeight, int extendHeight) {
////                mOffset = offset / 2;
////                ivParallax.setTranslationY(mOffset - mScrollY);
////                toolBar.setAlpha(1 - Math.min(percent, 1));
//            }
//        });
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            int lastScrollY = 0;
            int h = DensityUtil.dp2px(170);
            int color = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary) & 0x00ffffff;

            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (lastScrollY < h) {
                    scrollY = Math.min(h, scrollY);
                    mScrollY = scrollY > h ? h : scrollY;
//                    buttonBar.setAlpha(1f * mScrollY / h);
                    toolBar.setBackgroundColor(((255 * mScrollY / h) << 24) | color);
                    ivParallax.setTranslationY(mOffset - mScrollY);
                }
                lastScrollY = scrollY;
            }
        });
        toolBar.setBackgroundColor(0);
        //状态栏透明和间距处理
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, toolBar);
        ivParallax.setBackgroundColor(generateColor());


        mPresenter.requestData("上海", id);
        mPresenter.requestDataPhotos("上海", id);
        mPresenter.requestDataReviews("上海", id);
        rvRecyclerViewPhotos.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rvRecyclerViewReviews.setLayoutManager(new LinearLayoutManager(this));
        moviePhotoAdapter = new DouBanMoviePhotoAdapter(this, castsData, directorsData);
        movieReviewAdapter = new DouBanMovieReviewAdapter(this, reviewsData);
        rvRecyclerViewPhotos.setAdapter(moviePhotoAdapter);
        rvRecyclerViewReviews.setAdapter(movieReviewAdapter);
        rvRecyclerViewPhotos.setNestedScrollingEnabled(false);
        rvRecyclerViewReviews.setNestedScrollingEnabled(false);
        rvRecyclerViewPhotos.setOverScrollMode(View.OVER_SCROLL_NEVER);
        rvRecyclerViewReviews.setOverScrollMode(View.OVER_SCROLL_NEVER);
    }


    @Override
    public void setPresenter(DouBanDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(int resId) {
        showToast(getString(resId));
    }

    @Override
    public void showTips(String msg) {
        showToast(msg);
    }

    @Override
    public void showData(DouBanMovieDetailBean douBanMovieDetailBean) {
        tvMovieTitle.setText(douBanMovieDetailBean.getTitle());
        double average = douBanMovieDetailBean.getRating().getAverage();
        tvRatingAverage.setText(String.valueOf(average));
        rbRatingBar.setRating((float) (average / 2));
        tvRatingCount.setText(String.valueOf((int) douBanMovieDetailBean.getRatings_count()) + "人");
        String year = douBanMovieDetailBean.getYear();
        String x = year + "/";
        List<String> genres = douBanMovieDetailBean.getGenres();
        for (int i = 0; i < genres.size(); i++) {
            if (i == genres.size() - 1) {
                x += genres.get(i);
            } else {
                x += genres.get(i) + "/";
            }
        }
        tvYearGenres.setText(x);
        tvOriginalTitle.setText("原名：" + douBanMovieDetailBean.getOriginal_title());
        tvPubdates.setText("上映时间：" + douBanMovieDetailBean.getPubdates().get(0));
        tvDurations.setText("片长：" + douBanMovieDetailBean.getDurations().get(0));
        tvSummary.setText(douBanMovieDetailBean.getSummary());
        Glide.with(this)
                .load(douBanMovieDetailBean.getImages().getLarge())
                .apply(new RequestOptions().placeholder(R.drawable.ic_mellow_place_holder))
                .apply(new RequestOptions().centerCrop())
                .into(ivMovieAvatar);

    }

    @Override
    public void showPhotos(DouBanMoviePhotoBean douBanMoviePhotoBean) {
        DouBanMoviePhotoBean.SubjectBean subjectBean = douBanMoviePhotoBean.getSubject();
        List<DouBanMoviePhotoBean.SubjectBean.CastsBean> casts = subjectBean.getCasts();
        List<DouBanMoviePhotoBean.SubjectBean.DirectorsBean> directors = subjectBean.getDirectors();
        moviePhotoAdapter.showAvatar(casts, directors);
    }

    @Override
    public void showReviews(DouBanMovieReviewBean douBanMovieReviewBean) {
        List<DouBanMovieReviewBean.ReviewsBean> reviews = douBanMovieReviewBean.getReviews();
        movieReviewAdapter.showReviewsData(reviews);
    }

    private int generateColor() {
        Random random = new Random();
//        r = Integer.toHexString(random.nextInt(256)).toUpperCase();
//        g = Integer.toHexString(random.nextInt(256)).toUpperCase();
//        b = Integer.toHexString(random.nextInt(256)).toUpperCase();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        int color = Color.rgb(r, g, b);
        return color;
    }
}
