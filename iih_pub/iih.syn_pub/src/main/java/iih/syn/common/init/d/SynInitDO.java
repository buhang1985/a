package iih.syn.common.init.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.syn.common.init.d.desc.SynInitDODesc;
import java.math.BigDecimal;

/**
 * 基础数据初始化 DO数据 
 * 
 */
public class SynInitDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//初始化ID
	public static final String ID_INIT= "Id_init";
	//名称
	public static final String NAME= "Name";
	//初始化分类
	public static final String ID_INIT_CA= "Id_init_ca";
	//描述
	public static final String NOTE= "Note";
	//逐条初始化
	public static final String FG_SINGLE= "Fg_single";
	//依据实体
	public static final String NAME_BAS_TABLE= "Name_bas_table";
	//键属性名称
	public static final String NAME_BAS_ATTR= "Name_bas_attr";
	//名称属性名称
	public static final String NAME_ATTR= "Name_attr";
	//编码属性名称
	public static final String CODE_ATTR= "Code_attr";
	//描述属性名称
	public static final String DES_ATTR= "Des_attr";
	//条件
	public static final String WHERE_COND= "Where_cond";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
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
	 * 初始化ID
	 * @return String
	 */
	public String getId_init() {
		return ((String) getAttrVal("Id_init"));
	}	
	/**
	 * 初始化ID
	 * @param Id_init
	 */
	public void setId_init(String Id_init) {
		setAttrVal("Id_init", Id_init);
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
	 * 初始化分类
	 * @return String
	 */
	public String getId_init_ca() {
		return ((String) getAttrVal("Id_init_ca"));
	}	
	/**
	 * 初始化分类
	 * @param Id_init_ca
	 */
	public void setId_init_ca(String Id_init_ca) {
		setAttrVal("Id_init_ca", Id_init_ca);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 描述
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 逐条初始化
	 * @return FBoolean
	 */
	public FBoolean getFg_single() {
		return ((FBoolean) getAttrVal("Fg_single"));
	}	
	/**
	 * 逐条初始化
	 * @param Fg_single
	 */
	public void setFg_single(FBoolean Fg_single) {
		setAttrVal("Fg_single", Fg_single);
	}
	/**
	 * 依据实体
	 * @return String
	 */
	public String getName_bas_table() {
		return ((String) getAttrVal("Name_bas_table"));
	}	
	/**
	 * 依据实体
	 * @param Name_bas_table
	 */
	public void setName_bas_table(String Name_bas_table) {
		setAttrVal("Name_bas_table", Name_bas_table);
	}
	/**
	 * 键属性名称
	 * @return String
	 */
	public String getName_bas_attr() {
		return ((String) getAttrVal("Name_bas_attr"));
	}	
	/**
	 * 键属性名称
	 * @param Name_bas_attr
	 */
	public void setName_bas_attr(String Name_bas_attr) {
		setAttrVal("Name_bas_attr", Name_bas_attr);
	}
	/**
	 * 名称属性名称
	 * @return String
	 */
	public String getName_attr() {
		return ((String) getAttrVal("Name_attr"));
	}	
	/**
	 * 名称属性名称
	 * @param Name_attr
	 */
	public void setName_attr(String Name_attr) {
		setAttrVal("Name_attr", Name_attr);
	}
	/**
	 * 编码属性名称
	 * @return String
	 */
	public String getCode_attr() {
		return ((String) getAttrVal("Code_attr"));
	}	
	/**
	 * 编码属性名称
	 * @param Code_attr
	 */
	public void setCode_attr(String Code_attr) {
		setAttrVal("Code_attr", Code_attr);
	}
	/**
	 * 描述属性名称
	 * @return String
	 */
	public String getDes_attr() {
		return ((String) getAttrVal("Des_attr"));
	}	
	/**
	 * 描述属性名称
	 * @param Des_attr
	 */
	public void setDes_attr(String Des_attr) {
		setAttrVal("Des_attr", Des_attr);
	}
	/**
	 * 条件
	 * @return String
	 */
	public String getWhere_cond() {
		return ((String) getAttrVal("Where_cond"));
	}	
	/**
	 * 条件
	 * @param Where_cond
	 */
	public void setWhere_cond(String Where_cond) {
		setAttrVal("Where_cond", Where_cond);
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
		return "Id_init";
	}
	
	@Override
	public String getTableName() {	  
		return "syn_init";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SynInitDODesc.class);
	}
	
}