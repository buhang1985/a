package iih.bl.itf.std.inner;

import iih.bl.itf.std.bean.input.charge.WsParamGetCostBill;
import iih.bl.itf.std.bean.input.charge.WsParamSetCostBill;
import iih.bl.itf.std.bean.output.WsResultMsgInfo;
import iih.bl.itf.std.bean.output.charge.WsResultIpGetCostBill;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--住院记账服务
 * @author shaokx 2019/7/22
 *
 */
public interface IBlIpChargeInnerService {

	/**
	 * 住院退补费
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2018/7/22
	 */
	public abstract WsResultMsgInfo setCostAppendToIIH(WsParamSetCostBill inParam) throws BizException;
	
	/**
	 * 住院费用清单查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	public abstract WsResultIpGetCostBill getCostBill(WsParamGetCostBill inParam) throws BizException;
	
	/**
	 * 住院日费用清单查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	public abstract WsResultMsgInfo getDayCostBill(WsParamGetCostBill inParam) throws BizException;
}
