package com.example.test;

import java.math.BigDecimal;
import java.text.NumberFormat;

import com.example.test.ScaleMarkView.OnValueChangedListener;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class NewRuleMarkActivity extends Activity {
	private NumberFormat mNumberFormat = NumberFormat.getInstance();
	 TextView shown;
	  ScaleMarkView scaleMark;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.dialog_health_target);
		mNumberFormat.setMinimumFractionDigits(0);
		mNumberFormat.setMaximumFractionDigits(2);
		 shown = (TextView) 
				findViewById(R.id.choose_value);
		 scaleMark = (ScaleMarkView) 
				findViewById(R.id.scale_mark);
//		scaleMark.setPreMarkValue(1f);
//		scaleMark.setDefaultValue(60);
//		scaleMark.setMinValue(0);
//		scaleMark.setMaxValue(500);
//		scaleMark.setPerScaleMark(2);
		scaleMark.setOnValueChangedListener(new OnValueChangedListener() {

			@Override
			public void onValueChanged(ScaleMarkView view, BigDecimal oldValue,
					BigDecimal newValue) {
				shown.setText(formatWeight(newValue));

			}
		});
	}

	private Dialog newTargetDialog() {
		final Dialog dialog = new Dialog(NewRuleMarkActivity.this,
				R.style.FullScreenDialog);
		initDialogWindows(dialog.getWindow());
		dialog.setContentView(R.layout.dialog_health_target);
		

	
		return dialog;
	}

	private CharSequence formatWeight(Object weigth) {
		return String.format("%skg", mNumberFormat.format(weigth));
	}

	private void initDialogWindows(Window window) {
		WindowManager.LayoutParams lp = window.getAttributes();
		lp.gravity = Gravity.BOTTOM;
		lp.width = WindowManager.LayoutParams.MATCH_PARENT;
		lp.height = ConvertUtils.dp2Px(getResources(), 294);
		lp.windowAnimations = R.style.Animations_Bottom_to_top;
		window.setAttributes(lp);
	}
}
