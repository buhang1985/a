package iih.mi.mc.s.ctrlcore.mimcwholecheck.rule;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.mi.constant.IMiMcCheckConst;
import iih.mi.itf2.util.MiParamUtil;
import iih.mi.mc.dto.mimcwholerule.d.MiMcCheckFailResultEnum;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrdSrvDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrdSrvResultDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrderDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleInParamDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleOutParamDTO;
import iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp.MiCheckWholeMsgUtilBP;
import iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp.MiCheckWholeSetErrMsgBP;
import iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.ep.MiFreqEP;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

/**
 * 门诊持有量校验规则
 * 
 * @author LIM
 * @since 2019-09-23
 *
 */
public class MiCheckOpHoldRule {
	/**
	 * 门诊持有量校验规则
	 * 
	 * @param inParamDto
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public MiMcWholeRuleOutParamDTO exec(MiMcWholeRuleInParamDTO inParamDto) throws BizException {
		MiMcWholeRuleOutParamDTO outParamDto = new MiMcWholeRuleOutParamDTO();
		outParamDto.setFg_checkflag(FBoolean.TRUE);// 默认通过校验

		String id_hp = inParamDto.getId_hp();
		// 校验历史持有量
		int haveTmpDays = MiParamUtil.MI3008(id_hp);
		// 门诊医生站最大开药提醒天数
		int ordMaxDays = MiParamUtil.MI3009(id_hp);

		FArrayList list = new FArrayList();
		// 获取不限量药品
		List<String> unLimitDrugList = (List<String>) Context.get().getAttribute(
				IMiMcCheckConst.CHECKWHOLE_UNLIMITDRUGLIST);
		// 历史开单医嘱
		FArrayList2 historycidtoLst = (FArrayList2) Context.get().getAttribute(
				IMiMcCheckConst.CHECKWHOLE_HISCIORDERLIST);
//		if (historycidtoLst == null) {
//			return outParamDto;
//		}
		// 历史药品类持有量集合
		HashMap<String, Integer> srvAndSrvorDays = this.calMmHisDays(historycidtoLst);

		// 获取获取单次频次数据
		MiFreqEP freqEP = new MiFreqEP();
		HashMap<String, String> freqOnceMap = freqEP.getOnceFreqMap();

		for (Object item : inParamDto.getCiorderlist()) {
			MiMcOrderDTO ciOrderDO = (MiMcOrderDTO) item;
			FArrayList orsrvLst = ciOrderDO.getOrdsrvlist();
			for (Object orsrv : orsrvLst) {
				MiMcOrdSrvDTO ordSrvDO = (MiMcOrdSrvDTO) orsrv;
				// 判断是否是西药医嘱或者是否不限量药品,频次为st,once,prn不校验历史持有量  不校验特殊病药品
				if (!ordSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)
						|| (!ListUtil.isEmpty(unLimitDrugList) && unLimitDrugList.contains(ordSrvDO.getId_mm()))
						|| freqOnceMap.containsKey(ordSrvDO.getId_freq()) || FBoolean.TRUE.equals(ordSrvDO.getSpecdrug_flag()))
					continue;
				// 历史持有量
				int holdDateTmp = 0;
				String strKey = ordSrvDO.getId_srv() + ordSrvDO.getId_mm();
				if (srvAndSrvorDays.containsKey(strKey)) {
					holdDateTmp = srvAndSrvorDays.get(strKey);
				}
				String errorMsg = "";
				// 就诊类型 == 门诊IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(inParamDto.getCode_entp()) && 
				if (holdDateTmp > haveTmpDays) {
					outParamDto.setFg_checkflag(FBoolean.FALSE);
					MiCheckWholeSetErrMsgBP setErrorInfoBP = new MiCheckWholeSetErrMsgBP();
					MiMcOrdSrvResultDTO itmChkRstDTO = new MiMcOrdSrvResultDTO();
					errorMsg = MiCheckWholeMsgUtilBP.GetCheckOpHoldMsg(ordSrvDO.getName_srv(), ordSrvDO.getName_mm(),
							haveTmpDays, holdDateTmp);

					itmChkRstDTO = setErrorInfoBP
							.exec(ciOrderDO,ordSrvDO, MiMcCheckFailResultEnum.GREATER_THAN_OWN_OEP,errorMsg);
					if (itmChkRstDTO != null) {
						list.add(itmChkRstDTO);
					}
				}
				// 判断开药天数是否大于可使用最大天数(默认100天)
				if (ordSrvDO.getDays_available() > ordMaxDays) {
					outParamDto.setFg_checkflag(FBoolean.FALSE);
					MiMcOrdSrvResultDTO itmChkRstDTO = new MiMcOrdSrvResultDTO();
					MiCheckWholeSetErrMsgBP setErrorInfoBP = new MiCheckWholeSetErrMsgBP();
					errorMsg = ordSrvDO.getName_srv() + "开药数量大于" + ordMaxDays + "天！";
					// 此消息只提示不限制 所以用40
					itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO,ordSrvDO,MiMcCheckFailResultEnum.RADIATION_CLASS_ORDER,errorMsg);
					if (itmChkRstDTO != null) {
						list.add(itmChkRstDTO);
					}
				}
			}
		}
		if(!ListUtil.isEmpty(list))
			outParamDto.setErroritm_list(list);
		return outParamDto;
	}

	/**
	 * 计算药品持有量
	 * 
	 * @param historycidtoLst
	 *            历史医嘱
	 * @return
	 * @throws BizException 
	 */
	private HashMap<String, Integer> calMmHisDays(FArrayList2 historycidtoLst) throws BizException {
		HashMap<String, Integer> srvAndSrvorDays = new HashMap<String, Integer>();
		// 1.获取当前日期
		FDate currentDate = AppUtils.getServerDate();
		// 药品最早执行日期集合
		HashMap<String, HashMap<FDateTime, Integer>> maxDtEffeMap = new HashMap<String, HashMap<FDateTime, Integer>>();
		// 2.设置药品总持有量，设置药品最早执行日期，设置对应的服务DO
		setMaxDay(historycidtoLst, srvAndSrvorDays, maxDtEffeMap);
		// 3.计算剩余持有量天数
		setDtEffeDays(srvAndSrvorDays, maxDtEffeMap, currentDate);
		return srvAndSrvorDays;
	}

