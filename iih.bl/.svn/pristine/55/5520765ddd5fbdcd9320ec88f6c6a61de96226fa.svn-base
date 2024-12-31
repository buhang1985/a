package iih.bl.pay.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.FDoubleUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.d.BlIncItmIpDO;
import iih.bl.inc.blincip.d.BlStIncIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincip.i.IBlincipCudService;
import iih.bl.inc.blincip.i.IBlincipRService;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.inc.i.IBlIncValidateService;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.bl.inc.service.i.IBlincQryService;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.ep.IpPayPatEP;
import iih.bl.pay.event.IpRefundPayPatEvent;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatip.i.IBlpaypatipCudService;
import iih.bl.st.blpaypatip.i.IBlpaypatipRService;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.DataCloneUtils;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院退款BP
 * 
 * @author liwq
 *
 */
public class DoIpRefundBP {

	/**
	 * 住院退费
	 * 
	 * @throws BizException
	 * @since 2017-7-13 18:38:33
	 * 
	 * */
	public BlPrePayPatDO doStipRefund(OperatorInfoDTO operatorInfoDTO, String id_stip, String sd_pttp) throws BizException {

		BlEventInfoDTO blEventInfoDTO = new BlEventInfoDTO();
		// 1.获取当前服务器时间		
		FDateTime dateTime = AppUtils.getServerDateTime();	

		// 2.保存并返回结算红冲信息
		BlStIpDO blStIpDO = this.setBlStIpRefund(operatorInfoDTO, id_stip, dateTime, blEventInfoDTO);

		// 3.保存红冲和新记账信息
		this.setBlCgIpRefund(id_stip, blStIpDO, dateTime, blEventInfoDTO);

		// 4.保存红冲发票信息
		this.setBlStIpIncRefund(operatorInfoDTO, id_stip, blStIpDO, dateTime, blEventInfoDTO);

		// 收付款
		FDouble amt_pay = this.setBlStIpPayRefund(operatorInfoDTO, id_stip, blStIpDO, dateTime, blEventInfoDTO);

		// 预交金
		BlPrePayPatDO blPrePayPatDO = this.setBlPrePayInfoByRefund(blStIpDO, amt_pay, sd_pttp);

		// 修改就诊账户数据
		this.setEntEntAccoutInfoByRefund(blStIpDO, amt_pay);

		// 修改就诊信息
		this.setEnEntInfoByIdStip(id_stip, blEventInfoDTO);

		// 发送事件
		this.invokeRefundEvent(blEventInfoDTO);

		return blPrePayPatDO;
	}
	/**
	 * 住院结算退款发送事件
	 * 
	 * @throws BizException
	 * */
	public void invokeRefundEvent(BlEventInfoDTO blEventInfoDTO) throws BizException {
		IpRefundPayPatEvent ipRefundEvent = new IpRefundPayPatEvent();
		ipRefundEvent.invokeRefund(blEventInfoDTO);
	}
	/**
	 * 住院退费 - 结算信息
	 * @param operatorInfoDTO
	 * @param id_stip
	 * @param dateTime
	 * @param blEventInfoDTO
	 * @return
	 * @throws BizException
	 */
	public BlStIpDO setBlStIpRefund(OperatorInfoDTO operatorInfoDTO, String id_stip, FDateTime dateTime, BlEventInfoDTO blEventInfoDTO) throws BizException {
		IpPayPatEP ipPayPatEP = new IpPayPatEP();
		IBlstipCudService stCService = ServiceFinder.find(IBlstipCudService.class);
		BlStIpDO blStIpDO = ipPayPatEP.getSettleInfo(id_stip);
		//1.组装红冲结算DO
		BlStIpDO stIpDO = DataCloneUtils.clone(blStIpDO);	
		stIpDO.setId_stip(null);		
		stIpDO.setEu_direct(BookRtnDirectEnum.RETURNS);		
		stIpDO.setEu_sttp(StTypeEnum.ST_INP_CANC);	
		GetCodeByCustomization code_ins = new GetCodeByCustomization();
		stIpDO.setCode_st(code_ins.GetCodeStIp());// 结算号
		stIpDO.setDt_st(dateTime);
		stIpDO.setId_dep_st(operatorInfoDTO.getId_dep());
		stIpDO.setId_emp_st(operatorInfoDTO.getId_emp());
		stIpDO.setFg_cc(FBoolean.FALSE);
		stIpDO.setId_cc(null);
		stIpDO.setFg_canc(FBoolean.FALSE);
		stIpDO.setId_emp_can(null);
		stIpDO.setDt_canc(null);
		stIpDO.setSd_reason_canc(null);
		stIpDO.setDes_reason_canc(null);
		stIpDO.setFg_arclear(FBoolean.TRUE);
		stIpDO.setId_propip(null);
		stIpDO.setId_par(id_stip);
		stIpDO.setFg_pay(FBoolean.TRUE);
		stIpDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
		stIpDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
		stIpDO.setStatus(DOStatus.NEW);
		BlStIpDO[] stIpDOArr = stCService.save(new BlStIpDO[] { stIpDO });
		if(ArrayUtil.isEmptyNoNull(stIpDOArr)) {
			throw new BizException("保存结算红冲数据失败！");
		}
		
		//2.更新原结算DO信息
		blStIpDO.setFg_canc(FBoolean.TRUE);
		blStIpDO.setId_emp_can(operatorInfoDTO.getId_emp());
		blStIpDO.setDt_canc(dateTime);
		blStIpDO.setId_reason_canc(IBlDictCodeConst.BD_REFUND_SETTLE_CANCELLED_ID);
		blStIpDO.setSd_reason_canc(IBlDictCodeConst.BD_REFUND_SETTLE_CANCELLED);
		blStIpDO.setDes_reason_canc("退费");
		blStIpDO.setStatus(DOStatus.UPDATED);
		BlStIpDO[] orginStDoArr = stCService.save(new BlStIpDO[] { blStIpDO });
		if(ArrayUtil.isEmptyNoNull(orginStDoArr)) {
			throw new BizException("保存结算红冲数据失败！");
		}
		//3.事件dto中赋值
		blEventInfoDTO.setBlStIpDO(stIpDOArr[0]);
		//4.返回红冲结算DO
		return stIpDOArr[0];
	}

