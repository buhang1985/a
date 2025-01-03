package iih.ci.ord.external.blood.ruimei.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 用血参数 DTO数据 
 * 
 */
public class IEOpUbOrEnParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 病人姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 病人姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}
	/**
	 * 申请单号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 开具的血液成分内容，多成分拼接而成（血液成分、数量、单位）
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 开具的血液成分内容，多成分拼接而成（血液成分、数量、单位）
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 交叉配血号
	 * @return String
	 */
	public String getMatch_id() {
		return ((String) getAttrVal("Match_id"));
	}
	/**
	 * 交叉配血号
	 * @param Match_id
	 */
	public void setMatch_id(String Match_id) {
		setAttrVal("Match_id", Match_id);
	}
	/**
	 * 申请医生代码
	 * @return String
	 */
	public String getCode_emp_or() {
		return ((String) getAttrVal("Code_emp_or"));
	}
	/**
	 * 申请医生代码
	 * @param Code_emp_or
	 */
	public void setCode_emp_or(String Code_emp_or) {
		setAttrVal("Code_emp_or", Code_emp_or);
	}
	/**
	 * 用血时间
	 * @return String
	 */
	public String getDt_effe() {
		return ((String) getAttrVal("Dt_effe"));
	}
	/**
	 * 用血时间
	 * @param Dt_effe
	 */
	public void setDt_effe(String Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 执行科室
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 住院次数
	 * @return String
	 */
	public String getTimesip() {
		return ((String) getAttrVal("Timesip"));
	}
	/**
	 * 住院次数
	 * @param Timesip
	 */
	public void setTimesip(String Timesip) {
		setAttrVal("Timesip", Timesip);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
}