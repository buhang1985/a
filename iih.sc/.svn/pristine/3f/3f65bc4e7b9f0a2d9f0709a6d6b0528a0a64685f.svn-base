package iih.sc.sch.s.event;

import iih.bd.bc.event.pub.IScEventConst;
import iih.sc.apt.dto.d.OpSchStop4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

public class OpSchStopEvent {
	/**
	 * 触发门诊排班停诊事件
	 * 
	 * @param schStop4EsDTO 门诊排班停诊事件源
	 * @throws BizException
	 */
	public void invoke(OpSchStop4EsDTO schStop4EsDTO) throws BizException {
		BusinessEvent opRegEvent = new BusinessEvent(IScEventConst.EVENT_SOURCE_SOURCE_SC_OP_SCH_STOP, IScEventConst.EVENT_SC_OP_SCH_STOP,
				schStop4EsDTO);
		EventDispatcher.fireEvent(opRegEvent);
	}
}
