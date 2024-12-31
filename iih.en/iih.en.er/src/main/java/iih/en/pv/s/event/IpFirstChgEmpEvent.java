package iih.en.pv.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.inpatient.dto.d.ChgEmp4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 首次责任医生录入事件
 * 
 * @author liubin 
 *
 */
public class IpFirstChgEmpEvent {
	/**
	 * 触发事件
	 * @param chgEmp4EsDTO 医护人员修改事件源
	 * @throws BizException
	 */
	public void invoke(ChgEmp4EsDTO chgEmp4EsDTO) throws BizException{	
		BusinessEvent chgBedEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_IP_CHG_EMP, IEnEventConst.EVENT_EN_IP_FIRST_ENTRY_EMP,
				chgEmp4EsDTO);
		EventDispatcher.fireEvent(chgBedEvent);
	}
}
