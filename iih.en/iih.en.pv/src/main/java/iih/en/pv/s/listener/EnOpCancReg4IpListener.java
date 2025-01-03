package iih.en.pv.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.custom.EnOpCustomServiceUtils;
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
 * 门诊退号--集成平台监听器
 * @author yank
 *
 */
public class EnOpCancReg4IpListener  implements IBusinessListener {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//1、验证事件，是否匹配
		this.validate(event);
		
		//2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		OpReg4EsDTO eventSourceDTO = (OpReg4EsDTO)bizUserObj.getUserObj();
		//通过OpReg4EsDTO构造Reg4IpDTO
		GetOpReg4IpBP bp = new GetOpReg4IpBP();
		Reg4IpDTO reg4IpDTO = bp.createReg4IpDTO(eventSourceDTO);
		reg4IpDTO.setMsgtype("cancel");
		
		//3、触发门诊挂号集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(reg4IpDTO, BusiType.MZ, "0", "0");
		MsgObj msg = new MsgObj();
		msg.setInteractionCode("cancel");
		msg.setPatientCode(reg4IpDTO.getCode_pat());
		msg.setEntimes(reg4IpDTO.getTimes_en());
		buo.setMsgObj(msg);
		//调用客开处理
		EnOpCustomServiceUtils.handleWrapOpRegist4IeObj(buo);
		
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(),event.getEventType(),buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
	}
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException{
		if(!IEnEventConst.EVENT_SOURCE_EN_OP_REG.equalsIgnoreCase(event.getSourceID())
			|| !IEnEventConst.EVENT_EN_OP_CANC_REG.equals(event.getEventType())){
			throw new BizException(IEnMsgConst.ERROR_OPREG4IP_LISTENER_NOT_MATCH_EVENT);
		}		
	}
}
