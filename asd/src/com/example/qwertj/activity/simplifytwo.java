package com.example.qwertj.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qwertj.R;
import com.example.qwertj.activity.GridViewAdapter.ViewHolder;

public class simplifytwo extends Activity implements OnClickListener {

	private Button ok;
	private List<Itembean> list = new ArrayList<Itembean>();
	private List<String> listsNo = new ArrayList<String>();
	private GridView gv_list;
	private TextView ecxeple;
	private ImageView imageview;
	private LinearLayout taocan, kexuanbao;
	private GridViewAdapter Gadapter;
	private String[] string = new String[] { "������ʾ", "�����շ�", "���ʳ�;", "��������",
			"����������ת��", "��æǰת", "��Ӧ��ǰת", "���ɽ�ǰת", "WCSMA(3G����)", "LTE(4G����)" };
	int e = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplify_one);
		setdatas();
		taocan = (LinearLayout) findViewById(R.id.taocan);
		kexuanbao = (LinearLayout) findViewById(R.id.kexuanbao);
		imageview = (ImageView) findViewById(R.id.imageview);
		ok = (Button) findViewById(R.id.ok);
		ok.setOnClickListener(this);
		gv_list = (GridView) findViewById(R.id.gv_list);
		gv_list.setColumnWidth(10);
		taocan.setVisibility(View.GONE);
		gv_list.setVerticalSpacing(15);
		Gadapter = new GridViewAdapter(this, list);
		gv_list.setAdapter(Gadapter);
		gv_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if (arg1.getTag() instanceof ViewHolder) {
					ViewHolder holder = (ViewHolder) arg1.getTag();
					// ���Զ�����CheckBox��checked�¼�
					holder.cbCheck.toggle();
				}
			}
		});
		kexuanbao.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (e == 0) {
					taocan.setVisibility(View.VISIBLE);
					imageview
							.setBackgroundResource(R.drawable.indicator_unexpanded);
					e = e + 1;
				} else {
					taocan.setVisibility(View.GONE);
					imageview
							.setBackgroundResource(R.drawable.indicator_expanded);
					e = e - 1;
				}

			}
		});
	}

	private void setdatas() {
		for (int i = 0; i < string.length; i++) {
			Itembean itembean = new Itembean(string[i], true);
			list.add(itembean);
		}
		// ģ�������
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ok:
			String datas = "";
			Map<Integer, Boolean> map = Gadapter.getCheckMap();
			// ���б���
			int j = 0;
			for (int i = 0; i < list.size(); i++) {
				if (map.get(i) != null && map.get(i)) {
					if (map.get(i)) {
						j += 1;

						Itembean itembean = list.get(i);
						datas += itembean.getTv() + ",";
					}
				}
			}
			if (j == 0) {
				Toast.makeText(this, "��ѡ��", 0).show();
				return;
			}

			Toast.makeText(this, datas.substring(0, datas.length() - 1), 0)
					.show();
			Log.d("tag",
					"����" + map.size() + datas.substring(0, datas.length() - 1));

			break;

		}
		Intent intent = new Intent(simplifytwo.this, readers.class);
		startActivity(intent);
	}
}
