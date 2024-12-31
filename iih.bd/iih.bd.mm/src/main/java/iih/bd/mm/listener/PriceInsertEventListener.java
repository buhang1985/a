package iih.bd.mm.listener;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.mm.iemsg.MmPriceBp;
import iih.bd.mm.iemsg.d.PricemmDTO;
import iih.mm.st.stockpriceadjust.d.StockPriceAdjustDO;
import iih.mm.st.stockpriceadjust.d.StockpriceadjustAggDO;
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
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public class PriceInsertEventListener implements IBusinessListener{

	@SuppressWarnings("unchecked")
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		
		BDCommonEvent bdcEvent=(BDCommonEvent) event;	
		Object[] objs=bdcEvent.getNewObjs();
		if(ArrayUtils.isEmpty(objs))return;
		//BusinessEvent bdcEvent = (BusinessEvent) event;
		
		//Object[] objs = (Object[]) bdcEvent.getObject();
		
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

		MmPriceBp bp = new MmPriceBp();
		PricemmDTO[] priDTO = bp.setPriDTO(dedos,event.getEventType());		
		
		if(priDTO == null || priDTO.length == 0)
			return;
		
		FArrayList2 list = new FArrayList2();
		list.addAll(Arrays.asList(priDTO));
		
		
		//3、集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(list, BusiType.NO_CAT);
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(),event.getEventType(),buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
				
		ipEventListener.doAction(bizEvent);
		
	}



}
