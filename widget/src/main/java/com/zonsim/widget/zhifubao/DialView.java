package com.zonsim.widget.zhifubao;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 支付宝芝麻信用(350~950)
 * Created by tang-jw on 2017/7/5.
 */

public class DialView extends View {
    
    /**
     * 默认宽高（正方形）
     */
    private int defaultSize;
    
    /**
     * 画笔有宽度，距离边界要有一定的距离
     */
    private int defaultPadding = 20;
    
    
    /**
     * 外圆矩形
     */
    private RectF mOuterRect;
    private RectF mInnerRect;
    private int radius;
    private Paint mOuterArcPaint;
    private Paint mInnerArcPaint;
    private Paint mSmallScalePaint;
    private Paint mBigSaclePaint;
    private Paint mInnerBigScalePaint;
    private float mStartAngle = 165f;
    private float mSweepAngle = 210f;
    /**
     * 圆环间距
     */
    private int arcDistance;
    
    
    public DialView(Context context) {
        this(context, null);
    }
    
    public DialView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    public DialView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    
    
    private void init() {
        //默认宽高
        defaultSize = dp2px(250);
        arcDistance = dp2px(14);
        
        //外层圆环画笔
        mOuterArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mOuterArcPaint.setStrokeWidth(8f);
        mOuterArcPaint.setColor(Color.BLUE);
        mOuterArcPaint.setStyle(Paint.Style.STROKE);
        mOuterArcPaint.setAlpha(80);
        
        mInnerArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mInnerArcPaint.setStrokeWidth(24f);
        mInnerArcPaint.setColor(Color.RED);
        mInnerArcPaint.setStyle(Paint.Style.STROKE);
//        mInnerArcPaint.setAlpha(80);
        
        
        //圆环小刻度画笔
        mSmallScalePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mSmallScalePaint.setStrokeWidth(dp2px(1));
        mSmallScalePaint.setStyle(Paint.Style.STROKE);
        mSmallScalePaint.setColor(Color.WHITE);
        
        //圆环大刻度画笔
        mBigSaclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBigSaclePaint.setTextSize(30);
        mBigSaclePaint.setColor(Color.WHITE);
        
        
        mInnerBigScalePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        
        mInnerBigScalePaint.setStrokeWidth(dp2px(3));
        mInnerBigScalePaint.setStyle(Paint.Style.STROKE);
        mInnerBigScalePaint.setColor(Color.WHITE);
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        
        setMeasuredDimension(getReSize(widthMeasureSpec, defaultSize),
                getReSize(heightMeasureSpec, defaultSize));
    }
    
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        radius = (w - 50) / 2;
        //外圆弧的区域，坐标减去defaultPadding
        mOuterRect = new RectF(defaultPadding, defaultPadding, w - defaultPadding, h - defaultPadding);
        int delta = defaultPadding + arcDistance;
        mInnerRect = new RectF(delta, delta, w - delta, w - delta);
    }
    
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        System.out.println("onLayout => " + "changed:" + changed + ",left:" + left + ",top:" + top + ",right:" + right + ",bottom:" + bottom);
    }
    
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawOuterCircle(canvas);
        drawInnerCircle(canvas);
        
        drawSmallScale(canvas);
        drawInnerBigScale(canvas);
        
        drawInnerNum(canvas);
    }
    
    private void drawInnerNum(Canvas canvas) {
        canvas.save();
        
        canvas.rotate(0, radius, radius);
        
        int start = (int) (48 - mInnerArcPaint.getStrokeWidth() + 32);
        int end = (int) (start + mInnerArcPaint.getStrokeWidth() + 12);
        
        for (int i = 0; i < 12; i++) {
            
            // 测量文本的长度
            String text;
            if (i == 0) {
                text = "12";
            } else {
                text = "" + i;
            }
            float textLen = mBigSaclePaint.measureText(text);
            
            canvas.drawText(text, radius - textLen / 2, end + 40, mBigSaclePaint);
            
            canvas.rotate(30, radius, radius);
        }
        
        canvas.restore();
        
        
    }
    
    private void drawInnerBigScale(Canvas canvas) {
        canvas.save();
        
        canvas.rotate(0, radius, radius);
        
        int start = (int) (48 - mInnerBigScalePaint.getStrokeWidth() + 12);
        int end = (int) (start + mInnerBigScalePaint.getStrokeWidth() + 12);
        
        for (int i = 0; i < 12; i++) {
            
            canvas.drawLine(radius, start, radius, end, mInnerBigScalePaint);
            canvas.rotate(30, radius, radius);
        }
        
        canvas.restore();
    }
    
    /**
     * 绘制内圆刻度
     *
     * @param canvas
     */
    private void drawSmallScale(Canvas canvas) {
        
        canvas.save();
        
        canvas.rotate(0, radius, radius);
        
        int start = (int) (48 - mInnerArcPaint.getStrokeWidth() + 12);
        int end = (int) (start + mInnerArcPaint.getStrokeWidth());
        
        for (int i = 0; i < 60; i++) {
            
            canvas.drawLine(radius, start, radius, end, mSmallScalePaint);
            canvas.rotate(6, radius, radius);
        }
        
        canvas.restore();
        
    }
    
    
    private int getReSize(int measureSpec, int defaultSize) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        
        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
                result = defaultSize;
                break;
            case MeasureSpec.AT_MOST:
                result = Math.min(specSize, defaultSize);
                break;
            case MeasureSpec.EXACTLY:
                System.out.println("EXACTLY");
                result = specSize;
                break;
            default:
                result = defaultSize;
                break;
        }
        return result;
    }
    
    
    /**
     * 绘制外层圆
     *
     * @param canvas
     */
    private void drawOuterCircle(Canvas canvas) {
        canvas.drawArc(mOuterRect, mStartAngle, mSweepAngle, false, mOuterArcPaint);
    }
    
    private void drawInnerCircle(Canvas canvas) {
        canvas.drawArc(mInnerRect, mStartAngle, mSweepAngle, false, mInnerArcPaint);
    }
    
    
    /**
     * dp2px
     */
    private int dp2px(int values) {
        
        float density = getResources().getDisplayMetrics().density;
        return (int) (values * density + 0.5f);
    }
    
    
    /**
     * 获取当前时间
     */
    private String getCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd", Locale.CANADA);
        return format.format(new Date());
    }
}
