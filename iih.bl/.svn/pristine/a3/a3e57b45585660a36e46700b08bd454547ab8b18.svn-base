package iih.bl.cg.bp.oep;

import java.util.ArrayList;
import java.util.List;
import iih.bd.base.utils.AppUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepMDORService;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.ep.OepCgEP;
import iih.bl.cg.ep.OepIncEP;
import iih.bl.cg.ep.OepStEP;
import iih.bl.cg.service.d.BL_Register_RefundDTO;
import iih.bl.cg.service.d.BlRefundItmDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.cg.service.s.bp.RefundAndSettlementBp;
import iih.bl.cg.service.s.bp.RefundAndSettlementInsurToSaveBp;
import iih.bl.cg.service.s.bp.RefundFeeBp;
import iih.bl.cg.service.s.bp.RefundInsurBp;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepRService;
import iih.bl.st.blstoep.d.BlStOepDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 改变门诊挂号就诊
 * @author 
 * @since 2017-11-23
 *
 */
public class ChangeOpRegEntBP {
	/**
	 * 改变门诊挂号就诊
	 * 将之前的费用明细进行红冲，并修改就诊ID
	 * @param cgId 原挂号记账ID
	 * @param targetEntId 目标就诊ID
	 * @return 新的记账ID
	 * @throws BizException
	 * @author 
	 */
	@SuppressWarnings("unused")
	public String exec(String cgId,String targetEntId) throws BizException{
		BlcgoepAggDO[] blcgoepAggDOs = this.getBlcgoepAggDOByIdcgoep(cgId);//此处的cgId 为主表的主键id即id_cgoep
    	//1.红冲 ：原样红冲  支付明细是虚交易 
		OperatorInfoDTO operDTO = new OperatorInfoDTO();
		operDTO.setId_emp(Context.get().getStuffId());
		operDTO.setId_dep(Context.get().getDeptId());
		operDTO.setId_grp(Context.get().getGroupId());
		operDTO.setId_org(Context.get().getOrgId());
		operDTO.setId_org_emp(Context.get().getOrgId());
		//应先由cgId来组装BL_Register_RefundDTO id_cgoep_and_ent；
		BL_Register_RefundDTO refundDTO = this.assRefundDTOByIdcgid(cgId,blcgoepAggDOs);
		BlIncItmVsTypeDTO[]  blIncItmVsTypeDTOs= this.register_RefundAndSettlement(refundDTO, operDTO,null,FBoolean.FALSE);
		
		//2.重收 ：原样重收，id_ent是新的值  对应的原支付时虚交易
	    List<BlOrderAppendBillParamDTO>  bloabpDTOList = new ArrayList<BlOrderAppendBillParamDTO>();
		if(blcgoepAggDOs !=null && blcgoepAggDOs.length>0 )
		{
			BlCgItmOepDO[] cgitms = blcgoepAggDOs[0].getBlCgItmOepDO();
			for(BlCgItmOepDO blcgitmdo :cgitms )
			{
				BlOrderAppendBillParamDTO blOrderAppendBillParamDTO = new BlOrderAppendBillParamDTO();
				blOrderAppendBillParamDTO.setId_ent(targetEntId);
				blOrderAppendBillParamDTO.setId_pat(blcgitmdo.getId_pat());
				blOrderAppendBillParamDTO.setDt_or(AppUtils.getServerDateTime());
				blOrderAppendBillParamDTO.setId_hp(blcgitmdo.getId_hp());
				blOrderAppendBillParamDTO.setId_grp(blcgitmdo.getId_grp());
				blOrderAppendBillParamDTO.setId_org(blcgitmdo.getId_org());
				blOrderAppendBillParamDTO.setId_srv(blcgitmdo.getId_srv());
				blOrderAppendBillParamDTO.setQuan(blcgitmdo.getQuan());
				blOrderAppendBillParamDTO.setEu_direct(blcgoepAggDOs[0].getParentDO().getEu_direct());
				blOrderAppendBillParamDTO.setCode_enttp(blcgitmdo.getCode_enttp());
				blOrderAppendBillParamDTO.setId_enttp(blcgitmdo.getId_enttp());
				blOrderAppendBillParamDTO.setId_pres(blcgitmdo.getId_pres());
				blOrderAppendBillParamDTO.setId_or(blcgitmdo.getId_or());
				blOrderAppendBillParamDTO.setId_orsrv(blcgitmdo.getId_orsrv());
				blOrderAppendBillParamDTO.setId_srvtp(blcgitmdo.getId_srvtp());
				blOrderAppendBillParamDTO.setSd_srvtp(blcgitmdo.getSd_srvtp());
				blOrderAppendBillParamDTO.setId_srvca(blcgitmdo.getId_srvca());
				blOrderAppendBillParamDTO.setId_srv(blcgitmdo.getId_srv());
				blOrderAppendBillParamDTO.setCode_srv(blcgitmdo.getCode_srv());
				blOrderAppendBillParamDTO.setSrvu(blcgitmdo.getSrvu());
				blOrderAppendBillParamDTO.setName_srv(blcgitmdo.getName_srv());
				blOrderAppendBillParamDTO.setPrice(blcgitmdo.getPrice());
				blOrderAppendBillParamDTO.setId_org_or(blcgitmdo.getId_org_or());
				blOrderAppendBillParamDTO.setId_dep_or(blcgitmdo.getId_dep_or());
				blOrderAppendBillParamDTO.setId_emp_or(blcgitmdo.getId_emp_or());
				blOrderAppendBillParamDTO.setId_org_mp(blcgitmdo.getId_org_mp());
				blOrderAppendBillParamDTO.setId_dep_mp(blcgitmdo.getId_dep_mp());
				
				bloabpDTOList.add(blOrderAppendBillParamDTO);
			}
		}
		BlPayPatOepDO  blPayPatDOList = this.getBlPayPatOepDOByidcgoep(cgId);
		IBlpaypatoepRService oeppayser  = ServiceFinder.find(IBlpaypatoepRService.class);
		 BlpaypatoepAggDO payAggdo  = new   BlpaypatoepAggDO();
		if(blPayPatDOList!=null)
		{
	        payAggdo = oeppayser.findById(blPayPatDOList.getId_paypatoep());	
	        BlPayPatOepDO maindo = payAggdo.getParentDO();
	        maindo.setId_paypatoep(null);
	        maindo.setStatus(DOStatus.NEW);
	       
	        BlPayItmPatOepDO[] cgiTMdoS = payAggdo.getBlPayItmPatOepDO();
	        if(cgiTMdoS !=null && cgiTMdoS.length>0 )
	        {
	        	 for(BlPayItmPatOepDO item :cgiTMdoS)
	        	 {
	        		 item.setId_payitmpatoep(null);
	        		 item.setId_paypatoep(null);
	     	         item.setStatus(DOStatus.NEW);
	     	     }	
	        }
	        payAggdo.setParentDO(maindo);
	        payAggdo.setBlPayItmPatOepDO(cgiTMdoS);
	    }
        IBLCiOrderToBlCgService ciToCgService = ServiceFinder.find(IBLCiOrderToBlCgService.class);
		String  tradeno ="";
		String  codest ="";
	
		BlIncItmVsTypeDTO[] blIncItmVsTypeDTOArr =
				ciToCgService.PriceAndSettlementPayment_Register(bloabpDTOList.toArray(new BlOrderAppendBillParamDTO[]{}),
						payAggdo, null, null, operDTO, tradeno, codest, FBoolean.FALSE, FBoolean.FALSE, cgId);
		IBlcgoepMDORService cgRser = ServiceFinder.find(IBlcgoepMDORService.class);
		
		BlCgOepDO[] blCgOepDOs = cgRser.find(" id_cgoep IN (SELECT ID_CGOEP FROM BL_CG_ITM_OEP WHERE ID_ENT='"
				+ targetEntId + "')", "", FBoolean.FALSE);

	    if(blCgOepDOs!=null && blCgOepDOs.length>0)
	    {
	    	return blCgOepDOs[0].getId_cgoep();
	    }
		return null;
	}
	
	
	/**
	 * 根据记账主键idcg来获得记账AggDO 
	 * @param id_cgid
	 * @return
	 * @throws BizException
	 */
	private BlcgoepAggDO[] getBlcgoepAggDOByIdcgoep(String id_cgid) throws BizException
	{
		String condstr = "";
		   // 1.获得挂号对应的记账信息
			IBlcgoepRService iBlcgoepRService = ServiceFinder.find(IBlcgoepRService.class);

			condstr = "";
			condstr = " a0.id_cgoep='" + id_cgid + "' ";

			BlcgoepAggDO[] register_blcgoepAggDO = iBlcgoepRService.find(condstr, "", FBoolean.FALSE);
			if (null == register_blcgoepAggDO || register_blcgoepAggDO.length == 0) {
			  throw new BizException("查询挂号对应的原门诊记账信息失败。");
			}
			return register_blcgoepAggDO;
	}

	
	/**
	 * 根据记账主键idcg来获得付款DO 
	 * @param id_cgid
	 * @return
	 * @throws BizException
	 */
	private BlPayPatOepDO  getBlPayPatOepDOByidcgoep(String id_cgid)throws BizException
	{
		StringBuilder sb = new StringBuilder();
		sb.append("select pay.*  from  bl_pay_pat_oep pay ");
		sb.append("inner join bl_st_oep  st  on st.id_paypatoep = pay.id_paypatoep ");
		sb.append("inner join bl_cg_itm_oep  cgitm on st.id_stoep = cgitm.id_stoep ");
		sb.append("where  cgitm.id_cgoep ='").append(id_cgid).append("' ");
		@SuppressWarnings("unchecked")
		List<BlPayPatOepDO> blPayPatOepDOList = (List<BlPayPatOepDO>) new DAFacade().execQuery(sb.toString(),  new BeanListHandler(BlPayPatOepDO.class));
	    if(blPayPatOepDOList !=null && blPayPatOepDOList.size()>0)
	    {
	    	return blPayPatOepDOList.get(0);
	    }
		return null;
	}
	
