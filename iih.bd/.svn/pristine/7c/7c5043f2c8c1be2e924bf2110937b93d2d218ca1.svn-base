package iih.bd.pp.listener;

import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.incca.d.desc.IncCaItmDODesc;
import iih.bd.pp.listener.bp.BdPpEventBp;
import iih.bd.pp.listener.d.IncCaEventDTO;
import xap.ip.event.BusinessEventListener;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent.BDCommonUserObj;

public class InccaListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		if(!(event.getSourceID().equals(IncCaItmDODesc.CLASS_FULLNAME)))return;
		String action = "";
		if(event.getEventType().equals(IEventType.TYPE_INSERT_AFTER)){
			action = "insert";
		}else if(event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)){
			action = "update";
		}else if(event.getEventType().equals(IEventType.TYPE_DELETE_AFTER)){
			action = "delete";
		}else{
			return;
		}
		BDCommonUserObj com = (BDCommonUserObj)event.getUserObject();
		IncCaItmDO[] incCaItmDOArr = (IncCaItmDO[])com.getNewObjects();
		
		BdPpEventBp priPmEventBp = new BdPpEventBp();
		IncCaEventDTO incCaEventDTO = priPmEventBp.incAssembly(incCaItmDOArr[0], action);
		
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(),event.getEventType(),incCaEventDTO);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
	}

}
