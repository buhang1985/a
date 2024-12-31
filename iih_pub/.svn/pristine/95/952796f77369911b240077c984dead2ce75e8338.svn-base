package iih.nm.nqm.nmnqmnchk.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmnchk.d.desc.NmNqmNchkItmDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_夜查房_督导项 DO数据 
 * 
 */
public class NmNqmNchkItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//督导项主键
	public static final String ID_NQM_NCHK_ITM= "Id_nqm_nchk_itm";
	//夜查房外键
	public static final String ID_NQM_NCHK= "Id_nqm_nchk";
	//督导项
	public static final String ID_NQM_SUPER= "Id_nqm_super";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NQM_SUPER_NAME= "Nqm_super_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 督导项主键
	 * @return String
	 */
	public String getId_nqm_nchk_itm() {
		return ((String) getAttrVal("Id_nqm_nchk_itm"));
	}	
	/**
	 * 督导项主键
	 * @param Id_nqm_nchk_itm
	 */
	public void setId_nqm_nchk_itm(String Id_nqm_nchk_itm) {
		setAttrVal("Id_nqm_nchk_itm", Id_nqm_nchk_itm);
	}
	/**
	 * 夜查房外键
	 * @return String
	 */
	public String getId_nqm_nchk() {
		return ((String) getAttrVal("Id_nqm_nchk"));
	}	
	/**
	 * 夜查房外键
	 * @param Id_nqm_nchk
	 */
	public void setId_nqm_nchk(String Id_nqm_nchk) {
		setAttrVal("Id_nqm_nchk", Id_nqm_nchk);
	}
	/**
	 * 督导项
	 * @return String
	 */
	public String getId_nqm_super() {
		return ((String) getAttrVal("Id_nqm_super"));
	}	
	/**
	 * 督导项
	 * @param Id_nqm_super
	 */
	public void setId_nqm_super(String Id_nqm_super) {
		setAttrVal("Id_nqm_super", Id_nqm_super);
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
	 * 名称
	 * @return String
	 */
	public String getNqm_super_name() {
		return ((String) getAttrVal("Nqm_super_name"));
	}	
	/**
	 * 名称
	 * @param Nqm_super_name
	 */
	public void setNqm_super_name(String Nqm_super_name) {
		setAttrVal("Nqm_super_name", Nqm_super_name);
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
		return "Id_nqm_nchk_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_NCHK_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmNchkItmDODesc.class);
	}
	
}