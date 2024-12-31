package iih.mp.dg.outdto.opdisppres.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 摆药状态 DTO数据 
 * 
 */
public class OpPresStateDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
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
	 * 处方id
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方id
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 发药窗口号
	 * @return String
	 */
	public String getWicket() {
		return ((String) getAttrVal("Wicket"));
	}
	/**
	 * 发药窗口号
	 * @param Wicket
	 */
	public void setWicket(String Wicket) {
		setAttrVal("Wicket", Wicket);
	}
	/**
	 * 摆药师id
	 * @return String
	 */
	public String getId_emp_disp() {
		return ((String) getAttrVal("Id_emp_disp"));
	}
	/**
	 * 摆药师id
	 * @param Id_emp_disp
	 */
	public void setId_emp_disp(String Id_emp_disp) {
		setAttrVal("Id_emp_disp", Id_emp_disp);
	}
	/**
	 * 摆药师姓名
	 * @return String
	 */
	public String getName_emp_disp() {
		return ((String) getAttrVal("Name_emp_disp"));
	}
	/**
	 * 摆药师姓名
	 * @param Name_emp_disp
	 */
	public void setName_emp_disp(String Name_emp_disp) {
		setAttrVal("Name_emp_disp", Name_emp_disp);
	}
	/**
	 * 摆药完成时间
	 * @return FDateTime
	 */
	public FDateTime getDt_disp() {
		return ((FDateTime) getAttrVal("Dt_disp"));
	}
	/**
	 * 摆药完成时间
	 * @param Dt_disp
	 */
	public void setDt_disp(FDateTime Dt_disp) {
		setAttrVal("Dt_disp", Dt_disp);
	}
	/**
	 * 摆药状态
	 * @return Integer
	 */
	public Integer getEn_disp() {
		return ((Integer) getAttrVal("En_disp"));
	}
	/**
	 * 摆药状态
	 * @param En_disp
	 */
	public void setEn_disp(Integer En_disp) {
		setAttrVal("En_disp", En_disp);
	}
}