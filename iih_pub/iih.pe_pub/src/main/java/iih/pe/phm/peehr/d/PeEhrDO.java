package iih.pe.phm.peehr.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.peehr.d.desc.PeEhrDODesc;
import java.math.BigDecimal;

/**
 * 体检电子健康档案EHR DO数据 
 * 
 */
public class PeEhrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检电子档案主键标识
	public static final String ID_PEEHR= "Id_peehr";
	//体检个人预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//电子档案文件
	public static final String EHRXML= "Ehrxml";
	//创建日期
	public static final String DT_EHT= "Dt_eht";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
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
	 * 体检电子档案主键标识
	 * @return String
	 */
	public String getId_peehr() {
		return ((String) getAttrVal("Id_peehr"));
	}	
	/**
	 * 体检电子档案主键标识
	 * @param Id_peehr
	 */
	public void setId_peehr(String Id_peehr) {
		setAttrVal("Id_peehr", Id_peehr);
	}
	/**
	 * 体检个人预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检个人预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 电子档案文件
	 * @return String
	 */
	public String getEhrxml() {
		return ((String) getAttrVal("Ehrxml"));
	}	
	/**
	 * 电子档案文件
	 * @param Ehrxml
	 */
	public void setEhrxml(String Ehrxml) {
		setAttrVal("Ehrxml", Ehrxml);
	}
	/**
	 * 创建日期
	 * @return FDate
	 */
	public FDate getDt_eht() {
		return ((FDate) getAttrVal("Dt_eht"));
	}	
	/**
	 * 创建日期
	 * @param Dt_eht
	 */
	public void setDt_eht(FDate Dt_eht) {
		setAttrVal("Dt_eht", Dt_eht);
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
		return "Id_peehr";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_ehr";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeEhrDODesc.class);
	}
	
}