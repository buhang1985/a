package iih.en.que.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.que.dto.d.OpQue4EsDTO;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 门诊--患者取消签到事件
 * 
 * @author yank
 *
 */
public class OpCancSignInEvent {
	/**
	 * 触发患者取消签到事件
	 * 
	 * @param opQue4EsDTO 门诊队列事件源DTO
	 * @throws BizException
	 */
	public void invoke(OpQue4EsDTO opQue4EsDTO) throws BizException{
		BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_OP_QUE, IEnEventConst.EVENT_EN_OP_CANC_SIGNIN,
				opQue4EsDTO);
		Logger.info("发送取消到诊事件: " + opQue4EsDTO);
		EventDispatcher.fireEvent(opRegEvent);
	}
}