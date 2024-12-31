package iih.mp.ot.dto.techcharge.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技记账医嘱 DTO数据 
 * 
 */
public class TechOrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 执行计划ID
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 执行计划ID
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
	 * 申请单号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}
	/**
	 * 申请单号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 开始时间
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 截止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 截止时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plam() {
		return ((FDateTime) getAttrVal("Dt_mp_plam"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_mp_plam
	 */
	public void setDt_mp_plam(FDateTime Dt_mp_plam) {
		setAttrVal("Dt_mp_plam", Dt_mp_plam);
	}
	/**
	 * 长临
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}
	/**
	 * 就诊类型
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getName_dep_app() {
		return ((String) getAttrVal("Name_dep_app"));
	}
	/**
	 * 申请科室
	 * @param Name_dep_app
	 */
	public void setName_dep_app(String Name_dep_app) {
		setAttrVal("Name_dep_app", Name_dep_app);
	}
	/**
	 * 申请医生
	 * @return String
	 */
	public String getName_emp_app() {
		return ((String) getAttrVal("Name_emp_app"));
	}
	/**
	 * 申请医生
	 * @param Name_emp_app
	 */
	public void setName_emp_app(String Name_emp_app) {
		setAttrVal("Name_emp_app", Name_emp_app);
	}
	/**
	 * 申请日期
	 * @return FDateTime
	 */
	public FDateTime getDt_app() {
		return ((FDateTime) getAttrVal("Dt_app"));
	}
	/**
	 * 申请日期
	 * @param Dt_app
	 */
	public void setDt_app(FDateTime Dt_app) {
		setAttrVal("Dt_app", Dt_app);
	}
	/**
	 * 已记账标记
	 * @return FBoolean
	 */
	public FBoolean getFg_charged() {
		return ((FBoolean) getAttrVal("Fg_charged"));
	}
	/**
	 * 已记账标记
	 * @param Fg_charged
	 */
	public void setFg_charged(FBoolean Fg_charged) {
		setAttrVal("Fg_charged", Fg_charged);
	}
	/**
	 * 医嘱项目
	 * @return FArrayList
	 */
	public FArrayList getArrraysrv() {
		return ((FArrayList) getAttrVal("Arrraysrv"));
	}
	/**
	 * 医嘱项目
	 * @param Arrraysrv
	 */
	public void setArrraysrv(FArrayList Arrraysrv) {
		setAttrVal("Arrraysrv", Arrraysrv);
	}
}