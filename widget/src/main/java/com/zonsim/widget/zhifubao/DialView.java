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
 * ^-^
 * Created by tang-jw on 2017/7/5.
 */

public class DialView extends View {
    
    /**
     * 默认宽高（正方形）
     */
    private int defaultSize;
    
    /**
     * 外圆矩形
     */
    private RectF mOuterRect;
    private RectF mInnerRect;
    private int radius;
    private Paint mOuterPaint;
    private Paint mInnerPaint;
    private Paint mInnerScalePaint;
    private Paint mInnerNumPaint;
    private Paint mInnerBigScalPaint;
    
    
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
        //外层圆环画笔
        mOuterPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mOuterPaint.setStrokeWidth(8f);
        mOuterPaint.setColor(Color.RED);
        mOuterPaint.setStyle(Paint.Style.STROKE);
//        mOuterPaint.setAlpha(80);
        
        mInnerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mInnerPaint.setStrokeWidth(24f);
        mInnerPaint.setColor(Color.RED);
        mInnerPaint.setStyle(Paint.Style.STROKE);
//        mInnerPaint.setAlpha(80);
        
        
        //圆环小刻度画笔
        mInnerScalePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mInnerScalePaint.setStrokeWidth(dp2px(1));
        mInnerScalePaint.setStyle(Paint.Style.STROKE);
        mInnerScalePaint.setColor(Color.WHITE);
        //圆环小刻度画笔
        mInnerNumPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mInnerNumPaint.setTextSize(30);
        mInnerNumPaint.setColor(Color.WHITE);
    
    
    
        mInnerBigScalPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
       
        mInnerBigScalPaint.setStrokeWidth(dp2px(3));
        mInnerBigScalPaint.setStyle(Paint.Style.STROKE);
        mInnerBigScalPaint.setColor(Color.WHITE);
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        System.out.println("onMeasure => " + "w: " + widthMeasureSpec + " , h: " + heightMeasureSpec);
        
        System.out.println("onMeasure getSuggested => "
                + "width: " + getSuggestedMinimumWidth()
                + " , height: " + getSuggestedMinimumHeight());
        
        System.out.println("onMeasure ReSize => " + "width: " + getReSize(getSuggestedMinimumWidth(), defaultSize)
                + " , height: " + getReSize(getSuggestedMinimumHeight(), defaultSize));
        
        setMeasuredDimension(getReSize(widthMeasureSpec, defaultSize),
                getReSize(heightMeasureSpec, defaultSize));
    }
    
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        System.out.println("onSizeChanged => " + "w:" + w + ",h:" + h + ",oldw:" + oldw + ",oldh:" + oldh);
        radius = w / 2;
        mOuterRect = new RectF(4, 4, w - 4, h - 4);
        mInnerRect = new RectF(48, 48, w - 48, h - 48);
    }
    
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        System.out.println("onLayout => " + "changed:" + changed + ",left:" + left + ",top:" + top + ",right:" + right + ",bottom:" + bottom);
    }
    
    
    @Override
    protected void onDraw(Canvas canvas) {
        System.out.println("onDraw");
        drawOuterCircle(canvas);
        drawInnerCircle(canvas);
        
        drawInnerScale(canvas);
        drawInnerBigScale(canvas);
        
        drawInnerNum(canvas);
    }
    
    private void drawInnerNum(Canvas canvas) {
        canvas.save();
        
        canvas.rotate(0, radius, radius);
        
        int start = (int) (48 - mInnerPaint.getStrokeWidth() + 32);
        int end = (int) (start + mInnerPaint.getStrokeWidth() + 12);
        
        for (int i = 0; i < 12; i++) {
            
            // 测量文本的长度
            String text;
            if (i == 0) {
                text = "12";
            } else {
                text = "" + i;
            }
            float textLen = mInnerNumPaint.measureText(text);
            
            canvas.drawText(text, radius - textLen/2, end + 40, mInnerNumPaint);
            
            canvas.rotate(30, radius, radius);
        }
        
        canvas.restore();
        
        
    }
    
    private void drawInnerBigScale(Canvas canvas) {
        canvas.save();
        
        canvas.rotate(0, radius, radius);
        
        int start = (int) (48 - mInnerBigScalPaint.getStrokeWidth() + 12);
        int end = (int) (start + mInnerBigScalPaint.getStrokeWidth() + 12);
        
        for (int i = 0; i < 12; i++) {
            
            canvas.drawLine(radius, start, radius, end, mInnerBigScalPaint);
            canvas.rotate(30, radius, radius);
        }
        
        canvas.restore();
    }
    
    /**
     * 绘制内圆刻度
     *
     * @param canvas
     */
    private void drawInnerScale(Canvas canvas) {
        
        canvas.save();
        
        canvas.rotate(0, radius, radius);
        
        int start = (int) (48 - mInnerPaint.getStrokeWidth() + 12);
        int end = (int) (start + mInnerPaint.getStrokeWidth());
        
        for (int i = 0; i < 60; i++) {
            
            canvas.drawLine(radius, start, radius, end, mInnerScalePaint);
            canvas.rotate(6, radius, radius);
        }
        
        canvas.restore();
        
    }
    
    private void drawInnerCircle(Canvas canvas) {
        canvas.drawArc(mInnerRect, 0f, 360f, false, mInnerPaint);
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
        canvas.drawArc(mOuterRect, 0f, 360f, false, mOuterPaint);
        
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
