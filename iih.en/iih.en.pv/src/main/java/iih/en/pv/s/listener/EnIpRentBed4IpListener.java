package iih.en.pv.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnMsgConst;
import iih.en.pv.inpatient.dto.d.RentBed4EsDTO;
import iih.en.pv.inpatient.dto.d.RentBed4IpDTO;
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
 * 包床--集成平台监听器
 * 
 * @author yank
 * @author renying
 *
 */
public class EnIpRentBed4IpListener implements IBusinessListener {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、验证事件，是否匹配
		this.validate(event);

		// 2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		RentBed4EsDTO eventSourceDTO = (RentBed4EsDTO)bizUserObj.getUserObj();
		RentBed4IpDTO rentBed4IpDTO = wrapObj4Ip(eventSourceDTO);

		// 3、触发集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(rentBed4IpDTO, BusiType.ZY,"071", "0");
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(), event.getEventType(), buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
	}

	/**
	 * 验证事件
	 * 
	 * @param event 事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException {
		if (!IEnEventConst.EVENT_SOURCE_EN_IP_RENT_BED.equalsIgnoreCase(event.getSourceID())
				|| !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			throw new BizException(IEnMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}
	}

	/**
	 * 包装集成平台事件源
	 * 
	 * @param chgBed4EsDTO
	 * @return
	 * @throws BizException
	 */
	private RentBed4IpDTO wrapObj4Ip(RentBed4EsDTO rentBed4EsDTO) throws BizException {
		return null;
	}

}
