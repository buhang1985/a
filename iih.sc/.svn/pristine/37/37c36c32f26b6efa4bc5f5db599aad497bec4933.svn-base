package iih.sc.apt.s.listener;

import iih.bd.bc.event.pub.IScEventConst;
import iih.sc.apt.dto.d.OpApt4EsDTO;
import iih.sc.apt.dto.d.OpApt4SmsDTO;
import iih.sc.apt.s.listener.bp.SendOpSmsMsgBP;
import iih.sc.apt.s.listener.bp.WrapObj2SmsDTOBP;
import iih.sc.comm.IScMsgConst;
import iih.sc.pub.IScSmsConst;
import iih.sc.pub.listener.IOpAptAndPay4EmsListener;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;

/**
 * 门诊预约+交费短信监听器
 * @author yank
 *
 */
public class OpAptAndPay4EmsListener implements IOpAptAndPay4EmsListener {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、验证事件，是否匹配
		this.validate(event);

		// 2、包装APT结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		OpApt4EsDTO eventSourceDTO = (OpApt4EsDTO)bizUserObj.getUserObj();
		OpApt4SmsDTO aptDTO = wrapObj4Ip(eventSourceDTO);
		if (null == aptDTO) {
			return;
		}
		// 3、调用短信发送服务
		this.sendMsg(aptDTO);
	}
	/**
	 * 验证事件
	 * 
	 * @param event 事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException {
		if (!IScEventConst.EVENT_SOURCE_SOURCE_SC_OP_APT.equalsIgnoreCase(event.getSourceID())) {
			throw new BizException(IScMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}
	}
	/**
	 * 包装
	 * @param esDTO
	 * @return
	 */
	private OpApt4SmsDTO wrapObj4Ip(OpApt4EsDTO esDTO) throws BizException{
		WrapObj2SmsDTOBP wrap = new WrapObj2SmsDTOBP();
		return wrap.getSmsByEs(esDTO);
	}
	/**
	 * 发送消息
	 * @param aptDTO 预约短信DTO
	 * @throws BizException
	 */
	private void sendMsg(OpApt4SmsDTO aptDTO) throws BizException{
		SendOpSmsMsgBP smsMsg = new SendOpSmsMsgBP();
		smsMsg.exec(aptDTO.getMobile(),IScSmsConst.SC_APT_AND_PAY_MSG_TEMPLATE, aptDTO);
	}
}
