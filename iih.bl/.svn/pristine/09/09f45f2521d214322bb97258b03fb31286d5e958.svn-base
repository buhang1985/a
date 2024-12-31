package iih.bl.cg.service.s.bp;

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
import iih.bl.cg.bp.GetBlCgItmOepMap;
import iih.bl.cg.bp.RedBackBP;
import iih.bl.cg.dto.d.BlCgItmOepMapDTO;
import iih.bl.cg.service.d.BlRefundItmDTO;
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
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.bl.inc.service.i.IBlincQryService;
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
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mp.dg.dto.d.OpDgRtnAmountDTO;
import iih.mp.dg.i.IMpDgOutService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiRService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

public class RedBackBillBp {
	/**
	 * 红冲(退费重构前的红冲，待程序稳定后，不再使用）
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
	 * @param AllRefundAndAllCharge
	 *            是否重退重收
	 * @throws BizException
	 */
	public BlcgoepAggDO[] exec(BlpaypatoepAggDO blpaypatoepAggDO, String id_stoep, String[] id_cgoep, BlRefundItmDTO[] id_cditmoep, OperatorInfoDTO operatorInfoDTO, String id_hp,
			FBoolean AllRefundAndAllCharge) throws BizException {
		// 提取指定的结算信息，记账信息，发票信息

		// //////////////先红冲
		String key = "", entAndno = "";
		String id_ent = "";
		GetCodeByCustomization code_ins = new GetCodeByCustomization();
		RedBackBP redBackBP_ins = new RedBackBP();
		FDouble all_amt = new FDouble(0);
		FDouble all_amt_pat = new FDouble(0);
		FDouble all_amt_std = new FDouble(0);
		FDouble all_amt_hp = new FDouble(0);
		FDouble sum_amt_acc = new FDouble(0); // 患者账户锁定金额合计变量清空

		// 1. 查找原结算信息
		IBlstoepRService iBlstoepRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO[] blStOepDOs0 = iBlstoepRService.find(" a0.id_stoep='" + id_stoep + "'", "", FBoolean.TRUE);
		if (null == blStOepDOs0 || blStOepDOs0.length == 0) {
			throw new BizException("查询原门诊结算信息失败");
		}
		TimeService timeService = new TimeServiceImpl();
		FDateTime strDateTime = timeService.getUFDateTime();
		// 2. 红冲收付款，并得到保存后的红冲收付款(采用统一解决方案）
		BlpaypatoepAggDO[] red_BlpaypatoepAggDO = redBackBP_ins.redBack_BlpaypatoepAgg(blStOepDOs0[0].getId_paypatoep(), strDateTime, operatorInfoDTO);

		// 3. 修改原结算信息，设置为取消
		for (int i = 0; i < blStOepDOs0.length; i++) {
			blStOepDOs0[i].setFg_canc(FBoolean.TRUE);
			blStOepDOs0[i].setId_emp_canc(operatorInfoDTO.getId_emp());
			blStOepDOs0[i].setDt_canc(strDateTime);
			blStOepDOs0[i].setId_reason_canc(IBlDictCodeConst.BD_REFUND_SETTLE_CANCELLED_ID);
			blStOepDOs0[i].setSd_reason_cand(IBlDictCodeConst.BD_REFUND_SETTLE_CANCELLED);
			blStOepDOs0[i].setStatus(DOStatus.UPDATED);

		}
		IBlstoepCudService iBlstoepCudService = ServiceFinder.find(IBlstoepCudService.class);
		BlStOepDO[] blStOepDOs = iBlstoepCudService.save(blStOepDOs0);
		if (null == blStOepDOs || blStOepDOs.length == 0) {
			throw new BizException("修改原门诊结算信息失败");
		}

		// 4. 红冲结算,生成红冲的结算信息，并保存
		BlStOepDO[] r_blStOepDOs = blStOepDOs0.clone();
		for (int i = 0; i < r_blStOepDOs.length; i++) {
			// r_blStOepDOs[i].setAmt(all_amt);
			// r_blStOepDOs[i].setAmt_pat(all_amt_pat);
			// r_blStOepDOs[i].setAmt_std(all_amt_std);
			r_blStOepDOs[i].setId_par(r_blStOepDOs[i].getId_stoep());
			r_blStOepDOs[i].setId_stoep(null);
			r_blStOepDOs[i].setId_org(operatorInfoDTO.getId_org());
			r_blStOepDOs[i].setId_grp(operatorInfoDTO.getId_grp());
			r_blStOepDOs[i].setEu_direct(BookRtnDirectEnum.REFUND);

			if (id_cditmoep[0].getEu_srctp() != null && id_cditmoep[0].getEu_srctp().intValue() == 1) {
				r_blStOepDOs[i].setEu_sttp(StTypeEnum.ST_REGISTER_RED); // 门诊挂号取消结算
			} else {
				r_blStOepDOs[i].setEu_sttp(StTypeEnum.ST_OEP_MIDWAY); // 门诊冲账
			}
			String stCode = BlCodeUtils.generateOepStCode();
			r_blStOepDOs[i].setCode_st(stCode);
			r_blStOepDOs[i].setDt_st(strDateTime);
			r_blStOepDOs[i].setId_dep_st(operatorInfoDTO.getId_dep());
			r_blStOepDOs[i].setId_emp_st(operatorInfoDTO.getId_emp());
			r_blStOepDOs[i].setFg_cc(FBoolean.FALSE);
			r_blStOepDOs[i].setFg_canc(FBoolean.FALSE);
			r_blStOepDOs[i].setId_emp_canc(null);
			r_blStOepDOs[i].setDt_canc(null);
			r_blStOepDOs[i].setId_reason_canc(null);
			r_blStOepDOs[i].setSd_reason_cand(null);
			r_blStOepDOs[i].setDes_reason_canc(null);
			// 红冲的收付款主键
			r_blStOepDOs[i].setId_paypatoep(red_BlpaypatoepAggDO[0].getParentDO().getId_paypatoep());
			r_blStOepDOs[i].setStatus(DOStatus.NEW);

		}

		BlStOepDO[] r_blStOepDOs1 = iBlstoepCudService.save(r_blStOepDOs);
		if (null == r_blStOepDOs1 || r_blStOepDOs1.length == 0) {
			throw new BizException("保存红冲门诊结算信息失败");
		}

		// 5. 生成红冲的记账信息
		IBlcgoepRService iBlcgoepRService = ServiceFinder.find(IBlcgoepRService.class);
		BlcgoepAggDO[] r_blcgoepAggDO1 = iBlcgoepRService.findByIds(id_cgoep, FBoolean.TRUE);
		if (null == r_blcgoepAggDO1 || r_blcgoepAggDO1.length == 0) {
			throw new BizException("查询原门诊记账信息失败");
		}

		List<String> id_orsrv = new ArrayList<String>();
		int index = 0, k = 0;
		k = id_cditmoep.length;
		List<BlcgoepAggDO> blcgoepAggDOList = new ArrayList<BlcgoepAggDO>();

		BlcgoepAggDO new_BlcgoepAggDO = new BlcgoepAggDO();
		List<BlCgItmOepDO> new_BlCgItmOepDOList = new ArrayList<BlCgItmOepDO>();
		BlCgOepDO new_BlCgOepDO = new BlCgOepDO();
		FDouble new_quan = new FDouble(0);
		// drugRefundMap=new FMap();

		IPriCalService pcService = (IPriCalService) ServiceFinder.find(IPriCalService.class);
		IBlcgoepCudService iBlcgoepCudService = ServiceFinder.find(IBlcgoepCudService.class);
		IMpDgOutService iMpDgOutService = ServiceFinder.find(IMpDgOutService.class);
		// 更改原bl_cg_itm_oep中的fg_refund为Y
		for (BlcgoepAggDO agg : r_blcgoepAggDO1) {
			agg.getParentDO().setStatus(DOStatus.UPDATED);
			BlCgItmOepDO[] blCgItmOepDOarr = agg.getBlCgItmOepDO();

			for (BlCgItmOepDO blCgItmOepdo : blCgItmOepDOarr) {

				blCgItmOepdo.setFg_refund(FBoolean.TRUE);
				blCgItmOepdo.setStatus(DOStatus.UPDATED);
			}

		}
		// sum_amt_acc=sum_amt_acc.multiply(-1);//红冲的
		BlcgoepAggDO[] r_blcgoepAggDO = iBlcgoepCudService.save(r_blcgoepAggDO1);
		if (null == r_blcgoepAggDO || r_blcgoepAggDO.length == 0) {
			throw new BizException("保存红冲门诊记账信息失败");
		}

		//

		int all_blcgitms_count = 0; // 所有明细记录数
		int allRefund_count = 0;// 全退的记录数量
		// 红冲原纪录，且生成重收纪录
		for (int i = 0; i < r_blcgoepAggDO.length; i++) {
			BlcgoepAggDO blcgoepAggDO = new BlcgoepAggDO();
			BlCgOepDO blCgOepDO = r_blcgoepAggDO[i].getParentDO();
			blCgOepDO.setId_cgoep(null);
			blCgOepDO.setId_org(operatorInfoDTO.getId_org());
			blCgOepDO.setId_grp(operatorInfoDTO.getId_grp());
			blCgOepDO.setCode_cg(code_ins.GetCodeBlCgOep());
			blCgOepDO.setId_dep_cg(operatorInfoDTO.getId_dep());
			blCgOepDO.setId_org_cg(operatorInfoDTO.getId_org_emp());
			blCgOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
			blCgOepDO.setDt_cg(strDateTime);
			blCgOepDO.setStatus(DOStatus.NEW);
			BlCgItmOepDO[] blCgItmOepDOs = r_blcgoepAggDO[i].getBlCgItmOepDO();
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
								&& "~" != blCgItmOepDOs[j].getId_or()) {

							if (!AllRefundAndAllCharge.booleanValue()) // 非全退全收
							{
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
				if (new_BlCgOepDO.getId_pat() == null) {
					// 生成重收的CG主表
					new_BlCgOepDO = (BlCgOepDO) r_blcgoepAggDO[i].getParentDO().clone();
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

				blCgItmOepDOs[j].setNote("退费：" + blCgItmOepDOs[j].getId_cgitmoep());
				blCgItmOepDOs[j].setId_par(blCgItmOepDOs[j].getId_cgitmoep());
				blCgItmOepDOs[j].setId_cgitmoep(null);
				blCgItmOepDOs[j].setId_cgoep(null);
				blCgItmOepDOs[j].setId_org(operatorInfoDTO.getId_org());
				blCgItmOepDOs[j].setId_grp(operatorInfoDTO.getId_grp());
				blCgItmOepDOs[j].setFg_st(FBoolean.TRUE);
				blCgItmOepDOs[j].setId_stoep(r_blStOepDOs1[0].getId_stoep());
				blCgItmOepDOs[j].setDt_st(strDateTime);
				blCgItmOepDOs[j].setFg_hp(blCgItmOepDOs[j].getFg_hp());
				blCgItmOepDOs[j].setFg_susp(FBoolean.FALSE);
				blCgItmOepDOs[j].setFg_refund(FBoolean.FALSE);
				blCgItmOepDOs[j].setStatus(DOStatus.NEW);
			}
			blcgoepAggDO.setParentDO(blCgOepDO);
			blcgoepAggDO.setBlCgItmOepDO(blCgItmOepDOs);
			blcgoepAggDOList.add(blcgoepAggDO);

		}

		// if(drugRefundMap.size()>0)
		// {
		// //门急诊药品退费前数量校验
		// IMpDgOutService
		// iMpDgOutService=ServiceFinder.find(IMpDgOutService.class);
		// String
		// info=iMpDgOutService.checkDrugAmountBeforeRefundCharge(drugRefundMap);
		// if(info.trim().length()>0)
		// {
		// throw new BizException(info);
		// }
		// }
		// 6. 保存红冲的记账信息
		BlcgoepAggDO[] blcgoepAggDO1 = iBlcgoepCudService.save(blcgoepAggDOList.toArray(new BlcgoepAggDO[] {}));
		if (null == blcgoepAggDO1 || blcgoepAggDO1.length == 0) {
			throw new BizException("保存红冲门诊记账信息失败");
		}

		if (id_orsrv.size() > 0)// 在补费接口，就需要更新医嘱记账信息
		{
			// 7.修改医嘱为退费状态
			Object obj2 = ServiceFinder.find(ICiOrdMaintainService.class);
			FBoolean updateCiOrder = ((ICiOrdMaintainService) obj2).UpdateOrdChargeRelInfo2(id_orsrv.toArray(new String[] {}), ICiDictCodeConst.SD_SU_BL_REFOUND_ID, ICiDictCodeConst.SD_SU_BL_REFOUND,
					strDateTime, FeeReverseType.BLSTREVERSE);
		}

		// 8.红冲票据
		// 取医保计划如果医保要求打印红冲票据（BD_HP.FG_SABINC =
		// TRUE）并且红冲票据需要由HIS打印(BD_HP.EU_SABINCPRN = 0)，
		BlincoepAggDO[] blincoepAggDO_red = redback_BlIncOep(r_blcgoepAggDO[0].getBlCgItmOepDO()[0].getId_ent(), id_stoep, r_blStOepDOs1[0].getId_stoep(), id_hp, AllRefundAndAllCharge, strDateTime,
				operatorInfoDTO, blcgoepAggDO1);

		// // ////////红冲结束

		// 9发事件
		try {
			// if(blincoepAggDO_red!=null && blincoepAggDO_red.length>0)
			// {
			this.invokeOepSettlementEvent(blcgoepAggDO1, red_BlpaypatoepAggDO[0], r_blStOepDOs1[0], blincoepAggDO_red[0]);
			// }
			// else
			// {
			// this.invokeOepSettlementEvent(blcgoepAggDO1,
			// red_BlpaypatoepAggDO[0], r_blStOepDOs1[0],blincoepAggDO_red[0]);
			// }
		} catch (Exception ex) {
			// xap.mw.runtime.msys.logging.
		}

		// 10. 如果全退(非重退重收)，则修改红冲收付款明细的实收（退）付款段标志，且返回null
		if (allRefund_count == all_blcgitms_count && !AllRefundAndAllCharge.booleanValue()) {

			IBlpaypatoepCudService iBlpaypatoepCudService = ServiceFinder.find(IBlpaypatoepCudService.class);

			Map<String, FDouble> pmAmt = new HashMap<String, FDouble>();
			FDouble temAmt = new FDouble(0);
			List<BlPayItmPatOepDO> qt_BlPayItmPatOepDOLst = new ArrayList<BlPayItmPatOepDO>();
			BlPayItmPatOepDO[] blPayItmPatOepDOArr = blpaypatoepAggDO.getBlPayItmPatOepDO();
			for (BlPayItmPatOepDO blPayItmPatOepDO : blPayItmPatOepDOArr) {
				if (pmAmt.containsKey(blPayItmPatOepDO.getId_pm() + "|" + blPayItmPatOepDO.getSd_pm())) {
					temAmt = pmAmt.get(blPayItmPatOepDO.getId_pm() + "|" + blPayItmPatOepDO.getSd_pm()).add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
				} else {
					pmAmt.put(blPayItmPatOepDO.getId_pm() + "|" + blPayItmPatOepDO.getSd_pm(), blPayItmPatOepDO.getAmt());
				}
				blPayItmPatOepDO.setFg_realpay(FBoolean.TRUE);
			}
			if (pmAmt.size() < blPayItmPatOepDOArr.length) {
				// 合并
				Iterator entrys = pmAmt.entrySet().iterator();
				int i = 0, j = 0;
				while (entrys.hasNext()) {
					Map.Entry entry = (Map.Entry) entrys.next();
					String key1 = (String) entry.getKey();
					// BlPropArOepDO blPropArOepDOt = (BlPropArOepDO)
					// entry.getValue();
					BlPayItmPatOepDO blPayItmPatOepDO = new BlPayItmPatOepDO();
					blPayItmPatOepDO = blpaypatoepAggDO.getBlPayItmPatOepDO()[0];
					blPayItmPatOepDO.setId_pm(key1.substring(0, key1.indexOf('|')));
					blPayItmPatOepDO.setSd_pm(key1.substring(key1.indexOf('|') + 1));
					blPayItmPatOepDO.setAmt(((FDouble) entry.getValue()).abs());
					if (((FDouble) entry.getValue()).compareTo(new FDouble(0)) < 0) {
						blPayItmPatOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
					} else {
						blPayItmPatOepDO.setEu_direct(BookRtnDirectEnum.CHARGES);
					}
					blPayItmPatOepDO.setFg_realpay(FBoolean.TRUE);
					qt_BlPayItmPatOepDOLst.add(blPayItmPatOepDO);
				}
				BlpaypatoepAggDO blpaypatoepAggDOQt = new BlpaypatoepAggDO();
				blpaypatoepAggDOQt.setParentDO(blpaypatoepAggDO.getParentDO());
				blpaypatoepAggDOQt.setBlPayItmPatOepDO(qt_BlPayItmPatOepDOLst.toArray(new BlPayItmPatOepDO[0]));
				blpaypatoepAggDO = blpaypatoepAggDOQt;
			}
			blpaypatoepAggDO.getParentDO().setDt_pay(strDateTime);
			BlpaypatoepAggDO[] blpaypatoepAggDOArr = iBlpaypatoepCudService.save(new BlpaypatoepAggDO[] { blpaypatoepAggDO });
			iBlpaypatoepCudService.delete(red_BlpaypatoepAggDO);// 删除之前整体红冲的收付款
			// 重写红冲结算对应的收付款ID
			for (BlStOepDO blStOepDO : r_blStOepDOs1) {
				blStOepDO.setId_paypatoep(blpaypatoepAggDOArr[0].getParentDO().getId_paypatoep());
				blStOepDO.setStatus(DOStatus.UPDATED);
			}
			BlStOepDO[] r_blStOepDOs2 = iBlstoepCudService.save(r_blStOepDOs1);
			if (null == r_blStOepDOs2 || r_blStOepDOs2.length == 0) {
				throw new BizException("保存红冲门诊结算信息失败");
			}
			// 保存前台来的数据

			return null;
		}
		// 9.有重收的数据，则返回重收的记账信息
		if (new_BlCgItmOepDOList.size() > 0) {

			// 设置重收将要出现的票据号
			String code_pkg = "";
			// 得到票据包
			IBlincQryService iBlincQryService = ServiceFinder.find(IBlincQryService.class);
			code_pkg = iBlincQryService.getCodeIncPkgByIdempiss(operatorInfoDTO.getId_org(), operatorInfoDTO.getId_emp(), IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);

			GetBlCgItmOepMap blCgItmOepMapIns = new GetBlCgItmOepMap();
			BlCgItmOepMapDTO blCgItmOepMapDTO = blCgItmOepMapIns.BlCgItmOepConvertToMapIncPripats(new_BlCgItmOepDOList.toArray(new BlCgItmOepDO[] {}), operatorInfoDTO.getId_emp(),
					IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE, code_pkg);
			// 一次遍历获得:就诊，发票号1|就诊，发票号2|...|
			// 就诊=id_pat+" "+id_org+" "+id_ent+" "+id_enttp
			// new_BlCgOepDO.setEnt_invoiceno(blCgItmOepMapDTO.getEntAndno());
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
	 * 红冲票据：取医保计划，如果医保要求打印红冲票据（BD_HP.FG_SABINC =
	 * TRUE）并且红冲票据需要由HIS打印(BD_HP.EU_SABINCPRN = 0)，则生成红冲发票，并且移动票号；
	 * 否则，也生成红冲发票，但是incno,code_incpkg,dt_inc,id_emp_inc设为空，fg_print=false
	 * 
	 * @param id_ent
	 *            第一条记账信息对应的id_ent
	 * @param id_stoep
	 *            原票据对应的结算ID
	 * @param id_stoep_redback
	 *            原结算对应的红冲结算ID
	 * @param id_hp
	 *            医保计划
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
	private BlincoepAggDO[] redback_BlIncOep(String id_ent, String id_stoep, String id_stoep_redback, String id_hp, FBoolean AllRefundAndAllCharge, FDateTime strDateTime,
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

		// 查询患者的就诊对应医保计划下，是否需要打印红冲票
		BLCancelSettlementImplBp bLCancelSettlementImplBp = new BLCancelSettlementImplBp();
		FBoolean printRedInc = bLCancelSettlementImplBp.getFPrintRedInc(id_ent);

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
		// if (printRedInc.booleanValue())
		// { // 红冲发票，即红冲的发票也要打印出来

		// 保存发票信息：blincoepAggDO

		String code_incpkg = "";
		IBlincQryService iBlincQryService = ServiceFinder.find(IBlincQryService.class);
		IBLInvoiceService obj11 = ServiceFinder.find(IBLInvoiceService.class);
		String invoiceNo = "";
		if (printRedInc.booleanValue()) {
			invoiceNo = obj11.GetInvoiceNo(operatorInfoDTO.getId_emp(), IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE);
		}
		List<BlincoepAggDO> blincoepAggDOList = new ArrayList<BlincoepAggDO>();
		// for (int i = 0; i < r_blincoepAggDOs.length; i++) {
		// 由原始发票信息生成红冲发票信息
		BlincoepAggDO blincoepAggDO = r_blincoepAggDOs[0]; // 原发票信息
		BlIncOepDO blIncOepDO = r_blincoepAggDOs[0].getParentDO();
		blIncOepDO.setId_incoep(null);
		blIncOepDO.setId_grp(operatorInfoDTO.getId_grp());
		blIncOepDO.setId_org(operatorInfoDTO.getId_org());
		blIncOepDO.setEu_direct(BookRtnDirectEnum.REFUND);

		if (printRedInc.booleanValue()) { // 红冲票打印，才设置这些值，否则，不用设置
			blIncOepDO.setIncno(invoiceNo);
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
			// key=blIncOepDO.getId_pat();
			// }
			// else
			// {
			// key=blIncOepDO.getId_pat()+" "+blIncOepDO.getId_ent()+" "+blIncOepDO.getId_enttp();
			// }
			entAndno = entAndno + blIncOepDO.getId_pat() + "," + invoiceNo + "|";
			// //获得最大发票号
			// if(maxInvoiceno.compareTo(invoiceNo)<0)
			// {
			// maxInvoiceno=invoiceNo;
			// }
		}
		BlStIncOepDO[] blStIncOepDOs = r_blincoepAggDOs[0].getBlStIncOepDO();
		for (int j = 0; j < blStIncOepDOs.length; j++) {
			blStIncOepDOs[j].setId_incoep(null);
			blStIncOepDOs[j].setId_stoep(id_stoep_redback);
			blStIncOepDOs[j].setId_stincoep(null);
			blStIncOepDOs[j].setStatus(DOStatus.NEW);
		}
		BlIncCgItmOep[] blIncCgItmOeps = r_blincoepAggDOs[0].getBlIncCgItmOep();
		for (int k1 = 0; k1 < blIncCgItmOeps.length; k1++) {
			blIncCgItmOeps[k1].setId_inccgitmoep(null);
			blIncCgItmOeps[k1].setId_incoep(null);
			blIncCgItmOeps[k1].setId_cgitmoep(blCgItmOepDOArr[k1].getId_cgitmoep());
			blIncCgItmOeps[k1].setStatus(DOStatus.NEW);
		}

		BlIncItmOepDO[] red_BlIncItmOepDOs = r_blincoepAggDOs[0].getBlIncItmOepDO();
		for (BlIncItmOepDO blIncItmOepDO : red_BlIncItmOepDOs) {
			blIncItmOepDO.setId_incitmoep(null);
			blIncItmOepDO.setStatus(DOStatus.NEW);
		}

		blincoepAggDO.setParentDO(blIncOepDO);
		blincoepAggDO.setBlStIncOepDO(blStIncOepDOs);
		blincoepAggDO.setBlIncCgItmOep(blIncCgItmOeps);
		blincoepAggDO.setBlIncItmOepDO(red_BlIncItmOepDOs);
		blincoepAggDOList.add(blincoepAggDO);

		blincoepAggDOs = iBlincoepCudService.save(blincoepAggDOList.toArray(new BlincoepAggDO[] {}));
		if (null == blincoepAggDOs || blincoepAggDOs.length == 0) {
			throw new BizException("保存红冲门诊结算发票信息失败");
		}
		if (printRedInc.booleanValue()) {
			// 打印了红冲票，需要重设当前发票号
			// String curno=String.valueOf(Long.parseLong(maxInvoiceno)+1);
			String curno = computeNextInvoiceNo(invoiceNo);
			IBLInvoiceService iBLInvoiceService = ServiceFinder.find(IBLInvoiceService.class);

			iBLInvoiceService.SetCurNoByParamNo(operatorInfoDTO.getId_emp(), IBdInccaCodeConst.ID_OUTPATIENT_INVOICE, curno);
		}
		// }
		return blincoepAggDOs;
	}	
	/**
	 * 触发门诊退费事件
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


}
