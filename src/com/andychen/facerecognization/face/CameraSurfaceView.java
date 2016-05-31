package com.andychen.facerecognization.face;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.hardware.Camera.CameraInfo;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraSurfaceView extends SurfaceView implements
		SurfaceHolder.Callback {
	private Context mContext;
	private SurfaceHolder mHolder;
	// Camera nv21格式预览帧的尺寸，默认设置640*480
	private int PREVIEW_WIDTH = 640;
	private int PREVIEW_HEIGHT = 480;
	// 缩放矩阵
	private Matrix mScaleMatrix = new Matrix();

	public CameraSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
		mHolder = getHolder();
		mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		mHolder.setFormat(PixelFormat.TRANSLUCENT);// translucent半透明
													// transparent透明
		mHolder.addCallback(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		CameraInterface.getInstance().doOpenCamera(holder,
				CameraInfo.CAMERA_FACING_FRONT);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

		mScaleMatrix.setScale(width / (float) PREVIEW_HEIGHT, height
				/ (float) PREVIEW_WIDTH);

		CameraInterface.getInstance().doStartPreview(mHolder, 1.333f);

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		CameraInterface.getInstance().doDestroyCamera();
	}

	public SurfaceHolder getSurfaceHolder() {
		return mHolder;
	}

	/**
	 * 获取矩阵缩放实例
	 * 
	 * @return
	 */
	public Matrix getMatrixInstance() {
		return mScaleMatrix;
	}

}
