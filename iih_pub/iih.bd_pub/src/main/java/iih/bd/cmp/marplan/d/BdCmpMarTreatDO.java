package iih.bd.cmp.marplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.cmp.marplan.d.desc.BdCmpMarTreatDODesc;
import java.math.BigDecimal;

/**
 * 营销方案特惠待遇 DO数据 
 * 
 */
public class BdCmpMarTreatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//营销方案特惠待遇id
	public static final String ID_MARPLANTREAT= "Id_marplantreat";
	//营销方案id
	public static final String ID_MARPLAN= "Id_marplan";
	//特惠待遇类型
	public static final String ID_TREATTP= "Id_treattp";
	//特惠待遇类型编码
	public static final String SD_TREATTP= "Sd_treattp";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String CODE_TREATTP= "Code_treattp";
	//名称
	public static final String NAME_TREATTP= "Name_treattp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 营销方案特惠待遇id
	 * @return String
	 */
	public String getId_marplantreat() {
		return ((String) getAttrVal("Id_marplantreat"));
	}	
	/**
	 * 营销方案特惠待遇id
	 * @param Id_marplantreat
	 */
	public void setId_marplantreat(String Id_marplantreat) {
		setAttrVal("Id_marplantreat", Id_marplantreat);
	}
	/**
	 * 营销方案id
	 * @return String
	 */
	public String getId_marplan() {
		return ((String) getAttrVal("Id_marplan"));
	}	
	/**
	 * 营销方案id
	 * @param Id_marplan
	 */
	public void setId_marplan(String Id_marplan) {
		setAttrVal("Id_marplan", Id_marplan);
	}
	/**
	 * 特惠待遇类型
	 * @return String
	 */
	public String getId_treattp() {
		return ((String) getAttrVal("Id_treattp"));
	}	
	/**
	 * 特惠待遇类型
	 * @param Id_treattp
	 */
	public void setId_treattp(String Id_treattp) {
		setAttrVal("Id_treattp", Id_treattp);
	}
	/**
	 * 特惠待遇类型编码
	 * @return String
	 */
	public String getSd_treattp() {
		return ((String) getAttrVal("Sd_treattp"));
	}	
	/**
	 * 特惠待遇类型编码
	 * @param Sd_treattp
	 */
	public void setSd_treattp(String Sd_treattp) {
		setAttrVal("Sd_treattp", Sd_treattp);
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
	 * 编码
	 * @return String
	 */
	public String getCode_treattp() {
		return ((String) getAttrVal("Code_treattp"));
	}	
	/**
	 * 编码
	 * @param Code_treattp
	 */
	public void setCode_treattp(String Code_treattp) {
		setAttrVal("Code_treattp", Code_treattp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_treattp() {
		return ((String) getAttrVal("Name_treattp"));
	}	
	/**
	 * 名称
	 * @param Name_treattp
	 */
	public void setName_treattp(String Name_treattp) {
		setAttrVal("Name_treattp", Name_treattp);
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
		return "Id_marplantreat";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mar_treat";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdCmpMarTreatDODesc.class);
	}
	
}