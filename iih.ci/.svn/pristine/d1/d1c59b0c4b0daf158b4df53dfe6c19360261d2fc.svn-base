package iih.ci.ord.s.external.provide.bp.partner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院的护理天数(兰陵使用)
 * 
 * @author li_zheng
 *
 */
public class getNursingDaysBP {

	public Map<String, Integer> getNursingDays(String id_ent) throws BizException {
		Map<String, Integer> map = new HashMap<String, Integer>() {
			{
				put("120100002", 0);
				put("120100003", 0);
				put("120100004", 0);
				put("120100005", 0);
			}
		};
		List<CiOrderDO> list = getNursingOrder(id_ent);
		/*
		 * put("120100002",0); 特级护理 put("120100003",0);一级护理
		 * put("120100004",0);二级护理 put("120100005",0);三级护理
		 */
		if (list == null || list.size() == 0)
			return map;
		Integer days = 0;
		for (CiOrderDO orderDO : list) {
			if (orderDO.getDt_stop() != null) {
				days = orderDO.getDt_stop().getDate().asLocalBegin()
						.getDaysAfter(orderDO.getDt_effe().getDate().asLocalBegin());
				days = (days==0 ? 1 : days);
				if (map.containsKey(orderDO.getCode_or())) {
					map.put(orderDO.getCode_or(), map.get(orderDO.getCode_or()) + days);
				}
			}
		}
		return map;
	}

	/**
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private List<CiOrderDO> getNursingOrder(String id_ent) throws BizException {
		SqlParam sqlparam=new SqlParam();
		sqlparam.addParam(id_ent);
		List<CiOrderDO> list = (List<CiOrderDO>) new DAFacade().execQuery(getSql(),sqlparam,
				new BeanListHandler(CiOrderDO.class));
		return list;
	}

	/**
	 * 
	 * @param id_ent
	 * @return
	 */
	private String getSql() {
		StringBuffer sqlsb = new StringBuffer();
		sqlsb.append(
				" select orsrv.code_srv code_or,  ord.dt_effe ,ord.dt_entry,orsrv.dt_last_cg as dt_stop,ord.name_or ");
		sqlsb.append(" from  ci_order ord, ci_or_srv orsrv ");
		sqlsb.append(" where  ord.id_or = orsrv.id_or ");
		sqlsb.append(" and ord.sd_srvtp like '0601%' ");
		sqlsb.append(" and ord.id_en =?");
		return sqlsb.toString();
	}

}
