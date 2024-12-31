package iih.pe.por.pecorpbinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pecorpbinfo.d.desc.PeCorpDeptDODesc;
import java.math.BigDecimal;

/**
 * 体检团体部门 DO数据 
 * 
 */
public class PeCorpDeptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检团体部门主键标识
	public static final String ID_PECORPDEPT= "Id_pecorpdept";
	//体检团体部门父主键
	public static final String ID_PECORPDEPT_PAR= "Id_pecorpdept_par";
	//体检团体ID
	public static final String ID_PECORPBINFO= "Id_pecorpbinfo";
	//部门编码
	public static final String CODE= "Code";
	//部门名称
	public static final String NAME= "Name";
	//是否有效
	public static final String FG_ACTIVE= "Fg_active";
	//备注
	public static final String NOTE= "Note";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//部门编码
	public static final String CODE_DEPT= "Code_dept";
	//部门名称
	public static final String NAME_DEPT= "Name_dept";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检团体部门主键标识
	 * @return String
	 */
	public String getId_pecorpdept() {
		return ((String) getAttrVal("Id_pecorpdept"));
	}	
	/**
	 * 体检团体部门主键标识
	 * @param Id_pecorpdept
	 */
	public void setId_pecorpdept(String Id_pecorpdept) {
		setAttrVal("Id_pecorpdept", Id_pecorpdept);
	}
	/**
	 * 体检团体部门父主键
	 * @return String
	 */
	public String getId_pecorpdept_par() {
		return ((String) getAttrVal("Id_pecorpdept_par"));
	}	
	/**
	 * 体检团体部门父主键
	 * @param Id_pecorpdept_par
	 */
	public void setId_pecorpdept_par(String Id_pecorpdept_par) {
		setAttrVal("Id_pecorpdept_par", Id_pecorpdept_par);
	}
	/**
	 * 体检团体ID
	 * @return String
	 */
	public String getId_pecorpbinfo() {
		return ((String) getAttrVal("Id_pecorpbinfo"));
	}	
	/**
	 * 体检团体ID
	 * @param Id_pecorpbinfo
	 */
	public void setId_pecorpbinfo(String Id_pecorpbinfo) {
		setAttrVal("Id_pecorpbinfo", Id_pecorpbinfo);
	}
	/**
	 * 部门编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 部门编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 部门名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 部门名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 是否有效
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否有效
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	 * 部门编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	/**
	 * 部门编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 部门名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 部门名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
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
		return "Id_pecorpdept";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pecorpdept";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeCorpDeptDODesc.class);
	}
	
}