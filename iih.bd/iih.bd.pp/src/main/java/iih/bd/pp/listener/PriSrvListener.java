package iih.bd.pp.listener;

import java.util.List;

import iih.bd.bc.event.pub.IBdPpEventCodeConst;
import iih.bd.pp.listener.bp.BdPpEventBp;
import iih.bd.pp.listener.d.MedSrvEventDTO;
import iih.bd.pp.listener.d.PriSrvEventDTO;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;

/**
 * MS031收费项目字典(价表维护)
 */
public class PriSrvListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		if (!(event.getSourceID().equals(IBdPpEventCodeConst.EVENT_BD_PP_SRV_PIC)))
			return;
		String action = "";
		if (event.getEventType().equals(IEventType.TYPE_INSERT_AFTER)) {
			action = "insert";
		} else if (event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)) {
			action = "update";
		} else if (event.getEventType().equals(IEventType.TYPE_DELETE_AFTER)) {
			action = "delete";
		} else {
			return;
		}
		BusinessUserObj com = (BusinessUserObj) event.getUserObject();
		MedSrvEventDTO[] medSrvDTOArr = (MedSrvEventDTO[]) com.getUserObj();

		BdPpEventBp priPmEventBp = new BdPpEventBp();
		List<PriSrvEventDTO> priSrvEventDTOList = priPmEventBp.priSrvAssembly(medSrvDTOArr, action);

//		String code_dept = priPmEventBp.getDeptCodeById(Context.get().getDeptId());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(priSrvEventDTOList, BusiType.NO_CAT, null, "0");
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(), event.getEventType(), buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
	}

}
