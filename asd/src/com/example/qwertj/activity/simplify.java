package com.example.qwertj.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.qwertj.R;

public class simplify extends Activity {

	private EditText phonenumber, simnumber;
	private Button queding, shifang;
	private ImageView imageveiw;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplify);
		shifang = (Button) findViewById(R.id.shifang);
		shifang.setVisibility(View.GONE);
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		phonenumber = (EditText) findViewById(R.id.phonenumber);
		phonenumber.setHint("�������ֻ�����");
		simnumber = (EditText) findViewById(R.id.simnumber);
		simnumber
				.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {
					@Override
					public void onFocusChange(View v, boolean hasFocus) {
						if (hasFocus) {
							// �˴�Ϊ�õ�����ʱ�Ĵ�������
							shifang.setVisibility(View.VISIBLE);
						} else {
							// �˴�Ϊʧȥ����ʱ�Ĵ�������
						}
					}
				});

		shifang.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "�ͷ�", 0).show();
				shifang.setVisibility(View.GONE);
			}
		});
	}

	public void queding(View v) {
		String phone = phonenumber.getText().toString().trim();
		String number = simnumber.getText().toString().trim();
		if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(number)) {
			Toast.makeText(this, "�û����������벻��Ϊ��", 0).show();
			return;
		}
		Intent intent = new Intent(simplify.this, simplifytwo.class);
		startActivity(intent);

	}

	@Override
	protected void onPause() {
		super.onPause();
		phonenumber.setText(null);
		simnumber.setText(null);
	}

}
