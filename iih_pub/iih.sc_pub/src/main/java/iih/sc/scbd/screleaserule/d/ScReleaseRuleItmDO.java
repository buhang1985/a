package iih.sc.scbd.screleaserule.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scbd.screleaserule.d.desc.ScReleaseRuleItmDODesc;
import java.math.BigDecimal;

/**
 * 排班释放规则细目 DO数据 
 * 
 */
public class ScReleaseRuleItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//释放规则细目id
	public static final String ID_RELEASE_RULEITM= "Id_release_ruleitm";
	//释放规则id
	public static final String ID_RELEASE_RULE= "Id_release_rule";
	//排班属性类型id
	public static final String ID_SCH_PROP_TP= "Id_sch_prop_tp";
	//排班属性类型编码
	public static final String SD_SCH_PROP_TP= "Sd_sch_prop_tp";
	//释放时间类型设置id
	public static final String ID_RELEASE_PERIOD_TP= "Id_release_period_tp";
	//释放时间类型设置编码
	public static final String SD_RELEASE_PERIOD_TP= "Sd_release_period_tp";
	//提前天数
	public static final String NUM_DAY= "Num_day";
	//提前小时数
	public static final String NUM_HOUR= "Num_hour";
	//可用排班服务类别
	public static final String IDS_SCSRVKINDITM= "Ids_scsrvkinditm";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//是否排除节假日
	public static final String FG_HOLIDAY_EXCL= "Fg_holiday_excl";
	//排班服务
	public static final String IDS_SCSRV= "Ids_scsrv";
	//排班属性类型名称
	public static final String NAME_SCH_PROP_TP= "Name_sch_prop_tp";
	//释放时间类型名称
	public static final String NAME_RELEASE_PERIOD_TP= "Name_release_period_tp";
	//排班服务明细编码
	public static final String CODE_SCSRV= "Code_scsrv";
	//排班服务类别明细
	public static final String NAME_SCSRV= "Name_scsrv";
	//排班服务编码
	public static final String CODE_SCSRVS= "Code_scsrvs";
	//排班服务名称
	public static final String NAME_SCSRVS= "Name_scsrvs";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 释放规则细目id
	 * @return String
	 */
	public String getId_release_ruleitm() {
		return ((String) getAttrVal("Id_release_ruleitm"));
	}	
	/**
	 * 释放规则细目id
	 * @param Id_release_ruleitm
	 */
	public void setId_release_ruleitm(String Id_release_ruleitm) {
		setAttrVal("Id_release_ruleitm", Id_release_ruleitm);
	}
	/**
	 * 释放规则id
	 * @return String
	 */
	public String getId_release_rule() {
		return ((String) getAttrVal("Id_release_rule"));
	}	
	/**
	 * 释放规则id
	 * @param Id_release_rule
	 */
	public void setId_release_rule(String Id_release_rule) {
		setAttrVal("Id_release_rule", Id_release_rule);
	}
	/**
	 * 排班属性类型id
	 * @return String
	 */
	public String getId_sch_prop_tp() {
		return ((String) getAttrVal("Id_sch_prop_tp"));
	}	
	/**
	 * 排班属性类型id
	 * @param Id_sch_prop_tp
	 */
	public void setId_sch_prop_tp(String Id_sch_prop_tp) {
		setAttrVal("Id_sch_prop_tp", Id_sch_prop_tp);
	}
	/**
	 * 排班属性类型编码
	 * @return String
	 */
	public String getSd_sch_prop_tp() {
		return ((String) getAttrVal("Sd_sch_prop_tp"));
	}	
	/**
	 * 排班属性类型编码
	 * @param Sd_sch_prop_tp
	 */
	public void setSd_sch_prop_tp(String Sd_sch_prop_tp) {
		setAttrVal("Sd_sch_prop_tp", Sd_sch_prop_tp);
	}
	/**
	 * 释放时间类型设置id
	 * @return String
	 */
	public String getId_release_period_tp() {
		return ((String) getAttrVal("Id_release_period_tp"));
	}	
	/**
	 * 释放时间类型设置id
	 * @param Id_release_period_tp
	 */
	public void setId_release_period_tp(String Id_release_period_tp) {
		setAttrVal("Id_release_period_tp", Id_release_period_tp);
	}
	/**
	 * 释放时间类型设置编码
	 * @return String
	 */
	public String getSd_release_period_tp() {
		return ((String) getAttrVal("Sd_release_period_tp"));
	}	
	/**
	 * 释放时间类型设置编码
	 * @param Sd_release_period_tp
	 */
	public void setSd_release_period_tp(String Sd_release_period_tp) {
		setAttrVal("Sd_release_period_tp", Sd_release_period_tp);
	}
	/**
	 * 提前天数
	 * @return Integer
	 */
	public Integer getNum_day() {
		return ((Integer) getAttrVal("Num_day"));
	}	
	/**
	 * 提前天数
	 * @param Num_day
	 */
	public void setNum_day(Integer Num_day) {
		setAttrVal("Num_day", Num_day);
	}
	/**
	 * 提前小时数
	 * @return Integer
	 */
	public Integer getNum_hour() {
		return ((Integer) getAttrVal("Num_hour"));
	}	
	/**
	 * 提前小时数
	 * @param Num_hour
	 */
	public void setNum_hour(Integer Num_hour) {
		setAttrVal("Num_hour", Num_hour);
	}
	/**
	 * 可用排班服务类别
	 * @return String
	 */
	public String getIds_scsrvkinditm() {
		return ((String) getAttrVal("Ids_scsrvkinditm"));
	}	
	/**
	 * 可用排班服务类别
	 * @param Ids_scsrvkinditm
	 */
	public void setIds_scsrvkinditm(String Ids_scsrvkinditm) {
		setAttrVal("Ids_scsrvkinditm", Ids_scsrvkinditm);
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
	 * 是否排除节假日
	 * @return FBoolean
	 */
	public FBoolean getFg_holiday_excl() {
		return ((FBoolean) getAttrVal("Fg_holiday_excl"));
	}	
	/**
	 * 是否排除节假日
	 * @param Fg_holiday_excl
	 */
	public void setFg_holiday_excl(FBoolean Fg_holiday_excl) {
		setAttrVal("Fg_holiday_excl", Fg_holiday_excl);
	}
	/**
	 * 排班服务
	 * @return String
	 */
	public String getIds_scsrv() {
		return ((String) getAttrVal("Ids_scsrv"));
	}	
	/**
	 * 排班服务
	 * @param Ids_scsrv
	 */
	public void setIds_scsrv(String Ids_scsrv) {
		setAttrVal("Ids_scsrv", Ids_scsrv);
	}
	/**
	 * 排班属性类型名称
	 * @return String
	 */
	public String getName_sch_prop_tp() {
		return ((String) getAttrVal("Name_sch_prop_tp"));
	}	
	/**
	 * 排班属性类型名称
	 * @param Name_sch_prop_tp
	 */
	public void setName_sch_prop_tp(String Name_sch_prop_tp) {
		setAttrVal("Name_sch_prop_tp", Name_sch_prop_tp);
	}
	/**
	 * 释放时间类型名称
	 * @return String
	 */
	public String getName_release_period_tp() {
		return ((String) getAttrVal("Name_release_period_tp"));
	}	
	/**
	 * 释放时间类型名称
	 * @param Name_release_period_tp
	 */
	public void setName_release_period_tp(String Name_release_period_tp) {
		setAttrVal("Name_release_period_tp", Name_release_period_tp);
	}
	/**
	 * 排班服务明细编码
	 * @return String
	 */
	public String getCode_scsrv() {
		return ((String) getAttrVal("Code_scsrv"));
	}	
	/**
	 * 排班服务明细编码
	 * @param Code_scsrv
	 */
	public void setCode_scsrv(String Code_scsrv) {
		setAttrVal("Code_scsrv", Code_scsrv);
	}
	/**
	 * 排班服务类别明细
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}	
	/**
	 * 排班服务类别明细
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
	/**
	 * 排班服务编码
	 * @return String
	 */
	public String getCode_scsrvs() {
		return ((String) getAttrVal("Code_scsrvs"));
	}	
	/**
	 * 排班服务编码
	 * @param Code_scsrvs
	 */
	public void setCode_scsrvs(String Code_scsrvs) {
		setAttrVal("Code_scsrvs", Code_scsrvs);
	}
	/**
	 * 排班服务名称
	 * @return String
	 */
	public String getName_scsrvs() {
		return ((String) getAttrVal("Name_scsrvs"));
	}	
	/**
	 * 排班服务名称
	 * @param Name_scsrvs
	 */
	public void setName_scsrvs(String Name_scsrvs) {
		setAttrVal("Name_scsrvs", Name_scsrvs);
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
		return "Id_release_ruleitm";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_release_rule_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScReleaseRuleItmDODesc.class);
	}
	
}