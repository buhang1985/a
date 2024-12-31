package iih.bl.pay.event;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 住院退款事件
 * @author liwq
 * @since 2017-7-14 11:16:29
 *
 */
public class IpRefundPayPatEvent {

	/**
	 * 住院退款触发事件
	 * @param blEventInfoDTO 事件源
	 * @throws BizException
	 */
	public void invokeRefund(BlEventInfoDTO blEventInfoDTO) throws BizException {
		BusinessEvent enterDeptEvent = new BusinessEvent(IBlEventConst.EVENT_BL_ST_IP_PAY_CLASS, IEventType.TYPE_DELETE_AFTER,
				blEventInfoDTO);
		EventDispatcher.fireEvent(enterDeptEvent);
	}
}
