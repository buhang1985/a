package iih.mi.mc.s.ctrlcore.mimcwholecheck.rule;

import java.util.HashMap;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.mi.constant.IMiMcCheckConst;
import iih.mi.itf2.util.MiParamUtil;
import iih.mi.mc.dto.mimcwholerule.d.MiMcCheckFailResultEnum;
import iih.mi.mc.dto.mimcwholerule.d.MiMcDiDefDTO;
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
import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 门诊领料量校验规则（开单量）
 * 
 * @author LIM
 * @since 2019-09-23
 *
 */
public class MiCheckOpPickRule  extends MiCheckBaseRule{
	/**
	 * 执行门诊领料量校验规则
	 * 
	 * @param inParamDto
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public MiMcWholeRuleOutParamDTO exec(MiMcWholeRuleInParamDTO inParamDto) throws BizException {
		MiMcWholeRuleOutParamDTO outParamDto = new MiMcWholeRuleOutParamDTO();
		outParamDto.setFg_checkflag(FBoolean.TRUE);// 默认通过校验
		// 1.判断诊断
		// 1.1诊断list
		FArrayList cidiList = inParamDto.getCidilist();
		// 1.2校验是否存在慢病行动不便诊断
		MiMcDiDefDTO miMcDiDefDTO=this.getDiFlag(cidiList);
		// 是否存在慢病诊断
		FBoolean fg_ExistChronicDi = miMcDiDefDTO.getFg_haschronic();
		// 是否存在行动不便诊断
		FBoolean fg_ExistMoveDiffDi = miMcDiDefDTO.getFg_hasmovediff();
		
		// 2、通过参数，获取校验天数的限制值
		String id_hp = inParamDto.getId_hp();
		int haveDays_mxb = MiParamUtil.MI3003(id_hp);// 慢病开单天数默认30天
		int haveDays_xdbb = MiParamUtil.MI3004(id_hp);// 行动不便开单天数默认14天
		int haveDays = MiParamUtil.MI3005(id_hp);// 普通开单天数 > 7
		int HerbhaveDays = MiParamUtil.MI3007(id_hp);// 草药开单付数
		//int orderMode = MiParamUtil.MHIR0001();// 0：采用病种模式；1:诊断模式（去除特殊病校验）

		// 3.获取特病患者诊断（病种）限制药品量 （去除特殊病校验）
//		MiCheckSpecillBP miCheckSpecillBP = new MiCheckSpecillBP();
//		HashMap<String, MiMcSpecDrugLimitDTO> specPatLimitList = miCheckSpecillBP.exec(inParamDto.getId_hp(), inParamDto.getId_pat(), orderMode);

		// 4.获取患者当月开单量
//		FMap patDrugMap =this.getPatDrugMap(inParamDto.getId_pat());
		HashMap<String,Integer> mmCurMap= new HashMap<String,Integer>();
		
		// 5、校验规则
		outParamDto.setErroritm_list(new FArrayList());// 默认值
		for (Object item : inParamDto.getCiorderlist()) {
			MiMcOrderDTO ciOrderDO = (MiMcOrderDTO) item;
			FArrayList orsrvLst = ciOrderDO.getOrdsrvlist();
			for (Object orsrv : orsrvLst) {
				MiMcOrdSrvDTO ordSrvDO = (MiMcOrdSrvDTO) orsrv;
				if (StringUtil.isEmpty(ordSrvDO.getId_mm())) {
					continue;
				}
				// 只校验西药、草药   不校验特殊病药品
				if (!ordSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG) 
						&& !ordSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)|| FBoolean.TRUE.equals(ordSrvDO.getSpecdrug_flag())) {
					continue;
				}
				// 判断是草药还是西药 草药按付数提示 西药按医嘱的开单天数进行校验
				int days;
				String unit = IBdSrvDictCodeConst.DAYS_UNIT;
				if (ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
					days = ciOrderDO.getQuan_orders();
					unit = IBdSrvDictCodeConst.ORDER_UNIT;
				} else {
					days = ciOrderDO.getQuan_days();
				}
				MiCheckWholeSetErrMsgBP setErrorInfoBP = new MiCheckWholeSetErrMsgBP();
				MiMcOrdSrvResultDTO itmChkRstDTO = new MiMcOrdSrvResultDTO();
				//（去除特殊病校验）
//				String sKey = orderMode == 0 ? ordSrvDO.getId_dsdef() + ordSrvDO.getId_mm() : ordSrvDO.getId_mm();
//				FBoolean bSpecJudge = FBoolean.FALSE;// 是否参与了特殊病判断
//				// 特殊病病判断
//				if (specPatLimitList.containsKey(sKey)) {
//					MiMcSpecDrugLimitDTO specDto = specPatLimitList.get(sKey);
//					int specLimitQuan = specDto.getQuan_limit();
//
//					FBoolean bValid;
//					// 按月控制
//					if (MiMcDrugControlEnum.CONTROLMONTH == specDto.getSd_control()) {
//						FDouble patDrugQuan = new FDouble(0);
//						// 获取患者当月开单量
//						if (patDrugMap.containsKey(sKey)) {
//							patDrugQuan = (FDouble)patDrugMap.get(sKey);
//						}
//						bValid = ordSrvDO.getFactor().multiply(ordSrvDO.getFactor_mb()).multiply(days).add(patDrugQuan).compareTo(specLimitQuan) > 0 ? FBoolean.TRUE : FBoolean.FALSE;
//					} else {
//						// 按天控制
//						bValid = days > specLimitQuan ? FBoolean.TRUE : FBoolean.FALSE;
//					}
//					if (FBoolean.TRUE.equals(bValid)) {
//						String errorMsg = MiCheckWholeMsgUtilBP.getChronicOrSpecExcessMsg(ciOrderDO.getName_or(), ordSrvDO.getName_mm(), specLimitQuan, days, unit);
//						outParamDto.setFg_checkflag(FBoolean.FALSE);
//						itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO, ordSrvDO, MiMcCheckFailResultEnum.GREATER_THAN_GET_OEP, errorMsg);
//						outParamDto.getErroritm_list().add(itmChkRstDTO);
//						continue;
//					}
//					bSpecJudge = FBoolean.TRUE;
//				}
				if(mmCurMap.containsKey(ordSrvDO.getId_mm())){
					days=mmCurMap.get(ordSrvDO.getId_mm())+days;
					mmCurMap.put(ordSrvDO.getId_mm(), days);
					
				}else{
					mmCurMap.put(ordSrvDO.getId_mm(), days);
				}
				// 没有参与特殊病判断的才走正常医保校验
//				if (FBoolean.FALSE.equals(bSpecJudge)) {
				// 如果是草药按照参数mi3007来统一限制，不区分慢病、行动不便 2020-02-12
				if (ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
					if (days > HerbhaveDays) {
						String errorMsg = MiCheckWholeMsgUtilBP.getChronicOrSpecExcessMsg(ciOrderDO.getName_or(), ordSrvDO.getName_mm(), new FDouble(HerbhaveDays), days, unit);
						outParamDto.setFg_checkflag(FBoolean.FALSE);
						itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO, ordSrvDO, MiMcCheckFailResultEnum.GREATER_THAN_GET_OEP, errorMsg);
						outParamDto.getErroritm_list().add(itmChkRstDTO);						
					}
				}else{
					// (工伤医保,特病医保) ||慢性病）
					if (FBoolean.TRUE.equals(fg_ExistChronicDi)) {
						if (days > haveDays_mxb) {
							String errorMsg = MiCheckWholeMsgUtilBP.getChronicOrSpecExcessMsg(ciOrderDO.getName_or(), ordSrvDO.getName_mm(), new FDouble(haveDays_mxb), days, unit);
							outParamDto.setFg_checkflag(FBoolean.FALSE);
							itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO, ordSrvDO, MiMcCheckFailResultEnum.GREATER_THAN_GET_OEP, errorMsg);
							outParamDto.getErroritm_list().add(itmChkRstDTO);
						}
					} else if (FBoolean.TRUE.equals(fg_ExistMoveDiffDi)) {
						// 行动不便
						if (days > haveDays_xdbb) {
							outParamDto.setFg_checkflag(FBoolean.FALSE);
							String errorMsg = MiCheckWholeMsgUtilBP.getDiffToMoveMsgExcessMsg(ciOrderDO.getName_or(), ordSrvDO.getName_mm(), haveDays_xdbb, days, unit);
							itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO, ordSrvDO, MiMcCheckFailResultEnum.GREATER_THAN_GET_OEP, errorMsg);
							outParamDto.getErroritm_list().add(itmChkRstDTO);
						}
					} else if (days > haveDays) {
						// 普通
						outParamDto.setFg_checkflag(FBoolean.FALSE);
						String errorMsg = MiCheckWholeMsgUtilBP.getBillExcessMsg(ciOrderDO.getName_or(), ordSrvDO.getName_mm(), haveDays, days, unit);
						itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO, ordSrvDO, MiMcCheckFailResultEnum.GREATER_THAN_GET_OEP, errorMsg);
						outParamDto.getErroritm_list().add(itmChkRstDTO);
					}
				}
//				}
			}
		}
		return outParamDto;
	}

	/**
	 * 是否存在慢病或行动不便诊断
	 * 
	 * @param cidiList
	 *            诊断list
	 * @param fg_ExistChronicDi
	 *            是否存在慢病诊断
	 * @param fg_ExistMoveDiffDi
	 *            是否存在行动不便
	 * @return
	 */
	private MiMcDiDefDTO getDiFlag(FArrayList cidiList) {
		MiMcDiDefDTO miMcDiDefDTO= new MiMcDiDefDTO();
		miMcDiDefDTO.setFg_haschronic(FBoolean.FALSE);
		miMcDiDefDTO.setFg_hasmovediff(FBoolean.FALSE);
		if (cidiList == null)
			return miMcDiDefDTO;
		for (Object diItmObj : cidiList) {
			MiMcDiDefDTO diItm = (MiMcDiDefDTO) diItmObj;
			if (FBoolean.TRUE.equals(diItm.getFg_haschronic()))
				miMcDiDefDTO.setFg_haschronic(FBoolean.TRUE) ;
			if(diItm.getName_didef().contains("行动不便"))
				miMcDiDefDTO.setFg_hasmovediff(FBoolean.TRUE) ;
//			if (FBoolean.TRUE.equals(diItm.getFg_hasmovediff()))
//				fg_ExistMoveDiffDi = FBoolean.TRUE;
		}
		return miMcDiDefDTO;
	}
}
