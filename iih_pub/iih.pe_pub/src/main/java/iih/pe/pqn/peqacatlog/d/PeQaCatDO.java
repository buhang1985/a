package iih.pe.pqn.peqacatlog.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peqacatlog.d.desc.PeQaCatDODesc;
import java.math.BigDecimal;

/**
 * 体检问卷问题分组 DO数据 
 * 
 */
public class PeQaCatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检问卷问题分组主键标识
	public static final String ID_PEQACATLOG= "Id_peqacatlog";
	//体检问卷问题分组父ID
	public static final String ID_PEQACATLOG_PAR= "Id_peqacatlog_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//问卷分组编码
	public static final String CODE= "Code";
	//问卷分组名称
	public static final String NAME= "Name";
	//次序
	public static final String SORTNO= "Sortno";
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
	//计算公式
	public static final String FORMULA= "Formula";
	//问卷分组编码
	public static final String CODE_PAR= "Code_par";
	//问卷分组名称
	public static final String NAME_PAR= "Name_par";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检问卷问题分组主键标识
	 * @return String
	 */
	public String getId_peqacatlog() {
		return ((String) getAttrVal("Id_peqacatlog"));
	}	
	/**
	 * 体检问卷问题分组主键标识
	 * @param Id_peqacatlog
	 */
	public void setId_peqacatlog(String Id_peqacatlog) {
		setAttrVal("Id_peqacatlog", Id_peqacatlog);
	}
	/**
	 * 体检问卷问题分组父ID
	 * @return String
	 */
	public String getId_peqacatlog_par() {
		return ((String) getAttrVal("Id_peqacatlog_par"));
	}	
	/**
	 * 体检问卷问题分组父ID
	 * @param Id_peqacatlog_par
	 */
	public void setId_peqacatlog_par(String Id_peqacatlog_par) {
		setAttrVal("Id_peqacatlog_par", Id_peqacatlog_par);
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
	 * 问卷分组编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 问卷分组编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 问卷分组名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 问卷分组名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 次序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 次序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 计算公式
	 * @return String
	 */
	public String getFormula() {
		return ((String) getAttrVal("Formula"));
	}	
	/**
	 * 计算公式
	 * @param Formula
	 */
	public void setFormula(String Formula) {
		setAttrVal("Formula", Formula);
	}
	/**
	 * 问卷分组编码
	 * @return String
	 */
	public String getCode_par() {
		return ((String) getAttrVal("Code_par"));
	}	
	/**
	 * 问卷分组编码
	 * @param Code_par
	 */
	public void setCode_par(String Code_par) {
		setAttrVal("Code_par", Code_par);
	}
	/**
	 * 问卷分组名称
	 * @return String
	 */
	public String getName_par() {
		return ((String) getAttrVal("Name_par"));
	}	
	/**
	 * 问卷分组名称
	 * @param Name_par
	 */
	public void setName_par(String Name_par) {
		setAttrVal("Name_par", Name_par);
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
		return "Id_peqacatlog";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peqacat";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeQaCatDODesc.class);
	}
	
}