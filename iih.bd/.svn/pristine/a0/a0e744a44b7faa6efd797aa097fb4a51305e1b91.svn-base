package iih.bd.srv.relmmbagtactics.s.bp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.DoUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.relmmbagtactics.d.RelMmBagTacticsDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 刷新药品关联药单费策略关联数据
 * 
 * @author hao_wu 2020-1-13
 *
 */
public class RefreshRelMmBagTacticsRelDataBp {

	@SuppressWarnings("unchecked")
	public void exec(RelMmBagTacticsDO[] relMmBagTacticsDos) throws BizException {
		if (ArrayUtils.isEmpty(relMmBagTacticsDos)) {
			return;
		}

		String[] srvIds = DoUtils.getAttrValArrNotNull(relMmBagTacticsDos, RelMmBagTacticsDO.ID_SRV, String.class);
		if (ArrayUtils.isEmpty(srvIds)) {
			return;
		}

		String sql = String.format(
				"SELECT srv.id_srv, srv.id_unit_med, unit.name AS name_unit_med FROM bd_Srv srv INNER JOIN bd_measdoc unit ON srv.id_unit_med = unit.id_measdoc WHERE %s",
				SqlUtils.getInSqlByIds("srv.id_srv", srvIds));

		DAFacade daFacade = new DAFacade();
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) daFacade.execQuery(sql, new MapListHandler());
		if (dataList == null || dataList.size() <= 0) {
			return;
		}

		HashMap<String, Map<String, Object>> srvMap = new HashMap<>();
		for (Map<String, Object> map : dataList) {
			String srvId = (String) map.get("id_srv");
			srvMap.put(srvId, map);
		}

		for (RelMmBagTacticsDO relMmBagTacticsDO : relMmBagTacticsDos) {
			String srvId = relMmBagTacticsDO.getId_srv();
			if (StringUtils.isBlank(srvId) || !srvMap.containsKey(srvId)) {
				continue;
			}

			Map<String, Object> srvInfo = srvMap.get(srvId);
			relMmBagTacticsDO.setId_unit((String) srvInfo.get("id_unit_med"));
			relMmBagTacticsDO.setName_unit((String) srvInfo.get("name_unit_med"));
		}
	}
}
