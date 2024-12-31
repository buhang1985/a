package iih.bl.cg.ep;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.inc.blincoep.d.BlIncCgItmOep;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlStIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.inc.i.IBlIncValidateService;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.bl.inc.service.i.IBlincQryService;
import iih.bl.st.blstoep.d.BlStOepDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class OepIncEP {
	
	/** 
	 * 红冲票据：取医保计划，如果医保要求打印红冲票据（BD_HP.FG_SABINC =
	 * TRUE）并且红冲票据需要由HIS打印(BD_HP.EU_SABINCPRN = 0)，则生成红冲发票，并且移动票号；
	 * 否则，也生成红冲发票，但是incno,code_incpkg,dt_inc,id_emp_inc设为空，fg_print=false* 
	 * @param printRedInc 是否打印红冲票 
	 * @param stOepDO 原收费数据
	 * @param id_stoep_redback 原结算对应的红冲结算ID
	 * @param PrintOnlyOneInvoice 多次就诊一次结算是否打印一张发票
	 * @param AllRefundAndAllCharge 是否重退重收
	 * @param strDateTime 当前操作时间
	 * @param operatorInfoDTO 操作人员信息
	 * @param blcgoepAggDO1 记账数据
	 * @return
	 * @throws BizException
	 */
	public BlincoepAggDO[] redback_BlIncOep(FBoolean printRedInc, BlStOepDO stOepDO, String id_stoep_redback, FBoolean PrintOnlyOneInvoice, FBoolean AllRefundAndAllCharge, FDateTime strDateTime, OperatorInfoDTO operatorInfoDTO, BlcgoepAggDO[] blcgoepAggDO1) throws BizException {
		// 门诊的退费，不会从前台传来是否打印红冲票。只有退号才从前台传来是否打印红冲票
		if (printRedInc == null) {
			// 取医保计划如果医保要求打印红冲票据（BD_HP.FG_SABINC =
			// TRUE）并且红冲票据需要由HIS打印(BD_HP.EU_SABINCPRN = 0)，
			IBlIncValidateService service = ServiceFinder.find(IBlIncValidateService.class);
			printRedInc = service.isPrintRedInc(stOepDO.getId_ent());
		}
		
		//2018/04/20 ly 重构红冲发票逻辑
		IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
		BlincoepAggDO[] blincoepAggDOs = incService.saveRedOpInvoice(stOepDO.getId_stoep(), blcgoepAggDO1, printRedInc);
		
		// 红冲票据
		/*BlincoepAggDO[] blincoepAggDOs = null;
		String entAndno = "", key = "";

		// 查找原发票
		IBlincoepRService iBlincoepRService = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] r_blincoepAggDOs = iBlincoepRService.findByAttrValString(BlIncOepDO.ID_STOEP, stOepDO.getId_stoep());
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
		List<BlCgItmOepDO> blCgItmOepDOLst = new ArrayList<BlCgItmOepDO>();
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
				key = blIncOepDO.getId_pat();
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
			
			GetCodeByCustomization code_ins = new GetCodeByCustomization();
			// 打印了红冲票，需要重设当前发票号
			String curno =code_ins.computeNextInvoiceNo(maxInvoiceno);
			IBLInvoiceService iBLInvoiceService = ServiceFinder.find(IBLInvoiceService.class);

			iBLInvoiceService.SetCurNoByParamNo(operatorInfoDTO.getId_emp(), IBdInccaCodeConst.ID_OUTPATIENT_INVOICE, curno);
		}*/
		return blincoepAggDOs;
	}
}
