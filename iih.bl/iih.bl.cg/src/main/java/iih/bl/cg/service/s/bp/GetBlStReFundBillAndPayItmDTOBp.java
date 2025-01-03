package iih.bl.cg.service.s.bp;

import iih.bd.base.utils.CollectionUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.cg.dto.blcgprinfo.d.BlCgPrInfoDTO;
import iih.bl.cg.dto.cglogic.d.BlCgApplyDTO;
import iih.bl.cg.service.s.bp.qry.GetBlStReFundBillDTOQry;
import iih.bl.comm.util.BlSqlQueryUtil;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.i.IBlPayItmPatOepDORService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;
import iih.bl.st.dto.d.BlStReFundBillAndPayItmDTO;
import iih.bl.st.dto.d.BlStReFundBillDTO;
import iih.mp.dg.dto.d.OpDgRtnAmountDTO;
import iih.mp.dg.i.IMpDgOutService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 退费提取明细数据
 * 
 * @author yang.lu
 * @since 2017年6月26日
 */
public class GetBlStReFundBillAndPayItmDTOBp {
	/**
	 * 退费提取明细数据和支付方式
	 * 
	 * @param id_stoep
	 * @return
	 * @throws BizException
	 */
	public BlStReFundBillAndPayItmDTO exec(String id_stoep) throws BizException {
		BlStReFundBillAndPayItmDTO blStReFundBillAndPrePaySrvpmDTO = new BlStReFundBillAndPayItmDTO();

		// 1.获取记账明细数据
		blStReFundBillAndPrePaySrvpmDTO.setBlStReFundBillDTO(GetBlStReFundBillDTO(id_stoep));
		// 2.获得收付款_预交金_费用来源_门急体
		IBlPayItmPatOepDORService itmService = ServiceFinder.find(IBlPayItmPatOepDORService.class);
		BlPayItmPatOepDO[] itmPatOepDOs = itmService.find(
				"id_paypatoep=(SELECT id_paypatoep FROM BL_ST_OEP WHERE ID_STOEP='" + id_stoep + "')", "",
				FBoolean.FALSE);
		blStReFundBillAndPrePaySrvpmDTO.setBlPayItmPatOepDO(CollectionUtils.toFArrayList2(itmPatOepDOs));

		return blStReFundBillAndPrePaySrvpmDTO;
	}

	/**
	 * 获取记账明细数据
	 * 
	 * @param id_stoep
	 * @return
	 * @throws BizException
	 */
	private FArrayList2 GetBlStReFundBillDTO(String id_stoep) throws BizException {

		BlStReFundBillDTO[] blStReFundBillDTOs = (BlStReFundBillDTO[]) AppFwUtil
				.getDORstWithDao(new GetBlStReFundBillDTOQry(id_stoep), BlStReFundBillDTO.class);

		//补充订单信息
		this.addApplyInfo(blStReFundBillDTOs);
		
		// id_or的集合(调用查询执行信息的入参)
		List<String> ordIdList = new ArrayList<String>();

		// 1调用药品接口，获得可退数量
		List<String> Refund_mm_id_orsrv = new ArrayList<String>();
		List<OpDgRtnAmountDTO> opDgRtnAmountDTOLst = new ArrayList<OpDgRtnAmountDTO>();

		for (int i = 0; i < blStReFundBillDTOs.length; i++) {
			// 判断是否是物品 药品
			if (blStReFundBillDTOs[i].getSd_srvtp() != null && blStReFundBillDTOs[i].getSd_srvtp().indexOf("01") == 0 && FBoolean.TRUE.equals(blStReFundBillDTOs[i].getFg_or())) {
				Refund_mm_id_orsrv.add(blStReFundBillDTOs[i].getId_orsrv());
				OpDgRtnAmountDTO opDgRtnAmountDTO = new OpDgRtnAmountDTO();
				opDgRtnAmountDTO.setId_orsrv(blStReFundBillDTOs[i].getId_orsrv());
				opDgRtnAmountDTO.setCharged_amount(blStReFundBillDTOs[i].getQuan());
				opDgRtnAmountDTOLst.add(opDgRtnAmountDTO);
			} else {
				// 医技
				if (blStReFundBillDTOs[i].getFg_feertnable() != null
						&& !blStReFundBillDTOs[i].getFg_feertnable().booleanValue()) {
					blStReFundBillDTOs[i].setCan_quan(new FDouble(0));
				}
				if (!StringUtil.isEmpty(blStReFundBillDTOs[i].getId_or())) {
					ordIdList.add(blStReFundBillDTOs[i].getId_or());
				}
			}
		}

		if (!ListUtil.isEmpty(ordIdList)) {
			// 给非药品医嘱的执行人员和执行状态赋值
			BlCgPrInfoDTO[] blCgPrInfoDTOs = BlSqlQueryUtil.getOrdPrInfo(ordIdList.toArray(new String[] {}));
			for (BlStReFundBillDTO itm : blStReFundBillDTOs) {
				if (!ArrayUtil.isEmpty(blCgPrInfoDTOs)) {
					for (BlCgPrInfoDTO itmChild : blCgPrInfoDTOs) {
						if (!StringUtil.isEmpty(itm.getId_or())) {
							if (itm.getId_or().equals(itmChild.getId_or())) {
								itm.setName_emp_cg(itmChild.getName_emp_mp());
								itm.setName_su_mp(itmChild.getName_eusu());
								break;
							}
						}
					}
				}
			}
		}

		IBlstoepRService stService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO stDO = stService.findById(id_stoep);
		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(stDO.getCode_enttp()) || IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(stDO.getCode_enttp())){
			return CollectionUtils.toFArrayList2(blStReFundBillDTOs);
		}
		
