package iih.en.pv.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.inpatient.dto.d.ChgBed4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 换床事件
 * @author yank
 *
 */
public class IpChgBedEvent {
	/**
	 * 触发事件
	 * @param chgBed4EsDTO 换床事件源DTO
	 * @throws BizException
	 */
	public void invoke(ChgBed4EsDTO chgBed4EsDTO) throws BizException{	
		BusinessEvent chgBedEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_CHANGE_BED, IEventType.TYPE_UPDATE_AFTER,
				chgBed4EsDTO);
		EventDispatcher.fireEvent(chgBedEvent);
	}
}
