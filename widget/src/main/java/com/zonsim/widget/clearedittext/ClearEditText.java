package com.zonsim.widget.clearedittext;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;

/**
 * 自带清空按钮的EditText
 * Created by tang-jw on 2017/7/4.
 */

public class ClearEditText extends AppCompatEditText implements
        View.OnFocusChangeListener, TextWatcher {
    
    private Drawable mClearDrawable;
    private boolean mHasFocus;
    
    public ClearEditText(Context context) {
        this(context, null);
        
    }
    
    public ClearEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
    }
    
    public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        
        init();
        
    }
    
    private void init() {
        
        mClearDrawable = getCompoundDrawables()[2];
        if (mClearDrawable == null) {
            mClearDrawable = getResources().getDrawable(android.R.drawable.ic_menu_close_clear_cancel);
        }

//        mClearDrawable.setBounds(0, 0, mClearDrawable.getIntrinsicWidth(), mClearDrawable.getIntrinsicHeight());
        
        
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }
    
    @Override
    public void setCompoundDrawablesWithIntrinsicBounds(@DrawableRes int left, @DrawableRes int top, @DrawableRes int right, @DrawableRes int bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        setCompoundDrawablesWithIntrinsicBounds(null, null,
                right != 0 ? getContext().getResources().getDrawable(right) : null, null);
        
    }
    
    public void setClearIconIsVisible(boolean isVisible) {
        setCompoundDrawablesWithIntrinsicBounds(null, null, isVisible ? mClearDrawable : null, null);
    }
    
    
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        
    }
    
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (mHasFocus) {
            setClearIconIsVisible(s.length() > 0);
        }
    }
    
    @Override
    public void afterTextChanged(Editable s) {
        
    }
    
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        mHasFocus = hasFocus;
        if (mHasFocus) {
            setClearIconIsVisible(getText().length() > 0);
        } else {
            setClearIconIsVisible(false);
        }
    }
    
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP && mClearDrawable != null) {
            boolean isTouchClearIcon = event.getX() > (getWidth() - getTotalPaddingRight())
                    && event.getX() < getWidth() - getPaddingRight();
            if (isTouchClearIcon) {
                setText(null);
                Animation animation = shakeAnimation(2);
                startAnimation(animation);
            }
            
        }
        
        return super.onTouchEvent(event);
    }
    
    
    /**
     * 晃动动画
     *
     * @param counts 1秒钟晃动多少下
     * @return
     */
    public Animation shakeAnimation(int counts) {
        Animation translateAnimation = new TranslateAnimation(0, 10, 0, 0);
        translateAnimation.setInterpolator(new CycleInterpolator(counts));
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }
}
