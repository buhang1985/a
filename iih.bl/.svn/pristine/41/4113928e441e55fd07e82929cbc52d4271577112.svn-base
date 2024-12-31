package iih.bl.cc.linstrener.event;

import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.pub.dto.d.BlEventInfoDTO;

public class BlCcRefEvent {

	/**
	 * 住院结账
	 * @throws BizException 
	 * */
	public void invokeAdd(BlEventInfoDTO blEventInfoDTO) throws BizException {
		BusinessEvent enterDeptEvent = new BusinessEvent(IBlEventConst.EVENT_BL_CC_REF, IEventType.TYPE_INSERT_AFTER,
				blEventInfoDTO);
		EventDispatcher.fireEvent(enterDeptEvent);
	}
	
	/**
	 * 取消住院结账
	 * @throws BizException 
	 * */
	public void invokeDel(BlEventInfoDTO blEventInfoDTO) throws BizException {
		BusinessEvent enterDeptEvent = new BusinessEvent(IBlEventConst.EVENT_BL_CC_REF, IEventType.TYPE_DELETE_AFTER,
				blEventInfoDTO);
		EventDispatcher.fireEvent(enterDeptEvent);
	}

}
