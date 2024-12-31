package iih.ci.ord.i.external.gvchina.meta;

/**
 * 查询患者在眼科本次就诊的有效手术医嘱
 * @author wangqingzhu
 *
 */
public class GvSurgeryOrderRstInfo  extends BaseGvRstInfo {
	
	/**
	 * 申请时间
	 */
	private String appTime;
	
	
	/**
	 * 申请时间
	 */
	private String doctorCode;


	public String getAppTime() {
		return appTime;
	}


	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}


	public String getDoctorCode() {
		return doctorCode;
	}


	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	
	
	
}
