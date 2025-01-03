package iih.bl.itf.std;

import iih.bl.itf.std.bp.opprepay.GetOpAccountInfoBP;
import iih.bl.itf.std.bp.opprepay.GetOpRechargeRecordBP;
import iih.bl.itf.std.bp.opprepay.GetRechargeInfoBP;
import iih.bl.itf.std.bp.opprepay.OpRechargePrepayBP;
import iih.bl.itf.std.bp.opprepay.OpRefundPrepayBP;
import iih.bl.itf.std.bp.opprepay.OpRefundPrepayCheckBP;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--门诊预交金服务
 * @author ly 2018/7/16
 *
 */
public class BlOpPrepayServiceImpl implements IBlOpPrepayService, IBlOpPrepayRService {

	/**
	 * 门诊预交金充值
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/7/16
	 */
	@Override
	public String recharge(String param) throws BizException {
		OpRechargePrepayBP bp = new OpRechargePrepayBP();
		return bp.execTrans(param);
	}
	
	/**
	 * 门诊预交金退充值校验
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2019/11/21
	 */
	@Override
	public String refundCheck(String param) throws BizException{
		OpRefundPrepayCheckBP bp = new OpRefundPrepayCheckBP();
		return bp.exec(param);
	}
	
	/**
	 * 门诊预交金退充值
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2019/11/21
	 */
	@Override
	public String refund(String param) throws BizException{
		OpRefundPrepayBP bp = new OpRefundPrepayBP();
		return bp.execTrans(param);
	}
	
	/**
	 * 门诊账户查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/7/16
	 */
	@Override
	public String getAccountInfo(String param) throws BizException {
		GetOpAccountInfoBP bp = new GetOpAccountInfoBP();
		return bp.exec(param);
	}

	/**
	 * 门诊充值记录查询(含余额)
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/7/16
	 */
	@Override
	public String getRechargeRecord(String param) throws BizException {
		GetOpRechargeRecordBP bp = new GetOpRechargeRecordBP();
		return bp.exec(param);
	}

	/**
	 * 充值记录查询新(门诊+住院)
	 */
	@Override
	public String getRechargeInfo(String param) throws BizException {
		GetRechargeInfoBP bp = new GetRechargeInfoBP();
		return bp.exec(param);
	}
}
