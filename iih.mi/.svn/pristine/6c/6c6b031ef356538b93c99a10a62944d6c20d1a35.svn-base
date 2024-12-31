package iih.mi.mc.s.ctrlcore.mimcwholecheck.rule;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.CollectionUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
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
import iih.mi.util.MiComUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.enterprisewechat.cp.util.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
/**
 * 重复开药校验规则
 * @author LIM
 * @since 2019-09-23
 */
public class MiCheckReBillRule {
	/**
	 * 重复开药: 医生不允许在1天内给同一患者重复开同一种药品，以下情况除处： 溶媒不限制； 单次执行(频次ST、ONCE、PRN)的医嘱不限制；
	 * @param inParamDto
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public MiMcWholeRuleOutParamDTO exec(MiMcWholeRuleInParamDTO inParamDto)throws BizException{
		MiMcWholeRuleOutParamDTO outParamDto= new MiMcWholeRuleOutParamDTO();
		outParamDto.setFg_checkflag(FBoolean.TRUE);//默认通过校验	
		// 1、获取单次执行频次
		MiFreqEP freqEP = new MiFreqEP();
		Map<String, String> freqOnceMap = freqEP.getOnceFreqMap();// 获取频次map
		
		//2、获取重复开药的排斥剂型
		String id_doas=MiParamUtil.MI3002(inParamDto.getId_hp());
		String[] doasArr= new String[]{};
		if(!StringUtil.isEmpty(id_doas)){
			doasArr=id_doas.split(",");
		}
		
		//3.获取不限量药品
		List<String> unLimitMMList= (List<String>)Context.get().getAttribute(IMiMcCheckConst.CHECKWHOLE_UNLIMITDRUGLIST);
		//3.1 获取历史医嘱
		FArrayList2  hisOrdLst=	(FArrayList2)Context.get().getAttribute(IMiMcCheckConst.CHECKWHOLE_HISCIORDERLIST);
		//4.获取今天已开立的医嘱
		List<String> todayOrdSrvIdLst = this.getTodayHisOrSrvList(hisOrdLst,inParamDto.getCiorderlist(), freqOnceMap,doasArr);
		if (ListUtil.isEmpty(todayOrdSrvIdLst)) {
			return outParamDto;// 默认通过校验
		}		
		//5.校验重复开药
		FArrayList list = new FArrayList();
		List<String> newSrvList = new ArrayList<String>();
		//6.获取当前要提交的医嘱
		for (Object item : inParamDto.getCiorderlist()) {
			MiMcOrderDTO ciOrderDO = (MiMcOrderDTO) item;// 获取医嘱本身
			FArrayList ordSrvDoLst = ciOrderDO.getOrdsrvlist();// 获取医嘱服务
			for (Object ordSrvDoItm : ordSrvDoLst) {
				MiMcOrdSrvDTO ordSrvDo = (MiMcOrdSrvDTO) ordSrvDoItm;
				//6.1过滤不限量药品
				if (!ListUtil.isEmpty(unLimitMMList) && unLimitMMList.indexOf(ordSrvDo.getId_mm()) != -1) {
					continue;
				}
				//6.2过滤非西药、溶媒
				if (!ordSrvDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG) || ordSrvDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY) ) {
					continue;
				}
				//6.3过滤单次执行并且剂型在重复开药的排斥剂型存在 的数据
				if(freqOnceMap.containsKey(ordSrvDo.getId_freq())){
					boolean iscont=false;
					if(!StringUtil.isEmpty(ordSrvDo.getId_mm())&& MiComUtil.getStrInArr(doasArr, ordSrvDo.getId_dosage())){
						iscont=true;
						break;
					}
					if(iscont){
						continue;
					}
				}
				//6.4历史中已经包含该服务，则提示重复用药
				if (todayOrdSrvIdLst.contains(ordSrvDo.getId_mm()) || newSrvList.contains(ordSrvDo.getId_mm())) {
					outParamDto.setFg_checkflag(FBoolean.FALSE);
					
					MiCheckWholeSetErrMsgBP setErrorInfoBP = new MiCheckWholeSetErrMsgBP();
					MiMcOrdSrvResultDTO itmChkRstDTO = new MiMcOrdSrvResultDTO();
					String errMsg= MiCheckWholeMsgUtilBP.GetCheckReBillMsg(ordSrvDo.getName_srv(),ordSrvDo.getName_mm());
					itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO,ordSrvDo, MiMcCheckFailResultEnum.REPEAT_PRES_DRUG,errMsg);
					list.add(itmChkRstDTO);
				} else {
					newSrvList.add(ordSrvDo.getId_mm());
				}
			}
		}
		outParamDto.setErroritm_list(list);
		return outParamDto;
	}
	
	/**
	 * 获取今天已开立的服务集合
	 * 
	 * @param hisCiOrList
	 *            历史医嘱集合
	 * @return
	 */
	private List<String> getTodayHisOrSrvList(FArrayList2 hisCiOrList,FArrayList orList, Map<String, String> freqOnceMap,String[] doasArr) {
		FDate serverDate = AppUtils.getServerDate();// 当前服务器时间
		List<String> todayOrdSrvIdLst = new ArrayList<String>();
		List<String> orSrvIdLst= this.getOrSrvidList(orList);
		// 添加默认一条数据 避免两个同样数据 同时签署
		todayOrdSrvIdLst.add("");
		if(CollectionUtils.isEmpty(hisCiOrList))
			return todayOrdSrvIdLst;
		for (Object historycidto1 : hisCiOrList) {
			HpQryCiorderDTO historycidto = (HpQryCiorderDTO) historycidto1;
			CiOrderDO order = historycidto.getCiorderdo();
			if (historycidto == null || CollectionUtils.isEmpty(historycidto.getOrdsrvs()) || CollectionUtils.isEmpty(historycidto.getOrdsrvmms())) {
				continue;
			}
			Map<String, OrdSrvDO> srvMap = new HashMap<String, OrdSrvDO>();
			for (Object ordsrvs1 : historycidto.getOrdsrvs()) {
				OrdSrvDO ordsrv = (OrdSrvDO) ordsrvs1;
				srvMap.put(ordsrv.getId_srv(), ordsrv);
			}
			for (Object mmObj : historycidto.getOrdsrvmms()) {
				OrdSrvMmDO mm = (OrdSrvMmDO) mmObj;
				OrdSrvDO ordsrv = srvMap.get(mm.getId_srv());
				if (DateTimeUtils.isInThisDay(order.getDt_effe(), serverDate) 
						&& !(freqOnceMap.containsKey(ordsrv.getId_freq())&& getStrInArr(doasArr,mm.getId_dosage()))
						&& !orSrvIdLst.contains(ordsrv.getId_orsrv())) {
					todayOrdSrvIdLst.add(mm.getId_mm());// 只获取当天的数据
				}
			}
		}
		return todayOrdSrvIdLst;
	}
	
	/**
	 * 获取当前开立医嘱服务id
	 * @param orList
	 * @return
	 */
	private List<String> getOrSrvidList(FArrayList orList){
		List<String> orSevIdList= new ArrayList<String>();
		for (Object item : orList) {
			MiMcOrderDTO ciOrderDO = (MiMcOrderDTO) item;// 获取医嘱本身
			FArrayList ordSrvDoLst = ciOrderDO.getOrdsrvlist();// 获取医嘱服务
			for (Object ordSrvDoItm : ordSrvDoLst) {
				MiMcOrdSrvDTO ordSrvDo = (MiMcOrdSrvDTO) ordSrvDoItm;
				if(!StringUtils.isEmpty(ordSrvDo.getId_orsrv())){
					orSevIdList.add(ordSrvDo.getId_orsrv());
				}
			}
		}
		return orSevIdList;
	}
	/**
	 * 判断字段是否在数组中存在
	 * @param arr 数组
	 * @param targetValue 寻找的字符
	 * @return
	 */
	public static boolean getStrInArr(String[] arr, String targetValue) {
		  return Arrays.asList(arr).contains(targetValue);
	}
}
