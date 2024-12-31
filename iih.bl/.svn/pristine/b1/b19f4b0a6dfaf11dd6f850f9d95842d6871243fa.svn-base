package iih.bl.cg.service.s.bp;

import iih.bd.base.utils.MapUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.dto.priview.d.BdPriViewDTO;
import iih.bd.pp.i.IBdPriCalService;
import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.pp.service.i.IBdInccaQueService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendInpBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendOutpBillParamDTO;
import iih.bl.cg.bp.GetBlCgDO;
import iih.bl.cg.bp.SetBlOrderAppendBillParamDTOPricing;
import iih.bl.cg.dto.d.SrvIdAndQuanDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.IBlConst;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.i.IEnOutQryService;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IPatAccServiceExt;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 补费、退费业务逻辑
 * 
 * @author tcy
 *
 */
public class BlAppendOrRefundBillBP {
	/**
	 * 医嘱补费
	 * 
	 * @param appendBillParamDTO1
	 *            医嘱角度的，数据来源于ci_or_srv
	 * @param code_enttp
	 *            就诊类型代码
	 * @return
	 * @throws BizException
	 */
	public List<BlOrderAppendBillParamDTO> getBlOrderAppendBillParamDTOArr_CiOrder(BlOrderAppendBillParamDTO[] appendBillParamDTO1) throws BizException {
		List<BlOrderAppendBillParamDTO> blOrderAppendBillParamDTOLst = new ArrayList<BlOrderAppendBillParamDTO>();
		SetBlOrderAppendBillParamDTOPricing insMm = new SetBlOrderAppendBillParamDTOPricing();
		Map<String, SrvIdAndQuanDTO> idorsrv_ciorsrv = new HashMap<String, SrvIdAndQuanDTO>();
		SrvIdAndQuanDTO srvs;
		for (int i = 0; i < appendBillParamDTO1.length; i++) {
			if (!appendBillParamDTO1[i].getFg_mm().booleanValue()) {
				if (!idorsrv_ciorsrv.containsKey(appendBillParamDTO1[i].getId_orsrv())) {
					// 非物品
					// 获取服务价格
					StringBuffer sbf = new StringBuffer();
					sbf.append("select id_srv,name,quan_medu as Amount ");
					sbf.append(" from ci_or_srv ");
					sbf.append(" where id_orsrv=? and fg_mm='N' ");
					SqlParam sqlparam = new SqlParam();
					sqlparam.addParam(appendBillParamDTO1[i].getId_orsrv());
					// 获得查询结果
					List<SrvIdAndQuanDTO> list = (List<SrvIdAndQuanDTO>) new DAFacade().execQuery(sbf.toString(), sqlparam, new BeanListHandler(SrvIdAndQuanDTO.class));
					if (list == null) {
						throw new BizException("该医嘱服务不存在！医嘱服务ID:" + appendBillParamDTO1[i].getId_orsrv());
					}
					srvs = list.toArray(new SrvIdAndQuanDTO[] {})[0];// 主键查询，只有一条查询结果
					if (srvs.getAmount() == null) {
						throw new BizException("该医嘱服务对应的数量不存在！医嘱服务ID:" + appendBillParamDTO1[i].getId_orsrv());
					}
					idorsrv_ciorsrv.put(appendBillParamDTO1[i].getId_orsrv(), srvs);
				} else {
					srvs = idorsrv_ciorsrv.get(appendBillParamDTO1[i].getId_orsrv());
				}

				if (appendBillParamDTO1[i].getQuan() == null) {
					appendBillParamDTO1[i].setQuan(srvs.getAmount());
				} else {
					appendBillParamDTO1[i].setQuan(appendBillParamDTO1[i].getQuan());
				}
				appendBillParamDTO1[i].setId_srv(srvs.getId_srv());

				// 调用新的计价方法(带价格比例）

				// BlOrderAppendBillParamDTO[] appendBillParamDTO = insMm
				// .SetBlOrderAppendBillParamDTOPricing(new
				// BlOrderAppendBillParamDTO[]{appendBillParamDTO1[i]});
				blOrderAppendBillParamDTOLst.addAll(insMm.SetBlOrderAppendBillParamDTOPricing_list(new BlOrderAppendBillParamDTO[] { appendBillParamDTO1[i] }));

			} else // 物品
			{
				if (appendBillParamDTO1[0].getCode_enttp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) || appendBillParamDTO1[0].getCode_enttp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)
						|| appendBillParamDTO1[0].getCode_enttp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_PE)) // 门诊物品，需要调用物品接口
				{
					// 计算每条DTO的费用
					blOrderAppendBillParamDTOLst.addAll(insMm.SetBlOrderAppendBillParamDTOPricing_list(new BlOrderAppendBillParamDTO[] { appendBillParamDTO1[i] }));

				} else // 住院不用调物品接口
				{
					blOrderAppendBillParamDTOLst.add(appendBillParamDTO1[i]);
				}
			}
		}
		return blOrderAppendBillParamDTOLst;
	}

	/**
	 * 医嘱补费
	 * 
	 * @param 费用明细
	 * @param code_enttp
	 *            就诊类型代码
	 * @return
	 * @throws BizException
	 */
	public List<BlOrderAppendBillParamDTO> getBlOrderAppendBillParamDTOArr_Itms(BlOrderAppendBillParamDTO[] appendBillParamDTO1) throws BizException {
		List<BlOrderAppendBillParamDTO> blOrderAppendBillParamDTOLst = new ArrayList<BlOrderAppendBillParamDTO>();
		SetBlOrderAppendBillParamDTOPricing insMm = new SetBlOrderAppendBillParamDTOPricing();
		// 如果价格为空，则需要重新划价
//		if (appendBillParamDTO1[0].getPrice() == null || ("").equals(appendBillParamDTO1[0].getPrice())) {

			blOrderAppendBillParamDTOLst.addAll(insMm.SetBlOrderAppendBillParamDTOPricing_list(appendBillParamDTO1));
//		}
//		List<BlOrderAppendBillParamDTO> havePriceList = new ArrayList<BlOrderAppendBillParamDTO>();
//		List<BlOrderAppendBillParamDTO> noPriceList = new ArrayList<BlOrderAppendBillParamDTO>();
//		for(BlOrderAppendBillParamDTO dto : appendBillParamDTO1){
//			if(dto.getPrice() == null || ("").equals(dto.getPrice())){
//				noPriceList.add(dto);
//			}else{
//				havePriceList.add(dto);
//			}
//		}
//		if(!ListUtil.isEmpty(noPriceList)){
//			//价格为空进行重新计价
//			blOrderAppendBillParamDTOLst.addAll(insMm.SetBlOrderAppendBillParamDTOPricing_list(noPriceList.toArray(new BlOrderAppendBillParamDTO[0])));
//		
//		}
//		if(!ListUtil.isEmpty(havePriceList)){
//			for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : havePriceList) {
//				
//			}
//			blOrderAppendBillParamDTOLst.addAll(havePriceList);
//		}
		
		
		if (blOrderAppendBillParamDTOLst.size() == 0) {
			String[] fields = { "id_unit_med" }; // 需要查询的列
			DAFacade dAFacade = new DAFacade();
			for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO1 : appendBillParamDTO1) {
				// 检查是否设置了srvu
				if (blOrderAppendBillParamDTO1.getSrvu() == null) {
					List<MedSrvDO> medDocDOList = (List<MedSrvDO>) dAFacade.findByCond(MedSrvDO.class, "id_srv='" + blOrderAppendBillParamDTO1.getId_srv() + "'", "1", fields);
					if (medDocDOList != null && medDocDOList.size() > 0) {
						blOrderAppendBillParamDTO1.setSrvu(medDocDOList.toArray(new MedSrvDO[0])[0].getId_unit_med());
					}
					// if(blOrderAppendBillParamDTO1.getSpec()==null)
					// {
					// blOrderAppendBillParamDTO1.setSpec("/");
					// }
				}

				// 完善账单码
				/*IncCaItmDO incCaItmDO = getInccaitmCodeAndName(blOrderAppendBillParamDTO1.getCode_enttp(), blOrderAppendBillParamDTO1.getId_srv());
				if (incCaItmDO != null) {
					blOrderAppendBillParamDTO1.setName_inccaitm(incCaItmDO.getName());
					blOrderAppendBillParamDTO1.setCode_inccaitm(incCaItmDO.getCode());
				}*/
				blOrderAppendBillParamDTOLst.add(blOrderAppendBillParamDTO1);
			}
		}

		return blOrderAppendBillParamDTOLst;
	}

	/**
	 * 将费用明细记入门诊记账表(商保记账)，直接存CG表，不修改患者消费金额
	 * 
	 * @param appendBillParamDTO
	 *            需要保存的费用明细
	 * @return 保存成功返回的BlcgoepAggDO
	 */
	public BlcgoepAggDO[] doInBlcgOep_hpcg(BlOrderAppendBillParamDTO[] appendBillParamDTO) throws BizException {
		
		BlcgoepAggDO[] blcgoepAggDOs = savecgAggDOs(appendBillParamDTO);
		if (null == blcgoepAggDOs) {
			throw new BizException("保存门诊记账信息失败");
		}

		return blcgoepAggDOs;
	}

	/**
	 * 将费用明细记入门诊记账表，且修改门诊账户消费金额
	 * 
	 * @param appendBillParamDTO
	 *            需要保存的费用明细
	 * @param sum_amt
	 *            需要修改账户的消费金额
	 * @return 保存成功返回的BlcgoepAggDO
	 */
	public BlcgoepAggDO[] doInBlcgOepAndUpdateEntAcc(BlOrderAppendBillParamDTO[] appendBillParamDTO, FDouble sum_amt) throws BizException {
		FDouble prepayAmount = null; // 预交金余额
		// 调用门诊账户接口
		IPatAccServiceExt patAccImpls = (IPatAccServiceExt) ServiceFinder.find(IPatAccServiceExt.class);
		// 计算门诊账户余额：调用门诊账户接口
		prepayAmount = patAccImpls.GetOutpPrepaymentAmount(appendBillParamDTO[0].getId_pat());
		// 与标准金额比较，当预交金余额不足时，需要进行示范允许后付费的判断
		if (prepayAmount.compareTo(sum_amt) < 0) {
			if (!appendBillParamDTO[0].getSupportAppendBill().booleanValue()) {
				// 国际提示
				throw new BizException("预交金不足，不支持预交金记账。本次待记账金额:"
						+ sum_amt.setScale(IBlConst.PRECISION_AMOUNT, BigDecimal.ROUND_HALF_UP).toString() + " 账户可用余额:"
						+ prepayAmount.setScale(IBlConst.PRECISION_AMOUNT, BigDecimal.ROUND_HALF_UP).toString() + " 差额:"
						+ sum_amt.sub(prepayAmount).setScale(IBlConst.PRECISION_AMOUNT, BigDecimal.ROUND_HALF_UP).toString());
			} else {
				// IF账户余额充足 THEN Y ELSE N
				for (BlOrderAppendBillParamDTO dto : appendBillParamDTO) {
					if (dto.getOutpBillDTO() == null) {
						BlOrderAppendOutpBillParamDTO outpBillDTO = new BlOrderAppendOutpBillParamDTO();
						dto.setOutpBillDTO(outpBillDTO);
					}
					dto.getOutpBillDTO().setFg_acc(FBoolean.FALSE);
					dto.getOutpBillDTO().setAmt_acc(null);
				}
			}
		} else {
			// IF账户余额充足 THEN Y ELSE N
			for (BlOrderAppendBillParamDTO dto : appendBillParamDTO) {
				if (dto.getOutpBillDTO() == null) {
					BlOrderAppendOutpBillParamDTO outpBillDTO = new BlOrderAppendOutpBillParamDTO();
					dto.setOutpBillDTO(outpBillDTO);
				}
				dto.getOutpBillDTO().setFg_acc(FBoolean.TRUE);
				dto.getOutpBillDTO().setAmt_acc(dto.getAmt_ratio());
			}
		}

		// 2017年8月1日 医嘱记账以单条生成一条主记录yang.lu
		
		BlcgoepAggDO[] blcgoepAggDOs = savecgAggDOs(appendBillParamDTO);

		if (null == blcgoepAggDOs) {
			throw new BizException("保存门诊记账信息失败");
		}

		// if
		// (!appendBillParamDTO[0].getOutpBillDTO().getFg_acc().booleanValue())
		// {
		// // 患者账户未授权，则不扣
		// }
		if (appendBillParamDTO[0].getOutpBillDTO() != null && appendBillParamDTO[0].getOutpBillDTO().getFg_acc().booleanValue()) {
			// 患者账户授权， 更新预交金余额 ：调用门诊账户接口
			PiPatAccDO piPatAccDO = patAccImpls.PatiAccPreAuthor(appendBillParamDTO[0].getId_pat(), sum_amt);
			if (null == piPatAccDO) {
				throw new BizException("保存患者预交金信息失败");
			}
		}
		return blcgoepAggDOs;
	}

	/**
	 * 保存记账数据
	 * 
	 * @param appendBillParamDTO
	 * @return
	 * @throws BizException
	 */
	private BlcgoepAggDO[] savecgAggDOs(BlOrderAppendBillParamDTO[] appendBillParamDTO) throws BizException {

		GetBlCgDO blCgIns = new GetBlCgDO();
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();

		ArrayList<BlcgoepAggDO> saveList = new ArrayList<BlcgoepAggDO>();
		for (BlOrderAppendBillParamDTO billParamDTO : appendBillParamDTO) {
			BlcgoepAggDO blcgoepAggDO = new BlcgoepAggDO();
			// 一条主记录
			blcgoepAggDO.setParentDO(blCgIns.GetBlCgOepDO(billParamDTO, strDateTime));
			// 一条明细记录
			blcgoepAggDO.setBlCgItmOepDO(blCgIns.GetBlCgItmOepDOs(new BlOrderAppendBillParamDTO[] { billParamDTO }, strDateTime, FBoolean.FALSE)); // 补费，非挂起状态
			saveList.add(blcgoepAggDO);
		}

		// 门诊记账
		Object obj = ServiceFinder.find(IBlcgoepCudService.class);

		BlcgoepAggDO[] blcgoepAggDOs = ((IBlcgoepCudService) obj).save(saveList.toArray(new BlcgoepAggDO[saveList.size()]));

		// 为避免退费异常，修改记账数据为 一条主数据一条明细记录 2017年8月1日 yang.lu ↓代码注释
		// GetBlCgDO blCgIns = new GetBlCgDO();
		// TimeService timeService = new TimeServiceImpl();
		// String strDateTime = timeService.getUFDateTime().toStdString();
		//
		// // 门诊记账
		// BlcgoepAggDO blcgoepAggDO = new BlcgoepAggDO();
		// // 一条主记录
		// blcgoepAggDO.setParentDO(blCgIns.GetBlCgOepDO(appendBillParamDTO[0],
		// strDateTime));
		// // 多条明细记录
		// blcgoepAggDO.setBlCgItmOepDO(blCgIns.GetBlCgItmOepDOs(appendBillParamDTO,
		// strDateTime, FBoolean.FALSE)); // 补费，非挂起状态
		// Object obj = ServiceFinder.find(IBlcgoepCudService.class);
		// BlcgoepAggDO[] blcgoepAggDOs = ((IBlcgoepCudService) obj).save(new
		// BlcgoepAggDO[] { blcgoepAggDO });
		// if (null == blcgoepAggDOs) {
		// throw new BizException("保存门诊记账信息失败");
		// }

		return blcgoepAggDOs;
	}

	/**
	 * 将费用明细记入住院记账表，且修改住院账户消费金额
	 * 
	 * @param appendBillParamDTO
	 *            需要保存的费用明细
	 * @param sum_amt
	 *            需要修改账户的消费金额
	 * @return 保存成功返回的BlcgoepAggDO
	 */
	public BlCgIpDO[] doInBlcgIpAndUpdateEntAcc(BlOrderAppendBillParamDTO[] appendBillParamDTO, FDouble sum_amt) throws BizException {
		FDouble prepayAmount = null; // 预交金余额
		GetBlCgDO blCgIns = new GetBlCgDO();
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();

		// 计算住院账户余额:调用住院账户接口

		// 调用新接口
		IEnOutQryService inpPatAccImpls = ServiceFinder.find(IEnOutQryService.class);
		BalanceDTO balanceDTO = inpPatAccImpls.getBalanceDTO(appendBillParamDTO[0].getId_ent());
		prepayAmount = balanceDTO.getAvailable();
		// 与标准金额比较，当预交金余额不足时，需要进行示范允许后付费的判断
		if (prepayAmount.compareTo(sum_amt) < 0) {
			if (!appendBillParamDTO[0].getSupportAppendBill().booleanValue()) {
				throw new BizException("住院预交金余额不足，不支持后付费！\r\n本次执行金额：" + sum_amt.setScale(-2, BigDecimal.ROUND_HALF_UP).toString() + "\r\n差额："
						+ sum_amt.sub(prepayAmount).setScale(-2, BigDecimal.ROUND_HALF_UP).toString());
			}
		}
		// 住院记账

		// 只存了主表
		BlCgIpDO[] blCgIpDOs = blCgIns.GetBlCgIpDOs(appendBillParamDTO, strDateTime);
		//根据医嘱
		BlCgIpDO[] blcgqueryAggDOArr = new BlCgIpDO[blCgIpDOs.length];
		for (int k = 0; k < blCgIpDOs.length; k++) {
			BlCgIpDO blcgqueryAggDO = blCgIpDOs[k];
			//blcgqueryAggDO.setParentDO(blCgIpDOs[k]);
			blcgqueryAggDOArr[k] = blcgqueryAggDO;
		}
		Object obj = ServiceFinder.find(IBlcgqueryCudService.class);
		BlCgIpDO[] blcgqueryAggDOs = ((IBlcgqueryCudService) obj).save(blcgqueryAggDOArr);

		if (null == blcgqueryAggDOs) {
			throw new BizException("保存住院记账信息失败");
		}
		IEnOutCmdService enAccService = ServiceFinder.find(IEnOutCmdService.class);
		// 更新预交金余额 ：调用住院账户接口
		enAccService.consume(appendBillParamDTO[0].getId_ent(), sum_amt);
		return blcgqueryAggDOs;
	}

	/**
	 * 根据服务ID（非物品），返回完整的BlOrderAppendBillParamDTO数组
	 * 
	 * @param appendBillParamDTOArr
	 *            挂号显示价格调用时：
	 *            1.id_pat,id_enttp,code_enttp,id_srv,quan,eu_direct(挂号填1
	 *            ),id_org_mp,id_dep_mp必填,其他字段可省;
	 *            2.如果需要支持后付费，则需要设置BlOrderAppendBillParamDTO
	 *            .setOutpBillDTO(OutpBillDTO)
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @param id_pripat
	 *            患者价格分类
	 * @return
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] getBlOrderAppendBillParamDTOArr(BlOrderAppendBillParamDTO[] appendBillParamDTOArr, OperatorInfoDTO operatorInfoDTO, String id_pripat) throws BizException {
		IPriCalService iPriCalService = ServiceFinder.find(IPriCalService.class);
		DAFacade dafacade = new DAFacade();
		//SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO = null;
		String[] srvFields = { "id_srv", "id_srvtp", "sd_srvtp", "id_srvca", "code", "id_unit_med", "name", "fg_mm" };
		FDouble price = new FDouble(0);
		FDouble amt = new FDouble(0);
		FDouble amt_pat = new FDouble(0);
		FDouble amt_hp = new FDouble(0);
		FDouble amt_std = new FDouble(0);
		
		// 2.计价
			// 2019-4-1移植解决挂号费不走特殊价标的问题
			Set<String> srvList = new HashSet<String>();
			List<String> pripatIdList = new ArrayList<String>();
			pripatIdList.add(id_pripat);
			for (BlOrderAppendBillParamDTO dto : appendBillParamDTOArr) {
				
				if(FBoolean.TRUE.equals(dto.getFg_mm()))
					continue;
				
				srvList.add(dto.getId_srv());
			}
			
			Map<String, BdPriViewDTO> priMap = new HashMap<String, BdPriViewDTO>();
			if(srvList.size() > 0){
				
				IBdPriCalService calService = ServiceFinder.find(IBdPriCalService.class);
				BdPriViewDTO[] priViewDtos = calService.calSrvPrice(
						srvList.toArray(new String[0]),
						pripatIdList.toArray(new String[0]));
				
				priMap = (Map<String, BdPriViewDTO>) MapUtils
						.convertArrayToMap(priViewDtos, "Id_srv,Id_pripat");
			}
				
		
		for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : appendBillParamDTOArr) {
			// 1.完善服务相关信息
			List<MedSrvDO> medSrvDOLst = (List<MedSrvDO>) dafacade.findByCond(MedSrvDO.class, "id_srv='" + blOrderAppendBillParamDTO.getId_srv() + "'", srvFields);
			if (medSrvDOLst != null && medSrvDOLst.size() > 0) {
				MedSrvDO[] medSrvDO = medSrvDOLst.toArray(new MedSrvDO[0]);
				// 主键查询，只有一行查询结果
				blOrderAppendBillParamDTO.setId_srvtp(medSrvDO[0].getId_srvtp());
				blOrderAppendBillParamDTO.setSd_srvtp(medSrvDO[0].getSd_srvtp());
				blOrderAppendBillParamDTO.setId_srvca(medSrvDO[0].getId_srvca());
				blOrderAppendBillParamDTO.setCode_srv(medSrvDO[0].getCode());
				blOrderAppendBillParamDTO.setSrvu(medSrvDO[0].getId_unit_med());
				blOrderAppendBillParamDTO.setName_srv(medSrvDO[0].getName());
				blOrderAppendBillParamDTO.setFg_mm(medSrvDO[0].getFg_mm());
				// blOrderAppendBillParamDTO.setSpec("/");
				if (blOrderAppendBillParamDTO.getFg_mm() != null && blOrderAppendBillParamDTO.getFg_mm().booleanValue()) {
					throw new BizException("该服务为物品，本接口不处理物品，服务ID：" + blOrderAppendBillParamDTO.getId_srv() + " 服务名称：" + blOrderAppendBillParamDTO.getName_srv());
				}
			} else {
				throw new BizException("服务未定义，服务ID：" + blOrderAppendBillParamDTO.getId_srv());
			}
			// 2.查价格
			String key = blOrderAppendBillParamDTO.getId_srv() +id_pripat ;
			BdPriViewDTO priDto = priMap.get(key);
			//srvPricalRateAndPriceDTO = iPriCalService.CalSingleSrvPriceByIdPripat_NameTip(blOrderAppendBillParamDTO.getId_srv(), blOrderAppendBillParamDTO.getName_srv(), id_pripat);
			if (priDto != null) {
				price=priDto.getPrice_std();
				// 折扣金额=折扣单价*数量 取2位小数
				amt = priDto.getPrice_ratio().multiply(blOrderAppendBillParamDTO.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP);
				amt_pat=amt;
				amt_hp=FDouble.ZERO_DBL;
				amt_std=priDto.getPrice_std().multiply(blOrderAppendBillParamDTO.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP);
				
				blOrderAppendBillParamDTO.setPrice(price);
				blOrderAppendBillParamDTO.setAmt(amt);
				blOrderAppendBillParamDTO.setAmt_pat(amt_pat);
				blOrderAppendBillParamDTO.setAmt_hp(amt_hp);
				blOrderAppendBillParamDTO.setAmt_std(amt_std);
				blOrderAppendBillParamDTO.setAmt_ratio(amt);
				blOrderAppendBillParamDTO.setRatio_pripat(priDto.getRate());
				blOrderAppendBillParamDTO.setPrice_ratio(priDto.getPrice_ratio());
				blOrderAppendBillParamDTO.setId_pripat(id_pripat);
				if (blOrderAppendBillParamDTO.getOutpBillDTO() != null) {
					if (blOrderAppendBillParamDTO.getOutpBillDTO().getFg_acc() != null && blOrderAppendBillParamDTO.getOutpBillDTO().getFg_acc().booleanValue()) {
						BlOrderAppendOutpBillParamDTO outpBillDTO = blOrderAppendBillParamDTO.getOutpBillDTO();
						outpBillDTO.setAmt_acc(amt); // 不考虑医保前提下，amt与amt_ratio相等
						blOrderAppendBillParamDTO.setOutpBillDTO(outpBillDTO);
					}
				}
			}

			// 3.医保计划类型和医保计划????????

			// 4.完善操作人员信息
			blOrderAppendBillParamDTO.setId_org(operatorInfoDTO.getId_org());
			blOrderAppendBillParamDTO.setId_grp(operatorInfoDTO.getId_grp());
			blOrderAppendBillParamDTO.setId_org_cg(operatorInfoDTO.getId_org_emp());
			blOrderAppendBillParamDTO.setId_emp_cg(operatorInfoDTO.getId_emp());
			blOrderAppendBillParamDTO.setId_org_or(operatorInfoDTO.getId_org());
			blOrderAppendBillParamDTO.setId_emp_or(operatorInfoDTO.getId_emp());
			blOrderAppendBillParamDTO.setId_dep_or(operatorInfoDTO.getId_dep());

			// 5.设标志
			blOrderAppendBillParamDTO.setFg_st(FBoolean.FALSE);
			blOrderAppendBillParamDTO.setFg_susp(FBoolean.FALSE);
			blOrderAppendBillParamDTO.setFg_refund(FBoolean.FALSE);
			blOrderAppendBillParamDTO.setFg_additm(FBoolean.FALSE);

			if (blOrderAppendBillParamDTO.getName_inccaitm() == null || blOrderAppendBillParamDTO.getName_inccaitm().trim().length() == 0) {
				// 完善账单码
				/*IncCaItmDO incCaItmDO = getInccaitmCodeAndName(blOrderAppendBillParamDTO.getCode_enttp(), blOrderAppendBillParamDTO.getId_srv());
				if (incCaItmDO != null) {
					blOrderAppendBillParamDTO.setName_inccaitm(incCaItmDO.getName());
					blOrderAppendBillParamDTO.setCode_inccaitm(incCaItmDO.getCode());
				}*/
			}
		}
		return appendBillParamDTOArr;
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
	 * 门诊记账表中信息转化成 List<BlOrderAppendBillParamDTO>
	 * 
	 * @param blcgoepAggDOs
	 * @return
	 */
	public List<BlOrderAppendBillParamDTO> getBlOrderAppendBillParamDTOFromCgOep(BlcgoepAggDO[] blcgoepAggDOs) {
		List<BlOrderAppendBillParamDTO> BlOrderAppendBillParamDTO_list_save = new ArrayList<BlOrderAppendBillParamDTO>();
		for (int ii = 0; ii < blcgoepAggDOs.length; ii++) {
			BlCgItmOepDO[] BlCgItmOepDO_list = blcgoepAggDOs[ii].getBlCgItmOepDO();
			for (int kk = 0; kk < BlCgItmOepDO_list.length; kk++) {
				BlOrderAppendBillParamDTO blOrderAppendBillParamDTO1 = new BlOrderAppendBillParamDTO();
				BlOrderAppendOutpBillParamDTO blOrderAppendOutpBillParamDTO1 = new BlOrderAppendOutpBillParamDTO();
				blOrderAppendOutpBillParamDTO1.setId_cgoep(blcgoepAggDOs[ii].getParentDO().getId_cgoep());
				blOrderAppendOutpBillParamDTO1.setId_cgitmoep(BlCgItmOepDO_list[kk].getId_cgitmoep());
				blOrderAppendOutpBillParamDTO1.setFg_acc(BlCgItmOepDO_list[kk].getFg_acc());
				blOrderAppendOutpBillParamDTO1.setFg_hpcg(BlCgItmOepDO_list[kk].getFg_hpcg());
				blOrderAppendBillParamDTO1.setOutpBillDTO(blOrderAppendOutpBillParamDTO1);
				blOrderAppendBillParamDTO1.setId_or(BlCgItmOepDO_list[kk].getId_or());
				blOrderAppendBillParamDTO1.setId_orsrv(BlCgItmOepDO_list[kk].getId_orsrv());
				blOrderAppendBillParamDTO1.setId_pat(BlCgItmOepDO_list[kk].getId_pat());
				blOrderAppendBillParamDTO1.setId_ent(BlCgItmOepDO_list[kk].getId_ent());
				blOrderAppendBillParamDTO1.setId_org(BlCgItmOepDO_list[kk].getId_org());
				blOrderAppendBillParamDTO1.setId_grp(BlCgItmOepDO_list[kk].getId_grp());
				blOrderAppendBillParamDTO1.setId_mm(BlCgItmOepDO_list[kk].getId_mm());
				blOrderAppendBillParamDTO1.setId_enttp(BlCgItmOepDO_list[kk].getId_enttp());
				blOrderAppendBillParamDTO1.setId_pres(BlCgItmOepDO_list[kk].getId_pres());
				blOrderAppendBillParamDTO1.setCode_enttp(BlCgItmOepDO_list[kk].getCode_enttp());

				blOrderAppendBillParamDTO1.setName_srv(BlCgItmOepDO_list[kk].getName_srv());
				blOrderAppendBillParamDTO1.setId_srv(BlCgItmOepDO_list[kk].getId_srv());
				blOrderAppendBillParamDTO1.setCode_srv(BlCgItmOepDO_list[kk].getCode_srv());
				blOrderAppendBillParamDTO1.setAmt(BlCgItmOepDO_list[kk].getAmt());
				blOrderAppendBillParamDTO1.setAmt_pat(BlCgItmOepDO_list[kk].getAmt_pat());
				blOrderAppendBillParamDTO1.setAmt_std(BlCgItmOepDO_list[kk].getAmt_std());
				blOrderAppendBillParamDTO1.setAmt_hp(BlCgItmOepDO_list[kk].getAmt_hp());
				blOrderAppendBillParamDTO1.setAmt_ratio(BlCgItmOepDO_list[kk].getAmt_ratio());
				blOrderAppendBillParamDTO1.setId_emp_cg(blcgoepAggDOs[ii].getParentDO().getId_emp_cg());
				blOrderAppendBillParamDTO1.setQuan(BlCgItmOepDO_list[kk].getQuan());
				blOrderAppendBillParamDTO1.setPrice(BlCgItmOepDO_list[kk].getPrice());
				blOrderAppendBillParamDTO1.setPrice_ratio(BlCgItmOepDO_list[kk].getPrice_ratio());
				blOrderAppendBillParamDTO1.setSrvu(BlCgItmOepDO_list[kk].getSrvu());

				blOrderAppendBillParamDTO1.setCode_apply(BlCgItmOepDO_list[kk].getCode_apply());
				blOrderAppendBillParamDTO1.setCode_applytp(BlCgItmOepDO_list[kk].getCode_applytp());
				blOrderAppendBillParamDTO1.setFg_free(BlCgItmOepDO_list[kk].getFg_free());
				blOrderAppendBillParamDTO1.setFg_additm(BlCgItmOepDO_list[kk].getFg_additm());
				BlOrderAppendBillParamDTO_list_save.add(blOrderAppendBillParamDTO1);
			}
		}
		return BlOrderAppendBillParamDTO_list_save;

	}

	/**
	 * 住院记账表中信息转化成 List<BlOrderAppendBillParamDTO>
	 * 
	 * @param blcgoepAggDOs
	 * @return
	 */
	public List<BlOrderAppendBillParamDTO> getBlOrderAppendBillParamDTOFromCgIp(BlCgIpDO[] blcgqueryAggDOs) {
		List<BlOrderAppendBillParamDTO> BlOrderAppendBillParamDTO_list_save = new ArrayList<BlOrderAppendBillParamDTO>();
		for (int kk = 0; kk < blcgqueryAggDOs.length; kk++) {
			BlCgIpDO blCgIpDO = blcgqueryAggDOs[kk];
			List<BlOrderAppendBillParamDTO> tempList = getBlOrderAppendBillParamDTOFromCgIpItms(new BlCgIpDO[] { blCgIpDO });
			BlOrderAppendBillParamDTO_list_save.addAll(tempList);

		}
		return BlOrderAppendBillParamDTO_list_save;
	}

	/**
	 * 住院记账表BlCgIp中信息转化成 List<BlOrderAppendBillParamDTO>
	 * 
	 * @param blcgoepAggDOs
	 * @return
	 */
	public List<BlOrderAppendBillParamDTO> getBlOrderAppendBillParamDTOFromCgIpItms(BlCgIpDO[] blCgIpDOArr) {
		List<BlOrderAppendBillParamDTO> BlOrderAppendBillParamDTO_list_save = new ArrayList<BlOrderAppendBillParamDTO>();
		for (BlCgIpDO blCgIpDO : blCgIpDOArr) {
			BlOrderAppendBillParamDTO blOrderAppendBillParamDTO1 = new BlOrderAppendBillParamDTO();
			BlOrderAppendInpBillParamDTO blOrderAppendInpBillParamDTO1 = new BlOrderAppendInpBillParamDTO();
			blOrderAppendInpBillParamDTO1.setId_cg(blCgIpDO.getId_cgip());
			blOrderAppendBillParamDTO1.setInpBillDTO(blOrderAppendInpBillParamDTO1);
			blOrderAppendBillParamDTO1.setId_or(blCgIpDO.getId_or());
			blOrderAppendBillParamDTO1.setId_orsrv(blCgIpDO.getId_orsrv());
			blOrderAppendBillParamDTO1.setId_pat(blCgIpDO.getId_pat());
			blOrderAppendBillParamDTO1.setId_ent(blCgIpDO.getId_ent());
			blOrderAppendBillParamDTO1.setId_org(blCgIpDO.getId_org());
			blOrderAppendBillParamDTO1.setId_grp(blCgIpDO.getId_grp());
			blOrderAppendBillParamDTO1.setId_mm(blCgIpDO.getId_mm());
			blOrderAppendBillParamDTO1.setId_enttp(blCgIpDO.getId_enttp());
			blOrderAppendBillParamDTO1.setCode_enttp(blCgIpDO.getCode_enttp());

			blOrderAppendBillParamDTO1.setName_srv(blCgIpDO.getName_srv());
			blOrderAppendBillParamDTO1.setId_srv(blCgIpDO.getId_srv());
			blOrderAppendBillParamDTO1.setCode_srv(blCgIpDO.getCode_srv());
			blOrderAppendBillParamDTO1.setAmt(blCgIpDO.getAmt());
			blOrderAppendBillParamDTO1.setAmt_pat(blCgIpDO.getAmt_pat());
			blOrderAppendBillParamDTO1.setAmt_std(blCgIpDO.getAmt_std());
			blOrderAppendBillParamDTO1.setAmt_hp(blCgIpDO.getAmt_hp());
			blOrderAppendBillParamDTO1.setPrice(blCgIpDO.getPrice());
			blOrderAppendBillParamDTO1.setPrice_ratio(blCgIpDO.getPrice_ratio());
			blOrderAppendBillParamDTO1.setQuan(blCgIpDO.getQuan());
			blOrderAppendBillParamDTO1.setSrvu(blCgIpDO.getSrvu());

			blOrderAppendBillParamDTO1.setId_or_pr(blCgIpDO.getId_or_pr());
			blOrderAppendBillParamDTO1.setId_or_pr_srv(blCgIpDO.getId_or_pr_srv());

			BlOrderAppendBillParamDTO_list_save.add(blOrderAppendBillParamDTO1);

		}
		return BlOrderAppendBillParamDTO_list_save;
	}

}
