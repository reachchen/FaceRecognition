package com.andychen.facerecognization.face;

import android.graphics.Point;

public class FaceNose {

	 private Point nose_bottom,nose_left,nose_right,nose_top;
	
	 private static FaceNose faceNose;
	 
	 public FaceNose(){}
	 
	 public static synchronized FaceNose getInstace(){
		 if (faceNose == null) {
			faceNose = new FaceNose();
		}
		return faceNose;
	 }

	public Point getNose_bottom() {
		return nose_bottom;
	}

	public void setNose_bottom(Point nose_bottom) {
		this.nose_bottom = nose_bottom;
	}

	public Point getNose_left() {
		return nose_left;
	}

	public void setNose_left(Point nose_left) {
		this.nose_left = nose_left;
	}

	public Point getNose_right() {
		return nose_right;
	}

	public void setNose_right(Point nose_right) {
		this.nose_right = nose_right;
	}

	public Point getNose_top() {
		return nose_top;
	}

	public void setNose_top(Point nose_top) {
		this.nose_top = nose_top;
	}


	
}
