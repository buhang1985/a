package iih.ei.std.d.v1.bl.oppricingdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊划价出参 DTO数据 
 * 
 */
public class OpPricingResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 支付顺序号
	 * @return String
	 */
	public String getPayno() {
		return ((String) getAttrVal("Payno"));
	}	
	/**
	 * 支付顺序号
	 * @param Payno
	 */
	public void setPayno(String Payno) {
		setAttrVal("Payno", Payno);
	}
	/**
	 * 门诊划价就诊信息
	 * @return String
	 */
	public FArrayList getEntinfo() {
		return ((FArrayList) getAttrVal("Entinfo"));
	}	
	/**
	 * 门诊划价就诊信息
	 * @param Entinfo
	 */
	public void setEntinfo(FArrayList Entinfo) {
		setAttrVal("Entinfo", Entinfo);
	}
	/**
	 * 门诊划价医保信息
	 * @return String
	 */
	public FArrayList getHpinfo() {
		return ((FArrayList) getAttrVal("Hpinfo"));
	}	
	/**
	 * 门诊划价医保信息
	 * @param Hpinfo
	 */
	public void setHpinfo(FArrayList Hpinfo) {
		setAttrVal("Hpinfo", Hpinfo);
	}
}