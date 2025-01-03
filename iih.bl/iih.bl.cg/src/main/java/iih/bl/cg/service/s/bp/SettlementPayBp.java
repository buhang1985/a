package iih.bl.cg.service.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.SVCheckUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.bp.DoOepFgAccAmtAcc;
import iih.bl.cg.bp.HandlerCpnOepBp;
import iih.bl.cg.bp.oep.OpFreeAmtHandleBP;
import iih.bl.cg.service.d.Bl_IdorAndIdorsrvDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.s.event.BlOpPayEvent;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.comm.IBlFlowKeyConst;
import iih.bl.comm.s.bp.BlThirdPayBP;
import iih.bl.comm.util.BlDataUtil;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.comm.util.BlUpdateOrChargeStateUtil;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.d.desc.BlIncOepDODesc;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.dto.blincprint.d.BlIncPrintDTO;
import iih.bl.inc.dto.d.BlIncissOepDTO;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.bl.params.BlParams;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.pub.dto.d.BlOepSrvEventInfoDTO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepCudService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.ciprn.i.ICiprintExtService;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;

/**
 * 结算付款
 * @author yangyang
 *
 */
public class SettlementPayBp {
	
	private static final String LOCK_KEY = "payment_lock_";

	/** 结算付款
	 * @param blcgoepAggDOArr 记账明细
	 * @param blpaypatoepAggDO 付款明细
	 * @param IsDrugApplication 是否药品
	 * @param PrintInvoice 是否打印发票
	 * @param IsTransferPrepay 是否转存
	 * @return
	 */
	public BlIncItmVsTypeDTO[] exec(BlcgoepAggDO[] blcgoepAggDOArr, BlpaypatoepAggDO blpaypatoepAggDO, FBoolean IsDrugApplication, FBoolean PrintInvoice, FBoolean IsTransferPrepay) throws BizException
	{
		// 设置终端类型上下文
		if (blpaypatoepAggDO != null) {
			BlPayPatOepDO payPatDo = blpaypatoepAggDO.getParentDO();
			if (payPatDo != null) {
				Context.get().setAttribute(IBlFlowKeyConst.BL_FLOW_KEY_SD_PTTP, payPatDo.getSd_pttp());
			}
		}

		//结转
		Context.get().setAttribute(IBlFlowKeyConst.BL_FLOW_KEY_TRANSFERPREPAY, IsTransferPrepay);
		
		//获取当前时间
		FDateTime fDateTime = AppUtils.getServerDateTime();

		OperatorInfoDTO operatorInfoDTO = new OperatorInfoDTO();
		operatorInfoDTO.setId_grp(blpaypatoepAggDO.getParentDO().getId_grp());
		operatorInfoDTO.setId_org(blpaypatoepAggDO.getParentDO().getId_org());
		operatorInfoDTO.setId_dep(blpaypatoepAggDO.getParentDO().getId_dep_pay());
		operatorInfoDTO.setId_emp(blpaypatoepAggDO.getParentDO().getId_emp_pay());
		operatorInfoDTO.setId_org_emp(blpaypatoepAggDO.getParentDO().getId_org());

		String maxInvoiceno = "";
		String id_stoep = "";
		BlIncItmVsTypeDTO[] incOepInfoLst = null;
		//1、数据验证
		this.validateData(blcgoepAggDOArr,blpaypatoepAggDO);
		//校验医嘱数据是否做了更改,TODO review by yangyang 2017-10-26,铜陵住院上线当天，加锁机制问题比较严重
//		addInstanceLock(blcgoepAggDOArr);
		
		//加锁（锁id和旧取消划价，新取消划价，新收付款接口一致）
		String stId = blcgoepAggDOArr[0].getBlCgItmOepDO()[0].getId_stoep();
		String lockKey = LOCK_KEY + stId;
		boolean lock = PKLock.getInstance().addDynamicLock(lockKey, 0);
		if(!lock){
			throw new BizException("当前患者正在收付款或取消划价，请刷新重试");
		}
		
		this.checkSv(blcgoepAggDOArr);//ly 2019/05/15
		
		//2、保存患者收付款
		BlpaypatoepAggDO[] blpaypatoepAggDOs = updatePayInfo(blcgoepAggDOArr, blpaypatoepAggDO, fDateTime, IsTransferPrepay);

		// 3. 处理减免的业务逻辑
		// (1)查询发票信息 (已经是一次划价，一次结算，一张发票的模式）
		id_stoep = blcgoepAggDOArr[0].getBlCgItmOepDO()[0].getId_stoep();
		for(BlCgItmOepDO cgitmDo:blcgoepAggDOArr[0].getBlCgItmOepDO())
		{
			if(!StringUtil.isEmptyWithTrim(cgitmDo.getId_stoep()))
			{
				id_stoep=cgitmDo.getId_stoep();
				break;
			}
		}
		
		IBlincoepRService iBlincoepRService = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] blincoepAggDOArrx = iBlincoepRService.find(BlIncOepDODesc.TABLE_ALIAS_NAME + ".id_stoep='" + id_stoep + "'", "", FBoolean.FALSE);
		//if (blincoepAggDOArrx == null || blincoepAggDOArrx.length == 0) {
		//	throw new BizException("门诊结算：查询患者发票信息失败");
		//}
		if(ArrayUtil.isEmpty(blincoepAggDOArrx)){
			IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
			blincoepAggDOArrx = incService.saveOpInvoice(blcgoepAggDOArr);
		}
		
