package iih.bl.vv.s;


import iih.bl.vv.dto.blcpnout.d.BlCpnOutDTO;
import iih.bl.vv.i.IBlVvQryService;
import iih.bl.vv.s.bp.QueryCouponBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;


/**
 * 优惠券模块查询服务
 * @author ly 2018/02/25
 *
 */
@Service(serviceInterfaces={IBlVvQryService.class}, binding=Binding.JSONRPC)
public class BlVvQryServiceImpl implements IBlVvQryService {

	/**
	 * 查询优惠券记录
	 * @param 根据优惠券编码，从优惠券列表中查询出优惠券记录。
	 * @author houll 2018/03/01
	 * 
	 */
	@Override
	public BlCpnOutDTO[] queryCoupon(String idPat) throws BizException {
		QueryCouponBP bp=new QueryCouponBP();
		return bp.exec(idPat);
	}
}
