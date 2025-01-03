package iih.bl.cg.service.s.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.blcgoeptf.d.BlCgItmOepTfRcdDO;
import iih.bl.cg.blcgoeptf.i.IBlcgoeptfCudService;
import iih.bl.cg.blcgoeptf.i.IBlcgoeptfRService;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.bp.DoOepFgAccAmtAcc;
import iih.bl.cg.bp.GetBlCgItmOepMap;
import iih.bl.cg.dto.d.BlCgItmOepMapDTO;
import iih.bl.cg.dto.d.BlCgoepAggAndPrintRedIncItmDTO;
import iih.bl.cg.dto.d.OpRefund4EsDTO;
import iih.bl.cg.ep.OepCgEP;
import iih.bl.cg.ep.OepIncEP;
import iih.bl.cg.ep.OepStEP;
import iih.bl.cg.event.OpRefundEvent;
import iih.bl.cg.service.d.BlRefundItmDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.cg.service.s.bp.qry.GetBlStReFundBillDTOQry;
import iih.bl.cg.service.s.event.BlOpPayEvent;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.comm.IBlFlowKeyConst;
import iih.bl.comm.log.BLBizLogger;
import iih.bl.comm.s.bp.BlThirdPayBP;
import iih.bl.comm.thirdpayapi.BlThirdPayValidateUtil;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.service.i.IBlincQryService;
import iih.bl.itf.dto.thirdpayvalidate.d.BlThirdPayValidateRltDTO;
import iih.bl.itf.payplatform.d.BlOrdReqDTO;
import iih.bl.itf.trdtrans.d.BlThirdTransRcdDO;
import iih.bl.itf.trdtrans.d.TransStateEnum;
import iih.bl.params.BlParams;
import iih.bl.pay.blprepaypatpmamtoep.d.BlPrepayPatPmamtOepDO;
import iih.bl.pay.blprepaypatpmamtoep.i.IBlprepaypatpmamtoepCudService;
import iih.bl.pay.blrtnreasondto.d.BlRtnReasonDTO;
import iih.bl.pub.IBlFunCodeConst;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.d.PayDirectEnum;
import iih.bl.st.blpaypatoep.i.IBlPayItmPatOepDORService;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepCudService;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepRService;
import iih.bl.st.blprepaysrcpmoep.d.BlPrepaySrcpmOepDO;
import iih.bl.st.blprepaysrcpmoep.i.IBlprepaysrcpmoepCudService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.bl.st.dto.blpayoep.d.BlPayOepRefundEventDTO;
import iih.bl.st.dto.d.BlStReFundBillDTO;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mp.dg.dto.d.OpDgRtnAmountDTO;
import iih.mp.dg.i.IMpDgOutService;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pmp.pay.ordreqdto.d.CmbcSceneEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;

/**
 * 退费调用
 * 
 * @author yang.lu 2017年6月26日
 *
 */
public class RefundFeeBp {

	
	private BlPayOepRefundEventDTO eventDto;
	
