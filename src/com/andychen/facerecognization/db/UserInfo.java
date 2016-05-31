package com.andychen.facerecognization.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 用户信息
 * 
 * @author paytend_liu
 * 
 */
public class UserInfo {
	/**
	 * 单例用户信息
	 */
	private static UserInfo mInfo;
	/**
	 * 即时结算
	 */
	private boolean authSettlement;
	/**
	 * 及时结算验证手机
	 */
	private boolean authMobile;
	/**
	 * 四费率key
	 */
	private List<String> mFeeKeyList;
	/**
	 * 四费率value
	 */
	private List<String> mFeeValueList;
	/**
	 * 是否支持四费率
	 */
	boolean support4rate = false;
	/**
	 * 当前费率
	 */
	int currentRate;
	/**
	 * 商户手机号
	 */
	private String telNo = "";
	/**
	 * 刷卡费率
	 */
	private String posFee;
	/**
	 * 刷卡封顶
	 */
	private String posTopFee;
	/**
	 * 微信费率
	 */
	private String wxFee;
	/**
	 * 快捷支付费率
	 */
	private String qpayFee;

	/**
	 * 是否需要更新信息
	 */
	private boolean needUpdate;
	/**
	 * t0校验姓名
	 */
	private String t0Name;
	/**
	 * t0校验省份证号
	 */
	private String t0CardId;
	/**
	 * t0校验金额
	 */
	private String t0CheckAmount;
	/**
	 * 每日t0额度
	 */
	private String t0Amount;
	/**
	 * 每日t0磁条卡额度
	 */
	private String t0MagenticAmount;
	/**
	 * 结算时间
	 */
	private int realTime;
	/**
	 * 加密密钥
	 */
	private String macKey;
	/**
	 * 签购单名称
	 */
	private String merchantName;
	/**
	 * 商户的编号
	 */
	private String merchantId;
	/**
	 * 信用卡每笔消费金额
	 */
	private String maxAmount;
	/**
	 * 信用卡每日消费金额
	 */
	private String dayAmount;
	/**
	 * 借记卡每笔消费金额
	 */
	private String monthAmount;
	/**
	 * 银行名称
	 */
	private String bankName;
	/**
	 * 持卡人姓名
	 */
	private String bankAccName;
	/**
	 * 卡号
	 */
	private String bankAcc;
	/**
	 * 最后结算的id
	 */
	private String lastSettle_id;
	/**
	 * 最后结算金额
	 */
	private String lastSettle_amount;
	/**
	 * 结算状态
	 */
	private String lastSettle_status;
	/**
	 * 结算时间
	 */
	private String lastSettle_recordTime;
	/**
	 * 原因
	 */
	private String lastSettle_remark;

	/**
	 * 服务商名称
	 */
	private String agentName;
	/**
	 * 服务商地址
	 */
	private String agentAddress;
	/**
	 * 服务商电话
	 */
	private String agentTelNo;
	/**
	 * 服务商网址
	 */
	private String agentWebsite;
	/**
	 * 服务商QQ
	 */
	private String agentQQ;
	/**
	 * 业务员名称
	 */
	private String oper;
	/**
	 * 业务员编号
	 */
	private String operId;
	/**
	 * 业务员电话
	 */
	private String operMobile;

	/**
	 * 手机充值实际金额
	 */
	private String t30, t50, t100, t200, t300, t500;

	/**
	 * 私有构造函数
	 */
	private UserInfo() {

	}

	/**
	 * 获取用户信息
	 * 
	 * @return 单例用户信息
	 */
	public static UserInfo getInfo() {
		if (mInfo == null) {
			mInfo = new UserInfo();
		}
		return mInfo;
	}

	/**
	 * 清空用户信息
	 * 
	 * @return 单例用户信息
	 */
	public static void ClearInfo() {

		mInfo = null;

	}

	/**
	 * 即时结算校验手机
	 * 
	 * @return
	 */
	public boolean isAuthMobile() {
		return authMobile;
	}

	/**
	 * 即时结算
	 * 
	 * @return
	 */
	public boolean isAuthSettlement() {
		return authSettlement;
	}

	/**
	 * 即时结算检验手机
	 * 
	 * @param authMobile
	 */
	public void setAuthMobile(boolean authMobile) {
		this.authMobile = authMobile;
	}

	/**
	 * 即时结算
	 * 
	 * @param authSettlement
	 */
	public void setAuthSettlement(boolean authSettlement) {
		this.authSettlement = authSettlement;
	}

