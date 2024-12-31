package iih.pe.pqn.pestrokemodel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.pestrokemodel.d.desc.PeStrokeModelFieldDODesc;
import java.math.BigDecimal;

/**
 * 健康评估模型_脑卒中_字段 DO数据 
 * 
 */
public class PeStrokeModelFieldDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//脑卒中评估模型字段评估主键标识
	public static final String ID_PESTROKEMODELFIELD= "Id_pestrokemodelfield";
	//脑卒中评估模型ID
	public static final String ID_PESTROKEMODEL= "Id_pestrokemodel";
	//字段名
	public static final String FIELDNAME= "Fieldname";
	//危险因素ID
	public static final String ID_RISKDEF= "Id_riskdef";
	//编码
	public static final String CODE_RISK= "Code_risk";
	//名称
	public static final String NAME_RISK= "Name_risk";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 脑卒中评估模型字段评估主键标识
	 * @return String
	 */
	public String getId_pestrokemodelfield() {
		return ((String) getAttrVal("Id_pestrokemodelfield"));
	}	
	/**
	 * 脑卒中评估模型字段评估主键标识
	 * @param Id_pestrokemodelfield
	 */
	public void setId_pestrokemodelfield(String Id_pestrokemodelfield) {
		setAttrVal("Id_pestrokemodelfield", Id_pestrokemodelfield);
	}
	/**
	 * 脑卒中评估模型ID
	 * @return String
	 */
	public String getId_pestrokemodel() {
		return ((String) getAttrVal("Id_pestrokemodel"));
	}	
	/**
	 * 脑卒中评估模型ID
	 * @param Id_pestrokemodel
	 */
	public void setId_pestrokemodel(String Id_pestrokemodel) {
		setAttrVal("Id_pestrokemodel", Id_pestrokemodel);
	}
	/**
	 * 字段名
	 * @return String
	 */
	public String getFieldname() {
		return ((String) getAttrVal("Fieldname"));
	}	
	/**
	 * 字段名
	 * @param Fieldname
	 */
	public void setFieldname(String Fieldname) {
		setAttrVal("Fieldname", Fieldname);
	}
	/**
	 * 危险因素ID
	 * @return String
	 */
	public String getId_riskdef() {
		return ((String) getAttrVal("Id_riskdef"));
	}	
	/**
	 * 危险因素ID
	 * @param Id_riskdef
	 */
	public void setId_riskdef(String Id_riskdef) {
		setAttrVal("Id_riskdef", Id_riskdef);
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
		return "Id_pestrokemodelfield";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pestrokemodelfield";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeStrokeModelFieldDODesc.class);
	}
	
}