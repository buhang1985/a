package iih.mi.biz.flow.oepchargeflow.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊收费自助机处理出参 DTO数据 
 * 
 */
public class MiOepChargePaySelfOutParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 旧医保平台分摊数据
	 * @return FArrayList
	 */
	public FArrayList getOldpropdata() {
		return ((FArrayList) getAttrVal("Oldpropdata"));
	}
	/**
	 * 旧医保平台分摊数据
	 * @param Oldpropdata
	 */
	public void setOldpropdata(FArrayList Oldpropdata) {
		setAttrVal("Oldpropdata", Oldpropdata);
	}
}