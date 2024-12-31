package iih.bl.itf.std.bean.input.scvpbox.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.input.WsParamInfoWithCustom;

/**
 * 扫码堆刷卡支付
 * 
 * @author shaokx 2018/11/10
 *
 */
@XmlRootElement(name = "req")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamScvpBoxInfo extends WsParamInfoWithCustom {

	private static final long serialVersionUID = 1L;

	// His业务唯一订单号
	@XmlElement(name = "businessId")
	private String businessId;

	// 业务类型(预约挂号 0，诊间支付 1，住院预交金 2，当天挂号 3，住院结算 4)
	@XmlElement(name = "businessType")
	private String businessType;

	// 订单应收金额(单位：分)
	@XmlElement(name = "orderAmout")
	private String orderAmout;


	// 授权码(扫码设备获取的患者授权码)
	@XmlElement(name = "authCode")
	private String authCode;

	// 支付方式(微信刷卡付：9801，支付宝刷卡付：9901)
	@XmlElement(name = "payMode")
	private String payMode;

	// 扫码设备编码
	@XmlElement(name = "machineId")
	private String machineId;

	// 订单描述
	@XmlElement(name = "remark")
	private String remark;

	// 用户健康卡号码
	@XmlElement(name = "healthCardNo")
	private String healthCardNo;

	// 患者姓名
	@XmlElement(name = "patientName")
	private String patientName;

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getOrderAmout() {
		return orderAmout;
	}

	public void setOrderAmout(String orderAmout) {
		this.orderAmout = orderAmout;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getHealthCardNo() {
		return healthCardNo;
	}

	public void setHealthCardNo(String healthCardNo) {
		this.healthCardNo = healthCardNo;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
}
