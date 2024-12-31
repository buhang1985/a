package iih.bl.cg.event;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.dto.d.OpRefund4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 门诊退费事件
 * @author yankan
 * @since 2017-06-26
 *
 */
public class OpRefundEvent {
	/**
	 * 触发事件
	 * 
	 * @param eventSource事件源
	 * @throws BizException
	 */
	public void invoke(OpRefund4EsDTO eventSource) throws BizException{
		BusinessEvent refundEvent = new BusinessEvent(IBlEventConst.EVENT_SOURCE_OP_REFUND, IBlEventConst.EVENT_TYPE_BL_OP_REFUND,
				eventSource);
		EventDispatcher.fireEvent(refundEvent);
	}
}