		// TODO 此方法可以优化为 map 可以减少一次循环
		// 2.调用物品域接口 设置可退数量与 是否领药的状态
		if (opDgRtnAmountDTOLst.size() > 0) {
			IMpDgOutService iMpDgOutService = ServiceFinder.find(IMpDgOutService.class);
			OpDgRtnAmountDTO[] opDgRtnAmountDTOs = iMpDgOutService
					.getOpDgRtnAmount(opDgRtnAmountDTOLst.toArray(new OpDgRtnAmountDTO[0]));

			if (opDgRtnAmountDTOs != null && opDgRtnAmountDTOs.length > 0) {
				for (int i = 0; i < blStReFundBillDTOs.length; i++) {
					if (blStReFundBillDTOs[i].getSd_srvtp() != null
							&& blStReFundBillDTOs[i].getSd_srvtp().indexOf("01") > -1
							&& FBoolean.TRUE.equals(blStReFundBillDTOs[i].getFg_or())) {
						for (int j = 0; j < opDgRtnAmountDTOs.length; j++) {
							if (opDgRtnAmountDTOs[j].getId_orsrv().equals(blStReFundBillDTOs[i].getId_orsrv())) {
								// 设置可退数
								blStReFundBillDTOs[i].setCan_quan(opDgRtnAmountDTOs[j].getRtn_amount());
								// 是否领药
								if (opDgRtnAmountDTOs[j].getFg_get().booleanValue()) {
									blStReFundBillDTOs[i].setFg_pat_getmm(FBoolean.TRUE); // 已领药
								} else {
									blStReFundBillDTOs[i].setFg_pat_getmm(FBoolean.FALSE); // 未发药
								}

								// 药品医嘱设置执行状态
								if (blStReFundBillDTOs[i].getCan_quan() == FDouble.ZERO_DBL) {
									blStReFundBillDTOs[i].setName_su_mp("已领用，不可退");
									// 药品医嘱设置执行人员（发药人员）
									blStReFundBillDTOs[i].setName_emp_cg(opDgRtnAmountDTOs[j].getName_emp_dp());// 物品接口返回
								} else if (!blStReFundBillDTOs[i].getFg_pat_getmm().booleanValue()) {
									blStReFundBillDTOs[i].setName_su_mp("未领用");
									// 药品医嘱设置执行人员（发药人员）
									blStReFundBillDTOs[i].setName_emp_cg("");// 物品接口返回
								} else {
									blStReFundBillDTOs[i].setName_su_mp("已退药");
									// 药品医嘱设置执行人员（发药人员）
									blStReFundBillDTOs[i].setName_emp_cg("");// 物品接口返回
								}
								break;
							}
						}
					}
				}
			}
			// //记日志，便于查询
			// BlCgLogsRecordUtil.setIBlCgLogsRecordService(ServiceFinder.find(IBlCgLogsRecordService.class));
			// BlCgLogsRecordUtil.getIBlCgLogsRecordService().recordBlCgVsMMLogs(timeService.getUFDateTime(),info.toString());
		}

