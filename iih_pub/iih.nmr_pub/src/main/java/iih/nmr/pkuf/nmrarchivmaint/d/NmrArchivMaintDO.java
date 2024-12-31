package iih.nmr.pkuf.nmrarchivmaint.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.nmrarchivmaint.d.desc.NmrArchivMaintDODesc;
import java.math.BigDecimal;

/**
 * 文书归档维护 DO数据 
 * 
 */
public class NmrArchivMaintDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//归档维护住建文书
	public static final String ID_ARCHMAIN= "Id_archmain";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//序号
	public static final String SERIALNUM= "Serialnum";
	//文书id
	public static final String ID_NMRDOC= "Id_nmrdoc";
	//文书名称
	public static final String NAME_DOC= "Name_doc";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
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
	 * 归档维护住建文书
	 * @return String
	 */
	public String getId_archmain() {
		return ((String) getAttrVal("Id_archmain"));
	}	
	/**
	 * 归档维护住建文书
	 * @param Id_archmain
	 */
	public void setId_archmain(String Id_archmain) {
		setAttrVal("Id_archmain", Id_archmain);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSerialnum() {
		return ((Integer) getAttrVal("Serialnum"));
	}	
	/**
	 * 序号
	 * @param Serialnum
	 */
	public void setSerialnum(Integer Serialnum) {
		setAttrVal("Serialnum", Serialnum);
	}
	/**
	 * 文书id
	 * @return String
	 */
	public String getId_nmrdoc() {
		return ((String) getAttrVal("Id_nmrdoc"));
	}	
	/**
	 * 文书id
	 * @param Id_nmrdoc
	 */
	public void setId_nmrdoc(String Id_nmrdoc) {
		setAttrVal("Id_nmrdoc", Id_nmrdoc);
	}
	/**
	 * 文书名称
	 * @return String
	 */
	public String getName_doc() {
		return ((String) getAttrVal("Name_doc"));
	}	
	/**
	 * 文书名称
	 * @param Name_doc
	 */
	public void setName_doc(String Name_doc) {
		setAttrVal("Name_doc", Name_doc);
	}
	/**
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
		return "Id_archmain";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_ARCHIVMAINT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmrArchivMaintDODesc.class);
	}
	
}