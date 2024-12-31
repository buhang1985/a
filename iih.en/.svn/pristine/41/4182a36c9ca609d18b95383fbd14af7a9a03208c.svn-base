package iih.en.pv.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.inpatient.dto.d.IpReg4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 住院取消登记事件
 * 
 * @author yank
 *
 */
public class IpCancRegEvent {
	/**
	 * 触发事件
	 * 
	 * @param regEsDTO 住院登记事件源DTO
	 * @throws BizException
	 */
	public void invoke(IpReg4EsDTO reg4EsDTO) throws BizException {
		BusinessEvent ipRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_CANC_REG, IEventType.TYPE_UPDATE_AFTER,
				reg4EsDTO);
		EventDispatcher.fireEvent(ipRegEvent);
	}

}
