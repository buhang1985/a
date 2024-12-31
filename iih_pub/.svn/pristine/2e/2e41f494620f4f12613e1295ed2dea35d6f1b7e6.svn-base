package iih.pe.pwf.perstdiagsugg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.perstdiagsugg.d.desc.PeRstDiDODesc;
import java.math.BigDecimal;

/**
 * 体检结果诊断 DO数据 
 * 
 */
public class PeRstDiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检结果诊断主键标识
	public static final String ID_PERSTDI= "Id_perstdi";
	//体检结果诊断建议ID
	public static final String ID_PERSTDIAGSUGG= "Id_perstdiagsugg";
	//体检诊断定义ID
	public static final String ID_PERSTDIDEF= "Id_perstdidef";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检诊断
	public static final String NAMEDIAG= "Namediag";
	//序号
	public static final String SORTNO= "Sortno";
	//可疑标识
	public static final String FG_DOUBT= "Fg_doubt";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//紧急标识
	public static final String FG_URGENCY= "Fg_urgency";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检结果诊断主键标识
	 * @return String
	 */
	public String getId_perstdi() {
		return ((String) getAttrVal("Id_perstdi"));
	}	
	/**
	 * 体检结果诊断主键标识
	 * @param Id_perstdi
	 */
	public void setId_perstdi(String Id_perstdi) {
		setAttrVal("Id_perstdi", Id_perstdi);
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
	 * 体检诊断定义ID
	 * @return String
	 */
	public String getId_perstdidef() {
		return ((String) getAttrVal("Id_perstdidef"));
	}	
	/**
	 * 体检诊断定义ID
	 * @param Id_perstdidef
	 */
	public void setId_perstdidef(String Id_perstdidef) {
		setAttrVal("Id_perstdidef", Id_perstdidef);
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
	 * 体检诊断
	 * @return String
	 */
	public String getNamediag() {
		return ((String) getAttrVal("Namediag"));
	}	
	/**
	 * 体检诊断
	 * @param Namediag
	 */
	public void setNamediag(String Namediag) {
		setAttrVal("Namediag", Namediag);
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
	 * 可疑标识
	 * @return FBoolean
	 */
	public FBoolean getFg_doubt() {
		return ((FBoolean) getAttrVal("Fg_doubt"));
	}	
	/**
	 * 可疑标识
	 * @param Fg_doubt
	 */
	public void setFg_doubt(FBoolean Fg_doubt) {
		setAttrVal("Fg_doubt", Fg_doubt);
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
	 * 紧急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgency() {
		return ((FBoolean) getAttrVal("Fg_urgency"));
	}	
	/**
	 * 紧急标识
	 * @param Fg_urgency
	 */
	public void setFg_urgency(FBoolean Fg_urgency) {
		setAttrVal("Fg_urgency", Fg_urgency);
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
		return "Id_perstdi";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_perstdi";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstDiDODesc.class);
	}
	
}