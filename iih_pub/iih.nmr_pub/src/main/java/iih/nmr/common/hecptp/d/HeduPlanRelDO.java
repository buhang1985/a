package iih.nmr.common.hecptp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.common.hecptp.d.desc.HeduPlanRelDODesc;
import java.math.BigDecimal;

/**
 * 健康教育计划关系 DO数据 
 * 
 */
public class HeduPlanRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康教育计划关系ID
	public static final String ID_PKUF_HECPREL= "Id_pkuf_hecprel";
	//单据类型ID
	public static final String ID_PKUF_HECPTP= "Id_pkuf_hecptp";
	//教育计划内容ID
	public static final String ID_PKUF_HECP= "Id_pkuf_hecp";
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
	//教育内容
	public static final String NAME_HECP= "Name_hecp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康教育计划关系ID
	 * @return String
	 */
	public String getId_pkuf_hecprel() {
		return ((String) getAttrVal("Id_pkuf_hecprel"));
	}	
	/**
	 * 健康教育计划关系ID
	 * @param Id_pkuf_hecprel
	 */
	public void setId_pkuf_hecprel(String Id_pkuf_hecprel) {
		setAttrVal("Id_pkuf_hecprel", Id_pkuf_hecprel);
	}
	/**
	 * 单据类型ID
	 * @return String
	 */
	public String getId_pkuf_hecptp() {
		return ((String) getAttrVal("Id_pkuf_hecptp"));
	}	
	/**
	 * 单据类型ID
	 * @param Id_pkuf_hecptp
	 */
	public void setId_pkuf_hecptp(String Id_pkuf_hecptp) {
		setAttrVal("Id_pkuf_hecptp", Id_pkuf_hecptp);
	}
	/**
	 * 教育计划内容ID
	 * @return String
	 */
	public String getId_pkuf_hecp() {
		return ((String) getAttrVal("Id_pkuf_hecp"));
	}	
	/**
	 * 教育计划内容ID
	 * @param Id_pkuf_hecp
	 */
	public void setId_pkuf_hecp(String Id_pkuf_hecp) {
		setAttrVal("Id_pkuf_hecp", Id_pkuf_hecp);
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
	/**
	 * 教育内容
	 * @return String
	 */
	public String getName_hecp() {
		return ((String) getAttrVal("Name_hecp"));
	}	
	/**
	 * 教育内容
	 * @param Name_hecp
	 */
	public void setName_hecp(String Name_hecp) {
		setAttrVal("Name_hecp", Name_hecp);
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
		return "Id_pkuf_hecprel";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_HECPREL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HeduPlanRelDODesc.class);
	}
	
}