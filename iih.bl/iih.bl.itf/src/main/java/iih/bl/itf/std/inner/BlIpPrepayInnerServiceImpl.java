package iih.bl.itf.std.inner;

import iih.bl.itf.std.bean.input.prepay.WsParamGetAccRecord;
import iih.bl.itf.std.bean.input.prepay.WsParamPrepay;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.prepay.WsResultGetIpAcc;
import iih.bl.itf.std.bean.output.prepay.WsResultPrepay;
import iih.bl.itf.std.bp.ipprepay.GetIpAccountInfoBP;
import iih.bl.itf.std.bp.ipprepay.GetIpRechargeRecordBP;
import iih.bl.itf.std.bp.ipprepay.IpRechargePrepayBP;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--住院预交金服务(内部接口，出入参为未转xml时数据)
 * @author shaokx 2019/7/22
 *
 */
public class BlIpPrepayInnerServiceImpl implements IBlIpPrepayInnerService{

	/**
	 * 住院押金充值
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	@Override
	public WsResultPrepay recharge(WsParamPrepay inParam) throws BizException {
		IpRechargePrepayBP bp = new IpRechargePrepayBP();
		return bp.execTransTV(inParam);
	}

	/**
	 * 住院账户查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	@Override
	public WsResultMsg getAccountInfo(WsParamGetAccRecord inParam) throws BizException {
		GetIpAccountInfoBP bp = new GetIpAccountInfoBP();
		return bp.execTV(inParam);
	}

	/**
	 * 住院押金充值记录查询(含余额)
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	@Override
	public WsResultGetIpAcc getRechargeRecord(WsParamGetAccRecord inParam) throws BizException {
		GetIpRechargeRecordBP bp = new GetIpRechargeRecordBP();
		return bp.execTV(inParam);
	}

}
