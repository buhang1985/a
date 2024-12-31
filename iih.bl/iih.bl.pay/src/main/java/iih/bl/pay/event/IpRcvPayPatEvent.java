package iih.bl.pay.event;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 住院收付款事件
 * @author liwq
 * @since 2017-7-13 10:00:12
 *
 */
public class IpRcvPayPatEvent {

	/**
	 * 触发事件
	 * 
	 * @param blEventInfoDTO
	 * @throws BizException
	 */
	public void invokePay(BlEventInfoDTO blEventInfoDTO) throws BizException{
		BusinessEvent enterDeptEvent = new BusinessEvent(IBlEventConst.EVENT_BL_ST_IP_PAY_CLASS, IEventType.TYPE_INSERT_AFTER,
				blEventInfoDTO);
		EventDispatcher.fireEvent(enterDeptEvent);
	}
}
