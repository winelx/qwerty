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
	 * CheckBox �Ƿ�ѡ��Ĵ洢����,key �� position , value �Ǹ�position�Ƿ�ѡ��
	 */
	private Map<Integer, Boolean> isCheckMap = new HashMap<Integer, Boolean>();

	public GridViewAdapter(Context context, List<Itembean> list) {
		this.context = context;
		this.lists = list;
		// ��ʼ��,Ĭ�϶�û��ѡ��
		configCheckMap(false);
		DisplayMetrics dm = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay()
				.getMetrics(dm);
		layoutParams = new GridView.LayoutParams(dm.widthPixels / 3,
				dm.widthPixels / 7);
	}

	/**
	 * ����,Ĭ�������,������Ŀ����û��ѡ�е�.������г�ʼ��
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
		 * ��ø�item �Ƿ�����ɾ��
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
				 * ��ѡ������ص�map����Ĵ�
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
			 * �����ݱ��浽tag
			 */
			convertView.setTag(holder);
		}
		return convertView;
	}

	/**
	 * ����һ���ʱ��
	 */
	public void add(Itembean bean) {
		this.lists.add(0, bean);

		// ��������Ŀ��Ϊ��ѡ��
		configCheckMap(false);
	}

	// �Ƴ�һ����Ŀ��ʱ��
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
