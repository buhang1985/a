package iih.nm.nqm.nmnqmcstmpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmcstmpl.d.desc.NmnqmtmplitmDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_模板指标 DO数据 
 * 
 */
public class NmnqmtmplitmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//检查标准模板id
	public static final String ID_NQM_TMPL_ITM= "Id_nqm_tmpl_itm";
	//检查标准
	public static final String ID_NQM_CS= "Id_nqm_cs";
	//检查指标
	public static final String ID_NQM_KPI= "Id_nqm_kpi";
	//父级指标
	public static final String ID_NQM_KPI_PAR= "Id_nqm_kpi_par";
	//检查标准模板
	public static final String ID_NQM_TMPL= "Id_nqm_tmpl";
	//指标名称
	public static final String NAME_NQM_KPI= "Name_nqm_kpi";
	//指标分值
	public static final String VALUE_NQM_VALUE= "Value_nqm_value";
	//指标权重
	public static final String WI_NQM_VALUE= "Wi_nqm_value";
	//是否为必要指标
	public static final String FG_MUSTKPI= "Fg_mustkpi";
	//指标编码
	public static final String CODE_NQM_KPI= "Code_nqm_kpi";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 检查标准模板id
	 * @return String
	 */
	public String getId_nqm_tmpl_itm() {
		return ((String) getAttrVal("Id_nqm_tmpl_itm"));
	}	
	/**
	 * 检查标准模板id
	 * @param Id_nqm_tmpl_itm
	 */
	public void setId_nqm_tmpl_itm(String Id_nqm_tmpl_itm) {
		setAttrVal("Id_nqm_tmpl_itm", Id_nqm_tmpl_itm);
	}
	/**
	 * 检查标准
	 * @return String
	 */
	public String getId_nqm_cs() {
		return ((String) getAttrVal("Id_nqm_cs"));
	}	
	/**
	 * 检查标准
	 * @param Id_nqm_cs
	 */
	public void setId_nqm_cs(String Id_nqm_cs) {
		setAttrVal("Id_nqm_cs", Id_nqm_cs);
	}
	/**
	 * 检查指标
	 * @return String
	 */
	public String getId_nqm_kpi() {
		return ((String) getAttrVal("Id_nqm_kpi"));
	}	
	/**
	 * 检查指标
	 * @param Id_nqm_kpi
	 */
	public void setId_nqm_kpi(String Id_nqm_kpi) {
		setAttrVal("Id_nqm_kpi", Id_nqm_kpi);
	}
	/**
	 * 父级指标
	 * @return String
	 */
	public String getId_nqm_kpi_par() {
		return ((String) getAttrVal("Id_nqm_kpi_par"));
	}	
	/**
	 * 父级指标
	 * @param Id_nqm_kpi_par
	 */
	public void setId_nqm_kpi_par(String Id_nqm_kpi_par) {
		setAttrVal("Id_nqm_kpi_par", Id_nqm_kpi_par);
	}
	/**
	 * 检查标准模板
	 * @return String
	 */
	public String getId_nqm_tmpl() {
		return ((String) getAttrVal("Id_nqm_tmpl"));
	}	
	/**
	 * 检查标准模板
	 * @param Id_nqm_tmpl
	 */
	public void setId_nqm_tmpl(String Id_nqm_tmpl) {
		setAttrVal("Id_nqm_tmpl", Id_nqm_tmpl);
	}
	/**
	 * 指标名称
	 * @return String
	 */
	public String getName_nqm_kpi() {
		return ((String) getAttrVal("Name_nqm_kpi"));
	}	
	/**
	 * 指标名称
	 * @param Name_nqm_kpi
	 */
	public void setName_nqm_kpi(String Name_nqm_kpi) {
		setAttrVal("Name_nqm_kpi", Name_nqm_kpi);
	}
	/**
	 * 指标分值
	 * @return FDouble
	 */
	public FDouble getValue_nqm_value() {
		return ((FDouble) getAttrVal("Value_nqm_value"));
	}	
	/**
	 * 指标分值
	 * @param Value_nqm_value
	 */
	public void setValue_nqm_value(FDouble Value_nqm_value) {
		setAttrVal("Value_nqm_value", Value_nqm_value);
	}
	/**
	 * 指标权重
	 * @return String
	 */
	public String getWi_nqm_value() {
		return ((String) getAttrVal("Wi_nqm_value"));
	}	
	/**
	 * 指标权重
	 * @param Wi_nqm_value
	 */
	public void setWi_nqm_value(String Wi_nqm_value) {
		setAttrVal("Wi_nqm_value", Wi_nqm_value);
	}
	/**
	 * 是否为必要指标
	 * @return FBoolean
	 */
	public FBoolean getFg_mustkpi() {
		return ((FBoolean) getAttrVal("Fg_mustkpi"));
	}	
	/**
	 * 是否为必要指标
	 * @param Fg_mustkpi
	 */
	public void setFg_mustkpi(FBoolean Fg_mustkpi) {
		setAttrVal("Fg_mustkpi", Fg_mustkpi);
	}
	/**
	 * 指标编码
	 * @return String
	 */
	public String getCode_nqm_kpi() {
		return ((String) getAttrVal("Code_nqm_kpi"));
	}	
	/**
	 * 指标编码
	 * @param Code_nqm_kpi
	 */
	public void setCode_nqm_kpi(String Code_nqm_kpi) {
		setAttrVal("Code_nqm_kpi", Code_nqm_kpi);
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
		return "Id_nqm_tmpl_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_TMPLITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmnqmtmplitmDODesc.class);
	}
	
}