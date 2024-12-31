package iih.bl.hp.rule;

import iih.bd.base.utils.CollectionUtils;
import iih.bd.base.utils.FBooleanUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.comm.util.BlMsgUtils;
import iih.bl.hp.bp.AnalysisDiBP;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckFailResultEnum;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.bl.hp.dto.d.DiStatsDTO;
import iih.bl.hp.dto.d.ItmChkRstDTO;
import iih.bl.hp.hpque.bp.CheckSpecillBP;
import iih.bl.params.BlParams;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import iih.en.pv.entplan.d.EntHpDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 门诊开单量限制
 * 
 * @author yankan
 * @since 2017-09-01 重构
 *
 */
public class CheckOpBillDaysRule {

	/**
	 * 门诊开单量限制
	 * 
	 * @param ciHpCheckDTO
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public CiHpCheckResultDTO exec(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		// 创建默认检查结构
		CiHpCheckResultDTO chkResult = new CiHpCheckResultDTO();
		chkResult.setCheckflag(FBoolean.TRUE);// 默认通过校验
		// 如果就诊信息为空、非门诊、保存医嘱为空，则返回
		if (ciHpCheckDTO == null || ciHpCheckDTO.getEntdo() == null || !IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ciHpCheckDTO.getEntdo().getCode_entp()) || CollectionUtils.isEmpty(ciHpCheckDTO.getSavecidto())) {
			return chkResult;
		}

		// 1、获取主医保计划
		EntHpDO mainHpDO = this.getMainHpDO(ciHpCheckDTO.getEnthpdo());
		if (mainHpDO == null) {
			return chkResult;
		}

		// 2、通过参数，获取校验天数的限制值
		int haveDays_mxb = BlParams.BLHP000007();// 开单天数默认30天
		int haveDays_xdbb = BlParams.BLHP000008();// 行动不便开单天数默认14天
		int haveDays = BlParams.BLHP000009();// 开单天数 > 7
		int HerbhaveDays = BlParams.BLHP000016();// 开单付数 > 7
		// 3、分析诊断
		AnalysisDiBP analysisDi = new AnalysisDiBP();
		DiStatsDTO diStatsDTO = analysisDi.exec(ciHpCheckDTO.getCi_di_itms());

		// 4、校验规则
		chkResult.setErroritm_list(new FArrayList());// 默认值
		for (Object item : ciHpCheckDTO.getSavecidto()) {
			HpQryCiorderDTO hpQryCiorderDTO = (HpQryCiorderDTO) item;
			CiOrderDO ciOrderDO = hpQryCiorderDTO.getCiorderdo();
			FArrayList2 orsrvLst = hpQryCiorderDTO.getOrdsrvs();
			for (Object orsrv : orsrvLst) {
				OrdSrvDO ordSrvDO = (OrdSrvDO) orsrv;
				if (StringUtil.isEmpty(ordSrvDO.getId_mm())) {
					continue;
				}
				// 过滤不限量药品
				// if (ciHpCheckDTO.getId_mmLst().indexOf(ordSrvDO.getId_mm())
				// != -1) {
				// continue;
				// }
				// 只校验西药、草药
				if (!ordSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG) && !ordSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)) {
					continue;
				}
				SetErrorInfoBP setErrorInfoBP = new SetErrorInfoBP();
				ItmChkRstDTO itmChkRstDTO = new ItmChkRstDTO();
				// 是否特殊病
				CheckSpecillBP checkSpecillBP = new CheckSpecillBP();
				// 判断是草药还是西药 草药按付数提示 西药按医嘱的开单天数进行校验
				int days;
				String unit = IBdSrvDictCodeConst.DAYS_UNIT;
				GetOpDaysBP getOpDaysBP = new GetOpDaysBP();
				if (ordSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
					days = getOpDaysBP.exec(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG, ciOrderDO);
					unit = IBdSrvDictCodeConst.ORDER_UNIT;
					// 草药校验付数 默认是7
					if (days > HerbhaveDays) {
						String errorMsg = BlMsgUtils.getChronicOrSpecExcessMsg("草药" + ciOrderDO.getOrders() + unit + "：" + ciOrderDO.getContent_or().split("\\|")[2], null, HerbhaveDays, days, unit);
						chkResult.setCheckflag(FBoolean.FALSE);
						itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO, ordSrvDO, errorMsg, CiHpCheckFailResultEnum.GREATER_THAN_GET_OEP);
						chkResult.getErroritm_list().add(itmChkRstDTO);
						break;
					}
				} else {
					days = getOpDaysBP.exec(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG, ciOrderDO);
				}
				// (工伤医保,特病医保) || 诊断是慢性病）
				if (IBdPpCodeTypeConst.SD_HP_BJ_KIND_INSUR.equals(mainHpDO.getCode_hpkind()) || FBooleanUtils.isTrue(checkSpecillBP.exec(ordSrvDO.getId_mm(), ciHpCheckDTO.getId_ent(), ciHpCheckDTO.getCi_di_itms())) || FBooleanUtils.isTrue(diStatsDTO.getFg_haschronic())) {
					if (days > haveDays_mxb) {
						String errorMsg = BlMsgUtils.getChronicOrSpecExcessMsg(ciOrderDO.getName_or(), BlMsgUtils.getOrderMmList(ordSrvDO.getId_orsrv(), ordSrvDO.getId_srv(), hpQryCiorderDTO.getOrdsrvmms()), haveDays_mxb, days, unit);
						chkResult.setCheckflag(FBoolean.FALSE);
						itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO, ordSrvDO, errorMsg, CiHpCheckFailResultEnum.GREATER_THAN_GET_OEP);
						chkResult.getErroritm_list().add(itmChkRstDTO);
					}
				} else if (FBooleanUtils.isTrue(diStatsDTO.getFg_hasmovediff())) {
					// 行动不便
					if (days > haveDays_xdbb) {
						chkResult.setCheckflag(FBoolean.FALSE);
						String errorMsg = BlMsgUtils.getDiffToMoveMsgExcessMsg(ciOrderDO.getName_or(), BlMsgUtils.getOrderMmList(ordSrvDO.getId_orsrv(), ordSrvDO.getId_srv(), hpQryCiorderDTO.getOrdsrvmms()), haveDays_xdbb, days, unit);
						itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO, ordSrvDO, errorMsg, CiHpCheckFailResultEnum.GREATER_THAN_GET_OEP);
						chkResult.getErroritm_list().add(itmChkRstDTO);
					}
				} else if (days > haveDays) {
					// 普通
					chkResult.setCheckflag(FBoolean.FALSE);
					String errorMsg = BlMsgUtils.getBillExcessMsg(ciOrderDO.getName_or(), BlMsgUtils.getOrderMmList(ordSrvDO.getId_orsrv(), ordSrvDO.getId_srv(), hpQryCiorderDTO.getOrdsrvmms()), haveDays, days, unit);
					itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO, ordSrvDO, errorMsg, CiHpCheckFailResultEnum.GREATER_THAN_GET_OEP);
					chkResult.getErroritm_list().add(itmChkRstDTO);
				}
			}
		}
		return chkResult;
	}

	/**
	 * 获取就诊的主医保计划
	 * 
	 * @param entHpList
	 * @return
	 */
	private EntHpDO getMainHpDO(FArrayList2 entHpList) {
		if (entHpList == null || entHpList.size() <= 0) {
			return null;
		}
		EntHpDO mainHpDO = null;
		for (Object enHpDO1 : entHpList) {
			EntHpDO enhpdo = (EntHpDO) enHpDO1;
			if (FBooleanUtils.isTrue(enhpdo.getFg_maj())) {
				mainHpDO = enhpdo; // 主医保
				break;
			}
		}
		return mainHpDO;
	}

}
