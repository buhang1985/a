package iih.ei.std.d.v1.en.visittimesstat.d;

import xap.mw.core.data.BaseDTO;

/**
 * 统计门急诊就诊人次 DTO数据 
 * 
 */
public class VisitTimesStatDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 日期
	 * @return String
	 */
	public String getDate() {
		return ((String) getAttrVal("Date"));
	}	
	/**
	 * 日期
	 * @param Date
	 */
	public void setDate(String Date) {
		setAttrVal("Date", Date);
	}
	/**
	 * 急诊次数
	 * @return String
	 */
	public String getTimes_msg() {
		return ((String) getAttrVal("Times_msg"));
	}	
	/**
	 * 急诊次数
	 * @param Times_msg
	 */
	public void setTimes_msg(String Times_msg) {
		setAttrVal("Times_msg", Times_msg);
	}
	/**
	 * 门诊次数
	 * @return String
	 */
	public String getTimes_op() {
		return ((String) getAttrVal("Times_op"));
	}	
	/**
	 * 门诊次数
	 * @param Times_op
	 */
	public void setTimes_op(String Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	/**
	 * 科室编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 普通号次数
	 * @return String
	 */
	public String getTimes_comm() {
		return ((String) getAttrVal("Times_comm"));
	}	
	/**
	 * 普通号次数
	 * @param Times_comm
	 */
	public void setTimes_comm(String Times_comm) {
		setAttrVal("Times_comm", Times_comm);
	}
	/**
	 * 庄家号次数
	 * @return String
	 */
	public String getTimes_prof() {
		return ((String) getAttrVal("Times_prof"));
	}	
	/**
	 * 庄家号次数
	 * @param Times_prof
	 */
	public void setTimes_prof(String Times_prof) {
		setAttrVal("Times_prof", Times_prof);
	}
	/**
	 * 普通号医生出诊人天
	 * @return String
	 */
	public String getPhycomm_days() {
		return ((String) getAttrVal("Phycomm_days"));
	}	
	/**
	 * 普通号医生出诊人天
	 * @param Phycomm_days
	 */
	public void setPhycomm_days(String Phycomm_days) {
		setAttrVal("Phycomm_days", Phycomm_days);
	}
	/**
	 * 专家号医生出出诊人天
	 * @return String
	 */
	public String getPhyprof_days() {
		return ((String) getAttrVal("Phyprof_days"));
	}	
	/**
	 * 专家号医生出出诊人天
	 * @param Phyprof_days
	 */
	public void setPhyprof_days(String Phyprof_days) {
		setAttrVal("Phyprof_days", Phyprof_days);
	}
}