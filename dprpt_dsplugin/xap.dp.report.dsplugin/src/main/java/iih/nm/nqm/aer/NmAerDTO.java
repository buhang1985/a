package iih.nm.nqm.aer;
/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年6月7日 下午5:03:30
 * 类说明：
 * Company: Copyright 2017 by PKU healthcare IT Co.,Ltd.
 */
public class NmAerDTO {

	private String name_emp_rpt;//报告人
	private String name_dep_rpt;//报告科室
	private String dt_occur;//发生时间
	private String dt_rpt;//报告时间
	private String evt_info;//基本情况
	private String problem;//存在问题
	private String advice;//改进建议
	private String sd_evt_ca;//事件分类
	private String name_other;//事件分类其他
	
	public String getName_other() {
		return name_other;
	}
	public void setName_other(String name_other) {
		this.name_other = name_other;
	}
	public String getName_emp_rpt() {
		return name_emp_rpt;
	}
	public void setName_emp_rpt(String name_emp_rpt) {
		this.name_emp_rpt = name_emp_rpt;
	}
	public String getName_dep_rpt() {
		return name_dep_rpt;
	}
	public void setName_dep_rpt(String name_dep_rpt) {
		this.name_dep_rpt = name_dep_rpt;
	}
	public String getDt_occur() {
		return dt_occur;
	}
	public void setDt_occur(String dt_occur) {
		this.dt_occur = dt_occur;
	}
	public String getDt_rpt() {
		return dt_rpt;
	}
	public void setDt_rpt(String dt_rpt) {
		this.dt_rpt = dt_rpt;
	}
	public String getEvt_info() {
		return evt_info;
	}
	public void setEvt_info(String evt_info) {
		this.evt_info = evt_info;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public String getSd_evt_ca() {
		return sd_evt_ca;
	}
	public void setSd_evt_ca(String sd_evt_ca) {
		this.sd_evt_ca = sd_evt_ca;
	}
	
	
}
