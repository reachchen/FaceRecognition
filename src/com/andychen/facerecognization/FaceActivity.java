package com.andychen.facerecognization;

import com.andychen.facerecognization.fragmnet.FaceFragment;
import com.andychen.facerecognization.view.ShowToast;

import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class FaceActivity extends FragmentActivity implements OnClickListener {
	/**
	 * actionbar
	 */
	TextView tv_title;
	ImageView img_left;
	View actionBar;
	FaceFragment mFaceFragment;
	@Override
	protected void onCreate(Bundle arg0) {
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(arg0);
		setContentView(R.layout.activity_parent);
		initActionbar();
		mFaceFragment = new FaceFragment();
		getSupportFragmentManager().beginTransaction()
				.add(R.id.layout_parent_fragmenthost, mFaceFragment)
				.commitAllowingStateLoss();
	}
	private void initActionbar() {
		actionBar = findViewById(R.id.include_actionbar);
		actionBar.setVisibility(View.VISIBLE);
		tv_title = (TextView) actionBar.findViewById(R.id.tv_action_title);
		img_left = (ImageView) actionBar.findViewById(R.id.img_action_left);
		img_left.setVisibility(View.VISIBLE);
		img_left.setOnClickListener(this);
		initTilte();

	}

	private void initTilte() {
		tv_title.setText("人脸识别");

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.img_action_left:
			finish();
			ShowToast.showToast(this, "已取消");
			overridePendingTransition(R.anim.slide_in_right,
					R.anim.slide_out_right);
			break;
		}

	}
}
