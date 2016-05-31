package com.andychen.facerecognization.face;

import android.graphics.Point;

public class FaceEyebrow {

	private Point right_eyebrow_left_corner, right_eyebrow_middle,
			right_eyebrow_right_corner, left_eyebrow_left_corner,
			left_eyebrow_middle, left_eyebrow_right_corner;
	
	private static FaceEyebrow faceEyebrow;
	
	public static synchronized FaceEyebrow getInstance(){
		if (faceEyebrow ==null) {
			faceEyebrow = new FaceEyebrow();
		}
		return faceEyebrow;
	}

	public Point getRight_eyebrow_left_corner() {
		return right_eyebrow_left_corner;
	}

	public void setRight_eyebrow_left_corner(Point right_eyebrow_left_corner) {
		this.right_eyebrow_left_corner = right_eyebrow_left_corner;
	}

	public Point getRight_eyebrow_middle() {
		return right_eyebrow_middle;
	}

	public void setRight_eyebrow_middle(Point right_eyebrow_middle) {
		this.right_eyebrow_middle = right_eyebrow_middle;
	}

	public Point getRight_eyebrow_right_corner() {
		return right_eyebrow_right_corner;
	}

	public void setRight_eyebrow_right_corner(Point right_eyebrow_right_corner) {
		this.right_eyebrow_right_corner = right_eyebrow_right_corner;
	}

	public Point getLeft_eyebrow_left_corner() {
		return left_eyebrow_left_corner;
	}

	public void setLeft_eyebrow_left_corner(Point left_eyebrow_left_corner) {
		this.left_eyebrow_left_corner = left_eyebrow_left_corner;
	}

	public Point getLeft_eyebrow_middle() {
		return left_eyebrow_middle;
	}

	public void setLeft_eyebrow_middle(Point left_eyebrow_middle) {
		this.left_eyebrow_middle = left_eyebrow_middle;
	}

	public Point getLeft_eyebrow_right_corner() {
		return left_eyebrow_right_corner;
	}

	public void setLeft_eyebrow_right_corner(Point left_eyebrow_right_corner) {
		this.left_eyebrow_right_corner = left_eyebrow_right_corner;
	}

}