		// (2) 处理减免的业务逻辑-
		//DoOepFgFree doOepFgFree = new DoOepFgFree();
		//TODO 合并，需兼容北京和铜陵，yangyang处理，2017-12-22
//		blincoepAggDOArrx[0] = doOepFgFree.doFreeBiz(blcgoepAggDOArr, blpaypatoepAggDO, blincoepAggDOArrx[0], DOStatus.UPDATED);
		//blincoepAggDOArrx[0] = doOepFgFree.DoOep_FgFree_new(blcgoepAggDOArr, blpaypatoepAggDO, blincoepAggDOArrx[0], DOStatus.UPDATED);
		//1.使用新的减免方式 hanjq 2019-10-23 13:22
		OpFreeAmtHandleBP freeBp = new OpFreeAmtHandleBP();
		freeBp.exec(id_stoep, blcgoepAggDOArr, blpaypatoepAggDO);
		// 4.根据Id_stoep，查询ST表，用收付款主键回写结算表，如果是医生站接诊产生的数据，还需要完善其他数据
		BlStOepDO blStOepDO = spotBlStInfo(id_stoep, blpaypatoepAggDOs[0].getParentDO().getId_paypatoep(), operatorInfoDTO)[0];
		
		String entId = null;
		for (BlcgoepAggDO blcgoepAggDO : blcgoepAggDOArr) {
			for (BlCgItmOepDO cgItmDO : blcgoepAggDO.getBlCgItmOepDO()) {
				if(!StringUtil.isEmpty(cgItmDO.getId_ent())){
					entId = cgItmDO.getId_ent();
					break;
				}
			}
		}
		
		boolean ifPreIp = this.ifPreIp(entId);
		
		if(!ifPreIp){
			
			// 更新医嘱记账状态
			updateCiOrderAfterPay(blcgoepAggDOArr, fDateTime);
		
			// 如果当前结算为诊间挂号数据结算 需要更新就诊数据  by liming 2019-01-10
			FBoolean bExistEntRegist=BlDataUtil.bExistEntRegist(blcgoepAggDOArr[0].getBlCgItmOepDO());
			if (FBoolean.TRUE.equals(bExistEntRegist)) {
				IEnOutCmdService enService = ServiceFinder.find(IEnOutCmdService.class);
				enService.ubpdateFgstAfterSt(blStOepDO.getId_stoep());
			}

			HashMap<String, String> map = new HashMap<String, String>();
			for (BlcgoepAggDO aggdo : blcgoepAggDOArr) {
				BlCgItmOepDO[] itmOepDOs = aggdo.getBlCgItmOepDO();
				for (BlCgItmOepDO blCgItmOepDO : itmOepDOs) {
					//TODO yangyang review 退费明细不再处理
					if(blCgItmOepDO.getFg_refund()!=null && blCgItmOepDO.getFg_refund().booleanValue())
						continue;
					if (blCgItmOepDO.getEu_srctp() == 0) {
						if (map.containsKey(blCgItmOepDO.getId_ent())) {
							if (blCgItmOepDO.getCode_apply() != null && !"".equals(blCgItmOepDO.getCode_apply())) {
								String str = map.get(blCgItmOepDO.getId_ent());
								map.remove(blCgItmOepDO.getId_ent());
								map.put(blCgItmOepDO.getId_ent(), str + ",'" + blCgItmOepDO.getCode_apply() + "'");
							}
						} else {
							if (blCgItmOepDO.getCode_apply() != null && !"".equals(blCgItmOepDO.getCode_apply()))
								map.put(blCgItmOepDO.getId_ent(), "'" + blCgItmOepDO.getCode_apply() + "'");
						}
					}
				}
			}
			if (map.size() != 0) {
				ICiprintExtService service = ServiceFinder.find(ICiprintExtService.class);
				service.UpdateCiPrintBlsettled(map, FBoolean.TRUE);
			}
		}else{
			
			//更新就诊账户锁定额
			this.updateEntAcc(entId, blStOepDO);
		}
		
		// 5.不打印发票，则直接更新记账挂起标志
		if (FBoolean.FALSE.equals(BlParams.BLSTOEP0008())&&blincoepAggDOArrx[0].getParentDO().getAmt().equals(new FDouble(0)))// 如果本次结算的发票总金额是0，则不打发票
		{
			PrintInvoice = FBoolean.FALSE;
		}
		if (!PrintInvoice.booleanValue()) // 不打印发票
		{
			BLCiOrderToBlCgServiceImplBp handlerBp = new BLCiOrderToBlCgServiceImplBp();
			incOepInfoLst = handlerBp.handlerIncInfoDtos(FBoolean.TRUE, FBoolean.FALSE, blStOepDO, blincoepAggDOArrx, blpaypatoepAggDOs[0]);
			writeBackBlCgAfterPay(blcgoepAggDOArr);
//			//
//			// 发事件
//			this.invokeOepSettlementEvent(blcgoepAggDOArr, blpaypatoepAggDO, blStOepDO, blincoepAggDOArrx[0], IBlFunCodeConst.FUN_CODE_OPFEECOLLECT);


			//发送新的退费事件 2019年1月22日
			BlOpPayEvent.invokePay(blcgoepAggDOArr, blStOepDO, blpaypatoepAggDO, blincoepAggDOArrx);
			//如果收款类型为窗口，并且付款方式为支付宝或者微信，则回写日志信息    zhangxin 2019年3月9日20:42:15
			this.ThirdPaySettle(blcgoepAggDOArr, blpaypatoepAggDOs, id_stoep);
			return incOepInfoLst;
		}
		
