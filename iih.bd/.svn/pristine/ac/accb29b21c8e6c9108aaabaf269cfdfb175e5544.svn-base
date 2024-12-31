package iih.bd.mm.listener;

import java.util.ArrayList;
import java.util.Arrays;

import iih.bd.mm.iemsg.MeterialBp;
import iih.bd.mm.iemsg.d.MeterialDTO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
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

/**
 * 物品数据修改监听器。
 * 
 * @author shao_yuan
 *
 */

public class MeterialUpdateEventListener implements IBusinessListener {

	@SuppressWarnings("unchecked")
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、验证事件，是否匹配
		// this.validate(event);

		BDCommonEvent bdcEvent = (BDCommonEvent) event;

		Object[] objs = (Object[]) bdcEvent.getNewObjs();

		if (ArrayUtil.isEmpty(objs)) {
			return;
		}
		if (!(objs[0] instanceof MeterialAggDO)) {
			return;
		}
		ArrayList<MeterialDO> list = new ArrayList<MeterialDO>();
		// MeterialDO[] dedos = new MeterialDO[objs.length];
		for (int i = 0; i < objs.length; i++) {
			if (((MeterialAggDO) objs[i]).getParentDO().getSd_mmtp().startsWith("1")) {
				list.add(((MeterialAggDO) objs[i]).getParentDO());
			}
		}

		if(list.size()==0){
			return;
		}
		MeterialBp bp = new MeterialBp();
		MeterialDTO[] mmDTO = bp.setMmDTO(list.toArray(new MeterialDO[list.size()]), event.getEventType());

		if (mmDTO == null || mmDTO.length == 0)
			return;

		FArrayList2 lists = new FArrayList2();
		lists.addAll(Arrays.asList(mmDTO));

		// 3、集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(lists, BusiType.NO_CAT);
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(), event.getEventType(), buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);

	}

	/**
	 * 验证事件
	 * 
	 * @param event
	 *            事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException {
		if (!IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			throw new BizException();
		}
	}

}