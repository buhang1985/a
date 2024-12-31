package iih.pe.pqn.peevalchrorisk.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peevalchrorisk.d.desc.PeChroQaDODesc;
import java.math.BigDecimal;

/**
 * 体检慢性病风险因素-问卷 DO数据 
 * 
 */
public class PeChroQaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检慢性病风险因素问卷主键标识
	public static final String ID_PECHRORISKQA= "Id_pechroriskqa";
	//体检慢性病风险因素ID
	public static final String ID_PECHRORISK= "Id_pechrorisk";
	//体检问卷问题库ID
	public static final String ID_PEQACONTENTDEF= "Id_peqacontentdef";
	//体检问卷选项ID
	public static final String ID_PEQAKEYDEF= "Id_peqakeydef";
	//分值
	public static final String SCORE= "Score";
	//求和标识
	public static final String FG_SUM= "Fg_sum";
	//问题编码
	public static final String CODE_QA= "Code_qa";
	//问题名称
	public static final String NAME_QA= "Name_qa";
	//答案编码
	public static final String CODE_KEY= "Code_key";
	//答案名称
	public static final String NAME_KEY= "Name_key";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检慢性病风险因素问卷主键标识
	 * @return String
	 */
	public String getId_pechroriskqa() {
		return ((String) getAttrVal("Id_pechroriskqa"));
	}	
	/**
	 * 体检慢性病风险因素问卷主键标识
	 * @param Id_pechroriskqa
	 */
	public void setId_pechroriskqa(String Id_pechroriskqa) {
		setAttrVal("Id_pechroriskqa", Id_pechroriskqa);
	}
	/**
	 * 体检慢性病风险因素ID
	 * @return String
	 */
	public String getId_pechrorisk() {
		return ((String) getAttrVal("Id_pechrorisk"));
	}	
	/**
	 * 体检慢性病风险因素ID
	 * @param Id_pechrorisk
	 */
	public void setId_pechrorisk(String Id_pechrorisk) {
		setAttrVal("Id_pechrorisk", Id_pechrorisk);
	}
	/**
	 * 体检问卷问题库ID
	 * @return String
	 */
	public String getId_peqacontentdef() {
		return ((String) getAttrVal("Id_peqacontentdef"));
	}	
	/**
	 * 体检问卷问题库ID
	 * @param Id_peqacontentdef
	 */
	public void setId_peqacontentdef(String Id_peqacontentdef) {
		setAttrVal("Id_peqacontentdef", Id_peqacontentdef);
	}
	/**
	 * 体检问卷选项ID
	 * @return String
	 */
	public String getId_peqakeydef() {
		return ((String) getAttrVal("Id_peqakeydef"));
	}	
	/**
	 * 体检问卷选项ID
	 * @param Id_peqakeydef
	 */
	public void setId_peqakeydef(String Id_peqakeydef) {
		setAttrVal("Id_peqakeydef", Id_peqakeydef);
	}
	/**
	 * 分值
	 * @return FDouble
	 */
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}	
	/**
	 * 分值
	 * @param Score
	 */
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 求和标识
	 * @return FBoolean
	 */
	public FBoolean getFg_sum() {
		return ((FBoolean) getAttrVal("Fg_sum"));
	}	
	/**
	 * 求和标识
	 * @param Fg_sum
	 */
	public void setFg_sum(FBoolean Fg_sum) {
		setAttrVal("Fg_sum", Fg_sum);
	}
	/**
	 * 问题编码
	 * @return String
	 */
	public String getCode_qa() {
		return ((String) getAttrVal("Code_qa"));
	}	
	/**
	 * 问题编码
	 * @param Code_qa
	 */
	public void setCode_qa(String Code_qa) {
		setAttrVal("Code_qa", Code_qa);
	}
	/**
	 * 问题名称
	 * @return String
	 */
	public String getName_qa() {
		return ((String) getAttrVal("Name_qa"));
	}	
	/**
	 * 问题名称
	 * @param Name_qa
	 */
	public void setName_qa(String Name_qa) {
		setAttrVal("Name_qa", Name_qa);
	}
	/**
	 * 答案编码
	 * @return String
	 */
	public String getCode_key() {
		return ((String) getAttrVal("Code_key"));
	}	
	/**
	 * 答案编码
	 * @param Code_key
	 */
	public void setCode_key(String Code_key) {
		setAttrVal("Code_key", Code_key);
	}
	/**
	 * 答案名称
	 * @return String
	 */
	public String getName_key() {
		return ((String) getAttrVal("Name_key"));
	}	
	/**
	 * 答案名称
	 * @param Name_key
	 */
	public void setName_key(String Name_key) {
		setAttrVal("Name_key", Name_key);
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
		return "Id_pechroriskqa";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pechroqa";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChroQaDODesc.class);
	}
	
}