package iih.mp.orm.surginsmtmrtpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.orm.surginsmtmrtpl.d.desc.SurgInsmtMrtplDODesc;
import java.math.BigDecimal;

/**
 * 手术器械模板 DO数据 
 * 
 */
public class SurgInsmtMrtplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//模板主键id
	public static final String ID_MOMT= "Id_momt";
	//模板编码
	public static final String CODE= "Code";
	//模板名称
	public static final String NAME= "Name";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//适用科室列表
	public static final String ID_DEPTS= "Id_depts";
	//适用手术
	public static final String ID_SRVS= "Id_srvs";
	//启用
	public static final String FG_ATV= "Fg_atv";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//科室名称
	public static final String DEP_NAME= "Dep_name";
	//科室编码
	public static final String DEP_CODE= "Dep_code";
	//手术名称
	public static final String SRV_NAME= "Srv_name";
	//手术编码
	public static final String SRV_CODE= "Srv_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 模板主键id
	 * @return String
	 */
	public String getId_momt() {
		return ((String) getAttrVal("Id_momt"));
	}	
	/**
	 * 模板主键id
	 * @param Id_momt
	 */
	public void setId_momt(String Id_momt) {
		setAttrVal("Id_momt", Id_momt);
	}
	/**
	 * 模板编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 模板编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 模板名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 模板名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	/**
	 * 适用科室列表
	 * @return String
	 */
	public String getId_depts() {
		return ((String) getAttrVal("Id_depts"));
	}	
	/**
	 * 适用科室列表
	 * @param Id_depts
	 */
	public void setId_depts(String Id_depts) {
		setAttrVal("Id_depts", Id_depts);
	}
	/**
	 * 适用手术
	 * @return String
	 */
	public String getId_srvs() {
		return ((String) getAttrVal("Id_srvs"));
	}	
	/**
	 * 适用手术
	 * @param Id_srvs
	 */
	public void setId_srvs(String Id_srvs) {
		setAttrVal("Id_srvs", Id_srvs);
	}
	/**
	 * 启用
	 * @return FBoolean
	 */
	public FBoolean getFg_atv() {
		return ((FBoolean) getAttrVal("Fg_atv"));
	}	
	/**
	 * 启用
	 * @param Fg_atv
	 */
	public void setFg_atv(FBoolean Fg_atv) {
		setAttrVal("Fg_atv", Fg_atv);
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
	 * 科室名称
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	/**
	 * 科室名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getDep_code() {
		return ((String) getAttrVal("Dep_code"));
	}	
	/**
	 * 科室编码
	 * @param Dep_code
	 */
	public void setDep_code(String Dep_code) {
		setAttrVal("Dep_code", Dep_code);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 手术名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 手术编码
	 * @return String
	 */
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	/**
	 * 手术编码
	 * @param Srv_code
	 */
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
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
		return "Id_momt";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_ORM_MM_TMPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SurgInsmtMrtplDODesc.class);
	}
	
}