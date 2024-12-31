package iih.mp.nr.hcis.d;

import java.io.Serializable;

public class QueryReportCondition implements Serializable {
  
	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;

	/**
	 * 查询开始时间
	 */
	private String beginDate;
	
	/**
	 * 查询结束时间
	 */
	private String endDate;
	
	/**
	 * 患者唯一标识 ID
	 */
	private String  patientId;

	public String getBeginDate() {
		return beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	
}
