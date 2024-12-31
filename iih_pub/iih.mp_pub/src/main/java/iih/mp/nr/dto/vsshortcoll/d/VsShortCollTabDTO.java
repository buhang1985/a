package iih.mp.nr.dto.vsshortcoll.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体征快捷采集Tab数据源 DTO数据 
 * 
 */
public class VsShortCollTabDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 采集ID
	 * @return String
	 */
	public String getId_mr_vs() {
		return ((String) getAttrVal("Id_mr_vs"));
	}
	/**
	 * 采集ID
	 * @param Id_mr_vs
	 */
	public void setId_mr_vs(String Id_mr_vs) {
		setAttrVal("Id_mr_vs", Id_mr_vs);
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
	 * 采集时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vt() {
		return ((FDateTime) getAttrVal("Dt_vt"));
	}
	/**
	 * 采集时间
	 * @param Dt_vt
	 */
	public void setDt_vt(FDateTime Dt_vt) {
		setAttrVal("Dt_vt", Dt_vt);
	}
	/**
	 * 测量日期
	 * @return String
	 */
	public String getDt_date() {
		return ((String) getAttrVal("Dt_date"));
	}
	/**
	 * 测量日期
	 * @param Dt_date
	 */
	public void setDt_date(String Dt_date) {
		setAttrVal("Dt_date", Dt_date);
	}
	/**
	 * 测量时间
	 * @return String
	 */
	public String getDt_time() {
		return ((String) getAttrVal("Dt_time"));
	}
	/**
	 * 测量时间
	 * @param Dt_time
	 */
	public void setDt_time(String Dt_time) {
		setAttrVal("Dt_time", Dt_time);
	}
	/**
	 * 显示文本
	 * @return String
	 */
	public String getText() {
		return ((String) getAttrVal("Text"));
	}
	/**
	 * 显示文本
	 * @param Text
	 */
	public void setText(String Text) {
		setAttrVal("Text", Text);
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
	 * 采集人姓名
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 采集人姓名
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 是否允许删除
	 * @return FBoolean
	 */
	public FBoolean getFg_delete() {
		return ((FBoolean) getAttrVal("Fg_delete"));
	}
	/**
	 * 是否允许删除
	 * @param Fg_delete
	 */
	public void setFg_delete(FBoolean Fg_delete) {
		setAttrVal("Fg_delete", Fg_delete);
	}
	/**
	 * 是否加测
	 * @return FBoolean
	 */
	public FBoolean getFg_add() {
		return ((FBoolean) getAttrVal("Fg_add"));
	}
	/**
	 * 是否加测
	 * @param Fg_add
	 */
	public void setFg_add(FBoolean Fg_add) {
		setAttrVal("Fg_add", Fg_add);
	}
	/**
	 * 体征数据
	 * @return FArrayList
	 */
	public FArrayList getArrayrows() {
		return ((FArrayList) getAttrVal("Arrayrows"));
	}
	/**
	 * 体征数据
	 * @param Arrayrows
	 */
	public void setArrayrows(FArrayList Arrayrows) {
		setAttrVal("Arrayrows", Arrayrows);
	}
}