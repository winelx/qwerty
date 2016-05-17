package com.example.qwertj.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qwertj.R;
import com.example.qwertj.R.id;

public class producty extends Activity {
	private Button choose, confirm, next, cardString;
	private LinearLayout xuanxiang;
	private TextView one, two, three, four;
	private LinearLayout kexuanbao, dingdan, ciyueliuliang, ciyuetaocan;
	private ImageView imageview, prioduct;
	private EditText ediotext, resource;
	int a, e, b = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.product);
		cardString = (Button) findViewById(R.id.cardString);

		dingdan = (LinearLayout) findViewById(R.id.dingdan);// ��д����
		ciyueliuliang = (LinearLayout) findViewById(R.id.ciyueliuliang);// ��������
		ciyuetaocan = (LinearLayout) findViewById(R.id.ciyuetaocan);// �����ײ�
		confirm = (Button) findViewById(R.id.confirm);// ȷ��
		choose = (Button) findViewById(R.id.choose);// ȥѡ��
		next = (Button) findViewById(R.id.next);// ��һ��
		kexuanbao = (LinearLayout) findViewById(R.id.kexuanbao);// ��ѡ���ײ�
		imageview = (ImageView) findViewById(R.id.imageview);// ͼƬ
		prioduct = (ImageView) findViewById(R.id.prioduct);
		xuanxiang = (LinearLayout) findViewById(R.id.xuanxiang);// ѡ��
		ciyuetaocan.setVisibility(View.GONE);
		cardString.setVisibility(View.GONE);
		dingdan.setVisibility(View.GONE);
		confirm.setVisibility(View.GONE);
		xuanxiang.setVisibility(View.GONE);
		resource = (EditText) findViewById(R.id.resource);
		ediotext = (EditText) findViewById(R.id.ediotext);

		/**
		 * ȥѡ��
		 */
		choose.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(producty.this, productyone.class);
				startActivity(intent);
			}
		});
		/**
		 * ��һ��
		 */
		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// �ſ���ʳ������֤
				String edio = resource.getText().toString().trim();
				String erios = ediotext.getText().toString().trim();
				// if (cardString.getVisibility() == View.VISIBLE
				// || TextUtils.isEmpty(edio) || TextUtils.isEmpty(erios)) {
				// Toast.makeText(producty.this, "�ף��㻹ûѡ�����ء�", 0).show();

				// } else {
				dingdan.setVisibility(View.VISIBLE);
				ciyueliuliang.setVisibility(View.VISIBLE);
				next.setVisibility(View.GONE);
				confirm.setVisibility(View.VISIBLE);

				// }

			}
		});

		ciyueliuliang.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (a == 0) {
					ciyuetaocan.setVisibility(View.VISIBLE);
					prioduct.setBackgroundResource(R.drawable.indicator_unexpanded);
					a = a + 1;
				} else {
					ciyuetaocan.setVisibility(View.GONE);
					prioduct.setBackgroundResource(R.drawable.indicator_expanded);
					a = a - 1;
				}

			}
		});
		kexuanbao.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (e == 0) {
					xuanxiang.setVisibility(View.VISIBLE);
					imageview
							.setBackgroundResource(R.drawable.indicator_unexpanded);
					e = e + 1;
				} else {
					xuanxiang.setVisibility(View.GONE);
					imageview
							.setBackgroundResource(R.drawable.indicator_expanded);
					e = e - 1;
				}

			}
		});

	}
}
