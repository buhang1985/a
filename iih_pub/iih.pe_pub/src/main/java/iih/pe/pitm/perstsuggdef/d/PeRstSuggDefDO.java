package iih.pe.pitm.perstsuggdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perstsuggdef.d.desc.PeRstSuggDefDODesc;
import java.math.BigDecimal;

/**
 * 体检建议定义 DO数据 
 * 
 */
public class PeRstSuggDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检建议主键标识
	public static final String ID_PERSTSUGGDEF= "Id_perstsuggdef";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//建议编码
	public static final String CODE= "Code";
	//建议名称
	public static final String NAME= "Name";
	//英文建议
	public static final String ENAME= "Ename";
	//建议关键字
	public static final String SUGGKEYWORD= "Suggkeyword";
	//次序
	public static final String SORTNO= "Sortno";
	//关联类型
	public static final String LINKTP= "Linktp";
	//使用频率
	public static final String FRQ= "Frq";
	//复查标识
	public static final String FG_RECHECK= "Fg_recheck";
	//复查提醒周期
	public static final String REMIND_DAYS= "Remind_days";
	//建议内容
	public static final String ZZ_CONT= "Zz_cont";
	//英文建议内容
	public static final String ZZ_ECONT= "Zz_econt";
	//备注
	public static final String NOTE= "Note";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
	//建议分类ID
	public static final String ID_PERSTSUGGTP= "Id_perstsuggtp";
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
	//建议内容文本
	public static final String CON= "Con";
	//英文建议内容文本
	public static final String ECON= "Econ";
	//编码
	public static final String CODE_SUGGCA= "Code_suggca";
	//名称
	public static final String NAME_SUGGCA= "Name_suggca";
	//类别
	public static final String SUGG_CA= "Sugg_ca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检建议主键标识
	 * @return String
	 */
	public String getId_perstsuggdef() {
		return ((String) getAttrVal("Id_perstsuggdef"));
	}	
	/**
	 * 体检建议主键标识
	 * @param Id_perstsuggdef
	 */
	public void setId_perstsuggdef(String Id_perstsuggdef) {
		setAttrVal("Id_perstsuggdef", Id_perstsuggdef);
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
	 * 建议编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 建议编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 建议名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 建议名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 英文建议
	 * @return String
	 */
	public String getEname() {
		return ((String) getAttrVal("Ename"));
	}	
	/**
	 * 英文建议
	 * @param Ename
	 */
	public void setEname(String Ename) {
		setAttrVal("Ename", Ename);
	}
	/**
	 * 建议关键字
	 * @return String
	 */
	public String getSuggkeyword() {
		return ((String) getAttrVal("Suggkeyword"));
	}	
	/**
	 * 建议关键字
	 * @param Suggkeyword
	 */
	public void setSuggkeyword(String Suggkeyword) {
		setAttrVal("Suggkeyword", Suggkeyword);
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
	 * 关联类型
	 * @return Integer
	 */
	public Integer getLinktp() {
		return ((Integer) getAttrVal("Linktp"));
	}	
	/**
	 * 关联类型
	 * @param Linktp
	 */
	public void setLinktp(Integer Linktp) {
		setAttrVal("Linktp", Linktp);
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
	 * 复查标识
	 * @return FBoolean
	 */
	public FBoolean getFg_recheck() {
		return ((FBoolean) getAttrVal("Fg_recheck"));
	}	
	/**
	 * 复查标识
	 * @param Fg_recheck
	 */
	public void setFg_recheck(FBoolean Fg_recheck) {
		setAttrVal("Fg_recheck", Fg_recheck);
	}
	/**
	 * 复查提醒周期
	 * @return Integer
	 */
	public Integer getRemind_days() {
		return ((Integer) getAttrVal("Remind_days"));
	}	
	/**
	 * 复查提醒周期
	 * @param Remind_days
	 */
	public void setRemind_days(Integer Remind_days) {
		setAttrVal("Remind_days", Remind_days);
	}
	/**
	 * 建议内容
	 * @return String
	 */
	public String getZz_cont() {
		return ((String) getAttrVal("Zz_cont"));
	}	
	/**
	 * 建议内容
	 * @param Zz_cont
	 */
	public void setZz_cont(String Zz_cont) {
		setAttrVal("Zz_cont", Zz_cont);
	}
	/**
	 * 英文建议内容
	 * @return String
	 */
	public String getZz_econt() {
		return ((String) getAttrVal("Zz_econt"));
	}	
	/**
	 * 英文建议内容
	 * @param Zz_econt
	 */
	public void setZz_econt(String Zz_econt) {
		setAttrVal("Zz_econt", Zz_econt);
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
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 建议分类ID
	 * @return String
	 */
	public String getId_perstsuggtp() {
		return ((String) getAttrVal("Id_perstsuggtp"));
	}	
	/**
	 * 建议分类ID
	 * @param Id_perstsuggtp
	 */
	public void setId_perstsuggtp(String Id_perstsuggtp) {
		setAttrVal("Id_perstsuggtp", Id_perstsuggtp);
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
	 * 建议内容文本
	 * @return String
	 */
	public String getCon() {
		return ((String) getAttrVal("Con"));
	}	
	/**
	 * 建议内容文本
	 * @param Con
	 */
	public void setCon(String Con) {
		setAttrVal("Con", Con);
	}
	/**
	 * 英文建议内容文本
	 * @return String
	 */
	public String getEcon() {
		return ((String) getAttrVal("Econ"));
	}	
	/**
	 * 英文建议内容文本
	 * @param Econ
	 */
	public void setEcon(String Econ) {
		setAttrVal("Econ", Econ);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_suggca() {
		return ((String) getAttrVal("Code_suggca"));
	}	
	/**
	 * 编码
	 * @param Code_suggca
	 */
	public void setCode_suggca(String Code_suggca) {
		setAttrVal("Code_suggca", Code_suggca);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_suggca() {
		return ((String) getAttrVal("Name_suggca"));
	}	
	/**
	 * 名称
	 * @param Name_suggca
	 */
	public void setName_suggca(String Name_suggca) {
		setAttrVal("Name_suggca", Name_suggca);
	}
	/**
	 * 类别
	 * @return Integer
	 */
	public Integer getSugg_ca() {
		return ((Integer) getAttrVal("Sugg_ca"));
	}	
	/**
	 * 类别
	 * @param Sugg_ca
	 */
	public void setSugg_ca(Integer Sugg_ca) {
		setAttrVal("Sugg_ca", Sugg_ca);
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
		return "Id_perstsuggdef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_perstsuggdef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstSuggDefDODesc.class);
	}
	
}