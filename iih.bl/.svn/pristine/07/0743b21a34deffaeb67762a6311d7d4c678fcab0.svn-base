package iih.bl.st.listrener;

import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bd.bc.event.pub.IBlEventCodeConst;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.pub.dto.d.BlIihIeDTO;
import iih.bl.pub.dto.d.BlIihIe_bill_DTO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.listrener.bp.BlStLinstrenerBp;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.ip.event.BusinessEventListener;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;

public class BlStIpArrearsLinstrener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
//		if(!IBlEventCodeConst.EVENT_BL_ST_IP_PAY.equals(event.getSourceID())
//				&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER))return;
//		
//		BusinessUserObj com = (BusinessUserObj)event.getUserObject();
//		BlEventInfoDTO blEventInfoDTO = (BlEventInfoDTO)com.getUserObj();
//		BlIihIeDTO bl_iih_ie_DTO = this.assembly(blEventInfoDTO);
//		
////		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(),event.getEventType(),bl_iih_ie_DTO);
////		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
////		ipEventListener.doAction(bizEvent);
	}

	@SuppressWarnings("unchecked")
	private BlIihIeDTO assembly(BlEventInfoDTO blEventInfoDTO) throws BizException {
		PatiVisitDO patiVisitDO = blEventInfoDTO.getPatiVisitDO();//就诊信息
		//BlStIpDO blStIpDO = blEventInfoDTO.getBlStIpDO();//结算信息
		BlpaypatipAggDO blpaypatipAggDO = blEventInfoDTO.getBlpaypatipAggDO();//结算收付款信息
		BlincipAggDO blincipAggDO = blEventInfoDTO.getBlincipAggDO();//账单信息
		BlStLinstrenerBp blStLinstrenerBp = new BlStLinstrenerBp();
		InpatientDO inpatientDO = blStLinstrenerBp.getEntIpInfo(patiVisitDO.getId_ent());//就诊属性信息
		EntHpDO entHpDO = blStLinstrenerBp.getEntHpInfo(patiVisitDO.getId_ent());//就诊医保计划信息
		
		BlIihIeDTO bl_iih_ie_DTO = new BlIihIeDTO();
		bl_iih_ie_DTO.setDomain_id("02");//域ID（门诊：01，；住院：02）
		bl_iih_ie_DTO.setId_pat(patiVisitDO.getId_pat());//患者ID
		bl_iih_ie_DTO.setId_ent(patiVisitDO.getId_ent());//就诊ID
		bl_iih_ie_DTO.setEnt_times(inpatientDO.getTimes_ip().toString());//就诊次数
		bl_iih_ie_DTO.setCode_entp(patiVisitDO.getCode_entp());//就诊类型编码
		bl_iih_ie_DTO.setDt_pay(blpaypatipAggDO.getParentDO().getDt_pay().toString());//收付款日期
		bl_iih_ie_DTO.setId_emp_pay(blpaypatipAggDO.getParentDO().getId_emp_pay());//收款人编码
		bl_iih_ie_DTO.setEmp_pay_name(blpaypatipAggDO.getParentDO().getName_emp_pay());//收款人名称
		bl_iih_ie_DTO.setInsur_no(entHpDO.getNo_hp());//医保号
		
		FArrayList2 billList = new FArrayList2();
		BlIihIe_bill_DTO blIihIe_bill_DTO = new BlIihIe_bill_DTO();
		blIihIe_bill_DTO.setIncno(blincipAggDO.getParentDO().getIncno());
		blIihIe_bill_DTO.setInccode(blincipAggDO.getParentDO().getInccacode());
		blIihIe_bill_DTO.setIncname(blincipAggDO.getParentDO().getInccaname());
		blIihIe_bill_DTO.setInc_dt(blincipAggDO.getParentDO().getDt_inc().toString());
		blIihIe_bill_DTO.setInc_amt(blincipAggDO.getParentDO().getAmt().toString());
		blIihIe_bill_DTO.setInc_amt_unit("元");
		blIihIe_bill_DTO.setId_pat(blincipAggDO.getParentDO().getId_pat());
		billList.add(blIihIe_bill_DTO);
		bl_iih_ie_DTO.setBliihie_bill_dto(billList);
		
		return bl_iih_ie_DTO;
	}

}
