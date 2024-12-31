package iih.bl.itf.std.bp.ipprepay;

import iih.bl.itf.std.bean.input.prepay.WsParamGetAccRecord;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bp.BlItfBaseBP;
import xap.mw.core.data.BizException;

/**
 * 住院账户查询
 * 
 * @author ly 2018/7/20
 *
 */
public class GetIpAccountInfoBP extends BlItfBaseBP<WsParamGetAccRecord, WsResultMsg> {

	@Override
	protected String getBusiness() {

		return null;
	}

	@Override
	protected void checkParam(WsParamGetAccRecord param) throws BizException {
		
	}

	@Override
	protected WsResultMsg doWork(WsParamGetAccRecord param) throws BizException {
		return null;
	}
}
