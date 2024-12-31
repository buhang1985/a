package iih.ci.mrfp.cimrsugdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 手术记录 DTO数据 
 * 
 */
public class CiMrSugDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊号
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊号
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 手术、操作编码
	 * @return String
	 */
	public String getSd_sug() {
		return ((String) getAttrVal("Sd_sug"));
	}
	/**
	 * 手术、操作编码
	 * @param Sd_sug
	 */
	public void setSd_sug(String Sd_sug) {
		setAttrVal("Sd_sug", Sd_sug);
	}
	/**
	 * 手术、操作名称
	 * @return String
	 */
	public String getName_sug() {
		return ((String) getAttrVal("Name_sug"));
	}
	/**
	 * 手术、操作名称
	 * @param Name_sug
	 */
	public void setName_sug(String Name_sug) {
		setAttrVal("Name_sug", Name_sug);
	}
	/**
	 * 手术、操作开始时间
	 * @return String
	 */
	public String getDt_start_sug() {
		return ((String) getAttrVal("Dt_start_sug"));
	}
	/**
	 * 手术、操作开始时间
	 * @param Dt_start_sug
	 */
	public void setDt_start_sug(String Dt_start_sug) {
		setAttrVal("Dt_start_sug", Dt_start_sug);
	}
	/**
	 * 手术、操作结束时间
	 * @return String
	 */
	public String getDt_end_sug() {
		return ((String) getAttrVal("Dt_end_sug"));
	}
	/**
	 * 手术、操作结束时间
	 * @param Dt_end_sug
	 */
	public void setDt_end_sug(String Dt_end_sug) {
		setAttrVal("Dt_end_sug", Dt_end_sug);
	}
}