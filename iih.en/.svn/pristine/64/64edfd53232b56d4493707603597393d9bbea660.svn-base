package iih.en.pv.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.inpatient.dto.d.TransDept4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 转科事件
 * 
 * @author yank
 *
 */
public class IpTransDeptEvent {
	/**
	 * 触发事件
	 * 
	 * @param transDept4EsDTO 住院转科事件源DTO
	 * @throws BizException
	 */
	public void invoke(TransDept4EsDTO transDept4EsDTO) throws BizException {
		BusinessEvent ipRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_TRANS_DEPT, IEventType.TYPE_UPDATE_AFTER,
				transDept4EsDTO);

		EventDispatcher.fireEvent(ipRegEvent);
	}
}
