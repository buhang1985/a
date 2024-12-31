package iih.mi.biz.flow.oepchargeflow.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊划价自助机处理出参 DTO数据 
 * 
 */
public class MiOepChargePricingSelfOutParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医保登记串
	 * @return String
	 */
	public String getStr_hpregister() {
		return ((String) getAttrVal("Str_hpregister"));
	}
	/**
	 * 医保登记串
	 * @param Str_hpregister
	 */
	public void setStr_hpregister(String Str_hpregister) {
		setAttrVal("Str_hpregister", Str_hpregister);
	}
	/**
	 * 明细上传串
	 * @return String
	 */
	public String getStr_detailupload() {
		return ((String) getAttrVal("Str_detailupload"));
	}
	/**
	 * 明细上传串
	 * @param Str_detailupload
	 */
	public void setStr_detailupload(String Str_detailupload) {
		setAttrVal("Str_detailupload", Str_detailupload);
	}
	/**
	 * 预结算串
	 * @return String
	 */
	public String getStr_hpprest() {
		return ((String) getAttrVal("Str_hpprest"));
	}
	/**
	 * 预结算串
	 * @param Str_hpprest
	 */
	public void setStr_hpprest(String Str_hpprest) {
		setAttrVal("Str_hpprest", Str_hpprest);
	}
}