package iih.en.pv.s.listener.ip.msg;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnMsgConst;
import iih.en.pub.IEnSysMsgConst;
import iih.en.pv.inpatient.dto.d.IpReg4EsDTO;
import iih.en.pv.inpatient.dto.d.IpSysMsgDTO;
import iih.en.pv.s.listener.ip.msg.bp.AssemblySysMsgBP;
import iih.en.pv.s.listener.ip.msg.bp.FireSysMsgEventBP;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.message.message.i.IGenerateMessageExtdService;

/**
 * 住院登记事件监听器
 * 发送消息给病区接收节点
 * 
 * @author Administrator
 *
 */
public class EnIpReg4MsgListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//1、验证事件，是否匹配
		this.validate(event);
		
		//2、包装所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		IpReg4EsDTO ipReg4Es = (IpReg4EsDTO)bizUserObj.getUserObj();
		IpSysMsgDTO ipSysMsg = assembly(ipReg4Es);
		
		//3、发送消息
		try {
			//发送病区转出消息
			IGenerateMessageExtdService igservice = ServiceFinder
					.find(IGenerateMessageExtdService.class);
			Map<String, Object> data = new HashMap<>();
			data.put(IpSysMsgDTO.class.getSimpleName(), ipSysMsg);
			igservice.GenerateMessageAndMap(IEnSysMsgConst.MSG_IN_HOSPITAL, data, null);
		} catch (Exception e) {
			Logger.error("发送病区转出消息失败：", e);
		}
		FireSysMsgEventBP bp = new FireSysMsgEventBP(IEnSysMsgConst.MSG_IN_HOSPITAL);
		bp.exec(ipSysMsg);
	}
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException{
		if(!IEnEventConst.EVENT_SOURCE_EN_IP_REG.equalsIgnoreCase(event.getSourceID())
			|| !IEventType.TYPE_INSERT_AFTER.equals(event.getEventType())){
			throw new BizException(IEnMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}		
	}
	/**
	 * 包装所需结构
	 * 
	 * @param event
	 * @return
	 */
	private IpSysMsgDTO assembly(IpReg4EsDTO ipReg4Es){
		
		AssemblySysMsgBP bp = new AssemblySysMsgBP();
		return bp.assemblySysMsgByIpRegDTO(ipReg4Es);
	}
}
