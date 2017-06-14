package com.bc.mcapp.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * Created by admins on 2016/10/18.
 */
public class CustomHrzScrollView extends HorizontalScrollView {


    public CustomHrzScrollView(Context context) {
        super(context);
    }

    public CustomHrzScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomHrzScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        // TODO Auto-generated method stub
        super.onScrollChanged(l, t, oldl, oldt);
    }

    

}