		//发票服务
		BlIncPrintDTO printSet = new BlIncPrintDTO();
		printSet.setFgpay(FBoolean.TRUE);
		if(blpaypatoepAggDO!=null){
			BlPayPatOepDO payPatDo=blpaypatoepAggDO.getParentDO();
			if(payPatDo!=null){
				printSet.setSd_pttp(payPatDo.getSd_pttp());
			}
		}
		if(StringUtil.isEmpty(printSet.getSd_pttp())){
			printSet.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		}
		IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
		blincoepAggDOArrx = incService.printOpInvoice(new String[]{id_stoep},printSet);

		// 8.打发票
		String strPayWay = getPm_tp(blpaypatoepAggDO, id_stoep);// 查询支付方式
		BLCiOrderToBlCgServiceImplBp handlerBp = new BLCiOrderToBlCgServiceImplBp();
		BlIncItmVsTypeDTO[] incOepDtoLst = handlerBp.handlerIncInfoDtos(FBoolean.TRUE, FBoolean.FALSE, blStOepDO, blincoepAggDOArrx, blpaypatoepAggDOs[0]);
		List<String> id_orsrvLst = new ArrayList<String>();
		// 9.已经收付款后，需要更新CG表的挂起标志等信息。返回CG表中的id_orsrv
		id_orsrvLst = writeBackBlCgAfterPay(blcgoepAggDOArr);

		// 11.发事件
		try {
//			this.invokeOepSettlementEvent(blcgoepAggDOArr, blpaypatoepAggDO, blStOepDO, blincoepAggDOArrx[0], IBlFunCodeConst.FUN_CODE_OPFEECOLLECT);
//			// 尝试把CI的发事件代码复制过来
//			if (id_orsrvLst != null || id_orsrvLst.size() > 0) {
//				this.invokeOepCiOrderEvent(id_orsrvLst);
//			}
			
			//发送新的退费事件 2019年1月22日
			BlOpPayEvent.invokePay(blcgoepAggDOArr, blStOepDO, blpaypatoepAggDO, blincoepAggDOArrx);
			
		} catch (Exception ex) {
			Logger.getLogger(this.getClass()).error(ex);
		}
		//12.如果收款类型为窗口，并且付款方式为支付宝或者微信，则回写日志信息
		this.ThirdPaySettle(blcgoepAggDOArr, blpaypatoepAggDOs, id_stoep);

