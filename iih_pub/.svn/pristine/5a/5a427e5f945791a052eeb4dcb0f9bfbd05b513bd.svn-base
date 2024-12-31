package iih.pe.pitm.perules.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perules.d.desc.PeRuleDefDODesc;
import java.math.BigDecimal;

/**
 * 体检规则定义 DO数据 
 * 
 */
public class PeRuleDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检异常判断规则主键标识
	public static final String ID_PERULEDEF= "Id_peruledef";
	//体检异常判断规则父ID
	public static final String ID_PERULEDEF_PAR= "Id_peruledef_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//规则编码
	public static final String CODE= "Code";
	//规则名称
	public static final String NAME= "Name";
	//优先级
	public static final String PRIORITY= "Priority";
	//异常标识符号
	public static final String MARK= "Mark";
	//数据合法性检测标识
	public static final String FG_DATAVALID= "Fg_datavalid";
	//次序
	public static final String SORTNO= "Sortno";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//性别限制
	public static final String SEX_LIMIT= "Sex_limit";
	//开始年龄
	public static final String AGE_BEGIN= "Age_begin";
	//截止年龄
	public static final String AGE_END= "Age_end";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//规则编码
	public static final String CODE_RULE= "Code_rule";
	//规则名称
	public static final String NAME_RULE= "Name_rule";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检异常判断规则主键标识
	 * @return String
	 */
	public String getId_peruledef() {
		return ((String) getAttrVal("Id_peruledef"));
	}	
	/**
	 * 体检异常判断规则主键标识
	 * @param Id_peruledef
	 */
	public void setId_peruledef(String Id_peruledef) {
		setAttrVal("Id_peruledef", Id_peruledef);
	}
	/**
	 * 体检异常判断规则父ID
	 * @return String
	 */
	public String getId_peruledef_par() {
		return ((String) getAttrVal("Id_peruledef_par"));
	}	
	/**
	 * 体检异常判断规则父ID
	 * @param Id_peruledef_par
	 */
	public void setId_peruledef_par(String Id_peruledef_par) {
		setAttrVal("Id_peruledef_par", Id_peruledef_par);
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
	 * 规则编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 规则编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 规则名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 规则名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 优先级
	 * @return Integer
	 */
	public Integer getPriority() {
		return ((Integer) getAttrVal("Priority"));
	}	
	/**
	 * 优先级
	 * @param Priority
	 */
	public void setPriority(Integer Priority) {
		setAttrVal("Priority", Priority);
	}
	/**
	 * 异常标识符号
	 * @return String
	 */
	public String getMark() {
		return ((String) getAttrVal("Mark"));
	}	
	/**
	 * 异常标识符号
	 * @param Mark
	 */
	public void setMark(String Mark) {
		setAttrVal("Mark", Mark);
	}
	/**
	 * 数据合法性检测标识
	 * @return FBoolean
	 */
	public FBoolean getFg_datavalid() {
		return ((FBoolean) getAttrVal("Fg_datavalid"));
	}	
	/**
	 * 数据合法性检测标识
	 * @param Fg_datavalid
	 */
	public void setFg_datavalid(FBoolean Fg_datavalid) {
		setAttrVal("Fg_datavalid", Fg_datavalid);
	}
	/**
	 * 次序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 次序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
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
	 * 性别限制
	 * @return Integer
	 */
	public Integer getSex_limit() {
		return ((Integer) getAttrVal("Sex_limit"));
	}	
	/**
	 * 性别限制
	 * @param Sex_limit
	 */
	public void setSex_limit(Integer Sex_limit) {
		setAttrVal("Sex_limit", Sex_limit);
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
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 规则编码
	 * @return String
	 */
	public String getCode_rule() {
		return ((String) getAttrVal("Code_rule"));
	}	
	/**
	 * 规则编码
	 * @param Code_rule
	 */
	public void setCode_rule(String Code_rule) {
		setAttrVal("Code_rule", Code_rule);
	}
	/**
	 * 规则名称
	 * @return String
	 */
	public String getName_rule() {
		return ((String) getAttrVal("Name_rule"));
	}	
	/**
	 * 规则名称
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
		return "Id_peruledef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_perules";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRuleDefDODesc.class);
	}
	
}