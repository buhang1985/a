package iih.bl.cg.service.s;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.SVCheckUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.pp.bdcpnca.d.BdCpncaDO;
import iih.bd.pp.bdcpnca.d.BdcpncaAggDO;
import iih.bd.pp.bdcpnca.i.IBdcpncaRService;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.api.d.OpPayParam;
import iih.bl.cg.api.d.OpPayReturn;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.desc.BlCgOepDODesc;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.bp.DoOepFgAccAmtAcc;
import iih.bl.cg.bp.DoOepFgFree;
import iih.bl.cg.bp.GetBlCgItmOepMap;
import iih.bl.cg.bp.GetBlCgOepAggByItmsQuery;
import iih.bl.cg.bp.GetBlPsnDocName;
import iih.bl.cg.bp.GetBlStOepVsIncSql;
import iih.bl.cg.bp.GetInvoiceType;
import iih.bl.cg.bp.HandlerCpnOepBp;
import iih.bl.cg.bp.SetBlOrderAppendBillParamDTOPricing;
import iih.bl.cg.bp.UpdateBlOepPriceIdent;
import iih.bl.cg.bp.oep.OpFreeAmtHandleBP;
import iih.bl.cg.bp.self.GetIdCgOepByIdStoep;
import iih.bl.cg.dto.d.BlCgItmOepMapDTO;
import iih.bl.cg.dto.d.BlcgOepAggDTO;
import iih.bl.cg.dto.d.OpCharge4EsDTO;
import iih.bl.cg.ep.EntHpEP;
import iih.bl.cg.ep.OepCgEP;
import iih.bl.cg.event.OpChargeEvent;
import iih.bl.cg.i.IBlCgCmdService;
import iih.bl.cg.s.bp.GetMedWindowsBP;
import iih.bl.cg.s.bp.GetPayCodeBP;
import iih.bl.cg.s.bp.op.BlCgReprintIncBP;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.Bl_IdorAndIdorsrvDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.cg.service.s.bp.BLCancelSettlementImplBp;
import iih.bl.cg.service.s.bp.BLCiOrderToBlCgServiceImplBp;
import iih.bl.cg.service.s.bp.FilterHpDtosBP;
import iih.bl.cg.service.s.bp.PriceSettleBP;
import iih.bl.cg.service.s.bp.RePrintIncBp;
import iih.bl.cg.service.s.bp.SetCiOrderToPriceBP;
import iih.bl.cg.service.s.bp.SetSrvFactorBP;
import iih.bl.cg.service.s.bp.SettlementPayBp;
import iih.bl.cg.service.s.event.BlOpPayEvent;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.comm.IBlFlowKeyConst;
import iih.bl.comm.log.BLBizLogger;
import iih.bl.comm.s.bp.BlThirdPayBP;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.comm.util.BlDataUtil;
import iih.bl.inc.blcpnin.d.BlCpnDO;
import iih.bl.inc.blcpnin.i.IBlCpnDORService;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinccanc.i.IBlinccancCudService;
import iih.bl.inc.blincoep.d.BlIncCgItmOep;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlStIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.d.desc.BlIncOepDODesc;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.blincquerydto.d.BIncSumAmtInfoDTO;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceHeadTailDTO;
import iih.bl.inc.dto.blincprint.d.BlIncPrintDTO;
import iih.bl.inc.dto.d.RePrintInvoiceInfoDTO;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.bl.inc.service.i.IBlincQryService;
import iih.bl.params.BlParams;
import iih.bl.prop.blproparoep.d.BlPropArItmOepDO;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.prop.service.i.IBLPropMaintainService;
import iih.bl.pub.IBlFunCodeConst;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.d.PayDirectEnum;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepCudService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.blstoep.d.desc.BlStOepDODesc;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.bl.st.dto.blpayoep.d.BlPayOepRefundEventDTO;
import iih.bl.st.service.i.IBLStQueService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.ciprn.i.ICiprintExtService;
import iih.ci.ord.dto.orsrvguide.d.OrSrvGuideDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.OepSettleRtnValDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.facade.MiFacade;
import iih.mi.itf2.util.MiParamUtil;
import iih.mp.dg.dto.d.OpDgRtnAmountDTO;
import iih.mp.dg.i.IMpDgOutService;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 门诊收费：划价、取消划价、结算
 * 
 * @author tcy
 *
 */
@Service(serviceInterfaces = { IBLCiOrderToBlCgService.class }, binding = Binding.JSONRPC)
public class IBLCiOrderToBlCgServiceImpl implements IBLCiOrderToBlCgService {

