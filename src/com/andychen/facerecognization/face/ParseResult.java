package com.andychen.facerecognization.face;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.graphics.Point;
import android.text.TextUtils;

public class ParseResult {
	/**
	 * 离线人脸框结果解析方法
	 * @param json
	 * @return
	 */
	static public FaceRect[] parseResult(String json) {
		FaceRect[] rect = null;
		if (TextUtils.isEmpty(json)) {
			return null;
		}
		try {
			JSONTokener tokener = new JSONTokener(json);
			JSONObject joResult = new JSONObject(tokener);
			// 获取每个人脸的结果
			JSONArray items = joResult.getJSONArray("face");
			// 获取人脸数目
			rect = new FaceRect[items.length()];
			for (int i = 0; i < items.length(); i++) {

				JSONObject position = items.getJSONObject(i).getJSONObject(
						"position");
				// 提取关键点数据
				rect[i] = new FaceRect();
				rect[i].bound.left = position.getInt("left");
				rect[i].bound.top = position.getInt("top");
				rect[i].bound.right = position.getInt("right");
				rect[i].bound.bottom = position.getInt("bottom");
				FacePosition.getInstance().setBottom(rect[i].bound.bottom);
				FacePosition.getInstance().setLeft(rect[i].bound.left);
				FacePosition.getInstance().setRight(rect[i].bound.right);
				FacePosition.getInstance().setTop(rect[i].bound.top);

				try {
					JSONObject landmark = items.getJSONObject(i).getJSONObject(
							"landmark");
					int keyPoint = landmark.length();
					rect[i].point = new Point[keyPoint];
					Iterator it = landmark.keys();
					int point = 0;
					while (it.hasNext() && point < keyPoint) {
						String key = (String) it.next();
						if (key.equals("mouth_lower_lip_bottom")) {
							FaceMouth.getInstance().setMouth_lower_lip_bottom(
									new Point(landmark.getJSONObject(key)
											.getInt("x"), landmark
											.getJSONObject(key).getInt("y")));
						} else if (key.equals("mouth_upper_lip_top")) {
							FaceMouth.getInstance().setMouth_upper_lip_top(
									new Point(landmark.getJSONObject(key)
											.getInt("x"), landmark
											.getJSONObject(key).getInt("y")));
						} else if (key.equals("right_eyebrow_middle")) {
							FaceEyebrow.getInstance().setRight_eyebrow_middle(
									new Point(landmark.getJSONObject(key)
											.getInt("x"), landmark
											.getJSONObject(key).getInt("y")));
						} else if (key.equals("left_eyebrow_middle")) {
							FaceEyebrow.getInstance().setLeft_eyebrow_middle(
									new Point(landmark.getJSONObject(key)
											.getInt("x"), landmark
											.getJSONObject(key).getInt("y")));
						}

						JSONObject postion = landmark.getJSONObject(key);
						rect[i].point[point] = new Point(postion.getInt("x"),
								postion.getInt("y"));
						point++;
					}
				} catch (JSONException e) {
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rect;
	}
}