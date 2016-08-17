package com.example.textviewcolor;

import com.example.textviewcolor.view.CommonDialogHandler;
import com.example.textviewcolor.view.CommonDialogHandler.ResultCallBack;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements ResultCallBack {

	private TextView tv_info;
	private EditText et_phone;
	private CommonDialogHandler dialogHandler; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

		String reusltString = "初始密码为【20958】";

		int result = reusltString.indexOf("【")+1;
		System.out.println("总长度 "+reusltString.length() +"---得到的长度值："+result);
		String teString = reusltString.substring(result,reusltString.length()-1);
		System.out.println("得到的字符串  "+teString);


		dialogHandler = new CommonDialogHandler(this, true);
		dialogHandler.setResultCallBack(this);
		dialogHandler.setHintTitle("注册成功");
		dialogHandler.setContentText(reusltString);
		dialogHandler.setColorText(teString);
		et_phone = (EditText) findViewById(R.id.et_phone);
		Button start = (Button) findViewById(R.id.start);
		start.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				showProgressDialog();
			}
		});

	}

	private void showProgressDialog(){
		if (dialogHandler != null) {
			dialogHandler.obtainMessage(CommonDialogHandler.SHOW_PROGRESS_MESSAGE).sendToTarget();
		}
	}

	private void dismissProgressDialog(){
		if (dialogHandler != null) {
			dialogHandler.obtainMessage(CommonDialogHandler.DISMISS_PROGRESS_MESSAGE).sendToTarget();
			dialogHandler = null;
		}
	}

	private void initView() {

		tv_info = (TextView) findViewById(R.id.tv_info);
	}


	@Override
	public void onClickOk() {
		dismissProgressDialog();
	}


}
