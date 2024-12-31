package iih.mp.ot.dto.confirm.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技确认筛选条件 DTO数据 
 * 
 */
public class MpOtCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 开始日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}
	/**
	 * 结束日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
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
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 医嘱id集合
	 * @return FArrayList
	 */
	public FArrayList getId_ors() {
		return ((FArrayList) getAttrVal("Id_ors"));
	}
	/**
	 * 医嘱id集合
	 * @param Id_ors
	 */
	public void setId_ors(FArrayList Id_ors) {
		setAttrVal("Id_ors", Id_ors);
	}
	/**
	 * 执行科室id
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室id
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 开立科室id
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开立科室id
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开立科室名称
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开立科室名称
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 批量执行标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bat() {
		return ((FBoolean) getAttrVal("Fg_bat"));
	}
	/**
	 * 批量执行标识
	 * @param Fg_bat
	 */
	public void setFg_bat(FBoolean Fg_bat) {
		setAttrVal("Fg_bat", Fg_bat);
	}
	/**
	 * 补费数据未记账标识
	 * @return FBoolean
	 */
	public FBoolean getFg_unrecord() {
		return ((FBoolean) getAttrVal("Fg_unrecord"));
	}
	/**
	 * 补费数据未记账标识
	 * @param Fg_unrecord
	 */
	public void setFg_unrecord(FBoolean Fg_unrecord) {
		setAttrVal("Fg_unrecord", Fg_unrecord);
	}
}