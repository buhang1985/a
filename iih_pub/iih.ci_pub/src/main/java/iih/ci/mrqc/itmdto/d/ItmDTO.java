package iih.ci.mrqc.itmdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 质控项DTO DTO数据 
 * 
 */
public class ItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * DTO主键
	 * @return String
	 */
	public String getId_itmdto() {
		return ((String) getAttrVal("Id_itmdto"));
	}
	/**
	 * DTO主键
	 * @param Id_itmdto
	 */
	public void setId_itmdto(String Id_itmdto) {
		setAttrVal("Id_itmdto", Id_itmdto);
	}
	/**
	 * 质控项主键
	 * @return String
	 */
	public String getId_qa_itm() {
		return ((String) getAttrVal("Id_qa_itm"));
	}
	/**
	 * 质控项主键
	 * @param Id_qa_itm
	 */
	public void setId_qa_itm(String Id_qa_itm) {
		setAttrVal("Id_qa_itm", Id_qa_itm);
	}
	/**
	 * 质控要求
	 * @return String
	 */
	public String getReq() {
		return ((String) getAttrVal("Req"));
	}
	/**
	 * 质控要求
	 * @param Req
	 */
	public void setReq(String Req) {
		setAttrVal("Req", Req);
	}
	/**
	 * 扣分标准
	 * @return String
	 */
	public String getDeduct_des() {
		return ((String) getAttrVal("Deduct_des"));
	}
	/**
	 * 扣分标准
	 * @param Deduct_des
	 */
	public void setDeduct_des(String Deduct_des) {
		setAttrVal("Deduct_des", Deduct_des);
	}
	/**
	 * 自动质控标志
	 * @return FBoolean
	 */
	public FBoolean getFg_auto_qa() {
		return ((FBoolean) getAttrVal("Fg_auto_qa"));
	}
	/**
	 * 自动质控标志
	 * @param Fg_auto_qa
	 */
	public void setFg_auto_qa(FBoolean Fg_auto_qa) {
		setAttrVal("Fg_auto_qa", Fg_auto_qa);
	}
	/**
	 * 缺陷表主键
	 * @return String
	 */
	public String getId_qa_flt() {
		return ((String) getAttrVal("Id_qa_flt"));
	}
	/**
	 * 缺陷表主键
	 * @param Id_qa_flt
	 */
	public void setId_qa_flt(String Id_qa_flt) {
		setAttrVal("Id_qa_flt", Id_qa_flt);
	}
	/**
	 * 缺陷扣分次数
	 * @return Integer
	 */
	public Integer getDeduct_scr_times() {
		return ((Integer) getAttrVal("Deduct_scr_times"));
	}
	/**
	 * 缺陷扣分次数
	 * @param Deduct_scr_times
	 */
	public void setDeduct_scr_times(Integer Deduct_scr_times) {
		setAttrVal("Deduct_scr_times", Deduct_scr_times);
	}
	/**
	 * 单次扣分值
	 * @return FDouble
	 */
	public FDouble getOnce_drp_scr() {
		return ((FDouble) getAttrVal("Once_drp_scr"));
	}
	/**
	 * 单次扣分值
	 * @param Once_drp_scr
	 */
	public void setOnce_drp_scr(FDouble Once_drp_scr) {
		setAttrVal("Once_drp_scr", Once_drp_scr);
	}
	/**
	 * 最大扣分值
	 * @return FDouble
	 */
	public FDouble getMax_drp_scr() {
		return ((FDouble) getAttrVal("Max_drp_scr"));
	}
	/**
	 * 最大扣分值
	 * @param Max_drp_scr
	 */
	public void setMax_drp_scr(FDouble Max_drp_scr) {
		setAttrVal("Max_drp_scr", Max_drp_scr);
	}
	/**
	 * 扣分类型id
	 * @return String
	 */
	public String getId_qa_drp_scr_tp() {
		return ((String) getAttrVal("Id_qa_drp_scr_tp"));
	}
	/**
	 * 扣分类型id
	 * @param Id_qa_drp_scr_tp
	 */
	public void setId_qa_drp_scr_tp(String Id_qa_drp_scr_tp) {
		setAttrVal("Id_qa_drp_scr_tp", Id_qa_drp_scr_tp);
	}
	/**
	 * 缺陷分类id
	 * @return String
	 */
	public String getId_fst_itm() {
		return ((String) getAttrVal("Id_fst_itm"));
	}
	/**
	 * 缺陷分类id
	 * @param Id_fst_itm
	 */
	public void setId_fst_itm(String Id_fst_itm) {
		setAttrVal("Id_fst_itm", Id_fst_itm);
	}
	/**
	 * 缺陷分类
	 * @return String
	 */
	public String getName_fst_itm() {
		return ((String) getAttrVal("Name_fst_itm"));
	}
	/**
	 * 缺陷分类
	 * @param Name_fst_itm
	 */
	public void setName_fst_itm(String Name_fst_itm) {
		setAttrVal("Name_fst_itm", Name_fst_itm);
	}
	/**
	 * 重度缺陷标志
	 * @return FBoolean
	 */
	public FBoolean getFg_serious() {
		return ((FBoolean) getAttrVal("Fg_serious"));
	}
	/**
	 * 重度缺陷标志
	 * @param Fg_serious
	 */
	public void setFg_serious(FBoolean Fg_serious) {
		setAttrVal("Fg_serious", Fg_serious);
	}
	/**
	 * 扣分理由
	 * @return String
	 */
	public String getDrp_des() {
		return ((String) getAttrVal("Drp_des"));
	}
	/**
	 * 扣分理由
	 * @param Drp_des
	 */
	public void setDrp_des(String Drp_des) {
		setAttrVal("Drp_des", Drp_des);
	}
	/**
	 * 扣分值
	 * @return String
	 */
	public String getDropscore() {
		return ((String) getAttrVal("Dropscore"));
	}
	/**
	 * 扣分值
	 * @param Dropscore
	 */
	public void setDropscore(String Dropscore) {
		setAttrVal("Dropscore", Dropscore);
	}
	/**
	 * 必须修复标志
	 * @return FBoolean
	 */
	public FBoolean getFg_repair() {
		return ((FBoolean) getAttrVal("Fg_repair"));
	}
	/**
	 * 必须修复标志
	 * @param Fg_repair
	 */
	public void setFg_repair(FBoolean Fg_repair) {
		setAttrVal("Fg_repair", Fg_repair);
	}
	/**
	 * 质控项序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 质控项序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 扣分类型sd
	 * @return String
	 */
	public String getSd_qa_drp_scr_tp() {
		return ((String) getAttrVal("Sd_qa_drp_scr_tp"));
	}
	/**
	 * 扣分类型sd
	 * @param Sd_qa_drp_scr_tp
	 */
	public void setSd_qa_drp_scr_tp(String Sd_qa_drp_scr_tp) {
		setAttrVal("Sd_qa_drp_scr_tp", Sd_qa_drp_scr_tp);
	}
	/**
	 * 实际扣分值
	 * @return FDouble
	 */
	public FDouble getReal_score() {
		return ((FDouble) getAttrVal("Real_score"));
	}
	/**
	 * 实际扣分值
	 * @param Real_score
	 */
	public void setReal_score(FDouble Real_score) {
		setAttrVal("Real_score", Real_score);
	}
}