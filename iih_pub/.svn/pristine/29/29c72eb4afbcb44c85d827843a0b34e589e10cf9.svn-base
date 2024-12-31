package iih.pe.pqn.peicdvmodel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peicdvmodel.d.desc.PeIcdvModelFieldDODesc;
import java.math.BigDecimal;

/**
 * 健康评估模型_缺血性冠心病_字段 DO数据 
 * 
 */
public class PeIcdvModelFieldDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//缺血性冠心病评估模型字段名主键标识
	public static final String ID_PEICDVMODELFIELD= "Id_peicdvmodelfield";
	//缺血性冠心病ID
	public static final String ID_PEICDVMODEL= "Id_peicdvmodel";
	//结果字段名
	public static final String FIELDNAME= "Fieldname";
	//健康危险因素ID
	public static final String ID_RISKDEF= "Id_riskdef";
	//编码
	public static final String CODE_RISK= "Code_risk";
	//名称
	public static final String NAME_RISK= "Name_risk";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 缺血性冠心病评估模型字段名主键标识
	 * @return String
	 */
	public String getId_peicdvmodelfield() {
		return ((String) getAttrVal("Id_peicdvmodelfield"));
	}	
	/**
	 * 缺血性冠心病评估模型字段名主键标识
	 * @param Id_peicdvmodelfield
	 */
	public void setId_peicdvmodelfield(String Id_peicdvmodelfield) {
		setAttrVal("Id_peicdvmodelfield", Id_peicdvmodelfield);
	}
	/**
	 * 缺血性冠心病ID
	 * @return String
	 */
	public String getId_peicdvmodel() {
		return ((String) getAttrVal("Id_peicdvmodel"));
	}	
	/**
	 * 缺血性冠心病ID
	 * @param Id_peicdvmodel
	 */
	public void setId_peicdvmodel(String Id_peicdvmodel) {
		setAttrVal("Id_peicdvmodel", Id_peicdvmodel);
	}
	/**
	 * 结果字段名
	 * @return String
	 */
	public String getFieldname() {
		return ((String) getAttrVal("Fieldname"));
	}	
	/**
	 * 结果字段名
	 * @param Fieldname
	 */
	public void setFieldname(String Fieldname) {
		setAttrVal("Fieldname", Fieldname);
	}
	/**
	 * 健康危险因素ID
	 * @return String
	 */
	public String getId_riskdef() {
		return ((String) getAttrVal("Id_riskdef"));
	}	
	/**
	 * 健康危险因素ID
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
		return "Id_peicdvmodelfield";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peicdvmodelfield";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeIcdvModelFieldDODesc.class);
	}
	
}