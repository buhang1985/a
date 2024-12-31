package iih.en.pv.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.inpatient.dto.d.Recall4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 出院召回事件
 * @author yank
 *
 */
public class IpRecallEvent {
	/**
	 * 触发事件
	 * @param recall4EsDTO 出院召回事件源DTO
	 * @throws BizException
	 */
	public void invoke(Recall4EsDTO recall4EsDTO) throws BizException{	
		BusinessEvent recallEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_RECALL, IEventType.TYPE_UPDATE_AFTER,
				recall4EsDTO);
		EventDispatcher.fireEvent(recallEvent);
	}
	
}
