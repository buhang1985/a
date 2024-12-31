package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊记账事件源DTO DTO数据 
 * 
 */
public class OpAcc4EsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 记账明细ID
	 * @return String
	 */
	public String getId_cgitmoep() {
		return ((String) getAttrVal("Id_cgitmoep"));
	}
	/**
	 * 记账明细ID
	 * @param Id_cgitmoep
	 */
	public void setId_cgitmoep(String Id_cgitmoep) {
		setAttrVal("Id_cgitmoep", Id_cgitmoep);
	}
	/**
	 * 记账ID
	 * @return String
	 */
	public String getId_cgoep() {
		return ((String) getAttrVal("Id_cgoep"));
	}
	/**
	 * 记账ID
	 * @param Id_cgoep
	 */
	public void setId_cgoep(String Id_cgoep) {
		setAttrVal("Id_cgoep", Id_cgoep);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getCode_apply() {
		return ((String) getAttrVal("Code_apply"));
	}
	/**
	 * 申请单号
	 * @param Code_apply
	 */
	public void setCode_apply(String Code_apply) {
		setAttrVal("Code_apply", Code_apply);
	}
	/**
	 * 申请单类型
	 * @return String
	 */
	public String getCode_applytp() {
		return ((String) getAttrVal("Code_applytp"));
	}
	/**
	 * 申请单类型
	 * @param Code_applytp
	 */
	public void setCode_applytp(String Code_applytp) {
		setAttrVal("Code_applytp", Code_applytp);
	}
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
	 * 处方ID
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方ID
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 医疗服务ID
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医疗服务ID
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 记账标志
	 * @return FBoolean
	 */
	public FBoolean getFg_acc() {
		return ((FBoolean) getAttrVal("Fg_acc"));
	}
	/**
	 * 记账标志
	 * @param Fg_acc
	 */
	public void setFg_acc(FBoolean Fg_acc) {
		setAttrVal("Fg_acc", Fg_acc);
	}
	/**
	 * 高端商保标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hpcg() {
		return ((FBoolean) getAttrVal("Fg_hpcg"));
	}
	/**
	 * 高端商保标志
	 * @param Fg_hpcg
	 */
	public void setFg_hpcg(FBoolean Fg_hpcg) {
		setAttrVal("Fg_hpcg", Fg_hpcg);
	}
	/**
	 * 减免标志
	 * @return FBoolean
	 */
	public FBoolean getFg_free() {
		return ((FBoolean) getAttrVal("Fg_free"));
	}
	/**
	 * 减免标志
	 * @param Fg_free
	 */
	public void setFg_free(FBoolean Fg_free) {
		setAttrVal("Fg_free", Fg_free);
	}
	/**
	 * 补费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_additm() {
		return ((FBoolean) getAttrVal("Fg_additm"));
	}
	/**
	 * 补费标识
	 * @param Fg_additm
	 */
	public void setFg_additm(FBoolean Fg_additm) {
		setAttrVal("Fg_additm", Fg_additm);
	}
	/**
	 * 就诊编号
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊编号
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
}