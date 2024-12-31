package iih.mp.nr.dto.batchvs.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体征批量采集卡 DTO数据 
 * 
 */
public class VsBatchCardDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 测量日期
	 * @return FDate
	 */
	public FDate getDt_date() {
		return ((FDate) getAttrVal("Dt_date"));
	}
	/**
	 * 测量日期
	 * @param Dt_date
	 */
	public void setDt_date(FDate Dt_date) {
		setAttrVal("Dt_date", Dt_date);
	}
	/**
	 * 测量时间ID
	 * @return String
	 */
	public String getId_times() {
		return ((String) getAttrVal("Id_times"));
	}
	/**
	 * 测量时间ID
	 * @param Id_times
	 */
	public void setId_times(String Id_times) {
		setAttrVal("Id_times", Id_times);
	}
	/**
	 * 测量时间编码
	 * @return String
	 */
	public String getSd_times() {
		return ((String) getAttrVal("Sd_times"));
	}
	/**
	 * 测量时间编码
	 * @param Sd_times
	 */
	public void setSd_times(String Sd_times) {
		setAttrVal("Sd_times", Sd_times);
	}
	/**
	 * 测量时间名称
	 * @return String
	 */
	public String getName_times() {
		return ((String) getAttrVal("Name_times"));
	}
	/**
	 * 测量时间名称
	 * @param Name_times
	 */
	public void setName_times(String Name_times) {
		setAttrVal("Name_times", Name_times);
	}
	/**
	 * 测量时间
	 * @return String
	 */
	public String getDt_vts() {
		return ((String) getAttrVal("Dt_vts"));
	}
	/**
	 * 测量时间
	 * @param Dt_vts
	 */
	public void setDt_vts(String Dt_vts) {
		setAttrVal("Dt_vts", Dt_vts);
	}
	/**
	 * 患者过滤条件ID
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 患者过滤条件ID
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 患者过滤条件编码
	 * @return String
	 */
	public String getSd_patca() {
		return ((String) getAttrVal("Sd_patca"));
	}
	/**
	 * 患者过滤条件编码
	 * @param Sd_patca
	 */
	public void setSd_patca(String Sd_patca) {
		setAttrVal("Sd_patca", Sd_patca);
	}
	/**
	 * 患者过滤条件名称
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}
	/**
	 * 患者过滤条件名称
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
}