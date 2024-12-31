package iih.en.ip.s.bp.events;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.inpatient.dto.d.DisHos4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 退院事件
 * @author yank
 *
 */
public class IpDisHosEvent {
	/**
	 * 触发事件
	 * @param disHos4EsDTO 退院事件源DTO
	 * @throws BizException
	 */
	public void invoke(DisHos4EsDTO disHos4EsDTO) throws BizException{	
		BusinessEvent disHosEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_DISCHARGE, IEventType.TYPE_UPDATE_AFTER,
				disHos4EsDTO);
		EventDispatcher.fireEvent(disHosEvent);
	}
}
