package iih.bl.itf.std;

import java.util.List;

import iih.bl.itf.dto.blthirdnowindcheckdto.d.BlThirdNOWindCheckDTO;
import iih.bl.itf.dto.blthirdreconcilldto.d.BlThirdOrderDTO;
import iih.bl.itf.dto.blthirdreconcilldto.d.BlThirdReconCillDTO;
import iih.bl.itf.std.bp.balacc.CheckAbnormalDataBP;
import iih.bl.itf.std.bp.balacc.CheckOrderStausBP;
import iih.bl.itf.std.bp.balacc.CheckThirdPayOrdBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
/**
 * 支付平台提供对账接口
 * @author zhangxin
 * @date 2019年4月16日
 */
public class BlPmpBalanceQryServiceImpl implements IBlPmpBalanceQryService {

	/**
	 * 查询是否异常数据接口 为支付平台提供
	 * 
	 * @param order_no
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean isCheckAbnormal(String order_no) throws BizException {
		CheckAbnormalDataBP bp = new CheckAbnormalDataBP();
		return bp.exec(order_no);
	}
	/**
	 *
	 * 查询一段时间内的订单数据
	 * @param orderdo
	 * @param begin_date
	 * @param end_date
	 * @return
	 * @author zhangxin
	 * @throws BizException
	 */
	@Override
	public BlThirdReconCillDTO[] CheckOrderStatus(BlThirdOrderDTO[] orderdo, String begin_date, String end_date) throws BizException {
		CheckOrderStausBP bp = new CheckOrderStausBP();
		return bp.exec(orderdo, begin_date, end_date);
	}
	/**
	 * 查询非窗口第三方支付的数据
	 * @param start_time
	 * @param end_time
	 * @param pttpandPm
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlThirdNOWindCheckDTO[] CheckNoWindBill(String start_time, String end_time, List<String> pttpandPm)
			throws BizException {
		CheckThirdPayOrdBP bp = new CheckThirdPayOrdBP();
		return bp.exec(start_time, end_time, pttpandPm);
	}
}
