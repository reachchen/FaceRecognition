package com.andychen.facerecognization.util;

/**
 * 访问的地址和接口
 * 
 * @author paytend_liu
 * 
 */
public class HttpURL {
	/**
	 * 登录返回的地址，其他交易接口都访问此地址
	 */
	private static String httpStr;

	/**
	 * 登录返回的地址，其他交易接口都访问此地址
	 */
	public static void setHttp(String mhttp) {
		httpStr = mhttp;
	}

	/**
	 * 登录返回的地址，其他交易接口都访问此地址
	 */
	public static String getHttp() {
		if (httpStr == null || httpStr.length() == 0) {
			return baseURLStr;
		}
		// return baseURLStr;
		return httpStr;
	}

	/**
	 * 外卡 链接地址
	 */
	public static String waikaHttp;

	/**
	 * 登录返回的地址，其他交易接口都访问此地址
	 */
	public static void setWaikaHttp(String mhttp) {
		waikaHttp = mhttp;
	}

	/**
	 * 登录返回的地址，其他交易接口都访问此地址
	 */
	public static String getWaikaHttp() {
		return waikaHttp;
	}

	/**
	 * 登录密钥
	 */
	public static final String MK = "2356174821BDCCAE49572909876BCBCBC";
	/**
	 * 注册密钥
	 */
	public static final String CK = "0C86F818D3D65C6E272C88C6564A9467F7945A4C5FA33267F3C7C0B7CEB9096E";
	/**
	 * 访问的ip
	 */
	public final static String baseURLStr = "http://posp.paytend.com:9067";
	// 测试
	// public final static String baseURLStr = "http://59.151.3.43:8078";
	// public final static String baseURLStr = "http://218.97.161.244:9062";

	// public final static String baseURLStr = "http://192.168.1.149:9001";
	/**
	 * 用户信息相关访问的ip
	 */
	public final static String regbaseStr = "http://a.paytend.com";
	// 测试
	// public final static String regbaseStr = "http://59.151.3.43";
	// public final static String regbaseStr = "http://192.168.1.149";
	/**
	 * 收银台 打印二维码生产
	 */
	public final static String CashierStr = "https://pay.paytend.com/d/printQR";
	// 测试
	//public final static String CashierStr = "http://test.paytend.com:8088/d/printQR";
	/**
	 * p2p协议
	 */
	public static final String p2pAgreementStr = "http://101.200.238.151:8080/m/m_register_protocol.shtml";
	// public static final String p2pAgreementStr = HttpURL.baseURLStr
	// + "/m/m_register_protocol.shtml";

	/**
	 * p2p登录
	 */
	public static final String p2pLoginStr = HttpURL.baseURLStr
			+ "/service2/p2p/p2plogin.htm";
	// HttpURL.baseURLStr

