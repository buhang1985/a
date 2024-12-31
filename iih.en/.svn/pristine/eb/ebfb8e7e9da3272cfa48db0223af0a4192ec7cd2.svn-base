package iih.en.que.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.AllQue4EsDTO;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
/****
 * 通用队列-发送事件
 * @author fanlq
 * @date: 2020年2月3日 下午3:39:34
 */
public class AllQueEventNew {
	/***
	 * @Description:触发通用队列事件
	 * @param allQue4EsDTO
	 * @param event
	 * @throws BizException
	 */
	public void exec(AllQue4EsDTO allQue4EsDTO,String event) throws BizException{
		if(EnValidator.isEmpty(event))
			return;
		switch(event){
			case IEnEventConst.EVENT_EN_ALL_SIGNIN://到诊
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_SIGNIN);
				Logger.info("发送通用队列患者到诊事件: " + allQue4EsDTO);
				break;
			case IEnEventConst.EVENT_EN_ALL_CANC_SIGNIN://取消到诊
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_CANC_SIGNIN);
				Logger.info("发送通用队列患者取消到诊事件: " + allQue4EsDTO);
				break;
			case IEnEventConst.EVENT_EN_ALL_TRIAGE://分诊
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_TRIAGE);
				Logger.info("发送通用队列分诊事件: " + allQue4EsDTO);
				break;
			case IEnEventConst.EVENT_EN_ALL_CANC_TRIAGE://取消分诊
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_CANC_TRIAGE);
				Logger.info("发送通用队列取消分诊事件: " + allQue4EsDTO);
				break;
			case IEnEventConst.EVENT_EN_ALL_DOC_ONLINE://上线
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_DOC_ONLINE);
				Logger.info("发送通用队列上线事件: " + allQue4EsDTO);
				break;
			case IEnEventConst.EVENT_EN_ALL_DOC_OFFLINE://下线
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_DOC_OFFLINE);
				Logger.info("发送通用队列上线事件: " + allQue4EsDTO);
				break;
			case IEnEventConst.EVENT_EN_ALL_DOC_PAUSE://暂停
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_DOC_PAUSE);
				Logger.info("发送通用队列暂停事件: " + allQue4EsDTO);
				break;
			case IEnEventConst.EVENT_EN_ALL_DOC_CONTINUE://继续
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_DOC_CONTINUE);
				Logger.info("发送通用队列继续事件: " + allQue4EsDTO);
				break;
			case IEnEventConst.EVENT_EN_ALL_CALLNUM://叫号
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_CALLNUM);
				Logger.info("发送通用队列叫号事件: " + allQue4EsDTO);
				break;
			case IEnEventConst.EVENT_EN_ALL_SELECTED_CALLNUM://选择叫号
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_SELECTED_CALLNUM);
				Logger.info("发送通用队列选择叫号事件: " + allQue4EsDTO);
				break;
			case IEnEventConst.EVENT_EN_ALL_PASSNUM://过号
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_PASSNUM);
				Logger.info("发送通用队列过号事件: " + allQue4EsDTO);
				break;
			case IEnEventConst.EVENT_EN_ALL_DOC_ACPT://处置
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_DOC_ACPT);
				Logger.info("发送通用队列处置事件: " + allQue4EsDTO);
				break;
			case IEnEventConst.EVENT_EN_ALL_DOC_CANC_ACPT://取消处置
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_DOC_CANC_ACPT);
				Logger.info("发送通用队列取消处置事件: " + allQue4EsDTO);
				break;
			case IEnEventConst.EVENT_EN_ALL_DIAGEND://处置完成
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_EN_ALL_DIAGEND);
				Logger.info("发送通用队列处置完成事件: " + allQue4EsDTO);
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
