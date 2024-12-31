package iih.bd.mm.listener;

import java.util.Arrays;

import iih.bd.bc.event.pub.IMmIEEventConst;
import iih.bd.mm.iemsg.SuppliEventBp;
import iih.bd.mm.iemsg.d.SuppliersDTO;
import iih.bd.mm.supplier.d.SupplierDO;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IEventType;

public class FactoryUpdateEventListener extends AbstractFacEdiAfterListener{

	@SuppressWarnings("unchecked")
	@Override
	protected void doYourActionAfter(SupplierDO[] ors) throws BizException {
		
		SuppliEventBp bp = new SuppliEventBp();
		SupplierDO[] orsList = bp.getFacList(ors);	
		
		SuppliersDTO[] supDTO = bp.setSupliDTO(orsList,IEventType.TYPE_UPDATE_AFTER);	
		
		if(supDTO == null || supDTO.length == 0)
			return;
		
		FArrayList2 list = new FArrayList2();
		list.addAll(Arrays.asList(supDTO));
		
		//3、集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(list, BusiType.NO_CAT);
		BusinessEvent bizEvent = new BusinessEvent(IMmIEEventConst.EVENT_IE_BDMM_FACTORY,IMmIEEventConst.EVENT_IE_BDMM_UPDATE_PRD,buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
	}



}