	/**
	 * 住院退费 - 记账信息
	 */
	private void setBlCgIpRefund(String id_stip, BlStIpDO blStIpDO, FDateTime dateTime, BlEventInfoDTO blEventInfoDTO) throws BizException {
		IpPayPatEP ipPayPatEP = new IpPayPatEP();		
		List<BlCgIpDO> blCgIpDOList = new ArrayList<BlCgIpDO>();
		BlCgIpDO[] blCgIpDOArr = ipPayPatEP.getCgIpDOs(id_stip);
		FArrayList cgRefundList = new FArrayList();
		for (BlCgIpDO cgDO : blCgIpDOArr) {
			// 红冲记录
			BlCgIpDO refundDO = DataCloneUtils.clone(cgDO);
			refundDO.setEu_direct(cgDO.getEu_direct() * -1);
			refundDO.setId_stip(blStIpDO.getId_stip());
			refundDO.setDt_st(dateTime);
			refundDO.setFg_hp(FBoolean.FALSE);
			refundDO.setId_par(cgDO.getId_cgip());
			refundDO.setId_cgip(null);
			refundDO.setCode_inccaitm(cgDO.getCode_inccaitm());
			refundDO.setName_inccaitm(cgDO.getName_inccaitm());
			refundDO.setStatus(DOStatus.NEW);
			blCgIpDOList.add(refundDO);

			// 新记账数据
			BlCgIpDO blCgIpDO = DataCloneUtils.clone(cgDO);
			blCgIpDO.setId_cgip(null);
			blCgIpDO.setFg_st(FBoolean.FALSE);
			blCgIpDO.setId_stip(null);
			blCgIpDO.setDt_st(null);
			blCgIpDO.setId_par(cgDO.getId_cgip());
			blCgIpDO.setFg_refund(FBoolean.FALSE);
			blCgIpDO.setFg_free(FBoolean.FALSE);
			blCgIpDO.setStatus(DOStatus.NEW);
			blCgIpDOList.add(blCgIpDO);

			// 原记账数据
			cgDO.setFg_refund(FBoolean.TRUE);
			cgDO.setStatus(DOStatus.UPDATED);
			blCgIpDOList.add(cgDO);
		}
		// 保存记账明细
		ipPayPatEP.saveCgIpDOs(blCgIpDOList.toArray(new BlCgIpDO[]{}));
		// 事件DTO赋值红冲记账数据
		blEventInfoDTO.setBlCgIpDOList(cgRefundList);
	}

