package iih.bd.pp.opmutextset.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.opmutextset.d.desc.BdOpMutextSetDODesc;
import java.math.BigDecimal;

/**
 * 门诊调入互斥配置 DO数据 
 * 
 */
public class BdOpMutextSetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//门诊互斥id
	public static final String ID_MUTEX= "Id_mutex";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//配置类型
	public static final String EU_SETTP= "Eu_settp";
	//序号
	public static final String SORTNO= "Sortno";
	//互斥属性id
	public static final String ID_MUTEX_PROPERTY= "Id_mutex_property";
	//互斥属性编码
	public static final String CODE_MUTEX_PROPERTY= "Code_mutex_property";
	//显示属性编码
	public static final String CODE_DISPLAY_PROPERTY= "Code_display_property";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//互斥编码
	public static final String CODE_MUTEX= "Code_mutex";
	//互斥名称
	public static final String NAME_MUTEX= "Name_mutex";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 门诊互斥id
	 * @return String
	 */
	public String getId_mutex() {
		return ((String) getAttrVal("Id_mutex"));
	}	
	/**
	 * 门诊互斥id
	 * @param Id_mutex
	 */
	public void setId_mutex(String Id_mutex) {
		setAttrVal("Id_mutex", Id_mutex);
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
	 * 配置类型
	 * @return String
	 */
	public String getEu_settp() {
		return ((String) getAttrVal("Eu_settp"));
	}	
	/**
	 * 配置类型
	 * @param Eu_settp
	 */
	public void setEu_settp(String Eu_settp) {
		setAttrVal("Eu_settp", Eu_settp);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 互斥属性id
	 * @return String
	 */
	public String getId_mutex_property() {
		return ((String) getAttrVal("Id_mutex_property"));
	}	
	/**
	 * 互斥属性id
	 * @param Id_mutex_property
	 */
	public void setId_mutex_property(String Id_mutex_property) {
		setAttrVal("Id_mutex_property", Id_mutex_property);
	}
	/**
	 * 互斥属性编码
	 * @return String
	 */
	public String getCode_mutex_property() {
		return ((String) getAttrVal("Code_mutex_property"));
	}	
	/**
	 * 互斥属性编码
	 * @param Code_mutex_property
	 */
	public void setCode_mutex_property(String Code_mutex_property) {
		setAttrVal("Code_mutex_property", Code_mutex_property);
	}
	/**
	 * 显示属性编码
	 * @return String
	 */
	public String getCode_display_property() {
		return ((String) getAttrVal("Code_display_property"));
	}	
	/**
	 * 显示属性编码
	 * @param Code_display_property
	 */
	public void setCode_display_property(String Code_display_property) {
		setAttrVal("Code_display_property", Code_display_property);
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
	 * 互斥编码
	 * @return String
	 */
	public String getCode_mutex() {
		return ((String) getAttrVal("Code_mutex"));
	}	
	/**
	 * 互斥编码
	 * @param Code_mutex
	 */
	public void setCode_mutex(String Code_mutex) {
		setAttrVal("Code_mutex", Code_mutex);
	}
	/**
	 * 互斥名称
	 * @return String
	 */
	public String getName_mutex() {
		return ((String) getAttrVal("Name_mutex"));
	}	
	/**
	 * 互斥名称
	 * @param Name_mutex
	 */
	public void setName_mutex(String Name_mutex) {
		setAttrVal("Name_mutex", Name_mutex);
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
		return "Id_mutex";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_opmutex_set";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdOpMutextSetDODesc.class);
	}
	
}