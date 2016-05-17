package com.example.qwertj.activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.example.qwertj.R;

public class GridViewAdapter extends BaseAdapter {

	private android.widget.AbsListView.LayoutParams layoutParams;
	private List<Itembean> lists;

	private Context context = null;
	/**
	 * CheckBox 是否选择的存储集合,key 是 position , value 是该position是否选中
	 */
	private Map<Integer, Boolean> isCheckMap = new HashMap<Integer, Boolean>();

	public GridViewAdapter(Context context, List<Itembean> list) {
		this.context = context;
		this.lists = list;
		// 初始化,默认都没有选中
		configCheckMap(false);
		DisplayMetrics dm = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay()
				.getMetrics(dm);
		layoutParams = new GridView.LayoutParams(dm.widthPixels / 3,
				dm.widthPixels / 7);
	}

	/**
	 * 首先,默认情况下,所有项目都是没有选中的.这里进行初始化
	 */
	public void configCheckMap(boolean bool) {

		for (int i = 0; i < lists.size(); i++) {
			isCheckMap.put(i, bool);
		}

	}

	@Override
	public int getCount() {
		return lists == null ? 0 : lists.size();
	}

	@Override
	public Object getItem(int position) {
		return lists.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.item, null);
			convertView.setLayoutParams(layoutParams);
		}
		/*
		 * 获得该item 是否允许删除
		 */
		Itembean item = lists.get(position);
		boolean canRemove = item.isCanRemove();

		CheckBox cbCheck = (CheckBox) convertView.findViewById(R.id.tv_ss1);
		cbCheck.setText(item.getTv());
		cbCheck.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {

				/*
				 * 将选择项加载到map里面寄存
				 */
				isCheckMap.put(position, isChecked);
			}
		});
		if (!canRemove) {
			cbCheck.setChecked(false);
		} else {
			if (isCheckMap.get(position) == null) {
				isCheckMap.put(position, false);
			}

			cbCheck.setChecked(isCheckMap.get(position));

			ViewHolder holder = new ViewHolder();

			holder.cbCheck = cbCheck;

			/**
			 * 将数据保存到tag
			 */
			convertView.setTag(holder);
		}
		return convertView;
	}

	/**
	 * 增加一项的时候
	 */
	public void add(Itembean bean) {
		this.lists.add(0, bean);

		// 让所有项目都为不选择
		configCheckMap(false);
	}

	// 移除一个项目的时候
	public void remove(int position) {
		this.lists.remove(position);
	}

	public Map<Integer, Boolean> getCheckMap() {
		return this.isCheckMap;
	}

	public static class ViewHolder {

		public CheckBox cbCheck = null;
		public TextView title = null;
		public Object data = null;

	}

	public List<Itembean> getDatas() {
		return lists;
	}

}
