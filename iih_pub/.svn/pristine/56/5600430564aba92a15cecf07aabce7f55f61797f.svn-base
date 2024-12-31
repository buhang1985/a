package iih.pe.pqn.peevalkinematics.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peevalkinematics.d.desc.PeEvalKineDurDODesc;
import java.math.BigDecimal;

/**
 * 健康评估-运动评估定义-时间 DO数据 
 * 
 */
public class PeEvalKineDurDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康运动评估时间主键标识
	public static final String ID_PEEVALKINEDUR= "Id_peevalkinedur";
	//健康运动评估定义ID
	public static final String ID_PEEVALKINEMATICS= "Id_peevalkinematics";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//分值
	public static final String SCORE= "Score";
	//序号
	public static final String SORTNO= "Sortno";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康运动评估时间主键标识
	 * @return String
	 */
	public String getId_peevalkinedur() {
		return ((String) getAttrVal("Id_peevalkinedur"));
	}	
	/**
	 * 健康运动评估时间主键标识
	 * @param Id_peevalkinedur
	 */
	public void setId_peevalkinedur(String Id_peevalkinedur) {
		setAttrVal("Id_peevalkinedur", Id_peevalkinedur);
	}
	/**
	 * 健康运动评估定义ID
	 * @return String
	 */
	public String getId_peevalkinematics() {
		return ((String) getAttrVal("Id_peevalkinematics"));
	}	
	/**
	 * 健康运动评估定义ID
	 * @param Id_peevalkinematics
	 */
	public void setId_peevalkinematics(String Id_peevalkinematics) {
		setAttrVal("Id_peevalkinematics", Id_peevalkinematics);
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
		return "Id_peevalkinedur";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peevalkinedur";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeEvalKineDurDODesc.class);
	}
	
}