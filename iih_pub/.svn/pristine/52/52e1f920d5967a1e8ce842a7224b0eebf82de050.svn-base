package iih.ems.emcm.emge.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.emcm.emge.d.desc.EmsGeRecordDODesc;
import java.math.BigDecimal;

/**
 * 设备计量记录表 DO数据 
 * 
 */
public class EmsGeRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//设备计量记录主键
	public static final String ID_GE= "Id_ge";
	//卡片主键
	public static final String ID_CARD= "Id_card";
	//资产卡编号
	public static final String CARD_NO= "Card_no";
	//记录名称
	public static final String NAME= "Name";
	//检测单号
	public static final String CODE= "Code";
	//设备使用科
	public static final String ID_DEPT= "Id_dept";
	//设备基础信息主键
	public static final String ID_EM= "Id_em";
	//设备编码
	public static final String EM_CODE= "Em_code";
	//院内码
	public static final String INNERCODE= "Innercode";
	//检测类型
	public static final String ID_GE_TYPE= "Id_ge_type";
	//检测类型编码
	public static final String SD_GE_TYPE= "Sd_ge_type";
	//发票号码(外修填写)
	public static final String INV_NO= "Inv_no";
	//发票日期(外修填写)
	public static final String DT_INV= "Dt_inv";
	//计量仪器分类
	public static final String ID_GE_CA= "Id_ge_ca";
	//检测费用
	public static final String GE_FEE= "Ge_fee";
	//检测日期
	public static final String DT_GE= "Dt_ge";
	//检测人员
	public static final String ID_GE_OPER= "Id_ge_oper";
	//检测单位(部门)
	public static final String ID_GE_DEPT= "Id_ge_dept";
	//检测内容
	public static final String GE_CONT= "Ge_cont";
	//保管等级
	public static final String ID_STOR_LEVEL= "Id_stor_level";
	//保管等级编码
	public static final String SD_STOR_LEVEL= "Sd_stor_level";
	//保管科室
	public static final String ID_STOR_DEPT= "Id_stor_dept";
	//保管人
	public static final String ID_STOR_OPER= "Id_stor_oper";
	//计量记录单状态
	public static final String ID_GE_ST= "Id_ge_st";
	//计量记录单状态编码
	public static final String SD_GE_ST= "Sd_ge_st";
	//制单人
	public static final String ID_OPER= "Id_oper";
	//仓库
	public static final String ID_WH= "Id_wh";
	//制单时间
	public static final String DT_OPER= "Dt_oper";
	//确认人
	public static final String ID_CONF_OPER= "Id_conf_oper";
	//确认时间
	public static final String DT_CONF= "Dt_conf";
	//核准人
	public static final String ID_CHK_OPER= "Id_chk_oper";
	//核准时间
	public static final String DT_CHK= "Dt_chk";
	//作废人
	public static final String ID_WASTE_OPER= "Id_waste_oper";
	//作废时间
	public static final String DT_WASTE= "Dt_waste";
	//作废原因
	public static final String WASTE_CAUSE= "Waste_cause";
	//备注
	public static final String REMARK= "Remark";
	//检测证书
	public static final String GE_CERT= "Ge_cert";
	//检测是否合格
	public static final String FG_PASS= "Fg_pass";
	//计量周期（天）
	public static final String GE_CYC= "Ge_cyc";
	//上次计量时间
	public static final String DT_LAST_GE= "Dt_last_ge";
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
	//卡片名称
	public static final String NAME_CARD= "Name_card";
	//设备名称
	public static final String EM_NAME= "Em_name";
	//名称
	public static final String NAME_GE_TYPE= "Name_ge_type";
	//名称
	public static final String NAME_GETP= "Name_getp";
	//姓名
	public static final String NAME_GE_OPER= "Name_ge_oper";
	//名称
	public static final String NAME_GE_DEPT= "Name_ge_dept";
	//名称
	public static final String NAME_STOR_LEVEL= "Name_stor_level";
	//名称
	public static final String NAME_STOR_DEPT= "Name_stor_dept";
	//姓名
	public static final String NAME_STOR_OPER= "Name_stor_oper";
	//名称
	public static final String NAME_GE_ST= "Name_ge_st";
	//姓名
	public static final String NAME_OPER= "Name_oper";
	//仓库名称
	public static final String NAME_WH= "Name_wh";
	//姓名
	public static final String NAME_CONF_OPER= "Name_conf_oper";
	//姓名
	public static final String NAME_CHK_OPER= "Name_chk_oper";
	//姓名
	public static final String NAME_WASTER_OPER= "Name_waster_oper";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 设备计量记录主键
	 * @return String
	 */
	public String getId_ge() {
		return ((String) getAttrVal("Id_ge"));
	}	
	/**
	 * 设备计量记录主键
	 * @param Id_ge
	 */
	public void setId_ge(String Id_ge) {
		setAttrVal("Id_ge", Id_ge);
	}
	/**
	 * 卡片主键
	 * @return String
	 */
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}	
	/**
	 * 卡片主键
	 * @param Id_card
	 */
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
	}
	/**
	 * 资产卡编号
	 * @return String
	 */
	public String getCard_no() {
		return ((String) getAttrVal("Card_no"));
	}	
	/**
	 * 资产卡编号
	 * @param Card_no
	 */
	public void setCard_no(String Card_no) {
		setAttrVal("Card_no", Card_no);
	}
	/**
	 * 记录名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 记录名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 检测单号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 检测单号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 设备使用科
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 设备使用科
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 设备基础信息主键
	 * @return String
	 */
	public String getId_em() {
		return ((String) getAttrVal("Id_em"));
	}	
	/**
	 * 设备基础信息主键
	 * @param Id_em
	 */
	public void setId_em(String Id_em) {
		setAttrVal("Id_em", Id_em);
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
	 * 院内码
	 * @return String
	 */
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	/**
	 * 院内码
	 * @param Innercode
	 */
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	/**
	 * 检测类型
	 * @return String
	 */
	public String getId_ge_type() {
		return ((String) getAttrVal("Id_ge_type"));
	}	
	/**
	 * 检测类型
	 * @param Id_ge_type
	 */
	public void setId_ge_type(String Id_ge_type) {
		setAttrVal("Id_ge_type", Id_ge_type);
	}
	/**
	 * 检测类型编码
	 * @return String
	 */
	public String getSd_ge_type() {
		return ((String) getAttrVal("Sd_ge_type"));
	}	
	/**
	 * 检测类型编码
	 * @param Sd_ge_type
	 */
	public void setSd_ge_type(String Sd_ge_type) {
		setAttrVal("Sd_ge_type", Sd_ge_type);
	}
	/**
	 * 发票号码(外修填写)
	 * @return String
	 */
	public String getInv_no() {
		return ((String) getAttrVal("Inv_no"));
	}	
	/**
	 * 发票号码(外修填写)
	 * @param Inv_no
	 */
	public void setInv_no(String Inv_no) {
		setAttrVal("Inv_no", Inv_no);
	}
	/**
	 * 发票日期(外修填写)
	 * @return FDate
	 */
	public FDate getDt_inv() {
		return ((FDate) getAttrVal("Dt_inv"));
	}	
	/**
	 * 发票日期(外修填写)
	 * @param Dt_inv
	 */
	public void setDt_inv(FDate Dt_inv) {
		setAttrVal("Dt_inv", Dt_inv);
	}
	/**
	 * 计量仪器分类
	 * @return String
	 */
	public String getId_ge_ca() {
		return ((String) getAttrVal("Id_ge_ca"));
	}	
	/**
	 * 计量仪器分类
	 * @param Id_ge_ca
	 */
	public void setId_ge_ca(String Id_ge_ca) {
		setAttrVal("Id_ge_ca", Id_ge_ca);
	}
	/**
	 * 检测费用
	 * @return FDouble
	 */
	public FDouble getGe_fee() {
		return ((FDouble) getAttrVal("Ge_fee"));
	}	
	/**
	 * 检测费用
	 * @param Ge_fee
	 */
	public void setGe_fee(FDouble Ge_fee) {
		setAttrVal("Ge_fee", Ge_fee);
	}
	/**
	 * 检测日期
	 * @return FDate
	 */
	public FDate getDt_ge() {
		return ((FDate) getAttrVal("Dt_ge"));
	}	
	/**
	 * 检测日期
	 * @param Dt_ge
	 */
	public void setDt_ge(FDate Dt_ge) {
		setAttrVal("Dt_ge", Dt_ge);
	}
	/**
	 * 检测人员
	 * @return String
	 */
	public String getId_ge_oper() {
		return ((String) getAttrVal("Id_ge_oper"));
	}	
	/**
	 * 检测人员
	 * @param Id_ge_oper
	 */
	public void setId_ge_oper(String Id_ge_oper) {
		setAttrVal("Id_ge_oper", Id_ge_oper);
	}
	/**
	 * 检测单位(部门)
	 * @return String
	 */
	public String getId_ge_dept() {
		return ((String) getAttrVal("Id_ge_dept"));
	}	
	/**
	 * 检测单位(部门)
	 * @param Id_ge_dept
	 */
	public void setId_ge_dept(String Id_ge_dept) {
		setAttrVal("Id_ge_dept", Id_ge_dept);
	}
	/**
	 * 检测内容
	 * @return String
	 */
	public String getGe_cont() {
		return ((String) getAttrVal("Ge_cont"));
	}	
	/**
	 * 检测内容
	 * @param Ge_cont
	 */
	public void setGe_cont(String Ge_cont) {
		setAttrVal("Ge_cont", Ge_cont);
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
	 * 保管等级编码
	 * @return String
	 */
	public String getSd_stor_level() {
		return ((String) getAttrVal("Sd_stor_level"));
	}	
	/**
	 * 保管等级编码
	 * @param Sd_stor_level
	 */
	public void setSd_stor_level(String Sd_stor_level) {
		setAttrVal("Sd_stor_level", Sd_stor_level);
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
	 * 计量记录单状态
	 * @return String
	 */
	public String getId_ge_st() {
		return ((String) getAttrVal("Id_ge_st"));
	}	
	/**
	 * 计量记录单状态
	 * @param Id_ge_st
	 */
	public void setId_ge_st(String Id_ge_st) {
		setAttrVal("Id_ge_st", Id_ge_st);
	}
	/**
	 * 计量记录单状态编码
	 * @return String
	 */
	public String getSd_ge_st() {
		return ((String) getAttrVal("Sd_ge_st"));
	}	
	/**
	 * 计量记录单状态编码
	 * @param Sd_ge_st
	 */
	public void setSd_ge_st(String Sd_ge_st) {
		setAttrVal("Sd_ge_st", Sd_ge_st);
	}
	/**
	 * 制单人
	 * @return String
	 */
	public String getId_oper() {
		return ((String) getAttrVal("Id_oper"));
	}	
	/**
	 * 制单人
	 * @param Id_oper
	 */
	public void setId_oper(String Id_oper) {
		setAttrVal("Id_oper", Id_oper);
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
	 * 制单时间
	 * @return FDate
	 */
	public FDate getDt_oper() {
		return ((FDate) getAttrVal("Dt_oper"));
	}	
	/**
	 * 制单时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDate Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
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
	 * @return FDate
	 */
	public FDate getDt_conf() {
		return ((FDate) getAttrVal("Dt_conf"));
	}	
	/**
	 * 确认时间
	 * @param Dt_conf
	 */
	public void setDt_conf(FDate Dt_conf) {
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
	 * 核准时间
	 * @return FDate
	 */
	public FDate getDt_chk() {
		return ((FDate) getAttrVal("Dt_chk"));
	}	
	/**
	 * 核准时间
	 * @param Dt_chk
	 */
	public void setDt_chk(FDate Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	/**
	 * 作废人
	 * @return String
	 */
	public String getId_waste_oper() {
		return ((String) getAttrVal("Id_waste_oper"));
	}	
	/**
	 * 作废人
	 * @param Id_waste_oper
	 */
	public void setId_waste_oper(String Id_waste_oper) {
		setAttrVal("Id_waste_oper", Id_waste_oper);
	}
	/**
	 * 作废时间
	 * @return FDate
	 */
	public FDate getDt_waste() {
		return ((FDate) getAttrVal("Dt_waste"));
	}	
	/**
	 * 作废时间
	 * @param Dt_waste
	 */
	public void setDt_waste(FDate Dt_waste) {
		setAttrVal("Dt_waste", Dt_waste);
	}
	/**
	 * 作废原因
	 * @return String
	 */
	public String getWaste_cause() {
		return ((String) getAttrVal("Waste_cause"));
	}	
	/**
	 * 作废原因
	 * @param Waste_cause
	 */
	public void setWaste_cause(String Waste_cause) {
		setAttrVal("Waste_cause", Waste_cause);
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
	 * 检测证书
	 * @return String
	 */
	public String getGe_cert() {
		return ((String) getAttrVal("Ge_cert"));
	}	
	/**
	 * 检测证书
	 * @param Ge_cert
	 */
	public void setGe_cert(String Ge_cert) {
		setAttrVal("Ge_cert", Ge_cert);
	}
	/**
	 * 检测是否合格
	 * @return FBoolean
	 */
	public FBoolean getFg_pass() {
		return ((FBoolean) getAttrVal("Fg_pass"));
	}	
	/**
	 * 检测是否合格
	 * @param Fg_pass
	 */
	public void setFg_pass(FBoolean Fg_pass) {
		setAttrVal("Fg_pass", Fg_pass);
	}
	/**
	 * 计量周期（天）
	 * @return Integer
	 */
	public Integer getGe_cyc() {
		return ((Integer) getAttrVal("Ge_cyc"));
	}	
	/**
	 * 计量周期（天）
	 * @param Ge_cyc
	 */
	public void setGe_cyc(Integer Ge_cyc) {
		setAttrVal("Ge_cyc", Ge_cyc);
	}
	/**
	 * 上次计量时间
	 * @return FDate
	 */
	public FDate getDt_last_ge() {
		return ((FDate) getAttrVal("Dt_last_ge"));
	}	
	/**
	 * 上次计量时间
	 * @param Dt_last_ge
	 */
	public void setDt_last_ge(FDate Dt_last_ge) {
		setAttrVal("Dt_last_ge", Dt_last_ge);
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
	 * 卡片名称
	 * @return String
	 */
	public String getName_card() {
		return ((String) getAttrVal("Name_card"));
	}	
	/**
	 * 卡片名称
	 * @param Name_card
	 */
	public void setName_card(String Name_card) {
		setAttrVal("Name_card", Name_card);
	}
	/**
	 * 设备名称
	 * @return String
	 */
	public String getEm_name() {
		return ((String) getAttrVal("Em_name"));
	}	
	/**
	 * 设备名称
	 * @param Em_name
	 */
	public void setEm_name(String Em_name) {
		setAttrVal("Em_name", Em_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ge_type() {
		return ((String) getAttrVal("Name_ge_type"));
	}	
	/**
	 * 名称
	 * @param Name_ge_type
	 */
	public void setName_ge_type(String Name_ge_type) {
		setAttrVal("Name_ge_type", Name_ge_type);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_getp() {
		return ((String) getAttrVal("Name_getp"));
	}	
	/**
	 * 名称
	 * @param Name_getp
	 */
	public void setName_getp(String Name_getp) {
		setAttrVal("Name_getp", Name_getp);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_ge_oper() {
		return ((String) getAttrVal("Name_ge_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_ge_oper
	 */
	public void setName_ge_oper(String Name_ge_oper) {
		setAttrVal("Name_ge_oper", Name_ge_oper);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ge_dept() {
		return ((String) getAttrVal("Name_ge_dept"));
	}	
	/**
	 * 名称
	 * @param Name_ge_dept
	 */
	public void setName_ge_dept(String Name_ge_dept) {
		setAttrVal("Name_ge_dept", Name_ge_dept);
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
	public String getName_ge_st() {
		return ((String) getAttrVal("Name_ge_st"));
	}	
	/**
	 * 名称
	 * @param Name_ge_st
	 */
	public void setName_ge_st(String Name_ge_st) {
		setAttrVal("Name_ge_st", Name_ge_st);
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
	 * 姓名
	 * @return String
	 */
	public String getName_waster_oper() {
		return ((String) getAttrVal("Name_waster_oper"));
	}	
	/**
	 * 姓名
	 * @param Name_waster_oper
	 */
	public void setName_waster_oper(String Name_waster_oper) {
		setAttrVal("Name_waster_oper", Name_waster_oper);
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
		return "Id_ge";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_ge";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsGeRecordDODesc.class);
	}
	
}