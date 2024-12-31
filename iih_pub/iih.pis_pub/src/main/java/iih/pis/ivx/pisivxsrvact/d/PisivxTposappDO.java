package iih.pis.ivx.pisivxsrvact.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxsrvact.d.desc.PisivxTposappDODesc;
import java.math.BigDecimal;

/**
 * 第三方应用 DO数据 
 * 
 */
public class PisivxTposappDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//应用标识
	public static final String ID_IVX_TPOSAPP= "Id_ivx_tposapp";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//名称
	public static final String NAME= "Name";
	//编码
	public static final String CODE= "Code";
	//账号id
	public static final String ID_TPOSAPP= "Id_tposapp";
	//账号密码
	public static final String PWD_TPOSAPP= "Pwd_tposapp";
	//应用地址
	public static final String URL_TPOSAPP= "Url_tposapp";
	//默认参数1
	public static final String PARAM1= "Param1";
	//默认参数2
	public static final String PARAM2= "Param2";
	//微信服务号外键
	public static final String ID_IVX_SRVACT= "Id_ivx_srvact";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_GRP= "Name_grp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 应用标识
	 * @return String
	 */
	public String getId_ivx_tposapp() {
		return ((String) getAttrVal("Id_ivx_tposapp"));
	}	
	/**
	 * 应用标识
	 * @param Id_ivx_tposapp
	 */
	public void setId_ivx_tposapp(String Id_ivx_tposapp) {
		setAttrVal("Id_ivx_tposapp", Id_ivx_tposapp);
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
	 * 账号id
	 * @return String
	 */
	public String getId_tposapp() {
		return ((String) getAttrVal("Id_tposapp"));
	}	
	/**
	 * 账号id
	 * @param Id_tposapp
	 */
	public void setId_tposapp(String Id_tposapp) {
		setAttrVal("Id_tposapp", Id_tposapp);
	}
	/**
	 * 账号密码
	 * @return String
	 */
	public String getPwd_tposapp() {
		return ((String) getAttrVal("Pwd_tposapp"));
	}	
	/**
	 * 账号密码
	 * @param Pwd_tposapp
	 */
	public void setPwd_tposapp(String Pwd_tposapp) {
		setAttrVal("Pwd_tposapp", Pwd_tposapp);
	}
	/**
	 * 应用地址
	 * @return String
	 */
	public String getUrl_tposapp() {
		return ((String) getAttrVal("Url_tposapp"));
	}	
	/**
	 * 应用地址
	 * @param Url_tposapp
	 */
	public void setUrl_tposapp(String Url_tposapp) {
		setAttrVal("Url_tposapp", Url_tposapp);
	}
	/**
	 * 默认参数1
	 * @return String
	 */
	public String getParam1() {
		return ((String) getAttrVal("Param1"));
	}	
	/**
	 * 默认参数1
	 * @param Param1
	 */
	public void setParam1(String Param1) {
		setAttrVal("Param1", Param1);
	}
	/**
	 * 默认参数2
	 * @return String
	 */
	public String getParam2() {
		return ((String) getAttrVal("Param2"));
	}	
	/**
	 * 默认参数2
	 * @param Param2
	 */
	public void setParam2(String Param2) {
		setAttrVal("Param2", Param2);
	}
	/**
	 * 微信服务号外键
	 * @return String
	 */
	public String getId_ivx_srvact() {
		return ((String) getAttrVal("Id_ivx_srvact"));
	}	
	/**
	 * 微信服务号外键
	 * @param Id_ivx_srvact
	 */
	public void setId_ivx_srvact(String Id_ivx_srvact) {
		setAttrVal("Id_ivx_srvact", Id_ivx_srvact);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
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
		return "Id_ivx_tposapp";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_tposapp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisivxTposappDODesc.class);
	}
	
}