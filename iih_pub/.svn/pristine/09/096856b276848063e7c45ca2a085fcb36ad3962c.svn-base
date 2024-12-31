package iih.syn.common.init.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.syn.common.init.d.desc.SynInitTableDODesc;
import java.math.BigDecimal;

/**
 * 初始化表 DO数据 
 * 
 */
public class SynInitTableDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//初始化表
	public static final String ID_INIT_TABLE= "Id_init_table";
	//初始化ID
	public static final String ID_INIT= "Id_init";
	//序号
	public static final String SORTNO= "Sortno";
	//描述
	public static final String NOTE= "Note";
	//实体名称
	public static final String NAME_CLASS= "Name_class";
	//实体全路径
	public static final String NAME_FULL_CLASS= "Name_full_class";
	//是否全表初始化
	public static final String FG_FULL_TABLE= "Fg_full_table";
	//基础条件
	public static final String BASE_COND= "Base_cond";
	//查询条件
	public static final String COND= "Cond";
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
	 * 初始化表
	 * @return String
	 */
	public String getId_init_table() {
		return ((String) getAttrVal("Id_init_table"));
	}	
	/**
	 * 初始化表
	 * @param Id_init_table
	 */
	public void setId_init_table(String Id_init_table) {
		setAttrVal("Id_init_table", Id_init_table);
	}
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
	 * 实体名称
	 * @return String
	 */
	public String getName_class() {
		return ((String) getAttrVal("Name_class"));
	}	
	/**
	 * 实体名称
	 * @param Name_class
	 */
	public void setName_class(String Name_class) {
		setAttrVal("Name_class", Name_class);
	}
	/**
	 * 实体全路径
	 * @return String
	 */
	public String getName_full_class() {
		return ((String) getAttrVal("Name_full_class"));
	}	
	/**
	 * 实体全路径
	 * @param Name_full_class
	 */
	public void setName_full_class(String Name_full_class) {
		setAttrVal("Name_full_class", Name_full_class);
	}
	/**
	 * 是否全表初始化
	 * @return FBoolean
	 */
	public FBoolean getFg_full_table() {
		return ((FBoolean) getAttrVal("Fg_full_table"));
	}	
	/**
	 * 是否全表初始化
	 * @param Fg_full_table
	 */
	public void setFg_full_table(FBoolean Fg_full_table) {
		setAttrVal("Fg_full_table", Fg_full_table);
	}
	/**
	 * 基础条件
	 * @return String
	 */
	public String getBase_cond() {
		return ((String) getAttrVal("Base_cond"));
	}	
	/**
	 * 基础条件
	 * @param Base_cond
	 */
	public void setBase_cond(String Base_cond) {
		setAttrVal("Base_cond", Base_cond);
	}
	/**
	 * 查询条件
	 * @return String
	 */
	public String getCond() {
		return ((String) getAttrVal("Cond"));
	}	
	/**
	 * 查询条件
	 * @param Cond
	 */
	public void setCond(String Cond) {
		setAttrVal("Cond", Cond);
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
		return "Id_init_table";
	}
	
	@Override
	public String getTableName() {	  
		return "syn_init_table";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SynInitTableDODesc.class);
	}
	
}