package iih.bd.mm.listener;

import java.util.Arrays;

import iih.bd.mm.iemsg.WarehouseBp;
import iih.bd.mm.iemsg.d.WarehouseDTO;
import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.d.desc.WarehouseDODesc;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public class WareUpdateEventListener implements IBusinessListener{

	@SuppressWarnings("unchecked")
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//1、验证事件，是否匹配
		//this.validate(event);
		
		BDCommonEvent bdcEvent = (BDCommonEvent) event;
		
		Object[] objs = (Object[]) bdcEvent.getNewObjs();
		
		if (ArrayUtil.isEmpty(objs)) {
			return;
		}
		if (!(objs[0] instanceof WarehouseDO)) {
			return;
		}
		
		WarehouseDO[] dedos = new WarehouseDO[objs.length];
		for (int i = 0; i < objs.length; i++) {
			dedos[i] = (WarehouseDO) objs[i];
		}

		WarehouseBp bp = new WarehouseBp();
		WarehouseDTO[] wareDTO = bp.setWareDTO(dedos,event.getEventType());		
		
		if(wareDTO == null || wareDTO.length == 0)
			return;
		
		FArrayList2 list = new FArrayList2();
		list.addAll(Arrays.asList(wareDTO));
		
		//3、集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(list, BusiType.NO_CAT);
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(),event.getEventType(),buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
		
	}

	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException{
		if(!WarehouseDODesc.CLASS_FULLNAME.equalsIgnoreCase(event.getSourceID())
			|| !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())){
			throw new BizException();
		}		
	}

}
