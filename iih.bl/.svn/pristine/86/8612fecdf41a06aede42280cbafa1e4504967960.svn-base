package iih.bl.st.listrener;

import iih.bd.bc.event.pub.IBlEventCodeConst;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.pub.dto.d.BlIihIeDTO;
import xap.ip.event.BusinessEventListener;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;

public class BlStIpCancelLinstrener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
//		if(!IBlEventCodeConst.EVENT_BL_ST_IP_REF.equals(event.getSourceID())
//				&& event.getEventType().equals(IEventType.TYPE_DELETE_AFTER))return;
//		
//		BusinessUserObj com = (BusinessUserObj)event.getUserObject();
//		BlEventInfoDTO blEventInfoDTO = (BlEventInfoDTO)com.getUserObj();
//		BlIihIeDTO bl_iih_ie_DTO = this.assembly(blEventInfoDTO);
//		
//		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(),event.getEventType(),bl_iih_ie_DTO);
//		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
//		ipEventListener.doAction(bizEvent);
	}

	private BlIihIeDTO assembly(BlEventInfoDTO blEventInfoDTO) {
		if(blEventInfoDTO.getPatiVisitDO() == null){
			
		}
		return null;
	}

}
