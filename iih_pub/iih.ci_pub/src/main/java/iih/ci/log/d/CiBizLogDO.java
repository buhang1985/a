package iih.ci.log.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.log.d.desc.CiBizLogDODesc;
import java.math.BigDecimal;

/**
 * 临床操作日志 DO数据 
 * 
 */
public class CiBizLogDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//临床操作日志主键
	public static final String ID_BIZ_LOG= "Id_biz_log";
	//功能节点编码
	public static final String CODE_FUN= "Code_fun";
	//所属集团ID
	public static final String ID_GRP= "Id_grp";
	//所属集团
	public static final String NAME_GRP= "Name_grp";
	//所属组织ID
	public static final String ID_ORG= "Id_org";
	//所属组织编码
	public static final String CODE_ORG= "Code_org";
	//所属组织
	public static final String NAME_ORG= "Name_org";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//患者编码
	public static final String CODE_PAT= "Code_pat";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//描述信息
	public static final String DES= "Des";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//就诊科室
	public static final String NAME_DEP_EN= "Name_dep_en";
	//就诊编码
	public static final String CODE_EN= "Code_en";
	//就诊病区
	public static final String NAME_DEP_NS= "Name_dep_ns";
	//开立医生
	public static final String NAME_EMP_OR= "Name_emp_or";
	//操作编码
	public static final String CODE_OP= "Code_op";
	//操作名称
	public static final String NAME_OP= "Name_op";
	//操作时间
	public static final String DT_OP= "Dt_op";
	//日志级别
	public static final String LOG_LV= "Log_lv";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 临床操作日志主键
	 * @return String
	 */
	public String getId_biz_log() {
		return ((String) getAttrVal("Id_biz_log"));
	}	
	/**
	 * 临床操作日志主键
	 * @param Id_biz_log
	 */
	public void setId_biz_log(String Id_biz_log) {
		setAttrVal("Id_biz_log", Id_biz_log);
	}
	/**
	 * 功能节点编码
	 * @return String
	 */
	public String getCode_fun() {
		return ((String) getAttrVal("Code_fun"));
	}	
	/**
	 * 功能节点编码
	 * @param Code_fun
	 */
	public void setCode_fun(String Code_fun) {
		setAttrVal("Code_fun", Code_fun);
	}
	/**
	 * 所属集团ID
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团ID
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 所属集团
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 所属组织ID
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织ID
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 所属组织编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	/**
	 * 所属组织编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 所属组织
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
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
	 * 描述信息
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 描述信息
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	 * 就诊科室
	 * @return String
	 */
	public String getName_dep_en() {
		return ((String) getAttrVal("Name_dep_en"));
	}	
	/**
	 * 就诊科室
	 * @param Name_dep_en
	 */
	public void setName_dep_en(String Name_dep_en) {
		setAttrVal("Name_dep_en", Name_dep_en);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_en() {
		return ((String) getAttrVal("Code_en"));
	}	
	/**
	 * 就诊编码
	 * @param Code_en
	 */
	public void setCode_en(String Code_en) {
		setAttrVal("Code_en", Code_en);
	}
	/**
	 * 就诊病区
	 * @return String
	 */
	public String getName_dep_ns() {
		return ((String) getAttrVal("Name_dep_ns"));
	}	
	/**
	 * 就诊病区
	 * @param Name_dep_ns
	 */
	public void setName_dep_ns(String Name_dep_ns) {
		setAttrVal("Name_dep_ns", Name_dep_ns);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}	
	/**
	 * 开立医生
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 操作编码
	 * @return String
	 */
	public String getCode_op() {
		return ((String) getAttrVal("Code_op"));
	}	
	/**
	 * 操作编码
	 * @param Code_op
	 */
	public void setCode_op(String Code_op) {
		setAttrVal("Code_op", Code_op);
	}
	/**
	 * 操作名称
	 * @return String
	 */
	public String getName_op() {
		return ((String) getAttrVal("Name_op"));
	}	
	/**
	 * 操作名称
	 * @param Name_op
	 */
	public void setName_op(String Name_op) {
		setAttrVal("Name_op", Name_op);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_op() {
		return ((FDateTime) getAttrVal("Dt_op"));
	}	
	/**
	 * 操作时间
	 * @param Dt_op
	 */
	public void setDt_op(FDateTime Dt_op) {
		setAttrVal("Dt_op", Dt_op);
	}
	/**
	 * 日志级别
	 * @return String
	 */
	public String getLog_lv() {
		return ((String) getAttrVal("Log_lv"));
	}	
	/**
	 * 日志级别
	 * @param Log_lv
	 */
	public void setLog_lv(String Log_lv) {
		setAttrVal("Log_lv", Log_lv);
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
		return "Id_biz_log";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_biz_log";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiBizLogDODesc.class);
	}
	
}