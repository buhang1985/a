package iih.bl.st.listrener;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bd.bc.event.pub.IBlEventCodeConst;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.pub.dto.d.BlIihIeDTO;
import iih.bl.pub.dto.d.BlIihIe_bill_DTO;
import iih.bl.pub.dto.d.BlIihIe_item_DTO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.listrener.bp.BlStLinstrenerBp;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.ip.event.BusinessEventListener;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;

public class BlStIpNewLinstrener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
//		if(!IBlEventCodeConst.EVENT_BL_ST_IP_REF.equals(event.getSourceID())
//				&& event.getEventType().equals(IEventType.TYPE_INSERT_AFTER))return;
//		
//		BusinessUserObj com = (BusinessUserObj)event.getUserObject();
//		BlEventInfoDTO blEventInfoDTO = (BlEventInfoDTO)com.getUserObj();
//		BlIihIeDTO bl_iih_ie_DTO = this.assembly(blEventInfoDTO);
//		
//		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(),event.getEventType(),bl_iih_ie_DTO);
//		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
//		ipEventListener.doAction(bizEvent);
	}

	@SuppressWarnings("unchecked")
	private BlIihIeDTO assembly(BlEventInfoDTO blEventInfoDTO) throws BizException{
		
		PatiVisitDO patiVisitDO = blEventInfoDTO.getPatiVisitDO();
		BlStIpDO blStIpDO = blEventInfoDTO.getBlStIpDO();
		BlCgIpDO[] blCgIpDOArr = (BlCgIpDO[]) blEventInfoDTO.getBlCgIpDOList().toArray(new BlCgIpDO[]{});
		BlStLinstrenerBp blStLinstrenerBp = new BlStLinstrenerBp();
		InpatientDO inpatientDO = blStLinstrenerBp.getEntIpInfo(patiVisitDO.getId_ent());
		
		BlIihIeDTO bl_iih_ie_DTO = new BlIihIeDTO();
		bl_iih_ie_DTO.setDomain_id("02");//域ID（门诊：01，；住院：02）
		bl_iih_ie_DTO.setId_pat(patiVisitDO.getId_pat());
		bl_iih_ie_DTO.setId_ent(patiVisitDO.getId_ent());
		bl_iih_ie_DTO.setEnt_times(inpatientDO.getTimes_ip().toString());
		
		FArrayList2 billList = new FArrayList2();
		for(BlCgIpDO blCgIpDO : blCgIpDOArr){
			BlIihIe_item_DTO blIihIe_item_DTO = new BlIihIe_item_DTO();
			
			billList.add(blIihIe_item_DTO);
		}
		
		//bl_iih_ie_DTO.setBlIihIe_bill_DTO(billList);
		return bl_iih_ie_DTO;
	}

}
