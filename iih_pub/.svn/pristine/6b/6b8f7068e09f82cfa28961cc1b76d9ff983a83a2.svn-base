package iih.ems.emcm.upkeep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.emcm.upkeep.d.desc.EmsUpkeepDODesc;
import java.math.BigDecimal;

/**
 * 设备保养记录 DO数据 
 * 
 */
public class EmsUpkeepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//保养记录主键
	public static final String ID_UK= "Id_uk";
	//资产卡
	public static final String ID_CARD= "Id_card";
	//资产卡号
	public static final String CARD_NO= "Card_no";
	//资产名称
	public static final String CARD_NAME= "Card_name";
	//设备分类
	public static final String ID_EMCA= "Id_emca";
	//设备基本信息
	public static final String ID_EM= "Id_em";
	//设备分类树内码
	public static final String EMCA_INRCODE= "Emca_inrcode";
	//计划保养时间
	public static final String DT_PLAN_UPKEEP= "Dt_plan_upkeep";
	//实际保养时间
	public static final String DT_UPKEEP= "Dt_upkeep";
	//保养类别
	public static final String ID_UPKEEP_TYPE= "Id_upkeep_type";
	//保养类别编码
	public static final String SD_UPKEEP_TYPE= "Sd_upkeep_type";
	//保养内容
	public static final String UPKEEP_CONTENT= "Upkeep_content";
	//保养部位
	public static final String UPKEEP_PART= "Upkeep_part";
	//保养单状态
	public static final String ID_ST= "Id_st";
	//保养单状态编码
	public static final String SD_ST= "Sd_st";
	//指派保养人员
	public static final String ID_EMP_UK= "Id_emp_uk";
	//保养建议
	public static final String UK_SUGG= "Uk_sugg";
	//保养结果
	public static final String ID_UK_RLT= "Id_uk_rlt";
	//保养结果编码
	public static final String SD_UK_RLT= "Sd_uk_rlt";
	//对应维修记录流水号
	public static final String ID_REPAIR= "Id_repair";
	//操作时间
	public static final String DT_OPER= "Dt_oper";
	//操作员
	public static final String ID_OPER= "Id_oper";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//名称
	public static final String NAME_EMCA= "Name_emca";
	//设备名称
	public static final String NAME_EM= "Name_em";
	//名称
	public static final String NAME_UKTP= "Name_uktp";
	//名称
	public static final String NAME_ST= "Name_st";
	//姓名
	public static final String NAME_EMP_UK= "Name_emp_uk";
	//名称
	public static final String NAME_UK_RLT= "Name_uk_rlt";
	//姓名
	public static final String NAME_OPER= "Name_oper";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 保养记录主键
	 * @return String
	 */
	public String getId_uk() {
		return ((String) getAttrVal("Id_uk"));
	}	
	/**
	 * 保养记录主键
	 * @param Id_uk
	 */
	public void setId_uk(String Id_uk) {
		setAttrVal("Id_uk", Id_uk);
	}
	/**
	 * 资产卡
	 * @return String
	 */
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}	
	/**
	 * 资产卡
	 * @param Id_card
	 */
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
	}
	/**
	 * 资产卡号
	 * @return String
	 */
	public String getCard_no() {
		return ((String) getAttrVal("Card_no"));
	}	
	/**
	 * 资产卡号
	 * @param Card_no
	 */
	public void setCard_no(String Card_no) {
		setAttrVal("Card_no", Card_no);
	}
	/**
	 * 资产名称
	 * @return String
	 */
	public String getCard_name() {
		return ((String) getAttrVal("Card_name"));
	}	
	/**
	 * 资产名称
	 * @param Card_name
	 */
	public void setCard_name(String Card_name) {
		setAttrVal("Card_name", Card_name);
	}
	/**
	 * 设备分类
	 * @return String
	 */
	public String getId_emca() {
		return ((String) getAttrVal("Id_emca"));
	}	
	/**
	 * 设备分类
	 * @param Id_emca
	 */
	public void setId_emca(String Id_emca) {
		setAttrVal("Id_emca", Id_emca);
	}
	/**
	 * 设备基本信息
	 * @return String
	 */
	public String getId_em() {
		return ((String) getAttrVal("Id_em"));
	}	
	/**
	 * 设备基本信息
	 * @param Id_em
	 */
	public void setId_em(String Id_em) {
		setAttrVal("Id_em", Id_em);
	}
	/**
	 * 设备分类树内码
	 * @return String
	 */
	public String getEmca_inrcode() {
		return ((String) getAttrVal("Emca_inrcode"));
	}	
	/**
	 * 设备分类树内码
	 * @param Emca_inrcode
	 */
	public void setEmca_inrcode(String Emca_inrcode) {
		setAttrVal("Emca_inrcode", Emca_inrcode);
	}
	/**
	 * 计划保养时间
	 * @return FDate
	 */
	public FDate getDt_plan_upkeep() {
		return ((FDate) getAttrVal("Dt_plan_upkeep"));
	}	
	/**
	 * 计划保养时间
	 * @param Dt_plan_upkeep
	 */
	public void setDt_plan_upkeep(FDate Dt_plan_upkeep) {
		setAttrVal("Dt_plan_upkeep", Dt_plan_upkeep);
	}
	/**
	 * 实际保养时间
	 * @return FDate
	 */
	public FDate getDt_upkeep() {
		return ((FDate) getAttrVal("Dt_upkeep"));
	}	
	/**
	 * 实际保养时间
	 * @param Dt_upkeep
	 */
	public void setDt_upkeep(FDate Dt_upkeep) {
		setAttrVal("Dt_upkeep", Dt_upkeep);
	}
	/**
	 * 保养类别
	 * @return String
	 */
	public String getId_upkeep_type() {
		return ((String) getAttrVal("Id_upkeep_type"));
	}	
	/**
	 * 保养类别
	 * @param Id_upkeep_type
	 */
	public void setId_upkeep_type(String Id_upkeep_type) {
		setAttrVal("Id_upkeep_type", Id_upkeep_type);
	}
	/**
	 * 保养类别编码
	 * @return String
	 */
	public String getSd_upkeep_type() {
		return ((String) getAttrVal("Sd_upkeep_type"));
	}	
	/**
	 * 保养类别编码
	 * @param Sd_upkeep_type
	 */
	public void setSd_upkeep_type(String Sd_upkeep_type) {
		setAttrVal("Sd_upkeep_type", Sd_upkeep_type);
	}
	/**
	 * 保养内容
	 * @return String
	 */
	public String getUpkeep_content() {
		return ((String) getAttrVal("Upkeep_content"));
	}	
	/**
	 * 保养内容
	 * @param Upkeep_content
	 */
	public void setUpkeep_content(String Upkeep_content) {
		setAttrVal("Upkeep_content", Upkeep_content);
	}
	/**
	 * 保养部位
	 * @return String
	 */
	public String getUpkeep_part() {
		return ((String) getAttrVal("Upkeep_part"));
	}	
	/**
	 * 保养部位
	 * @param Upkeep_part
	 */
	public void setUpkeep_part(String Upkeep_part) {
		setAttrVal("Upkeep_part", Upkeep_part);
	}
	/**
	 * 保养单状态
	 * @return String
	 */
	public String getId_st() {
		return ((String) getAttrVal("Id_st"));
	}	
	/**
	 * 保养单状态
	 * @param Id_st
	 */
	public void setId_st(String Id_st) {
		setAttrVal("Id_st", Id_st);
	}
	/**
	 * 保养单状态编码
	 * @return String
	 */
	public String getSd_st() {
		return ((String) getAttrVal("Sd_st"));
	}	
	/**
	 * 保养单状态编码
	 * @param Sd_st
	 */
	public void setSd_st(String Sd_st) {
		setAttrVal("Sd_st", Sd_st);
	}
	/**
	 * 指派保养人员
	 * @return String
	 */
	public String getId_emp_uk() {
		return ((String) getAttrVal("Id_emp_uk"));
	}	
	/**
	 * 指派保养人员
	 * @param Id_emp_uk
	 */
	public void setId_emp_uk(String Id_emp_uk) {
		setAttrVal("Id_emp_uk", Id_emp_uk);
	}
	/**
	 * 保养建议
	 * @return String
	 */
	public String getUk_sugg() {
		return ((String) getAttrVal("Uk_sugg"));
	}	
	/**
	 * 保养建议
	 * @param Uk_sugg
	 */
	public void setUk_sugg(String Uk_sugg) {
		setAttrVal("Uk_sugg", Uk_sugg);
	}
	/**
	 * 保养结果
	 * @return String
	 */
	public String getId_uk_rlt() {
		return ((String) getAttrVal("Id_uk_rlt"));
	}	
	/**
	 * 保养结果
	 * @param Id_uk_rlt
	 */
	public void setId_uk_rlt(String Id_uk_rlt) {
		setAttrVal("Id_uk_rlt", Id_uk_rlt);
	}
	/**
	 * 保养结果编码
	 * @return String
	 */
	public String getSd_uk_rlt() {
		return ((String) getAttrVal("Sd_uk_rlt"));
	}	
	/**
	 * 保养结果编码
	 * @param Sd_uk_rlt
	 */
	public void setSd_uk_rlt(String Sd_uk_rlt) {
		setAttrVal("Sd_uk_rlt", Sd_uk_rlt);
	}
	/**
	 * 对应维修记录流水号
	 * @return String
	 */
	public String getId_repair() {
		return ((String) getAttrVal("Id_repair"));
	}	
	/**
	 * 对应维修记录流水号
	 * @param Id_repair
	 */
	public void setId_repair(String Id_repair) {
		setAttrVal("Id_repair", Id_repair);
	}
	/**
	 * 操作时间
	 * @return FDate
	 */
	public FDate getDt_oper() {
		return ((FDate) getAttrVal("Dt_oper"));
	}	
	/**
	 * 操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDate Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 操作员
	 * @return String
	 */
	public String getId_oper() {
		return ((String) getAttrVal("Id_oper"));
	}	
	/**
	 * 操作员
	 * @param Id_oper
	 */
	public void setId_oper(String Id_oper) {
		setAttrVal("Id_oper", Id_oper);
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
	 * 名称
	 * @return String
	 */
	public String getName_emca() {
		return ((String) getAttrVal("Name_emca"));
	}	
	/**
	 * 名称
	 * @param Name_emca
	 */
	public void setName_emca(String Name_emca) {
		setAttrVal("Name_emca", Name_emca);
	}
	/**
	 * 设备名称
	 * @return String
	 */
	public String getName_em() {
		return ((String) getAttrVal("Name_em"));
	}	
	/**
	 * 设备名称
	 * @param Name_em
	 */
	public void setName_em(String Name_em) {
		setAttrVal("Name_em", Name_em);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_uktp() {
		return ((String) getAttrVal("Name_uktp"));
	}	
	/**
	 * 名称
	 * @param Name_uktp
	 */
	public void setName_uktp(String Name_uktp) {
		setAttrVal("Name_uktp", Name_uktp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_st() {
		return ((String) getAttrVal("Name_st"));
	}	
	/**
	 * 名称
	 * @param Name_st
	 */
	public void setName_st(String Name_st) {
		setAttrVal("Name_st", Name_st);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_uk() {
		return ((String) getAttrVal("Name_emp_uk"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_uk
	 */
	public void setName_emp_uk(String Name_emp_uk) {
		setAttrVal("Name_emp_uk", Name_emp_uk);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_uk_rlt() {
		return ((String) getAttrVal("Name_uk_rlt"));
	}	
	/**
	 * 名称
	 * @param Name_uk_rlt
	 */
	public void setName_uk_rlt(String Name_uk_rlt) {
		setAttrVal("Name_uk_rlt", Name_uk_rlt);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_oper() {
		return ((String) getAttrVal("Name_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_oper
	 */
	public void setName_oper(String Name_oper) {
		setAttrVal("Name_oper", Name_oper);
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
		return "Id_uk";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_uk";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsUpkeepDODesc.class);
	}
	
}