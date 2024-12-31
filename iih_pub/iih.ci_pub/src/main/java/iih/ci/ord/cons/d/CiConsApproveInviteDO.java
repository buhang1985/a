package iih.ci.ord.cons.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cons.d.desc.CiConsApproveInviteDODesc;
import java.math.BigDecimal;

/**
 * 医嘱会诊审批安排应答人 DO数据 
 * 
 */
public class CiConsApproveInviteDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//会诊审批安排应答人
	public static final String ID_CONSAPPROVEINVITE= "Id_consapproveinvite";
	//会诊审批记录ID
	public static final String ID_CONSAPPROVE= "Id_consapprove";
	//会诊医嘱
	public static final String ID_OR= "Id_or";
	//会诊申请
	public static final String ID_APCONS= "Id_apcons";
	//会诊受邀对象ID
	public static final String ID_INVITECONS= "Id_invitecons";
	//应答机构
	public static final String ID_ORG= "Id_org";
	//应答机构名称
	public static final String NAME_ORG= "Name_org";
	//应答科室
	public static final String ID_DEP= "Id_dep";
	//应答人人
	public static final String ID_EMP= "Id_emp";
	//应答人职称
	public static final String ID_EMPTITLE= "Id_emptitle";
	//应答人职称编码
	public static final String SD_EMPTITLE= "Sd_emptitle";
	//应答人联系方式
	public static final String TEL= "Tel";
	//作废标志
	public static final String FG_CANC= "Fg_canc";
	//作废人
	public static final String ID_EMP_CANC= "Id_emp_canc";
	//作废时间
	public static final String DT_CANC= "Dt_canc";
	//应答科室名称
	public static final String NAME_DEP= "Name_dep";
	//应答人姓名
	public static final String NAME_EMP= "Name_emp";
	//应答人职称名称
	public static final String NAME_EMPTITLE= "Name_emptitle";
	//作废人姓名
	public static final String NAME_EMP_CANC= "Name_emp_canc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 会诊审批安排应答人
	 * @return String
	 */
	public String getId_consapproveinvite() {
		return ((String) getAttrVal("Id_consapproveinvite"));
	}	
	/**
	 * 会诊审批安排应答人
	 * @param Id_consapproveinvite
	 */
	public void setId_consapproveinvite(String Id_consapproveinvite) {
		setAttrVal("Id_consapproveinvite", Id_consapproveinvite);
	}
	/**
	 * 会诊审批记录ID
	 * @return String
	 */
	public String getId_consapprove() {
		return ((String) getAttrVal("Id_consapprove"));
	}	
	/**
	 * 会诊审批记录ID
	 * @param Id_consapprove
	 */
	public void setId_consapprove(String Id_consapprove) {
		setAttrVal("Id_consapprove", Id_consapprove);
	}
	/**
	 * 会诊医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 会诊医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 会诊申请
	 * @return String
	 */
	public String getId_apcons() {
		return ((String) getAttrVal("Id_apcons"));
	}	
	/**
	 * 会诊申请
	 * @param Id_apcons
	 */
	public void setId_apcons(String Id_apcons) {
		setAttrVal("Id_apcons", Id_apcons);
	}
	/**
	 * 会诊受邀对象ID
	 * @return String
	 */
	public String getId_invitecons() {
		return ((String) getAttrVal("Id_invitecons"));
	}	
	/**
	 * 会诊受邀对象ID
	 * @param Id_invitecons
	 */
	public void setId_invitecons(String Id_invitecons) {
		setAttrVal("Id_invitecons", Id_invitecons);
	}
	/**
	 * 应答机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 应答机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 应答机构名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 应答机构名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 应答科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 应答科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 应答人人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 应答人人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 应答人职称
	 * @return String
	 */
	public String getId_emptitle() {
		return ((String) getAttrVal("Id_emptitle"));
	}	
	/**
	 * 应答人职称
	 * @param Id_emptitle
	 */
	public void setId_emptitle(String Id_emptitle) {
		setAttrVal("Id_emptitle", Id_emptitle);
	}
	/**
	 * 应答人职称编码
	 * @return String
	 */
	public String getSd_emptitle() {
		return ((String) getAttrVal("Sd_emptitle"));
	}	
	/**
	 * 应答人职称编码
	 * @param Sd_emptitle
	 */
	public void setSd_emptitle(String Sd_emptitle) {
		setAttrVal("Sd_emptitle", Sd_emptitle);
	}
	/**
	 * 应答人联系方式
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	/**
	 * 应答人联系方式
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 作废标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	/**
	 * 作废标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 作废人
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	/**
	 * 作废人
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	/**
	 * 作废时间
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	/**
	 * 作废时间
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 应答科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 应答科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 应答人姓名
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	/**
	 * 应答人姓名
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 应答人职称名称
	 * @return String
	 */
	public String getName_emptitle() {
		return ((String) getAttrVal("Name_emptitle"));
	}	
	/**
	 * 应答人职称名称
	 * @param Name_emptitle
	 */
	public void setName_emptitle(String Name_emptitle) {
		setAttrVal("Name_emptitle", Name_emptitle);
	}
	/**
	 * 作废人姓名
	 * @return String
	 */
	public String getName_emp_canc() {
		return ((String) getAttrVal("Name_emp_canc"));
	}	
	/**
	 * 作废人姓名
	 * @param Name_emp_canc
	 */
	public void setName_emp_canc(String Name_emp_canc) {
		setAttrVal("Name_emp_canc", Name_emp_canc);
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
		return "Id_consapproveinvite";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_cons_approve_invite";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiConsApproveInviteDODesc.class);
	}
	
}