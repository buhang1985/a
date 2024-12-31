package iih.bl.hp.rule;

import java.util.Arrays;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.comm.util.BlMsgUtils;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckFailResultEnum;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.bl.hp.dto.d.ItmChkRstDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;

/**
 * 校验CT开立 一天只能开一个CT
 * 
 * @author LIM
 * @author yankan
 *
 */
public class CheckRadiationRule {
	/**
	 * 校验CT开立 一天只能开一个CT
	 * 
	 * @param ciHpCheckDTO
	 * @return
	 * @throws BizException
	 */
	public CiHpCheckResultDTO exec(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		CiHpCheckResultDTO ciHpCheckResultDTO = new CiHpCheckResultDTO();
		ciHpCheckResultDTO.setCheckflag(FBoolean.TRUE);// 默认通过校验
		// 待提交医嘱集合
		FArrayList2 hpQryCiOrderCurrent = ciHpCheckDTO.getSavecidto();
		// N日医嘱集合
		FArrayList2 historycidtoLst = ciHpCheckDTO.getHistorycidto();
		FArrayList list = new FArrayList();		
		int count_CT = 0;// ct类医嘱个数
		// 1.判断当天是否已有放射类医嘱
		if (historycidtoLst != null){ 
			// 校验历史医嘱		
			FDate serverDate = AppUtils.getServerDate();
			for (Object historycidto1 : historycidtoLst) {
				HpQryCiorderDTO historycidto = (HpQryCiorderDTO) historycidto1;				
				CiOrderDO ciorder = historycidto.getCiorderdo();// 获取当前医嘱信息
				if (DateTimeUtils.isInThisDay(ciorder.getDt_entry(), serverDate)
						&& ciorder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_CT)) {
					count_CT++;
					break;
				}
			}
		}
		if (hpQryCiOrderCurrent != null) {
			for (Object item : hpQryCiOrderCurrent) {
				HpQryCiorderDTO hpQryCiorderDTO = (HpQryCiorderDTO) item;
				// 获取当医嘱
				CiOrderDO ciorder = hpQryCiorderDTO.getCiorderdo();
				FArrayList2 ordsrvs = hpQryCiorderDTO.getOrdsrvs();
				// 只校验CT类的
				if (ciorder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_CT)) {
					count_CT++;
					if (count_CT > 1) {
						ciHpCheckResultDTO.setCheckflag(FBoolean.FALSE);
						// failidorsrvmap.put(ciorder.getId_srv(),
						// "存在多条放射类医嘱，请注意分开安排执行时间！" +
						// IBdPpCodeTypeConst.CHECK_CIHP_SAVE_DES_CODE_SPLIT
						// + CiHpCheckFailResultEnum.RADIATION_CLASS_ORDER);
						OrdSrvDO ord = new OrdSrvDO();
						ord.setCode_srv(ciorder.getId_or());
						ord.setName_srv(ciorder.getName_or());
						String errMsg = BlMsgUtils.GetCheckRadiationMsg();
						SetErrorInfoBP setErrorInfoBP = new SetErrorInfoBP();
						ItmChkRstDTO itmChkRstDTO = new ItmChkRstDTO();
						itmChkRstDTO = setErrorInfoBP.exec(ciorder, ord, errMsg,
								CiHpCheckFailResultEnum.RADIATION_CLASS_ORDER);
						if (itmChkRstDTO != null) {
							list.add(itmChkRstDTO);
						}
					}
				}
			}
		}
		// ciHpCheckResultDTO.setFailidorsrvmap(failidorsrvmap);
		//ciHpCheckResultDTO.setErroritm_list(list);
		ciHpCheckResultDTO.setCheckflag(FBoolean.TRUE);
		ciHpCheckResultDTO.setErroritm_list(new FArrayList());
		return ciHpCheckResultDTO;
	}
}
