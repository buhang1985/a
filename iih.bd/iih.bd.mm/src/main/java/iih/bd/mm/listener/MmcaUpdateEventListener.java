package iih.bd.mm.listener;

import java.util.Arrays;

import iih.bd.mm.iemsg.MmcaEventBp;
import iih.bd.mm.iemsg.d.MmcaEventDTO;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.mm.mmcategory.d.desc.MMCategoryDODesc;
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

public class MmcaUpdateEventListener implements IBusinessListener{

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
		if (!(objs[0] instanceof MMCategoryDO)) {
			return;
		}
		
		MMCategoryDO[] dedos = new MMCategoryDO[objs.length];
		for (int i = 0; i < objs.length; i++) {
			dedos[i] = (MMCategoryDO) objs[i];
		}

		MmcaEventBp bp = new MmcaEventBp();
		MmcaEventDTO[] mmcaDTO = bp.setMmcaDTO(dedos,event.getEventType());		
		
		if(mmcaDTO == null || mmcaDTO.length == 0)
			return;
		
		FArrayList2 list = new FArrayList2();
		list.addAll(Arrays.asList(mmcaDTO));
		
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
		if(!MMCategoryDODesc.CLASS_FULLNAME.equalsIgnoreCase(event.getSourceID())
			|| !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())){
			throw new BizException();
		}		
	}



}
