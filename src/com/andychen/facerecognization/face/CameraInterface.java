package com.andychen.facerecognization.face;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.andychen.facerecognization.listener.TakePictureListener;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.view.SurfaceHolder;

/**
 * 设置相机
 * 
 * @author Administrator
 * 
 */
public class CameraInterface {

	private Camera mCamera;
	private static CameraInterface cameraInter;

	private boolean isPreview = false;
	private Parameters mParams;
	// Camera nv21格式预览帧的尺寸，默认设置640*480
	private int PREVIEW_WIDTH = 640;
	private int PREVIEW_HEIGHT = 480;
	// 预览帧数据存储数组和缓存数组
	private byte[] nv21;
	private byte[] buffer;

	private CameraInterface() {
		nv21 = new byte[PREVIEW_WIDTH * PREVIEW_HEIGHT * 2];
		buffer = new byte[PREVIEW_WIDTH * PREVIEW_HEIGHT * 2];
	}

	public interface CameraOpenCallback {
		public void cameraHasOpen();
	}

	public CameraInterface(Camera camera) {

		this.mCamera = camera;
	}

	public static synchronized CameraInterface getInstance() {
		if (cameraInter == null) {
			cameraInter = new CameraInterface();
		}
		return cameraInter;
	}

	/**
	 * 打开相机 一直开启前置摄像头
	 * 
	 * @param callback
	 */
	@SuppressWarnings("deprecation")
	public void doOpenCamera(SurfaceHolder holder, int cameraId) {
		if (null != mCamera) {
			return;
		}
		try {
			mCamera = Camera.open(cameraId);
		} catch (Exception e) {
			doDestroyCamera();
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void doStartPreview(SurfaceHolder holder, float previewRate) {

		if (isPreview) {
			mCamera.stopPreview();
			return;
		}

		if (mCamera != null) {
			mParams = mCamera.getParameters();
			mParams.setPictureFormat(PixelFormat.JPEG);// 设置拍照后存储的图片格式
			// 设置PreviewSize和PictureSize
			mParams.setPreviewFormat(ImageFormat.NV21);
			mParams.setPreviewSize(PREVIEW_WIDTH, PREVIEW_HEIGHT);
			mCamera.setParameters(mParams);
			mCamera.setDisplayOrientation(90);
			List<String> focusModes = mParams.getSupportedFocusModes();
			if (focusModes.contains("continuous-video")) {
				mParams.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
			}
			mCamera.setPreviewCallback(new PreviewCallback() {
				@Override
				public void onPreviewFrame(byte[] data, Camera camera) {
					System.arraycopy(data, 0, nv21, 0, data.length);
					if (takePictureFlag == 1) {
						Bitmap mBitmap = null;
						Camera.Parameters parameters = camera.getParameters();
						int format = parameters.getPreviewFormat();
						if (format == PixelFormat.YCbCr_420_SP
								|| format == PixelFormat.YCbCr_422_I) {
							int w = parameters.getPreviewSize().width;
							int h = parameters.getPreviewSize().height;
							int[] i = new int[data.length];
							decodeYUV420SP(i, data, w, h);
							mBitmap = Bitmap.createBitmap(i, w, h,
									Bitmap.Config.RGB_565);
						} else if (format == PixelFormat.JPEG
								|| format == PixelFormat.RGB_565) {
							mBitmap = BitmapFactory.decodeByteArray(data, 0,
									data.length);
						}
						if (null != mBitmap) {
							if (takePictureFlag == 1) {
								takePictureFlag++;
							} else {
								return;
							}
							// 设置FOCUS_MODE_CONTINUOUS_VIDEO)之后，myParam.set("rotation",
							// 90)失效。
							// 图片竟然不能旋转了，故这里要旋转下
							Bitmap rotateImage = FaceUtil.rotateImage(270,
									mBitmap);

							if (mListener != null) {
								mListener.onTakePictuerResult(rotateImage);
							}
						}
					}
				}
			});

			try {
				mCamera.setPreviewDisplay(holder);
				mCamera.startPreview();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			isPreview = true;
		}

	}

	@SuppressWarnings("deprecation")
	public void doDestroyCamera() {
		if (mCamera != null) {
			mCamera.setPreviewCallback(null);
			mCamera.stopPreview();
			isPreview = false;
			
			mCamera.release();
			mCamera = null;
		}
	}

	int takePictureFlag = 0;

	/**
	 * 拍照
	 */
	@SuppressWarnings("deprecation")
	public void doTakePicture() {

		if (isPreview && (mCamera != null)) {
			takePictureFlag = 1;

		}
	}

	public void decodeYUV420SP(int[] rgb, byte[] yuv420sp, int width, int height) {
		final int frameSize = width * height;
		for (int j = 0, yp = 0; j < height; j++) {
			int uvp = frameSize + (j >> 1) * width, u = 0, v = 0;
			for (int i = 0; i < width; i++, yp++) {
				int y = (0xff & ((int) yuv420sp[yp])) - 16;
				if (y < 0)
					y = 0;
				if ((i & 1) == 0) {
					v = (0xff & yuv420sp[uvp++]) - 128;
					u = (0xff & yuv420sp[uvp++]) - 128;
				}
				int y1192 = 1192 * y;
				int r = (y1192 + 1634 * v);
				int g = (y1192 - 833 * v - 400 * u);
				int b = (y1192 + 2066 * u);
				if (r < 0)
					r = 0;
				else if (r > 262143)
					r = 262143;
				if (g < 0)
					g = 0;
				else if (g > 262143)
					g = 262143;
				if (b < 0)
					b = 0;
				else if (b > 262143)
					b = 262143;
				rgb[yp] = 0xff000000 | ((r << 6) & 0xff0000)
						| ((g >> 2) & 0xff00) | ((b >> 10) & 0xff);
			}
		}
	}

	/**
	 * 获取相机实例
	 * 
	 * @return
	 */
	public Camera getCameraInstance() {
		return mCamera;
	}

	/**
	 * 提供预览帧数据组和缓存数据
	 * 
	 * @return
	 */
	public List<Object> getPreviewDate() {

		List<Object> list = new ArrayList<Object>();
		list.add(buffer);
		list.add(nv21);
		return list;
	}

	private TakePictureListener mListener;

	public void setOnTakePictureListener(TakePictureListener mListener) {
		this.mListener = mListener;
	}

}
