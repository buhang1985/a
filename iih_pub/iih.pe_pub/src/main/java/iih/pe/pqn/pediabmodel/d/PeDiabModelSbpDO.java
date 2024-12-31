package iih.pe.pqn.pediabmodel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.pediabmodel.d.desc.PeDiabModelSbpDODesc;
import java.math.BigDecimal;

/**
 * 健康评估模型_糖尿病_收缩压 DO数据 
 * 
 */
public class PeDiabModelSbpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//糖尿病模型收缩压主键标识
	public static final String ID_PEDIABMODELSBP= "Id_pediabmodelsbp";
	//糖尿病模型ID
	public static final String ID_PEDIABMODEL= "Id_pediabmodel";
	//低值
	public static final String VALUE_LOW= "Value_low";
	//高值
	public static final String VALUE_HEIGH= "Value_heigh";
	//评分
	public static final String SCORE= "Score";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 糖尿病模型收缩压主键标识
	 * @return String
	 */
	public String getId_pediabmodelsbp() {
		return ((String) getAttrVal("Id_pediabmodelsbp"));
	}	
	/**
	 * 糖尿病模型收缩压主键标识
	 * @param Id_pediabmodelsbp
	 */
	public void setId_pediabmodelsbp(String Id_pediabmodelsbp) {
		setAttrVal("Id_pediabmodelsbp", Id_pediabmodelsbp);
	}
	/**
	 * 糖尿病模型ID
	 * @return String
	 */
	public String getId_pediabmodel() {
		return ((String) getAttrVal("Id_pediabmodel"));
	}	
	/**
	 * 糖尿病模型ID
	 * @param Id_pediabmodel
	 */
	public void setId_pediabmodel(String Id_pediabmodel) {
		setAttrVal("Id_pediabmodel", Id_pediabmodel);
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
		return "Id_pediabmodelsbp";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pediabmodelsbp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDiabModelSbpDODesc.class);
	}
	
}