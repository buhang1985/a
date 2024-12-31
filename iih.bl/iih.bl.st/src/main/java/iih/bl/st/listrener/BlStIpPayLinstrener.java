package iih.bl.st.listrener;

import java.util.Map;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.comm.IBlConst;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.pub.dto.d.BlIihIeDTO;
import iih.bl.pub.dto.d.BlIihIe_bill_DTO;
import iih.bl.pub.dto.d.BlIihIe_item_DTO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.dto.d.BlStIpInccaInfoDTO;
import iih.bl.st.listrener.bp.BlStLinstrenerBp;
import iih.ci.ord.pres.d.CiPresDO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList2;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * BS353费用信息服务
 * */
public class BlStIpPayLinstrener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		if(!IBlEventConst.EVENT_BL_ST_IP_PAY_CLASS.equals(event.getSourceID())
				&& event.getEventType().equals(IEventType.TYPE_INSERT_AFTER))return;
		
		BusinessUserObj com = (BusinessUserObj)event.getUserObject();
		BlEventInfoDTO blEventInfoDTO = (BlEventInfoDTO)com.getUserObj();
		BlIihIeDTO bl_iih_ie_DTO = this.assembly(blEventInfoDTO);
		
//		Logger.info("住院结算收付款=="+bl_iih_ie_DTO.serializeJson());
		BlStLinstrenerBp blStLinstrenerBp = new BlStLinstrenerBp();
		String code_dept = blStLinstrenerBp.getDeptCodeById(Context.get().getDeptId());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(bl_iih_ie_DTO, BusiType.ZY,code_dept,"0");
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(),event.getEventType(),buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
	}

	/**
	 * 组装数据
	 * */
	@SuppressWarnings("unchecked")
	private BlIihIeDTO assembly(BlEventInfoDTO blEventInfoDTO) throws BizException {
		IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
		PatiVisitDO patiVisitDO = blEventInfoDTO.getPatiVisitDO();//就诊信息
		PatDO patDO = patRService.findById(patiVisitDO.getId_pat());//患者信息
		BlStIpDO blStIpDO = blEventInfoDTO.getBlStIpDO();//结算信息
		BlpaypatipAggDO blpaypatipAggDO =  blEventInfoDTO.getBlpaypatipAggDO();//结算收付款信息
		BlincipAggDO blincipAggDO = blEventInfoDTO.getBlincipAggDO();//发票信息
		BlStLinstrenerBp blStLinstrenerBp = new BlStLinstrenerBp();
		InpatientDO inpatientDO = blStLinstrenerBp.getEntIpInfo(patiVisitDO.getId_ent());//就诊属性信息
		EntHpDO entHpDO = blStLinstrenerBp.getEntHpInfo(patiVisitDO.getId_ent());//就诊医保计划信息
		BlStIpInccaInfoDTO[] blStIpInccaInfoDTOArr = blStLinstrenerBp.getBdIncCgInfoByIdStIp(blStIpDO.getId_stip());//获取账单信息
		BlCgIpDO[] blCgIpDOArr = blStLinstrenerBp.getBlCgIpInfo(blStIpDO.getId_stip());//获取记账信息
		Map<String,IncCaItmRelDO> inccaMap = blStLinstrenerBp.getInccaInfo();//获取账单分类信息
		Map<String,DeptDO> depMap = blStLinstrenerBp.getDeptInfo();//获取科室信息
		Map<String,HPDO> hpMap = blStLinstrenerBp.getPatHpTpInfo();//获取医保计划信息
		Map<String,CiPresDO> presMap = blStLinstrenerBp.getCiPresInfo();//获取处方信息
		
		BlIihIeDTO bl_iih_ie_DTO = new BlIihIeDTO();
		bl_iih_ie_DTO.setDomain_id("02");//域ID（门诊：01，；住院：02）
//		bl_iih_ie_DTO.setId_pat(patiVisitDO.getId_pat());//患者ID
		bl_iih_ie_DTO.setId_pat(patDO.getCode());//患者ID
		bl_iih_ie_DTO.setId_ent(patDO.getBarcode_chis());//就诊ID
		bl_iih_ie_DTO.setEnt_code(patiVisitDO.getCode());//就诊编码
		bl_iih_ie_DTO.setEnt_times(inpatientDO.getTimes_ip().toString());//就诊次数
		bl_iih_ie_DTO.setCode_entp(patiVisitDO.getCode_entp());//就诊类型编码
		bl_iih_ie_DTO.setDt_pay(blpaypatipAggDO.getParentDO().getDt_pay().toString());//收付款日期
		bl_iih_ie_DTO.setId_emp_pay(blpaypatipAggDO.getParentDO().getId_emp_pay());//收款人编码
		bl_iih_ie_DTO.setEmp_pay_name(blpaypatipAggDO.getParentDO().getName_emp_pay());//收款人名称
		if(entHpDO != null)
		{
			bl_iih_ie_DTO.setInsur_no(entHpDO.getNo_hp());//医保号
		}

		FArrayList2 billList = new FArrayList2();//账单信息
		for(BlStIpInccaInfoDTO blStIpInccaInfoDTO : blStIpInccaInfoDTOArr){
			BlIihIe_bill_DTO blIihIe_bill_DTO = new BlIihIe_bill_DTO();
			if(blincipAggDO != null && blincipAggDO.getParentDO() != null){
				blIihIe_bill_DTO.setIncno(blincipAggDO.getParentDO().getIncno());//发票号
				blIihIe_bill_DTO.setInc_dt(blincipAggDO.getParentDO().getDt_inc().toString());//账单日期
				blIihIe_bill_DTO.setId_pat(blincipAggDO.getParentDO().getId_pat());//患者编码
			}
			
			blIihIe_bill_DTO.setRed_rcptno(null);//红冲账单流水号
			blIihIe_bill_DTO.setInccode(blStIpInccaInfoDTO.getCode_inccaitm());//账单编码
			blIihIe_bill_DTO.setIncname(blStIpInccaInfoDTO.getName_inccaitm());//账单名称
			blIihIe_bill_DTO.setInc_amt(blStIpInccaInfoDTO.getAmt().toString());//账单金额
			blIihIe_bill_DTO.setInc_amt_unit("元");//金额单位
			bl_iih_ie_DTO.setTranstacttype(BookRtnDirectEnum.CHARGE.toString());//交易类型
			
			FArrayList2 cgList = new FArrayList2();//费用明细
			for(BlCgIpDO blCgIpDO : blCgIpDOArr){
				IncCaItmRelDO incCaItmRelDO = inccaMap.get(blCgIpDO.getId_srv());
				if(incCaItmRelDO == null || !incCaItmRelDO.getId_inccaitm().equals(blStIpInccaInfoDTO.getId_inccaitm())){
					continue;
				}
				BlIihIe_item_DTO blIihIe_item_DTO= new BlIihIe_item_DTO();
				HPDO hpDO = hpMap.get(blCgIpDO.getId_hp());
				if(hpDO != null){
//					throw new BizException("医保计划信息不存在");
					blIihIe_item_DTO.setHpsrvtp_code(hpDO.getSd_hptp());//项目分组编码(医保计划类型编码)
					blIihIe_item_DTO.setHpsrvtp_name(hpDO.getName_hptp());//项目分组名称(医保计划类型名称)
					blIihIe_item_DTO.setInsur_group(hpDO.getSd_hptp());//医保类型编码
					blIihIe_item_DTO.setInsur_group_name(hpDO.getName_hptp());//医保类型名称
				}
				blIihIe_item_DTO.setInc_code1(blStIpInccaInfoDTO.getCode_inccaitm());//费别编码
				blIihIe_item_DTO.setInc_name1(blStIpInccaInfoDTO.getName_inccaitm());//费别名称
				blIihIe_item_DTO.setBill_item_no("08");//细目号
//				if(blCgIpDO.getFg_bb().booleanValue()){
//					blIihIe_item_DTO.setFg_bb("1");//婴儿标志(是)
//					blIihIe_item_DTO.setFg_bb_no(blCgIpDO.getNo_bb());//婴儿标记编码
//				}else{
//					blIihIe_item_DTO.setFg_bb("0");//婴儿标志(否)
//				}
				blIihIe_item_DTO.setSettlement_times(1);//结算次数
				blIihIe_item_DTO.setCharge_status_code(IBlConst.FEE_BL_TYPE_CODE_SF);//费用状态编码
				blIihIe_item_DTO.setCharge_status_name(IBlConst.FEE_BL_TYPE_NAME_SF);//费用状态名称（录入, 上帐, 收费, 冲账, 结算）
				blIihIe_item_DTO.setPrice_date(blpaypatipAggDO.getParentDO().getDt_pay().toString());//项目收费时间
				blIihIe_item_DTO.setRecipe_no(blCgIpDO.getId_pres());//处方号
				CiPresDO presDO = presMap.get(blCgIpDO.getId_pres());
				if(presDO != null){
					//throw new BizException("处方信息不存在！");
					blIihIe_item_DTO.setRecipe_type_code(presDO.getSd_prestp());//处方类别编码
					blIihIe_item_DTO.setRecipe_type_name(presDO.getPrestp_name());//处方类别名称
				}
				blIihIe_item_DTO.setId_or(blCgIpDO.getId_or());//医嘱号
				blIihIe_item_DTO.setOrder_type_code(blCgIpDO.getSd_srvtp());//医嘱类别编码
				blIihIe_item_DTO.setOrder_type_name(blCgIpDO.getSrvtpname());//医嘱类别名称
				if(blCgIpDO.getFg_mm().booleanValue()){
					blIihIe_item_DTO.setSerial_no(blCgIpDO.getCode_mm());//包装序号
				}else{
					blIihIe_item_DTO.setSerial_no(blCgIpDO.getCode_srv());//包装序号
				}
				blIihIe_item_DTO.setCharge_code(blCgIpDO.getCode_srv());//费用编码
				blIihIe_item_DTO.setCharge_name(blCgIpDO.getName_srv());//费用名称
				blIihIe_item_DTO.setPrice(blCgIpDO.getPrice().toString());//单价
				blIihIe_item_DTO.setPrice_srvu("元");//单价价格单位
				blIihIe_item_DTO.setQuan(blCgIpDO.getQuan().toString());//数量
				blIihIe_item_DTO.setSrvu(blCgIpDO.getSrvu());//单位
				blIihIe_item_DTO.setCharge_confirm_emp_code(blpaypatipAggDO.getParentDO().getId_emp_pay());//费用申请人编码
				blIihIe_item_DTO.setCharge_confirm_emp_name(blpaypatipAggDO.getParentDO().getName_emp_pay());//费用申请人名称
				DeptDO deptApDO = depMap.get(blCgIpDO.getId_dep_or());
				if(deptApDO != null){
					blIihIe_item_DTO.setApply_dep_code(deptApDO.getCode());//申请科室编码
					blIihIe_item_DTO.setApply_dep_name(deptApDO.getName());//申请科室名称
				}
				DeptDO deptMpDO = depMap.get(blCgIpDO.getId_dep_mp());
				if(deptMpDO != null){
					blIihIe_item_DTO.setMp_dep_code(deptMpDO.getCode());//费用执行科室编码
					blIihIe_item_DTO.setMp_dep_name(deptMpDO.getName());//费用执行科室名称
				}
				if(blincipAggDO != null && blincipAggDO.getParentDO() != null){
					blIihIe_item_DTO.setInc_no(blincipAggDO.getParentDO().getIncno());//收据号
				}
				cgList.add(blIihIe_item_DTO);
			}
			blIihIe_bill_DTO.setBliihie_item_dto(cgList);
			billList.add(blIihIe_bill_DTO);
		}
		bl_iih_ie_DTO.setBliihie_bill_dto(billList);
		
		return bl_iih_ie_DTO;
	}

}
