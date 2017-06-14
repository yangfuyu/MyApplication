package com.bc.mcapp.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class CustomGridView1 extends GridView {



	public CustomGridView1(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public CustomGridView1(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CustomGridView1(Context context) {
		super(context);
	}
	
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,  
                MeasureSpec.AT_MOST);  
			super.onMeasure(widthMeasureSpec, expandSpec);
	}
	
	
	
}
