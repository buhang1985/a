package iih.bl.st.listrener.event;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

public class BlStIpEvent {
	
	/**
	 * 住院结算新增事件
	 * */
	public void invokeNew(BlEventInfoDTO blEventInfoDTO) throws BizException{
//		BusinessEvent enterDeptEvent = new BusinessEvent(IBlEventCodeConst.EVENT_BL_ST_IP_REF, IEventType.TYPE_INSERT_AFTER,
//				blEventInfoDTO);
//		EventDispatcher.fireEvent(enterDeptEvent);
	}
	
	/**
	 * 住院结算删除事件
	 * */
	public void invokeCancel(BlEventInfoDTO blEventInfoDTO) throws BizException{
//		BusinessEvent enterDeptEvent = new BusinessEvent(IBlEventCodeConst.EVENT_BL_ST_IP_REF, IEventType.TYPE_DELETE_AFTER,
//				blEventInfoDTO);
//		EventDispatcher.fireEvent(enterDeptEvent);
	}
	
	/**
	 * 住院结算收付款事件
	 * */
	public void invokePay(BlEventInfoDTO blEventInfoDTO) throws BizException{
		BusinessEvent enterDeptEvent = new BusinessEvent(IBlEventConst.EVENT_BL_ST_IP_PAY_CLASS, IEventType.TYPE_INSERT_AFTER,
				blEventInfoDTO);
		EventDispatcher.fireEvent(enterDeptEvent);
	}

	/**
	 * 住院结算退款
	 * @throws BizException 
	 * */
	public void invokeRefund(BlEventInfoDTO blEventInfoDTO) throws BizException {
		BusinessEvent enterDeptEvent = new BusinessEvent(IBlEventConst.EVENT_BL_ST_IP_PAY_CLASS, IEventType.TYPE_DELETE_AFTER,
				blEventInfoDTO);
		EventDispatcher.fireEvent(enterDeptEvent);
	}
	
	/**
	 * 住院结算退款
	 * @throws BizException 
	 * */
	public void invokeArrears(BlEventInfoDTO blEventInfoDTO) throws BizException {
		BusinessEvent enterDeptEvent = new BusinessEvent(IBlEventConst.EVENT_BL_ST_IP_PAY_CLASS, IEventType.TYPE_UPDATE_AFTER,
				blEventInfoDTO);
		EventDispatcher.fireEvent(enterDeptEvent);
	}
}
