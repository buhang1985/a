package iih.en.pv.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.dto.d.OpReg4EsDTO;
import iih.en.que.dto.d.OpQue4EsDTO;
import iih.en.que.i.IEnQueOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
/**
 * 触发医生待回诊事件
 * @author fanlq
 *
 */
public class OPDiagNoseContinueEvent {
	
	private OpQue4EsDTO es = null;
	
	public OPDiagNoseContinueEvent(String entId) throws BizException{
		IEnQueOutQryService serv = ServiceFinder.find(IEnQueOutQryService.class);
		this.es = serv.getOpQue4EsDTO(entId, null, null);
	}
    public OPDiagNoseContinueEvent(OpQue4EsDTO es){
		this.es = es;
	}
    
	/**
	 * 触发待回诊事件
	 * 
	 * @param reg4EsDTO 门诊挂号事件源DTO
	 * @throws BizException
	 */
	public void invoke(OpReg4EsDTO reg4EsDTO) throws BizException {
		BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_OP_QUE, IEnEventConst.EVENT_EN_OP_DIAGNOSECONTINUE, reg4EsDTO);
		EventDispatcher.fireEvent(opRegEvent);
	}
	/**
	 * 触发待回诊事件
	 * 
	 * @param reg4EsDTO 门诊挂号事件源DTO
	 * @throws BizException
	 */
	public void invoke() throws BizException {
		BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_OP_QUE, IEnEventConst.EVENT_EN_OP_DIAGNOSECONTINUE, es);
		EventDispatcher.fireEvent(opRegEvent);
	}
	/**
	 * 触发医生待回诊事件
	 * 
	 * @param opQue4EsDTO 门诊队列事件源DTO
	 * @throws BizException
	 */
	public void invoke(OpQue4EsDTO opQue4EsDTO) throws BizException {
		BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_OP_QUE, IEnEventConst.EVENT_EN_OP_DIAGNOSECONTINUE,
				opQue4EsDTO);
		Logger.info("发送待回诊事件: " + opQue4EsDTO);
		EventDispatcher.fireEvent(opRegEvent);
	}

	
}
