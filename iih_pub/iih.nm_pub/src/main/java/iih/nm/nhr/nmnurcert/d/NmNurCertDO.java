package iih.nm.nhr.nmnurcert.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnurcert.d.desc.NmNurCertDODesc;
import java.math.BigDecimal;

/**
 * 人员证书 DO数据 
 * 
 */
public class NmNurCertDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//人员证书主键
	public static final String ID_NUR_CERT= "Id_nur_cert";
	//人员基本信息
	public static final String ID_NUR= "Id_nur";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//证书编号
	public static final String CODE= "Code";
	//证书名称
	public static final String NAME= "Name";
	//证书类别id
	public static final String ID_CERTCA= "Id_certca";
	//证书类别编码
	public static final String SD_CERTCA= "Sd_certca";
	//证书类型id
	public static final String ID_CERTTP= "Id_certtp";
	//证书类型编码
	public static final String SD_CERTTP= "Sd_certtp";
	//专业id
	public static final String ID_MAJOR= "Id_major";
	//专业编码
	public static final String SD_MAJOR= "Sd_major";
	//资格级别id
	public static final String ID_CERT_LEVEL= "Id_cert_level";
	//资格级别编码
	public static final String SD_CERT_LEVEL= "Sd_cert_level";
	//证书日期
	public static final String DT_CERT= "Dt_cert";
	//获得时间
	public static final String DT_GAIN= "Dt_gain";
	//到期时间
	public static final String DT_DUE= "Dt_due";
	//发证机构
	public static final String NAME_CERT_ORG= "Name_cert_org";
	//在用标志
	public static final String FG_ACTIVE= "Fg_active";
	//教育经历
	public static final String ID_NUR_EDUEXP= "Id_nur_eduexp";
	//工作经历
	public static final String ID_NUR_WKEXP= "Id_nur_wkexp";
	//审核人
	public static final String ID_NUR_AUDIT= "Id_nur_audit";
	//审核时间
	public static final String DT_AUDIT= "Dt_audit";
	//登记人
	public static final String ID_REG_PSN= "Id_reg_psn";
	//登记时间
	public static final String DT_REG= "Dt_reg";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//人员姓名
	public static final String NAME_NUR= "Name_nur";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//名称
	public static final String NAME_CERTCA= "Name_certca";
	//名称
	public static final String NAME_CERTTP= "Name_certtp";
	//名称
	public static final String NAME_MAJOR= "Name_major";
	//名称
	public static final String NAME_CERT_LEVEL= "Name_cert_level";
	//学校
	public static final String NAME_SCH_EDUEXP= "Name_sch_eduexp";
	//工作单位
	public static final String NAME_WORK_PART_NUE_WKEXP= "Name_work_part_nue_wkexp";
	//用户名称
	public static final String NAME_AUDIT= "Name_audit";
	//用户名称
	public static final String NAME_REG= "Name_reg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 人员证书主键
	 * @return String
	 */
	public String getId_nur_cert() {
		return ((String) getAttrVal("Id_nur_cert"));
	}	
	/**
	 * 人员证书主键
	 * @param Id_nur_cert
	 */
	public void setId_nur_cert(String Id_nur_cert) {
		setAttrVal("Id_nur_cert", Id_nur_cert);
	}
	/**
	 * 人员基本信息
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 人员基本信息
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
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
	 * 证书编号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 证书编号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 证书名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 证书名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 证书类别id
	 * @return String
	 */
	public String getId_certca() {
		return ((String) getAttrVal("Id_certca"));
	}	
	/**
	 * 证书类别id
	 * @param Id_certca
	 */
	public void setId_certca(String Id_certca) {
		setAttrVal("Id_certca", Id_certca);
	}
	/**
	 * 证书类别编码
	 * @return String
	 */
	public String getSd_certca() {
		return ((String) getAttrVal("Sd_certca"));
	}	
	/**
	 * 证书类别编码
	 * @param Sd_certca
	 */
	public void setSd_certca(String Sd_certca) {
		setAttrVal("Sd_certca", Sd_certca);
	}
	/**
	 * 证书类型id
	 * @return String
	 */
	public String getId_certtp() {
		return ((String) getAttrVal("Id_certtp"));
	}	
	/**
	 * 证书类型id
	 * @param Id_certtp
	 */
	public void setId_certtp(String Id_certtp) {
		setAttrVal("Id_certtp", Id_certtp);
	}
	/**
	 * 证书类型编码
	 * @return String
	 */
	public String getSd_certtp() {
		return ((String) getAttrVal("Sd_certtp"));
	}	
	/**
	 * 证书类型编码
	 * @param Sd_certtp
	 */
	public void setSd_certtp(String Sd_certtp) {
		setAttrVal("Sd_certtp", Sd_certtp);
	}
	/**
	 * 专业id
	 * @return String
	 */
	public String getId_major() {
		return ((String) getAttrVal("Id_major"));
	}	
	/**
	 * 专业id
	 * @param Id_major
	 */
	public void setId_major(String Id_major) {
		setAttrVal("Id_major", Id_major);
	}
	/**
	 * 专业编码
	 * @return String
	 */
	public String getSd_major() {
		return ((String) getAttrVal("Sd_major"));
	}	
	/**
	 * 专业编码
	 * @param Sd_major
	 */
	public void setSd_major(String Sd_major) {
		setAttrVal("Sd_major", Sd_major);
	}
	/**
	 * 资格级别id
	 * @return String
	 */
	public String getId_cert_level() {
		return ((String) getAttrVal("Id_cert_level"));
	}	
	/**
	 * 资格级别id
	 * @param Id_cert_level
	 */
	public void setId_cert_level(String Id_cert_level) {
		setAttrVal("Id_cert_level", Id_cert_level);
	}
	/**
	 * 资格级别编码
	 * @return String
	 */
	public String getSd_cert_level() {
		return ((String) getAttrVal("Sd_cert_level"));
	}	
	/**
	 * 资格级别编码
	 * @param Sd_cert_level
	 */
	public void setSd_cert_level(String Sd_cert_level) {
		setAttrVal("Sd_cert_level", Sd_cert_level);
	}
	/**
	 * 证书日期
	 * @return FDateTime
	 */
	public FDateTime getDt_cert() {
		return ((FDateTime) getAttrVal("Dt_cert"));
	}	
	/**
	 * 证书日期
	 * @param Dt_cert
	 */
	public void setDt_cert(FDateTime Dt_cert) {
		setAttrVal("Dt_cert", Dt_cert);
	}
	/**
	 * 获得时间
	 * @return FDateTime
	 */
	public FDateTime getDt_gain() {
		return ((FDateTime) getAttrVal("Dt_gain"));
	}	
	/**
	 * 获得时间
	 * @param Dt_gain
	 */
	public void setDt_gain(FDateTime Dt_gain) {
		setAttrVal("Dt_gain", Dt_gain);
	}
	/**
	 * 到期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_due() {
		return ((FDateTime) getAttrVal("Dt_due"));
	}	
	/**
	 * 到期时间
	 * @param Dt_due
	 */
	public void setDt_due(FDateTime Dt_due) {
		setAttrVal("Dt_due", Dt_due);
	}
	/**
	 * 发证机构
	 * @return String
	 */
	public String getName_cert_org() {
		return ((String) getAttrVal("Name_cert_org"));
	}	
	/**
	 * 发证机构
	 * @param Name_cert_org
	 */
	public void setName_cert_org(String Name_cert_org) {
		setAttrVal("Name_cert_org", Name_cert_org);
	}
	/**
	 * 在用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 在用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 教育经历
	 * @return String
	 */
	public String getId_nur_eduexp() {
		return ((String) getAttrVal("Id_nur_eduexp"));
	}	
	/**
	 * 教育经历
	 * @param Id_nur_eduexp
	 */
	public void setId_nur_eduexp(String Id_nur_eduexp) {
		setAttrVal("Id_nur_eduexp", Id_nur_eduexp);
	}
	/**
	 * 工作经历
	 * @return String
	 */
	public String getId_nur_wkexp() {
		return ((String) getAttrVal("Id_nur_wkexp"));
	}	
	/**
	 * 工作经历
	 * @param Id_nur_wkexp
	 */
	public void setId_nur_wkexp(String Id_nur_wkexp) {
		setAttrVal("Id_nur_wkexp", Id_nur_wkexp);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getId_nur_audit() {
		return ((String) getAttrVal("Id_nur_audit"));
	}	
	/**
	 * 审核人
	 * @param Id_nur_audit
	 */
	public void setId_nur_audit(String Id_nur_audit) {
		setAttrVal("Id_nur_audit", Id_nur_audit);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_audit() {
		return ((FDateTime) getAttrVal("Dt_audit"));
	}	
	/**
	 * 审核时间
	 * @param Dt_audit
	 */
	public void setDt_audit(FDateTime Dt_audit) {
		setAttrVal("Dt_audit", Dt_audit);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getId_reg_psn() {
		return ((String) getAttrVal("Id_reg_psn"));
	}	
	/**
	 * 登记人
	 * @param Id_reg_psn
	 */
	public void setId_reg_psn(String Id_reg_psn) {
		setAttrVal("Id_reg_psn", Id_reg_psn);
	}
	/**
	 * 登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 登记时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
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
	 * 人员姓名
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 人员姓名
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
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
	 * 名称
	 * @return String
	 */
	public String getName_certca() {
		return ((String) getAttrVal("Name_certca"));
	}	
	/**
	 * 名称
	 * @param Name_certca
	 */
	public void setName_certca(String Name_certca) {
		setAttrVal("Name_certca", Name_certca);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_certtp() {
		return ((String) getAttrVal("Name_certtp"));
	}	
	/**
	 * 名称
	 * @param Name_certtp
	 */
	public void setName_certtp(String Name_certtp) {
		setAttrVal("Name_certtp", Name_certtp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_major() {
		return ((String) getAttrVal("Name_major"));
	}	
	/**
	 * 名称
	 * @param Name_major
	 */
	public void setName_major(String Name_major) {
		setAttrVal("Name_major", Name_major);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_cert_level() {
		return ((String) getAttrVal("Name_cert_level"));
	}	
	/**
	 * 名称
	 * @param Name_cert_level
	 */
	public void setName_cert_level(String Name_cert_level) {
		setAttrVal("Name_cert_level", Name_cert_level);
	}
	/**
	 * 学校
	 * @return String
	 */
	public String getName_sch_eduexp() {
		return ((String) getAttrVal("Name_sch_eduexp"));
	}	
	/**
	 * 学校
	 * @param Name_sch_eduexp
	 */
	public void setName_sch_eduexp(String Name_sch_eduexp) {
		setAttrVal("Name_sch_eduexp", Name_sch_eduexp);
	}
	/**
	 * 工作单位
	 * @return String
	 */
	public String getName_work_part_nue_wkexp() {
		return ((String) getAttrVal("Name_work_part_nue_wkexp"));
	}	
	/**
	 * 工作单位
	 * @param Name_work_part_nue_wkexp
	 */
	public void setName_work_part_nue_wkexp(String Name_work_part_nue_wkexp) {
		setAttrVal("Name_work_part_nue_wkexp", Name_work_part_nue_wkexp);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_audit() {
		return ((String) getAttrVal("Name_audit"));
	}	
	/**
	 * 用户名称
	 * @param Name_audit
	 */
	public void setName_audit(String Name_audit) {
		setAttrVal("Name_audit", Name_audit);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_reg() {
		return ((String) getAttrVal("Name_reg"));
	}	
	/**
	 * 用户名称
	 * @param Name_reg
	 */
	public void setName_reg(String Name_reg) {
		setAttrVal("Name_reg", Name_reg);
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
		return "Id_nur_cert";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NHR_NUR_CERT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNurCertDODesc.class);
	}
	
}