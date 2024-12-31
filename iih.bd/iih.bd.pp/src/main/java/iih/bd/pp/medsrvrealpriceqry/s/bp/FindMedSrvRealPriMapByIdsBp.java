package iih.bd.pp.medsrvrealpriceqry.s.bp;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;

/**
 * 根据医疗服务主键集合查询真实价格字典业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindMedSrvRealPriMapByIdsBp {

	public FMap2 exec(String[] medSrvIds) throws BizException {
		FMap2 realPriMap = new FMap2();

		if (ArrayUtils.isEmpty(medSrvIds)) {
			return realPriMap;
		}

		FindMedSrvRefPriMapByIdsBp bp = new FindMedSrvRefPriMapByIdsBp();
		FMap refPriMap = bp.exec(medSrvIds);
		if (refPriMap.size() <= 0) {
			return realPriMap;
		}

		for (String srvId : refPriMap.keySet()) {
			realPriMap.put(srvId, refPriMap.get(srvId));
		}
		return realPriMap;
	}
}
