package iih.en.que.s.event.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.OpQue4EsDTO;
import iih.en.que.s.event.OpAcptEvent;
import iih.en.que.s.event.OpCallNumEvent;
import iih.en.que.s.event.OpCancAcptEvent;
import iih.en.que.s.event.OpCancCallNumEvent;
import iih.en.que.s.event.OpCancSignInEvent;
import iih.en.que.s.event.OpCancTriageEvent;
import iih.en.que.s.event.OpDocOfflineEvent;
import iih.en.que.s.event.OpDocOnlineEvent;
import iih.en.que.s.event.OpPassNumEvent;
import iih.en.que.s.event.OpSignInEvent;
import iih.en.que.s.event.OpTriageEvent;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;

/**
 * 门诊队列事件BP
 * 
 * @author liubin
 *
 */
public class EnOpQueEventBP {

	/**
	 * 触发事件
	 * 
	 * @param queId 队列ID
	 * @param siteId 站点ID
	 * @param entId 就诊ID
	 * @param eventType 事件类型
	 * @throws BizException 
	 */
	public void invokeEnOpQueEvent(String queId, String siteId, String codeEnTp, String entId, String eventType) throws BizException{
		try{
			Logger.info("发送事件：" + eventType);
			WrapObj2OpQue4EsBP wrapBp = new WrapObj2OpQue4EsBP();
			OpQue4EsDTO es = wrapBp.wrap(queId, siteId, codeEnTp, entId);
			this.invokeEnOpQueEvent(es, eventType);
		}catch(Exception ex){
			Logger.error("发送事件：", ex);
		}
	}
	
	/**
	 * 触发下线事件 fanlq 2017-08-24
	 * 
	 * @param queId
	 *            队列ID
	 * @param siteId
	 *            站点ID
	 * @param entId
	 *            就诊ID
	 * @param empId
	 *            医生ID
	 * @param eventType
	 *            事件类型
	 * @throws BizException
	 */
	public void invokeEnOpQueOutEvent(String queId, String siteId, String codeEnTp, String entId, String eventType, String empId) throws BizException {
		try {
			Logger.info("发送事件：" + eventType);
			WrapObj2OpQue4EsBP wrapBp = new WrapObj2OpQue4EsBP();
			OpQue4EsDTO es = wrapBp.wrapLogOut(queId, siteId, codeEnTp, entId, empId);
			this.invokeEnOpQueEvent(es, eventType);
		} catch (Exception ex) {
			Logger.error("发送事件：", ex);
		}
	}
		
	/**
	 * 触发事件
	 * 
	 * @param es 事件数据源
	 * @param eventType 事件类型
	 * @throws BizException
	 */
	public void invokeEnOpQueEvent(OpQue4EsDTO es, String eventType) throws BizException{
		//1、验证数据
		this.validate(es, eventType);
		//3.触发事件
		this.invoke(es, eventType);
	}

	/**
	 * 触发事件
	 * 
	 * @param es
	 * @param eventType
	 * @throws BizException 
	 */
	private void invoke(OpQue4EsDTO es, String eventType) throws BizException {
		switch (eventType) {
		case IEnEventConst.EVENT_EN_OP_SIGNIN:
			// 到诊
			OpSignInEvent signInEvent = new OpSignInEvent();
			signInEvent.invoke(es);
			break;
		case IEnEventConst.EVENT_EN_OP_CANC_SIGNIN:
			// 取消到诊
			OpCancSignInEvent cancSignInEvent = new OpCancSignInEvent();
			cancSignInEvent.invoke(es);
			break;
		case IEnEventConst.EVENT_EN_OP_TRIAGE:
			OpTriageEvent triageEvent = new OpTriageEvent();
			triageEvent.invoke(es);
			// 分诊
			break;
		case IEnEventConst.EVENT_EN_OP_CANC_TRIAGE:
			// 取消分诊
			OpCancTriageEvent cancTriageEvent = new OpCancTriageEvent();
			cancTriageEvent.invoke(es);
			break;
		case IEnEventConst.EVENT_EN_OP_DOC_ONLINE:
			// 医生上线
			OpDocOnlineEvent docOnlineEvent = new OpDocOnlineEvent();
			docOnlineEvent.invoke(es);
			break;
		case IEnEventConst.EVENT_EN_OP_DOC_OFFLINE:
			// 医生下线
			OpDocOfflineEvent docOfflineEvent = new OpDocOfflineEvent();
			docOfflineEvent.invoke(es);
			break;
		case IEnEventConst.EVENT_EN_OP_CALLNUM: 
			// 叫号
			OpCallNumEvent callNumEvent = new OpCallNumEvent();
			callNumEvent.invoke(es);
			break;
		case IEnEventConst.EVENT_EN_OP_CANC_CALLNUM:
			// 取消叫号
			OpCancCallNumEvent cancCallNumEvent = new OpCancCallNumEvent();
			cancCallNumEvent.invoke(es);
			break;
		case IEnEventConst.EVENT_EN_OP_PASSNUM:
			//过号
			OpPassNumEvent passNumEvent = new OpPassNumEvent();
			passNumEvent.invoke(es);
			break;
		case IEnEventConst.EVENT_EN_OP_DOC_ACPT:
			// 接诊
			OpAcptEvent acptEvent = new OpAcptEvent();
			acptEvent.invoke(es);
			break;
		case IEnEventConst.EVENT_EN_OP_DOC_CANC_ACPT:
			// 取消接诊
			OpCancAcptEvent cancAcptEvent = new OpCancAcptEvent();
			cancAcptEvent.invoke(es);
			break;
		default:
			throw new BizException(IEnMsgConst.ERROR_ENOPQUE_EVENT_TYPE);
		}
	}
	/**
	 * 验证数据
	 * 
	 * @param enQue
	 * @throws BizException 
	 */
	private void validate(OpQue4EsDTO opQue4Es, String eventType) throws BizException{
		EnValidator.validateParam("opQue4Es", opQue4Es);
		EnValidator.validateParam("eventType", eventType);
	}
}
