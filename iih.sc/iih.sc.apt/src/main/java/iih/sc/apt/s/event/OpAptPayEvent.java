package iih.sc.apt.s.event;

import iih.bd.bc.event.pub.IScEventConst;
import iih.sc.apt.dto.d.OpApt4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 门诊预约付费事件
 * @author yank
 *
 */
public class OpAptPayEvent {
	/**
	 * 触发门诊预约取号事件
	 * 
	 * @param apt4EsDTO 门诊预约事件源
	 * @throws BizException
	 */
	public void invoke(OpApt4EsDTO apt4EsDTO) throws BizException {
		BusinessEvent opRegEvent = new BusinessEvent(IScEventConst.EVENT_SOURCE_SOURCE_SC_OP_APT, IScEventConst.EVENT_SC_OP_APT_PAY,
				apt4EsDTO);
		EventDispatcher.fireEvent(opRegEvent);
	}
}
