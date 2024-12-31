package iih.sfda.aer.sfdaaerevinstrument.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevinstrument.d.desc.SfdaAerEvInstrumentDODesc;
import java.math.BigDecimal;

/**
 * 医疗器械事件 DO数据 
 * 
 */
public class SfdaAerEvInstrumentDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗器械事件主键
	public static final String ID_AER_EV_INSTRUMENT= "Id_aer_ev_instrument";
	//不良事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//事件主要表现
	public static final String EVENT_DES= "Event_des";
	//发现或者知悉时间
	public static final String DIS_KNOWN_TIME= "Dis_known_time";
	//医疗器械实际使用场所id
	public static final String ID_INSTR_SITE= "Id_instr_site";
	//医疗器械实际使用场所编码
	public static final String SD_INSTR_SITE= "Sd_instr_site";
	//其他医疗器械实际使用场所
	public static final String OTH_INSTR_SITE= "Oth_instr_site";
	//事件后果id
	public static final String ID_EVENT_CONSEQUENCE= "Id_event_consequence";
	//事件后果编码
	public static final String SD_EVENT_CONSEQUENCE= "Sd_event_consequence";
	//死亡时间
	public static final String DEATH_TIME= "Death_time";
	//事件陈诉
	public static final String EVENT_STATE= "Event_state";
	//产品名称
	public static final String PRODUCT_NAME= "Product_name";
	//商品名称
	public static final String PROD_NAME= "Prod_name";
	//注册证号
	public static final String REG_NUMBER= "Reg_number";
	//生产企业名称
	public static final String MANU_NAME= "Manu_name";
	//生产企业地址
	public static final String MANU_SITE= "Manu_site";
	//企业联系电话
	public static final String MANU_PHONE= "Manu_phone";
	//型号规格
	public static final String SPEC_TYPE= "Spec_type";
	//产品编号
	public static final String PRODUCT_NUMBER= "Product_number";
	//产品批号
	public static final String PRODUCT_BAT_NUMBER= "Product_bat_number";
	//操作人id
	public static final String ID_OPERATOR= "Id_operator";
	//操作人编码
	public static final String SD_OPERATOR= "Sd_operator";
	//其他操作人说明
	public static final String OTH_OPERATOR= "Oth_operator";
	//有效日期
	public static final String EFFECT_DATE= "Effect_date";
	//生产日期
	public static final String PROD_DATE= "Prod_date";
	//停用日期
	public static final String STOP_DATE= "Stop_date";
	//植入日期
	public static final String IMPLA_DATE= "Impla_date";
	//事件发生初步原因分析
	public static final String EVENT_INIT_ANALYZE= "Event_init_analyze";
	//事件初步处理情况
	public static final String EVENT_INIT_DISPOSE= "Event_init_dispose";
	//事件报告状态id
	public static final String ID_EVENT_STATE= "Id_event_state";
	//事件报告状态编码
	public static final String SD_EVENT_STATE= "Sd_event_state";
	//省级监测技术机构评价意见
	public static final String PROV_OPINION= "Prov_opinion";
	//国家监测技术机构评价意见
	public static final String STATE_OPINION= "State_opinion";
	//客户扩展字段1
	public static final String DEF1= "Def1";
	//客户扩展字段2
	public static final String DEF2= "Def2";
	//客户扩展字段3
	public static final String DEF3= "Def3";
	//客户扩展字段4
	public static final String DEF4= "Def4";
	//客户扩展字段5
	public static final String DEF5= "Def5";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_INSTR_SITE= "Name_instr_site";
	//名称
	public static final String NAME_EVENT_CONSEQUENCE= "Name_event_consequence";
	//名称
	public static final String NAME_OPERATOR= "Name_operator";
	//名称
	public static final String NAME_EVENT_STATE= "Name_event_state";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗器械事件主键
	 * @return String
	 */
	public String getId_aer_ev_instrument() {
		return ((String) getAttrVal("Id_aer_ev_instrument"));
	}	
	/**
	 * 医疗器械事件主键
	 * @param Id_aer_ev_instrument
	 */
	public void setId_aer_ev_instrument(String Id_aer_ev_instrument) {
		setAttrVal("Id_aer_ev_instrument", Id_aer_ev_instrument);
	}
	/**
	 * 不良事件外键
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 不良事件外键
	 * @param Id_aer_ev
	 */
	public void setId_aer_ev(String Id_aer_ev) {
		setAttrVal("Id_aer_ev", Id_aer_ev);
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
	 * 事件主要表现
	 * @return String
	 */
	public String getEvent_des() {
		return ((String) getAttrVal("Event_des"));
	}	
	/**
	 * 事件主要表现
	 * @param Event_des
	 */
	public void setEvent_des(String Event_des) {
		setAttrVal("Event_des", Event_des);
	}
	/**
	 * 发现或者知悉时间
	 * @return FDateTime
	 */
	public FDateTime getDis_known_time() {
		return ((FDateTime) getAttrVal("Dis_known_time"));
	}	
	/**
	 * 发现或者知悉时间
	 * @param Dis_known_time
	 */
	public void setDis_known_time(FDateTime Dis_known_time) {
		setAttrVal("Dis_known_time", Dis_known_time);
	}
	/**
	 * 医疗器械实际使用场所id
	 * @return String
	 */
	public String getId_instr_site() {
		return ((String) getAttrVal("Id_instr_site"));
	}	
	/**
	 * 医疗器械实际使用场所id
	 * @param Id_instr_site
	 */
	public void setId_instr_site(String Id_instr_site) {
		setAttrVal("Id_instr_site", Id_instr_site);
	}
	/**
	 * 医疗器械实际使用场所编码
	 * @return String
	 */
	public String getSd_instr_site() {
		return ((String) getAttrVal("Sd_instr_site"));
	}	
	/**
	 * 医疗器械实际使用场所编码
	 * @param Sd_instr_site
	 */
	public void setSd_instr_site(String Sd_instr_site) {
		setAttrVal("Sd_instr_site", Sd_instr_site);
	}
	/**
	 * 其他医疗器械实际使用场所
	 * @return String
	 */
	public String getOth_instr_site() {
		return ((String) getAttrVal("Oth_instr_site"));
	}	
	/**
	 * 其他医疗器械实际使用场所
	 * @param Oth_instr_site
	 */
	public void setOth_instr_site(String Oth_instr_site) {
		setAttrVal("Oth_instr_site", Oth_instr_site);
	}
	/**
	 * 事件后果id
	 * @return String
	 */
	public String getId_event_consequence() {
		return ((String) getAttrVal("Id_event_consequence"));
	}	
	/**
	 * 事件后果id
	 * @param Id_event_consequence
	 */
	public void setId_event_consequence(String Id_event_consequence) {
		setAttrVal("Id_event_consequence", Id_event_consequence);
	}
	/**
	 * 事件后果编码
	 * @return String
	 */
	public String getSd_event_consequence() {
		return ((String) getAttrVal("Sd_event_consequence"));
	}	
	/**
	 * 事件后果编码
	 * @param Sd_event_consequence
	 */
	public void setSd_event_consequence(String Sd_event_consequence) {
		setAttrVal("Sd_event_consequence", Sd_event_consequence);
	}
	/**
	 * 死亡时间
	 * @return FDateTime
	 */
	public FDateTime getDeath_time() {
		return ((FDateTime) getAttrVal("Death_time"));
	}	
	/**
	 * 死亡时间
	 * @param Death_time
	 */
	public void setDeath_time(FDateTime Death_time) {
		setAttrVal("Death_time", Death_time);
	}
	/**
	 * 事件陈诉
	 * @return String
	 */
	public String getEvent_state() {
		return ((String) getAttrVal("Event_state"));
	}	
	/**
	 * 事件陈诉
	 * @param Event_state
	 */
	public void setEvent_state(String Event_state) {
		setAttrVal("Event_state", Event_state);
	}
	/**
	 * 产品名称
	 * @return String
	 */
	public String getProduct_name() {
		return ((String) getAttrVal("Product_name"));
	}	
	/**
	 * 产品名称
	 * @param Product_name
	 */
	public void setProduct_name(String Product_name) {
		setAttrVal("Product_name", Product_name);
	}
	/**
	 * 商品名称
	 * @return String
	 */
	public String getProd_name() {
		return ((String) getAttrVal("Prod_name"));
	}	
	/**
	 * 商品名称
	 * @param Prod_name
	 */
	public void setProd_name(String Prod_name) {
		setAttrVal("Prod_name", Prod_name);
	}
	/**
	 * 注册证号
	 * @return String
	 */
	public String getReg_number() {
		return ((String) getAttrVal("Reg_number"));
	}	
	/**
	 * 注册证号
	 * @param Reg_number
	 */
	public void setReg_number(String Reg_number) {
		setAttrVal("Reg_number", Reg_number);
	}
	/**
	 * 生产企业名称
	 * @return String
	 */
	public String getManu_name() {
		return ((String) getAttrVal("Manu_name"));
	}	
	/**
	 * 生产企业名称
	 * @param Manu_name
	 */
	public void setManu_name(String Manu_name) {
		setAttrVal("Manu_name", Manu_name);
	}
	/**
	 * 生产企业地址
	 * @return String
	 */
	public String getManu_site() {
		return ((String) getAttrVal("Manu_site"));
	}	
	/**
	 * 生产企业地址
	 * @param Manu_site
	 */
	public void setManu_site(String Manu_site) {
		setAttrVal("Manu_site", Manu_site);
	}
	/**
	 * 企业联系电话
	 * @return String
	 */
	public String getManu_phone() {
		return ((String) getAttrVal("Manu_phone"));
	}	
	/**
	 * 企业联系电话
	 * @param Manu_phone
	 */
	public void setManu_phone(String Manu_phone) {
		setAttrVal("Manu_phone", Manu_phone);
	}
	/**
	 * 型号规格
	 * @return String
	 */
	public String getSpec_type() {
		return ((String) getAttrVal("Spec_type"));
	}	
	/**
	 * 型号规格
	 * @param Spec_type
	 */
	public void setSpec_type(String Spec_type) {
		setAttrVal("Spec_type", Spec_type);
	}
	/**
	 * 产品编号
	 * @return String
	 */
	public String getProduct_number() {
		return ((String) getAttrVal("Product_number"));
	}	
	/**
	 * 产品编号
	 * @param Product_number
	 */
	public void setProduct_number(String Product_number) {
		setAttrVal("Product_number", Product_number);
	}
	/**
	 * 产品批号
	 * @return String
	 */
	public String getProduct_bat_number() {
		return ((String) getAttrVal("Product_bat_number"));
	}	
	/**
	 * 产品批号
	 * @param Product_bat_number
	 */
	public void setProduct_bat_number(String Product_bat_number) {
		setAttrVal("Product_bat_number", Product_bat_number);
	}
	/**
	 * 操作人id
	 * @return String
	 */
	public String getId_operator() {
		return ((String) getAttrVal("Id_operator"));
	}	
	/**
	 * 操作人id
	 * @param Id_operator
	 */
	public void setId_operator(String Id_operator) {
		setAttrVal("Id_operator", Id_operator);
	}
	/**
	 * 操作人编码
	 * @return String
	 */
	public String getSd_operator() {
		return ((String) getAttrVal("Sd_operator"));
	}	
	/**
	 * 操作人编码
	 * @param Sd_operator
	 */
	public void setSd_operator(String Sd_operator) {
		setAttrVal("Sd_operator", Sd_operator);
	}
	/**
	 * 其他操作人说明
	 * @return String
	 */
	public String getOth_operator() {
		return ((String) getAttrVal("Oth_operator"));
	}	
	/**
	 * 其他操作人说明
	 * @param Oth_operator
	 */
	public void setOth_operator(String Oth_operator) {
		setAttrVal("Oth_operator", Oth_operator);
	}
	/**
	 * 有效日期
	 * @return FDateTime
	 */
	public FDateTime getEffect_date() {
		return ((FDateTime) getAttrVal("Effect_date"));
	}	
	/**
	 * 有效日期
	 * @param Effect_date
	 */
	public void setEffect_date(FDateTime Effect_date) {
		setAttrVal("Effect_date", Effect_date);
	}
	/**
	 * 生产日期
	 * @return FDateTime
	 */
	public FDateTime getProd_date() {
		return ((FDateTime) getAttrVal("Prod_date"));
	}	
	/**
	 * 生产日期
	 * @param Prod_date
	 */
	public void setProd_date(FDateTime Prod_date) {
		setAttrVal("Prod_date", Prod_date);
	}
	/**
	 * 停用日期
	 * @return FDateTime
	 */
	public FDateTime getStop_date() {
		return ((FDateTime) getAttrVal("Stop_date"));
	}	
	/**
	 * 停用日期
	 * @param Stop_date
	 */
	public void setStop_date(FDateTime Stop_date) {
		setAttrVal("Stop_date", Stop_date);
	}
	/**
	 * 植入日期
	 * @return FDateTime
	 */
	public FDateTime getImpla_date() {
		return ((FDateTime) getAttrVal("Impla_date"));
	}	
	/**
	 * 植入日期
	 * @param Impla_date
	 */
	public void setImpla_date(FDateTime Impla_date) {
		setAttrVal("Impla_date", Impla_date);
	}
	/**
	 * 事件发生初步原因分析
	 * @return String
	 */
	public String getEvent_init_analyze() {
		return ((String) getAttrVal("Event_init_analyze"));
	}	
	/**
	 * 事件发生初步原因分析
	 * @param Event_init_analyze
	 */
	public void setEvent_init_analyze(String Event_init_analyze) {
		setAttrVal("Event_init_analyze", Event_init_analyze);
	}
	/**
	 * 事件初步处理情况
	 * @return String
	 */
	public String getEvent_init_dispose() {
		return ((String) getAttrVal("Event_init_dispose"));
	}	
	/**
	 * 事件初步处理情况
	 * @param Event_init_dispose
	 */
	public void setEvent_init_dispose(String Event_init_dispose) {
		setAttrVal("Event_init_dispose", Event_init_dispose);
	}
	/**
	 * 事件报告状态id
	 * @return String
	 */
	public String getId_event_state() {
		return ((String) getAttrVal("Id_event_state"));
	}	
	/**
	 * 事件报告状态id
	 * @param Id_event_state
	 */
	public void setId_event_state(String Id_event_state) {
		setAttrVal("Id_event_state", Id_event_state);
	}
	/**
	 * 事件报告状态编码
	 * @return String
	 */
	public String getSd_event_state() {
		return ((String) getAttrVal("Sd_event_state"));
	}	
	/**
	 * 事件报告状态编码
	 * @param Sd_event_state
	 */
	public void setSd_event_state(String Sd_event_state) {
		setAttrVal("Sd_event_state", Sd_event_state);
	}
	/**
	 * 省级监测技术机构评价意见
	 * @return String
	 */
	public String getProv_opinion() {
		return ((String) getAttrVal("Prov_opinion"));
	}	
	/**
	 * 省级监测技术机构评价意见
	 * @param Prov_opinion
	 */
	public void setProv_opinion(String Prov_opinion) {
		setAttrVal("Prov_opinion", Prov_opinion);
	}
	/**
	 * 国家监测技术机构评价意见
	 * @return String
	 */
	public String getState_opinion() {
		return ((String) getAttrVal("State_opinion"));
	}	
	/**
	 * 国家监测技术机构评价意见
	 * @param State_opinion
	 */
	public void setState_opinion(String State_opinion) {
		setAttrVal("State_opinion", State_opinion);
	}
	/**
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 客户扩展字段2
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
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
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
	/**
	 * 名称
	 * @return String
	 */
	public String getName_instr_site() {
		return ((String) getAttrVal("Name_instr_site"));
	}	
	/**
	 * 名称
	 * @param Name_instr_site
	 */
	public void setName_instr_site(String Name_instr_site) {
		setAttrVal("Name_instr_site", Name_instr_site);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_event_consequence() {
		return ((String) getAttrVal("Name_event_consequence"));
	}	
	/**
	 * 名称
	 * @param Name_event_consequence
	 */
	public void setName_event_consequence(String Name_event_consequence) {
		setAttrVal("Name_event_consequence", Name_event_consequence);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_operator() {
		return ((String) getAttrVal("Name_operator"));
	}	
	/**
	 * 名称
	 * @param Name_operator
	 */
	public void setName_operator(String Name_operator) {
		setAttrVal("Name_operator", Name_operator);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_event_state() {
		return ((String) getAttrVal("Name_event_state"));
	}	
	/**
	 * 名称
	 * @param Name_event_state
	 */
	public void setName_event_state(String Name_event_state) {
		setAttrVal("Name_event_state", Name_event_state);
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
		return "Id_aer_ev_instrument";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_INSTRUMENT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvInstrumentDODesc.class);
	}
	
}