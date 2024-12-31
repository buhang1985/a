package iih.mi.mc.s.ctrlcore.mimcwholecheck.rule;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import iih.mi.constant.IMiMcCheckConst;
import iih.mi.mc.dto.mimcwholerule.d.MiMcCheckFailResultEnum;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrdSrvDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrdSrvResultDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrderDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleInParamDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleOutParamDTO;
import iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp.MiCheckWholeMsgUtilBP;
import iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp.MiCheckWholeSetErrMsgBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
/**
 * 放射类医嘱校验规则
 * @author LIM
 * @since 2019-09-23
 */
public class MiCheckRadiationRule {
	/**
	 * 放射类医嘱校验（校验CT开立 一天只能开一个CT）
	 * @param inParamDto
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public MiMcWholeRuleOutParamDTO exec(MiMcWholeRuleInParamDTO inParamDto)throws BizException{
		MiMcWholeRuleOutParamDTO outParamDto= new MiMcWholeRuleOutParamDTO();
		outParamDto.setFg_checkflag(FBoolean.TRUE);//默认通过校验	
		//获取历史医嘱
		FArrayList2 historycidtoLst =(FArrayList2)Context.get().getAttribute(IMiMcCheckConst.CHECKWHOLE_HISCIORDERLIST);
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
		// 待提交医嘱集合
		FArrayList hpQryCiOrderCurrent = inParamDto.getCiorderlist();
		if(hpQryCiOrderCurrent!=null){
			for (Object item : hpQryCiOrderCurrent) {
				// 获取当医嘱
				MiMcOrderDTO ciorder = (MiMcOrderDTO) item;
				// 只校验CT类的
				if (ciorder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_CT)) {
					count_CT++;
					if (count_CT > 1) {
						outParamDto.setFg_checkflag(FBoolean.FALSE);
						String errMsg = MiCheckWholeMsgUtilBP.GetCheckRadiationMsg();
						MiMcOrdSrvDTO miMcOrdSrvDTO= new MiMcOrdSrvDTO();
						miMcOrdSrvDTO.setId_srv(ciorder.getId_srv());
						MiCheckWholeSetErrMsgBP setErrorInfoBP = new MiCheckWholeSetErrMsgBP();
						MiMcOrdSrvResultDTO itmChkRstDTO = new MiMcOrdSrvResultDTO();
						itmChkRstDTO = setErrorInfoBP.exec(ciorder,miMcOrdSrvDTO, MiMcCheckFailResultEnum.RADIATION_CLASS_ORDER,errMsg);
						if (itmChkRstDTO != null) {
							list.add(itmChkRstDTO);
						}
					}
				}
			}		
		}
		outParamDto.setErroritm_list(list);
		return outParamDto;
	}
}
