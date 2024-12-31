package iih.bd.mm.listener;

import iih.bd.mm.iemsg.AuditEventBp;
import iih.bd.mm.iemsg.d.AuditEntryDTO;
import iih.bd.mm.iemsg.d.AuditEventDTO;
import iih.mm.st.stockpriceadjust.d.StockPriceAdjustDO;
import iih.mm.st.stockpriceadjust.d.StockpriceadjustAggDO;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;

public class AuditUpdateEventListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//1、验证事件，是否匹配
		//this.validate(event);
				
		BusinessEvent bdcEvent = (BusinessEvent) event;
		
		Object[] objs = (Object[]) bdcEvent.getObject();
		
		if (ArrayUtil.isEmpty(objs)) {
			return;
		}
		if (!(objs[0] instanceof StockpriceadjustAggDO)) {
			return;
		}
		
		StockPriceAdjustDO[] dedos = new StockPriceAdjustDO[objs.length];
		for (int i = 0; i < objs.length; i++) {
			dedos[i] = ((StockpriceadjustAggDO) objs[i]).getParentDO();
		}
			
		AuditEventBp bp = new AuditEventBp();
		AuditEntryDTO[] wareDTO = bp.setMmDTO(dedos,event.getEventType());
		
		if(wareDTO==null || wareDTO.length==0)
			return;
		
		AuditEventDTO auditEventDTO = bp.setAuditEventDTO(wareDTO,event.getEventType());
		
		//3、集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(auditEventDTO, BusiType.MZ);
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
		if(!IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())){
			throw new BizException();
		}		
	}

}
