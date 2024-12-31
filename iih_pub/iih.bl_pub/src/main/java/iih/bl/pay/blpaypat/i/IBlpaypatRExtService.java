package iih.bl.pay.blpaypat.i;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;


/**
* 医疗费用_收付款_患者数据额外维护服务
*/

public interface IBlpaypatRExtService {

	/**
	 * 根据condition条件查找医疗费用_收付款_患者数据集合	
	 * @param whereStr
	 * @param orderStr
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public abstract BlPrePayPatDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
}
