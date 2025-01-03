package iih.bd.srv.reportcardtpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.reportcardtpl.d.desc.ReportCardTplDoDesc;
import java.math.BigDecimal;

/**
 * 报卡模板 DO数据 
 * 
 */
public class ReportCardTplDo extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_BD_RCM_TPL= "Id_bd_rcm_tpl";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//名称
	public static final String NAME= "Name";
	//编码
	public static final String CODE= "Code";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//拼音码
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//备注
	public static final String DES= "Des";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
	//编辑器主键
	public static final String ID_MRED= "Id_mred";
	//编辑器编码
	public static final String MRED_CODE= "Mred_code";
	//编辑器名称
	public static final String MRED_NAME= "Mred_name";
	//编辑器启动函数
	public static final String MRED_FUNCEDITOR= "Mred_funceditor";
	//编辑器反射生成类
	public static final String MRED_NAMECLASS= "Mred_nameclass";
	//编辑器反射生成dll名称
	public static final String MRED_DLLPATH= "Mred_dllpath";
	//是否需要审签
	public static final String FG_SIGN= "Fg_sign";
	//审签的用户
	public static final String ID_SIGN= "Id_sign";
	//是否匿名上报
	public static final String ISHIDENAME= "Ishidename";
	//审签用户编码
	public static final String SD_SIGN= "Sd_sign";
	//审签用户名称
	public static final String NAME_SIGN= "Name_sign";
	//存贮模式
	public static final String SAVEMODEL= "Savemodel";
	//存贮模式编码
	public static final String SD_SAVEMODEL= "Sd_savemodel";
	//存贮模式名称
	public static final String NAME_SAVEMODEL= "Name_savemodel";
	//报卡类型主键
	public static final String ID_BD_RCM_TP= "Id_bd_rcm_tp";
	//报卡类型名称
	public static final String NAME_BD_RCM_TP= "Name_bd_rcm_tp";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//默认模板
	public static final String FG_DEF= "Fg_def";
	//用户名称
	public static final String SIGN_USER_NAME= "Sign_user_name";
	//用户编码
	public static final String SIGN_USER_CODE= "Sign_user_code";
	//编码
	public static final String SAVEMODEL_CODE= "Savemodel_code";
	//名称
	public static final String SAVEMODEL_NAME= "Savemodel_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_bd_rcm_tpl() {
		return ((String) getAttrVal("Id_bd_rcm_tpl"));
	}	
	/**
	 * 主键
	 * @param Id_bd_rcm_tpl
	 */
	public void setId_bd_rcm_tpl(String Id_bd_rcm_tpl) {
		setAttrVal("Id_bd_rcm_tpl", Id_bd_rcm_tpl);
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
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
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
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 编辑器主键
	 * @return String
	 */
	public String getId_mred() {
		return ((String) getAttrVal("Id_mred"));
	}	
	/**
	 * 编辑器主键
	 * @param Id_mred
	 */
	public void setId_mred(String Id_mred) {
		setAttrVal("Id_mred", Id_mred);
	}
	/**
	 * 编辑器编码
	 * @return String
	 */
	public String getMred_code() {
		return ((String) getAttrVal("Mred_code"));
	}	
	/**
	 * 编辑器编码
	 * @param Mred_code
	 */
	public void setMred_code(String Mred_code) {
		setAttrVal("Mred_code", Mred_code);
	}
	/**
	 * 编辑器名称
	 * @return String
	 */
	public String getMred_name() {
		return ((String) getAttrVal("Mred_name"));
	}	
	/**
	 * 编辑器名称
	 * @param Mred_name
	 */
	public void setMred_name(String Mred_name) {
		setAttrVal("Mred_name", Mred_name);
	}
	/**
	 * 编辑器启动函数
	 * @return String
	 */
	public String getMred_funceditor() {
		return ((String) getAttrVal("Mred_funceditor"));
	}	
	/**
	 * 编辑器启动函数
	 * @param Mred_funceditor
	 */
	public void setMred_funceditor(String Mred_funceditor) {
		setAttrVal("Mred_funceditor", Mred_funceditor);
	}
	/**
	 * 编辑器反射生成类
	 * @return String
	 */
	public String getMred_nameclass() {
		return ((String) getAttrVal("Mred_nameclass"));
	}	
	/**
	 * 编辑器反射生成类
	 * @param Mred_nameclass
	 */
	public void setMred_nameclass(String Mred_nameclass) {
		setAttrVal("Mred_nameclass", Mred_nameclass);
	}
	/**
	 * 编辑器反射生成dll名称
	 * @return String
	 */
	public String getMred_dllpath() {
		return ((String) getAttrVal("Mred_dllpath"));
	}	
	/**
	 * 编辑器反射生成dll名称
	 * @param Mred_dllpath
	 */
	public void setMred_dllpath(String Mred_dllpath) {
		setAttrVal("Mred_dllpath", Mred_dllpath);
	}
	/**
	 * 是否需要审签
	 * @return FBoolean
	 */
	public FBoolean getFg_sign() {
		return ((FBoolean) getAttrVal("Fg_sign"));
	}	
	/**
	 * 是否需要审签
	 * @param Fg_sign
	 */
	public void setFg_sign(FBoolean Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
	}
	/**
	 * 审签的用户
	 * @return String
	 */
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	/**
	 * 审签的用户
	 * @param Id_sign
	 */
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
	}
	/**
	 * 是否匿名上报
	 * @return FBoolean
	 */
	public FBoolean getIshidename() {
		return ((FBoolean) getAttrVal("Ishidename"));
	}	
	/**
	 * 是否匿名上报
	 * @param Ishidename
	 */
	public void setIshidename(FBoolean Ishidename) {
		setAttrVal("Ishidename", Ishidename);
	}
	/**
	 * 审签用户编码
	 * @return String
	 */
	public String getSd_sign() {
		return ((String) getAttrVal("Sd_sign"));
	}	
	/**
	 * 审签用户编码
	 * @param Sd_sign
	 */
	public void setSd_sign(String Sd_sign) {
		setAttrVal("Sd_sign", Sd_sign);
	}
	/**
	 * 审签用户名称
	 * @return String
	 */
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	/**
	 * 审签用户名称
	 * @param Name_sign
	 */
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
	}
	/**
	 * 存贮模式
	 * @return String
	 */
	public String getSavemodel() {
		return ((String) getAttrVal("Savemodel"));
	}	
	/**
	 * 存贮模式
	 * @param Savemodel
	 */
	public void setSavemodel(String Savemodel) {
		setAttrVal("Savemodel", Savemodel);
	}
	/**
	 * 存贮模式编码
	 * @return String
	 */
	public String getSd_savemodel() {
		return ((String) getAttrVal("Sd_savemodel"));
	}	
	/**
	 * 存贮模式编码
	 * @param Sd_savemodel
	 */
	public void setSd_savemodel(String Sd_savemodel) {
		setAttrVal("Sd_savemodel", Sd_savemodel);
	}
	/**
	 * 存贮模式名称
	 * @return String
	 */
	public String getName_savemodel() {
		return ((String) getAttrVal("Name_savemodel"));
	}	
	/**
	 * 存贮模式名称
	 * @param Name_savemodel
	 */
	public void setName_savemodel(String Name_savemodel) {
		setAttrVal("Name_savemodel", Name_savemodel);
	}
	/**
	 * 报卡类型主键
	 * @return String
	 */
	public String getId_bd_rcm_tp() {
		return ((String) getAttrVal("Id_bd_rcm_tp"));
	}	
	/**
	 * 报卡类型主键
	 * @param Id_bd_rcm_tp
	 */
	public void setId_bd_rcm_tp(String Id_bd_rcm_tp) {
		setAttrVal("Id_bd_rcm_tp", Id_bd_rcm_tp);
	}
	/**
	 * 报卡类型名称
	 * @return String
	 */
	public String getName_bd_rcm_tp() {
		return ((String) getAttrVal("Name_bd_rcm_tp"));
	}	
	/**
	 * 报卡类型名称
	 * @param Name_bd_rcm_tp
	 */
	public void setName_bd_rcm_tp(String Name_bd_rcm_tp) {
		setAttrVal("Name_bd_rcm_tp", Name_bd_rcm_tp);
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
	 * 默认模板
	 * @return FBoolean
	 */
	public FBoolean getFg_def() {
		return ((FBoolean) getAttrVal("Fg_def"));
	}	
	/**
	 * 默认模板
	 * @param Fg_def
	 */
	public void setFg_def(FBoolean Fg_def) {
		setAttrVal("Fg_def", Fg_def);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getSign_user_name() {
		return ((String) getAttrVal("Sign_user_name"));
	}	
	/**
	 * 用户名称
	 * @param Sign_user_name
	 */
	public void setSign_user_name(String Sign_user_name) {
		setAttrVal("Sign_user_name", Sign_user_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getSign_user_code() {
		return ((String) getAttrVal("Sign_user_code"));
	}	
	/**
	 * 用户编码
	 * @param Sign_user_code
	 */
	public void setSign_user_code(String Sign_user_code) {
		setAttrVal("Sign_user_code", Sign_user_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSavemodel_code() {
		return ((String) getAttrVal("Savemodel_code"));
	}	
	/**
	 * 编码
	 * @param Savemodel_code
	 */
	public void setSavemodel_code(String Savemodel_code) {
		setAttrVal("Savemodel_code", Savemodel_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSavemodel_name() {
		return ((String) getAttrVal("Savemodel_name"));
	}	
	/**
	 * 名称
	 * @param Savemodel_name
	 */
	public void setSavemodel_name(String Savemodel_name) {
		setAttrVal("Savemodel_name", Savemodel_name);
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
		return "Id_bd_rcm_tpl";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_rcm_tpl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ReportCardTplDoDesc.class);
	}
	
}