package iih.bd.srv.mrinfectdisewarn.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrinfectdisewarn.d.desc.MrInfectDiseWarnDODesc;
import java.math.BigDecimal;

/**
 * 传染病预警配置 DO数据 
 * 
 */
public class MrInfectDiseWarnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_MR_INFECT_DESE_WARN= "Id_mr_infect_dese_warn";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//传染病主键
	public static final String ID_MR_INFECT_DISE= "Id_mr_infect_dise";
	//传染病科室
	public static final String ID_DEPT= "Id_dept";
	//传染病人员
	public static final String ID_PSN= "Id_psn";
	//手机号1
	public static final String PHONE1= "Phone1";
	//手机号2
	public static final String PHONE2= "Phone2";
	//序号
	public static final String SORTNO= "Sortno";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String CODE_DEPT= "Code_dept";
	//名称
	public static final String NAME_DEPT= "Name_dept";
	//姓名
	public static final String NAME_PSN= "Name_psn";
	//人员编码
	public static final String CODE_PSN= "Code_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_mr_infect_dese_warn() {
		return ((String) getAttrVal("Id_mr_infect_dese_warn"));
	}	
	/**
	 * 主键
	 * @param Id_mr_infect_dese_warn
	 */
	public void setId_mr_infect_dese_warn(String Id_mr_infect_dese_warn) {
		setAttrVal("Id_mr_infect_dese_warn", Id_mr_infect_dese_warn);
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
	 * 传染病主键
	 * @return String
	 */
	public String getId_mr_infect_dise() {
		return ((String) getAttrVal("Id_mr_infect_dise"));
	}	
	/**
	 * 传染病主键
	 * @param Id_mr_infect_dise
	 */
	public void setId_mr_infect_dise(String Id_mr_infect_dise) {
		setAttrVal("Id_mr_infect_dise", Id_mr_infect_dise);
	}
	/**
	 * 传染病科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 传染病科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 传染病人员
	 * @return String
	 */
	public String getId_psn() {
		return ((String) getAttrVal("Id_psn"));
	}	
	/**
	 * 传染病人员
	 * @param Id_psn
	 */
	public void setId_psn(String Id_psn) {
		setAttrVal("Id_psn", Id_psn);
	}
	/**
	 * 手机号1
	 * @return String
	 */
	public String getPhone1() {
		return ((String) getAttrVal("Phone1"));
	}	
	/**
	 * 手机号1
	 * @param Phone1
	 */
	public void setPhone1(String Phone1) {
		setAttrVal("Phone1", Phone1);
	}
	/**
	 * 手机号2
	 * @return String
	 */
	public String getPhone2() {
		return ((String) getAttrVal("Phone2"));
	}	
	/**
	 * 手机号2
	 * @param Phone2
	 */
	public void setPhone2(String Phone2) {
		setAttrVal("Phone2", Phone2);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	/**
	 * 编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
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
	 * 姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_psn() {
		return ((String) getAttrVal("Code_psn"));
	}	
	/**
	 * 人员编码
	 * @param Code_psn
	 */
	public void setCode_psn(String Code_psn) {
		setAttrVal("Code_psn", Code_psn);
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
		return "Id_mr_infect_dese_warn";
	}
	
	@Override
	public String getTableName() {	  
		return "mr_infect_dise_warn";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrInfectDiseWarnDODesc.class);
	}
	
}