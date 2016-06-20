package com.andychen.facerecognization.intent;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Locale;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.params.CoreConnectionPNames;

import android.os.AsyncTask;
import android.os.Message;

/**
 * httpsclent 联网方法
 * 
 * @author paytend_liu
 * 
 */
public class HttpsClient {
	/**
	 * 联网的方法 
	 * 调用异步任务
	 * 
	 * @param url
	 *            联网的连接
	 * @param listener
	 *            监听器
	 * @param type联网的标识符
	 */
	public static void httpsGet(String url, HttpsListener listener, int type) {
		new HttpsAsyncTask(listener, type).execute(url);
	}

	/**
	 * 
	 * 联网的方法
	 * @param path
	 *            联网地址
	 * @return 接收返回的消息
	 * @throws Exception
	 */
	private static String sendHttpsClientPOSTRequest(String path)
			throws Exception {
		String encoding = "UTF-8";
		HttpPost httpPost = new HttpPost(path);
		String locale = Locale.getDefault().getLanguage();
		if (locale.equals("zh")) {
			locale = "zh";
		} else {
			locale = "en";
		}
		httpPost.addHeader("Cookie", "locale=" + locale);

		HttpClient client = HttpsUtil.getHttpClient();

		client.getParams().setParameter(
				CoreConnectionPNames.CONNECTION_TIMEOUT, 5 * 1000);
		HttpResponse response = client.execute(httpPost);

		return new String(readStream(response.getEntity().getContent()),
				encoding);
	}

	/**
	 * 
	 * 将输入流转化成字符串
	 * 
	 * @param inStream
	 *            输入流
	 * @return 字符串
	 * @throws Exception
	 */
	public static byte[] readStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len = inStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}
		outSteam.close();
		inStream.close();
		return outSteam.toByteArray();
	}

	/**
	 * 联网的异步任务
	 * 
	 * @author paytend_liu
	 * 
	 */
	private static class HttpsAsyncTask extends AsyncTask<String, Void, String> {
		/**
		 * 联网的标识符
		 */
		private int type;
		/**
		 * 监听器
		 */
		private HttpsListener listener;

		/**
		 * 
		 * @param listener
		 * @param type
		 */
		public HttpsAsyncTask(HttpsListener listener, int type) {
			this.listener = listener;
			this.type = type;
		}

		protected void onPostExecute(String HttpsStr) {
			if (listener != null) {
				Message message = new Message();
				message.what = type;
				if (HttpsStr != null) {
					message.obj = HttpsStr;
				}
				listener.onPostGet(message);
			}

		}

		@Override
		protected String doInBackground(String... url) {
			if (isEmpty(url[0])) {
				return null;
			}
			try {
				return sendHttpsClientPOSTRequest(url[0]);
			} catch (Exception e) {
				return null;
			}
		}
	}
/**
 * 监听器
 * @author paytend_liu
 *
 */
	public static interface HttpsListener {
		/**
		 * 接收联网返回的消息
		 * @param message 联网返回的消息
		 */
		public void onPostGet(Message message);
	}
/**
 * 判断字符串是否为空
 * @param sourceArray 需要判断的字符串
 * @return 空为true 非空为false
 */
	public static boolean isEmpty(String sourceArray) {
		return (sourceArray == null || sourceArray.isEmpty());
	}
}
