package iih.ci.sdk.price;

import java.util.HashMap;
import java.util.Map;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import iih.ci.sdk.cache.BDSrvInfoCache;
import iih.ci.sdk.cache.BDSrvSetInfoCache;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;

/**
 * 查询套内项目,包含临床和非临床 (有待优化）
 * @author wangqingzhu
 *
 */
public class CiOrSrvSetNotClinicalItemsBP {
	/**
	 * 查询套内项目,包含临床和非临床
	 * 
	 * @param param
	 * @throws BizException
	 */
	public Map<String, FDouble> exec(BdSrvPriCalParamDTO param) throws BizException {
		MedSrvSetItemDO[] srvSetArray = BDSrvSetInfoCache.GetMedSrvSetItemInfo(param.getId_srv());

		Map<String, FDouble> srvquanMap = new HashMap<String, FDouble>();
		if (srvSetArray == null || srvSetArray.length == 0)
			return srvquanMap; // 套内临床项目为空时候，直接返回
		String[] id_srvs = new String[srvSetArray.length];
		int i = 0;
		for (MedSrvSetItemDO medSrvSetItem : srvSetArray) {
			id_srvs[i] = medSrvSetItem.getId_srv_itm();
			if (srvquanMap.containsKey(medSrvSetItem.getId_srv_itm())) {
				srvquanMap.put(medSrvSetItem.getId_srv_itm(),
						srvquanMap.get(medSrvSetItem.getId_srv_itm()).add(medSrvSetItem.getQuan_medu()));
			} else {
				srvquanMap.put(medSrvSetItem.getId_srv_itm(), medSrvSetItem.getQuan_medu());
			}
			i++;
		}
		MedSrvDO[] szMedSrvInfo = BDSrvInfoCache.GetBdSrvInfos(null, id_srvs);
		if (ObjectUtils.isEmpty(szMedSrvInfo))
			return srvquanMap;

		FArrayList items = new FArrayList();
		for (MedSrvSetItemDO itemdo : srvSetArray) {
			for (MedSrvDO srvInfo : szMedSrvInfo) {
				if (itemdo.getId_srv_itm().equals(srvInfo.getId_srv())) {
					BdSrvPriCalParamDTO calparam = new BdSrvPriCalParamDTO();
					calparam.setId_srv(srvInfo.getId_srv());
					calparam.setId_primd(srvInfo.getId_primd());
					calparam.setName_srv(srvInfo.getName());
					calparam.setNum(itemdo.getQuan_medu().intValue());
					items.add(calparam);
				}
			}
		}

		param.setSrvsetitms(items);
		return srvquanMap;
	}

	/**
	 * 查询套内非临床的项目
	 * 
	 * @param param
	 * @throws BizException
	 */
	public Map<String, FDouble> notClinicalItems(BdSrvPriCalParamDTO param) throws BizException {
		MedSrvSetItemDO[] srvSetArray = BDSrvSetInfoCache.GetMedSrvSetItemInfo_NC(param.getId_srv());
		Map<String, FDouble> srvquanMap = new HashMap<String, FDouble>();
		String[] id_srvs = new String[srvSetArray.length];
		int i = 0;
		for (MedSrvSetItemDO medSrvSetItem : srvSetArray) {
			id_srvs[i] = medSrvSetItem.getId_srv_itm();
			if (srvquanMap.containsKey(medSrvSetItem.getId_srv_itm())) {
				srvquanMap.put(medSrvSetItem.getId_srv_itm(),
						srvquanMap.get(medSrvSetItem.getId_srv_itm()).add(medSrvSetItem.getQuan_medu()));
			} else {
				srvquanMap.put(medSrvSetItem.getId_srv_itm(), medSrvSetItem.getQuan_medu());
			}
			i++;
		}

		MedSrvDO[] szMedSrvInfo = BDSrvInfoCache.GetBdSrvInfos(null, id_srvs);
		FArrayList items = new FArrayList();
		if (ObjectUtils.isEmpty(szMedSrvInfo)) {
			param.setSrvsetitms(items);
			return srvquanMap;
		}

		for (MedSrvSetItemDO itemdo : srvSetArray) {
			for (MedSrvDO srvInfo : szMedSrvInfo) {
				if (itemdo.getId_srv_itm().equals(srvInfo.getId_srv())) {
					BdSrvPriCalParamDTO calparam = new BdSrvPriCalParamDTO();
					calparam.setId_srv(srvInfo.getId_srv());
					calparam.setId_primd(srvInfo.getId_primd());
					calparam.setName_srv(srvInfo.getName());
					calparam.setNum(itemdo.getQuan_medu().intValue());
					items.add(calparam);
				}
			}
		}

		param.setSrvsetitms(items);
		return srvquanMap;
	}
}
