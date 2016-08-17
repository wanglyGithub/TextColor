package com.wangly.itcast.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.textviewcolor.R;
import com.wangly.itcast.view.CommonDialogHandler;
import com.wangly.itcast.view.CommonDialogHandler.ResultCallBack;

public class MainActivity extends Activity implements ResultCallBack {

	private CommonDialogHandler dialogHandler; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


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



	@Override
	public void onClickOk() {
		dismissProgressDialog();
	}


}
