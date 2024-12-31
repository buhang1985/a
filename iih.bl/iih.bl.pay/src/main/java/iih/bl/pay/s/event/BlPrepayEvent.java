package iih.bl.pay.s.event;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 预交金收款事件
 * @author ly 2018/07/26
 *
 */
public class BlPrepayEvent {

	/**
	 * 预交金充值事件
	 * @param prepayDO
	 * @throws BizException
	 */
	public static void invokeCharge(BlPrePayPatDO prepayDO) throws BizException{
		BusinessEvent event = new BusinessEvent(
				IBlEventConst.EVENT_SOURCE_PREPAY,
				IBlEventConst.EVENT_TYPE_PREPAY_CHARGE, prepayDO);
		EventDispatcher.fireEvent(event);
	}
	
	/**
	 * 预交金退充值事件
	 * @param prepayDO
	 * @throws BizException
	 */
	public static void invokeRefund(BlPrePayPatDO prepayDO) throws BizException{
		BusinessEvent event = new BusinessEvent(
				IBlEventConst.EVENT_SOURCE_PREPAY,
				IBlEventConst.EVENT_TYPE_PREPAY_REFUND, prepayDO);
		EventDispatcher.fireEvent(event);
	}
}
