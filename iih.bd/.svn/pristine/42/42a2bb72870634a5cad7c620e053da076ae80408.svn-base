package iih.bd.mm.listener;

import java.util.Arrays;

import iih.bd.bc.event.pub.IMmIEEventConst;
import iih.bd.mm.iemsg.MmUdiEventBp;
import iih.bd.mm.iemsg.d.MmUdidocDTO;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.xbd.udi.d.UdidocDO;

public class UdiDeleteEventListener extends AbstractUdiDelListener{

	@SuppressWarnings("unchecked")
	@Override
	protected void doYourActionAfter(UdidocDO[] ors) throws BizException {
		
		MmUdiEventBp bp = new MmUdiEventBp();
		MmUdidocDTO[] mmUdiDTO = bp.setUdiDTO(ors,IEventType.TYPE_DELETE_AFTER);	
		
		if(mmUdiDTO == null || mmUdiDTO.length == 0)
			return;
		
		FArrayList2 list = new FArrayList2();
		list.addAll(Arrays.asList(mmUdiDTO));
		
		//3、集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(list, BusiType.NO_CAT);
		BusinessEvent bizEvent = new BusinessEvent(IMmIEEventConst.EVENT_IE_BDMM_MMTP,IMmIEEventConst.EVENT_IE_BDMM_UPDATE_MMTP,buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);		
	}



}