	/**
	 * 根据idcg来组装退费用dto数据
	 * @param id_cgid
	 * @return
	 * @throws BizException
	 */
	private BL_Register_RefundDTO assRefundDTOByIdcgid(String id_cgid ,BlcgoepAggDO[] register_blcgoepAggDO)throws BizException{
	     // 1.获得挂号对应的记账信息
		BL_Register_RefundDTO refundDTO = new BL_Register_RefundDTO();
		BlCgItmOepDO[] BlCgItmOepDOs = register_blcgoepAggDO[0].getBlCgItmOepDO();
    	BlPayPatOepDO regInfoDTOList =this.getBlPayPatOepDOByidcgoep(id_cgid);
        if(regInfoDTOList!=null )
        {
        	refundDTO.setSd_pttp(regInfoDTOList.getSd_pttp());	
        }
	    refundDTO.setId_cgoep(id_cgid);
		refundDTO.setAllRefundAndAllCharge(FBoolean.FALSE);
	    refundDTO.setPrintRedInc(FBoolean.FALSE);//不打印红冲发票
	    return refundDTO;
	}
	
	/**
	 * 退费重收(将id_cgoep下所有明细都退掉)
	 * @param id_cgoep_and_ent
	 * @param operDTO
	 * @param blpaypatoepAggDO
	 * @param isNew
	 * @return
	 * @throws BizException
	 */
	private BlIncItmVsTypeDTO[]  register_RefundAndSettlement(BL_Register_RefundDTO id_cgoep_and_ent  ,OperatorInfoDTO operDTO,BlpaypatoepAggDO blpaypatoepAggDO,FBoolean isNew)throws BizException
	{
		String condstr = "";
	    FBoolean fgRealpay = FBoolean.TRUE;
		BlIncItmVsTypeDTO[] BlIncItmVsTypeDTO_temp = null;
		List<String> id_stoep_list = new ArrayList<String>();
		// 1.获得挂号对应的记账信息
		IBlcgoepRService iBlcgoepRService = ServiceFinder.find(IBlcgoepRService.class);

		condstr = "";
		condstr = " a0.id_cgoep='" + id_cgoep_and_ent.getId_cgoep() + "' ";

		BlcgoepAggDO[] register_blcgoepAggDO = iBlcgoepRService.find(condstr, "", FBoolean.FALSE);
		if (null == register_blcgoepAggDO || register_blcgoepAggDO.length == 0) {
			//throw new BizException("查询挂号对应的原门诊记账信息失败。\r\n就诊主键:" + id_cgoep_and_ent.getId_ent());
			throw new BizException("查询挂号对应的原门诊记账信息失败。");
		}
		
		id_stoep_list.clear();// 清空
		// 2.获得需要退费的所有结算号，
		for (int ii = 0; ii < register_blcgoepAggDO.length; ii++) {
			BlCgItmOepDO[] BlCgItmOepDO_arr = register_blcgoepAggDO[ii].getBlCgItmOepDO();
			for (int j = 0; j < BlCgItmOepDO_arr.length; j++) {
				if (!id_stoep_list.contains(BlCgItmOepDO_arr[j].getId_stoep())) {
					id_stoep_list.add(BlCgItmOepDO_arr[j].getId_stoep());
				}
			}
		}
		// 查看此笔交易是否是医保交易
		FBoolean fbIsHp = FBoolean.FALSE;
		// 3.根据结算号取结算号下的退款信息
		if (id_stoep_list != null && id_stoep_list.size() > 0) {
			if (id_stoep_list.size() > 1) {
				throw new BizException("退号请分开操作");
			}
			String[] id_stoep_arr = id_stoep_list.toArray(new String[] {});

			List<String> id_cgoep_arr_list = new ArrayList<String>();
			List<BlRefundItmDTO> BlRefundItmDTO_list = new ArrayList<BlRefundItmDTO>();
			// 用结算反查记账
			for (int ii = 0; ii < register_blcgoepAggDO.length; ii++) {
				BlCgItmOepDO[] BlCgItmOepDO_arr = register_blcgoepAggDO[ii].getBlCgItmOepDO();

				for (int j = 0; j < BlCgItmOepDO_arr.length; j++) {
					if (id_stoep_arr[0].equals(BlCgItmOepDO_arr[j].getId_stoep())) {
						if (!id_cgoep_arr_list.contains(BlCgItmOepDO_arr[j].getId_cgoep())) {
							id_cgoep_arr_list.add(BlCgItmOepDO_arr[j].getId_cgoep());
						}
						BlRefundItmDTO blRefundItmDTO = new BlRefundItmDTO();
						blRefundItmDTO.setId_cgoep(BlCgItmOepDO_arr[j].getId_cgoep());
						blRefundItmDTO.setId_cditmoep(BlCgItmOepDO_arr[j].getId_cgitmoep());
						blRefundItmDTO.setQuan_refund(BlCgItmOepDO_arr[j].getQuan());
						blRefundItmDTO.setEu_srctp(BlCgItmOepDO_arr[j].getEu_srctp());
						BlRefundItmDTO_list.add(blRefundItmDTO);

						fbIsHp = BlCgItmOepDO_arr[j].getFg_hp();
					}
				}
			}

			// 4.获得该结算下对应的原始支付信息 当blpaypatoepAggDO为null 的时候 则认为当前调用的是 SC就诊域的操作
			if (blpaypatoepAggDO == null) {
				// 1. 查找原结算信息
				String[] fields = { "id_paypatoep" };
				DAFacade dafacade = new DAFacade();
				@SuppressWarnings("unchecked")
				List<BlStOepDO> blStOepDOLst = (List<BlStOepDO>) dafacade.findByCond(BlStOepDO.class, " id_stoep='" + id_stoep_list.toArray(new String[0])[0] + "'", fields);
				
				if (null == blStOepDOLst || blStOepDOLst.size() == 0) {
					throw new BizException("查询原门诊结算信息失败");
				}
				// 2. 获得该结算下对应的支付信息
				IBlpaypatoepRService iBlpaypatoepRService = ServiceFinder.find(IBlpaypatoepRService.class);
				BlpaypatoepAggDO[] blpaypatoepAggDO_arr = iBlpaypatoepRService.find(" a0.id_paypatoep='" + blStOepDOLst.toArray(new BlStOepDO[0])[0].getId_paypatoep() + "'", "", FBoolean.FALSE);
				if (null == blpaypatoepAggDO_arr || blpaypatoepAggDO_arr.length == 0) {
					// throw new BizException("查询患者收付款信息失败");
					// 获取当前结算是否有收付款信息 如果没有 断定是诊间挂号数据 直接进行删除功能 删除记账，记账明细 结算信息
					// 2017年11月12日 yang.lu
					OepStEP step = new OepStEP();
					
					BlStOepDO stoep = step.getBlStOepDOByIdSt( id_stoep_list.toArray(new String[0])[0]);

					if (StringUtil.isEmpty(stoep.getId_paypatoep())) {

						IBlcgoepRService cgService = ServiceFinder.find(IBlcgoepRService.class);
						BlcgoepAggDO[] cgs = cgService.find(" id_cgoep in (SELECT ID_CGOEP FROM BL_CG_ITM_OEP WHERE ID_STOEP='" + stoep.getId_stoep() + "')", "", FBoolean.FALSE);
						FDateTime nowTime = AppUtils.getServerDateTime();
						//红冲结算数据
						BlStOepDO redStoep = step.redBack_StOep(stoep, operDTO, null, nowTime, cgs[0].getBlCgItmOepDO()[0].getEu_srctp(), null);
						//红冲记账数据
						OepCgEP cgep=new OepCgEP();
						BlcgoepAggDO[] redcgs=cgep.redBack_CgOep(cgs,  nowTime,operDTO, FBoolean.FALSE, FBoolean.TRUE, redStoep.getId_stoep());
						OepIncEP incep=new OepIncEP();
						incep.redback_BlIncOep(FBoolean.FALSE, stoep, redStoep.getId_stoep(), FBoolean.FALSE, FBoolean.FALSE, nowTime, operDTO, redcgs);
						return null;
					}

				} else {
					blpaypatoepAggDO = blpaypatoepAggDO_arr[0];
					blpaypatoepAggDO.getParentDO().setSd_pttp(id_cgoep_and_ent.getSd_pttp());
					blpaypatoepAggDO.getParentDO().setId_paypatoep(null);
					if (!id_cgoep_and_ent.getAllRefundAndAllCharge().booleanValue()) // 全退重收不变
					{
						if (blpaypatoepAggDO.getParentDO().getEu_direct() == BookRtnDirectEnum.REFUND) {
							blpaypatoepAggDO.getParentDO().setEu_direct(BookRtnDirectEnum.CHARGES);
						} else {
							blpaypatoepAggDO.getParentDO().setEu_direct(BookRtnDirectEnum.REFUND);
						}
					}
					blpaypatoepAggDO.getParentDO().setStatus(DOStatus.NEW);
					BlPayItmPatOepDO[] blPayItmPatOepDOArr = blpaypatoepAggDO.getBlPayItmPatOepDO();

					for (BlPayItmPatOepDO blPayItmPatOepDO : blPayItmPatOepDOArr) {
						blPayItmPatOepDO.setId_paypatoep(null);
						blPayItmPatOepDO.setId_payitmpatoep(null);
						if (!id_cgoep_and_ent.getAllRefundAndAllCharge().booleanValue()) // 全退重收不变
						{
							if (blPayItmPatOepDO.getEu_direct() == BookRtnDirectEnum.REFUND) {
								blPayItmPatOepDO.setEu_direct(BookRtnDirectEnum.CHARGES);
							} else {
								blPayItmPatOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
							}
						}
						blPayItmPatOepDO.setFg_realpay(fgRealpay);
						blPayItmPatOepDO.setStatus(DOStatus.NEW);
					}
				}
			}
			// 调用退费和重接函数
			if (!fbIsHp.booleanValue()) // 非医保
			{
				if (id_cgoep_and_ent.getAllRefundAndAllCharge().booleanValue()) // 全退重收
				{
					RefundAndSettlementBp bp = new RefundAndSettlementBp();
					BlIncItmVsTypeDTO_temp = bp.exec(id_stoep_arr[0], id_cgoep_arr_list.toArray(new String[] {}), BlRefundItmDTO_list.toArray(new BlRefundItmDTO[] {}), operDTO, blpaypatoepAggDO); // 重划重收强制不打印红冲票
				} else // 全退
				{
					RefundFeeBp bp = new RefundFeeBp();
					BlIncItmVsTypeDTO_temp = bp.exec(id_stoep_arr[0], 
							id_cgoep_arr_list.toArray(new String[] {}), 
							BlRefundItmDTO_list.toArray(new BlRefundItmDTO[] {}), 
							operDTO, blpaypatoepAggDO, 
							FBoolean.TRUE, 
							id_cgoep_and_ent.getPrintRedInc(),
							null);
				}

			} else {
				// 医保
				BlPropOepDO[] blPropOepDOArr = (BlPropOepDO[]) id_cgoep_and_ent.getBlPropOepDO().toArray(new BlPropOepDO[0]);
				BlproparoepAggDO[] blproparoepAggDOArr = (BlproparoepAggDO[]) id_cgoep_and_ent.getBlproparoepAggDO().toArray(new BlproparoepAggDO[0]);

				for (BlproparoepAggDO blproparoepAggDO : blproparoepAggDOArr) {
					blproparoepAggDO.getParentDO().setId_grp(blPropOepDOArr[0].getId_grp());
					blproparoepAggDO.getParentDO().setId_org(blPropOepDOArr[0].getId_org());
				}
				// 医保全退
				if (!FBoolean.TRUE.equals(isNew)) {

					RefundInsurBp bp = new RefundInsurBp();
					BlIncItmVsTypeDTO_temp = bp.exec(blPropOepDOArr, blproparoepAggDOArr, id_stoep_arr[0], id_cgoep_arr_list.toArray(new String[] {}), BlRefundItmDTO_list.toArray(new BlRefundItmDTO[] {}), operDTO, blpaypatoepAggDO, id_cgoep_and_ent.getPrintRedInc());
				} else {

					RefundFeeBp bp = new RefundFeeBp();
					BlIncItmVsTypeDTO_temp = bp.exec(id_stoep_arr[0], 
							id_cgoep_arr_list.toArray(new String[] {}), 
							BlRefundItmDTO_list.toArray(new BlRefundItmDTO[] {}), 
							operDTO, blpaypatoepAggDO, 
							FBoolean.TRUE, 
							id_cgoep_and_ent.getPrintRedInc(),
							null);
					BlPropOepDO[] blPropOepDOArr_recharge = null;
					BlproparoepAggDO[] blproparoepAggDOArr_recharge = null;
					if (id_cgoep_and_ent.getBlproparoepAggDO_recharge() != null) {
						blPropOepDOArr_recharge = (BlPropOepDO[]) id_cgoep_and_ent.getBlPropOepDO_recharge().toArray(new BlPropOepDO[0]);
						blproparoepAggDOArr_recharge = (BlproparoepAggDO[]) id_cgoep_and_ent.getBlproparoepAggDO_recharge().toArray(new BlproparoepAggDO[0]);
					}
					// 保存医保分摊，含三部分数据：
					RefundAndSettlementInsurToSaveBp saveBp = new RefundAndSettlementInsurToSaveBp();
					saveBp.exec(blPropOepDOArr, blproparoepAggDOArr, blPropOepDOArr_recharge, blproparoepAggDOArr_recharge, id_stoep_arr[0]);
				}
			}
		}
		return BlIncItmVsTypeDTO_temp;
	}
}
