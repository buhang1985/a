/**
 * 
 */
package iih.bl.st.exchagehandle.bp;

import iih.bl.cg.dto.d.BlChargeDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊收费业务类
 * @author yi
 *
 */
public class BlChargeHandleBp {

	/**
	 * 划价业务
	 * @param chargeItems
	 * @return
	 */
	public BlChargeDTO[] price(BlChargeDTO[] chargeItems) throws BizException
	{
		//计价
		return null;
	}
	
	private void checkParam(BlChargeDTO[] chargeItems)
	{
		//这里校验数据的准确性，暂时不考虑，由前端校验
	}
	
	/**
	 * 针对医嘱服务项目进行价格计算
	 * @param chargeItems
	 * @return
	 */
	private BlChargeDTO[] calcuSrvPrice(BlChargeDTO[] chargeItems)
	{
		//对于服务进行价格计算
		IMaterialStockService mlService = ServiceFinder.find(IMaterialStockService.class);
		return null;
	}
}
