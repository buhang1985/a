package iih.en.pv.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.event.pub.IScEventConst;
import iih.en.comm.custom.EnOpCustomServiceUtils;
import iih.en.pv.dto.d.OpReg4EsDTO;
import iih.en.pv.dto.d.Reg4IpDTO;
import iih.en.pv.s.listener.bp.GetOpReg4IpBP;
import iih.sc.apt.dto.d.OpApt4EsDTO;
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
 * 门诊预约取号--集成平台监听器
 * @author yank
 *
 */
public class EnOpAptTake4IpListener  implements IBusinessListener {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//1、验证事件，是否匹配
		if(!this.validate(event))
			return;
		//2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		OpApt4EsDTO esDTO = (OpApt4EsDTO)bizUserObj.getUserObj();		
		OpReg4EsDTO reg4EsDTO = new OpReg4EsDTO();
		reg4EsDTO.setId_ent(esDTO.getId_ent());
		reg4EsDTO.setId_pat(esDTO.getId_pat());
		GetOpReg4IpBP bp = new GetOpReg4IpBP();
		Reg4IpDTO reg4IpDTO = bp.createReg4IpDTO(reg4EsDTO);
		reg4IpDTO.setMsgtype("new");
		
		//3、触发门诊挂号集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(reg4IpDTO, BusiType.MZ, "0", "0");
		MsgObj msg = new MsgObj();
		msg.setInteractionCode("new");
		msg.setPatientCode(reg4IpDTO.getCode_pat());
		msg.setEntimes(reg4IpDTO.getTimes_en());
		buo.setMsgObj(msg);
		//调用客开处理
		EnOpCustomServiceUtils.handleWrapOpRegist4IeObj(buo);
		
		BusinessEvent bizEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_OP_REG, IEnEventConst.EVENT_EN_OP_REG, buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
	}
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private boolean validate(IBusinessEvent event) throws BizException{
		if(!IScEventConst.EVENT_SOURCE_SOURCE_SC_OP_APT.equalsIgnoreCase(event.getSourceID())
			|| !IScEventConst.EVENT_SC_OP_APT_TAKE.equals(event.getEventType())){
			return false;
		}	
		return true;
	}
}
