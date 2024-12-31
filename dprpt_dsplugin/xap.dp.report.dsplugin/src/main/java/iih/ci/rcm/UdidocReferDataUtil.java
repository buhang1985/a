package iih.ci.rcm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.sys.jdbc.handler.BeanListHandler;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 查询自定义参照
 * 
 * @author tangws
 * @date 2015年4月6日 上午11:12:16
 *
 */
public class UdidocReferDataUtil {

	@SuppressWarnings("unchecked")
	public static Map<String, LinkedHashMap<String, String>> queryUdidoc(
			String[] udidocpks) throws Exception {

		Map<String, LinkedHashMap<String, String>> udimap = new HashMap<String, LinkedHashMap<String, String>>();

		StringBuilder sql = new StringBuilder();
		sql.append("select udi.code as code,");
		sql.append("udi.name as name,");
		sql.append("udi.id_udidoclist as id_udidoclist,");
		sql.append("udi.id_udidoc as id ");
		sql.append("from bd_udidoc udi ");
		sql.append("where udi.id_udidoclist in (");
		for (int i = 0; i < udidocpks.length; i++) {
			sql.append("'" + udidocpks[i] + "'");
			if (i != udidocpks.length - 1) {
				sql.append(",");
			}
		}
		sql.append(") order by code");
		SqlReader sql_rdr = new SqlReader(null, sql.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(ReferDTO.class);
		List<ReferDTO> result = (List<ReferDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();

		if (result != null && result.size() > 0)
			for (ReferDTO refdto : result) {
				if (udimap.containsKey(refdto.getId_udidoclist())) {
					udimap.get(refdto.getId_udidoclist()).put(refdto.getId(),
							refdto.getName());
				} else {
					LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
					map.put(refdto.getId(), refdto.getName());
					udimap.put(refdto.getId_udidoclist(), map);
				}
			}

		return udimap;
	}

}
