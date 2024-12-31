package iih.pe.phm.pehmgroup.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pehmgroup.d.desc.PeHmGroupDODesc;
import java.math.BigDecimal;

/**
 * 体检健康管理群体定义 DO数据 
 * 
 */
public class PeHmGroupDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检健康群体定义主键标识
	public static final String ID_PEHMGROUP= "Id_pehmgroup";
	//体检健康群体定义父ID
	public static final String ID_PEHMGROUP_PAR= "Id_pehmgroup_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//开始日期
	public static final String DT_BEGIN= "Dt_begin";
	//截止日期
	public static final String DT_END= "Dt_end";
	//开始年龄
	public static final String AGE_BEGIN= "Age_begin";
	//截止年龄
	public static final String AGE_END= "Age_end";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//健康危险因素规则ID
	public static final String ID_RISKRULE= "Id_riskrule";
	//规则检索标识
	public static final String FG_RISKRULE= "Fg_riskrule";
	//编码
	public static final String CODE_RULE= "Code_rule";
	//名称
	public static final String NAME_RULE= "Name_rule";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检健康群体定义主键标识
	 * @return String
	 */
	public String getId_pehmgroup() {
		return ((String) getAttrVal("Id_pehmgroup"));
	}	
	/**
	 * 体检健康群体定义主键标识
	 * @param Id_pehmgroup
	 */
	public void setId_pehmgroup(String Id_pehmgroup) {
		setAttrVal("Id_pehmgroup", Id_pehmgroup);
	}
	/**
	 * 体检健康群体定义父ID
	 * @return String
	 */
	public String getId_pehmgroup_par() {
		return ((String) getAttrVal("Id_pehmgroup_par"));
	}	
	/**
	 * 体检健康群体定义父ID
	 * @param Id_pehmgroup_par
	 */
	public void setId_pehmgroup_par(String Id_pehmgroup_par) {
		setAttrVal("Id_pehmgroup_par", Id_pehmgroup_par);
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
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 开始日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 截止日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	/**
	 * 截止日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 开始年龄
	 * @return Integer
	 */
	public Integer getAge_begin() {
		return ((Integer) getAttrVal("Age_begin"));
	}	
	/**
	 * 开始年龄
	 * @param Age_begin
	 */
	public void setAge_begin(Integer Age_begin) {
		setAttrVal("Age_begin", Age_begin);
	}
	/**
	 * 截止年龄
	 * @return Integer
	 */
	public Integer getAge_end() {
		return ((Integer) getAttrVal("Age_end"));
	}	
	/**
	 * 截止年龄
	 * @param Age_end
	 */
	public void setAge_end(Integer Age_end) {
		setAttrVal("Age_end", Age_end);
	}
	/**
	 * 性别限制
	 * @return Integer
	 */
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	/**
	 * 性别限制
	 * @param Sexlimit
	 */
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	/**
	 * 健康危险因素规则ID
	 * @return String
	 */
	public String getId_riskrule() {
		return ((String) getAttrVal("Id_riskrule"));
	}	
	/**
	 * 健康危险因素规则ID
	 * @param Id_riskrule
	 */
	public void setId_riskrule(String Id_riskrule) {
		setAttrVal("Id_riskrule", Id_riskrule);
	}
	/**
	 * 规则检索标识
	 * @return FBoolean
	 */
	public FBoolean getFg_riskrule() {
		return ((FBoolean) getAttrVal("Fg_riskrule"));
	}	
	/**
	 * 规则检索标识
	 * @param Fg_riskrule
	 */
	public void setFg_riskrule(FBoolean Fg_riskrule) {
		setAttrVal("Fg_riskrule", Fg_riskrule);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_rule() {
		return ((String) getAttrVal("Code_rule"));
	}	
	/**
	 * 编码
	 * @param Code_rule
	 */
	public void setCode_rule(String Code_rule) {
		setAttrVal("Code_rule", Code_rule);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_rule() {
		return ((String) getAttrVal("Name_rule"));
	}	
	/**
	 * 名称
	 * @param Name_rule
	 */
	public void setName_rule(String Name_rule) {
		setAttrVal("Name_rule", Name_rule);
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
		return "Id_pehmgroup";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pehmgroup";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeHmGroupDODesc.class);
	}
	
}