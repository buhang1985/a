package iih.ei.std.d.v1.en.saveentpeinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 保存体检就诊入参 DTO数据 
 * 
 */
public class SaveEntPeInfoParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
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
	 * 患者性别
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 患者性别
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 体检科室
	 * @return String
	 */
	public String getCode_dep_phy() {
		return ((String) getAttrVal("Code_dep_phy"));
	}	
	/**
	 * 体检科室
	 * @param Code_dep_phy
	 */
	public void setCode_dep_phy(String Code_dep_phy) {
		setAttrVal("Code_dep_phy", Code_dep_phy);
	}
	/**
	 * 体检日期
	 * @return String
	 */
	public String getDt_entry() {
		return ((String) getAttrVal("Dt_entry"));
	}	
	/**
	 * 体检日期
	 * @param Dt_entry
	 */
	public void setDt_entry(String Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getCode_emp_entry() {
		return ((String) getAttrVal("Code_emp_entry"));
	}	
	/**
	 * 登记人
	 * @param Code_emp_entry
	 */
	public void setCode_emp_entry(String Code_emp_entry) {
		setAttrVal("Code_emp_entry", Code_emp_entry);
	}
	/**
	 * 可体检有效期开始时间
	 * @return String
	 */
	public String getDt_valid_b() {
		return ((String) getAttrVal("Dt_valid_b"));
	}	
	/**
	 * 可体检有效期开始时间
	 * @param Dt_valid_b
	 */
	public void setDt_valid_b(String Dt_valid_b) {
		setAttrVal("Dt_valid_b", Dt_valid_b);
	}
	/**
	 * 可体检有效结束时间
	 * @return String
	 */
	public String getDt_valid_e() {
		return ((String) getAttrVal("Dt_valid_e"));
	}	
	/**
	 * 可体检有效结束时间
	 * @param Dt_valid_e
	 */
	public void setDt_valid_e(String Dt_valid_e) {
		setAttrVal("Dt_valid_e", Dt_valid_e);
	}
	/**
	 * 顺序号
	 * @return String
	 */
	public String getTickno() {
		return ((String) getAttrVal("Tickno"));
	}	
	/**
	 * 顺序号
	 * @param Tickno
	 */
	public void setTickno(String Tickno) {
		setAttrVal("Tickno", Tickno);
	}
}