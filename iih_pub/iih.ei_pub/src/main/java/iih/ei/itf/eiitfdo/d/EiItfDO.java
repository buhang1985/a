package iih.ei.itf.eiitfdo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ei.itf.eiitfdo.d.desc.EiItfDODesc;
import java.math.BigDecimal;

/**
 * 接口注册 DO数据 
 * 
 */
public class EiItfDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//接口id
	public static final String ID_ITF= "Id_itf";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//服务名
	public static final String SERVICENAME= "Servicename";
	//方法名
	public static final String METHODNAME= "Methodname";
	//系统标识
	public static final String FG_SYS= "Fg_sys";
	//序列化类型
	public static final String EU_SERIALIZE= "Eu_serialize";
	//序列化标识
	public static final String FG_SERIALIZE= "Fg_serialize";
	//调用频率
	public static final String CALL_RATE= "Call_rate";
	//详细说明
	public static final String DES= "Des";
	//服务全路径
	public static final String FULLNAME= "Fullname";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//客户扩展字段1
	public static final String DEF1= "Def1";
	//客户扩展字段2
	public static final String DEF2= "Def2";
	//客户扩展字段3
	public static final String DEF3= "Def3";
	//客户扩展字段4
	public static final String DEF4= "Def4";
	//客户扩展字段5
	public static final String DEF5= "Def5";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//是否打印日志
	public static final String FG_PRINTLOG= "Fg_printlog";
	//是否启用事务
	public static final String FG_AFFAIRS= "Fg_affairs";
	//所属模块
	public static final String ID_MODUL= "Id_modul";
	//版本号
	public static final String VERSION= "Version";
	//分页标志
	public static final String FG_PAGING= "Fg_paging";
	//名称
	public static final String NAME_MODUL= "Name_modul";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 接口id
	 * @return String
	 */
	public String getId_itf() {
		return ((String) getAttrVal("Id_itf"));
	}	
	/**
	 * 接口id
	 * @param Id_itf
	 */
	public void setId_itf(String Id_itf) {
		setAttrVal("Id_itf", Id_itf);
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
	 * 服务名
	 * @return String
	 */
	public String getServicename() {
		return ((String) getAttrVal("Servicename"));
	}	
	/**
	 * 服务名
	 * @param Servicename
	 */
	public void setServicename(String Servicename) {
		setAttrVal("Servicename", Servicename);
	}
	/**
	 * 方法名
	 * @return String
	 */
	public String getMethodname() {
		return ((String) getAttrVal("Methodname"));
	}	
	/**
	 * 方法名
	 * @param Methodname
	 */
	public void setMethodname(String Methodname) {
		setAttrVal("Methodname", Methodname);
	}
	/**
	 * 系统标识
	 * @return FBoolean
	 */
	public FBoolean getFg_sys() {
		return ((FBoolean) getAttrVal("Fg_sys"));
	}	
	/**
	 * 系统标识
	 * @param Fg_sys
	 */
	public void setFg_sys(FBoolean Fg_sys) {
		setAttrVal("Fg_sys", Fg_sys);
	}
	/**
	 * 序列化类型
	 * @return String
	 */
	public String getEu_serialize() {
		return ((String) getAttrVal("Eu_serialize"));
	}	
	/**
	 * 序列化类型
	 * @param Eu_serialize
	 */
	public void setEu_serialize(String Eu_serialize) {
		setAttrVal("Eu_serialize", Eu_serialize);
	}
	/**
	 * 序列化标识
	 * @return FBoolean
	 */
	public FBoolean getFg_serialize() {
		return ((FBoolean) getAttrVal("Fg_serialize"));
	}	
	/**
	 * 序列化标识
	 * @param Fg_serialize
	 */
	public void setFg_serialize(FBoolean Fg_serialize) {
		setAttrVal("Fg_serialize", Fg_serialize);
	}
	/**
	 * 调用频率
	 * @return String
	 */
	public String getCall_rate() {
		return ((String) getAttrVal("Call_rate"));
	}	
	/**
	 * 调用频率
	 * @param Call_rate
	 */
	public void setCall_rate(String Call_rate) {
		setAttrVal("Call_rate", Call_rate);
	}
	/**
	 * 详细说明
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 详细说明
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 服务全路径
	 * @return String
	 */
	public String getFullname() {
		return ((String) getAttrVal("Fullname"));
	}	
	/**
	 * 服务全路径
	 * @param Fullname
	 */
	public void setFullname(String Fullname) {
		setAttrVal("Fullname", Fullname);
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
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
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
	 * 是否打印日志
	 * @return FBoolean
	 */
	public FBoolean getFg_printlog() {
		return ((FBoolean) getAttrVal("Fg_printlog"));
	}	
	/**
	 * 是否打印日志
	 * @param Fg_printlog
	 */
	public void setFg_printlog(FBoolean Fg_printlog) {
		setAttrVal("Fg_printlog", Fg_printlog);
	}
	/**
	 * 是否启用事务
	 * @return FBoolean
	 */
	public FBoolean getFg_affairs() {
		return ((FBoolean) getAttrVal("Fg_affairs"));
	}	
	/**
	 * 是否启用事务
	 * @param Fg_affairs
	 */
	public void setFg_affairs(FBoolean Fg_affairs) {
		setAttrVal("Fg_affairs", Fg_affairs);
	}
	/**
	 * 所属模块
	 * @return String
	 */
	public String getId_modul() {
		return ((String) getAttrVal("Id_modul"));
	}	
	/**
	 * 所属模块
	 * @param Id_modul
	 */
	public void setId_modul(String Id_modul) {
		setAttrVal("Id_modul", Id_modul);
	}
	/**
	 * 版本号
	 * @return Integer
	 */
	public Integer getVersion() {
		return ((Integer) getAttrVal("Version"));
	}	
	/**
	 * 版本号
	 * @param Version
	 */
	public void setVersion(Integer Version) {
		setAttrVal("Version", Version);
	}
	/**
	 * 分页标志
	 * @return FBoolean
	 */
	public FBoolean getFg_paging() {
		return ((FBoolean) getAttrVal("Fg_paging"));
	}	
	/**
	 * 分页标志
	 * @param Fg_paging
	 */
	public void setFg_paging(FBoolean Fg_paging) {
		setAttrVal("Fg_paging", Fg_paging);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_modul() {
		return ((String) getAttrVal("Name_modul"));
	}	
	/**
	 * 名称
	 * @param Name_modul
	 */
	public void setName_modul(String Name_modul) {
		setAttrVal("Name_modul", Name_modul);
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
		return "Id_itf";
	}
	
	@Override
	public String getTableName() {	  
		return "ei_itf";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EiItfDODesc.class);
	}
	
}