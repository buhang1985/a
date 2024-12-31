package iih.pe.pqn.peicdvmodel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peicdvmodel.d.desc.PeIcdvModelDiabetesDODesc;
import java.math.BigDecimal;

/**
 * 健康评估模型_缺血性冠心病_糖尿病 DO数据 
 * 
 */
public class PeIcdvModelDiabetesDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//缺血性冠心病评估模型糖尿病主键标识
	public static final String ID_PEICDVMODELDIABETES= "Id_peicdvmodeldiabetes";
	//缺血性冠心病ID
	public static final String ID_PEICDVMODEL= "Id_peicdvmodel";
	//糖尿病标识
	public static final String FG_DIABETES= "Fg_diabetes";
	//评分
	public static final String SCORE= "Score";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 缺血性冠心病评估模型糖尿病主键标识
	 * @return String
	 */
	public String getId_peicdvmodeldiabetes() {
		return ((String) getAttrVal("Id_peicdvmodeldiabetes"));
	}	
	/**
	 * 缺血性冠心病评估模型糖尿病主键标识
	 * @param Id_peicdvmodeldiabetes
	 */
	public void setId_peicdvmodeldiabetes(String Id_peicdvmodeldiabetes) {
		setAttrVal("Id_peicdvmodeldiabetes", Id_peicdvmodeldiabetes);
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
	 * 糖尿病标识
	 * @return FBoolean
	 */
	public FBoolean getFg_diabetes() {
		return ((FBoolean) getAttrVal("Fg_diabetes"));
	}	
	/**
	 * 糖尿病标识
	 * @param Fg_diabetes
	 */
	public void setFg_diabetes(FBoolean Fg_diabetes) {
		setAttrVal("Fg_diabetes", Fg_diabetes);
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
		return "Id_peicdvmodeldiabetes";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peicdvmodeldiabetes";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeIcdvModelDiabetesDODesc.class);
	}
	
}