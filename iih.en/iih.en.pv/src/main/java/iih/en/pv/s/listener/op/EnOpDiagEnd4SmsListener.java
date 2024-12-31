package iih.en.pv.s.listener.op;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.PatEP;
import iih.en.que.dto.d.OpQue4EsDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.OpApt4SmsDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.pub.IScSmsConst;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 诊毕短信通知监听器
 * @author yank
 *
 */
public class EnOpDiagEnd4SmsListener implements IBusinessListener {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、验证事件，是否匹配
		this.validate(event);

		// 2、包装APT结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		OpQue4EsDTO eventSourceDTO = (OpQue4EsDTO)bizUserObj.getUserObj();
		OpApt4SmsDTO aptDTO = wrapObj4Ip(eventSourceDTO);

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
		if (!IEnEventConst.EVENT_SOURCE_EN_OP_QUE.equalsIgnoreCase(event.getSourceID())
				|| !IEnEventConst.EVENT_EN_OP_DIAGEND.equals(event.getEventType())) {
			throw new BizException(IEnMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}
	}
	/**
	 * 包装
	 * @param esDTO
	 * @return
	 */
	private OpApt4SmsDTO wrapObj4Ip(OpQue4EsDTO esDTO) throws BizException{
		OpApt4SmsDTO apt4SmsDTO = new OpApt4SmsDTO();		
		apt4SmsDTO.setName_pat(esDTO.getName_pat());//患者姓名
		apt4SmsDTO.setName_dep(esDTO.getName_dep());//科室		
		PatEP patEP = new PatEP();
		PatDO patDO = patEP.getPatById(esDTO.getId_pat());
		if(patDO==null){
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		}
		apt4SmsDTO.setMobile(patDO.getMob());//手机号码
		
		return apt4SmsDTO;
	}
	/**
	 * 发送消息
	 * @param aptDTO 预约短信DTO
	 * @throws BizException
	 */
	private void sendMsg(OpApt4SmsDTO aptDTO) throws BizException{
		IScAptOutCmdService aptOutCmdService = ServiceFinder.find(IScAptOutCmdService.class);
		aptOutCmdService.sendOpSmsMsg(aptDTO.getMobile(),IScSmsConst.SC_DIAG_END_MSG_TEMPLATE, aptDTO);
	}
}
