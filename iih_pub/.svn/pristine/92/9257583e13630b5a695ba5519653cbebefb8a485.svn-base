package iih.mm.pl.poplanstrategy.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.pl.poplanstrategy.d.desc.PoPlanStrategyDODesc;
import java.math.BigDecimal;

/**
 * 采购计划计算策略 DO数据 
 * 
 */
public class PoPlanStrategyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//策略主键
	public static final String ID_STRATEGY= "Id_strategy";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//策略名称
	public static final String NAME= "Name";
	//仓库
	public static final String ID_WH= "Id_wh";
	//药库库存
	public static final String RULEOUT_DRUGSTORAGE= "Ruleout_drugstorage";
	//全院库存
	public static final String RULEOUT_ALLSTORAGE= "Ruleout_allstorage";
	//药库可用量
	public static final String RULEOUT_DRUGUSESTORAGE= "Ruleout_drugusestorage";
	//全院可用量
	public static final String RULEOUT_ALLUSESTORAGE= "Ruleout_allusestorage";
	//平均消耗天数
	public static final String DAYS_AVGUSE= "Days_avguse";
	//计划采购天数
	public static final String DAYS_POPLAN= "Days_poplan";
	//采购供应商类别
	public static final String POSUPTYPE= "Posuptype";
	//是否过滤计算量为0
	public static final String FG_ZERO= "Fg_zero";
	//仓库类型
	public static final String ID_WHTP= "Id_whtp";
	//仓库范围
	public static final String ID_WH_RANGE= "Id_wh_range";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//校验最低库存
	public static final String FG_CHKLOWSTNUM= "Fg_chklowstnum";
	//采购量计算方式
	public static final String SD_QUANCALTP_PL= "Sd_quancaltp_pl";
	//默认标识
	public static final String FG_DEFAULT= "Fg_default";
	//集团名称
	public static final String GROUP_NAME= "Group_name";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//名称
	public static final String WHTP_NAME= "Whtp_name";
	//仓库名称
	public static final String WH_RANGE_NAME= "Wh_range_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 策略主键
	 * @return String
	 */
	public String getId_strategy() {
		return ((String) getAttrVal("Id_strategy"));
	}	
	/**
	 * 策略主键
	 * @param Id_strategy
	 */
	public void setId_strategy(String Id_strategy) {
		setAttrVal("Id_strategy", Id_strategy);
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
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	 * 仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 药库库存
	 * @return FBoolean
	 */
	public FBoolean getRuleout_drugstorage() {
		return ((FBoolean) getAttrVal("Ruleout_drugstorage"));
	}	
	/**
	 * 药库库存
	 * @param Ruleout_drugstorage
	 */
	public void setRuleout_drugstorage(FBoolean Ruleout_drugstorage) {
		setAttrVal("Ruleout_drugstorage", Ruleout_drugstorage);
	}
	/**
	 * 全院库存
	 * @return FBoolean
	 */
	public FBoolean getRuleout_allstorage() {
		return ((FBoolean) getAttrVal("Ruleout_allstorage"));
	}	
	/**
	 * 全院库存
	 * @param Ruleout_allstorage
	 */
	public void setRuleout_allstorage(FBoolean Ruleout_allstorage) {
		setAttrVal("Ruleout_allstorage", Ruleout_allstorage);
	}
	/**
	 * 药库可用量
	 * @return FBoolean
	 */
	public FBoolean getRuleout_drugusestorage() {
		return ((FBoolean) getAttrVal("Ruleout_drugusestorage"));
	}	
	/**
	 * 药库可用量
	 * @param Ruleout_drugusestorage
	 */
	public void setRuleout_drugusestorage(FBoolean Ruleout_drugusestorage) {
		setAttrVal("Ruleout_drugusestorage", Ruleout_drugusestorage);
	}
	/**
	 * 全院可用量
	 * @return FBoolean
	 */
	public FBoolean getRuleout_allusestorage() {
		return ((FBoolean) getAttrVal("Ruleout_allusestorage"));
	}	
	/**
	 * 全院可用量
	 * @param Ruleout_allusestorage
	 */
	public void setRuleout_allusestorage(FBoolean Ruleout_allusestorage) {
		setAttrVal("Ruleout_allusestorage", Ruleout_allusestorage);
	}
	/**
	 * 平均消耗天数
	 * @return Integer
	 */
	public Integer getDays_avguse() {
		return ((Integer) getAttrVal("Days_avguse"));
	}	
	/**
	 * 平均消耗天数
	 * @param Days_avguse
	 */
	public void setDays_avguse(Integer Days_avguse) {
		setAttrVal("Days_avguse", Days_avguse);
	}
	/**
	 * 计划采购天数
	 * @return Integer
	 */
	public Integer getDays_poplan() {
		return ((Integer) getAttrVal("Days_poplan"));
	}	
	/**
	 * 计划采购天数
	 * @param Days_poplan
	 */
	public void setDays_poplan(Integer Days_poplan) {
		setAttrVal("Days_poplan", Days_poplan);
	}
	/**
	 * 采购供应商类别
	 * @return Integer
	 */
	public Integer getPosuptype() {
		return ((Integer) getAttrVal("Posuptype"));
	}	
	/**
	 * 采购供应商类别
	 * @param Posuptype
	 */
	public void setPosuptype(Integer Posuptype) {
		setAttrVal("Posuptype", Posuptype);
	}
	/**
	 * 是否过滤计算量为0
	 * @return FBoolean
	 */
	public FBoolean getFg_zero() {
		return ((FBoolean) getAttrVal("Fg_zero"));
	}	
	/**
	 * 是否过滤计算量为0
	 * @param Fg_zero
	 */
	public void setFg_zero(FBoolean Fg_zero) {
		setAttrVal("Fg_zero", Fg_zero);
	}
	/**
	 * 仓库类型
	 * @return String
	 */
	public String getId_whtp() {
		return ((String) getAttrVal("Id_whtp"));
	}	
	/**
	 * 仓库类型
	 * @param Id_whtp
	 */
	public void setId_whtp(String Id_whtp) {
		setAttrVal("Id_whtp", Id_whtp);
	}
	/**
	 * 仓库范围
	 * @return String
	 */
	public String getId_wh_range() {
		return ((String) getAttrVal("Id_wh_range"));
	}	
	/**
	 * 仓库范围
	 * @param Id_wh_range
	 */
	public void setId_wh_range(String Id_wh_range) {
		setAttrVal("Id_wh_range", Id_wh_range);
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
	 * 校验最低库存
	 * @return FBoolean
	 */
	public FBoolean getFg_chklowstnum() {
		return ((FBoolean) getAttrVal("Fg_chklowstnum"));
	}	
	/**
	 * 校验最低库存
	 * @param Fg_chklowstnum
	 */
	public void setFg_chklowstnum(FBoolean Fg_chklowstnum) {
		setAttrVal("Fg_chklowstnum", Fg_chklowstnum);
	}
	/**
	 * 采购量计算方式
	 * @return String
	 */
	public String getSd_quancaltp_pl() {
		return ((String) getAttrVal("Sd_quancaltp_pl"));
	}	
	/**
	 * 采购量计算方式
	 * @param Sd_quancaltp_pl
	 */
	public void setSd_quancaltp_pl(String Sd_quancaltp_pl) {
		setAttrVal("Sd_quancaltp_pl", Sd_quancaltp_pl);
	}
	/**
	 * 默认标识
	 * @return FBoolean
	 */
	public FBoolean getFg_default() {
		return ((FBoolean) getAttrVal("Fg_default"));
	}	
	/**
	 * 默认标识
	 * @param Fg_default
	 */
	public void setFg_default(FBoolean Fg_default) {
		setAttrVal("Fg_default", Fg_default);
	}
	/**
	 * 集团名称
	 * @return String
	 */
	public String getGroup_name() {
		return ((String) getAttrVal("Group_name"));
	}	
	/**
	 * 集团名称
	 * @param Group_name
	 */
	public void setGroup_name(String Group_name) {
		setAttrVal("Group_name", Group_name);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	/**
	 * 仓库名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getWhtp_name() {
		return ((String) getAttrVal("Whtp_name"));
	}	
	/**
	 * 名称
	 * @param Whtp_name
	 */
	public void setWhtp_name(String Whtp_name) {
		setAttrVal("Whtp_name", Whtp_name);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getWh_range_name() {
		return ((String) getAttrVal("Wh_range_name"));
	}	
	/**
	 * 仓库名称
	 * @param Wh_range_name
	 */
	public void setWh_range_name(String Wh_range_name) {
		setAttrVal("Wh_range_name", Wh_range_name);
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
		return "Id_strategy";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_PL_Strategy";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PoPlanStrategyDODesc.class);
	}
	
}