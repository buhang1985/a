package iih.pe.phm.pehmriskrule.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pehmriskrule.d.desc.PeHmRiskRuleItemDODesc;
import java.math.BigDecimal;

/**
 * 健康危险因素规则定义项目 DO数据 
 * 
 */
public class PeHmRiskRuleItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康危险因素规则项目主键标识
	public static final String ID_RISKRULEITEM= "Id_riskruleitem";
	//健康危险因素规则ID
	public static final String ID_RISKRULE= "Id_riskrule";
	//健康危险因素目录ID
	public static final String ID_RISKDEF= "Id_riskdef";
	//索引
	public static final String IDX= "Idx";
	//逻辑操作符
	public static final String LOGIC_OPERATOR= "Logic_operator";
	//左括号
	public static final String LEFT_BRACKET= "Left_bracket";
	//操作数
	public static final String OPERAND= "Operand";
	//操作符
	public static final String OPERATOR= "Operator";
	//值
	public static final String VAL= "Val";
	//右括号
	public static final String RIGHT_BRACKET= "Right_bracket";
	//结果比较方式
	public static final String ITEMCMPTP= "Itemcmptp";
	//编码
	public static final String CODE_RISK= "Code_risk";
	//名称
	public static final String NAME_RISK= "Name_risk";
	//数据来源
	public static final String DATATP= "Datatp";
	//参考值
	public static final String VALUE_REF_RISK= "Value_ref_risk";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康危险因素规则项目主键标识
	 * @return String
	 */
	public String getId_riskruleitem() {
		return ((String) getAttrVal("Id_riskruleitem"));
	}	
	/**
	 * 健康危险因素规则项目主键标识
	 * @param Id_riskruleitem
	 */
	public void setId_riskruleitem(String Id_riskruleitem) {
		setAttrVal("Id_riskruleitem", Id_riskruleitem);
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
	 * 索引
	 * @return Integer
	 */
	public Integer getIdx() {
		return ((Integer) getAttrVal("Idx"));
	}	
	/**
	 * 索引
	 * @param Idx
	 */
	public void setIdx(Integer Idx) {
		setAttrVal("Idx", Idx);
	}
	/**
	 * 逻辑操作符
	 * @return Integer
	 */
	public Integer getLogic_operator() {
		return ((Integer) getAttrVal("Logic_operator"));
	}	
	/**
	 * 逻辑操作符
	 * @param Logic_operator
	 */
	public void setLogic_operator(Integer Logic_operator) {
		setAttrVal("Logic_operator", Logic_operator);
	}
	/**
	 * 左括号
	 * @return String
	 */
	public String getLeft_bracket() {
		return ((String) getAttrVal("Left_bracket"));
	}	
	/**
	 * 左括号
	 * @param Left_bracket
	 */
	public void setLeft_bracket(String Left_bracket) {
		setAttrVal("Left_bracket", Left_bracket);
	}
	/**
	 * 操作数
	 * @return String
	 */
	public String getOperand() {
		return ((String) getAttrVal("Operand"));
	}	
	/**
	 * 操作数
	 * @param Operand
	 */
	public void setOperand(String Operand) {
		setAttrVal("Operand", Operand);
	}
	/**
	 * 操作符
	 * @return Integer
	 */
	public Integer getOperator() {
		return ((Integer) getAttrVal("Operator"));
	}	
	/**
	 * 操作符
	 * @param Operator
	 */
	public void setOperator(Integer Operator) {
		setAttrVal("Operator", Operator);
	}
	/**
	 * 值
	 * @return String
	 */
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	/**
	 * 值
	 * @param Val
	 */
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	/**
	 * 右括号
	 * @return String
	 */
	public String getRight_bracket() {
		return ((String) getAttrVal("Right_bracket"));
	}	
	/**
	 * 右括号
	 * @param Right_bracket
	 */
	public void setRight_bracket(String Right_bracket) {
		setAttrVal("Right_bracket", Right_bracket);
	}
	/**
	 * 结果比较方式
	 * @return Integer
	 */
	public Integer getItemcmptp() {
		return ((Integer) getAttrVal("Itemcmptp"));
	}	
	/**
	 * 结果比较方式
	 * @param Itemcmptp
	 */
	public void setItemcmptp(Integer Itemcmptp) {
		setAttrVal("Itemcmptp", Itemcmptp);
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
	 * 数据来源
	 * @return Integer
	 */
	public Integer getDatatp() {
		return ((Integer) getAttrVal("Datatp"));
	}	
	/**
	 * 数据来源
	 * @param Datatp
	 */
	public void setDatatp(Integer Datatp) {
		setAttrVal("Datatp", Datatp);
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
		return "Id_riskruleitem";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_riskruleitem";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeHmRiskRuleItemDODesc.class);
	}
	
}