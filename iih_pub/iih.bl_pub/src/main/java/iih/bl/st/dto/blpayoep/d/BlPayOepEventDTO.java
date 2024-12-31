package iih.bl.st.dto.blpayoep.d;

import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import xap.mw.core.data.BaseDTO;

/**
 * 门诊收费事件数据模型（手工dto,无法进行前台传输）
 * @author ly 2018/12/14
 *
 */
public class BlPayOepEventDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	public static final String CGDATA= "CgData";
	public static final String STDATA= "StData";
	public static final String PAYDATA= "PayData";
	public static final String INCDATA= "IncData";
	
	/**
	 * 记账数据
	 * @return
	 */
	public BlcgoepAggDO[] getCgData() {
		return (BlcgoepAggDO[]) getAttrVal(CGDATA);
	}

	/**
	 * 记账数据
	 * @param cgData
	 */
	public void setCgData(BlcgoepAggDO[] cgData) {
		setAttrVal(CGDATA, cgData);
	}

	/**
	 * 结算数据
	 * @return
	 */
	public BlStOepDO getStData() {
		return (BlStOepDO) getAttrVal(STDATA);
	}

	/**
	 * 结算数据
	 * @param stData
	 */
	public void setStData(BlStOepDO stData) {
		setAttrVal(STDATA, stData);
	}

	/**
	 * 收付款数据
	 * @return
	 */
	public BlpaypatoepAggDO getPayData() {
		return (BlpaypatoepAggDO) getAttrVal(PAYDATA);
	}

	/**
	 * 收付款数据
	 * @param payData
	 */
	public void setPayData(BlpaypatoepAggDO payData) {
		setAttrVal(PAYDATA, payData);
	}

	/**
	 * 发票数据
	 * @return
	 */
	public BlincoepAggDO[] getIncData() {
		return (BlincoepAggDO[]) getAttrVal(INCDATA);
	}

	/**
	 * 发票数据
	 * @param incData
	 */
	public void setIncData(BlincoepAggDO[] incData) {
		setAttrVal(INCDATA, incData);
	}
}
