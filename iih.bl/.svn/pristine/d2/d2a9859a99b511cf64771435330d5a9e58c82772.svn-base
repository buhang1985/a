package iih.bl.cg.service.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.service.i.IBdInccaQueService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.desc.BlCgItmOepDODesc;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendInpBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendOutpBillParamDTO;
import iih.bl.cg.bp.GetBlCgDO;
import iih.bl.cg.bp.ValidateParam;
import iih.bl.cg.dto.d.OpCancAcc4EsDTO;
import iih.bl.cg.event.OpCancAccEvent;
import iih.bl.cg.listener.qry.GetOpFund4IpEsDTOsByIdsQry;
import iih.bl.cg.service.d.BlOrderRefundBillParamDTO;
import iih.bl.cg.service.d.Bl_BatchAppendBillDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IPatAccServiceExt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊住院补费、退费业务逻辑
 * 
 * @author tcy
 * @since 2016-9-26
 *
 */
public class IBLOrderAppendBillServiceImplBp {

	// Bl_BatchAppendBillDTO

	/**
	 * 针对多病人（id_pat）特定就诊的医嘱补费接口，返回值为计费完整的DTO,数据库中生成多条主记录，多条明细记录
	 * 
	 * 备注： BlOrderAppendBillParamDTO
	 * 医嘱补费需要的参数数组，数组中每行id_pat,code_enttp,是否允许后计费,门诊必填数据或住院结账必填数据相同
	 * 
	 * @param isCiOrder
	 *            是否是医嘱记账，如果是true，则由本接口负责将医嘱转换成费用，其中，id_or必填；
	 *            否则(isCiOrder=false)
	 *            ，由调用方直接先将费用条目组装好(如果需要本接口计算费用，请将price设置为null)再传入本接口。
	 * @param Map
	 *            <String,List<BlOrderAppendBillParamDTO>>
	 *            <id_ent,id_ent下的List<BlOrderAppendBillParamDTO>>
	 * @param Map
	 *            <String,FDouble> <id_ent,id_ent下的sum(amt_ratio)>
	 * @param List
	 *            <String> 带更新的医嘱记账信息 list<id_orsrv>
	 * @param code_enttp
	 *            就诊类型代码
	 * @param isCiOrder
	 *            是否医嘱补费 返回值：补费成功后的DTO
	 * @throws BizException
	 */
	public Bl_BatchAppendBillDTO SetOrderAppendBill_MultiPat_Bp_new(Map<String, List<BlOrderAppendBillParamDTO>> identBlCgDTOMap, Map<String, FDouble> identSumAmtRatioMap, List<String> identLst, List<String> orsrvids_list, String code_enttp, boolean isCiOrder) throws BizException {
		ValidateParam validateParams = new ValidateParam();
		BlAppendOrRefundBillBP blAppendOrRefundBillBP = new BlAppendOrRefundBillBP();
		GetBlCgDO blCgIns = new GetBlCgDO();
		List<BlcgoepAggDO> blcgoepAggDOLst = new ArrayList<BlcgoepAggDO>();
		List<BlOrderAppendBillParamDTO> BlOrderAppendBillParamDTO_list_save = new ArrayList<BlOrderAppendBillParamDTO>();
		List<BlCgIpDO> blCgIpDOLst = new ArrayList<BlCgIpDO>();
		Map<String, FDouble> id_ent_acc_map = new HashMap<String, FDouble>();
		BlOrderAppendBillParamDTO[] tempDTOArr = null;
		FDouble prepayAmount = null; // 预交金余额
		FDouble sum_amt = null;
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();
		IPatAccServiceExt patAccImpls = (IPatAccServiceExt) ServiceFinder.find(IPatAccServiceExt.class);
		IEnOutQryService inpPatAccImpls = ServiceFinder.find(IEnOutQryService.class);
		IEnOutCmdService enAccService = ServiceFinder.find(IEnOutCmdService.class);
		String tip = "";
		Map<String, String> Fail_Ident_tip = new HashMap<String, String>();
		List<String> Succ_Ident = new ArrayList<String>();
		// 按就诊循环
		for (String id_ent : identLst) {
			Succ_Ident.add(id_ent);
			tempDTOArr = identBlCgDTOMap.get(id_ent).toArray(new BlOrderAppendBillParamDTO[0]);
			// 1.有效性校验
			tip = validateParams.ValidateParamForAppendBill_MultiPat_NotCiOrder_new(tempDTOArr, isCiOrder);
			if (tip.length() > 0) {
				Succ_Ident.remove(id_ent);
				Fail_Ident_tip.put(id_ent, tip);
				continue;
			}
			validateParams.validateFreezeAccAndAuditStatus(id_ent);
			// 2.账户扣费
			if (code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) || code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET) || code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_PE)) // 门诊记账
			{
				// 2.1 计算门诊账户余额：调用门诊账户接口,并修改授权标志和授权金额
				prepayAmount = patAccImpls.GetOutpPrepaymentAmount(tempDTOArr[0].getId_pat());
				// 与标准金额比较，当预交金余额不足时，需要进行示范允许后付费的判断
				if (prepayAmount.compareTo(sum_amt) < 0) {
					if (!tempDTOArr[0].getSupportAppendBill().booleanValue()) {
						tip = "门诊账户预交金余额不足,不支持后付费！\r\n本次执行金额：" + sum_amt.setScale(-2, BigDecimal.ROUND_HALF_UP).toString() + "\r\n差额：" + sum_amt.sub(prepayAmount).setScale(-2, BigDecimal.ROUND_HALF_UP).toString();
						Succ_Ident.remove(id_ent);
						Fail_Ident_tip.put(id_ent, tip);
						continue;
					} else // 支持后付费，不锁定预交金
					{
						// IF账户余额充足 THEN Y ELSE N
						for (BlOrderAppendBillParamDTO dto : tempDTOArr) {
							dto.getOutpBillDTO().setFg_acc(FBoolean.FALSE);
							dto.getOutpBillDTO().setAmt_acc(null);
							// dto.getOutpBillDTO().setFg_acc(FBoolean.TRUE);
							// dto.getOutpBillDTO().setAmt_acc(dto.getAmt_ratio());
						}
					}
				} else {
					// IF账户余额充足 THEN Y ELSE N
					for (BlOrderAppendBillParamDTO dto : tempDTOArr) {
						dto.getOutpBillDTO().setFg_acc(FBoolean.TRUE);
						dto.getOutpBillDTO().setAmt_acc(dto.getAmt_ratio());
					}
				}
				// 2.2 患者账户授权,更新预交金余额 ：调用门诊账户接口
				if (tempDTOArr[0].getOutpBillDTO() != null && tempDTOArr[0].getOutpBillDTO().getFg_acc().booleanValue()) {
					// 患者账户授权， 更新预交金余额 ：调用门诊账户接口
					PiPatAccDO piPatAccDO = patAccImpls.PatiAccPreAuthor(tempDTOArr[0].getId_pat(), sum_amt);
					if (null == piPatAccDO) {
						tip = "保存患者预交金信息失败";
						Succ_Ident.remove(id_ent);
						Fail_Ident_tip.put(id_ent, tip);
						continue;
						// throw new BizException("保存患者预交金信息失败");
					}
				}

				// 2.3 门诊记账，将DTO转换成BlcgoepAggDO
				BlcgoepAggDO blcgoepAggDO = new BlcgoepAggDO();
				blcgoepAggDO.setParentDO(blCgIns.GetBlCgOepDO(tempDTOArr[0], strDateTime));
				// 将DTO转换成BlcgoepAggDO：多条明细记录
				blcgoepAggDO.setBlCgItmOepDO(blCgIns.GetBlCgItmOepDOs(tempDTOArr, strDateTime, FBoolean.FALSE)); // 补费，非挂起状态
				blcgoepAggDOLst.add(blcgoepAggDO);

			} else// 住院记账
			{
				// 2.1 计算住院账户余额：调用住院账户接口
				BalanceDTO balanceDTO = inpPatAccImpls.getBalanceDTO(id_ent);
				prepayAmount = balanceDTO.getAvailable();
				sum_amt = identSumAmtRatioMap.get(id_ent);
				// 与标准金额比较，当预交金余额不足时，需要进行是否允许后付费的判断
				if (prepayAmount.compareTo(sum_amt) < 0) {
					if (!tempDTOArr[0].getSupportAppendBill().booleanValue()) {
						tip = "住院预交金余额不足，不支持后付费！\r\n本次执行金额：" + sum_amt.setScale(-2, BigDecimal.ROUND_HALF_UP).toString() + "\r\n差额：" + sum_amt.sub(prepayAmount).setScale(-2, BigDecimal.ROUND_HALF_UP).toString();
						Succ_Ident.remove(id_ent);
						Fail_Ident_tip.put(id_ent, tip);
						continue;
					}
				}
				// 2.2 即将批量处理的消费金额
				id_ent_acc_map.put(id_ent, sum_amt);
				// enAccService.consume(tempDTOArr[0].getId_ent(), sum_amt);

				// 2.3 住院记账，转变成BlCgIpDO
				BlCgIpDO[] blCgIpDOs = blCgIns.GetBlCgIpDOs(tempDTOArr, strDateTime);
				BlCgIpDO[] blcgqueryAggDOArr = new BlCgIpDO[blCgIpDOs.length];
				for (int k = 0; k < blCgIpDOs.length; k++) {
					BlCgIpDO blcgqueryAggDO = new BlCgIpDO();
					//blcgqueryAggDO.setParentDO(blCgIpDOs[k]);
					blcgqueryAggDOArr[k] = blcgqueryAggDO;
					blCgIpDOLst.add(blCgIpDOs[k]);
				}
			}
		}

		// 3.写入门诊记账表，与写入住院记账表互斥
		if (blcgoepAggDOLst != null && blcgoepAggDOLst.size() > 0) {
			// 3.1存入住院记账表
			IBlcgoepCudService iBlcgoepCudService = ServiceFinder.find(IBlcgoepCudService.class);
			BlcgoepAggDO[] blcgoepAggDOs = iBlcgoepCudService.save(blcgoepAggDOLst.toArray(new BlcgoepAggDO[0]));
			if (null == blcgoepAggDOs || blcgoepAggDOs.length == 0) {
				throw new BizException("保存门诊记账信息失败");

			}
			// 3.2 返回门诊结果
			BlOrderAppendBillParamDTO_list_save = blAppendOrRefundBillBP.getBlOrderAppendBillParamDTOFromCgOep(blcgoepAggDOs);
		}

		// 3. 写入住院记账表，与写入门诊记账表互斥
		if (blCgIpDOLst != null && blCgIpDOLst.size() > 0) {
			// 存入住院记账表
			IBlcgqueryCudService iBlcgqueryMDOCudService = ServiceFinder.find(IBlcgqueryCudService.class);
			BlCgIpDO[] blCgIpDOArr = iBlcgqueryMDOCudService.save(blCgIpDOLst.toArray(new BlCgIpDO[0]));
			if (null == blCgIpDOArr || blCgIpDOArr.length == 0) {
				throw new BizException("保存住院记账信息失败");
			}
			// 3.2 返回住院结果
			BlOrderAppendBillParamDTO_list_save = blAppendOrRefundBillBP.getBlOrderAppendBillParamDTOFromCgIpItms(blCgIpDOArr);
		}

		// 4.批量修改预交金消费额度
		if (id_ent_acc_map != null && id_ent_acc_map.size() > 0) {
			enAccService.batchConsume(id_ent_acc_map);
		}

		// 5 更新医嘱记账信息
		if (orsrvids_list != null && orsrvids_list.size() > 0) {
			ICiOrdMaintainService obj2X = ServiceFinder.find(ICiOrdMaintainService.class);
			FBoolean updateCiOrder = obj2X.UpdateOrdChargeRelInfo2(orsrvids_list.toArray(new String[] {}), ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID, ICiDictCodeConst.SD_SU_BL_ACCOUNT, new FDateTime(strDateTime), FeeReverseType.NOBLCANCEL);
		}
		Bl_BatchAppendBillDTO bl_BatchAppendBillDTO = new Bl_BatchAppendBillDTO();
		FArrayList2 flist2 = new FArrayList2();
		for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : BlOrderAppendBillParamDTO_list_save) {
			flist2.add(blOrderAppendBillParamDTO);
		}
		bl_BatchAppendBillDTO.setBlOrderAppendBillParamDTO(flist2);
		bl_BatchAppendBillDTO.setFail_Ident_tip(Fail_Ident_tip);
		bl_BatchAppendBillDTO.setSucc_Ident(Succ_Ident);

		return bl_BatchAppendBillDTO;
	}

	/**
	 * 针对多病人（id_pat）特定就诊的医嘱补费接口，返回值为计费完整的DTO,数据库中生成多条主记录，多条明细记录
	 * 
	 * 备注： BlOrderAppendBillParamDTO
	 * 医嘱补费需要的参数数组，数组中每行id_pat,code_enttp,是否允许后计费,门诊必填数据或住院结账必填数据相同
	 * 
	 * @param isCiOrder
	 *            是否是医嘱记账，如果是true，则由本接口负责将医嘱转换成费用，其中，id_or必填；
	 *            否则(isCiOrder=false)
	 *            ，由调用方直接先将费用条目组装好(如果需要本接口计算费用，请将price设置为null)再传入本接口。
	 * @param Map
	 *            <String,List<BlOrderAppendBillParamDTO>>
	 *            <id_ent,id_ent下的List<BlOrderAppendBillParamDTO>>
	 * @param Map
	 *            <String,FDouble> <id_ent,id_ent下的sum(amt_ratio)>
	 * @param List
	 *            <String> 带更新的医嘱记账信息 list<id_orsrv>
	 * @param code_enttp
	 *            就诊类型代码
	 * @param isCiOrder
	 *            是否医嘱补费 返回值：补费成功后的DTO
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] SetOrderAppendBill_MultiPat_Bp(Map<String, List<BlOrderAppendBillParamDTO>> identBlCgDTOMap, Map<String, FDouble> identSumAmtRatioMap, List<String> identLst, List<String> orsrvids_list, String code_enttp, boolean isCiOrder) throws BizException {
		ValidateParam validateParams = new ValidateParam();
		BlAppendOrRefundBillBP blAppendOrRefundBillBP = new BlAppendOrRefundBillBP();
		GetBlCgDO blCgIns = new GetBlCgDO();
		List<BlcgoepAggDO> blcgoepAggDOLst = new ArrayList<BlcgoepAggDO>();
		List<BlOrderAppendBillParamDTO> BlOrderAppendBillParamDTO_list_save = new ArrayList<BlOrderAppendBillParamDTO>();
		List<BlCgIpDO> blCgIpDOLst = new ArrayList<BlCgIpDO>();
		Map<String, FDouble> id_ent_acc_map = new HashMap<String, FDouble>();
		BlOrderAppendBillParamDTO[] tempDTOArr = null;
		FDouble prepayAmount = null; // 预交金余额
		FDouble sum_amt = null;
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();
		IPatAccServiceExt patAccImpls = (IPatAccServiceExt) ServiceFinder.find(IPatAccServiceExt.class);
		IEnOutQryService inpPatAccImpls = ServiceFinder.find(IEnOutQryService.class);
		IEnOutCmdService enAccService = ServiceFinder.find(IEnOutCmdService.class);

		// 按就诊循环
		for (String id_ent : identLst) {
			tempDTOArr = identBlCgDTOMap.get(id_ent).toArray(new BlOrderAppendBillParamDTO[0]);
			// 1.有效性校验
			if (!validateParams.ValidateParamForAppendBill_MultiPat_NotCiOrder(tempDTOArr, isCiOrder)) {
				return null;
			}
			if (!(code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) || code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET) || code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_PE))) // 只有住院检查是否封账
			{
				validateParams.validateFreezeAccAndAuditStatus(id_ent);
			}
			// 2.账户扣费
			if (code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) || code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET) || code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_PE)) // 门诊记账
			{
				// 2.1 计算门诊账户余额：调用门诊账户接口,并修改授权标志和授权金额
				prepayAmount = patAccImpls.GetOutpPrepaymentAmount(tempDTOArr[0].getId_pat());
				// 与标准金额比较，当预交金余额不足时，需要进行示范允许后付费的判断
				if (prepayAmount.compareTo(sum_amt) < 0) {
					if (!tempDTOArr[0].getSupportAppendBill().booleanValue()) {
						throw new BizException("门诊账户预交金余额不足,不支持后付费！\r\n本次执行金额：" + sum_amt.setScale(-2, BigDecimal.ROUND_HALF_UP).toString() + "\r\n差额：" + sum_amt.sub(prepayAmount).setScale(-2, BigDecimal.ROUND_HALF_UP).toString());
					} else // 支持后付费，不锁定预交金
					{
						// IF账户余额充足 THEN Y ELSE N
						for (BlOrderAppendBillParamDTO dto : tempDTOArr) {
							dto.getOutpBillDTO().setFg_acc(FBoolean.FALSE);
							dto.getOutpBillDTO().setAmt_acc(null);
							// dto.getOutpBillDTO().setFg_acc(FBoolean.TRUE);
							// dto.getOutpBillDTO().setAmt_acc(dto.getAmt_ratio());
						}
					}
				} else {
					// IF账户余额充足 THEN Y ELSE N
					for (BlOrderAppendBillParamDTO dto : tempDTOArr) {
						dto.getOutpBillDTO().setFg_acc(FBoolean.TRUE);
						dto.getOutpBillDTO().setAmt_acc(dto.getAmt_ratio());
					}
				}
				// 2.2 患者账户授权,更新预交金余额 ：调用门诊账户接口
				if (tempDTOArr[0].getOutpBillDTO() != null && tempDTOArr[0].getOutpBillDTO().getFg_acc().booleanValue()) {
					// 患者账户授权， 更新预交金余额 ：调用门诊账户接口
					PiPatAccDO piPatAccDO = patAccImpls.PatiAccPreAuthor(tempDTOArr[0].getId_pat(), sum_amt);
					if (null == piPatAccDO) {
						throw new BizException("保存患者预交金信息失败");
					}
				}

				// 2.3 门诊记账，将DTO转换成BlcgoepAggDO
				BlcgoepAggDO blcgoepAggDO = new BlcgoepAggDO();
				blcgoepAggDO.setParentDO(blCgIns.GetBlCgOepDO(tempDTOArr[0], strDateTime));
				// 将DTO转换成BlcgoepAggDO：多条明细记录
				blcgoepAggDO.setBlCgItmOepDO(blCgIns.GetBlCgItmOepDOs(tempDTOArr, strDateTime, FBoolean.FALSE)); // 补费，非挂起状态
				blcgoepAggDOLst.add(blcgoepAggDO);

			} else// 住院记账
			{
				// 2.1 计算住院账户余额：调用住院账户接口
				BalanceDTO balanceDTO = inpPatAccImpls.getBalanceDTO(id_ent);
				prepayAmount = balanceDTO.getAvailable();
				sum_amt = identSumAmtRatioMap.get(id_ent);
				// 与标准金额比较，当预交金余额不足时，需要进行是否允许后付费的判断
				if (prepayAmount.compareTo(sum_amt) < 0) {
					if (!tempDTOArr[0].getSupportAppendBill().booleanValue()) {
						throw new BizException("住院预交金余额不足，不支持后付费！\r\n本次执行金额：" + sum_amt.setScale(-2, BigDecimal.ROUND_HALF_UP).toString() + "\r\n差额：" + sum_amt.sub(prepayAmount).setScale(-2, BigDecimal.ROUND_HALF_UP).toString());
					}
				}
				// 2.2 即将批量处理的消费金额
				id_ent_acc_map.put(id_ent, sum_amt);
				// enAccService.consume(tempDTOArr[0].getId_ent(), sum_amt);

				// 2.3 住院记账，转变成BlCgIpDO
				BlCgIpDO[] blCgIpDOs = blCgIns.GetBlCgIpDOs(tempDTOArr, strDateTime);
				BlCgIpDO[] blcgqueryAggDOArr = new BlCgIpDO[blCgIpDOs.length];
				for (int k = 0; k < blCgIpDOs.length; k++) {
					BlCgIpDO blcgqueryAggDO = new BlCgIpDO();
					//blcgqueryAggDO.setParentDO(blCgIpDOs[k]);
					blcgqueryAggDOArr[k] = blcgqueryAggDO;
					blCgIpDOLst.add(blCgIpDOs[k]);
				}
			}
		}

		// 3.写入门诊记账表，与写入住院记账表互斥
		if (blcgoepAggDOLst != null && blcgoepAggDOLst.size() > 0) {
			// 3.1存入住院记账表
			IBlcgoepCudService iBlcgoepCudService = ServiceFinder.find(IBlcgoepCudService.class);
			BlcgoepAggDO[] blcgoepAggDOs = iBlcgoepCudService.save(blcgoepAggDOLst.toArray(new BlcgoepAggDO[0]));
			if (null == blcgoepAggDOs || blcgoepAggDOs.length == 0) {
				throw new BizException("保存门诊记账信息失败");
			}
			// 3.2 返回门诊结果
			BlOrderAppendBillParamDTO_list_save = blAppendOrRefundBillBP.getBlOrderAppendBillParamDTOFromCgOep(blcgoepAggDOs);
		}

		// 3. 写入住院记账表，与写入门诊记账表互斥
		if (blCgIpDOLst != null && blCgIpDOLst.size() > 0) {
			// 存入住院记账表
			IBlcgqueryCudService iBlcgqueryMDOCudService = ServiceFinder.find(IBlcgqueryCudService.class);
			BlCgIpDO[] blCgIpDOArr = iBlcgqueryMDOCudService.save(blCgIpDOLst.toArray(new BlCgIpDO[0]));
			if (null == blCgIpDOArr || blCgIpDOArr.length == 0) {
				throw new BizException("保存住院记账信息失败");
			}
			// 3.2 返回住院结果
			BlOrderAppendBillParamDTO_list_save = blAppendOrRefundBillBP.getBlOrderAppendBillParamDTOFromCgIpItms(blCgIpDOArr);
		}

		// 4.批量修改预交金消费额度
		if (id_ent_acc_map != null && id_ent_acc_map.size() > 0) {
			enAccService.batchConsume(id_ent_acc_map);
		}

		// 5 更新医嘱记账信息
		if (orsrvids_list != null && orsrvids_list.size() > 0) {
			ICiOrdMaintainService obj2X = ServiceFinder.find(ICiOrdMaintainService.class);
			FBoolean updateCiOrder = obj2X.UpdateOrdChargeRelInfo2(orsrvids_list.toArray(new String[] {}), ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID, ICiDictCodeConst.SD_SU_BL_ACCOUNT, new FDateTime(strDateTime), FeeReverseType.NOBLCANCEL);
		}

		return BlOrderAppendBillParamDTO_list_save.toArray(new BlOrderAppendBillParamDTO[] {});
	}

	/**
	 * 门诊补费： 针对同一病人（id_pat）特定就诊的医嘱补费接口，返回值为计费完整的DTO,数据库中生成一条主记录，多条明细记录
	 * 
	 * @param appendBillParamDTO
	 *            医嘱补费需要的参数数组，数组中每行id_pat,code_enttp,是否允许后计费,门诊必填数据或住院结账必填数据相同
	 * @param isCiOrder
	 *            是否是医嘱记账，如果是true，则由本接口负责将医嘱转换成费用，其中，id_or必填；
	 *            否则(isCiOrder=false)
	 *            ，由调用方直接先将费用条目组装好(如果需要本接口计算费用，请将price设置为null)再传入本接口。
	 *            返回值：补费成功后的DTO
	 * @throws BizException
	 */
	private BlOrderAppendBillParamDTO[] SetOrderAppendBill_Oep(BlOrderAppendBillParamDTO[] appendBillParamDTO1, boolean isCiOrder) throws BizException {
		// 0.有效性校验
		ValidateParam validateParams = new ValidateParam();
		if (!validateParams.ValidateParamForAppendBill(appendBillParamDTO1, isCiOrder)) {
			return null;
		}
		BlAppendOrRefundBillBP blAppendOrRefundBillBP = new BlAppendOrRefundBillBP();
		FDouble sum_amt_ratio = new FDouble(0);
		List<BlOrderAppendBillParamDTO> BlOrderAppendBillParamDTO_list_save = new ArrayList<BlOrderAppendBillParamDTO>();
		List<String> orsrvids_list = new ArrayList<String>();
		List<BlOrderAppendBillParamDTO> blOrderAppendBillParamDTOlist_new = new ArrayList<BlOrderAppendBillParamDTO>();

		// 1.获得记账明细
		if (isCiOrder) // 医嘱记账
		{
			// 1.1转换成记账的DTO
			blOrderAppendBillParamDTOlist_new = blAppendOrRefundBillBP.getBlOrderAppendBillParamDTOArr_CiOrder(appendBillParamDTO1);
		} else // 后台记账计算钱钱，非医嘱
		{
			// 1.1换行成记账的DTO
			blOrderAppendBillParamDTOlist_new = blAppendOrRefundBillBP.getBlOrderAppendBillParamDTOArr_Itms(appendBillParamDTO1);
		}

		// 2.计算账户消费金额，记录已记账的医嘱序号
		for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : blOrderAppendBillParamDTOlist_new) {

			// 判断如果数据为手工记账则将金额赋值到对应的金额字段
			if ("1".equals(blOrderAppendBillParamDTO.getEu_blmd())) {
				blOrderAppendBillParamDTO.setPrice(blOrderAppendBillParamDTO.getPri());
				blOrderAppendBillParamDTO.setPrice_ratio(blOrderAppendBillParamDTO.getPri().multiply(blOrderAppendBillParamDTO.getPri_ratio()).setScale(-4, BigDecimal.ROUND_HALF_UP));
				blOrderAppendBillParamDTO.setAmt(blOrderAppendBillParamDTO.getPri().multiply(blOrderAppendBillParamDTO.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				blOrderAppendBillParamDTO.setAmt_ratio(blOrderAppendBillParamDTO.getPrice_ratio().multiply(blOrderAppendBillParamDTO.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				blOrderAppendBillParamDTO.setAmt_std(blOrderAppendBillParamDTO.getPri().multiply(blOrderAppendBillParamDTO.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				blOrderAppendBillParamDTO.setAmt_hp(new FDouble(0));
				blOrderAppendBillParamDTO.setAmt_pat(blOrderAppendBillParamDTO.getAmt_ratio());
				blOrderAppendBillParamDTO.setRatio_pripat(blOrderAppendBillParamDTO.getPri_ratio());
				if (blOrderAppendBillParamDTO.getOutpBillDTO() != null) {
					if (blOrderAppendBillParamDTO.getOutpBillDTO().getFg_acc() != null && blOrderAppendBillParamDTO.getOutpBillDTO().getFg_acc().booleanValue()) {
						BlOrderAppendOutpBillParamDTO outpBillDTO = blOrderAppendBillParamDTO.getOutpBillDTO();
						outpBillDTO.setAmt_acc(blOrderAppendBillParamDTO.getPrice_ratio().multiply(blOrderAppendBillParamDTO.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP)); // 不考虑医保前提下，amt与amt_ratio相等
						blOrderAppendBillParamDTO.setOutpBillDTO(outpBillDTO);
					}
				}
				
			}
			
			if(!FBoolean.TRUE.equals(blOrderAppendBillParamDTO.getFg_zeroreg())){//添加零挂判断 ly 2018/08/27
				// 2.1 检查价格：4位小数，且不为0，amt为2位小数
				if (blOrderAppendBillParamDTO.getPrice_ratio().compareTo(new FDouble(0)) == 0) {
					throw new BizException("参与计价的明细价格应大于0，项目：" + blOrderAppendBillParamDTO.getName_srv());
				}
				if (blOrderAppendBillParamDTO.getAmt().compareTo(new FDouble(0)) < 0) {
					throw new BizException("参与计价的明细金额应大于0，项目：" + blOrderAppendBillParamDTO.getName_srv());
				}
			}
			blOrderAppendBillParamDTO.setFg_susp(FBoolean.FALSE);// 补费的数据未挂起
			if (blOrderAppendBillParamDTO.getFg_additm() == null) {
				blOrderAppendBillParamDTO.setFg_additm(FBoolean.FALSE);// 非补录的数据，商保记账或预交金记账
			}
			
			blOrderAppendBillParamDTO.setFg_hp(FBoolean.FALSE);// 记账上传医保标志
			blOrderAppendBillParamDTO.setFg_pricinginsertcg(FBoolean.FALSE);
			blOrderAppendBillParamDTO.setAmt(blOrderAppendBillParamDTO.getAmt().setScale(-2, BigDecimal.ROUND_HALF_UP));
			blOrderAppendBillParamDTO.setAmt_std(blOrderAppendBillParamDTO.getAmt_std().setScale(-2, BigDecimal.ROUND_HALF_UP));
			blOrderAppendBillParamDTO.setAmt_hp(blOrderAppendBillParamDTO.getAmt_hp().setScale(-2, BigDecimal.ROUND_HALF_UP));
			blOrderAppendBillParamDTO.setAmt_pat(blOrderAppendBillParamDTO.getAmt_pat().setScale(-2, BigDecimal.ROUND_HALF_UP));
			if (blOrderAppendBillParamDTO.getAmt_ratio() == null || blOrderAppendBillParamDTO.getAmt_ratio().toString().trim().length() == 0) {
				blOrderAppendBillParamDTO.setAmt_ratio(blOrderAppendBillParamDTO.getAmt());
			} else {
				blOrderAppendBillParamDTO.setAmt_ratio(blOrderAppendBillParamDTO.getAmt_ratio().setScale(-2, BigDecimal.ROUND_HALF_UP));
			}
			// 增加了折扣价格
			if (blOrderAppendBillParamDTO.getPrice_ratio() == null || blOrderAppendBillParamDTO.getPrice_ratio().toString().trim().length() == 0) {
				blOrderAppendBillParamDTO.setPrice_ratio(blOrderAppendBillParamDTO.getPrice().multiply(blOrderAppendBillParamDTO.getRatio_pripat()).setScale(-4, BigDecimal.ROUND_HALF_UP));
			}
			// 2.2 计算账户消费金额
			if (blOrderAppendBillParamDTO.getOutpBillDTO() != null && blOrderAppendBillParamDTO.getOutpBillDTO().getFg_acc() != null && blOrderAppendBillParamDTO.getOutpBillDTO().getFg_acc().booleanValue()) {
				// 门诊补费
				sum_amt_ratio = sum_amt_ratio.add(blOrderAppendBillParamDTO.getOutpBillDTO().getAmt_acc().multiply(blOrderAppendBillParamDTO.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			} else {
				// 住院补费
				sum_amt_ratio = sum_amt_ratio.add(blOrderAppendBillParamDTO.getAmt_ratio().multiply(blOrderAppendBillParamDTO.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			}
			// 2.3 记录已记账的医嘱序号
			if (blOrderAppendBillParamDTO.getId_orsrv() != null && !orsrvids_list.contains(blOrderAppendBillParamDTO.getId_orsrv())) {
				orsrvids_list.add(blOrderAppendBillParamDTO.getId_orsrv());
			}
			if (blOrderAppendBillParamDTO.getCode_inccaitm() == null) {
				// 完善账单码
				/*IncCaItmDO incCaItmDO = getInccaitmCodeAndName(blOrderAppendBillParamDTO.getCode_enttp(), blOrderAppendBillParamDTO.getId_srv());
				if (incCaItmDO != null) {
					blOrderAppendBillParamDTO.setName_inccaitm(incCaItmDO.getName());
					blOrderAppendBillParamDTO.setCode_inccaitm(incCaItmDO.getCode());
				}*/
			}
		}

		// 3.写记账表，修改账户消费额度
		BlOrderAppendBillParamDTO[] appendBillParamDTO = blOrderAppendBillParamDTOlist_new.toArray(new BlOrderAppendBillParamDTO[] {});

		// doInBlcgOep_hpcg
		BlcgoepAggDO[] blcgoepAggDOs = null;
		if (appendBillParamDTO[0].getOutpBillDTO() != null && appendBillParamDTO[0].getOutpBillDTO().getFg_hpcg() != null && appendBillParamDTO[0].getOutpBillDTO().getFg_hpcg().booleanValue()) {
			// 3.1 采用医保计划记账
			blcgoepAggDOs = blAppendOrRefundBillBP.doInBlcgOep_hpcg(appendBillParamDTO);
		} else {
			// 3.1 存入门诊记账表,修改账户消费额度
			blcgoepAggDOs = blAppendOrRefundBillBP.doInBlcgOepAndUpdateEntAcc(appendBillParamDTO, sum_amt_ratio);
		}
		// 3.2返回门诊记账结果
		BlOrderAppendBillParamDTO_list_save = blAppendOrRefundBillBP.getBlOrderAppendBillParamDTOFromCgOep(blcgoepAggDOs);

		// 4 更新医嘱记账信息
		if (orsrvids_list != null && orsrvids_list.size() > 0) {
			ICiOrdMaintainService obj2X = ServiceFinder.find(ICiOrdMaintainService.class);
			FBoolean updateCiOrder = obj2X.UpdateOrdChargeRelInfo2(orsrvids_list.toArray(new String[] {}), ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID, ICiDictCodeConst.SD_SU_BL_ACCOUNT, appendBillParamDTO[0].getDt_last_bl(), FeeReverseType.NOBLCANCEL);
		}

		return BlOrderAppendBillParamDTO_list_save.toArray(new BlOrderAppendBillParamDTO[] {});
	}

	/**
	 * 住院补费： 针对同一病人（id_pat）特定就诊的医嘱补费接口，返回值为计费完整的DTO,数据库中生成一条主记录，多条明细记录
	 * 
	 * @param appendBillParamDTO
	 *            医嘱补费需要的参数数组，数组中每行id_pat,code_enttp,是否允许后计费,门诊必填数据或住院结账必填数据相同
	 * @param isCiOrder
	 *            是否是医嘱记账，如果是true，则由本接口负责将医嘱转换成费用，其中，id_or必填；
	 *            否则(isCiOrder=false)
	 *            ，由调用方直接先将费用条目组装好(如果需要本接口计算费用，请将price设置为null)再传入本接口。
	 *            返回值：补费成功后的DTO
	 * @throws BizException
	 */
	private BlOrderAppendBillParamDTO[] SetOrderAppendBill_Ip(BlOrderAppendBillParamDTO[] appendBillParamDTO1, boolean isCiOrder) throws BizException {
		
		throw new BizException("记账失败，请调用新接口");
		
		/*// 0.有效性校验
		ValidateParam validateParams = new ValidateParam();
		FDateTime times = AppUtils.getServerDateTime();
		if (!validateParams.ValidateParamForAppendBill(appendBillParamDTO1, isCiOrder)) {
			return null;
		}
		FDateTime timed = AppUtils.getServerDateTime();
		// long interval = timed.getMillisAfter(times);
		BlAppendOrRefundBillBP blAppendOrRefundBillBP = new BlAppendOrRefundBillBP();
		FDouble sum_amt_ratio = new FDouble(0);
		List<BlOrderAppendBillParamDTO> BlOrderAppendBillParamDTO_list_save = new ArrayList<BlOrderAppendBillParamDTO>();
		List<String> orsrvids_list = new ArrayList<String>();
		List<BlOrderAppendBillParamDTO> blOrderAppendBillParamDTOlist_new = new ArrayList<BlOrderAppendBillParamDTO>();

		// 判断是否封账和是否在审核结算流程中
		validateParams.validateFreezeAccAndAuditStatus(appendBillParamDTO1[0].getId_ent());

		// 1.获得记账明细
		if (isCiOrder) // 医嘱记账
		{
			// 1.1转换成记账的DTO
			List<BlOrderAppendBillParamDTO> tmpAppendBillParamDTOs = blAppendOrRefundBillBP.getBlOrderAppendBillParamDTOArr_CiOrder(appendBillParamDTO1);
			// 对于医嘱记账时 补费标志为N，重构时可以考虑将此字段移到函数里进行赋值 By liwq 2017年7月6日19:29:19
			for (BlOrderAppendBillParamDTO appendDto : tmpAppendBillParamDTOs) {
				appendDto.setFg_additm(FBoolean.FALSE);
				blOrderAppendBillParamDTOlist_new.add(appendDto);
			}
		} else // 后台记账计算钱钱，非医嘱
		{
			// 1.1换行成记账的DTO
			List<BlOrderAppendBillParamDTO> tmpAppendBillParamDTOs = blAppendOrRefundBillBP.getBlOrderAppendBillParamDTOArr_Itms(appendBillParamDTO1);
			// 对于医嘱记账时 补费标志为N，重构时可以考虑将此字段移到函数里进行赋值 By liwq 2017年7月6日19:29:19
			for (BlOrderAppendBillParamDTO appendDto : tmpAppendBillParamDTOs) {
				appendDto.setFg_additm(FBoolean.TRUE);
				blOrderAppendBillParamDTOlist_new.add(appendDto);
			}
		}

		// 2.计算账户消费金额，记录已记账的医嘱序号
		for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : blOrderAppendBillParamDTOlist_new) {
			// 2.1 检查价格：4位小数，且不为0，amt为2位小数
			if (blOrderAppendBillParamDTO.getPrice().compareTo(new FDouble(0)) == 0) {
				throw new BizException("参与计价的明细价格应大于0，项目：" + blOrderAppendBillParamDTO.getName_srv());
			}
			if (blOrderAppendBillParamDTO.getAmt().compareTo(new FDouble(0)) < 0) {
				throw new BizException("参与计价的明细金额应大于0，项目：" + blOrderAppendBillParamDTO.getName_srv());
			}
			// 补费的数据未挂起
			blOrderAppendBillParamDTO.setFg_susp(FBoolean.FALSE);

			// 记账上传医保标志
			blOrderAppendBillParamDTO.setFg_hp(FBoolean.FALSE);
			blOrderAppendBillParamDTO.setFg_pricinginsertcg(FBoolean.FALSE);
			blOrderAppendBillParamDTO.setAmt(blOrderAppendBillParamDTO.getAmt().setScale(-2, BigDecimal.ROUND_HALF_UP));
			blOrderAppendBillParamDTO.setAmt_std(blOrderAppendBillParamDTO.getAmt_std().setScale(-2, BigDecimal.ROUND_HALF_UP));
			blOrderAppendBillParamDTO.setAmt_hp(blOrderAppendBillParamDTO.getAmt_hp().setScale(-2, BigDecimal.ROUND_HALF_UP));
			blOrderAppendBillParamDTO.setAmt_pat(blOrderAppendBillParamDTO.getAmt_pat().setScale(-2, BigDecimal.ROUND_HALF_UP));
			if (blOrderAppendBillParamDTO.getAmt_ratio() == null || blOrderAppendBillParamDTO.getAmt_ratio().toString().trim().length() == 0) {
				blOrderAppendBillParamDTO.setAmt_ratio(blOrderAppendBillParamDTO.getAmt());
			} else {
				blOrderAppendBillParamDTO.setAmt_ratio(blOrderAppendBillParamDTO.getAmt_ratio().setScale(-2, BigDecimal.ROUND_HALF_UP));
			}
			// 增加了折扣价格
			if (blOrderAppendBillParamDTO.getPrice_ratio() == null || blOrderAppendBillParamDTO.getPrice_ratio().toString().trim().length() == 0) {
				blOrderAppendBillParamDTO.setPrice_ratio(blOrderAppendBillParamDTO.getPrice());
			}
			// 2.2 计算账户消费金额
			// if(blOrderAppendBillParamDTO.getOutpBillDTO()!=null &&
			// blOrderAppendBillParamDTO.getOutpBillDTO().getFg_acc()!=null &&
			// blOrderAppendBillParamDTO.getOutpBillDTO().getFg_acc().booleanValue())
			// {
			// //门诊补费
			// sum_amt_ratio =
			// sum_amt_ratio.add(blOrderAppendBillParamDTO.getOutpBillDTO().getAmt_acc().multiply(blOrderAppendBillParamDTO.getEu_direct()).setScale(-2,
			// BigDecimal.ROUND_HALF_UP));
			// }
			// else
			// {
			// 住院补费
			sum_amt_ratio = sum_amt_ratio.add(blOrderAppendBillParamDTO.getAmt_ratio().multiply(blOrderAppendBillParamDTO.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			// }
			// 2.3 记录已记账的医嘱序号
			if (blOrderAppendBillParamDTO.getId_orsrv() != null && !orsrvids_list.contains(blOrderAppendBillParamDTO.getId_orsrv())) {
				orsrvids_list.add(blOrderAppendBillParamDTO.getId_orsrv());
			}

			blOrderAppendBillParamDTO.setSupportAppendBill(FBoolean.TRUE); // 住院允许后付费

			if (blOrderAppendBillParamDTO.getCode_inccaitm() == null) {
				// 完善账单码
				IncCaItmDO incCaItmDO = getInccaitmCodeAndName(blOrderAppendBillParamDTO.getCode_enttp(), blOrderAppendBillParamDTO.getId_srv());
				if (incCaItmDO != null) {
					blOrderAppendBillParamDTO.setName_inccaitm(incCaItmDO.getName());
					blOrderAppendBillParamDTO.setCode_inccaitm(incCaItmDO.getCode());
				}
			}
		}

		// 3.写记账表，修改账户消费额度
		BlOrderAppendBillParamDTO[] appendBillParamDTO = blOrderAppendBillParamDTOlist_new.toArray(new BlOrderAppendBillParamDTO[] {});

		// 3.1 存入住院记账表,修改账户消费额度
		BlCgIpDO[] blcgqueryAggDOs = blAppendOrRefundBillBP.doInBlcgIpAndUpdateEntAcc(appendBillParamDTO, sum_amt_ratio);

		// 3.2返回住院结果
		BlOrderAppendBillParamDTO_list_save = blAppendOrRefundBillBP.getBlOrderAppendBillParamDTOFromCgIp(blcgqueryAggDOs);

		// 4 更新医嘱记账信息
		if (orsrvids_list != null && orsrvids_list.size() > 0) {
			ICiOrdMaintainService obj2X = ServiceFinder.find(ICiOrdMaintainService.class);
			FBoolean updateCiOrder = obj2X.UpdateOrdChargeRelInfo2(orsrvids_list.toArray(new String[] {}), ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID, ICiDictCodeConst.SD_SU_BL_ACCOUNT, appendBillParamDTO[0].getDt_last_bl(), FeeReverseType.NOBLCANCEL);
		}

		return BlOrderAppendBillParamDTO_list_save.toArray(new BlOrderAppendBillParamDTO[] {});*/
	}

	/**
	 * 根据就诊类型和ID_srv，查询对应的账单项
	 * 
	 * @param code_enttp
	 *            就诊类型代码
	 * @param id_srv
	 *            服务ID
	 * @return 对应的账单项
	 * @throws BizException
	 */
	private IncCaItmDO getInccaitmCodeAndName(String code_enttp, String id_srv) throws BizException {
		IBdInccaQueService iBdInccaQueService = ServiceFinder.find(IBdInccaQueService.class);
		return iBdInccaQueService.getInccaitmCodeAndName(code_enttp, id_srv);
	}

	/**
	 * 针对同一病人（id_pat）特定就诊的医嘱补费接口，返回值为计费完整的DTO,数据库中生成一条主记录，多条明细记录
	 * 
	 * @param appendBillParamDTO
	 *            医嘱补费需要的参数数组，数组中每行id_pat,code_enttp,是否允许后计费,门诊必填数据或住院结账必填数据相同
	 * @param isCiOrder
	 *            是否是医嘱记账，如果是true，则由本接口负责将医嘱转换成费用，其中，id_or必填；
	 *            否则(isCiOrder=false)
	 *            ，由调用方直接先将费用条目组装好(如果需要本接口计算费用，请将price设置为null)再传入本接口。
	 *            返回值：补费成功后的DTO
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] SetOrderAppendBill(BlOrderAppendBillParamDTO[] appendBillParamDTO1, String code_enttp, boolean isCiOrder) throws BizException {
		if (code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) || code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET) || code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_PE)) // 门诊记账
		{
			return SetOrderAppendBill_Oep(appendBillParamDTO1, isCiOrder);
		} else {
			appendBillParamDTO1 = doSupplyOrderAppendBill_Ip(appendBillParamDTO1);
			return SetOrderAppendBill_Ip(appendBillParamDTO1, isCiOrder);
		}
	}

	/**
	 * 完善住院补费的部分字段
	 * 
	 * @param appendBillParamDTO1
	 * @return
	 * @throws BizException
	 */
	private BlOrderAppendBillParamDTO[] doSupplyOrderAppendBill_Ip(BlOrderAppendBillParamDTO[] appendBillParamDTO1) throws BizException {
		String id_de_nur = "";
		String[] fields1 = { "id_dep_nur" };
		DAFacade dafacade = new DAFacade();
		List<PatiVisitDO> priPatDOLst = (List<PatiVisitDO>) dafacade.findByCond(PatiVisitDO.class, " id_ent='" + appendBillParamDTO1[0].getId_ent() + "'", fields1);
		if (priPatDOLst != null && priPatDOLst.size() > 0) {
			id_de_nur = priPatDOLst.toArray(new PatiVisitDO[0])[0].getId_dep_nur();
		}

		for (BlOrderAppendBillParamDTO dto : appendBillParamDTO1) {
			if (dto.getInpBillDTO() == null) {
				BlOrderAppendInpBillParamDTO inpbill = new BlOrderAppendInpBillParamDTO();
				inpbill.setId_dep_nur(id_de_nur);
			}

		}
		return appendBillParamDTO1;
	}

	public BlcgoepAggDO[] GetOrginBlcgoepAggDOFromIdorsrv(BlOrderAppendBillParamDTO[] refundBillParamDTO_arr) throws BizException {
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();
		Object obj1 = ServiceFinder.find(IBlcgoepRService.class);
		List<BlcgoepAggDO> BlcgoepAggDOList = new ArrayList<BlcgoepAggDO>();
		GetBlCgDO blCgIns = new GetBlCgDO();
		ValidateParam validateParams = new ValidateParam();
		List<String> id_orsrv_list = new ArrayList<String>();// 需要退的医嘱服务
		IBlcgoepRService iBlcgoepRService = ServiceFinder.find(IBlcgoepRService.class);
		IBlCgItmOepDORService iBlCgItmOepDORService = ServiceFinder.find(IBlCgItmOepDORService.class);
		for (int i = 0; i < refundBillParamDTO_arr.length; i++) {
			id_orsrv_list.add(refundBillParamDTO_arr[i].getId_orsrv());
			if (!validateParams.ValidateParamForRefundBill(refundBillParamDTO_arr[i], true)) {
				return null;
			}
			// 门诊记账红冲
			// 查询需要红冲的明细DO
			//String wheresql = " " + BlCgItmOepDODesc.TABLE_ALIAS_NAME + ".id_pat='" + refundBillParamDTO_arr[i].getId_pat() + "' and " + BlCgItmOepDODesc.TABLE_ALIAS_NAME + ".id_or='" + refundBillParamDTO_arr[i].getId_or() + "' and " + BlCgItmOepDODesc.TABLE_ALIAS_NAME + ".id_orsrv='" + refundBillParamDTO_arr[i].getId_orsrv() + "' and " + BlCgItmOepDODesc.TABLE_ALIAS_NAME + ".id_org='"
					//+ refundBillParamDTO_arr[i].getId_org() + "'" + " and " + BlCgItmOepDODesc.TABLE_ALIAS_NAME + ".fg_refund='N'";

			//执行确认，执行取消，再执行确认，再执行取消的时候原代码会有错误，因此修改。  2018.08.13  shaokx
			StringBuffer sb = new StringBuffer();
			sb.append(" select ");
			sb.append("  itmoep.id_cgitmoep,itmoep.id_grp,itmoep.id_org,itmoep.id_pat,itmoep.id_cgoep,itmoep.id_ent,itmoep.id_enttp,itmoep.code_enttp,itmoep.id_pres,itmoep.id_or,itmoep.id_orsrv,itmoep.id_srvtp,itmoep.sd_srvtp,itmoep.id_srvca,itmoep.id_srv,itmoep.code_srv,itmoep.name_srv,itmoep.srvu,itmoep.price,itmoep.quan,itmoep.amt,itmoep.ratio_pripat,itmoep.amt_std,itmoep.id_pripat,itmoep.amt_pat,itmoep.id_hpsrvtp,itmoep.sd_hpsrvtp,itmoep.id_hp,itmoep.ratio_hp,itmoep.amt_hp,itmoep.fg_acc,itmoep.amt_acc,itmoep.amt_ratio,itmoep.dt_or,itmoep.id_org_or,itmoep.id_dep_or,itmoep.id_emp_or,itmoep.id_org_mp,itmoep.id_dep_mp,itmoep.id_dep_wh,itmoep.fg_mm,itmoep.id_mm,itmoep.id_mmtp,itmoep.sd_mmtp,itmoep.code_mm,itmoep.onlycode,itmoep.name_mm,itmoep.spec,itmoep.cd_batch,itmoep.pgku_base,itmoep.pgku_cur,itmoep.factor,itmoep.quan_base,itmoep.pri_ss,itmoep.fg_st,itmoep.id_stoep,itmoep.dt_st,itmoep.fg_hp,itmoep.fg_susp,itmoep.id_par,itmoep.eu_srctp,itmoep.note,itmoep.fg_refund,itmoep.fg_additm,itmoep.apprno,itmoep.id_recg_oep,itmoep.fg_recg,itmoep.dt_srv,itmoep.srcfunc_des,itmoep.ds,itmoep.sv,itmoep.code_inccaitm,itmoep.name_inccaitm,itmoep.fg_free,itmoep.code_apply,itmoep.price_ratio,itmoep.sd_abrd,itmoep.fg_hpcg,itmoep.fg_pricinginsertcg,itmoep.code_applytp,itmoep.id_hpsrvmpayratio,itmoep.fg_zeroreg,itmoep.id_mis,itmoep.code_account,itmoep.name_account ");
			sb.append(" from bl_cg_itm_oep itmoep ");
			sb.append(" inner join bl_cg_oep oep ");
			sb.append(" on itmoep.id_cgoep = oep.id_cgoep ");
			sb.append("  where  ");
			sb.append(" itmoep.id_pat = ? ");
			sb.append(" and itmoep.id_or = ? ");
			sb.append(" and itmoep.id_orsrv = ? ");
			sb.append(" and itmoep.fg_refund = 'N' ");
			sb.append(" and oep.eu_direct = 1 ");

			//对占位符的赋值
			SqlParam sp = new SqlParam();
			sp.addParam(refundBillParamDTO_arr[i].getId_pat());
			sp.addParam(refundBillParamDTO_arr[i].getId_or());
			sp.addParam(refundBillParamDTO_arr[i].getId_orsrv());

			List<BlCgItmOepDO> list = (List<BlCgItmOepDO>) new DAFacade().execQuery(sb.toString(), sp,
					new BeanListHandler(BlCgItmOepDO.class));
			
			
			BlCgItmOepDO[] blCgItmOepDOArr = list.toArray(new BlCgItmOepDO[]{});
			if (blCgItmOepDOArr == null || blCgItmOepDOArr.length == 0) {
				throw new BizException("没有找到患者该医嘱下的计费信息！");
			}

			String errorMsg = "";
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOArr) {
				if (FBoolean.TRUE.equals(blCgItmOepDO.getFg_st())) {
					errorMsg = (StringUtil.isEmpty(errorMsg) ? "" : "，") + blCgItmOepDO.getName_srv();
				}
			}
			if (!StringUtil.isEmpty(errorMsg)) {
				throw new BizException("服务项目：" + errorMsg + "已结算，无法取消记账！");
			}
			// 查询主DO
			BlcgoepAggDO blcgoepAggDO = iBlcgoepRService.findById(blCgItmOepDOArr[0].getId_cgoep());
			blcgoepAggDO.setBlCgItmOepDO(blCgItmOepDOArr);
			BlcgoepAggDOList.add(blcgoepAggDO);

		}
		return BlcgoepAggDOList.toArray(new BlcgoepAggDO[] {});
	}

	// /**
	// * 门诊退费。获得指定条件：id_pat,id_org,id_or,id_orsrv对应的原始记账信息
	// * @param refundBillParamDTO_arr
	// * @return
	// * @throws BizException
	// */
	// private BlcgoepAggDO[]
	// GetOrginBlcgoepAggDOFromIdorsrv(BlOrderAppendBillParamDTO[]
	// refundBillParamDTO_arr) throws BizException
	// {
	// TimeService timeService = new TimeServiceImpl();
	// String strDateTime = timeService.getUFDateTime().toStdString();
	// Object obj1 = ServiceFinder.find(IBlcgoepRService.class);
	// List<BlcgoepAggDO> BlcgoepAggDOList=new ArrayList<BlcgoepAggDO>();
	// GetBlCgDO blCgIns = new GetBlCgDO();
	// ValidateParam validateParams = new ValidateParam();
	// List<String> id_orsrv_list=new ArrayList<String>();//需要退的医嘱服务
	// IBlcgoepRService
	// iBlcgoepRService=ServiceFinder.find(IBlcgoepRService.class);
	// IBlCgItmOepDORService
	// iBlCgItmOepDORService=ServiceFinder.find(IBlCgItmOepDORService.class);
	// for(int i=0;i<refundBillParamDTO_arr.length;i++)
	// {
	// id_orsrv_list.add(refundBillParamDTO_arr[i].getId_orsrv());
	// if
	// (!validateParams.ValidateParamForRefundBill(refundBillParamDTO_arr[i],true))
	// {
	// return null;
	// }
	// // 门诊记账红冲
	// // 查询需要红冲的明细DO
	// String wheresql = " "+BlCgItmOepDODesc.TABLE_ALIAS_NAME +".id_pat='" +
	// refundBillParamDTO_arr[i].getId_pat()
	// + "' and "+BlCgItmOepDODesc.TABLE_ALIAS_NAME+".id_or='" +
	// refundBillParamDTO_arr[i].getId_or()
	// + "' and "+BlCgItmOepDODesc.TABLE_ALIAS_NAME+".id_orsrv='" +
	// refundBillParamDTO_arr[i].getId_orsrv()
	// + "' and "+BlCgItmOepDODesc.TABLE_ALIAS_NAME+".id_org='" +
	// refundBillParamDTO_arr[i].getId_org()
	// + "'";
	//
	// BlCgItmOepDO[] blCgItmOepDOArr=iBlCgItmOepDORService.find(wheresql, "",
	// FBoolean.FALSE);
	// if (blCgItmOepDOArr == null || blCgItmOepDOArr.length == 0) {
	// throw new BizException("没有找到患者该医嘱下的计费信息！");
	// }
	//
	// //查询主DO
	// BlcgoepAggDO blcgoepAggDO
	// =iBlcgoepRService.findById(blCgItmOepDOArr[0].getId_cgoep());
	// blcgoepAggDO.setBlCgItmOepDO(blCgItmOepDOArr);
	// // BlcgoepAggDO[] blcgoepAggDOs = ((IBlcgoepRService) obj1).find(
	// // wheresql, "", FBoolean.FALSE);
	// //
	// // if (blcgoepAggDOs == null || blcgoepAggDOs.length == 0) {
	// // throw new BizException("没有找到患者该医嘱下的计费信息！");
	// // }
	//
	// // // 获得红冲的门诊记账主表和明细表
	// // BlcgoepAggDO[] dashedBackBlcgoepAggDOs = blCgIns
	// // .GetDashedBackBlcgoepAggDO(new BlcgoepAggDO[]{blcgoepAggDO},
	// // refundBillParamDTO_arr[i].getId_org_cg(),
	// // refundBillParamDTO_arr[i].getId_dep_cg(),
	// // refundBillParamDTO_arr[i].getId_emp_cg(), strDateTime);
	// // for(BlcgoepAggDO agg:dashedBackBlcgoepAggDOs)
	// // {
	// BlcgoepAggDOList.add(blcgoepAggDO);
	// // }
	// }
	// return BlcgoepAggDOList.toArray(new BlcgoepAggDO[]{});
	// }

	/**
	 * 门诊退费。获得指定条件：id_pat,id_org,id_or,id_orsrv对应的红冲信息
	 * 
	 * @param refundBillParamDTO_arr
	 * @return
	 * @throws BizException
	 */
	private BlcgoepAggDO[] GetRedBlcgoepAggDOFromIdorsrv(BlOrderAppendBillParamDTO[] refundBillParamDTO_arr) throws BizException {
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();
		Object obj1 = ServiceFinder.find(IBlcgoepRService.class);
		List<BlcgoepAggDO> BlcgoepAggDOList = new ArrayList<BlcgoepAggDO>();
		GetBlCgDO blCgIns = new GetBlCgDO();
		ValidateParam validateParams = new ValidateParam();
		List<String> id_orsrv_list = new ArrayList<String>();// 需要退的医嘱服务
		IBlcgoepRService iBlcgoepRService = ServiceFinder.find(IBlcgoepRService.class);
		IBlCgItmOepDORService iBlCgItmOepDORService = ServiceFinder.find(IBlCgItmOepDORService.class);
		for (int i = 0; i < refundBillParamDTO_arr.length; i++) {
			id_orsrv_list.add(refundBillParamDTO_arr[i].getId_orsrv());
			if (!validateParams.ValidateParamForRefundBill(refundBillParamDTO_arr[i], true)) {
				return null;
			}
			// 门诊记账红冲
			// 查询需要红冲的明细DO
			String wheresql = " " + BlCgItmOepDODesc.TABLE_ALIAS_NAME + ".id_pat='" + refundBillParamDTO_arr[i].getId_pat() + "' and " + BlCgItmOepDODesc.TABLE_ALIAS_NAME + ".id_or='" + refundBillParamDTO_arr[i].getId_or() + "' and " + BlCgItmOepDODesc.TABLE_ALIAS_NAME + ".id_orsrv='" + refundBillParamDTO_arr[i].getId_orsrv() + "' and " + BlCgItmOepDODesc.TABLE_ALIAS_NAME + ".id_org='"
					+ refundBillParamDTO_arr[i].getId_org() + "'";

			BlCgItmOepDO[] blCgItmOepDOArr = iBlCgItmOepDORService.find(wheresql, "", FBoolean.FALSE);
			if (blCgItmOepDOArr == null || blCgItmOepDOArr.length == 0) {
				throw new BizException("没有找到患者该医嘱下的计费信息！");
			}

			// 查询主DO
			BlcgoepAggDO blcgoepAggDO = iBlcgoepRService.findById(blCgItmOepDOArr[0].getId_cgoep());
			blcgoepAggDO.setBlCgItmOepDO(blCgItmOepDOArr);
			// BlcgoepAggDO[] blcgoepAggDOs = ((IBlcgoepRService) obj1).find(
			// wheresql, "", FBoolean.FALSE);
			//
			// if (blcgoepAggDOs == null || blcgoepAggDOs.length == 0) {
			// throw new BizException("没有找到患者该医嘱下的计费信息！");
			// }

			// 获得红冲的门诊记账主表和明细表
			BlcgoepAggDO[] dashedBackBlcgoepAggDOs = blCgIns.GetDashedBackBlcgoepAggDO(new BlcgoepAggDO[] { blcgoepAggDO }, refundBillParamDTO_arr[i].getId_org_cg(), refundBillParamDTO_arr[i].getId_dep_cg(), refundBillParamDTO_arr[i].getId_emp_cg(), strDateTime);
			for (BlcgoepAggDO agg : dashedBackBlcgoepAggDOs) {
				BlcgoepAggDOList.add(agg);
			}
		}
		return BlcgoepAggDOList.toArray(new BlcgoepAggDO[] {});
	}

	/**
	 * 获得门诊退费的锁定金额。获得指定条件：id_pat,id_org,id_or,id_orsrv对应的红冲信息
	 * 
	 * @param refundBillParamDTO_arr
	 * @return
	 * @throws BizException
	 */
	private FDouble GetAcc_amt(BlOrderAppendBillParamDTO[] refundBillParamDTO_arr) throws BizException {
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();
		Object obj1 = ServiceFinder.find(IBlcgoepRService.class);
		List<BlcgoepAggDO> BlcgoepAggDOList = new ArrayList<BlcgoepAggDO>();
		GetBlCgDO blCgIns = new GetBlCgDO();
		ValidateParam validateParams = new ValidateParam();
		List<String> id_orsrv_list = new ArrayList<String>();// 需要退的医嘱服务
		IBlcgoepRService iBlcgoepRService = ServiceFinder.find(IBlcgoepRService.class);
		IBlCgItmOepDORService iBlCgItmOepDORService = ServiceFinder.find(IBlCgItmOepDORService.class);
		FDouble acc_amt = new FDouble(0);
		for (int i = 0; i < refundBillParamDTO_arr.length; i++) {
			id_orsrv_list.add(refundBillParamDTO_arr[i].getId_orsrv());
			if (!validateParams.ValidateParamForRefundBill(refundBillParamDTO_arr[i], true)) {
				return null;
			}
			// 门诊记账红冲
			// 查询需要红冲的明细DO
			String wheresql = " " + BlCgItmOepDODesc.TABLE_ALIAS_NAME + ".id_pat='" + refundBillParamDTO_arr[i].getId_pat() + "' and " + BlCgItmOepDODesc.TABLE_ALIAS_NAME + ".id_or='" + refundBillParamDTO_arr[i].getId_or() + "' and " + BlCgItmOepDODesc.TABLE_ALIAS_NAME + ".id_orsrv='" + refundBillParamDTO_arr[i].getId_orsrv() + "' and " + BlCgItmOepDODesc.TABLE_ALIAS_NAME + ".id_org='"
					+ refundBillParamDTO_arr[i].getId_org() + "'";

			BlCgItmOepDO[] blCgItmOepDOArr = iBlCgItmOepDORService.find(wheresql, "", FBoolean.FALSE);
			if (blCgItmOepDOArr == null || blCgItmOepDOArr.length == 0) {
				throw new BizException("没有找到患者该医嘱下的计费信息！");
			}
			// 查询主DO
			BlcgoepAggDO blcgoepAggDO = iBlcgoepRService.findById(blCgItmOepDOArr[0].getId_cgoep());
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOArr) {
				if (blCgItmOepDO.getFg_acc() != null && blCgItmOepDO.getFg_acc().booleanValue()) {
					acc_amt = acc_amt.add(blCgItmOepDO.getAmt_acc().multiply(blcgoepAggDO.getParentDO().getEu_direct()).multiply(new FDouble(-1)));
				}
			}

		}
		return acc_amt;
	}

	/**
	 * 住院退费。医嘱退费则获得指定条件：id_pat,id_or,id_orsrv对应的红冲信息；或者指定id_cgip的信息
	 * 
	 * @param refundBillParamDTO_arr
	 * @return
	 * @throws BizException
	 */
	private BlCgIpDO[] GetRedBlcgqueryAggDOFromIdorsrv_discard(BlOrderAppendBillParamDTO[] refundBillParamDTO_arrs) throws BizException {
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();
		IBlcgqueryRService iBlcgqueryRService = ServiceFinder.find(IBlcgqueryRService.class);
		List<BlCgIpDO> BlcgqueryAggDOList = new ArrayList<BlCgIpDO>();
		List<BlCgIpDO> red_BlcgqueryAggDOList = new ArrayList<BlCgIpDO>();
		GetBlCgDO blCgIns = new GetBlCgDO();

		// 1.查找原纪录
		for (BlOrderAppendBillParamDTO refundBillParamDTO_arr : refundBillParamDTO_arrs) {
			// 住院记账红冲
			String wheresql = "";
			if (!StringUtil.isEmpty(refundBillParamDTO_arr.getRefundBillParamDTO().getId_cg_pk())) {
				wheresql = " a0.id_cgip='" + refundBillParamDTO_arr.getRefundBillParamDTO().getId_cg_pk() + "' ";
			} else if(!StringUtil.isEmpty(refundBillParamDTO_arr.getRefundBillParamDTO().getId_or_pr_srv())) {
				wheresql = " a0.id_or_pr_srv='" + refundBillParamDTO_arr.getRefundBillParamDTO().getId_or_pr_srv() + "' ";
			} else {
				wheresql = " a0.id_orsrv='" + refundBillParamDTO_arr.getRefundBillParamDTO().getId_orsrv() + "' ";
			}

			wheresql += " and a0.fg_refund = 'N' and a0.eu_direct = 1 ";
			BlCgIpDO[] blcgqueryAggDOs = iBlcgqueryRService.find(wheresql, "", FBoolean.FALSE);
			if (blcgqueryAggDOs == null || blcgqueryAggDOs.length == 0) {
				throw new BizException("没有找到患者该医嘱下的计费信息！");
			}
			for (BlCgIpDO blcgqueryAggDO : blcgqueryAggDOs) {
				BlcgqueryAggDOList.add(blcgqueryAggDO);
			}
		}
		// 2.修改原纪录的fg_refund=Y
		for (BlCgIpDO agg : BlcgqueryAggDOList) {
			agg.setFg_refund(FBoolean.TRUE);// 原纪录已退
			agg.setStatus(DOStatus.UPDATED);
		}
		IBlcgqueryCudService iBlcgqueryCudService = ServiceFinder.find(IBlcgqueryCudService.class);
		BlCgIpDO[] orgin_BlcgqueryAggDOs = iBlcgqueryCudService.save(BlcgqueryAggDOList.toArray(new BlCgIpDO[] {}));

		// 3.获得红冲纪录
		for (BlOrderAppendBillParamDTO refundBillParamDTO_arr : refundBillParamDTO_arrs) {

			// 检查退费数量，不能大于当前数量
			FDouble can_return = new FDouble(0);
			String name = "";

			BlOrderRefundBillParamDTO blOrderRefundBillParamDTO = refundBillParamDTO_arr.getRefundBillParamDTO();
			for (BlCgIpDO blcgqueryAggDO : BlcgqueryAggDOList) {

				BlCgIpDO blCgIpDO = blcgqueryAggDO;
				if (blOrderRefundBillParamDTO.getId_cg_pk() != null) {
					if (blOrderRefundBillParamDTO.getId_cg_pk().equals(blCgIpDO.getId_cgip())) {
						can_return = blCgIpDO.getQuan().multiply(blCgIpDO.getEu_direct());
						// name=blCgIpDO.getName_srv();
					}
				} else if (blOrderRefundBillParamDTO.getId_or_pr_srv() != null) {
					if (blOrderRefundBillParamDTO.getId_or_pr_srv().equals(blCgIpDO.getId_or_pr_srv())) {
						can_return = blCgIpDO.getQuan().multiply(blCgIpDO.getEu_direct());
						// name=blCgIpDO.getName_srv();
					}
				} else if (refundBillParamDTO_arr.getId_or() != null) {
					if (refundBillParamDTO_arr.getId_or().equals(blCgIpDO.getId_or()) && refundBillParamDTO_arr.getId_orsrv().equals(blCgIpDO.getId_orsrv()) && refundBillParamDTO_arr.getId_pat().equals(blCgIpDO.getId_pat())) {
						can_return = blCgIpDO.getQuan().multiply(blCgIpDO.getEu_direct());
						// name=blCgIpDO.getName_srv();
					}
				} else {
					continue;
				}

				if (blOrderRefundBillParamDTO.getReturn_num() != null) {
					if (blOrderRefundBillParamDTO.getReturn_num().compareTo(can_return) > 0) {
						throw new BizException("退费数量不应该大于可退数量！\r\n项目：" + blCgIpDO.getName_srv() + "\r\n可退数量：" + can_return.setScale(-2, BigDecimal.ROUND_HALF_UP).toString() + "\r\n申请退费数量：" + blOrderRefundBillParamDTO.getReturn_num().setScale(-2, BigDecimal.ROUND_HALF_UP).toString());
					}
				}

				// 增加就诊
				refundBillParamDTO_arr.setId_ent(blcgqueryAggDO.getId_ent());

				// 获得红冲的住院记账主表和明细表
				BlCgIpDO[] dashedBackBlcgqueryAggDOs = null;
				// 物品
				if (null != refundBillParamDTO_arr.getRefundBillParamDTO().getId_cg_pk() && (refundBillParamDTO_arr.getRefundBillParamDTO().getReturn_num() != null)) {
					dashedBackBlcgqueryAggDOs = blCgIns.GetDashedBackBlcgqueryAggDO_mm(new BlCgIpDO[] { blcgqueryAggDO }, refundBillParamDTO_arr.getRefundBillParamDTO(), strDateTime);
				} else if (null != refundBillParamDTO_arr.getRefundBillParamDTO().getId_or_pr_srv()) // 执行
				{
					dashedBackBlcgqueryAggDOs = blCgIns.GetDashedBackBlcgqueryAggDO_mm(new BlCgIpDO[] { blcgqueryAggDO }, refundBillParamDTO_arr.getRefundBillParamDTO(), strDateTime);
				} else// 非物品
				{
					dashedBackBlcgqueryAggDOs = blCgIns.GetDashedBackBlcgqueryAggDO(new BlCgIpDO[] { blcgqueryAggDO }, refundBillParamDTO_arr.getRefundBillParamDTO().getId_org_cg(), refundBillParamDTO_arr.getRefundBillParamDTO().getId_dep_cg(), refundBillParamDTO_arr.getRefundBillParamDTO().getId_emp_cg(), strDateTime);
				}
				for (BlCgIpDO dto : dashedBackBlcgqueryAggDOs) {
					red_BlcgqueryAggDOList.add(dto);
				}
			}

		}

		// 红冲记录
		for (BlCgIpDO agg : red_BlcgqueryAggDOList) {
			agg.setFg_refund(FBoolean.FALSE);
			agg.setId_cgip(null);
			agg.setStatus(DOStatus.NEW);
		}

		return BlcgqueryAggDOList.toArray(new BlCgIpDO[] {});
	}

	/**
	 * 住院退费。医嘱退费则获得指定条件：id_pat,id_or,id_orsrv对应的红冲信息；或者指定id_cgip的信息
	 * 
	 * @param refundBillParamDTO_arr
	 * @return
	 * @throws BizException
	 */
	private BlCgIpDO[] GetRedBlcgqueryAggDOFromIdorsrv(BlOrderAppendBillParamDTO[] refundBillParamDTO_arrs) throws BizException {
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();
		IBlcgqueryRService iBlcgqueryRService = ServiceFinder.find(IBlcgqueryRService.class);
		List<BlCgIpDO> BlcgqueryAggDOList = new ArrayList<BlCgIpDO>();
		List<BlCgIpDO> red_BlcgqueryAggDOList = new ArrayList<BlCgIpDO>();
		GetBlCgDO blCgIns = new GetBlCgDO();

		for (BlOrderAppendBillParamDTO refundBillParamDTO_arr : refundBillParamDTO_arrs) {			
			// 住院记账红冲
			String wheresql = "";
			if (!StringUtil.isEmpty(refundBillParamDTO_arr.getRefundBillParamDTO().getId_cg_pk())) {
				wheresql = " a0.id_cgip='" + refundBillParamDTO_arr.getRefundBillParamDTO().getId_cg_pk() + "' ";
			} else if(!StringUtil.isEmpty(refundBillParamDTO_arr.getRefundBillParamDTO().getId_or_pr_srv())) {
				wheresql = " a0.id_or_pr_srv='" + refundBillParamDTO_arr.getRefundBillParamDTO().getId_or_pr_srv() + "' ";
			} else {
				wheresql = " a0.id_orsrv='" + refundBillParamDTO_arr.getRefundBillParamDTO().getId_orsrv() + "' ";
			}
			
			// 退费时应当只查询可退费的数据，不包括已经退掉的数据和红冲数据
			// By liwq 2017年6月30日21:37:53
			wheresql += " and a0.fg_refund = 'N' and a0.eu_direct = 1 ";
			BlCgIpDO[] blcgqueryAggDOs = iBlcgqueryRService.find(wheresql, "", FBoolean.FALSE);
			if (blcgqueryAggDOs == null || blcgqueryAggDOs.length == 0) {
				throw new BizException("没有找到患者该医嘱下的计费信息！");
			}
			// 2.修改原纪录的fg_refund=Y
			for (BlCgIpDO agg : blcgqueryAggDOs) {
				agg.setFg_refund(FBoolean.TRUE);// 原纪录已退
				agg.setStatus(DOStatus.UPDATED);
			}
			IBlcgqueryCudService iBlcgqueryCudService = ServiceFinder.find(IBlcgqueryCudService.class);
			iBlcgqueryCudService.save(blcgqueryAggDOs);

			// 3.生成红冲的数据
			// 检查退费数量，不能大于当前数量
			FDouble can_return = new FDouble(0);
			BlOrderRefundBillParamDTO blOrderRefundBillParamDTO = refundBillParamDTO_arr.getRefundBillParamDTO();
			for (BlCgIpDO agg : blcgqueryAggDOs) {
				BlCgIpDO blCgIpDO = agg;
				if (blOrderRefundBillParamDTO.getId_cg_pk() != null) {
					if (blOrderRefundBillParamDTO.getId_cg_pk().equals(blCgIpDO.getId_cgip())) {
						can_return = blCgIpDO.getQuan().multiply(blCgIpDO.getEu_direct());
					}
				} else if (blOrderRefundBillParamDTO.getId_or_pr_srv() != null) {
					if (blOrderRefundBillParamDTO.getId_or_pr_srv().equals(blCgIpDO.getId_or_pr_srv())) {
						can_return = blCgIpDO.getQuan().multiply(blCgIpDO.getEu_direct());
					}
				} else if (blOrderRefundBillParamDTO.getId_or() != null) {
					if (blOrderRefundBillParamDTO.getId_or().equals(blCgIpDO.getId_or()) && blOrderRefundBillParamDTO.getId_orsrv().equals(blCgIpDO.getId_orsrv()) && blOrderRefundBillParamDTO.getId_pat().equals(blCgIpDO.getId_pat())) {
						can_return = blCgIpDO.getQuan().multiply(blCgIpDO.getEu_direct());
					}
				} else {
					continue;
				}

				if (blOrderRefundBillParamDTO.getReturn_num() != null) {
					if (blOrderRefundBillParamDTO.getReturn_num().compareTo(can_return) > 0) {
						throw new BizException("退费数量不应该大于可退数量！\r\n项目：" + blCgIpDO.getName_srv() + "\r\n可退数量：" + can_return.setScale(-2, BigDecimal.ROUND_HALF_UP).toString() + "\r\n申请退费数量：" + blOrderRefundBillParamDTO.getReturn_num().setScale(-2, BigDecimal.ROUND_HALF_UP).toString());
					}
				}

				// 增加就诊
				refundBillParamDTO_arr.setId_ent(agg.getId_ent());

				// 获得红冲的住院记账主表和明细表
				BlCgIpDO[] dashedBackBlcgqueryAggDOs = null;
				// 物品
				if (null != refundBillParamDTO_arr.getRefundBillParamDTO().getId_cg_pk() && (refundBillParamDTO_arr.getRefundBillParamDTO().getReturn_num() != null)) {
					dashedBackBlcgqueryAggDOs = blCgIns.GetDashedBackBlcgqueryAggDO_mm(new BlCgIpDO[] { agg }, refundBillParamDTO_arr.getRefundBillParamDTO(), strDateTime);
				} else if (null != refundBillParamDTO_arr.getRefundBillParamDTO().getId_or_pr_srv()) // 执行
				{
					dashedBackBlcgqueryAggDOs = blCgIns.GetDashedBackBlcgqueryAggDO_mm(new BlCgIpDO[] { agg }, refundBillParamDTO_arr.getRefundBillParamDTO(), strDateTime);
				} else// 非物品
				{
					dashedBackBlcgqueryAggDOs = blCgIns.GetDashedBackBlcgqueryAggDO(new BlCgIpDO[] { agg }, refundBillParamDTO_arr.getRefundBillParamDTO().getId_org_cg(), refundBillParamDTO_arr.getRefundBillParamDTO().getId_dep_cg(), refundBillParamDTO_arr.getRefundBillParamDTO().getId_emp_cg(), strDateTime);
				}
				for (BlCgIpDO dto : dashedBackBlcgqueryAggDOs) {
					red_BlcgqueryAggDOList.add(dto);
				}
			}
		}

		// 红冲记录
		for (BlCgIpDO agg : red_BlcgqueryAggDOList) {
			agg.setFg_refund(FBoolean.FALSE);
			agg.setId_cgip(null);
			agg.setStatus(DOStatus.NEW);
		}

		return red_BlcgqueryAggDOList.toArray(new BlCgIpDO[] {});
	}

	/**
	 * 住院医嘱退记账业务逻辑:
	 * 门诊退记账信息，必须录入id_or,id_orsrv,code_ent,id_pat,id_org,id_org_cg,id_dep_cg
	 * ,id_emp_cg
	 * 住院退记账信息，在BlOrderAppendBillParamDTO中必须生成RefundBillParamDTO，必须录入id_org_cg
	 * ,id_dep_cg,id_emp_cg,id_ent,id_or,id_orsrv,id_pat,id_org,code_ent
	 * 当isCiOrder
	 * =FBoolean.true时，按医嘱下服务整张退（同时满足这四个条件：id_pat,id_org,id_or,id_orsrv）；
	 * 当isCiOrder=FBoolean.false时,由调用方拼好所有信息，包括价格，标准费用等信息
	 */
	private FBoolean SetOrderRefundBill_Ip(BlOrderAppendBillParamDTO[] refundBillParamDTOs, boolean isCiOrder) throws BizException {
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();
		List<String> id_orsrv_list = new ArrayList<String>();
		// id_orsrv_list=null;
		FDouble acc_lock = new FDouble(0);
		FDouble amt_std = new FDouble(0);
		GetBlCgDO blCgIns = new GetBlCgDO();

		ValidateParam validateParams = new ValidateParam();
		// 1.判断是否封账和是否在审核结算流程中
		if (refundBillParamDTOs[0].getId_ent() != null) {
			validateParams.validateFreezeAccAndAuditStatus(refundBillParamDTOs[0].getId_ent());
		} else {
			validateParams.validateFreezeAccAndAuditStatus(refundBillParamDTOs[0].getRefundBillParamDTO().getId_ent());
		}

		BlCgOepDO blCgOepDO = null;
		List<BlCgItmOepDO> BlCgItmOepDOlist = new ArrayList<BlCgItmOepDO>();

		// 2.退费。获得退费产生的记账AggDO
		BlCgIpDO[] dashedBackBlcgqueryAggDOs = null;
		if (isCiOrder)// 医嘱退费：按医嘱下服务整张退（同时满足这四个条件：id_pat,id_org,id_or,id_orsrv）
		{
			dashedBackBlcgqueryAggDOs = GetRedBlcgqueryAggDOFromIdorsrv(refundBillParamDTOs);

		} else if (refundBillParamDTOs[0].getRefundBillParamDTO() != null) // 按记账主键退费或按执行记录退费
		{
			dashedBackBlcgqueryAggDOs = GetRedBlcgqueryAggDOFromIdorsrv(refundBillParamDTOs);
		} else // 调用方已经组装好
		{
			for (BlOrderAppendBillParamDTO appendBillParamDTO1 : refundBillParamDTOs) {
				if (appendBillParamDTO1.getRatio_pripat() == null && appendBillParamDTO1.getFg_mm().booleanValue()) {
					appendBillParamDTO1.setRatio_pripat(new FDouble(1)); // 主要是物品
				}
				amt_std = appendBillParamDTO1.getPrice().multiply(appendBillParamDTO1.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP);
				if (appendBillParamDTO1.getAmt_std() == null) {
					appendBillParamDTO1.setAmt_std(amt_std);
				}
				if (appendBillParamDTO1.getAmt_ratio() == null) {
					appendBillParamDTO1.setAmt_ratio(appendBillParamDTO1.getPrice().multiply(appendBillParamDTO1.getQuan()).multiply(appendBillParamDTO1.getRatio_pripat()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				}
				if (appendBillParamDTO1.getAmt_pat() == null) {
					appendBillParamDTO1.setAmt_pat(appendBillParamDTO1.getAmt_ratio());
				}
				if (appendBillParamDTO1.getAmt() == null) {
					appendBillParamDTO1.setAmt(appendBillParamDTO1.getAmt_ratio());
				}
				appendBillParamDTO1.setAmt_hp(new FDouble(0));

				if (appendBillParamDTO1.getCode_inccaitm() == null) {
					// 完善账单码
					/*IncCaItmDO incCaItmDO = getInccaitmCodeAndName(appendBillParamDTO1.getCode_enttp(), appendBillParamDTO1.getId_srv());
					if (incCaItmDO != null) {
						appendBillParamDTO1.setName_inccaitm(incCaItmDO.getName());
						appendBillParamDTO1.setCode_inccaitm(incCaItmDO.getCode());
					}*/
				}
			}
			// 只存了主表
			dashedBackBlcgqueryAggDOs = blCgIns.GetBlCgIpDOs(refundBillParamDTOs, strDateTime);
		}

		for (BlCgIpDO dto : dashedBackBlcgqueryAggDOs) {
			dto.setFg_refund(FBoolean.FALSE); // 设置退费标志
			dto.setStatus(DOStatus.NEW);
		}

		// 3.保存退费红冲数据
		Object obj = ServiceFinder.find(IBlcgqueryCudService.class);
		BlCgIpDO[] dashBackBlcgqueryAggDOs = ((IBlcgqueryCudService) obj).save(dashedBackBlcgqueryAggDOs);
		if (null == dashBackBlcgqueryAggDOs) {
			throw new BizException("保存住院记账红冲信息失败");
		}
		
		for (BlCgIpDO blCgIpDO : dashBackBlcgqueryAggDOs) {
			if(!StringUtil.isEmpty(blCgIpDO.getId_orsrv())){
				id_orsrv_list.add(blCgIpDO.getId_orsrv());
			}
		}

		// 4.调整住院预交金账户
		acc_lock = blCgIns.GetDashedBackAcc_ip_Lock(dashedBackBlcgqueryAggDOs); // 比例金额*记费方向
		IEnOutCmdService inpPatAccImpls = ServiceFinder.find(IEnOutCmdService.class);
		inpPatAccImpls.consume(refundBillParamDTOs[0].getId_ent(), acc_lock); // 修改消费值

		// 取消医嘱记账: 改成0还是2？？？
		// TODO:2017-5-24修改：
		// 2、记账状态回写接口，入参需要增加【冲账类型】参数，参数值：【销账】【结算后冲账】。
		// 1) 记账后，【记账状态】=已记账，冲账类型 =空。
		// 2) 销账后，【记账状态】=已退费，冲账类型 =销账。
		// 3) 结算后冲账后，【记账状态】=已退费，冲账类型 =结算后冲账。
		// 但是，住院没有明确是改成已退费还是未记账，故保持原样 2017-5-24
		if (id_orsrv_list != null && id_orsrv_list.size() > 0) {
			Object obj2X = ServiceFinder.find(ICiOrdMaintainService.class);
			FBoolean updateCiOrder = ((ICiOrdMaintainService) obj2X).UpdateOrdChargeRelInfo2(id_orsrv_list.toArray(new String[] {}), ICiDictCodeConst.SD_SU_BL_NONE_ID, ICiDictCodeConst.SD_SU_BL_NONE, null, FeeReverseType.BLCGCANCEL);
		}
		return FBoolean.TRUE;
	}

	/**
	 * 门急诊医嘱退记账逻辑:
	 * 门诊退记账信息，必须录入id_or,id_orsrv,code_ent,id_pat,id_org,id_org_cg,id_dep_cg
	 * ,id_emp_cg
	 * 住院退记账信息，在BlOrderAppendBillParamDTO中必须生成RefundBillParamDTO，必须录入id_org_cg
	 * ,id_dep_cg,id_emp_cg,id_ent,id_or,id_orsrv,id_pat,id_org,code_ent
	 * 当isCiOrder
	 * =FBoolean.true时，按医嘱下服务整张退（同时满足这四个条件：id_pat,id_org,id_or,id_orsrv）；
	 * 当isCiOrder=FBoolean.false时,由调用方拼好所有信息，包括价格，标准费用等信息
	 */
	private FBoolean SetOrderRefundBill_Oep(BlOrderAppendBillParamDTO[] refundBillParamDTOs, boolean isCiOrder) throws BizException {
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();
		List<String> id_orsrv_list = new ArrayList<String>();
		FBoolean fg_hpcg = FBoolean.FALSE;
		// id_orsrv_list=null;
		FDouble acc_lock = new FDouble(0);
		FDouble amt_std = new FDouble(0);
		GetBlCgDO blCgIns = new GetBlCgDO();
		BlcgoepAggDO[] orgin_BlcgoepAggDO = null;
		BlCgOepDO blCgOepDO = null;
		List<BlCgItmOepDO> BlCgItmOepDOlist = new ArrayList<BlCgItmOepDO>();
		// 门急诊数据
		BlcgoepAggDO[] orginAndRedBlcgoepAggDOs = null;
		BlcgoepAggDO[] RedBlcgoepAggDOarr = null;
		List<BlcgoepAggDO> aggLst = new ArrayList<BlcgoepAggDO>();
		List<BlcgoepAggDO> red_aggLst = new ArrayList<BlcgoepAggDO>();
		// 1.查找原始记账信息，得到回退金额，id_orsrv
		if (isCiOrder)// 医嘱退费：按医嘱下服务整张退（同时满足这四个条件：id_pat,id_org,id_or,id_orsrv）
		{

			// 查询对应的原始记账信息
			orgin_BlcgoepAggDO = GetOrginBlcgoepAggDOFromIdorsrv(refundBillParamDTOs);
			// 因为原始数据中 两个AGGdo 中的主do是相同的
			Map<String, BlcgoepAggDO> aggmap = new HashMap<String, BlcgoepAggDO>();
			for (BlcgoepAggDO orgindto : orgin_BlcgoepAggDO) {
				orgindto.getParentDO().setStatus(DOStatus.UPDATED);
				BlCgItmOepDO[] blCgItmOepDOs = orgindto.getBlCgItmOepDO();
				fg_hpcg = blCgItmOepDOs[0].getFg_hpcg(); // 是否高端商保记账标志
				for (BlCgItmOepDO dto : blCgItmOepDOs) {
					dto.setFg_refund(FBoolean.TRUE);
					dto.setStatus(DOStatus.UPDATED);
					if (!id_orsrv_list.contains(dto.getId_orsrv())) {
						id_orsrv_list.add(dto.getId_orsrv());
					}
					if (dto.getAmt_acc() != null)
						acc_lock = acc_lock.add(dto.getAmt_acc().multiply(-1));
				}
				// 如果aggdo中有两个以上的相同数据会因sv相同而报错，所以使用map进行合并agg
				if (aggmap.containsKey(orgindto.getParentDO().getId_cgoep())) {
					BlCgItmOepDO[] dtos = aggmap.get(orgindto.getParentDO().getId_cgoep()).getBlCgItmOepDO();
					List<BlCgItmOepDO> listdto = new ArrayList<BlCgItmOepDO>();
					for (int i = 0; i < dtos.length; i++) {
						listdto.add(dtos[i]);
					}
					for (int i = 0; i < blCgItmOepDOs.length; i++) {
						listdto.add(blCgItmOepDOs[i]);
					}
					aggmap.get(orgindto.getParentDO().getId_cgoep()).setBlCgItmOepDO(listdto.toArray(new BlCgItmOepDO[0]));
				} else {
					aggmap.put(orgindto.getParentDO().getId_cgoep(), orgindto);
				}
			}
			for (BlcgoepAggDO blcgoepAggDO : aggmap.values()) {
				aggLst.add(blcgoepAggDO);
			}

		} else// 非医嘱，调用方已经组装好
		{
			for (BlOrderAppendBillParamDTO appendBillParamDTO1 : refundBillParamDTOs) {
				if (appendBillParamDTO1.getRatio_pripat() == null && appendBillParamDTO1.getFg_mm().booleanValue()) {
					// 查价格比例
					appendBillParamDTO1.setRatio_pripat(new FDouble(1));
				}
				amt_std = appendBillParamDTO1.getAmt_std();
				appendBillParamDTO1.setAmt(amt_std);
				appendBillParamDTO1.setAmt_ratio(amt_std);
				appendBillParamDTO1.setAmt_pat(amt_std);
				appendBillParamDTO1.setAmt_hp(new FDouble(0));
				if (appendBillParamDTO1.getOutpBillDTO() != null && appendBillParamDTO1.getOutpBillDTO().getFg_acc() != null && appendBillParamDTO1.getOutpBillDTO().getFg_acc().booleanValue()) {
					// 记账时已扣预交金
					acc_lock = acc_lock.add(appendBillParamDTO1.getOutpBillDTO().getAmt_acc().multiply(-1));
				}
				if (appendBillParamDTO1.getCode_inccaitm() == null) {
					// 完善账单码
					/*IncCaItmDO incCaItmDO = getInccaitmCodeAndName(appendBillParamDTO1.getCode_enttp(), appendBillParamDTO1.getId_srv());
					if (incCaItmDO != null) {
						appendBillParamDTO1.setName_inccaitm(incCaItmDO.getName());
						appendBillParamDTO1.setCode_inccaitm(incCaItmDO.getCode());
					}*/
				}
				if (null == blCgOepDO)// 门急诊主表，只需生成一次主表
				{
					blCgOepDO = blCgIns.GetBlCgOepDO(appendBillParamDTO1, strDateTime);
					blCgOepDO.setStatus(DOStatus.NEW);
				}

				// 获得子表
				BlCgItmOepDOlist.add(blCgIns.GetBlCgItmOepDO(appendBillParamDTO1, strDateTime, FBoolean.FALSE)); // 待划价
			}
			if (refundBillParamDTOs[0].getOutpBillDTO() != null && refundBillParamDTOs[0].getOutpBillDTO().getFg_hpcg() != null) {
				fg_hpcg = refundBillParamDTOs[0].getOutpBillDTO().getFg_hpcg(); // 是否高端商保记账标志
			}
			BlcgoepAggDO blcgoepAggDO = new BlcgoepAggDO();
			blcgoepAggDO.setParentDO(blCgOepDO);
			blcgoepAggDO.setBlCgItmOepDO(BlCgItmOepDOlist.toArray(new BlCgItmOepDO[0]));
			RedBlcgoepAggDOarr = new BlcgoepAggDO[1];
			RedBlcgoepAggDOarr[0] = blcgoepAggDO;
			// 找到原记账信息
			orgin_BlcgoepAggDO = GetOrginBlcgoepAggDOFromIdorsrv(refundBillParamDTOs);
			aggLst.add(blcgoepAggDO);
		}

		// 更新原始记录
		IBlcgoepCudService iBlcgoepCudService = ServiceFinder.find(IBlcgoepCudService.class);
		BlcgoepAggDO[] blcgoepAggDOs = iBlcgoepCudService.save(aggLst.toArray(new BlcgoepAggDO[0]));
		if (blcgoepAggDOs == null || blcgoepAggDOs.length == 0) {
			throw new BizException("更新原记账记录失败！");
		}
		// 保存红冲记账记录
		// 获得红冲的门诊记账主表和明细表
		BlcgoepAggDO[] dashedBackBlcgoepAggDOs = blCgIns.GetDashedBackBlcgoepAggDO(blcgoepAggDOs, refundBillParamDTOs[0].getId_org_cg(), refundBillParamDTOs[0].getId_dep_cg(), refundBillParamDTOs[0].getId_emp_cg(), strDateTime);
		for (BlcgoepAggDO agg : dashedBackBlcgoepAggDOs) {
			red_aggLst.add(agg);
		}

		BlcgoepAggDO[] red_blcgoepAggDOs = iBlcgoepCudService.save(red_aggLst.toArray(new BlcgoepAggDO[0]));
		if (red_blcgoepAggDOs == null || red_blcgoepAggDOs.length == 0) {
			throw new BizException("红冲原记账记录失败！");
		}
		this.invokeRefundCancAccEvent(red_blcgoepAggDOs);
		// 修改账户数据
		// 如果采用了预交金授权，则调整预交金账户
		if (!fg_hpcg.booleanValue()) // 不是高端商保
		{
			if (acc_lock.abs().compareTo(FDouble.ZERO_DBL) > 0) {
				IPatAccServiceExt patAccImpls = (IPatAccServiceExt) ServiceFinder.find(IPatAccServiceExt.class);
				PiPatAccDO piPatAccDO = patAccImpls.PatiAccPreAuthor(refundBillParamDTOs[0].getId_pat(), acc_lock);
				if (null == piPatAccDO) {
					throw new BizException("更新患者预交金信息失败");
				}
			}
		}

		// 取消医嘱记账: 改成0还是2？？？
		// 2017-5-24修改：
		// 2、记账状态回写接口，入参需要增加【冲账类型】参数，参数值：【销账】【结算后冲账】。
		// 1) 记账后，【记账状态】=已记账，冲账类型 =空。
		// 2) 销账后，【记账状态】=已退费，冲账类型 =销账。
		// 3) 结算后冲账后，【记账状态】=已退费，冲账类型 =结算后冲账。
		if (id_orsrv_list != null && id_orsrv_list.size() > 0) {
			Object obj2X = ServiceFinder.find(ICiOrdMaintainService.class);
			FBoolean updateCiOrder = ((ICiOrdMaintainService) obj2X).UpdateOrdChargeRelInfo2(id_orsrv_list.toArray(new String[] {}), ICiDictCodeConst.SD_SU_BL_REFOUND_ID, ICiDictCodeConst.SD_SU_BL_REFOUND, null, FeeReverseType.BLCGCANCEL);
		}
		return FBoolean.TRUE;
	}

	/**
	 * 医嘱退记账接口:
	 * 门诊退记账信息，必须录入id_or,id_orsrv,code_ent,id_pat,id_org,id_org_cg,id_dep_cg
	 * ,id_emp_cg
	 * 住院退记账信息，在BlOrderAppendBillParamDTO中必须生成RefundBillParamDTO，必须录入id_org_cg
	 * ,id_dep_cg,id_emp_cg,id_ent,id_or,id_orsrv,id_pat,id_org,code_ent
	 * 当isCiOrder
	 * =FBoolean.true时，按医嘱下服务整张退（同时满足这四个条件：id_pat,id_org,id_or,id_orsrv）；
	 * 当isCiOrder=FBoolean.false时,由调用方拼好所有信息，包括价格，标准费用等信息 code_ent：就诊类型代码,门诊还是住院
	 */
	public FBoolean SetOrderRefundBill(BlOrderAppendBillParamDTO[] refundBillParamDTOs, boolean isCiOrder, String code_ent) throws BizException {
		if (refundBillParamDTOs == null || refundBillParamDTOs.length == 0) {
			throw new BizException("当前用户没有可销账的费用数据！（销账数据必须记账人本人）");
		}
		if (code_ent.equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) || code_ent.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET) || code_ent.equals(IBdFcDictCodeConst.SD_CODE_ENTP_PE)) // 门诊退费
		{
			return SetOrderRefundBill_Oep(refundBillParamDTOs, isCiOrder);
		} else// 住院退费
		{
			return SetOrderRefundBill_Ip(refundBillParamDTOs, isCiOrder);
		}
	}

	/**
	 * 根据服务ID（非物品），返回完整的BlOrderAppendBillParamDTO数组
	 * 
	 * @param appendBillParamDTOArr
	 *            挂号显示价格调用时：
	 *            1.id_pat,id_enttp,code_enttp,id_srv,quan,eu_direct(挂号填1
	 *            ),id_org_mp,id_dep_mp必填,其他字段可省;
	 *            2.如果需要支持后付费，则需要设置BlOrderAppendBillParamDTO
	 *            .setOutpBillDTO(OutpBillDTO.fg_acc=FBoolean.true)
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @param id_pripat
	 *            患者价格分类
	 * @return 完整的BlOrderAppendBillParamDTO数组
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] getBlOrderAppendBillParamDTOArr(BlOrderAppendBillParamDTO[] appendBillParamDTOArr, OperatorInfoDTO operatorInfoDTO, String id_pripat) throws BizException {
		BlAppendOrRefundBillBP bp = new BlAppendOrRefundBillBP();
		return bp.getBlOrderAppendBillParamDTOArr(appendBillParamDTOArr, operatorInfoDTO, id_pripat);
	}

	/**
	 * 发送监听事件
	 * 
	 * @param blcgoepAggDOs
	 * @throws BizException
	 */
	private void invokeRefundCancAccEvent(BlcgoepAggDO[] blcgoepAggDOs) throws BizException {

		ArrayList<String> idcgitmoepStr = new ArrayList<String>();
		for (BlcgoepAggDO aggDO : blcgoepAggDOs) {

			if (!ArrayUtil.isEmpty(aggDO.getBlCgItmOepDO())) {
				for (BlCgItmOepDO itmDO : aggDO.getBlCgItmOepDO()) {
					idcgitmoepStr.add(itmDO.getId_cgitmoep());
				}
			}
		}
		OpCancAcc4EsDTO[] acc4EsDTOs = (OpCancAcc4EsDTO[]) AppFwUtil.getDORstWithDao(new GetOpFund4IpEsDTOsByIdsQry(idcgitmoepStr.toArray(new String[idcgitmoepStr.size()])), OpCancAcc4EsDTO.class);
		OpCancAccEvent event = new OpCancAccEvent();

		event.invoke(acc4EsDTOs);

	}

}
