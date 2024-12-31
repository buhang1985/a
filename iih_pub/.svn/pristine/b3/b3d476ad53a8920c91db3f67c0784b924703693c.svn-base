package iih.pe.pqn.peevallifestyle.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peevallifestyle.d.desc.PeEvalLifestyleItmDODesc;
import java.math.BigDecimal;

/**
 * 健康生活方式评估定义内容 DO数据 
 * 
 */
public class PeEvalLifestyleItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康生活方式评估项目定义主键标识
	public static final String ID_PEEVALLIFESTYLEITM= "Id_peevallifestyleitm";
	//健康生活方式评估定义ID
	public static final String ID_PEEVALLIFESTYLE= "Id_peevallifestyle";
	//项目编码
	public static final String CODE= "Code";
	//项目名称
	public static final String NAME= "Name";
	//健康危险因素目录ID
	public static final String ID_RISKDEF= "Id_riskdef";
	//序号
	public static final String SORTNO= "Sortno";
	//参考值
	public static final String VALUE_REF= "Value_ref";
	//编码
	public static final String CODE_RISK= "Code_risk";
	//名称
	public static final String NAME_RISK= "Name_risk";
	//参考值
	public static final String VALUE_REF_RISK= "Value_ref_risk";
	//理想值
	public static final String VALUE_IDEA_RIKS= "Value_idea_riks";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康生活方式评估项目定义主键标识
	 * @return String
	 */
	public String getId_peevallifestyleitm() {
		return ((String) getAttrVal("Id_peevallifestyleitm"));
	}	
	/**
	 * 健康生活方式评估项目定义主键标识
	 * @param Id_peevallifestyleitm
	 */
	public void setId_peevallifestyleitm(String Id_peevallifestyleitm) {
		setAttrVal("Id_peevallifestyleitm", Id_peevallifestyleitm);
	}
	/**
	 * 健康生活方式评估定义ID
	 * @return String
	 */
	public String getId_peevallifestyle() {
		return ((String) getAttrVal("Id_peevallifestyle"));
	}	
	/**
	 * 健康生活方式评估定义ID
	 * @param Id_peevallifestyle
	 */
	public void setId_peevallifestyle(String Id_peevallifestyle) {
		setAttrVal("Id_peevallifestyle", Id_peevallifestyle);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 项目编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 项目名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 健康危险因素目录ID
	 * @return String
	 */
	public String getId_riskdef() {
		return ((String) getAttrVal("Id_riskdef"));
	}	
	/**
	 * 健康危险因素目录ID
	 * @param Id_riskdef
	 */
	public void setId_riskdef(String Id_riskdef) {
		setAttrVal("Id_riskdef", Id_riskdef);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 参考值
	 * @return String
	 */
	public String getValue_ref() {
		return ((String) getAttrVal("Value_ref"));
	}	
	/**
	 * 参考值
	 * @param Value_ref
	 */
	public void setValue_ref(String Value_ref) {
		setAttrVal("Value_ref", Value_ref);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_risk() {
		return ((String) getAttrVal("Code_risk"));
	}	
	/**
	 * 编码
	 * @param Code_risk
	 */
	public void setCode_risk(String Code_risk) {
		setAttrVal("Code_risk", Code_risk);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_risk() {
		return ((String) getAttrVal("Name_risk"));
	}	
	/**
	 * 名称
	 * @param Name_risk
	 */
	public void setName_risk(String Name_risk) {
		setAttrVal("Name_risk", Name_risk);
	}
	/**
	 * 参考值
	 * @return String
	 */
	public String getValue_ref_risk() {
		return ((String) getAttrVal("Value_ref_risk"));
	}	
	/**
	 * 参考值
	 * @param Value_ref_risk
	 */
	public void setValue_ref_risk(String Value_ref_risk) {
		setAttrVal("Value_ref_risk", Value_ref_risk);
	}
	/**
	 * 理想值
	 * @return String
	 */
	public String getValue_idea_riks() {
		return ((String) getAttrVal("Value_idea_riks"));
	}	
	/**
	 * 理想值
	 * @param Value_idea_riks
	 */
	public void setValue_idea_riks(String Value_idea_riks) {
		setAttrVal("Value_idea_riks", Value_idea_riks);
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
		return "Id_peevallifestyleitm";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peevallifestyleitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeEvalLifestyleItmDODesc.class);
	}
	
}