	/**
	 * 供就诊领域分诊台挂号使用（划价，扣预交金）
	 * 
	 * @param appendBillParamDTOs
	 *            待处理的费用明细
	 * @param operatorInfoDTO
	 *            操作人员信息
	 * @param PrintInvocie
	 *            是否打印发票
	 * @return 划价结果（划价后的BlCgOepAgg，处方RecipeDTO）
	 * @throws BizException
	 */
	public BlCgOepAggDTO pricingFromPrepay(BlOrderAppendBillParamDTO[] appendBillParamDTOs, OperatorInfoDTO operatorInfoDTO, FBoolean PrintInvocie) throws BizException {
		// 1.划价
		BlCgOepAggDTO blCgOepAggDTO = SetCiOrderToPrice(appendBillParamDTOs, operatorInfoDTO, PrintInvocie);

		// 2.计算预交金,修改bl_cg_itm_oep.fg_acc和bl_cg_itm_oep.amt_acc
		FDouble prepayAmount = new FDouble(0);
		FArrayList blcgoepAggDOLst = blCgOepAggDTO.getBlcgoepAggDO();
		BlcgoepAggDO[] blcgoepAggDOs = (BlcgoepAggDO[]) blcgoepAggDOLst.toArray(new BlcgoepAggDO[0]);
		for (BlcgoepAggDO blcgoepAggDO : blcgoepAggDOs) {
			BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDO.getBlCgItmOepDO();
			blcgoepAggDO.getParentDO().setStatus(DOStatus.UPDATED);
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOs) {
				blCgItmOepDO.setFg_acc(FBoolean.TRUE);
				blCgItmOepDO.setAmt_acc(blCgItmOepDO.getAmt_ratio());
				blCgItmOepDO.setStatus(DOStatus.UPDATED);
				prepayAmount = prepayAmount.add(blCgItmOepDO.getAmt_ratio().multiply(blcgoepAggDO.getParentDO().getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			}
		}
		IBlcgoepCudService iBlcgoepCudService = ServiceFinder.find(IBlcgoepCudService.class);
		blcgoepAggDOs = iBlcgoepCudService.save(blcgoepAggDOs);
		if (null == blcgoepAggDOs) {
			throw new BizException("修改门诊记账信息失败");
		}

		// 3.回写
		FArrayList blcgoepAggDOList = new FArrayList();
		for (BlcgoepAggDO blcgoepAggDO1 : blcgoepAggDOs) {
			blcgoepAggDOList.add(blcgoepAggDO1);
		}
		blCgOepAggDTO.setBlcgoepAggDO(blcgoepAggDOList);

		// 4.扣预交金
		updatePatiAccPreAuthor(blcgoepAggDOs[0].getParentDO().getId_pat(), prepayAmount);
		return blCgOepAggDTO;
	}

	/**
	 * 修改预交金消费金额
	 * 
	 * @param id_pat
	 *            患者ID
	 * @param acc_lock
	 *            预交金锁定金额
	 * @throws BizException
	 */
	private void updatePatiAccPreAuthor(String id_pat, FDouble acc_lock) throws BizException {
		IPatAccServiceExt patAccImpls = (IPatAccServiceExt) ServiceFinder.find(IPatAccServiceExt.class);
		// 计算门诊账户余额：调用门诊账户接口
		FDouble prepayAmount = patAccImpls.GetOutpPrepaymentAmount(id_pat);
		// 与标准金额比较，当预交金余额不足时，需要进行示范允许后付费的判断
		if (prepayAmount.compareTo(acc_lock) < 0) {
			throw new BizException("门诊账户预交金余额不足,不支持后付费！\r\n本次执行金额：" + acc_lock.toString() + "\r\n差额：" + acc_lock.sub(prepayAmount).setScale(-2, BigDecimal.ROUND_HALF_UP).toString());
		}
		// 患者账户授权， 更新预交金余额 ：调用门诊账户接口
		PiPatAccDO piPatAccDO = patAccImpls.PatiAccPreAuthor(id_pat, acc_lock);
		if (null == piPatAccDO) {
			throw new BizException("保存患者预交金信息失败");
		}
	}

	/**
	 * 仅仅计算价格，如果是物品，强制不走预留
	 * 
	 * @param appendBillParamDTOs
	 * @return
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] computePrice(BlOrderAppendBillParamDTO[] appendBillParamDTOs) throws BizException {

		for (BlOrderAppendBillParamDTO dto : appendBillParamDTOs) {
			if (dto.getFg_mm() != null && dto.getFg_mm().booleanValue()) {
				dto.setFg_reserveMaterials(FBoolean.FALSE);// 单独查询价格时，不预留
			}
			// 判断如果数据为手工记账则将金额赋值到对应的金额字段
			if ("1".equals(dto.getEu_blmd())) {
				dto.setRatio_pripat(FDouble.ONE_DBL);
				dto.setPrice(dto.getPri() == null ? FDouble.ZERO_DBL : dto.getPri());
				dto.setPrice_ratio(dto.getPrice());
				dto.setAmt(dto.getPrice().multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				dto.setAmt_ratio(dto.getPrice_ratio().multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				dto.setAmt_std(dto.getPrice().multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				dto.setAmt_hp(new FDouble(0));
				dto.setAmt_pat(dto.getAmt_ratio());
				dto.setPri_ratio(dto.getRatio_pripat());
				//dto.setRatio_pripat(dto.getPri_ratio());
			}
		}
		// 判断当前划价数据是否是医保的数据并执行医保重复收费项目操作
		FilterHpDtosBP fhpDtosBP=new FilterHpDtosBP();
		fhpDtosBP.exec(appendBillParamDTOs);
		SetBlOrderAppendBillParamDTOPricing GetMmToBlOrderAppendBillParamDTOIns = new SetBlOrderAppendBillParamDTOPricing();
		appendBillParamDTOs = GetMmToBlOrderAppendBillParamDTOIns.SetBlOrderAppendBillParamDTOPricing(appendBillParamDTOs);
		List<BlOrderAppendBillParamDTO> lst = new ArrayList<BlOrderAppendBillParamDTO>();
		for (BlOrderAppendBillParamDTO dto : appendBillParamDTOs) {
			if (dto.getFg_mm() != null && dto.getFg_mm().booleanValue()) {
				dto.setFg_reserveMaterials(FBoolean.TRUE);// 还原回去
			}
			lst.add(dto);
		}
		return lst.toArray(new BlOrderAppendBillParamDTO[lst.size()]);
	}

	/**
	 * 1.门诊新划价(2017-1-18重构）：存入门诊记账主表和明细表，结算表，分摊表,发票表,返回一主表多子表，如果全是挂起的数据，则可使用划价
	 * 主表中包含： 就诊，发票1|就诊，发票2|……|就诊，发票N； 结算号，发票开立人1|结算号，发票开立人2|……|结算号，发票开立人N；
	 * 结算号，发票1|结算号，发票2|……|结算号，发票N； 返回：划价后的BlCgOepAgg，处方RecipeDTO
	 */
	public BlCgOepAggDTO SetCiOrderToPrice(BlOrderAppendBillParamDTO[] appendBillParamDTOs, OperatorInfoDTO operatorInfoDTO, FBoolean PrintInvocie) throws BizException {
		SetCiOrderToPriceBP scotpBP = new SetCiOrderToPriceBP();
		return scotpBP.exec(appendBillParamDTOs, operatorInfoDTO, PrintInvocie);
	}

	/**
	 * 保存分摊的数据
	 * 
	 * @param blPropOepDOArr
	 * @param blproparoepAggDOArr
	 */
	private void saveProp(BlPropOepDO[] blPropOepDOArr, BlproparoepAggDO[] blproparoepAggDOArr) throws BizException {
		IBLPropMaintainService iBLPropMaintainService = ServiceFinder.find(IBLPropMaintainService.class);
		iBLPropMaintainService.saveOepProp(blPropOepDOArr, blproparoepAggDOArr);
	}

	/**
	 * 更新记账明细表对应的医保金额信息
	 * 
	 * @param blPropOepDOArr
	 *            分摊1
	 * @param blproparoepAggDOArr
	 *            分摊2
	 * @param blcgoepAggDO
	 *            记账明细表
	 * @throws BizException
	 */
	private void updateCgAmtHpByProp(BlPropOepDO[] blPropOepDOArr, BlproparoepAggDO[] blproparoepAggDOArr, BlcgoepAggDO[] blcgoepAggDO) throws BizException {
		List<BlPropArItmOepDO> blPropArItmOepDOList = new ArrayList<BlPropArItmOepDO>();
		String code_mm = "";
		IMeterialMDORService iMeterialMDORService = ServiceFinder.find(IMeterialMDORService.class);

		// 1.获得分摊后的明细
//		for (BlproparoepAggDO blproparoepAggDO : blproparoepAggDOArr) {
//			BlPropArItmOepDO[] blPropArItmOepDOArr = blproparoepAggDO.getBlPropArItmOepDO();
//			for (BlPropArItmOepDO blPropArItmOepDO : blPropArItmOepDOArr) {
//				blPropArItmOepDOList.add(blPropArItmOepDO);
//			}
//		}
		// 2.用分摊后价格回写记账表对应的价格
		for (BlcgoepAggDO blcgoepAggDO1 : blcgoepAggDO) {
			BlCgOepDO parentDo = blcgoepAggDO1.getParentDO();
			parentDo.setStatus(DOStatus.UPDATED);
			// 如果更新子DO的字段，必须同时保证主DO的状态为Update
			BlCgItmOepDO[] blCgItmOepDOArr = blcgoepAggDO1.getBlCgItmOepDO();
			for (BlCgItmOepDO blCgItmOepDO1 : blCgItmOepDOArr) {
				for (BlPropArItmOepDO blPropArItmOepDO : blPropArItmOepDOList) {
					if (!blCgItmOepDO1.getFg_mm().booleanValue()) {
						if (blCgItmOepDO1.getCode_srv().equals(blPropArItmOepDO.getCode()) && blCgItmOepDO1.getAmt().equals(blPropArItmOepDO.getAmt_hp().add(blPropArItmOepDO.getAmt_pat()))) {
							// 病人支付=病人比例金额 - 医保支付金额
							blCgItmOepDO1.setAmt(blCgItmOepDO1.getAmt_ratio());
							// 分摊返回的：医保支付金额
							blCgItmOepDO1.setAmt_hp(blPropArItmOepDO.getAmt_hp());
							// 分摊返回的：医保_个人支付
							blCgItmOepDO1.setAmt_pat(blPropArItmOepDO.getAmt_pat());
							// 医保是否上传到了医保计划，即是否是医保结算
							blCgItmOepDO1.setFg_hp(FBoolean.TRUE);
							blCgItmOepDO1.setStatus(DOStatus.UPDATED);
						}
					} else if (blCgItmOepDO1.getFg_mm().booleanValue()) {
						if (blCgItmOepDO1.getCode_mm().equals(blPropArItmOepDO.getCode()) && blCgItmOepDO1.getAmt().equals(blPropArItmOepDO.getAmt_hp().add(blPropArItmOepDO.getAmt_pat()))) {
							// 病人支付=病人比例金额 - 医保支付金额
							blCgItmOepDO1.setAmt(blCgItmOepDO1.getAmt_ratio());
							// 分摊返回的：医保支付金额
							blCgItmOepDO1.setAmt_hp(blPropArItmOepDO.getAmt_hp());
							// 分摊返回的：医保_个人支付
							blCgItmOepDO1.setAmt_pat(blPropArItmOepDO.getAmt_pat());
							// 医保是否上传到了医保计划，即是否是医保结算
							blCgItmOepDO1.setFg_hp(FBoolean.TRUE);
							blCgItmOepDO1.setStatus(DOStatus.UPDATED);
						}
					}
				}
			}
		}
		// 3.保存记账信息
		IBlcgoepCudService iBlcgCudService = ServiceFinder.find(IBlcgoepCudService.class);
		BlcgoepAggDO[] blcgoepAggDOArr = iBlcgCudService.save(blcgoepAggDO);
		if (blcgoepAggDOArr == null || blcgoepAggDOArr.length == 0) {
			throw new BizException("更新记账明细对应的医保金额失败！");
		}
	}

	/**
	 * 门诊结算：含分摊的付款
	 * 
	 * @param blPropOepDOArr
	 *            分摊1
	 * @param blproparoepAggDOArr
	 *            分摊1
	 * @param blcgoepAggDO
	 *            记账信息
	 * @param blpaypatoepAggDO
	 *            支付信息
	 * @param IsDrugApplication
	 *            是否药品
	 * @param PrintOnlyOneInvoice
	 *            一次结算，打印一张发票还是多张发票
	 * @param PrintInvoice
	 *            是否打印发票
	 * @return 发票内容
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] SettlementInsurPayment(OepSettleRtnValDTO oepSettleRtnValDto,BlPropOepDO[] blPropOepDOArr, BlproparoepAggDO[] blproparoepAggDOArr, BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO, FBoolean IsDrugApplication, FBoolean PrintInvoice, FBoolean IsTransferPrepay) throws BizException {

		// 1.保存分摊信息，并用分摊汇总信息更新bl_st_oep和bl_cg_oep表
		savePropAndWriteBackStInc(oepSettleRtnValDto,blPropOepDOArr, blproparoepAggDOArr);
		// 2.修改cg表中的amt,amt_pat,amt_hp
		updateCgAmtHpByProp(blPropOepDOArr, blproparoepAggDOArr, blcgoepAggDO);
		// 3.付款
		//BlIncItmVsTypeDTO[] blIncItmVsTypeDTOs = SettlementPayment(blcgoepAggDO, blpaypatoepAggDO, IsDrugApplication, PrintInvoice, IsTransferPrepay);

		SettlementPayBp bp = new SettlementPayBp();
		return bp.exec(blcgoepAggDO, blpaypatoepAggDO, IsDrugApplication, PrintInvoice, IsTransferPrepay);
		
		//return blIncItmVsTypeDTOs;
	}

	/**
	 * 保存分摊信息，并用分摊汇总信息更新bl_st_oep和bl_cg_oep表
	 * 
	 * @param blPropOepDOArr
	 *            分摊1
	 * @param blproparoepAggDOArr
	 *            分摊2
	 * @throws BizException
	 */
	private void savePropAndWriteBackStInc(OepSettleRtnValDTO oepSettleRtnValDto,BlPropOepDO[] blPropOepDOArr, BlproparoepAggDO[] blproparoepAggDOArr) throws BizException {
		FDouble amt_hp = new FDouble(0);
		FDouble amt_pat = new FDouble(0);
		FDouble amt = new FDouble(0);
		if (blPropOepDOArr != null && blPropOepDOArr.length != 0 && blproparoepAggDOArr != null && blproparoepAggDOArr.length != 0) {
			for (BlproparoepAggDO blproparoepAggDO : blproparoepAggDOArr) {
				blproparoepAggDO.getParentDO().setId_grp(blPropOepDOArr[0].getId_grp());
				blproparoepAggDO.getParentDO().setId_org(blPropOepDOArr[0].getId_org());
			}
		}
		// 1.保存分摊
		saveProp(blPropOepDOArr, blproparoepAggDOArr);

		String patId = null;
		// 2.回写(amt_hp,amt_pat,amt)
		IBlstoepRService iBlstoepRService = ServiceFinder.find(IBlstoepRService.class);
		IBlstoepCudService iBlstoepCudService = ServiceFinder.find(IBlstoepCudService.class);
		/*IBlincoepRService iBlincoepRService = ServiceFinder.find(IBlincoepRService.class);
		IBlincoepCudService iBlincoepCudService = ServiceFinder.find(IBlincoepCudService.class);*/
		for (BlPropOepDO blPropOepDO : blPropOepDOArr) {
			BlStOepDO[] blStOepDO = iBlstoepRService.find(BlStOepDODesc.TABLE_ALIAS_NAME + ".Id_stoep='" + blPropOepDO.getId_stoep() + "' ", "", FBoolean.FALSE);
			//BlincoepAggDO[] blincoepAggDOArr = iBlincoepRService.find(BlIncOepDODesc.TABLE_ALIAS_NAME + ".Id_stoep='" + blPropOepDO.getId_stoep() + "' ", "", FBoolean.FALSE);
			patId = blStOepDO[0].getId_pat();
			if (blproparoepAggDOArr.length == 1) {
				BlPropArOepDO blPropAroepDo = blproparoepAggDOArr[0].getParentDO();
				// 医保费用
				amt_hp = blPropAroepDo.getAmt_hp();
				// 自费
				amt_pat = blPropAroepDo.getAmt_cash().add(blPropAroepDo.getAmt_psnacc());
				// 实收金额
				amt = blStOepDO[0].getAmt_ratio().sub(amt_hp);
				// 2.1回写bl_st_oep(amt_hp,amt_pat,amt)
				blStOepDO[0].setAmt_hp(amt_hp);
				blStOepDO[0].setAmt_pat(amt_pat);
				blStOepDO[0].setAmt(amt);
				blStOepDO[0].setStatus(DOStatus.UPDATED);
				BlStOepDO[] blStOepDOArr1 = iBlstoepCudService.save(blStOepDO);
				if (blStOepDOArr1 == null || blStOepDOArr1.length == 0) {
					throw new BizException("更新结算表医保金额失败");
				}
				
				// 2.2回写bl_inc_oep
				/*blincoepAggDOArr[0].getParentDO().setAmt_hp(amt_hp);
				blincoepAggDOArr[0].getParentDO().setAmt_pat(amt_pat);
				blincoepAggDOArr[0].getParentDO().setAmt(amt);
				blincoepAggDOArr[0].getParentDO().setStatus(DOStatus.UPDATED);
				BlincoepAggDO[] blincoepAggDOArr1 = iBlincoepCudService.save(blincoepAggDOArr);
				if (blincoepAggDOArr1 == null || blincoepAggDOArr1.length == 0) {
					throw new BizException("修改门诊发票表医保费用失败");
				}*/
			}
		}

		
		//保存医保分摊信息
//		InsureContext insureContext=new InsureContext();
//		insureContext.setIdHp(blproparoepAggDOArr[0].getParentDO().getId_hp());
//		InsureFacade facade=new InsureFacade(insureContext);
//		HisPropertyRefHpDTO propertyRefHpDto=new HisPropertyRefHpDTO();
//		propertyRefHpDto.setId_ref(blproparoepAggDOArr[0].getParentDO().getId_proparoep());
//		propertyRefHpDto.setId_ref_prop(blproparoepAggDOArr[0].getParentDO().getId_propoep());
//		propertyRefHpDto.setId_ref_preflow(blPropOepDOArr[0].getId_stoep());
//		propertyRefHpDto.setId_pat(patId);
//		facade.savePayPropDataOep(oepSettleRtnValDto, propertyRefHpDto);
		
		//医保接口调用接口类型
		int miBd0001= MiParamUtil.MIBD0001();
		if(miBd0001==1){
			//保存医保分摊信息
			InsureContext insureContext=new InsureContext();
			insureContext.setIdHp(blproparoepAggDOArr[0].getParentDO().getId_hp());
			InsureFacade facade=new InsureFacade(insureContext);
			HisPropertyRefHpDTO propertyRefHpDto=new HisPropertyRefHpDTO();
			propertyRefHpDto.setId_ref(blproparoepAggDOArr[0].getParentDO().getId_proparoep());
			propertyRefHpDto.setId_ref_prop(blproparoepAggDOArr[0].getParentDO().getId_propoep());
			propertyRefHpDto.setId_ref_preflow(blPropOepDOArr[0].getId_stoep());
			propertyRefHpDto.setId_pat(patId);
			facade.savePayPropDataOep(oepSettleRtnValDto, propertyRefHpDto);
		}else{
			MiContext miContext = new MiContext();
			miContext.setIdHp(blproparoepAggDOArr[0].getParentDO().getId_hp());
			MiFacade miFacade = new MiFacade(miContext);
			
			HisPropertyRefHpDTO propertyRefHpDto=new HisPropertyRefHpDTO();
			propertyRefHpDto.setId_ref(blproparoepAggDOArr[0].getParentDO().getId_proparoep());
			propertyRefHpDto.setId_ref_prop(blproparoepAggDOArr[0].getParentDO().getId_propoep());
			propertyRefHpDto.setId_ref_preflow(blPropOepDOArr[0].getId_stoep());
			propertyRefHpDto.setId_pat(patId);
			miFacade.savePayPropDataOep(oepSettleRtnValDto, propertyRefHpDto);	
		}
		
//		//医保接口调用接口类型
//		int miBd0001= MiParamUtil.MIBD0001();
//		if(miBd0001==1){
//			//保存医保分摊信息
//			InsureContext insureContext=new InsureContext();
//			insureContext.setIdHp(blproparoepAggDOArr[0].getParentDO().getId_hp());
//			InsureFacade facade=new InsureFacade(insureContext);
//			HisPropertyRefHpDTO propertyRefHpDto=new HisPropertyRefHpDTO();
//			propertyRefHpDto.setId_ref(blproparoepAggDOArr[0].getParentDO().getId_proparoep());
//			propertyRefHpDto.setId_ref_prop(blproparoepAggDOArr[0].getParentDO().getId_propoep());
//			propertyRefHpDto.setId_ref_preflow(blPropOepDOArr[0].getId_stoep());
//			propertyRefHpDto.setId_pat(patId);
//			facade.savePayPropDataOep(oepSettleRtnValDto, propertyRefHpDto);
//		}else{
//			MiContext miContext = new MiContext();
//			miContext.setIdHp(blproparoepAggDOArr[0].getParentDO().getId_hp());
//			MiFacade miFacade = new MiFacade(miContext);
//			
//			HisPropertyRefHpDTO propertyRefHpDto=new HisPropertyRefHpDTO();
//			propertyRefHpDto.setId_ref(blproparoepAggDOArr[0].getParentDO().getId_proparoep());
//			propertyRefHpDto.setId_ref_prop(blproparoepAggDOArr[0].getParentDO().getId_propoep());
//			propertyRefHpDto.setId_ref_preflow(blPropOepDOArr[0].getId_stoep());
//			propertyRefHpDto.setId_pat(patId);
//			miFacade.savePayPropDataOep(oepSettleRtnValDto, propertyRefHpDto);	
//		}
	}

	/**
	 * 门诊结算（特殊病）：含分摊的付款，单没有分摊明细
	 * 
	 * @param blPropOepDOArr
	 *            分摊1
	 * @param blproparoepAggDOArr
	 *            分摊1
	 * @param blcgoepAggDO
	 *            记账信息
	 * @param blpaypatoepAggDO
	 *            支付信息
	 * @param IsDrugApplication
	 *            是否药品
	 * @param PrintOnlyOneInvoice
	 *            一次结算，打印一张发票还是多张发票
	 * @param PrintInvoice
	 *            是否打印发票
	 * @return 发票内容
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] SettlementInsurPaymentNoItmProp(BlPropOepDO[] blPropOepDOArr, BlproparoepAggDO[] blproparoepAggDOArr, BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO, FBoolean IsDrugApplication, FBoolean PrintInvoice, FBoolean IsTransferPrepay) throws BizException {
		// 1.保存分摊信息，并用分摊汇总信息更新bl_st_oep和bl_cg_oep表
		savePropAndWriteBackStInc(null,blPropOepDOArr, blproparoepAggDOArr);

		// 2.付款
		BlIncItmVsTypeDTO[] blIncItmVsTypeDTOs = SettlementPayment(blcgoepAggDO, blpaypatoepAggDO, IsDrugApplication, PrintInvoice, IsTransferPrepay);

		return blIncItmVsTypeDTOs;
	}

	/**
	 * 门诊挂号结算：不含分摊的付款,供就诊领域使用，先更新bl_cg_itm_oep,bl_st_oep,bl_inc_oep中id_ent，再结算
	 */
	public BlIncItmVsTypeDTO[] SettlementPayment_Register(String id_ent, BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO, FBoolean IsDrugApplication, FBoolean PrintInvoice) throws BizException {
		// 1.回写划价缺失的id_ent
		UpdateBlOepPriceIdent bp = new UpdateBlOepPriceIdent();
		bp.UpdateBlOepPriceIdent(id_ent, blcgoepAggDO);

		// 2.调用门诊收付款
		BlIncItmVsTypeDTO[] blIncItmVsTypeDTOs = SettlementPayment(blcgoepAggDO, blpaypatoepAggDO, IsDrugApplication, PrintInvoice, new FBoolean(false));
		return blIncItmVsTypeDTOs;
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
	private BlpaypatoepAggDO[] saveBlpaypatoepAggDOsAndDisposalPrepay(BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO, FDateTime fDateTime, FBoolean IsTransferPrepay) throws BizException {
		BlPayPatOepDO blPayPatOepDO = blpaypatoepAggDO.getParentDO();
		blPayPatOepDO.setDt_pay(fDateTime);
		blPayPatOepDO.setStatus(DOStatus.NEW);
		blpaypatoepAggDO.setParentDO(blPayPatOepDO);
		for (BlPayItmPatOepDO blPayItmPatOepDO : blpaypatoepAggDO.getBlPayItmPatOepDO()) {
			blPayItmPatOepDO.setFg_realpay(FBoolean.TRUE);// 真实数据
			// pay_way=pay_way+","+getPm_way(blPayItmPatOepDO.getSd_pm());//收款方式
		}
		// pay_way=pay_way.substring(1);
		Object obj222 = ServiceFinder.find(IBlpaypatoepCudService.class);
		BlpaypatoepAggDO[] blpaypatoepAggDOs = ((IBlpaypatoepCudService) obj222).save(new BlpaypatoepAggDO[] { blpaypatoepAggDO });
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
	private BlStOepDO[] writeBackBlStOepByIdPaypatoep(String id_stoep, String id_paypatoep, OperatorInfoDTO operatorInfoDTO, String id_ent) throws BizException {
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
		blStOepDO.setId_ent(id_ent);
		blStOepDO.setStatus(DOStatus.UPDATED);
		
		//回写医保ID
		String hpId = this.getHpIdFromPropData(blStOepDO.getId_stoep());
		blStOepDO.setId_hp(hpId);
		
		String patCaId = this.getPatCaId(blStOepDO.getId_stoep());
		if(!StringUtil.isEmpty(patCaId)){
			blStOepDO.setId_patca(patCaId);
		}
		
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
				// TODO review by yangyang
				if (blCgItmOepDOs[k].getFg_refund() != null && blCgItmOepDOs[k].getFg_refund().booleanValue())
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
	 * 根据患者是否医保以及持卡结算更新Fg_fundpay和Fg_hp_card字段
	 * 
	 * @param blincoepAggDOArr
	 *            发票agg
	 * @param EntHpDOs
	 *            医保计划
	 * @return
	 * @throws BizException
	 * @author LIM
	 */
	private BlincoepAggDO[] updateIncOepStatus(BlincoepAggDO[] blincoepAggDOArr, EntHpDO[] entHpDOs) throws BizException {
		IBlincoepCudService iBlincoepCudService = ServiceFinder.find(IBlincoepCudService.class);
		for (BlincoepAggDO blincoepAggDO : blincoepAggDOArr) {
			blincoepAggDO.getParentDO().setFg_fundpay(entHpDOs[0].getFg_fundpay());
			blincoepAggDO.getParentDO().setFg_hp_card(entHpDOs[0].getFg_hp_card());
			blincoepAggDO.getParentDO().setStatus(DOStatus.UPDATED);
		}
		BlincoepAggDO[] blincoepAggDOs = iBlincoepCudService.save(blincoepAggDOArr);
		return blincoepAggDOs;
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
	private BlincoepAggDO[] updateIncIncnoAfterPay(BlincoepAggDO[] blincoepAggDOArr, String incno, String Code_incpkg, OperatorInfoDTO operatorInfoDTO) throws BizException {
		IBlincoepCudService iBlincoepCudService = ServiceFinder.find(IBlincoepCudService.class);
		for (BlincoepAggDO blincoepAggDO : blincoepAggDOArr) {

			blincoepAggDO.getParentDO().setFg_print(FBoolean.TRUE);
			if (blincoepAggDO.getParentDO().getIncno() == null) {
				blincoepAggDO.getParentDO().setIncno(incno);
				blincoepAggDO.getParentDO().setCode_incpkg(Code_incpkg);
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
				ICiOrdMaintainService iCiOrdMaintainService = ServiceFinder.find(ICiOrdMaintainService.class);
				FBoolean updateRes = iCiOrdMaintainService.UpdateOrdChargeRelInfo2(id_orsrvs, ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID, ICiDictCodeConst.SD_SU_BL_ACCOUNT, fDateTime, FeeReverseType.NOBLCANCEL);
				if (!updateRes.booleanValue()) {
					throw new BizException("更新医嘱状态失败,本次操作不成功！");
				}
			}
		}

	}

	/**
	 * 2.门诊新收款：返回打印发票的结构
	 * 
	 * @param sum_amt_acc
	 *            :结算中采用预付款已经锁定的金额，若没有，设置为 null
	 * @param blcgoepAggDO
	 *            ：记账信息
	 * @param blpaypatoepAggDO
	 *            ： 收付款信息
	 * @param IsDrugApplication
	 *            : 是否需要药品请领
	 * @param PrintInvocie
	 *            是否需要打印发票，FBoolean.TRUE：打印发票，FBoolean.Fasle:不打印发票，不保存发票相关数据
	 * @param IsTransferPrepay
	 *            是否结存，即找零数据结转到门诊预交金账户
	 * @return
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] SettlementPayment(BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO, FBoolean IsDrugApplication, FBoolean PrintInvoice, FBoolean IsTransferPrepay) throws BizException {
		
		//设置终端类型上下文
		if(blpaypatoepAggDO!=null){
			BlPayPatOepDO payPatDo=blpaypatoepAggDO.getParentDO();
			if(payPatDo!=null){
				Context.get().setAttribute(IBlFlowKeyConst.BL_FLOW_KEY_SD_PTTP, payPatDo.getSd_pttp());
			}
		}
		
		//结转
		Context.get().setAttribute(IBlFlowKeyConst.BL_FLOW_KEY_TRANSFERPREPAY, IsTransferPrepay);
		
		
		FDateTime fDateTime = AppUtils.getServerDateTime();
		String srv_invoicename = "", tempKeys = "", keys = "", values = "", pkg_code = "";
		String[] arr_ent_invoice;

		Map<String, String> ent_invoice = new HashMap<String, String>();
		Map<String, String> ent_invoice_pkgcodem = new HashMap<String, String>();

		String maxInvoiceno = "";
		OperatorInfoDTO operatorInfoDTO = new OperatorInfoDTO();
		operatorInfoDTO.setId_grp(blpaypatoepAggDO.getParentDO().getId_grp());
		operatorInfoDTO.setId_org(blpaypatoepAggDO.getParentDO().getId_org());
		operatorInfoDTO.setId_dep(blpaypatoepAggDO.getParentDO().getId_dep_pay());
		operatorInfoDTO.setId_emp(blpaypatoepAggDO.getParentDO().getId_emp_pay());
		operatorInfoDTO.setId_org_emp(blpaypatoepAggDO.getParentDO().getId_org());
		List<String> id_orsrvLst = new ArrayList<String>();
		List<String> id_orLst = new ArrayList<String>();

		String pay_way = "";// 收款方式，前台打印用
		String id_stoep = "";
		BlIncItmVsTypeDTO[] incOepInfoLst = null;

		PriceSettleBP priceBp = new PriceSettleBP();
		// 0.入口验证
		priceBp.validate_settlementPayment(blcgoepAggDO, blpaypatoepAggDO);

		// 1.防止脏数据，加锁,校验SV
		/*Bl_IdorAndIdorsrvDTO bl_IdorAndIdorsrvDTO = getIdorOfPay(blcgoepAggDO);
		id_orLst = bl_IdorAndIdorsrvDTO.getId_or();
		id_orsrvLst = bl_IdorAndIdorsrvDTO.getId_orsrv();
		if (id_orLst != null && id_orLst.size() > 0) {
			boolean isLock = PKLock.getInstance().addBatchDynamicLock(id_orLst.toArray(new String[0]));
			if (!isLock) {
				throw new BizException("医嘱加锁失败，其他用户正在处理，请重新提取再结算!");
			}
			// 校验ci_or_srv.sv是否发生改变，若改了，则禁止收款（放到此处是为了缩短校验时差）
			validateCiSV(blcgoepAggDO, id_orLst);
		}*/
		this.checkSv(blcgoepAggDO);

		// 2.保存患者收付款.
		// 如果患者采用预交金支付或结存，则处理预交金，且修改门诊预交金账户,修改门诊预交金消费锁定金额
		BlpaypatoepAggDO[] blpaypatoepAggDOs = saveBlpaypatoepAggDOsAndDisposalPrepay(blcgoepAggDO, blpaypatoepAggDO, fDateTime, IsTransferPrepay);

		// 3. 处理减免的业务逻辑
		//2018/04/11 by ly 没啥用
		// (1)查询发票信息 (已经是一次划价，一次结算，一张发票的模式）
		id_stoep = blcgoepAggDO[0].getBlCgItmOepDO()[0].getId_stoep();
		/*for (BlCgItmOepDO cgitmDo : blcgoepAggDO[0].getBlCgItmOepDO()) {
			if (!StringUtil.isEmptyWithTrim(cgitmDo.getId_stoep())) {
				id_stoep = cgitmDo.getId_stoep();
				break;
			}
		}*/
		IBlincoepRService iBlincoepRService = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] blincoepAggDOArrx = iBlincoepRService.find(BlIncOepDODesc.TABLE_ALIAS_NAME + ".id_stoep='" + id_stoep + "'", "", FBoolean.FALSE);
		if (blincoepAggDOArrx == null || blincoepAggDOArrx.length == 0) {
			throw new BizException("门诊结算：查询患者发票信息失败");
		}

		// (2) 处理减免的业务逻辑
		/*DoOepFgFree doOepFgFree = new DoOepFgFree();
		blincoepAggDOArrx[0] = doOepFgFree.DoOep_FgFree_new(blcgoepAggDO, blpaypatoepAggDO, blincoepAggDOArrx[0], DOStatus.UPDATED);
		*/
		
		// 费用减免
		OpFreeAmtHandleBP freeBp = new OpFreeAmtHandleBP();
		freeBp.exec(id_stoep, blcgoepAggDO, blpaypatoepAggDO);
		
		// 4.根据Id_stoep，查询ST表，用收付款主键回写结算表，如果是医生站接诊产生的数据，还需要完善其他数据
		BlStOepDO blStOepDO = writeBackBlStOepByIdPaypatoep(id_stoep, blpaypatoepAggDOs[0].getParentDO().getId_paypatoep(), operatorInfoDTO, blcgoepAggDO[0].getBlCgItmOepDO()[0].getId_ent())[0];

		// //2017-3-1 针对门诊收费程序，收费了才修改ci_or_srv.sd_su_bl 2017-3-10还是放在划价里修改
		// 2017-4-11再次修改
		// 更新医嘱记账信息
		updateCiOrderAfterPay(blcgoepAggDO, fDateTime);
		// 更新医嘱记账状态
		// 定义个list 查询医保计划用 lim
		List<String> id_entList = new ArrayList<String>();
		if (blcgoepAggDO != null) {
			HashMap<String, String> map = new HashMap<String, String>();
			for (BlcgoepAggDO aggdo : blcgoepAggDO) {
				BlCgItmOepDO[] itmOepDOs = aggdo.getBlCgItmOepDO();
				for (BlCgItmOepDO blCgItmOepDO : itmOepDOs) {
					// TODO yangyang review 退费明细不再处理
					if (blCgItmOepDO.getFg_refund() != null && blCgItmOepDO.getFg_refund().booleanValue())
						continue;
					if (blCgItmOepDO.getEu_srctp() == 0) {
						if (map.containsKey(blCgItmOepDO.getId_ent())) {
							if (blCgItmOepDO.getCode_apply() != null && !"".equals(blCgItmOepDO.getCode_apply())) {
								String str = map.get(blCgItmOepDO.getId_ent());
								map.remove(blCgItmOepDO.getId_ent());
								map.put(blCgItmOepDO.getId_ent(), str + ",'" + blCgItmOepDO.getCode_apply() + "'");
							}
						} else {
							if (blCgItmOepDO.getCode_apply() != null && !"".equals(blCgItmOepDO.getCode_apply())) {
								map.put(blCgItmOepDO.getId_ent(), "'" + blCgItmOepDO.getCode_apply() + "'");
								id_entList.add(blCgItmOepDO.getId_ent());
							}
						}
					}
				}
			}
			if (map.size() != 0) {
				ICiprintExtService service = ServiceFinder.find(ICiprintExtService.class);
				service.UpdateCiPrintBlsettled(map, FBoolean.TRUE);
			}
		}
		// 更新发票信息fg_fundpay和fg_hp_card字段 防止0元不打票，还未来得及更新就返回 by lim 2017-10-17
		// 查询医保计划
		List<BlIncItmVsTypeDTO> turn_list = new ArrayList<BlIncItmVsTypeDTO>();
		if (id_entList.size() > 0) {
			EntHpEP enhpep = new EntHpEP();
			EntHpDO[] EntHpDOs = enhpep.getEntHpById_ent(id_entList);
			List<EntHpDO> listhp_bjyb = new ArrayList<EntHpDO>();
			if (!ArrayUtil.isEmpty(EntHpDOs)) {
				for (EntHpDO ehpDO : EntHpDOs) {
					if (ehpDO.getId_hp() != null && ehpDO.getId_hp().equals(IBdPpCodeTypeConst.ID_HP_BJ_BASIC_MEDICAL_INSUR)) {
						listhp_bjyb.add(ehpDO);
					}
				}
			}
			if (listhp_bjyb != null && listhp_bjyb.size() > 0) {
				blincoepAggDOArrx = updateIncOepStatus(blincoepAggDOArrx, listhp_bjyb.toArray(new EntHpDO[] {}));
				for (BlincoepAggDO item1 : blincoepAggDOArrx) {
					BlIncItmVsTypeDTO blItmVsTypeDTO = new BlIncItmVsTypeDTO();
					BlInvoiceHeadTailDTO newHT = new BlInvoiceHeadTailDTO();
					newHT.setHandbook_no(listhp_bjyb.get(0).getNo_hp()); // 手册号：医保卡号
					newHT.setUpload_no(item1.getParentDO().getIncno()); // 上传号：发票号
					blItmVsTypeDTO.setBlInvoiceHeadTailDTO(newHT);
					turn_list.add(blItmVsTypeDTO);
				}
			}
		}

		// 如果当前结算为诊间挂号数据结算 需要更新就诊数据
//		if (StTypeEnum.ST_OEP_REG.equals(blStOepDO.getEu_sttp())) {
//			IEnOutCmdService enService = ServiceFinder.find(IEnOutCmdService.class);
//			enService.ubpdateFgstAfterSt(blStOepDO.getId_stoep());
//		}
		// 如果当前结算为诊间挂号数据结算 需要更新就诊数据  by liming 2019-01-10
		FBoolean bExistEntRegist=BlDataUtil.bExistEntRegist(blcgoepAggDO[0].getBlCgItmOepDO());
		if (FBoolean.TRUE.equals(bExistEntRegist)) {
			IEnOutCmdService enService = ServiceFinder.find(IEnOutCmdService.class);
			enService.ubpdateFgstAfterSt(blStOepDO.getId_stoep());
		}
		
		// 5.不打印发票，则直接更新记账挂起标志
		if (blincoepAggDOArrx[0].getParentDO().getAmt().equals(new FDouble(0)))// 如果本次结算的发票总金额是0，则不打发票
		{
			// 判断是否0元打发票 lim 2017-09-15
			if (!FBoolean.TRUE.equals(BlParams.BLSTOEP0008())) {
				PrintInvoice = FBoolean.FALSE;
			}
		}
		if (!PrintInvoice.booleanValue()) // 不打印发票
		{
			BLCiOrderToBlCgServiceImplBp handlerBp = new BLCiOrderToBlCgServiceImplBp();
			incOepInfoLst = handlerBp.handlerIncInfoDtos(FBoolean.TRUE, FBoolean.FALSE, blStOepDO, blincoepAggDOArrx, blpaypatoepAggDOs[0]);
			id_orsrvLst = writeBackBlCgAfterPay(blcgoepAggDO);
			// 发事件
			try {
				//this.invokeOepSettlementEvent(blcgoepAggDO, blpaypatoepAggDO, blStOepDO, blincoepAggDOArrx[0], IBlFunCodeConst.FUN_CODE_OPFEECOLLECT);
				BlOpPayEvent.invokePay(blcgoepAggDO, blStOepDO, blpaypatoepAggDO, blincoepAggDOArrx);
			} catch (Exception ex) {

			}
			//.如果收款类型为窗口，并且付款方式为支付宝或者微信，则回写日志信息
			this.ThirdPaySettle(blcgoepAggDO,blpaypatoepAggDOs,id_stoep);
			return incOepInfoLst;
		}
	
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
		
		//发票服务
		IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
		blincoepAggDOArrx = incService.printOpInvoice(new String[]{id_stoep}, printSet);
		
		// 8.打发票
		pay_way = getPm_tp(blpaypatoepAggDO, id_stoep);// 查询支付方式
		BLCiOrderToBlCgServiceImplBp handlerBp = new BLCiOrderToBlCgServiceImplBp();
		BlIncItmVsTypeDTO[] incOepDtoLst = handlerBp.handlerIncInfoDtos(FBoolean.TRUE, FBoolean.FALSE, blStOepDO, blincoepAggDOArrx, blpaypatoepAggDOs[0]);
		if (incOepDtoLst.length == turn_list.size()) {
			for (int i = 0; i < incOepDtoLst.length; i++) {
				BlInvoiceHeadTailDTO blHTDto = incOepDtoLst[i].getBlInvoiceHeadTailDTO();
				blHTDto.setHandbook_no("手册号:" + turn_list.get(i).getBlInvoiceHeadTailDTO().getHandbook_no());// 手册号：医保卡号
				blHTDto.setUpload_no("上传号:" + incOepDtoLst[i].getBlInvoiceHeadTailDTO().getIncno());// 上传号：发票号
				incOepDtoLst[i].setBlInvoiceHeadTailDTO(blHTDto);
			}
		}
		// 9.已经收付款后，需要更新CG表的挂起标志等信息。返回CG表中的id_orsrv
		id_orsrvLst = writeBackBlCgAfterPay(blcgoepAggDO);

		// 11.发事件
		try {
			//this.invokeOepSettlementEvent(blcgoepAggDO, blpaypatoepAggDO, blStOepDO, blincoepAggDOArrx[0], IBlFunCodeConst.FUN_CODE_OPFEECOLLECT);
		
			//发送新收费事件
			BlOpPayEvent.invokePay(blcgoepAggDO, blStOepDO, blpaypatoepAggDO, blincoepAggDOArrx);
		} catch (Exception ex) {

		}
		//.如果收款类型为窗口，并且付款方式为支付宝或者微信，则回写日志信息
		this.ThirdPaySettle(blcgoepAggDO,blpaypatoepAggDOs,id_stoep);
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
	 * 红冲后，重收结算代码
	 * 
	 * @param blcgoepAggDO_recharge
	 *            需要重新收费的记账信息
	 * @param orgin_idstoep
	 *            原始结算ID
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @param blpaypatoepAggDO
	 *            退费的收付款记录
	 * @param AllRefundAndAllCharge
	 *            是否重划重收标志，重划重收时，红冲的支付明细fg_realpay='N'
	 * @param fDateTime
	 *            服务器时间
	 * @return 待打印的发票DTO
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] settlementAfterRedBill(BlcgoepAggDO[] blcgoepAggDO_recharge, String orgin_idstoep, OperatorInfoDTO operatorInfoDTO, BlpaypatoepAggDO blpaypatoepAggDO, FBoolean AllRefundAndAllCharge, FDateTime fDateTime) throws BizException {
		BLCancelSettlementImplBp bLCancelSettlementImplBp = new BLCancelSettlementImplBp();
		BLCiOrderToBlCgServiceImplBp bLCiOrderToBlCgServiceImplBp = new BLCiOrderToBlCgServiceImplBp();
		// 1.获取记账中具体项目和主键的MAP
		GetBlCgItmOepMap blCgItmOepMapIns = new GetBlCgItmOepMap();
		BlCgItmOepMapDTO blCgItmOepMapDTO11 = blCgItmOepMapIns.BlCgItmOepConvertToMaps(blcgoepAggDO_recharge, operatorInfoDTO.getId_emp(), IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE, FBoolean.TRUE);

		// 2.生成新的收付款记录
		BlpaypatoepAggDO[] blpaypatoepAggDO_recharge = bLCancelSettlementImplBp.get_BlpaypatoepAggDO_reCharge(orgin_idstoep, blpaypatoepAggDO, operatorInfoDTO, AllRefundAndAllCharge, fDateTime);
		// 3.保存新的收付款记录
		BlpaypatoepAggDO[] blpaypatoepAggDOs = bLCiOrderToBlCgServiceImplBp.saveBlpaypatoepAggDO(blpaypatoepAggDO_recharge[0], fDateTime);

		// 4.校验：重收明细金额与从原来收付款信息产生的重收收付款金额是否一致。
		bLCiOrderToBlCgServiceImplBp.validate_fee_recharge(blcgoepAggDO_recharge, blpaypatoepAggDOs[0].getParentDO().getAmt().multiply(blpaypatoepAggDOs[0].getParentDO().getEu_direct()));

		// 5.重收预交金应该在患者预交金余额中进行获取或退
		DoOepFgAccAmtAcc doOepFgAccAmtAccBp = new DoOepFgAccAmtAcc();
		doOepFgAccAmtAccBp.doPayByPrepay(blpaypatoepAggDOs);

		// 6.生成结算bl_st_oep信息(已经保存）
		BlStOepDO[] blStOepDOs = bLCancelSettlementImplBp.get_NewBlStOepsFromReSettlement(blCgItmOepMapDTO11, blcgoepAggDO_recharge, orgin_idstoep, blpaypatoepAggDOs[0].getParentDO().getId_paypatoep(), fDateTime, operatorInfoDTO);

		// 7.保存退费重收后的记账明细
		BlcgoepAggDO[] blcgoepAggDOs = bLCiOrderToBlCgServiceImplBp.save_rechargeBlcgoepAggDO(blcgoepAggDO_recharge, fDateTime, blStOepDOs[0].getId_stoep());

		/*// 8.获得发票号
		String incno = bLCancelSettlementImplBp.getIncnoFromEnt_invoiceno(blcgoepAggDO_recharge[0].getParentDO().getEnt_invoiceno());
		// 9.获得票据包
		IBlincQryService iBlincQryService = ServiceFinder.find(IBlincQryService.class);
		String code_pkg = iBlincQryService.getCodeIncPkgByIdempiss(operatorInfoDTO.getId_org(), operatorInfoDTO.getId_emp(), IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
		// 10.生成发票信息且保存
		BlincoepAggDO blincoepAggDO = bLCancelSettlementImplBp.get_NewBlIncOepsFromReSettlement(blcgoepAggDOs, blCgItmOepMapDTO11, blStOepDOs[0], blpaypatoepAggDOs, incno, code_pkg, fDateTime, operatorInfoDTO);*/

		
		IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
		//10.保存发票数据
		BlincoepAggDO[] blincoepAggDO = incService.saveOpInvoice(blcgoepAggDOs);
		
		//计算金额减免
		OpFreeAmtHandleBP freeBp = new OpFreeAmtHandleBP();
		freeBp.exec(blStOepDOs[0].getId_stoep(), blcgoepAggDOs, blpaypatoepAggDOs[0]);
		
		//10.1.打印发票
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
		
		//是否打重收发票 by lim 2019-12-05
		BlIncItmVsTypeDTO[] incInfoDtoLst=null;
		FBoolean bRePrint=this.isRePrintInc();
		if(FBoolean.TRUE.equals(bRePrint)){
			blincoepAggDO = incService.printOpInvoice(new String[]{blStOepDOs[0].getId_stoep()},printSet);
			incInfoDtoLst = bLCiOrderToBlCgServiceImplBp.handlerIncInfoDtos(FBoolean.FALSE, FBoolean.FALSE, blStOepDOs[0], blincoepAggDO, blpaypatoepAggDO_recharge[0]);
		}else{
			//返回结算id 防止不打发票却打小票或者导引单
			List<BlIncItmVsTypeDTO> list= new ArrayList<BlIncItmVsTypeDTO>();
			BlInvoiceHeadTailDTO invoiceHeadTaildto = new BlInvoiceHeadTailDTO();
			invoiceHeadTaildto.setId_stoep(blStOepDOs[0].getId_stoep());
			BlIncItmVsTypeDTO incInfoDto = new BlIncItmVsTypeDTO();
			incInfoDto.setBlInvoiceHeadTailDTO(invoiceHeadTaildto);
			list.add(incInfoDto);
			incInfoDtoLst=list.toArray(new BlIncItmVsTypeDTO[0]);
		}
		
		// 11.获得收付款方式（需要打印出来）
		String pay_way = "";
		for (BlPayItmPatOepDO blPayItmPatOepDO : blpaypatoepAggDO.getBlPayItmPatOepDO()) {
			blPayItmPatOepDO.setFg_realpay(FBoolean.TRUE);// 真实数据
			pay_way = pay_way + "," + getPm_way(blPayItmPatOepDO.getSd_pm());// 收款方式
		}
		if (pay_way.length() > 1) {
			pay_way = pay_way.substring(1);
		}
		// 12.生成发票打印的dto
		// BlIncItmVsTypeDTO
		// blIncItmVsTypeDTO=bLCiOrderToBlCgServiceImplBp.assemblyIncItmVsTypeDto(blcgoepAggDOs,
		// blincoepAggDO,blStOepDOs[0],pay_way);

//		BlIncItmVsTypeDTO[] incInfoDtoLst = bLCiOrderToBlCgServiceImplBp.handlerIncInfoDtos(FBoolean.FALSE, FBoolean.FALSE, blStOepDOs[0], blincoepAggDO, blpaypatoepAggDO_recharge[0]);
		// 13. 设置当前发票号
		/*String curno = computeNextInvoiceNo(incno);
		IBLInvoiceService iBLInvoiceService = ServiceFinder.find(IBLInvoiceService.class);
		iBLInvoiceService.SetCurNoByParamNo(blincoepAggDO.getParentDO().getId_emp_inc(), blincoepAggDO.getParentDO().getId_incca(), curno);*/

		// 14.发事件
		// try
		// { //TODO
		//this.invokeOepSettlementEvent(blcgoepAggDOs, blpaypatoepAggDO, blStOepDOs[0], blincoepAggDO[0], IBlFunCodeConst.FUN_CODE_OPFEERTN);
		
		//使用新的收费事件
		//BlOpPayEvent.invokePay(blcgoepAggDOs, blStOepDOs[0], blpaypatoepAggDO, blincoepAggDO);
		// }
		// catch (Exception ex)
		// {
		//
		// }
		BlPayOepRefundEventDTO enventDto = new BlPayOepRefundEventDTO();
		enventDto.setNewCgData(blcgoepAggDOs);
		enventDto.setNewStData(blStOepDOs[0]);
		enventDto.setNewPayData(blpaypatoepAggDOs[0]);
		enventDto.setNewIncData(blincoepAggDO);

		Context.get().setAttribute(IBlFlowKeyConst.BL_FLOW_OPREFUND_EVENTDATA, enventDto);
		
		return incInfoDtoLst;
	}
	
	/**
	 * 判断重收时是否打印发票
	 * @return
	 */
	private FBoolean isRePrintInc(){
		FBoolean bRePrint= FBoolean.FALSE;
		String blcg0035=BlParams.BLCG0035();
		if(!StringUtil.isEmpty(blcg0035)){
			String str=blcg0035.substring(0,1);
			bRePrint="1".equals(str)?FBoolean.TRUE:FBoolean.FALSE;
		}
		return bRePrint;
	}

	// /**
	// * 组装发票和明细清单的DTO
	// * @param blcgoepAggDOArr 记账信息
	// * @param incOepaggDo 发票信息
	// * @param stOepDo 结算信息
	// * @return
	// * @throws BizException
	// */
	// public BlIncItmVsTypeDTO assemblyIncItmVsTypeDto(BlcgoepAggDO[]
	// blcgoepAggDOArr,BlincoepAggDO incOepaggDo,BlStOepDO stOepDo,String
	// pay_tp) throws BizException
	// {
	// BlIncOepDO incOepDo=incOepaggDo.getParentDO();
	// //校验一下参数
	// if(!stOepDo.getId_stoep().equalsIgnoreCase(incOepDo.getId_stoep()))
	// throw new BizException("参数异常，传入的结算实体和发票实体不匹配");
	// //构建发票信息DTO
	// BlIncItmVsTypeDTO incItmVsTypeDto=new BlIncItmVsTypeDTO();
	//
	// //执行域（药品)发药窗口相关服务
	// IMpDgOutService
	// iMpDgOutService=ServiceFinder.find(IMpDgOutService.class);
	// Map<String,OpPresQueSiteDTO> mapPresToOpPresQueSite=new
	// HashMap<String,OpPresQueSiteDTO>();
	//
	// //构建发票汇总信息
	// BlInvoiceHeadTailDTO invoiceHeadTailDto=new BlInvoiceHeadTailDTO();
	// invoiceHeadTailDto.setAmt(incOepDo.getAmt());
	// invoiceHeadTailDto.setAmt_free(incOepDo.getAmt_free());
	// invoiceHeadTailDto.setAmt_pat(incOepDo.getAmt_pat());
	// invoiceHeadTailDto.setAmt_ratio(incOepDo.getAmt_ratio());
	// invoiceHeadTailDto.setAmt_hp(incOepDo.getAmt_hp());
	// invoiceHeadTailDto.setAmt_std(incOepDo.getAmt_std());
	// invoiceHeadTailDto.setEu_direct(incOepDo.getEu_direct());
	// invoiceHeadTailDto.setInc_emp_name(incOepDo.getId_emp_inc_name());
	// invoiceHeadTailDto.setEu_freemd(incOepDo.getEu_freemd());
	// invoiceHeadTailDto.setIncno(incOepDo.getIncno());
	//
	// invoiceHeadTailDto.setPayee_emp_name(stOepDo.getId_emp_st_code());
	// invoiceHeadTailDto.setId_stoep(stOepDo.getId_stoep());
	// invoiceHeadTailDto.setCode_st(stOepDo.getCode_st());
	// invoiceHeadTailDto.setDatetime_st(stOepDo.getDt_st());
	// invoiceHeadTailDto.setPay_tp(pay_tp); //支付方式
	// incItmVsTypeDto.setBlInvoiceHeadTailDTO(invoiceHeadTailDto);
	//
	// FArrayList invoiceDetailDtoLst=new FArrayList();
	// for(BlcgoepAggDO aggdo:blcgoepAggDOArr)
	// {
	// BlCgItmOepDO[] cgItmOepDoArr=(BlCgItmOepDO[])aggdo.getBlCgItmOepDO();
	// for(BlCgItmOepDO cgItmOepDo:cgItmOepDoArr)
	// {
	// BlInvoiceDetailsDTO invoiceDetailDto=new BlInvoiceDetailsDTO();
	// invoiceDetailDto.setName_srv(cgItmOepDo.getName_srv());
	// //判断是否为物品，如果是物品显示物品名
	// if(cgItmOepDo.getFg_mm().booleanValue())
	// {
	// invoiceDetailDto.setName_srv(cgItmOepDo.getName_srv()+"("+cgItmOepDo.getName_mm()+")");
	// }
	// invoiceDetailDto.setId_srv(cgItmOepDo.getId_srv());
	// invoiceDetailDto.setId_mm(cgItmOepDo.getId_mm());
	// invoiceDetailDto.setAmt(cgItmOepDo.getAmt());
	// invoiceDetailDto.setAmt_pat(cgItmOepDo.getAmt_pat());
	// invoiceDetailDto.setAmt_ratio(cgItmOepDo.getAmt_ratio());
	// invoiceDetailDto.setAmt_std(cgItmOepDo.getAmt_std());
	// invoiceDetailDto.setFg_free(cgItmOepDo.getFg_free());
	// invoiceDetailDto.setFg_mm(cgItmOepDo.getFg_mm());
	//
	// OpPresQueSiteDTO opPresQueSiteDTO=null;
	// if(cgItmOepDo.getId_pres()!=null)
	// {
	// if(!mapPresToOpPresQueSite.containsKey(cgItmOepDo.getId_pres()))
	// {
	// opPresQueSiteDTO
	// =iMpDgOutService.insertPresWindowData(cgItmOepDo.getId_pres(), 1);
	// }
	// else
	// {
	// opPresQueSiteDTO=mapPresToOpPresQueSite.get(cgItmOepDo.getId_pres());
	// }
	// if(opPresQueSiteDTO!=null)
	// {
	// invoiceDetailDto.setWindowinfo(opPresQueSiteDTO.getName_quesite());
	// invoiceDetailDto.setFg_window(opPresQueSiteDTO.getFg_window());
	// }
	// }
	//
	// //账单项编码
	// invoiceDetailDto.setCode_inccaitm(cgItmOepDo.getCode_inccaitm());
	// invoiceDetailDto.setName_inccaitm(cgItmOepDo.getName_inccaitm());
	// if(cgItmOepDo.getFg_hp().booleanValue())
	// {
	// invoiceDetailDto.setHpsrvtp(cgItmOepDo.getSd_hpsrvtp());
	// invoiceDetailDto.setHp_name(gethp_name(cgItmOepDo.getSd_hpsrvtp()));
	// }
	// else
	// {
	// invoiceDetailDto.setHpsrvtp("");
	// invoiceDetailDto.setHp_name("");
	// }
	// invoiceDetailDto.setId_cgoep(cgItmOepDo.getId_cgoep());
	// invoiceDetailDto.setPrice(cgItmOepDo.getPrice());
	// invoiceDetailDto.setQuan(cgItmOepDo.getQuan());
	// invoiceDetailDto.setSpec_srv(cgItmOepDo.getSpec());
	// invoiceDetailDto.setSrvu(cgItmOepDo.getSrvu_name());
	//
	//
	// invoiceDetailDtoLst.add(invoiceDetailDto);
	// }
	// }//明细项处理完
	// incItmVsTypeDto.setBlInvoiceDetailsDTO(invoiceDetailDtoLst);
	//
	// //账单项处理
	// BlIncItmOepDO[]
	// incItmOepDoArr=(BlIncItmOepDO[])incOepaggDo.getBlIncItmOepDO();
	// FArrayList incCaitmDoLst=new FArrayList();
	// if(incItmOepDoArr!=null)
	// {
	// for(BlIncItmOepDO incItmOepDo:incItmOepDoArr)
	// {
	// BlinvoicecaitmDTO incCaitmDo=new BlinvoicecaitmDTO();
	// incCaitmDo.setCode_inccam(incItmOepDo.getCode());
	// incCaitmDo.setName_inccam(incItmOepDo.getName());
	// incCaitmDo.setAmt(incItmOepDo.getAmt());
	// incCaitmDo.setAmt_free(incItmOepDo.getAmt_free());
	// incCaitmDo.setAmt_hp(incItmOepDo.getAmt_hp());
	// incCaitmDo.setAmt_pat(incItmOepDo.getAmt_pat());
	// incCaitmDo.setAmt_ratio(incItmOepDo.getAmt_ratio());
	// incCaitmDo.setAmt_std(incItmOepDo.getAmt_std());
	// incCaitmDoLst.add(incCaitmDo);
	// }
	// incItmVsTypeDto.setBlInvoicecaitmDTOLst(incCaitmDoLst);
	// }
	//
	//
	// return incItmVsTypeDto;
	// }
	//

	// /**
	// * 门诊结算：不含分摊的付款
	// */
	// public BlIncItmVsTypeDTO[] SettlementPayment_discard(BlcgoepAggDO[]
	// blcgoepAggDO,BlpaypatoepAggDO blpaypatoepAggDO,FBoolean
	// IsDrugApplication,FBoolean PrintInvoice,FBoolean IsTransferPrepay) throws
	// BizException
	// {
	// TimeService timeService = new TimeServiceImpl();
	// FDateTime fDateTime =timeService.getUFDateTime();
	// GetInvoiceType getInvoiceType=new GetInvoiceType();
	// String id_incca=IBdInccaCodeConst.ID_OUTPATIENT_INVOICE; //门诊发票
	//
	// //Map<String,String> st_srv_invoicetype=new HashMap<String,String>();
	// Map<String,String> blStOepMapEnt=new HashMap<String,String>();
	// Map<String,FDateTime> blStOepMapDtst=new HashMap<String,FDateTime>();
	// List<BlIncItmVsTypeDTO> blIncItmVsTypeDTOlist=new
	// ArrayList<BlIncItmVsTypeDTO>();
	// String
	// key="",srv_invoicename="",tempKeys="",keys="",values="",pkg_code="";
	// String[] arr_ent_invoice;
	// Map<String,String> blCgItmOepMapCodeSt=new HashMap<String,String>();
	// Map<String,String> ent_invoice=new HashMap<String,String>();
	// Map<String,String> ent_invoice_pkgcodem=new HashMap<String,String>();
	// String id_cgoeps="",tempKey="",maxInvoiceno="";
	// OperatorInfoDTO operatorInfoDTO=new OperatorInfoDTO();
	// operatorInfoDTO.setId_grp(blpaypatoepAggDO.getParentDO().getId_grp());
	// operatorInfoDTO.setId_org(blpaypatoepAggDO.getParentDO().getId_org());
	// operatorInfoDTO.setId_dep(blpaypatoepAggDO.getParentDO().getId_dep_pay());
	// operatorInfoDTO.setId_emp(blpaypatoepAggDO.getParentDO().getId_emp_pay());
	// operatorInfoDTO.setId_org_emp(blpaypatoepAggDO.getParentDO().getId_org());
	// List<String> id_orsrvLst=new ArrayList<String>();
	// String pay_way="";//收款方式，前台打印用
	//
	//
	// PriceSettleBP priceBp=new PriceSettleBP();
	// //1.入口验证
	// priceBp.validate_settlementPayment(blcgoepAggDO, blpaypatoepAggDO);
	//
	//
	// //2.保存患者收付款
	// BlPayPatOepDO blPayPatOepDO= blpaypatoepAggDO.getParentDO();
	// blPayPatOepDO.setDt_pay(fDateTime);
	// blPayPatOepDO.setStatus(DOStatus.NEW);
	// blpaypatoepAggDO.setParentDO(blPayPatOepDO);
	// for(BlPayItmPatOepDO blPayItmPatOepDO:
	// blpaypatoepAggDO.getBlPayItmPatOepDO())
	// {
	// blPayItmPatOepDO.setFg_realpay(FBoolean.TRUE);//真实数据
	// pay_way=pay_way+","+getPm_way(blPayItmPatOepDO.getSd_pm());//收款方式
	// }
	// pay_way=pay_way.substring(1);
	// Object obj222 = ServiceFinder.find(IBlpaypatoepCudService.class);
	// BlpaypatoepAggDO[]
	// blpaypatoepAggDOs=((IBlpaypatoepCudService)obj222).save(new
	// BlpaypatoepAggDO[]{blpaypatoepAggDO});
	// if(null==blpaypatoepAggDOs)
	// {
	// throw new BizException("保存患者收付款信息失败");
	// }
	// //2.1如果患者采用预交金支付或结存，则处理预交金，且修改门诊预交金账户,修改门诊预交金消费锁定金额
	// DoOepFgAccAmtAcc doOepFgAccAmtAccBp=new DoOepFgAccAmtAcc();
	// doOepFgAccAmtAccBp.doOepPrepayConsumeAndTransferPrepay(blcgoepAggDO,
	// blpaypatoepAggDOs, IsTransferPrepay, fDateTime);
	//
	// //3.获得本次结算的结算ID：Id_stoep
	// String id_stoeps="";
	// String id_stoeps_incoep="";
	// for(int i=0;i<blcgoepAggDO.length;i++)
	// {
	// BlCgItmOepDO[] blCgItmOepDOs=blcgoepAggDO[i].getBlCgItmOepDO();
	// for(int j=0;j<blCgItmOepDOs.length;j++)
	// {
	// if(id_stoeps.indexOf("'"+blCgItmOepDOs[j].getId_stoep()+"'")<0)
	// {
	// id_stoeps=id_stoeps+" or "+BlStOepDODesc.TABLE_ALIAS_NAME+".id_stoep='"+blCgItmOepDOs[j].getId_stoep()+"' ";
	// //
	// id_stoeps_incoep=id_stoeps_incoep+" or "+"id_stoep='"+blCgItmOepDOs[j].getId_stoep()+"' ";
	// id_stoeps_incoep=id_stoeps_incoep+",'"+blCgItmOepDOs[j].getId_stoep()+"'";
	// }
	// // if(blCgItmOepDOs[j].getEu_srctp()==1)
	// // {
	// // PrintOnlyOneInvoice=FBoolean.FALSE;//就诊来源的数据，则分开打发票
	// // }
	// }
	// }
	// if(id_stoeps.length()<3)
	// {
	// throw new BizException("查询患者结算信息失败");
	// }
	// id_stoeps=id_stoeps.substring(3);
	// id_stoeps_incoep="id_stoep in ("+id_stoeps_incoep.substring(1)+")";
	// //从发票表中查询
	//
	// //3.1查询发票信息
	// IBlincoepRService
	// iBlincoepRService=ServiceFinder.find(IBlincoepRService.class);
	// IBlincoepCudService
	// iBlincoepCudService=ServiceFinder.find(IBlincoepCudService.class);
	// BlincoepAggDO[]
	// blincoepAggDOArrx=iBlincoepRService.find(id_stoeps_incoep, "",
	// FBoolean.TRUE);
	// if(blincoepAggDOArrx==null || blincoepAggDOArrx.length==0)
	// {
	// throw new BizException("门诊结算：查询患者发票信息失败");
	// }
	//
	// //3.2 处理减免的业务逻辑
	// DoOepFgFree doOepFgFree=new DoOepFgFree();
	// int Eu_freemd=doOepFgFree.DoOep_FgFree(blcgoepAggDO, blpaypatoepAggDO,
	// blincoepAggDOArrx[0]);
	//
	// //查是否有分摊
	// if(isPayByMedInsur(id_stoeps_incoep.substring(1)).booleanValue())
	// {
	// pay_way=pay_way+",医保基金";
	// }
	//
	//
	// //4.根据Id_stoep，查询ST表，并回写ST表中Id_paypatoep
	// IBlstoepRService
	// iBlstoepRService=ServiceFinder.find(IBlstoepRService.class);
	// BlStOepDO[] blStOepDO=iBlstoepRService.find(id_stoeps, "",
	// FBoolean.FALSE);
	// if(null==blStOepDO)
	// {
	// throw new BizException("查询患者结算信息失败");
	// }
	// //修改门诊结算信息，回写收付款外键：blStOepDO
	// for(int i=0;i<blStOepDO.length;i++)
	// {
	// blStOepDO[i].setId_paypatoep(blpaypatoepAggDOs[0].getParentDO().getId_paypatoep());
	// //医生站接诊的数据没有收款员消息
	// if(blStOepDO[i].getId_emp_st()==null ||
	// blStOepDO[i].getId_emp_st().length()==0)
	// {
	// blStOepDO[i].setId_emp_st(operatorInfoDTO.getId_emp());
	// }
	// if(blStOepDO[i].getId_dep_st()==null ||
	// blStOepDO[i].getId_dep_st().length()==0)
	// {
	// blStOepDO[i].setId_dep_st(operatorInfoDTO.getId_dep());
	// }
	// if(blStOepDO[i].getId_org()==null ||
	// blStOepDO[i].getId_org().length()==0)
	// {
	// blStOepDO[i].setId_org(operatorInfoDTO.getId_org());
	// }
	// if(blStOepDO[i].getId_grp()==null ||
	// blStOepDO[i].getId_grp().length()==0)
	// {
	// blStOepDO[i].setId_grp(operatorInfoDTO.getId_grp());
	// }
	//
	// blStOepDO[i].setStatus(DOStatus.UPDATED);
	// // if(PrintOnlyOneInvoice.booleanValue())
	// // {
	// key=blStOepDO[i].getId_pat();
	// // }
	// // else
	// // {
	// //
	// key=blStOepDO[i].getId_pat()+" "+blStOepDO[i].getId_ent()+" "+blStOepDO[i].getId_enttp();
	// // }
	// if(!blStOepMapEnt.containsKey(key))//《就诊，结算号》
	// {
	// blStOepMapEnt.put(key, blStOepDO[i].getCode_st());
	// }
	// if(!blStOepMapDtst.containsKey(key))//《就诊，日期》
	// {
	// blStOepMapDtst.put(key, blStOepDO[i].getDt_st());
	// }
	// }
	// IBlstoepCudService
	// iBlstoepCudService=ServiceFinder.find(IBlstoepCudService.class);
	// BlStOepDO[] blStOepDO1=iBlstoepCudService.save(blStOepDO);
	// if(null==blStOepDO1)
	// {
	// throw new BizException("更新患者结算信息失败");
	// }
	//
	// //5.不打印发票，则直接更新记账挂起标志
	// if(!PrintInvoice.booleanValue()) //不打印发票
	// {
	// BlIncItmVsTypeDTO[] blIncItmVsTypeDTO=new BlIncItmVsTypeDTO[1];
	// blIncItmVsTypeDTO[0]=new BlIncItmVsTypeDTO();
	// blIncItmVsTypeDTO[0].setId_cgoep(blcgoepAggDO[0].getParentDO().getId_cgoep());
	// for(int kk=0;kk<blcgoepAggDO.length;kk++) //门诊记账Agg
	// {
	// //更新记账明细，需要更改主DO的状态为更新
	// BlCgOepDO blCgoepDo=blcgoepAggDO[kk].getParentDO();
	// blCgoepDo.setStatus(DOStatus.UPDATED);
	// //记账明细字段更新
	// BlCgItmOepDO[] blCgItmOepDOs=blcgoepAggDO[kk].getBlCgItmOepDO();
	// for(int k=0;k<blCgItmOepDOs.length;k++)//门诊记账明细表
	// {
	// if(blCgItmOepDOs[k].getId_orsrv()!=null)
	// {
	// id_orsrvLst.add(blCgItmOepDOs[k].getId_orsrv());
	// }
	// blCgItmOepDOs[k].setFg_susp(FBoolean.FALSE);
	// blCgItmOepDOs[k].setFg_st(FBoolean.TRUE); //已结算
	// blCgItmOepDOs[k].setStatus(DOStatus.UPDATED);
	// }
	// }
	// //更新记账信息
	// IBlcgoepCudService
	// iBlcgoepCudService1=ServiceFinder.find(IBlcgoepCudService.class);
	// BlcgoepAggDO[] BlcgoepAggDO_arr=iBlcgoepCudService1.save(blcgoepAggDO);
	// if(BlcgoepAggDO_arr==null)
	// {
	// throw new BizException("更新记账挂起数据失败");
	// }
	// return blIncItmVsTypeDTO;
	// }
	//
	// //***************************以下要打印发票了*********************
	//
	// //5.更新记账挂起标志
	// for(int kk=0;kk<blcgoepAggDO.length;kk++) //门诊记账Agg
	// {
	// //根据结算号，查询对应的服务和服务所属发票项目类型
	// id_cgoeps=id_cgoeps+",'"+blcgoepAggDO[kk].getParentDO().getId_cgoep()+"'";
	// }
	// id_cgoeps=id_cgoeps.substring(2);
	// id_cgoeps=id_cgoeps.substring(0,id_cgoeps.length()-1);
	// //
	// st_srv_invoicetype=getInvoiceType.GetInvocieTypeByBlCgOepId(id_incca,id_cgoeps);
	// // //获得《就诊，结算号》
	// srv_invoicename=blcgoepAggDO[0].getParentDO().getEnt_invoiceno();
	// pkg_code=blcgoepAggDO[0].getParentDO().getEnt_invoice_pkgcode();
	// if(srv_invoicename.indexOf("|")>0)
	// {
	// arr_ent_invoice=srv_invoicename.split("\\|");
	// for(int ll=0;ll<arr_ent_invoice.length;ll++)
	// {
	// tempKeys=arr_ent_invoice[ll];
	// keys=tempKeys.substring(0, tempKeys.indexOf(','));
	// values=tempKeys.substring(tempKeys.indexOf(',')+1);
	// ent_invoice.put(keys, values);
	// if(maxInvoiceno.compareTo(values)<0)
	// {
	// maxInvoiceno=values;
	// }
	// }
	// }
	// if(pkg_code.indexOf("|")>0)
	// {
	// arr_ent_invoice=pkg_code.split("\\|");
	// for(int ll=0;ll<arr_ent_invoice.length;ll++)
	// {
	// tempKeys=arr_ent_invoice[ll];
	// keys=tempKeys.substring(0, tempKeys.indexOf(','));
	// values=tempKeys.substring(tempKeys.indexOf(',')+1);
	// ent_invoice_pkgcodem.put(keys, values);
	// }
	// }
	//
	//
	// //6.修改INC表中打印发票的标志
	//
	// for(BlincoepAggDO blincoepAggDO:blincoepAggDOArrx)
	// {
	//
	// // if(PrintOnlyOneInvoice.booleanValue())
	// // {
	// key=blincoepAggDO.getParentDO().getId_pat();
	// // }
	// // else
	// // {
	// //
	// key=blincoepAggDO.getParentDO().getId_pat()+" "+blincoepAggDO.getParentDO().getId_ent()+" "+blincoepAggDO.getParentDO().getId_enttp();
	// // }
	// blincoepAggDO.getParentDO().setFg_print(FBoolean.TRUE);
	// if(blincoepAggDO.getParentDO().getIncno()==null)
	// {
	// blincoepAggDO.getParentDO().setIncno(ent_invoice.get(key));
	// blincoepAggDO.getParentDO().setCode_incpkg(ent_invoice_pkgcodem.get(key));
	// }
	// //医生站接诊挂号产生的数据没有这些信息
	// if(blincoepAggDO.getParentDO().getId_grp()==null ||
	// blincoepAggDO.getParentDO().getId_grp().length()==0)
	// {
	// blincoepAggDO.getParentDO().setId_grp(operatorInfoDTO.getId_grp());
	// }
	// if(blincoepAggDO.getParentDO().getId_org()==null ||
	// blincoepAggDO.getParentDO().getId_org().length()==0)
	// {
	// blincoepAggDO.getParentDO().setId_org(operatorInfoDTO.getId_org());
	// }
	//
	// // blincoepAggDO.getParentDO().setDt_inc(Dt_inc);(FBoolean.TRUE);
	//
	// // if(blincoepAggDO.getParentDO().getCode_incpkg()==null)
	// // {
	//
	// // }
	// blincoepAggDO.getParentDO().setId_emp_canc(null);
	// blincoepAggDO.getParentDO().setId_emp_inc(blpaypatoepAggDO.getParentDO().getId_emp_pay());
	// blincoepAggDO.getParentDO().setTimes_prn(1);
	//
	// blincoepAggDO.getParentDO().setStatus(DOStatus.UPDATED);
	// }
	// BlincoepAggDO[]
	// blincoepAggDOArrx1=iBlincoepCudService.save(blincoepAggDOArrx);
	//
	// //7.<就诊，发票开立人>
	// String
	// ent_invoice_empnames=blcgoepAggDO[0].getParentDO().getEnt_invoice_empname();
	// String[] ent_invoice_empnames_arr=ent_invoice_empnames.split("\\|");
	// Map<String,String> ent_empname=new HashMap<String,String>();
	// for(int i=0;i<ent_invoice_empnames_arr.length;i++)
	// {
	// String[] temps=ent_invoice_empnames_arr[i].split(",");
	// if(!ent_empname.containsKey(temps[0]))
	// {
	// ent_empname.put(temps[0], temps[1]);
	// }
	// }
	//
	// //8.打发票
	// BLCiOrderToBlCgServiceImplBp bLCiOrderToBlCgServiceImplBp=new
	// BLCiOrderToBlCgServiceImplBp();
	// // String
	// inc_emp_name=ent_empname.get(blcgoepAggDO[0].getParentDO().getId_pat());
	// // String
	// code_st=blStOepMapEnt.get(blcgoepAggDO[0].getParentDO().getId_pat());
	// // FDateTime
	// datetime_st=blStOepMapDtst.get(blcgoepAggDO[0].getParentDO().getId_pat());
	// // FDateTime dateTime_print=fDateTime;
	// // String
	// incno=ent_invoice.get(blcgoepAggDO[0].getParentDO().getId_pat());
	// // BlIncItmVsTypeDTO
	// blIncItmVsTypeDTO=bLCiOrderToBlCgServiceImplBp.getBlIncItmVsTypeDTO(blcgoepAggDO,
	// inc_emp_name, pay_way, code_st, datetime_st, dateTime_print, Eu_freemd,
	// incno);
	//
	// Map<String,String> measDocDOMap =getMeasDocDOMap();
	// IMpDgOutService
	// iMpDgOutService=ServiceFinder.find(IMpDgOutService.class);
	// List<String> id_presList=new ArrayList<String>();
	// BIncSumAmtInfoDTO blPrintIncInfoDTO=new BIncSumAmtInfoDTO();
	// for(int t=0;t<blcgoepAggDO.length;t++)
	// {
	// //更新记账明细，需要更改主DO的状态为更新
	// BlCgOepDO blCgoepDo=blcgoepAggDO[t].getParentDO();
	// blCgoepDo.setStatus(DOStatus.UPDATED);
	// BlCgItmOepDO[] blCgItmOepDOs=blcgoepAggDO[t].getBlCgItmOepDO();
	// for(int k=0;k<blCgItmOepDOs.length;k++)//门诊记账明细表
	// {
	// //all_blCgItmOepDO_list.add(blCgItmOepDOs[k]);
	// // if(blCgItmOepDOs[k].getId_orsrv()!=null)
	// // {
	// // id_orsrvLst.add(blCgItmOepDOs[k].getId_orsrv());
	// // }
	// BlIncItmVsTypeDTO blIncItmVsTypeDTO=new BlIncItmVsTypeDTO();
	// blIncItmVsTypeDTO.setId_cgoep(blCgItmOepDOs[k].getId_cgoep());
	// //修改记账明细表的结算信息
	// //比较id_ent,id_enttp,id_org,id_pat
	// // if(PrintOnlyOneInvoice==FBoolean.FALSE)
	// // {
	// //
	// key=blCgItmOepDOs[k].getId_pat()+" "+blCgItmOepDOs[k].getId_ent()+" "+blCgItmOepDOs[k].getId_enttp();
	// // }
	// // else
	// // {
	// key=blCgItmOepDOs[k].getId_pat();//打印一张发票
	// // }
	// // if(blPrintIncInfoDTO.getInc_emp_name()==null)
	// // {
	// // blPrintIncInfoDTO.setInc_emp_name(ent_empname.get(key));
	// // }
	// blIncItmVsTypeDTO.setInc_emp_name(ent_empname.get(key));
	// blIncItmVsTypeDTO.setId_mm(blCgItmOepDOs[k].getId_mm());
	// blIncItmVsTypeDTO.setSrvu(measDocDOMap.get(blCgItmOepDOs[k].getSrvu()));
	// blIncItmVsTypeDTO.setPay_tp(pay_way); //支付方式
	// if(blStOepMapEnt.containsKey(key))
	// {
	// // if(blPrintIncInfoDTO.getCode_st()==null)
	// // {
	// // blPrintIncInfoDTO.setCode_st(blStOepMapEnt.get(key));
	// // }
	// blIncItmVsTypeDTO.setCode_st(blStOepMapEnt.get(key));
	// }
	// if(blStOepMapDtst.containsKey(key))
	// {
	// // if(blPrintIncInfoDTO.getCode_st()==null)
	// // {
	// // blPrintIncInfoDTO.setCode_st(blStOepMapEnt.get(key));
	// // }
	// blIncItmVsTypeDTO.setDatetime_st(blStOepMapDtst.get(key));//结算时间
	// }
	// blCgItmOepDOs[k].setFg_st(FBoolean.TRUE); //已结算
	// blCgItmOepDOs[k].setFg_susp(FBoolean.FALSE);//置挂起标志为假
	// blCgItmOepDOs[k].setStatus(DOStatus.UPDATED);;//置挂起标志为假
	// // if(blPrintIncInfoDTO.getCode_st()==null)
	// // {
	// // blPrintIncInfoDTO.setIncno(ent_invoice.get(key));
	// // }
	// blIncItmVsTypeDTO.setIncno(ent_invoice.get(key));
	// //名称，规格
	// if(null==blCgItmOepDOs[k].getFg_mm() ||
	// blCgItmOepDOs[k].getFg_mm()==FBoolean.FALSE)
	// {
	// blIncItmVsTypeDTO.setName_srv(blCgItmOepDOs[k].getName_srv());
	// //规格
	// blIncItmVsTypeDTO.setSpec_srv(blCgItmOepDOs[k].getSpec());
	// }
	// else
	// {
	// blIncItmVsTypeDTO.setName_srv(blCgItmOepDOs[k].getName_srv()+"("+blCgItmOepDOs[k].getName_mm()+")");
	// //规格
	// blIncItmVsTypeDTO.setSpec_srv(blCgItmOepDOs[k].getSpec());
	// }
	// blIncItmVsTypeDTO.setQuan(blCgItmOepDOs[k].getQuan());
	// blIncItmVsTypeDTO.setAmt_std(blCgItmOepDOs[k].getAmt_std());
	// //比例金额-医保基金支付-医保个人账户支付
	// blIncItmVsTypeDTO.setAmt_pat(blCgItmOepDOs[k].getAmt()); //个人自付
	// blIncItmVsTypeDTO.setAmt_tc(new FDouble(0));//医保基金支付
	// if(blCgItmOepDOs[k].getAmt_hp()!=null)
	// {
	// blIncItmVsTypeDTO.setAmt_tc(blCgItmOepDOs[k].getAmt_hp());
	// }
	// blIncItmVsTypeDTO.setAmt_qtyb(new FDouble(0));//其他医保
	// blIncItmVsTypeDTO.setAmt_grzf(new FDouble(0));//个人账户支付
	// blIncItmVsTypeDTO.setAmt_pat(blCgItmOepDOs[k].getAmt());
	// blIncItmVsTypeDTO.setPrice(blCgItmOepDOs[k].getPrice());
	// if(Eu_freemd==BlFreeMdEnum.ITM_FREE_MD) //项目减免
	// {
	// blIncItmVsTypeDTO.setName_srv(blIncItmVsTypeDTO.getName_srv()+"-减免");
	// blIncItmVsTypeDTO.setAmt_std(new FDouble(0));
	// blIncItmVsTypeDTO.setAmt_pat(new FDouble(0));
	// }
	//
	// if(blCgItmOepDOs[k].getSd_hpsrvtp()==null)
	// {
	// blIncItmVsTypeDTO.setHpsrvtp("");
	// blIncItmVsTypeDTO.setHp_name("");
	// }
	// else
	// {
	// blIncItmVsTypeDTO.setHpsrvtp(blCgItmOepDOs[k].getSd_hpsrvtp());
	// blIncItmVsTypeDTO.setHp_name(gethp_name(blCgItmOepDOs[k].getSd_hpsrvtp()));
	//
	// }
	// //
	// blIncItmVsTypeDTO.setInvoicetype(st_srv_invoicetype.get(blCgItmOepDOs[k].getId_srv()));
	// blIncItmVsTypeDTO.setInvoicetype(blCgItmOepDOs[k].getName_inccaitm());
	// // if(blPrintIncInfoDTO.getCode_st()==null)
	// // {
	// // blPrintIncInfoDTO.setDatetime_print(fDateTime);//打印时间与结算时间相同
	// // }
	// blIncItmVsTypeDTO.setDatetime_print(fDateTime);//打印时间与结算时间相同
	//
	// blIncItmVsTypeDTO.setFg_mm(FBoolean.FALSE);
	// if(blCgItmOepDOs[k].getFg_mm()!=null &&
	// blCgItmOepDOs[k].getFg_mm().booleanValue())
	// {
	// // if(!id_presList.contains(blCgItmOepDOs[k].getId_pres()))
	// // {
	// //改由前台区分
	//
	// OpPresQueSiteDTO opPresQueSiteDTO
	// =iMpDgOutService.insertPresWindowData(blCgItmOepDOs[k].getId_pres(), 1);
	// if(opPresQueSiteDTO!=null)
	// {
	// blIncItmVsTypeDTO.setWindowinfo(opPresQueSiteDTO.getName_quesite());
	// blIncItmVsTypeDTO.setFg_Window(opPresQueSiteDTO.getFg_window());
	// blIncItmVsTypeDTO.setFg_mm(FBoolean.TRUE);
	// }
	// id_presList.add(blCgItmOepDOs[k].getId_pres());
	// // }
	// }
	//
	// blIncItmVsTypeDTOlist.add(blIncItmVsTypeDTO);
	// }
	//
	// }
	//
	//
	// //9.更新记账信息
	// IBlcgoepCudService
	// iBlcgoepCudService1=ServiceFinder.find(IBlcgoepCudService.class);
	// BlcgoepAggDO[] BlcgoepAggDO_arr=iBlcgoepCudService1.save(blcgoepAggDO);
	// if(BlcgoepAggDO_arr==null)
	// {
	// throw new BizException("更新记账挂起数据失败");
	// }
	//
	// //10.若打印发票，则需要付款后需要修改当前票据号
	// IBLInvoiceService iBLInvoiceService =
	// ServiceFinder.find(IBLInvoiceService.class);
	//
	// //String curno=String.valueOf(Long.parseLong(maxInvoiceno)+1);
	// String curno=computeNextInvoiceNo(maxInvoiceno);
	// iBLInvoiceService.SetCurNoByParamNo(blpaypatoepAggDOs[0].getParentDO().getId_emp_pay(),
	// IBdInccaCodeConst.ID_OUTPATIENT_INVOICE,curno);
	//
	// //11.发事件
	// try
	// {
	// this.invokeOepSettlementEvent(BlcgoepAggDO_arr, blpaypatoepAggDO,
	// blStOepDO1[0],blincoepAggDOArrx1[0],IBlFunCodeConst.FUN_CODE_OPFEECOLLECT);
	// //尝试把CI的发事件代码复制过来
	// if(id_orsrvLst!=null || id_orsrvLst.size()>0)
	// {
	// this.invokeOepCiOrderEvent(id_orsrvLst);
	// }
	//
	// }
	// catch (Exception ex) {
	// // xap.mw.runtime.msys.logging.
	// }
	// //return IncIdmmVsWindowInfo(blIncItmVsTypeDTOlist.toArray(new
	// BlIncItmVsTypeDTO[]{}),OpDgQueSiteDTOs_WindowInfo);
	//
	//
	// //12.处理金额减免
	// // if(Eu_freemd==BlFreeMdEnum.AMT_FREE_MD) //金额减免
	// // {
	// // //由账单减免项组装的发票明细DTO，确保打印的发票和门诊明细清单账目金额相等
	// // List<BlIncItmVsTypeDTO>
	// blIncItmVsTypeDTO_freeLst=bLCiOrderToBlCgServiceImplBp.getBlIncItmVsTypeDTO_freeLst(blincoepAggDOArrx[0].getParentDO().getId_incoep(),
	// blIncItmVsTypeDTOlist.toArray(new BlIncItmVsTypeDTO[0])[0]);
	// // blIncItmVsTypeDTOlist.addAll(blIncItmVsTypeDTO_freeLst);
	// // }
	//
	// return blIncItmVsTypeDTOlist.toArray(new BlIncItmVsTypeDTO[0]);
	// }

	// /**
	// * 门诊结算：不含分摊的付款
	// */
	// @Override
	// public BlIncItmVsTypeDTO[] SettlementPayment_test(BlcgoepAggDO[]
	// blcgoepAggDO,BlpaypatoepAggDO blpaypatoepAggDO,FBoolean
	// PrintInvoice,FBoolean IsTransferPrepay) throws BizException
	// {
	// TimeService timeService = new TimeServiceImpl();
	// FDateTime fDateTime =timeService.getUFDateTime();
	// GetInvoiceType getInvoiceType=new GetInvoiceType();
	// String id_incca=IBdInccaCodeConst.ID_OUTPATIENT_INVOICE; //门诊发票
	//
	// //Map<String,String> st_srv_invoicetype=new HashMap<String,String>();
	// Map<String,String> blStOepMapEnt=new HashMap<String,String>();
	// Map<String,FDateTime> blStOepMapDtst=new HashMap<String,FDateTime>();
	// List<BlIncItmVsTypeDTO> blIncItmVsTypeDTOlist=new
	// ArrayList<BlIncItmVsTypeDTO>();
	// String
	// key="",srv_invoicename="",tempKeys="",keys="",values="",pkg_code="";
	// String[] arr_ent_invoice;
	// Map<String,String> blCgItmOepMapCodeSt=new HashMap<String,String>();
	// Map<String,String> ent_invoice=new HashMap<String,String>();
	// Map<String,String> ent_invoice_pkgcodem=new HashMap<String,String>();
	// String id_cgoeps="",tempKey="",maxInvoiceno="";
	// OperatorInfoDTO operatorInfoDTO=new OperatorInfoDTO();
	// operatorInfoDTO.setId_grp(blpaypatoepAggDO.getParentDO().getId_grp());
	// operatorInfoDTO.setId_org(blpaypatoepAggDO.getParentDO().getId_org());
	// operatorInfoDTO.setId_dep(blpaypatoepAggDO.getParentDO().getId_dep_pay());
	// operatorInfoDTO.setId_emp(blpaypatoepAggDO.getParentDO().getId_emp_pay());
	// operatorInfoDTO.setId_org_emp(blpaypatoepAggDO.getParentDO().getId_org());
	// List<String> id_orsrvLst=new ArrayList<String>();
	// String pay_way="";//收款方式，前台打印用
	//
	//
	// PriceSettleBP priceBp=new PriceSettleBP();
	// //1.入口验证
	// priceBp.validate_settlementPayment(blcgoepAggDO, blpaypatoepAggDO);
	//
	//
	// //2.保存患者收付款
	// BlPayPatOepDO blPayPatOepDO= blpaypatoepAggDO.getParentDO();
	// blPayPatOepDO.setDt_pay(fDateTime);
	// blPayPatOepDO.setStatus(DOStatus.NEW);
	// blpaypatoepAggDO.setParentDO(blPayPatOepDO);
	// for(BlPayItmPatOepDO blPayItmPatOepDO:
	// blpaypatoepAggDO.getBlPayItmPatOepDO())
	// {
	// blPayItmPatOepDO.setFg_realpay(FBoolean.TRUE);//真实数据
	// pay_way=pay_way+","+getPm_way(blPayItmPatOepDO.getSd_pm());//收款方式
	// }
	// pay_way=pay_way.substring(1);
	// Object obj222 = ServiceFinder.find(IBlpaypatoepCudService.class);
	// BlpaypatoepAggDO[]
	// blpaypatoepAggDOs=((IBlpaypatoepCudService)obj222).save(new
	// BlpaypatoepAggDO[]{blpaypatoepAggDO});
	// if(null==blpaypatoepAggDOs)
	// {
	// throw new BizException("保存患者收付款信息失败");
	// }
	// //2.1如果患者采用预交金支付或结存，则处理预交金，且修改门诊预交金账户,修改门诊预交金消费锁定金额
	// DoOepFgAccAmtAcc doOepFgAccAmtAccBp=new DoOepFgAccAmtAcc();
	// doOepFgAccAmtAccBp.doOepPrepayConsumeAndTransferPrepay(blcgoepAggDO,
	// blpaypatoepAggDOs, IsTransferPrepay, fDateTime);
	//
	// //3.获得本次结算的结算ID：Id_stoep
	// String id_stoeps="";
	// String id_stoeps_incoep="";
	// for(int i=0;i<blcgoepAggDO.length;i++)
	// {
	// BlCgItmOepDO[] blCgItmOepDOs=blcgoepAggDO[i].getBlCgItmOepDO();
	// for(int j=0;j<blCgItmOepDOs.length;j++)
	// {
	// if(id_stoeps.indexOf("'"+blCgItmOepDOs[j].getId_stoep()+"'")<0)
	// {
	// id_stoeps=id_stoeps+" or "+BlStOepDODesc.TABLE_ALIAS_NAME+".id_stoep='"+blCgItmOepDOs[j].getId_stoep()+"' ";
	// //
	// id_stoeps_incoep=id_stoeps_incoep+" or "+"id_stoep='"+blCgItmOepDOs[j].getId_stoep()+"' ";
	// id_stoeps_incoep=id_stoeps_incoep+",'"+blCgItmOepDOs[j].getId_stoep()+"'";
	// }
	// // if(blCgItmOepDOs[j].getEu_srctp()==1)
	// // {
	// // PrintOnlyOneInvoice=FBoolean.FALSE;//就诊来源的数据，则分开打发票
	// // }
	// }
	// }
	// if(id_stoeps.length()<3)
	// {
	// throw new BizException("查询患者结算信息失败");
	// }
	// id_stoeps=id_stoeps.substring(3);
	// id_stoeps_incoep="id_stoep in ("+id_stoeps_incoep.substring(1)+")";
	// //从发票表中查询
	//
	// //3.1查询发票信息
	// IBlincoepRService
	// iBlincoepRService=ServiceFinder.find(IBlincoepRService.class);
	// IBlincoepCudService
	// iBlincoepCudService=ServiceFinder.find(IBlincoepCudService.class);
	// BlincoepAggDO[]
	// blincoepAggDOArrx=iBlincoepRService.find(id_stoeps_incoep, "",
	// FBoolean.TRUE);
	// if(blincoepAggDOArrx==null || blincoepAggDOArrx.length==0)
	// {
	// throw new BizException("门诊结算：查询患者发票信息失败");
	// }
	//
	// //3.2 处理减免的业务逻辑
	// DoOepFgFree doOepFgFree=new DoOepFgFree();
	// int Eu_freemd=doOepFgFree.DoOep_FgFree(blcgoepAggDO, blpaypatoepAggDO,
	// blincoepAggDOArrx[0]);
	//
	// //查是否有分摊
	// if(isPayByMedInsur(id_stoeps_incoep.substring(1)).booleanValue())
	// {
	// pay_way=pay_way+",医保基金";
	// }
	//
	//
	// //4.根据Id_stoep，查询ST表，并回写ST表中Id_paypatoep
	// IBlstoepRService
	// iBlstoepRService=ServiceFinder.find(IBlstoepRService.class);
	// BlStOepDO[] blStOepDO=iBlstoepRService.find(id_stoeps, "",
	// FBoolean.FALSE);
	// if(null==blStOepDO)
	// {
	// throw new BizException("查询患者结算信息失败");
	// }
	// //修改门诊结算信息，回写收付款外键：blStOepDO
	// for(int i=0;i<blStOepDO.length;i++)
	// {
	// blStOepDO[i].setId_paypatoep(blpaypatoepAggDOs[0].getParentDO().getId_paypatoep());
	// //医生站接诊的数据没有收款员消息
	// if(blStOepDO[i].getId_emp_st()==null ||
	// blStOepDO[i].getId_emp_st().length()==0)
	// {
	// blStOepDO[i].setId_emp_st(operatorInfoDTO.getId_emp());
	// }
	// if(blStOepDO[i].getId_dep_st()==null ||
	// blStOepDO[i].getId_dep_st().length()==0)
	// {
	// blStOepDO[i].setId_dep_st(operatorInfoDTO.getId_dep());
	// }
	// if(blStOepDO[i].getId_org()==null ||
	// blStOepDO[i].getId_org().length()==0)
	// {
	// blStOepDO[i].setId_org(operatorInfoDTO.getId_org());
	// }
	// if(blStOepDO[i].getId_grp()==null ||
	// blStOepDO[i].getId_grp().length()==0)
	// {
	// blStOepDO[i].setId_grp(operatorInfoDTO.getId_grp());
	// }
	//
	// blStOepDO[i].setStatus(DOStatus.UPDATED);
	// // if(PrintOnlyOneInvoice.booleanValue())
	// // {
	// key=blStOepDO[i].getId_pat();
	// // }
	// // else
	// // {
	// //
	// key=blStOepDO[i].getId_pat()+" "+blStOepDO[i].getId_ent()+" "+blStOepDO[i].getId_enttp();
	// // }
	// if(!blStOepMapEnt.containsKey(key))//《就诊，结算号》
	// {
	// blStOepMapEnt.put(key, blStOepDO[i].getCode_st());
	// }
	// if(!blStOepMapDtst.containsKey(key))//《就诊，日期》
	// {
	// blStOepMapDtst.put(key, blStOepDO[i].getDt_st());
	// }
	// }
	// IBlstoepCudService
	// iBlstoepCudService=ServiceFinder.find(IBlstoepCudService.class);
	// BlStOepDO[] blStOepDO1=iBlstoepCudService.save(blStOepDO);
	// if(null==blStOepDO1)
	// {
	// throw new BizException("更新患者结算信息失败");
	// }
	//
	// //5.不打印发票，则直接更新记账挂起标志
	// if(!PrintInvoice.booleanValue()) //不打印发票
	// {
	// BlIncItmVsTypeDTO[] blIncItmVsTypeDTO=new BlIncItmVsTypeDTO[1];
	// blIncItmVsTypeDTO[0]=new BlIncItmVsTypeDTO();
	// blIncItmVsTypeDTO[0].setId_cgoep(blcgoepAggDO[0].getParentDO().getId_cgoep());
	// for(int kk=0;kk<blcgoepAggDO.length;kk++) //门诊记账Agg
	// {
	// //更新记账明细，需要更改主DO的状态为更新
	// BlCgOepDO blCgoepDo=blcgoepAggDO[kk].getParentDO();
	// blCgoepDo.setStatus(DOStatus.UPDATED);
	// //记账明细字段更新
	// BlCgItmOepDO[] blCgItmOepDOs=blcgoepAggDO[kk].getBlCgItmOepDO();
	// for(int k=0;k<blCgItmOepDOs.length;k++)//门诊记账明细表
	// {
	// if(blCgItmOepDOs[k].getId_orsrv()!=null)
	// {
	// id_orsrvLst.add(blCgItmOepDOs[k].getId_orsrv());
	// }
	// blCgItmOepDOs[k].setFg_susp(FBoolean.FALSE);
	// blCgItmOepDOs[k].setFg_st(FBoolean.TRUE); //已结算
	// blCgItmOepDOs[k].setStatus(DOStatus.UPDATED);
	// }
	// }
	// //更新记账信息
	// IBlcgoepCudService
	// iBlcgoepCudService1=ServiceFinder.find(IBlcgoepCudService.class);
	// BlcgoepAggDO[] BlcgoepAggDO_arr=iBlcgoepCudService1.save(blcgoepAggDO);
	// if(BlcgoepAggDO_arr==null)
	// {
	// throw new BizException("更新记账挂起数据失败");
	// }
	// return blIncItmVsTypeDTO;
	// }
	//
	// //***************************以下要打印发票了*********************
	//
	// //5.更新记账挂起标志
	// for(int kk=0;kk<blcgoepAggDO.length;kk++) //门诊记账Agg
	// {
	// //根据结算号，查询对应的服务和服务所属发票项目类型
	// id_cgoeps=id_cgoeps+",'"+blcgoepAggDO[kk].getParentDO().getId_cgoep()+"'";
	// }
	// id_cgoeps=id_cgoeps.substring(2);
	// id_cgoeps=id_cgoeps.substring(0,id_cgoeps.length()-1);
	// //
	// st_srv_invoicetype=getInvoiceType.GetInvocieTypeByBlCgOepId(id_incca,id_cgoeps);
	// // //获得《就诊，结算号》
	// srv_invoicename=blcgoepAggDO[0].getParentDO().getEnt_invoiceno();
	// pkg_code=blcgoepAggDO[0].getParentDO().getEnt_invoice_pkgcode();
	// if(srv_invoicename.indexOf("|")>0)
	// {
	// arr_ent_invoice=srv_invoicename.split("\\|");
	// for(int ll=0;ll<arr_ent_invoice.length;ll++)
	// {
	// tempKeys=arr_ent_invoice[ll];
	// keys=tempKeys.substring(0, tempKeys.indexOf(','));
	// values=tempKeys.substring(tempKeys.indexOf(',')+1);
	// ent_invoice.put(keys, values);
	// if(maxInvoiceno.compareTo(values)<0)
	// {
	// maxInvoiceno=values;
	// }
	// }
	// }
	// if(pkg_code.indexOf("|")>0)
	// {
	// arr_ent_invoice=pkg_code.split("\\|");
	// for(int ll=0;ll<arr_ent_invoice.length;ll++)
	// {
	// tempKeys=arr_ent_invoice[ll];
	// keys=tempKeys.substring(0, tempKeys.indexOf(','));
	// values=tempKeys.substring(tempKeys.indexOf(',')+1);
	// ent_invoice_pkgcodem.put(keys, values);
	// }
	// }
	//
	//
	// //6.修改INC表中打印发票的标志
	//
	// for(BlincoepAggDO blincoepAggDO:blincoepAggDOArrx)
	// {
	//
	// // if(PrintOnlyOneInvoice.booleanValue())
	// // {
	// key=blincoepAggDO.getParentDO().getId_pat();
	// // }
	// // else
	// // {
	// //
	// key=blincoepAggDO.getParentDO().getId_pat()+" "+blincoepAggDO.getParentDO().getId_ent()+" "+blincoepAggDO.getParentDO().getId_enttp();
	// // }
	// blincoepAggDO.getParentDO().setFg_print(FBoolean.TRUE);
	// if(blincoepAggDO.getParentDO().getIncno()==null)
	// {
	// blincoepAggDO.getParentDO().setIncno(ent_invoice.get(key));
	// blincoepAggDO.getParentDO().setCode_incpkg(ent_invoice_pkgcodem.get(key));
	// }
	// //医生站接诊挂号产生的数据没有这些信息
	// if(blincoepAggDO.getParentDO().getId_grp()==null ||
	// blincoepAggDO.getParentDO().getId_grp().length()==0)
	// {
	// blincoepAggDO.getParentDO().setId_grp(operatorInfoDTO.getId_grp());
	// }
	// if(blincoepAggDO.getParentDO().getId_org()==null ||
	// blincoepAggDO.getParentDO().getId_org().length()==0)
	// {
	// blincoepAggDO.getParentDO().setId_org(operatorInfoDTO.getId_org());
	// }
	//
	// // blincoepAggDO.getParentDO().setDt_inc(Dt_inc);(FBoolean.TRUE);
	//
	// // if(blincoepAggDO.getParentDO().getCode_incpkg()==null)
	// // {
	//
	// // }
	// blincoepAggDO.getParentDO().setId_emp_canc(null);
	// blincoepAggDO.getParentDO().setId_emp_inc(blpaypatoepAggDO.getParentDO().getId_emp_pay());
	// blincoepAggDO.getParentDO().setTimes_prn(1);
	//
	// blincoepAggDO.getParentDO().setStatus(DOStatus.UPDATED);
	// }
	// BlincoepAggDO[]
	// blincoepAggDOArrx1=iBlincoepCudService.save(blincoepAggDOArrx);
	//
	// //7.<就诊，发票开立人>
	// String
	// ent_invoice_empnames=blcgoepAggDO[0].getParentDO().getEnt_invoice_empname();
	// String[] ent_invoice_empnames_arr=ent_invoice_empnames.split("\\|");
	// Map<String,String> ent_empname=new HashMap<String,String>();
	// for(int i=0;i<ent_invoice_empnames_arr.length;i++)
	// {
	// String[] temps=ent_invoice_empnames_arr[i].split(",");
	// if(!ent_empname.containsKey(temps[0]))
	// {
	// ent_empname.put(temps[0], temps[1]);
	// }
	// }
	//
	// //8.打发票
	// BLCiOrderToBlCgServiceImplBp bLCiOrderToBlCgServiceImplBp=new
	// BLCiOrderToBlCgServiceImplBp();
	// String
	// inc_emp_name=ent_empname.get(blcgoepAggDO[0].getParentDO().getId_pat());
	// String
	// code_st=blStOepMapEnt.get(blcgoepAggDO[0].getParentDO().getId_pat());
	// FDateTime
	// datetime_st=blStOepMapDtst.get(blcgoepAggDO[0].getParentDO().getId_pat());
	// FDateTime dateTime_print=fDateTime;
	// String incno=ent_invoice.get(blcgoepAggDO[0].getParentDO().getId_pat());
	// BlIncItmVsTypeDTO
	// blIncItmVsTypeDTO=bLCiOrderToBlCgServiceImplBp.getBlIncItmVsTypeDTO(blcgoepAggDO,
	// inc_emp_name, pay_way, code_st, datetime_st, dateTime_print, Eu_freemd,
	// incno);
	// blIncItmVsTypeDTOlist.add(blIncItmVsTypeDTO);
	//
	// //9.更新记账信息
	// IBlcgoepCudService
	// iBlcgoepCudService1=ServiceFinder.find(IBlcgoepCudService.class);
	// BlcgoepAggDO[] BlcgoepAggDO_arr=iBlcgoepCudService1.save(blcgoepAggDO);
	// if(BlcgoepAggDO_arr==null)
	// {
	// throw new BizException("更新记账挂起数据失败");
	// }
	//
	// //10.若打印发票，则需要付款后需要修改当前票据号
	// IBLInvoiceService iBLInvoiceService =
	// ServiceFinder.find(IBLInvoiceService.class);
	//
	// //String curno=String.valueOf(Long.parseLong(maxInvoiceno)+1);
	// String curno=computeNextInvoiceNo(maxInvoiceno);
	// iBLInvoiceService.SetCurNoByParamNo(blpaypatoepAggDOs[0].getParentDO().getId_emp_pay(),
	// IBdInccaCodeConst.ID_OUTPATIENT_INVOICE,curno);
	//
	// //11.发事件
	// try
	// {
	// this.invokeOepSettlementEvent(BlcgoepAggDO_arr, blpaypatoepAggDO,
	// blStOepDO1[0],blincoepAggDOArrx1[0],IBlFunCodeConst.FUN_CODE_OPFEECOLLECT);
	// //尝试把CI的发事件代码复制过来
	// if(id_orsrvLst!=null || id_orsrvLst.size()>0)
	// {
	// this.invokeOepCiOrderEvent(id_orsrvLst);
	// }
	//
	// }
	// catch (Exception ex) {
	// // xap.mw.runtime.msys.logging.
	// }
	// //return IncIdmmVsWindowInfo(blIncItmVsTypeDTOlist.toArray(new
	// BlIncItmVsTypeDTO[]{}),OpDgQueSiteDTOs_WindowInfo);
	//
	//
	// //12.处理金额减免
	// if(Eu_freemd==BlFreeMdEnum.AMT_FREE_MD) //金额减免
	// {
	// //由账单减免项组装的发票明细DTO，确保打印的发票和门诊明细清单账目金额相等
	// List<BlIncItmVsTypeDTO>
	// blIncItmVsTypeDTO_freeLst=bLCiOrderToBlCgServiceImplBp.getBlIncItmVsTypeDTO_freeLst(blincoepAggDOArrx[0].getParentDO().getId_incoep(),
	// blIncItmVsTypeDTOlist.toArray(new BlIncItmVsTypeDTO[0])[0]);
	// blIncItmVsTypeDTOlist.addAll(blIncItmVsTypeDTO_freeLst);
	// }
	//
	// return blIncItmVsTypeDTOlist.toArray(new BlIncItmVsTypeDTO[0]);
	// }
	// // /**
	// * 返回发票打印的DTO
	// * @param blcgoepAggDO 记账AGG
	// * @param inc_emp_name 发票人员
	// * @param pay_way 支付方式
	// * @param code_st 结算号
	// * @param datetime_st 结算日期
	// * @param DateTime_print 打印日期
	// * @param Eu_freemd 减免方式
	// * @param incno 发票号
	// * @return 返回发票打印的DTO
	// * @throws BizException
	// */
	// public BlIncItmVsTypeDTO getBlIncItmVsTypeDTOArr(BlcgoepAggDO[]
	// blcgoepAggDO,String inc_emp_name,String pay_way,String code_st,FDateTime
	// datetime_st,FDateTime DateTime_print,int Eu_freemd,String incno) throws
	// BizException
	// {
	// List<BlIncItmVsTypeDTO> blIncItmVsTypeDTOlist=new
	// ArrayList<BlIncItmVsTypeDTO>();
	// FArrayList blInvoiceDetailsDTOLst=new FArrayList();
	// BlIncItmVsTypeDTO blIncItmVsTypeDTO=new BlIncItmVsTypeDTO();
	// Map<String,String> measDocDOMap =getMeasDocDOMap();
	// IMpDgOutService
	// iMpDgOutService=ServiceFinder.find(IMpDgOutService.class);
	// List<String> id_presList=new ArrayList<String>();
	// BIncSumAmtInfoDTO blPrintIncInfoDTO=new BIncSumAmtInfoDTO();
	// BlInvoiceHeadTailDTO blInvoiceHeadTailDTO=new BlInvoiceHeadTailDTO();
	// FDouble sum_amt_std=new FDouble(0);
	// FDouble sum_amt_pat=new FDouble(0);
	//
	// for(int t=0;t<blcgoepAggDO.length;t++)
	// {
	// BlCgOepDO blCgoepDo=blcgoepAggDO[t].getParentDO();
	// BlCgItmOepDO[] blCgItmOepDOs=blcgoepAggDO[t].getBlCgItmOepDO();
	// for(int k=0;k<blCgItmOepDOs.length;k++)//门诊记账明细表
	// {
	// sum_amt_std=sum_amt_std.add(blCgItmOepDOs[k].getAmt_std());
	// sum_amt_pat=sum_amt_pat.add(blCgItmOepDOs[k].getAmt());
	// BlInvoiceDetailsDTO blInvoiceDetailsDTO=new BlInvoiceDetailsDTO();
	// blInvoiceDetailsDTO.setId_cgoep(blCgItmOepDOs[k].getId_cgoep());
	// blInvoiceDetailsDTO.setId_mm(blCgItmOepDOs[k].getId_mm());
	// blInvoiceDetailsDTO.setSrvu(measDocDOMap.get(blCgItmOepDOs[k].getSrvu()));
	// //名称，规格
	// if(null==blCgItmOepDOs[k].getFg_mm() ||
	// blCgItmOepDOs[k].getFg_mm()==FBoolean.FALSE)
	// {
	// blInvoiceDetailsDTO.setName_srv(blCgItmOepDOs[k].getName_srv());
	// //规格
	// blInvoiceDetailsDTO.setSpec_srv(blCgItmOepDOs[k].getSpec());
	// }
	// else
	// {
	// blInvoiceDetailsDTO.setName_srv(blCgItmOepDOs[k].getName_srv()+"("+blCgItmOepDOs[k].getName_mm()+")");
	// //规格
	// blInvoiceDetailsDTO.setSpec_srv(blCgItmOepDOs[k].getSpec());
	// }
	// blInvoiceDetailsDTO.setQuan(blCgItmOepDOs[k].getQuan());
	// blInvoiceDetailsDTO.setAmt_std(blCgItmOepDOs[k].getAmt_std());
	// //比例金额-医保基金支付-医保个人账户支付
	// blInvoiceDetailsDTO.setAmt_pat(blCgItmOepDOs[k].getAmt()); //个人自付
	// blInvoiceDetailsDTO.setPrice(blCgItmOepDOs[k].getPrice());
	// if(Eu_freemd==BlFreeMdEnum.ITM_FREE_MD) //项目减免
	// {
	// blInvoiceDetailsDTO.setName_srv(blIncItmVsTypeDTO.getName_srv()+"-减免");
	// blInvoiceDetailsDTO.setAmt_std(new FDouble(0));
	// blInvoiceDetailsDTO.setAmt_pat(new FDouble(0));
	// }
	//
	// if(blCgItmOepDOs[k].getSd_hpsrvtp()==null)
	// {
	// blInvoiceDetailsDTO.setHpsrvtp("");
	// blInvoiceDetailsDTO.setHp_name("");
	// }
	// else
	// {
	// blInvoiceDetailsDTO.setHpsrvtp(blCgItmOepDOs[k].getSd_hpsrvtp());
	// blInvoiceDetailsDTO.setHp_name(gethp_name(blCgItmOepDOs[k].getSd_hpsrvtp()));
	// }
	// blInvoiceDetailsDTO.setInvoicetype(blCgItmOepDOs[k].getName_inccaitm());
	// blInvoiceDetailsDTO.setFg_mm(FBoolean.FALSE);
	// if(blCgItmOepDOs[k].getFg_mm()!=null &&
	// blCgItmOepDOs[k].getFg_mm().booleanValue())
	// {
	// OpPresQueSiteDTO opPresQueSiteDTO
	// =iMpDgOutService.insertPresWindowData(blCgItmOepDOs[k].getId_pres(), 1);
	// blInvoiceDetailsDTO.setWindowinfo(opPresQueSiteDTO.getName_quesite());
	// blInvoiceDetailsDTO.setFg_Window(opPresQueSiteDTO.getFg_window());
	// blInvoiceDetailsDTO.setFg_mm(FBoolean.TRUE);
	// id_presList.add(blCgItmOepDOs[k].getId_pres());
	// }
	// blInvoiceDetailsDTOLst.add(blInvoiceDetailsDTO);
	// }
	// }
	// blInvoiceHeadTailDTO.setInc_emp_name(inc_emp_name);
	// blInvoiceHeadTailDTO.setPay_tp(pay_way); //支付方式
	// blInvoiceHeadTailDTO.setCode_st(code_st);
	// blInvoiceHeadTailDTO.setDatetime_st(datetime_st);//结算时间
	// blInvoiceHeadTailDTO.setIncno(incno);
	// blInvoiceHeadTailDTO.setDatetime_print(DateTime_print);//打印时间与结算时间相同
	// blInvoiceHeadTailDTO.setAmt_std(sum_amt_std);
	// //比例金额-医保基金支付-医保个人账户支付
	// blInvoiceHeadTailDTO.setAmt_pat(sum_amt_pat); //个人自付
	// blInvoiceHeadTailDTO.setAmt_tc(new FDouble(0));//医保基金支付
	// blInvoiceHeadTailDTO.setAmt_qtyb(new FDouble(0));//其他医保
	// blInvoiceHeadTailDTO.setAmt_grzf(new FDouble(0));//个人账户支付
	// blIncItmVsTypeDTO.setBlInvoiceHeadTailDTO(blInvoiceHeadTailDTO);
	// blIncItmVsTypeDTO.setBlInvoiceDetailsDTO(blInvoiceDetailsDTOLst);
	// return blIncItmVsTypeDTO;
	// }
	//
	/**
	 * 
	 * @param blpaypatoepAggDO
	 * @param id_stoep
	 * @return
	 * @throws BizException
	 */
	private String getPm_way_ByBlpaypatAndIdstoep(BlpaypatoepAggDO blpaypatoepAggDO, String id_stoep) throws BizException {
		String pm_way = "";
		BlPayItmPatOepDO[] blPayItmPatOepDOArr = blpaypatoepAggDO.getBlPayItmPatOepDO();
		for (BlPayItmPatOepDO blPayItmPatOepDO : blPayItmPatOepDOArr) {
			pm_way = pm_way + "," + getPm_way(blPayItmPatOepDO.getSd_pm());
		}
		if (pm_way.length() > 1) {
			pm_way = pm_way.substring(1);
		}
		if (isPayByMedInsur("'" + id_stoep + "'").booleanValue()) {
			if (pm_way.length() > 1) {
				pm_way = pm_way + ",医保基金";
			} else {
				pm_way = "医保基金";
			}
		}
		return pm_way;
	}

	private String getPm_way_ByIdStoep(String id_stoep) throws BizException {
		String pm_way = "";
		StringBuffer sqlb = new StringBuffer();
		sqlb.append("  select c.sd_pm");
		sqlb.append("    from bl_st_oep a");
		sqlb.append("   inner join bl_pay_pat_oep b");
		sqlb.append("      on a.id_paypatoep = b.id_paypatoep");
		sqlb.append("   inner join bl_pay_itm_pat_oep c");
		sqlb.append("      on b.id_paypatoep = c.id_paypatoep");
		sqlb.append("   where a.id_stoep=?");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_stoep);
		DAFacade dafacade = new DAFacade();
		List<BlPayItmPatOepDO> blPayItmPatOepDOLst = (List<BlPayItmPatOepDO>) dafacade.execQuery(sqlb.toString(), sqlp, new BeanListHandler(BlPayItmPatOepDO.class));
		if (blPayItmPatOepDOLst != null && blPayItmPatOepDOLst.size() > 0) {
			for (BlPayItmPatOepDO blPayItmPatOepDO : blPayItmPatOepDOLst) {
				pm_way = pm_way + "," + getPm_way(blPayItmPatOepDO.getSd_pm());
			}
		}
		if (pm_way.length() > 1) {
			pm_way = pm_way.substring(1);
		}
		if (isPayByMedInsur("'" + id_stoep + "'").booleanValue()) {
			if (pm_way.length() > 1) {
				pm_way = pm_way + ",医保基金";
			} else {
				pm_way = "医保基金";
			}
		}
		return pm_way;
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
	 * 根据医保对照类型SD，返回对应名称
	 * 
	 * @param sd_hpsrvtp
	 *            医保对照类型SD
	 * @return 医保对照类型名称
	 */
	private String gethp_name(String sd_hpsrvtp) {
		String hp_name = "";
		switch (sd_hpsrvtp) {
		case IBdPpCodeTypeConst.SD_HP_BJ_ONE:
			hp_name = "甲类";
			break;
		case IBdPpCodeTypeConst.SD_HP_BJ_TOW:
			hp_name = "乙类";
			break;
		case IBdPpCodeTypeConst.SD_HP_BJ_THREE:
			hp_name = "丙类";
			break;
		default:
			break;
		}
		return hp_name;
	}

	/**
	 * 获取计量单位列表
	 * 
	 * @throws BizException
	 * */
	private Map<String, String> getMeasDocDOMap() throws BizException {

		Map<String, String> measMap = new HashMap<String, String>();// 计量单位字典

		// 查询：调用轻量级的服务
		String[] fields = { "Id_measdoc", "Name" }; // 需要查询的列
		DAFacade dAFacade = new DAFacade();
		List<MeasDocDO> measDocDOList = (List<MeasDocDO>) dAFacade.findByCond(MeasDocDO.class, "1=1", "1", fields);
		if (measDocDOList != null && measDocDOList.size() > 0) {
			for (MeasDocDO measDocDO : measDocDOList) {
				if (measMap.get(measDocDO.getId_measdoc()) == null) {
					measMap.put(measDocDO.getId_measdoc(), measDocDO.getName());
				}
			}
		}
		return measMap;
	}

	/**
	 * 重新打印门诊发票，将原发票信息放在空白作废票中，新发票号替换原发票号 只能重新打印当前票号的上一张号
	 * 
	 * @param id_stoep
	 *            欲重打发票的结算号
	 * @param operatorInfo
	 *            操作员信息
	 * @param code_incpkg
	 *            票据包
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlIncItmVsTypeDTO[] doRepeatPrintOepInvoice(String id_stoep, OperatorInfoDTO operatorInfo, String code_incpkg) throws BizException {
		BlIncItmVsTypeDTO[] blIncItmVsTypeDTOArr = null;
		List<BlIncItmVsTypeDTO> blIncItmVsTypeDTOlist = new ArrayList<BlIncItmVsTypeDTO>();
		List<BlIncCancDO> BlIncCancDOLst = new ArrayList<BlIncCancDO>();
		String code_incca = IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE;// 门诊发票
		Map<String, String> id_stoepVSincno = new HashMap<String, String>();
		FDateTime currentFt = AppUtils.getServerDateTime();
		if (id_stoep == null || id_stoep.trim() == "") {
			throw new BizException("没有传入门诊结算号！");
		}
		// 1.查询收付款方式
		String pm_way = this.getPm_way_ByIdStoep(id_stoep);

		// 2.分派发票号
		IBLInvoiceService iBLInvoiceService = ServiceFinder.find(IBLInvoiceService.class);
		String invoiceNo = iBLInvoiceService.GetInvoiceNo(operatorInfo.getId_emp(), code_incca);
		// 3.查询原来门诊发票实体
		IBlincoepRService iBlincoepRService = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] blincoepAggDOArr = iBlincoepRService.find(BlIncOepDODesc.TABLE_ALIAS_NAME + ".id_stoep='" + id_stoep + "'", "", FBoolean.FALSE);

		// 4.校验：只能处理：未结账+本人作废票
		if (blincoepAggDOArr != null && blincoepAggDOArr.length > 0) {
			for (BlincoepAggDO blincoepAggDO : blincoepAggDOArr) {
				if (blincoepAggDO.getParentDO().getFg_cc_out() != null && blincoepAggDO.getParentDO().getFg_cc_out().booleanValue()) {
					throw new BizException("只能重打未结账的发票，若处理已结账的发票请采用重划重收操作！");
				}
				if (!blincoepAggDO.getParentDO().getId_emp_inc().equals(operatorInfo.getId_emp())) {
					throw new BizException("补打发票，请采用重划重收操作"); // 非本开具
				}
			}

		}

		// ////////////////////////////////////
		// 只能重新打印当前发票的前一张票（不支持多次就诊分开结算的模式）
		// 校验：是否是当前票号的上一张号
		IBlstoepRService iBlstoepRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO[] blStOepDO = iBlstoepRService.find(BlStOepDODesc.TABLE_ALIAS_NAME + ".id_stoep='" + id_stoep + "'", "", FBoolean.TRUE);
		GetBlPsnDocName getBlPsnDocName = new GetBlPsnDocName();
		String psn_name = getBlPsnDocName.GetBlPsnDocName(operatorInfo.getId_emp());
		Map<String, String> measDocDOMap = getMeasDocDOMap();
		IMpDgOutService iMpDgOutService = ServiceFinder.find(IMpDgOutService.class);
		FMap id_presMap = new FMap();
		BIncSumAmtInfoDTO blPrintIncInfoDTO = new BIncSumAmtInfoDTO();
		IBlCgItmOepDORService iBlCgItmOepDORService = ServiceFinder.find(IBlCgItmOepDORService.class);
		BlCgItmOepDO[] blCgItmOepDOs = iBlCgItmOepDORService.find(" id_stoep='" + id_stoep + "'", "", FBoolean.FALSE);
		GetInvoiceType getInvoiceType = new GetInvoiceType();
		// Map<String, String> st_srv_invoicetype_temp=new HashMap<String,
		// String>();
		// Map<String, String> st_srv_invoicetype=new HashMap<String, String>();
		// 得到<id_srv,发票分类>
		List<String> id_cgoepLst = new ArrayList<String>();
		for (int k = 0; k < blCgItmOepDOs.length; k++)// 门诊记账明细表
		{
			if (!id_cgoepLst.contains(blCgItmOepDOs[k].getId_cgoep())) {
				id_cgoepLst.add(blCgItmOepDOs[k].getId_cgoep());
			}
		}

		// 5.用新发票号修改原发票号

		int i = 0;
		if (blincoepAggDOArr != null && blincoepAggDOArr.length > 0) {
			for (BlincoepAggDO blincoepAggDO : blincoepAggDOArr) {
				BlIncOepDO blIncOepDO = blincoepAggDO.getParentDO();
				// 空白作废票
				BlIncCancDO blIncCancDO = new BlIncCancDO();
				blIncCancDO.setCode_incpkg(code_incpkg);
				blIncCancDO.setIncno(blIncOepDO.getIncno());
				blIncCancDO.setId_emp_canc(operatorInfo.getId_emp());
				blIncCancDO.setSd_reason_canc(IBdPpCodeTypeConst.SD_OTHER);
				blIncCancDO.setId_reason_canc(IBdPpCodeTypeConst.SD_OTHER);
				blIncCancDO.setId_incca(IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE);
				blIncCancDO.setDes_reason_canc(IBdPpCodeTypeConst.DES_OTHER);
				blIncCancDO.setDt_canc(AppUtils.getServerDateTime());
				blIncCancDO.setFg_canc(FBoolean.TRUE);
				blIncCancDO.setId_grp(operatorInfo.getId_grp());
				blIncCancDO.setId_org(operatorInfo.getId_org());
				blIncCancDO.setStatus(DOStatus.NEW);
				BlIncCancDOLst.add(blIncCancDO);

				// 更新的门诊发票
				blIncOepDO.setIncno(invoiceNo); // 结算与发票一一对应，因此只有一张发票
				blIncOepDO.setId_emp_inc(operatorInfo.getId_emp());
				blIncOepDO.setCode_incpkg(code_incpkg);
				blIncOepDO.setId_grp(operatorInfo.getId_grp());
				blIncOepDO.setId_org(operatorInfo.getId_org());
				blIncOepDO.setDt_inc(currentFt);
				blIncOepDO.setStatus(DOStatus.UPDATED);
				i++;
			}
		}
		// 6.存入作废发票表
		IBlinccancCudService iBlinccancCudService = ServiceFinder.find(IBlinccancCudService.class);
		BlIncCancDO[] BlIncCancDOArr1 = iBlinccancCudService.save(BlIncCancDOLst.toArray(new BlIncCancDO[0]));
		if (BlIncCancDOArr1 == null || BlIncCancDOArr1.length == 0) {
			throw new BizException("新增作废发票表失败！");
		}
		// 7.更新门诊发票
		IBlincoepCudService iBlincoepCudService = ServiceFinder.find(IBlincoepCudService.class);
		BlincoepAggDO[] blincoepAggDOArr1 = iBlincoepCudService.save(blincoepAggDOArr);
		if (blincoepAggDOArr1 == null || blincoepAggDOArr1.length == 0) {
			throw new BizException("更新发票号失败");
		}
		// 8.设置当前票号
		// String curno=String.valueOf(Long.parseLong(invoiceNo)+1);
		String curno = computeNextInvoiceNo(invoiceNo);
		iBLInvoiceService.SetCurNoByParamNo(operatorInfo.getId_emp(), IBdInccaCodeConst.ID_OUTPATIENT_INVOICE, curno);

		// 9.更改返回值的带打印的发票信息
		if (blIncItmVsTypeDTOlist != null || blIncItmVsTypeDTOlist.size() > 0) {
			blIncItmVsTypeDTOArr = blIncItmVsTypeDTOlist.toArray(new BlIncItmVsTypeDTO[0]);
		}
		return blIncItmVsTypeDTOArr;

	}

	/**
	 * 触发门诊收费事件
	 * 
	 * @param patDO
	 * @param regInfo
	 * @param pvDO
	 * @throws BizException
	 */
	private void invokeOepSettlementEvent(BlcgoepAggDO[] BlcgoepAggDO_arr, BlpaypatoepAggDO blpaypatoepAggDO, BlStOepDO blStOepDO1, BlincoepAggDO blincoepAggDOArrx1, String func_source) throws BizException {
		BlEventInfoDTO blEventInfoDTO = new BlEventInfoDTO();
		OpCharge4EsDTO esDTO = new OpCharge4EsDTO();
		FArrayList itemIdCgList = new FArrayList();
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
				itemIdCgList.add(blCgItmOepDO.getId_cgitmoep());
			}
		}
		esDTO.setIds_cgitm(itemIdCgList);
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

		// 2、触发事件 因 平台中未配置 此事件 所以当前注释此消息 2017年8月29日
		// BusinessEvent oepSettlementEvent = new
		// BusinessEvent(IBlEventConst.EVENT_SOURCE_BL_OEP_SETTLEMENT,
		// IEventType.TYPE_INSERT_AFTER, blEventInfoDTO);
		// EventDispatcher.fireEvent(oepSettlementEvent);

		// 3.触发事件门诊收费 2017年8月29日
		OpChargeEvent chargeEvent = new OpChargeEvent();
		esDTO.setId_st(blStOepDO1.getId_stoep());
		chargeEvent.invoke(esDTO);

	}

	/**
	 * 重新打印发票接口
	 * 
	 * @param strCodeSt
	 * @param operatorInfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlIncItmVsTypeDTO[] doRePrintInc(String strCodeSt, OperatorInfoDTO operatorInfo) throws BizException {
		BLCiOrderToBlCgServiceImplBp handerBp = new BLCiOrderToBlCgServiceImplBp();
		return handerBp.doReprintInc(strCodeSt, operatorInfo);
	}
	

	/**
	 * 重新打印发票接口
	 * 
	 * @param strCodeSt
	 * @param operatorInfo
	 * @param rePrintInvoiceInfoDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlIncItmVsTypeDTO[] doRePrintInvoice(String strCodeSt, OperatorInfoDTO operatorInfo, RePrintInvoiceInfoDTO rePrintInvoiceInfoDTO) throws BizException {
		RePrintIncBp handerBp = new RePrintIncBp();
		return handerBp.doRePrintInvoice(strCodeSt, operatorInfo, rePrintInvoiceInfoDTO);
	}
	
	// /**
	// * 触发检查申请信息服务事件
	// *
	// * @throws BizException
	// * */
	// public void invokeOepCiOrderEvent(List<String> id_orsrvLst) throws
	// BizException {
	// String[] objArr = id_orsrvLst.toArray(new String[] {});
	// BlOepSrvEventInfoDTO blOepSrvEventInfoDTO = new BlOepSrvEventInfoDTO();
	// blOepSrvEventInfoDTO.setOper_type(BookRtnDirectEnum.CHARGES);
	// blOepSrvEventInfoDTO.setIdSrvArr(objArr);
	// BusinessEvent oepSettlementEvent = new
	// BusinessEvent(IBlEventConst.EVENT_IE_BL_OEP_CHARGE,
	// IEventType.TYPE_UPDATE_AFTER, new BlOepSrvEventInfoDTO[] {
	// blOepSrvEventInfoDTO });
	// EventDispatcher.fireEvent(oepSettlementEvent);
	// }

	/**
	 * 门诊新收款：从DTO中获得：就诊，发票号1|就诊，发票号2
	 * 
	 * @param appendBillParamDTOs
	 * @param Id_emp_inc
	 *            开票人ID
	 * @param code_incca
	 *            票据种类代码
	 * @param PrintOnlyOneInvoice
	 *            多次就诊打印一张发票还是多次就诊打印多张发票，若是多次就诊打印多张发票，则 一次遍历获得:
	 *            就诊，发票号1|就诊，发票号2|...| 否则： 病人ID，发票号|
	 * @return
	 * @throws BizException
	 */
	@Override
	public String GetEntInvoicenoFromDTO(BlOrderAppendBillParamDTO[] appendBillParamDTOs, String Id_emp_inc, String code_incca, String code_incpkg) throws BizException {
		GetBlCgItmOepMap ins = new GetBlCgItmOepMap();
		String ent_invoiceno = ins.GetEntInvoicenoFromDTO(appendBillParamDTOs, Id_emp_inc, code_incca, code_incpkg);
		return ent_invoiceno;
	}

	/**
	 * 仅保存门诊记账信息Agg,更新医嘱记账信息
	 * 
	 * @param blcgoepAggDOlist
	 * @return
	 * @throws BizException
	 */
	private BlcgoepAggDO[] SaveBlcgoepAggDOVSUpdateCiOrder(BlcgoepAggDO[] blcgoepAggDOs) throws BizException {
		IBlcgoepCudService iBlcgoepCudService = ServiceFinder.find(IBlcgoepCudService.class);
		BlcgoepAggDO[] srvrtctlaggdo = iBlcgoepCudService.save(blcgoepAggDOs);
		if (null == srvrtctlaggdo) {
			throw new BizException("保存门诊记账信息失败");
		}

		BlcgoepAggDO srvrtctlaggdo1 = new BlcgoepAggDO();
		BlCgOepDO blCgOepDO = srvrtctlaggdo[0].getParentDO();
		// blCgOepDO.setEnt_invoiceno(ent_invoiceno);//再次回写就诊，发票号1|就诊，发票号2|...|
		BlCgItmOepDO[] blCgItmOepDO = srvrtctlaggdo[0].getBlCgItmOepDO();
		srvrtctlaggdo1.setParentDO(blCgOepDO);
		srvrtctlaggdo1.setBlCgItmOepDO(blCgItmOepDO);
		// srvrtctlaggdo[0].getParentDO().setEnt_invoiceno(ent_invoiceno);//再次回写就诊，发票号1|就诊，发票号2|...|
		srvrtctlaggdo[0] = srvrtctlaggdo1;

		// 更新医嘱记账信息：新划价的信息对应医嘱
		FDateTime fDateTime = AppUtils.getServerDateTime();
		if (null != blCgOepDO.getOrsrvids()) {
			if (blCgOepDO.getOrsrvids().length() > 0)// 在补费接口，就需要更新医嘱记账信息
			{
				Object obj2 = ServiceFinder.find(ICiOrdMaintainService.class);
				// FBoolean
				// updateCiOrder=((ICiOrdMaintainService)obj2).UpdateOrdChargeRelInfo(
				// orsrvidslist.toArray(new String[]{}),
				// ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID,ICiDictCodeConst.SD_SU_BL_ACCOUNT);
				FBoolean updateCiOrder = ((ICiOrdMaintainService) obj2).UpdateOrdChargeRelInfo2(blCgOepDO.getOrsrvids().split(","), ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID, ICiDictCodeConst.SD_SU_BL_ACCOUNT, fDateTime, FeeReverseType.NOBLCANCEL);
				if (!updateCiOrder.booleanValue()) {
					throw new BizException("更新医嘱状态失败,本次操作不成功！");
				}
			}
		}
		return srvrtctlaggdo;
	}

	/**
	 * 门急诊退费结算（不含划价部分）：供红冲后再划价使用。不用了，待新退费结算稳定后，删除
	 * 
	 * @param blStOepDO
	 *            ：按就诊ID和就诊类型的产生的结算数组，一次就诊产生一次DO，多次就诊产生多次DO（就诊=id_pat+" "+id_ent
	 *            +" "+id_enttp）
	 * @param blincoepAggDO
	 *            ：发票AGG数组，一个blStOepDO，对应一个发票AGG；多个blStOepDO，对应多个发票AGG
	 * @param BlcgoepAggDO
	 *            ：记账AGG，红冲后返回的待解算AGG
	 * @param blpaypatoepAggDO
	 *            :收付款AGG
	 * @param PrintOnlyOneInvoice
	 *            :FBoolean.True:多次就诊打印一张发票；FBoolean.False:多次就诊打印多张发票
	 * @return
	 * @throws BizException
	 */
	private BlIncItmVsTypeDTO[] settlementAfterRedBill_Bp(BlStOepDO[] blStOepDO, BlincoepAggDO[] blincoepAggDOs, BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO) throws BizException {

		// FMap orginIdcgitmoepVsNewIdcgitmoepMap=new FMap();
		List<OpDgRtnAmountDTO> opDgRtnAmountDTO_list = new ArrayList<OpDgRtnAmountDTO>();
		GetBlPsnDocName name_ins = new GetBlPsnDocName();
		String inc_emp_name = name_ins.GetBlPsnDocName(blpaypatoepAggDO.getParentDO().getId_emp_pay());

		// Map<String,String> blCgItmOepMapCodeSt=new HashMap<String,String>();

		String tempKey = "", key = "";
		String maxInvoiceno = "";
		String strDateTime = AppUtils.getServerDateTime().toString();
		String pm_way = "";
		pm_way = getPm_way_ByBlpaypatAndIdstoep(blpaypatoepAggDO, blStOepDO[0].getId_stoep());
		// 1.参数校验
		PriceSettleBP priceSettleBP = new PriceSettleBP();
		priceSettleBP.validate_SettlementAfterRedBill(blStOepDO, blincoepAggDOs, blcgoepAggDO, blpaypatoepAggDO);

		// 2.保存患者收付款
		BlPayPatOepDO blPayPatOepDO = blpaypatoepAggDO.getParentDO();
		blPayPatOepDO.setDt_pay(new FDateTime(strDateTime));
		blPayPatOepDO.setStatus(DOStatus.NEW);
		blpaypatoepAggDO.setParentDO(blPayPatOepDO);
		Object obj222 = ServiceFinder.find(IBlpaypatoepCudService.class);
		BlpaypatoepAggDO[] blpaypatoepAggDOs = ((IBlpaypatoepCudService) obj222).save(new BlpaypatoepAggDO[] { blpaypatoepAggDO });
		if (null == blpaypatoepAggDOs) {
			throw new BizException("保存患者收付款信息失败");
		}

		// 2.1 如果患者有预交金收付款，则修改对应的门诊预交金账户和预授权金额
		FDouble sum_amt_acc = new FDouble(0);
		for (BlcgoepAggDO blcgoepAggDO1 : blcgoepAggDO) {
			BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDO1.getBlCgItmOepDO();
			for (int j = 0; j < blCgItmOepDOs.length; j++) {
				if (blCgItmOepDOs[j].getFg_acc() != null && blCgItmOepDOs[j].getFg_acc().booleanValue()) {
					sum_amt_acc = sum_amt_acc.add(blCgItmOepDOs[j].getAmt_acc().multiply(blcgoepAggDO1.getParentDO().getEu_direct()));
				}
			}
		}
		// 2.2如果患者采用预交金支付，则统计预交金支付金额，且修改门诊预交金账户
		DoOepFgAccAmtAcc doOepFgAccAmtAccBp = new DoOepFgAccAmtAcc();
		// doOepFgAccAmtAccBp.doPayByPrepay(blpaypatoepAggDOs); 2016-07-20
		doOepFgAccAmtAccBp.prepayConsume(blpaypatoepAggDOs, sum_amt_acc);

		// 退费重收不用考虑改医嘱记账状态，原记账状态本来就是1
		// //该记账未保存入数据库
		// if(blcgoepAggDO[0].getParentDO().getHas_saveindb()==FBoolean.FALSE)
		// //若干是医保这该字段为TRUE,
		// {
		// //需要保存blcgoepAggDO，且修改对应的医嘱记账状态
		// blcgoepAggDO=SaveBlcgoepAggDOVSUpdateCiOrder(blcgoepAggDO);
		// }
		// 保存CG
		IBlcgoepCudService iBlcgoepCudService = ServiceFinder.find(IBlcgoepCudService.class);
		BlcgoepAggDO[] srvrtctlaggdo = iBlcgoepCudService.save(blcgoepAggDO);
		if (null == srvrtctlaggdo) {
			throw new BizException("保存门诊记账信息失败");
		}

		// 获取记账中具体项目和主键的MAP
		GetBlCgItmOepMap blCgItmOepMapIns = new GetBlCgItmOepMap();
		// BlCgItmOepMapDTO
		// blCgItmOepMapDTO11=blCgItmOepMapIns.BlCgItmOepConvertToMaps(blcgoepAggDO,PrintOnlyOneInvoice);
		BlCgItmOepMapDTO blCgItmOepMapDTO11 = blCgItmOepMapIns.BlCgItmOepConvertToMaps(blcgoepAggDO, blincoepAggDOs[0].getParentDO().getId_emp_inc(), IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE, FBoolean.TRUE);
		Map<String, String> blCgItmOepMapEnt = blCgItmOepMapDTO11.getBlCgItmOepMapEnt();// Map<就诊,结账序号>
		Map<String, FDouble> blCgItmOepAmtStdMap = blCgItmOepMapDTO11.getBlCgItmOepAmtStdMap();// Map<就诊,标准金额>
		Map<String, FDouble> blCgItmOepAmtPatMap = blCgItmOepMapDTO11.getBlCgItmOepAmtPatMap();// Map<就诊,医保自付金额>
		Map<String, FDouble> blCgItmOepAmtRatioMap = blCgItmOepMapDTO11.getBlCgItmOepAmtRatioMap();// Map<就诊,金额_价格比例>
		Map<String, FDouble> blCgItmOepAmtHpMap = blCgItmOepMapDTO11.getBlCgItmOepAmtHpMap();// Map<就诊,医保支付金额>
		Map<String, FDouble> blCgItmOepAmtMap = blCgItmOepMapDTO11.getBlCgItmOepAmtMap();// Map<就诊,自付金额>
		// blCgItmOepMapDTO11.setBlCgItmOepMapEnt(blCgItmOepMapEnt);
		// blCgItmOepMapDTO11.setBlCgItmOepAmtStdMap(blCgItmOepAmtStdMap);
		// blCgItmOepMapDTO11.setBlCgItmOepAmtPatMap(blCgItmOepAmtPatMap);
		// blCgItmOepMapDTO11.setBlCgItmOepAmtHpMap(blCgItmOepAmtHpMap);
		// blCgItmOepMapDTO11.setBlCgItmOepAmtMap(blCgItmOepAmtMap);
		// blCgItmOepMapDTO11.setBlCgItmOepAmtRatioMap(blCgItmOepAmtRatioMap);
		Map<String, String> blStOepMapEnt = new HashMap<String, String>();

		// 3. 保存门诊结算信息：blStOepDO
		for (int i = 0; i < blStOepDO.length; i++) {
			// 生成结算号
			String stCode = BlCodeUtils.generateOepStCode();
			blStOepDO[i].setCode_st(stCode);
			// if (PrintOnlyOneInvoice.equals(FBoolean.TRUE))
			// {
			tempKey = blStOepDO[i].getId_pat();
			// } else
			// {
			// tempKey = blStOepDO[i].getId_pat() + " "
			// + blStOepDO[i].getId_ent() + " "
			// + blStOepDO[i].getId_enttp();
			// }
			// if (!blCgItmOepMapCodeSt.containsKey(tempKey))
			// {
			// blCgItmOepMapCodeSt.put(tempKey, blStOepDO[i].getCode_st());
			// }
			blStOepDO[i].setAmt_std(blCgItmOepAmtStdMap.get(tempKey));// 结算标准总金额
			blStOepDO[i].setAmt_pat(blCgItmOepAmtPatMap.get(tempKey));// 自付金额
			blStOepDO[i].setAmt_ratio(blCgItmOepAmtRatioMap.get(tempKey));// 金额_价格比例
			blStOepDO[i].setAmt(blCgItmOepAmtMap.get(tempKey));// 自付金额
			blStOepDO[i].setAmt_hp(blCgItmOepAmtHpMap.get(tempKey));// 医保支付金额
			// 回写患者收付款
			blStOepDO[i].setId_paypatoep(blpaypatoepAggDOs[0].getParentDO().getId_paypatoep());
			blStOepDO[i].setDt_st(new FDateTime(strDateTime));
			blStOepDO[i].setFg_cc(FBoolean.FALSE);// 设置结账标志为FALSE
			blStOepDO[i].setStatus(DOStatus.NEW);
		}
		Object obj1 = ServiceFinder.find(IBlstoepCudService.class);
		BlStOepDO[] blStOepDOs = ((IBlstoepCudService) obj1).save(blStOepDO);
		if (null == blStOepDOs) {
			throw new BizException("保存门诊结算信息失败");
		}

		GetBlCgItmOepMap blCgItmOepMapInsx = new GetBlCgItmOepMap();
		BlCgItmOepMapDTO blCgItmOepMapDTOx = blCgItmOepMapInsx.blStOepConvertToMaps(blStOepDOs[0]);
		blStOepMapEnt = blCgItmOepMapDTOx.getBlStOepMapEnt();

		// // 4. 保存发票信息：blincoepAggDO
		// Object obj2 = ServiceFinder.find(IBlincoepCudService.class);
		// BlincoepAggDO[] blincoepAggDOs = ((IBlincoepCudService) obj2)
		// .save(blincoepAggDO);
		// if (null == blincoepAggDOs) {
		// throw new BizException("保存门诊结算发票信息失败");
		// }

		// 5. 获取本次结算的所有记账明细信息
		List<BlCgItmOepDO> BlCgItmOepDOlist = new ArrayList<BlCgItmOepDO>();
		for (int i = 0; i < blcgoepAggDO.length; i++) {
			BlCgOepDO blcgoepdo = blcgoepAggDO[i].getParentDO();
			blcgoepdo.setDt_cg(new FDateTime(strDateTime));
			blcgoepdo.setStatus(DOStatus.UPDATED);
			BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDO[i].getBlCgItmOepDO();
			for (int j = 0; j < blCgItmOepDOs.length; j++) {
				blCgItmOepDOs[j].setId_org(blcgoepdo.getId_org());
				// if(blStOepMapEnt.containsKey(blCgItmOepDOs[j].getId_pat()))
				// {
				blCgItmOepDOs[j].setFg_st(FBoolean.TRUE);
				blCgItmOepDOs[j].setId_stoep(blStOepDOs[0].getId_stoep());
				blCgItmOepDOs[j].setDt_st(new FDateTime(strDateTime));
				// }
				blCgItmOepDOs[j].setFg_st(FBoolean.TRUE);// 置结算标志为真
				blCgItmOepDOs[j].setFg_susp(FBoolean.FALSE);// 置挂起标志为假
				blCgItmOepDOs[j].setStatus(DOStatus.UPDATED);
				BlCgItmOepDOlist.add(blCgItmOepDOs[j]);
			}
		}
		iBlcgoepCudService = ServiceFinder.find(IBlcgoepCudService.class);
		BlcgoepAggDO[] blcgoepAggDO1 = iBlcgoepCudService.save(blcgoepAggDO);
		if (null == blcgoepAggDO1) {
			throw new BizException("更新门诊记账信息失败");
		}

		BlCgItmOepDO[] AllBlCgItmOepDOs = BlCgItmOepDOlist.toArray(new BlCgItmOepDO[] {});

		// StringBuffer info=new StringBuffer();
		//
		// info.append("补费：物品预留writebackDispItmAfterRefundCharge。");
		// info.append("门急诊药品退费后回写发放明细数据 该药品未发放时，修改请领表数据 ");
		// info.append("入参{");

		List<String> id_orsrvLst = new ArrayList<String>();

		// 6. 回写结算与发票关系，发票费用明细，组成BL_ST_INC_OEPDO,BL_INC_CG_ITM_OEP
		// 票据接口
		Object obj22 = ServiceFinder.find(IBLInvoiceService.class);
		String Incno = "";
		tempKey = "";
		List<BlincoepAggDO> blincoepAggDOList = new ArrayList<BlincoepAggDO>();
		int index = 0;
		for (BlincoepAggDO blincoepAggDO1 : blincoepAggDOs) // 产生了几张发票
		{
			// 每个发票对应的结算与发票关系_门急体
			List<BlStIncOepDO> blStIncOepDOs = new ArrayList<BlStIncOepDO>();

			// 发票费用明细_门诊
			List<BlIncCgItmOep> blIncCgItmOeps = new ArrayList<BlIncCgItmOep>();

			BlincoepAggDO[] newBlincoepAggDO1 = new BlincoepAggDO[1];
			BlIncOepDO blIncOepDO = blincoepAggDO1.getParentDO();
			// if(PrintOnlyOneInvoice.equals(FBoolean.TRUE))
			// {
			tempKey = blIncOepDO.getId_pat();
			// }
			// else
			// {
			// tempKey=blIncOepDO.getId_pat()+" "+blIncOepDO.getId_ent()+" "+blIncOepDO.getId_enttp();
			// }

			// 获得最大发票号
			if (maxInvoiceno.compareTo(blIncOepDO.getIncno()) < 0) {
				maxInvoiceno = blIncOepDO.getIncno();
			}
			blIncOepDO.setId_stoep(blStOepMapEnt.get(tempKey));
			blIncOepDO.setDt_inc(new FDateTime(strDateTime));
			blIncOepDO.setFg_print(FBoolean.TRUE);
			blIncOepDO.setStatus(DOStatus.UPDATED);
			newBlincoepAggDO1[0] = new BlincoepAggDO();
			newBlincoepAggDO1[0].setParentDO(blIncOepDO);
			// 6.1 门急诊结算与发票关系，生成blStIncOepDO
			for (int ii = 0; ii < blStOepDOs.length; ii++) {
				// id_org,id_pat,id_ent,id_enttp
				// if(PrintOnlyOneInvoice.equals(FBoolean.TRUE))
				// {
				key = blStOepDOs[ii].getId_pat();
				// }
				// else
				// {
				// key=blStOepDOs[ii].getId_pat()+" "+blStOepDOs[ii].getId_ent()+" "+blStOepDOs[ii].getId_enttp();
				// }
				if (tempKey.equals(key)) {
					BlStIncOepDO blStIncOepDO = new BlStIncOepDO();
					blStIncOepDO.setId_stoep(blStOepDOs[ii].getId_stoep());
					blStIncOepDO.setId_incoep(blIncOepDO.getId_incoep());
					blStIncOepDO.setFg_active(FBoolean.TRUE);

					blStIncOepDO.setStatus(DOStatus.NEW);
					blStIncOepDOs.add(blStIncOepDO);
					blIncOepDO.setAmt(blStOepDOs[ii].getAmt());
					blIncOepDO.setAmt_std(blStOepDOs[ii].getAmt_std());
					blIncOepDO.setAmt_pat(blStOepDOs[ii].getAmt_pat());
					blIncOepDO.setAmt_hp(blStOepDOs[ii].getAmt_hp());
					blIncOepDO.setAmt_ratio(blStOepDOs[ii].getAmt_ratio());
				}
			}

			// 6.2 门诊发票费用明细 ：就诊，生成BlIncCgItmOep
			String keyInvoiceType = "";
			Map<String, BlIncItmOepDO> blCgIncTypeBlIncItmOepDOMap = new HashMap<String, BlIncItmOepDO>();
			FDouble amt_inctype = new FDouble(0);
			FDouble amt_pat_inctype = new FDouble(0);
			FDouble amt_std_inctype = new FDouble(0);
			FDouble amt_hp_inctype = new FDouble(0);
			FDouble amt_ratio_inctype = new FDouble(0);
			for (int j = 0; j < AllBlCgItmOepDOs.length; j++) {
				// if(PrintOnlyOneInvoice.equals(FBoolean.TRUE))
				// {
				key = AllBlCgItmOepDOs[j].getId_pat();
				// }
				// else
				// {
				// key=AllBlCgItmOepDOs[j].getId_pat()+" "+AllBlCgItmOepDOs[j].getId_ent()+" "+AllBlCgItmOepDOs[j].getId_enttp();
				// }
				if (tempKey.equals(key)) {
					BlIncCgItmOep blIncCgItmOep = new BlIncCgItmOep();
					blIncCgItmOep.setId_cgitmoep(AllBlCgItmOepDOs[j].getId_cgitmoep());
					blIncCgItmOep.setId_incoep(blIncOepDO.getId_incoep());
					blIncCgItmOep.setStatus(DOStatus.NEW);
					blIncCgItmOeps.add(blIncCgItmOep);
				}

				keyInvoiceType = AllBlCgItmOepDOs[j].getCode_inccaitm() + "," + AllBlCgItmOepDOs[j].getName_inccaitm();
				if (blCgIncTypeBlIncItmOepDOMap.containsKey(keyInvoiceType)) {
					BlIncItmOepDO blIncItmOepDO = blCgIncTypeBlIncItmOepDOMap.get(keyInvoiceType);
					amt_inctype = blIncItmOepDO.getAmt().add(AllBlCgItmOepDOs[j].getAmt());
					amt_pat_inctype = blIncItmOepDO.getAmt_pat().add(AllBlCgItmOepDOs[j].getAmt_pat());
					amt_std_inctype = blIncItmOepDO.getAmt_std().add(AllBlCgItmOepDOs[j].getAmt_std());
					amt_hp_inctype = blIncItmOepDO.getAmt_hp().add(AllBlCgItmOepDOs[j].getAmt_hp());
					amt_ratio_inctype = blIncItmOepDO.getAmt_ratio().add(AllBlCgItmOepDOs[j].getAmt_ratio());
					blIncItmOepDO.setCode(AllBlCgItmOepDOs[j].getCode_inccaitm());
					blIncItmOepDO.setName(AllBlCgItmOepDOs[j].getName_inccaitm());
					blIncItmOepDO.setAmt_std(amt_std_inctype);
					blIncItmOepDO.setAmt_pat(amt_pat_inctype);
					blIncItmOepDO.setAmt_hp(amt_hp_inctype);
					blIncItmOepDO.setAmt_ratio(amt_ratio_inctype);
					blIncItmOepDO.setAmt(amt_inctype);
					blIncItmOepDO.setStatus(DOStatus.NEW);
					blCgIncTypeBlIncItmOepDOMap.remove(keyInvoiceType);
					blCgIncTypeBlIncItmOepDOMap.put(keyInvoiceType, blIncItmOepDO);
				} else {
					BlIncItmOepDO blIncItmOepDO = new BlIncItmOepDO();
					blIncItmOepDO.setId_incitmoep(null);
					blIncItmOepDO.setId_incoep(null);
					blIncItmOepDO.setCode(AllBlCgItmOepDOs[j].getCode_inccaitm());
					blIncItmOepDO.setName(AllBlCgItmOepDOs[j].getName_inccaitm());
					blIncItmOepDO.setAmt_std(AllBlCgItmOepDOs[j].getAmt_std());
					blIncItmOepDO.setAmt_pat(AllBlCgItmOepDOs[j].getAmt_pat());
					blIncItmOepDO.setAmt_hp(AllBlCgItmOepDOs[j].getAmt_hp());
					blIncItmOepDO.setAmt_ratio(AllBlCgItmOepDOs[j].getAmt_ratio());
					blIncItmOepDO.setAmt(AllBlCgItmOepDOs[j].getAmt());
					blIncItmOepDO.setAmt_free(new FDouble(0));
					blIncItmOepDO.setStatus(DOStatus.NEW);
					blCgIncTypeBlIncItmOepDOMap.put(keyInvoiceType, blIncItmOepDO);
				}
			}

			List<BlIncItmOepDO> blIncItmOepDOLst = new ArrayList<BlIncItmOepDO>();
			Iterator iter = blCgIncTypeBlIncItmOepDOMap.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				blIncItmOepDOLst.add((BlIncItmOepDO) entry.getValue());
			}
			if (ListUtil.isEmpty(blIncItmOepDOLst)) {
				throw new BizException("没有生成发票账单表数据");
			}
			newBlincoepAggDO1[0].setBlIncItmOepDO(blIncItmOepDOLst.toArray(new BlIncItmOepDO[] {}));
			newBlincoepAggDO1[0].setBlStIncOepDO(blStIncOepDOs.toArray(new BlStIncOepDO[] {}));
			newBlincoepAggDO1[0].setBlIncCgItmOep(blIncCgItmOeps.toArray(new BlIncCgItmOep[] {}));

			blincoepAggDOList.add(newBlincoepAggDO1[0]);
			index++;
		}
		// 7. 保存BL_ST_INC_OEPDO,BL_INC_CG_ITM_OEP
		Object obj3 = ServiceFinder.find(IBlincoepCudService.class);
		// BlincoepAggDO[] updateBlincoepAggDO=new
		// BlincoepAggDO[blincoepAggDOList.size()];
		// BlincoepAggDO[]
		// blincoepAggDOs1=((IBlincoepCudService)obj3).save(blincoepAggDOList.toArray(new
		// BlincoepAggDO[]{}));
		// if(null==blincoepAggDOs1)
		// {
		// throw new BizException("保存门诊结算发票信息失败");
		// }

		// 处理减免的业务逻辑
		DoOepFgFree doOepFgFree = new DoOepFgFree();
		int Eu_freemd = 0;
		blincoepAggDOs[0] = doOepFgFree.DoOep_FgFree_new(blcgoepAggDO, blpaypatoepAggDO, blincoepAggDOList.toArray(new BlincoepAggDO[] {})[0], DOStatus.NEW);

		// 8. 生成发票打印的dto
		String[] arr_ent_invoice = null;
		String incno = "", tempKeys = "";
		for (int l = 0; l < blcgoepAggDO.length; l++) {
			String srv_invoicename = blcgoepAggDO[l].getParentDO().getEnt_invoiceno();
			if (srv_invoicename.indexOf("|") > 0) {
				arr_ent_invoice = srv_invoicename.split("\\|"); // 只打印一张发票
				tempKeys = arr_ent_invoice[0];
				incno = tempKeys.substring(tempKeys.indexOf(',') + 1);
				break;
			}
		}
		BLCiOrderToBlCgServiceImplBp bLCiOrderToBlCgServiceImplBp = new BLCiOrderToBlCgServiceImplBp();
		String code_st = blStOepMapEnt.get(blcgoepAggDO[0].getParentDO().getId_pat());
		FDateTime datetime = new FDateTime(strDateTime);
		// BlIncItmVsTypeDTO
		// blIncItmVsTypeDTO=bLCiOrderToBlCgServiceImplBp.getBlIncItmVsTypeDTO(blcgoepAggDO,
		// inc_emp_name, pm_way, code_st, datetime, datetime, Eu_freemd, incno);
		String pay_way = "";
		for (BlPayItmPatOepDO blPayItmPatOepDO : blpaypatoepAggDO.getBlPayItmPatOepDO()) {
			blPayItmPatOepDO.setFg_realpay(FBoolean.TRUE);// 真实数据
			pay_way = pay_way + "," + getPm_way(blPayItmPatOepDO.getSd_pm());// 收款方式
		}
		if (pay_way.length() > 1) {
			pay_way = pay_way.substring(1);
		}
		BlIncItmVsTypeDTO[] incOepDtoLst = bLCiOrderToBlCgServiceImplBp.handlerIncInfoDtos(FBoolean.FALSE, FBoolean.FALSE, blStOepDOs[0], blincoepAggDOs, blpaypatoepAggDO);

		// 9. 设置当前发票号
		// String curno=String.valueOf(Long.parseLong(maxInvoiceno)+1);
		// String
		// curno=maxInvoiceno.substring(0,String.valueOf(Long.parseLong(maxInvoiceno)).length())+String.valueOf(Long.parseLong(maxInvoiceno)+1);
		// String curno=String.valueOf(Long.parseLong(maxInvoiceno)+1);
		String curno = computeNextInvoiceNo(maxInvoiceno);
		((IBLInvoiceService) obj22).SetCurNoByParamNo(blincoepAggDOs[0].getParentDO().getId_emp_inc(), blincoepAggDOs[0].getParentDO().getId_incca(), curno);

		// BlIncItmVsTypeDTO[]
		// blIncItmVsTypeDTOs=blIncItmVsTypeDTOlist.toArray(new
		// BlIncItmVsTypeDTO[]{});

		// 10.发事件
		try {
			this.invokeOepSettlementEvent(blcgoepAggDO1, blpaypatoepAggDO, blStOepDOs[0], blincoepAggDOs[0], IBlFunCodeConst.FUN_CODE_OPFEERTN);
		} catch (Exception ex) {

		}

		return incOepDtoLst;
	}

