package iih.bl.cg.service.s.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.MapUtils;
import iih.bd.base.validator.ParamValidator;
import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.bp.DoOepFgFree;
import iih.bl.cg.bp.GetBlCgItmOepMap;
import iih.bl.cg.bp.RedBackBP;
import iih.bl.cg.bp.RefundBackBizBp;
import iih.bl.cg.dto.d.BlCgItmOepMapDTO;
import iih.bl.cg.dto.d.BlCgoepAggAndPrintRedIncItmDTO;
import iih.bl.cg.service.d.BlRefundItmDTO;
import iih.bl.cg.service.d.Bl_reSettlement_ST_INC_DTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.inc.blincoep.d.BlIncCgItmOep;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlStIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.i.IBlIncValidateService;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.bl.inc.service.i.IBlincQryService;
import iih.bl.prop.blproparoep.d.BlPropArItmOepDO;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blproparoep.d.desc.BlPropArOepDODesc;
import iih.bl.prop.blproparoep.i.IBlproparoepCudService;
import iih.bl.prop.blproparoep.i.IBlproparoepRService;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.prop.blpropoep.d.desc.BlPropOepDODesc;
import iih.bl.prop.blpropoep.i.IBlpropoepCudService;
import iih.bl.prop.blpropoep.i.IBlpropoepRService;
import iih.bl.prop.service.i.IBLPropMaintainService;
import iih.bl.pub.IBlFunCodeConst;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepCudService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mm.itf.material.d.ReserveReqDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.mp.dg.dto.d.OpDgRtnAmountDTO;
import iih.mp.dg.i.IMpDgOutService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
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

/**
 * 退费业务逻辑
 * 
 * @author tcy
 *
 */
public class BLCancelSettlementImplBp {
	/**
	 * 查询患者的就诊对应医保计划下，是否需要打印红冲票
	 * 
	 * @param id_ent
	 *            就诊ID
	 * @return FBoolean.FALSE 不打印红冲票；FBoolean.TRUE 打印红冲票
	 * @throws BizException
	 * @author yang.lu 2017年6月26日 当前方法迁入到 IBlIncOutQryService 中 的 isPrintRedInc中
	 */
	public FBoolean getFPrintRedInc(String id_ent) throws BizException {
		IBlIncValidateService service = ServiceFinder.find(IBlIncValidateService.class);
		return service.isPrintRedInc(id_ent);
	}

	/**
	 * 红冲票据：取医保计划，如果医保要求打印红冲票据（BD_HP.FG_SABINC =
	 * TRUE）并且红冲票据需要由HIS打印(BD_HP.EU_SABINCPRN = 0)，则生成红冲发票，并且移动票号；
	 * 否则，也生成红冲发票，但是incno,code_incpkg,dt_inc,id_emp_inc设为空，fg_print=false
	 * 
	 * @param printRedInc
	 *            是否打印红冲票
	 * @param id_stoep
	 *            原票据对应的结算ID
	 * @param id_stoep_redback
	 *            原结算对应的红冲结算ID
	 * @param PrintOnlyOneInvoice
	 *            多次就诊一次结算是否打印一张发票
	 * @param AllRefundAndAllCharge
	 *            是否重退重收
	 * @param strDateTime
	 *            当前操作时间
	 * @param operatorInfoDTO
	 *            操作人员信息
	 * @throws BizException
	 */
	private BlincoepAggDO[] redback_BlIncOep(FBoolean printRedInc, String id_stoep, String id_stoep_redback, FBoolean PrintOnlyOneInvoice, FBoolean AllRefundAndAllCharge, FDateTime strDateTime,
			OperatorInfoDTO operatorInfoDTO, BlcgoepAggDO[] blcgoepAggDO1) throws BizException {
		// 红冲票据
		BlincoepAggDO[] blincoepAggDOs = null;
		String entAndno = "", key = "";

		// 查找原发票
		IBlincoepRService iBlincoepRService = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] r_blincoepAggDOs = iBlincoepRService.find(" a0.id_stoep='" + id_stoep + "'", "", FBoolean.TRUE);
		if (null == r_blincoepAggDOs || r_blincoepAggDOs.length == 0) {
			throw new BizException("查询原门诊结算发票信息失败");
		}
		// 原发票设为作废
		// fg_canc 发票作废标志 Y
		// sd_reason_canc 发票作废原因 01
		// des_reason_canc 发票作废原因描述 退费
		// dt_canc 发票作废日期 当前时间（服务器时间）
		// id_emp_canc 发票作废操作人 操作员
		for (BlincoepAggDO blincoepAggDO : r_blincoepAggDOs) {
			BlIncOepDO blIncOepDO = blincoepAggDO.getParentDO();
			blIncOepDO.setFg_canc(FBoolean.TRUE);
			blIncOepDO.setId_reason_canc(IBdPpCodeTypeConst.ID_REFUND);
			blIncOepDO.setSd_reason_canc(IBdPpCodeTypeConst.SD_REFUND);
			blIncOepDO.setDes_reason_canc(IBdPpCodeTypeConst.DES_REFUND);
			blIncOepDO.setDt_canc(strDateTime);
			blIncOepDO.setId_emp_canc(operatorInfoDTO.getId_emp());
			blIncOepDO.setStatus(DOStatus.UPDATED);
		}

