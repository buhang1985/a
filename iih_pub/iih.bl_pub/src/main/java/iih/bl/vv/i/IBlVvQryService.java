package iih.bl.vv.i;


import iih.bl.vv.dto.blcpnout.d.BlCpnOutDTO;
import xap.mw.core.data.BizException;

/**
 * 优惠券模块查询服务
 * @author ly 2018/02/25
 *
 */
public interface IBlVvQryService {
	/**
	 * 查询优惠券记录
	 * @param 根据优惠券编码，从优惠券列表中根据优惠券编码查询出优惠券记录
	 * @author houll
	 * 
	 */
    public abstract BlCpnOutDTO[] queryCoupon(String patId) throws BizException;
 
}
