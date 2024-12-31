package iih.nm.nqm.nqmimprovl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nqmimprovl.d.desc.NqmImprovKpiDODesc;
import java.math.BigDecimal;

/**
 * 问题指标 DO数据 
 * 
 */
public class NqmImprovKpiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//问题指标主键
	public static final String ID_NQM_IMPROV_KPI= "Id_nqm_improv_kpi";
	//持续改进记录外键
	public static final String ID_NQM_IMPROV= "Id_nqm_improv";
	//质控标准
	public static final String ID_NQM_CS= "Id_nqm_cs";
	//标准指标
	public static final String ID_NQM_KPI= "Id_nqm_kpi";
	//检查份数
	public static final String COUNT_CHK= "Count_chk";
	//发生次数
	public static final String FREQ= "Freq";
	//发生率
	public static final String FREQ_RATE= "Freq_rate";
	//备注问题
	public static final String ISSUEDES= "Issuedes";
	//扩展字段1
	public static final String DEF1= "Def1";
	//扩展字段2
	public static final String DEF2= "Def2";
	//扩展字段3
	public static final String DEF3= "Def3";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//质控标准
	public static final String NAME_NQM_CS= "Name_nqm_cs";
	//指标
	public static final String NAME_NQM_KPI= "Name_nqm_kpi";
	//上级指标
	public static final String ID_NQM_KPI_PAR= "Id_nqm_kpi_par";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 问题指标主键
	 * @return String
	 */
	public String getId_nqm_improv_kpi() {
		return ((String) getAttrVal("Id_nqm_improv_kpi"));
	}	
	/**
	 * 问题指标主键
	 * @param Id_nqm_improv_kpi
	 */
	public void setId_nqm_improv_kpi(String Id_nqm_improv_kpi) {
		setAttrVal("Id_nqm_improv_kpi", Id_nqm_improv_kpi);
	}
	/**
	 * 持续改进记录外键
	 * @return String
	 */
	public String getId_nqm_improv() {
		return ((String) getAttrVal("Id_nqm_improv"));
	}	
	/**
	 * 持续改进记录外键
	 * @param Id_nqm_improv
	 */
	public void setId_nqm_improv(String Id_nqm_improv) {
		setAttrVal("Id_nqm_improv", Id_nqm_improv);
	}
	/**
	 * 质控标准
	 * @return String
	 */
	public String getId_nqm_cs() {
		return ((String) getAttrVal("Id_nqm_cs"));
	}	
	/**
	 * 质控标准
	 * @param Id_nqm_cs
	 */
	public void setId_nqm_cs(String Id_nqm_cs) {
		setAttrVal("Id_nqm_cs", Id_nqm_cs);
	}
	/**
	 * 标准指标
	 * @return String
	 */
	public String getId_nqm_kpi() {
		return ((String) getAttrVal("Id_nqm_kpi"));
	}	
	/**
	 * 标准指标
	 * @param Id_nqm_kpi
	 */
	public void setId_nqm_kpi(String Id_nqm_kpi) {
		setAttrVal("Id_nqm_kpi", Id_nqm_kpi);
	}
	/**
	 * 检查份数
	 * @return Integer
	 */
	public Integer getCount_chk() {
		return ((Integer) getAttrVal("Count_chk"));
	}	
	/**
	 * 检查份数
	 * @param Count_chk
	 */
	public void setCount_chk(Integer Count_chk) {
		setAttrVal("Count_chk", Count_chk);
	}
	/**
	 * 发生次数
	 * @return Integer
	 */
	public Integer getFreq() {
		return ((Integer) getAttrVal("Freq"));
	}	
	/**
	 * 发生次数
	 * @param Freq
	 */
	public void setFreq(Integer Freq) {
		setAttrVal("Freq", Freq);
	}
	/**
	 * 发生率
	 * @return String
	 */
	public String getFreq_rate() {
		return ((String) getAttrVal("Freq_rate"));
	}	
	/**
	 * 发生率
	 * @param Freq_rate
	 */
	public void setFreq_rate(String Freq_rate) {
		setAttrVal("Freq_rate", Freq_rate);
	}
	/**
	 * 备注问题
	 * @return String
	 */
	public String getIssuedes() {
		return ((String) getAttrVal("Issuedes"));
	}	
	/**
	 * 备注问题
	 * @param Issuedes
	 */
	public void setIssuedes(String Issuedes) {
		setAttrVal("Issuedes", Issuedes);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
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
	 * 质控标准
	 * @return String
	 */
	public String getName_nqm_cs() {
		return ((String) getAttrVal("Name_nqm_cs"));
	}	
	/**
	 * 质控标准
	 * @param Name_nqm_cs
	 */
	public void setName_nqm_cs(String Name_nqm_cs) {
		setAttrVal("Name_nqm_cs", Name_nqm_cs);
	}
	/**
	 * 指标
	 * @return String
	 */
	public String getName_nqm_kpi() {
		return ((String) getAttrVal("Name_nqm_kpi"));
	}	
	/**
	 * 指标
	 * @param Name_nqm_kpi
	 */
	public void setName_nqm_kpi(String Name_nqm_kpi) {
		setAttrVal("Name_nqm_kpi", Name_nqm_kpi);
	}
	/**
	 * 上级指标
	 * @return String
	 */
	public String getId_nqm_kpi_par() {
		return ((String) getAttrVal("Id_nqm_kpi_par"));
	}	
	/**
	 * 上级指标
	 * @param Id_nqm_kpi_par
	 */
	public void setId_nqm_kpi_par(String Id_nqm_kpi_par) {
		setAttrVal("Id_nqm_kpi_par", Id_nqm_kpi_par);
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
		return "Id_nqm_improv_kpi";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_IMPROV_KPI";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NqmImprovKpiDODesc.class);
	}
	
}