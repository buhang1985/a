package iih.bd.srv.autoitm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.autoitm.d.desc.AutoItmDODesc;
import java.math.BigDecimal;

/**
 * 自动质控控制表 DO数据 
 * 
 */
public class AutoItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_QA_ITM_CONFIG= "Id_qa_itm_config";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//质控项目
	public static final String ID_QA_ITM= "Id_qa_itm";
	//自动质控项说明
	public static final String REQ= "Req";
	//医疗记录自定义分类
	public static final String ID_MRCACTM= "Id_mrcactm";
	//模板段落
	public static final String ID_DATAGRP= "Id_datagrp";
	//数据组编码
	public static final String SD_DATAGRP= "Sd_datagrp";
	//循环次数
	public static final String TIMES_FOR= "Times_for";
	//提前预警
	public static final String HOURS_WARNING= "Hours_warning";
	//病历文书类型
	public static final String ID_MR_TYPES= "Id_mr_types";
	//事件类型
	public static final String EVENT_TYPE_CODE= "Event_type_code";
	//期限时间
	public static final String HOURS_DEAD= "Hours_dead";
	//启用标记
	public static final String FG_ACTIVE= "Fg_active";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//文件操作类型
	public static final String ID_MR_OP_TYPE= "Id_mr_op_type";
	//文件操作类型编码
	public static final String SD_MR_OP_TYPE= "Sd_mr_op_type";
	//循环标识
	public static final String FG_LOOP= "Fg_loop";
	//是否必备
	public static final String FG_MUST= "Fg_must";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//是否可替代
	public static final String FG_CHANGE= "Fg_change";
	//可替代医疗记录类型
	public static final String ID_MRTP_CHANGE= "Id_mrtp_change";
	//是否医务审核项
	public static final String FG_PERFORMANCE= "Fg_performance";
	//区间内文书份数
	public static final String TIMES_REGION= "Times_region";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//编码
	public static final String MRCACTM_CODE= "Mrcactm_code";
	//名称
	public static final String MRCACTM_NAME= "Mrcactm_name";
	//数据组编码
	public static final String DATAGRP_CODE= "Datagrp_code";
	//数据组名称
	public static final String DATAGRP_NAME= "Datagrp_name";
	//医疗记录类型编码
	public static final String MR_TYPES_CODE= "Mr_types_code";
	//医疗记录类型名称
	public static final String MR_TYPES_NAME= "Mr_types_name";
	//事件名称
	public static final String EVENT_NAME= "Event_name";
	//用户名称
	public static final String CREATEBY_NAME= "Createby_name";
	//用户编码
	public static final String CREATEBY_CODE= "Createby_code";
	//用户名称
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	//用户编码
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	//医疗记录类型名称
	public static final String MRTP_CHANGE_NAME= "Mrtp_change_name";
	//医疗记录类型编码
	public static final String MRTP_CHANGE_CODE= "Mrtp_change_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_qa_itm_config() {
		return ((String) getAttrVal("Id_qa_itm_config"));
	}	
	/**
	 * 主键
	 * @param Id_qa_itm_config
	 */
	public void setId_qa_itm_config(String Id_qa_itm_config) {
		setAttrVal("Id_qa_itm_config", Id_qa_itm_config);
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
	 * 质控项目
	 * @return String
	 */
	public String getId_qa_itm() {
		return ((String) getAttrVal("Id_qa_itm"));
	}	
	/**
	 * 质控项目
	 * @param Id_qa_itm
	 */
	public void setId_qa_itm(String Id_qa_itm) {
		setAttrVal("Id_qa_itm", Id_qa_itm);
	}
	/**
	 * 自动质控项说明
	 * @return String
	 */
	public String getReq() {
		return ((String) getAttrVal("Req"));
	}	
	/**
	 * 自动质控项说明
	 * @param Req
	 */
	public void setReq(String Req) {
		setAttrVal("Req", Req);
	}
	/**
	 * 医疗记录自定义分类
	 * @return String
	 */
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}	
	/**
	 * 医疗记录自定义分类
	 * @param Id_mrcactm
	 */
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
	}
	/**
	 * 模板段落
	 * @return String
	 */
	public String getId_datagrp() {
		return ((String) getAttrVal("Id_datagrp"));
	}	
	/**
	 * 模板段落
	 * @param Id_datagrp
	 */
	public void setId_datagrp(String Id_datagrp) {
		setAttrVal("Id_datagrp", Id_datagrp);
	}
	/**
	 * 数据组编码
	 * @return String
	 */
	public String getSd_datagrp() {
		return ((String) getAttrVal("Sd_datagrp"));
	}	
	/**
	 * 数据组编码
	 * @param Sd_datagrp
	 */
	public void setSd_datagrp(String Sd_datagrp) {
		setAttrVal("Sd_datagrp", Sd_datagrp);
	}
	/**
	 * 循环次数
	 * @return Integer
	 */
	public Integer getTimes_for() {
		return ((Integer) getAttrVal("Times_for"));
	}	
	/**
	 * 循环次数
	 * @param Times_for
	 */
	public void setTimes_for(Integer Times_for) {
		setAttrVal("Times_for", Times_for);
	}
	/**
	 * 提前预警
	 * @return Integer
	 */
	public Integer getHours_warning() {
		return ((Integer) getAttrVal("Hours_warning"));
	}	
	/**
	 * 提前预警
	 * @param Hours_warning
	 */
	public void setHours_warning(Integer Hours_warning) {
		setAttrVal("Hours_warning", Hours_warning);
	}
	/**
	 * 病历文书类型
	 * @return String
	 */
	public String getId_mr_types() {
		return ((String) getAttrVal("Id_mr_types"));
	}	
	/**
	 * 病历文书类型
	 * @param Id_mr_types
	 */
	public void setId_mr_types(String Id_mr_types) {
		setAttrVal("Id_mr_types", Id_mr_types);
	}
	/**
	 * 事件类型
	 * @return String
	 */
	public String getEvent_type_code() {
		return ((String) getAttrVal("Event_type_code"));
	}	
	/**
	 * 事件类型
	 * @param Event_type_code
	 */
	public void setEvent_type_code(String Event_type_code) {
		setAttrVal("Event_type_code", Event_type_code);
	}
	/**
	 * 期限时间
	 * @return Integer
	 */
	public Integer getHours_dead() {
		return ((Integer) getAttrVal("Hours_dead"));
	}	
	/**
	 * 期限时间
	 * @param Hours_dead
	 */
	public void setHours_dead(Integer Hours_dead) {
		setAttrVal("Hours_dead", Hours_dead);
	}
	/**
	 * 启用标记
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标记
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 文件操作类型
	 * @return String
	 */
	public String getId_mr_op_type() {
		return ((String) getAttrVal("Id_mr_op_type"));
	}	
	/**
	 * 文件操作类型
	 * @param Id_mr_op_type
	 */
	public void setId_mr_op_type(String Id_mr_op_type) {
		setAttrVal("Id_mr_op_type", Id_mr_op_type);
	}
	/**
	 * 文件操作类型编码
	 * @return String
	 */
	public String getSd_mr_op_type() {
		return ((String) getAttrVal("Sd_mr_op_type"));
	}	
	/**
	 * 文件操作类型编码
	 * @param Sd_mr_op_type
	 */
	public void setSd_mr_op_type(String Sd_mr_op_type) {
		setAttrVal("Sd_mr_op_type", Sd_mr_op_type);
	}
	/**
	 * 循环标识
	 * @return FBoolean
	 */
	public FBoolean getFg_loop() {
		return ((FBoolean) getAttrVal("Fg_loop"));
	}	
	/**
	 * 循环标识
	 * @param Fg_loop
	 */
	public void setFg_loop(FBoolean Fg_loop) {
		setAttrVal("Fg_loop", Fg_loop);
	}
	/**
	 * 是否必备
	 * @return String
	 */
	public String getFg_must() {
		return ((String) getAttrVal("Fg_must"));
	}	
	/**
	 * 是否必备
	 * @param Fg_must
	 */
	public void setFg_must(String Fg_must) {
		setAttrVal("Fg_must", Fg_must);
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
	 * 是否可替代
	 * @return FBoolean
	 */
	public FBoolean getFg_change() {
		return ((FBoolean) getAttrVal("Fg_change"));
	}	
	/**
	 * 是否可替代
	 * @param Fg_change
	 */
	public void setFg_change(FBoolean Fg_change) {
		setAttrVal("Fg_change", Fg_change);
	}
	/**
	 * 可替代医疗记录类型
	 * @return String
	 */
	public String getId_mrtp_change() {
		return ((String) getAttrVal("Id_mrtp_change"));
	}	
	/**
	 * 可替代医疗记录类型
	 * @param Id_mrtp_change
	 */
	public void setId_mrtp_change(String Id_mrtp_change) {
		setAttrVal("Id_mrtp_change", Id_mrtp_change);
	}
	/**
	 * 是否医务审核项
	 * @return FBoolean
	 */
	public FBoolean getFg_performance() {
		return ((FBoolean) getAttrVal("Fg_performance"));
	}	
	/**
	 * 是否医务审核项
	 * @param Fg_performance
	 */
	public void setFg_performance(FBoolean Fg_performance) {
		setAttrVal("Fg_performance", Fg_performance);
	}
	/**
	 * 区间内文书份数
	 * @return Integer
	 */
	public Integer getTimes_region() {
		return ((Integer) getAttrVal("Times_region"));
	}	
	/**
	 * 区间内文书份数
	 * @param Times_region
	 */
	public void setTimes_region(Integer Times_region) {
		setAttrVal("Times_region", Times_region);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	/**
	 * 编码
	 * @param Grp_code
	 */
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	/**
	 * 名称
	 * @param Grp_name
	 */
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 组织编码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
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
	 * 编码
	 * @return String
	 */
	public String getMrcactm_code() {
		return ((String) getAttrVal("Mrcactm_code"));
	}	
	/**
	 * 编码
	 * @param Mrcactm_code
	 */
	public void setMrcactm_code(String Mrcactm_code) {
		setAttrVal("Mrcactm_code", Mrcactm_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMrcactm_name() {
		return ((String) getAttrVal("Mrcactm_name"));
	}	
	/**
	 * 名称
	 * @param Mrcactm_name
	 */
	public void setMrcactm_name(String Mrcactm_name) {
		setAttrVal("Mrcactm_name", Mrcactm_name);
	}
	/**
	 * 数据组编码
	 * @return String
	 */
	public String getDatagrp_code() {
		return ((String) getAttrVal("Datagrp_code"));
	}	
	/**
	 * 数据组编码
	 * @param Datagrp_code
	 */
	public void setDatagrp_code(String Datagrp_code) {
		setAttrVal("Datagrp_code", Datagrp_code);
	}
	/**
	 * 数据组名称
	 * @return String
	 */
	public String getDatagrp_name() {
		return ((String) getAttrVal("Datagrp_name"));
	}	
	/**
	 * 数据组名称
	 * @param Datagrp_name
	 */
	public void setDatagrp_name(String Datagrp_name) {
		setAttrVal("Datagrp_name", Datagrp_name);
	}
	/**
	 * 医疗记录类型编码
	 * @return String
	 */
	public String getMr_types_code() {
		return ((String) getAttrVal("Mr_types_code"));
	}	
	/**
	 * 医疗记录类型编码
	 * @param Mr_types_code
	 */
	public void setMr_types_code(String Mr_types_code) {
		setAttrVal("Mr_types_code", Mr_types_code);
	}
	/**
	 * 医疗记录类型名称
	 * @return String
	 */
	public String getMr_types_name() {
		return ((String) getAttrVal("Mr_types_name"));
	}	
	/**
	 * 医疗记录类型名称
	 * @param Mr_types_name
	 */
	public void setMr_types_name(String Mr_types_name) {
		setAttrVal("Mr_types_name", Mr_types_name);
	}
	/**
	 * 事件名称
	 * @return String
	 */
	public String getEvent_name() {
		return ((String) getAttrVal("Event_name"));
	}	
	/**
	 * 事件名称
	 * @param Event_name
	 */
	public void setEvent_name(String Event_name) {
		setAttrVal("Event_name", Event_name);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getCreateby_name() {
		return ((String) getAttrVal("Createby_name"));
	}	
	/**
	 * 用户名称
	 * @param Createby_name
	 */
	public void setCreateby_name(String Createby_name) {
		setAttrVal("Createby_name", Createby_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCreateby_code() {
		return ((String) getAttrVal("Createby_code"));
	}	
	/**
	 * 用户编码
	 * @param Createby_code
	 */
	public void setCreateby_code(String Createby_code) {
		setAttrVal("Createby_code", Createby_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getModifiedby_name() {
		return ((String) getAttrVal("Modifiedby_name"));
	}	
	/**
	 * 用户名称
	 * @param Modifiedby_name
	 */
	public void setModifiedby_name(String Modifiedby_name) {
		setAttrVal("Modifiedby_name", Modifiedby_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getModifiedby_code() {
		return ((String) getAttrVal("Modifiedby_code"));
	}	
	/**
	 * 用户编码
	 * @param Modifiedby_code
	 */
	public void setModifiedby_code(String Modifiedby_code) {
		setAttrVal("Modifiedby_code", Modifiedby_code);
	}
	/**
	 * 医疗记录类型名称
	 * @return String
	 */
	public String getMrtp_change_name() {
		return ((String) getAttrVal("Mrtp_change_name"));
	}	
	/**
	 * 医疗记录类型名称
	 * @param Mrtp_change_name
	 */
	public void setMrtp_change_name(String Mrtp_change_name) {
		setAttrVal("Mrtp_change_name", Mrtp_change_name);
	}
	/**
	 * 医疗记录类型编码
	 * @return String
	 */
	public String getMrtp_change_code() {
		return ((String) getAttrVal("Mrtp_change_code"));
	}	
	/**
	 * 医疗记录类型编码
	 * @param Mrtp_change_code
	 */
	public void setMrtp_change_code(String Mrtp_change_code) {
		setAttrVal("Mrtp_change_code", Mrtp_change_code);
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
		return "Id_qa_itm_config";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_qa_auto_itm_config";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AutoItmDODesc.class);
	}
	
}