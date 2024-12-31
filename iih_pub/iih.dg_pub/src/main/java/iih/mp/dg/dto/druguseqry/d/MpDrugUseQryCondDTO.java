package iih.mp.dg.dto.druguseqry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 用药查询条件 DTO数据 
 * 
 */
public class MpDrugUseQryCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 护理病区id
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 护理病区id
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 药品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 在院患者id
	 * @return String
	 */
	public String getId_pat_in() {
		return ((String) getAttrVal("Id_pat_in"));
	}
	/**
	 * 在院患者id
	 * @param Id_pat_in
	 */
	public void setId_pat_in(String Id_pat_in) {
		setAttrVal("Id_pat_in", Id_pat_in);
	}
	/**
	 * 在院患者姓名
	 * @return String
	 */
	public String getName_pat_in() {
		return ((String) getAttrVal("Name_pat_in"));
	}
	/**
	 * 在院患者姓名
	 * @param Name_pat_in
	 */
	public void setName_pat_in(String Name_pat_in) {
		setAttrVal("Name_pat_in", Name_pat_in);
	}
	/**
	 * 在院就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 在院就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 出院患者id
	 * @return String
	 */
	public String getId_pat_out() {
		return ((String) getAttrVal("Id_pat_out"));
	}
	/**
	 * 出院患者id
	 * @param Id_pat_out
	 */
	public void setId_pat_out(String Id_pat_out) {
		setAttrVal("Id_pat_out", Id_pat_out);
	}
	/**
	 * 出院患者姓名
	 * @return String
	 */
	public String getName_pat_out() {
		return ((String) getAttrVal("Name_pat_out"));
	}
	/**
	 * 出院患者姓名
	 * @param Name_pat_out
	 */
	public void setName_pat_out(String Name_pat_out) {
		setAttrVal("Name_pat_out", Name_pat_out);
	}
	/**
	 * 药房id
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}
	/**
	 * 药房id
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 * 药房名称
	 * @return String
	 */
	public String getName_dep_wh() {
		return ((String) getAttrVal("Name_dep_wh"));
	}
	/**
	 * 药房名称
	 * @param Name_dep_wh
	 */
	public void setName_dep_wh(String Name_dep_wh) {
		setAttrVal("Name_dep_wh", Name_dep_wh);
	}
	/**
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 单位id
	 * @return String
	 */
	public String getId_unit_pkg() {
		return ((String) getAttrVal("Id_unit_pkg"));
	}
	/**
	 * 单位id
	 * @param Id_unit_pkg
	 */
	public void setId_unit_pkg(String Id_unit_pkg) {
		setAttrVal("Id_unit_pkg", Id_unit_pkg);
	}
}