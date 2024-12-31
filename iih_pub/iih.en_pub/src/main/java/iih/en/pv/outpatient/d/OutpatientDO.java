package iih.en.pv.outpatient.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.outpatient.d.desc.OutpatientDODesc;
import java.math.BigDecimal;

/**
 * 门诊属性 DO数据 
 * 
 */
public class OutpatientDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//门诊属性主键
	public static final String ID_OUTPATIENT= "Id_outpatient";
	//患者就诊主键
	public static final String ID_ENT= "Id_ent";
	//门诊档案号
	public static final String CODE_AMR_OEP= "Code_amr_oep";
	//就诊状态
	public static final String SD_STATUS= "Sd_status";
	//诊疗类型
	public static final String ID_SVRTP= "Id_svrtp";
	//诊疗类型编码
	public static final String SD_SVRTP= "Sd_svrtp";
	//对应挂号员
	public static final String ID_EMP_OPERATOR= "Id_emp_operator";
	//有效期限_开始
	public static final String DT_VALID_B= "Dt_valid_b";
	//有效期限_结束
	public static final String DT_VALID_E= "Dt_valid_e";
	//对应预约
	public static final String ID_SCHAPT= "Id_schapt";
	//对应排班
	public static final String ID_SCH= "Id_sch";
	//日期分组
	public static final String ID_DATESLOT= "Id_dateslot";
	//号段id
	public static final String ID_TICKS= "Id_ticks";
	//号位id
	public static final String ID_TICK= "Id_tick";
	//就诊排队号
	public static final String TICKETNO= "Ticketno";
	//排班资源
	public static final String ID_SCRES= "Id_scres";
	//排班服务
	public static final String ID_SCSRV= "Id_scsrv";
	//挂号科室id
	public static final String ID_DEP_REG= "Id_dep_reg";
	//挂号医生id
	public static final String ID_EMP_REG= "Id_emp_reg";
	//对应计费_挂号
	public static final String ID_CG_REG= "Id_cg_reg";
	//初诊标志
	public static final String FG_FIRST= "Fg_first";
	//已结算标志_挂号
	public static final String FG_CG= "Fg_cg";
	//对应结算_挂号
	public static final String ID_CG= "Id_cg";
	//转归
	public static final String ID_GOWHERE= "Id_gowhere";
	//转归编码
	public static final String SD_GOWHERE= "Sd_gowhere";
	//病情等级
	public static final String ID_LEVEL_DISE= "Id_level_dise";
	//病情等级编码
	public static final String SD_LEVEL_DISE= "Sd_level_dise";
	//需回诊标志
	public static final String FG_NEEDRTN= "Fg_needrtn";
	//挂号类型
	public static final String EU_REGTP= "Eu_regtp";
	//门诊次数
	public static final String TIMES_OP= "Times_op";
	//抢救标志
	public static final String FG_RESCUE= "Fg_rescue";
	//抢救次数
	public static final String TIMES_RESCUE= "Times_rescue";
	//抢救成功次数
	public static final String SUCC_RESCUE= "Succ_rescue";
	//预检状态
	public static final String EU_PREOBS= "Eu_preobs";
	//诊断记录发病日期
	public static final String DT_DI_MOR= "Dt_di_mor";
	//抢救打印次数
	public static final String TIMES_PRINT= "Times_print";
	//日期分组编码
	public static final String DAYSLOT_CODE= "Dayslot_code";
	//日期分组名称
	public static final String DAYSLOT_NAME= "Dayslot_name";
	//日期分组类型
	public static final String ID_DAYSLOTTP= "Id_dayslottp";
	//日期分组类型编码
	public static final String SD_DAYSLOTTP= "Sd_dayslottp";
	//资源编码
	public static final String SCRES_CODE= "Scres_code";
	//资源名称
	public static final String SCRES_NAME= "Scres_name";
	//排班服务编码
	public static final String SCSRV_CODE= "Scsrv_code";
	//排班服务名称
	public static final String SCSRV_NAME= "Scsrv_name";
	//挂号科室编码
	public static final String DEP_REG_CODE= "Dep_reg_code";
	//挂号科室名称
	public static final String DEP_REG_NAME= "Dep_reg_name";
	//挂号医生编码
	public static final String EMP_REG_CODE= "Emp_reg_code";
	//挂号医生姓名
	public static final String EMP_REG_NAME= "Emp_reg_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 门诊属性主键
	 * @return String
	 */
	public String getId_outpatient() {
		return ((String) getAttrVal("Id_outpatient"));
	}	
	/**
	 * 门诊属性主键
	 * @param Id_outpatient
	 */
	public void setId_outpatient(String Id_outpatient) {
		setAttrVal("Id_outpatient", Id_outpatient);
	}
	/**
	 * 患者就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 患者就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 门诊档案号
	 * @return String
	 */
	public String getCode_amr_oep() {
		return ((String) getAttrVal("Code_amr_oep"));
	}	
	/**
	 * 门诊档案号
	 * @param Code_amr_oep
	 */
	public void setCode_amr_oep(String Code_amr_oep) {
		setAttrVal("Code_amr_oep", Code_amr_oep);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 就诊状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 诊疗类型
	 * @return String
	 */
	public String getId_svrtp() {
		return ((String) getAttrVal("Id_svrtp"));
	}	
	/**
	 * 诊疗类型
	 * @param Id_svrtp
	 */
	public void setId_svrtp(String Id_svrtp) {
		setAttrVal("Id_svrtp", Id_svrtp);
	}
	/**
	 * 诊疗类型编码
	 * @return String
	 */
	public String getSd_svrtp() {
		return ((String) getAttrVal("Sd_svrtp"));
	}	
	/**
	 * 诊疗类型编码
	 * @param Sd_svrtp
	 */
	public void setSd_svrtp(String Sd_svrtp) {
		setAttrVal("Sd_svrtp", Sd_svrtp);
	}
	/**
	 * 对应挂号员
	 * @return String
	 */
	public String getId_emp_operator() {
		return ((String) getAttrVal("Id_emp_operator"));
	}	
	/**
	 * 对应挂号员
	 * @param Id_emp_operator
	 */
	public void setId_emp_operator(String Id_emp_operator) {
		setAttrVal("Id_emp_operator", Id_emp_operator);
	}
	/**
	 * 有效期限_开始
	 * @return FDateTime
	 */
	public FDateTime getDt_valid_b() {
		return ((FDateTime) getAttrVal("Dt_valid_b"));
	}	
	/**
	 * 有效期限_开始
	 * @param Dt_valid_b
	 */
	public void setDt_valid_b(FDateTime Dt_valid_b) {
		setAttrVal("Dt_valid_b", Dt_valid_b);
	}
	/**
	 * 有效期限_结束
	 * @return FDateTime
	 */
	public FDateTime getDt_valid_e() {
		return ((FDateTime) getAttrVal("Dt_valid_e"));
	}	
	/**
	 * 有效期限_结束
	 * @param Dt_valid_e
	 */
	public void setDt_valid_e(FDateTime Dt_valid_e) {
		setAttrVal("Dt_valid_e", Dt_valid_e);
	}
	/**
	 * 对应预约
	 * @return String
	 */
	public String getId_schapt() {
		return ((String) getAttrVal("Id_schapt"));
	}	
	/**
	 * 对应预约
	 * @param Id_schapt
	 */
	public void setId_schapt(String Id_schapt) {
		setAttrVal("Id_schapt", Id_schapt);
	}
	/**
	 * 对应排班
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}	
	/**
	 * 对应排班
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 日期分组
	 * @return String
	 */
	public String getId_dateslot() {
		return ((String) getAttrVal("Id_dateslot"));
	}	
	/**
	 * 日期分组
	 * @param Id_dateslot
	 */
	public void setId_dateslot(String Id_dateslot) {
		setAttrVal("Id_dateslot", Id_dateslot);
	}
	/**
	 * 号段id
	 * @return String
	 */
	public String getId_ticks() {
		return ((String) getAttrVal("Id_ticks"));
	}	
	/**
	 * 号段id
	 * @param Id_ticks
	 */
	public void setId_ticks(String Id_ticks) {
		setAttrVal("Id_ticks", Id_ticks);
	}
	/**
	 * 号位id
	 * @return String
	 */
	public String getId_tick() {
		return ((String) getAttrVal("Id_tick"));
	}	
	/**
	 * 号位id
	 * @param Id_tick
	 */
	public void setId_tick(String Id_tick) {
		setAttrVal("Id_tick", Id_tick);
	}
	/**
	 * 就诊排队号
	 * @return Integer
	 */
	public Integer getTicketno() {
		return ((Integer) getAttrVal("Ticketno"));
	}	
	/**
	 * 就诊排队号
	 * @param Ticketno
	 */
	public void setTicketno(Integer Ticketno) {
		setAttrVal("Ticketno", Ticketno);
	}
	/**
	 * 排班资源
	 * @return String
	 */
	public String getId_scres() {
		return ((String) getAttrVal("Id_scres"));
	}	
	/**
	 * 排班资源
	 * @param Id_scres
	 */
	public void setId_scres(String Id_scres) {
		setAttrVal("Id_scres", Id_scres);
	}
	/**
	 * 排班服务
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}	
	/**
	 * 排班服务
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 挂号科室id
	 * @return String
	 */
	public String getId_dep_reg() {
		return ((String) getAttrVal("Id_dep_reg"));
	}	
	/**
	 * 挂号科室id
	 * @param Id_dep_reg
	 */
	public void setId_dep_reg(String Id_dep_reg) {
		setAttrVal("Id_dep_reg", Id_dep_reg);
	}
	/**
	 * 挂号医生id
	 * @return String
	 */
	public String getId_emp_reg() {
		return ((String) getAttrVal("Id_emp_reg"));
	}	
	/**
	 * 挂号医生id
	 * @param Id_emp_reg
	 */
	public void setId_emp_reg(String Id_emp_reg) {
		setAttrVal("Id_emp_reg", Id_emp_reg);
	}
	/**
	 * 对应计费_挂号
	 * @return String
	 */
	public String getId_cg_reg() {
		return ((String) getAttrVal("Id_cg_reg"));
	}	
	/**
	 * 对应计费_挂号
	 * @param Id_cg_reg
	 */
	public void setId_cg_reg(String Id_cg_reg) {
		setAttrVal("Id_cg_reg", Id_cg_reg);
	}
	/**
	 * 初诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_first() {
		return ((FBoolean) getAttrVal("Fg_first"));
	}	
	/**
	 * 初诊标志
	 * @param Fg_first
	 */
	public void setFg_first(FBoolean Fg_first) {
		setAttrVal("Fg_first", Fg_first);
	}
	/**
	 * 已结算标志_挂号
	 * @return FBoolean
	 */
	public FBoolean getFg_cg() {
		return ((FBoolean) getAttrVal("Fg_cg"));
	}	
	/**
	 * 已结算标志_挂号
	 * @param Fg_cg
	 */
	public void setFg_cg(FBoolean Fg_cg) {
		setAttrVal("Fg_cg", Fg_cg);
	}
	/**
	 * 对应结算_挂号
	 * @return String
	 */
	public String getId_cg() {
		return ((String) getAttrVal("Id_cg"));
	}	
	/**
	 * 对应结算_挂号
	 * @param Id_cg
	 */
	public void setId_cg(String Id_cg) {
		setAttrVal("Id_cg", Id_cg);
	}
	/**
	 * 转归
	 * @return String
	 */
	public String getId_gowhere() {
		return ((String) getAttrVal("Id_gowhere"));
	}	
	/**
	 * 转归
	 * @param Id_gowhere
	 */
	public void setId_gowhere(String Id_gowhere) {
		setAttrVal("Id_gowhere", Id_gowhere);
	}
	/**
	 * 转归编码
	 * @return String
	 */
	public String getSd_gowhere() {
		return ((String) getAttrVal("Sd_gowhere"));
	}	
	/**
	 * 转归编码
	 * @param Sd_gowhere
	 */
	public void setSd_gowhere(String Sd_gowhere) {
		setAttrVal("Sd_gowhere", Sd_gowhere);
	}
	/**
	 * 病情等级
	 * @return String
	 */
	public String getId_level_dise() {
		return ((String) getAttrVal("Id_level_dise"));
	}	
	/**
	 * 病情等级
	 * @param Id_level_dise
	 */
	public void setId_level_dise(String Id_level_dise) {
		setAttrVal("Id_level_dise", Id_level_dise);
	}
	/**
	 * 病情等级编码
	 * @return String
	 */
	public String getSd_level_dise() {
		return ((String) getAttrVal("Sd_level_dise"));
	}	
	/**
	 * 病情等级编码
	 * @param Sd_level_dise
	 */
	public void setSd_level_dise(String Sd_level_dise) {
		setAttrVal("Sd_level_dise", Sd_level_dise);
	}
	/**
	 * 需回诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_needrtn() {
		return ((FBoolean) getAttrVal("Fg_needrtn"));
	}	
	/**
	 * 需回诊标志
	 * @param Fg_needrtn
	 */
	public void setFg_needrtn(FBoolean Fg_needrtn) {
		setAttrVal("Fg_needrtn", Fg_needrtn);
	}
	/**
	 * 挂号类型
	 * @return String
	 */
	public String getEu_regtp() {
		return ((String) getAttrVal("Eu_regtp"));
	}	
	/**
	 * 挂号类型
	 * @param Eu_regtp
	 */
	public void setEu_regtp(String Eu_regtp) {
		setAttrVal("Eu_regtp", Eu_regtp);
	}
	/**
	 * 门诊次数
	 * @return Integer
	 */
	public Integer getTimes_op() {
		return ((Integer) getAttrVal("Times_op"));
	}	
	/**
	 * 门诊次数
	 * @param Times_op
	 */
	public void setTimes_op(Integer Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 抢救标志
	 * @return FBoolean
	 */
	public FBoolean getFg_rescue() {
		return ((FBoolean) getAttrVal("Fg_rescue"));
	}	
	/**
	 * 抢救标志
	 * @param Fg_rescue
	 */
	public void setFg_rescue(FBoolean Fg_rescue) {
		setAttrVal("Fg_rescue", Fg_rescue);
	}
	/**
	 * 抢救次数
	 * @return Integer
	 */
	public Integer getTimes_rescue() {
		return ((Integer) getAttrVal("Times_rescue"));
	}	
	/**
	 * 抢救次数
	 * @param Times_rescue
	 */
	public void setTimes_rescue(Integer Times_rescue) {
		setAttrVal("Times_rescue", Times_rescue);
	}
	/**
	 * 抢救成功次数
	 * @return Integer
	 */
	public Integer getSucc_rescue() {
		return ((Integer) getAttrVal("Succ_rescue"));
	}	
	/**
	 * 抢救成功次数
	 * @param Succ_rescue
	 */
	public void setSucc_rescue(Integer Succ_rescue) {
		setAttrVal("Succ_rescue", Succ_rescue);
	}
	/**
	 * 预检状态
	 * @return String
	 */
	public String getEu_preobs() {
		return ((String) getAttrVal("Eu_preobs"));
	}	
	/**
	 * 预检状态
	 * @param Eu_preobs
	 */
	public void setEu_preobs(String Eu_preobs) {
		setAttrVal("Eu_preobs", Eu_preobs);
	}
	/**
	 * 诊断记录发病日期
	 * @return FDateTime
	 */
	public FDateTime getDt_di_mor() {
		return ((FDateTime) getAttrVal("Dt_di_mor"));
	}	
	/**
	 * 诊断记录发病日期
	 * @param Dt_di_mor
	 */
	public void setDt_di_mor(FDateTime Dt_di_mor) {
		setAttrVal("Dt_di_mor", Dt_di_mor);
	}
	/**
	 * 抢救打印次数
	 * @return Integer
	 */
	public Integer getTimes_print() {
		return ((Integer) getAttrVal("Times_print"));
	}	
	/**
	 * 抢救打印次数
	 * @param Times_print
	 */
	public void setTimes_print(Integer Times_print) {
		setAttrVal("Times_print", Times_print);
	}
	/**
	 * 日期分组编码
	 * @return String
	 */
	public String getDayslot_code() {
		return ((String) getAttrVal("Dayslot_code"));
	}	
	/**
	 * 日期分组编码
	 * @param Dayslot_code
	 */
	public void setDayslot_code(String Dayslot_code) {
		setAttrVal("Dayslot_code", Dayslot_code);
	}
	/**
	 * 日期分组名称
	 * @return String
	 */
	public String getDayslot_name() {
		return ((String) getAttrVal("Dayslot_name"));
	}	
	/**
	 * 日期分组名称
	 * @param Dayslot_name
	 */
	public void setDayslot_name(String Dayslot_name) {
		setAttrVal("Dayslot_name", Dayslot_name);
	}
	/**
	 * 日期分组类型
	 * @return String
	 */
	public String getId_dayslottp() {
		return ((String) getAttrVal("Id_dayslottp"));
	}	
	/**
	 * 日期分组类型
	 * @param Id_dayslottp
	 */
	public void setId_dayslottp(String Id_dayslottp) {
		setAttrVal("Id_dayslottp", Id_dayslottp);
	}
	/**
	 * 日期分组类型编码
	 * @return String
	 */
	public String getSd_dayslottp() {
		return ((String) getAttrVal("Sd_dayslottp"));
	}	
	/**
	 * 日期分组类型编码
	 * @param Sd_dayslottp
	 */
	public void setSd_dayslottp(String Sd_dayslottp) {
		setAttrVal("Sd_dayslottp", Sd_dayslottp);
	}
	/**
	 * 资源编码
	 * @return String
	 */
	public String getScres_code() {
		return ((String) getAttrVal("Scres_code"));
	}	
	/**
	 * 资源编码
	 * @param Scres_code
	 */
	public void setScres_code(String Scres_code) {
		setAttrVal("Scres_code", Scres_code);
	}
	/**
	 * 资源名称
	 * @return String
	 */
	public String getScres_name() {
		return ((String) getAttrVal("Scres_name"));
	}	
	/**
	 * 资源名称
	 * @param Scres_name
	 */
	public void setScres_name(String Scres_name) {
		setAttrVal("Scres_name", Scres_name);
	}
	/**
	 * 排班服务编码
	 * @return String
	 */
	public String getScsrv_code() {
		return ((String) getAttrVal("Scsrv_code"));
	}	
	/**
	 * 排班服务编码
	 * @param Scsrv_code
	 */
	public void setScsrv_code(String Scsrv_code) {
		setAttrVal("Scsrv_code", Scsrv_code);
	}
	/**
	 * 排班服务名称
	 * @return String
	 */
	public String getScsrv_name() {
		return ((String) getAttrVal("Scsrv_name"));
	}	
	/**
	 * 排班服务名称
	 * @param Scsrv_name
	 */
	public void setScsrv_name(String Scsrv_name) {
		setAttrVal("Scsrv_name", Scsrv_name);
	}
	/**
	 * 挂号科室编码
	 * @return String
	 */
	public String getDep_reg_code() {
		return ((String) getAttrVal("Dep_reg_code"));
	}	
	/**
	 * 挂号科室编码
	 * @param Dep_reg_code
	 */
	public void setDep_reg_code(String Dep_reg_code) {
		setAttrVal("Dep_reg_code", Dep_reg_code);
	}
	/**
	 * 挂号科室名称
	 * @return String
	 */
	public String getDep_reg_name() {
		return ((String) getAttrVal("Dep_reg_name"));
	}	
	/**
	 * 挂号科室名称
	 * @param Dep_reg_name
	 */
	public void setDep_reg_name(String Dep_reg_name) {
		setAttrVal("Dep_reg_name", Dep_reg_name);
	}
	/**
	 * 挂号医生编码
	 * @return String
	 */
	public String getEmp_reg_code() {
		return ((String) getAttrVal("Emp_reg_code"));
	}	
	/**
	 * 挂号医生编码
	 * @param Emp_reg_code
	 */
	public void setEmp_reg_code(String Emp_reg_code) {
		setAttrVal("Emp_reg_code", Emp_reg_code);
	}
	/**
	 * 挂号医生姓名
	 * @return String
	 */
	public String getEmp_reg_name() {
		return ((String) getAttrVal("Emp_reg_name"));
	}	
	/**
	 * 挂号医生姓名
	 * @param Emp_reg_name
	 */
	public void setEmp_reg_name(String Emp_reg_name) {
		setAttrVal("Emp_reg_name", Emp_reg_name);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_outpatient";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_op";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OutpatientDODesc.class);
	}
	
}