package iih.en.ip.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.inpatient.dto.d.ChgEmp4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 医护人员修改事件
 * @author li.wm
 *
 */
public class IpChgEmpEvent2 {
	/**
	 * 触发事件
	 * @param chgEmp4EsDTO 换床事件源DTO
	 * @throws BizException
	 */
	public void invoke(ChgEmp4EsDTO chgEmp4EsDTO) throws BizException{	
		BusinessEvent chgBedEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_CHG_EMP, IEventType.TYPE_UPDATE_AFTER,
				chgEmp4EsDTO);
		EventDispatcher.fireEvent(chgBedEvent);
	}
}
