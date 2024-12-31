package iih.ei.std.d.v1.mp.lisdata.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检验申请单信息 DTO数据 
 * 
 */
public class LabApDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
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
	 * 标本条码号
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}	
	/**
	 * 标本条码号
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 申请项目名称
	 * @return String
	 */
	public String getName_applyform() {
		return ((String) getAttrVal("Name_applyform"));
	}	
	/**
	 * 申请项目名称
	 * @param Name_applyform
	 */
	public void setName_applyform(String Name_applyform) {
		setAttrVal("Name_applyform", Name_applyform);
	}
	/**
	 * 申请单类别
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 申请单类别
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 申请单类别名称
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	/**
	 * 申请单类别名称
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	/**
	 * 加急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}	
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 标本类型
	 * @return String
	 */
	public String getName_samptp() {
		return ((String) getAttrVal("Name_samptp"));
	}	
	/**
	 * 标本类型
	 * @param Name_samptp
	 */
	public void setName_samptp(String Name_samptp) {
		setAttrVal("Name_samptp", Name_samptp);
	}
	/**
	 * 标本类型编码
	 * @return String
	 */
	public String getSd_samptp() {
		return ((String) getAttrVal("Sd_samptp"));
	}	
	/**
	 * 标本类型编码
	 * @param Sd_samptp
	 */
	public void setSd_samptp(String Sd_samptp) {
		setAttrVal("Sd_samptp", Sd_samptp);
	}
	/**
	 * 容器类型
	 * @return String
	 */
	public String getName_contp() {
		return ((String) getAttrVal("Name_contp"));
	}	
	/**
	 * 容器类型
	 * @param Name_contp
	 */
	public void setName_contp(String Name_contp) {
		setAttrVal("Name_contp", Name_contp);
	}
	/**
	 * 容器类型编码
	 * @return String
	 */
	public String getSd_contp() {
		return ((String) getAttrVal("Sd_contp"));
	}	
	/**
	 * 容器类型编码
	 * @param Sd_contp
	 */
	public void setSd_contp(String Sd_contp) {
		setAttrVal("Sd_contp", Sd_contp);
	}
	/**
	 * 采集方法
	 * @return String
	 */
	public String getName_colltp() {
		return ((String) getAttrVal("Name_colltp"));
	}	
	/**
	 * 采集方法
	 * @param Name_colltp
	 */
	public void setName_colltp(String Name_colltp) {
		setAttrVal("Name_colltp", Name_colltp);
	}
	/**
	 * 采集 方法编码
	 * @return String
	 */
	public String getSd_colltp() {
		return ((String) getAttrVal("Sd_colltp"));
	}	
	/**
	 * 采集 方法编码
	 * @param Sd_colltp
	 */
	public void setSd_colltp(String Sd_colltp) {
		setAttrVal("Sd_colltp", Sd_colltp);
	}
	/**
	 * 标本说明
	 * @return String
	 */
	public String getDes_labsamp() {
		return ((String) getAttrVal("Des_labsamp"));
	}	
	/**
	 * 标本说明
	 * @param Des_labsamp
	 */
	public void setDes_labsamp(String Des_labsamp) {
		setAttrVal("Des_labsamp", Des_labsamp);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getCode_dep_app() {
		return ((String) getAttrVal("Code_dep_app"));
	}	
	/**
	 * 申请科室
	 * @param Code_dep_app
	 */
	public void setCode_dep_app(String Code_dep_app) {
		setAttrVal("Code_dep_app", Code_dep_app);
	}
	/**
	 * 申请科室名称
	 * @return String
	 */
	public String getName_dep_app() {
		return ((String) getAttrVal("Name_dep_app"));
	}	
	/**
	 * 申请科室名称
	 * @param Name_dep_app
	 */
	public void setName_dep_app(String Name_dep_app) {
		setAttrVal("Name_dep_app", Name_dep_app);
	}
	/**
	 * 申请医生名称
	 * @return String
	 */
	public String getName_emp_app() {
		return ((String) getAttrVal("Name_emp_app"));
	}	
	/**
	 * 申请医生名称
	 * @param Name_emp_app
	 */
	public void setName_emp_app(String Name_emp_app) {
		setAttrVal("Name_emp_app", Name_emp_app);
	}
	/**
	 * 申请医生编码
	 * @return String
	 */
	public String getCode_emp_app() {
		return ((String) getAttrVal("Code_emp_app"));
	}	
	/**
	 * 申请医生编码
	 * @param Code_emp_app
	 */
	public void setCode_emp_app(String Code_emp_app) {
		setAttrVal("Code_emp_app", Code_emp_app);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_app() {
		return ((FDateTime) getAttrVal("Dt_app"));
	}	
	/**
	 * 申请时间
	 * @param Dt_app
	 */
	public void setDt_app(FDateTime Dt_app) {
		setAttrVal("Dt_app", Dt_app);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getCode_dep_mp() {
		return ((String) getAttrVal("Code_dep_mp"));
	}	
	/**
	 * 执行科室编码
	 * @param Code_dep_mp
	 */
	public void setCode_dep_mp(String Code_dep_mp) {
		setAttrVal("Code_dep_mp", Code_dep_mp);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}	
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 申请备注
	 * @return String
	 */
	public String getNote_app() {
		return ((String) getAttrVal("Note_app"));
	}	
	/**
	 * 申请备注
	 * @param Note_app
	 */
	public void setNote_app(String Note_app) {
		setAttrVal("Note_app", Note_app);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 项目编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 收费金额
	 * @return FDouble
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}	
	/**
	 * 收费金额
	 * @param Pri
	 */
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	/**
	 * 申请项目明细
	 * @return String
	 */
	public FArrayList getLabitemdto() {
		return ((FArrayList) getAttrVal("Labitemdto"));
	}	
	/**
	 * 申请项目明细
	 * @param Labitemdto
	 */
	public void setLabitemdto(FArrayList Labitemdto) {
		setAttrVal("Labitemdto", Labitemdto);
	}
}