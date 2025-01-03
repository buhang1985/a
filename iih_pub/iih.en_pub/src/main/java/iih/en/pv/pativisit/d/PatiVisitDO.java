package iih.en.pv.pativisit.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.pativisit.d.desc.PatiVisitDODesc;
import java.math.BigDecimal;

/**
 * 患者就诊 DO数据 
 * 
 */
public class PatiVisitDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者就诊主键标识
	public static final String ID_ENT= "Id_ent";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//患者
	public static final String ID_PAT= "Id_pat";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//就诊编码
	public static final String CODE= "Code";
	//就诊描述
	public static final String DES= "Des";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//患者性别
	public static final String ID_SEX_PAT= "Id_sex_pat";
	//患者性别编码
	public static final String SD_SEX_PAT= "Sd_sex_pat";
	//婚姻状况
	public static final String ID_MARI_PAT= "Id_mari_pat";
	//婚姻状况编码
	public static final String SD_MARI_PAT= "Sd_mari_pat";
	//患者出生日期
	public static final String DT_BIRTH_PAT= "Dt_birth_pat";
	//电话
	public static final String TELNO_PAT= "Telno_pat";
	//现住址
	public static final String ADDR_PAT= "Addr_pat";
	//现住址区县码id
	public static final String ID_ADMDIV_ADDR= "Id_admdiv_addr";
	//现住址区县码
	public static final String SD_ADMDIV_ADDR= "Sd_admdiv_addr";
	//就诊登记日期时间
	public static final String DT_ENTRY= "Dt_entry";
	//接诊有效
	public static final String FG_ACPTVALID= "Fg_acptvalid";
	//就诊接诊日期时间
	public static final String DT_ACPT= "Dt_acpt";
	//当前就诊科室
	public static final String ID_DEP_PHY= "Id_dep_phy";
	//当前医疗组
	public static final String ID_WG_PHY= "Id_wg_phy";
	//当前护理单位
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//当前主管医生
	public static final String ID_EMP_PHY= "Id_emp_phy";
	//当前责任护士
	public static final String ID_EMP_NUR= "Id_emp_nur";
	//登记人员
	public static final String ID_EMP_ENTRY= "Id_emp_entry";
	//主医保计划_本次
	public static final String ID_HP= "Id_hp";
	//患者分类_本次
	public static final String ID_PATCA= "Id_patca";
	//患者价格分类_本次
	public static final String ID_PRIPAT= "Id_pripat";
	//患者信用分类_本次
	public static final String ID_PATCRET= "Id_patcret";
	//就诊状态
	public static final String SD_STATUS= "Sd_status";
	//结算标志
	public static final String FG_ST= "Fg_st";
	//在院标志
	public static final String FG_IP= "Fg_ip";
	//随访标志
	public static final String FG_FLUP= "Fg_flup";
	//随访状态
	public static final String SD_STATUS_FLUP= "Sd_status_flup";
	//退诊标志
	public static final String FG_CANC= "Fg_canc";
	//退诊人员
	public static final String ID_EMP_CANC= "Id_emp_canc";
	//退诊日期
	public static final String DT_CANC= "Dt_canc";
	//备注
	public static final String NOTE= "Note";
	//可转移标志
	public static final String FG_DATA_TRANSF= "Fg_data_transf";
	//诊毕时间
	public static final String DT_END= "Dt_end";
	//新增时间
	public static final String DT_INSERT= "Dt_insert";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//合同单位
	public static final String ID_CUST_CMPY= "Id_cust_cmpy";
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
	//客户扩展字段6
	public static final String DEF6= "Def6";
	//客户扩展字段7
	public static final String DEF7= "Def7";
	//客户扩展字段8
	public static final String DEF8= "Def8";
	//客户扩展字段9
	public static final String DEF9= "Def9";
	//客户扩展字段10
	public static final String DEF10= "Def10";
	//医保医疗类别
	public static final String CODE_HPMEDKIND= "Code_hpmedkind";
	//急诊留观标志
	public static final String FG_EMGSTAY= "Fg_emgstay";
	//付款完成
	public static final String FG_PAY= "Fg_pay";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//组织编码
	public static final String CODE_ORG= "Code_org";
	//组织机构码
	public static final String ORGCODE= "Orgcode";
	//患者编码
	public static final String CODE_PAT= "Code_pat";
	//就诊类型名称
	public static final String NAME_ENTP= "Name_entp";
	//名称
	public static final String NAME_SEX= "Name_sex";
	//名称
	public static final String NAME_MARI= "Name_mari";
	//编码
	public static final String CODE_MARI= "Code_mari";
	//行政区划编码
	public static final String CODE_ADDR= "Code_addr";
	//行政区划名称
	public static final String NAME_ADDR= "Name_addr";
	//行政区划全称
	public static final String FULLNAME_ADDR= "Fullname_addr";
	//当前科室名称
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	//编码
	public static final String SD_DEP_PHY= "Sd_dep_phy";
	//病区名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//编码
	public static final String SD_DEP_NUR= "Sd_dep_nur";
	//姓名
	public static final String NAME_EMP_PHY= "Name_emp_phy";
	//人员编码
	public static final String SD_EMP_PHY= "Sd_emp_phy";
	//医保计划名称
	public static final String NAME_HP= "Name_hp";
	//医保计划编码
	public static final String CODE_HP= "Code_hp";
	//患者分类编码
	public static final String SD_PATCA= "Sd_patca";
	//患者分类名称
	public static final String NAME_PATCA= "Name_patca";
	//患者价格分类名称
	public static final String NAME_PRIPAT= "Name_pripat";
	//患者价格分类编码
	public static final String CODE_PRIPAT= "Code_pripat";
	//患者信用分类编码
	public static final String CODE_PATCRET= "Code_patcret";
	//者信用分类名称
	public static final String NAME_PATCRET= "Name_patcret";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者就诊主键标识
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 患者就诊主键标识
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 就诊编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 就诊描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 就诊描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getId_sex_pat() {
		return ((String) getAttrVal("Id_sex_pat"));
	}	
	/**
	 * 患者性别
	 * @param Id_sex_pat
	 */
	public void setId_sex_pat(String Id_sex_pat) {
		setAttrVal("Id_sex_pat", Id_sex_pat);
	}
	/**
	 * 患者性别编码
	 * @return String
	 */
	public String getSd_sex_pat() {
		return ((String) getAttrVal("Sd_sex_pat"));
	}	
	/**
	 * 患者性别编码
	 * @param Sd_sex_pat
	 */
	public void setSd_sex_pat(String Sd_sex_pat) {
		setAttrVal("Sd_sex_pat", Sd_sex_pat);
	}
	/**
	 * 婚姻状况
	 * @return String
	 */
	public String getId_mari_pat() {
		return ((String) getAttrVal("Id_mari_pat"));
	}	
	/**
	 * 婚姻状况
	 * @param Id_mari_pat
	 */
	public void setId_mari_pat(String Id_mari_pat) {
		setAttrVal("Id_mari_pat", Id_mari_pat);
	}
	/**
	 * 婚姻状况编码
	 * @return String
	 */
	public String getSd_mari_pat() {
		return ((String) getAttrVal("Sd_mari_pat"));
	}	
	/**
	 * 婚姻状况编码
	 * @param Sd_mari_pat
	 */
	public void setSd_mari_pat(String Sd_mari_pat) {
		setAttrVal("Sd_mari_pat", Sd_mari_pat);
	}
	/**
	 * 患者出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}	
	/**
	 * 患者出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getTelno_pat() {
		return ((String) getAttrVal("Telno_pat"));
	}	
	/**
	 * 电话
	 * @param Telno_pat
	 */
	public void setTelno_pat(String Telno_pat) {
		setAttrVal("Telno_pat", Telno_pat);
	}
	/**
	 * 现住址
	 * @return String
	 */
	public String getAddr_pat() {
		return ((String) getAttrVal("Addr_pat"));
	}	
	/**
	 * 现住址
	 * @param Addr_pat
	 */
	public void setAddr_pat(String Addr_pat) {
		setAttrVal("Addr_pat", Addr_pat);
	}
	/**
	 * 现住址区县码id
	 * @return String
	 */
	public String getId_admdiv_addr() {
		return ((String) getAttrVal("Id_admdiv_addr"));
	}	
	/**
	 * 现住址区县码id
	 * @param Id_admdiv_addr
	 */
	public void setId_admdiv_addr(String Id_admdiv_addr) {
		setAttrVal("Id_admdiv_addr", Id_admdiv_addr);
	}
	/**
	 * 现住址区县码
	 * @return String
	 */
	public String getSd_admdiv_addr() {
		return ((String) getAttrVal("Sd_admdiv_addr"));
	}	
	/**
	 * 现住址区县码
	 * @param Sd_admdiv_addr
	 */
	public void setSd_admdiv_addr(String Sd_admdiv_addr) {
		setAttrVal("Sd_admdiv_addr", Sd_admdiv_addr);
	}
	/**
	 * 就诊登记日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	/**
	 * 就诊登记日期时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 接诊有效
	 * @return FBoolean
	 */
	public FBoolean getFg_acptvalid() {
		return ((FBoolean) getAttrVal("Fg_acptvalid"));
	}	
	/**
	 * 接诊有效
	 * @param Fg_acptvalid
	 */
	public void setFg_acptvalid(FBoolean Fg_acptvalid) {
		setAttrVal("Fg_acptvalid", Fg_acptvalid);
	}
	/**
	 * 就诊接诊日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}	
	/**
	 * 就诊接诊日期时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 当前就诊科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	/**
	 * 当前就诊科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 当前医疗组
	 * @return String
	 */
	public String getId_wg_phy() {
		return ((String) getAttrVal("Id_wg_phy"));
	}	
	/**
	 * 当前医疗组
	 * @param Id_wg_phy
	 */
	public void setId_wg_phy(String Id_wg_phy) {
		setAttrVal("Id_wg_phy", Id_wg_phy);
	}
	/**
	 * 当前护理单位
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 当前护理单位
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 当前主管医生
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}	
	/**
	 * 当前主管医生
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 当前责任护士
	 * @return String
	 */
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}	
	/**
	 * 当前责任护士
	 * @param Id_emp_nur
	 */
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	/**
	 * 登记人员
	 * @return String
	 */
	public String getId_emp_entry() {
		return ((String) getAttrVal("Id_emp_entry"));
	}	
	/**
	 * 登记人员
	 * @param Id_emp_entry
	 */
	public void setId_emp_entry(String Id_emp_entry) {
		setAttrVal("Id_emp_entry", Id_emp_entry);
	}
	/**
	 * 主医保计划_本次
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 主医保计划_本次
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 患者分类_本次
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}	
	/**
	 * 患者分类_本次
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 患者价格分类_本次
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}	
	/**
	 * 患者价格分类_本次
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 患者信用分类_本次
	 * @return String
	 */
	public String getId_patcret() {
		return ((String) getAttrVal("Id_patcret"));
	}	
	/**
	 * 患者信用分类_本次
	 * @param Id_patcret
	 */
	public void setId_patcret(String Id_patcret) {
		setAttrVal("Id_patcret", Id_patcret);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 就诊状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 结算标志
	 * @return FBoolean
	 */
	public FBoolean getFg_st() {
		return ((FBoolean) getAttrVal("Fg_st"));
	}	
	/**
	 * 结算标志
	 * @param Fg_st
	 */
	public void setFg_st(FBoolean Fg_st) {
		setAttrVal("Fg_st", Fg_st);
	}
	/**
	 * 在院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}	
	/**
	 * 在院标志
	 * @param Fg_ip
	 */
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 随访标志
	 * @return FBoolean
	 */
	public FBoolean getFg_flup() {
		return ((FBoolean) getAttrVal("Fg_flup"));
	}	
	/**
	 * 随访标志
	 * @param Fg_flup
	 */
	public void setFg_flup(FBoolean Fg_flup) {
		setAttrVal("Fg_flup", Fg_flup);
	}
	/**
	 * 随访状态
	 * @return String
	 */
	public String getSd_status_flup() {
		return ((String) getAttrVal("Sd_status_flup"));
	}	
	/**
	 * 随访状态
	 * @param Sd_status_flup
	 */
	public void setSd_status_flup(String Sd_status_flup) {
		setAttrVal("Sd_status_flup", Sd_status_flup);
	}
	/**
	 * 退诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	/**
	 * 退诊标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 退诊人员
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	/**
	 * 退诊人员
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	/**
	 * 退诊日期
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	/**
	 * 退诊日期
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 可转移标志
	 * @return FBoolean
	 */
	public FBoolean getFg_data_transf() {
		return ((FBoolean) getAttrVal("Fg_data_transf"));
	}	
	/**
	 * 可转移标志
	 * @param Fg_data_transf
	 */
	public void setFg_data_transf(FBoolean Fg_data_transf) {
		setAttrVal("Fg_data_transf", Fg_data_transf);
	}
	/**
	 * 诊毕时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 诊毕时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 新增时间
	 * @return FDateTime
	 */
	public FDateTime getDt_insert() {
		return ((FDateTime) getAttrVal("Dt_insert"));
	}	
	/**
	 * 新增时间
	 * @param Dt_insert
	 */
	public void setDt_insert(FDateTime Dt_insert) {
		setAttrVal("Dt_insert", Dt_insert);
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
	 * 合同单位
	 * @return String
	 */
	public String getId_cust_cmpy() {
		return ((String) getAttrVal("Id_cust_cmpy"));
	}	
	/**
	 * 合同单位
	 * @param Id_cust_cmpy
	 */
	public void setId_cust_cmpy(String Id_cust_cmpy) {
		setAttrVal("Id_cust_cmpy", Id_cust_cmpy);
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
	 * 客户扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * 客户扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 客户扩展字段7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	/**
	 * 客户扩展字段7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 客户扩展字段8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	/**
	 * 客户扩展字段8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 客户扩展字段9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	/**
	 * 客户扩展字段9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 客户扩展字段10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	/**
	 * 客户扩展字段10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	/**
	 * 医保医疗类别
	 * @return String
	 */
	public String getCode_hpmedkind() {
		return ((String) getAttrVal("Code_hpmedkind"));
	}	
	/**
	 * 医保医疗类别
	 * @param Code_hpmedkind
	 */
	public void setCode_hpmedkind(String Code_hpmedkind) {
		setAttrVal("Code_hpmedkind", Code_hpmedkind);
	}
	/**
	 * 急诊留观标志
	 * @return FBoolean
	 */
	public FBoolean getFg_emgstay() {
		return ((FBoolean) getAttrVal("Fg_emgstay"));
	}	
	/**
	 * 急诊留观标志
	 * @param Fg_emgstay
	 */
	public void setFg_emgstay(FBoolean Fg_emgstay) {
		setAttrVal("Fg_emgstay", Fg_emgstay);
	}
	/**
	 * 付款完成
	 * @return FBoolean
	 */
	public FBoolean getFg_pay() {
		return ((FBoolean) getAttrVal("Fg_pay"));
	}	
	/**
	 * 付款完成
	 * @param Fg_pay
	 */
	public void setFg_pay(FBoolean Fg_pay) {
		setAttrVal("Fg_pay", Fg_pay);
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
	 * 组织机构码
	 * @return String
	 */
	public String getOrgcode() {
		return ((String) getAttrVal("Orgcode"));
	}	
	/**
	 * 组织机构码
	 * @param Orgcode
	 */
	public void setOrgcode(String Orgcode) {
		setAttrVal("Orgcode", Orgcode);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}	
	/**
	 * 就诊类型名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_mari() {
		return ((String) getAttrVal("Name_mari"));
	}	
	/**
	 * 名称
	 * @param Name_mari
	 */
	public void setName_mari(String Name_mari) {
		setAttrVal("Name_mari", Name_mari);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_mari() {
		return ((String) getAttrVal("Code_mari"));
	}	
	/**
	 * 编码
	 * @param Code_mari
	 */
	public void setCode_mari(String Code_mari) {
		setAttrVal("Code_mari", Code_mari);
	}
	/**
	 * 行政区划编码
	 * @return String
	 */
	public String getCode_addr() {
		return ((String) getAttrVal("Code_addr"));
	}	
	/**
	 * 行政区划编码
	 * @param Code_addr
	 */
	public void setCode_addr(String Code_addr) {
		setAttrVal("Code_addr", Code_addr);
	}
	/**
	 * 行政区划名称
	 * @return String
	 */
	public String getName_addr() {
		return ((String) getAttrVal("Name_addr"));
	}	
	/**
	 * 行政区划名称
	 * @param Name_addr
	 */
	public void setName_addr(String Name_addr) {
		setAttrVal("Name_addr", Name_addr);
	}
	/**
	 * 行政区划全称
	 * @return String
	 */
	public String getFullname_addr() {
		return ((String) getAttrVal("Fullname_addr"));
	}	
	/**
	 * 行政区划全称
	 * @param Fullname_addr
	 */
	public void setFullname_addr(String Fullname_addr) {
		setAttrVal("Fullname_addr", Fullname_addr);
	}
	/**
	 * 当前科室名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	/**
	 * 当前科室名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSd_dep_phy() {
		return ((String) getAttrVal("Sd_dep_phy"));
	}	
	/**
	 * 编码
	 * @param Sd_dep_phy
	 */
	public void setSd_dep_phy(String Sd_dep_phy) {
		setAttrVal("Sd_dep_phy", Sd_dep_phy);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 病区名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSd_dep_nur() {
		return ((String) getAttrVal("Sd_dep_nur"));
	}	
	/**
	 * 编码
	 * @param Sd_dep_nur
	 */
	public void setSd_dep_nur(String Sd_dep_nur) {
		setAttrVal("Sd_dep_nur", Sd_dep_nur);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getSd_emp_phy() {
		return ((String) getAttrVal("Sd_emp_phy"));
	}	
	/**
	 * 人员编码
	 * @param Sd_emp_phy
	 */
	public void setSd_emp_phy(String Sd_emp_phy) {
		setAttrVal("Sd_emp_phy", Sd_emp_phy);
	}
	/**
	 * 医保计划名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}	
	/**
	 * 医保计划名称
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 医保计划编码
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 医保计划编码
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 患者分类编码
	 * @return String
	 */
	public String getSd_patca() {
		return ((String) getAttrVal("Sd_patca"));
	}	
	/**
	 * 患者分类编码
	 * @param Sd_patca
	 */
	public void setSd_patca(String Sd_patca) {
		setAttrVal("Sd_patca", Sd_patca);
	}
	/**
	 * 患者分类名称
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}	
	/**
	 * 患者分类名称
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 患者价格分类名称
	 * @return String
	 */
	public String getName_pripat() {
		return ((String) getAttrVal("Name_pripat"));
	}	
	/**
	 * 患者价格分类名称
	 * @param Name_pripat
	 */
	public void setName_pripat(String Name_pripat) {
		setAttrVal("Name_pripat", Name_pripat);
	}
	/**
	 * 患者价格分类编码
	 * @return String
	 */
	public String getCode_pripat() {
		return ((String) getAttrVal("Code_pripat"));
	}	
	/**
	 * 患者价格分类编码
	 * @param Code_pripat
	 */
	public void setCode_pripat(String Code_pripat) {
		setAttrVal("Code_pripat", Code_pripat);
	}
	/**
	 * 患者信用分类编码
	 * @return String
	 */
	public String getCode_patcret() {
		return ((String) getAttrVal("Code_patcret"));
	}	
	/**
	 * 患者信用分类编码
	 * @param Code_patcret
	 */
	public void setCode_patcret(String Code_patcret) {
		setAttrVal("Code_patcret", Code_patcret);
	}
	/**
	 * 者信用分类名称
	 * @return String
	 */
	public String getName_patcret() {
		return ((String) getAttrVal("Name_patcret"));
	}	
	/**
	 * 者信用分类名称
	 * @param Name_patcret
	 */
	public void setName_patcret(String Name_patcret) {
		setAttrVal("Name_patcret", Name_patcret);
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
		return "Id_ent";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PatiVisitDODesc.class);
	}
	
}