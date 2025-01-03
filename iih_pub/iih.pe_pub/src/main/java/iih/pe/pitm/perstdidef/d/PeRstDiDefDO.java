package iih.pe.pitm.perstdidef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perstdidef.d.desc.PeRstDiDefDODesc;
import java.math.BigDecimal;

/**
 * 体检诊断定义 DO数据 
 * 
 */
public class PeRstDiDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检诊断主键标识
	public static final String ID_PERSTDIDEF= "Id_perstdidef";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//体检诊断目录ID
	public static final String ID_PERSTDITP= "Id_perstditp";
	//诊断编码
	public static final String CODE= "Code";
	//诊断名称
	public static final String NAME= "Name";
	//英文诊断名称
	public static final String ENAME= "Ename";
	//诊断关键字
	public static final String DIAGKEYWORD= "Diagkeyword";
	//总检医生建议
	public static final String ADVICE= "Advice";
	//专科医生建议
	public static final String ADVICE_DOC= "Advice_doc";
	//次序
	public static final String SORTNO= "Sortno";
	//风险性
	public static final String RISKS= "Risks";
	//追踪
	public static final String FOLLOWS= "Follows";
	//自动总检汇总
	public static final String FG_AUTOOVAL= "Fg_autooval";
	//使用频率
	public static final String FRQ= "Frq";
	//阳性标识
	public static final String FG_POSI= "Fg_posi";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//可疑标识
	public static final String FG_DOUBT= "Fg_doubt";
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
	//诊断目录编码
	public static final String CODE_TP= "Code_tp";
	//诊断目录名称
	public static final String NAME_TP= "Name_tp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检诊断主键标识
	 * @return String
	 */
	public String getId_perstdidef() {
		return ((String) getAttrVal("Id_perstdidef"));
	}	
	/**
	 * 体检诊断主键标识
	 * @param Id_perstdidef
	 */
	public void setId_perstdidef(String Id_perstdidef) {
		setAttrVal("Id_perstdidef", Id_perstdidef);
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
	 * 体检诊断目录ID
	 * @return String
	 */
	public String getId_perstditp() {
		return ((String) getAttrVal("Id_perstditp"));
	}	
	/**
	 * 体检诊断目录ID
	 * @param Id_perstditp
	 */
	public void setId_perstditp(String Id_perstditp) {
		setAttrVal("Id_perstditp", Id_perstditp);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 诊断编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 诊断名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 英文诊断名称
	 * @return String
	 */
	public String getEname() {
		return ((String) getAttrVal("Ename"));
	}	
	/**
	 * 英文诊断名称
	 * @param Ename
	 */
	public void setEname(String Ename) {
		setAttrVal("Ename", Ename);
	}
	/**
	 * 诊断关键字
	 * @return String
	 */
	public String getDiagkeyword() {
		return ((String) getAttrVal("Diagkeyword"));
	}	
	/**
	 * 诊断关键字
	 * @param Diagkeyword
	 */
	public void setDiagkeyword(String Diagkeyword) {
		setAttrVal("Diagkeyword", Diagkeyword);
	}
	/**
	 * 总检医生建议
	 * @return String
	 */
	public String getAdvice() {
		return ((String) getAttrVal("Advice"));
	}	
	/**
	 * 总检医生建议
	 * @param Advice
	 */
	public void setAdvice(String Advice) {
		setAttrVal("Advice", Advice);
	}
	/**
	 * 专科医生建议
	 * @return String
	 */
	public String getAdvice_doc() {
		return ((String) getAttrVal("Advice_doc"));
	}	
	/**
	 * 专科医生建议
	 * @param Advice_doc
	 */
	public void setAdvice_doc(String Advice_doc) {
		setAttrVal("Advice_doc", Advice_doc);
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
	 * 风险性
	 * @return Integer
	 */
	public Integer getRisks() {
		return ((Integer) getAttrVal("Risks"));
	}	
	/**
	 * 风险性
	 * @param Risks
	 */
	public void setRisks(Integer Risks) {
		setAttrVal("Risks", Risks);
	}
	/**
	 * 追踪
	 * @return Integer
	 */
	public Integer getFollows() {
		return ((Integer) getAttrVal("Follows"));
	}	
	/**
	 * 追踪
	 * @param Follows
	 */
	public void setFollows(Integer Follows) {
		setAttrVal("Follows", Follows);
	}
	/**
	 * 自动总检汇总
	 * @return FBoolean
	 */
	public FBoolean getFg_autooval() {
		return ((FBoolean) getAttrVal("Fg_autooval"));
	}	
	/**
	 * 自动总检汇总
	 * @param Fg_autooval
	 */
	public void setFg_autooval(FBoolean Fg_autooval) {
		setAttrVal("Fg_autooval", Fg_autooval);
	}
	/**
	 * 使用频率
	 * @return Integer
	 */
	public Integer getFrq() {
		return ((Integer) getAttrVal("Frq"));
	}	
	/**
	 * 使用频率
	 * @param Frq
	 */
	public void setFrq(Integer Frq) {
		setAttrVal("Frq", Frq);
	}
	/**
	 * 阳性标识
	 * @return FBoolean
	 */
	public FBoolean getFg_posi() {
		return ((FBoolean) getAttrVal("Fg_posi"));
	}	
	/**
	 * 阳性标识
	 * @param Fg_posi
	 */
	public void setFg_posi(FBoolean Fg_posi) {
		setAttrVal("Fg_posi", Fg_posi);
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
	 * 可疑标识
	 * @return FBoolean
	 */
	public FBoolean getFg_doubt() {
		return ((FBoolean) getAttrVal("Fg_doubt"));
	}	
	/**
	 * 可疑标识
	 * @param Fg_doubt
	 */
	public void setFg_doubt(FBoolean Fg_doubt) {
		setAttrVal("Fg_doubt", Fg_doubt);
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
	 * 诊断目录编码
	 * @return String
	 */
	public String getCode_tp() {
		return ((String) getAttrVal("Code_tp"));
	}	
	/**
	 * 诊断目录编码
	 * @param Code_tp
	 */
	public void setCode_tp(String Code_tp) {
		setAttrVal("Code_tp", Code_tp);
	}
	/**
	 * 诊断目录名称
	 * @return String
	 */
	public String getName_tp() {
		return ((String) getAttrVal("Name_tp"));
	}	
	/**
	 * 诊断目录名称
	 * @param Name_tp
	 */
	public void setName_tp(String Name_tp) {
		setAttrVal("Name_tp", Name_tp);
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
		return "Id_perstdidef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_perstdidef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstDiDefDODesc.class);
	}
	
}