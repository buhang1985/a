package iih.en.pv.enfee.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enfee.d.desc.EntAccActDODesc;
import java.math.BigDecimal;

/**
 * 就诊账户操作明细 DO数据 
 * 
 */
public class EntAccActDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//账户操作明细id
	public static final String ID_ENTACCACT= "Id_entaccact";
	//患者就诊账户
	public static final String ID_ENTACC= "Id_entacc";
	//账户操作类型
	public static final String ID_ACCACTTP= "Id_accacttp";
	//账户操作类型编码
	public static final String SD_ACCACTTP= "Sd_accacttp";
	//操作文件号
	public static final String ACCFILENO= "Accfileno";
	//操作时间
	public static final String ORICRET= "Oricret";
	//操作方向
	public static final String NEWCRET= "Newcret";
	//操作方向名称
	public static final String NAME_NEWCRET= "Name_newcret";
	//操作信用度
	public static final String CRED= "Cred";
	//操作人员
	public static final String ID_EMP= "Id_emp";
	//备注
	public static final String NOTE= "Note";
	//患者名称计算列
	public static final String NAME_PAT= "Name_pat";
	//机构
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//担保人ID
	public static final String ID_EMP_GUARANT= "Id_emp_guarant";
	//担保到期时间
	public static final String DT_GUARANTEE= "Dt_guarantee";
	//担保到期额度重置标志
	public static final String FG_CRED_RESET= "Fg_cred_reset";
	//人员编码
	public static final String EMP_CODE= "Emp_code";
	//姓名
	public static final String EMP_NAME= "Emp_name";
	//人员编码
	public static final String CODE_EMP_GUARANT= "Code_emp_guarant";
	//姓名
	public static final String NAME_EMP_GUARANT= "Name_emp_guarant";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 账户操作明细id
	 * @return String
	 */
	public String getId_entaccact() {
		return ((String) getAttrVal("Id_entaccact"));
	}	
	/**
	 * 账户操作明细id
	 * @param Id_entaccact
	 */
	public void setId_entaccact(String Id_entaccact) {
		setAttrVal("Id_entaccact", Id_entaccact);
	}
	/**
	 * 患者就诊账户
	 * @return String
	 */
	public String getId_entacc() {
		return ((String) getAttrVal("Id_entacc"));
	}	
	/**
	 * 患者就诊账户
	 * @param Id_entacc
	 */
	public void setId_entacc(String Id_entacc) {
		setAttrVal("Id_entacc", Id_entacc);
	}
	/**
	 * 账户操作类型
	 * @return String
	 */
	public String getId_accacttp() {
		return ((String) getAttrVal("Id_accacttp"));
	}	
	/**
	 * 账户操作类型
	 * @param Id_accacttp
	 */
	public void setId_accacttp(String Id_accacttp) {
		setAttrVal("Id_accacttp", Id_accacttp);
	}
	/**
	 * 账户操作类型编码
	 * @return String
	 */
	public String getSd_accacttp() {
		return ((String) getAttrVal("Sd_accacttp"));
	}	
	/**
	 * 账户操作类型编码
	 * @param Sd_accacttp
	 */
	public void setSd_accacttp(String Sd_accacttp) {
		setAttrVal("Sd_accacttp", Sd_accacttp);
	}
	/**
	 * 操作文件号
	 * @return String
	 */
	public String getAccfileno() {
		return ((String) getAttrVal("Accfileno"));
	}	
	/**
	 * 操作文件号
	 * @param Accfileno
	 */
	public void setAccfileno(String Accfileno) {
		setAttrVal("Accfileno", Accfileno);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getOricret() {
		return ((FDateTime) getAttrVal("Oricret"));
	}	
	/**
	 * 操作时间
	 * @param Oricret
	 */
	public void setOricret(FDateTime Oricret) {
		setAttrVal("Oricret", Oricret);
	}
	/**
	 * 操作方向
	 * @return Integer
	 */
	public Integer getNewcret() {
		return ((Integer) getAttrVal("Newcret"));
	}	
	/**
	 * 操作方向
	 * @param Newcret
	 */
	public void setNewcret(Integer Newcret) {
		setAttrVal("Newcret", Newcret);
	}
	/**
	 * 操作方向名称
	 * @return String
	 */
	public String getName_newcret() {
		return ((String) getAttrVal("Name_newcret"));
	}	
	/**
	 * 操作方向名称
	 * @param Name_newcret
	 */
	public void setName_newcret(String Name_newcret) {
		setAttrVal("Name_newcret", Name_newcret);
	}
	/**
	 * 操作信用度
	 * @return FDouble
	 */
	public FDouble getCred() {
		return ((FDouble) getAttrVal("Cred"));
	}	
	/**
	 * 操作信用度
	 * @param Cred
	 */
	public void setCred(FDouble Cred) {
		setAttrVal("Cred", Cred);
	}
	/**
	 * 操作人员
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 操作人员
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
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
	 * 患者名称计算列
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者名称计算列
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
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
	 * 担保人ID
	 * @return String
	 */
	public String getId_emp_guarant() {
		return ((String) getAttrVal("Id_emp_guarant"));
	}	
	/**
	 * 担保人ID
	 * @param Id_emp_guarant
	 */
	public void setId_emp_guarant(String Id_emp_guarant) {
		setAttrVal("Id_emp_guarant", Id_emp_guarant);
	}
	/**
	 * 担保到期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_guarantee() {
		return ((FDateTime) getAttrVal("Dt_guarantee"));
	}	
	/**
	 * 担保到期时间
	 * @param Dt_guarantee
	 */
	public void setDt_guarantee(FDateTime Dt_guarantee) {
		setAttrVal("Dt_guarantee", Dt_guarantee);
	}
	/**
	 * 担保到期额度重置标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cred_reset() {
		return ((FBoolean) getAttrVal("Fg_cred_reset"));
	}	
	/**
	 * 担保到期额度重置标志
	 * @param Fg_cred_reset
	 */
	public void setFg_cred_reset(FBoolean Fg_cred_reset) {
		setAttrVal("Fg_cred_reset", Fg_cred_reset);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getEmp_code() {
		return ((String) getAttrVal("Emp_code"));
	}	
	/**
	 * 人员编码
	 * @param Emp_code
	 */
	public void setEmp_code(String Emp_code) {
		setAttrVal("Emp_code", Emp_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_name
	 */
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_emp_guarant() {
		return ((String) getAttrVal("Code_emp_guarant"));
	}	
	/**
	 * 人员编码
	 * @param Code_emp_guarant
	 */
	public void setCode_emp_guarant(String Code_emp_guarant) {
		setAttrVal("Code_emp_guarant", Code_emp_guarant);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_guarant() {
		return ((String) getAttrVal("Name_emp_guarant"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_guarant
	 */
	public void setName_emp_guarant(String Name_emp_guarant) {
		setAttrVal("Name_emp_guarant", Name_emp_guarant);
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
		return "Id_entaccact";
	}
	
	@Override
	public String getTableName() {	  
		return "EN_ENT_ACC_ACT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EntAccActDODesc.class);
	}
	
}