package iih.bd.pp.listener.event;

import iih.bd.bc.event.pub.IBdPpEventCodeConst;
import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.incca.d.desc.IncCaItmDODesc;
import iih.bd.pp.listener.d.MedSrvEventDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

public class BdPpEvent {
	
	/**
	 * 票据分类项目
	 * */
	public void invokeInccaItm(IncCaItmDO[] incCaItmDOArr,String type_event) throws BizException{
		BusinessEvent enterDeptEvent = new BusinessEvent(IncCaItmDODesc.CLASS_FULLNAME, type_event,
				incCaItmDOArr);
		EventDispatcher.fireEvent(enterDeptEvent);
	}
	
	/**
	 * 价表维护
	 * */
	public void invokePriSrv(MedSrvEventDTO medSrvEventDTO,String type_event) throws BizException{
//		BusinessEvent enterDeptEvent = new BusinessEvent(MedSrvDODesc.CLASS_FULLNAME, type_event,
//				medSrvEventDTO);
		BusinessEvent enterDeptEvent = new BusinessEvent(IBdPpEventCodeConst.EVENT_BD_PP_SRV_PIC, type_event,
				new MedSrvEventDTO[]{medSrvEventDTO});
		EventDispatcher.fireEvent(enterDeptEvent);
	}
		
}
