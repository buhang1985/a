package iih.sc.apt.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.event.pub.IScEventConst;
import iih.en.pv.dto.d.OpReg4EsDTO;
import iih.en.pv.dto.d.Reg4IpDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.sc.apt.dto.d.OpApt4EsDTO;
import iih.sc.comm.ScValidator;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
/**
 * 门诊预约--集成平台监听器
 * @author yank
 * @author liubin
 */
public class OpApt4IpListener  implements IBusinessListener {
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
		//未生成就诊记录
		if(ScValidator.isEmptyIgnoreBlank(esDTO.getId_ent()))
			return;
		OpReg4EsDTO reg4EsDTO = new OpReg4EsDTO();
		reg4EsDTO.setId_ent(esDTO.getId_ent());
		reg4EsDTO.setId_pat(esDTO.getId_pat());
		IEnOutQryService serv = ServiceFinder.find(IEnOutQryService.class);
		Reg4IpDTO reg4IpDTO = serv.getReg4Ip(reg4EsDTO);
		if(reg4IpDTO == null)
			return;
		reg4IpDTO.setMsgtype("new");
		
		//3、触发门诊挂号集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(reg4IpDTO, BusiType.MZ,"071", "0");
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
			|| !IScEventConst.EVENT_SC_OP_APT.equals(event.getEventType())){
			return false;
		}	
		return true;
	}
}

