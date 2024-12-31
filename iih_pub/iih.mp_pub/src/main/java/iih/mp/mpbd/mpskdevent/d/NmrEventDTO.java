package iih.mp.mpbd.mpskdevent.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 文书事件 DTO数据 
 * 
 */
public class NmrEventDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getId_emp_oper() {
		return ((String) getAttrVal("Id_emp_oper"));
	}
	/**
	 * 操作人
	 * @param Id_emp_oper
	 */
	public void setId_emp_oper(String Id_emp_oper) {
		setAttrVal("Id_emp_oper", Id_emp_oper);
	}
	/**
	 * 发生时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}
	/**
	 * 发生时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 删除标志
	 * @return FBoolean
	 */
	public FBoolean getFg_del() {
		return ((FBoolean) getAttrVal("Fg_del"));
	}
	/**
	 * 删除标志
	 * @param Fg_del
	 */
	public void setFg_del(FBoolean Fg_del) {
		setAttrVal("Fg_del", Fg_del);
	}
	/**
	 * 文书事件
	 * @return String
	 */
	public String getId_nmrevent() {
		return ((String) getAttrVal("Id_nmrevent"));
	}
	/**
	 * 文书事件
	 * @param Id_nmrevent
	 */
	public void setId_nmrevent(String Id_nmrevent) {
		setAttrVal("Id_nmrevent", Id_nmrevent);
	}
	/**
	 * 文书事件编码
	 * @return String
	 */
	public String getSd_nmrevent() {
		return ((String) getAttrVal("Sd_nmrevent"));
	}
	/**
	 * 文书事件编码
	 * @param Sd_nmrevent
	 */
	public void setSd_nmrevent(String Sd_nmrevent) {
		setAttrVal("Sd_nmrevent", Sd_nmrevent);
	}
	/**
	 * 就诊状况类型
	 * @return String
	 */
	public String getId_enstatetp() {
		return ((String) getAttrVal("Id_enstatetp"));
	}
	/**
	 * 就诊状况类型
	 * @param Id_enstatetp
	 */
	public void setId_enstatetp(String Id_enstatetp) {
		setAttrVal("Id_enstatetp", Id_enstatetp);
	}
	/**
	 * 就诊状况类型编码
	 * @return String
	 */
	public String getSd_enstatetp() {
		return ((String) getAttrVal("Sd_enstatetp"));
	}
	/**
	 * 就诊状况类型编码
	 * @param Sd_enstatetp
	 */
	public void setSd_enstatetp(String Sd_enstatetp) {
		setAttrVal("Sd_enstatetp", Sd_enstatetp);
	}
	/**
	 * 就诊状况
	 * @return String
	 */
	public String getId_enstate() {
		return ((String) getAttrVal("Id_enstate"));
	}
	/**
	 * 就诊状况
	 * @param Id_enstate
	 */
	public void setId_enstate(String Id_enstate) {
		setAttrVal("Id_enstate", Id_enstate);
	}
	/**
	 * 其他属性
	 * @return FArrayList2
	 */
	public FArrayList2 getArr() {
		return ((FArrayList2) getAttrVal("Arr"));
	}
	/**
	 * 其他属性
	 * @param Arr
	 */
	public void setArr(FArrayList2 Arr) {
		setAttrVal("Arr", Arr);
	}
}