package iih.en.pv.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.inpatient.dto.d.CancelEnterDept4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 取消入科事件
 *
 */
public class IpCancelEnterDeptEvent {
	/**
	 * 触发事件
	 * @param enterDept4EsDTO 取消入科事件源DTO
	 * @throws BizException
	 */
	public void invoke(CancelEnterDept4EsDTO esDTO) throws BizException{	
		BusinessEvent event = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_CANCEL_IN_DEPT, IEventType.TYPE_UPDATE_AFTER,
				esDTO);
		EventDispatcher.fireEvent(event);
	}
	
}
