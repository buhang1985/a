package iih.ci.event.ord.listeners;

import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.ip.cfg.XipCfg;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
/**
 * 门诊住院发往集成平台公共监听
 * @author F
 *
 * @date 2019年9月3日上午9:48:23
 *
 * @classpath iih.ci.event.ord.listeners.OPIPSendIECommonListener
 */
public abstract class OPIPSendIECommonListener implements IBusinessListener{
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(OPIPSendIECommonListener.class.getSimpleName(), "进入 门诊住院发往集成平台 公共监听类");
		// 如果inDb=disable，那么所有的消息不入库
		if (!XipCfg.instance().isEnableInDb()) {return;}
		if(OrdEventUtil.isEmpty(event)) {return;}
		//事件源及事件类型判断
		if(!isMatchSourceIdAndEventType(event)) return;
		//转换获取到的数据
		BaseDTO baseDTO=transformData(event);
		//实现自身逻辑-组装发送数据
		doYourAction(baseDTO);
	}
	/**
	 * 转换获取到的数据
	 * @param event
	 * @return
	 * @throws BizException
	 */
	private BaseDTO transformData(IBusinessEvent event)throws BizException{
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(OrdEventUtil.isEmpty(newObjs))return null;
		BaseDTO baseDTO=null;
		if(newObjs[0] instanceof BaseDTO) {
			baseDTO=(BaseDTO)newObjs[0];
			return baseDTO;
		}
		//只支持BaseDTO作为参数，原因：门诊住院签署撤回等只有idors或者iden等值
		//，根本就不会传过其他的值来，没必要这么复杂 诊断和退费不走这的逻辑，整体结构就不一样
		return null;
	}
	/**
	 * 事件源及事件类型判断 
	 * @param sourceId
	 * @param eventType
	 * @throws BizException
	 */
	public abstract boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException;
	/**
	 * 实现自身逻辑-组装发送数据
	 * @param firedto
	 * @throws BizException
	 */
	private void doYourAction(BaseDTO baseDTO) throws BizException {
		BaseDTO[] baseDTOs=null;
		Long startTIme = System.currentTimeMillis();
		//组装(查询)数据
		if(!OrdEventUtil.isEmpty(baseDTO)) {
			baseDTOs=assembleData(baseDTO);
			OrdEventLogger.info(this.getClass().getSimpleName(), "临床集成平台，组装数据耗时  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		}
		//发送数据到集成平台
		if(!OrdEventUtil.isEmpty(baseDTOs)) {
			startTIme = System.currentTimeMillis();
			sendMessagesToIE(baseDTOs);
			OrdEventLogger.info(this.getClass().getSimpleName(), "临床集成平台，发送消息耗时  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		}
	}
	/**
	 * 组装(查询)数据
	 * @param baseDTO
	 * @return
	 * @throws BizException
	 */
	public abstract BaseDTO[] assembleData(BaseDTO baseDTO)throws BizException;
	/**
	 * 发送数据到集成平台
	 * @param dtos
	 * @throws BizException
	 */
	public abstract void sendMessagesToIE(BaseDTO[] dtos)throws BizException;
}
