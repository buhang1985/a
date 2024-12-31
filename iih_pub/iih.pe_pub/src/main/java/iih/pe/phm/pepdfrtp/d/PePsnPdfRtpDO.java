package iih.pe.phm.pepdfrtp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pepdfrtp.d.desc.PePsnPdfRtpDODesc;
import java.math.BigDecimal;

/**
 * 体检报告PDF格式 DO数据 
 * 
 */
public class PePsnPdfRtpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检PDF报告主键标识
	public static final String ID_PEPDFRTP= "Id_pepdfrtp";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//体检日期
	public static final String DT_PE= "Dt_pe";
	//体检机构
	public static final String ORG_PE= "Org_pe";
	//PDF报告
	public static final String PDFRPT= "Pdfrpt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//displaynam8
	public static final String NAME8= "Name8";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//客户编码
	public static final String CODE= "Code";
	//姓名
	public static final String NAME= "Name";
	//移动电话
	public static final String MOB= "Mob";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检PDF报告主键标识
	 * @return String
	 */
	public String getId_pepdfrtp() {
		return ((String) getAttrVal("Id_pepdfrtp"));
	}	
	/**
	 * 体检PDF报告主键标识
	 * @param Id_pepdfrtp
	 */
	public void setId_pepdfrtp(String Id_pepdfrtp) {
		setAttrVal("Id_pepdfrtp", Id_pepdfrtp);
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
	 * 体检日期
	 * @return FDate
	 */
	public FDate getDt_pe() {
		return ((FDate) getAttrVal("Dt_pe"));
	}	
	/**
	 * 体检日期
	 * @param Dt_pe
	 */
	public void setDt_pe(FDate Dt_pe) {
		setAttrVal("Dt_pe", Dt_pe);
	}
	/**
	 * 体检机构
	 * @return String
	 */
	public String getOrg_pe() {
		return ((String) getAttrVal("Org_pe"));
	}	
	/**
	 * 体检机构
	 * @param Org_pe
	 */
	public void setOrg_pe(String Org_pe) {
		setAttrVal("Org_pe", Org_pe);
	}
	/**
	 * PDF报告
	 * @return byte[]
	 */
	public byte[] getPdfrpt() {
		return ((byte[]) getAttrVal("Pdfrpt"));
	}	
	/**
	 * PDF报告
	 * @param Pdfrpt
	 */
	public void setPdfrpt(byte[] Pdfrpt) {
		setAttrVal("Pdfrpt", Pdfrpt);
	}
	/**
	 * 体检客户ID
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	/**
	 * 体检客户ID
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * displaynam8
	 * @return String
	 */
	public String getName8() {
		return ((String) getAttrVal("Name8"));
	}	
	/**
	 * displaynam8
	 * @param Name8
	 */
	public void setName8(String Name8) {
		setAttrVal("Name8", Name8);
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
	 * 客户编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 客户编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * 移动电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
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
		return "Id_pepdfrtp";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_ehr_psnpdfreport";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePsnPdfRtpDODesc.class);
	}
	
}