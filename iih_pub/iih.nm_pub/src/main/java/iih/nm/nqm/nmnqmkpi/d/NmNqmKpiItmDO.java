package iih.nm.nqm.nmnqmkpi.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmkpi.d.desc.NmNqmKpiItmDODesc;
import java.math.BigDecimal;

/**
 * 指标评分项目 DO数据 
 * 
 */
public class NmNqmKpiItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//指标评分项目主键
	public static final String ID_NQM_KPI_ITM= "Id_nqm_kpi_itm";
	//标准指标外键
	public static final String ID_NQM_KPI= "Id_nqm_kpi";
	//评分项
	public static final String ID_NQM_CHKITM= "Id_nqm_chkitm";
	//序号
	public static final String SORTNO= "Sortno";
	//名称
	public static final String NAME= "Name";
	//简称
	public static final String SHORT_NAME= "Short_name";
	//编码
	public static final String CODE= "Code";
	//分值
	public static final String VALUE= "Value";
	//权重
	public static final String WI= "Wi";
	//百分比
	public static final String PCT= "Pct";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//备注
	public static final String DES= "Des";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//评分项
	public static final String NAME_NQM_CHKITM= "Name_nqm_chkitm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 指标评分项目主键
	 * @return String
	 */
	public String getId_nqm_kpi_itm() {
		return ((String) getAttrVal("Id_nqm_kpi_itm"));
	}	
	/**
	 * 指标评分项目主键
	 * @param Id_nqm_kpi_itm
	 */
	public void setId_nqm_kpi_itm(String Id_nqm_kpi_itm) {
		setAttrVal("Id_nqm_kpi_itm", Id_nqm_kpi_itm);
	}
	/**
	 * 标准指标外键
	 * @return String
	 */
	public String getId_nqm_kpi() {
		return ((String) getAttrVal("Id_nqm_kpi"));
	}	
	/**
	 * 标准指标外键
	 * @param Id_nqm_kpi
	 */
	public void setId_nqm_kpi(String Id_nqm_kpi) {
		setAttrVal("Id_nqm_kpi", Id_nqm_kpi);
	}
	/**
	 * 评分项
	 * @return String
	 */
	public String getId_nqm_chkitm() {
		return ((String) getAttrVal("Id_nqm_chkitm"));
	}	
	/**
	 * 评分项
	 * @param Id_nqm_chkitm
	 */
	public void setId_nqm_chkitm(String Id_nqm_chkitm) {
		setAttrVal("Id_nqm_chkitm", Id_nqm_chkitm);
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
	 * 简称
	 * @return String
	 */
	public String getShort_name() {
		return ((String) getAttrVal("Short_name"));
	}	
	/**
	 * 简称
	 * @param Short_name
	 */
	public void setShort_name(String Short_name) {
		setAttrVal("Short_name", Short_name);
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
	 * 分值
	 * @return FDouble
	 */
	public FDouble getValue() {
		return ((FDouble) getAttrVal("Value"));
	}	
	/**
	 * 分值
	 * @param Value
	 */
	public void setValue(FDouble Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 权重
	 * @return FDouble
	 */
	public FDouble getWi() {
		return ((FDouble) getAttrVal("Wi"));
	}	
	/**
	 * 权重
	 * @param Wi
	 */
	public void setWi(FDouble Wi) {
		setAttrVal("Wi", Wi);
	}
	/**
	 * 百分比
	 * @return FDouble
	 */
	public FDouble getPct() {
		return ((FDouble) getAttrVal("Pct"));
	}	
	/**
	 * 百分比
	 * @param Pct
	 */
	public void setPct(FDouble Pct) {
		setAttrVal("Pct", Pct);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	 * 评分项
	 * @return String
	 */
	public String getName_nqm_chkitm() {
		return ((String) getAttrVal("Name_nqm_chkitm"));
	}	
	/**
	 * 评分项
	 * @param Name_nqm_chkitm
	 */
	public void setName_nqm_chkitm(String Name_nqm_chkitm) {
		setAttrVal("Name_nqm_chkitm", Name_nqm_chkitm);
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
		return "Id_nqm_kpi_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_KPI_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmKpiItmDODesc.class);
	}
	
}