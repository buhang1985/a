package iih.en.pv.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.custom.EnOpCustomServiceUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.pv.dto.d.OpReg4EsDTO;
import iih.en.pv.dto.d.Reg4IpDTO;
import iih.en.pv.s.listener.bp.GetOpReg4IpBP;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 门诊挂号--集成平台监听器
 * @author yank
 *
 */
public class EnOpReg4IpListener  implements IBusinessListener {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		EnLogUtil enLog= EnLogUtil.getInstance();
		enLog.displayInfo("接收事件: " + event.getEventType()); 
		//1、验证事件，是否匹配
		if(!this.validate(event))
			return;
		enLog.displayInfo("门诊挂号--集成平台监听器: " + event.getUserObject()); 
		//2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		OpReg4EsDTO eventSourceDTO = (OpReg4EsDTO)bizUserObj.getUserObj();
		
		//通过OpReg4EsDTO构造Reg4IpDTO
		GetOpReg4IpBP bp = new GetOpReg4IpBP();
		enLog.displayInfo("门诊挂号--集成平台监听器: " + eventSourceDTO); 
		Reg4IpDTO reg4IpDTO = bp.createReg4IpDTO(eventSourceDTO);
		reg4IpDTO.setMsgtype("new");
		enLog.displayInfo("门诊挂号--集成平台监听器: " + reg4IpDTO); 
		//3、触发门诊挂号集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(reg4IpDTO, BusiType.MZ,"0", "0");//071->0，默认为0 by ldq
		//by ldq  交互码和患者code入库 2017-7-18
		MsgObj msg = new MsgObj();
		msg.setInteractionCode("new");
		msg.setPatientCode(reg4IpDTO.getCode_pat());
		msg.setEntimes(reg4IpDTO.getTimes_en());
		buo.setMsgObj(msg);
		//调用客开处理
		enLog.displayInfo("门诊挂号--集成平台监听器客开处理开始: "); 
		EnOpCustomServiceUtils.handleWrapOpRegist4IeObj(buo);
		enLog.displayInfo("门诊挂号--集成平台监听器客开处理结束: "); 
		// end 
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(),event.getEventType(),buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
		enLog.displayInfo("门诊挂号--集成平台监听器发送集成平台消息结束: "); 
		
	}
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private boolean validate(IBusinessEvent event) throws BizException{
		if(!IEnEventConst.EVENT_SOURCE_EN_OP_REG.equalsIgnoreCase(event.getSourceID())
			|| !IEnEventConst.EVENT_EN_OP_REG.equals(event.getEventType())){
			return false;
		}
		return true;
	}

}