	/**
	 * p2p开通
	 */
	public final static String p2pOpen = HttpURL.baseURLStr
			+ "/service2/p2p/p2preg.htm";
	// HttpURL.baseURLStr
	/**
	 * 发送交易凭证
	 */
	public static String sendMessageOrEmail = "/service2/sendmsg.htm";
	/**
	 * 上传调单凭证
	 */
	public static String updateInvokePhoto = "/service2/upload_proof.htm";
	/**
	 * 获取可撤销的交易
	 */
	public static String getRevokeTradeList = "/service2/gettradelist4cancel.htm";
	/**
	 * 及时结算
	 */
	public static final String timelySettle = "/service2/settle/authWithdraw.htm";
	/**
	 * t+0结算列表
	 */
	public static String getTzeroList = "/service2/settle/getwithdrawtradelist.htm";
	/**
	 * t+0提现
	 */
	public static String getTzerocash = "/service2/settle/withdraw.htm";
	/**
	 * t+0更改结算模式
	 */
	public static String changTzeroModel = "/service2/settle/settlemode.htm";
	/**
	 * 检测T+0是否开通
	 */
	public static String tzerocheck = "/service2/settle/checkorg.htm";
	/**
	 * 检测信用卡是否正确
	 */
	public static String checkcreditStr = "/service2/checkcreditcard.htm";
	/**
	 * 获取当日还款记录
	 */
	public static String getRepaymentToday = "/service2/getbmtradelist.htm";
	/**
	 * 获取历史还款记录
	 */
	public static String getRepamentHistory = "/service2/getbmhistorytradelist.htm";
	public static String getBannerImage = regbaseStr
			+ "/api/jupos/regist/getAdPhoto.html";
	/**
	 * 获取头像信息
	 */
	public static String getHeader = regbaseStr
			+ "/api/jupos/regist/getUserHead.html";
	/**
	 * 转账查询手续费
	 */
	public static String poundageStr = "/service2/getc2cfee.htm";
	/**
	 * 加载图片
	 */
	public static String getphoto = regbaseStr + "/d/photo/";
	/**
	 * 获取商城列表
	 */
	public static String getPosList = regbaseStr
			+ "/api/jupos/regist/getposlist.html";
	/**
	 * 获取商城列表
	 */
	public static String getVouchersList = regbaseStr
			+ "/api/jupos/regist/get_voucher_list.html";
	/***
	 * 购买pos机，下订单
	 */
	public final static String buyposStr = regbaseStr
			+ "/api/jupos/regist/order.html";
	/**
	 * 获取分享信息
	 */
	public final static String getShareUrl = regbaseStr
			+ "/api/jupos/regist/getShareContent.html";
	/**
	 * 分享保存地址
	 */
	public final static String saveAddressUrl = regbaseStr
			+ "/api/jupos/regist/saveOrderAddr.html";
	/**
	 * 检测快捷支付的需填内容
	 */
	public static String quickCheck = "/service2/qpay/getcheckdata.htm";
	/**
	 * 获取验证码
	 */
	public static String quickphone = "/service2/qpay/getmobilecheckvalue.htm";
	/**
	 * 上传用户信息
	 */
	public final static String updataUserstr = regbaseStr
			+ "/api/jupos/regist/updateUser.html";
	/**
	 * 获取消息列表
	 */
	public final static String getNewsList = regbaseStr
			+ "/api/jupos/regist/getNewsList.html";
	/**
	 * 获取用户信息
	 */
	public final static String getUserstr = regbaseStr
			+ "/api/jupos/regist/getUser.html";
	/***
	 * 获取银行列表
	 */
	public static final String getBankList = regbaseStr
			+ "/api/jupos/regist/getBankList.html";
	/**
	 * 理财充值
	 */
	public static String payP2p = "/service2/p2p/p2ptopup.htm";
	/**
	 * 上传照片
	 */
	public final static String uploadInfo = regbaseStr
			+ "/api/jupos/regist/uploadInfo.html";
	/**
	 * 获取照片
	 */
	public static final String getUserPhoto = regbaseStr
			+ "/api/jupos/regist/getUserPhoto.html";
	/**
	 * 查询余额
	 */
	public static String Search_balance = "/service2/getbalance.htm";
	/***
	 * 回写
	 */
	public static String writeback = "/service2/uploadicdata.htm";
	/**
	 * 获取调单列表
	 */
	public static String getInvokeList = "/service2/gettradeinvokelist.htm";
	/**
	 * 调单交易详情
	 */
	public static String getInvokeDetial = "/service2/gettradeinvokedetial.htm";
	/**
	 * 获取工单列表
	 */
	public static String GET_WORKFORM_RECORDS = regbaseStr
			+ "/api/jupos/workorder/query_workorder_list.html";
	/**
	 * 微信支付
	 */
	public static String weChatPayStr = "/service2/wx/wxpay.htm";

	/**
	 * 撤销
	 */
	public static String revoke = "/service2/cancel.htm";
	/**
	 * 快捷支付
	 */
	public static String quickpay = "/service2/qpay/pay.htm";
	/**
	 * 刷卡消费
	 */
	public static String pay = "/service2/mpay.htm";
	/**
	 * 检查版本更新
	 */
	public static String check_version = baseURLStr
			+ "/service2/getappversion.htm";
	/**
	 * 获取绑定的pos机列表
	 */
	public static String getDevicesList = "/service2/getdevices.htm";
	/**
	 * 修改密码
	 */
	public final static String modifypassword = baseURLStr
			+ "/service2/modifypassword.htm";
	/**
	 * 登录的地址
	 */
	public final static String loginStr = baseURLStr + "/service2/login.htm";
	/**
	 * 获取最后结算信息
	 */
	public static String lastSettleStr = "/service2/getlastsettleinfo.htm";
	/**
	 * pos机登录
	 */
	public static String poslogin = "/service2/poslogin.htm";

