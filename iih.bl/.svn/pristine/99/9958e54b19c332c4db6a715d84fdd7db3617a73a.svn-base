package iih.bl.cg.event;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.dto.d.OpCancAcc4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 门诊取消记账
 * @author yankan
 * @since 2017-07-03
 *
 */
public class OpCancAccEvent {
	/**
	 * 触发事件
	 * 
	 * @param eventSource 事件源
	 * @throws BizException
	 */
	public void invoke(OpCancAcc4EsDTO[] eventSource) throws BizException{
		BusinessEvent refundEvent = new BusinessEvent(IBlEventConst.EVENT_SOURCE_OP_CANC_ACC, IEventType.TYPE_UPDATE_AFTER,
				eventSource);
		EventDispatcher.fireEvent(refundEvent);
	}
}