	/**
	 * 出院退费--发票信息 红冲票据:取医保计划，如果医保要求打印红冲票据（BD_HP.FG_SABINC =
	 * TRUE）并且红冲票据需要由HIS打印(BD_HP.EU_SABINCPRN = 0)，则生成红冲发票，并且移动票号,
	 * 否则,也生成红冲票据信息，但是incno,code_incpkg,dt_inc,id_emp_inc设为空，fg_print=false
	 * 如果患者没有医保计划,则不生成红冲发票信息 2016-08-18 TCY 修改 2016-11-25 TCY
	 * 修改（如果不打印红冲票，也生成红冲票据信息
	 * ，但是incno,code_incpkg,dt_inc,id_emp_inc设为空，fg_print=false） 2017-4-5
	 * TCY修改，将是否需要打印红冲发票挪到函数IBLCancelSettlement.getFPrintRedInc(id_ent)中
	 * */
	public void setBlStIpIncRefund(OperatorInfoDTO operatorInfoDTO, String id_stip, BlStIpDO blStIpDO, FDateTime dateTime, BlEventInfoDTO blEventInfoDTO) throws BizException {

		// 获得ID_HP主医保计划
		IBlstipRService iBlstipRService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO[] blStIpDOs0 = iBlstipRService.find(" a0.id_stip='" + id_stip + "'", "", FBoolean.TRUE);
		if (null == blStIpDOs0 || blStIpDOs0.length == 0) {
			throw new BizException("查询原住院结算信息失败");
		}

		// 2017-4-5,查询患者的就诊对应医保计划下，是否需要打印红冲票 修改日期 2017年6月26日 yang.lu 方法迁入到 IBlIncOutQryService.isPrintRedInc中
		IBlIncValidateService service = ServiceFinder.find(IBlIncValidateService.class);
		FBoolean printRedInvoice = service.isPrintRedInc(blStIpDOs0[0].getId_ent());

		IBlincipRService incRService = ServiceFinder.find(IBlincipRService.class);
		IBlincipCudService incCService = ServiceFinder.find(IBlincipCudService.class);
		BlincipAggDO[] blIncIpAggDOArr = incRService.find(" a0.id_stip = '" + id_stip + "'", null, FBoolean.FALSE);
		if (blIncIpAggDOArr == null || blIncIpAggDOArr.length == 0) {
			return;
		}
		// 获取票据编码
		IBLInvoiceService incService = (IBLInvoiceService) ServiceFinder.find(IBLInvoiceService.class);
		String incno = "";
		IBlincQryService incQService = ServiceFinder.find(IBlincQryService.class);
		String code_incpkg = incQService.getCodeIncPkgByIdempiss(operatorInfoDTO.getId_org(), operatorInfoDTO.getId_emp(), IBdInccaCodeConst.ID_INHOS_INVOICE);// 票据包编号

		List<BlincipAggDO> aggDOList = new ArrayList<BlincipAggDO>();
		for (BlincipAggDO aggDO : blIncIpAggDOArr) {
			// 红冲发票
			BlincipAggDO blIncIpAggDO = new BlincipAggDO();
			BlIncIpDO refundDO = (BlIncIpDO) aggDO.getParentDO().clone();
			refundDO.setId_incip(null);
			refundDO.setEu_direct(BookRtnDirectEnum.RETURNS);
			refundDO.setId_incca(IBdInccaCodeConst.ID_INHOS_INVOICE);// 当前票据包分类

			if (printRedInvoice.booleanValue()) { // 红冲发票，需要打印红冲发票信息，才出票据号，票据包号等
				incno = incService.GetInvoiceNo(operatorInfoDTO.getId_emp(), IBdInccaCodeConst.CODE_INHOS_INVOICE);
				refundDO.setCode_incpkg(code_incpkg);// 当前票据包编码
				refundDO.setIncno(incno);
				refundDO.setDt_inc(dateTime);
				refundDO.setId_emp_inc(operatorInfoDTO.getId_emp());
				refundDO.setTimes_prn(1);
				refundDO.setFg_print(FBoolean.TRUE);
				// 打印了红冲票，需要重设当前发票号
				String curno = String.valueOf(Long.parseLong(incno) + 1);
				incService.SetCurNoByParamNo(operatorInfoDTO.getId_emp(), IBdInccaCodeConst.ID_OUTPATIENT_INVOICE, curno);
			} else {
				refundDO.setCode_incpkg(null);
				refundDO.setIncno("");
				refundDO.setDt_inc(null);
				refundDO.setId_emp_inc("");
				refundDO.setTimes_prn(0);
				refundDO.setFg_print(FBoolean.FALSE);
			}
			refundDO.setId_stip(blStIpDO.getId_stip());

			refundDO.setFg_cc_out(FBoolean.FALSE);
			refundDO.setFg_cc_in(FBoolean.FALSE);
			refundDO.setStatus(DOStatus.NEW);
			blIncIpAggDO.setParentDO(refundDO);
			if (aggDO.getBlIncItmIpDO() != null) {
				List<BlIncItmIpDO> incItmIpList = new ArrayList<BlIncItmIpDO>();
				for (BlIncItmIpDO blIncItmIpDO : aggDO.getBlIncItmIpDO()) {
					BlIncItmIpDO incItmDO = (BlIncItmIpDO) blIncItmIpDO.clone();
					incItmDO.setId_incitmip(null);
					incItmDO.setId_incip(null);
					incItmDO.setStatus(DOStatus.NEW);
					incItmIpList.add(incItmDO);
				}
				blIncIpAggDO.setBlIncItmIpDO(incItmIpList.toArray(new BlIncItmIpDO[] {}));
			}
			if (aggDO.getBlStIncIpDO() != null) {
				List<BlStIncIpDO> stIncIpList = new ArrayList<BlStIncIpDO>();
				for (BlStIncIpDO blStIncIpDO : aggDO.getBlStIncIpDO()) {
					BlStIncIpDO stIncIpDO = (BlStIncIpDO) blStIncIpDO.clone();
					stIncIpDO.setId_stincip(null);
					stIncIpDO.setId_incip(null);
					stIncIpDO.setStatus(DOStatus.NEW);
					stIncIpList.add(stIncIpDO);
				}
				blIncIpAggDO.setBlStIncIpDO(stIncIpList.toArray(new BlStIncIpDO[] {}));
			}
			aggDOList.add(blIncIpAggDO);
			blEventInfoDTO.setBlincipAggDO(blIncIpAggDO);

			// 原发票记录修改
			aggDO.getParentDO().setFg_canc(FBoolean.TRUE);
			aggDO.getParentDO().setSd_reason_canc("01");
			aggDO.getParentDO().setDes_reason_canc("退费");
			aggDO.getParentDO().setDt_canc(dateTime);
			aggDO.getParentDO().setId_emp_canc(operatorInfoDTO.getId_emp());
			aggDO.getParentDO().setFg_print(FBoolean.FALSE);
			aggDO.getParentDO().setStatus(DOStatus.UPDATED);
			aggDOList.add(aggDO);
		}
		incCService.save(aggDOList.toArray(new BlincipAggDO[] {}));
	}

