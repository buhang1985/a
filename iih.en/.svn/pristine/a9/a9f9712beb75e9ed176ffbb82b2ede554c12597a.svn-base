package iih.en.que.s.event;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.util.DateTimeUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.AllQue4EsDTO;
import iih.en.que.s.event.bp.WrapObj2DrugQue4EsBP;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/****
 * 药房队列事件
 * @author fanlq
 *
 */
public class DrugQueEvent {
	/***
	 * 药房队列事件
	 * @param quesiteId
	 * @param queId
	 * @param event
	 * @throws BizException
	 */
	public void exec(String quesiteId,String entqueId,String presids,String event) throws BizException{
		if(EnValidator.isEmpty(event))
			return;
		EnLogUtil logUtil =EnLogUtil.getInstance();
		String nowDate = DateTimeUtils.getNow();
		logUtil.logInfo("调用一次药房窗口大屏，时间："+nowDate);
		logUtil.logInfo("接收到的消息:quesiteId/"+quesiteId+"/就诊队列Id/"+entqueId+"/处方id/"+presids+"/事件/"+event);
		//组装上屏数据
		WrapObj2DrugQue4EsBP bp = new WrapObj2DrugQue4EsBP();
		AllQue4EsDTO allQue4EsDTO = bp.exec(quesiteId,entqueId,presids, event);
		logUtil.logInfo("调用一次药房窗口大屏，组装后的上屏消息："+allQue4EsDTO);
		switch(event){
			case IEnEventConst.EVENT_DRUG_ONLIN://上线
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_DRUG_ONLIN);
				break;
			case IEnEventConst.EVENT_DRUG_OFFLIN://下线
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_DRUG_OFFLIN);
				break;
			case IEnEventConst.EVENT_DRUG_SIGNIN://处方分配到窗口
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_DRUG_SIGNIN);
				break;
			case IEnEventConst.EVENT_DRUG_DISPENSING://发药
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_DRUG_DISPENSING);
				break;
			case IEnEventConst.EVENT_DRUG_CALLNUM://叫号
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_DRUG_CALLNUM);
				break;
			case IEnEventConst.EVENT_DRUG_DOSAGE://药房配药
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_DRUG_DOSAGE);
				break;
			case IEnEventConst.EVENT_DRUG_CALLNOARRIVAL://药房叫号未到
				this.invoke(allQue4EsDTO, IEnEventConst.EVENT_DRUG_CALLNOARRIVAL);
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
		Logger.info("发送药房窗口队列事件: "+event+";发送数据：" + allQue4EsDTO);
		EventDispatcher.fireEvent(opRegEvent);
	}
}
