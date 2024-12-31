package iih.ems.embd.emgeca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.embd.emgeca.d.desc.EmGeCaDODesc;
import java.math.BigDecimal;

/**
 * 计量分类 DO数据 
 * 
 */
public class EmGeCaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//计量分类主键
	public static final String ID_GECA= "Id_geca";
	//父级ID
	public static final String ID_PARENT= "Id_parent";
	//编码
	public static final String CODE= "Code";
	//父级编码
	public static final String PCODE= "Pcode";
	//名称
	public static final String NAME= "Name";
	//计量周期
	public static final String GAUGE_CYC= "Gauge_cyc";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//是否末级
	public static final String FG_LEAF= "Fg_leaf";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记码
	public static final String MNSCODE= "Mnscode";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String PNAME= "Pname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 计量分类主键
	 * @return String
	 */
	public String getId_geca() {
		return ((String) getAttrVal("Id_geca"));
	}	
	/**
	 * 计量分类主键
	 * @param Id_geca
	 */
	public void setId_geca(String Id_geca) {
		setAttrVal("Id_geca", Id_geca);
	}
	/**
	 * 父级ID
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	/**
	 * 父级ID
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
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
	 * 父级编码
	 * @return String
	 */
	public String getPcode() {
		return ((String) getAttrVal("Pcode"));
	}	
	/**
	 * 父级编码
	 * @param Pcode
	 */
	public void setPcode(String Pcode) {
		setAttrVal("Pcode", Pcode);
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
	 * 计量周期
	 * @return Integer
	 */
	public Integer getGauge_cyc() {
		return ((Integer) getAttrVal("Gauge_cyc"));
	}	
	/**
	 * 计量周期
	 * @param Gauge_cyc
	 */
	public void setGauge_cyc(Integer Gauge_cyc) {
		setAttrVal("Gauge_cyc", Gauge_cyc);
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
	 * 是否末级
	 * @return FBoolean
	 */
	public FBoolean getFg_leaf() {
		return ((FBoolean) getAttrVal("Fg_leaf"));
	}	
	/**
	 * 是否末级
	 * @param Fg_leaf
	 */
	public void setFg_leaf(FBoolean Fg_leaf) {
		setAttrVal("Fg_leaf", Fg_leaf);
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
	public String getMnscode() {
		return ((String) getAttrVal("Mnscode"));
	}	
	/**
	 * 助记码
	 * @param Mnscode
	 */
	public void setMnscode(String Mnscode) {
		setAttrVal("Mnscode", Mnscode);
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
	 * 名称
	 * @return String
	 */
	public String getPname() {
		return ((String) getAttrVal("Pname"));
	}	
	/**
	 * 名称
	 * @param Pname
	 */
	public void setPname(String Pname) {
		setAttrVal("Pname", Pname);
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
		return "Id_geca";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_geca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmGeCaDODesc.class);
	}
	
}