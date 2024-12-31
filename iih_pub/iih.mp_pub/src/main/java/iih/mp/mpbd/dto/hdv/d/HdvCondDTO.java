package iih.mp.mpbd.dto.hdv.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 查询条件DTO DTO数据 
 * 
 */
public class HdvCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者体征id
	 * @return String
	 */
	public String getId_tagt() {
		return ((String) getAttrVal("Id_tagt"));
	}
	/**
	 * 患者体征id
	 * @param Id_tagt
	 */
	public void setId_tagt(String Id_tagt) {
		setAttrVal("Id_tagt", Id_tagt);
	}
	/**
	 * 患者体征编码
	 * @return String
	 */
	public String getCode_tagt() {
		return ((String) getAttrVal("Code_tagt"));
	}
	/**
	 * 患者体征编码
	 * @param Code_tagt
	 */
	public void setCode_tagt(String Code_tagt) {
		setAttrVal("Code_tagt", Code_tagt);
	}
	/**
	 * 患者体征名称
	 * @return String
	 */
	public String getName_tagt() {
		return ((String) getAttrVal("Name_tagt"));
	}
	/**
	 * 患者体征名称
	 * @param Name_tagt
	 */
	public void setName_tagt(String Name_tagt) {
		setAttrVal("Name_tagt", Name_tagt);
	}
	/**
	 * 日期
	 * @return FDate
	 */
	public FDate getDt_entry() {
		return ((FDate) getAttrVal("Dt_entry"));
	}
	/**
	 * 日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDate Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 班次id
	 * @return String
	 */
	public String getId_hdv_def() {
		return ((String) getAttrVal("Id_hdv_def"));
	}
	/**
	 * 班次id
	 * @param Id_hdv_def
	 */
	public void setId_hdv_def(String Id_hdv_def) {
		setAttrVal("Id_hdv_def", Id_hdv_def);
	}
	/**
	 * 班次名称
	 * @return String
	 */
	public String getName_hdv_def() {
		return ((String) getAttrVal("Name_hdv_def"));
	}
	/**
	 * 班次名称
	 * @param Name_hdv_def
	 */
	public void setName_hdv_def(String Name_hdv_def) {
		setAttrVal("Name_hdv_def", Name_hdv_def);
	}
}