package iih.ci.ord.dws.ip.ems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;

import java.math.BigDecimal;

/**
 * 死亡医疗单 DTO数据 
 * 
 */
public class EmsDeadViewDTO extends OrderListViewDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 死亡时间
	 * @return FDateTime
	 */
	public FDateTime getDt_timeout() {
		return ((FDateTime) getAttrVal("Dt_timeout"));
	}
	/**
	 * 死亡时间
	 * @param Dt_timeout
	 */
	public void setDt_timeout(FDateTime Dt_timeout) {
		setAttrVal("Dt_timeout", Dt_timeout);
	}
	/**
	 * 死亡描述
	 * @return String
	 */
	public String getDes_outtp() {
		return ((String) getAttrVal("Des_outtp"));
	}
	/**
	 * 死亡描述
	 * @param Des_outtp
	 */
	public void setDes_outtp(String Des_outtp) {
		setAttrVal("Des_outtp", Des_outtp);
	}
}