	/**
	 * 当前费率
	 * 
	 * @return
	 */
	public int getCurrentRate() {
		if (currentRate == 0) {
			currentRate = 1;
		}
		return currentRate;
	}

	/**
	 * 当前费率
	 * 
	 * @param currentRate
	 */
	public void setCurrentRate(int currentRate) {
		this.currentRate = currentRate;
	}

	/**
	 * 四费率key
	 * 
	 * @return
	 */
	public List<String> getFeeKeyList() {
		if (mFeeKeyList == null) {
			mFeeKeyList = new ArrayList<String>();
		}
		return mFeeKeyList;
	}

	/**
	 * 四费率key
	 * 
	 * @param mFeeKeyList
	 */
	public void setFeeKeyList(List<String> mFeeKeyList) {
		this.mFeeKeyList = mFeeKeyList;
	}

	/**
	 * 四费率value
	 * 
	 * @return
	 */
	public List<String> getFeeValueList() {
		if (mFeeValueList == null) {
			mFeeValueList = new ArrayList<String>();
		}
		return mFeeValueList;
	}

	/**
	 * 四费率value
	 * 
	 * @param mFeeValueList
	 */
	public void setFeeValueList(List<String> mFeeValueList) {
		this.mFeeValueList = mFeeValueList;
	}

	/**
	 * 是否支持4费率
	 * 
	 * @param support4rate
	 */
	public void setSupport4rate(boolean support4rate) {
		this.support4rate = support4rate;
	}

	/**
	 * 是否支持四费率
	 * 
	 * @return
	 */
	public boolean isSupport4rate() {
		return support4rate;
	}

	/**
	 * 商户手机号
	 */
	public String getTelNo() {
		return telNo;
	}

	/**
	 * 商户手机号
	 * 
	 * @param telNo
	 */
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	/**
	 * 刷卡费率
	 * 
	 * @return
	 */
	public String getPosFee() {
		return posFee;
	}

	/**
	 * 刷卡费率
	 * 
	 * @param posFee
	 */
	public void setPosFee(String posFee) {
		this.posFee = posFee;
	}

	/**
	 * 刷卡封顶
	 * 
	 * @return
	 */
	public String getPosTopFee() {
		return posTopFee;
	}

	/**
	 * 刷卡封顶
	 * 
	 * @param posTopFee
	 */
	public void setPosTopFee(String posTopFee) {
		this.posTopFee = posTopFee;
	}

	/**
	 * 微信支付费率
	 * 
	 * @return
	 */
	public String getWxFee() {
		return wxFee;
	}

	/**
	 * 微信支付费率
	 * 
	 * @param wxFee
	 */
	public void setWxFee(String wxFee) {
		this.wxFee = wxFee;
	}

	/**
	 * 快捷支付费率
	 * 
	 * @return
	 */
	public String getQpayFee() {
		return qpayFee;
	}

	/**
	 * 快捷支付费率
	 * 
	 * @param qpayFee
	 */
	public void setQpayFee(String qpayFee) {
		this.qpayFee = qpayFee;
	}

	/**
	 * 是否需要完善信息
	 * 
	 * @return
	 */
	public boolean isNeedUpdate() {
		return needUpdate;
	}

	/**
	 * 是否需要完善信息
	 * 
	 * @param needUpdate
	 */
	public void setNeedUpdate(boolean needUpdate) {
		this.needUpdate = needUpdate;
	}

	/**
	 * t0校验金额
	 * 
	 * @return
	 */
	public String getT0CheckAmount() {
		return t0CheckAmount;
	}

	/**
	 * t0校验金额
	 * 
	 * @param t0CheckAmount
	 */
	public void setT0CheckAmount(String t0CheckAmount) {
		this.t0CheckAmount = t0CheckAmount;
	}

	/**
	 * t0校验姓名
	 * 
	 * @return
	 */
	public String getT0Name() {
		return t0Name;
	}

	/**
	 * t0校验姓名
	 * 
	 * @param t0Name
	 */
	public void setT0Name(String t0Name) {
		this.t0Name = t0Name;
	}

	/**
	 * t0校验身份证号
	 * 
	 * @return
	 */
	public String getT0CardId() {
		return t0CardId;
	}

	/**
	 * t0校验身份证号
	 * 
	 * @param t0CardId
	 */
	public void setT0CardId(String t0CardId) {
		this.t0CardId = t0CardId;
	}

	/**
	 * 每日t0额度
	 * 
	 * @return
	 */
	public String getT0Amount() {
		return t0Amount;
	}

