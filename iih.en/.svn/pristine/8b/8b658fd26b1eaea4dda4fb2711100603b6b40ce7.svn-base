package iih.en.pv.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.inpatient.dto.d.LvDep4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 出科事件
 * 
 * @author
 *
 */
public class IpLvDepEvent {
	/**
	 * 触发事件
	 * 
	 * @param lvDep4EsDTO
	 *            出科事件源DTO
	 * @throws BizException
	 */
	public void invoke(LvDep4EsDTO lvDep4EsDTO) throws BizException {
		BusinessEvent levDepEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_LEAVE_DEP,
				IEventType.TYPE_UPDATE_AFTER, lvDep4EsDTO);
		EventDispatcher.fireEvent(levDepEvent);
	}
}
