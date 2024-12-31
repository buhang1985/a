package iih.bl.pay.event;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.pay.dto.d.OpRcvPrepay4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 收取门诊预交金事件
 * 
 * @author yankan
 * @since 2017-07-03
 *
 */
public class OpRcvPrepayEvent {
	/**
	 * 触发事件
	 * 
	 * @param eventSource 事件源
	 * @throws BizException
	 */
	public void invoke(OpRcvPrepay4EsDTO[] eventSource) throws BizException {
		BusinessEvent refundEvent = new BusinessEvent(IBlEventConst.EVENT_SOURCE_OP_RECEIVE_PREPAY,
				IEventType.TYPE_UPDATE_AFTER, eventSource);
		EventDispatcher.fireEvent(refundEvent);
	}
}
