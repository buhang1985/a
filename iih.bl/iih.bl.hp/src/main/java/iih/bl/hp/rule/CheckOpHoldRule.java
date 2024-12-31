package iih.bl.hp.rule;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.comm.util.BlMsgUtils;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckFailResultEnum;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.bl.hp.dto.d.ItmChkRstDTO;
import iih.bl.hp.ep.FreqEP;
import iih.bl.params.BlParams;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.en.pv.entplan.d.EntHpDO;

import java.util.HashMap;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;

/**
 * 门诊持有量校验
 * 
 * @author liming
 * @since 2017-09-04
 *
 */
public class CheckOpHoldRule {
	/**
	 * 门诊持有量限制: 医保为防止患者通过多天开药，积累持有的药品，造成资源浪费， 所以限制患者手中持有的药品的数量不得超过30天的用量。
	 * 2017年8月22日 改为50天
	 * 
	 * @param ciHpCheckDTO
	 * @return
	 * @throws BizException
	 */
	public CiHpCheckResultDTO exec(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		CiHpCheckResultDTO ciHpCheckResultDTO = new CiHpCheckResultDTO();
		ciHpCheckResultDTO.setCheckflag(FBoolean.TRUE);// 默认通过校验
		// 校验历史持有量
		int haveTmpDays = BlParams.BLHP000005();

		// 获取此次就诊的医保计划
		FArrayList2 enHpDOLst = ciHpCheckDTO.getEnthpdo();

		EntHpDO entHpDO_maj = null;
		for (Object enHpDO1 : enHpDOLst) {
			EntHpDO enhpdo = (EntHpDO) enHpDO1;
			if (enhpdo.getFg_maj() != null && enhpdo.getFg_maj().booleanValue()) {
				entHpDO_maj = enhpdo; // 主医保
				break;
			}
		}

		FArrayList list = new FArrayList();
		// if (就诊类型 == 门诊)
		if (ciHpCheckDTO != null && ciHpCheckDTO.getEntdo() != null && IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ciHpCheckDTO.getEntdo().getCode_entp())) {

			// 待提交医嘱
			FArrayList2 hpOrdCommittingLst = ciHpCheckDTO.getSavecidto();
			// 历史开单医嘱
			FArrayList2 historycidtoLst = ciHpCheckDTO.getHistorycidto();

			// 服务信息集合
			HashMap<String, OrdSrvDO> ordsrvMap = new HashMap<String, OrdSrvDO>();
			// 历史药品类持有量集合
			HashMap<String, Integer> srvAndSrvorDays = new HashMap<String, Integer>();
			// 药品开立历史消息
			HashMap<String, String> mmHisMsg = new HashMap<String, String>();
			GetOldMmDaysMapBP mapBP = new GetOldMmDaysMapBP();
			// 获取集合方法
			mapBP.exec(historycidtoLst, srvAndSrvorDays, ordsrvMap, mmHisMsg);
			// 获取获取单次频次数据
			FreqEP freqEP = new FreqEP();
			HashMap<String, String> freqOnceMap = freqEP.getOnceFreqMap();
			for (Object object : hpOrdCommittingLst) {
				// 医嘱查询实体 DTO数据
				HpQryCiorderDTO commCiOrder = (HpQryCiorderDTO) object;
				// 医嘱信息
				CiOrderDO commOr = commCiOrder.getCiorderdo();
				// 获取医嘱服务
				FArrayList2 commOrSrv = commCiOrder.getOrdsrvs();
				// 获取频次信息
				HashMap<String, String> srvMap = new HashMap<String, String>();
				for (Object srv : commOrSrv) {
					OrdSrvDO ordSrv = (OrdSrvDO) srv;
					srvMap.put(ordSrv.getId_srv() + ordSrv.getId_mm(), ordSrv.getId_freq());
				}
				// 服务下物品
				FArrayList2 commOrMms = commCiOrder.getOrdsrvmms();
				// 判断是否是西药、中成药医嘱
				if (!commOr.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG))
					continue;
				if (historycidtoLst == null)
					continue;
				for (Object mmObject : commOrMms) {
					OrdSrvMmDO mm = ((OrdSrvMmDO) mmObject);
					// 过滤不限量药品
					if (ciHpCheckDTO.getId_mmLst().indexOf(mm.getId_mm()) != -1) {
						continue;
					}
					// 历史持有量
					int holdDateTmp = 0;
					String strKey = mm.getId_srv() + mm.getId_mm();
					if (srvAndSrvorDays.containsKey(strKey)) {
						holdDateTmp = srvAndSrvorDays.get(strKey);
					}
					// 历史持有量3
					// 频次为st,once,prn不校验历史持有量 by lim 2017-10-17
					if (holdDateTmp > haveTmpDays && !IBdPpCodeTypeConst.SD_HP_BJ_KIND_INSUR.equals(entHpDO_maj.getCode_hpkind()) && !freqOnceMap.containsKey(srvMap.get(strKey))) {
						ciHpCheckResultDTO.setCheckflag(FBoolean.FALSE);
						SetErrorInfoBP setErrorInfoBP = new SetErrorInfoBP();
						ItmChkRstDTO itmChkRstDTO = new ItmChkRstDTO();
						OrdSrvDO ordSrvDO = ordsrvMap.get(strKey);
						FArrayList2 mmList = new FArrayList2();
						mmList.add(mm);
						String errorMsg = BlMsgUtils.GetCheckOpHoldMsg(ordSrvDO.getName(), BlMsgUtils.getOrderMmList(mm.getId_orsrv(), mm.getId_srv(), mmList), haveTmpDays, holdDateTmp);

						itmChkRstDTO = setErrorInfoBP.exec(commOr, ordSrvDO, errorMsg + mmHisMsg.get(strKey), CiHpCheckFailResultEnum.GREATER_THAN_OWN_OEP);
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
}