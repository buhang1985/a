package iih.mp.dg.antidispsum;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 抗菌药情况统计报表服务
 * @author Huan He 2017/5/15
 *
 */
public class AntiDispSumService {
	
	/**
	 * 服务主方法
	 * @param dateBegin 查询开始日期
	 * @param dateEnd 查询结束日期
	 * @param id_anti_set 抗菌药分类编码集
	 * @param opOrIp 门诊住院标记
	 * @return 根据查询条件从数据库返回的报表DTO列表
	 * @throws Exception
	 */
	public List<AntiDispSumRptDTO> fillBeanList(String dateBegin, String dateEnd, String id_anti_set, String opOrIp, String org_id) throws Exception {
		
		if(opOrIp.equals("01")) {
			return getOpAntiDispSumRptDTO(dateBegin, dateEnd, id_anti_set, org_id);
		}
		else {
			return getIpAntiDispSumRptDTO(dateBegin, dateEnd, id_anti_set, org_id);
		}
		
	}

	/**
	 * 门诊统计查询方法
	 * @param dateBegin 查询开始日期
	 * @param dateEnd 查询结束日期
	 * @param id_anti_set 抗菌药分类编码集
	 * @return 根据查询条件从数据库返回的报表DTO列表
	 * @throws Exception
	 */
	private List<AntiDispSumRptDTO> getOpAntiDispSumRptDTO(String dateBegin, String dateEnd, String id_anti_set, String org_id) throws Exception {
		dateBegin += " 00:00:00";
		dateEnd += " 23:23:59";
		String modSet = modifyParam(id_anti_set);
		StringBuffer strSql = new StringBuffer();
		strSql.append("select mp_dg_op.dt_dp as adm_date,BD_MM.name as med_name,BD_MM.spec as med_spec,bd_dep.name as department,");
		strSql.append("bd_psndoc.name as physician,sum(mp_dg_op_dt.quan_mp) as quantity");
		strSql.append(" from mp_dg_op");
		strSql.append(" inner join mp_dg_op_dt on mp_dg_op.id_dgop = mp_dg_op_dt.id_dgop");
		strSql.append(" inner join ci_or_srv on mp_dg_op_dt.id_orsrv = ci_or_srv.id_orsrv");
		strSql.append(" inner join ci_order on ci_or_srv.id_or = ci_order.id_or");
		strSql.append(" inner join ci_or_srv_mm on ci_or_srv_mm.id_orsrv = ci_or_srv.id_orsrv");
		strSql.append(" left join BD_MM on mp_dg_op_dt.id_mm = BD_MM.id_mm");
		strSql.append(" left join bd_psndoc on ci_order.id_emp_or = bd_psndoc.id_psndoc");
		strSql.append(" left join bd_dep on ci_order.id_dep_or = bd_dep.id_dep");
		strSql.append(" where ci_or_srv_mm.id_anti in (" + modSet + ")");
		if(!StringUtils.isBlank(org_id) && !"null".equals(org_id)) {
			strSql.append(" and mp_dg_op.id_org = '" + org_id + "'");
		}
		if(!StringUtils.isBlank(dateBegin) && !"null".equals(dateBegin) && !"".equals(dateBegin.trim())) {
			strSql.append(" and mp_dg_op.dt_dp >= '" + dateBegin + "'");
		}
		if(!StringUtils.isBlank(dateEnd) && !"null".equals(dateEnd) && !"".equals(dateEnd.trim())) {
			strSql.append(" and mp_dg_op.dt_dp <= '" + dateEnd + "'");
		}
		strSql.append(" group by mp_dg_op.dt_dp,BD_MM.name,BD_MM.spec,bd_dep.name,bd_psndoc.name");
		strSql.append(" order by mp_dg_op.dt_dp, BD_MM.name");
		
		return this.getResultBySql(strSql.toString());
	}
	
