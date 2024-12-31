package iih.mp.nr.dto.ordexetatus.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 执行计划上一级闭环状态 DTO数据 
 * 
 */
public class PrePlanOrpltpstaDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 执行计划主键
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 执行计划主键
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 上一级级闭环状态id
	 * @return String
	 */
	public String getId_preorpltpsta() {
		return ((String) getAttrVal("Id_preorpltpsta"));
	}
	/**
	 * 上一级级闭环状态id
	 * @param Id_preorpltpsta
	 */
	public void setId_preorpltpsta(String Id_preorpltpsta) {
		setAttrVal("Id_preorpltpsta", Id_preorpltpsta);
	}
	/**
	 * 上一级闭环状态名称
	 * @return String
	 */
	public String getName_preorpltpsta() {
		return ((String) getAttrVal("Name_preorpltpsta"));
	}
	/**
	 * 上一级闭环状态名称
	 * @param Name_preorpltpsta
	 */
	public void setName_preorpltpsta(String Name_preorpltpsta) {
		setAttrVal("Name_preorpltpsta", Name_preorpltpsta);
	}
	/**
	 * 上一级第三方状态对照码
	 * @return String
	 */
	public String getCode_prestatus() {
		return ((String) getAttrVal("Code_prestatus"));
	}
	/**
	 * 上一级第三方状态对照码
	 * @param Code_prestatus
	 */
	public void setCode_prestatus(String Code_prestatus) {
		setAttrVal("Code_prestatus", Code_prestatus);
	}
	/**
	 * displaynam20
	 * @return String
	 */
	public String getFun_precode() {
		return ((String) getAttrVal("Fun_precode"));
	}
	/**
	 * displaynam20
	 * @param Fun_precode
	 */
	public void setFun_precode(String Fun_precode) {
		setAttrVal("Fun_precode", Fun_precode);
	}
	/**
	 * 上一级闭环状态序号
	 * @return String
	 */
	public String getSortno_preorpltpsta() {
		return ((String) getAttrVal("Sortno_preorpltpsta"));
	}
	/**
	 * 上一级闭环状态序号
	 * @param Sortno_preorpltpsta
	 */
	public void setSortno_preorpltpsta(String Sortno_preorpltpsta) {
		setAttrVal("Sortno_preorpltpsta", Sortno_preorpltpsta);
	}
	/**
	 * 上一级闭环状态取消标识
	 * @return FBoolean
	 */
	public FBoolean getFg_precancelable() {
		return ((FBoolean) getAttrVal("Fg_precancelable"));
	}
	/**
	 * 上一级闭环状态取消标识
	 * @param Fg_precancelable
	 */
	public void setFg_precancelable(FBoolean Fg_precancelable) {
		setAttrVal("Fg_precancelable", Fg_precancelable);
	}
	/**
	 * 上一级闭环状态退费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_prefeertnable() {
		return ((FBoolean) getAttrVal("Fg_prefeertnable"));
	}
	/**
	 * 上一级闭环状态退费标识
	 * @param Fg_prefeertnable
	 */
	public void setFg_prefeertnable(FBoolean Fg_prefeertnable) {
		setAttrVal("Fg_prefeertnable", Fg_prefeertnable);
	}
	/**
	 * 上一级闭环状态患者标识
	 * @return FBoolean
	 */
	public FBoolean getFg_preneedpat() {
		return ((FBoolean) getAttrVal("Fg_preneedpat"));
	}
	/**
	 * 上一级闭环状态患者标识
	 * @param Fg_preneedpat
	 */
	public void setFg_preneedpat(FBoolean Fg_preneedpat) {
		setAttrVal("Fg_preneedpat", Fg_preneedpat);
	}
	/**
	 * 上一级闭环状态计费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_precharge() {
		return ((FBoolean) getAttrVal("Fg_precharge"));
	}
	/**
	 * 上一级闭环状态计费标识
	 * @param Fg_precharge
	 */
	public void setFg_precharge(FBoolean Fg_precharge) {
		setAttrVal("Fg_precharge", Fg_precharge);
	}
	/**
	 * 当前闭环状态id
	 * @return String
	 */
	public String getId_orpltpsta() {
		return ((String) getAttrVal("Id_orpltpsta"));
	}
	/**
	 * 当前闭环状态id
	 * @param Id_orpltpsta
	 */
	public void setId_orpltpsta(String Id_orpltpsta) {
		setAttrVal("Id_orpltpsta", Id_orpltpsta);
	}
	/**
	 * 当前闭环状态
	 * @return String
	 */
	public String getName_orpltpsta() {
		return ((String) getAttrVal("Name_orpltpsta"));
	}
	/**
	 * 当前闭环状态
	 * @param Name_orpltpsta
	 */
	public void setName_orpltpsta(String Name_orpltpsta) {
		setAttrVal("Name_orpltpsta", Name_orpltpsta);
	}
	/**
	 * 当前闭环状态序号
	 * @return String
	 */
	public String getSortno_orpltpsta() {
		return ((String) getAttrVal("Sortno_orpltpsta"));
	}
	/**
	 * 当前闭环状态序号
	 * @param Sortno_orpltpsta
	 */
	public void setSortno_orpltpsta(String Sortno_orpltpsta) {
		setAttrVal("Sortno_orpltpsta", Sortno_orpltpsta);
	}
	/**
	 * 当前闭环状态取消标识
	 * @return FBoolean
	 */
	public FBoolean getFg_cancelable() {
		return ((FBoolean) getAttrVal("Fg_cancelable"));
	}
	/**
	 * 当前闭环状态取消标识
	 * @param Fg_cancelable
	 */
	public void setFg_cancelable(FBoolean Fg_cancelable) {
		setAttrVal("Fg_cancelable", Fg_cancelable);
	}
	/**
	 * 当前闭环状态退费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_feertnable() {
		return ((FBoolean) getAttrVal("Fg_feertnable"));
	}
	/**
	 * 当前闭环状态退费标识
	 * @param Fg_feertnable
	 */
	public void setFg_feertnable(FBoolean Fg_feertnable) {
		setAttrVal("Fg_feertnable", Fg_feertnable);
	}
	/**
	 * 当前闭环状态患者标识
	 * @return FBoolean
	 */
	public FBoolean getFg_needpat() {
		return ((FBoolean) getAttrVal("Fg_needpat"));
	}
	/**
	 * 当前闭环状态患者标识
	 * @param Fg_needpat
	 */
	public void setFg_needpat(FBoolean Fg_needpat) {
		setAttrVal("Fg_needpat", Fg_needpat);
	}
	/**
	 * 当前闭环状态计费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_charge() {
		return ((FBoolean) getAttrVal("Fg_charge"));
	}
	/**
	 * 当前闭环状态计费标识
	 * @param Fg_charge
	 */
	public void setFg_charge(FBoolean Fg_charge) {
		setAttrVal("Fg_charge", Fg_charge);
	}
	/**
	 * 功能节点编码
	 * @return String
	 */
	public String getFun_code() {
		return ((String) getAttrVal("Fun_code"));
	}
	/**
	 * 功能节点编码
	 * @param Fun_code
	 */
	public void setFun_code(String Fun_code) {
		setAttrVal("Fun_code", Fun_code);
	}
	/**
	 * 第三方状态对照码
	 * @return String
	 */
	public String getCode_status() {
		return ((String) getAttrVal("Code_status"));
	}
	/**
	 * 第三方状态对照码
	 * @param Code_status
	 */
	public void setCode_status(String Code_status) {
		setAttrVal("Code_status", Code_status);
	}
}