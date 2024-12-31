package iih.en.pv.s.listener.ip.msg;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnMsgConst;
import iih.en.pub.IEnSysMsgConst;
import iih.en.pv.inpatient.dto.d.IpSysMsgDTO;
import iih.en.pv.inpatient.dto.d.TransDept4EsDTO;
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
import xap.sys.message.message.i.IGenerateMessageExtdService;
/**
 * 
 * 住院转出事件监听器
 * 发送消息给住院转入节点
 * 
 * @author liubin
 *
 */
public class EnIpTransOutDept4MsgListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//1、验证事件，是否匹配
		this.validate(event);
		
		//2、包装所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		TransDept4EsDTO transDept4Es = (TransDept4EsDTO)bizUserObj.getUserObj();
		IpSysMsgDTO ipSysMsg = assembly(transDept4Es);
		
		try {
			//发送病区转出消息
			IGenerateMessageExtdService igservice = ServiceFinder
					.find(IGenerateMessageExtdService.class);
			Map<String, Object> data = new HashMap<>();
			data.put(IpSysMsgDTO.class.getSimpleName(), ipSysMsg);
			igservice.GenerateMessageAndMap(IEnSysMsgConst.MSG_TRANSOUT, data, null);
		} catch (Exception e) {
			Logger.error("发送病区转出消息失败：", e);
		}
		
		//3、发送消息
		FireSysMsgEventBP bp = new FireSysMsgEventBP(IEnSysMsgConst.MSG_TRANSIN_DEPT);
		bp.exec(ipSysMsg);
	}
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException{
		if(!IEnEventConst.EVENT_SOURCE_EN_IP_TRANS_DEPT.equalsIgnoreCase(event.getSourceID())
			|| !IEnEventConst.EVENT_EN_IP_TRANSOUT_DEPT.equals(event.getEventType())){
			throw new BizException(IEnMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}		
	}
	/**
	 * 包装所需结构
	 * 
	 * @param event
	 * @return
	 */
	private IpSysMsgDTO assembly(TransDept4EsDTO transDept4Es){
		AssemblySysMsgBP bp = new AssemblySysMsgBP();
		return bp.assemblySysMsgByTransDeptDTO(transDept4Es);
	}
}
