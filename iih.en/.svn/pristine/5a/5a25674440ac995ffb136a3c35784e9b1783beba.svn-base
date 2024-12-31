package iih.en.pv.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.inpatient.dto.d.ChgHp4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 住院医保改变事件
 * 
 * @author liubin
 *
 */
public class IpHpChgEvent {
	/**
	 * 触发事件
	 * 
	 * @param chghp4EsDTO 住院医保改变事件源DTO
	 * @throws BizException
	 */
	public void invoke(ChgHp4EsDTO chghp4EsDTO) throws BizException {
		BusinessEvent ipRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_CHGHP, IEventType.TYPE_UPDATE_AFTER,
				chghp4EsDTO);
		EventDispatcher.fireEvent(ipRegEvent);
	}
}
