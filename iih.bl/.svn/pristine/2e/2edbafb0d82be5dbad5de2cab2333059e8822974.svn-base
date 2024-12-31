package iih.bl.pay.event;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.dto.d.OpCancAcc4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 退门诊预交金
 * @author yankan
 * @since 2017-07-03
 *
 */
public class OpRefundPrepayEvent {
	/**
	 * 触发事件
	 * 
	 * @param eventSource 事件源
	 * @throws BizException
	 */
	public void invoke(OpCancAcc4EsDTO[] eventSource) throws BizException{
		BusinessEvent refundEvent = new BusinessEvent(IBlEventConst.EVENT_SOURCE_OP_REFUND_PREPAY, IEventType.TYPE_UPDATE_AFTER,
				eventSource);
		EventDispatcher.fireEvent(refundEvent);
	}
}
