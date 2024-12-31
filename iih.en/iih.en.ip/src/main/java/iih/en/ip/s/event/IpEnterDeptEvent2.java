package iih.en.ip.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.inpatient.dto.d.EnterDept4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 住院入科事件
 * @author li.wm
 *
 */
public class IpEnterDeptEvent2 {
	/**
	 * 触发事件
	 * @param enterDept4EsDTO 住院入科事件源DTO
	 * @throws BizException
	 */
	public void invoke(EnterDept4EsDTO enterDept4EsDTO) throws BizException{	
		BusinessEvent enterDeptEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_IN_DEPT, IEventType.TYPE_UPDATE_AFTER,
				enterDept4EsDTO);
		EventDispatcher.fireEvent(enterDeptEvent);
	}
}
