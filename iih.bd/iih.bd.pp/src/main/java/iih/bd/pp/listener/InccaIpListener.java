package iih.bd.pp.listener;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.incca.d.desc.IncCaItmDODesc;
import iih.bd.pp.listener.bp.BdPpEventBp;
import iih.bd.pp.listener.d.InccaItemEventDTO;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * MS022住院费用分类代码(发票分类（住院）)------通过
 * */
public class InccaIpListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		if(!(event.getSourceID().equals(IncCaItmDODesc.CLASS_FULLNAME)))return;
		String action = "";
		if(event.getEventType().equals(IBdSrvIEEventConst.TYPE_INSERT_INCCA_ZY)){
			action = "insert";
		}else if(event.getEventType().equals(IBdSrvIEEventConst.TYPE_UPDATE_INCCA_ZY)){
			action = "update";
		}else if(event.getEventType().equals(IBdSrvIEEventConst.TYPE_DELETE_INCCA_ZY)){
			action = "delete";
		}else{
			return;
		}
		BusinessUserObj com = (BusinessUserObj)event.getUserObject();
		IncCaItmDO[] incCaItmDOArr = (IncCaItmDO[])com.getUserObj();
		
		BdPpEventBp priPmEventBp = new BdPpEventBp();
		InccaItemEventDTO inccaItemEventDTO = priPmEventBp.incItmAssembly(incCaItmDOArr[0], action);

		String code_dept = priPmEventBp.getDeptCodeById(Context.get().getDeptId());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(inccaItemEventDTO, BusiType.NO_CAT,code_dept,"0");
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(),event.getEventType(),buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
	}

}
