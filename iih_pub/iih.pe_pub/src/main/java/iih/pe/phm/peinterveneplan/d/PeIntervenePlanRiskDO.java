package iih.pe.phm.peinterveneplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.peinterveneplan.d.desc.PeIntervenePlanRiskDODesc;
import java.math.BigDecimal;

/**
 * 健康危险因素干预个人计划 DO数据 
 * 
 */
public class PeIntervenePlanRiskDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康干预个人计划危险因素主键标识
	public static final String ID_PEINTERVENEPLANRISK= "Id_peinterveneplanrisk";
	//健康干预个人计划ID
	public static final String ID_PEINTERVENEPLAN= "Id_peinterveneplan";
	//健康危险因素汇总ID
	public static final String ID_PERSTRISKS= "Id_perstrisks";
	//危险因素ID
	public static final String ID_RISKDEF= "Id_riskdef";
	//干预目标
	public static final String RST_GOAL= "Rst_goal";
	//实际干预结果
	public static final String RST_INTERVENE= "Rst_intervene";
	//干预结果分类
	public static final String INTERVENETP= "Intervenetp";
	//结果
	public static final String RST_RISK= "Rst_risk";
	//阳性标识
	public static final String FG_POSI_RISK= "Fg_posi_risk";
	//阳性符号
	public static final String MARK_POSI_RISK= "Mark_posi_risk";
	//编码
	public static final String CODE_RISKDEF= "Code_riskdef";
	//名称
	public static final String NAME_RISKDEF= "Name_riskdef";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康干预个人计划危险因素主键标识
	 * @return String
	 */
	public String getId_peinterveneplanrisk() {
		return ((String) getAttrVal("Id_peinterveneplanrisk"));
	}	
	/**
	 * 健康干预个人计划危险因素主键标识
	 * @param Id_peinterveneplanrisk
	 */
	public void setId_peinterveneplanrisk(String Id_peinterveneplanrisk) {
		setAttrVal("Id_peinterveneplanrisk", Id_peinterveneplanrisk);
	}
	/**
	 * 健康干预个人计划ID
	 * @return String
	 */
	public String getId_peinterveneplan() {
		return ((String) getAttrVal("Id_peinterveneplan"));
	}	
	/**
	 * 健康干预个人计划ID
	 * @param Id_peinterveneplan
	 */
	public void setId_peinterveneplan(String Id_peinterveneplan) {
		setAttrVal("Id_peinterveneplan", Id_peinterveneplan);
	}
	/**
	 * 健康危险因素汇总ID
	 * @return String
	 */
	public String getId_perstrisks() {
		return ((String) getAttrVal("Id_perstrisks"));
	}	
	/**
	 * 健康危险因素汇总ID
	 * @param Id_perstrisks
	 */
	public void setId_perstrisks(String Id_perstrisks) {
		setAttrVal("Id_perstrisks", Id_perstrisks);
	}
	/**
	 * 危险因素ID
	 * @return String
	 */
	public String getId_riskdef() {
		return ((String) getAttrVal("Id_riskdef"));
	}	
	/**
	 * 危险因素ID
	 * @param Id_riskdef
	 */
	public void setId_riskdef(String Id_riskdef) {
		setAttrVal("Id_riskdef", Id_riskdef);
	}
	/**
	 * 干预目标
	 * @return String
	 */
	public String getRst_goal() {
		return ((String) getAttrVal("Rst_goal"));
	}	
	/**
	 * 干预目标
	 * @param Rst_goal
	 */
	public void setRst_goal(String Rst_goal) {
		setAttrVal("Rst_goal", Rst_goal);
	}
	/**
	 * 实际干预结果
	 * @return String
	 */
	public String getRst_intervene() {
		return ((String) getAttrVal("Rst_intervene"));
	}	
	/**
	 * 实际干预结果
	 * @param Rst_intervene
	 */
	public void setRst_intervene(String Rst_intervene) {
		setAttrVal("Rst_intervene", Rst_intervene);
	}
	/**
	 * 干预结果分类
	 * @return Integer
	 */
	public Integer getIntervenetp() {
		return ((Integer) getAttrVal("Intervenetp"));
	}	
	/**
	 * 干预结果分类
	 * @param Intervenetp
	 */
	public void setIntervenetp(Integer Intervenetp) {
		setAttrVal("Intervenetp", Intervenetp);
	}
	/**
	 * 结果
	 * @return String
	 */
	public String getRst_risk() {
		return ((String) getAttrVal("Rst_risk"));
	}	
	/**
	 * 结果
	 * @param Rst_risk
	 */
	public void setRst_risk(String Rst_risk) {
		setAttrVal("Rst_risk", Rst_risk);
	}
	/**
	 * 阳性标识
	 * @return FBoolean
	 */
	public FBoolean getFg_posi_risk() {
		return ((FBoolean) getAttrVal("Fg_posi_risk"));
	}	
	/**
	 * 阳性标识
	 * @param Fg_posi_risk
	 */
	public void setFg_posi_risk(FBoolean Fg_posi_risk) {
		setAttrVal("Fg_posi_risk", Fg_posi_risk);
	}
	/**
	 * 阳性符号
	 * @return String
	 */
	public String getMark_posi_risk() {
		return ((String) getAttrVal("Mark_posi_risk"));
	}	
	/**
	 * 阳性符号
	 * @param Mark_posi_risk
	 */
	public void setMark_posi_risk(String Mark_posi_risk) {
		setAttrVal("Mark_posi_risk", Mark_posi_risk);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_riskdef() {
		return ((String) getAttrVal("Code_riskdef"));
	}	
	/**
	 * 编码
	 * @param Code_riskdef
	 */
	public void setCode_riskdef(String Code_riskdef) {
		setAttrVal("Code_riskdef", Code_riskdef);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_riskdef() {
		return ((String) getAttrVal("Name_riskdef"));
	}	
	/**
	 * 名称
	 * @param Name_riskdef
	 */
	public void setName_riskdef(String Name_riskdef) {
		setAttrVal("Name_riskdef", Name_riskdef);
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
		return "Id_peinterveneplanrisk";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_peinterveneplanrisk";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeIntervenePlanRiskDODesc.class);
	}
	
}