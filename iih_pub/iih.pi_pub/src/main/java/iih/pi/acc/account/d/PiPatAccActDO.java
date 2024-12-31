package iih.pi.acc.account.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.acc.account.d.desc.PiPatAccActDODesc;
import java.math.BigDecimal;

/**
 * 患者账户操作明细 DO数据 
 * 
 */
public class PiPatAccActDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//账户信用度操作ID
	public static final String ID_PATACCCRETACT= "Id_patacccretact";
	//患者账户
	public static final String ID_PATACC= "Id_patacc";
	//账户操作类型编码
	public static final String SD_ACCACTTP= "Sd_accacttp";
	//账户操作类型
	public static final String ID_ACCACTTP= "Id_accacttp";
	//操作文件号
	public static final String ACCFILENO= "Accfileno";
	//操作时间
	public static final String OPERATE_TIME= "Operate_time";
	//操作方向值
	public static final String OPERATE_DIRECT= "Operate_direct";
	//操作信用度
	public static final String CRED= "Cred";
	//操作人员
	public static final String ID_EMP= "Id_emp";
	//备注
	public static final String NOTE= "Note";
	//操作方向
	public static final String OPERATE_DIRECT_TEXT= "Operate_direct_text";
	//机构
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//留观_信用度
	public static final String CRED_EMGSTAY= "Cred_emgstay";
	//担保人
	public static final String ID_EMP_GUARANT= "Id_emp_guarant";
	//担保到期时间
	public static final String DT_GUARANTEE= "Dt_guarantee";
	//担保到期额度重置标志
	public static final String FG_CRED_RESET= "Fg_cred_reset";
	//账户名称
	public static final String PATACC_NAME= "Patacc_name";
	//账户编码
	public static final String PATACC_CODE= "Patacc_code";
	//编码
	public static final String ACCTP_CODE= "Acctp_code";
	//名称
	public static final String ACCTP_NAME= "Acctp_name";
	//人员编码
	public static final String EMP_CODE= "Emp_code";
	//姓名
	public static final String EMP_NAME= "Emp_name";
	//姓名
	public static final String EMP_GUARANT_NAME= "Emp_guarant_name";
	//人员编码
	public static final String EMP_GUARANT_CODE= "Emp_guarant_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 账户信用度操作ID
	 * @return String
	 */
	public String getId_patacccretact() {
		return ((String) getAttrVal("Id_patacccretact"));
	}	
	/**
	 * 账户信用度操作ID
	 * @param Id_patacccretact
	 */
	public void setId_patacccretact(String Id_patacccretact) {
		setAttrVal("Id_patacccretact", Id_patacccretact);
	}
	/**
	 * 患者账户
	 * @return String
	 */
	public String getId_patacc() {
		return ((String) getAttrVal("Id_patacc"));
	}	
	/**
	 * 患者账户
	 * @param Id_patacc
	 */
	public void setId_patacc(String Id_patacc) {
		setAttrVal("Id_patacc", Id_patacc);
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
	public FDateTime getOperate_time() {
		return ((FDateTime) getAttrVal("Operate_time"));
	}	
	/**
	 * 操作时间
	 * @param Operate_time
	 */
	public void setOperate_time(FDateTime Operate_time) {
		setAttrVal("Operate_time", Operate_time);
	}
	/**
	 * 操作方向值
	 * @return Integer
	 */
	public Integer getOperate_direct() {
		return ((Integer) getAttrVal("Operate_direct"));
	}	
	/**
	 * 操作方向值
	 * @param Operate_direct
	 */
	public void setOperate_direct(Integer Operate_direct) {
		setAttrVal("Operate_direct", Operate_direct);
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
	 * 操作方向
	 * @return String
	 */
	public String getOperate_direct_text() {
		return ((String) getAttrVal("Operate_direct_text"));
	}	
	/**
	 * 操作方向
	 * @param Operate_direct_text
	 */
	public void setOperate_direct_text(String Operate_direct_text) {
		setAttrVal("Operate_direct_text", Operate_direct_text);
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
	 * 留观_信用度
	 * @return FDouble
	 */
	public FDouble getCred_emgstay() {
		return ((FDouble) getAttrVal("Cred_emgstay"));
	}	
	/**
	 * 留观_信用度
	 * @param Cred_emgstay
	 */
	public void setCred_emgstay(FDouble Cred_emgstay) {
		setAttrVal("Cred_emgstay", Cred_emgstay);
	}
	/**
	 * 担保人
	 * @return String
	 */
	public String getId_emp_guarant() {
		return ((String) getAttrVal("Id_emp_guarant"));
	}	
	/**
	 * 担保人
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
	 * 账户名称
	 * @return String
	 */
	public String getPatacc_name() {
		return ((String) getAttrVal("Patacc_name"));
	}	
	/**
	 * 账户名称
	 * @param Patacc_name
	 */
	public void setPatacc_name(String Patacc_name) {
		setAttrVal("Patacc_name", Patacc_name);
	}
	/**
	 * 账户编码
	 * @return String
	 */
	public String getPatacc_code() {
		return ((String) getAttrVal("Patacc_code"));
	}	
	/**
	 * 账户编码
	 * @param Patacc_code
	 */
	public void setPatacc_code(String Patacc_code) {
		setAttrVal("Patacc_code", Patacc_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getAcctp_code() {
		return ((String) getAttrVal("Acctp_code"));
	}	
	/**
	 * 编码
	 * @param Acctp_code
	 */
	public void setAcctp_code(String Acctp_code) {
		setAttrVal("Acctp_code", Acctp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAcctp_name() {
		return ((String) getAttrVal("Acctp_name"));
	}	
	/**
	 * 名称
	 * @param Acctp_name
	 */
	public void setAcctp_name(String Acctp_name) {
		setAttrVal("Acctp_name", Acctp_name);
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
	 * 姓名
	 * @return String
	 */
	public String getEmp_guarant_name() {
		return ((String) getAttrVal("Emp_guarant_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_guarant_name
	 */
	public void setEmp_guarant_name(String Emp_guarant_name) {
		setAttrVal("Emp_guarant_name", Emp_guarant_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getEmp_guarant_code() {
		return ((String) getAttrVal("Emp_guarant_code"));
	}	
	/**
	 * 人员编码
	 * @param Emp_guarant_code
	 */
	public void setEmp_guarant_code(String Emp_guarant_code) {
		setAttrVal("Emp_guarant_code", Emp_guarant_code);
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
		return "Id_patacccretact";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_acc_act";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatAccActDODesc.class);
	}
	
}