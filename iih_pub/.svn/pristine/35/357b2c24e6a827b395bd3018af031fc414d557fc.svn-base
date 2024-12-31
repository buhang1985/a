package iih.ems.eass.scrap.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.eass.scrap.d.desc.EmsScrapDODesc;
import java.math.BigDecimal;

/**
 * 资产报废 DO数据 
 * 
 */
public class EmsScrapDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//报废主键
	public static final String ID_SCRAP= "Id_scrap";
	//资产卡
	public static final String ID_CARD= "Id_card";
	//资产卡号
	public static final String CARD_NO= "Card_no";
	//资产名称
	public static final String CARD_NAME= "Card_name";
	//所属科室
	public static final String ID_DEPT= "Id_dept";
	//设备基本信息
	public static final String ID_EM= "Id_em";
	//报废生效时间
	public static final String DT_DM= "Dt_dm";
	//设备编码
	public static final String EM_CODE= "Em_code";
	//设备分类树内码
	public static final String EMCA_INRCODE= "Emca_inrcode";
	//报废原因
	public static final String DM_CAUSE= "Dm_cause";
	//处理方法
	public static final String MD_METHOD= "Md_method";
	//保管等级
	public static final String ID_STOR_LEVEL= "Id_stor_level";
	//保管科室
	public static final String ID_STOR_DEPT= "Id_stor_dept";
	//保管人
	public static final String ID_STOR_OPER= "Id_stor_oper";
	//报损状态
	public static final String ID_STATE= "Id_state";
	//报损单状态
	public static final String SD_STATE= "Sd_state";
	//报损申请单号
	public static final String CODE= "Code";
	//报损单名称
	public static final String NAME= "Name";
	//申请人
	public static final String ID_AP_OPER= "Id_ap_oper";
	//申请科室
	public static final String ID_AP_DEPT= "Id_ap_dept";
	//申请仓库
	public static final String ID_WH= "Id_wh";
	//申请时间
	public static final String DT_AP= "Dt_ap";
	//确认人
	public static final String ID_CONF_OPER= "Id_conf_oper";
	//确认时间
	public static final String DT_CONF= "Dt_conf";
	//核准人
	public static final String ID_CHK_OPER= "Id_chk_oper";
	//核准部门
	public static final String ID_CHK_DEPT= "Id_chk_dept";
	//核准时间
	public static final String DT_CHK= "Dt_chk";
	//备注
	public static final String REMARK= "Remark";
	//资产残值
	public static final String LEAVE_PRICE= "Leave_price";
	//报废意见
	public static final String REJECT_COMMENT= "Reject_comment";
	//报废面积
	public static final String REJECT_AREA= "Reject_area";
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
	//财务年月
	public static final String YEAR_MONTH= "Year_month";
	//名称
	public static final String NAME_DEPT= "Name_dept";
	//名称
	public static final String NAME_STOR_LEVEL= "Name_stor_level";
	//名称
	public static final String NAME_STOR_DEPT= "Name_stor_dept";
	//姓名
	public static final String NAME_STOR_OPER= "Name_stor_oper";
	//名称
	public static final String NAME_STATE= "Name_state";
	//姓名
	public static final String NAME_AP_OPER= "Name_ap_oper";
	//名称
	public static final String NAME_AP_DEPT= "Name_ap_dept";
	//仓库名称
	public static final String NAME_WH= "Name_wh";
	//姓名
	public static final String NAME_CONF_OPER= "Name_conf_oper";
	//姓名
	public static final String NAME_CHK_OPER= "Name_chk_oper";
	//名称
	public static final String NAME_CHK_DEPT= "Name_chk_dept";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 报废主键
	 * @return String
	 */
	public String getId_scrap() {
		return ((String) getAttrVal("Id_scrap"));
	}	
	/**
	 * 报废主键
	 * @param Id_scrap
	 */
	public void setId_scrap(String Id_scrap) {
		setAttrVal("Id_scrap", Id_scrap);
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
	 * 所属科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 所属科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
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
	 * 报废生效时间
	 * @return String
	 */
	public String getDt_dm() {
		return ((String) getAttrVal("Dt_dm"));
	}	
	/**
	 * 报废生效时间
	 * @param Dt_dm
	 */
	public void setDt_dm(String Dt_dm) {
		setAttrVal("Dt_dm", Dt_dm);
	}
	/**
	 * 设备编码
	 * @return String
	 */
	public String getEm_code() {
		return ((String) getAttrVal("Em_code"));
	}	
	/**
	 * 设备编码
	 * @param Em_code
	 */
	public void setEm_code(String Em_code) {
		setAttrVal("Em_code", Em_code);
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
	 * 报废原因
	 * @return String
	 */
	public String getDm_cause() {
		return ((String) getAttrVal("Dm_cause"));
	}	
	/**
	 * 报废原因
	 * @param Dm_cause
	 */
	public void setDm_cause(String Dm_cause) {
		setAttrVal("Dm_cause", Dm_cause);
	}
	/**
	 * 处理方法
	 * @return String
	 */
	public String getMd_method() {
		return ((String) getAttrVal("Md_method"));
	}	
	/**
	 * 处理方法
	 * @param Md_method
	 */
	public void setMd_method(String Md_method) {
		setAttrVal("Md_method", Md_method);
	}
	/**
	 * 保管等级
	 * @return String
	 */
	public String getId_stor_level() {
		return ((String) getAttrVal("Id_stor_level"));
	}	
	/**
	 * 保管等级
	 * @param Id_stor_level
	 */
	public void setId_stor_level(String Id_stor_level) {
		setAttrVal("Id_stor_level", Id_stor_level);
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
	 * 报损状态
	 * @return String
	 */
	public String getId_state() {
		return ((String) getAttrVal("Id_state"));
	}	
	/**
	 * 报损状态
	 * @param Id_state
	 */
	public void setId_state(String Id_state) {
		setAttrVal("Id_state", Id_state);
	}
	/**
	 * 报损单状态
	 * @return String
	 */
	public String getSd_state() {
		return ((String) getAttrVal("Sd_state"));
	}	
	/**
	 * 报损单状态
	 * @param Sd_state
	 */
	public void setSd_state(String Sd_state) {
		setAttrVal("Sd_state", Sd_state);
	}
	/**
	 * 报损申请单号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 报损申请单号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 报损单名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 报损单名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 申请人
	 * @return String
	 */
	public String getId_ap_oper() {
		return ((String) getAttrVal("Id_ap_oper"));
	}	
	/**
	 * 申请人
	 * @param Id_ap_oper
	 */
	public void setId_ap_oper(String Id_ap_oper) {
		setAttrVal("Id_ap_oper", Id_ap_oper);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getId_ap_dept() {
		return ((String) getAttrVal("Id_ap_dept"));
	}	
	/**
	 * 申请科室
	 * @param Id_ap_dept
	 */
	public void setId_ap_dept(String Id_ap_dept) {
		setAttrVal("Id_ap_dept", Id_ap_dept);
	}
	/**
	 * 申请仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 申请仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_ap() {
		return ((FDateTime) getAttrVal("Dt_ap"));
	}	
	/**
	 * 申请时间
	 * @param Dt_ap
	 */
	public void setDt_ap(FDateTime Dt_ap) {
		setAttrVal("Dt_ap", Dt_ap);
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
	 * 核准人
	 * @return String
	 */
	public String getId_chk_oper() {
		return ((String) getAttrVal("Id_chk_oper"));
	}	
	/**
	 * 核准人
	 * @param Id_chk_oper
	 */
	public void setId_chk_oper(String Id_chk_oper) {
		setAttrVal("Id_chk_oper", Id_chk_oper);
	}
	/**
	 * 核准部门
	 * @return String
	 */
	public String getId_chk_dept() {
		return ((String) getAttrVal("Id_chk_dept"));
	}	
	/**
	 * 核准部门
	 * @param Id_chk_dept
	 */
	public void setId_chk_dept(String Id_chk_dept) {
		setAttrVal("Id_chk_dept", Id_chk_dept);
	}
	/**
	 * 核准时间
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}	
	/**
	 * 核准时间
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}	
	/**
	 * 备注
	 * @param Remark
	 */
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	/**
	 * 资产残值
	 * @return FDouble
	 */
	public FDouble getLeave_price() {
		return ((FDouble) getAttrVal("Leave_price"));
	}	
	/**
	 * 资产残值
	 * @param Leave_price
	 */
	public void setLeave_price(FDouble Leave_price) {
		setAttrVal("Leave_price", Leave_price);
	}
	/**
	 * 报废意见
	 * @return String
	 */
	public String getReject_comment() {
		return ((String) getAttrVal("Reject_comment"));
	}	
	/**
	 * 报废意见
	 * @param Reject_comment
	 */
	public void setReject_comment(String Reject_comment) {
		setAttrVal("Reject_comment", Reject_comment);
	}
	/**
	 * 报废面积
	 * @return String
	 */
	public String getReject_area() {
		return ((String) getAttrVal("Reject_area"));
	}	
	/**
	 * 报废面积
	 * @param Reject_area
	 */
	public void setReject_area(String Reject_area) {
		setAttrVal("Reject_area", Reject_area);
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
	 * 名称
	 * @return String
	 */
	public String getName_stor_level() {
		return ((String) getAttrVal("Name_stor_level"));
	}	
	/**
	 * 名称
	 * @param Name_stor_level
	 */
	public void setName_stor_level(String Name_stor_level) {
		setAttrVal("Name_stor_level", Name_stor_level);
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
	public String getName_state() {
		return ((String) getAttrVal("Name_state"));
	}	
	/**
	 * 名称
	 * @param Name_state
	 */
	public void setName_state(String Name_state) {
		setAttrVal("Name_state", Name_state);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_ap_oper() {
		return ((String) getAttrVal("Name_ap_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_ap_oper
	 */
	public void setName_ap_oper(String Name_ap_oper) {
		setAttrVal("Name_ap_oper", Name_ap_oper);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ap_dept() {
		return ((String) getAttrVal("Name_ap_dept"));
	}	
	/**
	 * 名称
	 * @param Name_ap_dept
	 */
	public void setName_ap_dept(String Name_ap_dept) {
		setAttrVal("Name_ap_dept", Name_ap_dept);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getName_wh() {
		return ((String) getAttrVal("Name_wh"));
	}	
	/**
	 * 仓库名称
	 * @param Name_wh
	 */
	public void setName_wh(String Name_wh) {
		setAttrVal("Name_wh", Name_wh);
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
	/**
	 * 名称
	 * @return String
	 */
	public String getName_chk_dept() {
		return ((String) getAttrVal("Name_chk_dept"));
	}	
	/**
	 * 名称
	 * @param Name_chk_dept
	 */
	public void setName_chk_dept(String Name_chk_dept) {
		setAttrVal("Name_chk_dept", Name_chk_dept);
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
		return "Id_scrap";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_srp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsScrapDODesc.class);
	}
	
}