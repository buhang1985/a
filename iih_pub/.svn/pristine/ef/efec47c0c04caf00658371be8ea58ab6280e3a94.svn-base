package iih.ei.itf.eiitfcateitm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ei.itf.eiitfcateitm.d.desc.ItfCateItmDODesc;
import java.math.BigDecimal;

/**
 * 接口分类项目 DO数据 
 * 
 */
public class ItfCateItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//接口分类项目
	public static final String ID_ITFCATE_ITM= "Id_itfcate_itm";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//接口分类
	public static final String ID_ITFCATE= "Id_itfcate";
	//接口
	public static final String ID_ITF= "Id_itf";
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
	 * 接口分类项目
	 * @return String
	 */
	public String getId_itfcate_itm() {
		return ((String) getAttrVal("Id_itfcate_itm"));
	}	
	/**
	 * 接口分类项目
	 * @param Id_itfcate_itm
	 */
	public void setId_itfcate_itm(String Id_itfcate_itm) {
		setAttrVal("Id_itfcate_itm", Id_itfcate_itm);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 接口分类
	 * @return String
	 */
	public String getId_itfcate() {
		return ((String) getAttrVal("Id_itfcate"));
	}	
	/**
	 * 接口分类
	 * @param Id_itfcate
	 */
	public void setId_itfcate(String Id_itfcate) {
		setAttrVal("Id_itfcate", Id_itfcate);
	}
	/**
	 * 接口
	 * @return String
	 */
	public String getId_itf() {
		return ((String) getAttrVal("Id_itf"));
	}	
	/**
	 * 接口
	 * @param Id_itf
	 */
	public void setId_itf(String Id_itf) {
		setAttrVal("Id_itf", Id_itf);
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
		return "Id_itfcate_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "EI_ITF_CATE_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ItfCateItmDODesc.class);
	}
	
}