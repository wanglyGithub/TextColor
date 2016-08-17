package com.example.textviewcolor;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv_info;
	private EditText et_phone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();


		et_phone = (EditText) findViewById(R.id.et_phone);
		Button start = (Button) findViewById(R.id.start);


	}

	private void initView() {

		String reusltString = "初始密码为【20957】";

		int result = reusltString.indexOf("【")+1;
		System.out.println("总长度 "+reusltString.length() +"---得到的长度值："+result);
		String teString = reusltString.substring(result,reusltString.length()-1);
		System.out.println("得到的字符串  "+teString);



		tv_info = (TextView) findViewById(R.id.tv_info);
		tv_info.setText(setTextViewColor(reusltString,teString));
	}

	private SpannableStringBuilder setTextViewColor(String contentText,String colorText){
		int fstart=contentText.indexOf(colorText);
		int fend=fstart+colorText.length();
		SpannableStringBuilder style=new SpannableStringBuilder(contentText); 
		style.setSpan(new ForegroundColorSpan(Color.RED),fstart,fend,Spannable.SPAN_EXCLUSIVE_INCLUSIVE); 
		return style;
	}


}
