package iih.ci.ord.cfg.cirulecfg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cfg.cirulecfg.d.desc.CiRuleEntityDesc;
import java.math.BigDecimal;

/**
 * 医嘱规则实体 DO数据 
 * 
 */
public class CiRuleEntity extends BaseDO {
	private static final long serialVersionUID = 1L;

	//规则配置主键
	public static final String ID_RULE= "Id_rule";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//规则分类
	public static final String EU_RULE_CATEGORY= "Eu_rule_category";
	//规则类型
	public static final String RULE_TYPE= "Rule_type";
	//规则类型名称
	public static final String NAME_RULE_TYPE= "Name_rule_type";
	//类全路径
	public static final String CLASS_PATH= "Class_path";
	//实现类名称
	public static final String CLASS_NAME= "Class_name";
	//必填项
	public static final String REQUIRED_PROPS= "Required_props";
	//必填项是否全部校验
	public static final String FG_CHECK_ALL_REQUIRED= "Fg_check_all_required";
	//可使用标识_门诊
	public static final String FG_USE_OP= "Fg_use_op";
	//可使用标识_住院
	public static final String FG_USE_IP= "Fg_use_ip";
	//可使用标识_急诊流水
	public static final String FG_USE_ER1= "Fg_use_er1";
	//可使用标识_急诊抢救
	public static final String FG_USE_ER2= "Fg_use_er2";
	//可使用标识_急诊留观
	public static final String FG_USE_ER3= "Fg_use_er3";
	//可使用标识_体检
	public static final String FG_USE_PE= "Fg_use_pe";
	//可使用标识_家庭
	public static final String FG_USE_FM= "Fg_use_fm";
	//描述
	public static final String DES= "Des";
	//序号
	public static final String SORTNO= "Sortno";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
	//系统标识
	public static final String FG_SYS= "Fg_sys";
	//属性定义
	public static final String PROPS_DEF= "Props_def";
	//集团编码
	public static final String CODE_GRP= "Code_grp";
	//集团名称
	public static final String NAME_GRP= "Name_grp";
	//组织编码
	public static final String CODE_ORG= "Code_org";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 规则配置主键
	 * @return String
	 */
	public String getId_rule() {
		return ((String) getAttrVal("Id_rule"));
	}	
	/**
	 * 规则配置主键
	 * @param Id_rule
	 */
	public void setId_rule(String Id_rule) {
		setAttrVal("Id_rule", Id_rule);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	 * 规则分类
	 * @return Integer
	 */
	public Integer getEu_rule_category() {
		return ((Integer) getAttrVal("Eu_rule_category"));
	}	
	/**
	 * 规则分类
	 * @param Eu_rule_category
	 */
	public void setEu_rule_category(Integer Eu_rule_category) {
		setAttrVal("Eu_rule_category", Eu_rule_category);
	}
	/**
	 * 规则类型
	 * @return String
	 */
	public String getRule_type() {
		return ((String) getAttrVal("Rule_type"));
	}	
	/**
	 * 规则类型
	 * @param Rule_type
	 */
	public void setRule_type(String Rule_type) {
		setAttrVal("Rule_type", Rule_type);
	}
	/**
	 * 规则类型名称
	 * @return String
	 */
	public String getName_rule_type() {
		return ((String) getAttrVal("Name_rule_type"));
	}	
	/**
	 * 规则类型名称
	 * @param Name_rule_type
	 */
	public void setName_rule_type(String Name_rule_type) {
		setAttrVal("Name_rule_type", Name_rule_type);
	}
	/**
	 * 类全路径
	 * @return String
	 */
	public String getClass_path() {
		return ((String) getAttrVal("Class_path"));
	}	
	/**
	 * 类全路径
	 * @param Class_path
	 */
	public void setClass_path(String Class_path) {
		setAttrVal("Class_path", Class_path);
	}
	/**
	 * 实现类名称
	 * @return String
	 */
	public String getClass_name() {
		return ((String) getAttrVal("Class_name"));
	}	
	/**
	 * 实现类名称
	 * @param Class_name
	 */
	public void setClass_name(String Class_name) {
		setAttrVal("Class_name", Class_name);
	}
	/**
	 * 必填项
	 * @return String
	 */
	public String getRequired_props() {
		return ((String) getAttrVal("Required_props"));
	}	
	/**
	 * 必填项
	 * @param Required_props
	 */
	public void setRequired_props(String Required_props) {
		setAttrVal("Required_props", Required_props);
	}
	/**
	 * 必填项是否全部校验
	 * @return FBoolean
	 */
	public FBoolean getFg_check_all_required() {
		return ((FBoolean) getAttrVal("Fg_check_all_required"));
	}	
	/**
	 * 必填项是否全部校验
	 * @param Fg_check_all_required
	 */
	public void setFg_check_all_required(FBoolean Fg_check_all_required) {
		setAttrVal("Fg_check_all_required", Fg_check_all_required);
	}
	/**
	 * 可使用标识_门诊
	 * @return FBoolean
	 */
	public FBoolean getFg_use_op() {
		return ((FBoolean) getAttrVal("Fg_use_op"));
	}	
	/**
	 * 可使用标识_门诊
	 * @param Fg_use_op
	 */
	public void setFg_use_op(FBoolean Fg_use_op) {
		setAttrVal("Fg_use_op", Fg_use_op);
	}
	/**
	 * 可使用标识_住院
	 * @return FBoolean
	 */
	public FBoolean getFg_use_ip() {
		return ((FBoolean) getAttrVal("Fg_use_ip"));
	}	
	/**
	 * 可使用标识_住院
	 * @param Fg_use_ip
	 */
	public void setFg_use_ip(FBoolean Fg_use_ip) {
		setAttrVal("Fg_use_ip", Fg_use_ip);
	}
	/**
	 * 可使用标识_急诊流水
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er1() {
		return ((FBoolean) getAttrVal("Fg_use_er1"));
	}	
	/**
	 * 可使用标识_急诊流水
	 * @param Fg_use_er1
	 */
	public void setFg_use_er1(FBoolean Fg_use_er1) {
		setAttrVal("Fg_use_er1", Fg_use_er1);
	}
	/**
	 * 可使用标识_急诊抢救
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er2() {
		return ((FBoolean) getAttrVal("Fg_use_er2"));
	}	
	/**
	 * 可使用标识_急诊抢救
	 * @param Fg_use_er2
	 */
	public void setFg_use_er2(FBoolean Fg_use_er2) {
		setAttrVal("Fg_use_er2", Fg_use_er2);
	}
	/**
	 * 可使用标识_急诊留观
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er3() {
		return ((FBoolean) getAttrVal("Fg_use_er3"));
	}	
	/**
	 * 可使用标识_急诊留观
	 * @param Fg_use_er3
	 */
	public void setFg_use_er3(FBoolean Fg_use_er3) {
		setAttrVal("Fg_use_er3", Fg_use_er3);
	}
	/**
	 * 可使用标识_体检
	 * @return FBoolean
	 */
	public FBoolean getFg_use_pe() {
		return ((FBoolean) getAttrVal("Fg_use_pe"));
	}	
	/**
	 * 可使用标识_体检
	 * @param Fg_use_pe
	 */
	public void setFg_use_pe(FBoolean Fg_use_pe) {
		setAttrVal("Fg_use_pe", Fg_use_pe);
	}
	/**
	 * 可使用标识_家庭
	 * @return FBoolean
	 */
	public FBoolean getFg_use_fm() {
		return ((FBoolean) getAttrVal("Fg_use_fm"));
	}	
	/**
	 * 可使用标识_家庭
	 * @param Fg_use_fm
	 */
	public void setFg_use_fm(FBoolean Fg_use_fm) {
		setAttrVal("Fg_use_fm", Fg_use_fm);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 系统标识
	 * @return FBoolean
	 */
	public FBoolean getFg_sys() {
		return ((FBoolean) getAttrVal("Fg_sys"));
	}	
	/**
	 * 系统标识
	 * @param Fg_sys
	 */
	public void setFg_sys(FBoolean Fg_sys) {
		setAttrVal("Fg_sys", Fg_sys);
	}
	/**
	 * 属性定义
	 * @return String
	 */
	public String getProps_def() {
		return ((String) getAttrVal("Props_def"));
	}	
	/**
	 * 属性定义
	 * @param Props_def
	 */
	public void setProps_def(String Props_def) {
		setAttrVal("Props_def", Props_def);
	}
	/**
	 * 集团编码
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	/**
	 * 集团编码
	 * @param Code_grp
	 */
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	/**
	 * 集团名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 集团名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	/**
	 * 组织编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
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
		return "Id_rule";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rule_entity";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiRuleEntityDesc.class);
	}
	
}