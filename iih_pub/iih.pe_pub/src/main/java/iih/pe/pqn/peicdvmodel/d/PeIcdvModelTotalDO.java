package iih.pe.pqn.peicdvmodel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peicdvmodel.d.desc.PeIcdvModelTotalDODesc;
import java.math.BigDecimal;

/**
 * 健康评估模型_缺血性冠心病_总分 DO数据 
 * 
 */
public class PeIcdvModelTotalDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//缺血性冠心病评估模型总分主键标识
	public static final String ID_PEICDVMODELTOTAL= "Id_peicdvmodeltotal";
	//缺血性冠心病ID
	public static final String ID_PEICDVMODEL= "Id_peicdvmodel";
	//总分
	public static final String SCORE_TOTAL= "Score_total";
	//危险
	public static final String RISK= "Risk";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 缺血性冠心病评估模型总分主键标识
	 * @return String
	 */
	public String getId_peicdvmodeltotal() {
		return ((String) getAttrVal("Id_peicdvmodeltotal"));
	}	
	/**
	 * 缺血性冠心病评估模型总分主键标识
	 * @param Id_peicdvmodeltotal
	 */
	public void setId_peicdvmodeltotal(String Id_peicdvmodeltotal) {
		setAttrVal("Id_peicdvmodeltotal", Id_peicdvmodeltotal);
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
		return "Id_peicdvmodeltotal";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peicdvmodeltotal";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeIcdvModelTotalDODesc.class);
	}
	
}