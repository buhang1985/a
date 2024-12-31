package iih.bd.pp.bdprewarn.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.bdprewarn.d.desc.BdPreWarnDODesc;
import java.math.BigDecimal;

/**
 * 预交金警告策略 DO数据 
 * 
 */
public class BdPreWarnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//预交金警告策略主键
	public static final String ID_PREWARN= "Id_prewarn";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//科室ID
	public static final String ID_DEP= "Id_dep";
	//警告值
	public static final String LIMIT= "Limit";
	//所属类型
	public static final String EU_PREWARNTP= "Eu_prewarntp";
	//患者身份
	public static final String ID_PATCA= "Id_patca";
	//部分控制值
	public static final String P_CONTROL= "P_control";
	//完全控制值
	public static final String F_CONTROL= "F_control";
	//控制模式
	public static final String EU_CONTROL= "Eu_control";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//受控白名单标志
	public static final String FG_WHITE= "Fg_white";
	//病区
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//医保计划身份
	public static final String ID_HPPATCA= "Id_hppatca";
	//欠费控制
	public static final String FG_PREWARN= "Fg_prewarn";
	//编码
	public static final String DEPTCODE= "Deptcode";
	//名称
	public static final String DEPTNAME= "Deptname";
	//患者分类编码
	public static final String PATCA_CODE= "Patca_code";
	//患者分类名称
	public static final String PATCA_NAME= "Patca_name";
	//就诊类型名称
	public static final String ENTP_NAME= "Entp_name";
	//病区名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//病区编码
	public static final String CODE_DEP_NUR= "Code_dep_nur";
	//医保身份编码
	public static final String CODE_HPPATCA= "Code_hppatca";
	//医保身份名称
	public static final String NAME_HPPATCA= "Name_hppatca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 预交金警告策略主键
	 * @return String
	 */
	public String getId_prewarn() {
		return ((String) getAttrVal("Id_prewarn"));
	}	
	/**
	 * 预交金警告策略主键
	 * @param Id_prewarn
	 */
	public void setId_prewarn(String Id_prewarn) {
		setAttrVal("Id_prewarn", Id_prewarn);
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
	 * 科室ID
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 科室ID
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 警告值
	 * @return FDouble
	 */
	public FDouble getLimit() {
		return ((FDouble) getAttrVal("Limit"));
	}	
	/**
	 * 警告值
	 * @param Limit
	 */
	public void setLimit(FDouble Limit) {
		setAttrVal("Limit", Limit);
	}
	/**
	 * 所属类型
	 * @return String
	 */
	public String getEu_prewarntp() {
		return ((String) getAttrVal("Eu_prewarntp"));
	}	
	/**
	 * 所属类型
	 * @param Eu_prewarntp
	 */
	public void setEu_prewarntp(String Eu_prewarntp) {
		setAttrVal("Eu_prewarntp", Eu_prewarntp);
	}
	/**
	 * 患者身份
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}	
	/**
	 * 患者身份
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 部分控制值
	 * @return FDouble
	 */
	public FDouble getP_control() {
		return ((FDouble) getAttrVal("P_control"));
	}	
	/**
	 * 部分控制值
	 * @param P_control
	 */
	public void setP_control(FDouble P_control) {
		setAttrVal("P_control", P_control);
	}
	/**
	 * 完全控制值
	 * @return FDouble
	 */
	public FDouble getF_control() {
		return ((FDouble) getAttrVal("F_control"));
	}	
	/**
	 * 完全控制值
	 * @param F_control
	 */
	public void setF_control(FDouble F_control) {
		setAttrVal("F_control", F_control);
	}
	/**
	 * 控制模式
	 * @return String
	 */
	public String getEu_control() {
		return ((String) getAttrVal("Eu_control"));
	}	
	/**
	 * 控制模式
	 * @param Eu_control
	 */
	public void setEu_control(String Eu_control) {
		setAttrVal("Eu_control", Eu_control);
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
	 * 受控白名单标志
	 * @return FBoolean
	 */
	public FBoolean getFg_white() {
		return ((FBoolean) getAttrVal("Fg_white"));
	}	
	/**
	 * 受控白名单标志
	 * @param Fg_white
	 */
	public void setFg_white(FBoolean Fg_white) {
		setAttrVal("Fg_white", Fg_white);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 医保计划身份
	 * @return String
	 */
	public String getId_hppatca() {
		return ((String) getAttrVal("Id_hppatca"));
	}	
	/**
	 * 医保计划身份
	 * @param Id_hppatca
	 */
	public void setId_hppatca(String Id_hppatca) {
		setAttrVal("Id_hppatca", Id_hppatca);
	}
	/**
	 * 欠费控制
	 * @return FBoolean
	 */
	public FBoolean getFg_prewarn() {
		return ((FBoolean) getAttrVal("Fg_prewarn"));
	}	
	/**
	 * 欠费控制
	 * @param Fg_prewarn
	 */
	public void setFg_prewarn(FBoolean Fg_prewarn) {
		setAttrVal("Fg_prewarn", Fg_prewarn);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDeptcode() {
		return ((String) getAttrVal("Deptcode"));
	}	
	/**
	 * 编码
	 * @param Deptcode
	 */
	public void setDeptcode(String Deptcode) {
		setAttrVal("Deptcode", Deptcode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDeptname() {
		return ((String) getAttrVal("Deptname"));
	}	
	/**
	 * 名称
	 * @param Deptname
	 */
	public void setDeptname(String Deptname) {
		setAttrVal("Deptname", Deptname);
	}
	/**
	 * 患者分类编码
	 * @return String
	 */
	public String getPatca_code() {
		return ((String) getAttrVal("Patca_code"));
	}	
	/**
	 * 患者分类编码
	 * @param Patca_code
	 */
	public void setPatca_code(String Patca_code) {
		setAttrVal("Patca_code", Patca_code);
	}
	/**
	 * 患者分类名称
	 * @return String
	 */
	public String getPatca_name() {
		return ((String) getAttrVal("Patca_name"));
	}	
	/**
	 * 患者分类名称
	 * @param Patca_name
	 */
	public void setPatca_name(String Patca_name) {
		setAttrVal("Patca_name", Patca_name);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}	
	/**
	 * 就诊类型名称
	 * @param Entp_name
	 */
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
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
	 * 病区编码
	 * @return String
	 */
	public String getCode_dep_nur() {
		return ((String) getAttrVal("Code_dep_nur"));
	}	
	/**
	 * 病区编码
	 * @param Code_dep_nur
	 */
	public void setCode_dep_nur(String Code_dep_nur) {
		setAttrVal("Code_dep_nur", Code_dep_nur);
	}
	/**
	 * 医保身份编码
	 * @return String
	 */
	public String getCode_hppatca() {
		return ((String) getAttrVal("Code_hppatca"));
	}	
	/**
	 * 医保身份编码
	 * @param Code_hppatca
	 */
	public void setCode_hppatca(String Code_hppatca) {
		setAttrVal("Code_hppatca", Code_hppatca);
	}
	/**
	 * 医保身份名称
	 * @return String
	 */
	public String getName_hppatca() {
		return ((String) getAttrVal("Name_hppatca"));
	}	
	/**
	 * 医保身份名称
	 * @param Name_hppatca
	 */
	public void setName_hppatca(String Name_hppatca) {
		setAttrVal("Name_hppatca", Name_hppatca);
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
		return "Id_prewarn";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_prewarn";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdPreWarnDODesc.class);
	}
	
}