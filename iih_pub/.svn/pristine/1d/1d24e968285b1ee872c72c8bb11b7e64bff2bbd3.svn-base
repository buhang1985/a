package iih.bl.itf.std;

import java.util.List;

import iih.bl.itf.dto.blthirdnowindcheckdto.d.BlThirdNOWindCheckDTO;
import iih.bl.itf.dto.blthirdreconcilldto.d.BlThirdOrderDTO;
import iih.bl.itf.dto.blthirdreconcilldto.d.BlThirdReconCillDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
/**
 * 支付平台提供对账接口
 * @author zhangxin
 * @date 2019年4月16日
 */
public interface IBlPmpBalanceQryService {
	/**
	 * 查询是否异常数据接口 为支付平台提供
	 * 
	 * true 异常 false正常
	 * @param order_no
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean isCheckAbnormal(String order_no) throws BizException;
	/**
	 * 查询一段时间内的订单数据
	 * @param orderdo
	 * @param begin_date
	 * @param end_date
	 * @return
	 * @throws BizException
	 */
	public abstract BlThirdReconCillDTO[] CheckOrderStatus(BlThirdOrderDTO[] orderdo, String begin_date, String end_date) throws BizException;
	/**
	 * 查询非窗口第三方支付的数据
	 * @param start_time
	 * @param end_time
	 * @param pttpandPm
	 * @return
	 * @throws BizException
	 */
	public abstract BlThirdNOWindCheckDTO[] CheckNoWindBill(String start_time,String end_time,List<String> pttpandPm) throws BizException;
	
}
