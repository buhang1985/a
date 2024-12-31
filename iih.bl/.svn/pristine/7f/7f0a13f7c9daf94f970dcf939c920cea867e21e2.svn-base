package iih.bl.itf.std;

import iih.bl.itf.std.bp.ipcharge.GetIpCostBillBP;
import iih.bl.itf.std.bp.ipcharge.GetIpDayCostBillBP;
import iih.bl.itf.std.bp.ipcharge.PaymentBP;
import iih.bl.itf.std.bp.ipcharge.SetIpCostBillBP;
import iih.bl.itf.std.bp.ipcharge.SettlementBP;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--住院记账服务
 * @author ly 2018/7/16
 *
 */
public class BlIpChargeServiceImpl implements IBlIpChargeService, IBlIpChargeRService {

	/**
	 * 住院费用清单查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/7/16
	 */
	@Override
	public String getCostBill(String param) throws BizException {
		GetIpCostBillBP bp = new GetIpCostBillBP();
		return bp.exec(param);
	}

	/**
	 * 住院日费用清单查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/7/16
	 */
	@Override
	public String getDayCostBill(String param) throws BizException {
		GetIpDayCostBillBP bp = new GetIpDayCostBillBP();
		return bp.exec(param);
	}
	
	/**
	 * 住院退补费
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/7/16
	 */
	@Override
	public String setCostAppendToIIH(String param) throws BizException {
		SetIpCostBillBP bp = new SetIpCostBillBP();
		return bp.execTrans(param);
	}

	@Override
	public String settlement(String param) throws BizException {
		SettlementBP bp = new SettlementBP();
		return bp.execTrans(param);
	}

	@Override
	public String payment(String param) throws BizException {
		PaymentBP bp = new PaymentBP();
		return bp.execTrans(param);
	}

}
