package iih.bl.itf.std.inner;

import iih.bl.itf.std.bean.input.prepay.WsParamGetAccRecord;
import iih.bl.itf.std.bean.input.prepay.WsParamPrepay;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.prepay.WsResultGetIpAcc;
import iih.bl.itf.std.bean.output.prepay.WsResultPrepay;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--住院预交金服务
 * @author shaokx 2019/7/22
 *
 */
public interface IBlIpPrepayInnerService {

	/**
	 * 住院押金充值
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/7/16
	 */
	public abstract WsResultPrepay recharge(WsParamPrepay inParam) throws BizException;
	
	/**
	 * 住院账户查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	public abstract WsResultMsg getAccountInfo(WsParamGetAccRecord inParam) throws BizException;
	
	/**
	 * 住院押金充值记录查询(含余额)
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	public abstract WsResultGetIpAcc getRechargeRecord(WsParamGetAccRecord inParam) throws BizException;
}
