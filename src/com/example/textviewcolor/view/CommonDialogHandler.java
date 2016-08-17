package com.example.textviewcolor.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.TextView;

import com.example.textviewcolor.R;
import com.example.textviewcolor.view.CommonDialog.CallBackListener;

/**
 * Created by wangly on 2016/7/22.
 */
public class CommonDialogHandler extends Handler implements CallBackListener,DialogShowContent{
	public static final int SHOW_PROGRESS_MESSAGE = 1;
	public static final int DISMISS_PROGRESS_MESSAGE = 2;
	private ResultCallBack back;
	private CommonDialog dialog;

	private Context context;
	private boolean cancelable;

	public CommonDialogHandler(Context context,boolean cancelable) {
		super();
		this.context = context;
		this.cancelable = cancelable;
	}
	public void setResultCallBack(ResultCallBack listener){
		this.back = listener;
	}

	private void initProgressDialog(){
		if (dialog == null) {
			dialog = new CommonDialog(context);
			dialog.setHintTitle(hintInof);
			dialog.setListener(this);
			dialog.setCancelable(cancelable);
			setTextViewColor(contentText, colorText,dialog.tv_result_hint);
			if (cancelable) {
				dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
					@Override
					public void onCancel(DialogInterface dialogInterface) {
						Log.d("wangly", "测试······");
						dismissProgressDialog();

					}
				});
			}

			if (!dialog.isShowing()) {
				dialog.show();
			}
		}
	}

	private void dismissProgressDialog(){
		if (dialog != null) {
			dialog.dismiss();
			dialog = null;
		}
	}

	@Override
	public void handleMessage(Message msg) {
		switch (msg.what) {
		case SHOW_PROGRESS_MESSAGE:
			initProgressDialog();
			break;
		case DISMISS_PROGRESS_MESSAGE:
			dismissProgressDialog();
			break;
		}
	}

	@Override
	public void onClickCallBack() {
		Log.d("wangly", "马上体验！！！");
		if (back != null) {
			back.onClickOk();
		}

	}

	public interface ResultCallBack{
		void onClickOk();
	}

	private void setTextViewColor(String contentText,String colorText,TextView tv_info){
		int fstart=contentText.indexOf(colorText);
		int fend=fstart+colorText.length();
		SpannableStringBuilder style=new SpannableStringBuilder(contentText); 
		style.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.guide_theme_color)),fstart,fend,Spannable.SPAN_EXCLUSIVE_INCLUSIVE); 
		tv_info.setText(style);
	}
	
	
	private String hintInof;
	private String contentText;
	private String colorText;
	@Override
	public void setHintTitle(String text) {
		this.hintInof = text;
	}
	@Override
	public void setContentText(String text) {
		this.contentText = text;
	}
	@Override
	public void setColorText(String text) {
		this.colorText = text;
	}

}