	/**
	 * 退费调用
	 * 
	 * @param id_stoep
	 *            退费结算号
	 * @param id_cgoep_arr
	 *            退费的记账主键数组
	 * @param refundItemDtoArr
	 *            退费明细
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @param blpaypatoepAggDO
	 *            收付款信息（重收的收付款信息），重构后： 前台不考虑收付款的方向，这个全部由后台考虑
	 *            数据来源于挂号的重收：原收费信息（正向） 数据来源于挂号的退号：null 数据来源于门诊结算的退费：退费的信息（负向）
	 *            数据来源于门诊结算的重划重收：新收费信息（正向）
	 * @param AllRefund
	 *            是否全退。FBoolean.TRUE:全退；FBoolean.FALSE:不全退
	 * @param isSc
	 *            是否是就诊退费
	 * @param rtnReasonDTO 退费原因，没有可填null
	 * @return
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] exec(String id_stoep, 
			String[] id_cgoep_arr, 
			BlRefundItmDTO[] refundItemDtoArr, 
			OperatorInfoDTO operatorInfoDTO, 
			BlpaypatoepAggDO blpaypatoepAggDO, 
			FBoolean AllRefund, 
			FBoolean isSc,
			BlRtnReasonDTO rtnReasonDTO) throws BizException {

		this.eventDto = new BlPayOepRefundEventDTO();
		
		//加锁
		String lockKey = "payment_lock_" + id_stoep;
		boolean lock = PKLock.getInstance().addDynamicLock(lockKey, 0);
		if(!lock){
			throw new BizException("当前结算正在进行收退费操作，请稍后重试");
		}
		
		// 设置终端类型上下文
		if (blpaypatoepAggDO != null) {
			BlPayPatOepDO payPatDo = blpaypatoepAggDO.getParentDO();
			if (payPatDo != null) {
				Context.get().setAttribute(IBlFlowKeyConst.BL_FLOW_KEY_SD_PTTP, payPatDo.getSd_pttp());
			}
		}
		
		BlIncItmVsTypeDTO[] blIncItmVsTypeDTO_arr = null;
		// 调用退费检查，查看可退费状态是否更变
		RetundVerification(id_stoep, refundItemDtoArr);
		BLCancelSettlementImplBp bLCancelSettlementImplBp = new BLCancelSettlementImplBp();
		FBoolean PrintOnlyOneInvoice = BlParams.BLSTOEP0003();
		FBoolean AllRefundAndAllCharge = FBoolean.FALSE;// 是否重划重收标志，重划重收时，红冲的支付明细fg_realpay='N',否则是'Y'

		FDateTime fDateTime = AppUtils.getServerDateTime();

		// FBoolean fgRealpay=FBoolean.TRUE;
		// if(blpaypatoepAggDO!=null
		// &&blpaypatoepAggDO.getBlPayItmPatOepDO()!=null&&blpaypatoepAggDO.getBlPayItmPatOepDO().length!=0){
		// fgRealpay=blpaypatoepAggDO.getBlPayItmPatOepDO()[0].getFg_realpay();
		// }
		// 1.红冲原记账，结算信息，发票信息，收付款信息，修改医嘱记账标志 并发出事件 。
		// 返回结果为需要重新结算的记账明细
		BlCgoepAggAndPrintRedIncItmDTO blCgoepAggAndPrintRedIncItmDTO = redBackBill(id_stoep, 
				id_cgoep_arr, 
				refundItemDtoArr, 
				operatorInfoDTO, 
				PrintOnlyOneInvoice, 
				AllRefundAndAllCharge, 
				AllRefund, 
				fDateTime, 
				isSc, 
				blpaypatoepAggDO,
				rtnReasonDTO);// 门诊收费，是否打印红冲票由bd_hp里的配置决定
		// 是否打印医保红冲发票 2017-3-28
		if (blCgoepAggAndPrintRedIncItmDTO != null && isSc != null && isSc.booleanValue() && blCgoepAggAndPrintRedIncItmDTO.getBlIncItmVsTypeDTO() != null) // 如果需要打印红冲票
		{
			FArrayList redIncItmLst = blCgoepAggAndPrintRedIncItmDTO.getBlIncItmVsTypeDTO();

			ArrayList<BlIncItmVsTypeDTO> list = new ArrayList<BlIncItmVsTypeDTO>();
			for (int i = 0; i < redIncItmLst.size(); i++) {
				list.add((BlIncItmVsTypeDTO) redIncItmLst.get(i));
			}
			blIncItmVsTypeDTO_arr = list.toArray(new BlIncItmVsTypeDTO[list.size()]);

			if (blCgoepAggAndPrintRedIncItmDTO.getBlCgoepAggDO() == null) {
				blCgoepAggAndPrintRedIncItmDTO = null;
			}
		}
		BlcgoepAggDO[] blcgoepAggDO_recharge = null;
		if (blCgoepAggAndPrintRedIncItmDTO != null && blCgoepAggAndPrintRedIncItmDTO.getBlCgoepAggDO() != null) {
			blcgoepAggDO_recharge = (BlcgoepAggDO[]) blCgoepAggAndPrintRedIncItmDTO.getBlCgoepAggDO().toArray(new BlcgoepAggDO[0]);
		}
		// 2.处理物品预留

		FBoolean isRPRS = FBoolean.FALSE;
		// 设置当前值是否为重划重收
		for (BlRefundItmDTO blIncItmVsTypeDTO : refundItemDtoArr) {
			if (FDouble.ZERO_DBL.equals(blIncItmVsTypeDTO.getQuan_refund())) {
				isRPRS = FBoolean.TRUE;
			} else {
				isRPRS = FBoolean.FALSE;
				break;
			}
		}
		bLCancelSettlementImplBp.RelieveMMReserved(refundItemDtoArr, isRPRS);
		FArrayList blIncItmVsTypeDTO_Lst = new FArrayList();
		if (blCgoepAggAndPrintRedIncItmDTO != null) {
			FArrayList redIncItmLst = blCgoepAggAndPrintRedIncItmDTO.getBlIncItmVsTypeDTO();
			// 红冲对应的发票项目
			if (redIncItmLst != null && redIncItmLst.size() > 0) {
				BlIncItmVsTypeDTO[] redIncItms = (BlIncItmVsTypeDTO[]) redIncItmLst.toArray(new BlIncItmVsTypeDTO[0]);
				for (BlIncItmVsTypeDTO blIncItmVsTypeDTO : redIncItms) {
					blIncItmVsTypeDTO_Lst.add(blIncItmVsTypeDTO);
				}
			}
		}
		// 3.若全退，则返回NULL
		if (AllRefund.booleanValue()) {
			//

		} else {

			// ***********下面是重收部分**********************

			// 5.获得退费的收款信息
			// 重构后，前台退费，传来的都是负的，需要再此处做变化
			// * 数据来源于挂号的重收：原收费信息（正向）
			// * 数据来源于挂号的退号：null
			// * 数据来源于门诊结算的退费：退费的信息（负向）
			// * 数据来源于门诊结算的重划重收：新收费信息（正向）
			// * * /
			
			IBLCiOrderToBlCgService iBLCiOrderToBlCgService = ServiceFinder.find(IBLCiOrderToBlCgService.class);
			BlIncItmVsTypeDTO[] new_blIncItmVsTypeDTO_arr = iBLCiOrderToBlCgService.settlementAfterRedBill(blcgoepAggDO_recharge, id_stoep, operatorInfoDTO, blpaypatoepAggDO, FBoolean.FALSE, fDateTime);

			// 重收对应的发票项目
			if (new_blIncItmVsTypeDTO_arr != null && new_blIncItmVsTypeDTO_arr.length > 0) {
				for (BlIncItmVsTypeDTO blIncItmVsTypeDTO1 : new_blIncItmVsTypeDTO_arr) {
					blIncItmVsTypeDTO_Lst.add(blIncItmVsTypeDTO1);
				}
			}
			blIncItmVsTypeDTO_arr = (BlIncItmVsTypeDTO[]) blIncItmVsTypeDTO_Lst.toArray(new BlIncItmVsTypeDTO[0]);
		}

		try {
			//发送退费事件
			this.invokeRefundEventNew(AllRefund, Arrays.asList(id_cgoep_arr));
		}
		catch (Exception ex){
			ex.printStackTrace();
			BLBizLogger.error(ex.getMessage(), ex);
		}
//		// 查询原收款信息
//		DAFacade dafacade1 = new DAFacade();
//		StringBuffer sqlb = new StringBuffer();
//		sqlb.append(" select a.* ");
//		sqlb.append("   from bl_pay_pat_oep a ");
//		sqlb.append("  inner join bl_st_oep b on a.id_paypatoep = b.id_paypatoep");
//		sqlb.append(" where b.id_stoep = ? ");
//		SqlParam sqlp1 = new SqlParam();
//		sqlp1.addParam(id_stoep);
//
//		// 查原始：收付款_预交金_费用来源_门急体
//		@SuppressWarnings("unchecked")
//		List<BlPayPatOepDO> oldBlPayPatOepDO = (List<BlPayPatOepDO>) dafacade1.execQuery(sqlb.toString(), sqlp1,
//			new BeanListHandler(BlPayPatOepDO.class));
//		if(!ListUtil.isEmpty(oldBlPayPatOepDO)){
//		// 发送退费事件
//		//this.invokeRefundEvent(id_stoep);
//		//12.如果收款类型为窗口，并且付款方式为支付宝或者微信，则回写日志信息
//		if(IBlDictCodeConst.SD_PTTP_WINDOW.equals(oldBlPayPatOepDO.get(0).getSd_pttp())){
//			BlPayItmPatOepDO[] blPayItmPatOepDOArr= blpaypatoepAggDO.getBlPayItmPatOepDO();
//			List<String> ordNoList= new ArrayList<String>();
//			//退费场景
//			String sence= isSc != null && isSc.booleanValue()?IBlDictCodeConst.SD_BIZSCENE_OEP_REENT:IBlDictCodeConst.SD_BIZSCENE_OEP_REFUND;
//			BlPayItmPatOepDO payItmPatOepDO =BlThirdPayBP.validate(blPayItmPatOepDOArr, sence);
//			if(payItmPatOepDO!=null){					
//				if(BookRtnDirectEnum.CHARGES.equals(payItmPatOepDO.getEu_direct())){
//					//收费
//					if(!StringUtils.isEmpty(payItmPatOepDO.getPaymodenode())){
//						ordNoList.add(payItmPatOepDO.getPaymodenode());
//					}
//					if(!ListUtil.isEmpty(ordNoList)){
//						saveThirdLog(ordNoList,id_stoep);
//					}	
//				}else{
//					//退费
//					//1.组织退费入参
//					BlOrdReqDTO blOrdReqDTO = this.setRefundOrdReqDTO(payItmPatOepDO,blpaypatoepAggDO.getParentDO().getId_pat(),id_stoep,payItmPatOepDO.getId_payitmpatoep());
//					BlThirdPayBP blThirdPayBP= new BlThirdPayBP();
//					//2.先保存退费两个日志信息
//					BlThirdTransRcdDO blThirdTransRcdDO= blThirdPayBP.setThirdPayDTO(blOrdReqDTO,null,TransStateEnum.UNFAIL);
//					String id_transrcd=blThirdPayBP.saveThirdTradeLog(blThirdTransRcdDO);
//					
//					if(FBoolean.TRUE.equals(BlParams.BLPAY001())){
//						BlThirdPayBP BlThirdPayBP= new BlThirdPayBP();
//						BlThirdPayBP.execRefund(blOrdReqDTO,id_transrcd);
//					}
//				}
//			}	
//		  }
		
		return blIncItmVsTypeDTO_arr;
	}

	/**
	 * 组织在线支付退费入参
	 * @param blPayItmPatOepDO
	 * @param id_pat
	 * @return
	 * @throws BizException 
	 */
    private BlOrdReqDTO setRefundOrdReqDTO(BlPayItmPatOepDO blPayItmPatOepDO,String id_pat,String id_stoep,String id_payitmpatoep) throws BizException
    {
        BlOrdReqDTO blOrdReqDTO = new BlOrdReqDTO();
        String ord_no="";//收款订单号
        String id_emp_pay="";//收款人员id
        BlpaypatoepAggDO BlpaypatoepAggDO= this.getOrginPayInfo(id_stoep);
        if(BlpaypatoepAggDO!=null){
            ord_no= this.getPayOrdNo(BlpaypatoepAggDO.getBlPayItmPatOepDO(),blPayItmPatOepDO.getId_pm());
            id_emp_pay=BlpaypatoepAggDO.getParentDO().getId_emp_pay();      	
        }
        blOrdReqDTO.setOrd_no(ord_no);//原收费订单号
        blOrdReqDTO.setRefund_req_no(BlCodeUtils.generateThirdOrdNo());
        blOrdReqDTO.setSubject("门诊退费" + blPayItmPatOepDO.getAmt() + "元");
        blOrdReqDTO.setAmt(blPayItmPatOepDO.getAmt()); 
        blOrdReqDTO.setEu_direct(BookRtnDirectEnum.REFUND);
        blOrdReqDTO.setId_psndoc(id_emp_pay);
        BlThirdPayValidateRltDTO dto = BlThirdPayValidateUtil.validate(new String[] {blPayItmPatOepDO.getId_pm()}, IBlDictCodeConst.SD_BIZSCENE_OEP_CHARGE);
        if (dto.getFg_success().booleanValue())
        {
        	blOrdReqDTO.setSd_chl(dto.getSd_paychannel()); 
        }else {
        	throw new BizException(dto.getError_msg());
        }
        blOrdReqDTO.setTradetype(IBdPripmCodeConst.ID_PRI_PM_ALIPAY.equals(blPayItmPatOepDO.getId_pm()) ? CmbcSceneEnum.ZFBSCAN : CmbcSceneEnum.WXSCAN);
        blOrdReqDTO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP); 
        blOrdReqDTO.setFg_refund(FBoolean.TRUE);
        blOrdReqDTO.setId_pm(blPayItmPatOepDO.getId_pm());
        blOrdReqDTO.setId_pat(id_pat);
        blOrdReqDTO.setId_st(id_stoep);
        blOrdReqDTO.setId_pay(id_payitmpatoep);
        blOrdReqDTO.setId_bizscene(IBlDictCodeConst.ID_BIZSCENE_OEP_REFUND);
        blOrdReqDTO.setSd_bizscene(IBlDictCodeConst.SD_BIZSCENE_OEP_REFUND);
        return blOrdReqDTO;
    }
    
    /**
     * 查询原收款信息
     * @param id_paypatoep 收款主键
     * @return
     * @throws BizException 
     */
    private BlpaypatoepAggDO getOrginPayInfo(String id_stoep) throws BizException{
		// 1. 查找原结算信息
		IBlstoepRService iBlstoepRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO orgin_StOepDO = iBlstoepRService.findById(id_stoep);
		if (null == orgin_StOepDO) {
			return null;
		}
		IBlpaypatoepRService iBlpaypatoepRService = ServiceFinder.find(IBlpaypatoepRService.class);
		BlpaypatoepAggDO blpaypatoepAggDO = iBlpaypatoepRService.findById(orgin_StOepDO.getId_paypatoep());
		if (null == blpaypatoepAggDO) {
			return null;
		}
    	return blpaypatoepAggDO;
    }
    
    /**
     * 查询收款的订单号
     * @param id_par
     * @return
     * @throws BizException 
     */
    private String getPayOrdNo(BlPayItmPatOepDO[] blPayItmPatOepDOArr,String id_pm) throws BizException{
		for(BlPayItmPatOepDO blPayItmPatOepDO :blPayItmPatOepDOArr){
			if(id_pm.equals(blPayItmPatOepDO.getId_pm()) && !StringUtils.isEmpty(blPayItmPatOepDO.getPaymodenode())){
				return blPayItmPatOepDO.getPaymodenode();
			}
		}
		return "";
    }
	/**
	 * 保存窗口支付(微信支付宝)日志（收费）
	 * @param ordNoList 外部订单号
	 * @param id_stoep 结算id
	 * @throws  
	 */
	private void saveThirdLog(List<String> ordNoList,String id_stoep) throws BizException{
		
		StringBuilder sql= new StringBuilder();
		sql.append("update");
		sql.append(" bl_trd_trans_rcd");
		sql.append(" set id_st='"+id_stoep+"',");
		sql.append(" eu_status='1',");
		sql.append(" fg_rollback='N',");
		sql.append(" id_pay=(select itm.id_payitmpatoep");
		sql.append(" from bl_pay_itm_pat_oep itm where bl_trd_trans_rcd.order_no=itm.paymodenode)");
		sql.append(" where ");
		sql.append(SqlUtils.getInSqlByIds("bl_trd_trans_rcd.order_no", ordNoList));
		new DAFacade().execUpdate(sql.toString());
	}

	/**
	 * 退费前校验
	 * 
	 * @param id_stoep
	 *            退的结算信息
	 * @param refundItemDtoArr
	 *            退的明细
	 * @throws BizException
	 */
	private void RetundVerification(String id_stoep, BlRefundItmDTO[] refundItemDtoArr) throws BizException {
		IBlstoepRService stService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO stOep = stService.findById(id_stoep);
		if(FBoolean.TRUE.equals(stOep.getFg_canc())){
			throw new BizException("当前结算已退费！");
		}
		// 获取当前结算 所有项目
		BlStReFundBillDTO[] blStReFundBillDTOs = (BlStReFundBillDTO[]) AppFwUtil.getDORstWithDao(new GetBlStReFundBillDTOQry(id_stoep), BlStReFundBillDTO.class);
		// 赋值记账数据 可退费集合
		HashMap<String, BlStReFundBillDTO> isRefundMap = new HashMap<String, BlStReFundBillDTO>();
		
		//退费考虑门诊费用插入住院费用的情况
		List<String> idList = new ArrayList<String>();
		for(int i=0;i<blStReFundBillDTOs.length;i++){
			if (iih.bd.base.utils.StringUtils.isNotEmpty(blStReFundBillDTOs[i].getId_cgitmoep())) {
				idList.add(blStReFundBillDTOs[i].getId_cgitmoep());
			}
		}
		BlCgItmOepTfRcdDO[] blCgItmOepTfRcdDOs = getOepTfItmInfo(idList);
		
		for (BlStReFundBillDTO blStReFundBillDTO : blStReFundBillDTOs) {
			BlStReFundBillDTO newRefDto = new BlStReFundBillDTO();
			newRefDto.setCan_quan(blStReFundBillDTO.getCan_quan());
			FBoolean isRef = FBoolean.FALSE;
			//退费考虑门诊费用插入住院费用的情况
			if (blCgItmOepTfRcdDOs!=null && blCgItmOepTfRcdDOs.length>0) {
				for(int i=0;i<blCgItmOepTfRcdDOs.length;i++){
					if (blCgItmOepTfRcdDOs[i].getId_cgitmoep().equals(blStReFundBillDTO.getId_cgitmoep())) {
						isRef = FBoolean.TRUE;
						break;
					}
				}
				
			}else {
				if (FBoolean.FALSE.equals(blStReFundBillDTO.getFg_mm())) {
					isRef = blStReFundBillDTO.getFg_feertnable();
				} else {
					if (blStReFundBillDTO.getCan_quan().toDouble() > 0) {
						isRef = FBoolean.TRUE;
					}
				}
			}
			
			newRefDto.setFg_feertnable(isRef);
			isRefundMap.put(blStReFundBillDTO.getId_cgitmoep(), newRefDto);
		}
		// 循环退费项目 如果有状态为不可退费 弹出异常数据
		for (BlRefundItmDTO refitmDto : refundItemDtoArr) {
			BlStReFundBillDTO dbRefundDto = isRefundMap.get(refitmDto.getId_cditmoep());
			// 判断 如果 可退状态 为 【不可退】 并且 (退的数量大于0 或者 退的数量大于可退数量)
			if (FBoolean.FALSE.equals(dbRefundDto.getFg_feertnable()) && refitmDto.getQuan_refund() != null && dbRefundDto.getCan_quan() != null && (refitmDto.getQuan_refund().toDouble() > 0 || refitmDto.getQuan_refund().toDouble() > dbRefundDto.getCan_quan().toDouble())) {
				throw new BizException("退费项目可退费状态已更改，请刷新后重新调入再进行退费！");
			}
		}
	}

	/**
	 * 不包含医保红冲,红冲
	 *
	 * @param id_stoep
	 *            退费的结算ID
	 * @param id_cgoep
	 *            退费的记账主键
	 * @param BlRefundItmDTO
	 *            :id_cgoep,id_cditmoep,退费数量
	 * @param operatorInfoDTO
	 * @param PrintOnlyOneInvoice
	 *            ：多次就诊一次结算打印一张发票还是多张发票
	 * @param AllRefundAndAllCharge
	 *            是否重退重收
	 * @param AllRefund
	 *            是否全退
	 * @param strDateTime
	 *            服务器时间
	 * @param printRedInc
	 *            是否打印红冲票, 如果传参为null，则表示是门诊退费来的，不是退号来的
	 * @param BlpaypatoepAggDO
	 *            如果是全退，需要传入界面的退款方式。如果是全退，但是走完全红冲，则传入null。如果非全退，也传入null
	 * @param rtnReasonDTO 退费原因
	 * @return
	 * @throws BizException
	 */
	private BlCgoepAggAndPrintRedIncItmDTO redBackBill(String id_stoep, 
			String[] id_cgoep, 
			BlRefundItmDTO[] id_cditmoep, 
			OperatorInfoDTO operatorInfoDTO, 
			FBoolean PrintOnlyOneInvoice, 
			FBoolean AllRefundAndAllCharge, 
			FBoolean AllRefund, 
			FDateTime strDateTime, 
			FBoolean printRedInc, 
			BlpaypatoepAggDO blpaypatoepAggDO,
			BlRtnReasonDTO rtnReasonDTO) throws BizException {
		BlCgoepAggAndPrintRedIncItmDTO blCgoepAggAndPrintRedIncItmDTO = null;
		// 1. 查找原结算信息
		IBlstoepRService iBlstoepRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO orgin_StOepDO = iBlstoepRService.findById(id_stoep);
		if (null == orgin_StOepDO) {
			throw new BizException("查询原门诊结算信息失败");
		}

		// 1. 红冲收付款，并得到保存后的红冲收付款(采用统一解决方案）提取指定的结算信息，记账信息，发票信息
		BlpaypatoepAggDO[] red_BlpaypatoepAggDO = redBack_BlpaypatoepAgg(orgin_StOepDO.getId_paypatoep(), strDateTime, operatorInfoDTO, AllRefund, blpaypatoepAggDO);

		OepStEP step = new OepStEP();
		// 2.红冲门诊结算表，且修改原结算表
		BlStOepDO red_BlStOepDO = step.redBack_StOep(orgin_StOepDO, 
				operatorInfoDTO, 
				red_BlpaypatoepAggDO[0].getParentDO().getId_paypatoep(), 
				strDateTime, 
				id_cditmoep[0].getEu_srctp(),
				rtnReasonDTO);

		// 3.获取原始门诊记账信息
		BlcgoepAggDO[] orgin_blcgoepAggDO = getOrgin_blcgoepAggDO(id_cgoep);
		if (null == orgin_blcgoepAggDO || orgin_blcgoepAggDO.length == 0) {
			throw new BizException("查询原门诊记账信息失败");
		}
		OepCgEP cgep = new OepCgEP();
		// 4.红冲门诊记账表，且修改原记账表
		BlcgoepAggDO[] red_BlcgoepAggDOs = cgep.redBack_CgOep(orgin_blcgoepAggDO, strDateTime, operatorInfoDTO, AllRefundAndAllCharge, AllRefund, red_BlStOepDO.getId_stoep());

		OepIncEP incEP = new OepIncEP();
		// 5.红冲票据
		BlincoepAggDO[] blincoepAggDO_red = incEP.redback_BlIncOep(printRedInc, orgin_StOepDO, red_BlStOepDO.getId_stoep(), PrintOnlyOneInvoice, AllRefundAndAllCharge, strDateTime, operatorInfoDTO, red_BlcgoepAggDOs);

		BlcgoepAggDO[] new_Recharge_BlcgoepAggDOs = null;
		// 6. 是重划重收调用或者退费重收，还需要获得重收的记账Agg
		if (AllRefundAndAllCharge.booleanValue() || !AllRefund.booleanValue()) {
			new_Recharge_BlcgoepAggDOs = getNewRechargeBlCg(orgin_blcgoepAggDO, id_cditmoep, strDateTime, operatorInfoDTO, PrintOnlyOneInvoice, AllRefundAndAllCharge, red_BlStOepDO.getId_stoep());
		}

		// --------------------------- 红冲结束

		// 6. 如果全退(非重退重收)，则修改红冲收付款明细的实收（退）付款段标志，且返回null
		if (AllRefund.booleanValue()) {

			BlpaypatoepAggDO[] blpaypatoepAggDOArr = null;

			IBlpaypatoepCudService iBlpaypatoepCudService = ServiceFinder.find(IBlpaypatoepCudService.class);

			Map<String, FDouble> pmAmt = new HashMap<String, FDouble>();
			FDouble temAmt = new FDouble(0);

			BlPayItmPatOepDO[] blPayItmPatOepDOArr = red_BlpaypatoepAggDO[0].getBlPayItmPatOepDO();
			for (BlPayItmPatOepDO blPayItmPatOepDO : blPayItmPatOepDOArr) {
				if (pmAmt.containsKey(blPayItmPatOepDO.getId_pm() + "|" + blPayItmPatOepDO.getSd_pm())) {
					temAmt = pmAmt.get(blPayItmPatOepDO.getId_pm() + "|" + blPayItmPatOepDO.getSd_pm()).add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
					pmAmt.remove(blPayItmPatOepDO.getId_pm() + "|" + blPayItmPatOepDO.getSd_pm());
					pmAmt.put(blPayItmPatOepDO.getId_pm() + "|" + blPayItmPatOepDO.getSd_pm(), temAmt);
				} else {
					pmAmt.put(blPayItmPatOepDO.getId_pm() + "|" + blPayItmPatOepDO.getSd_pm(), blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
				}
				if (blPayItmPatOepDO.getFg_realpay() == null) {
					blPayItmPatOepDO.setFg_realpay(FBoolean.TRUE);
				}
				blPayItmPatOepDO.setStatus(DOStatus.UPDATED);
				// qt_BlPayItmPatOepDOLst.add(blPayItmPatOepDO);
			}
			red_BlpaypatoepAggDO[0].getParentDO().setStatus(DOStatus.UPDATED);
			blpaypatoepAggDOArr = iBlpaypatoepCudService.save(red_BlpaypatoepAggDO);

			// 重写红冲结算对应的收付款ID
			red_BlStOepDO.setId_paypatoep(blpaypatoepAggDOArr[0].getParentDO().getId_paypatoep());
			red_BlStOepDO.setStatus(DOStatus.UPDATED);
			IBlstoepCudService iBlstoepCudService = ServiceFinder.find(IBlstoepCudService.class);
			BlStOepDO[] r_blStOepDOs2 = iBlstoepCudService.save(new BlStOepDO[] { red_BlStOepDO });
			if (null == r_blStOepDOs2 || r_blStOepDOs2.length == 0) {
				throw new BizException("保存红冲门诊结算信息失败");
			}
			// 保存前台来的数据

		} else {
			blCgoepAggAndPrintRedIncItmDTO = new BlCgoepAggAndPrintRedIncItmDTO();
			FArrayList blcgoepAggDOLst = new FArrayList();
			for (BlcgoepAggDO blcgoepAggDO : new_Recharge_BlcgoepAggDOs) {
				blcgoepAggDOLst.add(blcgoepAggDO);
			}
			blCgoepAggAndPrintRedIncItmDTO.setBlCgoepAggDO(blcgoepAggDOLst);
		}
		if (printRedInc != null && printRedInc.booleanValue()) {
			if (blCgoepAggAndPrintRedIncItmDTO == null)
				blCgoepAggAndPrintRedIncItmDTO = new BlCgoepAggAndPrintRedIncItmDTO();
			FArrayList blIncItmVsTypeDTOLst = new FArrayList();
			// 打红冲的发票(门诊挂号冲账结算的红冲票不再此处打印，在门诊收费里打印）
			if (printRedInc != null && printRedInc.booleanValue() && red_BlStOepDO.getEu_sttp() != StTypeEnum.ST_REGISTER_RED) {
				BLCiOrderToBlCgServiceImplBp BLCiOrderToBlCgServiceImplBp = new BLCiOrderToBlCgServiceImplBp();
				BlIncItmVsTypeDTO[] BlIncItmVsTypeDTOs = BLCiOrderToBlCgServiceImplBp.assemblyIncInfoDtosWithoutWindow(red_BlStOepDO, blincoepAggDO_red);
				for (BlIncItmVsTypeDTO blIncItmVsTypeDTO : BlIncItmVsTypeDTOs) {
					blIncItmVsTypeDTOLst.add(blIncItmVsTypeDTO);
				}
			}
			blCgoepAggAndPrintRedIncItmDTO.setBlIncItmVsTypeDTO(blIncItmVsTypeDTOLst);
		}

		// 5.发事件
		try {
			//新退费消息
			//BlOpPayEvent.invokeRefund(orgin_blcgoepAggDO, orgin_StOepDO, blpaypatoepAggDO, blincoepAggDO_red, red_BlcgoepAggDOs, red_BlStOepDO, red_BlpaypatoepAggDO[0], blincoepAggDO_red);
			IBlpaypatoepRService iBlpaypatoepRService = ServiceFinder.find(IBlpaypatoepRService.class);
			BlpaypatoepAggDO orgin_payAggDO = iBlpaypatoepRService.findById(orgin_StOepDO.getId_paypatoep());
			IBlincoepRService iBlIncRService = ServiceFinder.find(IBlincoepRService.class);
			BlincoepAggDO[] origin_incDos = iBlIncRService.findByAttrValString(BlIncOepDO.ID_STOEP, orgin_StOepDO.getId_stoep());
			
			this.eventDto.setOldCgData(orgin_blcgoepAggDO);
			this.eventDto.setOldStData(orgin_StOepDO);
			this.eventDto.setOldPayData(orgin_payAggDO);
			this.eventDto.setOldIncData(origin_incDos);
			this.eventDto.setRedCgData(red_BlcgoepAggDOs);
			this.eventDto.setRedStData(red_BlStOepDO);
			this.eventDto.setRedPayData(red_BlpaypatoepAggDO[0]);
			this.eventDto.setRedIncData(blincoepAggDO_red);
			
			//红冲数据发送收费消息（不知道为啥）
			//BlOpPayEvent.invokePay(red_BlcgoepAggDOs, red_BlStOepDO, red_BlpaypatoepAggDO[0], blincoepAggDO_red);
			//this.invokeOepSettlementEvent(red_BlcgoepAggDOs, red_BlpaypatoepAggDO[0], red_BlStOepDO, blincoepAggDO_red[0]);
		
		} catch (Exception ex) {
		}
		return blCgoepAggAndPrintRedIncItmDTO;
	}

	/**
	 * 收付款红冲数据的后续处理：如果有预交金，且修改门诊预交金账户，更新预交金_患者_收支总金额表， 保存收付款_预交金_费用来源_门急体表 TODO
	 * 是否可以添加到预付款模块中
	 * 
	 * @param red_blpaypatoepAggDOs
	 *            红冲的收付款记录
	 * @param id_paypatoep
	 *            原始收付款的主键
	 * @throws BizException
	 */
	private void savePrepayAndBlPrepayPatPmamtOepDO(BlpaypatoepAggDO[] red_blpaypatoepAggDOs, String id_paypatoep) throws BizException {
		// 退费也要处理结存的预交金
		// 1.如果患者采用预交金支付，则统计预交金支付金额，且修改门诊预交金账户
		DoOepFgAccAmtAcc doOepFgAccAmtAccBp = new DoOepFgAccAmtAcc();
		doOepFgAccAmtAccBp.doPayByPrepay_rtn(red_blpaypatoepAggDOs);

		// 2.查 收付款_预交金_费用来源_门急体
		IBlprepaypatpmamtoepCudService iBlprepaypatpmamtoepCudService = ServiceFinder.find(IBlprepaypatpmamtoepCudService.class);
		IBlprepaysrcpmoepCudService iBlprepaysrcpmoepCudService = ServiceFinder.find(IBlprepaysrcpmoepCudService.class);
		// 查支付方式优先级
		DAFacade dafacade = new DAFacade();
		StringBuffer sqlb1 = new StringBuffer();
		sqlb1.append("select b.* from bd_pri_pm a,bl_prepay_pat_pmamt_oep b where a.id_pm=b.id_pm ");
		sqlb1.append(" and b.id_pat=? order by a.prepay_lv asc");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(red_blpaypatoepAggDOs[0].getParentDO().getId_pat());
		List<BlPrepayPatPmamtOepDO> blPrepayPatPmamtOepDOLst = (List<BlPrepayPatPmamtOepDO>) dafacade.execQuery(sqlb1.toString(), sqlp, new BeanListHandler(BlPrepayPatPmamtOepDO.class));
		if (blPrepayPatPmamtOepDOLst == null || blPrepayPatPmamtOepDOLst.size() == 0) {
			// 为了兼容老数据，因此注销
			// throw new BizException("查询预交金各种付款方式收支总金额失败！");
		} else {
			BlPrepayPatPmamtOepDO[] blPrepayPatPmamtOepDOArr = blPrepayPatPmamtOepDOLst.toArray(new BlPrepayPatPmamtOepDO[0]);
			BlPayItmPatOepDO[] new_blPayItmPatOepDO_arr = red_blpaypatoepAggDOs[0].getBlPayItmPatOepDO();
			StringBuffer sqlb = new StringBuffer();
			sqlb.append(" select c.* ");
			sqlb.append("   from bl_pay_pat_oep a ");
			sqlb.append("  inner join bl_pay_itm_pat_oep b ");
			sqlb.append("     on a.id_paypatoep = b.id_paypatoep ");
			sqlb.append("   inner join BL_PREPAY_SRCPM_OEP c ");
			sqlb.append("     on b.id_payitmpatoep = c.id_payitmpatoep ");
			sqlb.append("  where a.id_paypatoep = ? ");
			SqlParam sqlp1 = new SqlParam();
			sqlp1.addParam(id_paypatoep);
			DAFacade dafacade1 = new DAFacade();
			// 查原始：收付款_预交金_费用来源_门急体
			List<BlPrepaySrcpmOepDO> blPrepaySrcpmOepDOLst = (List<BlPrepaySrcpmOepDO>) dafacade1.execQuery(sqlb.toString(), sqlp1, new BeanListHandler(BlPrepaySrcpmOepDO.class));

			for (BlPayItmPatOepDO blPayItmPatOepDO : new_blPayItmPatOepDO_arr) {
				if (IBdPripmCodeConst.ID_PRI_PM_PAY.equals(blPayItmPatOepDO.getId_pm())) // 预交金
				{
					if (blPrepaySrcpmOepDOLst != null && blPrepaySrcpmOepDOLst.size() > 0) {
						BlPrepaySrcpmOepDO[] blPrepaySrcpmOepDOArr = blPrepaySrcpmOepDOLst.toArray(new BlPrepaySrcpmOepDO[0]);
						for (BlPrepaySrcpmOepDO blPrepaySrcpmOepDO : blPrepaySrcpmOepDOArr) {
							blPrepaySrcpmOepDO.setId_prepaysrcpmoep(null);
							blPrepaySrcpmOepDO.setId_payitmpatoep(blPayItmPatOepDO.getId_payitmpatoep());
							blPrepaySrcpmOepDO.setStatus(DOStatus.NEW);
							for (BlPrepayPatPmamtOepDO blPrepayPatPmamtOepDO : blPrepayPatPmamtOepDOArr) {
								if (blPrepaySrcpmOepDO.getId_pm_src().equals(blPrepayPatPmamtOepDO.getId_pm())) {
									if (red_blpaypatoepAggDOs[0].getParentDO().getEu_direct() == BookRtnDirectEnum.REFUND) // 退
									{
										if (blPayItmPatOepDO.getEu_direct() == PayDirectEnum.CHARGE) // 退
										{
											blPrepayPatPmamtOepDO.setAmt_out(blPrepayPatPmamtOepDO.getAmt_out().add(blPayItmPatOepDO.getAmt()));
										} else // 找零
										{
											blPrepayPatPmamtOepDO.setAmt_in(blPrepayPatPmamtOepDO.getAmt_in().add(blPayItmPatOepDO.getAmt()));
										}
									} else // 收
									{
										if (blPayItmPatOepDO.getEu_direct() == PayDirectEnum.CHARGE) // 收
										{
											blPrepayPatPmamtOepDO.setAmt_in(blPrepayPatPmamtOepDO.getAmt_in().add(blPayItmPatOepDO.getAmt()));
										} else // 找零
										{
											blPrepayPatPmamtOepDO.setAmt_out(blPrepayPatPmamtOepDO.getAmt_out().add(blPayItmPatOepDO.getAmt()));
										}
									}
									blPrepayPatPmamtOepDO.setStatus(DOStatus.UPDATED);
								}
							}
						}
					}

					// 3.更新预交金_患者_收支总金额表
					iBlprepaypatpmamtoepCudService.save(blPrepayPatPmamtOepDOArr);
					// 4.保存收付款_预交金_费用来源_门急体表
					iBlprepaysrcpmoepCudService.save(blPrepaySrcpmOepDOLst.toArray(new BlPrepaySrcpmOepDO[0]));
				}
			}
		}
	}

	/**
	 * 保存红冲门诊收付款
	 * 
	 * @param id_paypatoep
	 * @return 保存的红冲门诊收付款
	 * @throws BizException
	 */
	public BlpaypatoepAggDO[] redBack_BlpaypatoepAgg(String id_paypatoep, FDateTime strDateTime, OperatorInfoDTO operatorInfoDTO,FBoolean AllRefund, BlpaypatoepAggDO blpayoepAggDo) throws BizException {

		BlpaypatoepAggDO red_BlpaypatoepAggDO = new BlpaypatoepAggDO();
		// 1. 原门诊收付款
		IBlpaypatoepRService iBlpaypatoepRService = ServiceFinder.find(IBlpaypatoepRService.class);
		BlpaypatoepAggDO blpaypatoepAggDO = null;
		//获取原收款的凭证号 by lim 2019-01-15
		HashMap<String,String> pmModeNodeMap=this.getSourcePayitmDO(id_paypatoep);
		if(AllRefund.booleanValue()){
			blpaypatoepAggDO = blpayoepAggDo;
		}
		else {
			blpaypatoepAggDO = iBlpaypatoepRService.findById(id_paypatoep);
		}

		if (null == blpaypatoepAggDO) {
			throw new BizException("查询患者收付款信息失败");
		}
		// 2. 生成红冲门诊收付款
		// 2.1 收付款主表
		List<BlPayItmPatOepDO> blPayItmPatOepDO_list = new ArrayList<BlPayItmPatOepDO>();
		BlPayPatOepDO blPayPatOepDO = blpaypatoepAggDO.getParentDO();
		blPayPatOepDO.setId_paypatoep(null);
		blPayPatOepDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_STRED);
		blPayPatOepDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_STRED);
		if(!AllRefund.booleanValue()){
			if (blPayPatOepDO.getEu_direct() == 1)// （原-1变1，原1变-1）
			{
				blPayPatOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
			} else {
				blPayPatOepDO.setEu_direct(BookRtnDirectEnum.CHARGES);
			}
		}
		blPayPatOepDO.setId_dep_pay(operatorInfoDTO.getId_dep());
		blPayPatOepDO.setId_org_pay(operatorInfoDTO.getId_org_emp());
		blPayPatOepDO.setId_emp_pay(operatorInfoDTO.getId_emp());
		blPayPatOepDO.setFg_cc(FBoolean.FALSE);
		if(Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_SD_PTTP) != null){
			blPayPatOepDO.setSd_pttp(Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_SD_PTTP).toString());
		}else{
			blPayPatOepDO.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		}
		
		blPayPatOepDO.setId_cc(null);
		blPayPatOepDO.setNote(null);
		blPayPatOepDO.setDt_pay(strDateTime);
		blPayPatOepDO.setStatus(DOStatus.NEW);
		// 2.2 收付款子表
		BlPayItmPatOepDO[] blPayItmPatOepDO_arr = blpaypatoepAggDO.getBlPayItmPatOepDO();

		for (int j = 0; j < blPayItmPatOepDO_arr.length; j++) {
			blPayItmPatOepDO_arr[j].setId_payitmpatoep(null);
			blPayItmPatOepDO_arr[j].setId_paypatoep(null);
			blPayItmPatOepDO_arr[j].setId_paypat(null);
			blPayItmPatOepDO_arr[j].setId_org(operatorInfoDTO.getId_org());
			if(!AllRefund.booleanValue()){
				// （原-1变1，原1变-1）
				if (blPayItmPatOepDO_arr[j].getEu_direct() == 1) {
					blPayItmPatOepDO_arr[j].setEu_direct(BookRtnDirectEnum.REFUND);
				} else {
					blPayItmPatOepDO_arr[j].setEu_direct(BookRtnDirectEnum.CHARGES);
				}
				blPayItmPatOepDO_arr[j].setFg_realpay(FBoolean.FALSE);
			}else{
				//如果凭证号为空，则将原收款明细收款方式对应的凭证号赋值给他  by lim 2019-01-15
				if(StringUtils.isEmpty(blPayItmPatOepDO_arr[j].getPaymodenode())&& pmModeNodeMap.containsKey(blPayItmPatOepDO_arr[j].getId_pm())){
					blPayItmPatOepDO_arr[j].setPaymodenode(pmModeNodeMap.get(blPayItmPatOepDO_arr[j].getId_pm()));
				}
			}
			blPayItmPatOepDO_arr[j].setStatus(DOStatus.NEW);
			blPayItmPatOepDO_list.add(blPayItmPatOepDO_arr[j]);
		}

		red_BlpaypatoepAggDO.setParentDO(blPayPatOepDO);
		red_BlpaypatoepAggDO.setBlPayItmPatOepDO(blPayItmPatOepDO_list.toArray(new BlPayItmPatOepDO[] {}));

		// 3.保存红冲收付款
		IBlpaypatoepCudService iBlpaypatoepCudService = ServiceFinder.find(IBlpaypatoepCudService.class);
		BlpaypatoepAggDO[] new_blpaypatoepAggDO_arr = iBlpaypatoepCudService.save(new BlpaypatoepAggDO[] { red_BlpaypatoepAggDO });
		if (null == new_blpaypatoepAggDO_arr) {
			throw new BizException("保存红冲患者收付款信息失败");
		}

		// 4.收付款红冲数据的后续处理：如果有预交金，且修改门诊预交金账户，更新预交金_患者_收支总金额表， 保存收付款_预交金_费用来源_门急体表
		savePrepayAndBlPrepayPatPmamtOepDO(new_blpaypatoepAggDO_arr, id_paypatoep);

		return new_blpaypatoepAggDO_arr;
	}
	
	/**
	 * 获取收付款明细中支付方式的凭证号信息
	 * @param id_paypatoep
	 * @return
	 * @throws BizException
	 */
  private HashMap<String,String> getSourcePayitmDO(String id_paypatoep) throws BizException{
	  HashMap<String,String> pmPayNoMap= new HashMap<String,String>();
	IBlPayItmPatOepDORService ser = ServiceFinder.find(IBlPayItmPatOepDORService.class);
	BlPayItmPatOepDO[] blPayItmPatOepDOArr= ser.findByAttrValString(BlPayItmPatOepDO.ID_PAYPATOEP, id_paypatoep);
	if(!ArrayUtils.isEmpty(blPayItmPatOepDOArr)){
		for(BlPayItmPatOepDO itm:blPayItmPatOepDOArr){
			String id_pm=itm.getId_pm();
			if((IBdPripmCodeConst.ID_PRI_PM_ALIPAY.equals(id_pm)||IBdPripmCodeConst.ID_PRI_PM_WECHAT.equals(id_pm))
					&&!pmPayNoMap.containsKey(id_pm)&& !StringUtils.isEmpty(itm.getPaymodenode())){
				pmPayNoMap.put(id_pm, itm.getPaymodenode());
			}
		}
		
	}
	return pmPayNoMap;
}

	/**
	 * 获得重收的费用Agg
	 * 
	 * @param orgin_blcgoepAggDO1
	 * @param id_cditmoep
	 * @param strDateTime
	 * @param operatorInfoDTO
	 * @param PrintOnlyOneInvoice
	 * @param AllRefundAndAllCharge
	 * @param red_idStOep
	 * @return
	 * @throws BizException
	 */
	private BlcgoepAggDO[] getNewRechargeBlCg(BlcgoepAggDO[] orgin_blcgoepAggDO1, BlRefundItmDTO[] id_cditmoep, FDateTime strDateTime, OperatorInfoDTO operatorInfoDTO, FBoolean PrintOnlyOneInvoice, FBoolean AllRefundAndAllCharge, String red_idStOep) throws BizException {

		FDouble all_amt = new FDouble(0);
		FDouble all_amt_pat = new FDouble(0);
		FDouble all_amt_std = new FDouble(0);
		// 1. 生成红冲的记账信息
		GetCodeByCustomization code_ins = new GetCodeByCustomization();

		List<String> id_orsrv = new ArrayList<String>();
		int k = 0;
		k = id_cditmoep.length;

		BlcgoepAggDO new_BlcgoepAggDO = new BlcgoepAggDO();
		List<BlCgItmOepDO> new_BlCgItmOepDOList = new ArrayList<BlCgItmOepDO>();
		BlCgOepDO new_BlCgOepDO = new BlCgOepDO();
		FDouble new_quan = new FDouble(0);

		IPriCalService pcService = (IPriCalService) ServiceFinder.find(IPriCalService.class);

		IMpDgOutService iMpDgOutService = ServiceFinder.find(IMpDgOutService.class);

		int all_blcgitms_count = 0; // 所有明细记录数
		int allRefund_count = 0;// 全退的记录数量
		
		boolean tf_flag = false;	//是否门诊真实转入住院的费用
		
		// 红冲原纪录，且生成重收纪录
		for (int i = 0; i < orgin_blcgoepAggDO1.length; i++) {
			// 生成重收的CG主表
			new_BlCgOepDO = (BlCgOepDO) orgin_blcgoepAggDO1[i].getParentDO().clone();
			new_BlCgOepDO.setId_cgoep(null);
			new_BlCgOepDO.setId_org(operatorInfoDTO.getId_org());
			new_BlCgOepDO.setId_grp(operatorInfoDTO.getId_grp());
			new_BlCgOepDO.setCode_cg(code_ins.GetCodeBlCgOep());
			new_BlCgOepDO.setId_dep_cg(operatorInfoDTO.getId_dep());
			new_BlCgOepDO.setId_org_cg(operatorInfoDTO.getId_org_emp());
			new_BlCgOepDO.setEu_direct(BookRtnDirectEnum.CHARGES);
			new_BlCgOepDO.setDt_cg(strDateTime);
			new_BlCgOepDO.setHas_saveindb(FBoolean.FALSE);
			new_BlCgOepDO.setStatus(DOStatus.NEW);

			BlCgItmOepDO[] blCgItmOepDOs = orgin_blcgoepAggDO1[i].getBlCgItmOepDO();
			all_blcgitms_count = all_blcgitms_count + blCgItmOepDOs.length;
			//退费考虑门诊费用插入住院费用的情况
			List<String> idList = new ArrayList<String>();
			for(int a=0;a<blCgItmOepDOs.length;a++){
				if (iih.bd.base.utils.StringUtils.isNotEmpty(blCgItmOepDOs[a].getId_cgitmoep())) {
					idList.add(blCgItmOepDOs[a].getId_cgitmoep());
				}
			}
			BlCgItmOepTfRcdDO[] blCgItmOepTfRcdDOs = getOepTfItmInfo(idList);
			
			for (int j = 0; j < blCgItmOepDOs.length; j++) {
				BlCgItmOepDO new_BlCgItmOepDO = new BlCgItmOepDO();

				// 医嘱设为已退费
				for (int t = 0; t < k; t++) {
					new_quan = blCgItmOepDOs[j].getQuan();// 默认重收数量
					if (blCgItmOepDOs[j].getId_cgoep().equals(id_cditmoep[t].getId_cgoep()) && blCgItmOepDOs[j].getId_cgitmoep().equals(id_cditmoep[t].getId_cditmoep())) {
						// 重划重收条件判断，如果AllRefundAndAllCharge=true,是需要重新收费的，此时new_quan和退费时的数量相同
						if (AllRefundAndAllCharge.booleanValue()) {
							// 重划重收时，再收费数量等于退费数量
							new_quan = blCgItmOepDOs[j].getQuan();
						} else {
							//如果退费的记录是真实转入住院的费用，优先处理
							if (blCgItmOepTfRcdDOs!=null && blCgItmOepTfRcdDOs.length>0) {
								for(int b=0;b<blCgItmOepTfRcdDOs.length;b++){
									if (blCgItmOepDOs[j].getId_cgitmoep().equals(blCgItmOepTfRcdDOs[b].getId_cgitmoep())) {
										//new_quan = new FDouble(0);
										tf_flag = true;
										break;
									}
								}
							}else {
								// 检查是否是物品，如果是物品，则再次检查是否满足退费的条件
								if (blCgItmOepDOs[j].getFg_mm().booleanValue()) {
									OpDgRtnAmountDTO opDgRtnAmountDTO = new OpDgRtnAmountDTO();
									opDgRtnAmountDTO.setId_orsrv(blCgItmOepDOs[j].getId_orsrv());
									opDgRtnAmountDTO.setCharged_amount(blCgItmOepDOs[j].getQuan());// 可以不要吗？
									OpDgRtnAmountDTO[] opDgRtnAmountDTOs = iMpDgOutService.getOpDgRtnAmount(new OpDgRtnAmountDTO[] { opDgRtnAmountDTO });
									if (opDgRtnAmountDTOs != null && opDgRtnAmountDTOs.length > 0) {
										if (opDgRtnAmountDTOs[0].getRtn_amount().compareTo(id_cditmoep[t].getQuan_refund()) < 0) {
											throw new BizException(blCgItmOepDOs[j].getName_srv() + " \r\n退费数量小于可退数量，请重新加载数据再退费！");
										}
									}
								} else {
									if (blCgItmOepDOs[j].getQuan().compareTo(id_cditmoep[t].getQuan_refund()) < 0) {
										throw new BizException(blCgItmOepDOs[j].getName_srv() + " \r\n退费数量小于可退数量，请重新加载数据再退费！");
									}
								}

								//new_quan = blCgItmOepDOs[j].getQuan().sub((id_cditmoep[t].getQuan_refund()));
							}
							
							

							new_quan = blCgItmOepDOs[j].getQuan().sub((id_cditmoep[t].getQuan_refund()));
						}
						if (((blCgItmOepDOs[j].getQuan().toBigDecimal().compareTo(id_cditmoep[t].getQuan_refund().toBigDecimal()) == 0)||tf_flag) && blCgItmOepDOs[j].getId_or() != null && "~" != blCgItmOepDOs[j].getId_or()) { // 收费数量与退费数量相同

							if (!AllRefundAndAllCharge.booleanValue() && !StringUtil.isEmpty(blCgItmOepDOs[j].getId_orsrv())) // 非全退全收
							{
								// 收费数量与退费数量相同，且非重退重收，表示真实的全退
								// 只要全退了，才能修改医嘱记账状态
								// 全退，需要修改医嘱表，置为医嘱退费
								id_orsrv.add(blCgItmOepDOs[j].getId_orsrv());
							}
							allRefund_count = allRefund_count + 1;
						}
						if (blCgItmOepDOs[j].getEu_srctp() == 1 && !AllRefundAndAllCharge.booleanValue()) // 退号
						{
							allRefund_count = allRefund_count + 1;
						}
						break;
					}
				}

				if (new_quan.compareTo(new FDouble(0)) > 0) // 刨去退费后剩余的新数据
				{
					new_BlCgItmOepDO = (BlCgItmOepDO) blCgItmOepDOs[j].clone();
					if (new_quan.toBigDecimal().compareTo(blCgItmOepDOs[j].getQuan().toBigDecimal()) != 0) {
						// 需要记退费关联的ID
						new_BlCgItmOepDO.setId_par(blCgItmOepDOs[j].getId_cgitmoep());
					}
					new_BlCgItmOepDO.setId_cgitmoep(null);
					new_BlCgItmOepDO.setId_cgoep(null);

					// 退费后需要收费的数量
					new_BlCgItmOepDO.setQuan(new_quan);

					// 重划重收需要重新计价
					if (AllRefundAndAllCharge.booleanValue()) {
						// 新价格，新比例
						if ((blCgItmOepDOs[j].getFg_mm() == null || !blCgItmOepDOs[j].getFg_mm().booleanValue())) // 非物品计价
						{
							SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = pcService.CalSingleSrvPriceByIdPripat_NameTip(new_BlCgItmOepDO.getId_srv(), new_BlCgItmOepDO.getName_srv(), new_BlCgItmOepDO.getId_pripat());
							new_BlCgItmOepDO.setPrice(srvPricalRateAndPriceDTO.getPrice());
							new_BlCgItmOepDO.setRatio_pripat(srvPricalRateAndPriceDTO.getRate());
						} else // 物品计价
						{
							new_BlCgItmOepDO.setPrice(blCgItmOepDOs[j].getPrice());
							new_BlCgItmOepDO.setRatio_pripat(blCgItmOepDOs[j].getRatio_pripat());
						}
					}
					// 标准金额:此处不用考虑医保，医保全退
					new_BlCgItmOepDO.setAmt_hp(new FDouble(0));
					new_BlCgItmOepDO.setAmt_std(new_quan.multiply(blCgItmOepDOs[j].getPrice()).setScale(-2, BigDecimal.ROUND_HALF_UP));

					if (blCgItmOepDOs[j].getFg_mm() == null || !blCgItmOepDOs[j].getFg_mm().booleanValue()) {
						// 物品不用设置价格比例，非物品需要考虑价格比例
						new_BlCgItmOepDO.setAmt(new_quan.multiply(blCgItmOepDOs[j].getPrice_ratio()).setScale(-2, BigDecimal.ROUND_HALF_UP));
					} else {
						// 物品不用设置价格比例
						new_BlCgItmOepDO.setAmt(new_BlCgItmOepDO.getAmt_std());
					}
					new_BlCgItmOepDO.setAmt_ratio(new_quan.multiply(blCgItmOepDOs[j].getPrice_ratio()).setScale(-2, BigDecimal.ROUND_HALF_UP));
					new_BlCgItmOepDO.setAmt_pat(new_BlCgItmOepDO.getAmt_ratio());
					// 患者自付金额
					// amt,amt_pat,amt_std,amt_hp
					all_amt = all_amt.add(new_BlCgItmOepDO.getAmt());
					all_amt_std = all_amt_std.add(new_BlCgItmOepDO.getAmt_std());
					all_amt_pat = all_amt_pat.add(new_BlCgItmOepDO.getAmt_pat());

					new_BlCgItmOepDO.setFg_st(null);
					new_BlCgItmOepDO.setId_stoep(null);
					new_BlCgItmOepDO.setDt_st(null);
					new_BlCgItmOepDO.setId_org(operatorInfoDTO.getId_org());
					new_BlCgItmOepDO.setId_grp(operatorInfoDTO.getId_grp());
					new_BlCgItmOepDO.setFg_hp(blCgItmOepDOs[j].getFg_hp());
					new_BlCgItmOepDO.setFg_susp(FBoolean.TRUE);
					new_BlCgItmOepDO.setId_par(blCgItmOepDOs[j].getId_cgitmoep());
					new_BlCgItmOepDO.setFg_refund(FBoolean.FALSE);
					new_BlCgItmOepDO.setNote("重收：" + blCgItmOepDOs[j].getId_cgitmoep());
					new_BlCgItmOepDO.setId_root(StringUtil.isEmpty(blCgItmOepDOs[j].getId_root()) ? blCgItmOepDOs[j].getId_cgitmoep() : blCgItmOepDOs[j].getId_root());
					new_BlCgItmOepDO.setStatus(DOStatus.NEW);
					new_BlCgItmOepDOList.add(new_BlCgItmOepDO);
				}
			}
		}

		if (!tf_flag) {
			if (id_orsrv.size() > 0)// 更新医嘱记账信息
			{
				// 修改医嘱为退费状态
				Object obj2 = ServiceFinder.find(ICiOrdMaintainService.class);
				FBoolean updateCiOrder = ((ICiOrdMaintainService) obj2).UpdateOrdChargeRelInfo2(id_orsrv.toArray(new String[] {}), ICiDictCodeConst.SD_SU_BL_REFOUND_ID, ICiDictCodeConst.SD_SU_BL_REFOUND, strDateTime, FeeReverseType.BLSTREVERSE);
				if (!updateCiOrder.booleanValue()) {
					throw new BizException("更新医嘱项目记账状态失败！");
				}
			}
		}
		

		// 9.有重收的数据，则返回重收的记账信息
		if (new_BlCgItmOepDOList.size() > 0) {

			// 设置重收将要出现的票据号，设置的作用是方便前台核对，防止即将写入的发票号与真实发票对不上
			String code_pkg = "";
			// 得到票据包
			IBlincQryService iBlincQryService = ServiceFinder.find(IBlincQryService.class);
			code_pkg = iBlincQryService.getCodeIncPkgByIdempiss(operatorInfoDTO.getId_org(), operatorInfoDTO.getId_emp(), IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);

			GetBlCgItmOepMap blCgItmOepMapIns = new GetBlCgItmOepMap();
			BlCgItmOepMapDTO blCgItmOepMapDTO = blCgItmOepMapIns.BlCgItmOepConvertToMapIncPripats(new_BlCgItmOepDOList.toArray(new BlCgItmOepDO[] {}), operatorInfoDTO.getId_emp(), IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE, code_pkg);
			// 一次遍历获得:就诊，发票号1|就诊，发票号2|...|
			// 就诊=id_pat+" "+id_org+" "+id_ent+" "+id_enttp
			new_BlCgOepDO.setEnt_invoiceno(blCgItmOepMapDTO.getEntAndno());
			//
			// new_BlCgOepDO.setEnt_invoiceno(entAndno);
			new_BlcgoepAggDO.setParentDO(new_BlCgOepDO);
			new_BlcgoepAggDO.setBlCgItmOepDO(new_BlCgItmOepDOList.toArray(new BlCgItmOepDO[] {}));
			BlcgoepAggDO[] new_BlcgoepAggDOs = new BlcgoepAggDO[] { new_BlcgoepAggDO };
			new_BlcgoepAggDOs[0].getParentDO().setEnt_invoiceno(blCgItmOepMapDTO.getEntAndno());
			return new_BlcgoepAggDOs;
		} else {
			return null;
		}

	}

	private BlcgoepAggDO[] getOrgin_blcgoepAggDO(String[] id_cgoep) throws BizException {
		IBlcgoepRService iBlcgoepRService = ServiceFinder.find(IBlcgoepRService.class);
		BlcgoepAggDO[] orgin_blcgoepAggDO = iBlcgoepRService.findByIds(id_cgoep, FBoolean.TRUE);
		return orgin_blcgoepAggDO;

	}

	/**
	 * 触发门诊收费事件
	 * 
	 * @param patDO
	 * @param regInfo
	 * @param pvDO
	 * @throws BizException
	 */
	private void invokeOepSettlementEvent(BlcgoepAggDO[] BlcgoepAggDO_arr, BlpaypatoepAggDO blpaypatoepAggDO, BlStOepDO blStOepDO1, BlincoepAggDO blincoepAggDOArrx1) throws BizException {
		BlEventInfoDTO blEventInfoDTO = new BlEventInfoDTO();
		// 组装事件需要的数据
		IPativisitRService iPativisitRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] patiVisitDO = iPativisitRService.find(" id_ent='" + blStOepDO1.getId_ent() + "'", "", FBoolean.FALSE);
		IPatiRService iPatiRService = ServiceFinder.find(IPatiRService.class);
		PatiAggDO[] patiAggDOArr = iPatiRService.find(" id_pat='" + blStOepDO1.getId_pat() + "'", "", FBoolean.FALSE);
		FArrayList blCgItmOepDOList = new FArrayList();
		for (BlcgoepAggDO blcgoepAggDO : BlcgoepAggDO_arr) {
			BlCgItmOepDO[] blCgItmOepDOArr = blcgoepAggDO.getBlCgItmOepDO();
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOArr) {
				blCgItmOepDOList.add(blCgItmOepDO);
			}
		}
		blEventInfoDTO.setPatiVisitDO(patiVisitDO[0]);
		blEventInfoDTO.setPatDO(patiAggDOArr[0].getParentDO());
		blEventInfoDTO.setBlpaypatoepAggDO(blpaypatoepAggDO);
		blEventInfoDTO.setBlStOepDO(blStOepDO1);
		blEventInfoDTO.setBlIncOepDO(blincoepAggDOArrx1.getParentDO());
		blEventInfoDTO.setBlCgItmOepDOList(blCgItmOepDOList);
		blEventInfoDTO.setFunc_Status(IBlFunCodeConst.FUN_CODE_OPFEERTN_RED);// 红冲

		// 2、触发事件
		BusinessEvent oepSettlementEvent = new BusinessEvent(IBlEventConst.EVENT_SOURCE_BL_OEP_SETTLEMENT, IEventType.TYPE_INSERT_AFTER, blEventInfoDTO);
		EventDispatcher.fireEvent(oepSettlementEvent);
	}

	/**
	 * 出发退费事件
	 * 
	 * @param id_st
	 * @throws BizException
	 */
	private void invokeRefundEvent(String id_st) throws BizException {
		OpRefundEvent event = new OpRefundEvent();
		OpRefund4EsDTO eventSource = new OpRefund4EsDTO();
		eventSource.setId_st(id_st);
		event.invoke(eventSource);
	}
	
	/**
	 * 发退费事件
	 * @param fgAllRefund
	 * @param refundCgIdList
	 * @throws BizException
	 */
	private void invokeRefundEventNew(FBoolean fgAllRefund,List<String> refundCgIdList) throws BizException {
		
		this.eventDto.setFg_allRefund(fgAllRefund);
		List<BlCgItmOepDO> refundCgList = new ArrayList<BlCgItmOepDO>();
		for (BlcgoepAggDO cgAggDO : this.eventDto.getOldCgData()) {
			for (BlCgItmOepDO blCgItmOepDO : cgAggDO.getBlCgItmOepDO()) {
				if(refundCgIdList.contains(blCgItmOepDO.getId_cgitmoep())){
					refundCgList.add(blCgItmOepDO);
				}
			}
		}
		
		this.eventDto.setActualRefundCgData(refundCgList.toArray(new BlCgItmOepDO[0]));
		BlPayOepRefundEventDTO reStEventData = (BlPayOepRefundEventDTO)Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_OPREFUND_EVENTDATA);
		if(reStEventData != null){
			this.eventDto.setNewCgData(reStEventData.getNewCgData());
			this.eventDto.setNewStData(reStEventData.getNewStData());
			this.eventDto.setNewPayData(reStEventData.getNewPayData());
			this.eventDto.setNewIncData(reStEventData.getNewIncData());
		}
		
		BlOpPayEvent.invokeRefund(this.eventDto);
	}
	
	/**
	 * 处理门诊费用真实转住院费用退费校验逻辑
	 * @author zhang.hw
	 * @date 2020年3月25日
	 * @param idList
	 * @return
	 * @throws BizException
	 */
	private BlCgItmOepTfRcdDO[] getOepTfItmInfo(List<String> idList) throws BizException{
		//退费考虑门诊费用插入住院费用的情况
		IBlcgoeptfRService tfrService = ServiceFinder.find(IBlcgoeptfRService.class);
		return tfrService.findoeptfrcdInfo(idList.toArray(new String[0]));
	}

}
