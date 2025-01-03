package iih.mp.nr.dto.batchvs.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 水平体征采集单元格 DTO数据 
 * 
 */
public class VsHrzRowCellDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体征测量属性ID
	 * @return String
	 */
	public String getId_mr_vs_itm() {
		return ((String) getAttrVal("Id_mr_vs_itm"));
	}
	/**
	 * 体征测量属性ID
	 * @param Id_mr_vs_itm
	 */
	public void setId_mr_vs_itm(String Id_mr_vs_itm) {
		setAttrVal("Id_mr_vs_itm", Id_mr_vs_itm);
	}
	/**
	 * 体征测量ID
	 * @return String
	 */
	public String getId_mr_vs() {
		return ((String) getAttrVal("Id_mr_vs"));
	}
	/**
	 * 体征测量ID
	 * @param Id_mr_vs
	 */
	public void setId_mr_vs(String Id_mr_vs) {
		setAttrVal("Id_mr_vs", Id_mr_vs);
	}
	/**
	 * 模板ID
	 * @return String
	 */
	public String getId_mrtpl_vst() {
		return ((String) getAttrVal("Id_mrtpl_vst"));
	}
	/**
	 * 模板ID
	 * @param Id_mrtpl_vst
	 */
	public void setId_mrtpl_vst(String Id_mrtpl_vst) {
		setAttrVal("Id_mrtpl_vst", Id_mrtpl_vst);
	}
	/**
	 * 测量项目ID
	 * @return String
	 */
	public String getId_mrtpl_vs() {
		return ((String) getAttrVal("Id_mrtpl_vs"));
	}
	/**
	 * 测量项目ID
	 * @param Id_mrtpl_vs
	 */
	public void setId_mrtpl_vs(String Id_mrtpl_vs) {
		setAttrVal("Id_mrtpl_vs", Id_mrtpl_vs);
	}
	/**
	 * 测量项目名称
	 * @return String
	 */
	public String getName_mrtpl_vs() {
		return ((String) getAttrVal("Name_mrtpl_vs"));
	}
	/**
	 * 测量项目名称
	 * @param Name_mrtpl_vs
	 */
	public void setName_mrtpl_vs(String Name_mrtpl_vs) {
		setAttrVal("Name_mrtpl_vs", Name_mrtpl_vs);
	}
	/**
	 * 测量属性ID
	 * @return String
	 */
	public String getId_mrtpl_vs_itm() {
		return ((String) getAttrVal("Id_mrtpl_vs_itm"));
	}
	/**
	 * 测量属性ID
	 * @param Id_mrtpl_vs_itm
	 */
	public void setId_mrtpl_vs_itm(String Id_mrtpl_vs_itm) {
		setAttrVal("Id_mrtpl_vs_itm", Id_mrtpl_vs_itm);
	}
	/**
	 * 测量属性名称
	 * @return String
	 */
	public String getName_mrtpl_vs_itm() {
		return ((String) getAttrVal("Name_mrtpl_vs_itm"));
	}
	/**
	 * 测量属性名称
	 * @param Name_mrtpl_vs_itm
	 */
	public void setName_mrtpl_vs_itm(String Name_mrtpl_vs_itm) {
		setAttrVal("Name_mrtpl_vs_itm", Name_mrtpl_vs_itm);
	}
	/**
	 * 数据类型
	 * @return String
	 */
	public String getSd_datatp() {
		return ((String) getAttrVal("Sd_datatp"));
	}
	/**
	 * 数据类型
	 * @param Sd_datatp
	 */
	public void setSd_datatp(String Sd_datatp) {
		setAttrVal("Sd_datatp", Sd_datatp);
	}
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 属性名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 属性名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 值
	 * @return String
	 */
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}
	/**
	 * 值
	 * @param Value
	 */
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * ID值
	 * @return String
	 */
	public String getId_value() {
		return ((String) getAttrVal("Id_value"));
	}
	/**
	 * ID值
	 * @param Id_value
	 */
	public void setId_value(String Id_value) {
		setAttrVal("Id_value", Id_value);
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
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 测量时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vt() {
		return ((FDateTime) getAttrVal("Dt_vt"));
	}
	/**
	 * 测量时间
	 * @param Dt_vt
	 */
	public void setDt_vt(FDateTime Dt_vt) {
		setAttrVal("Dt_vt", Dt_vt);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getSd_vspatcas() {
		return ((String) getAttrVal("Sd_vspatcas"));
	}
	/**
	 * 患者分类
	 * @param Sd_vspatcas
	 */
	public void setSd_vspatcas(String Sd_vspatcas) {
		setAttrVal("Sd_vspatcas", Sd_vspatcas);
	}
	/**
	 * 采集人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 采集人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
}