package iih.pe.pqn.peevalchrodef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peevalchrodef.d.desc.PeEvalChroDefDODesc;
import java.math.BigDecimal;

/**
 * 体检慢性病评估定义 DO数据 
 * 
 */
public class PeEvalChroDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检慢性病定义主键标识
	public static final String ID_PEEVALCHRODEF= "Id_peevalchrodef";
	//体检慢性病定义父ID
	public static final String ID_PEEVALCHRODEF_PAR= "Id_peevalchrodef_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//定义
	public static final String DEF= "Def";
	//危险因素
	public static final String RISKFACTOR= "Riskfactor";
	//诊断标准
	public static final String DIAG= "Diag";
	//治疗
	public static final String TREAT= "Treat";
	//生活方式调理
	public static final String LIFESTYLE= "Lifestyle";
	//中医康复调理
	public static final String TREATTCM= "Treattcm";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//开始年龄
	public static final String AGE_BEGIN= "Age_begin";
	//截止年龄
	public static final String AGE_END= "Age_end";
	//运动处方ID
	public static final String ID_EXERCISE= "Id_exercise";
	//饮食处方ID
	public static final String ID_DIET= "Id_diet";
	//处方编码
	public static final String CODE_EXERCISE= "Code_exercise";
	//处方名称
	public static final String NAME_EXERCISE= "Name_exercise";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检慢性病定义主键标识
	 * @return String
	 */
	public String getId_peevalchrodef() {
		return ((String) getAttrVal("Id_peevalchrodef"));
	}	
	/**
	 * 体检慢性病定义主键标识
	 * @param Id_peevalchrodef
	 */
	public void setId_peevalchrodef(String Id_peevalchrodef) {
		setAttrVal("Id_peevalchrodef", Id_peevalchrodef);
	}
	/**
	 * 体检慢性病定义父ID
	 * @return String
	 */
	public String getId_peevalchrodef_par() {
		return ((String) getAttrVal("Id_peevalchrodef_par"));
	}	
	/**
	 * 体检慢性病定义父ID
	 * @param Id_peevalchrodef_par
	 */
	public void setId_peevalchrodef_par(String Id_peevalchrodef_par) {
		setAttrVal("Id_peevalchrodef_par", Id_peevalchrodef_par);
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
	 * 定义
	 * @return String
	 */
	public String getDef() {
		return ((String) getAttrVal("Def"));
	}	
	/**
	 * 定义
	 * @param Def
	 */
	public void setDef(String Def) {
		setAttrVal("Def", Def);
	}
	/**
	 * 危险因素
	 * @return String
	 */
	public String getRiskfactor() {
		return ((String) getAttrVal("Riskfactor"));
	}	
	/**
	 * 危险因素
	 * @param Riskfactor
	 */
	public void setRiskfactor(String Riskfactor) {
		setAttrVal("Riskfactor", Riskfactor);
	}
	/**
	 * 诊断标准
	 * @return String
	 */
	public String getDiag() {
		return ((String) getAttrVal("Diag"));
	}	
	/**
	 * 诊断标准
	 * @param Diag
	 */
	public void setDiag(String Diag) {
		setAttrVal("Diag", Diag);
	}
	/**
	 * 治疗
	 * @return String
	 */
	public String getTreat() {
		return ((String) getAttrVal("Treat"));
	}	
	/**
	 * 治疗
	 * @param Treat
	 */
	public void setTreat(String Treat) {
		setAttrVal("Treat", Treat);
	}
	/**
	 * 生活方式调理
	 * @return String
	 */
	public String getLifestyle() {
		return ((String) getAttrVal("Lifestyle"));
	}	
	/**
	 * 生活方式调理
	 * @param Lifestyle
	 */
	public void setLifestyle(String Lifestyle) {
		setAttrVal("Lifestyle", Lifestyle);
	}
	/**
	 * 中医康复调理
	 * @return String
	 */
	public String getTreattcm() {
		return ((String) getAttrVal("Treattcm"));
	}	
	/**
	 * 中医康复调理
	 * @param Treattcm
	 */
	public void setTreattcm(String Treattcm) {
		setAttrVal("Treattcm", Treattcm);
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
	 * 运动处方ID
	 * @return String
	 */
	public String getId_exercise() {
		return ((String) getAttrVal("Id_exercise"));
	}	
	/**
	 * 运动处方ID
	 * @param Id_exercise
	 */
	public void setId_exercise(String Id_exercise) {
		setAttrVal("Id_exercise", Id_exercise);
	}
	/**
	 * 饮食处方ID
	 * @return String
	 */
	public String getId_diet() {
		return ((String) getAttrVal("Id_diet"));
	}	
	/**
	 * 饮食处方ID
	 * @param Id_diet
	 */
	public void setId_diet(String Id_diet) {
		setAttrVal("Id_diet", Id_diet);
	}
	/**
	 * 处方编码
	 * @return String
	 */
	public String getCode_exercise() {
		return ((String) getAttrVal("Code_exercise"));
	}	
	/**
	 * 处方编码
	 * @param Code_exercise
	 */
	public void setCode_exercise(String Code_exercise) {
		setAttrVal("Code_exercise", Code_exercise);
	}
	/**
	 * 处方名称
	 * @return String
	 */
	public String getName_exercise() {
		return ((String) getAttrVal("Name_exercise"));
	}	
	/**
	 * 处方名称
	 * @param Name_exercise
	 */
	public void setName_exercise(String Name_exercise) {
		setAttrVal("Name_exercise", Name_exercise);
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
		return "Id_peevalchrodef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peevalchrodef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeEvalChroDefDODesc.class);
	}
	
}