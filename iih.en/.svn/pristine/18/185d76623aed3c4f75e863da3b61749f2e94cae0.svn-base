package iih.en.pv.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.inpatient.dto.d.RentBed4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 包床事件
 * @author yank
 *
 */
public class IpRentBedEvent {
	/**
	 * 触发事件
	 * @param rentBed4EsDTO 包床事件源DTO
	 * @throws BizException
	 */
	public void invoke(RentBed4EsDTO rentBed4EsDTO) throws BizException{	
		BusinessEvent rentBedEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_RENT_BED, IEventType.TYPE_UPDATE_AFTER,
				rentBed4EsDTO);
		EventDispatcher.fireEvent(rentBedEvent);
	}
}
