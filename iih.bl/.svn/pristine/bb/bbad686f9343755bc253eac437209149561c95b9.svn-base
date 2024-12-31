package iih.bl.pay.ep;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;

/**
 * 患者预交金EP
 * @author yankan
 * @since 2017-06-19
 *
 */
public class PatPrepayEP {
      
	/**
	 * 保存数据
	 * @param blpppdos
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO[] save(BlPrePayPatDO[] blpppdos) throws BizException{
		IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
		BlPrePayPatDO[] blPrePayPatDOArr = payService.save(blpppdos);
		return  blPrePayPatDOArr ;
		
	}
}
