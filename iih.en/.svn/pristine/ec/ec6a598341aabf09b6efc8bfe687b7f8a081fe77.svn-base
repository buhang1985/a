package iih.en.pv.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.dto.d.OpReg4EsDTO;
import iih.en.que.dto.d.OpQue4EsDTO;
import iih.en.que.i.IEnQueOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 诊毕事件
 * 
 * @author liubin
 *
 */
public class OpDiagEndEvent {
	private OpQue4EsDTO es = null;
	public OpDiagEndEvent(){}
	
	public OpDiagEndEvent(String entId) throws BizException{
		IEnQueOutQryService serv = ServiceFinder.find(IEnQueOutQryService.class);
		this.es = serv.getOpQue4EsDTO(entId, null, null);
	}
    public OpDiagEndEvent(OpQue4EsDTO es){
		this.es = es;
	}
	/**
	 * 触发诊毕事件
	 * 
	 * @param reg4EsDTO 门诊挂号事件源DTO
	 * @throws BizException
	 */
	public void invoke(OpReg4EsDTO reg4EsDTO) throws BizException {
		BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_OP_QUE, IEnEventConst.EVENT_EN_OP_DIAGEND, reg4EsDTO);
		EventDispatcher.fireEvent(opRegEvent);
	}
	/**
	 * 触发诊毕事件
	 * 
	 * @param reg4EsDTO 门诊挂号事件源DTO
	 * @throws BizException
	 */
	public void invoke() throws BizException {
		BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_OP_QUE, IEnEventConst.EVENT_EN_OP_DIAGEND, es);
		EventDispatcher.fireEvent(opRegEvent);
	}
}
