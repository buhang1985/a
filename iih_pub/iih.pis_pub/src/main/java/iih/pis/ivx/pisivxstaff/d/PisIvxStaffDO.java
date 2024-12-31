package iih.pis.ivx.pisivxstaff.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxstaff.d.desc.PisIvxStaffDODesc;
import java.math.BigDecimal;

/**
 * 微信服务号职工绑定 DO数据 
 * 
 */
public class PisIvxStaffDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信服务号职工主键标识
	public static final String ID_PISIVXSTAFF= "Id_pisivxstaff";
	//微信账户ID
	public static final String ID_PISIVXACCOUNT= "Id_pisivxaccount";
	//人员主键标识
	public static final String ID_PSNDOC= "Id_psndoc";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//用户分组标签ID
	public static final String ID_PISIVXTAGS= "Id_pisivxtags";
	//微信唯一码
	public static final String OPENID= "Openid";
	//人员编码
	public static final String CODE= "Code";
	//姓名
	public static final String NAME= "Name";
	//标签id
	public static final String TAGID_TAG= "Tagid_tag";
	//名称
	public static final String NAME_TAG= "Name_tag";
	//编码
	public static final String CODE_TAG= "Code_tag";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信服务号职工主键标识
	 * @return String
	 */
	public String getId_pisivxstaff() {
		return ((String) getAttrVal("Id_pisivxstaff"));
	}	
	/**
	 * 微信服务号职工主键标识
	 * @param Id_pisivxstaff
	 */
	public void setId_pisivxstaff(String Id_pisivxstaff) {
		setAttrVal("Id_pisivxstaff", Id_pisivxstaff);
	}
	/**
	 * 微信账户ID
	 * @return String
	 */
	public String getId_pisivxaccount() {
		return ((String) getAttrVal("Id_pisivxaccount"));
	}	
	/**
	 * 微信账户ID
	 * @param Id_pisivxaccount
	 */
	public void setId_pisivxaccount(String Id_pisivxaccount) {
		setAttrVal("Id_pisivxaccount", Id_pisivxaccount);
	}
	/**
	 * 人员主键标识
	 * @return String
	 */
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	/**
	 * 人员主键标识
	 * @param Id_psndoc
	 */
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
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
	 * 用户分组标签ID
	 * @return String
	 */
	public String getId_pisivxtags() {
		return ((String) getAttrVal("Id_pisivxtags"));
	}	
	/**
	 * 用户分组标签ID
	 * @param Id_pisivxtags
	 */
	public void setId_pisivxtags(String Id_pisivxtags) {
		setAttrVal("Id_pisivxtags", Id_pisivxtags);
	}
	/**
	 * 微信唯一码
	 * @return String
	 */
	public String getOpenid() {
		return ((String) getAttrVal("Openid"));
	}	
	/**
	 * 微信唯一码
	 * @param Openid
	 */
	public void setOpenid(String Openid) {
		setAttrVal("Openid", Openid);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 人员编码
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
	 * 标签id
	 * @return Integer
	 */
	public Integer getTagid_tag() {
		return ((Integer) getAttrVal("Tagid_tag"));
	}	
	/**
	 * 标签id
	 * @param Tagid_tag
	 */
	public void setTagid_tag(Integer Tagid_tag) {
		setAttrVal("Tagid_tag", Tagid_tag);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_tag() {
		return ((String) getAttrVal("Name_tag"));
	}	
	/**
	 * 名称
	 * @param Name_tag
	 */
	public void setName_tag(String Name_tag) {
		setAttrVal("Name_tag", Name_tag);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_tag() {
		return ((String) getAttrVal("Code_tag"));
	}	
	/**
	 * 编码
	 * @param Code_tag
	 */
	public void setCode_tag(String Code_tag) {
		setAttrVal("Code_tag", Code_tag);
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
		return "Id_pisivxstaff";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_staff";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisIvxStaffDODesc.class);
	}
	
}