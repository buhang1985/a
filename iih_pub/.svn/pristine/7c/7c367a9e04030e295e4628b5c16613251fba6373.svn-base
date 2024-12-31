package iih.bl.st.blstproxyhp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.st.blstproxyhp.d.desc.BlStProxyhpItmDODesc;
import java.math.BigDecimal;

/**
 * 医保支付明细 DO数据 
 * 
 */
public class BlStProxyhpItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医保支付明细主键
	public static final String ID_ST_PROXYHP_ITM= "Id_st_proxyhp_itm";
	//医保报销支付
	public static final String ID_ST_PROXYHP= "Id_st_proxyhp";
	//应收方向
	public static final String EU_DIRECT= "Eu_direct";
	//金额
	public static final String AMT= "Amt";
	//支付方式
	public static final String ID_PM= "Id_pm";
	//患者预交金
	public static final String ID_PAYPAT= "Id_paypat";
	//备注
	public static final String NOTE= "Note";
	//付款方式编码
	public static final String PM_CODE= "Pm_code";
	//付款方式名称
	public static final String PM_NAME= "Pm_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医保支付明细主键
	 * @return String
	 */
	public String getId_st_proxyhp_itm() {
		return ((String) getAttrVal("Id_st_proxyhp_itm"));
	}	
	/**
	 * 医保支付明细主键
	 * @param Id_st_proxyhp_itm
	 */
	public void setId_st_proxyhp_itm(String Id_st_proxyhp_itm) {
		setAttrVal("Id_st_proxyhp_itm", Id_st_proxyhp_itm);
	}
	/**
	 * 医保报销支付
	 * @return String
	 */
	public String getId_st_proxyhp() {
		return ((String) getAttrVal("Id_st_proxyhp"));
	}	
	/**
	 * 医保报销支付
	 * @param Id_st_proxyhp
	 */
	public void setId_st_proxyhp(String Id_st_proxyhp) {
		setAttrVal("Id_st_proxyhp", Id_st_proxyhp);
	}
	/**
	 * 应收方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	/**
	 * 应收方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 支付方式
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}	
	/**
	 * 支付方式
	 * @param Id_pm
	 */
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	/**
	 * 患者预交金
	 * @return String
	 */
	public String getId_paypat() {
		return ((String) getAttrVal("Id_paypat"));
	}	
	/**
	 * 患者预交金
	 * @param Id_paypat
	 */
	public void setId_paypat(String Id_paypat) {
		setAttrVal("Id_paypat", Id_paypat);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 付款方式编码
	 * @return String
	 */
	public String getPm_code() {
		return ((String) getAttrVal("Pm_code"));
	}	
	/**
	 * 付款方式编码
	 * @param Pm_code
	 */
	public void setPm_code(String Pm_code) {
		setAttrVal("Pm_code", Pm_code);
	}
	/**
	 * 付款方式名称
	 * @return String
	 */
	public String getPm_name() {
		return ((String) getAttrVal("Pm_name"));
	}	
	/**
	 * 付款方式名称
	 * @param Pm_name
	 */
	public void setPm_name(String Pm_name) {
		setAttrVal("Pm_name", Pm_name);
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
		return "Id_st_proxyhp_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_st_proxyhp_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlStProxyhpItmDODesc.class);
	}
	
}