		return CollectionUtils.toFArrayList2(blStReFundBillDTOs);
	}

	/**
	 * 补充单据信息
	 * 
	 * @param orDtos
	 * @throws BizException
	 */
	private void addApplyInfo(BlStReFundBillDTO[] orDtos) throws BizException {

		Set<String> drugOrsrvSet = new HashSet<String>();// 药品
		Set<String> risOrSet = new HashSet<String>(); // 检查
		Set<String> lisOrSet = new HashSet<String>(); // 检验
		Set<String> bingliOrSet = new HashSet<String>(); // 病理
		Set<String> otherOrsrvSet = new HashSet<String>(); // 其他

		for (BlStReFundBillDTO orDto : orDtos) {

			// 暂时只处理原医嘱数据
			if (StringUtil.isEmpty(orDto.getId_or()) || StringUtil.isEmpty(orDto.getId_orsrv()))
				continue;

			if (orDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
				drugOrsrvSet.add(orDto.getId_orsrv());
			} else if (IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI.equals(orDto.getSd_srvtp())) {
				bingliOrSet.add(orDto.getId_or());
			} else if (orDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
				risOrSet.add(orDto.getId_or());
			} else if (orDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)) {
				lisOrSet.add(orDto.getId_or());
			} else {
				otherOrsrvSet.add(orDto.getId_orsrv());
			}
		}

		Map<String, BlCgApplyDTO> applyMap = new HashMap<String, BlCgApplyDTO>();

		if (drugOrsrvSet.size() > 0) {
			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getPresCode(drugOrsrvSet.toArray(new String[0]));
			if (!ArrayUtil.isEmpty(applyDtos)) {
				for (BlCgApplyDTO blCgApplyDTO : applyDtos) {
					applyMap.put(blCgApplyDTO.getId_key(), blCgApplyDTO);
				}
			}
		}

		if (risOrSet.size() > 0) {
			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getRisCode(risOrSet.toArray(new String[0]));
			if (!ArrayUtil.isEmpty(applyDtos)) {
				for (BlCgApplyDTO blCgApplyDTO : applyDtos) {
					applyMap.put(blCgApplyDTO.getId_key(), blCgApplyDTO);
				}
			}
		}

		if (lisOrSet.size() > 0) {
			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getLisCode(lisOrSet.toArray(new String[0]));
			if (!ArrayUtil.isEmpty(applyDtos)) {
				for (BlCgApplyDTO blCgApplyDTO : applyDtos) {
					applyMap.put(blCgApplyDTO.getId_key(), blCgApplyDTO);
				}
			}
		}

		if (bingliOrSet.size() > 0) {
			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getBingliCode(bingliOrSet.toArray(new String[0]));
			if (!ArrayUtil.isEmpty(applyDtos)) {
				for (BlCgApplyDTO blCgApplyDTO : applyDtos) {
					applyMap.put(blCgApplyDTO.getId_key(), blCgApplyDTO);
				}
			}
		}

		if (otherOrsrvSet.size() > 0) {
			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getOtherPrnCode(otherOrsrvSet.toArray(new String[0]));
			if (!ArrayUtil.isEmpty(applyDtos)) {
				for (BlCgApplyDTO blCgApplyDTO : applyDtos) {
					applyMap.put(blCgApplyDTO.getId_key(), blCgApplyDTO);
				}
			}
		}

		// 单据信息
		for (BlStReFundBillDTO orDto : orDtos) {
			if (!StringUtil.isEmpty(orDto.getId_or()) && !StringUtil.isEmpty(orDto.getId_orsrv())) {

				BlCgApplyDTO applyDto = applyMap.get(orDto.getId_or());
				if (applyDto == null) {
					applyDto = applyMap.get(orDto.getId_orsrv());
				}

				if (applyDto != null) {
					orDto.setApplyno(applyDto.getApplyno());
					orDto.setCode_bill(applyDto.getApplyno());// TODO
				}
			}
		}
	}
}
