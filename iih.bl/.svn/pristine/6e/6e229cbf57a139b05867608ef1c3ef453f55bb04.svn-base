package iih.bl.cg.event;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 集成平台退费事件
 * @author yankan
 * @since 2017-07-03
 *
 */
public class OpRefund4IpEvent {
	/**
	 * 触发事件
	 * 
	 * @param eventSource事件源
	 * @throws BizException
	 */
	public void invoke(OpRefund4IpEsDTO[] eventSource) throws BizException{
		BusinessEvent refundEvent = new BusinessEvent(IBlEventConst.EVENT_SOURCE_OP_REFUND_FOR_IP, IEventType.TYPE_UPDATE_AFTER,
				eventSource);
		EventDispatcher.fireEvent(refundEvent);
	}
}
