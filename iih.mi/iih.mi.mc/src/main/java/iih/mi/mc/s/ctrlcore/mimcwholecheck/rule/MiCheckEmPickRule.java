package iih.mi.mc.s.ctrlcore.mimcwholecheck.rule;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.mi.itf2.util.MiParamUtil;
import iih.mi.mc.dto.mimcwholerule.d.MiMcCheckFailResultEnum;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrdSrvDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrdSrvResultDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrderDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleInParamDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleOutParamDTO;
import iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp.MiCheckWholeMsgUtilBP;
import iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp.MiCheckWholeSetErrMsgBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 急诊领料量规则
 * 
 * @author LIM
 * @since 2019-09-23
 *
 */
public class MiCheckEmPickRule {
	/**
	 * 急诊领料量规则
	 * 
	 * @param inParamDto
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public MiMcWholeRuleOutParamDTO exec(MiMcWholeRuleInParamDTO inParamDto) throws BizException {
		MiMcWholeRuleOutParamDTO outParamDto = new MiMcWholeRuleOutParamDTO();
		outParamDto.setFg_checkflag(FBoolean.TRUE);// 默认通过校验
		int haveDays = MiParamUtil.MI3006(inParamDto.getId_hp());// 急诊领量限制天数
		int HerbhaveDays = MiParamUtil.MI3011(inParamDto.getId_hp());// 草药开单付数
		// 就诊类型为急诊流水、急诊抢救做判断。
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(inParamDto.getCode_entp())
				|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(inParamDto.getCode_entp())) { 
			FArrayList list = new FArrayList();
			for (Object openOrObj : inParamDto.getCiorderlist()) {
				MiMcOrderDTO ciOrderDO = (MiMcOrderDTO) openOrObj;
				// 中草药,西药(根据医嘱类型判定)
				if (ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)
						|| ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)) {
					int days;
					String unit = IBdSrvDictCodeConst.DAYS_UNIT;
					if (ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
						days = ciOrderDO.getQuan_orders();
						unit = IBdSrvDictCodeConst.ORDER_UNIT;
						// 草药校验付数 默认是7
						if (days > HerbhaveDays) {
							String errMsg = MiCheckWholeMsgUtilBP.getChronicOrSpecExcessMsg("草药" + days + unit + "："
									+ ciOrderDO.getContent_or().split("\\|")[2], null, new FDouble(HerbhaveDays), days, unit);
							outParamDto.setFg_checkflag(FBoolean.FALSE);
							MiMcOrdSrvResultDTO itmChkRstDTO = getReturnMsg(ciOrderDO, errMsg);
							if (itmChkRstDTO != null) {
								list.add(itmChkRstDTO);
							}
						}
					} else {
						days = ciOrderDO.getQuan_days();
						if (days > haveDays) {
							outParamDto.setFg_checkflag(FBoolean.FALSE);
							String errMsg = MiCheckWholeMsgUtilBP.GetCheckEmPickMsg(ciOrderDO.getName_or(), null,
									haveDays, days, unit);
							MiMcOrdSrvResultDTO itmChkRstDTO = getReturnMsg(ciOrderDO, errMsg);
							if (itmChkRstDTO != null) {
								list.add(itmChkRstDTO);
							}
						}
					}
				}
			}
			outParamDto.setErroritm_list(list);
		}
		
		return outParamDto;
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
	private MiMcOrdSrvResultDTO getReturnMsg(MiMcOrderDTO ciOrderDO, String errorMsg) throws BizException {
		MiCheckWholeSetErrMsgBP setErrorInfoBP = new MiCheckWholeSetErrMsgBP();
		MiMcOrdSrvResultDTO itmChkRstDTO = new MiMcOrdSrvResultDTO();
		MiMcOrdSrvDTO ordSrvDO = new MiMcOrdSrvDTO();
		ordSrvDO.setCode_srv(ciOrderDO.getCode_or());
		ordSrvDO.setName_srv(ciOrderDO.getName_or());
		itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO, ordSrvDO, MiMcCheckFailResultEnum.GREATER_THAN_GET_OEP, errorMsg);
		return itmChkRstDTO;
	}
}
