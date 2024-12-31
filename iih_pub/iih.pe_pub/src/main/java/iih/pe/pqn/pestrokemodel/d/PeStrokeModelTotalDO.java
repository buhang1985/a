package iih.pe.pqn.pestrokemodel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.pestrokemodel.d.desc.PeStrokeModelTotalDODesc;
import java.math.BigDecimal;

/**
 * 健康评估模型_脑卒中_总分 DO数据 
 * 
 */
public class PeStrokeModelTotalDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//脑卒中评估模型总分评估主键标识
	public static final String ID_PESTROKEMODELTOTAL= "Id_pestrokemodeltotal";
	//脑卒中评估模型ID
	public static final String ID_PESTROKEMODEL= "Id_pestrokemodel";
	//总分
	public static final String SCORE_TOTAL= "Score_total";
	//危险
	public static final String RISK= "Risk";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 脑卒中评估模型总分评估主键标识
	 * @return String
	 */
	public String getId_pestrokemodeltotal() {
		return ((String) getAttrVal("Id_pestrokemodeltotal"));
	}	
	/**
	 * 脑卒中评估模型总分评估主键标识
	 * @param Id_pestrokemodeltotal
	 */
	public void setId_pestrokemodeltotal(String Id_pestrokemodeltotal) {
		setAttrVal("Id_pestrokemodeltotal", Id_pestrokemodeltotal);
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
	 * 总分
	 * @return Integer
	 */
	public Integer getScore_total() {
		return ((Integer) getAttrVal("Score_total"));
	}	
	/**
	 * 总分
	 * @param Score_total
	 */
	public void setScore_total(Integer Score_total) {
		setAttrVal("Score_total", Score_total);
	}
	/**
	 * 危险
	 * @return FDouble
	 */
	public FDouble getRisk() {
		return ((FDouble) getAttrVal("Risk"));
	}	
	/**
	 * 危险
	 * @param Risk
	 */
	public void setRisk(FDouble Risk) {
		setAttrVal("Risk", Risk);
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
		return "Id_pestrokemodeltotal";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pestrokemodeltotal";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeStrokeModelTotalDODesc.class);
	}
	
}