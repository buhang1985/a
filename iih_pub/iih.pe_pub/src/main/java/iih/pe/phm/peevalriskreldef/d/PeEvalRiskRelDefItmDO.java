package iih.pe.phm.peevalriskreldef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.peevalriskreldef.d.desc.PeEvalRiskRelDefItmDODesc;
import java.math.BigDecimal;

/**
 * 健康评估-危险因素关系项目定义 DO数据 
 * 
 */
public class PeEvalRiskRelDefItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康评估-危险因素关系项目定义主键标识
	public static final String ID_PEEVALRISKRELDEFITM= "Id_peevalriskreldefitm";
	//健康评估-危险因素关系定义ID
	public static final String ID_PEEVALRISKRELDEF= "Id_peevalriskreldef";
	//健康危险因素目录ID
	public static final String ID_RISKDEF= "Id_riskdef";
	//参考值
	public static final String VALUE_REF= "Value_ref";
	//理想值
	public static final String VALUE_IDEA= "Value_idea";
	//编码
	public static final String CODE_RISK= "Code_risk";
	//名称
	public static final String NAME_RIKS= "Name_riks";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康评估-危险因素关系项目定义主键标识
	 * @return String
	 */
	public String getId_peevalriskreldefitm() {
		return ((String) getAttrVal("Id_peevalriskreldefitm"));
	}	
	/**
	 * 健康评估-危险因素关系项目定义主键标识
	 * @param Id_peevalriskreldefitm
	 */
	public void setId_peevalriskreldefitm(String Id_peevalriskreldefitm) {
		setAttrVal("Id_peevalriskreldefitm", Id_peevalriskreldefitm);
	}
	/**
	 * 健康评估-危险因素关系定义ID
	 * @return String
	 */
	public String getId_peevalriskreldef() {
		return ((String) getAttrVal("Id_peevalriskreldef"));
	}	
	/**
	 * 健康评估-危险因素关系定义ID
	 * @param Id_peevalriskreldef
	 */
	public void setId_peevalriskreldef(String Id_peevalriskreldef) {
		setAttrVal("Id_peevalriskreldef", Id_peevalriskreldef);
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
	 * 理想值
	 * @return String
	 */
	public String getValue_idea() {
		return ((String) getAttrVal("Value_idea"));
	}	
	/**
	 * 理想值
	 * @param Value_idea
	 */
	public void setValue_idea(String Value_idea) {
		setAttrVal("Value_idea", Value_idea);
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
	public String getName_riks() {
		return ((String) getAttrVal("Name_riks"));
	}	
	/**
	 * 名称
	 * @param Name_riks
	 */
	public void setName_riks(String Name_riks) {
		setAttrVal("Name_riks", Name_riks);
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
		return "Id_peevalriskreldefitm";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_peevalriskreldefitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeEvalRiskRelDefItmDODesc.class);
	}
	
}