package iih.en.er.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.inpatient.dto.d.EnterDept4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 抢救患者入科事件
 *
 */
public class UrgPatDepEvent {
	/**
	 * 触发事件
	 * @param enterDept4IpDTO 抢救患者入科事件事件源DTO
	 * @throws BizException
	 */
	public void invoke(EnterDept4EsDTO enterDept4EsDTO) throws BizException{	
		BusinessEvent enterDeptEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_IN_DEPT,IEnEventConst.EVENT_EN_URGPAT_ENTER_DEPT,
				enterDept4EsDTO);
		EventDispatcher.fireEvent(enterDeptEvent);
	}
	
}
