package iih.bl.hp.rule;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.comm.util.BlMsgUtils;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckFailResultEnum;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.bl.hp.dto.d.ItmChkRstDTO;
import iih.bl.params.BlParams;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 急诊开单量 只校验西药、中草药
 * 
 * @author yankan
 * @since 2017-09-04
 *
 */
public class CheckEmPickRule {
	/**
	 * 急诊开单量
	 * 
	 * @param ciHpCheckDTO
	 * @return
	 * @throws BizException
	 */
	public CiHpCheckResultDTO exec(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		CiHpCheckResultDTO ciHpCheckResultDTO = new CiHpCheckResultDTO();
		ciHpCheckResultDTO.setCheckflag(FBoolean.TRUE);// 默认通过校验
		if (ciHpCheckDTO == null || ciHpCheckDTO.getEntdo() == null || !IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(ciHpCheckDTO.getEntdo().getCode_entp()) || ciHpCheckDTO.getSavecidto() == null) {
			return ciHpCheckResultDTO;
		}

		FArrayList list = new FArrayList();
		int haveDays = BlParams.BLHP000006();// 领量限制天数
		int HerbhaveDays = BlParams.BLHP000016();// 开单付数 > 7
		for (Object openOrObj : ciHpCheckDTO.getSavecidto()) {
			HpQryCiorderDTO openOrderDTO = (HpQryCiorderDTO) openOrObj;
			CiOrderDO ciOrderDO = openOrderDTO.getCiorderdo();
			// 中草药,西药(根据医嘱类型判定)
			if (ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG) || ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)) {
				int days;
				String unit = IBdSrvDictCodeConst.DAYS_UNIT;
				GetOpDaysBP getOpDaysBP = new GetOpDaysBP();
				if (ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
					days = getOpDaysBP.exec(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG, ciOrderDO);
					unit = IBdSrvDictCodeConst.ORDER_UNIT;
					// 草药校验付数 默认是7
					if (days > HerbhaveDays) {
						String errMsg = BlMsgUtils.getChronicOrSpecExcessMsg("草药" + ciOrderDO.getOrders() + unit + "：" + ciOrderDO.getContent_or().split("\\|")[2], null, HerbhaveDays, days, unit);
						ciHpCheckResultDTO.setCheckflag(FBoolean.FALSE);
						// ItmChkRstDTO itmChkRstDTO = new ItmChkRstDTO();
						ItmChkRstDTO itmChkRstDTO = getReturnMsg(ciOrderDO, errMsg);
						if (itmChkRstDTO != null) {
							list.add(itmChkRstDTO);
						}
					}
				} else {
					days = getOpDaysBP.exec(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG, ciOrderDO);

					if (days > haveDays) {
						ciHpCheckResultDTO.setCheckflag(FBoolean.FALSE);
						String errMsg = BlMsgUtils.GetCheckEmPickMsg(ciOrderDO.getName_or(), null, haveDays, ciOrderDO.getDays_or(), unit);
						// ItmChkRstDTO itmChkRstDTO = new ItmChkRstDTO();
						ItmChkRstDTO itmChkRstDTO = getReturnMsg(ciOrderDO, errMsg);
						if (itmChkRstDTO != null) {
							list.add(itmChkRstDTO);
						}
					}
				}
			}
		}
		ciHpCheckResultDTO.setErroritm_list(list);
		return ciHpCheckResultDTO;
	}

	/**
	 * 组装返回的提示信息
	 * 
	 * @param ciOrderDO
	 * @param ordSrvDO
	 * @param errorMsg
	 * @return
	 * @throws BizException
	 */
	private ItmChkRstDTO getReturnMsg(CiOrderDO ciOrderDO, String errorMsg) throws BizException {
		SetErrorInfoBP setErrorInfoBP = new SetErrorInfoBP();
		ItmChkRstDTO itmChkRstDTO = new ItmChkRstDTO();
		OrdSrvDO ordSrvDO = new OrdSrvDO();
		ordSrvDO.setId_srv(ciOrderDO.getId_or());
		ordSrvDO.setCode_srv(ciOrderDO.getCode_or());
		ordSrvDO.setName(ciOrderDO.getName_or());
		itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO, ordSrvDO, errorMsg, CiHpCheckFailResultEnum.GREATER_THAN_GET_OEP);
		return itmChkRstDTO;
	}
}
