package iih.ci.ord.ap.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ap.d.desc.CiApSpecAntiRecordDODesc;
import java.math.BigDecimal;

/**
 * 特殊级抗菌药物临床应用记录表 DO数据 
 * 
 */
public class CiApSpecAntiRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//抗菌药会诊申请ID
	public static final String ID_APSPECANTIRECORD= "Id_apspecantirecord";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//病历号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//关联医嘱
	public static final String ID_OR= "Id_or";
	//关联医嘱服务项目
	public static final String ID_ORSRV= "Id_orsrv";
	//药品主键
	public static final String ID_MM= "Id_mm";
	//服务主键
	public static final String ID_SRV= "Id_srv";
	//临床诊断字典id
	public static final String ID_DIDEF= "Id_didef";
	//诊断名称拼接
	public static final String NAME_DI= "Name_di";
	//药品用法
	public static final String ID_ROUTE= "Id_route";
	//感染性疾病科是否会诊
	public static final String FG_INFECTCONS= "Fg_infectcons";
	//是否已做微生物检查
	public static final String FG_MICROBEINSPECTION= "Fg_microbeinspection";
	//是否紧急情况下使用
	public static final String FG_URGENT= "Fg_urgent";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//开单医生
	public static final String ID_EMP_OR= "Id_emp_or";
	//开单时间
	public static final String DT_EFFE= "Dt_effe";
	//审方医师
	public static final String ID_EMP_PHAR= "Id_emp_phar";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//患者编码
	public static final String CODE_PAT= "Code_pat";
	//物品名称
	public static final String NAME_MM= "Name_mm";
	//通用名
	public static final String NAME_SRV= "Name_srv";
	//用法名称
	public static final String NAME_ROUTE= "Name_route";
	//开单医生
	public static final String NAME_EMP_OR= "Name_emp_or";
	//审方医师
	public static final String NAME_EMP_PHAR= "Name_emp_phar";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 抗菌药会诊申请ID
	 * @return String
	 */
	public String getId_apspecantirecord() {
		return ((String) getAttrVal("Id_apspecantirecord"));
	}	
	/**
	 * 抗菌药会诊申请ID
	 * @param Id_apspecantirecord
	 */
	public void setId_apspecantirecord(String Id_apspecantirecord) {
		setAttrVal("Id_apspecantirecord", Id_apspecantirecord);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 病历号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 病历号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 关联医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 关联医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 关联医嘱服务项目
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	/**
	 * 关联医嘱服务项目
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 药品主键
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 药品主键
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 服务主键
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务主键
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 临床诊断字典id
	 * @return String
	 */
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}	
	/**
	 * 临床诊断字典id
	 * @param Id_didef
	 */
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	/**
	 * 诊断名称拼接
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	/**
	 * 诊断名称拼接
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 药品用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 药品用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 感染性疾病科是否会诊
	 * @return FBoolean
	 */
	public FBoolean getFg_infectcons() {
		return ((FBoolean) getAttrVal("Fg_infectcons"));
	}	
	/**
	 * 感染性疾病科是否会诊
	 * @param Fg_infectcons
	 */
	public void setFg_infectcons(FBoolean Fg_infectcons) {
		setAttrVal("Fg_infectcons", Fg_infectcons);
	}
	/**
	 * 是否已做微生物检查
	 * @return FBoolean
	 */
	public FBoolean getFg_microbeinspection() {
		return ((FBoolean) getAttrVal("Fg_microbeinspection"));
	}	
	/**
	 * 是否已做微生物检查
	 * @param Fg_microbeinspection
	 */
	public void setFg_microbeinspection(FBoolean Fg_microbeinspection) {
		setAttrVal("Fg_microbeinspection", Fg_microbeinspection);
	}
	/**
	 * 是否紧急情况下使用
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}	
	/**
	 * 是否紧急情况下使用
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
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
	 * 开单医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}	
	/**
	 * 开单医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开单时间
	 * @return String
	 */
	public String getDt_effe() {
		return ((String) getAttrVal("Dt_effe"));
	}	
	/**
	 * 开单时间
	 * @param Dt_effe
	 */
	public void setDt_effe(String Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 审方医师
	 * @return String
	 */
	public String getId_emp_phar() {
		return ((String) getAttrVal("Id_emp_phar"));
	}	
	/**
	 * 审方医师
	 * @param Id_emp_phar
	 */
	public void setId_emp_phar(String Id_emp_phar) {
		setAttrVal("Id_emp_phar", Id_emp_phar);
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
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 通用名
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 通用名
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}	
	/**
	 * 用法名称
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 开单医生
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}	
	/**
	 * 开单医生
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 审方医师
	 * @return String
	 */
	public String getName_emp_phar() {
		return ((String) getAttrVal("Name_emp_phar"));
	}	
	/**
	 * 审方医师
	 * @param Name_emp_phar
	 */
	public void setName_emp_phar(String Name_emp_phar) {
		setAttrVal("Name_emp_phar", Name_emp_phar);
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
		return "Id_apspecantirecord";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_spec_anti_record";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiApSpecAntiRecordDODesc.class);
	}
	
}