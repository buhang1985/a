package iih.ci.mrfp.cimrfpdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病案首页西医诊断 DTO数据 
 * 
 */
public class CiMrFpXYDIDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病案ID
	 * @return String
	 */
	public String getId_mrfp() {
		return ((String) getAttrVal("Id_mrfp"));
	}
	/**
	 * 病案ID
	 * @param Id_mrfp
	 */
	public void setId_mrfp(String Id_mrfp) {
		setAttrVal("Id_mrfp", Id_mrfp);
	}
	/**
	 * 住院病历首页西医诊断ID
	 * @return String
	 */
	public String getId_mrfpxydi() {
		return ((String) getAttrVal("Id_mrfpxydi"));
	}
	/**
	 * 住院病历首页西医诊断ID
	 * @param Id_mrfpxydi
	 */
	public void setId_mrfpxydi(String Id_mrfpxydi) {
		setAttrVal("Id_mrfpxydi", Id_mrfpxydi);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 疾病诊断
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 疾病诊断
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 疾病诊断编码
	 * @return String
	 */
	public String getSd_di() {
		return ((String) getAttrVal("Sd_di"));
	}
	/**
	 * 疾病诊断编码
	 * @param Sd_di
	 */
	public void setSd_di(String Sd_di) {
		setAttrVal("Sd_di", Sd_di);
	}
	/**
	 * 疾病诊断名称
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 疾病诊断名称
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 入院病情
	 * @return String
	 */
	public String getId_dislvl_inp() {
		return ((String) getAttrVal("Id_dislvl_inp"));
	}
	/**
	 * 入院病情
	 * @param Id_dislvl_inp
	 */
	public void setId_dislvl_inp(String Id_dislvl_inp) {
		setAttrVal("Id_dislvl_inp", Id_dislvl_inp);
	}
	/**
	 * 入院情况名称
	 * @return String
	 */
	public String getName_dislvl_inp() {
		return ((String) getAttrVal("Name_dislvl_inp"));
	}
	/**
	 * 入院情况名称
	 * @param Name_dislvl_inp
	 */
	public void setName_dislvl_inp(String Name_dislvl_inp) {
		setAttrVal("Name_dislvl_inp", Name_dislvl_inp);
	}
	/**
	 * 诊断类别
	 * @return String
	 */
	public String getId_di_type() {
		return ((String) getAttrVal("Id_di_type"));
	}
	/**
	 * 诊断类别
	 * @param Id_di_type
	 */
	public void setId_di_type(String Id_di_type) {
		setAttrVal("Id_di_type", Id_di_type);
	}
	/**
	 * 诊断类型编码
	 * @return String
	 */
	public String getSd_di_type() {
		return ((String) getAttrVal("Sd_di_type"));
	}
	/**
	 * 诊断类型编码
	 * @param Sd_di_type
	 */
	public void setSd_di_type(String Sd_di_type) {
		setAttrVal("Sd_di_type", Sd_di_type);
	}
	/**
	 * 诊断类型名称
	 * @return String
	 */
	public String getName_di_type() {
		return ((String) getAttrVal("Name_di_type"));
	}
	/**
	 * 诊断类型名称
	 * @param Name_di_type
	 */
	public void setName_di_type(String Name_di_type) {
		setAttrVal("Name_di_type", Name_di_type);
	}
	/**
	 * 诊断信息
	 * @return String
	 */
	public String getId_mrfpdi() {
		return ((String) getAttrVal("Id_mrfpdi"));
	}
	/**
	 * 诊断信息
	 * @param Id_mrfpdi
	 */
	public void setId_mrfpdi(String Id_mrfpdi) {
		setAttrVal("Id_mrfpdi", Id_mrfpdi);
	}
	/**
	 * 主诊断
	 * @return FBoolean
	 */
	public FBoolean getFg_maindi() {
		return ((FBoolean) getAttrVal("Fg_maindi"));
	}
	/**
	 * 主诊断
	 * @param Fg_maindi
	 */
	public void setFg_maindi(FBoolean Fg_maindi) {
		setAttrVal("Fg_maindi", Fg_maindi);
	}
	/**
	 * 版本
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 版本
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
	/**
	 * 治疗转归
	 * @return String
	 */
	public String getId_treatment_outcome() {
		return ((String) getAttrVal("Id_treatment_outcome"));
	}
	/**
	 * 治疗转归
	 * @param Id_treatment_outcome
	 */
	public void setId_treatment_outcome(String Id_treatment_outcome) {
		setAttrVal("Id_treatment_outcome", Id_treatment_outcome);
	}
	/**
	 * 治疗转归名称
	 * @return String
	 */
	public String getName_treatment_outcome() {
		return ((String) getAttrVal("Name_treatment_outcome"));
	}
	/**
	 * 治疗转归名称
	 * @param Name_treatment_outcome
	 */
	public void setName_treatment_outcome(String Name_treatment_outcome) {
		setAttrVal("Name_treatment_outcome", Name_treatment_outcome);
	}
	/**
	 * 治疗转归 编码
	 * @return String
	 */
	public String getSd_treatment_outcome() {
		return ((String) getAttrVal("Sd_treatment_outcome"));
	}
	/**
	 * 治疗转归 编码
	 * @param Sd_treatment_outcome
	 */
	public void setSd_treatment_outcome(String Sd_treatment_outcome) {
		setAttrVal("Sd_treatment_outcome", Sd_treatment_outcome);
	}
	/**
	 * 医保诊断主键
	 * @return String
	 */
	public String getId_hpdi() {
		return ((String) getAttrVal("Id_hpdi"));
	}
	/**
	 * 医保诊断主键
	 * @param Id_hpdi
	 */
	public void setId_hpdi(String Id_hpdi) {
		setAttrVal("Id_hpdi", Id_hpdi);
	}
	/**
	 * 医保诊断名称
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 医保诊断名称
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 医保诊断编码
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 医保诊断编码
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 诊断补充描述
	 * @return String
	 */
	public String getDiag_supp() {
		return ((String) getAttrVal("Diag_supp"));
	}
	/**
	 * 诊断补充描述
	 * @param Diag_supp
	 */
	public void setDiag_supp(String Diag_supp) {
		setAttrVal("Diag_supp", Diag_supp);
	}
}