		IBlincoepCudService iBlincoepCudService = ServiceFinder.find(IBlincoepCudService.class);
		BlincoepAggDO[] blincoepAggDOs1 = iBlincoepCudService.save((r_blincoepAggDOs));
		if (null == blincoepAggDOs1 || blincoepAggDOs1.length == 0) {
			throw new BizException("保存红冲门诊结算发票信息失败");
		}
		// FBoolean printRedInc = getFPrintRedInc(id_ent);
		// 将bl_cg_itm_oep.id_cgitmoep存入bl_inc_cg_itm_oep
		// 得到红冲的费用明细
		List<BlCgItmOepDO> blCgItmOepDOLst = new ArrayList<BlCgItmOepDO>();// blcgoepAggDO1
		for (BlcgoepAggDO blcgoepAggDO : blcgoepAggDO1) {
			BlCgItmOepDO[] blCgItmOepDOArr = blcgoepAggDO.getBlCgItmOepDO();
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOArr) {
				if (blCgItmOepDO.getId_stoep().equals(id_stoep_redback)) {
					blCgItmOepDOLst.add(blCgItmOepDO);
				}
			}
		}
		BlCgItmOepDO[] blCgItmOepDOArr = blCgItmOepDOLst.toArray(new BlCgItmOepDO[0]);
		String maxInvoiceno = "";

		// if (printRedInc.booleanValue())
		// { // 红冲发票，即红冲的发票也要打印出来

		// 保存发票信息：blincoepAggDO

		String code_incpkg = "";
		IBlincQryService iBlincQryService = ServiceFinder.find(IBlincQryService.class);
		IBLInvoiceService obj11 = ServiceFinder.find(IBLInvoiceService.class);
		String[] invoiceNo = null;
		if (printRedInc.booleanValue()) {
			invoiceNo = obj11.GetManyInvoiceNo(operatorInfoDTO.getId_emp(), IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE, r_blincoepAggDOs.length, r_blincoepAggDOs[0].getParentDO().getCode_incpkg());
		}
		List<BlincoepAggDO> blincoepAggDOList = new ArrayList<BlincoepAggDO>();
		for (int i = 0; i < r_blincoepAggDOs.length; i++) {
			BlincoepAggDO blincoepAggDO = new BlincoepAggDO();
			BlIncOepDO blIncOepDO = r_blincoepAggDOs[i].getParentDO();
			blIncOepDO.setId_incoep(null);
			blIncOepDO.setId_grp(operatorInfoDTO.getId_grp());
			blIncOepDO.setId_org(operatorInfoDTO.getId_org());
			blIncOepDO.setEu_direct(BookRtnDirectEnum.REFUND);

			if (printRedInc.booleanValue()) { // 红冲票打印，才设置这些值，否则，不用设置
				blIncOepDO.setIncno(invoiceNo[i]);
				code_incpkg = iBlincQryService.getCodeIncPkgByIdempiss(operatorInfoDTO.getId_org(), operatorInfoDTO.getId_emp(), IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
				blIncOepDO.setCode_incpkg(code_incpkg);
				blIncOepDO.setDt_inc(strDateTime);
				blIncOepDO.setId_emp_inc(operatorInfoDTO.getId_emp());
				blIncOepDO.setTimes_prn(1);
				blIncOepDO.setFg_print(FBoolean.TRUE);
			} else {
				blIncOepDO.setIncno(null);
				blIncOepDO.setCode_incpkg("");
				blIncOepDO.setDt_inc(null);
				blIncOepDO.setId_emp_inc("");
				blIncOepDO.setTimes_prn(0);
				blIncOepDO.setFg_print(FBoolean.FALSE);
			}
			blIncOepDO.setFg_canc(FBoolean.FALSE);
			blIncOepDO.setSd_reason_canc(null);
			blIncOepDO.setId_reason_canc(null);
			blIncOepDO.setDes_reason_canc(null);
			blIncOepDO.setDt_canc(null);

			blIncOepDO.setId_emp_canc(null);
			blIncOepDO.setId_stoep(id_stoep_redback);
			blIncOepDO.setFg_cc_in(FBoolean.FALSE);
			blIncOepDO.setFg_cc_out(FBoolean.FALSE);
			blIncOepDO.setId_cc_in(null);
			blIncOepDO.setId_cc_out(null);
			blIncOepDO.setStatus(DOStatus.NEW);
			if (printRedInc.booleanValue()) {
				// if(PrintOnlyOneInvoice.booleanValue())
				// {
				key = blIncOepDO.getId_pat();
				// }
				// else
				// {
				// key=blIncOepDO.getId_pat()+" "+blIncOepDO.getId_ent()+" "+blIncOepDO.getId_enttp();
				// }
				entAndno = entAndno + key + "," + invoiceNo[i] + "|";
				// 获得最大发票号
				if (maxInvoiceno.compareTo(invoiceNo[i]) < 0) {
					maxInvoiceno = invoiceNo[i];
				}
			}
			BlStIncOepDO[] blStIncOepDOs = r_blincoepAggDOs[i].getBlStIncOepDO();
			for (int j = 0; j < blStIncOepDOs.length; j++) {
				blStIncOepDOs[j].setId_incoep(null);
				blStIncOepDOs[j].setId_stoep(id_stoep_redback);
				blStIncOepDOs[j].setId_stincoep(null);
				blStIncOepDOs[j].setStatus(DOStatus.NEW);
			}
			BlIncCgItmOep[] blIncCgItmOeps = r_blincoepAggDOs[i].getBlIncCgItmOep();
			for (int k1 = 0; k1 < blIncCgItmOeps.length; k1++) {
				blIncCgItmOeps[k1].setId_inccgitmoep(null);
				blIncCgItmOeps[k1].setId_incoep(null);
				blIncCgItmOeps[k1].setId_cgitmoep(blCgItmOepDOArr[k1].getId_cgitmoep());
				blIncCgItmOeps[k1].setStatus(DOStatus.NEW);
			}

			BlIncItmOepDO[] blIncItmOepDOs = r_blincoepAggDOs[i].getBlIncItmOepDO();
			for (BlIncItmOepDO blIncItmOepDO : blIncItmOepDOs) {
				blIncItmOepDO.setId_incitmoep(null);
				blIncItmOepDO.setId_incoep(null);
				blIncItmOepDO.setStatus(DOStatus.NEW);
			}

			blincoepAggDO.setParentDO(blIncOepDO);
			blincoepAggDO.setBlStIncOepDO(blStIncOepDOs);
			blincoepAggDO.setBlIncCgItmOep(blIncCgItmOeps);
			blincoepAggDO.setBlIncItmOepDO(blIncItmOepDOs);
			blincoepAggDOList.add(blincoepAggDO);
		}

		blincoepAggDOs = iBlincoepCudService.save(blincoepAggDOList.toArray(new BlincoepAggDO[] {}));
		if (null == blincoepAggDOs || blincoepAggDOs.length == 0) {
			throw new BizException("保存红冲门诊结算发票信息失败");
		}
		if (printRedInc.booleanValue()) {
			// 打印了红冲票，需要重设当前发票号
			String curno = computeNextInvoiceNo(maxInvoiceno);
			IBLInvoiceService iBLInvoiceService = ServiceFinder.find(IBLInvoiceService.class);

			iBLInvoiceService.SetCurNoByParamNo(operatorInfoDTO.getId_emp(), IBdInccaCodeConst.ID_OUTPATIENT_INVOICE, curno);
		}
		// }
		return blincoepAggDOs;
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
	 * 红冲门诊结算表，且修改原结算表
	 * 
	 * @param id_stoep
	 * @param operatorInfoDTO
	 * @return
	 */
	private BlStOepDO RedBackBlStOep_And_RepairOrginOrginBlStOep(BlStOepDO orgin_BlStOepDO, OperatorInfoDTO operatorInfoDTO, String id_paypatoep, FDateTime strDateTime, String eu_sttp)
			throws BizException {
		GetCodeByCustomization code_ins = new GetCodeByCustomization();
		// 1. 修改原结算信息，设置为取消
		orgin_BlStOepDO.setFg_canc(FBoolean.TRUE);
		orgin_BlStOepDO.setId_emp_canc(operatorInfoDTO.getId_emp());
		orgin_BlStOepDO.setDt_canc(strDateTime);
		orgin_BlStOepDO.setId_reason_canc(IBlDictCodeConst.BD_REFUND_SETTLE_CANCELLED_ID);
		orgin_BlStOepDO.setSd_reason_cand(IBlDictCodeConst.BD_REFUND_SETTLE_CANCELLED);
		orgin_BlStOepDO.setStatus(DOStatus.UPDATED);
		IBlstoepCudService iBlstoepCudService = ServiceFinder.find(IBlstoepCudService.class);
		BlStOepDO[] blStOepDOs = iBlstoepCudService.save(new BlStOepDO[] { orgin_BlStOepDO });
		if (null == blStOepDOs || blStOepDOs.length == 0) {
			throw new BizException("修改原门诊结算信息失败");
		}
		// 2. 红冲结算,生成红冲的结算信息，并保存
		BlStOepDO red_blStOepDO = (BlStOepDO) orgin_BlStOepDO.clone();
		red_blStOepDO.setId_par(red_blStOepDO.getId_stoep());
		red_blStOepDO.setId_stoep(null);
		red_blStOepDO.setId_org(operatorInfoDTO.getId_org());
		red_blStOepDO.setId_grp(operatorInfoDTO.getId_grp());
		red_blStOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
		red_blStOepDO.setEu_sttp(eu_sttp);
		String stCode = BlCodeUtils.generateOepStCode();
		red_blStOepDO.setCode_st(stCode);
		red_blStOepDO.setDt_st(strDateTime);
		red_blStOepDO.setId_dep_st(operatorInfoDTO.getId_dep());
		red_blStOepDO.setId_emp_st(operatorInfoDTO.getId_emp());
		red_blStOepDO.setFg_cc(FBoolean.FALSE);
		red_blStOepDO.setFg_canc(FBoolean.FALSE);
		red_blStOepDO.setId_emp_canc(null);
		red_blStOepDO.setDt_canc(null);
		red_blStOepDO.setId_reason_canc(null);
		red_blStOepDO.setSd_reason_cand(null);
		red_blStOepDO.setDes_reason_canc(null);
		// 红冲的收付款主键
		red_blStOepDO.setId_paypatoep(id_paypatoep);
		red_blStOepDO.setStatus(DOStatus.NEW);
		BlStOepDO[] red_blStOepDO1 = iBlstoepCudService.save(new BlStOepDO[] { red_blStOepDO });
		if (null == red_blStOepDO1 || red_blStOepDO1.length == 0) {
			throw new BizException("保存红冲门诊结算信息失败");
		}
		return red_blStOepDO1[0];
	}

	/**
	 * 红冲门诊记账表，且修改原记账表
	 * 
	 * @param orgin_blcgoepAggDO1
	 *            原记账表
	 * @param strDateTime
	 *            时间
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @param repireCiSdSuBl
	 *            是否需要修改对应医嘱的记账状态
	 * @param red_idStOep
	 *            红冲bl_st_oep的主键
	 * @throws BizException
	 */
	private BlcgoepAggDO[] RedBackBlCg_And_RepairOrginOrginBlCg(BlcgoepAggDO[] orgin_blcgoepAggDO1, FDateTime strDateTime, OperatorInfoDTO operatorInfoDTO, FBoolean repireCiSdSuBl, String red_idStOep)
			throws BizException {
		GetCodeByCustomization code_ins = new GetCodeByCustomization();

		List<String> id_orsrv = new ArrayList<String>();

		List<BlcgoepAggDO> blcgoepAggDOList = new ArrayList<BlcgoepAggDO>();
		IBlcgoepCudService iBlcgoepCudService = ServiceFinder.find(IBlcgoepCudService.class);

		// 更改原bl_cg_itm_oep中的fg_refund为Y
		for (BlcgoepAggDO agg : orgin_blcgoepAggDO1) {
			agg.getParentDO().setStatus(DOStatus.UPDATED);
			BlCgItmOepDO[] blCgItmOepDOarr = agg.getBlCgItmOepDO();

			for (BlCgItmOepDO blCgItmOepdo : blCgItmOepDOarr) {

				blCgItmOepdo.setFg_refund(FBoolean.TRUE);
				blCgItmOepdo.setStatus(DOStatus.UPDATED);
			}

		}

		BlcgoepAggDO[] r_blcgoepAggDO = iBlcgoepCudService.save(orgin_blcgoepAggDO1);
		if (null == r_blcgoepAggDO || r_blcgoepAggDO.length == 0) {
			throw new BizException("修改原门诊记账信息失败");
		}

		// 红冲原纪录
		for (int i = 0; i < r_blcgoepAggDO.length; i++) {
			BlcgoepAggDO blcgoepAggDO = new BlcgoepAggDO();
			BlCgOepDO blCgOepDO = (BlCgOepDO) r_blcgoepAggDO[i].getParentDO().clone();
			blCgOepDO.setId_cgoep(null);
			blCgOepDO.setId_org(operatorInfoDTO.getId_org());
			blCgOepDO.setId_grp(operatorInfoDTO.getId_grp());
			blCgOepDO.setCode_cg(code_ins.GetCodeBlCgOep());
			blCgOepDO.setId_dep_cg(operatorInfoDTO.getId_dep());
			blCgOepDO.setId_org_cg(operatorInfoDTO.getId_org_emp());
			blCgOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
			blCgOepDO.setDt_cg(strDateTime);
			blCgOepDO.setStatus(DOStatus.NEW);
			BlCgItmOepDO[] blCgItmOepDOs = (BlCgItmOepDO[]) r_blcgoepAggDO[i].getBlCgItmOepDO();
			BlCgItmOepDO[] new_blCgItmOepDOs = new BlCgItmOepDO[blCgItmOepDOs.length];
			for (int j = 0; j < blCgItmOepDOs.length; j++) {
				BlCgItmOepDO new_BlCgItmOepDO = (BlCgItmOepDO) blCgItmOepDOs[j].clone();
				if (repireCiSdSuBl.booleanValue()) // 需要修改医嘱记账状态
				{
					if (blCgItmOepDOs[j].getId_orsrv() != null) // CI产生的数据需要修改医嘱记账状态；但是就诊来的数据就不用修改医嘱状态
					{
						id_orsrv.add(blCgItmOepDOs[j].getId_orsrv());
					}
				}
				new_BlCgItmOepDO.setNote("退费：" + blCgItmOepDOs[j].getId_cgitmoep());
				new_BlCgItmOepDO.setId_par(blCgItmOepDOs[j].getId_cgitmoep());
				new_BlCgItmOepDO.setId_cgitmoep(null);
				new_BlCgItmOepDO.setId_cgoep(null);
				new_BlCgItmOepDO.setId_org(operatorInfoDTO.getId_org());
				new_BlCgItmOepDO.setId_grp(operatorInfoDTO.getId_grp());
				new_BlCgItmOepDO.setFg_st(FBoolean.TRUE);
				new_BlCgItmOepDO.setId_stoep(red_idStOep);
				new_BlCgItmOepDO.setDt_st(strDateTime);
				new_BlCgItmOepDO.setFg_hp(blCgItmOepDOs[j].getFg_hp());
				new_BlCgItmOepDO.setFg_susp(FBoolean.FALSE);
				new_BlCgItmOepDO.setFg_refund(FBoolean.FALSE);
				new_BlCgItmOepDO.setStatus(DOStatus.NEW);
				new_blCgItmOepDOs[j] = new_BlCgItmOepDO;
			}
			blcgoepAggDO.setParentDO(blCgOepDO);
			blcgoepAggDO.setBlCgItmOepDO(new_blCgItmOepDOs);
			blcgoepAggDOList.add(blcgoepAggDO);
		}

		// 6. 保存红冲的记账信息
		BlcgoepAggDO[] red_blcgoepAggDO1 = iBlcgoepCudService.save(blcgoepAggDOList.toArray(new BlcgoepAggDO[] {}));
		if (null == red_blcgoepAggDO1 || red_blcgoepAggDO1.length == 0) {
			throw new BizException("保存红冲门诊记账信息失败");
		}

		if (id_orsrv.size() > 0)// 更新医嘱记账信息
		{
			// 7.修改医嘱为退费状态
			Object obj2 = ServiceFinder.find(ICiOrdMaintainService.class);
			FBoolean updateCiOrder = ((ICiOrdMaintainService) obj2).UpdateOrdChargeRelInfo2(id_orsrv.toArray(new String[] {}), ICiDictCodeConst.SD_SU_BL_REFOUND_ID, ICiDictCodeConst.SD_SU_BL_REFOUND,
					strDateTime, FeeReverseType.BLSTREVERSE);
		}
		return red_blcgoepAggDO1;
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
	private BlcgoepAggDO[] getNewRechargeBlCg(BlcgoepAggDO[] orgin_blcgoepAggDO1, BlRefundItmDTO[] id_cditmoep, FDateTime strDateTime, OperatorInfoDTO operatorInfoDTO, FBoolean PrintOnlyOneInvoice,
			FBoolean AllRefundAndAllCharge, String red_idStOep) throws BizException {
		FDouble all_amt = new FDouble(0);
		FDouble all_amt_pat = new FDouble(0);
		FDouble all_amt_std = new FDouble(0);
		FDouble all_amt_hp = new FDouble(0);
		FDouble sum_amt_acc = new FDouble(0); // 患者账户锁定金额合计变量清空
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

							new_quan = blCgItmOepDOs[j].getQuan().sub((id_cditmoep[t].getQuan_refund()));
						}
						if (blCgItmOepDOs[j].getQuan().toBigDecimal().compareTo(id_cditmoep[t].getQuan_refund().toBigDecimal()) == 0 && blCgItmOepDOs[j].getId_or() != null
								&& "~" != blCgItmOepDOs[j].getId_or()) { // 收费数量与退费数量相同

							if (!AllRefundAndAllCharge.booleanValue()) // 非全退全收
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
							SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = pcService.CalSingleSrvPriceByIdPripat_NameTip(new_BlCgItmOepDO.getId_srv(), new_BlCgItmOepDO.getName_srv(),
									new_BlCgItmOepDO.getId_pripat());
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
						new_BlCgItmOepDO.setAmt(new_BlCgItmOepDO.getAmt_std().multiply(new_BlCgItmOepDO.getRatio_pripat()).setScale(-2, BigDecimal.ROUND_HALF_UP));
					} else {
						// 物品不用设置价格比例
						new_BlCgItmOepDO.setAmt(new_BlCgItmOepDO.getAmt_std());
					}
					new_BlCgItmOepDO.setAmt_ratio(new_BlCgItmOepDO.getAmt());
					new_BlCgItmOepDO.setAmt_pat(new_BlCgItmOepDO.getAmt());
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
					new_BlCgItmOepDO.setFg_hp(FBoolean.FALSE);
					new_BlCgItmOepDO.setFg_susp(FBoolean.TRUE);
					new_BlCgItmOepDO.setId_par(blCgItmOepDOs[j].getId_cgitmoep());
					new_BlCgItmOepDO.setFg_refund(FBoolean.FALSE);
					new_BlCgItmOepDO.setNote("重收：" + blCgItmOepDOs[j].getId_cgitmoep());
					new_BlCgItmOepDO.setStatus(DOStatus.NEW);
					new_BlCgItmOepDOList.add(new_BlCgItmOepDO);
				}
			}
		}

		if (id_orsrv.size() > 0)// 更新医嘱记账信息
		{
			// 修改医嘱为退费状态
			Object obj2 = ServiceFinder.find(ICiOrdMaintainService.class);
			FBoolean updateCiOrder = ((ICiOrdMaintainService) obj2).UpdateOrdChargeRelInfo2(id_orsrv.toArray(new String[] {}), ICiDictCodeConst.SD_SU_BL_REFOUND_ID, ICiDictCodeConst.SD_SU_BL_REFOUND,
					strDateTime, FeeReverseType.BLSTREVERSE);
			if (!updateCiOrder.booleanValue()) {
				throw new BizException("更新医嘱项目记账状态失败！");
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
			BlCgItmOepMapDTO blCgItmOepMapDTO = blCgItmOepMapIns.BlCgItmOepConvertToMapIncPripats(new_BlCgItmOepDOList.toArray(new BlCgItmOepDO[] {}), operatorInfoDTO.getId_emp(),
					IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE, code_pkg);
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

	/**
	 * 单独红冲退分摊(原分摊的直接红冲）
	 * 
	 * @param id_stoep
	 *            结算ID
	 * @throws BizException
	 */
	public void RedBackBlCg_blproparoepAggDO(String id_stoep) throws BizException {
		// 查找原应收信息
		BlproparoepAggDO[] propArOepAggDoArr = AssemblyRedPropArOepAggDoOnlybyRefundAllBackBillOnHis(id_stoep, null);
		RedBackPropData(id_stoep, propArOepAggDoArr);
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
	 * @return
	 * @throws BizException
	 */
	public BlCgoepAggAndPrintRedIncItmDTO redBackBill_withoutProp(String id_stoep, String[] id_cgoep, BlRefundItmDTO[] id_cditmoep, OperatorInfoDTO operatorInfoDTO, FBoolean PrintOnlyOneInvoice,
			FBoolean AllRefundAndAllCharge, FBoolean AllRefund, FDateTime strDateTime, FBoolean printRedInc, BlpaypatoepAggDO red_BlpaypatoepAggDO1) throws BizException {
		// 1. 查找原结算信息
		IBlstoepRService iBlstoepRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO[] blStOepDOs0 = iBlstoepRService.find(" a0.id_stoep='" + id_stoep + "'", "", FBoolean.TRUE);
		if (null == blStOepDOs0 || blStOepDOs0.length == 0) {
			throw new BizException("查询原门诊结算信息失败");
		}
		if (printRedInc == null)// 门诊的退费，不会从前台传来是否打印红冲票。只有退号才从前台传来是否打印红冲票
		{
			// 取医保计划如果医保要求打印红冲票据（BD_HP.FG_SABINC =
			// TRUE）并且红冲票据需要由HIS打印(BD_HP.EU_SABINCPRN = 0)，
			printRedInc = getFPrintRedInc(blStOepDOs0[0].getId_ent());
		}
		return redBackBill_withoutProp_bp(blStOepDOs0, id_cgoep, id_cditmoep, operatorInfoDTO, PrintOnlyOneInvoice, AllRefundAndAllCharge, AllRefund, strDateTime, printRedInc, red_BlpaypatoepAggDO1);
	}

	/**
	 * 医保红冲
	 * 
	 * @param id_stoep
	 *            退费的结算ID
	 * @param id_cgoep
	 *            退费的记账主键
	 * @param BlRefundItmDTO
	 *            :id_cgoep,id_cditmoep,退费数量
	 * @param id_hp
	 *            :结算对应的医保主计划
	 * @param operatorInfoDTO
	 * @param PrintOnlyOneInvoice
	 *            ：多次就诊一次结算打印一张发票还是多张发票
	 * @throws BizException
	 */
	public BlCgoepAggAndPrintRedIncItmDTO redBackBill_insur(BlPropOepDO[] blPropOepDOArr, BlproparoepAggDO[] blproparoepAggDOArr, String id_stoep, String[] id_cgoep, BlRefundItmDTO[] id_cditmoep,
			OperatorInfoDTO operatorInfoDTO, FBoolean PrintOnlyOneInvoice, FBoolean AllRefundAndAllCharge, BlpaypatoepAggDO blpaypatoepAggDO, FBoolean AllRefund, FDateTime strDateTime,
			FBoolean printRedInc) throws BizException {
		BlCgoepAggAndPrintRedIncItmDTO blCgoepAggAndPrintRedIncItmDTO = redBackBill_withoutProp(id_stoep, id_cgoep, id_cditmoep, operatorInfoDTO, PrintOnlyOneInvoice, AllRefundAndAllCharge,
				AllRefund, strDateTime, printRedInc, blpaypatoepAggDO);
		// BlcgoepAggDO[]
		// blcgoepAggDOArr=(BlcgoepAggDO[])blCgoepAggAndPrintRedIncItmDTO.getBlCgoepAggDO().toArray();
		// 获取红冲ST的id_stoep
		DAFacade dafacade = new DAFacade();
		List<BlStOepDO> blStOepDOList = (List<BlStOepDO>) dafacade.findByCond(BlStOepDO.class, " id_par='" + id_stoep + "'");
		if (ListUtil.isEmpty(blStOepDOList) || blStOepDOList.size() == 0) {
			throw new BizException("查询患者结算信息失败");
		}
		String id_stoep_new = blStOepDOList.toArray(new BlStOepDO[0])[0].getId_stoep();
		for (BlPropOepDO blPropOepDO : blPropOepDOArr) {
			blPropOepDO.setId_stoep(id_stoep_new);
		}
		IBLPropMaintainService iBLPropMaintainService = ServiceFinder.find(IBLPropMaintainService.class);
		iBLPropMaintainService.saveOepProp(blPropOepDOArr, blproparoepAggDOArr);

		return blCgoepAggAndPrintRedIncItmDTO;
	}

	/**
	 * 红冲分摊信息
	 * 
	 * @param strIdStoep
	 *            红冲结算主键
	 * @param propArOepAggDoArr
	 *            应收数据
	 * @throws BizException
	 */
	private void RedBackPropData(String strIdStoep, BlproparoepAggDO[] propArOepAggDoArr) throws BizException {
		// 查询红冲生成的结算主键
		IBlstoepRService iBlstoepRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO[] blStOepDOs = iBlstoepRService.find(" id_par='" + strIdStoep + "'", "", FBoolean.FALSE);
		// 如果是医保退费，需要红冲掉分摊数据
		IBlpropoepCudService propOepCudSer = ServiceFinder.find(IBlpropoepCudService.class);
		// 组装分摊do数据
		BlPropOepDO propOepDo = new BlPropOepDO();
		propOepDo.setId_grp(Context.get().getGroupId());
		propOepDo.setId_org(Context.get().getOrgId());
		propOepDo.setDt_prop(AppUtils.getServerDateTime());
		// 判断有效标志
		propOepDo.setFg_active(FBoolean.TRUE);
		propOepDo.setEu_direct(-1);
		propOepDo.setId_stoep(blStOepDOs[0].getId_stoep());
		propOepDo.setStatus(DOStatus.NEW);

		// 判断是否有分摊
		BlPropOepDO[] propOepDoResultArr = propOepCudSer.save(new BlPropOepDO[] { propOepDo });

		// 组装应收数据
		ParamValidator.validateNotNull("RedBackPropData函数BlproparoepAggDO[]异常", propArOepAggDoArr);
		// 获取应收主表
		BlPropArOepDO propAroepDo = propArOepAggDoArr[0].getParentDO();
		propAroepDo.setId_propoep(propOepDoResultArr[0].getId_propoep());
		propAroepDo.setStatus(DOStatus.UPDATED);
		// 保存红冲应收数据
		IBlproparoepCudService propArOepCudSer = ServiceFinder.find(IBlproparoepCudService.class);
		propArOepCudSer.save(propArOepAggDoArr);
	}

	/**
	 * 组装医保应收数据，这个函数主要是提供给RefundAllBackBillOnHis用，其他地方不可能遇到
	 * 
	 * @param strIdStoep
	 *            原结算信息
	 * @param strCodeHp
	 *            医保交易流水号，退费分解产生的
	 * @return
	 * @throws BizException
	 */
	private BlproparoepAggDO[] AssemblyRedPropArOepAggDoOnlybyRefundAllBackBillOnHis(String strIdStoep, String strCodeHp) throws BizException {
		// 验证数据合法性
		ParamValidator.validateNotNull("AssemblyRedPropArOepAggDo", strIdStoep, strIdStoep);
		IBlpropoepRService iBlpropoepRService = ServiceFinder.find(IBlpropoepRService.class);
		BlPropOepDO[] oPropOepDOs = iBlpropoepRService.find(BlPropOepDODesc.TABLE_ALIAS_NAME + ".id_stoep='" + strIdStoep + "'", "", FBoolean.FALSE);
		if (oPropOepDOs == null || oPropOepDOs.length == 0) {
			throw new BizException("没有查到对应的分摊");
		}
		IBlproparoepRService rService = ServiceFinder.find(IBlproparoepRService.class);

		String strWhere = BlPropArOepDODesc.TABLE_ALIAS_NAME + ".ID_PROPOEP='" + oPropOepDOs[0].getId_propoep() + "'";
		BlproparoepAggDO[] propArOepAggDoArr = rService.find(strWhere, "", FBoolean.FALSE);
		// 红冲数据
		BlproparoepAggDO propArOepAggdoRedBack = new BlproparoepAggDO();

		BlPropArOepDO propArOepDoRedBack = (BlPropArOepDO) propArOepAggDoArr[0].getParentDO().clone();
		propArOepDoRedBack.setId_proparoep(null);
		propArOepDoRedBack.setId_propoep(null);
		propArOepDoRedBack.setEu_direct(BookRtnDirectEnum.REFUND);
		propArOepDoRedBack.setCode_hp(strCodeHp);
		propArOepDoRedBack.setStatus(DOStatus.NEW);
		propArOepAggdoRedBack.setParentDO(propArOepDoRedBack);

		List<BlPropArItmOepDO> lst = new ArrayList<BlPropArItmOepDO>();
		BlPropArItmOepDO[] itmOepDoArr = propArOepAggDoArr[0].getBlPropArItmOepDO();
		for (BlPropArItmOepDO itmOepDo : itmOepDoArr) {
			BlPropArItmOepDO propAritmOepDo = (BlPropArItmOepDO) itmOepDo.clone();
			propAritmOepDo.setId_proparitmoep(null);
			propAritmOepDo.setId_proparoep(null);
			propAritmOepDo.setStatus(DOStatus.NEW);
			lst.add(propAritmOepDo);
		}
		propArOepAggdoRedBack.setChildrenDO(lst.toArray(new BlPropArItmOepDO[0]));

		IBlproparoepCudService cudService = ServiceFinder.find(IBlproparoepCudService.class);
		BlproparoepAggDO[] result = cudService.save(new BlproparoepAggDO[] { propArOepAggdoRedBack });
		return result;
	}

	/**
	 * 门诊退费操作
	 * 
	 * @param strIdStOep
	 * @param refundItemDtos
	 * @param blpaypatoepAggDO
	 * @return
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] refundBill(String strIdStOep, BlRefundItmDTO[] refundItemDtos, BlpaypatoepAggDO blpaypatoepAggDO) throws BizException {
		RefundBackBizBp refundBackBp = new RefundBackBizBp();
		return null;
	}

	/**
	 * 保存界面传来的退款支付方式
	 * 
	 * @param red_BlpaypatoepAggDO1
	 * @return
	 * @throws BizException
	 */
	private BlpaypatoepAggDO[] saveRefundPay(BlpaypatoepAggDO red_BlpaypatoepAggDO1) throws BizException {
		if (red_BlpaypatoepAggDO1.getParentDO().getEu_direct() == BookRtnDirectEnum.CHARGES) {
			throw new BizException("退款支付方式方向设置有误");
		}
		IBlpaypatoepCudService iBlpaypatoepCudService = ServiceFinder.find(IBlpaypatoepCudService.class);
		BlpaypatoepAggDO[] new_blpaypatoepAggDO_arr = iBlpaypatoepCudService.save(new BlpaypatoepAggDO[] { red_BlpaypatoepAggDO1 });
		if (null == new_blpaypatoepAggDO_arr) {
			throw new BizException("保存患者退款收付款信息失败");
		}
		return new_blpaypatoepAggDO_arr;
	}

	/**
	 * 不包含医保红冲
	 * 
	 * @param BlpaypatoepAggDO
	 *            前台传入的收付款,前台传入的收付款不考虑方向，都是正的，需要再后台处理
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
	 *            是否打印红冲票
	 * @param BlpaypatoepAggDO
	 *            如果是全退，需要传入界面的退款方式。如果是全退，但是走完全红冲，则传入null。如果非全退，也传入null
	 * @throws BizException
	 */
	// @Override
	private BlCgoepAggAndPrintRedIncItmDTO redBackBill_withoutProp_bp(BlStOepDO[] orgin_blStOepDOs0, String[] id_cgoep, BlRefundItmDTO[] id_cditmoep, OperatorInfoDTO operatorInfoDTO,
			FBoolean PrintOnlyOneInvoice, FBoolean AllRefundAndAllCharge, FBoolean AllRefund, FDateTime strDateTime, FBoolean printRedInc, BlpaypatoepAggDO red_BlpaypatoepAggDO1) throws BizException {
		// 提取指定的结算信息，记账信息，发票信息

		RedBackBP redBackBP_ins = new RedBackBP();
		BlpaypatoepAggDO[] red_BlpaypatoepAggDO = null;
		// 1. 红冲收付款，并得到保存后的红冲收付款(采用统一解决方案）
		if (!AllRefund.booleanValue() || red_BlpaypatoepAggDO1 == null) {
			red_BlpaypatoepAggDO = redBackBP_ins.redBack_BlpaypatoepAgg(orgin_blStOepDOs0[0].getId_paypatoep(), strDateTime, operatorInfoDTO);
			// redBackBP_ins.savePrepayAndBlPrepayPatPmamtOepDO(red_BlpaypatoepAggDO,orgin_blStOepDOs0[0].getId_paypatoep());
		} else {
			red_BlpaypatoepAggDO = saveRefundPay(red_BlpaypatoepAggDO1);
		}
		redBackBP_ins.savePrepayAndBlPrepayPatPmamtOepDO(red_BlpaypatoepAggDO, orgin_blStOepDOs0[0].getId_paypatoep());
		// 2.红冲门诊结算表，且修改原结算表
		String eu_sttp = "";
		if (id_cditmoep[0].getEu_srctp() != null && id_cditmoep[0].getEu_srctp().intValue() == 1) {
			eu_sttp = StTypeEnum.ST_REGISTER_RED; // 门诊挂号取消结算
		} else {
			eu_sttp = StTypeEnum.ST_OEP_MIDWAY; // 门诊冲账
		}
		BlStOepDO red_BlStOepDO = RedBackBlStOep_And_RepairOrginOrginBlStOep(orgin_blStOepDOs0[0], operatorInfoDTO, red_BlpaypatoepAggDO[0].getParentDO().getId_paypatoep(), strDateTime, eu_sttp);

		// 3.红冲门诊记账表，且修改原记账表
		IBlcgoepRService iBlcgoepRService = ServiceFinder.find(IBlcgoepRService.class);
		BlcgoepAggDO[] orgin_blcgoepAggDO1 = iBlcgoepRService.findByIds(id_cgoep, FBoolean.TRUE);
		if (null == orgin_blcgoepAggDO1 || orgin_blcgoepAggDO1.length == 0) {
			throw new BizException("查询原门诊记账信息失败");
		}
		FBoolean repireCiSdSuBl = FBoolean.FALSE; // 原样红冲数据时，是否需要修改医嘱记账状态
		if (!AllRefundAndAllCharge.booleanValue() && AllRefund.booleanValue()) // (不是重划重收，但是全退)，那么只存在红冲的数据，因此需要修改医嘱医嘱状态
		{
			repireCiSdSuBl = FBoolean.TRUE;
		}
		BlcgoepAggDO[] red_BlcgoepAggDOs = RedBackBlCg_And_RepairOrginOrginBlCg(orgin_blcgoepAggDO1, strDateTime, operatorInfoDTO, repireCiSdSuBl, red_BlStOepDO.getId_stoep());

		// 4.红冲票据
		BlincoepAggDO[] blincoepAggDO_red = redback_BlIncOep(printRedInc, orgin_blStOepDOs0[0].getId_stoep(), red_BlStOepDO.getId_stoep(), PrintOnlyOneInvoice, AllRefundAndAllCharge, strDateTime,
				operatorInfoDTO, red_BlcgoepAggDOs);

		BlcgoepAggDO[] new_Recharge_BlcgoepAggDOs = null;
		if (AllRefundAndAllCharge.booleanValue() || !AllRefund.booleanValue()) // 是重划重收调用或者退费重收，还需要获得重收的记账Agg
		{
			new_Recharge_BlcgoepAggDOs = getNewRechargeBlCg(orgin_blcgoepAggDO1, id_cditmoep, strDateTime, operatorInfoDTO, PrintOnlyOneInvoice, AllRefundAndAllCharge, red_BlStOepDO.getId_stoep());
		}

		// // ////////红冲结束

		// 5.发事件
		try {
			this.invokeOepSettlementEvent(red_BlcgoepAggDOs, red_BlpaypatoepAggDO[0], red_BlStOepDO, blincoepAggDO_red[0]);
		} catch (Exception ex) {
		}

		// 6. 如果全退(非重退重收)，则修改红冲收付款明细的实收（退）付款段标志，且返回null
		if (AllRefund.booleanValue()) {

			BlpaypatoepAggDO blpaypatoepAggDOQt = new BlpaypatoepAggDO();
			BlpaypatoepAggDO[] blpaypatoepAggDOArr = null;

			IBlpaypatoepCudService iBlpaypatoepCudService = ServiceFinder.find(IBlpaypatoepCudService.class);

			Map<String, FDouble> pmAmt = new HashMap<String, FDouble>();
			FDouble temAmt = new FDouble(0);
			List<BlPayItmPatOepDO> qt_BlPayItmPatOepDOLst = new ArrayList<BlPayItmPatOepDO>();

			BlPayItmPatOepDO[] blPayItmPatOepDOArr = red_BlpaypatoepAggDO[0].getBlPayItmPatOepDO();
			for (BlPayItmPatOepDO blPayItmPatOepDO : blPayItmPatOepDOArr) {
				if (pmAmt.containsKey(blPayItmPatOepDO.getId_pm() + "|" + blPayItmPatOepDO.getSd_pm())) {
					temAmt = pmAmt.get(blPayItmPatOepDO.getId_pm() + "|" + blPayItmPatOepDO.getSd_pm()).add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
					pmAmt.remove(blPayItmPatOepDO.getId_pm() + "|" + blPayItmPatOepDO.getSd_pm());
					pmAmt.put(blPayItmPatOepDO.getId_pm() + "|" + blPayItmPatOepDO.getSd_pm(), temAmt);
				} else {
					pmAmt.put(blPayItmPatOepDO.getId_pm() + "|" + blPayItmPatOepDO.getSd_pm(), blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
				}
				blPayItmPatOepDO.setFg_realpay(FBoolean.TRUE);
				blPayItmPatOepDO.setStatus(DOStatus.UPDATED);
				// qt_BlPayItmPatOepDOLst.add(blPayItmPatOepDO);
			}
			red_BlpaypatoepAggDO[0].getParentDO().setStatus(DOStatus.UPDATED);
			blpaypatoepAggDOArr = iBlpaypatoepCudService.save(red_BlpaypatoepAggDO);

			/**
			 * 2017-4-10 不合并了 if (pmAmt.size() < blPayItmPatOepDOArr.length) //
			 * 汇总合并，主要解决多次退款的情况 { BlPayPatOepDO blPayPatOepDO =
			 * red_BlpaypatoepAggDO[0].getParentDO(); // 原始的收费明细需要删除
			 * qt_BlPayItmPatOepDOLst = new ArrayList<BlPayItmPatOepDO>(); for
			 * (BlPayItmPatOepDO blPayItmPatOepDO : blPayItmPatOepDOArr) {
			 * blPayItmPatOepDO.setStatus(DOStatus.DELETED); }
			 * red_BlpaypatoepAggDO
			 * [0].getParentDO().setStatus(DOStatus.DELETED);
			 * blpaypatoepAggDOArr =
			 * iBlpaypatoepCudService.save(red_BlpaypatoepAggDO);
			 * 
			 * // 合并 Iterator entrys = pmAmt.entrySet().iterator(); int i = 0, j
			 * = 0; while (entrys.hasNext()) { Map.Entry entry = (Map.Entry)
			 * entrys.next(); String key1 = (String) entry.getKey(); if
			 * (((FDouble) entry.getValue()).compareTo(new FDouble(0)) == 0) {
			 * continue; // 为0不必保存 } // BlPropArOepDO blPropArOepDOt =
			 * (BlPropArOepDO) // entry.getValue(); BlPayItmPatOepDO
			 * blPayItmPatOepDO = new BlPayItmPatOepDO(); blPayItmPatOepDO =
			 * red_BlpaypatoepAggDO[0].getBlPayItmPatOepDO()[0];
			 * blPayItmPatOepDO.setId_paypatoep(null);
			 * blPayItmPatOepDO.setId_payitmpatoep(null);
			 * blPayItmPatOepDO.setId_pm(key1.substring(0, key1.indexOf('|')));
			 * blPayItmPatOepDO.setSd_pm(key1.substring(key1.indexOf('|') + 1));
			 * blPayItmPatOepDO.setAmt(((FDouble) entry.getValue()).abs()); if
			 * (((FDouble) entry.getValue()).compareTo(new FDouble(0)) < 0) {
			 * blPayItmPatOepDO.setEu_direct(BookRtnDirectEnum.REFUND); } else {
			 * blPayItmPatOepDO.setEu_direct(BookRtnDirectEnum.CHARGES); }
			 * blPayItmPatOepDO.setStatus(DOStatus.NEW);
			 * blPayItmPatOepDO.setFg_realpay(FBoolean.TRUE);
			 * qt_BlPayItmPatOepDOLst.add(blPayItmPatOepDO); } // 保存合并后的新明细
			 * blPayPatOepDO.setStatus(DOStatus.NEW);
			 * red_BlpaypatoepAggDO[0].setParentDO(blPayPatOepDO); //
			 * red_BlpaypatoepAggDO[0].getParentDO().setStatus(DOStatus.NEW);
			 * red_BlpaypatoepAggDO
			 * [0].setBlPayItmPatOepDO(qt_BlPayItmPatOepDOLst.toArray(new
			 * BlPayItmPatOepDO[0])); blpaypatoepAggDOArr =
			 * iBlpaypatoepCudService.save(red_BlpaypatoepAggDO); }
			 */

			// if(qt_BlPayItmPatOepDOLst!=null &&
			// qt_BlPayItmPatOepDOLst.size()>0)
			// {
			// blpaypatoepAggDOQt.setParentDO(red_BlpaypatoepAggDO[0].getParentDO());
			// blpaypatoepAggDOQt.setBlPayItmPatOepDO(
			// qt_BlPayItmPatOepDOLst.toArray(new BlPayItmPatOepDO[0]));
			// blpaypatoepAggDO=blpaypatoepAggDOQt;
			// blpaypatoepAggDOArr=iBlpaypatoepCudService.save(new
			// BlpaypatoepAggDO[]{blpaypatoepAggDO});
			// iBlpaypatoepCudService.delete(red_BlpaypatoepAggDO);//删除之前整体红冲的收付款
			// }
			// else
			// {
			// red_BlpaypatoepAggDO[0].getParentDO().setStatus(DOStatus.UPDATED);
			// blpaypatoepAggDOQt.setParentDO(red_BlpaypatoepAggDO[0].getParentDO());
			// blpaypatoepAggDOQt.setBlPayItmPatOepDO(blPayItmPatOepDOArr);
			// blpaypatoepAggDO=blpaypatoepAggDOQt;
			// blpaypatoepAggDOArr=iBlpaypatoepCudService.save(new
			// BlpaypatoepAggDO[]{blpaypatoepAggDO});
			// }

			// 重写红冲结算对应的收付款ID
			red_BlStOepDO.setId_paypatoep(blpaypatoepAggDOArr[0].getParentDO().getId_paypatoep());
			red_BlStOepDO.setStatus(DOStatus.UPDATED);
			IBlstoepCudService iBlstoepCudService = ServiceFinder.find(IBlstoepCudService.class);
			BlStOepDO[] r_blStOepDOs2 = iBlstoepCudService.save(new BlStOepDO[] { red_BlStOepDO });
			if (null == r_blStOepDOs2 || r_blStOepDOs2.length == 0) {
				throw new BizException("保存红冲门诊结算信息失败");
			}
			// 保存前台来的数据

			return null;
		}
		BlCgoepAggAndPrintRedIncItmDTO blCgoepAggAndPrintRedIncItmDTO = new BlCgoepAggAndPrintRedIncItmDTO();
		FArrayList blcgoepAggDOLst = new FArrayList();
		FArrayList blIncItmVsTypeDTOLst = new FArrayList();
		for (BlcgoepAggDO blcgoepAggDO : new_Recharge_BlcgoepAggDOs) {
			blcgoepAggDOLst.add(blcgoepAggDO);
		}
		// 打红冲的发票(门诊挂号冲账结算的红冲票不再此处打印，在门诊收费里打印）
		if (printRedInc.booleanValue() && red_BlStOepDO.getEu_sttp() != StTypeEnum.ST_REGISTER_RED) {
			BLCiOrderToBlCgServiceImplBp BLCiOrderToBlCgServiceImplBp = new BLCiOrderToBlCgServiceImplBp();
			BlIncItmVsTypeDTO[] BlIncItmVsTypeDTOs = BLCiOrderToBlCgServiceImplBp.assemblyIncInfoDtosWithoutWindow(red_BlStOepDO, blincoepAggDO_red);
			for (BlIncItmVsTypeDTO blIncItmVsTypeDTO : BlIncItmVsTypeDTOs) {
				blIncItmVsTypeDTOLst.add(blIncItmVsTypeDTO);
			}
		}
		blCgoepAggAndPrintRedIncItmDTO.setBlCgoepAggDO(blcgoepAggDOLst);
		blCgoepAggAndPrintRedIncItmDTO.setBlIncItmVsTypeDTO(blIncItmVsTypeDTOLst);
		return blCgoepAggAndPrintRedIncItmDTO;
	}

	/**
	 * 处理物品预留问题
	 * 
	 * @param refundItemDtoArr
	 *            退费明细
	 * 
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public void RelieveMMReserved(BlRefundItmDTO[] refundItemDtoArr, FBoolean AllRefundAndAllCharge) throws BizException {

		boolean RefundFg_mm = false; // 物品退费
		// 需要的工作：调用物品，退物品
		// 退物品有两种情况：1.药品已发，且药品处已做退费。2.药品本来就未发放
		List<OpDgRtnAmountDTO> opDgRtnAmountDTO_list = new ArrayList<OpDgRtnAmountDTO>();

		List<String> id_orsrvLst_provide = new ArrayList<String>(); // 药品已发
		List<String> id_orsrvLst_notProvide = new ArrayList<String>(); // 药品未发
		List<ReserveReqDTO> reserveReqDTOLst = new ArrayList<ReserveReqDTO>();
		
		Set<String> orsrvIdSet = new HashSet<String>();
		for (BlRefundItmDTO rfdItmDto : refundItemDtoArr) {
			if(!StringUtil.isEmpty(rfdItmDto.getId_orsrv())){
				orsrvIdSet.add(rfdItmDto.getId_orsrv());
			}
		}
		
		Map<String, OrdSrvDO> orsrvMap = new HashMap<String, OrdSrvDO>();
		if(orsrvIdSet.size() > 0){
			
			DAFacade daf = new DAFacade();
			List<OrdSrvDO> orsrvList = (List<OrdSrvDO>)daf.findByPKs(OrdSrvDO.class, orsrvIdSet.toArray(new String[0]));
			if(!ListUtil.isEmpty(orsrvList)){
				orsrvMap = (Map<String, OrdSrvDO>)MapUtils.convertListToMap(orsrvList, OrdSrvDO.ID_ORSRV);
			}
		}
		
		for (int i = 0; i < refundItemDtoArr.length; i++) {
			// 物品已发放
			if (refundItemDtoArr[i].getQuan_refund().compareTo(new FDouble(0)) > 0) {
				
				OrdSrvDO orsrvDO = orsrvMap.get(refundItemDtoArr[i].getId_orsrv());
				if(orsrvDO != null && FBoolean.FALSE.equals(orsrvDO.getFg_or()))
					continue;
				
				if (refundItemDtoArr[i].getFg_mm() != null && refundItemDtoArr[i].getFg_mm().booleanValue()) {
					RefundFg_mm = true;
					OpDgRtnAmountDTO opDgRtnAmountDTO = new OpDgRtnAmountDTO();
					opDgRtnAmountDTO.setId_orsrv(refundItemDtoArr[i].getId_orsrv());
					opDgRtnAmountDTO.setFg_get(refundItemDtoArr[i].getFg_drug_provide()); // 药品是否发放
					opDgRtnAmountDTO.setRtn_amount(refundItemDtoArr[i].getQuan_refund());
					opDgRtnAmountDTO_list.add(opDgRtnAmountDTO);

					if (refundItemDtoArr[i].getFg_drug_provide().booleanValue()) {
						id_orsrvLst_provide.add(refundItemDtoArr[i].getId_orsrv());
					} else if (!refundItemDtoArr[i].getFg_drug_provide().booleanValue()) {
						// 药品未发放
						id_orsrvLst_notProvide.add(refundItemDtoArr[i].getId_orsrv());

						//OrdSrvDO orsrvDO = orsrvMap.get(refundItemDtoArr[i].getId_orsrv());
						if(orsrvDO == null || FBoolean.TRUE.equals(orsrvDO.getFg_or())){
							ReserveReqDTO mlDTO = new ReserveReqDTO();
							mlDTO.setId_mm(refundItemDtoArr[i].getId_mm());
							mlDTO.setId_dep(refundItemDtoArr[i].getId_dep_wh());
							mlDTO.setReq_num(refundItemDtoArr[i].getQuan_refund());
							mlDTO.setReq_unit_id(refundItemDtoArr[i].getReq_unit_id());
							mlDTO.setId_orsrv(refundItemDtoArr[i].getId_orsrv());
							reserveReqDTOLst.add(mlDTO);
						}
					}
				}
			}
		}
		if (!AllRefundAndAllCharge.booleanValue()) // 重划重收不处理物品
		{
			if (RefundFg_mm) // 物品退费
			{
				if (id_orsrvLst_provide != null && id_orsrvLst_provide.size() > 0) // 已发放
				{
					// 调用门急诊药品退费后回写发放明细数据
					IMpDgOutService iMpDgOutService = ServiceFinder.find(IMpDgOutService.class);
					iMpDgOutService.writebackDispItmAfterRefundCharge(id_orsrvLst_provide.toArray(new String[0]));
				} else if (id_orsrvLst_notProvide != null && id_orsrvLst_notProvide.size() > 0) // 已预留，未发放
				{
					// 释放窗口队列
					IMpDgOutService iMpDgOutService = ServiceFinder.find(IMpDgOutService.class);
					iMpDgOutService.releaseQueueAfterRefundCharge(id_orsrvLst_notProvide.toArray(new String[0]));
					//try {
						if(!ListUtil.isEmpty(reserveReqDTOLst)){
							// 退预留
							IMaterialStockService mlService = ServiceFinder.find(IMaterialStockService.class);
							mlService.reserveMaterials(IMaterialStockService.TYPE_RETURN, reserveReqDTOLst.toArray(new ReserveReqDTO[] {}));
						
						}
					//} catch (Exception e) {
					//	throw new BizException("退预留异常："+e.getMessage());
					//}
				}
			}
		}
	}

	public BlpaypatoepAggDO[] get_BlpaypatoepAggDO_reCharge(String orgin_idstoep, BlpaypatoepAggDO blpaypatoepAggDO, OperatorInfoDTO operatorInfoDTO, FBoolean AllRefundAndAllCharge,
			FDateTime strDateTime) throws BizException {
		// TimeService timeService = new TimeServiceImpl();
		// FDateTime strDateTime = timeService.getUFDateTime();
		//
		// 1. 重收的收付款记录
		BlpaypatoepAggDO[] reCharge_blpaypatoepAggDO = null;
		RedBackBP redBackBP_ins = new RedBackBP();
		reCharge_blpaypatoepAggDO = redBackBP_ins.reCharge_BlpaypatoepAgg(redBackBP_ins.getBlpaypatoepAggDOById_stoep(orgin_idstoep), blpaypatoepAggDO, operatorInfoDTO, strDateTime,
				AllRefundAndAllCharge);
		return reCharge_blpaypatoepAggDO;
	}

	/**
	 * 生成重收的ST
	 * 
	 * @param blCgItmOepMapDTO11
	 * @param id_pat
	 * @param id_ent
	 * @param id_enttp
	 * @param code_enttp
	 * @param orgin_idstoep
	 * @param PrintOnlyOneInvoice
	 * @param operatorInfoDTO
	 * @return
	 * @throws BizException
	 */
	public BlStOepDO[] get_NewBlStOepsFromReSettlement(BlCgItmOepMapDTO blCgItmOepMapDTO11, BlcgoepAggDO[] reCharge_blcgoepAggDO_arr, String orgin_idstoep, String id_paypatoep, FDateTime fDateTime,
			OperatorInfoDTO operatorInfoDTO) throws BizException {
		FArrayList2 blStOepDOLst = new FArrayList2();
		BlStOepDO blStOepDo = new BlStOepDO();
		String id_pat = reCharge_blcgoepAggDO_arr[0].getParentDO().getId_pat();
		Map<String, FDouble> blCgItmOepAmtStdMap = blCgItmOepMapDTO11.getBlCgItmOepAmtStdMap();// Map<就诊,标准金额>
		Map<String, FDouble> blCgItmOepAmtPatMap = blCgItmOepMapDTO11.getBlCgItmOepAmtPatMap();// Map<就诊,医保自付金额>
		Map<String, FDouble> blCgItmOepAmtRatioMap = blCgItmOepMapDTO11.getBlCgItmOepAmtRatioMap();// Map<就诊,金额_价格比例>
		Map<String, FDouble> blCgItmOepAmtHpMap = blCgItmOepMapDTO11.getBlCgItmOepAmtHpMap();// Map<就诊,医保支付金额>
		Map<String, FDouble> blCgItmOepAmtMap = blCgItmOepMapDTO11.getBlCgItmOepAmtMap();// Map<就诊,自付金额>

		// 给id_ent,id_enttp,code_enttp赋值，ST表需要存放
		List<String> id_entLst = new ArrayList<String>();
		List<String> id_enttpLst = new ArrayList<String>();
		String id_ent = "";
		String id_enttp = "";
		String code_enttp = "";
		for (BlcgoepAggDO blcgoepAggDO : reCharge_blcgoepAggDO_arr) {
			BlCgItmOepDO[] blCgItmOepDOArr = blcgoepAggDO.getBlCgItmOepDO();
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOArr) {
				if (!id_entLst.contains(blCgItmOepDO.getId_ent())) {
					id_entLst.add(blCgItmOepDO.getId_ent());
				}
				if (!id_enttpLst.contains(blCgItmOepDO.getId_enttp())) {
					id_enttpLst.add(blCgItmOepDO.getId_enttp());
					code_enttp = blCgItmOepDO.getCode_enttp();
				}
			}
		}
		if (id_entLst != null && id_entLst.size() > 1) {
			id_ent = "";
		} else {
			id_ent = id_entLst.toArray(new String[] {})[0];
		}
		if (id_enttpLst != null && id_enttpLst.size() > 1) {
			id_enttp = "";
			code_enttp = "";
		} else {
			id_enttp = id_enttpLst.toArray(new String[] {})[0];
		}

		// 对关联首次结算赋值  2019/04/17 ly
		DAFacade daf = new DAFacade();
		BlStOepDO oldStDO = (BlStOepDO)daf.findByPK(BlStOepDO.class, orgin_idstoep);
		if(StringUtil.isEmpty(oldStDO.getId_rootst())){
			blStOepDo.setId_rootst(oldStDO.getId_stoep());
		}else{
			blStOepDo.setId_rootst(oldStDO.getId_rootst());
		}
		blStOepDo.setId_hp(oldStDO.getId_hp());
		blStOepDo.setId_patca(oldStDO.getId_patca());
		blStOepDo.setId_stoep(null);
		blStOepDo.setEu_direct((int) BookRtnDirectEnum.CHARGES);
		blStOepDo.setEu_sttp(StTypeEnum.ST_OEP_CHARGE);
		blStOepDo.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
		blStOepDo.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
		blStOepDo.setId_pat(id_pat);
		blStOepDo.setId_par(orgin_idstoep);// 关联的结算主键
		blStOepDo.setId_dep_st(operatorInfoDTO.getId_dep());
		blStOepDo.setId_emp_st(operatorInfoDTO.getId_emp());
		blStOepDo.setStatus(DOStatus.NEW);
		blStOepDo.setId_org(operatorInfoDTO.getId_org());
		blStOepDo.setId_grp(operatorInfoDTO.getId_grp());
		blStOepDo.setId_ent(id_ent);
		blStOepDo.setId_enttp(id_enttp);
		blStOepDo.setCode_enttp(code_enttp);
		blStOepDo.setAmt_std(blCgItmOepAmtStdMap.get(id_pat));// 结算标准总金额
		blStOepDo.setAmt_pat(blCgItmOepAmtPatMap.get(id_pat));// 自付金额
		blStOepDo.setAmt_ratio(blCgItmOepAmtRatioMap.get(id_pat));// 金额_价格比例
		blStOepDo.setAmt(blCgItmOepAmtMap.get(id_pat));// 自付金额
		blStOepDo.setAmt_hp(blCgItmOepAmtHpMap.get(id_pat));// 医保支付金额
		String stCode = BlCodeUtils.generateOepStCode();
		blStOepDo.setCode_st(stCode);
		// 回写患者收付款
		blStOepDo.setId_paypatoep(id_paypatoep);
		blStOepDo.setDt_st(fDateTime);
		blStOepDo.setFg_cc(FBoolean.FALSE);// 设置结账标志为FALSE
		blStOepDo.setStatus(DOStatus.NEW);
		
		
		

		Object obj1 = ServiceFinder.find(IBlstoepCudService.class);
		BlStOepDO[] blStOepDOs = ((IBlstoepCudService) obj1).save(new BlStOepDO[] { blStOepDo });
		if (null == blStOepDOs) {
			throw new BizException("保存门诊结算信息失败");
		}
		return blStOepDOs;
	}

	public BlincoepAggDO get_NewBlIncOepsFromReSettlement(BlcgoepAggDO[] reCharge_blcgoepAggDO_arr, BlCgItmOepMapDTO blCgItmOepMapDTO11, BlStOepDO blStOepDo, BlpaypatoepAggDO[] blpaypatoepAggDOs,
			String incno, String code_pkg, FDateTime fDateTime, OperatorInfoDTO operatorInfoDTO) throws BizException {
		FArrayList2 blincoepAggDOLst = new FArrayList2();
		Map<String, FDouble> blCgItmOepAmtStdMap = blCgItmOepMapDTO11.getBlCgItmOepAmtStdMap();// Map<就诊,标准金额>
		Map<String, FDouble> blCgItmOepAmtPatMap = blCgItmOepMapDTO11.getBlCgItmOepAmtPatMap();// Map<就诊,医保自付金额>
		Map<String, FDouble> blCgItmOepAmtRatioMap = blCgItmOepMapDTO11.getBlCgItmOepAmtRatioMap();// Map<就诊,金额_价格比例>
		Map<String, FDouble> blCgItmOepAmtHpMap = blCgItmOepMapDTO11.getBlCgItmOepAmtHpMap();// Map<就诊,医保支付金额>
		Map<String, FDouble> blCgItmOepAmtMap = blCgItmOepMapDTO11.getBlCgItmOepAmtMap();// Map<就诊,自付金额>
		BlincoepAggDO blincoepAggDO = new BlincoepAggDO();
		// 1.发票主表bl_inc_oep
		BlIncOepDO blIncOepDo = new BlIncOepDO();
		blIncOepDo.setId_stoep(blStOepDo.getId_stoep());
		blIncOepDo.setDt_inc(fDateTime);
		blIncOepDo.setFg_print(FBoolean.TRUE);
		blIncOepDo.setStatus(DOStatus.NEW);
		blIncOepDo.setId_pat(blStOepDo.getId_pat());
		blIncOepDo.setId_enttp(blStOepDo.getId_enttp());
		blIncOepDo.setIncno(incno);
		blIncOepDo.setTimes_prn(1);
		blIncOepDo.setId_emp_inc(operatorInfoDTO.getId_emp());
		blIncOepDo.setCode_enttp(blStOepDo.getCode_enttp());
		blIncOepDo.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
		blIncOepDo.setEu_direct((int) BookRtnDirectEnum.CHARGES);
		blIncOepDo.setCode_incpkg(code_pkg);
		blIncOepDo.setId_org(operatorInfoDTO.getId_org());
		blIncOepDo.setId_grp(operatorInfoDTO.getId_grp());
		blIncOepDo.setFg_cc_in(FBoolean.FALSE);
		blIncOepDo.setFg_cc_out(FBoolean.FALSE);
		blIncOepDo.setId_cc_in(null);
		blIncOepDo.setId_cc_out(null);
		blIncOepDo.setAmt(blCgItmOepAmtMap.get(blStOepDo.getId_pat()));
		blIncOepDo.setAmt_std(blCgItmOepAmtStdMap.get(blStOepDo.getId_pat()));
		blIncOepDo.setAmt_pat(blCgItmOepAmtPatMap.get(blStOepDo.getId_pat()));
		blIncOepDo.setAmt_hp(blCgItmOepAmtHpMap.get(blStOepDo.getId_pat()));
		blIncOepDo.setAmt_ratio(blCgItmOepAmtRatioMap.get(blStOepDo.getId_pat()));
		blIncOepDo.setStatus(DOStatus.NEW);
		blincoepAggDO.setParentDO(blIncOepDo);
		// 2.门急诊结算与发票关系bl_st_inc
		BlStIncOepDO blStIncOepDO = new BlStIncOepDO();
		blStIncOepDO.setId_stoep(blStOepDo.getId_stoep());
		blStIncOepDO.setId_incoep(null);
		blStIncOepDO.setFg_active(FBoolean.TRUE);
		blStIncOepDO.setStatus(DOStatus.NEW);
		blincoepAggDO.setBlStIncOepDO(new BlStIncOepDO[] { blStIncOepDO });

		Map<String, BlIncItmOepDO> blCgIncTypeBlIncItmOepDOMap = new HashMap<String, BlIncItmOepDO>();
		List<BlIncCgItmOep> blIncCgItmOeps = new ArrayList<BlIncCgItmOep>();
		String keyInvoiceType = "";
		FDouble amt_inctype = new FDouble(0);
		FDouble amt_pat_inctype = new FDouble(0);
		FDouble amt_std_inctype = new FDouble(0);
		FDouble amt_hp_inctype = new FDouble(0);
		FDouble amt_ratio_inctype = new FDouble(0);
		for (BlcgoepAggDO blcgoepAggDO : reCharge_blcgoepAggDO_arr) {
			BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDO.getBlCgItmOepDO();
			for (int j = 0; j < blCgItmOepDOs.length; j++) {
				BlIncCgItmOep blIncCgItmOep = new BlIncCgItmOep();
				blIncCgItmOep.setId_cgitmoep(blCgItmOepDOs[j].getId_cgitmoep());
				blIncCgItmOep.setId_incoep(null);
				blIncCgItmOep.setStatus(DOStatus.NEW);
				blIncCgItmOeps.add(blIncCgItmOep);

				keyInvoiceType = blCgItmOepDOs[j].getCode_inccaitm() + "," + blCgItmOepDOs[j].getName_inccaitm();
				if (blCgIncTypeBlIncItmOepDOMap.containsKey(keyInvoiceType)) {
					BlIncItmOepDO blIncItmOepDO = blCgIncTypeBlIncItmOepDOMap.get(keyInvoiceType);
					amt_inctype = blIncItmOepDO.getAmt().add(blCgItmOepDOs[j].getAmt());
					amt_pat_inctype = blIncItmOepDO.getAmt_pat().add(blCgItmOepDOs[j].getAmt_pat());
					amt_std_inctype = blIncItmOepDO.getAmt_std().add(blCgItmOepDOs[j].getAmt_std());
					amt_hp_inctype = blIncItmOepDO.getAmt_hp().add(blCgItmOepDOs[j].getAmt_hp());
					amt_ratio_inctype = blIncItmOepDO.getAmt_ratio().add(blCgItmOepDOs[j].getAmt_ratio());
					blIncItmOepDO.setCode(blCgItmOepDOs[j].getCode_inccaitm());
					blIncItmOepDO.setName(blCgItmOepDOs[j].getName_inccaitm());
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
					blIncItmOepDO.setCode(blCgItmOepDOs[j].getCode_inccaitm());
					blIncItmOepDO.setName(blCgItmOepDOs[j].getName_inccaitm());
					blIncItmOepDO.setAmt_std(blCgItmOepDOs[j].getAmt_std());
					blIncItmOepDO.setAmt_pat(blCgItmOepDOs[j].getAmt_pat());
					blIncItmOepDO.setAmt_hp(blCgItmOepDOs[j].getAmt_hp());
					blIncItmOepDO.setAmt_ratio(blCgItmOepDOs[j].getAmt_ratio());
					blIncItmOepDO.setAmt(blCgItmOepDOs[j].getAmt());
					blIncItmOepDO.setAmt_free(new FDouble(0));
					blIncItmOepDO.setStatus(DOStatus.NEW);
					blCgIncTypeBlIncItmOepDOMap.put(keyInvoiceType, blIncItmOepDO);
				}
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
		blincoepAggDO.setBlIncItmOepDO(blIncItmOepDOLst.toArray(new BlIncItmOepDO[] {}));
		blincoepAggDO.setBlIncCgItmOep(blIncCgItmOeps.toArray(new BlIncCgItmOep[] {}));

		// 处理减免的业务逻辑
		DoOepFgFree doOepFgFree = new DoOepFgFree();
		int Eu_freemd = 0;
		BlincoepAggDO blincoepAggDOs = doOepFgFree.DoOep_FgFree_new(reCharge_blcgoepAggDO_arr, blpaypatoepAggDOs[0], blincoepAggDO, DOStatus.NEW);

		// blincoepAggDOLst.add(blincoepAggDO);
		return blincoepAggDOs;
	}

	/**
	 * 从（就诊，发票号|就诊，发票号|……|就诊，发票号 ）格式中解析出发票号
	 * 
	 * @param ent_invoiceno
	 *            格式：就诊，发票号|就诊，发票号|……|就诊，发票号
	 * @return 发票号
	 */
	public String getIncnoFromEnt_invoiceno(String ent_invoiceno) {

		String incno = "";
		String[] arrEnts = ent_invoiceno.split("\\|");// 就诊，发票号|就诊，发票号|……|就诊，发票号
		// 采用一次结算一张发票后，只有一张发票了
		incno = arrEnts[0].split(",")[1];
		return incno;
	}

	// /**
	// *
	// 根据重收的明细，生成重收的结算信息bl_st_oep和发票信息bl_inc_oep,bl_inc_cg_itm_oep,bl_inc_itm_oep
	// * @param reCharge_blcgoepAggDO_arr 重收明细
	// * @param orgin_idstoep 原始结算ID（退费前的）
	// * @param PrintOnlyOneInvoice 多次就诊，是否打印一次结算信息
	// * @param opertorInfoDTO 操作员信息
	// * @return 重收对应的结算信息
	// * @throws BizException
	// */
	// public Bl_reSettlement_ST_INC_DTO
	// get_NewblStOepDosAndIncFromReSettlement(BlcgoepAggDO[]
	// reCharge_blcgoepAggDO_arr,String orgin_idstoep,OperatorInfoDTO
	// operatorInfoDTO) throws BizException
	// {
	// if(reCharge_blcgoepAggDO_arr==null)
	// {
	// return null;
	// }
	// Bl_reSettlement_ST_INC_DTO bl_reSettlement_ST_INC_DTO=new
	// Bl_reSettlement_ST_INC_DTO();
	// FArrayList2 blStOepDOLst=new FArrayList2();
	// FArrayList2 blincoepAggDOLst=new FArrayList2();
	//
	//
	// String keyInvoice="";
	// IBlincQryService
	// iBlincQryService=ServiceFinder.find(IBlincQryService.class);
	// String
	// code_pkg=iBlincQryService.getCodeIncPkgByIdempiss(operatorInfoDTO.getId_org(),
	// operatorInfoDTO.getId_emp(), IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
	//
	// //计算费用：
	// //获取记账中具体项目和主键的MAP
	// GetBlCgItmOepMap blCgItmOepMapIns=new GetBlCgItmOepMap();
	// BlCgItmOepMapDTO
	// blCgItmOepMapDTO11=blCgItmOepMapIns.BlCgItmOepConvertToMaps(reCharge_blcgoepAggDO_arr,operatorInfoDTO.getId_emp(),IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE,FBoolean.TRUE);
	//
	//
	//
	// //2.生成重新结算的ST
	// blStOepDOLst=get_NewBlStOepsFromReSettlement(blCgItmOepMapDTO11,
	// reCharge_blcgoepAggDO_arr, orgin_idstoep,operatorInfoDTO);
	//
	// //3.生成重新结算的INC(只包含bl_inc_oep,bl_inc_cg_itm_oep,bl_inc_itm_oep)
	// // 获得发票号
	// String
	// incno=getIncnoFromEnt_invoiceno(reCharge_blcgoepAggDO_arr[0].getParentDO().getEnt_invoiceno());
	// blincoepAggDOLst=get_NewBlIncOepsFromReSettlement(reCharge_blcgoepAggDO_arr,
	// blCgItmOepMapDTO11,(BlStOepDO)blStOepDOLst.toArray(new
	// BlStOepDO[0])[0],incno,code_pkg,operatorInfoDTO);
	//
	// //4.装配DTO
	// bl_reSettlement_ST_INC_DTO.setBlStOepDO(blStOepDOLst);
	// bl_reSettlement_ST_INC_DTO.setBlincoepAggDO(blincoepAggDOLst);
	//
	// return bl_reSettlement_ST_INC_DTO;
	// }

	/**
	 * 根据重收的明细，生成重收的结算信息和发票信息
	 * 
	 * @param reCharge_blcgoepAggDO_arr
	 *            重收明细
	 * @param orgin_idstoep
	 *            原始结算ID（退费前的）
	 * @param PrintOnlyOneInvoice
	 *            多次就诊，是否打印一次结算信息
	 * @param opertorInfoDTO
	 *            操作员信息
	 * @return 重收对应的结算信息
	 * @throws BizException
	 */
	public Bl_reSettlement_ST_INC_DTO get_NewblStOepDosFromReSettlement_discard(BlcgoepAggDO[] reCharge_blcgoepAggDO_arr, String orgin_idstoep, FBoolean PrintOnlyOneInvoice,
			OperatorInfoDTO operatorInfoDTO) throws BizException {
		if (reCharge_blcgoepAggDO_arr == null) {
			return null;
		}
		Bl_reSettlement_ST_INC_DTO bl_reSettlement_ST_INC_DTO = new Bl_reSettlement_ST_INC_DTO();
		FArrayList2 blStOepDOLst = new FArrayList2();
		FArrayList2 blincoepAggDOLst = new FArrayList2();
		// 1.获得将要打印的发票号
		String ent_invoiceno = reCharge_blcgoepAggDO_arr[0].getParentDO().getEnt_invoiceno();
		// 生成重接的st,inc
		String[] arrEnts = ent_invoiceno.split("\\|");
		String[] arrBillcodes = null;
		BlStOepDO[] blStOepDos = new BlStOepDO[arrEnts.length];
		Map<String, String> ent_incno = new HashMap<String, String>();
		for (int i = 0; i < arrEnts.length; i++) {
			arrBillcodes = arrEnts[i].split(",");
			ent_incno.put(arrBillcodes[0], arrBillcodes[1]);
		}
		// String idkey= arrBillcodes[0];
		String id_pat = "";
		String id_org = "";
		String id_ent = "";
		String id_enttp = "";
		// 2.生成重新结算的ST
		for (int i = 0; i < arrEnts.length; i++) {
			String key = "";
			arrBillcodes = arrEnts[i].split(",");
			if (!PrintOnlyOneInvoice.booleanValue()) {
				// key = idkey;
				id_pat = arrBillcodes[i].split(" ")[0];
				// id_org = arrBillcodes[i].split(" ")[1];
				id_ent = arrBillcodes[i].split(" ")[1];
				id_enttp = arrBillcodes[i].split(" ")[2];
			} else {
				// key = id_pat;
				id_pat = arrBillcodes[0];
			}
			blStOepDos[i] = new BlStOepDO();
			blStOepDos[i].setId_stoep(null);
			blStOepDos[i].setEu_direct((int) BookRtnDirectEnum.CHARGES);
			blStOepDos[i].setEu_sttp(StTypeEnum.ST_OEP_CHARGE);
			blStOepDos[i].setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
			blStOepDos[i].setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
			blStOepDos[i].setId_pat(id_pat);
			blStOepDos[i].setId_par(orgin_idstoep);// 关联的结算主键
			blStOepDos[i].setId_dep_st(operatorInfoDTO.getId_dep());
			blStOepDos[i].setId_emp_st(operatorInfoDTO.getId_emp());
			blStOepDos[i].setStatus(DOStatus.NEW);
			blStOepDos[i].setId_org(operatorInfoDTO.getId_org());
			blStOepDos[i].setId_grp(operatorInfoDTO.getId_grp());
			if (id_ent.length() > 1) {
				blStOepDos[i].setId_ent(id_ent);
			} else {
				blStOepDos[i].setId_ent(reCharge_blcgoepAggDO_arr[0].getBlCgItmOepDO()[0].getId_ent());
			}
			if (id_enttp.length() > 1) {
				blStOepDos[i].setId_enttp(id_enttp);
			} else {
				blStOepDos[i].setId_enttp(reCharge_blcgoepAggDO_arr[0].getBlCgItmOepDO()[0].getId_enttp());
			}
			blStOepDos[i].setCode_enttp(reCharge_blcgoepAggDO_arr[0].getBlCgItmOepDO()[0].getCode_enttp());
			blStOepDOLst.add(blStOepDos[i]);
		}

		// 3.生成重新结算的INC
		String keyInvoice = "";
		IBlincQryService iBlincQryService = ServiceFinder.find(IBlincQryService.class);
		String code_pkg = iBlincQryService.getCodeIncPkgByIdempiss(operatorInfoDTO.getId_org(), operatorInfoDTO.getId_emp(), IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
		BlincoepAggDO[] blincoepAggDos = new BlincoepAggDO[arrEnts.length];
		for (int i = 0; i < arrEnts.length; i++) {
			blincoepAggDos[i] = new BlincoepAggDO();
			BlIncOepDO blIncOepDos = new BlIncOepDO();
			if (PrintOnlyOneInvoice.booleanValue()) {
				keyInvoice = blStOepDos[i].getId_pat();
			} else {
				keyInvoice = blStOepDos[i].getId_pat() + " " + blStOepDos[i].getId_ent() + " " + blStOepDos[i].getId_enttp();
			}

			blIncOepDos.setId_pat(blStOepDos[i].getId_pat());
			// blIncOepDos.setId_ent(blStOepDos[i].getId_ent());
			blIncOepDos.setId_enttp(blStOepDos[i].getId_enttp());
			blIncOepDos.setIncno(ent_incno.get(keyInvoice));
			blIncOepDos.setTimes_prn(1);
			blIncOepDos.setId_emp_inc(operatorInfoDTO.getId_emp());
			blIncOepDos.setCode_enttp(blStOepDos[i].getCode_enttp());
			blIncOepDos.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
			blIncOepDos.setEu_direct((int) BookRtnDirectEnum.CHARGES);
			blIncOepDos.setCode_incpkg(code_pkg);
			blIncOepDos.setId_org(operatorInfoDTO.getId_org());
			blIncOepDos.setId_grp(operatorInfoDTO.getId_grp());
			blIncOepDos.setFg_cc_in(FBoolean.FALSE);
			blIncOepDos.setFg_cc_out(FBoolean.FALSE);
			blIncOepDos.setId_cc_in(null);
			blIncOepDos.setId_cc_out(null);

			blIncOepDos.setStatus(DOStatus.NEW);
			blincoepAggDos[i] = new BlincoepAggDO();
			blincoepAggDos[i].setParentDO(blIncOepDos);
			blincoepAggDOLst.add(blincoepAggDos[i]);
		}

		// 4.装配DTO
		bl_reSettlement_ST_INC_DTO.setBlStOepDO(blStOepDOLst);
		bl_reSettlement_ST_INC_DTO.setBlincoepAggDO(blincoepAggDOLst);

		return bl_reSettlement_ST_INC_DTO;
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
		PatDO patDO = new PatDO();
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

}