	/**
	 * 门急诊退费结算（不含划价部分）：供红冲后再划价使用,不用了，待程序稳定后，删除
	 * 
	 * @param blStOepDO
	 *            ：按就诊ID和就诊类型的产生的结算数组，一次就诊产生一次DO，多次就诊产生多次DO（就诊=id_pat+" "+id_ent
	 *            +" "+id_enttp）
	 * @param blincoepAggDO
	 *            ：发票AGG数组，一个blStOepDO，对应一个发票AGG；多个blStOepDO，对应多个发票AGG
	 * @param BlcgoepAggDO
	 *            ：记账AGG，红冲后返回的待解算AGG
	 * @param blpaypatoepAggDO
	 *            :收付款AGG
	 * @param opDgRtnAmountDTOs
	 *            :<退费药品明细主键，退费数量>
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlIncItmVsTypeDTO[] SettlementAfterRedBill_new_discard(BlStOepDO[] blStOepDO, BlincoepAggDO[] blincoepAggDO, BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO) throws BizException {
		BlIncItmVsTypeDTO[] blIncItmVsTypeDTOs = settlementAfterRedBill_Bp(blStOepDO, blincoepAggDO, blcgoepAggDO, blpaypatoepAggDO);
		return blIncItmVsTypeDTOs;

	}

	/**
	 * 取消划价
	 */
	public FBoolean DeleteOepPricingInfo(String[] id_cgoepArr) throws BizException {
		final String LOCK_KEY = "payment_lock_";
		String cond = "";
		for (int i = 0; i < id_cgoepArr.length; i++) {
			cond = cond + ",'" + id_cgoepArr[i] + "'";
		}
		if (cond.length() > 0) {
			cond = cond.substring(1);
		}
		cond = BlCgOepDODesc.TABLE_ALIAS_NAME + ".id_cgoep in (" + cond + ")";
		IBlcgoepRService iBlcgoepRService = ServiceFinder.find(IBlcgoepRService.class);
		BlcgoepAggDO[] blcgoepAggDOs = iBlcgoepRService.find(cond, "", FBoolean.FALSE); // 懒加载就是把所有数据都加载完，否则，就只加载第一个子表数据
		if (blcgoepAggDOs == null) {
			return FBoolean.FALSE;
		}
		
		//加锁（锁id和旧收付款，新取消划价，新收付款接口一致）
		String stId = blcgoepAggDOs[0].getBlCgItmOepDO()[0].getId_stoep();
		String lockKey = LOCK_KEY + stId;
		boolean lock = PKLock.getInstance().addDynamicLock(lockKey, 0);
		if(!lock){
			throw new BizException("当前患者正在收付款或取消划价，请刷新重试");
		}
		
		BLCiOrderToBlCgServiceImplBp bLCiOrderToBlCgServiceImplBp = new BLCiOrderToBlCgServiceImplBp();
		return bLCiOrderToBlCgServiceImplBp.DeletePricingInfo_bp(blcgoepAggDOs, false);

	}