	/**
	 * 获取当日交易记录
	 */
	public static String getTodayTradList = "/service2/gettradelistnew.htm";
	/**
	 * 获取交易详情
	 */
	public static String getCancelTradeDetial = "/service2/gettradedetail.htm";
	/**
	 * 上传签名
	 */
	public static String uploadPhoto = "/d/upload/mobile";
	/**
	 * 获取历史交易记录
	 */
	public static String getHistoryTradList = "/service2/gethistorytradelistnew.htm";
	/**
	 * 获取推送消息
	 */
	public final static String getBDpush = regbaseStr
			+ "/api/baidupush/getBDMsgList.html";
	/**
	 * 注册商户获取验证码
	 */
	public static String regCheckcode = regbaseStr
			+ "/api/jupos/regist/getcheckcode.html";
	/**
	 * 注册商户
	 */
	public static String registStr = regbaseStr
			+ "/api/jupos/regist/regist.html";
	/**
	 * 解绑POS机
	 */
	public static final String UnbindPos = baseURLStr + "/service2/unbind.htm";
	/**
	 * 获取问题类型列表
	 */
	public static final String GET_WORKFORM_QUESTION_TYPE = regbaseStr
			+ "/api/jupos/workorder/query_categories_list.html";
	/**
	 * 获取结算信息
	 */
	public static String Get_Settle = "/service2/settleinfo.htm";
	/***
	 * 转账
	 */
	public static String Transfer = "/service2/c2ctransfer.htm";
	/**
	 * 还款
	 */
	public static String Repaymet = "/service2/creditcardrepayment.htm";
	/***
	 * 手机充值
	 */
	public static String Recharge = "/service2/charge.htm";
	/***
	 * 推送
	 */
	public static String BDpush = regbaseStr
			+ "/api/baidupush/bindChannel.html";
	/**
	 * 天天结算
	 */
	public static String DayOneStr = regbaseStr + "/d1open/d1.html";
	/**
	 * 获取公告
	 */
	public static String NewsStr = regbaseStr
			+ "/api/jupos/regist/getNews.html";
	/**
	 * 更改费率
	 */
	public static String ChangeFee = baseURLStr
			+ "/service2/settle/setcurrentrate.htm";
	/**
	 * 绑定二维码
	 */
	public static String BundingCode = baseURLStr + "/service2/wx/bindqr.htm";
	/**
	 * 汇率转换
	 */
	public static String Convert = "http://test.paytend.com:8088/rmb2eur.htm";
	public static String waikaPay = "/service2/appqpay.htm";
	public static String waikaRevoike = "/service2/appqpaycancel.htm";
	public static String timelyCheck = "/service2/settle/authentication.htm";
	/**
	 * 获取微信支付参数
	 */
	public static String getWechatBuy = regbaseStr
			+ "/api/jupos/regist/payOrder2Wxpay.html";
	/**
	 * 获取钱包信息
	 */
	public static String getWalletInfo = getHttp()
			+ "/service2/wallet/getaccountstat.htm";
	/**
	 * 钱包是否自动结算
	 */
	public static String isWalletSettleAuto = getHttp()
			+ "/service2/wallet/tranferinaccount.htm";
	/**
	 * 获取具体问题列表的url
	 * 
	 */
	public final static String GET_WORKFORM_QUSETION_LIST = regbaseStr
			+ "/api/jupos/workorder/query_subcategories_list.html";
	/**
	 * 问题有用
	 */
	public static final String WORKFORM_QUESTION_USE = regbaseStr
			+ "/api/jupos/workorder/click_categories_userful.html";
	/**
	 * 提交工单
	 */
	public static final String WORKFORM_UPDATE_QUESTION = regbaseStr
			+ "/api/jupos/workorder/add_workorder.html";
	/**
	 * 获取工单详情
	 */
	public static final String WORKFORM_GET_DETAIL = regbaseStr
			+ "/api/jupos/workorder/query_workorder_detail.html";
	/**
	 * 评价工单
	 */
	public static final String WORKFORM_EVALUATE = regbaseStr
			+ "/api/jupos/workorder/evaluate_workorder.html";
	/**
	 * 关闭工单
	 */
	public static final String WORKFORM_CLOSE = regbaseStr
			+ "/api/jupos/workorder/close_workorder.html";
	/**
	 * 确认工单
	 */
	public static final String WORKFORM_SOLUTION = regbaseStr
			+ "/api/jupos/workorder/sure_workorder.html";
	/**
	 * 提交留言
	 */
	public static final String WORKFORM_SUBMIT = regbaseStr
			+ "/api/jupos/workorder/re_workorder.html";
}
