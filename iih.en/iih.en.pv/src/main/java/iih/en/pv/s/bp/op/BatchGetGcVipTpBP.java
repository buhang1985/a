package iih.en.pv.s.bp.op;

import java.util.Map;

import iih.en.comm.IEnConst;
import iih.en.comm.ep.EnVipEP;
import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

/**
 * 批量获取就诊的VIP类型
 * 
 * @author zcm
 *
 */
public class BatchGetGcVipTpBP {
	/**
	 * 批量获取就诊的VIP类型
	 * 
	 * @param entIds 就诊ID集合
	 * @return map: key(就诊ID)，value(字符串类型，0-非gcVip，1-价格分类VIP； 2-号别VIP；
	 *         3-价格与号别同时为VIP)
	 * @throws BizException
	 * @author zcm
	 */
	public FMap exec(String[] entIds) throws BizException {
		// 检查参数
		EnValidator.validateParam("entIds", entIds);

		MatchGcVipTpBP matchBP = new MatchGcVipTpBP();

		// 匹配价格分类
		Map<String, Boolean> priMap = matchBP.matchPrica(entIds);

		// 匹配排班服务
		Map<String, Boolean> srvMap = matchBP.matchScsrv(entIds);
		
		//匹配EN_EXT_VIP
		Map<String, FBoolean> extVipMap = new EnVipEP().getIsExtVipMap(entIds);
		
		// 匹配患者标签VIP标识
		Map<String, Boolean> vipMap = matchBP.matchPatTag(entIds);
		
		//匹配科室或病区
		Map<String, Boolean> depMap = matchBP.matchDept(entIds);
		
		// 根据价格分类匹配结果和排班服务匹配结果综合匹配
		FMap fmap = this.match(entIds, priMap, srvMap, vipMap, extVipMap, depMap);

		return fmap;
	}

	/**
	 * 根据价格分类匹配结果和排班服务匹配结果综合匹配
	 *
	 * @param entIds 就诊ID数组
	 * @param priMap 价格分配匹配Map
	 * @param srvMap 排班服务匹配Map
	 * @return fmap: key(就诊ID)，value(字符串类型，0-非gcVip，1-价格分类VIP； 2-号别VIP；
	 *         3-价格与号别同时为VIP)
	 * @throws BizException
	 * @author zhengcm
	 */
	private FMap match(String[] entIds, Map<String, Boolean> priMap, Map<String, Boolean> srvMap, Map<String, Boolean> vipMap, Map<String, FBoolean> extVipMap, Map<String, Boolean> depMap)
			throws BizException {
		FMap fmap = new FMap();
		for (String entId : entIds) {
			String val = null;
			if (FBoolean.TRUE.equals(extVipMap.equals(entId))) {
				val = IEnConst.TP_VIP_EXT;	//手动加VIP
			}else if (priMap.get(entId) && srvMap.get(entId)) {
				val = IEnConst.TP_VIP_ALL;	//价格分类vip且号别vip
			}else if (depMap.get(entId)) {
				val = IEnConst.TP_VIP_DEP;	//科室VIP
			}else if (priMap.get(entId)) {
				val = IEnConst.TP_VIP_PRI;	//价格分类VIP
			}else if (srvMap.get(entId)) {
				val = IEnConst.TP_VIP_SRV;	//号别VIP
			}else if (vipMap.get(entId)) {
				val = IEnConst.TP_VIP_TAG;	//患者标签VIP
			}else {
				val = IEnConst.TP_VIP_NONE;
			}
			fmap.put(entId, val);
		}
		return fmap;
	}
}
