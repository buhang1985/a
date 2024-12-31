package iih.sc.apt.dto.d;

import xap.mw.core.data.FArrayList;

public class RegResultDTO {
	
	/***
	 * 发票信息
	 */
	private FArrayList incoicList;
	/**
	 * 预约id
	 */
	private String id_apt;
	/**
	 * 就诊顺序号
	 */
	private String sequenceNumber;
	/**
	 * 就诊次数
	 */
	private String times;
	/**
	 * 建议就诊时间
	 */
	private String visitingTime;
	/**
	 * 建议就诊时间差
	 */
	private Integer suggestExmint;
	/**
	 * 就诊日期
	 */
	private String entDate;
	/**
	 * 门诊地点
	 */
	private String placeOfVisit;
	/**
	 * 挂号是否成功标志及失败异常信息
	 */
	private String regMsg;
	//结算id
	private String id_stoep;
	//结算流水号
	private String code_st;
	//结算时间
	private String dt_st;
	
	public String getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getVisitingTime() {
		return visitingTime;
	}
	public void setVisitingTime(String visitingTime) {
		this.visitingTime = visitingTime;
	}
	public String getPlaceOfVisit() {
		return placeOfVisit;
	}
	public void setPlaceOfVisit(String placeOfVisit) {
		this.placeOfVisit = placeOfVisit;
	}
	public String getRegMsg() {
		return regMsg;
	}
	public void setRegMsg(String regMsg) {
		this.regMsg = regMsg;
	}
	public Integer getSuggestExmint() {
		return suggestExmint;
	}
	public void setSuggestExmint(Integer suggestExmint) {
		this.suggestExmint = suggestExmint;
	}
	public String getEntDate() {
		return entDate;
	}
	public void setEntDate(String entDate) {
		this.entDate = entDate;
	}
	public String getId_apt() {
		return id_apt;
	}
	public void setId_apt(String id_apt) {
		this.id_apt = id_apt;
	}
	public FArrayList getIncoicList() {
		return incoicList;
	}
	public void setIncoicList(FArrayList incoicList) {
		this.incoicList = incoicList;
	}
	public String getId_stoep() {
		return id_stoep;
	}
	public void setId_stoep(String id_stoep) {
		this.id_stoep = id_stoep;
	}
	public String getCode_st() {
		return code_st;
	}
	public void setCode_st(String code_st) {
		this.code_st = code_st;
	}
	public String getDt_st() {
		return dt_st;
	}
	public void setDt_st(String dt_st) {
		this.dt_st = dt_st;
	}
	
}
