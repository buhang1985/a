package iih.bl.itf.std.inner;

import iih.bl.itf.std.bean.input.prepay.WsParamGetAccRecord;
import iih.bl.itf.std.bean.input.prepay.WsParamPrepay;
import iih.bl.itf.std.bean.output.prepay.WsResultGetOpAcc;
import iih.bl.itf.std.bean.output.prepay.WsResultPrepay;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--门诊预交金服务
 * @author shaokx 2019/7/22
 *
 */
public interface IBlOpPrepayInnerService {

	/**
	 * 门诊预交金充值
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	public abstract WsResultPrepay recharge(WsParamPrepay inParam) throws BizException;
	
	/**
	 * 门诊账户查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	public abstract WsResultGetOpAcc getAccountInfo(WsParamGetAccRecord inParam) throws BizException;
	
	/**
	 * 门诊充值记录查询(含余额)
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	public abstract WsResultGetOpAcc getRechargeRecord(WsParamGetAccRecord inParam) throws BizException;
}