		return incOepDtoLst;
	}
   
	/**
	 * 校验sv
	 * @param blcgoepAggDOArr
	 * @throws BizException
	 */
	private void checkSv(BlcgoepAggDO[] blcgoepAggDOArr) throws BizException{
		
		Map<String,FDateTime> svCheckMap = new HashMap<String,FDateTime>();
		for (BlcgoepAggDO blcgoepAggDO : blcgoepAggDOArr) {
			for (BlCgItmOepDO cgItmDO : blcgoepAggDO.getBlCgItmOepDO()) {
				
				if(!StringUtil.isEmpty(cgItmDO.getId_or()) && cgItmDO.getCi_sv() != null){
					svCheckMap.put(cgItmDO.getId_or(), cgItmDO.getCi_sv());
				}
			}
		}
		
		if(svCheckMap.size() == 0)
			return;
		
		boolean lock = PKLock.getInstance().addBatchDynamicLock(svCheckMap.keySet().toArray(new String[0]));
		if(!lock){
			throw new BizException("当前医嘱数据已被他人修改，请重新调入");
		}
		
		Boolean check = SVCheckUtils.checkSv(svCheckMap, new CiOrderDO());
		if(!check){
			throw new BizException("当前医嘱数据已被他人修改，请重新调入");
		}
	}
	
	/**
	 * 第三方支付  处理逻辑 修改付款方式 回写日志信息
	 * @param blcgoepAggDOArr
	 * @param blpaypatoepAggDOs
	 * @throws BizException 
	 */
	private void ThirdPaySettle(BlcgoepAggDO[] blcgoepAggDOArr,BlpaypatoepAggDO[] blpaypatoepAggDOs,String  id_stoep) throws BizException{
		// 12.如果收款类型为窗口，并且付款方式为支付宝或者微信，则回写日志信息
		if (IBlDictCodeConst.SD_PTTP_WINDOW.equals(blpaypatoepAggDOs[0].getParentDO().getSd_pttp())||IBlDictCodeConst.SD_PTTP_ROOM.equals(blpaypatoepAggDOs[0].getParentDO().getSd_pttp())) {
			BlPayItmPatOepDO[] blPayItmPatOepDOArr = blpaypatoepAggDOs[0].getBlPayItmPatOepDO();
			List<String> ordNoList = new ArrayList<String>();
			FBoolean isSc = FBoolean.FALSE;
			if (blcgoepAggDOArr != null) {
				// 是否挂号费用
				if (StringUtils.isEmpty(blcgoepAggDOArr[0].getBlCgItmOepDO()[0].getId_orsrv())) {
					isSc = FBoolean.TRUE;
				}
			}
			BlPayItmPatOepDO payItmPatOepDO = BlThirdPayBP.validate(blPayItmPatOepDOArr,isSc.booleanValue() ? IBlDictCodeConst.SD_BIZSCENE_OEP_ENT: IBlDictCodeConst.SD_BIZSCENE_OEP_CHARGE);
			if (payItmPatOepDO != null) {
				// 如果支付方式为微信或支付宝 并且外部订单号不为空
				if (!StringUtils.isEmpty(payItmPatOepDO.getPaymodenode())) {
					ordNoList.add(payItmPatOepDO.getPaymodenode());
				}
			}
			if (!ListUtil.isEmpty(ordNoList)) {
				saveThirdLog(ordNoList, id_stoep);
			}
		}
	}
	/**
	 * 保存窗口支付(微信支付宝)日志
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
		sql.append(" from bl_pay_itm_pat_oep itm "
				+ "  inner join bl_pay_pat_oep pay on itm.id_paypatoep=pay.id_paypatoep"
				+ "  inner join bl_st_oep st on itm.id_paypatoep=st.id_paypatoep"
				+ " where st.id_stoep='"+id_stoep+"' and bl_trd_trans_rcd.order_no=itm.paymodenode and bl_trd_trans_rcd.id_emp_oper=pay.id_emp_pay)");
		sql.append(" where ");
		sql.append(SqlUtils.getInSqlByIds("bl_trd_trans_rcd.order_no", ordNoList));
		new DAFacade().execUpdate(sql.toString());
	}
	
	/**
	 * 保存患者收付款信息。 如果患者采用预交金支付或结存，则处理预交金，且修改门诊预交金账户,修改门诊预交金消费锁定金额
	 * 
	 * @param blcgoepAggDO
	 *            记账信息
	 * @param blpaypatoepAggDO
	 *            收付款信息
	 * @param fDateTime
	 *            服务器时间
	 * @param IsTransferPrepay
	 *            余额是否结转到预交金
	 * @return 保存后的收付款信息
	 * @throws BizException
	 */
	private BlpaypatoepAggDO[] updatePayInfo(BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO, FDateTime fDateTime, FBoolean IsTransferPrepay)
			throws BizException {
		BlPayPatOepDO blPayPatOepDO = blpaypatoepAggDO.getParentDO();
		blPayPatOepDO.setDt_pay(fDateTime);
		blPayPatOepDO.setStatus(DOStatus.NEW);
		blpaypatoepAggDO.setParentDO(blPayPatOepDO);
		for (BlPayItmPatOepDO blPayItmPatOepDO : blpaypatoepAggDO.getBlPayItmPatOepDO()) {
			if(blPayItmPatOepDO.getFg_realpay()==null){
				blPayItmPatOepDO.setFg_realpay(FBoolean.TRUE);// 真实数据
			}
		}
		Object service = ServiceFinder.find(IBlpaypatoepCudService.class);
		BlpaypatoepAggDO[] blpaypatoepAggDOs = ((IBlpaypatoepCudService) service).save(new BlpaypatoepAggDO[] { blpaypatoepAggDO });
		if (null == blpaypatoepAggDOs) {
			throw new BizException("保存患者收付款信息失败");
		}
		// 2.1如果患者采用预交金支付或结存，则处理预交金，且修改门诊预交金账户,修改门诊预交金消费锁定金额
		DoOepFgAccAmtAcc doOepFgAccAmtAccBp = new DoOepFgAccAmtAcc();
		doOepFgAccAmtAccBp.doOepPrepayConsumeAndTransferPrepay(blcgoepAggDO, blpaypatoepAggDOs, IsTransferPrepay, fDateTime);

		// 如果患者采用优惠券支付
		BlPayItmPatOepDO[] payItmPayDoLst = blpaypatoepAggDOs[0].getBlPayItmPatOepDO();
		HandlerCpnOepBp handlerCpnBp = new HandlerCpnOepBp();
		for (BlPayItmPatOepDO item : payItmPayDoLst) {
			// 如果是优惠券则做优惠券的处理
			if (item.getSd_pm().equals(IBdPripmCodeConst.CODE_PRI_PM_COUPON)) {
				handlerCpnBp.exec(blPayPatOepDO.getId_pat(), item.getPaymodenode());
			}
		}
		return blpaypatoepAggDOs;
	}
		/**
	 * 结算前校验
	 * 
	 * @param blStOepDO
	 * @param blincoepAggDO
	 * @param blcgoepAggDO
	 * @param PrintInvocie
	 * @throws BizException
	 */
	private void validateData(BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO) throws BizException {
		if (blcgoepAggDO == null) {
			throw new BizException("没有门诊记账信息");
		}
		if (blpaypatoepAggDO == null) {
			throw new BizException("没有门诊收款信息");
		}

		if (blpaypatoepAggDO.getParentDO().getAmt() == null || blpaypatoepAggDO.getParentDO().getAmt().toString().trim().length() == 0) {
			throw new BizException("收付款主表金额不为空！");
		}
		if (blpaypatoepAggDO.getParentDO().getSd_pttp() == null || blpaypatoepAggDO.getParentDO().getSd_pttp().toString().trim().length() == 0) {
			throw new BizException("收付款终端类型不为空！");
		}
		if (blpaypatoepAggDO.getBlPayItmPatOepDO() == null || blpaypatoepAggDO.getBlPayItmPatOepDO().length == 0) {
			throw new BizException("没有收付款明细，请检查支付方式！");
		}
		BlPayItmPatOepDO[] blPayItmPatOepDOArr = blpaypatoepAggDO.getBlPayItmPatOepDO();
		for (int i = 0; i < blPayItmPatOepDOArr.length; i++) {
			if (blPayItmPatOepDOArr[i] == null || blPayItmPatOepDOArr[i].getSd_pm() == null) {
				throw new BizException("没有设置门诊收款明细费用支付方式代码");
			}
			if (blPayItmPatOepDOArr[i] == null || blPayItmPatOepDOArr[i].getId_pm() == null) {
				throw new BizException("没有设置门诊收款明细费用支付方式ID");
			}

		}
	}

	private void addInstanceLock(BlcgoepAggDO[] blcgoepAggDO) throws BizException
	{
		List<String> id_orsrvLst = new ArrayList<String>();
		List<String> id_orLst = new ArrayList<String>();
		// 1.防止脏数据，加锁,校验SV
		Bl_IdorAndIdorsrvDTO bl_IdorAndIdorsrvDTO = getIdorOfPay(blcgoepAggDO);
		id_orLst = bl_IdorAndIdorsrvDTO.getId_or();
		id_orsrvLst = bl_IdorAndIdorsrvDTO.getId_orsrv();
		if (id_orLst != null && id_orLst.size() > 0) {
			boolean isLock = PKLock.getInstance().addBatchDynamicLock(id_orLst.toArray(new String[0]));
			if (!isLock) {
				throw new BizException("医嘱加锁失败，其他用户正在处理，请重新提取再结算!");
			}
			// 校验ci_or_srv.sv是否发生改变，若改了，则禁止收款（放到此处是为了缩短校验时差）
			validateCiSV(blcgoepAggDO, id_orLst);
		}
	}
	
	/**
	 * 获得结算对应的ID_OR和id_orsrv
	 * 
	 * @param blcgoepAggDOs
	 * @return
	 * @throws BizException
	 */
	private Bl_IdorAndIdorsrvDTO getIdorOfPay(BlcgoepAggDO[] blcgoepAggDOs) throws BizException {
		List<String> id_orLst = new ArrayList<String>();
		List<String> id_orsrvLst = new ArrayList<String>();
		for (int kk = 0; kk < blcgoepAggDOs.length; kk++) // 门诊记账Agg
		{
			BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDOs[kk].getBlCgItmOepDO();
			for (int k = 0; k < blCgItmOepDOs.length; k++)// 门诊记账明细表
			{
				if (blCgItmOepDOs[k].getId_or() != null && !id_orLst.contains(blCgItmOepDOs[k].getId_or())) {
					id_orLst.add(blCgItmOepDOs[k].getId_or());
				}
				if (blCgItmOepDOs[k].getId_orsrv() != null) {
					id_orsrvLst.add(blCgItmOepDOs[k].getId_orsrv());
				}
			}
		}
		Bl_IdorAndIdorsrvDTO bl_IdorAndIdorsrvDTO = new Bl_IdorAndIdorsrvDTO();
		bl_IdorAndIdorsrvDTO.setId_or(id_orLst);
		bl_IdorAndIdorsrvDTO.setId_orsrv(id_orsrvLst);
		return bl_IdorAndIdorsrvDTO;
	}

	/**
	 * 校验，在提取后或划价后，医嘱是否发生改变
	 * 
	 * @param blcgoepAggDOs
	 *            记账信息
	 * @param id_orsrvLst
	 *            ci_or_srv的id_orsrv
	 * @throws BizException
	 */
	private void validateCiSV(BlcgoepAggDO[] blcgoepAggDOs, List<String> id_orsrvLst) throws BizException {
		String condStr = "";
		Map<String, FDateTime> ci_sv_map = new HashMap<String, FDateTime>();
		for (String id_orsrv : id_orsrvLst) {
			condStr = condStr + ",'" + id_orsrv + "'";
		}
		if (condStr.length() == 0) {
			return;
		}
		condStr = " id_or in (" + condStr.substring(1) + ")";
		String[] fields = { "id_or", "sv" };
		DAFacade dafacade = new DAFacade();
		List<CiOrderDO> ordDOLst = (List<CiOrderDO>) dafacade.findByCond(CiOrderDO.class, condStr, fields);
		if (ordDOLst == null || ordDOLst.size() == 0) {
			return;
		}
		for (CiOrderDO ciordDO : ordDOLst) {
			ci_sv_map.put(ciordDO.getId_or(), ciordDO.getSv());
		}
		for (BlcgoepAggDO blcgoepAggDO : blcgoepAggDOs) {
			BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDO.getBlCgItmOepDO();
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOs) {
				if (blCgItmOepDO.getCi_sv() != null && blCgItmOepDO.getCi_sv().compareTo(new FDateTime("1900-01-01 00:00:00")) == 0) {
					continue;
				}
				if (blCgItmOepDO.getId_or() != null && blCgItmOepDO.getCi_sv() != null) {
					if (ci_sv_map.get(blCgItmOepDO.getId_or()) == null) {
						throw new BizException("医嘱已发生改变，请重新提取，再结算！");
					}
					if (blCgItmOepDO.getCi_sv().compareTo(ci_sv_map.get(blCgItmOepDO.getId_or())) != 0) {
						throw new BizException("医嘱已发生改变，请重新提取，再结算！");
					}
				}
			}
		}
	}
	
	/**
	 * 收费后修改对应的ci_or_srv.sd_su_bl
	 * 
	 * @param blcgoepAggDOs1
	 *            待保存的记账明细DO
	 * @param id_orsrvs
	 *            修改对应的ci_or_srv.sd_su_bl未已记账信息
	 * @return 保存成功的BlcgoepAggDO
	 * @throws BizException
	 */
	private void updateCiOrderAfterPay(BlcgoepAggDO[] blcgoepAggDO, FDateTime fDateTime) throws BizException {
		List<String> id_orsrvLst = new ArrayList<String>();
		for (BlcgoepAggDO blcgoepAggDO1 : blcgoepAggDO) {
			BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDO1.getBlCgItmOepDO();
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOs) {
				if (blCgItmOepDO.getId_orsrv() != null) {
					id_orsrvLst.add(blCgItmOepDO.getId_orsrv());
				}
			}
		}

		// 更新医嘱记账信息：新划价的信息对应医嘱
		if (id_orsrvLst != null && id_orsrvLst.size() > 0) {
			String[] id_orsrvs = id_orsrvLst.toArray(new String[0]);
			if (null != id_orsrvs && id_orsrvs.length > 0) {
				/*ICiOrdMaintainService iCiOrdMaintainService = ServiceFinder.find(ICiOrdMaintainService.class);
				FBoolean updateRes = iCiOrdMaintainService.UpdateOrdChargeRelInfo2(id_orsrvs, ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID, ICiDictCodeConst.SD_SU_BL_ACCOUNT, fDateTime,
						FeeReverseType.NOBLCANCEL);
				if (!updateRes.booleanValue()) {
					throw new BizException("更新医嘱状态失败,本次操作不成功！");
				}*/
				BlUpdateOrChargeStateUtil.updateChargeStatus(id_orsrvs, BlFlowContextUtil.getNowTime(), FeeReverseType.NOBLCANCEL);
			}
		}
	}
	
	/**
	 * 用收付款主键回写结算表，如果是医生站接诊产生的数据，还需要完善其他数据
	 * 
	 * @param id_stoep
	 *            结算主键
	 * @param id_paypatoep
	 *            收付款主键
	 * @param operatorInfoDTO
	 *            操作人员信息
	 * @return 结算表
	 * @throws BizException
	 */
	private BlStOepDO[] spotBlStInfo(String id_stoep, String id_paypatoep, OperatorInfoDTO operatorInfoDTO) throws BizException {
		// 1.检索结算表
		IBlstoepRService iBlstoepRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO blStOepDO = iBlstoepRService.findById(id_stoep);
		if (null == blStOepDO) {
			throw new BizException("查询患者结算信息失败");
		}
		// 2.修改门诊结算信息，回写收付款外键
		blStOepDO.setId_paypatoep(id_paypatoep);
		// 3.若是医生站接诊的数据，则没有收款员消息，需要完善
		//if (blStOepDO.getId_emp_st() == null || blStOepDO.getId_emp_st().length() == 0) {
			blStOepDO.setId_emp_st(operatorInfoDTO.getId_emp());
		//}
		//if (blStOepDO.getId_dep_st() == null || blStOepDO.getId_dep_st().length() == 0) {
			blStOepDO.setId_dep_st(operatorInfoDTO.getId_dep());
		//}
		if (blStOepDO.getId_org() == null || blStOepDO.getId_org().length() == 0) {
			blStOepDO.setId_org(operatorInfoDTO.getId_org());
		}
		if (blStOepDO.getId_grp() == null || blStOepDO.getId_grp().length() == 0) {
			blStOepDO.setId_grp(operatorInfoDTO.getId_grp());
		}
		blStOepDO.setId_hp(this.getHpIdFromPropData(blStOepDO.getId_stoep()));
		String patCaId = this.getPatCaId(blStOepDO.getId_stoep());
		if(!StringUtil.isEmpty(patCaId)){
			blStOepDO.setId_patca(patCaId);
		}
		
		blStOepDO.setStatus(DOStatus.UPDATED);
		// 4.保存
		IBlstoepCudService iBlstoepCudService = ServiceFinder.find(IBlstoepCudService.class);
		BlStOepDO[] blStOepDO1 = iBlstoepCudService.save(new BlStOepDO[] { blStOepDO });
		if (null == blStOepDO1) {
			throw new BizException("更新患者结算信息失败");
		}
		return blStOepDO1;
	}
	
	/**
	 * 查询分摊中的id_hp
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	private String getHpIdFromPropData(String stId) throws BizException{
	
		DAFacade daf = new DAFacade();
		String sql = "select propar.id_hp from bl_prop_ar_oep propar ";
		sql += "inner join bl_prop_oep prop ";
		sql += "on propar.id_propoep = prop.id_propoep ";
		sql += "where prop.id_stoep = ? ";
		
		SqlParam param = new SqlParam();
		param.addParam(stId);
		Object value = daf.execQuery(sql, param, new ColumnHandler());
		if(value == null){
			return null;
		}
		return value.toString();
	}
	
	/**
	 * 查询患者分类
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	private String getPatCaId(String stId) throws BizException{
		
		DAFacade daf = new DAFacade();
		String sql = "select distinct id_patca from en_ent ent ";
		sql += "inner join bl_cg_itm_oep cgitm ";
		sql += "on ent.id_ent = cgitm.id_ent ";
		sql += "where cgitm.id_stoep = ? ";
		
		SqlParam param = new SqlParam();
		param.addParam(stId);
		Object value = daf.execQuery(sql, param, new ColumnHandler());
		if(value == null){
			return null;
		}
		return value.toString();
	}

		/**
	 * 已经收付款后，需要更新CG表的挂起标志等信息。返回CG表中的id_orsrv
	 * 
	 * @param blcgoepAggDO
	 *            收付款对于的记账明细数据
	 * @return 记账中对应的id_orsrv list
	 * @throws BizException
	 */
	private List<String> writeBackBlCgAfterPay(BlcgoepAggDO[] blcgoepAggDO) throws BizException {
		List<String> id_orsrvLst = new ArrayList<String>();
		for (int kk = 0; kk < blcgoepAggDO.length; kk++) // 门诊记账Agg
		{
			// 更新记账明细，需要更改主DO的状态为更新
			BlCgOepDO blCgoepDo = blcgoepAggDO[kk].getParentDO();
			blCgoepDo.setStatus(DOStatus.UPDATED);
			// 记账明细字段更新
			BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDO[kk].getBlCgItmOepDO();
			for (int k = 0; k < blCgItmOepDOs.length; k++)// 门诊记账明细表
			{
				//TODO review by yangyang 
				if(blCgItmOepDOs[k].getFg_refund()!=null && blCgItmOepDOs[k].getFg_refund().booleanValue())
					continue;
				if (blCgItmOepDOs[k].getId_orsrv() != null) {
					id_orsrvLst.add(blCgItmOepDOs[k].getId_orsrv());
				}
				blCgItmOepDOs[k].setFg_susp(FBoolean.FALSE);
				blCgItmOepDOs[k].setFg_st(FBoolean.TRUE); // 已结算
				blCgItmOepDOs[k].setStatus(DOStatus.UPDATED);
			}
		}
		// 更新记账信息
		IBlcgoepCudService iBlcgoepCudService1 = ServiceFinder.find(IBlcgoepCudService.class);
		BlcgoepAggDO[] BlcgoepAggDO_arr = iBlcgoepCudService1.save(blcgoepAggDO);
		if (BlcgoepAggDO_arr == null) {
			throw new BizException("更新记账挂起数据失败");
		}

		return id_orsrvLst;
	}

		/**
	 * 触发门诊收费事件
	 * 
	 * @param patDO
	 * @param regInfo
	 * @param pvDO
	 * @throws BizException
	 */
	private void invokeOepSettlementEvent(BlcgoepAggDO[] BlcgoepAggDO_arr, BlpaypatoepAggDO blpaypatoepAggDO, BlStOepDO blStOepDO1, BlincoepAggDO blincoepAggDOArrx1, String func_source)
			throws BizException {
		BlEventInfoDTO blEventInfoDTO = new BlEventInfoDTO();

		List<String> id_entLst = new ArrayList<String>();
		String id_entCond = "";
		for (BlcgoepAggDO blcgoepAggDO : BlcgoepAggDO_arr) {
			BlCgItmOepDO[] BlCgItmOepDOArr = blcgoepAggDO.getBlCgItmOepDO();
			for (BlCgItmOepDO blCgItmOepDO : BlCgItmOepDOArr) {
				if (!id_entLst.contains(blCgItmOepDO.getId_ent())) {
					id_entCond = id_entCond + ",'" + blCgItmOepDO.getId_ent() + "'";
				} else {
					id_entLst.add(blCgItmOepDO.getId_ent());
				}

			}
		}
		if (id_entCond.length() > 1) {
			id_entCond = id_entCond.substring(1);
		}

		// 组装事件需要的数据
		PatDO patDO = new PatDO();
		IPativisitRService iPativisitRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] patiVisitDO = iPativisitRService.find(" id_ent in (" + id_entCond + ")", "", FBoolean.FALSE);
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
		blEventInfoDTO.setFunc_Status(func_source);

		// 2、触发事件
		BusinessEvent oepSettlementEvent = new BusinessEvent(IBlEventConst.EVENT_SOURCE_BL_OEP_SETTLEMENT, IEventType.TYPE_INSERT_AFTER, blEventInfoDTO);
		EventDispatcher.fireEvent(oepSettlementEvent);

	}
	/**
	 * 已经收付款后,若打发票，则需要修改发票表的票据号，票据包，开票人等信息。
	 * 
	 * @param blincoepAggDOArr
	 *            发票表
	 * @param incno
	 *            发票号码
	 * @param Code_incpkg
	 *            票据包
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @return 保存后的发票表
	 * @throws BizException
	 */
	private BlincoepAggDO[] updateIncIncno(BlincoepAggDO[] blincoepAggDOArr,OperatorInfoDTO operatorInfoDTO) throws BizException {
		IBLInvoiceService invoiceService=ServiceFinder.find(IBLInvoiceService.class);
		//发票领用信息
		BlIncissOepDTO incissOepDto=invoiceService.useReceipt(operatorInfoDTO.getId_emp(),IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE);
		IBlincoepCudService iBlincoepCudService = ServiceFinder.find(IBlincoepCudService.class);
		for (BlincoepAggDO blincoepAggDO : blincoepAggDOArr) {
			blincoepAggDO.getParentDO().setFg_print(FBoolean.TRUE);
			if (blincoepAggDO.getParentDO().getIncno() == null) {
				blincoepAggDO.getParentDO().setIncno(incissOepDto.getIncno_cur());
				blincoepAggDO.getParentDO().setCode_incpkg(incissOepDto.getCode_incpkg());
			}
			// 医生站接诊挂号产生的数据没有这些信息
			if (blincoepAggDO.getParentDO().getId_grp() == null || blincoepAggDO.getParentDO().getId_grp().length() == 0) {
				blincoepAggDO.getParentDO().setId_grp(operatorInfoDTO.getId_grp());
			}
			if (blincoepAggDO.getParentDO().getId_org() == null || blincoepAggDO.getParentDO().getId_org().length() == 0) {
				blincoepAggDO.getParentDO().setId_org(operatorInfoDTO.getId_org());
			}

			blincoepAggDO.getParentDO().setId_emp_canc(null);
			blincoepAggDO.getParentDO().setId_emp_inc(operatorInfoDTO.getId_emp());
			blincoepAggDO.getParentDO().setTimes_prn(1);

			blincoepAggDO.getParentDO().setStatus(DOStatus.UPDATED);
		}
		BlincoepAggDO[] blincoepAggDOs = iBlincoepCudService.save(blincoepAggDOArr);
		return blincoepAggDOs;
	}

	/**
	 * 获得患者收付款的支付方式
	 * 
	 * @param blpaypatoepAggDO
	 *            患者收付款明细
	 * @param id_stoep
	 *            结算号
	 * @return 患者收付款的支付方式
	 * @throws BizException
	 */
	private String getPm_tp(BlpaypatoepAggDO blpaypatoepAggDO, String id_stoep) throws BizException {
		// 4.查询支付方式。
		String pay_way = "";
		for (BlPayItmPatOepDO blPayItmPatOepDO : blpaypatoepAggDO.getBlPayItmPatOepDO()) {
			pay_way = pay_way + "," + getPm_way(blPayItmPatOepDO.getSd_pm());// 收款方式
		}
		pay_way = pay_way.substring(1);
		String id_stoeps_incoep = "'" + id_stoep + "'";
		if (isPayByMedInsur(id_stoeps_incoep).booleanValue()) {
			pay_way = pay_way + ",医保基金";
		}
		return pay_way;
	}
	
	/**
	 * 计算下张票号
	 * 
	 * @param curNo
	 *            当前票号
	 * @return 下张票号
	 * @throws BizException
	 */
	private String computeNextInvoiceNo(String curNo) throws BizException {
		GetCodeByCustomization code_ins = new GetCodeByCustomization();
		return code_ins.computeNextInvoiceNo(curNo);
	}	
	/**
	 * 查询是否有医保基金支付
	 * 
	 * @param id_stoepQueryStr
	 *            sql in 里面的结算主键，格式：’001’，‘001’
	 * @return FBoolean.FALSE：没有医保基金支付；FBoolean.TRUE：有医保基金支付
	 * @throws BizException
	 */
	private FBoolean isPayByMedInsur(String id_stoepQueryStr) throws BizException {
		StringBuffer sqlb = new StringBuffer();
		sqlb.append("  select a.*");
		sqlb.append("    from bl_st_oep a");
		sqlb.append("   inner join bl_prop_oep b");
		sqlb.append("      on a.id_stoep = b.id_stoep");
		sqlb.append("   inner join bl_prop_ar_oep c");
		sqlb.append("      on b.id_propoep = c.id_propoep");
		sqlb.append("   where c.amt_hp > 0");
		sqlb.append("   and a.id_stoep in (?)");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_stoepQueryStr);
		DAFacade dafacade = new DAFacade();
		List<BlStOepDO> blStOepDOLst = (List<BlStOepDO>) dafacade.execQuery(sqlb.toString(), sqlp, new BeanListHandler(BlStOepDO.class));
		if (blStOepDOLst == null || blStOepDOLst.size() == 0) {
			return FBoolean.FALSE;
		} else {
			return FBoolean.FALSE;
		}
	}
	
	/**
	 * 获得对应的支付方式
	 * 
	 * @param sd_pm
	 *            支付方式代码
	 * @return 支付方式名称
	 */
	private String getPm_way(String sd_pm) {
		String pd_way = "";
		switch (sd_pm) {
		case IBdPripmCodeConst.CODE_PRI_PM_CASH:
			pd_way = "现金";
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_CREDIT:
			pd_way = "信用卡";
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_CHECK:
			pd_way = "支票";
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_DEAFT:
			pd_way = "汇票";
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_PAY:
			pd_way = "预交金";
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_COUPON:
			pd_way = "优惠券";
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_SPECIALFUNDS:
			pd_way = "专用款";
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_MISPOS:
			pd_way = "MISPOS";
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_COMPANY:
			pd_way = "合同单位";
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_ACCOUNT:
			pd_way = "关联账户";
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_ALIPAY:
			pd_way = "支付宝";
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_WECHAT:
			pd_way = "微信";
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT:
			pd_way = "医保个人账户";
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_INSUR:
			pd_way = "医保基金";
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_MONEYDEDUCTION:
			pd_way = "金额减免";
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_SRVDEDUCTION:
			pd_way = "项目减免";
			break;
		default:
			break;
		}
		return pd_way;
	}
	
	/**
	 * 触发检查申请信息服务事件
	 * 
	 * @throws BizException
	 * */
	private void invokeOepCiOrderEvent(List<String> id_orsrvLst) throws BizException {
		String[] objArr = id_orsrvLst.toArray(new String[] {});
		BlOepSrvEventInfoDTO blOepSrvEventInfoDTO = new BlOepSrvEventInfoDTO();
		blOepSrvEventInfoDTO.setOper_type(BookRtnDirectEnum.CHARGES);
		blOepSrvEventInfoDTO.setIdSrvArr(objArr);
		BusinessEvent oepSettlementEvent = new BusinessEvent(IBlEventConst.EVENT_IE_BL_OEP_CHARGE, IEventType.TYPE_UPDATE_AFTER, new BlOepSrvEventInfoDTO[] { blOepSrvEventInfoDTO });
		EventDispatcher.fireEvent(oepSettlementEvent);
	}
	
	/**
	 * 判断是否预住院转门诊费用结算
	 * @param blcgoepAggDOArr
	 * @return
	 * @throws BizException
	 */
	private boolean ifPreIp(String entId) throws BizException {
		
		if(StringUtil.isEmpty(entId))
			return false;
		
		DAFacade daf = new DAFacade();
		PatiVisitDO entDO = (PatiVisitDO)daf.findByPK(PatiVisitDO.class, entId);
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals( entDO.getCode_entp())){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 更新锁定额
	 * @param entId
	 * @param blStOepDO
	 * @throws BizException
	 */
	private void updateEntAcc(String entId,BlStOepDO blStOepDO) throws BizException {
		
		IEnOutCmdService enCmdService = ServiceFinder.find(IEnOutCmdService.class);
		enCmdService.consume(entId, blStOepDO.getAmt_ratio().multiply(-1));
	}
}