	/**
	 * 门诊新结算：取消划价 后付费情况取消划价 删除挂起数据 包括挂号数据
	 */
	@Override
	public FBoolean DeletePricingInfo(BlcgoepAggDO[] blcgoepAggDOs) throws BizException {
		BLCiOrderToBlCgServiceImplBp bLCiOrderToBlCgServiceImplBp = new BLCiOrderToBlCgServiceImplBp();
		return bLCiOrderToBlCgServiceImplBp.DeletePricingInfo_bp(blcgoepAggDOs, true);
	}

	/**
	 * 通过子表条件，查询出未结账BlcgoepAggDO数组 a1.id_pat = '" + id_pat +
	 * "' and a1.id_org = '" + id_org + "' and a1.eu_direct = '" + eu_direct +
	 * "'
	 */
	@Override
	public BlcgoepAggDO[] FindByItmsCondition(String id_pat, String id_org, String eu_direct) throws BizException {

		// TODO Auto-generated method stub
		GetBlCgOepAggByItmsQuery ins = new GetBlCgOepAggByItmsQuery();
		String sql = ins.GetBlCgOepAggByItmsQueryStr();
		// 继续干活
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_pat);
		// sqlp.addParam(id_org);
		sqlp.addParam(Integer.parseInt(eu_direct));
		List<BlcgOepAggDTO> blcgAgg = (List<BlcgOepAggDTO>) new DAFacade().execQuery(sql, sqlp, new BeanListHandler(BlcgOepAggDTO.class));
		if (blcgAgg == null || blcgAgg.size() == 0) {
			throw new BizException("查询门诊记账信息失败");
		}

