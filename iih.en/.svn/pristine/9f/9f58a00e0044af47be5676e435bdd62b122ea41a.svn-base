package iih.en.pv.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.inpatient.dto.d.LvHos4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 出院事件
 * 
 * @author yank
 *
 */
public class IpLvHosEvent {
	/**
	 * 触发事件
	 * 
	 * @param lvHos4EsDTO 出院事件源DTO
	 * @throws BizException
	 */
	public void invoke(LvHos4EsDTO lvHos4EsDTO) throws BizException {
		BusinessEvent levHosEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_LEAVE, IEventType.TYPE_UPDATE_AFTER,
				lvHos4EsDTO);
		EventDispatcher.fireEvent(levHosEvent);
	}
}
