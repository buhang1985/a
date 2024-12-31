package iih.pe.phm.penutrition.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.penutrition.d.desc.PeNutritionDtlDODesc;
import java.math.BigDecimal;

/**
 * 健康营养评估结果 DO数据 
 * 
 */
public class PeNutritionDtlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康营养评估结果主键标识
	public static final String ID_PENUTRITIONDTL= "Id_penutritiondtl";
	//健康营养评估ID
	public static final String ID_PENUTRITION= "Id_penutrition";
	//健康营养评估定义营养分类ID
	public static final String ID_PEEVALNUTRITIONCLS= "Id_peevalnutritioncls";
	//实际摄入量
	public static final String INTAKE= "Intake";
	//摄入量分级
	public static final String LEVEL_INTAKE= "Level_intake";
	//编码
	public static final String CODE_NUCLS= "Code_nucls";
	//名称
	public static final String NAME_NUCLS= "Name_nucls";
	//参考摄入量
	public static final String VALUE_REF= "Value_ref";
	//低值
	public static final String VALUE_LOW= "Value_low";
	//高值
	public static final String VALUE_HIGH= "Value_high";
	//健康危险因素目录ID
	public static final String ID_RISKDEF= "Id_riskdef";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康营养评估结果主键标识
	 * @return String
	 */
	public String getId_penutritiondtl() {
		return ((String) getAttrVal("Id_penutritiondtl"));
	}	
	/**
	 * 健康营养评估结果主键标识
	 * @param Id_penutritiondtl
	 */
	public void setId_penutritiondtl(String Id_penutritiondtl) {
		setAttrVal("Id_penutritiondtl", Id_penutritiondtl);
	}
	/**
	 * 健康营养评估ID
	 * @return String
	 */
	public String getId_penutrition() {
		return ((String) getAttrVal("Id_penutrition"));
	}	
	/**
	 * 健康营养评估ID
	 * @param Id_penutrition
	 */
	public void setId_penutrition(String Id_penutrition) {
		setAttrVal("Id_penutrition", Id_penutrition);
	}
	/**
	 * 健康营养评估定义营养分类ID
	 * @return String
	 */
	public String getId_peevalnutritioncls() {
		return ((String) getAttrVal("Id_peevalnutritioncls"));
	}	
	/**
	 * 健康营养评估定义营养分类ID
	 * @param Id_peevalnutritioncls
	 */
	public void setId_peevalnutritioncls(String Id_peevalnutritioncls) {
		setAttrVal("Id_peevalnutritioncls", Id_peevalnutritioncls);
	}
	/**
	 * 实际摄入量
	 * @return Integer
	 */
	public Integer getIntake() {
		return ((Integer) getAttrVal("Intake"));
	}	
	/**
	 * 实际摄入量
	 * @param Intake
	 */
	public void setIntake(Integer Intake) {
		setAttrVal("Intake", Intake);
	}
	/**
	 * 摄入量分级
	 * @return Integer
	 */
	public Integer getLevel_intake() {
		return ((Integer) getAttrVal("Level_intake"));
	}	
	/**
	 * 摄入量分级
	 * @param Level_intake
	 */
	public void setLevel_intake(Integer Level_intake) {
		setAttrVal("Level_intake", Level_intake);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_nucls() {
		return ((String) getAttrVal("Code_nucls"));
	}	
	/**
	 * 编码
	 * @param Code_nucls
	 */
	public void setCode_nucls(String Code_nucls) {
		setAttrVal("Code_nucls", Code_nucls);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nucls() {
		return ((String) getAttrVal("Name_nucls"));
	}	
	/**
	 * 名称
	 * @param Name_nucls
	 */
	public void setName_nucls(String Name_nucls) {
		setAttrVal("Name_nucls", Name_nucls);
	}
	/**
	 * 参考摄入量
	 * @return String
	 */
	public String getValue_ref() {
		return ((String) getAttrVal("Value_ref"));
	}	
	/**
	 * 参考摄入量
	 * @param Value_ref
	 */
	public void setValue_ref(String Value_ref) {
		setAttrVal("Value_ref", Value_ref);
	}
	/**
	 * 低值
	 * @return FDouble
	 */
	public FDouble getValue_low() {
		return ((FDouble) getAttrVal("Value_low"));
	}	
	/**
	 * 低值
	 * @param Value_low
	 */
	public void setValue_low(FDouble Value_low) {
		setAttrVal("Value_low", Value_low);
	}
	/**
	 * 高值
	 * @return FDouble
	 */
	public FDouble getValue_high() {
		return ((FDouble) getAttrVal("Value_high"));
	}	
	/**
	 * 高值
	 * @param Value_high
	 */
	public void setValue_high(FDouble Value_high) {
		setAttrVal("Value_high", Value_high);
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
		return "Id_penutritiondtl";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_nutritiondtl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeNutritionDtlDODesc.class);
	}
	
}