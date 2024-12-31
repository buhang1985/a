package iih.pe.pwf.perstdiagsugg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.perstdiagsugg.d.desc.PeRstSuggDODesc;
import java.math.BigDecimal;

/**
 * 体检结果建议 DO数据 
 * 
 */
public class PeRstSuggDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检结果建议主键标识
	public static final String ID_PERSTSUGG= "Id_perstsugg";
	//体检结果诊断建议ID
	public static final String ID_PERSTDIAGSUGG= "Id_perstdiagsugg";
	//体检建议定义ID
	public static final String ID_PERSTSUGGDEF= "Id_perstsuggdef";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检建议
	public static final String NAMESUGG= "Namesugg";
	//序号
	public static final String SORTNO= "Sortno";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检结果建议主键标识
	 * @return String
	 */
	public String getId_perstsugg() {
		return ((String) getAttrVal("Id_perstsugg"));
	}	
	/**
	 * 体检结果建议主键标识
	 * @param Id_perstsugg
	 */
	public void setId_perstsugg(String Id_perstsugg) {
		setAttrVal("Id_perstsugg", Id_perstsugg);
	}
	/**
	 * 体检结果诊断建议ID
	 * @return String
	 */
	public String getId_perstdiagsugg() {
		return ((String) getAttrVal("Id_perstdiagsugg"));
	}	
	/**
	 * 体检结果诊断建议ID
	 * @param Id_perstdiagsugg
	 */
	public void setId_perstdiagsugg(String Id_perstdiagsugg) {
		setAttrVal("Id_perstdiagsugg", Id_perstdiagsugg);
	}
	/**
	 * 体检建议定义ID
	 * @return String
	 */
	public String getId_perstsuggdef() {
		return ((String) getAttrVal("Id_perstsuggdef"));
	}	
	/**
	 * 体检建议定义ID
	 * @param Id_perstsuggdef
	 */
	public void setId_perstsuggdef(String Id_perstsuggdef) {
		setAttrVal("Id_perstsuggdef", Id_perstsuggdef);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 体检建议
	 * @return String
	 */
	public String getNamesugg() {
		return ((String) getAttrVal("Namesugg"));
	}	
	/**
	 * 体检建议
	 * @param Namesugg
	 */
	public void setNamesugg(String Namesugg) {
		setAttrVal("Namesugg", Namesugg);
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
		return "Id_perstsugg";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_perstsugg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstSuggDODesc.class);
	}
	
}