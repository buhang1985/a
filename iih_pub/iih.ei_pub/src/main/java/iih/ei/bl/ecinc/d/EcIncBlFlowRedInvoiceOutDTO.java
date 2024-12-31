package iih.ei.bl.ecinc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 电子票据红冲票据出参 DTO数据 
 * 
 */
public class EcIncBlFlowRedInvoiceOutDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 电子红票代码
	 * @return String
	 */
	public String getEcinc_code() {
		return ((String) getAttrVal("Ecinc_code"));
	}
	/**
	 * 电子红票代码
	 * @param Ecinc_code
	 */
	public void setEcinc_code(String Ecinc_code) {
		setAttrVal("Ecinc_code", Ecinc_code);
	}
	/**
	 * 电子红票号
	 * @return String
	 */
	public String getEcincno() {
		return ((String) getAttrVal("Ecincno"));
	}
	/**
	 * 电子红票号
	 * @param Ecincno
	 */
	public void setEcincno(String Ecincno) {
		setAttrVal("Ecincno", Ecincno);
	}
	/**
	 * 电子红票校验码
	 * @return String
	 */
	public String getEcinc_checkno() {
		return ((String) getAttrVal("Ecinc_checkno"));
	}
	/**
	 * 电子红票校验码
	 * @param Ecinc_checkno
	 */
	public void setEcinc_checkno(String Ecinc_checkno) {
		setAttrVal("Ecinc_checkno", Ecinc_checkno);
	}
	/**
	 * 电子红票url
	 * @return String
	 */
	public String getEcinc_url() {
		return ((String) getAttrVal("Ecinc_url"));
	}
	/**
	 * 电子红票url
	 * @param Ecinc_url
	 */
	public void setEcinc_url(String Ecinc_url) {
		setAttrVal("Ecinc_url", Ecinc_url);
	}
	/**
	 * 电子红票外网url
	 * @return String
	 */
	public String getEcinc_neturl() {
		return ((String) getAttrVal("Ecinc_neturl"));
	}
	/**
	 * 电子红票外网url
	 * @param Ecinc_neturl
	 */
	public void setEcinc_neturl(String Ecinc_neturl) {
		setAttrVal("Ecinc_neturl", Ecinc_neturl);
	}
	/**
	 * 电子红票生成时间
	 * @return FDateTime
	 */
	public FDateTime getDt_inc() {
		return ((FDateTime) getAttrVal("Dt_inc"));
	}
	/**
	 * 电子红票生成时间
	 * @param Dt_inc
	 */
	public void setDt_inc(FDateTime Dt_inc) {
		setAttrVal("Dt_inc", Dt_inc);
	}
}