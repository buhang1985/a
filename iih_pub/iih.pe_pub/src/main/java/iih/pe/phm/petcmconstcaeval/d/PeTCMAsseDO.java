package iih.pe.phm.petcmconstcaeval.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.petcmconstcaeval.d.desc.PeTCMAsseDODesc;
import java.math.BigDecimal;

/**
 * 体检中医问卷评分结果 DO数据 
 * 
 */
public class PeTCMAsseDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检中医评估明细主键标识
	public static final String ID_PETCMASSE= "Id_petcmasse";
	//体检中医评估得分ID
	public static final String ID_PETCMCON= "Id_petcmcon";
	//中医体质分析判定问卷ID
	public static final String ID_PETCMCONSTCAJUDGEQA= "Id_petcmconstcajudgeqa";
	//单项分值
	public static final String SCORE= "Score";
	//体检中医体质分型定义ID
	public static final String ID_PETCMCONSTCADEF= "Id_petcmconstcadef";
	//名称
	public static final String NAME_QES= "Name_qes";
	//次序
	public static final String SORTNO= "Sortno";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//编码
	public static final String CODE_CA= "Code_ca";
	//名称
	public static final String NAME_CA= "Name_ca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检中医评估明细主键标识
	 * @return String
	 */
	public String getId_petcmasse() {
		return ((String) getAttrVal("Id_petcmasse"));
	}	
	/**
	 * 体检中医评估明细主键标识
	 * @param Id_petcmasse
	 */
	public void setId_petcmasse(String Id_petcmasse) {
		setAttrVal("Id_petcmasse", Id_petcmasse);
	}
	/**
	 * 体检中医评估得分ID
	 * @return String
	 */
	public String getId_petcmcon() {
		return ((String) getAttrVal("Id_petcmcon"));
	}	
	/**
	 * 体检中医评估得分ID
	 * @param Id_petcmcon
	 */
	public void setId_petcmcon(String Id_petcmcon) {
		setAttrVal("Id_petcmcon", Id_petcmcon);
	}
	/**
	 * 中医体质分析判定问卷ID
	 * @return String
	 */
	public String getId_petcmconstcajudgeqa() {
		return ((String) getAttrVal("Id_petcmconstcajudgeqa"));
	}	
	/**
	 * 中医体质分析判定问卷ID
	 * @param Id_petcmconstcajudgeqa
	 */
	public void setId_petcmconstcajudgeqa(String Id_petcmconstcajudgeqa) {
		setAttrVal("Id_petcmconstcajudgeqa", Id_petcmconstcajudgeqa);
	}
	/**
	 * 单项分值
	 * @return Integer
	 */
	public Integer getScore() {
		return ((Integer) getAttrVal("Score"));
	}	
	/**
	 * 单项分值
	 * @param Score
	 */
	public void setScore(Integer Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 体检中医体质分型定义ID
	 * @return String
	 */
	public String getId_petcmconstcadef() {
		return ((String) getAttrVal("Id_petcmconstcadef"));
	}	
	/**
	 * 体检中医体质分型定义ID
	 * @param Id_petcmconstcadef
	 */
	public void setId_petcmconstcadef(String Id_petcmconstcadef) {
		setAttrVal("Id_petcmconstcadef", Id_petcmconstcadef);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_qes() {
		return ((String) getAttrVal("Name_qes"));
	}	
	/**
	 * 名称
	 * @param Name_qes
	 */
	public void setName_qes(String Name_qes) {
		setAttrVal("Name_qes", Name_qes);
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
	 * 编码
	 * @return String
	 */
	public String getCode_ca() {
		return ((String) getAttrVal("Code_ca"));
	}	
	/**
	 * 编码
	 * @param Code_ca
	 */
	public void setCode_ca(String Code_ca) {
		setAttrVal("Code_ca", Code_ca);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ca() {
		return ((String) getAttrVal("Name_ca"));
	}	
	/**
	 * 名称
	 * @param Name_ca
	 */
	public void setName_ca(String Name_ca) {
		setAttrVal("Name_ca", Name_ca);
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
		return "Id_petcmasse";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_petcmasse";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeTCMAsseDODesc.class);
	}
	
}