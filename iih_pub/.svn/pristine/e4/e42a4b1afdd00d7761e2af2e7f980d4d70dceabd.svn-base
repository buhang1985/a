package iih.bd.pp.accountsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.accountsrv.d.desc.AccountSrvDODesc;
import java.math.BigDecimal;

/**
 * 核算科目与收费项目的关联关系 DO数据 
 * 
 */
public class AccountSrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//会计核算分类与服务关联主键
	public static final String ID_ACCAVSSRV= "Id_accavssrv";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//服务项目主键
	public static final String ID_SRV= "Id_srv";
	//会计核算分类主键
	public static final String ID_ACCOUNTCA= "Id_accountca";
	//核算体系主键
	public static final String ID_ACCOUNT= "Id_account";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//服务编码
	public static final String CODE_SRV= "Code_srv";
	//服务名称
	public static final String NAME_SRV= "Name_srv";
	//编码
	public static final String CA_CODE= "Ca_code";
	//名称
	public static final String CA_NAME= "Ca_name";
	//编码
	public static final String ACC_CODE= "Acc_code";
	//名称
	public static final String ACC_NAME= "Acc_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 会计核算分类与服务关联主键
	 * @return String
	 */
	public String getId_accavssrv() {
		return ((String) getAttrVal("Id_accavssrv"));
	}	
	/**
	 * 会计核算分类与服务关联主键
	 * @param Id_accavssrv
	 */
	public void setId_accavssrv(String Id_accavssrv) {
		setAttrVal("Id_accavssrv", Id_accavssrv);
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
	 * 服务项目主键
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务项目主键
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 会计核算分类主键
	 * @return String
	 */
	public String getId_accountca() {
		return ((String) getAttrVal("Id_accountca"));
	}	
	/**
	 * 会计核算分类主键
	 * @param Id_accountca
	 */
	public void setId_accountca(String Id_accountca) {
		setAttrVal("Id_accountca", Id_accountca);
	}
	/**
	 * 核算体系主键
	 * @return String
	 */
	public String getId_account() {
		return ((String) getAttrVal("Id_account"));
	}	
	/**
	 * 核算体系主键
	 * @param Id_account
	 */
	public void setId_account(String Id_account) {
		setAttrVal("Id_account", Id_account);
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
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCa_code() {
		return ((String) getAttrVal("Ca_code"));
	}	
	/**
	 * 编码
	 * @param Ca_code
	 */
	public void setCa_code(String Ca_code) {
		setAttrVal("Ca_code", Ca_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCa_name() {
		return ((String) getAttrVal("Ca_name"));
	}	
	/**
	 * 名称
	 * @param Ca_name
	 */
	public void setCa_name(String Ca_name) {
		setAttrVal("Ca_name", Ca_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getAcc_code() {
		return ((String) getAttrVal("Acc_code"));
	}	
	/**
	 * 编码
	 * @param Acc_code
	 */
	public void setAcc_code(String Acc_code) {
		setAttrVal("Acc_code", Acc_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAcc_name() {
		return ((String) getAttrVal("Acc_name"));
	}	
	/**
	 * 名称
	 * @param Acc_name
	 */
	public void setAcc_name(String Acc_name) {
		setAttrVal("Acc_name", Acc_name);
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
		return "Id_accavssrv";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_ACCOUNT_CA_VS_SRV";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AccountSrvDODesc.class);
	}
	
}