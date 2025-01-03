package iih.pe.pqn.peqacontentdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peqacontentdef.d.desc.PeQacontentDefDODesc;
import java.math.BigDecimal;

/**
 * 体检问卷问题库 DO数据 
 * 
 */
public class PeQacontentDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检问卷问题库主键标识
	public static final String ID_PEQACONTENTDEF= "Id_peqacontentdef";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//体检问卷问题分组ID
	public static final String ID_PEQACATLOG= "Id_peqacatlog";
	//体检问卷问题编码
	public static final String CODE= "Code";
	//体检问卷问题
	public static final String NAME= "Name";
	//体检问卷问题英文名
	public static final String ENAME= "Ename";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//界面控件类型
	public static final String COMPTP= "Comptp";
	//重要标识
	public static final String FG_IMP= "Fg_imp";
	//复制标识
	public static final String FG_COPY= "Fg_copy";
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
	//排序
	public static final String SORTNO= "Sortno";
	//汇总摘要标识
	public static final String FG_SUMMARY= "Fg_summary";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检问卷问题库主键标识
	 * @return String
	 */
	public String getId_peqacontentdef() {
		return ((String) getAttrVal("Id_peqacontentdef"));
	}	
	/**
	 * 体检问卷问题库主键标识
	 * @param Id_peqacontentdef
	 */
	public void setId_peqacontentdef(String Id_peqacontentdef) {
		setAttrVal("Id_peqacontentdef", Id_peqacontentdef);
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
	 * 体检问卷问题分组ID
	 * @return String
	 */
	public String getId_peqacatlog() {
		return ((String) getAttrVal("Id_peqacatlog"));
	}	
	/**
	 * 体检问卷问题分组ID
	 * @param Id_peqacatlog
	 */
	public void setId_peqacatlog(String Id_peqacatlog) {
		setAttrVal("Id_peqacatlog", Id_peqacatlog);
	}
	/**
	 * 体检问卷问题编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 体检问卷问题编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 体检问卷问题
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 体检问卷问题
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 体检问卷问题英文名
	 * @return String
	 */
	public String getEname() {
		return ((String) getAttrVal("Ename"));
	}	
	/**
	 * 体检问卷问题英文名
	 * @param Ename
	 */
	public void setEname(String Ename) {
		setAttrVal("Ename", Ename);
	}
	/**
	 * 性别限制
	 * @return Integer
	 */
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	/**
	 * 性别限制
	 * @param Sexlimit
	 */
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	/**
	 * 界面控件类型
	 * @return Integer
	 */
	public Integer getComptp() {
		return ((Integer) getAttrVal("Comptp"));
	}	
	/**
	 * 界面控件类型
	 * @param Comptp
	 */
	public void setComptp(Integer Comptp) {
		setAttrVal("Comptp", Comptp);
	}
	/**
	 * 重要标识
	 * @return FBoolean
	 */
	public FBoolean getFg_imp() {
		return ((FBoolean) getAttrVal("Fg_imp"));
	}	
	/**
	 * 重要标识
	 * @param Fg_imp
	 */
	public void setFg_imp(FBoolean Fg_imp) {
		setAttrVal("Fg_imp", Fg_imp);
	}
	/**
	 * 复制标识
	 * @return FBoolean
	 */
	public FBoolean getFg_copy() {
		return ((FBoolean) getAttrVal("Fg_copy"));
	}	
	/**
	 * 复制标识
	 * @param Fg_copy
	 */
	public void setFg_copy(FBoolean Fg_copy) {
		setAttrVal("Fg_copy", Fg_copy);
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
	 * 排序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 排序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 汇总摘要标识
	 * @return FBoolean
	 */
	public FBoolean getFg_summary() {
		return ((FBoolean) getAttrVal("Fg_summary"));
	}	
	/**
	 * 汇总摘要标识
	 * @param Fg_summary
	 */
	public void setFg_summary(FBoolean Fg_summary) {
		setAttrVal("Fg_summary", Fg_summary);
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
		return "Id_peqacontentdef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peqacontentdef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeQacontentDefDODesc.class);
	}
	
}