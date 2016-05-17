package com.example.qwertj.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class MyListView extends ListView {
	public MyListView(Context paramContext) {
		super(paramContext);
	}

	public MyListView(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
	}

	public MyListView(Context paramContext, AttributeSet paramAttributeSet,
			int paramInt) {
		super(paramContext, paramAttributeSet, paramInt);
	}

	protected void onMeasure(int paramInt1, int paramInt2) {
		super.onMeasure(paramInt1,
				View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2));
	}
}