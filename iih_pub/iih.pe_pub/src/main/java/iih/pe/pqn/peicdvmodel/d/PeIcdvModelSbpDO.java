package iih.pe.pqn.peicdvmodel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peicdvmodel.d.desc.PeIcdvModelSbpDODesc;
import java.math.BigDecimal;

/**
 * 健康评估模型_缺血性冠心病_收缩压 DO数据 
 * 
 */
public class PeIcdvModelSbpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//缺血性冠心病评估模型收缩压主键标识
	public static final String ID_PEICDVMODELSBP= "Id_peicdvmodelsbp";
	//缺血性冠心病ID
	public static final String ID_PEICDVMODEL= "Id_peicdvmodel";
	//低值
	public static final String VALUE_LOW= "Value_low";
	//高值
	public static final String VALUE_HEIGH= "Value_heigh";
	//评分
	public static final String SCORE= "Score";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 缺血性冠心病评估模型收缩压主键标识
	 * @return String
	 */
	public String getId_peicdvmodelsbp() {
		return ((String) getAttrVal("Id_peicdvmodelsbp"));
	}	
	/**
	 * 缺血性冠心病评估模型收缩压主键标识
	 * @param Id_peicdvmodelsbp
	 */
	public void setId_peicdvmodelsbp(String Id_peicdvmodelsbp) {
		setAttrVal("Id_peicdvmodelsbp", Id_peicdvmodelsbp);
	}
	/**
	 * 缺血性冠心病ID
	 * @return String
	 */
	public String getId_peicdvmodel() {
		return ((String) getAttrVal("Id_peicdvmodel"));
	}	
	/**
	 * 缺血性冠心病ID
	 * @param Id_peicdvmodel
	 */
	public void setId_peicdvmodel(String Id_peicdvmodel) {
		setAttrVal("Id_peicdvmodel", Id_peicdvmodel);
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
		return "Id_peicdvmodelsbp";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peicdvmodelsbp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeIcdvModelSbpDODesc.class);
	}
	
}