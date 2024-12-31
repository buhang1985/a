package iih.ci.event.ord.listeners.refund.op;

import java.util.ArrayList;

import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.ip.cfg.XipCfg;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
/**
 * 门诊退费发往集成平台公共监听
 * @author F
 *
 * @date 2019年9月16日下午4:28:09
 *
 * @classpath iih.ci.event.ord.listeners.refund.op.OpRefundSendCommonListener
 */
public abstract class OpRefundSendCommonListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(OpRefundSendCommonListener.class.getSimpleName(), "进入 门诊退费发往集成平台 公共监听类");
		// 如果inDb=disable，那么所有的消息不入库
		if (!XipCfg.instance().isEnableInDb()) {return;}
		if(OrdEventUtil.isEmpty(event)) {return;}
		//事件源及事件类型判断
		if(!isMatchSourceIdAndEventType(event)) return;
		//转换获取到的数据
		OpRefund4IpEsDTO[] firedto=transformData(event);
		//实现自身逻辑-组装发送数据
		doYourAction(firedto);
	}
	/**
	 * 转换获取到的数据
	 * @param event
	 * @return
	 * @throws BizException
	 */
	private OpRefund4IpEsDTO[] transformData(IBusinessEvent event)throws BizException{
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(OrdEventUtil.isEmpty(newObjs))return null;
		OpRefund4IpEsDTO[] firedto=getDtos(newObjs);
		return firedto;
	}
	protected OpRefund4IpEsDTO[] getDtos(Object[] newObjs){
		OpRefund4IpEsDTO dto;
		ArrayList<OpRefund4IpEsDTO> rtn=new ArrayList<OpRefund4IpEsDTO>();
		//遍历
		for(Object obj: newObjs ){
			dto=(OpRefund4IpEsDTO) obj;
			//加入列表中
			rtn.add(dto);
		}
		//空判断
		if(OrdEventUtil.isEmpty(rtn))return null;
		//返回值
		return rtn.toArray(new OpRefund4IpEsDTO[0]);
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
	private void doYourAction(OpRefund4IpEsDTO[] opRefund4IpEsDTOs) throws BizException {
		BaseDTO[] baseDTOs=null;
		//组装(查询)数据
		if(!OrdEventUtil.isEmpty(opRefund4IpEsDTOs)) {
			baseDTOs=assembleData(opRefund4IpEsDTOs);
		}
		//发送数据到集成平台
		if(!OrdEventUtil.isEmpty(baseDTOs)) {
			sendMessagesToIE(baseDTOs);
		}
	}
	/**
	 * 组装(查询)数据
	 * @param firedto
	 * @return
	 * @throws BizException
	 */
	public abstract BaseDTO[] assembleData(OpRefund4IpEsDTO[] opRefund4IpEsDTOs)throws BizException;
	/**
	 * 发送数据到集成平台
	 * @param dtos
	 * @throws BizException
	 */
	public abstract void sendMessagesToIE(BaseDTO[] dtos)throws BizException;
}
