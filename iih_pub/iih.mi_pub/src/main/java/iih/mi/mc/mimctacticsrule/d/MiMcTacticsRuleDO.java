package iih.mi.mc.mimctacticsrule.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.mc.mimctacticsrule.d.desc.MiMcTacticsRuleDODesc;
import java.math.BigDecimal;

/**
 * 医保规则 DO数据 
 * 
 */
public class MiMcTacticsRuleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医保规则主键
	public static final String ID_HPTACTICSRULE= "Id_hptacticsrule";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//医保计划
	public static final String ID_HP= "Id_hp";
	//医保策略库主键
	public static final String ID_HPTACTICS= "Id_hptactics";
	//控制类型
	public static final String EU_CTRLTP= "Eu_ctrltp";
	//是否生效
	public static final String FG_ACTIVE= "Fg_active";
	//生效时间
	public static final String DT_B= "Dt_b";
	//失效时间
	public static final String DT_E= "Dt_e";
	//规则维护人
	public static final String ID_EMP_RULE= "Id_emp_rule";
	//规则维护时间
	public static final String DT_RULE= "Dt_rule";
	//备注
	public static final String DES= "Des";
	//可使用标志_门诊
	public static final String FG_USER_OP= "Fg_user_op";
	//可使用标志_急诊流水
	public static final String FG_USER_ER= "Fg_user_er";
	//可使用标志_急诊抢救
	public static final String FG_USER_ER1= "Fg_user_er1";
	//可使用标志_急诊留观
	public static final String FG_USER_ER2= "Fg_user_er2";
	//可使用标志_住院
	public static final String FG_ENTP_IP= "Fg_entp_ip";
	//可使用标志_家庭病床
	public static final String FG_ENTP_FM= "Fg_entp_fm";
	//可使用标志_体检
	public static final String FG_ENTP_PE= "Fg_entp_pe";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//可使用标识_预住院
	public static final String FG_USE_PIP= "Fg_use_pip";
	//医保计划编码
	public static final String HP_CODE= "Hp_code";
	//医保计划名称
	public static final String HP_NAME= "Hp_name";
	//策略名称
	public static final String NAME= "Name";
	//策略编码
	public static final String CODE= "Code";
	//人员编码
	public static final String EMP_RULE_CODE= "Emp_rule_code";
	//姓名
	public static final String EMP_RULE_NAME= "Emp_rule_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医保规则主键
	 * @return String
	 */
	public String getId_hptacticsrule() {
		return ((String) getAttrVal("Id_hptacticsrule"));
	}	
	/**
	 * 医保规则主键
	 * @param Id_hptacticsrule
	 */
	public void setId_hptacticsrule(String Id_hptacticsrule) {
		setAttrVal("Id_hptacticsrule", Id_hptacticsrule);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保策略库主键
	 * @return String
	 */
	public String getId_hptactics() {
		return ((String) getAttrVal("Id_hptactics"));
	}	
	/**
	 * 医保策略库主键
	 * @param Id_hptactics
	 */
	public void setId_hptactics(String Id_hptactics) {
		setAttrVal("Id_hptactics", Id_hptactics);
	}
	/**
	 * 控制类型
	 * @return String
	 */
	public String getEu_ctrltp() {
		return ((String) getAttrVal("Eu_ctrltp"));
	}	
	/**
	 * 控制类型
	 * @param Eu_ctrltp
	 */
	public void setEu_ctrltp(String Eu_ctrltp) {
		setAttrVal("Eu_ctrltp", Eu_ctrltp);
	}
	/**
	 * 是否生效
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否生效
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 生效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	/**
	 * 生效时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 失效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	/**
	 * 失效时间
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 规则维护人
	 * @return String
	 */
	public String getId_emp_rule() {
		return ((String) getAttrVal("Id_emp_rule"));
	}	
	/**
	 * 规则维护人
	 * @param Id_emp_rule
	 */
	public void setId_emp_rule(String Id_emp_rule) {
		setAttrVal("Id_emp_rule", Id_emp_rule);
	}
	/**
	 * 规则维护时间
	 * @return FDateTime
	 */
	public FDateTime getDt_rule() {
		return ((FDateTime) getAttrVal("Dt_rule"));
	}	
	/**
	 * 规则维护时间
	 * @param Dt_rule
	 */
	public void setDt_rule(FDateTime Dt_rule) {
		setAttrVal("Dt_rule", Dt_rule);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 可使用标志_门诊
	 * @return FBoolean
	 */
	public FBoolean getFg_user_op() {
		return ((FBoolean) getAttrVal("Fg_user_op"));
	}	
	/**
	 * 可使用标志_门诊
	 * @param Fg_user_op
	 */
	public void setFg_user_op(FBoolean Fg_user_op) {
		setAttrVal("Fg_user_op", Fg_user_op);
	}
	/**
	 * 可使用标志_急诊流水
	 * @return FBoolean
	 */
	public FBoolean getFg_user_er() {
		return ((FBoolean) getAttrVal("Fg_user_er"));
	}	
	/**
	 * 可使用标志_急诊流水
	 * @param Fg_user_er
	 */
	public void setFg_user_er(FBoolean Fg_user_er) {
		setAttrVal("Fg_user_er", Fg_user_er);
	}
	/**
	 * 可使用标志_急诊抢救
	 * @return FBoolean
	 */
	public FBoolean getFg_user_er1() {
		return ((FBoolean) getAttrVal("Fg_user_er1"));
	}	
	/**
	 * 可使用标志_急诊抢救
	 * @param Fg_user_er1
	 */
	public void setFg_user_er1(FBoolean Fg_user_er1) {
		setAttrVal("Fg_user_er1", Fg_user_er1);
	}
	/**
	 * 可使用标志_急诊留观
	 * @return FBoolean
	 */
	public FBoolean getFg_user_er2() {
		return ((FBoolean) getAttrVal("Fg_user_er2"));
	}	
	/**
	 * 可使用标志_急诊留观
	 * @param Fg_user_er2
	 */
	public void setFg_user_er2(FBoolean Fg_user_er2) {
		setAttrVal("Fg_user_er2", Fg_user_er2);
	}
	/**
	 * 可使用标志_住院
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_ip() {
		return ((FBoolean) getAttrVal("Fg_entp_ip"));
	}	
	/**
	 * 可使用标志_住院
	 * @param Fg_entp_ip
	 */
	public void setFg_entp_ip(FBoolean Fg_entp_ip) {
		setAttrVal("Fg_entp_ip", Fg_entp_ip);
	}
	/**
	 * 可使用标志_家庭病床
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_fm() {
		return ((FBoolean) getAttrVal("Fg_entp_fm"));
	}	
	/**
	 * 可使用标志_家庭病床
	 * @param Fg_entp_fm
	 */
	public void setFg_entp_fm(FBoolean Fg_entp_fm) {
		setAttrVal("Fg_entp_fm", Fg_entp_fm);
	}
	/**
	 * 可使用标志_体检
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_pe() {
		return ((FBoolean) getAttrVal("Fg_entp_pe"));
	}	
	/**
	 * 可使用标志_体检
	 * @param Fg_entp_pe
	 */
	public void setFg_entp_pe(FBoolean Fg_entp_pe) {
		setAttrVal("Fg_entp_pe", Fg_entp_pe);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 可使用标识_预住院
	 * @return FBoolean
	 */
	public FBoolean getFg_use_pip() {
		return ((FBoolean) getAttrVal("Fg_use_pip"));
	}	
	/**
	 * 可使用标识_预住院
	 * @param Fg_use_pip
	 */
	public void setFg_use_pip(FBoolean Fg_use_pip) {
		setAttrVal("Fg_use_pip", Fg_use_pip);
	}
	/**
	 * 医保计划编码
	 * @return String
	 */
	public String getHp_code() {
		return ((String) getAttrVal("Hp_code"));
	}	
	/**
	 * 医保计划编码
	 * @param Hp_code
	 */
	public void setHp_code(String Hp_code) {
		setAttrVal("Hp_code", Hp_code);
	}
	/**
	 * 医保计划名称
	 * @return String
	 */
	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}	
	/**
	 * 医保计划名称
	 * @param Hp_name
	 */
	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
	}
	/**
	 * 策略名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 策略名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 策略编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 策略编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getEmp_rule_code() {
		return ((String) getAttrVal("Emp_rule_code"));
	}	
	/**
	 * 人员编码
	 * @param Emp_rule_code
	 */
	public void setEmp_rule_code(String Emp_rule_code) {
		setAttrVal("Emp_rule_code", Emp_rule_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_rule_name() {
		return ((String) getAttrVal("Emp_rule_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_rule_name
	 */
	public void setEmp_rule_name(String Emp_rule_name) {
		setAttrVal("Emp_rule_name", Emp_rule_name);
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
		return "Id_hptacticsrule";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_mc_tactics_rule";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiMcTacticsRuleDODesc.class);
	}
	
}