	/**
	 * 每日t0额度
	 * 
	 * @param t0Amount
	 */
	public void setT0Amount(String t0Amount) {
		this.t0Amount = t0Amount;
	}

	/**
	 * 每日t0磁条额度
	 * 
	 * @return
	 */
	public String getT0MangenticAmount() {
		return t0MagenticAmount;
	}

	/**
	 * 每日t0磁条额度
	 * 
	 * @param t0Amount
	 */
	public void setT0MangenticAmount(String t0Amount) {
		this.t0MagenticAmount = t0Amount;
	}

	/**
	 * 结算时间
	 * 
	 * @return
	 */
	public int getRealTime() {
		return realTime;
	}

	/**
	 * 结算时间
	 * 
	 * @param realTime
	 */
	public void setRealTime(int realTime) {
		this.realTime = realTime;
	}

	/**
	 * 加密密钥
	 * 
	 * @return
	 */
	public String getMacKey() {
		return macKey;
	}

	/**
	 * 加密密钥
	 * 
	 * @param macKey
	 */
	public void setMacKey(String macKey) {
		this.macKey = macKey;
	}

	/**
	 * 签购单名称
	 * 
	 * @return
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * 签购单名称
	 * 
	 * @param merchantName
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
	 * 用户ID
	 * 
	 * @return
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * 用户ID
	 * 
	 * @param merchantId
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * 信用卡每笔消费金额
	 * 
	 * @return
	 */
	public String getMaxAmount() {
		return maxAmount;
	}

	/**
	 * 信用卡每笔消费金额
	 * 
	 * @param maxAmount
	 */

	public void setMaxAmount(String maxAmount) {
		this.maxAmount = maxAmount;
	}

	/**
	 * 信用卡每日消费金额
	 * 
	 * @return
	 */
	public String getDayAmount() {
		return dayAmount;
	}

	/**
	 * 信用卡每日消费金额
	 * 
	 * @param dayAmount
	 */
	public void setDayAmount(String dayAmount) {
		this.dayAmount = dayAmount;
	}

	/**
	 * 借记卡每笔消费金额
	 * 
	 * @return
	 */
	public String getMonthAmount() {
		return monthAmount;
	}

	/**
	 * 借记卡每笔消费金额
	 * 
	 * @param monthAmount
	 */
	public void setMonthAmount(String monthAmount) {
		this.monthAmount = monthAmount;
	}

	/**
	 * 银行名称
	 * 
	 * @return
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * 银行名称
	 * 
	 * @param bankName
	 */

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * 持卡人姓名
	 * 
	 * @return
	 */
	public String getBankAccName() {
		return bankAccName;
	}

	/**
	 * 持卡人姓名
	 * 
	 * @param bankAccName
	 */
	public void setBankAccName(String bankAccName) {
		this.bankAccName = bankAccName;
	}

	/**
	 * 银行卡号
	 * 
	 * @return
	 */
	public String getBankAcc() {
		return bankAcc;
	}

	/**
	 * 银行卡号
	 * 
	 * @param bankAcc
	 */
	public void setBankAcc(String bankAcc) {
		this.bankAcc = bankAcc;
	}

	/**
	 * 最后结算ID
	 * 
	 * @return
	 */
	public String getLastSettle_id() {
		return lastSettle_id;
	}

	/**
	 * 最后结算ID
	 * 
	 * @param lastSettle_id
	 */
	public void setLastSettle_id(String lastSettle_id) {
		this.lastSettle_id = lastSettle_id;
	}

	/**
	 * 最后结算金额
	 * 
	 * @return
	 */
	public String getLastSettle_amount() {
		return lastSettle_amount;
	}

	/**
	 * 最后结算金额
	 * 
	 * @param lastSettle_amount
	 */
	public void setLastSettle_amount(String lastSettle_amount) {
		this.lastSettle_amount = lastSettle_amount;
	}

	/**
	 * 最后结算状态
	 * 
	 * @return
	 */
	public String getLastSettle_status() {
		return lastSettle_status;
	}

	/**
	 * 最后结算状态
	 * 
	 * @param lastSettle_status
	 */
	public void setLastSettle_status(String lastSettle_status) {
		this.lastSettle_status = lastSettle_status;
	}

	/**
	 * 最后结算时间
	 */
	public String getLastSettle_recordTime() {
		return lastSettle_recordTime;
	}

