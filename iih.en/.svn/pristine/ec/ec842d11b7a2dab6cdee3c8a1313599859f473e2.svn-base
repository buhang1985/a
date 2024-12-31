package iih.en.pv.s.bp.op;

import java.util.Map;

import iih.en.comm.ep.EnVipEP;
import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

/**
 * 批量判定是否绿色通道
 * 
 * @author zcm
 *
 */
public class BatchChkIsGcVipBP {
	/**
	 * 批量判定是否绿色通道
	 * 
	 * @param entIds 就诊ID集合
	 * @return map，key:就诊ID, value: true或 false
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
		
		//匹配科室或病区
		Map<String, Boolean> depMap = matchBP.matchDept(entIds);
		
		//匹配患者
		Map<String, Boolean> patMap = matchBP.matchPatTag(entIds);

		// 根据价格分类匹配结果和排班服务匹配结果综合匹配
		FMap fmap = this.match(entIds, priMap, srvMap, extVipMap, depMap, patMap);

		return fmap;
	}

	/**
	 * 根据价格分类匹配结果和排班服务匹配结果综合匹配
	 *
	 * @param entIds 就诊ID数组
	 * @param priMap 价格分配匹配Map
	 * @param srvMap 排班服务匹配Map
	 * @return 综合匹配结果Map
	 * @throws BizException
	 * @author zhengcm
	 */
	private FMap match(String[] entIds, Map<String, Boolean> priMap, Map<String, Boolean> srvMap, Map<String, FBoolean> extVipMap, 
			Map<String, Boolean> depMap, Map<String, Boolean> patMap)
			throws BizException {
		FMap fmap = new FMap();
		for (String entId : entIds) {
			FBoolean isMatch = FBoolean.FALSE;
			if (priMap.get(entId) || srvMap.get(entId) || FBoolean.TRUE.equals(extVipMap.equals(entId)) ||
					depMap.get(entId) || patMap.get(entId)) {
				isMatch = FBoolean.TRUE;
			}
			fmap.put(entId, isMatch);
		}
		return fmap;
	}
}
