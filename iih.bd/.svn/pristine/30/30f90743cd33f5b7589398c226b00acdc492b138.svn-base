package iih.bd.pp.listener;

import iih.bd.pp.listener.bp.BdPpEventBp;
import iih.bd.pp.listener.d.PriPmEventDTO;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.d.desc.PriPmDODesc;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent.BDCommonUserObj;

/**
 * MS018支付方式代码(付款方式字典)------通过
 * */
public class PriPmListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		if(!(event.getSourceID().equals(PriPmDODesc.CLASS_FULLNAME)))return;
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
		PriPmDO[] priPmDOArr = (PriPmDO[])com.getNewObjects();
		
		BdPpEventBp priPmEventBp = new BdPpEventBp();
		PriPmEventDTO priPmEventDTO = priPmEventBp.pmAssembly(priPmDOArr[0],action);

		String code_dept = priPmEventBp.getDeptCodeById(Context.get().getDeptId());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(priPmEventDTO, BusiType.NO_CAT,code_dept,"0");
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(),event.getEventType(),buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
	}
	
}
