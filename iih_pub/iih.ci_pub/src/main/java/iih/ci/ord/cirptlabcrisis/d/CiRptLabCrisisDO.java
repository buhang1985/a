package iih.ci.ord.cirptlabcrisis.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cirptlabcrisis.d.desc.CiRptLabCrisisDODesc;
import java.math.BigDecimal;

/**
 * 检验危急值实体 DO数据 
 * 
 */
public class CiRptLabCrisisDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//检验危急值主键
	public static final String ID_RPT_LAB_CRISIS= "Id_rpt_lab_crisis";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//就诊ID
	public static final String ID_ENT= "Id_ent";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//LIS上报ID
	public static final String ID_ALERT= "Id_alert";
	//申请单号
	public static final String NO_APPLYFORM= "No_applyform";
	//上报时间
	public static final String DT_ALERT= "Dt_alert";
	//上报人主键
	public static final String ID_EMP_ALERT= "Id_emp_alert";
	//标本类型名称
	public static final String NAME_LABSAMPTP= "Name_labsamptp";
	//标本签收时间
	public static final String DT_RECIEVE= "Dt_recieve";
	//上报项目ID
	public static final String ID_SRV= "Id_srv";
	//上报项目编码
	public static final String CODE_RPTITM= "Code_rptitm";
	//上报项目名称
	public static final String NAME_RPTITM= "Name_rptitm";
	//结果值
	public static final String VAL_RSTRPTLAB= "Val_rstrptlab";
	//检验结果状态ID
	public static final String ID_DEVIATE= "Id_deviate";
	//检验结果状态编码
	public static final String SD_DEVIATE= "Sd_deviate";
	//单位名称
	public static final String NAME_UNIT= "Name_unit";
	//参考值
	public static final String VAL_REFERENCE= "Val_reference";
	//上报描述
	public static final String DESCRIPTIONS= "Descriptions";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//上报人姓名
	public static final String NAME_EMP_ALERT= "Name_emp_alert";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 检验危急值主键
	 * @return String
	 */
	public String getId_rpt_lab_crisis() {
		return ((String) getAttrVal("Id_rpt_lab_crisis"));
	}	
	/**
	 * 检验危急值主键
	 * @param Id_rpt_lab_crisis
	 */
	public void setId_rpt_lab_crisis(String Id_rpt_lab_crisis) {
		setAttrVal("Id_rpt_lab_crisis", Id_rpt_lab_crisis);
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
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * LIS上报ID
	 * @return String
	 */
	public String getId_alert() {
		return ((String) getAttrVal("Id_alert"));
	}	
	/**
	 * LIS上报ID
	 * @param Id_alert
	 */
	public void setId_alert(String Id_alert) {
		setAttrVal("Id_alert", Id_alert);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 上报时间
	 * @return FDateTime
	 */
	public FDateTime getDt_alert() {
		return ((FDateTime) getAttrVal("Dt_alert"));
	}	
	/**
	 * 上报时间
	 * @param Dt_alert
	 */
	public void setDt_alert(FDateTime Dt_alert) {
		setAttrVal("Dt_alert", Dt_alert);
	}
	/**
	 * 上报人主键
	 * @return String
	 */
	public String getId_emp_alert() {
		return ((String) getAttrVal("Id_emp_alert"));
	}	
	/**
	 * 上报人主键
	 * @param Id_emp_alert
	 */
	public void setId_emp_alert(String Id_emp_alert) {
		setAttrVal("Id_emp_alert", Id_emp_alert);
	}
	/**
	 * 标本类型名称
	 * @return String
	 */
	public String getName_labsamptp() {
		return ((String) getAttrVal("Name_labsamptp"));
	}	
	/**
	 * 标本类型名称
	 * @param Name_labsamptp
	 */
	public void setName_labsamptp(String Name_labsamptp) {
		setAttrVal("Name_labsamptp", Name_labsamptp);
	}
	/**
	 * 标本签收时间
	 * @return FDateTime
	 */
	public FDateTime getDt_recieve() {
		return ((FDateTime) getAttrVal("Dt_recieve"));
	}	
	/**
	 * 标本签收时间
	 * @param Dt_recieve
	 */
	public void setDt_recieve(FDateTime Dt_recieve) {
		setAttrVal("Dt_recieve", Dt_recieve);
	}
	/**
	 * 上报项目ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 上报项目ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 上报项目编码
	 * @return String
	 */
	public String getCode_rptitm() {
		return ((String) getAttrVal("Code_rptitm"));
	}	
	/**
	 * 上报项目编码
	 * @param Code_rptitm
	 */
	public void setCode_rptitm(String Code_rptitm) {
		setAttrVal("Code_rptitm", Code_rptitm);
	}
	/**
	 * 上报项目名称
	 * @return String
	 */
	public String getName_rptitm() {
		return ((String) getAttrVal("Name_rptitm"));
	}	
	/**
	 * 上报项目名称
	 * @param Name_rptitm
	 */
	public void setName_rptitm(String Name_rptitm) {
		setAttrVal("Name_rptitm", Name_rptitm);
	}
	/**
	 * 结果值
	 * @return String
	 */
	public String getVal_rstrptlab() {
		return ((String) getAttrVal("Val_rstrptlab"));
	}	
	/**
	 * 结果值
	 * @param Val_rstrptlab
	 */
	public void setVal_rstrptlab(String Val_rstrptlab) {
		setAttrVal("Val_rstrptlab", Val_rstrptlab);
	}
	/**
	 * 检验结果状态ID
	 * @return String
	 */
	public String getId_deviate() {
		return ((String) getAttrVal("Id_deviate"));
	}	
	/**
	 * 检验结果状态ID
	 * @param Id_deviate
	 */
	public void setId_deviate(String Id_deviate) {
		setAttrVal("Id_deviate", Id_deviate);
	}
	/**
	 * 检验结果状态编码
	 * @return String
	 */
	public String getSd_deviate() {
		return ((String) getAttrVal("Sd_deviate"));
	}	
	/**
	 * 检验结果状态编码
	 * @param Sd_deviate
	 */
	public void setSd_deviate(String Sd_deviate) {
		setAttrVal("Sd_deviate", Sd_deviate);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	/**
	 * 单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 参考值
	 * @return String
	 */
	public String getVal_reference() {
		return ((String) getAttrVal("Val_reference"));
	}	
	/**
	 * 参考值
	 * @param Val_reference
	 */
	public void setVal_reference(String Val_reference) {
		setAttrVal("Val_reference", Val_reference);
	}
	/**
	 * 上报描述
	 * @return String
	 */
	public String getDescriptions() {
		return ((String) getAttrVal("Descriptions"));
	}	
	/**
	 * 上报描述
	 * @param Descriptions
	 */
	public void setDescriptions(String Descriptions) {
		setAttrVal("Descriptions", Descriptions);
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
	 * 上报人姓名
	 * @return String
	 */
	public String getName_emp_alert() {
		return ((String) getAttrVal("Name_emp_alert"));
	}	
	/**
	 * 上报人姓名
	 * @param Name_emp_alert
	 */
	public void setName_emp_alert(String Name_emp_alert) {
		setAttrVal("Name_emp_alert", Name_emp_alert);
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
		return "Id_rpt_lab_crisis";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_RPT_LAB_CRISIS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiRptLabCrisisDODesc.class);
	}
	
}