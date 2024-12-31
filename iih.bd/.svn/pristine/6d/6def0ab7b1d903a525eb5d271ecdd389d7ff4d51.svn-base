package iih.bd.pp.listener;

import iih.bd.bc.event.pub.IBdPpEventCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.d.HpAggDO;
import iih.bd.pp.listener.bp.BdPpEventBp;
import iih.bd.pp.listener.d.BdHpEventDTO;
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
 * MS037 病人付费类别(医保计划)------通过
 */
public class BdHpListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		if (!(event.getSourceID().equals(IBdPpEventCodeConst.EVENT_BD_PP_HP))&& !(event.getSourceID().equals(IBdPpEventCodeConst.EVENT_BD_PP_HP_MDO)))
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
		BDCommonUserObj com = (BDCommonUserObj) event.getUserObject();
		BdPpEventBp priPmEventBp = new BdPpEventBp();
		BdHpEventDTO bdHpEventDTO = null;
		if (event.getSourceID().equals(IBdPpEventCodeConst.EVENT_BD_PP_HP)) {
			HpAggDO[] hpAggDOArr = (HpAggDO[]) com.getNewObjects();
			bdHpEventDTO = priPmEventBp.hpAssembly(hpAggDOArr[0], action);
		} else {
			HPDO[] hpAggDOArr = (HPDO[]) com.getNewObjects();
			bdHpEventDTO = priPmEventBp.hpAssembly(hpAggDOArr[0], action);
		}
		String code_dept = priPmEventBp.getDeptCodeById(Context.get().getDeptId());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(bdHpEventDTO, BusiType.NO_CAT, code_dept, "0");
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(), event.getEventType(), buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);

	}

}
