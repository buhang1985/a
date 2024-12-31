package iih.bd.srv.bdmrsigntype.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.bdmrsigntype.d.desc.BdMrSignTypeDODesc;
import java.math.BigDecimal;

/**
 * 病历审签类型 DO数据 
 * 
 */
public class BdMrSignTypeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//病历审签类型主键
	public static final String ID_MR_SIGN_TYPE= "Id_mr_sign_type";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//启用人
	public static final String ID_ACTIVE_USER= "Id_active_user";
	//启用时间
	public static final String DT_ACTIVE= "Dt_active";
	//停用人
	public static final String ID_DEACTIVE= "Id_deactive";
	//停用时间
	public static final String DT_DEACTIVE= "Dt_deactive";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 病历审签类型主键
	 * @return String
	 */
	public String getId_mr_sign_type() {
		return ((String) getAttrVal("Id_mr_sign_type"));
	}	
	/**
	 * 病历审签类型主键
	 * @param Id_mr_sign_type
	 */
	public void setId_mr_sign_type(String Id_mr_sign_type) {
		setAttrVal("Id_mr_sign_type", Id_mr_sign_type);
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
	 * 启用人
	 * @return String
	 */
	public String getId_active_user() {
		return ((String) getAttrVal("Id_active_user"));
	}	
	/**
	 * 启用人
	 * @param Id_active_user
	 */
	public void setId_active_user(String Id_active_user) {
		setAttrVal("Id_active_user", Id_active_user);
	}
	/**
	 * 启用时间
	 * @return String
	 */
	public String getDt_active() {
		return ((String) getAttrVal("Dt_active"));
	}	
	/**
	 * 启用时间
	 * @param Dt_active
	 */
	public void setDt_active(String Dt_active) {
		setAttrVal("Dt_active", Dt_active);
	}
	/**
	 * 停用人
	 * @return String
	 */
	public String getId_deactive() {
		return ((String) getAttrVal("Id_deactive"));
	}	
	/**
	 * 停用人
	 * @param Id_deactive
	 */
	public void setId_deactive(String Id_deactive) {
		setAttrVal("Id_deactive", Id_deactive);
	}
	/**
	 * 停用时间
	 * @return String
	 */
	public String getDt_deactive() {
		return ((String) getAttrVal("Dt_deactive"));
	}	
	/**
	 * 停用时间
	 * @param Dt_deactive
	 */
	public void setDt_deactive(String Dt_deactive) {
		setAttrVal("Dt_deactive", Dt_deactive);
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
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
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
		return "Id_mr_sign_type";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mr_sign_type";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdMrSignTypeDODesc.class);
	}
	
}