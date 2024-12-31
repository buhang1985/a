package iih.en.pv.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.dto.d.OpReg4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 门诊挂号事件
 * 
 * @author yank
 *
 */
public class OpRegEvent {
	/**
	 * 触发门诊挂号事件
	 * 
	 * @param reg4EsDTO 门诊挂号事件源DTO
	 * @throws BizException
	 */
	public void invoke(OpReg4EsDTO reg4EsDTO) throws BizException {
		BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_OP_REG, IEnEventConst.EVENT_EN_OP_REG,
				reg4EsDTO);
		EventDispatcher.fireEvent(opRegEvent);
	}
}
