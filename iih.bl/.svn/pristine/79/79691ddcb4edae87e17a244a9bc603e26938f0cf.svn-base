package iih.bl.pay.s.ep;

import iih.bl.pay.blpayspcl.d.BlpayspclAggDO;
import iih.bl.pay.blpayspcl.i.IBlpayspclCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 患者专用款收付款EP
 * @author ly 2018/05/19
 *
 */
public class PatSpclPayEP {

	/**
	 * 保存
	 * @param dos
	 * @return
	 * @throws Bizexception
	 */
	public BlpayspclAggDO[] save(BlpayspclAggDO[] dos) throws BizException{
		IBlpayspclCudService service = ServiceFinder.find(IBlpayspclCudService.class);
		BlpayspclAggDO[] newDos = service.save(dos);
		return newDos;
	}
}
