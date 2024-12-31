package iih.pe.pqn.peevalkinematics.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peevalkinematics.d.desc.PeEvalKineLevelDODesc;
import java.math.BigDecimal;

/**
 * 健康评估-运动评估定义-分级 DO数据 
 * 
 */
public class PeEvalKineLevelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康运动评估分级主键标识
	public static final String ID_PEEVALKINELEVEL= "Id_peevalkinelevel";
	//健康运动评估定义ID
	public static final String ID_PEEVALKINEMATICS= "Id_peevalkinematics";
	//分级编码
	public static final String CODE= "Code";
	//分级名称
	public static final String NAME= "Name";
	//分值下限
	public static final String SCORE_LOW= "Score_low";
	//分值上线
	public static final String SCORE_HIGH= "Score_high";
	//活动指数
	public static final String ACTIVITYINDEX= "Activityindex";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康运动评估分级主键标识
	 * @return String
	 */
	public String getId_peevalkinelevel() {
		return ((String) getAttrVal("Id_peevalkinelevel"));
	}	
	/**
	 * 健康运动评估分级主键标识
	 * @param Id_peevalkinelevel
	 */
	public void setId_peevalkinelevel(String Id_peevalkinelevel) {
		setAttrVal("Id_peevalkinelevel", Id_peevalkinelevel);
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
	 * 分级编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 分级编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 分级名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 分级名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 分值下限
	 * @return Integer
	 */
	public Integer getScore_low() {
		return ((Integer) getAttrVal("Score_low"));
	}	
	/**
	 * 分值下限
	 * @param Score_low
	 */
	public void setScore_low(Integer Score_low) {
		setAttrVal("Score_low", Score_low);
	}
	/**
	 * 分值上线
	 * @return Integer
	 */
	public Integer getScore_high() {
		return ((Integer) getAttrVal("Score_high"));
	}	
	/**
	 * 分值上线
	 * @param Score_high
	 */
	public void setScore_high(Integer Score_high) {
		setAttrVal("Score_high", Score_high);
	}
	/**
	 * 活动指数
	 * @return Integer
	 */
	public Integer getActivityindex() {
		return ((Integer) getAttrVal("Activityindex"));
	}	
	/**
	 * 活动指数
	 * @param Activityindex
	 */
	public void setActivityindex(Integer Activityindex) {
		setAttrVal("Activityindex", Activityindex);
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
		return "Id_peevalkinelevel";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peevalkinelevel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeEvalKineLevelDODesc.class);
	}
	
}