	/**
	 * 住院统计查询方法
	 * @param dateBegin 查询开始日期
	 * @param dateEnd 查询结束日期
	 * @param id_anti_set 抗菌药分类编码集
	 * @return 根据查询条件从数据库返回的报表DTO列表
	 * @throws Exception
	 */
	private List<AntiDispSumRptDTO> getIpAntiDispSumRptDTO(String dateBegin, String dateEnd, String id_anti_set, String org_id) throws Exception {
		dateBegin += " 00:00:00";
		dateEnd += " 23:23:59";
		String modSet = modifyParam(id_anti_set);
		StringBuffer strSql = new StringBuffer();
		strSql.append("select mp_dg_ip_de.dt_dp as adm_date,BD_MM.name as med_name,BD_MM.Spec as med_spec,bd_dep.name as department,");
		strSql.append("bd_psndoc.name as physician,sum(mp_dg_ip_apde_dt.quan_ap) as quantity");
		strSql.append(" from mp_dg_ip_apde_dt");
		strSql.append(" inner join mp_dg_ip_de on mp_dg_ip_apde_dt.id_dgipde = mp_dg_ip_de.id_dgipde and mp_dg_ip_de.sd_dgtp in ('21', '23') and mp_dg_ip_apde_dt.quan_ap > 0");
		strSql.append(" inner join ci_order on mp_dg_ip_apde_dt.id_or = ci_order.id_or");
		strSql.append(" inner join ci_or_srv on mp_dg_ip_apde_dt.id_orsrv = ci_or_srv.id_orsrv");
		strSql.append(" inner join ci_or_srv_mm on ci_or_srv_mm.id_orsrv = ci_or_srv.id_orsrv");
		strSql.append(" left join BD_MM on mp_dg_ip_apde_dt.id_mm = BD_MM.id_mm");
		strSql.append(" left join bd_psndoc on ci_order.id_emp_or = bd_psndoc.id_psndoc");
		strSql.append(" left join bd_dep on ci_order.id_dep_or = bd_dep.id_dep");
		strSql.append(" where ci_or_srv_mm.id_anti in (" + modSet + ")");
		if(!StringUtils.isBlank(org_id) && !"null".equals(org_id)) {
			strSql.append(" and mp_dg_ip_apde_dt.id_org = '" + org_id + "'");
		}
		if(!StringUtils.isBlank(dateBegin) && !"null".equals(dateBegin) && !"".equals(dateBegin.trim())) {
			strSql.append(" and mp_dg_ip_de.dt_dp >= '" + dateBegin + "'");
		}
		if(!StringUtils.isBlank(dateEnd) && !"null".equals(dateEnd) && !"".equals(dateEnd.trim())) {
			strSql.append(" and mp_dg_ip_de.dt_dp <= '" + dateEnd + "'");
		}
		strSql.append(" group by mp_dg_ip_de.dt_dp,BD_MM.name,BD_MM.Spec,bd_dep.name,bd_psndoc.name");
		strSql.append(" order by mp_dg_ip_de.dt_dp, BD_MM.name");
		
		return this.getResultBySql(strSql.toString());
	}
	
	/**
	 * 将抗菌药分类编码集元素加单引号的方法
	 * @param ss 未处理的抗菌药分类编码集
	 * @return 处理后的抗菌药分类编码集
	 */
	private String modifyParam(String ss) {
		String[] aa = ss.split(",");
		StringBuffer bf = new StringBuffer();
		for (String item : aa) {
			bf.append("'" + item + "',");
		}
		bf.deleteCharAt(bf.length()-1);
		
		return bf.toString();
	}
	
	/**
	 * 与数据库进行连接的方法
	 * @param strSql SQL查询语句
	 * @return 根据查询语句从数据库返回的报表DTO列表
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private List<AntiDispSumRptDTO> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(AntiDispSumRptDTO.class);
		List<AntiDispSumRptDTO> result = (List<AntiDispSumRptDTO>)beanlist_handler.processRs(cached_rs);

		sql_rdr.destroy();
		
		if(result == null || result.size() <= 0) {
			return null;
		}
		
		return result;
	}
	
}
