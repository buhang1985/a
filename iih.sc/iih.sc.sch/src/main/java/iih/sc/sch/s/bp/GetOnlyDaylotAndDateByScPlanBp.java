package iih.sc.sch.s.bp;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**获取所有唯一的日期分组和排班日期根据计划和排班开始、结束时间
 * @author ccj
 *
 */
public class GetOnlyDaylotAndDateByScPlanBp {
	/**获取所有唯一的日期分组和排班日期根据计划和排班开始、结束时间
	 * @param id_plan  计划id
	 * @param begDate	排班开始时间
	 * @param endDate	排班结束时间
	 * @param excludeDates 排除日期s
	 * @return mapList 结果集
	 * @throws BizException
	 */
	public List exec(String id_plan, String begDate, String endDate, String excludeDates) throws BizException {
		if (StringUtils.isEmpty(id_plan) || StringUtils.isEmpty(begDate) || StringUtils.isEmpty(endDate))
			return null;
		SqlParam sqlParam = new SqlParam();
		String qurSQL = "select distinct sch.id_dayslot,sch.d_sch  from sc_sch sch where d_sch >= ? and  d_sch <= ? and id_scpl = ?";
		if (StringUtils.isNotEmpty(excludeDates)) {
			qurSQL += " and sch.d_sch not in (" + excludeDates + ")";
		}
		sqlParam.addParam(begDate);
		sqlParam.addParam(endDate);
		sqlParam.addParam(id_plan);
		List list = (List) new DAFacade().execQuery(qurSQL, sqlParam, new MapListHandler());
		return list;
	}
}
