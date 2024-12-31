package iih.bl.hp.rule;

import java.util.HashMap;

import org.apache.commons.collections.CollectionUtils;

import iih.bd.base.utils.FDoubleUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckFailResultEnum;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.bl.hp.dto.d.ItmChkRstDTO;
import iih.bl.hp.ep.FreqEP;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 单次执行医嘱领量限制
 * 
 * @author lm
 * @author yankan
 *
 */
public class CheckPickByOnePerformRule {
	/**
	 * 单次执行医嘱领量限制
	 * 
	 * @param ciHpCheckDTO
	 * @return
	 * @throws BizException
	 */
	public CiHpCheckResultDTO exec(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		CiHpCheckResultDTO checkResultDTO = new CiHpCheckResultDTO();
		checkResultDTO.setCheckflag(FBoolean.TRUE);// 默认通过校验
		if (ciHpCheckDTO == null || CollectionUtils.isEmpty(ciHpCheckDTO.getSavecidto())) {
			return checkResultDTO;
		}

		// 1、获取单次频次
		FreqEP freqEP = new FreqEP();
		HashMap<String, String> freqOnceMap = freqEP.getOnceFreqMap();

		// 2、校验单次执行领量
		FArrayList list = new FArrayList();
		for (Object hpQryCiorderDTO1 : ciHpCheckDTO.getSavecidto()) {
			HpQryCiorderDTO hpQryCiorderDTO = (HpQryCiorderDTO) hpQryCiorderDTO1;
			CiOrderDO ciOrderDO = (CiOrderDO) hpQryCiorderDTO.getCiorderdo();
			FArrayList2 ordsrvs_save = hpQryCiorderDTO.getOrdsrvs();
			FArrayList2 ordsrvmms_save = hpQryCiorderDTO.getOrdsrvmms();
			for (Object ordsrvs1 : ordsrvs_save) {
				OrdSrvDO ordsrv = (OrdSrvDO) ordsrvs1;
				// 过滤不限量药品
				if (ciHpCheckDTO.getId_mmLst().indexOf(ordsrv.getId_mm()) != -1) {
					continue;
				}
				if (!freqOnceMap.containsKey(ordsrv.getId_freq())) {
					continue;// 非单次则过滤不校验
				}
				if (ordsrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
					// 对于中草药，付数必须为1
					if (ciOrderDO.getOrders() != null && ciOrderDO.getOrders() > 1) {
						checkResultDTO.setCheckflag(FBoolean.FALSE);
						ItmChkRstDTO itmChkRstDTO = new ItmChkRstDTO();
						itmChkRstDTO = setErrorMessage(ciOrderDO, ordsrv);
						list.add(itmChkRstDTO);
					}
				} else if (ordsrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)) {
					for (Object ordsrvmms1 : ordsrvmms_save) {
						OrdSrvMmDO ordSrvMmDO = (OrdSrvMmDO) ordsrvmms1;
						if (!StringUtil.isEmpty(ordSrvMmDO.getId_orsrv()) && StringUtil.isEmpty(ordsrv.getId_orsrv())) {
							if (!ordSrvMmDO.getId_orsrv().equals(ordsrv.getId_orsrv())) {
								continue;
							}
						}
						if (FDoubleUtils.isMoreThanOne(ordSrvMmDO.getQuan_cur())) {
							checkResultDTO.setCheckflag(FBoolean.FALSE);
							ItmChkRstDTO itmChkRstDTO = new ItmChkRstDTO();
							itmChkRstDTO = setErrorMessage(ciOrderDO, ordsrv);
							list.add(itmChkRstDTO);
						}
					}
				}
			}
		}
		checkResultDTO.setErroritm_list(list);
		return checkResultDTO;
	}

	/**
	 * 设置错误消息
	 * 
	 * @param ciOrderDO
	 * @param ordsrv
	 * @return
	 * @throws BizException
	 */
	private ItmChkRstDTO setErrorMessage(CiOrderDO ciOrderDO, OrdSrvDO ordsrv) throws BizException {
		SetErrorInfoBP setErrorInfoBP = new SetErrorInfoBP();
		ItmChkRstDTO itmChkRstDTO = new ItmChkRstDTO();
		String errMsg = ordsrv.getName() + ":\r\n对于单次执行（频次为ST、ONCE、PRN）的医嘱领量只允许为1，不得超出1！";
		itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO, ordsrv, errMsg, CiHpCheckFailResultEnum.GREATER_THAN_ONE_TIME);
		return itmChkRstDTO;
	}
}
