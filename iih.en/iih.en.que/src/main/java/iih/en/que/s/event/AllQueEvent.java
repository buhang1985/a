package iih.en.que.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.AllQue4EsDTO;
import iih.en.que.s.event.bp.WrapObj2AllQue4EsBP;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
/***
 * 通用队列事件
 * @author fanlq
 *
 */
public class AllQueEvent {

	public void exec(String quesiteId,String queId,String entqueId,String ticketno,String id_queben,String event) throws BizException{
		if(EnValidator.isEmpty(event))
			return;
		//1.组装数据源
		WrapObj2AllQue4EsBP bp = new WrapObj2AllQue4EsBP();
		AllQue4EsDTO allQue4EsDTO = bp.warp(quesiteId,queId,entqueId,ticketno,id_queben);
		switch(event){
			case IEnEventConst.EVENT_EN_ALL_SIGNIN://到诊
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_SIGNIN);
				break;
			case IEnEventConst.EVENT_EN_ALL_CANC_SIGNIN://取消到诊
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_CANC_SIGNIN);
				break;
			case IEnEventConst.EVENT_EN_ALL_TRIAGE://分诊
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_TRIAGE);
				break;
			case IEnEventConst.EVENT_EN_ALL_CANC_TRIAGE://取消分诊
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_CANC_TRIAGE);
				break;
			case IEnEventConst.EVENT_EN_ALL_DOC_ONLINE://上线
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_DOC_ONLINE);
				break;
			case IEnEventConst.EVENT_EN_ALL_DOC_OFFLINE://下线
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_DOC_OFFLINE);
				break;
			case IEnEventConst.EVENT_EN_ALL_DOC_PAUSE://暂停
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_DOC_PAUSE);
				break;
			case IEnEventConst.EVENT_EN_ALL_DOC_CONTINUE://继续
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_DOC_CONTINUE);
				break;
			case IEnEventConst.EVENT_EN_ALL_CALLNUM://叫号
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_CALLNUM);
				break;
			case IEnEventConst.EVENT_EN_ALL_SELECTED_CALLNUM://选择叫号
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_SELECTED_CALLNUM);
				break;
			case IEnEventConst.EVENT_EN_ALL_PASSNUM://过号
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_PASSNUM);
				break;
			case IEnEventConst.EVENT_EN_ALL_DOC_ACPT://处置
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_DOC_ACPT);
				break;
			case IEnEventConst.EVENT_EN_ALL_DOC_CANC_ACPT://取消处置
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_DOC_CANC_ACPT);
				break;
			case IEnEventConst.EVENT_EN_ALL_DIAGEND://处置完成
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_DIAGEND);
				break;
			default:
				throw new BizException(IEnMsgConst.ERROR_LISTENER_NO_SOURCE);
		}
	}

	/**
	 * 触发通用队列事件
	 * 
	 * @param opQue4EsDTO 门诊队列事件源DTO
	 * @throws BizException
	 */
	public void invoke(AllQue4EsDTO allQue4EsDTO,String event) throws BizException {
		BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_ALL_QUE, event,allQue4EsDTO);
		Logger.info("发送通用队列事件: "+event+";发送数据：" + allQue4EsDTO);
		EventDispatcher.fireEvent(opRegEvent);
	}
}