	/**
	 * 最后结算时间
	 * 
	 * @param lastSettle_recordTime
	 */
	public void setLastSettle_recordTime(String lastSettle_recordTime) {
		this.lastSettle_recordTime = lastSettle_recordTime;
	}

	/**
	 * 最后结算原因
	 * 
	 * @return
	 */
	public String getLastSettle_remark() {
		return lastSettle_remark;
	}

	/**
	 * 最后结算原因
	 * 
	 * @param lastSettle_remark
	 */
	public void setLastSettle_remark(String lastSettle_remark) {
		this.lastSettle_remark = lastSettle_remark;
	}

	/**
	 * 服务机构名称
	 * 
	 * @return
	 */
	public String getAgentName() {
		return agentName;
	}

	/**
	 * 服务机构名称
	 * 
	 * @param agentName
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	/**
	 * 服务机构地址
	 * 
	 * @return
	 */
	public String getAgentAddress() {
		return agentAddress;
	}

	/**
	 * 服务机构地址
	 * 
	 * @param agentAddress
	 */

	public void setAgentAddress(String agentAddress) {
		this.agentAddress = agentAddress;
	}

	/**
	 * 服务机构电话
	 * 
	 * @return
	 */
	public String getAgentTelNo() {
		return agentTelNo;
	}

	/**
	 * 服务机构电话
	 * 
	 * @param agentTelNo
	 */

	public void setAgentTelNo(String agentTelNo) {
		this.agentTelNo = agentTelNo;
	}

	/**
	 * 服务机构网址
	 * 
	 * @return
	 */
	public String getAgentWebsite() {
		return agentWebsite;
	}

	/**
	 * 服务机构网址
	 * 
	 * @param agentWebsite
	 */
	public void setAgentWebsite(String agentWebsite) {
		this.agentWebsite = agentWebsite;
	}

	/**
	 * 服务机构QQ
	 * 
	 * @return
	 */
	public String getAgentQQ() {
		return agentQQ;
	}

	/**
	 * 服务机构QQ
	 * 
	 * @param agentQQ
	 */
	public void setAgentQQ(String agentQQ) {
		this.agentQQ = agentQQ;
	}

	/**
	 * 业务员名字
	 * 
	 * @return
	 */
	public String getOper() {
		return oper;
	}

	/**
	 * 业务员名字
	 * 
	 * @param oper
	 */
	public void setOper(String oper) {
		this.oper = oper;
	}

	/**
	 * 业务员编号
	 * 
	 * @return
	 */
	public String getOperId() {
		return operId;
	}

	/**
	 * 业务员编号
	 * 
	 * @param operId
	 */
	public void setOperId(String operId) {
		this.operId = operId;
	}

	/**
	 * 业务员电话
	 * 
	 * @return
	 */
	public String getOperMobile() {
		return operMobile;
	}

	/**
	 * 业务员电话
	 * 
	 * @param operMobile
	 */
	public void setOperMobile(String operMobile) {
		this.operMobile = operMobile;
	}

	/**
	 * 实际充值金额
	 * 
	 * @return
	 */
	public String getT30() {
		return t30;
	}

	/**
	 * 实际充值金额
	 * 
	 * @param t30
	 */
	public void setT30(String t30) {
		this.t30 = t30;
	}

	/**
	 * 实际充值金额
	 * 
	 * @return
	 */
	public String getT50() {
		return t50;
	}

	/**
	 * 实际充值金额
	 * 
	 * @param t50
	 */
	public void setT50(String t50) {
		this.t50 = t50;
	}

	/**
	 * 实际充值金额
	 * 
	 * @return
	 */
	public String getT100() {
		return t100;
	}

	/**
	 * 实际充值金额
	 * 
	 * @param t100
	 */
	public void setT100(String t100) {
		this.t100 = t100;
	}

	/**
	 * 实际充值金额
	 * 
	 * @return
	 */
	public String getT200() {
		return t200;
	}

	/**
	 * 实际充值金额
	 * 
	 * @param t200
	 */
	public void setT200(String t200) {
		this.t200 = t200;
	}

	/**
	 * 实际充值金额
	 * 
	 * @return
	 */
	public String getT300() {
		return t300;
	}

	/**
	 * 实际充值金额
	 * 
	 * @param t300
	 */
	public void setT300(String t300) {
		this.t300 = t300;
	}

	/**
	 * 实际充值金额
	 * 
	 * @return
	 */
	public String getT500() {
		return t500;
	}

	/**
	 * 实际充值金额
	 * 
	 * @param t500
	 */
	public void setT500(String t500) {
		this.t500 = t500;
	}

}
