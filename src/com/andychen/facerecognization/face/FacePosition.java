package com.andychen.facerecognization.face;

public class FacePosition {

	private int bottom,left,right,top;
	public static FacePosition facePosition;
	
	public FacePosition(){
	}
	public static synchronized FacePosition getInstance(){
		if (facePosition ==null) {
			facePosition = new FacePosition();
		}
		return facePosition;
	}
	
	public int getBottom() {
		return bottom;
	}

	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}
	
}
