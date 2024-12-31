package iih.bd.mm.listener;

import java.util.Arrays;

import iih.bd.mm.iemsg.MeasdocEventBp;
import iih.bd.mm.iemsg.d.MeasdocDTO;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.d.desc.MeasDocDODesc;

public class MeasdocUpdateEventListener extends AbstractMeaUpdateListener{

	@SuppressWarnings("unchecked")
	@Override
	protected void doYourActionAfter(MeasDocDO[] ors) throws BizException {
		MeasdocEventBp bp = new MeasdocEventBp();
		MeasdocDTO[] meaDTO = bp.setMeasDTO(ors,IEventType.TYPE_UPDATE_AFTER);	
		
		if(meaDTO == null || meaDTO.length == 0)
			return;
		
		FArrayList2 list = new FArrayList2();
		list.addAll(Arrays.asList(meaDTO));
		
		//3、集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(list, BusiType.NO_CAT);
		BusinessEvent bizEvent = new BusinessEvent(MeasDocDODesc.CLASS_FULLNAME,IEventType.TYPE_UPDATE_AFTER,buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);		
	}



}
