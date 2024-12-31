package iih.bd.mm.medicinedirectory.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.medicinedirectory.d.desc.MedicineDirectoryDODesc;
import java.math.BigDecimal;

/**
 * 包药机药品目录维护 DO数据 
 * 
 */
public class MedicineDirectoryDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//包药机药品目录维护主键
	public static final String ID_ORALMECH_REL= "Id_oralmech_rel";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//医疗物品
	public static final String ID_MM= "Id_mm";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//通用名称
	public static final String GENERICNAME= "Genericname";
	//剂型
	public static final String DOSAGEFORM= "Dosageform";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//生产厂家名称
	public static final String MM_SUP_NAME= "Mm_sup_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 包药机药品目录维护主键
	 * @return String
	 */
	public String getId_oralmech_rel() {
		return ((String) getAttrVal("Id_oralmech_rel"));
	}	
	/**
	 * 包药机药品目录维护主键
	 * @param Id_oralmech_rel
	 */
	public void setId_oralmech_rel(String Id_oralmech_rel) {
		setAttrVal("Id_oralmech_rel", Id_oralmech_rel);
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
	 * 医疗物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 医疗物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 通用名称
	 * @return String
	 */
	public String getGenericname() {
		return ((String) getAttrVal("Genericname"));
	}	
	/**
	 * 通用名称
	 * @param Genericname
	 */
	public void setGenericname(String Genericname) {
		setAttrVal("Genericname", Genericname);
	}
	/**
	 * 剂型
	 * @return String
	 */
	public String getDosageform() {
		return ((String) getAttrVal("Dosageform"));
	}	
	/**
	 * 剂型
	 * @param Dosageform
	 */
	public void setDosageform(String Dosageform) {
		setAttrVal("Dosageform", Dosageform);
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
	 * 物品编码
	 * @return String
	 */
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	/**
	 * 物品编码
	 * @param Mm_code
	 */
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	/**
	 * 物品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	/**
	 * 物品规格
	 * @return String
	 */
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}	
	/**
	 * 物品规格
	 * @param Mm_spec
	 */
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
	}
	/**
	 * 生产厂家名称
	 * @return String
	 */
	public String getMm_sup_name() {
		return ((String) getAttrVal("Mm_sup_name"));
	}	
	/**
	 * 生产厂家名称
	 * @param Mm_sup_name
	 */
	public void setMm_sup_name(String Mm_sup_name) {
		setAttrVal("Mm_sup_name", Mm_sup_name);
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
		return "Id_oralmech_rel";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mm_oralmech_rel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedicineDirectoryDODesc.class);
	}
	
}