package iih.bl.hp.rule;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.comm.util.BlMsgUtils;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckFailResultEnum;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.bl.hp.dto.d.ItmChkRstDTO;
import iih.bl.hp.ep.FreqEP;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 重复开药
 * 
 * @author yankan
 * @since 2017-09-04
 *
 */
public class CheckReBillRule {

	/**
	 * 重复开药: 医生不允许在1天内给同一患者重复开同一种药品，以下情况除处： 溶媒不限制； 单次执行(频次ST、ONCE、PRN)的医嘱不限制；
	 * 
	 * @param ciHpCheckDTO
	 * @return
	 * @throws BizException
	 */
	public CiHpCheckResultDTO exec(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		CiHpCheckResultDTO ciHpCheckResultDTO = new CiHpCheckResultDTO();
		ciHpCheckResultDTO.setCheckflag(FBoolean.TRUE);// 默认通过校验

		// 判断如果是急诊 默认通过
		if (ciHpCheckDTO == null || ciHpCheckDTO.getEntdo() == null || IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(ciHpCheckDTO.getEntdo().getCode_entp()) || CollectionUtils.isEmpty(ciHpCheckDTO.getSavecidto()) || CollectionUtils.isEmpty(ciHpCheckDTO.getHistorycidto())) {
			return ciHpCheckResultDTO;// 默认通过校验
		}
		// 1、获取单次执行频次
		FreqEP freqEP = new FreqEP();
		Map<String, String> freqOnceMap = freqEP.getOnceFreqMap();// 获取频次map
		// 2、获取今天已开立的医嘱
		List<String> todayOrdSrvIdLst = this.getTodayHisOrSrvList(ciHpCheckDTO.getHistorycidto(), freqOnceMap);
		if (ListUtil.isEmpty(todayOrdSrvIdLst)) {
			return ciHpCheckResultDTO;// 默认通过校验
		}

		// 3、校验重复开药
		FArrayList list = new FArrayList();
		List<String> newSrvList = new ArrayList<String>();
		// 获取当前要提交的医嘱
		for (Object item : ciHpCheckDTO.getSavecidto()) {
			HpQryCiorderDTO hpQryCiorderDTO = (HpQryCiorderDTO) item;
			FArrayList2 ordSrvDoLst = hpQryCiorderDTO.getOrdsrvs();// 获取医嘱服务
			CiOrderDO ciOrderDO = hpQryCiorderDTO.getCiorderdo();// 获取医嘱本身
			for (Object ordSrvDoItm : ordSrvDoLst) {
				OrdSrvDO ordSrvDo = (OrdSrvDO) ordSrvDoItm;
				// 过滤不限量药品
				if (ciHpCheckDTO.getId_mmLst().indexOf(ordSrvDo.getId_mm()) != -1) {
					continue;
				}
				// 过滤非西药、溶媒、单次执行
				if (!ordSrvDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG) || ordSrvDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY) || freqOnceMap.containsKey(ordSrvDo.getId_freq())) {
					continue;
				}
				// 历史中已经包含该服务，则提示重复用药
				if (todayOrdSrvIdLst.contains(ordSrvDo.getId_mm()) || newSrvList.contains(ordSrvDo.getId_mm())) {
					ciHpCheckResultDTO.setCheckflag(FBoolean.FALSE);
					String errMsg = BlMsgUtils.GetCheckReBillMsg(ordSrvDo.getName(), BlMsgUtils.getOrderMmList(ordSrvDo.getId_orsrv(), ordSrvDo.getId_srv(), hpQryCiorderDTO.getOrdsrvmms()));
					SetErrorInfoBP setErrorInfoBP = new SetErrorInfoBP();
					ItmChkRstDTO itmChkRstDTO = new ItmChkRstDTO();
					itmChkRstDTO = setErrorInfoBP.exec(ciOrderDO, ordSrvDo, errMsg, CiHpCheckFailResultEnum.REPEAT_PRES_DRUG);
					list.add(itmChkRstDTO);
				} else {
					newSrvList.add(ordSrvDo.getId_mm());
				}
			}
		}
		ciHpCheckResultDTO.setErroritm_list(list);
		return ciHpCheckResultDTO;
	}

	/**
	 * 获取今天已开立的服务集合
	 * 
	 * @param hisCiOrList
	 *            历史医嘱集合
	 * @return
	 */
	private List<String> getTodayHisOrSrvList(FArrayList2 hisCiOrList, Map<String, String> freqOnceMap) {
		FDate serverDate = AppUtils.getServerDate();// 当前服务器时间
		List<String> todayOrdSrvIdLst = new ArrayList<String>();
		// 添加默认一条数据 避免两个同样数据 同时签署
		todayOrdSrvIdLst.add("");
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
				if (DateTimeUtils.isInThisDay(order.getDt_effe(), serverDate) && !freqOnceMap.containsKey(ordsrv.getId_freq())) {
					todayOrdSrvIdLst.add(mm.getId_mm());// 只获取当天的数据
				}
			}
		}
		return todayOrdSrvIdLst;
	}
}
