package iih.sc.scp.s.bp;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据计划id求计划下面的周数
 * @author ccj
 *
 */
public class GetIdxWeekByPlanBp {
	
	/**
	 * 根据计划id求计划下面的周数
	 * @param id_scpl 计划id
	 * @return Integer[]  周计划下面的周arrays
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public Integer[] exec(String id_scpl)throws BizException{
		if(StringUtils.isBlank(id_scpl)) return null;
		SqlParam param = new SqlParam();
		StringBuffer buffer = new StringBuffer();
		buffer.append("select distinct week.idx_week from sc_pl_week week where week.id_scpl = ? and week.idx_week is not null order by week.idx_week");
		param.addParam(id_scpl);
		List<Integer> list = (List<Integer>) new DAFacade().execQuery(buffer.toString(), param, new ColumnListHandler());
		if(CollectionUtils.isEmpty(list)) return null;
		return list.toArray(new Integer[list.size()]);
	}
}
