package iih.en.pv.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.inpatient.dto.d.IpRegInfoDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 修改入院时间、入科时间
 * 
 * @author li.wm
 *
 */
public class IpModifyEntryAcptEnevt {
	/**
	 * 触发入院时间、入科时间事件
	 * 
	 * @param IpRegInfoDTO 修该入院时间、入科时间事件源DTO
	 * @throws BizException
	 */
	public void invoke(IpRegInfoDTO ipRegInfoDTO) throws BizException {
		BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_ENT, IEnEventConst.EVENT_ENIP_MODIFY_ENTRYACPT,
				ipRegInfoDTO);
		EventDispatcher.fireEvent(opRegEvent);
	}
}
