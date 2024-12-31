package iih.bl.itf.std.inner;

import iih.bl.itf.std.bean.input.charge.WsParamGetCostBill;
import iih.bl.itf.std.bean.input.charge.WsParamSetCostBill;
import iih.bl.itf.std.bean.output.WsResultMsgInfo;
import iih.bl.itf.std.bean.output.charge.WsResultIpGetCostBill;
import iih.bl.itf.std.bp.ipcharge.GetIpCostBillBP;
import iih.bl.itf.std.bp.ipcharge.GetIpDayCostBillBP;
import iih.bl.itf.std.bp.ipcharge.SetIpCostBillBP;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--住院记账服务(内部接口，出入参为未转xml时数据)
 * @author shaokx 2019/7/22
 *
 */
public class BlIpChargeInnerServiceImpl implements IBlIpChargeInnerService{

	/**
	 * 住院退补费
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	@Override
	public WsResultMsgInfo setCostAppendToIIH(WsParamSetCostBill inParam) throws BizException {
		SetIpCostBillBP bp = new SetIpCostBillBP();
		return bp.execTransTV(inParam);
	}

	/**
	 * 住院费用清单查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	@Override
	public WsResultIpGetCostBill getCostBill(WsParamGetCostBill inParam) throws BizException {
		GetIpCostBillBP bp = new GetIpCostBillBP();
		return bp.execTV(inParam);
	}

	/**
	 * 住院日费用清单查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	@Override
	public WsResultMsgInfo getDayCostBill(WsParamGetCostBill inParam) throws BizException {
		GetIpDayCostBillBP bp = new GetIpDayCostBillBP();
		return bp.execTV(inParam);
	}

}
