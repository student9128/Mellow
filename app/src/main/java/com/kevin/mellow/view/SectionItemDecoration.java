package com.kevin.mellow.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.kevin.mellow.R;
import com.kevin.mellow.database.CityDataEntity;
import com.kevin.mellow.utils.DisplayUtils;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/23.
 * <h3>
 * Describe:
 * <h3/>
 */
public class SectionItemDecoration extends RecyclerView.ItemDecoration {
    private List<CityDataEntity> mData;
    private Paint mPaint;
    private TextPaint mTextPaint;
    private Rect mBounds;
    private int mSectionHeight;
    private int mSectionColor;
    private int mTextColor;
    private int mTextSize;

    private static final String TAG = "Section11111.class";

    public SectionItemDecoration(Context context, List<CityDataEntity> data, @Nullable
            AttributeSet attrs) {
        this.mData = data;
        TypedValue typedValue = new TypedValue();
//        Resources.Theme theme = context.getTheme();
//        Resources resources = context.getResources();
//        theme.resolveAttribute(R.attr.sectionColor, typedValue, true);
//        theme.resolveAttribute(R.attr.sectionHeight, typedValue, true);
//        theme.resolveAttribute(R.attr.sectionTextSize, typedValue, true);
//        theme.resolveAttribute(R.attr.sectionTextColor, typedValue, true);
//        mSectionColor = resources.getColor(typedValue.resourceId);
//        mSectionHeight = context.getResources().getDimensionPixelSize(typedValue.resourceId);
//        mTextColor = context.getResources().getColor(typedValue.resourceId);
//        mTextSize = context.getResources().getDimensionPixelSize(typedValue.resourceId);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable
                .SectionItemDecoration);
        int textSize = context.getResources().getDimensionPixelSize(R.dimen.textSize16);
        int sectionHeight = context.getResources().getDimensionPixelSize(R.dimen.margin_35);
        mSectionColor = ta.getColor(R.styleable.SectionItemDecoration_sectionColor, ContextCompat
                .getColor(context, R.color.gray_2));
        mSectionHeight = ta.getDimensionPixelSize(R.styleable
                .SectionItemDecoration_sectionHeight, sectionHeight);
        mTextSize = ta.getDimensionPixelSize(R.styleable.SectionItemDecoration_sectionTextSize,
                textSize);
        mTextColor = ta.getColor(R.styleable.SectionItemDecoration_sectionTextColor, Color.WHITE);


        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mSectionColor);

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setColor(mTextColor);

        mBounds = new Rect();
    }

    public void setData(List<CityDataEntity> data) {
        this.mData = data;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int lef = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            Log.d(TAG, "onDraw:=====chlde " + child.getPaddingLeft());
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            int position = layoutParams.getViewLayoutPosition();
            if (mData != null && !mData.isEmpty() && position < mData.size() - 1 && position > -1) {
                if (position == 0) {
                    drawSection(c, lef, right, child, layoutParams, position);
                } else {
                    String sectionText = mData.get(position).getSectionText();
                    if (null != sectionText && !sectionText.equals(mData.get(position - 1)
                            .getSectionText())) {
                        drawSection(c, lef, right, child, layoutParams, position);
                    }
                }
            }
        }
    }

    private void drawSection(Canvas c, int left, int right, View child,
                             RecyclerView.LayoutParams params, int position) {
        c.drawRect(left, child.getTop() - params.topMargin - mSectionHeight, right,
                child.getTop() - params.topMargin, mPaint);
        String sectionText = mData.get(position).getSectionText();
        mTextPaint.getTextBounds(sectionText, 0, sectionText.length(), mBounds);
        Log.i("Section====", child.getPaddingLeft() + "");
        c.drawText(sectionText, child.getPaddingLeft(), child.getTop() - params.topMargin
                - (mSectionHeight / 2 - mBounds.height() / 2), mTextPaint);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
//        super.onDrawOver(c, parent, state);
        int position = ((LinearLayoutManager) parent.getLayoutManager())
                .findFirstVisibleItemPosition();
        if (position < 0) {
            return;
        }
        if (mData == null || mData.isEmpty()) return;
        String sectionText = mData.get(position).getSectionText();
        View child = parent.findViewHolderForLayoutPosition(position).itemView;
        boolean flag = false;
        if ((position + 1) < mData.size()) {
            if (null != sectionText && !sectionText.equals(mData.get(position + 1).getSectionText
                    ())) {
                if (child.getHeight() + child.getTop() < mSectionHeight) {
                    c.save();
                    flag = true;
                    c.translate(0, child.getHeight() + child.getTop() - mSectionHeight);
                }
            }
        }
        c.drawRect(parent.getPaddingLeft(), parent.getPaddingTop(), parent.getRight() - parent
                .getPaddingRight(), parent.getPaddingTop() + mSectionHeight, mPaint);
        mTextPaint.getTextBounds(sectionText, 0, sectionText.length(), mBounds);
        Log.i("Section==2==", child.getPaddingLeft() + "");
        c.drawText(sectionText,
                child.getPaddingLeft(),
                parent.getPaddingTop() + mSectionHeight - (mSectionHeight / 2 - mBounds.height()
                        / 2),
                mTextPaint);
        if (flag)
            c.restore();
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State
            state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        if (mData != null && !mData.isEmpty() && position <= mData.size() - 1 && position > -1) {
            if (position == 0) {
                outRect.set(0, mSectionHeight, 0, 0);
            } else {
                if (null != mData.get(position).getSectionText()
                        && !mData.get(position).getSectionText().equals(mData.get(position - 1)
                        .getSectionText())) {
                    outRect.set(0, mSectionHeight, 0, 0);
                }
            }
        }
    }
}


