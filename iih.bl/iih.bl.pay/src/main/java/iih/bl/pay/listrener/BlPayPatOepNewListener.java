package iih.bl.pay.listrener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.dto.d.SrvVsInvoiceTypeDTO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.pub.IBlFunCodeConst;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.pub.dto.d.BlIihIeDTO;
import iih.bl.pub.dto.d.BlIihIe_bill_DTO;
import iih.bl.pub.dto.d.BlIihIe_item_DTO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.ci.ord.pres.d.CiPresDO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * BS353费用信息服务
 * */
public class BlPayPatOepNewListener  implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//1、验证事件，是否匹配
		this.validate(event);
		
		//2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		BlEventInfoDTO eventSourceDTO = (BlEventInfoDTO)bizUserObj.getUserObj();
		BlIihIeDTO blIihIeDTO;
		try {
			blIihIeDTO = getBlIihIeDTOFromEvent(eventSourceDTO);
		} catch (ParseException e) {
			throw new BizException("日期转化失败！");
		}
		
		//3、触发门诊挂号集成平台事件
		String code_dept = this.getDeptCodeById(Context.get().getDeptId());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(blIihIeDTO, BusiType.MZ,code_dept,"0");
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(),event.getEventType(),buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
	}
	
	/**
	 * 构建集成平台所需要的DTO
	 * @param eventSourceDTO 事件发过来的DTO
	 * @return
	 * @throws BizException
	 * @throws ParseException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private BlIihIeDTO getBlIihIeDTOFromEvent(BlEventInfoDTO eventSourceDTO) throws BizException, ParseException
	{
//		Map<String,String> pres_codeName_map=new HashMap<String,String>();
//		Map<String,String> srvtpCodeName_map=new HashMap<String,String>();
//		Map<String,String> idpsn_name_map=new HashMap<String,String>();
//		Map<String,String> iddep_name_map=new HashMap<String,String>();
//		Map<String,String> hpsrvtp_map=new HashMap<String,String>(); //<1,甲类>
//		Map<String,String> measdoc_map=new HashMap<String,String>(); //<单位id,单位名称>
		
		Map<String,CiPresDO> ciPresDO = this.getCiPresInfo();//处方信息
		Map<String,SrvCateDO> srvCateMap = this.getSrvCateInfos();//服务分类信息
		Map<String,PsnDocDO> psnMap = this.getPsndocInfos();//人员信息
		Map<String,DeptDO> deptMap = this.getDeptInfo();//部门信息
		Map<String,String> hpSrvTpMap = this.getHpSrvTpInfos(); //医保类型
		Map<String,MeasDocDO> measMap = this.getMeasdocInfos();//单位信息
		Map<String,HPDO> hpMap = this.getHpInfo();//医保信息

		String func=eventSourceDTO.getFunc_Status();
		String times_op="0",id_ent="";
		SimpleDateFormat fmt_dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat fmt_dt1 = new SimpleDateFormat("yyyyMMddhhmmss");
		//1.获得事件源的类型
		PatiVisitDO patiVisitDO=eventSourceDTO.getPatiVisitDO();
		//PatDO patDO=eventSourceDTO.getPatDO();
		FArrayList blCgItmOepDOList=eventSourceDTO.getBlCgItmOepDOList();
		BlpaypatoepAggDO blpaypatoepAggDO=eventSourceDTO.getBlpaypatoepAggDO();
		BlStOepDO blStOepDO=eventSourceDTO.getBlStOepDO();
		BlIncOepDO blIncOepDO=eventSourceDTO.getBlIncOepDO();

		IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDO = patRService.findById(patiVisitDO.getId_pat());//患者信息
		//2.构建DTO
		//2.1 构建账单基本DTO
		BlIihIeDTO blIihIeDTO=new BlIihIeDTO();			
		blIihIeDTO.setMsg_type("New");//  消息交互类型		
	    blIihIeDTO.setDomain_id("01");//域ID
		blIihIeDTO.setId_pat(patDO.getCode());// 患者ID
		blIihIeDTO.setId_ent(patDO.getBarcode_chis());// 就诊ID  域ID=门诊时为门诊号(p_bar_code)	域ID=住院时为住院号
//		blIihIeDTO.setId_pat(patDO.getBarcode_chis());// 患者ID
//		blIihIeDTO.setId_ent(patiVisitDO.getId_ent());// 就诊ID
		blIihIeDTO.setEnt_code(patDO.getBarcode_chis());//  就诊号
		DAFacade dafacade=new DAFacade();
		List<OutpatientDO> outpatientDOLst=(List<OutpatientDO>)dafacade.execQuery("select times_op from en_ent_op where id_ent='"+patiVisitDO.getId_ent()+"'", new BeanListHandler(OutpatientDO.class));
		if(outpatientDOLst!=null && outpatientDOLst.size()>0){
			times_op=outpatientDOLst.get(0).getTimes_op().toString();
		    blIihIeDTO.setEnt_times(times_op);//  就诊次数
		}
		//  交易类型
		if(IBlFunCodeConst.FUN_CODE_OPFEECOLLECT.equals(func)){
			blIihIeDTO.setTranstacttype("CHRG");//正常收费
		}else if(IBlFunCodeConst.FUN_CODE_OPFEERTN_RED.equals(func)){ //红冲
	    	blIihIeDTO.setTranstacttype("REV");//退费
	    }else if(IBlFunCodeConst.FUN_CODE_OPFEERTN.equals(func)){
	    	blIihIeDTO.setTranstacttype("ROR");//退费重收
	    }
		
		blIihIeDTO.setMsg_create_date(fmt_dt1.format(new Date()));//消息发送日期
	    //  收款日期		
		blIihIeDTO.setDt_pay(fmt_dt1.format(fmt_dt.parse(blpaypatoepAggDO.getParentDO().getDt_pay().toString())));
		PsnDocDO psnDocDO = psnMap.get(blpaypatoepAggDO.getParentDO().getId_emp_pay());
		if(psnDocDO == null){
			throw new BizException("收款人员"+blpaypatoepAggDO.getParentDO().getId_emp_pay()+"不存在！");
		}
		blIihIeDTO.setId_emp_pay(psnDocDO.getCode());//  收款人编码
		blIihIeDTO.setEmp_pay_name(psnDocDO.getName());//  收款人姓名

		blIihIeDTO.setCode_entp(blpaypatoepAggDO.getParentDO().getCode_enttp());//就诊类型
		//多次就诊一次结算时，bl_st_oep的id_ent为空
		if(blStOepDO.getId_ent()==null || (blStOepDO.getId_ent()!=null && blStOepDO.getId_ent().length()<2))
		{
			id_ent=patiVisitDO.getId_ent();
		}
		else
		{
			id_ent=blStOepDO.getId_ent();
		}
		List<EntHpDO> entHpDOLst=(List<EntHpDO>)dafacade.execQuery("select no_hp,id_hp from en_ent_Hp where id_ent='"+id_ent+"'", new BeanListHandler(EntHpDO.class));
		if(entHpDOLst!=null && entHpDOLst.size()>0)
		{
			blIihIeDTO.setInsur_no(entHpDOLst.get(0).getNo_hp());//  医保号
			HPDO hpDO = hpMap.get(entHpDOLst.get(0).getId_hp());
			if(hpDO!=null)
			{
			    blIihIeDTO.setInsur_charge_type_code(hpDO.getCode());//病人医保付费类型编码
			    blIihIeDTO.setInsur_charge_type_name(hpDO.getName());//病人医保付费类型名称
			}
		}
		
		
		List<BlPropArOepDO> blPropArOepDOLst=(List<BlPropArOepDO>)dafacade.execQuery("select distinct c.amt_hp  from bl_st_oep a, bl_prop_oep b, bl_prop_ar_oep c,bl_cg_itm_oep d  where a.id_stoep=d.id_stoep    and  a.id_stoep = b.id_stoep   and b.id_propoep = c.id_propoep   and d.id_stoep ='"+blStOepDO.getId_stoep()+"'", new BeanListHandler(BlPropArOepDO.class));
		if(blPropArOepDOLst!=null && blPropArOepDOLst.size()>0){
			blIihIeDTO.setInsur_amt(blPropArOepDOLst.get(0).getAmt_hp().toString());//医保金额
	    }
		blIihIeDTO.setInsur_amt_unit("RMB");//医保金额单位
		blIihIeDTO.setOther_card_pay_no("");//其他卡号
		blIihIeDTO.setOther_card_charge_type_code("");// 病人其他卡付费类型编码
		blIihIeDTO.setOther_card_charge_type_name("");// 病人其他卡付费类型名称
		blIihIeDTO.setOther_card_amt(((blpaypatoepAggDO.getParentDO().getAmt()).multiply(blpaypatoepAggDO.getParentDO().getEu_direct())).toString());// 其他卡金额
		blIihIeDTO.setOther_card_amt_unit("RMB");//其他卡金额单位
	
		//**********************账单
		//2.2组装《发票项目CODE,发票项目对应下收费金额>
		List<BlIihIe_bill_DTO> blIihIe_bill_DTOLst=new ArrayList<BlIihIe_bill_DTO>();
//		IBlcgqueryService iBlcgqueryService=ServiceFinder.find(IBlcgqueryService.class);
//		SrvVsInvoiceTypeDTO[] srvVsInvoiceTypeDTOArr=iBlcgqueryService.GetInvocieTypeByStOepId(blStOepDO.getId_stoep());
		 BlCgItmOepDO[] blCgItmOepDOArr=(BlCgItmOepDO[]) blCgItmOepDOList.toArray(new BlCgItmOepDO[]{});
		 List<SrvVsInvoiceTypeDTO> srvVsInvoiceTypeDTOLst=new ArrayList<SrvVsInvoiceTypeDTO>();
		for(BlCgItmOepDO blCgItmOepDO: blCgItmOepDOArr)
		{
			SrvVsInvoiceTypeDTO srvVsInvoiceTypeDTO=new SrvVsInvoiceTypeDTO();
			srvVsInvoiceTypeDTO.setId_srv(blCgItmOepDO.getId_srv());
			srvVsInvoiceTypeDTO.setName(blCgItmOepDO.getName_inccaitm());
			srvVsInvoiceTypeDTO.setCode(blCgItmOepDO.getCode_inccaitm());
			if(IBlFunCodeConst.FUN_CODE_OPFEERTN_RED.equals(func))
			{
				srvVsInvoiceTypeDTO.setAmt_ratio(blCgItmOepDO.getAmt_ratio().multiply(new FDouble(-1))); //退费
			}
			else
			{
				srvVsInvoiceTypeDTO.setAmt_ratio(blCgItmOepDO.getAmt_ratio()); //收费
			}
			srvVsInvoiceTypeDTOLst.add(srvVsInvoiceTypeDTO);
		}
		SrvVsInvoiceTypeDTO[] srvVsInvoiceTypeDTOArr=srvVsInvoiceTypeDTOLst.toArray(new SrvVsInvoiceTypeDTO[0]);
		
	    Map<String,FDouble> invoceCodeAmtMap=new HashMap<String,FDouble>();//《发票项目CODE,发票项目对应下收费>
		Map<String,String> idsrvInvoceCodeMap=new HashMap<String,String>();//<服务id_srv,发票项目CODE >
		String code="";
		if(srvVsInvoiceTypeDTOArr==null)
		{
			throw new BizException("没有找到发票项目及数据");
		}
		//《发票项目CODE,发票项目对应下收费>
		for(SrvVsInvoiceTypeDTO srvVsInvoiceTypeDTO:srvVsInvoiceTypeDTOArr)
		{
			if(!idsrvInvoceCodeMap.containsKey(srvVsInvoiceTypeDTO.getId_srv()))
			{
				//（id_srv,对应的发票分类code)
				idsrvInvoceCodeMap.put(srvVsInvoiceTypeDTO.getId_srv(), srvVsInvoiceTypeDTO.getCode());
			}
			if(!invoceCodeAmtMap.containsKey(srvVsInvoiceTypeDTO.getCode()))
			{
				//（发票分类code,钱）
				invoceCodeAmtMap.put(srvVsInvoiceTypeDTO.getCode(), srvVsInvoiceTypeDTO.getAmt_ratio());
			}
			else
			{
				FDouble temp=new FDouble(0); 
			    temp=(new FDouble(invoceCodeAmtMap.get(srvVsInvoiceTypeDTO.getCode()))).add(srvVsInvoiceTypeDTO.getAmt_ratio());
			    invoceCodeAmtMap.remove(srvVsInvoiceTypeDTO.getCode());
			    //invoceCodeAmtMap.put(srvVsInvoiceTypeDTO.getCode(), srvVsInvoiceTypeDTO.getAmt_ratio());
			    invoceCodeAmtMap.put(srvVsInvoiceTypeDTO.getCode(), temp);
			}
		}
		
		
		
		
		//2.3根据发票项目分类，构建账单项
		List<String> codeLst=new ArrayList<String>();
		Iterator invoceCodeAmt= invoceCodeAmtMap.entrySet().iterator();
		while (invoceCodeAmt.hasNext())
		{
			Entry e = (Entry)invoceCodeAmt.next();			
			code = (String)e.getKey();
			for(SrvVsInvoiceTypeDTO srvVsInvoiceTypeDTO:srvVsInvoiceTypeDTOArr)
			{
				 if(!codeLst.contains(code))
				 {
					  if(code.equals(srvVsInvoiceTypeDTO.getCode()))
					  {
						  codeLst.add(code);
						  BlIihIe_bill_DTO blIihIe_bill_DTO=new BlIihIe_bill_DTO();	
						  if(blIncOepDO==null){
							  blIihIe_bill_DTO.setIncno("");// 收据号
						  }
						  else{
							  blIihIe_bill_DTO.setIncno(blIncOepDO.getIncno());// 收据号
						  }
						  if(IBlFunCodeConst.FUN_CODE_OPFEERTN_RED.equals(func)){
							  blIihIe_bill_DTO.setRed_rcptno(blIncOepDO.getIncno());// 红冲账单流水号
						  }		 
						  blIihIe_bill_DTO.setInccode(srvVsInvoiceTypeDTO.getCode());// 账单码编码
						  blIihIe_bill_DTO.setIncname(srvVsInvoiceTypeDTO.getName());// 账单码名称
						  if(blIncOepDO==null){
							  blIihIe_bill_DTO.setInc_dt(fmt_dt1.format(fmt_dt.parse(blStOepDO.getDt_st().toString())));// 账单日期
						  }
						  else{
							  blIihIe_bill_DTO.setInc_dt(fmt_dt1.format(fmt_dt.parse(blIncOepDO.getDt_inc().toString())));// 账单日期
						  }
						  blIihIe_bill_DTO.setInc_amt(invoceCodeAmtMap.get(code).toString());//  账单金额
						  blIihIe_bill_DTO.setInc_amt_unit("RMB");// 账单金额单位
						  if(blIncOepDO==null){
							  blIihIe_bill_DTO.setId_pat(blStOepDO.getId_pat().toString());// 账单日期
						  }
						  else{
							  blIihIe_bill_DTO.setId_pat(blIncOepDO.getId_pat());// 患者ID
						  }
						  
						  blIihIe_bill_DTOLst.add(blIihIe_bill_DTO);
						  
						
					  }
				 }
			  }
		 }
		 //blIihIeDTO.setBlIihIe_bill_DTO(blIihIe_bill_DTO);
		 //**********************费用明细信息
		 Integer index_no=0;
		
			 
		 //2.4构建账单，账单下明细的关系
		 FArrayList2 blIihIeBillDTOList = new FArrayList2();
		 for(BlIihIe_bill_DTO blIihIe_bill_DTO:blIihIe_bill_DTOLst)
		 {//账单项目
			 index_no=0;
			 FArrayList2 blIihIeItemDTOList = new FArrayList2();
			 for(BlCgItmOepDO blCgItmOepDO:blCgItmOepDOArr) 
			 {//收费明细
				 if(idsrvInvoceCodeMap.get(blCgItmOepDO.getId_srv()).equals(blIihIe_bill_DTO.getInccode()))
				 {					 
					 index_no++;
					 BlIihIe_item_DTO blIihIe_item_DTO=new BlIihIe_item_DTO();
					 blIihIe_item_DTO.setHpsrvtp_code(blCgItmOepDO.getSd_hpsrvtp());// 项目分组编码
					 String hpSrvTpName = hpSrvTpMap.get(blCgItmOepDO.getSd_hpsrvtp());
					 if(hpSrvTpName != null){
						 blIihIe_item_DTO.setHpsrvtp_name(hpSrvTpName); //项目分组名称
//						 throw new BizException("医保计划目录类型不存在");
					 }
					 
				     blIihIe_item_DTO.setInc_code1(blIihIe_bill_DTO.getInccode());	//费别编码
				     blIihIe_item_DTO.setInc_name1(blIihIe_bill_DTO.getIncname());//费别名称
				     blIihIe_item_DTO.setBill_item_no(index_no.toString());//细目号
				     blIihIe_item_DTO.setFg_bb_no("N");// 是否婴儿标记编码
				     blIihIe_item_DTO.setFg_bb("N");//  是否婴儿标记
				     blIihIe_item_DTO.setSettlement_times(1);	//  结算次数
				     blIihIe_item_DTO.setEnt_times(times_op);//就诊次数
					 //交易类型
					 if(IBlFunCodeConst.FUN_CODE_OPFEECOLLECT.equals(func)){
						  blIihIe_item_DTO.setCharge_status_code("4");//  费用状态编码
						  blIihIe_item_DTO.setCharge_status_name("收费");//费用状态名称
					 }else if(IBlFunCodeConst.FUN_CODE_OPFEERTN.equals(func)){
						  blIihIe_item_DTO.setCharge_status_code("4");//  费用状态编码
						  blIihIe_item_DTO.setCharge_status_name("收费");//费用状态名称
					 }else if(IBlFunCodeConst.FUN_CODE_OPFEERTN_RED.equals(func)){
						  blIihIe_item_DTO.setCharge_status_code("7");//  费用状态编码
						  blIihIe_item_DTO.setCharge_status_name("冲账");//费用状态名称
					 }
				     blIihIe_item_DTO.setPrice_date(fmt_dt1.format(fmt_dt.parse(blpaypatoepAggDO.getParentDO().getDt_pay().toString())));//项目收费时间
				     blIihIe_item_DTO.setRecipe_no(blCgItmOepDO.getId_pres());//处方号:
				     CiPresDO ciPresDO1 = ciPresDO.get(blCgItmOepDO.getId_pres());
				     if(ciPresDO1 != null){
				    	 blIihIe_item_DTO.setRecipe_type_code(ciPresDO1.getSd_srvtp());//处方类别编码
						 blIihIe_item_DTO.setRecipe_type_name(ciPresDO1.getName());//处方类别名称
				     }
					 
				     blIihIe_item_DTO.setPres_item_charge_no(blCgItmOepDO.getId_or());//费用号
				     blIihIe_item_DTO.setOrder_type_code(blCgItmOepDO.getSd_srvtp());//医嘱类别编码
				     blIihIe_item_DTO.setId_or(blCgItmOepDO.getId_or());//医嘱号
				     SrvCateDO srvCateDO = srvCateMap.get(blCgItmOepDO.getId_srvca());
				     if(srvCateDO != null){
			    		 blIihIe_item_DTO.setOrder_type_name(srvCateDO.getName());//医嘱类别名称
				     }
		    		 
				     blIihIe_item_DTO.setSerial_no(blCgItmOepDO.getSrvu());// 包装序号,即包装单位
				     if(blCgItmOepDO.getFg_mm()!=null && blCgItmOepDO.getFg_mm().booleanValue()){
				    	 blIihIe_item_DTO.setCharge_code(blCgItmOepDO.getCode_mm());//费用编码
				     }else{
				    	 blIihIe_item_DTO.setCharge_code(blCgItmOepDO.getCode_srv());//费用编码
				     }
				     blIihIe_item_DTO.setCharge_name(blCgItmOepDO.getName_srv());//费用名称
				     blIihIe_item_DTO.setPrice(blCgItmOepDO.getPrice().toString());//单价
				     blIihIe_item_DTO.setPrice_srvu("RMB");//单价价格单位
				     blIihIe_item_DTO.setQuan(blCgItmOepDO.getQuan().toString());//数量
				     MeasDocDO measDocDO =  measMap.get(blCgItmOepDO.getSrvu());
				     if(measDocDO != null){
					     blIihIe_item_DTO.setHpsrvtp_name(measDocDO.getName()); //单位
				     }
				     String hpSrvTp = hpSrvTpMap.get(blCgItmOepDO.getSd_hpsrvtp());
				     if(hpSrvTp != null){
					     blIihIe_item_DTO.setInsur_group_name(hpSrvTp);
//				    	 throw new BizException("医保类型"+blCgItmOepDO.getSd_hpsrvtp()+"不存在！");
				     }
				     
				     blIihIe_item_DTO.setInsur_group(blCgItmOepDO.getSd_hpsrvtp());//医保类型编码
				     blIihIe_item_DTO.setCharge_confirm_emp_code(blpaypatoepAggDO.getParentDO().getId_emp_pay());//费用确认人编码
				     PsnDocDO psnDocDO1 = psnMap.get(blpaypatoepAggDO.getParentDO().getId_emp_pay());
				     if(psnDocDO1 != null){
					     blIihIe_item_DTO.setCharge_confirm_emp_name(psnDocDO1.getName());//费用确认人姓名
//				    	 throw new BizException("费用确认人"+blpaypatoepAggDO.getParentDO().getId_emp_pay()+"不存在！");
				     }
				     
				     blIihIe_item_DTO.setCharge_apply_emp_code(blCgItmOepDO.getId_emp_or());//费用申请人编码
				     PsnDocDO psnDocDO2 = psnMap.get(blCgItmOepDO.getId_emp_or());
				     if(psnDocDO2 != null){
					     blIihIe_item_DTO.setCharge_apply_emp_name(psnDocDO2.getName());//费用申请人姓名
//				    	 throw new BizException("费用申请人"+blCgItmOepDO.getId_emp_or()+"不存在！");
				     }
				     
				     blIihIe_item_DTO.setApply_dep_code(blCgItmOepDO.getId_dep_or());//申请科室编码
				     DeptDO deptDO = deptMap.get(blCgItmOepDO.getId_dep_or());
				     if(deptDO != null){
					     blIihIe_item_DTO.setApply_dep_name(deptDO.getName());//申请科室名称
//				    	 throw new BizException("申请科室"+blCgItmOepDO.getId_dep_or()+"不存在！");
				     }
				     
				     DeptDO deptDO1 = deptMap.get(blCgItmOepDO.getId_dep_mp());
				     if(deptDO1 != null){
					     blIihIe_item_DTO.setMp_dep_name(deptDO1.getName());//费用执行科室名称
//				    	 throw new BizException("费用执行科室"+blCgItmOepDO.getId_dep_mp()+"不存在！");
				     }
				     
				     blIihIe_item_DTO.setMp_dep_code(this.getDeptCodeById(blCgItmOepDO.getId_dep_mp()));//费用执行科室编码
				     if(blIncOepDO==null){
				    	 blIihIe_item_DTO.setInc_no("");// 收据号
				     }else{
				    	 blIihIe_item_DTO.setInc_no(blIncOepDO.getIncno());// 收据号
				     }
				    
				     blIihIeItemDTOList.add(blIihIe_item_DTO);
				     
				 }
			 }
			 
			 blIihIe_bill_DTO.setBliihie_item_dto(blIihIeItemDTOList);//账单信息
			 
			 blIihIeBillDTOList.add(blIihIe_bill_DTO);
			
		}
		 blIihIeDTO.setBliihie_bill_dto(blIihIeBillDTOList);
		return blIihIeDTO;
	}
	
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException{
		if(!IBlEventConst.EVENT_SOURCE_BL_OEP_SETTLEMENT.equalsIgnoreCase(event.getSourceID())
			|| !IEventType.TYPE_INSERT_AFTER.equals(event.getEventType())){
			throw new BizException("门诊收款确认");
		}		
	}

	/**
	 * 获取部门编码
	 * @throws BizException 
	 * */
	public String getDeptCodeById(String id_dept) throws BizException{
		IDeptRService service = ServiceFinder.find(IDeptRService.class);
		DeptDO deptDO = service.findById(id_dept);
		if(deptDO == null){
			throw new BizException("没有查到对应部门！");
		}
		return deptDO.getCode();
	}
	
	/**
	 * 获取医保计划目录类型信息
	 * */
	@SuppressWarnings("unchecked")
	public Map<String,String> getHpSrvTpInfos() throws BizException{
		Map<String,String> hpSrvOrCaMap = new HashMap<String,String>();
		DAFacade dafacade=new DAFacade();
		List<HPSrvorcaDO> HpSrvOrCaDOLst=(List<HPSrvorcaDO>)dafacade.execQuery("SELECT distinct(a.name) name, b.sd_hpsrvtp  FROM bd_udidoc a, BD_HP_SRVORCA b  WHERE a.id_udidoc = b.id_hpsrvtp", new BeanListHandler(HPSrvorcaDO.class));
		if(HpSrvOrCaDOLst == null || HpSrvOrCaDOLst.size() == 0){
			throw new BizException("医保计划目录信息不存在！");
		}
		for(HPSrvorcaDO hPSrvorcaDO : HpSrvOrCaDOLst){
			hpSrvOrCaMap.put(hPSrvorcaDO.getSd_hpsrvtp(), hPSrvorcaDO.getName());
		}
		return hpSrvOrCaMap;
	}
	
	/**
	 * 获取人员信息
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	public Map<String,PsnDocDO> getPsndocInfos() throws BizException{
		Map<String,PsnDocDO> psnMap = new HashMap<String,PsnDocDO>();
		DAFacade dafacade=new DAFacade();
		List<PsnDocDO> PsnDocDOLst1=(List<PsnDocDO>)dafacade.execQuery(" select id_psndoc,code,name from bd_psndoc", new BeanListHandler(PsnDocDO.class));
		if(PsnDocDOLst1 == null || PsnDocDOLst1.size() == 0){
			throw new BizException("人员信息不存在！");
		}
		for(PsnDocDO psnDocDO : PsnDocDOLst1){
			psnMap.put(psnDocDO.getId_psndoc(), psnDocDO);
		}
		return psnMap;
	}
	
	/**
	 * 获取部门信息
	 * */
	@SuppressWarnings("unchecked")
	public Map<String,DeptDO> getDeptInfo() throws BizException{
		Map<String,DeptDO> depMap = new HashMap<String,DeptDO>();
		DAFacade dafacade=new DAFacade();
		List<DeptDO> deptList = (List<DeptDO>)dafacade.execQuery("select id_dep,code,name from bd_dep", new BeanListHandler(DeptDO.class));
		if(deptList == null || deptList.size() == 0){
			throw new BizException("科室信息不存在！");
		}
		for(DeptDO deptDO : deptList){
			depMap.put(deptDO.getId_dep(), deptDO);
		}
		return depMap;
	}
	
	/**
	 * 获取单位信息
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	public Map<String,MeasDocDO> getMeasdocInfos() throws BizException{
		Map<String,MeasDocDO> measMap = new HashMap<String,MeasDocDO>();
		DAFacade dafacade=new DAFacade();
		List<MeasDocDO> measLst=(List<MeasDocDO>)dafacade.execQuery("SELECT ID_MEASDOC,CODE,NAME FROM BD_MEASDOC", new BeanListHandler(MeasDocDO.class));
		if(measLst == null || measLst.size() == 0){
			throw new BizException("单位信息不存在！");
		}
		for(MeasDocDO measDocDO : measLst){
			measMap.put(measDocDO.getId_measdoc(), measDocDO);
		}
		return measMap;
	}
	
	/**
	 * 获取服务分类信息
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	public Map<String,SrvCateDO> getSrvCateInfos() throws BizException{
		Map<String,SrvCateDO> srvCateMap = new HashMap<String,SrvCateDO>();
		DAFacade dafacade=new DAFacade();
		List<SrvCateDO> bdSrvCaLst=(List<SrvCateDO>)dafacade.execQuery(" select name from bd_srvca", new BeanListHandler(SrvCateDO.class));
		if(bdSrvCaLst == null || bdSrvCaLst.size() == 0){
			throw new BizException("单位信息不存在！");
		}
		for(SrvCateDO srvCateDO : bdSrvCaLst){
			srvCateMap.put(srvCateDO.getId_srvca(), srvCateDO);
		}
		return srvCateMap;
	}
	
	/**
	 * 获取患者医保计划信息
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	public Map<String,HPDO> getPatHpTpInfo() throws BizException{
		Map<String,HPDO> map = new HashMap<String,HPDO>();
		StringBuffer sql = new StringBuffer();
		sql.append("select code,name from bd_hp");
		DAFacade dafacade=new DAFacade();
		List<HPDO> hptList = (List<HPDO>)dafacade.execQuery(sql.toString(), new BeanListHandler(HPDO.class));
		if(hptList == null || hptList.size() == 0){
			throw new BizException("患者对应的医保计划信息不存在！");
		}
		for(HPDO hpDO : hptList){
			map.put(hpDO.getId_hp(), hpDO);
		}
		return map;
	}
	
	/**
	 * 获取处方信息
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	public Map<String,CiPresDO> getCiPresInfo() throws BizException{
		Map<String,CiPresDO> ciPresMap = new HashMap<String,CiPresDO>();
		StringBuffer sql = new StringBuffer();
		sql.append("select c.id_pres,c.id_prestp,c.sd_prestp,b.name as prestp_name ")
			.append("from ci_pres c ")
			.append("left join bd_udidoc b on b.id_udidoc = c.id_prestp");
		DAFacade dafacade=new DAFacade();
		List<CiPresDO> prestList = (List<CiPresDO>)dafacade.execQuery(sql.toString(), new BeanListHandler(CiPresDO.class));
		if(prestList == null || prestList.size() == 0){
			throw new BizException("处方信息不存在！");
		}
		for(CiPresDO ciPresDO : prestList){
			ciPresMap.put(ciPresDO.getId_pres(), ciPresDO);
		}
		return ciPresMap;
	}
	
	/**
	 * 获取医保信息
	 * */
	@SuppressWarnings("unchecked")
	public Map<String,HPDO> getHpInfo() throws BizException{
		Map<String,HPDO> hpMap = new HashMap<String,HPDO>();
		StringBuffer sql = new StringBuffer();
		sql.append("select id_hp,code,name from bd_hp");
		DAFacade dafacade=new DAFacade();
		List<HPDO> hpList = (List<HPDO>)dafacade.execQuery(sql.toString(), new BeanListHandler(HPDO.class));
		if(hpList == null || hpList.size() == 0){
			throw new BizException("医保信息不存在！");
		}
		for(HPDO hpDO : hpList){
			hpMap.put(hpDO.getId_hp(), hpDO);
		}
		return hpMap;
	}
}
