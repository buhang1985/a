package iih.mp.nr.dto.signshoriz.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 测量条件 DTO数据 
 * 
 */
public class SignsCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 测量项目id
	 * @return String
	 */
	public String getId_itm() {
		return ((String) getAttrVal("Id_itm"));
	}
	/**
	 * 测量项目id
	 * @param Id_itm
	 */
	public void setId_itm(String Id_itm) {
		setAttrVal("Id_itm", Id_itm);
	}
	/**
	 * 测量项目编码
	 * @return String
	 */
	public String getSd_itm() {
		return ((String) getAttrVal("Sd_itm"));
	}
	/**
	 * 测量项目编码
	 * @param Sd_itm
	 */
	public void setSd_itm(String Sd_itm) {
		setAttrVal("Sd_itm", Sd_itm);
	}
	/**
	 * 测量项目名称
	 * @return String
	 */
	public String getName_itm() {
		return ((String) getAttrVal("Name_itm"));
	}
	/**
	 * 测量项目名称
	 * @param Name_itm
	 */
	public void setName_itm(String Name_itm) {
		setAttrVal("Name_itm", Name_itm);
	}
	/**
	 * 患者分类id
	 * @return String
	 */
	public String getId_vspatcas() {
		return ((String) getAttrVal("Id_vspatcas"));
	}
	/**
	 * 患者分类id
	 * @param Id_vspatcas
	 */
	public void setId_vspatcas(String Id_vspatcas) {
		setAttrVal("Id_vspatcas", Id_vspatcas);
	}
	/**
	 * 患者分类编码
	 * @return String
	 */
	public String getSd_vspatcas() {
		return ((String) getAttrVal("Sd_vspatcas"));
	}
	/**
	 * 患者分类编码
	 * @param Sd_vspatcas
	 */
	public void setSd_vspatcas(String Sd_vspatcas) {
		setAttrVal("Sd_vspatcas", Sd_vspatcas);
	}
	/**
	 * 患者分类名称
	 * @return String
	 */
	public String getName_vspatcas() {
		return ((String) getAttrVal("Name_vspatcas"));
	}
	/**
	 * 患者分类名称
	 * @param Name_vspatcas
	 */
	public void setName_vspatcas(String Name_vspatcas) {
		setAttrVal("Name_vspatcas", Name_vspatcas);
	}
	/**
	 * 测量日期
	 * @return FDate
	 */
	public FDate getD_vt() {
		return ((FDate) getAttrVal("D_vt"));
	}
	/**
	 * 测量日期
	 * @param D_vt
	 */
	public void setD_vt(FDate D_vt) {
		setAttrVal("D_vt", D_vt);
	}
	/**
	 * 时间表id
	 * @return String
	 */
	public String getId_time_table() {
		return ((String) getAttrVal("Id_time_table"));
	}
	/**
	 * 时间表id
	 * @param Id_time_table
	 */
	public void setId_time_table(String Id_time_table) {
		setAttrVal("Id_time_table", Id_time_table);
	}
	/**
	 * 时间表名称
	 * @return String
	 */
	public String getName_time_table() {
		return ((String) getAttrVal("Name_time_table"));
	}
	/**
	 * 时间表名称
	 * @param Name_time_table
	 */
	public void setName_time_table(String Name_time_table) {
		setAttrVal("Name_time_table", Name_time_table);
	}
	/**
	 * 测量日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vt() {
		return ((FDateTime) getAttrVal("Dt_vt"));
	}
	/**
	 * 测量日期时间
	 * @param Dt_vt
	 */
	public void setDt_vt(FDateTime Dt_vt) {
		setAttrVal("Dt_vt", Dt_vt);
	}
	/**
	 * 测量时间
	 * @return String
	 */
	public String getT_vt() {
		return ((String) getAttrVal("T_vt"));
	}
	/**
	 * 测量时间
	 * @param T_vt
	 */
	public void setT_vt(String T_vt) {
		setAttrVal("T_vt", T_vt);
	}
}