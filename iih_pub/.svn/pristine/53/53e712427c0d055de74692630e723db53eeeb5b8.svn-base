package iih.pe.pqn.pestrokemodel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.pestrokemodel.d.desc.PeStrokeModelSbpDODesc;
import java.math.BigDecimal;

/**
 * 健康评估模型_脑卒中_收缩压 DO数据 
 * 
 */
public class PeStrokeModelSbpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//脑卒中评估模型收缩压主键标识
	public static final String ID_PESTROKEMODELSBP= "Id_pestrokemodelsbp";
	//脑卒中评估模型ID
	public static final String ID_PESTROKEMODEL= "Id_pestrokemodel";
	//低值
	public static final String VALUE_LOW= "Value_low";
	//高值
	public static final String VALUE_HEIGH= "Value_heigh";
	//评分
	public static final String SCORE= "Score";
	//治疗标识
	public static final String FG_CURE= "Fg_cure";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 脑卒中评估模型收缩压主键标识
	 * @return String
	 */
	public String getId_pestrokemodelsbp() {
		return ((String) getAttrVal("Id_pestrokemodelsbp"));
	}	
	/**
	 * 脑卒中评估模型收缩压主键标识
	 * @param Id_pestrokemodelsbp
	 */
	public void setId_pestrokemodelsbp(String Id_pestrokemodelsbp) {
		setAttrVal("Id_pestrokemodelsbp", Id_pestrokemodelsbp);
	}
	/**
	 * 脑卒中评估模型ID
	 * @return String
	 */
	public String getId_pestrokemodel() {
		return ((String) getAttrVal("Id_pestrokemodel"));
	}	
	/**
	 * 脑卒中评估模型ID
	 * @param Id_pestrokemodel
	 */
	public void setId_pestrokemodel(String Id_pestrokemodel) {
		setAttrVal("Id_pestrokemodel", Id_pestrokemodel);
	}
	/**
	 * 低值
	 * @return FDouble
	 */
	public FDouble getValue_low() {
		return ((FDouble) getAttrVal("Value_low"));
	}	
	/**
	 * 低值
	 * @param Value_low
	 */
	public void setValue_low(FDouble Value_low) {
		setAttrVal("Value_low", Value_low);
	}
	/**
	 * 高值
	 * @return FDouble
	 */
	public FDouble getValue_heigh() {
		return ((FDouble) getAttrVal("Value_heigh"));
	}	
	/**
	 * 高值
	 * @param Value_heigh
	 */
	public void setValue_heigh(FDouble Value_heigh) {
		setAttrVal("Value_heigh", Value_heigh);
	}
	/**
	 * 评分
	 * @return Integer
	 */
	public Integer getScore() {
		return ((Integer) getAttrVal("Score"));
	}	
	/**
	 * 评分
	 * @param Score
	 */
	public void setScore(Integer Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 治疗标识
	 * @return FBoolean
	 */
	public FBoolean getFg_cure() {
		return ((FBoolean) getAttrVal("Fg_cure"));
	}	
	/**
	 * 治疗标识
	 * @param Fg_cure
	 */
	public void setFg_cure(FBoolean Fg_cure) {
		setAttrVal("Fg_cure", Fg_cure);
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
		return "Id_pestrokemodelsbp";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pestrokemodelsbp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeStrokeModelSbpDODesc.class);
	}
	
}