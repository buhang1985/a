package iih.mp.nr.dto.splitrtn.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 最后生成时间回写 DTO数据 
 * 
 */
public class SplitWriteBackDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱项目ID
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱项目ID
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 唯一标识
	 * @return String
	 */
	public String getId_key() {
		return ((String) getAttrVal("Id_key"));
	}
	/**
	 * 唯一标识
	 * @param Id_orsrv
	 */
	public void setId_key(String Id_key) {
		setAttrVal("Id_key", Id_key);
	}
	/**
	 * 最后生成时间
	 * @return FDateTime
	 */
	public FDateTime getDt_last_bl() {
		return ((FDateTime) getAttrVal("Dt_last_bl"));
	}
	/**
	 * 最后生成时间
	 * @param Dt_last_bl
	 */
	public void setDt_last_bl(FDateTime Dt_last_bl) {
		setAttrVal("Dt_last_bl", Dt_last_bl);
	}
	/**
	 * 拆分类型
	 * @return String
	 */
	public String getSd_split() {
		return ((String) getAttrVal("Sd_split"));
	}
	/**
	 * 拆分类型
	 * @param Sd_split
	 */
	public void setSd_split(String Sd_split) {
		setAttrVal("Sd_split", Sd_split);
	}
	/**
	 * 时间戳
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 时间戳
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
}