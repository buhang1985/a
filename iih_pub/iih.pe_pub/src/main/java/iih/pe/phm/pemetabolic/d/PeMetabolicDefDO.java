package iih.pe.phm.pemetabolic.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pemetabolic.d.desc.PeMetabolicDefDODesc;
import java.math.BigDecimal;

/**
 * 体检危险因素-肥胖与高血压糖尿病血脂异常关系 DO数据 
 * 
 */
public class PeMetabolicDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检肥胖与高血压糖尿病血脂异常主键表
	public static final String ID_PEMETABOLIC= "Id_pemetabolic";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//体重指数
	public static final String BMI= "Bmi";
	//体重指数范围
	public static final String REF_BMI= "Ref_bmi";
	//腰围正常
	public static final String WAISTLINE_NORMAL= "Waistline_normal";
	//腰围增长
	public static final String WAISTLINE_LENGTH= "Waistline_length";
	//腰围过长
	public static final String WAISTLINE_OVER= "Waistline_over";
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
	 * 体检肥胖与高血压糖尿病血脂异常主键表
	 * @return String
	 */
	public String getId_pemetabolic() {
		return ((String) getAttrVal("Id_pemetabolic"));
	}	
	/**
	 * 体检肥胖与高血压糖尿病血脂异常主键表
	 * @param Id_pemetabolic
	 */
	public void setId_pemetabolic(String Id_pemetabolic) {
		setAttrVal("Id_pemetabolic", Id_pemetabolic);
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
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 体重指数
	 * @return Integer
	 */
	public Integer getBmi() {
		return ((Integer) getAttrVal("Bmi"));
	}	
	/**
	 * 体重指数
	 * @param Bmi
	 */
	public void setBmi(Integer Bmi) {
		setAttrVal("Bmi", Bmi);
	}
	/**
	 * 体重指数范围
	 * @return String
	 */
	public String getRef_bmi() {
		return ((String) getAttrVal("Ref_bmi"));
	}	
	/**
	 * 体重指数范围
	 * @param Ref_bmi
	 */
	public void setRef_bmi(String Ref_bmi) {
		setAttrVal("Ref_bmi", Ref_bmi);
	}
	/**
	 * 腰围正常
	 * @return Integer
	 */
	public Integer getWaistline_normal() {
		return ((Integer) getAttrVal("Waistline_normal"));
	}	
	/**
	 * 腰围正常
	 * @param Waistline_normal
	 */
	public void setWaistline_normal(Integer Waistline_normal) {
		setAttrVal("Waistline_normal", Waistline_normal);
	}
	/**
	 * 腰围增长
	 * @return Integer
	 */
	public Integer getWaistline_length() {
		return ((Integer) getAttrVal("Waistline_length"));
	}	
	/**
	 * 腰围增长
	 * @param Waistline_length
	 */
	public void setWaistline_length(Integer Waistline_length) {
		setAttrVal("Waistline_length", Waistline_length);
	}
	/**
	 * 腰围过长
	 * @return Integer
	 */
	public Integer getWaistline_over() {
		return ((Integer) getAttrVal("Waistline_over"));
	}	
	/**
	 * 腰围过长
	 * @param Waistline_over
	 */
	public void setWaistline_over(Integer Waistline_over) {
		setAttrVal("Waistline_over", Waistline_over);
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
		return "Id_pemetabolic";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pemetabolicdef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeMetabolicDefDODesc.class);
	}
	
}