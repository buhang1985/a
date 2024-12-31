package iih.ei.std.d.v1.bl.oppricingdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊划价医保信息 DTO数据 
 * 
 */
public class HpInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医保登记串
	 * @return String
	 */
	public String getHpregisterinfo() {
		return ((String) getAttrVal("Hpregisterinfo"));
	}	
	/**
	 * 医保登记串
	 * @param Hpregisterinfo
	 */
	public void setHpregisterinfo(String Hpregisterinfo) {
		setAttrVal("Hpregisterinfo", Hpregisterinfo);
	}
	/**
	 * 医保明细上传串
	 * @return String
	 */
	public String getHpdetailuploadinfo() {
		return ((String) getAttrVal("Hpdetailuploadinfo"));
	}	
	/**
	 * 医保明细上传串
	 * @param Hpdetailuploadinfo
	 */
	public void setHpdetailuploadinfo(String Hpdetailuploadinfo) {
		setAttrVal("Hpdetailuploadinfo", Hpdetailuploadinfo);
	}
	/**
	 * 医保预结算串
	 * @return String
	 */
	public String getHpprestinfo() {
		return ((String) getAttrVal("Hpprestinfo"));
	}	
	/**
	 * 医保预结算串
	 * @param Hpprestinfo
	 */
	public void setHpprestinfo(String Hpprestinfo) {
		setAttrVal("Hpprestinfo", Hpprestinfo);
	}
	/**
	 * 医保读卡信息
	 * @return String
	 */
	public String getHpcardinfo() {
		return ((String) getAttrVal("Hpcardinfo"));
	}	
	/**
	 * 医保读卡信息
	 * @param Hpcardinfo
	 */
	public void setHpcardinfo(String Hpcardinfo) {
		setAttrVal("Hpcardinfo", Hpcardinfo);
	}
}