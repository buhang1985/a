package iih.bl.pay.listrener;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.desc.BlPrePayPatDODesc;
import iih.bl.pub.dto.d.BlIihIeDTO;
import iih.bl.pub.dto.d.BlIihIe_bill_DTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.ip.event.BusinessEventListener;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent.BDCommonUserObj;

public class BlPayPatNewLinstrener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		
		if(!(event.getSourceID().equals(BlPrePayPatDODesc.CLASS_FULLNAME)
				&& event.getEventType().equals(IEventType.TYPE_INSERT_AFTER)))return;
		BDCommonUserObj com = (BDCommonUserObj)event.getUserObject();
		BlPrePayPatDO[] blPrePayPatDOArr = (BlPrePayPatDO[])com.getNewObjects();
		if(blPrePayPatDOArr == null || blPrePayPatDOArr.length == 0) return;
		if(!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(blPrePayPatDOArr[0].getCode_enttp())) return;
		BlIihIeDTO bl_iih_ie_DTO = this.assembly(blPrePayPatDOArr[0]);
		
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(),event.getEventType(),bl_iih_ie_DTO);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
	}
	
	/**
	 * 组装数据
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	public BlIihIeDTO assembly(BlPrePayPatDO blPrePayPatDO) throws BizException{
		BlIihIeDTO bl_iih_ie_DTO = new BlIihIeDTO();
		bl_iih_ie_DTO.setDomain_id("02");//域ID（门诊：01，；住院：02）
		bl_iih_ie_DTO.setDt_pay(blPrePayPatDO.getDt_pay().toString());//收款日期
		bl_iih_ie_DTO.setId_emp_pay(blPrePayPatDO.getEmp_code());//收款人编码
		bl_iih_ie_DTO.setEmp_pay_name(blPrePayPatDO.getEmp_name());//收款人名称
		bl_iih_ie_DTO.setId_ent(blPrePayPatDO.getId_ent());//就诊ID
		bl_iih_ie_DTO.setId_pat(blPrePayPatDO.getId_pat());//患者ID
		//this.getPatInfo(bl_iih_ie_DTO);
		this.getEntInfo(bl_iih_ie_DTO);
		
		FArrayList2 billList = new FArrayList2();
		BlIihIe_bill_DTO blIihIe_bill_DTO = new BlIihIe_bill_DTO();
		blIihIe_bill_DTO.setInccode(blPrePayPatDO.getCode_rep());//收据编号
		blIihIe_bill_DTO.setInc_dt(blPrePayPatDO.getDt_pay().toString());//账单日期
		blIihIe_bill_DTO.setInc_amt(blPrePayPatDO.getAmt().multiply(blPrePayPatDO.getEu_direct()).toString());//金额
		blIihIe_bill_DTO.setInc_amt_unit("元");//账单金额单位
		blIihIe_bill_DTO.setId_pat(blPrePayPatDO.getId_pat());//患者ID
		billList.add(blIihIe_bill_DTO);
		
		bl_iih_ie_DTO.setBliihie_bill_dto(billList);
		return bl_iih_ie_DTO;
	}
	
	/**
	 * 获取患者信息
	 * @throws BizException 
	 * */
	public void getPatInfo(BlIihIeDTO bl_iih_ie_DTO) throws BizException{
		//IPatiMDORService service = ServiceFinder.find(IPatiMDORService.class);
		//PatDO patDO = service.findById(bl_iih_ie_DTO.getId_pat());
	}
	
	/**
	 * 获取就诊数据
	 * @throws BizException 
	 * */
	public void getEntInfo(BlIihIeDTO bl_iih_ie_DTO) throws BizException{
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = service.findById(bl_iih_ie_DTO.getId_ent());
		if(patiVisitDO == null){
			throw new BizException("就诊信息不存在！");
		}
		bl_iih_ie_DTO.setEnt_code(patiVisitDO.getCode());//就诊号
		IInpatientRService ipService = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] inpatientDOArr = ipService.find(" id_ent = '" + bl_iih_ie_DTO.getId_ent() + "'", null, FBoolean.FALSE);
		if(inpatientDOArr == null || inpatientDOArr.length == 0){
			throw new BizException("就诊属性不存在！");
		}
		bl_iih_ie_DTO.setEnt_times(inpatientDOArr[0].getTimes_ip().toString());
	}
}
