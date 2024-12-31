package iih.en.pv.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.inpatient.dto.d.TransDept4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 转病区事件
 * 
 * @author yank
 *
 */
public class IpTransWardEvent {
	/**
	 * 触发事件
	 * 
	 * @param transDept4EsDTO 住院转科事件源DTO
	 * @throws BizException
	 */
	public void invoke(TransDept4EsDTO transDept4EsDTO) throws BizException {
		BusinessEvent transWardEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_TRANS_DEPT, IEnEventConst.EVENT_EN_IP_TRANS_WARD,
				transDept4EsDTO);

		EventDispatcher.fireEvent(transWardEvent);
	}
}
