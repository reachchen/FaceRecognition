package com.andychen.facerecognization.face;

import android.graphics.Point;

public class FaceMouth {

	private static FaceMouth faceInfo;
	private Point mouth_left_corner;
	private Point mouth_lower_lip_bottom;
	private Point mouth_middle;
	private Point mouth_right_corner;
	private Point mouth_upper_lip_top;
	
	public FaceMouth() {
	}

	public synchronized static FaceMouth getInstance(){
		if (faceInfo == null) {
			faceInfo = new FaceMouth();
		}
		return faceInfo;
	}

	public Point getMouth_left_corner() {
		return mouth_left_corner;
	}

	public void setMouth_left_corner(Point mouth_left_corner) {
		this.mouth_left_corner = mouth_left_corner;
	}

	public Point getMouth_lower_lip_bottom() {
		return mouth_lower_lip_bottom;
	}

	public void setMouth_lower_lip_bottom(Point mouth_lower_lip_bottom2) {
		this.mouth_lower_lip_bottom = mouth_lower_lip_bottom2;
	}

	public Point getMouth_middle() {
		return mouth_middle;
	}

	public void setMouth_middle(Point mouth_middle) {
		this.mouth_middle = mouth_middle;
	}

	public Point getMouth_right_corner() {
		return mouth_right_corner;
	}

	public void setMouth_right_corner(Point mouth_right_corner) {
		this.mouth_right_corner = mouth_right_corner;
	}

	public Point getMouth_upper_lip_top() {
		return mouth_upper_lip_top;
	}

	public void setMouth_upper_lip_top(Point mouth_upper_lip_top) {
		this.mouth_upper_lip_top = mouth_upper_lip_top;
	}
	
}