	/**
	 * 设置药品总持有量，设置药品最早执行日期，设置对应的服务DO
	 * 
	 * @param historycidtoLst
	 *            原始服务
	 * @param srvAndSrvorDays
	 *            持有量天数集合
	 * @param maxDtEffeMap
	 *            最早开单天数
	 * @throws BizException
	 */
	private void setMaxDay(FArrayList2 historycidtoLst, HashMap<String, Integer> srvAndSrvorDays,
			HashMap<String, HashMap<FDateTime, Integer>> maxDtEffeMap) throws BizException {
		if (historycidtoLst != null) {

			for (Object object : historycidtoLst) {
				// 医嘱查询实体 DTO数据
				HpQryCiorderDTO commCiOrder = (HpQryCiorderDTO) object;
				// 医嘱信息
				CiOrderDO oldOr = commCiOrder.getCiorderdo();

				// 判断是否是西药、中成药医嘱
				if (!oldOr.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG))
					continue;
				// 判断是否是未付款
//				if (ICiDictCodeConst.SD_SU_BL_NONE.equals(oldOr.getSd_su_bl())) {
//					continue;
//				}
				// 医嘱中包含的服务
				FArrayList2 orSrvs = commCiOrder.getOrdsrvs();

				// 服务下物品
				FArrayList2 orMms = commCiOrder.getOrdsrvmms();
				// 获取单次频次
				MiFreqEP freqEP = new MiFreqEP();
				HashMap<String, String> freqOnceMap = freqEP.getOnceFreqMap();
				// 获取出持有量天数的总天数
				for (Object srvObj : orSrvs) {
					OrdSrvDO ordSrvDO = (OrdSrvDO) srvObj;
					if (freqOnceMap.containsKey(ordSrvDO.getId_freq()) || (FBoolean.TRUE).equals(ordSrvDO.getFg_self())) {
						continue;// 单次则过滤不校验 自备药不参与持有量校验
					}

					int i = 0;
					if (orMms != null)
						for (Object mmObj : orMms) {
							OrdSrvMmDO srvMmDO = (OrdSrvMmDO) mmObj;
							if (ordSrvDO.getId_srv().equals(srvMmDO.getId_srv())) {
								// 持有量键
								String strKey = ordSrvDO.getId_srv() + srvMmDO.getId_mm();
								// 计算当前物品持有量天数
								Integer days = srvMmDO.getDays_available();
								days = days == null ? 0 : days;
								// 获取当前开药执行日期
								FDateTime dtEffe = oldOr.getDt_effe();

								ordSrvDO.setId_mm(srvMmDO.getId_mm());
								// 判断是否有此项目
								if (srvAndSrvorDays.containsKey(strKey)) {
									i++;
									// 添加对应日期的持有量天数
									maxDtEffeMap.get(strKey).put(dtEffe.addSeconds(i), days);
									// 赋值当前天数（累加）
									days = days + srvAndSrvorDays.get(strKey);
									// 删除已有数据
									srvAndSrvorDays.remove(strKey);
								} else {
									HashMap<FDateTime, Integer> dtmap = new HashMap<FDateTime, Integer>();
									dtmap.put(dtEffe, days);
									maxDtEffeMap.put(strKey, dtmap);
								}
								srvAndSrvorDays.put(strKey, days);
							}
						}
				}
			}
		}
	}

	/**
	 * 计算剩余持有量天数
	 * 
	 * @param srvAndSrvorDays
	 *            持有量天数集合
	 * @param maxDtEffeMap
	 *            最早开单天数
	 */
	private void setDtEffeDays(HashMap<String, Integer> srvAndSrvorDays,
			HashMap<String, HashMap<FDateTime, Integer>> maxDtEffeMap, FDate currentDate) {
		// 循环最早日期
		for (String strKey : maxDtEffeMap.keySet()) {
			// 创建排序集合
			TreeMap<FDateTime, Integer> map = new TreeMap<FDateTime, Integer>(new Comparator<FDateTime>() {
				public int compare(FDateTime obj1, FDateTime obj2) {
					return obj1.compareTo(obj2);// 升序排序
				}
			});
			// 将持有量天数添加到 集合中
			for (FDateTime dtKey : maxDtEffeMap.get(strKey).keySet()) {
				int days = maxDtEffeMap.get(strKey).get(dtKey);
				if (map.containsKey(dtKey))
					days = days + map.get(dtKey);
				map.put(dtKey, days);
			}
			// 上一次区间日期
			FDateTime lastDateTime = null;
			// 区间次有量天数
			Integer s_e_days = 0;
			// 循环排序后持有量数据
			for (FDateTime dtKey : map.keySet()) {
				// 如果上一次区间不为空时 区间持有量=持有量+(上一次区间日期-本次区间日期)如果小于0 为0 ，并加上本次持有量天数s
				if (lastDateTime != null) {
					s_e_days = s_e_days
							+ lastDateTime.getDate().asLocalBegin().getDaysAfter(dtKey.getDate().asLocalBegin());
					if (s_e_days < 0)
						s_e_days = 0;
					s_e_days = s_e_days + map.get(dtKey);
				} else {
					// 如果是第一次 持有量天数位本次持有量天数
					s_e_days = map.get(dtKey);
				}
				// 将本次区间日期设置为 上次区间日期
				lastDateTime = dtKey;
			}

			// 获取当前物品所有持有量 总持有量=区间持有量+(上一次区间日期-当前日期)
			Integer avadays = s_e_days + lastDateTime.getDate().asLocalBegin().getDaysAfter(currentDate.asLocalBegin());

			// 小于0 默认为0
			if (avadays < 0)
				avadays = 0;
			// 删除已有的
			srvAndSrvorDays.remove(strKey);
			// 添加计算后持有量值
			srvAndSrvorDays.put(strKey, avadays);
		}
	}

}
