package iih.bl.itf.std;

import iih.bl.itf.std.bp.ipprepay.GetIpAccountInfoBP;
import iih.bl.itf.std.bp.ipprepay.GetIpRechargeRecordBP;
import iih.bl.itf.std.bp.ipprepay.IpRechargePrepayBP;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--住院预交金服务
 * @author ly 2018/7/16
 *
 */
public class BlIpPrepayServiceImpl implements IBlIpPrepayService, IBlIpPrepayRService {

	/**
	 * 住院押金充值
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/7/16
	 */
	@Override
	public String recharge(String param) throws BizException {
		IpRechargePrepayBP bp = new IpRechargePrepayBP();
		return bp.execTrans(param);
	}
	
	/**
	 * 住院账户查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/7/16
	 */
	@Override
	public String getAccountInfo(String param) throws BizException {
		GetIpAccountInfoBP bp = new GetIpAccountInfoBP();
		return bp.exec(param);
	}

	/**
	 * 住院押金充值记录查询(含余额)
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/7/16
	 */
	@Override
	public String getRechargeRecord(String param) throws BizException {
		GetIpRechargeRecordBP bp = new GetIpRechargeRecordBP();
		return bp.exec(param);
	}
}
