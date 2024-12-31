package iih.bd.srv.mrtplvst.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrtplvst.d.desc.BdMrtplVstItmDODesc;
import java.math.BigDecimal;

/**
 * 体征模板项目关系 DO数据 
 * 
 */
public class BdMrtplVstItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体征模板项目ID
	public static final String ID_MRTPL_VST_ITM= "Id_mrtpl_vst_itm";
	//体征模板
	public static final String ID_MRTPL_VST= "Id_mrtpl_vst";
	//体征项目
	public static final String ID_MRTPL_VS= "Id_mrtpl_vs";
	//序号
	public static final String SORTNO= "Sortno";
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
	//体征模板名称
	public static final String NAME_MRTPLVST= "Name_mrtplvst";
	//体征项目名称
	public static final String NAME_MRTPLVS= "Name_mrtplvs";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体征模板项目ID
	 * @return String
	 */
	public String getId_mrtpl_vst_itm() {
		return ((String) getAttrVal("Id_mrtpl_vst_itm"));
	}	
	/**
	 * 体征模板项目ID
	 * @param Id_mrtpl_vst_itm
	 */
	public void setId_mrtpl_vst_itm(String Id_mrtpl_vst_itm) {
		setAttrVal("Id_mrtpl_vst_itm", Id_mrtpl_vst_itm);
	}
	/**
	 * 体征模板
	 * @return String
	 */
	public String getId_mrtpl_vst() {
		return ((String) getAttrVal("Id_mrtpl_vst"));
	}	
	/**
	 * 体征模板
	 * @param Id_mrtpl_vst
	 */
	public void setId_mrtpl_vst(String Id_mrtpl_vst) {
		setAttrVal("Id_mrtpl_vst", Id_mrtpl_vst);
	}
	/**
	 * 体征项目
	 * @return String
	 */
	public String getId_mrtpl_vs() {
		return ((String) getAttrVal("Id_mrtpl_vs"));
	}	
	/**
	 * 体征项目
	 * @param Id_mrtpl_vs
	 */
	public void setId_mrtpl_vs(String Id_mrtpl_vs) {
		setAttrVal("Id_mrtpl_vs", Id_mrtpl_vs);
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
	 * 体征模板名称
	 * @return String
	 */
	public String getName_mrtplvst() {
		return ((String) getAttrVal("Name_mrtplvst"));
	}	
	/**
	 * 体征模板名称
	 * @param Name_mrtplvst
	 */
	public void setName_mrtplvst(String Name_mrtplvst) {
		setAttrVal("Name_mrtplvst", Name_mrtplvst);
	}
	/**
	 * 体征项目名称
	 * @return String
	 */
	public String getName_mrtplvs() {
		return ((String) getAttrVal("Name_mrtplvs"));
	}	
	/**
	 * 体征项目名称
	 * @param Name_mrtplvs
	 */
	public void setName_mrtplvs(String Name_mrtplvs) {
		setAttrVal("Name_mrtplvs", Name_mrtplvs);
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
		return "Id_mrtpl_vst_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrtpl_vst_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdMrtplVstItmDODesc.class);
	}
	
}