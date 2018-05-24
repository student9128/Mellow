package com.kevin.mellow.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.kevin.mellow.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/22.
 * <h3>
 * Describe:
 * <h3/>
 */
public class IndexBar extends View {
    private static final String[] INDEXES = {"定位", "热门", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
    private List<String> mIndexItems;
    private float mItemHeight;
    private int mTextSize;
    private int mTextColor;
    private int mTextSelectedColor;
    private int mCurrentIndex = -1;

    private Paint mPaint;
    private Paint mSelectedPaint;

    private int mWidth;
    private int mHeight;
    private float mMargin;

    private TextView mOverlayText;
    private String indexText;


    public IndexBar(Context context) {
        this(context,null);
    }

    public IndexBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public IndexBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attrs) {
        mIndexItems = new ArrayList<>();
        mIndexItems.addAll(Arrays.asList(INDEXES));
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.IndexBar);
        int textSize = context.getResources().getDimensionPixelSize(R.dimen.textSize14);
        mTextSize = ta.getDimensionPixelSize(R.styleable.IndexBar_indexTextSize, textSize);
        mTextColor = ta.getColor(R.styleable.IndexBar_indexTextColor, Color.GRAY);
        mTextSelectedColor = ta.getColor(R.styleable.IndexBar_indexSelectedTextColor, Color.BLACK);
        ta.recycle();

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(mTextSize);
        mPaint.setColor(mTextColor);

        mSelectedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mSelectedPaint.setTextSize(mTextSize);
        mSelectedPaint.setColor(mTextSelectedColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mIndexItems.size(); i++) {
            Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
            indexText = mIndexItems.get(i);
            canvas.drawText(indexText, (mWidth - mPaint.measureText(indexText))/2,
                    mItemHeight / 2 + (fontMetrics.bottom - fontMetrics.top) / 2 -
                            fontMetrics.bottom + mItemHeight * i + mMargin,
                    i == mCurrentIndex ? mSelectedPaint : mPaint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        mHeight = Math.max(h, oldh);
        mItemHeight = mHeight/mIndexItems.size();
        mMargin = (mHeight- mItemHeight*mIndexItems.size())/2;
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        performClick();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                float y = event.getY();
                int indexSize = mIndexItems.size();
                int selectedIndex = (int) (y / mItemHeight);
                if (selectedIndex < 0) {
                    selectedIndex = 0;
                } else if (selectedIndex>=indexSize){
                    selectedIndex = indexSize - 1;
                }
                if (listener != null && selectedIndex >= 0 && selectedIndex < indexSize) {
                    if (selectedIndex != mCurrentIndex) {
                        mCurrentIndex = selectedIndex;
                        if (mOverlayText != null) {
                            mOverlayText.setVisibility(VISIBLE);
                            mOverlayText.setText(mIndexItems.get(selectedIndex));
                        }
                        listener.onIndexChanged(mIndexItems.get(selectedIndex), selectedIndex);
                        invalidate();
                    }
                }

                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mCurrentIndex=-1;
                if (mOverlayText != null) {
                    mOverlayText.setVisibility(GONE);
                }
                invalidate();
                break;
        }
        return true;
    }

    private OnIndexChangedListener listener;
    public interface  OnIndexChangedListener{
        void onIndexChanged(String indexText, int position);
    }

    /**
     * 设置索引变化的监听事件
     * @param l
     * @return
     */
    public IndexBar setOnIndexChangedListener(OnIndexChangedListener l){
       this.listener = l;
       return this;
    }

    /**
     * 设置overlay text
     * @param overlayText
     * @return
     */
    public IndexBar setOverlayText(TextView overlayText) {
        this.mOverlayText = overlayText;
        return this;
    }
}