		// 获得Agg
		String id_cgoep = (blcgAgg.toArray(new BlcgOepAggDTO[0]))[0].getId_cgoep();
		String cond = BlCgOepDODesc.TABLE_ALIAS_NAME + ".id_cgoep='" + id_cgoep + "'";
		IBlcgoepRService iBlcgoepRService = ServiceFinder.find(IBlcgoepRService.class);
		return iBlcgoepRService.find(cond, "", FBoolean.TRUE);

	}

	/**
	 * 查询未结算的记账信息，并在第一个主表中根据就诊返回就诊发票号 注意：数据来源:1.从医技补费接口来，只有记账信息
	 * 2.从本“划价”，已经生成了cg,st,inc
	 * 
	 * @param condStr
	 *            查询条件
	 * @param Id_emp_inc
	 *            发票人员ID
	 * @param Code_incca
	 *            票据类型
	 */
	@Override
	public BlCgOepAggDTO FindNoSettlementBlcgoepAggDOWithNewInvocie(String condStr, OperatorInfoDTO operatorInfoDTO, String Code_incca, String code_incpkg) throws BizException {
		IBlcgoepRService service = ServiceFinder.find(IBlcgoepRService.class);
		BlcgoepAggDO[] blcgoepAggDOs = service.find(condStr, "", FBoolean.FALSE);
		if (blcgoepAggDOs == null || blcgoepAggDOs.length <= 0) {
			throw new BizException("查询门诊未结算信息失败");
		}

		String inc_name = "";
		GetBlPsnDocName name_ins = new GetBlPsnDocName();
		// 开票人姓名
		inc_name = name_ins.GetBlPsnDocName(operatorInfoDTO.getId_emp());
		List<BlcgoepAggDO> BlcgoepAggDOFromAppendBill = new ArrayList<BlcgoepAggDO>();// 来源于补费
		List<BlcgoepAggDO> NotBlcgoepAggDOFromAppendBill = new ArrayList<BlcgoepAggDO>();// 非补费
		FBoolean PrintOnlyOneInvoice = FBoolean.TRUE;
		IBLInvoiceService obj11 = ServiceFinder.find(IBLInvoiceService.class);
		String key = "", entAndno = "", endAndpkgcode = "";
		Map<String, String> ent_invocie_temp = new HashMap<String, String>();
		boolean appendBill = false;
		String ent_emp_name = "";
		List<String> id_entLst = new ArrayList<String>(); // 就诊计划
		for (int i = 0; i < blcgoepAggDOs.length; i++) {
			BlCgItmOepDO[] BlCgItmOepDOs = blcgoepAggDOs[i].getBlCgItmOepDO();

			// 查询结算信息，如果没有结算信息，则表示该数据来源于医嘱补费接口，需要生成一个st,一个inc agg的数据
			for (int j = 0; j < BlCgItmOepDOs.length; j++) {
				if (BlCgItmOepDOs[j].getId_stoep() == null) // 说明数据来源于医技补费
				{
					if (!BlcgoepAggDOFromAppendBill.contains(blcgoepAggDOs[i])) {
						BlcgoepAggDOFromAppendBill.add(blcgoepAggDOs[i]);
						appendBill = true;
					}
				} else {
					if (!NotBlcgoepAggDOFromAppendBill.contains(blcgoepAggDOs[i])) {
						NotBlcgoepAggDOFromAppendBill.add(blcgoepAggDOs[i]);
					}
				}
				// 就诊计划
				if (!id_entLst.contains(BlCgItmOepDOs[j].getId_ent())) {
					id_entLst.add(BlCgItmOepDOs[j].getId_ent());
				}

				// 判断费用来源:在门诊结算窗口的挂号费，都要打印发票
				// if(BlCgItmOepDOs[j].getEu_srctp()==1)
				// {
				// PrintOnlyOneInvoice=FBoolean.FALSE;
				// }

				if (PrintOnlyOneInvoice.equals(FBoolean.TRUE)) {
					key = BlCgItmOepDOs[j].getId_pat();
				}
				// else
				// {
				// key=BlCgItmOepDOs[j].getId_pat()+" "+BlCgItmOepDOs[j].getId_ent()+" "+BlCgItmOepDOs[j].getId_enttp();
				// }
				// if(BlCgItmOepDOs[j].getEu_srctp()==1) //就诊来源的数据，按就诊打印发票
				// {
				// key=BlCgItmOepDOs[j].getId_pat()+" "+BlCgItmOepDOs[j].getId_ent()+" "+BlCgItmOepDOs[j].getId_enttp();
				// }
				if (!ent_invocie_temp.containsKey(key)) {
					ent_invocie_temp.put(key, "");
					// entAndno=entAndno+key+","+invoiceNo[j]+"|";
					ent_emp_name = ent_emp_name + key + "," + inc_name + "|";
				}
			}
		}

		// 查看就诊医保计划
		EntHpEP enhpep = new EntHpEP();
		EntHpDO[] entHpDOArr = enhpep.getEntHpById_ent(id_entLst);
		String[] invoiceNo = obj11.GetManyInvoiceNo(operatorInfoDTO.getId_emp(), Code_incca, ent_invocie_temp.size(), code_incpkg);
		Iterator entrys = ent_invocie_temp.entrySet().iterator();
		int i = 0, j = 0;
		while (entrys.hasNext()) {
			Map.Entry entry = (Map.Entry) entrys.next();
			key = (String) entry.getKey();
			entAndno = entAndno + key + "," + invoiceNo[j] + "|";
			endAndpkgcode = endAndpkgcode + key + "," + code_incpkg + "|";
			j++;
		}

		if (appendBill == true)// 有来自补费的数据
		{
			int len = 0;
			List<BlcgoepAggDO> TempBlcgoepAggDOFromAppendBill = new ArrayList<BlcgoepAggDO>();
			BlcgoepAggDO[] blcgoepAggDO2 = pricingFromAppendBill(operatorInfoDTO, BlcgoepAggDOFromAppendBill.toArray(new BlcgoepAggDO[] {}), entAndno, PrintOnlyOneInvoice);

			for (int ii = 0; ii < blcgoepAggDO2.length; ii++) {
				TempBlcgoepAggDOFromAppendBill.add(blcgoepAggDO2[ii]);
			}
			if (NotBlcgoepAggDOFromAppendBill.size() > 0) // 还有非补费的数据，则合并
			{
				for (BlcgoepAggDO blcgoepAggDO1 : NotBlcgoepAggDOFromAppendBill) {
					TempBlcgoepAggDOFromAppendBill.add(blcgoepAggDO1);
				}
			}
			blcgoepAggDOs = TempBlcgoepAggDOFromAppendBill.toArray(new BlcgoepAggDO[] {});
		}

		BlCgOepDO blCgOepDO1 = blcgoepAggDOs[0].getParentDO();
		blCgOepDO1.setEnt_invoiceno(entAndno);
		blCgOepDO1.setEnt_invoice_pkgcode(endAndpkgcode);
		blCgOepDO1.setSt_first_incno(invoiceNo[0]);

		blCgOepDO1.setEnt_invoice_empname(ent_emp_name);

		// blCgOepDO1.getHas_saveindb(FBoolean.TRUE);
		blCgOepDO1.setStatus(DOStatus.UPDATED);
		blcgoepAggDOs[0].setParent(blCgOepDO1);
		OepCgEP cgEP = new OepCgEP();
		return cgEP.createBlCgOepAggDTO(blcgoepAggDOs, entHpDOArr);
	}

	/**
	 * 处理医嘱补费划价：已在cg agg中，但是没有在st,inc表中
	 * 
	 * @param operatorInfoDTO
	 * @param blcgoepAggDO
	 * @param entAndno
	 *            就诊和发票号，格式如：就诊，发票号|就诊，发票号
	 * @param PrintOnlyOneInvoice
	 *            :多次就诊打印一张发票还是多张发票
	 */
	private BlcgoepAggDO[] pricingFromAppendBill(OperatorInfoDTO operatorInfoDTO, BlcgoepAggDO[] blcgoepAggDO, String entAndno, FBoolean PrintOnlyOneInvoice) throws BizException {
		String key = "";
		Map<String, String> entMap = new HashMap<String, String>();
		List<BlStOepDO> blStOepDOList = new ArrayList<BlStOepDO>();
		List<BlincoepAggDO> blincoepAggDOList = new ArrayList<BlincoepAggDO>();
		List<BlcgoepAggDO> blcgoepAggDOlist = new ArrayList<BlcgoepAggDO>();
		Map<String, String> blCgItmOepMapEnt = new HashMap<String, String>();
		Map<String, FDouble> blCgItmOepAmtStdMap = new HashMap<String, FDouble>();
		Map<String, FDouble> blCgItmOepAmtMap = new HashMap<String, FDouble>();
		Map<String, FDouble> blCgItmOepAmtPatMap = new HashMap<String, FDouble>();
		Map<String, FDouble> blCgItmOepAmtRatioMap = new HashMap<String, FDouble>();
		Map<String, FDouble> blCgItmOepAmtHpMap = new HashMap<String, FDouble>();
		GetBlCgItmOepMap blCgItmOepMapIns = new GetBlCgItmOepMap();
		BlCgItmOepMapDTO blCgItmOepMapDTO = blCgItmOepMapIns.BlCgItmOepConvertToAmtMaps(blcgoepAggDO);
		blCgItmOepMapEnt = blCgItmOepMapDTO.getBlCgItmOepMapEnt();// Map<就诊,结账序号>
		blCgItmOepAmtStdMap = blCgItmOepMapDTO.getBlCgItmOepAmtStdMap();// Map<就诊,标准金额>
		blCgItmOepAmtMap = blCgItmOepMapDTO.getBlCgItmOepAmtMap();// Map<就诊,应交金额>
		blCgItmOepAmtPatMap = blCgItmOepMapDTO.getBlCgItmOepAmtPatMap();// Map<就诊,医保自付金额>
		blCgItmOepAmtRatioMap = blCgItmOepMapDTO.getBlCgItmOepAmtRatioMap();// Map<就诊,医保自付金额>
		Map<String, String> blStOepMapEnt = new HashMap<String, String>();

		Map<String, String> blCgItmOepMapCodeSt = new HashMap<String, String>();
		String code_incpkg = "", keys = "", value = "";
		String[] ent_vs_incno = entAndno.split("\\|");
		String orsrvidss = "";
		for (int i = 0; i < ent_vs_incno.length; i++) {
			keys = ent_vs_incno[i].substring(0, ent_vs_incno[i].indexOf(","));
			value = ent_vs_incno[i].substring(ent_vs_incno[i].indexOf(",") + 1);
			blStOepMapEnt.put(keys, value);
		}

		for (int i = 0; i < blcgoepAggDO.length; i++) {

			BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDO[i].getBlCgItmOepDO();
			for (int j = 0; j < blCgItmOepDOs.length; j++) {
				if (blCgItmOepDOs[j].getId_orsrv() != null && "".equals(blCgItmOepDOs[j].getId_orsrv()))
					orsrvidss = orsrvidss + "," + blCgItmOepDOs[j].getId_orsrv();
				if (j == 0) {
					// 获得票据包
					IBlincQryService iBlincQryService = ServiceFinder.find(IBlincQryService.class);
					code_incpkg = iBlincQryService.getCodeIncPkgByIdempissAndCodeEntp(operatorInfoDTO.getId_org(), operatorInfoDTO.getId_emp(), blCgItmOepDOs[j].getCode_enttp());
				}
				// if(PrintOnlyOneInvoice.booleanValue())
				// {
				// 2017-1-11需求更改：多次就诊一次结算，只生成一条bl_st_oep和bl_inc_oep记录
				key = blCgItmOepDOs[j].getId_pat();
				// }
				// else
				// {
				// key=blCgItmOepDOs[j].getId_pat()+" "+blCgItmOepDOs[j].getId_ent()+" "+blCgItmOepDOs[j].getId_enttp();
				// }

				if (!entMap.containsKey(key)) {
					entMap.put(key, "");
					// 生成结算表
					BlStOepDO blStOepDO = new BlStOepDO();
					blStOepDO.setEu_direct(1);
					blStOepDO.setEu_sttp(StTypeEnum.ST_OEP_CHARGE);
					blStOepDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
					blStOepDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
					blStOepDO.setAmt(blCgItmOepAmtMap.get(key));
					blStOepDO.setAmt_std(blCgItmOepAmtStdMap.get(key));
					blStOepDO.setAmt_pat(blCgItmOepAmtPatMap.get(key));
					blStOepDO.setAmt_hp(blCgItmOepAmtHpMap.get(key));
					blStOepDO.setAmt_ratio(blCgItmOepAmtRatioMap.get(key));
					blStOepDO.setId_grp(operatorInfoDTO.getId_grp());
					blStOepDO.setId_org(operatorInfoDTO.getId_org());
					blStOepDO.setId_pat(blCgItmOepDOs[j].getId_pat());
					blStOepDO.setId_ent(blCgItmOepDOs[j].getId_ent());
					blStOepDO.setId_dep_st(operatorInfoDTO.getId_dep());
					blStOepDO.setId_emp_st(operatorInfoDTO.getId_emp());
					blStOepDO.setId_enttp(blCgItmOepDOs[j].getId_enttp());
					blStOepDO.setCode_enttp(blCgItmOepDOs[j].getCode_enttp());
					blStOepDO.setId_paypatoep("");
					blStOepDO.setId_stoep(new DBUtil().getOIDs(1)[0]);
					blStOepDO.setStatus(DOStatus.NEW);
					blStOepDOList.add(blStOepDO);

					// 生成发票表
					BlincoepAggDO blincoepAggDO = new BlincoepAggDO();
					BlIncOepDO blIncOepDO = new BlIncOepDO();
					blIncOepDO.setId_grp(operatorInfoDTO.getId_grp());
					blIncOepDO.setId_org(operatorInfoDTO.getId_org());
					blIncOepDO.setId_pat(blCgItmOepDOs[j].getId_pat());
					// blIncOepDO.setId_ent(blCgItmOepDOs[j].getId_ent());
					blIncOepDO.setId_enttp(blCgItmOepDOs[j].getId_enttp());
					blIncOepDO.setIncno(blStOepMapEnt.get(key)); // 发票号
					blIncOepDO.setTimes_prn(1);
					blIncOepDO.setId_emp_inc(operatorInfoDTO.getId_emp());
					blIncOepDO.setCode_enttp(blCgItmOepDOs[j].getCode_enttp());
					blIncOepDO.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
					blIncOepDO.setEu_direct(BookRtnDirectEnum.CHARGES);
					blIncOepDO.setCode_incpkg(code_incpkg); // 票据包
					blIncOepDO.setId_stoep(blStOepDO.getId_stoep());
					blIncOepDO.setStatus(DOStatus.NEW);
					blincoepAggDO.setParentDO(blIncOepDO);
					blincoepAggDOList.add(blincoepAggDO);
				}
			}
			blcgoepAggDOlist.add(blcgoepAggDO[i]);
		}
		if (orsrvidss.length() > 1) {
			orsrvidss = orsrvidss.substring(1);
		}

		blcgoepAggDOlist.toArray(new BlcgoepAggDO[0])[0].getParentDO().setOrsrvids(orsrvidss);
		blcgoepAggDOlist.toArray(new BlcgoepAggDO[0])[0].getParentDO().setEnt_invoiceno(entAndno);
		// 保存AGG，更新医嘱记账信息
		BLCiOrderToBlCgServiceImplBp bLCiOrderToBlCgServiceImplBp = new BLCiOrderToBlCgServiceImplBp();
		BlcgoepAggDO[] blcgoepAggDO1 = bLCiOrderToBlCgServiceImplBp.SaveBlcgoepAggDOUpdateCiOrder(blcgoepAggDOlist);
		BlcgoepAggDO[] srvrtctlaggdo = bLCiOrderToBlCgServiceImplBp.pricing_bp(blStOepDOList.toArray(new BlStOepDO[] {})[0], blincoepAggDOList.toArray(new BlincoepAggDO[] {})[0], blcgoepAggDO1, FBoolean.TRUE);
		return srvrtctlaggdo;
	}

	/**
	 * 门诊收费初始加载默认调入天数
	 * 
	 * @return
	 * @throws BizException
	 */
	public int GetDefaultDaysStOep() throws BizException {
		return BlParams.BLSTOEP0004();
	}

	/**
	 * 门诊收费默认调入天数
	 * 
	 * @return
	 * @throws BizException
	 */
	public int GetDefaultDaysLoadOep() throws BizException {
		return BlParams.BLSTOEP0004();
	}

	/**
	 * 计算下张票号
	 * 
	 * @param curNo
	 *            当前票号
	 * @return 下张票号
	 * @throws BizException
	 */
	public String computeNextInvoiceNo(String curNo) throws BizException {
		GetCodeByCustomization code_ins = new GetCodeByCustomization();
		return code_ins.computeNextInvoiceNo(curNo);
	}

	/**
	 * 查询该患者未收款信息下的最小发票号
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	@Override
	public String GetMinInvoicenoFromStOepWithoutPay(String id_pat) throws BizException {
		GetBlStOepVsIncSql ins = new GetBlStOepVsIncSql();
		ColumnHandler handler = new ColumnHandler();
		String sql = ins.GetMinInvoicenoFromStOepWithoutPaySql();
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_pat);

		// sqlParam.addParam(Id_srv);
		DAFacade cade = new DAFacade();
		Object result = cade.execQuery(sql, sqlParam, handler);
		if (result == null) {
			throw new BizException("未分配票号");
		}
		return result.toString();
	}

	@Override
	public String[] GetHpByCardSettlement(String xx) throws BizException {
		String[] str = { "0001AA1000000001871V" };// TODO delete
		// str=ParamsetQryUtil.getParaString(IOrgConst.GLOBEORG,
		// "SettlementWithInsurCardHp");//.getParaStringByInstance("~",
		// "isSettlementWithInsurCard", "Id_hp");
		// str="0001AA1000000001871V";

		return str;
	}

	/**
	 * 根据id_ent获得EntHpDO[]
	 * 
	 * @param id_ent
	 * @return
	 */
	public EntHpDO[] getEntHpDOArr(String id_ent) throws BizException {
		BLCiOrderToBlCgServiceImplBp handlerBp = new BLCiOrderToBlCgServiceImplBp();
		return handlerBp.getEntHpDOArr(id_ent);
	}

	/**
	 * 获取医嘱服务对应的使用指导
	 * 
	 * @param 医嘱服务主键
	 * @return 医嘱服务指导DTO
	 * @throws BizException
	 */
	public OrSrvGuideDTO[] getOrSrvGuideDTO(String[] arrIdOrSrv) throws BizException {
		ICiOrdQryService service = ServiceFinder.find(ICiOrdQryService.class);
		//获取服务对应使用指导
		OrSrvGuideDTO[] arrOrSrvguideDTO = service.getOrSrvGuideDTO(arrIdOrSrv);
		//设置服务对应换算率数据
		SetSrvFactorBP ssfBp=new SetSrvFactorBP();
		//返回设置后数据
		return ssfBp.exec(arrOrSrvguideDTO);
	}

	/**
	 * 回写划价产生数据所缺失的id_ent
	 * 
	 * @param id_ent
	 *            回写的id_ent
	 * @param blcgoepAggDO
	 *            划价后的数据
	 * @throws BizException
	 */
	@Override
	public void UpdateBlOepPriceIdent(String id_ent, BlcgoepAggDO[] blcgoepAggDO) throws BizException {
		// TODO Auto-generated method stub
		UpdateBlOepPriceIdent bp = new UpdateBlOepPriceIdent();
		bp.UpdateBlOepPriceIdent(id_ent, blcgoepAggDO);
	}

	/**
	 * 如果患者采用预交金支付，则统计预交金支付金额，且修改门诊预交金账户
	 * 
	 * @param blpaypatoepAggDOs
	 *            支付方式
	 * @throws BizException
	 */
	@Override
	public void doPayByPrepay(BlpaypatoepAggDO[] blpaypatoepAggDOs) throws BizException {
		DoOepFgAccAmtAcc bp = new DoOepFgAccAmtAcc();
		bp.doPayByPrepay(blpaypatoepAggDOs);
	}

	@Override
	public BdcpncaAggDO GetCouponcaAggDOByCode(String couponCode, String strIdPat, FBoolean isCouponCa) throws BizException {
		// 优惠券分类查询接口类
		IBdcpncaRService cpncaRService = ServiceFinder.find(IBdcpncaRService.class);
		// 优惠券查询接口类
		IBlCpnDORService cpnRService = ServiceFinder.find(IBlCpnDORService.class);
		BlCpnDO cpnDo = null;
		// 优惠券分类AggDO
		BdcpncaAggDO cpncaAggDo = null;
		// 优惠券分类实体
		BdCpncaDO cpncaDo = null;
		if (isCouponCa.booleanValue()) // 判断优惠券分类票还是单票
		{
			// 分类票
			BdcpncaAggDO[] ArrcpncaAggDo = cpncaRService.find(" a0.code='" + couponCode + "'", "", new FBoolean(false));
			if (ArrcpncaAggDo == null || ArrcpncaAggDo.length == 0)
				throw new BizException(couponCode + "不是有效的优惠券编码，请核对后重新输入正确的优惠券编码！");
			cpncaAggDo = ArrcpncaAggDo[0];
			cpncaDo = cpncaAggDo.getParentDO();
			// 判断优惠券的启用状态
			if (cpncaDo.getActive_state() == 1)
				throw new BizException(cpncaDo.getName() + "类型的优惠券还没有启用，无法用于支付！");
			if (cpncaDo.getActive_state() == 3)
				throw new BizException(cpncaDo.getName() + "类型的优惠券已经停止使用，无法用于支付！");
		} else {
			BlCpnDO[] ArrCpnDo;
			ArrCpnDo = cpnRService.findByAttrValString(BlCpnDO.CODE, couponCode);
			if (ArrCpnDo == null || ArrCpnDo.length <= 0)
				throw new BizException(couponCode + "不是有效的优惠券编码，请核对后重新输入正确的优惠券编码！");
			cpnDo = ArrCpnDo[0];
			cpncaAggDo = cpncaRService.findById(cpnDo.getId_cpnca());
			if (cpncaAggDo != null)
				cpncaDo = cpncaAggDo.getParentDO();
			// 判断优惠券的启用状态
			if (cpncaDo.getActive_state() == 1)// 未启用
				throw new BizException(cpncaDo.getName() + "类型的优惠券还没有启用，无法用于支付！");
			if (cpncaDo.getActive_state() == 3)// 已经停用
				throw new BizException(cpncaDo.getName() + "类型的优惠券已经停止使用，无法用于支付！");
			if (cpncaDo.getFg_own().booleanValue()) {
				// 如果是记名，需要验证是否发放
				if (!cpnDo.getFg_iss().booleanValue()) {
					throw new BizException("该优惠券还未发放，请确认！");
				}
				// 验证优惠券持有人
				if (!cpnDo.getId_pat_own().equals(strIdPat)) {
					throw new BizException("当前患者不是优惠券的持有人，无法使用该优惠券支付");
				}
			}
			if(cpnDo.getFg_used().booleanValue())
				throw new BizException("该优惠券已经被使用！");
		}
		return cpncaAggDo;
	}

	/**
	 * 用于患者离院未结算的情况下自动结算。 目前仅支持商保记账结算。
	 *
	 * @param days
	 *            结算距今天的头几个自然日的费用信息
	 * @throws BizException
	 */
	public FBoolean PriceAndSettlementPayment_hpcg_background(int days, OperatorInfoDTO operatorInfoDTO) throws BizException {
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().getDateTimeBefore(days).toLocalString();
		StringBuffer msg_p = new StringBuffer();
		msg_p.append("商保记账患者离院未结算的情况下自动结算，结算时间：[").append(strDateTime).append("]  当前系统时间：[").append(timeService.getUFDateTime()).append("]").append("\r\n");
		BLBizLogger.info(msg_p.toString());
		// 1.查询离院未结算的患者信息
		BLCiOrderToBlCgServiceImplBp bLCiOrderToBlCgServiceImplBp = new BLCiOrderToBlCgServiceImplBp();
		List<PatiVisitDO> patiVisitDOLst = bLCiOrderToBlCgServiceImplBp.getIdEntsFromCiWithoutSettlement_hpcg(days);
		if (patiVisitDOLst == null || patiVisitDOLst.size() == 0) {
			msg_p.append("未查询到商保患者离院未结算就诊en_ent！");
			BLBizLogger.info(msg_p.toString());
			return FBoolean.FALSE;
		}
		IBLStQueService iBLStQueService = ServiceFinder.find(IBLStQueService.class);
		String[] sd_su_bl = { "0" };
		FDouble amt_ratio = new FDouble(0);
		String id_pat = "";
		String id_ent = "";
		Map<String, String> hp_cust_map = bLCiOrderToBlCgServiceImplBp.getAllIdCustByIdHp();// <id_hp,id_cust>

		for (PatiVisitDO patiVisitDO : patiVisitDOLst) {
			try {
				id_pat = patiVisitDO.getId_pat();
				id_ent = patiVisitDO.getId_ent();
				// 2.提取该就诊下未记账的医嘱信息
				BlOrderAppendBillParamDTO[] blOrderAppendBillParamDTOs = iBLStQueService.getNoSettlementSrvPriceInfoByIdent(patiVisitDO.getId_ent(), sd_su_bl, patiVisitDO.getId_pat(), days);

				for (BlOrderAppendBillParamDTO dto : blOrderAppendBillParamDTOs) {
					if (dto.getFg_mm() != null && dto.getFg_mm().booleanValue()) // 物品不用预留
					{
						dto.setFg_reserveMaterials(FBoolean.FALSE);
					}
				}
				// 3.划价
				BlCgOepAggDTO blCgOepAggDTO = SetCiOrderToPrice(blOrderAppendBillParamDTOs, operatorInfoDTO, FBoolean.FALSE);
				// 4.拼收款AGG
				amt_ratio = new FDouble(0);
				FArrayList blcgoepAggDOLst = blCgOepAggDTO.getBlcgoepAggDO();
				BlcgoepAggDO[] blcgoepAggDOs = (BlcgoepAggDO[]) blcgoepAggDOLst.toArray(new BlcgoepAggDO[0]);
				for (BlcgoepAggDO blcgoepAggDO : blcgoepAggDOs) {
					BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDO.getBlCgItmOepDO();
					for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOs) {
						amt_ratio = amt_ratio.add(blCgItmOepDO.getAmt_ratio());
					}
				}
				BlpaypatoepAggDO blpaypatoepAggDO = bLCiOrderToBlCgServiceImplBp.AssemblePayData(amt_ratio, operatorInfoDTO, patiVisitDO.getId_pat(), hp_cust_map.get(patiVisitDO.getId_hp()));
				// 5.收款
				BlIncItmVsTypeDTO[] blIncItmVsTypeDTOs = SettlementPayment(blcgoepAggDOs, blpaypatoepAggDO, FBoolean.FALSE, FBoolean.FALSE, FBoolean.FALSE);
				msg_p.append("查询商保患者id:").append(patiVisitDO.getId_pat()).append("   就诊id:").append(patiVisitDO.getId_ent()).append("   后台自动结算成功！").append("\r\n");
				BLBizLogger.info(msg_p.toString());
			} catch (Exception e) {
				msg_p.append("商保患者id:").append(patiVisitDO.getId_pat()).append("   就诊id:").append(patiVisitDO.getId_ent()).append("   后台自动结算失败！").append("\r\n");
				BLBizLogger.info(msg_p.toString());
			}
		}

		return FBoolean.TRUE;
	}

	/**
	 * 挂号划价结算一体化:仅处理单次挂号,成功返回FBoolean.true
	 * 
	 * @param appendBillParamDTOs
	 *            费用明细
	 * @param blpaypatoepAggDO
	 *            支付明细
	 * @param blPropOepDOArr
	 *            医保分摊1，无分摊则为null
	 * @param blproparoepAggDOArr
	 *            医保分摊2，无分摊则为null
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @param tradeNo
	 *            医保交易号
	 * @param code_st
	 *            结算号
	 * @param PrintInvoice
	 *            是否打印发票
	 * @param IsTransferPrepay
	 *            余额是否结转到预交金
	 * @param idcg
	 *            记账数据编号
	 * @return 发票信息
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] PriceAndSettlementPayment_Register(BlOrderAppendBillParamDTO[] appendBillParamDTOs, BlpaypatoepAggDO blpaypatoepAggDO, BlPropOepDO[] blPropOepDOArr, BlproparoepAggDO[] blproparoepAggDOArr, OperatorInfoDTO operatorInfoDTO, String tradeNo, String code_st, FBoolean PrintInvoice, FBoolean IsTransferPrepay, String idCg) throws BizException {
		String id_cgoep = null;

		// 设置重收数据中的sd_pttp   PO说注了
		/*if (blpaypatoepAggDO != null && !StringUtil.isEmpty(idCg)) {
			IBlpaypatoepMDORService paypatoepSer = ServiceFinder.find(IBlpaypatoepMDORService.class);
			BlPayPatOepDO[] oepDOs = paypatoepSer.find(" ID_PAYPATOEP=(SELECT ID_PAYPATOEP FROM BL_ST_OEP WHERE ID_STOEP=(SELECT ID_STOEP FROM BL_CG_ITM_OEP WHERE ROWNUM=1 AND ID_CGOEP='" + idCg + "'))", "", FBoolean.FALSE);
			if (oepDOs != null && oepDOs.length == 1) {
				blpaypatoepAggDO.getParentDO().setSd_pttp(oepDOs[0].getSd_pttp());
			}
		}*/

		for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : appendBillParamDTOs) {
			blOrderAppendBillParamDTO.setId_org_cg(operatorInfoDTO.getId_org());
			blOrderAppendBillParamDTO.setId_dep_cg(operatorInfoDTO.getId_dep());
			blOrderAppendBillParamDTO.setId_emp_cg(operatorInfoDTO.getId_emp());
			blOrderAppendBillParamDTO.setSrcfunc_des(IBlCgCodeConst.RegisterFee); // 挂号费产生
			blOrderAppendBillParamDTO.setCode_st(code_st);// 提前生成的code_st
		}
		// TODO review by yangyang 尽量整个提取到bp里，直接通过业务bp的实例调用SetCiOrderToPrice方法
		// 1.调用划价方法
		BlCgOepAggDTO blCgOepAggDTO = SetCiOrderToPrice(appendBillParamDTOs, operatorInfoDTO, PrintInvoice);
		BlcgoepAggDO[] blcgoepAggDO = (BlcgoepAggDO[]) blCgOepAggDTO.getBlcgoepAggDO().toArray(new BlcgoepAggDO[0]);

		// 2.保存分摊
		if (blPropOepDOArr != null) {
			for (BlPropOepDO blPropOepDO : blPropOepDOArr) {
				blPropOepDO.setId_stoep(blcgoepAggDO[0].getBlCgItmOepDO()[0].getId_stoep());
				blPropOepDO.setId_org(operatorInfoDTO.getId_org());
				blPropOepDO.setId_grp(blcgoepAggDO[0].getBlCgItmOepDO()[0].getId_grp());
			}
			// saveProp(blPropOepDOArr,blproparoepAggDOArr);

			//TODO  1.保存分摊信息，并用分摊汇总信息更新bl_st_oep和bl_cg_oep表
			savePropAndWriteBackStInc(null,blPropOepDOArr, blproparoepAggDOArr);
			// 2.修改cg表中的amt,amt_pat,amt_hp
			updateCgAmtHpByProp(blPropOepDOArr, blproparoepAggDOArr, blcgoepAggDO);
		}

		// 3.付款
		SettlementPayBp bp = new SettlementPayBp();
		BlIncItmVsTypeDTO[] blIncItmVsTypeDTOArr = bp.exec(blcgoepAggDO, blpaypatoepAggDO, FBoolean.TRUE, PrintInvoice, IsTransferPrepay);
		//BlIncItmVsTypeDTO[] blIncItmVsTypeDTOArr = SettlementPayment(blcgoepAggDO, blpaypatoepAggDO, FBoolean.TRUE, PrintInvoice, IsTransferPrepay);

		if (blcgoepAggDO != null && blcgoepAggDO.length > 0) {
			id_cgoep = blcgoepAggDO[0].getParentDO().getId_cgoep();
			IBlCgCmdService server = ServiceFinder.find(IBlCgCmdService.class);
			server.sendRefundMsgByStId(blcgoepAggDO[0].getBlCgItmOepDO()[0].getId_stoep());
		}

		return blIncItmVsTypeDTOArr;
	}
	
	/**
	 * 挂号划价结算一体化:仅处理单次挂号（含医保）
	 * 
	 * @param appendBillParamDTOs
	 *            费用明细
	 * @param blpaypatoepAggDO
	 *            支付明细
	 * @param blPropOepDOArr
	 *            医保分摊1，无分摊则为null
	 * @param blproparoepAggDOArr
	 *            医保分摊2，无分摊则为null
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @param tradeNo
	 *            医保交易号
	 * @param code_st
	 *            结算号
	 * @param PrintInvoice
	 *            是否打印发票
	 * @param IsTransferPrepay
	 *            余额是否结转到预交金
	 *@param oepSettleRtnValDto
	 *医保结算返回值
	 * @return 发票信息
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] PriceAndSettlementPaymentInsurance_Register(BlOrderAppendBillParamDTO[] appendBillParamDTOs, BlpaypatoepAggDO blpaypatoepAggDO, BlPropOepDO[] blPropOepDOArr,
			BlproparoepAggDO[] blproparoepAggDOArr, OperatorInfoDTO operatorInfoDTO, String tradeNo, String code_st, FBoolean PrintInvoice, FBoolean IsTransferPrepay,String idCg,OepSettleRtnValDTO oepSettleRtnValDto)throws BizException 
	{
		//设置结算编码上下文，用于结算时的存储
		Context.get().setAttribute(IBlFlowKeyConst.BL_FLOW_KEY_ST_CODE, code_st);
		
		String id_cgoep = null;

		// 设置重收数据中的sd_pttp   PO说注了
		/*if (blpaypatoepAggDO != null && !StringUtil.isEmpty(idCg)) {
			IBlpaypatoepMDORService paypatoepSer = ServiceFinder.find(IBlpaypatoepMDORService.class);
			BlPayPatOepDO[] oepDOs = paypatoepSer.find(" ID_PAYPATOEP=(SELECT ID_PAYPATOEP FROM BL_ST_OEP WHERE ID_STOEP=(SELECT ID_STOEP FROM BL_CG_ITM_OEP WHERE ROWNUM=1 AND ID_CGOEP='" + idCg + "'))", "", FBoolean.FALSE);
			if (oepDOs != null && oepDOs.length == 1) {
				blpaypatoepAggDO.getParentDO().setSd_pttp(oepDOs[0].getSd_pttp());
			}
		}*/

		for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : appendBillParamDTOs) {
			blOrderAppendBillParamDTO.setId_org_cg(operatorInfoDTO.getId_org());
			blOrderAppendBillParamDTO.setId_dep_cg(operatorInfoDTO.getId_dep());
			blOrderAppendBillParamDTO.setId_emp_cg(operatorInfoDTO.getId_emp());
			blOrderAppendBillParamDTO.setSrcfunc_des(IBlCgCodeConst.RegisterFee); // 挂号费产生
			blOrderAppendBillParamDTO.setCode_st(code_st);// 提前生成的code_st
		}
		// TODO review by yangyang 尽量整个提取到bp里，直接通过业务bp的实例调用SetCiOrderToPrice方法
		// 1.调用划价方法
		BlCgOepAggDTO blCgOepAggDTO = SetCiOrderToPrice(appendBillParamDTOs, operatorInfoDTO, PrintInvoice);
		BlcgoepAggDO[] blcgoepAggDO = (BlcgoepAggDO[]) blCgOepAggDTO.getBlcgoepAggDO().toArray(new BlcgoepAggDO[0]);

		// 2.保存分摊
		if (blPropOepDOArr != null) {
			for (BlPropOepDO blPropOepDO : blPropOepDOArr) {
				blPropOepDO.setId_stoep(blcgoepAggDO[0].getBlCgItmOepDO()[0].getId_stoep());
				blPropOepDO.setId_org(operatorInfoDTO.getId_org());
				blPropOepDO.setId_grp(blcgoepAggDO[0].getBlCgItmOepDO()[0].getId_grp());
			}
			// saveProp(blPropOepDOArr,blproparoepAggDOArr);

			//TODO  1.保存分摊信息，并用分摊汇总信息更新bl_st_oep和bl_cg_oep表
			savePropAndWriteBackStInc(oepSettleRtnValDto,blPropOepDOArr, blproparoepAggDOArr);
			// 2.修改cg表中的amt,amt_pat,amt_hp
			updateCgAmtHpByProp(blPropOepDOArr, blproparoepAggDOArr, blcgoepAggDO);
		}

		// 3.付款
		SettlementPayBp bp = new SettlementPayBp();
		BlIncItmVsTypeDTO[] blIncItmVsTypeDTOArr = bp.exec(blcgoepAggDO, blpaypatoepAggDO, FBoolean.TRUE, PrintInvoice, IsTransferPrepay);
		//BlIncItmVsTypeDTO[] blIncItmVsTypeDTOArr = SettlementPayment(blcgoepAggDO, blpaypatoepAggDO, FBoolean.TRUE, PrintInvoice, IsTransferPrepay);

		if (blcgoepAggDO != null && blcgoepAggDO.length > 0) {
			id_cgoep = blcgoepAggDO[0].getParentDO().getId_cgoep();
			IBlCgCmdService server = ServiceFinder.find(IBlCgCmdService.class);
			server.sendRefundMsgByStId(blcgoepAggDO[0].getBlCgItmOepDO()[0].getId_stoep());
		}

		return blIncItmVsTypeDTOArr;
	}


	/**
	 * 打印门诊挂号发票（处理在挂号收费以及后台自动结算时没有及时打印发票，后期补打的情况）
	 * 
	 * @param strIdPat
	 *            患者主键ID
	 * @param operatorInfoDTO
	 *            操作人员信息
	 * @return 发票信息
	 * @throws BizException
	 * @author Liwq 添加参数解决红冲发票选择性打印
	 */
	public BlIncItmVsTypeDTO[] printRegisterInvoice(String strIdPat, OperatorInfoDTO operatorInfoDTO, String[] strArr) throws BizException {
		BLCiOrderToBlCgServiceImplBp handlerBp = new BLCiOrderToBlCgServiceImplBp();
		return handlerBp.printRegisterInvoice(strIdPat, operatorInfoDTO, strArr);
	}

	/**
	 * 根据结算号更新发票表发票号
	 * 
	 * @param id_stoepArr
	 * @param operatorInfoDTO
	 * @param Code_incca
	 * @param code_incpkg
	 * @throws BizException
	 */
	public FBoolean updateBlIncOepIncno(String[] id_stoepArr, OperatorInfoDTO operatorInfoDTO, String Code_incca, String code_incpkg) throws BizException {

		// 获得发票号
		IBLInvoiceService obj11 = ServiceFinder.find(IBLInvoiceService.class);
		String[] invoiceNo = obj11.GetManyInvoiceNo(operatorInfoDTO.getId_emp(), Code_incca, id_stoepArr.length, code_incpkg);
		int i = 0;
		// 发票号回写bl_inc_oep
		DAFacade dafacade = new DAFacade();
		for (String id_stoep : id_stoepArr) {
			List<BlIncOepDO> blIncOepDOLst = (List<BlIncOepDO>) dafacade.findByCond(BlIncOepDO.class, "id_stoep='" + id_stoep + "'");
			if (blIncOepDOLst == null || blIncOepDOLst.size() == 0) {
				return FBoolean.FALSE;
			}
			BlIncOepDO[] blIncOepDO = blIncOepDOLst.toArray(new BlIncOepDO[0]); // 结算与发票一一对应
			if (!blIncOepDO[0].getFg_print().booleanValue() && invoiceNo[i].equals(blIncOepDO[0].getIncno())) {
				blIncOepDO[0].setIncno(invoiceNo[i]);
				blIncOepDO[0].setId_emp_canc(null);
				blIncOepDO[0].setId_emp_inc(operatorInfoDTO.getId_emp());
				blIncOepDO[0].setTimes_prn(1);
				blIncOepDO[0].setFg_print(FBoolean.TRUE);
				blIncOepDO[0].setStatus(DOStatus.UPDATED);
				if (dafacade.updateDO(blIncOepDO[0]) == 0) {
					throw new BizException("保存发票号失败！");
				}
				i++;
			}
		}
		return FBoolean.TRUE;
	}

	/**
	 * 获取所有商保对应的合同单位(门诊)
	 * 
	 * @author Liwq
	 * @throws BizException
	 */
	public HPDO[] GetAllHpCust() throws BizException {
		// FMap map = new FMap();
		// StringBuilder sql = new StringBuilder();
		// sql.append(" select c.id_cust as cust_id,c.name as cust_name from  en_ent_hp a inner join bd_hp b on a.id_hp = b.id_hp inner join bd_cust c on b.id_cust = c.id_cust ");
		// sql.append(" where a.id_ent = ? and b.fg_hpcg='Y'");
		//
		// SqlParam param = new SqlParam();
		// param.addParam(id_ent);
		//
		// List<String> list = (List<String>) new
		// DAFacade().execQuery(sql.toString(),param, new ColumnListHandler());
		// if(!list.isEmpty()) {
		// map.put("cust_id", list.get(0));
		//
		// map.put("cust_name", list.get(1));
		// }
		//
		// return map;

		IHpMDORService hpService = ServiceFinder.find(IHpMDORService.class);
		HPDO[] hpDoArr = hpService.find(" a0.fg_hpcg = 'Y' ", "a0.code", FBoolean.TRUE);
		return hpDoArr;
	}

	/**
	 * 供第三方划价和结算一体化
	 * 
	 * @param orderBillParamDTOs
	 * @param operatorInfoDTO
	 * @return
	 * @throws BizException
	 */
	public OpPayReturn PriceAndSettlementPaymentForThirdParty(BlOrderAppendBillParamDTO[] orderBillParamDTOs, OperatorInfoDTO operatorInfoDTO, FDouble money, String id_pat, OpPayParam thirdPartyParam) throws BizException {
		StringBuffer msg_p = new StringBuffer();
		OpPayReturn rtnInfo = new OpPayReturn();
		IBLCiOrderToBlCgService cgService = ServiceFinder.find(IBLCiOrderToBlCgService.class);
		IBLCiOrderToBlCgServiceImpl BlCiOrderToBlCgServiceImpl = new IBLCiOrderToBlCgServiceImpl();
		BLCiOrderToBlCgServiceImplBp bLCiOrderToBlCgServiceImplBp = new BLCiOrderToBlCgServiceImplBp();

		BlCgOepAggDTO blCgOepAggDTO = new BlCgOepAggDTO();
		// 4.1 划价
		try {
			blCgOepAggDTO = cgService.SetCiOrderToPrice(orderBillParamDTOs, operatorInfoDTO, FBoolean.FALSE);
		} catch (Exception e) {
			msg_p.append("第三方患者id:").append(id_pat).append(" 后台自动划价失败！").append("\r\n");
			BLBizLogger.info(msg_p.toString() + e.getMessage());
			rtnInfo.setResultCode("1");
			rtnInfo.setResultMsg("第三方划价失败，请重新操作！");
			return rtnInfo;
		}
		// 4.2 组装收付款AGG
		FDouble amt_ratio = new FDouble(0);

		FArrayList blcgoepAggDOLst = blCgOepAggDTO.getBlcgoepAggDO();
		BlcgoepAggDO[] blcgoepAggDOs = (BlcgoepAggDO[]) blcgoepAggDOLst.toArray(new BlcgoepAggDO[0]);
		for (BlcgoepAggDO blcgoepAggDO : blcgoepAggDOs) {
			BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDO.getBlCgItmOepDO();
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOs) {
				amt_ratio = amt_ratio.add(blCgItmOepDO.getAmt_ratio());
			}
		}
		// 比较支付金额是否一致
		if (amt_ratio.compareTo(money) > 0) {
			FBoolean fBool = bLCiOrderToBlCgServiceImplBp.DeletePricingInfo_bp(blcgoepAggDOs, false);
			if (fBool.booleanValue()) {
				rtnInfo.setResultCode("1");
				rtnInfo.setResultMsg("输入金额错误！应付金额" + amt_ratio.toString() + "元！");
			} else {
				rtnInfo.setResultCode("1");
				rtnInfo.setResultMsg("因输入金额错误，（应付金额" + amt_ratio.toString() + "元）而进行的取消划价失败！");
			}
			return rtnInfo;
		}

		// BlpaypatoepAggDO blpaypatoepAggDO =
		// bLCiOrderToBlCgServiceImplBp.AssemblePayData(amt_ratio,
		// operatorInfoDTO, id_pat, null);
		// 组装收付款主子表数据
		BlpaypatoepAggDO blpaypatoepAggDO = new BlpaypatoepAggDO();
		// 1.组装主表
		BlPayPatOepDO blPayPatOepDO = new BlPayPatOepDO();
		blPayPatOepDO.setId_grp(operatorInfoDTO.getId_grp());
		blPayPatOepDO.setId_org(operatorInfoDTO.getId_org());
		blPayPatOepDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);// const
		blPayPatOepDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);// const
		blPayPatOepDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_ST);// const
		blPayPatOepDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_ST);// const
		blPayPatOepDO.setId_pat(id_pat);
		blPayPatOepDO.setEu_direct(PayDirectEnum.CHARGE);
		// 费用来源
		if (!StringUtil.isEmptyWithTrim(thirdPartyParam.getPtTpCode())) {
			blPayPatOepDO.setSd_pttp(thirdPartyParam.getPtTpCode());
		} else {
			blPayPatOepDO.setSd_pttp(IBlDictCodeConst.SD_PTTP_PHONE_APP);
		}
		// 实际的收付款数肯定应该是要收入的金额
		blPayPatOepDO.setAmt(amt_ratio);
		blPayPatOepDO.setId_org_pay(operatorInfoDTO.getId_org_emp());
		blPayPatOepDO.setId_dep_pay(operatorInfoDTO.getId_dep());
		blPayPatOepDO.setId_emp_pay(operatorInfoDTO.getId_emp());
		blPayPatOepDO.setFg_cc(FBoolean.FALSE);
		blpaypatoepAggDO.setParentDO(blPayPatOepDO);

		// 2. 组装子表
		BlPayItmPatOepDO[] arr = new BlPayItmPatOepDO[1];
		BlPayItmPatOepDO blPayItmPatOepDO_1 = new BlPayItmPatOepDO();
		blPayItmPatOepDO_1.setId_grp(operatorInfoDTO.getId_grp());
		blPayItmPatOepDO_1.setId_org(operatorInfoDTO.getId_org());
		blPayItmPatOepDO_1.setEu_direct(Integer.valueOf(IBlDictCodeConst.SD_DIRECT_CHARGE).intValue());
		// 获取统一解析支付方式数据的BP
		GetPayCodeBP payhelp = new GetPayCodeBP();
		PriPmDO pripm = payhelp.exec(thirdPartyParam.getPmCode(), true);
		blPayItmPatOepDO_1.setId_pm(pripm.getId_pm());
		blPayItmPatOepDO_1.setSd_pm(pripm.getSd_pmtp());
		// blPayItmPatOepDO_1.setName_pm(pripm.getName());

		// if ("1".equals(thirdPayType)) {
		// blPayItmPatOepDO_1.setId_pm(IBdPripmCodeConst.ID_PRI_PM_ALIPAY); //
		// 支付宝
		// blPayItmPatOepDO_1.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_ALIPAY);
		// } else if ("2".equals(thirdPayType)) {
		// blPayItmPatOepDO_1.setId_pm(IBdPripmCodeConst.ID_PRI_PM_WECHAT); //
		// 微信
		// blPayItmPatOepDO_1.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_WECHAT);
		// } else if ("4".equals(thirdPayType)) {
		// blPayItmPatOepDO_1.setId_pm(IBdPripmCodeConst.ID_PRI_PM_CREDIT); //
		// 银行卡
		// blPayItmPatOepDO_1.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CREDIT);
		// }else if ("6".equals(thirdPayType)) {
		// blPayItmPatOepDO_1.setId_pm(IBdPripmCodeConst.ID_PRI_PM_INSURPERSONALACCOUNT);
		// // 医保个人账户
		// blPayItmPatOepDO_1.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT);
		// }else {
		// blPayItmPatOepDO_1.setId_pm(IBdPripmCodeConst.ID_PRI_PM_PAY); //3 预交金
		// blPayItmPatOepDO_1.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
		// }

		blPayItmPatOepDO_1.setId_cust(null);
		blPayItmPatOepDO_1.setId_bank(null);
		blPayItmPatOepDO_1.setBankno(thirdPartyParam.getAccount());
		blPayItmPatOepDO_1.setPaymodenode(thirdPartyParam.getPayOrder());
		blPayItmPatOepDO_1.setStatus(DOStatus.NEW);

		blPayItmPatOepDO_1.setAmt(amt_ratio);
		blPayItmPatOepDO_1.setFg_realpay(FBoolean.TRUE);// 真实数据
		arr[0] = blPayItmPatOepDO_1;
		// 子项添加到AggDO
		blpaypatoepAggDO.setBlPayItmPatOepDO(arr);

		// 4.3 结算
		String code_st = "";
		String id_stoep = "";
		String disWindow = "";// 发药窗口
		try {
			BlIncItmVsTypeDTO[] blIncItmVsTypeDTOs = BlCiOrderToBlCgServiceImpl.SettlementPayment(blcgoepAggDOs, blpaypatoepAggDO, FBoolean.FALSE, FBoolean.FALSE, FBoolean.FALSE);
			code_st = blIncItmVsTypeDTOs[0].getBlInvoiceHeadTailDTO().getCode_st();
			id_stoep = blIncItmVsTypeDTOs[0].getBlInvoiceHeadTailDTO().getId_stoep();
			// 提取发药窗口
			GetMedWindowsBP getWin = new GetMedWindowsBP();
			disWindow = getWin.getWindows(blIncItmVsTypeDTOs);
		} catch (Exception e) {
			msg_p.append("第三方患者id:").append(id_pat).append(" 后台自动结算失败！").append("\r\n");
			BLBizLogger.info(msg_p.toString() + e.getMessage());

			rtnInfo.setResultCode("1");
			rtnInfo.setResultMsg("第三方结算失败，请重新操作！");
			rtnInfo.setCodeSt("");
			return rtnInfo;

		}
		rtnInfo.setDispenseWindow(disWindow);
		rtnInfo.setResultCode("0");
		rtnInfo.setResultMsg("操作成功！");
		rtnInfo.setCodeSt(code_st);
		// 获取结算的记账id 挂号收费需返回 by lim 2017-10-26
		GetIdCgOepByIdStoep getIdArr = new GetIdCgOepByIdStoep();
		rtnInfo.setIdCgOepArray(getIdArr.exec(id_stoep));
		return rtnInfo;
	}

	/**
	 * 供第三方：根据就诊id和处方号查询未结算费用
	 * 
	 * @param id_pres
	 * @param id_ent
	 * @author Liwq
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] getNoSettledSrvFromCiByIdentIdPres(String id_pres, String id_ent) throws BizException {

		IBLStQueService stService = ServiceFinder.find(IBLStQueService.class);
		String[] sd_su_bl = { "0" };
		List<BlOrderAppendBillParamDTO> list = new ArrayList<BlOrderAppendBillParamDTO>();
		BlOrderAppendBillParamDTO[] orderFeeDtoArr = stService.getOrderSrvPrinceInfoByIdent(id_ent, sd_su_bl);
		if (orderFeeDtoArr != null && orderFeeDtoArr.length > 0) {
			for (BlOrderAppendBillParamDTO itmDto : orderFeeDtoArr) {
				if (itmDto.getId_or() != null && itmDto.getId_or().length() > 0) {
					if (itmDto.getId_or().equals(id_pres)) {
						list.add(itmDto);
					}
				}
			}
		}
		return list.toArray(new BlOrderAppendBillParamDTO[] {});
	}

	@Override
	public String CiOrderById_or_validate(String[] id_ors) throws BizException {
		PriceSettleBP bp = new PriceSettleBP();
		return bp.validateCiOrderSrvById_or(id_ors);
	}

	@Override
	public String GetBlOepCodeSt() throws BizException {
		return BlCodeUtils.generateOepStCode();
	}
	
	/**
	 * 发票重打新版本
	 * @param stId 结算id
	 * @param incDtos 需重打的发票信息
	 * @return
	 * @throws BizException
	 * @author ly 2018/04/16
	 */
	@Override
	public BlIncItmVsTypeDTO[] doRePrintIncNew(String stId,RePrintInvoiceInfoDTO[] incDtos) throws BizException{
		BlCgReprintIncBP bp = new BlCgReprintIncBP();
		return bp.exec(stId, incDtos);
	}
	/**
	 * 第三方支付  处理逻辑 修改付款方式 回写日志信息
	 * @param blcgoepAggDOArr
	 * @param blpaypatoepAggDOs
	 * @throws BizException 
	 */
	private void ThirdPaySettle(BlcgoepAggDO[] blcgoepAggDOArr,BlpaypatoepAggDO[] blpaypatoepAggDOs,String  id_stoep) throws BizException{
		
		// 12.如果收款类型为窗口，并且付款方式为支付宝或者微信，则回写日志信息
		if (IBlDictCodeConst.SD_PTTP_WINDOW.equals(blpaypatoepAggDOs[0].getParentDO().getSd_pttp())) {
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
	
}
