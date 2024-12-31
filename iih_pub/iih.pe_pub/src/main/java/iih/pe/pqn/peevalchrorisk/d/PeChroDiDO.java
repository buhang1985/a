package iih.pe.pqn.peevalchrorisk.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peevalchrorisk.d.desc.PeChroDiDODesc;
import java.math.BigDecimal;

/**
 * 体检慢性病风险因素-诊断 DO数据 
 * 
 */
public class PeChroDiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检慢性病风险因素诊断主键标识
	public static final String ID_PECHRORISKDI= "Id_pechroriskdi";
	//体检慢性病风险因素ID
	public static final String ID_PECHRORISK= "Id_pechrorisk";
	//体检诊断ID
	public static final String ID_PERSTDIDEF= "Id_perstdidef";
	//分值
	public static final String SCORE= "Score";
	//求和标识
	public static final String FG_SUM= "Fg_sum";
	//诊断编码
	public static final String CODE_DI= "Code_di";
	//诊断名称
	public static final String NAME_DI= "Name_di";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检慢性病风险因素诊断主键标识
	 * @return String
	 */
	public String getId_pechroriskdi() {
		return ((String) getAttrVal("Id_pechroriskdi"));
	}	
	/**
	 * 体检慢性病风险因素诊断主键标识
	 * @param Id_pechroriskdi
	 */
	public void setId_pechroriskdi(String Id_pechroriskdi) {
		setAttrVal("Id_pechroriskdi", Id_pechroriskdi);
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
	 * 体检诊断ID
	 * @return String
	 */
	public String getId_perstdidef() {
		return ((String) getAttrVal("Id_perstdidef"));
	}	
	/**
	 * 体检诊断ID
	 * @param Id_perstdidef
	 */
	public void setId_perstdidef(String Id_perstdidef) {
		setAttrVal("Id_perstdidef", Id_perstdidef);
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
	 * 诊断编码
	 * @return String
	 */
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}	
	/**
	 * 诊断编码
	 * @param Code_di
	 */
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	/**
	 * 诊断名称
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
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
		return "Id_pechroriskdi";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pechrodi";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChroDiDODesc.class);
	}
	
}