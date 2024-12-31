package iih.ems.einv.emout.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.einv.emout.d.desc.EmsOutDODesc;
import java.math.BigDecimal;

/**
 * 设备出库单 DO数据 
 * 
 */
public class EmsOutDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//出库单流水号
	public static final String ID_OUT= "Id_out";
	//领用申请主键
	public static final String ID_DA= "Id_da";
	//是否红单
	public static final String FG_RED= "Fg_red";
	//出库单据号
	public static final String CODE= "Code";
	//出库名称
	public static final String NAME= "Name";
	//卡片流水号
	public static final String ID_CARD= "Id_card";
	//卡片编号
	public static final String CARD_NO= "Card_no";
	//资产名称
	public static final String CARD_NAME= "Card_name";
	//出库类型
	public static final String ID_OUT_TYPE= "Id_out_type";
	//出库类型编码
	public static final String SD_OUT_TYPE= "Sd_out_type";
	//出库分类
	public static final String ID_OUTCA= "Id_outca";
	//出库状态
	public static final String ID_STU= "Id_stu";
	//出库状态编码
	public static final String SD_STU= "Sd_stu";
	//出库科室
	public static final String ID_OUT_DEPT= "Id_out_dept";
	//出库金额
	public static final String OUT_COST= "Out_cost";
	//领用人
	public static final String ID_OPER= "Id_oper";
	//领用科室
	public static final String ID_DEPT= "Id_dept";
	//接收单位（调出用）
	public static final String INCEPT_UNIT= "Incept_unit";
	//保管人
	public static final String ID_STOR_OPER= "Id_stor_oper";
	//保管科室
	public static final String ID_STOR_DEPT= "Id_stor_dept";
	//保管仓库
	public static final String ID_STOR_WH= "Id_stor_wh";
	//资产用途
	public static final String ID_EM_USE= "Id_em_use";
	//资产用途编码
	public static final String SD_EM_USE= "Sd_em_use";
	//出库时间
	public static final String DT_DATE= "Dt_date";
	//出库操作员
	public static final String ID_OUT_OPER= "Id_out_oper";
	//保管地点
	public static final String SAVE_PLACE= "Save_place";
	//财务年月
	public static final String YEAR_MONTH= "Year_month";
	//是否已打印
	public static final String FG_PRINTED= "Fg_printed";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//确认人
	public static final String ID_CONF_OPER= "Id_conf_oper";
	//确认时间
	public static final String DT_CONF= "Dt_conf";
	//审核人
	public static final String ID_CHK_OPER= "Id_chk_oper";
	//审核时间
	public static final String DT_CHK= "Dt_chk";
	//审核意见
	public static final String CHK_DES= "Chk_des";
	//名称
	public static final String NAME_OUT_TP= "Name_out_tp";
	//名称
	public static final String NAME_OUTCA= "Name_outca";
	//名称
	public static final String NAME_STU= "Name_stu";
	//名称
	public static final String NAME_OUT_DEPT= "Name_out_dept";
	//姓名
	public static final String NAME_OPER= "Name_oper";
	//名称
	public static final String NAME_DEPT= "Name_dept";
	//姓名
	public static final String NAME_STOR_OPER= "Name_stor_oper";
	//名称
	public static final String NAME_STOR_DEPT= "Name_stor_dept";
	//仓库名称
	public static final String NAME_STOR_WH= "Name_stor_wh";
	//名称
	public static final String NAME_EM_USE= "Name_em_use";
	//姓名
	public static final String NAME_OUT_OPER= "Name_out_oper";
	//姓名
	public static final String NAME_CONF_OPER= "Name_conf_oper";
	//姓名
	public static final String NAME_CHK_OPER= "Name_chk_oper";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 出库单流水号
	 * @return String
	 */
	public String getId_out() {
		return ((String) getAttrVal("Id_out"));
	}	
	/**
	 * 出库单流水号
	 * @param Id_out
	 */
	public void setId_out(String Id_out) {
		setAttrVal("Id_out", Id_out);
	}
	/**
	 * 领用申请主键
	 * @return String
	 */
	public String getId_da() {
		return ((String) getAttrVal("Id_da"));
	}	
	/**
	 * 领用申请主键
	 * @param Id_da
	 */
	public void setId_da(String Id_da) {
		setAttrVal("Id_da", Id_da);
	}
	/**
	 * 是否红单
	 * @return FBoolean
	 */
	public FBoolean getFg_red() {
		return ((FBoolean) getAttrVal("Fg_red"));
	}	
	/**
	 * 是否红单
	 * @param Fg_red
	 */
	public void setFg_red(FBoolean Fg_red) {
		setAttrVal("Fg_red", Fg_red);
	}
	/**
	 * 出库单据号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 出库单据号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 出库名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 出库名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 卡片流水号
	 * @return String
	 */
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}	
	/**
	 * 卡片流水号
	 * @param Id_card
	 */
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
	}
	/**
	 * 卡片编号
	 * @return String
	 */
	public String getCard_no() {
		return ((String) getAttrVal("Card_no"));
	}	
	/**
	 * 卡片编号
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
	 * 出库类型
	 * @return String
	 */
	public String getId_out_type() {
		return ((String) getAttrVal("Id_out_type"));
	}	
	/**
	 * 出库类型
	 * @param Id_out_type
	 */
	public void setId_out_type(String Id_out_type) {
		setAttrVal("Id_out_type", Id_out_type);
	}
	/**
	 * 出库类型编码
	 * @return String
	 */
	public String getSd_out_type() {
		return ((String) getAttrVal("Sd_out_type"));
	}	
	/**
	 * 出库类型编码
	 * @param Sd_out_type
	 */
	public void setSd_out_type(String Sd_out_type) {
		setAttrVal("Sd_out_type", Sd_out_type);
	}
	/**
	 * 出库分类
	 * @return String
	 */
	public String getId_outca() {
		return ((String) getAttrVal("Id_outca"));
	}	
	/**
	 * 出库分类
	 * @param Id_outca
	 */
	public void setId_outca(String Id_outca) {
		setAttrVal("Id_outca", Id_outca);
	}
	/**
	 * 出库状态
	 * @return String
	 */
	public String getId_stu() {
		return ((String) getAttrVal("Id_stu"));
	}	
	/**
	 * 出库状态
	 * @param Id_stu
	 */
	public void setId_stu(String Id_stu) {
		setAttrVal("Id_stu", Id_stu);
	}
	/**
	 * 出库状态编码
	 * @return String
	 */
	public String getSd_stu() {
		return ((String) getAttrVal("Sd_stu"));
	}	
	/**
	 * 出库状态编码
	 * @param Sd_stu
	 */
	public void setSd_stu(String Sd_stu) {
		setAttrVal("Sd_stu", Sd_stu);
	}
	/**
	 * 出库科室
	 * @return String
	 */
	public String getId_out_dept() {
		return ((String) getAttrVal("Id_out_dept"));
	}	
	/**
	 * 出库科室
	 * @param Id_out_dept
	 */
	public void setId_out_dept(String Id_out_dept) {
		setAttrVal("Id_out_dept", Id_out_dept);
	}
	/**
	 * 出库金额
	 * @return FDouble
	 */
	public FDouble getOut_cost() {
		return ((FDouble) getAttrVal("Out_cost"));
	}	
	/**
	 * 出库金额
	 * @param Out_cost
	 */
	public void setOut_cost(FDouble Out_cost) {
		setAttrVal("Out_cost", Out_cost);
	}
	/**
	 * 领用人
	 * @return String
	 */
	public String getId_oper() {
		return ((String) getAttrVal("Id_oper"));
	}	
	/**
	 * 领用人
	 * @param Id_oper
	 */
	public void setId_oper(String Id_oper) {
		setAttrVal("Id_oper", Id_oper);
	}
	/**
	 * 领用科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 领用科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 接收单位（调出用）
	 * @return String
	 */
	public String getIncept_unit() {
		return ((String) getAttrVal("Incept_unit"));
	}	
	/**
	 * 接收单位（调出用）
	 * @param Incept_unit
	 */
	public void setIncept_unit(String Incept_unit) {
		setAttrVal("Incept_unit", Incept_unit);
	}
	/**
	 * 保管人
	 * @return String
	 */
	public String getId_stor_oper() {
		return ((String) getAttrVal("Id_stor_oper"));
	}	
	/**
	 * 保管人
	 * @param Id_stor_oper
	 */
	public void setId_stor_oper(String Id_stor_oper) {
		setAttrVal("Id_stor_oper", Id_stor_oper);
	}
	/**
	 * 保管科室
	 * @return String
	 */
	public String getId_stor_dept() {
		return ((String) getAttrVal("Id_stor_dept"));
	}	
	/**
	 * 保管科室
	 * @param Id_stor_dept
	 */
	public void setId_stor_dept(String Id_stor_dept) {
		setAttrVal("Id_stor_dept", Id_stor_dept);
	}
	/**
	 * 保管仓库
	 * @return String
	 */
	public String getId_stor_wh() {
		return ((String) getAttrVal("Id_stor_wh"));
	}	
	/**
	 * 保管仓库
	 * @param Id_stor_wh
	 */
	public void setId_stor_wh(String Id_stor_wh) {
		setAttrVal("Id_stor_wh", Id_stor_wh);
	}
	/**
	 * 资产用途
	 * @return String
	 */
	public String getId_em_use() {
		return ((String) getAttrVal("Id_em_use"));
	}	
	/**
	 * 资产用途
	 * @param Id_em_use
	 */
	public void setId_em_use(String Id_em_use) {
		setAttrVal("Id_em_use", Id_em_use);
	}
	/**
	 * 资产用途编码
	 * @return String
	 */
	public String getSd_em_use() {
		return ((String) getAttrVal("Sd_em_use"));
	}	
	/**
	 * 资产用途编码
	 * @param Sd_em_use
	 */
	public void setSd_em_use(String Sd_em_use) {
		setAttrVal("Sd_em_use", Sd_em_use);
	}
	/**
	 * 出库时间
	 * @return FDateTime
	 */
	public FDateTime getDt_date() {
		return ((FDateTime) getAttrVal("Dt_date"));
	}	
	/**
	 * 出库时间
	 * @param Dt_date
	 */
	public void setDt_date(FDateTime Dt_date) {
		setAttrVal("Dt_date", Dt_date);
	}
	/**
	 * 出库操作员
	 * @return String
	 */
	public String getId_out_oper() {
		return ((String) getAttrVal("Id_out_oper"));
	}	
	/**
	 * 出库操作员
	 * @param Id_out_oper
	 */
	public void setId_out_oper(String Id_out_oper) {
		setAttrVal("Id_out_oper", Id_out_oper);
	}
	/**
	 * 保管地点
	 * @return String
	 */
	public String getSave_place() {
		return ((String) getAttrVal("Save_place"));
	}	
	/**
	 * 保管地点
	 * @param Save_place
	 */
	public void setSave_place(String Save_place) {
		setAttrVal("Save_place", Save_place);
	}
	/**
	 * 财务年月
	 * @return String
	 */
	public String getYear_month() {
		return ((String) getAttrVal("Year_month"));
	}	
	/**
	 * 财务年月
	 * @param Year_month
	 */
	public void setYear_month(String Year_month) {
		setAttrVal("Year_month", Year_month);
	}
	/**
	 * 是否已打印
	 * @return FBoolean
	 */
	public FBoolean getFg_printed() {
		return ((FBoolean) getAttrVal("Fg_printed"));
	}	
	/**
	 * 是否已打印
	 * @param Fg_printed
	 */
	public void setFg_printed(FBoolean Fg_printed) {
		setAttrVal("Fg_printed", Fg_printed);
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
	 * 确认人
	 * @return String
	 */
	public String getId_conf_oper() {
		return ((String) getAttrVal("Id_conf_oper"));
	}	
	/**
	 * 确认人
	 * @param Id_conf_oper
	 */
	public void setId_conf_oper(String Id_conf_oper) {
		setAttrVal("Id_conf_oper", Id_conf_oper);
	}
	/**
	 * 确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_conf() {
		return ((FDateTime) getAttrVal("Dt_conf"));
	}	
	/**
	 * 确认时间
	 * @param Dt_conf
	 */
	public void setDt_conf(FDateTime Dt_conf) {
		setAttrVal("Dt_conf", Dt_conf);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getId_chk_oper() {
		return ((String) getAttrVal("Id_chk_oper"));
	}	
	/**
	 * 审核人
	 * @param Id_chk_oper
	 */
	public void setId_chk_oper(String Id_chk_oper) {
		setAttrVal("Id_chk_oper", Id_chk_oper);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}	
	/**
	 * 审核时间
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	/**
	 * 审核意见
	 * @return String
	 */
	public String getChk_des() {
		return ((String) getAttrVal("Chk_des"));
	}	
	/**
	 * 审核意见
	 * @param Chk_des
	 */
	public void setChk_des(String Chk_des) {
		setAttrVal("Chk_des", Chk_des);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_out_tp() {
		return ((String) getAttrVal("Name_out_tp"));
	}	
	/**
	 * 名称
	 * @param Name_out_tp
	 */
	public void setName_out_tp(String Name_out_tp) {
		setAttrVal("Name_out_tp", Name_out_tp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_outca() {
		return ((String) getAttrVal("Name_outca"));
	}	
	/**
	 * 名称
	 * @param Name_outca
	 */
	public void setName_outca(String Name_outca) {
		setAttrVal("Name_outca", Name_outca);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_stu() {
		return ((String) getAttrVal("Name_stu"));
	}	
	/**
	 * 名称
	 * @param Name_stu
	 */
	public void setName_stu(String Name_stu) {
		setAttrVal("Name_stu", Name_stu);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_out_dept() {
		return ((String) getAttrVal("Name_out_dept"));
	}	
	/**
	 * 名称
	 * @param Name_out_dept
	 */
	public void setName_out_dept(String Name_out_dept) {
		setAttrVal("Name_out_dept", Name_out_dept);
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
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_stor_oper() {
		return ((String) getAttrVal("Name_stor_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_stor_oper
	 */
	public void setName_stor_oper(String Name_stor_oper) {
		setAttrVal("Name_stor_oper", Name_stor_oper);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_stor_dept() {
		return ((String) getAttrVal("Name_stor_dept"));
	}	
	/**
	 * 名称
	 * @param Name_stor_dept
	 */
	public void setName_stor_dept(String Name_stor_dept) {
		setAttrVal("Name_stor_dept", Name_stor_dept);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getName_stor_wh() {
		return ((String) getAttrVal("Name_stor_wh"));
	}	
	/**
	 * 仓库名称
	 * @param Name_stor_wh
	 */
	public void setName_stor_wh(String Name_stor_wh) {
		setAttrVal("Name_stor_wh", Name_stor_wh);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_em_use() {
		return ((String) getAttrVal("Name_em_use"));
	}	
	/**
	 * 名称
	 * @param Name_em_use
	 */
	public void setName_em_use(String Name_em_use) {
		setAttrVal("Name_em_use", Name_em_use);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_out_oper() {
		return ((String) getAttrVal("Name_out_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_out_oper
	 */
	public void setName_out_oper(String Name_out_oper) {
		setAttrVal("Name_out_oper", Name_out_oper);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_conf_oper() {
		return ((String) getAttrVal("Name_conf_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_conf_oper
	 */
	public void setName_conf_oper(String Name_conf_oper) {
		setAttrVal("Name_conf_oper", Name_conf_oper);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_chk_oper() {
		return ((String) getAttrVal("Name_chk_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_chk_oper
	 */
	public void setName_chk_oper(String Name_chk_oper) {
		setAttrVal("Name_chk_oper", Name_chk_oper);
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
		return "Id_out";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_out";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsOutDODesc.class);
	}
	
}