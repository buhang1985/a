package iih.sc.sch.s.bp;

import iih.bd.base.utils.SqlUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.s.ep.OralSchEP;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;

/**
 * 获取指定排班同号源池不包含当前渠道的号位BP
 * 
 * @author zhengcm
 * @date 2018-04-25 15:53:16
 *
 */
public class GetSchOtherChlTickBP {

	/**
	 * 获取指定排班同号源池不包含当前渠道的号位
	 * 
	 * @author zhengcm
	 *
	 * @param infoList
	 * @param chlDO
	 * @return
	 * @throws BizException
	 */
	public Map<String, List<ScSchTickDO>> exec(Map<String, Integer> schMap, SchedulechlDO chlDO) throws BizException {
		if (null == schMap || schMap.isEmpty() || null == chlDO) {
			return null;
		}
		List<String> schIds = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : schMap.entrySet()) {
			String id_sch = entry.getKey();
			if (!schIds.contains(id_sch)) {
				schIds.add(id_sch);
			}
		}
		
		// 查询排班号位设置了渠道的号位
		String cond = String.format(SqlUtils.getInSqlByIds("id_sch", schIds.toArray(new String[0]))
				+ " and ids_scchl is not null and eu_used = %d and eu_usescope = %d", EuUseState.WY, EuUseScope.APT);
		
		ScSchTickDO[] tickDOs = new OralSchEP().getSchTickByCond(cond, "id_sch", null);
		if (ArrayUtil.isEmpty(tickDOs)) {
			return null;
		}
		Map<String, List<ScSchTickDO>> map = new HashMap<String, List<ScSchTickDO>>();
		for (ScSchTickDO tickDO : tickDOs) {
			String key = tickDO.getId_sch();
			if (null == schMap.get(key)) {
				continue;
			}
			// 渠道号位对应排班渠道的号源池
			int polcn = schMap.get(key);
			// 记录排班号位号源池相同且不包含当前渠道的号位
			if (null != tickDO.getPolno() && tickDO.getPolno() == polcn
					&& !tickDO.getIds_scchl().contains(chlDO.getId_scchl())) {
				if (map.containsKey(key)) {
					map.get(key).add(tickDO);
				} else {
					List<ScSchTickDO> temp = new ArrayList<ScSchTickDO>();
					temp.add(tickDO);
					map.put(key, temp);
				}
			}
		}
		return map;
	}
}
