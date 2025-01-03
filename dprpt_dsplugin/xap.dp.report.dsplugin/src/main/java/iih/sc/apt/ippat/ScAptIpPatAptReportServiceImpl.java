package iih.sc.apt.ippat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.sun.rowset.CachedRowSetImpl;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 医技预约（住院病人）报表
 *
 * @author yaohl
 *
 */
public class ScAptIpPatAptReportServiceImpl {

	/**
	 * @author yaohl
	 * @param dt_b
	 * @param dt_e
	 * @param id_dep_nur
	 *            病区
	 * @param sd_status
	 *            状态
	 * @return
	 * @throws Exception
	 */
	public List<AptIpPatDTO> exec(String dt_b, String dt_e, String id_dep_nur, String sd_status) throws Exception {
		if(StringUtil.isEmpty(sd_status) || StringUtil.isEmpty(id_dep_nur)) return null;
		String sql = this.getSql(dt_b, dt_e, id_dep_nur, sd_status);
		// 执行sql
		List<AptIpPatDTO> resultBySql = this.getResultBySql(sql.toString());
		if (ListUtil.isEmpty(resultBySql))
			return null;
		// 循环 拆分医嘱
		for (AptIpPatDTO ipPatDTO : resultBySql) {
			if (StringUtils.isNotEmpty(ipPatDTO.getContent_or()) && "0".equals(ipPatDTO.getSd_sys_from())) {
				String newContent = this.getCiOrderContent(ipPatDTO.getContent_or());
				if (StringUtils.isNotEmpty(newContent)) {
					ipPatDTO.setContent_or(newContent);
				}
			}
		}
		// 处理医嘱
		return resultBySql;
	}
	/**
	 * 获取sql
	 * @param dt_b
	 * @param dt_e
	 * @param id_dep_nur
	 * @param sd_status
	 * @return
	 */
	private String getSql(String dt_b, String dt_e, String id_dep_nur, String sd_status) {

		StringBuffer sql = new StringBuffer();
		if ("Y".equals(sd_status)) {//作废
			sql.append(" select ");
			sql.append(" ip.name_bed code_bed,");
			sql.append(" pat.name name_pat,");
			sql.append(" ip.code_amr_ip code_ip,");
			sql.append(" appl.sd_sys_from,");
			sql.append(" appl.content_or,");
			sql.append(" 'Y' sd_status ");
			sql.append(" from sc_apt_appl appl ");
			sql.append(" inner join en_ent ent on ent.id_ent = appl.id_ent and ent.fg_ip = 'Y'");
			sql.append(" inner join en_ent_ip ip on ent.id_ent  = ip.id_ent");
			sql.append(" inner join pi_pat pat on appl.id_pi = pat.id_pat");
			sql.append(" inner join bd_dep dep on  ent.id_dep_nur = dep.id_dep ");
			sql.append(" where appl.fg_canc = 'Y' and sd_sctp = '03'");
			if (!StringUtil.isEmptyWithTrim(dt_b)) {
				sql.append(" and appl.d_b >= '" + dt_b + " 00:00:00'");
			}
			/*if (!StringUtil.isEmptyWithTrim(dt_e)) {
				sql.append(" and apt.dt_e <= '" + dt_e + " 23:59:59'");
			}*/
			if (!StringUtil.isEmptyWithTrim(id_dep_nur)) {
				sql.append(" and ent.id_dep_nur = '" + id_dep_nur + "'");
			}
		} else if ("N".equals(sd_status)) {//预约
			sql.append(" select ");
			sql.append(" ip.name_bed code_bed,");
			sql.append(" pat.name name_pat,");
			sql.append(" ip.code_amr_ip code_ip,");
			sql.append(" apt.dt_b,");
			sql.append(" appl.sd_sys_from,");
			sql.append(" appl.content_or,");
			sql.append(" pl.des addr_apt,");
			sql.append(" 'N' sd_status");
			sql.append(" from sc_apt apt");
			sql.append(" inner join sc_apt_appl appl on apt.id_apt = appl.id_scapt and apt.fg_canc = 'N' and appl.sd_sctp = '03'");
			sql.append(" inner join en_ent ent on ent.id_ent = appl.id_ent and ent.fg_ip = 'Y'");
			sql.append(" inner join en_ent_ip ip on ent.id_ent  = ip.id_ent");
			sql.append(" inner join pi_pat pat on apt.id_pat = pat.id_pat");
			sql.append(" inner join bd_dep dep on  ent.id_dep_nur = dep.id_dep ");
			sql.append(" inner join sc_sch sch on apt.id_sch  = sch.id_sch");
			sql.append(" inner join sc_pl pl on sch.id_scpl = pl.id_scpl ");
			sql.append(" where 1 = 1 and apt.fg_canc = 'N'");
			if (!StringUtil.isEmptyWithTrim(dt_b)) {
				sql.append(" and apt.dt_b >= '" + dt_b + " 00:00:00'");
			}
			if (!StringUtil.isEmptyWithTrim(dt_e)) {
				sql.append(" and apt.dt_e <= '" + dt_e + " 23:59:59'");
			}
			if (!StringUtil.isEmptyWithTrim(id_dep_nur)) {
				sql.append(" and ent.id_dep_nur = '" + id_dep_nur + "'");
			}
			sql.append(" order by code_bed");
		}else{
			return null;
		}
		return sql.toString();
	}

	/**
	 * 执行SQL
	 *
	 * @param qry
	 * @return
	 * @throws Exception
	 */
	private List<AptIpPatDTO> getResultBySql(String qry) throws Exception {
		if(StringUtil.isEmpty(qry)) return null;
		SqlReader sql_rdr = new SqlReader(null, qry);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(AptIpPatDTO.class);
		List<AptIpPatDTO> result = (List<AptIpPatDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}

	/**
	 * 拆分医嘱内容
	 *
	 * @param content_or
	 * @return
	 * @modified yu.b 2020-07=10
	 */
	private String getCiOrderContent(String content_or) {
		StringBuilder sb = new StringBuilder();
		LinkedList<String> strs = new LinkedList<String>(Arrays.asList(content_or.split("\\|\\|")));
		if(strs.size() <= 2){
			String[] split = content_or.split("\\|");
			if(split.length > 3){
				String[] content_ors = split[2].split("&");
				if(content_ors.length > 0){
					return content_ors[0];
				}
			}
		}
		strs.remove(0);
		for(String str1 : strs) {
			if(StringUtil.isEmpty(str1)) continue;
			String[] strArr = str1.split("&");
			if(ArrayUtil.isEmpty(strArr)) continue;
			sb.append(strArr[0]);
			sb.append(";");
		}
		return sb.toString();
	}
}
