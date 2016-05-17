package com.example.qwertj.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import java.util.Map;

import com.example.qwertj.R;

public class productyone extends Activity {
	static String bntID;
	static int i;
	public static String[] info;
	static int provincePosition = 3;
	RadioButton btn1, btn2, btn3, btn4, btn5, btn6;
	View.OnClickListener btnListener1 = new View.OnClickListener() {
		public void onClick(View paramView) {
			switch (paramView.getId()) {
			case 2131361814:
			default:
				return;
			case R.id.bnA:
				productyone.this.grp2.clearCheck();
				productyone.this.playnumber.setVisibility(0);
				productyone.this.resource.setVisibility(8);
				productyone.this.lastnumber.setVisibility(8);
				productyone.this.choose.setText("随机选号");
				productyone.i = 1;
				return;
			case R.id.bnB:
				productyone.this.grp2.clearCheck();
				productyone.this.playnumber.setVisibility(0);
				productyone.this.resource.setVisibility(0);
				productyone.this.lastnumber.setVisibility(0);
				productyone.this.lastnumber.setHint("号码后四位");
				productyone.this.resource.setHint("号码后前七位");
				productyone.this.choose.setText("号码头+号码尾");
				productyone.this.choose.setText("查询");
				productyone.i = 2;
				return;
			case R.id.bnC:
				productyone.this.grp2.clearCheck();
				productyone.this.playnumber.setVisibility(0);
				productyone.this.resource.setVisibility(8);
				productyone.this.lastnumber.setVisibility(0);
				productyone.this.lastnumber.setHint("输入号码后四位");
				productyone.this.lastnumber.setHint("号码尾");
				productyone.this.choose.setText("查询");
				productyone.i = 3;
				return;
			case R.id.bnD:
				productyone.this.grp1.clearCheck();
				productyone.this.playnumber.setVisibility(0);
				productyone.this.resource.setVisibility(8);
				productyone.this.lastnumber.setVisibility(0);
				productyone.this.lastnumber.setHint("输入手机号码");
				productyone.this.choose.setText("查询");
				productyone.i = 4;
				return;
			case R.id.bnE:
				productyone.this.grp1.clearCheck();
				productyone.this.playnumber.setVisibility(0);
				productyone.this.resource.setVisibility(8);
				productyone.this.lastnumber.setVisibility(0);
				productyone.this.lastnumber.setHint("号码头");
				productyone.this.lastnumber.setHint("输入号码前七位");
				productyone.this.choose.setText("查询");
				productyone.i = 5;
			}
		}
	};
	private Button choose;
	RadioGroup grp1;
	RadioGroup grp2;
	private EditText lastnumber;
	private MyListView listview;
	private List<Map<String, Object>> mData;
	private LinearLayout playnumber;
	ArrayAdapter<String> provAdapter = null;
	private String[] province = { "   普通选号", "   靓号选号", "  专属选号" };
	ArrayAdapter<String> provinceAdapter;
	private Spinner provinceSpinner;
	private Spinner provinces;
	private EditText resource;
	String strBtnSelected = "unInit";
	private TextView telephone;
	private String[] zhuangt = { "   移动", "  联通", "  电信" };

	static {
		int i = 1;
		info = new String[] { "17055100520", "17055100521", "17055100522",
				"17055100523", "17055100524", "17055100525", "17055100528",
				"17055100526", "17055100527", "17055100527" };
	}

	private void init() {
		this.btn1 = ((RadioButton) findViewById(R.id.bnA));
		this.btn2 = ((RadioButton) findViewById(R.id.bnB));
		this.btn3 = ((RadioButton) findViewById(R.id.bnC));
		this.btn4 = ((RadioButton) findViewById(R.id.bnD));
		this.btn5 = ((RadioButton) findViewById(R.id.bnE));
		this.grp1 = ((RadioGroup) findViewById(R.id.radiogrp1));
		this.grp2 = ((RadioGroup) findViewById(R.id.radiogrp2));
		this.btn1.setOnClickListener(this.btnListener1);
		this.btn2.setOnClickListener(this.btnListener1);
		this.btn3.setOnClickListener(this.btnListener1);
		this.btn4.setOnClickListener(this.btnListener1);
		this.btn5.setOnClickListener(this.btnListener1);
		this.btn1.setChecked(true);
	}

	private void setSpinner() {
		this.provinceSpinner = ((Spinner) findViewById(R.id.provinces));
		this.provinceAdapter = new ArrayAdapter(this, 2130903050, this.province);
		this.provinceSpinner.setAdapter(this.provinceAdapter);
		this.provinceSpinner.setSelection(0, true);
		this.provAdapter = new ArrayAdapter(this, 2130903050, this.zhuangt);
		this.provinces.setAdapter(this.provAdapter);
		this.provinces.setSelection(0, true);
	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.product_one);
		this.provinces = ((Spinner) findViewById(R.id.spin_province));
		this.playnumber = ((LinearLayout) findViewById(R.id.playnumber));
		this.listview = ((MyListView) findViewById(R.id.listview));
		this.playnumber.setVisibility(View.GONE);
		this.resource = ((EditText) findViewById(R.id.resource));
		this.lastnumber = ((EditText) findViewById(R.id.resources));
		this.choose = ((Button) findViewById(R.id.choose));
		this.telephone = ((TextView) findViewById(R.id.telephone));
		init();
		setSpinner();
		choose.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				switch (productyone.i) {
				default:
					return;
				case 1:
					Toast.makeText(productyone.this.getApplicationContext(),
							"随机选号", 0).show();
					return;
				case 2:
					Toast.makeText(productyone.this.getApplicationContext(),
							"号码头+号码尾", 0).show();
					return;
				case 3:
					Toast.makeText(productyone.this.getApplicationContext(),
							"号码尾", 0).show();
					return;
				case 4:
					Toast.makeText(productyone.this.getApplicationContext(),
							"指定号码", 0).show();
					return;
				case 5:
				}
				Toast.makeText(productyone.this.getApplicationContext(), "号码头",
						0).show();
			}
		});
	}
}
