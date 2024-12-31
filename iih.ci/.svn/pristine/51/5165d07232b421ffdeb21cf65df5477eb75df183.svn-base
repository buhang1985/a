package iih.ci.mr.s.listener;

import iih.bd.bc.event.pub.IMrEventConst;
import iih.ci.mr.cideathcert.d.desc.CideathcertDODesc;
import iih.ci.mr.cideathcert.d.CideathcertDO;
import iih.ci.mr.d.CiMrDeathDTO;
import iih.ci.mr.i.ICiMrDeathService;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public class CiMrDeathListener implements IBusinessListener{
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//修改时候触发
		if(!(event.getSourceID().equals(CideathcertDODesc.CLASS_FULLNAME)
			&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))return;
		
		//病历文书记录
		CideathcertDO[] ciMrDOs = (CideathcertDO[])((BDCommonEvent)event).getNewObjs();
		
		
		if(ArrayUtil.isEmpty(ciMrDOs))return;
		
//		BusinessEvent mrEvent = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_DEATHCERT_PASS,
//				IEventType.TYPE_UPDATE_AFTER, ciMrDOs);
//		EventDispatcher.fireEvent(mrEvent);
		
		//ciMrDOs[0].getId_pat()
		
		ICiMrDeathService service = ServiceFinder
				.find(ICiMrDeathService.class);
		
		CiMrDeathDTO dto = service.getCiMrDeathDTO(ciMrDOs[0].getId_pat());
		
		DomainBusinessUserObj buo = new DomainBusinessUserObj(dto,IMrPubConst.NOCAT,"0","0");
		BusinessEvent mrEvent = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_DEATHCERT_PASS,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener =ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(mrEvent);
//		try {
//			EventDispatcher.fireEvent(mrEvent);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}
	}
	
}
