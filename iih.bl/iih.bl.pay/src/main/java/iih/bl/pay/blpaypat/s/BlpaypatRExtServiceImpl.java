package iih.bl.pay.blpaypat.s;

import iih.bl.pay.blpaypat.bp.BlPaypatRExtBp;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatRExtService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
* 医疗费用_收付款_患者数据额外维护服务
*/
@Service(serviceInterfaces={IBlpaypatRExtService.class}, binding=Binding.JSONRPC)
public class BlpaypatRExtServiceImpl implements IBlpaypatRExtService {
	
	/**
	 * 根据condition条件查找医疗费用_收付款_患者数据集合	
	 * @param whereStr
	 * @param orderStr
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlPrePayPatDO[] find(String whereStr, String orderStr, FBoolean isLazy) throws BizException {
		BlPaypatRExtBp bp=new BlPaypatRExtBp();
		return bp.exec(whereStr,orderStr,isLazy);
	}
}
