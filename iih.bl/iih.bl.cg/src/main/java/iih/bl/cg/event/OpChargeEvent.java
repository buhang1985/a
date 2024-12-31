package iih.bl.cg.event;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.dto.d.OpCharge4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 门诊收费事件
 * @author yankan
 *
 */
public class OpChargeEvent {
	/**
	 * 触发事件
	 * 
	 * @param eventSource事件源
	 * @throws BizException
	 */
	public void invoke(OpCharge4EsDTO eventSource) throws BizException{
		BusinessEvent refundEvent = new BusinessEvent(IBlEventConst.EVENT_SOURCE_OP_CHARGE, IBlEventConst.EVENT_TYPE_BL_OP_CHARGE,
				eventSource);
		EventDispatcher.fireEvent(refundEvent);
	}
}
