package com.example.textviewcolor.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.textviewcolor.R;

/**
 * 统一样式的Dialog
 * 
 * @author wangly
 * 
 */
public class CommonDialog extends Dialog implements
android.view.View.OnClickListener {

	private TextView tv_titile_hint;
	public TextView tv_result_hint;
	private TextView tv_start;

	private CallBackListener listener;

	public void setListener(CallBackListener listener) {
		this.listener = listener;
	}

	public CommonDialog(Context context) {
		super(context, R.style.commonDialog_style);
		intView();
	}

	private void intView() {
		setContentView(R.layout.common_theme_dialog);

		tv_titile_hint = (TextView) findViewById(R.id.tv_titile_hint);
		tv_result_hint = (TextView) findViewById(R.id.tv_result_hint);

		tv_start = (TextView) findViewById(R.id.tv_start);
		tv_start.setOnClickListener(this);

	}

	/**
	 * 设置提示的标题
	 * 
	 * @param title
	 */
	public void setHintTitle(String title) {
		tv_titile_hint.setText(title);
	}

	/**
	 * 设置提示结果
	 * 
	 * @param result
	 */
	public void setHintResult(String result) {
		tv_result_hint.setText(result);
	}

	public void setStartHintTitle(String title) {
		tv_start.setText(title);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_start:
			if (listener != null) {
				listener.onClickCallBack();
			}
			break;
		default:
			break;
		}
	}

	public interface CallBackListener {

		void onClickCallBack();

	}
}
