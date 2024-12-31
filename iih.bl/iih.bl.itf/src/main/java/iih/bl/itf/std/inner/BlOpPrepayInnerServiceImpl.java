package iih.bl.itf.std.inner;

import iih.bl.itf.std.bean.input.prepay.WsParamGetAccRecord;
import iih.bl.itf.std.bean.input.prepay.WsParamPrepay;
import iih.bl.itf.std.bean.output.prepay.WsResultGetOpAcc;
import iih.bl.itf.std.bean.output.prepay.WsResultPrepay;
import iih.bl.itf.std.bp.opprepay.GetOpAccountInfoBP;
import iih.bl.itf.std.bp.opprepay.GetOpRechargeRecordBP;
import iih.bl.itf.std.bp.opprepay.OpRechargePrepayBP;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--门诊预交金服务
 * @author shaokx 2019/7/22
 *
 */
public class BlOpPrepayInnerServiceImpl implements IBlOpPrepayInnerService{

	/**
	 * 门诊账户查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	@Override
	public WsResultGetOpAcc getAccountInfo(WsParamGetAccRecord inParam) throws BizException {
		GetOpAccountInfoBP bp = new GetOpAccountInfoBP();
		return bp.execTV(inParam);
	}

	/**
	 * 门诊充值记录查询(含余额)
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	@Override
	public WsResultGetOpAcc getRechargeRecord(WsParamGetAccRecord inParam) throws BizException {
		GetOpRechargeRecordBP bp = new GetOpRechargeRecordBP();
		return bp.execTV(inParam);
	}

	/**
	 * 门诊预交金充值
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	@Override
	public WsResultPrepay recharge(WsParamPrepay inParam) throws BizException {
		OpRechargePrepayBP bp = new OpRechargePrepayBP();
		return bp.execTransTV(inParam);
	}

}
