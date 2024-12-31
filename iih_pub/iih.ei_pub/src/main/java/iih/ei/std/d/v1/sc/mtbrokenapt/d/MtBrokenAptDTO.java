package iih.ei.std.d.v1.sc.mtbrokenapt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者爽约记录 DTO数据 
 * 
 */
public class MtBrokenAptDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 记录id
	 * @return String
	 */
	public String getId_key() {
		return ((String) getAttrVal("Id_key"));
	}	
	/**
	 * 记录id
	 * @param Id_key
	 */
	public void setId_key(String Id_key) {
		setAttrVal("Id_key", Id_key);
	}
	/**
	 * 患者编号
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编号
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
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 号别编码
	 * @return String
	 */
	public String getCode_scsrv() {
		return ((String) getAttrVal("Code_scsrv"));
	}	
	/**
	 * 号别编码
	 * @param Code_scsrv
	 */
	public void setCode_scsrv(String Code_scsrv) {
		setAttrVal("Code_scsrv", Code_scsrv);
	}
	/**
	 * 号别名称
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}	
	/**
	 * 号别名称
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
	/**
	 * 患者电话
	 * @return String
	 */
	public String getMobile() {
		return ((String) getAttrVal("Mobile"));
	}	
	/**
	 * 患者电话
	 * @param Mobile
	 */
	public void setMobile(String Mobile) {
		setAttrVal("Mobile", Mobile);
	}
	/**
	 * 爽约日期
	 * @return FDate
	 */
	public FDate getDt_act() {
		return ((FDate) getAttrVal("Dt_act"));
	}	
	/**
	 * 爽约日期
	 * @param Dt_act
	 */
	public void setDt_act(FDate Dt_act) {
		setAttrVal("Dt_act", Dt_act);
	}
	/**
	 * 爽约类型编码
	 * @return String
	 */
	public String getSd_bbrtp() {
		return ((String) getAttrVal("Sd_bbrtp"));
	}	
	/**
	 * 爽约类型编码
	 * @param Sd_bbrtp
	 */
	public void setSd_bbrtp(String Sd_bbrtp) {
		setAttrVal("Sd_bbrtp", Sd_bbrtp);
	}
}