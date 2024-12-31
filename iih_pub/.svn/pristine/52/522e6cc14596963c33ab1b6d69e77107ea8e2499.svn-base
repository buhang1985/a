package iih.pe.pqn.petcmconstcadef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.petcmconstcadef.d.desc.PeTCMJudgeQaDODesc;
import java.math.BigDecimal;

/**
 * 体检中医体质分析判定问卷 DO数据 
 * 
 */
public class PeTCMJudgeQaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//中医体质分型判定问卷主键标识
	public static final String ID_PETCMCONSTCAJUDGEQA= "Id_petcmconstcajudgeqa";
	//体检体检中医体质分型定义主键
	public static final String ID_PETCMCONSTCADEF= "Id_petcmconstcadef";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//英文名称
	public static final String ENAME= "Ename";
	//分组号
	public static final String NO_GROUP= "No_group";
	//次序
	public static final String SORTNO= "Sortno";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//分值
	public static final String SCORE= "Score";
	//计分方式
	public static final String SCORETP= "Scoretp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 中医体质分型判定问卷主键标识
	 * @return String
	 */
	public String getId_petcmconstcajudgeqa() {
		return ((String) getAttrVal("Id_petcmconstcajudgeqa"));
	}	
	/**
	 * 中医体质分型判定问卷主键标识
	 * @param Id_petcmconstcajudgeqa
	 */
	public void setId_petcmconstcajudgeqa(String Id_petcmconstcajudgeqa) {
		setAttrVal("Id_petcmconstcajudgeqa", Id_petcmconstcajudgeqa);
	}
	/**
	 * 体检体检中医体质分型定义主键
	 * @return String
	 */
	public String getId_petcmconstcadef() {
		return ((String) getAttrVal("Id_petcmconstcadef"));
	}	
	/**
	 * 体检体检中医体质分型定义主键
	 * @param Id_petcmconstcadef
	 */
	public void setId_petcmconstcadef(String Id_petcmconstcadef) {
		setAttrVal("Id_petcmconstcadef", Id_petcmconstcadef);
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
	 * 英文名称
	 * @return String
	 */
	public String getEname() {
		return ((String) getAttrVal("Ename"));
	}	
	/**
	 * 英文名称
	 * @param Ename
	 */
	public void setEname(String Ename) {
		setAttrVal("Ename", Ename);
	}
	/**
	 * 分组号
	 * @return Integer
	 */
	public Integer getNo_group() {
		return ((Integer) getAttrVal("No_group"));
	}	
	/**
	 * 分组号
	 * @param No_group
	 */
	public void setNo_group(Integer No_group) {
		setAttrVal("No_group", No_group);
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
	 * 分值
	 * @return Integer
	 */
	public Integer getScore() {
		return ((Integer) getAttrVal("Score"));
	}	
	/**
	 * 分值
	 * @param Score
	 */
	public void setScore(Integer Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 计分方式
	 * @return Integer
	 */
	public Integer getScoretp() {
		return ((Integer) getAttrVal("Scoretp"));
	}	
	/**
	 * 计分方式
	 * @param Scoretp
	 */
	public void setScoretp(Integer Scoretp) {
		setAttrVal("Scoretp", Scoretp);
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
		return "Id_petcmconstcajudgeqa";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_petcmjudgeqa";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeTCMJudgeQaDODesc.class);
	}
	
}