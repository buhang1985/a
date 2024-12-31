package iih.bd.base.utils;

import java.util.List;
import java.util.Map;

import iih.bd.base.exception.ArgumentNullException;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.d.FTypeManager;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * SV校验工具类
 * @author ly 2019/05/15
 *
 */
public class SVCheckUtils {

	/**
	 * 校验SV
	 * @param checkMap key:主键id value:sv
	 * @param doInfo DO信息
	 * @return 校验结果
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static Boolean checkSv(Map<String, FDateTime> checkMap, BaseDO doInfo) throws BizException {

		if (checkMap == null) {
			throw new ArgumentNullException("校验SV", "checkMap");
		}

		if (doInfo == null) {
			throw new ArgumentNullException("校验SV", "doInfo");
		}

		String sql = String.format("select %s,sv from %s where ", doInfo.getPKFieldName().toLowerCase(), doInfo.getTableName().toLowerCase());
		sql += SqlUtils.getInSqlByIds(doInfo.getPKFieldName(), checkMap.keySet().toArray(new String[0]));

		DAFacade daf = new DAFacade();
		List<Map<String, Object>> rltList = (List<Map<String, Object>>) daf.execQuery(sql, new MapListHandler());

		if (ListUtil.isEmpty(rltList))
			return false;

		if (rltList.size() != checkMap.size())
			return false;

		for (Map<String, Object> rlt : rltList) {

			String key = (String) rlt.get(doInfo.getPKFieldName().toLowerCase());
			FDateTime sv = (FDateTime) FTypeManager.convert2FType(FType.FDateTime, rlt.get("sv"));

			FDateTime checkSv = checkMap.get(key);
			if (checkSv == null)
				return false;

			if (!checkSv.equals(sv))
				return false;
		}

		return true;
	}
}