	/**
	 * 出院退费--结算收付款信息
	 * */
	public FDouble setBlStIpPayRefund(OperatorInfoDTO operatorInfoDTO, String id_stip, BlStIpDO blStIpDO, FDateTime dateTime, BlEventInfoDTO blEventInfoDTO) throws BizException {
		IBlpaypatipRService payRService = ServiceFinder.find(IBlpaypatipRService.class);
		IBlpaypatipCudService payCService = ServiceFinder.find(IBlpaypatipCudService.class);
		BlpaypatipAggDO[] blPayPatIpAggDOArr = payRService.find(" a0.id_stip = '" + id_stip + "'", null, FBoolean.FALSE);
		if (ArrayUtil.isEmptyNoNull(blPayPatIpAggDOArr)) {
			throw new BizException("未查询到本次结算对应的收付款明细信息！");
		}
		List<BlPayItmPatIpDO> freeList = new ArrayList<BlPayItmPatIpDO>();
		List<BlPayItmPatIpDO> noFreeList = new ArrayList<BlPayItmPatIpDO>();
		List<BlPayItmPatIpDO> redPayList = new ArrayList<BlPayItmPatIpDO>();
		FDouble amt_pay = FDouble.ZERO_DBL; //结算总金额
		FDouble amt_no_free = FDouble.ZERO_DBL; //非减免支付金额
		FDouble amt_free = FDouble.ZERO_DBL; //减免金额
		FBoolean fg_free = FBoolean.FALSE;	//含有减免的标志
		for (BlpaypatipAggDO payPatAggDO : blPayPatIpAggDOArr) {
			amt_pay = amt_pay.add(payPatAggDO.getParentDO().getAmt());
			for (BlPayItmPatIpDO blPayItmPatIpDO : payPatAggDO.getBlPayItmPatIpDO()) {				
				if (IBdPripmCodeConst.CODE_PRI_PM_MONEYDEDUCTION.equals(blPayItmPatIpDO.getSd_pm()) || IBdPripmCodeConst.CODE_PRI_PM_SRVDEDUCTION.equals(blPayItmPatIpDO.getSd_pm())) {
					fg_free = FBoolean.TRUE;
					amt_free = amt_free.add(blPayItmPatIpDO.getAmt().multiply(blPayItmPatIpDO.getEu_direct()));
					freeList.add(blPayItmPatIpDO);
				} else {
					amt_no_free = amt_no_free.add(blPayItmPatIpDO.getAmt().multiply(blPayItmPatIpDO.getEu_direct()));
					noFreeList.add(blPayItmPatIpDO);
				}
			}
		}

		// 红冲数据
		BlpaypatipAggDO payAggDO = new BlpaypatipAggDO();

		BlPayPatIpDO payIpDO = new BlPayPatIpDO();
		payIpDO.setId_paypatip(null);
		payIpDO.setId_grp(operatorInfoDTO.getId_grp());
		payIpDO.setId_org(operatorInfoDTO.getId_org());
		payIpDO.setId_stip(blStIpDO.getId_stip());
		payIpDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_CANCELST);
		payIpDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_CANCELST);
		payIpDO.setId_pat(blStIpDO.getId_pat());
		payIpDO.setId_ent(blStIpDO.getId_ent());
		payIpDO.setId_enttp(blStIpDO.getId_enttp());
		payIpDO.setCode_enttp(blStIpDO.getCode_enttp());
		
		payIpDO.setEu_direct(BookRtnDirectEnum.RETURNS);
		
		payIpDO.setAmt(amt_pay);// 收退款金额(个人负担金额)
		payIpDO.setDt_pay(dateTime);
		payIpDO.setId_org_pay(operatorInfoDTO.getId_org());
		payIpDO.setId_dep_pay(operatorInfoDTO.getId_dep());
		payIpDO.setId_emp_pay(operatorInfoDTO.getId_emp());
		payIpDO.setId_cc(null);
		payIpDO.setFg_cc(FBoolean.FALSE);
		payIpDO.setNote("取消结算");
		payIpDO.setStatus(DOStatus.NEW);
		payAggDO.setParentDO(payIpDO);
		
		if (fg_free.booleanValue()) {//原支付方式含减免
			redPayList.add(this.getNewBlPayPatItmDO(operatorInfoDTO.getId_org(), amt_free, freeList.get(0).getId_pm(), freeList.get(0).getSd_pm()));
		} else {			
			redPayList.add(this.getNewBlPayPatItmDO(operatorInfoDTO.getId_org(), amt_no_free, IBdPripmCodeConst.ID_PRI_PM_CASH, IBdPripmCodeConst.CODE_PRI_PM_CASH));
		}
		
		payAggDO.setBlPayItmPatIpDO(redPayList.toArray(new BlPayItmPatIpDO[] {}));

		BlpaypatipAggDO[] payAggDOArr = payCService.save(new BlpaypatipAggDO[] { payAggDO });

		// 事件DTO中赋值红冲结算收付款信息
		blEventInfoDTO.setBlpaypatipRedAggDO(payAggDOArr[0]);

		// 修改红冲结算信息
		if (payAggDOArr == null || payAggDOArr.length == 0) {
			throw new BizException("红冲结算收付款信息失败！");
		}	

		return amt_no_free;
	}
	
	/**
	 * 出院退费--修改预交金信息
	 * */
	public BlPrePayPatDO setBlPrePayInfoByRefund(BlStIpDO blStIpDO, FDouble amtRecharge, String sd_pttp) throws BizException {
		if (FDoubleUtils.isNullOrZero(amtRecharge)) {
			return null;
		}
		BlPrePayPatDO prePayDO = new BlPrePayPatDO();
		prePayDO.setId_org(Context.get().getOrgId());
		prePayDO.setId_grp(Context.get().getGroupId());
		prePayDO.setId_dep_pay(Context.get().getDeptId());
		prePayDO.setId_org_pay(Context.get().getOrgId());
		prePayDO.setId_emp_pay(Context.get().getStuffId());
		prePayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAY);
		prePayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAY);
		prePayDO.setId_pat(blStIpDO.getId_pat());
		prePayDO.setId_ent(blStIpDO.getId_ent());
		prePayDO.setId_enttp(blStIpDO.getId_enttp());
		prePayDO.setCode_enttp(blStIpDO.getCode_enttp());
		prePayDO.setEu_direct(BookRtnDirectEnum.CHARGE);
		prePayDO.setAmt(amtRecharge);
		prePayDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_CASH);
		prePayDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CASH);
		// 获取当前服务器时间
		FDateTime dateTime = AppUtils.getServerDateTime();
		prePayDO.setDt_pay(dateTime);
		prePayDO.setSd_pttp(sd_pttp);
		prePayDO.setNote("住院退款-退回");
		prePayDO.setStatus(DOStatus.NEW);

		// 获取当前票据编码
		IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
		//IBLInvoiceService incService = (IBLInvoiceService) ServiceFinder.find(IBLInvoiceService.class);
		prePayDO.setCode_rep(incService.getCurInvoiceNo(prePayDO.getId_emp_pay(), Context.get().getClientHost(), IBdInccaCodeConst.ID_INHOS_DEPOSIT));
		prePayDO.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);
		prePayDO.setCode_incca(IBdInccaCodeConst.CODE_INHOS_DEPOSIT);

		IBlpaypatCudService payService = (IBlpaypatCudService) ServiceFinder.find(IBlpaypatCudService.class);
		BlPrePayPatDO[] blPrePayPatDOArr = payService.save(new BlPrePayPatDO[] { prePayDO });
		if (ArrayUtil.isEmptyNoNull(blPrePayPatDOArr)) {
			throw new BizException("退费充值预交金保存失败！");
		}
		incService.nextInvoiceNo(prePayDO.getId_emp_pay(), Context.get().getClientHost(), IBdInccaCodeConst.ID_INHOS_DEPOSIT);
		//incService.NextInvoiceNoUpdateCurNo(prePayDO.getId_emp_pay(), IBdInccaCodeConst.CODE_INHOS_DEPOSIT);// 票据编码修改
		
		return blPrePayPatDOArr[0];
	}
	

	/**
	 * 出院退费--修改就诊账户信息
	 * */
	public void setEntEntAccoutInfoByRefund(BlStIpDO blStIpDO, FDouble amt_pay) throws BizException {
		IEnOutCmdService inpPatAccImpls = ServiceFinder.find(IEnOutCmdService.class);
		// 消费金额
		inpPatAccImpls.consume(blStIpDO.getId_ent(), blStIpDO.getAmt_ratio());
		// 充值金额
		inpPatAccImpls.recharge(blStIpDO.getId_ent(), amt_pay);
	}
	

	/**
	 * 出院退费--修改就诊信息
	 * 
	 * @throws BizException
	 * */
	public void setEnEntInfoByIdStip(String id_stip, BlEventInfoDTO blEventInfoDTO) throws BizException {
		IBlstipRService stRService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO blStIpDO = stRService.findById(id_stip);

		IPativisitRService entService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = entService.findById(blStIpDO.getId_ent());

		if (StTypeEnum.ST_INP.equals(blStIpDO.getEu_sttp())) {
			IPativisitCudService entCService = ServiceFinder.find(IPativisitCudService.class);
			patiVisitDO.setFg_st(FBoolean.FALSE);
			patiVisitDO.setStatus(DOStatus.UPDATED);
			entCService.save(new PatiVisitDO[] { patiVisitDO });
		}

		blEventInfoDTO.setPatiVisitDO(patiVisitDO);
	}

	
	/**
	 * 组装收付款明细数据
	 * */
	public BlPayItmPatIpDO getNewBlPayPatItmDO(String id_org, FDouble amt, String id_pm, String sd_pm) {
		BlPayItmPatIpDO payItmDO = new BlPayItmPatIpDO();
		payItmDO.setId_payitmpatip(null);
		payItmDO.setId_paypatip(null);
		payItmDO.setId_org(id_org);
		payItmDO.setEu_direct(BookRtnDirectEnum.RETURNS);
		payItmDO.setId_pm(id_pm);
		payItmDO.setSd_pm(sd_pm);
		payItmDO.setAmt(amt);
		payItmDO.setId_bank(null);
		payItmDO.setBankno(null);
		payItmDO.setPaymodenode(null);
		payItmDO.setFg_realpay(FBoolean.TRUE);// 新加字段
		payItmDO.setStatus(DOStatus.NEW);
		return payItmDO;
	}

}
