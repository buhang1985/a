package iih.ci.mr.s.listener;

import iih.bd.bc.event.pub.IMrEventConst;
import iih.bd.srv.billtypedto.d.BillTypeDto;
import iih.bd.srv.mrfpbltype.d.MrFpBlTypeDO;
import iih.bd.srv.mrfpbltype.d.MrfpbltypeAggDO;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.mr.s.bp.MrFpBlTypeBP;
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

/**
 * 账单类别监听器。
 * 
 * @author tangws
 *
 */
// MrfpbltypeAggDODesc
public class MrFpBlTypeUpdateEventListener implements IBusinessListener {

	@SuppressWarnings("unchecked")
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		
		
		// 1、验证事件，是否匹配
		BDCommonEvent bdcEvent = (BDCommonEvent) event;

		Object[] objs = (Object[]) bdcEvent.getNewObjs();
		if (ArrayUtil.isEmpty(objs)) {
			return;
		}
		if (!(objs[0] instanceof MrfpbltypeAggDO)) {
			return;
		}

		MrFpBlTypeDO[] mrdos = new MrFpBlTypeDO[objs.length];
		for (int i = 0; i < objs.length; i++) {
			mrdos[i] = ((MrfpbltypeAggDO) objs[i]).getParentDO();
		}

		MrFpBlTypeBP bp = new MrFpBlTypeBP();
		BillTypeDto[] dtos = bp.setMmDTO(mrdos, event.getEventType());

		if (dtos == null || dtos.length == 0)
			return;

//		FArrayList2 list = new FArrayList2();
//		list.addAll(Arrays.asList(dtos));

		// 3、集成平台事件
		/*
		 * DomainBusinessUserObj buo = new DomainBusinessUserObj(list, "01");
		 * BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(),
		 * event.getEventType(), buo); BusinessEventListener ipEventListener =
		 * ServiceFinder .find(BusinessEventListener.class);
		 * ipEventListener.doAction(bizEvent);
		 */

		DomainBusinessUserObj buo = new DomainBusinessUserObj(dtos[0],
				IMrPubConst.NOCAT,"","0");
		BusinessEvent mrEvent = new BusinessEvent(
				IMrEventConst.EVENT_SOURCE_MR_BILLTYPE_ZDLB,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener =ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(mrEvent);
//		try {
//			EventDispatcher.fireEvent(mrEvent);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * 验证事件
	 * 
	 * @param event
	 *            事件
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private void validate(IBusinessEvent event) throws BizException {
		if (!IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			throw new BizException();
		}
	}
}
