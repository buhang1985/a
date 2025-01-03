package iih.sc.apt.aptmthava;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.handler.BeanListHandler;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 医技已预约报表用 服务实现类
 * @author ccj
 *
 */
public class ScAptMtHavaReportServiceImpl {

	/**
	 * 报表查询功能
	 * @param id_dep_mp  执行科室id
	 * @param id_entp 	就诊类型id
	 * @param content_or	医嘱内容
	 * @param no_applyform  申请单号
	 * @param pat_name	患者姓名
	 * @param begin_date	开始时间
	 * @param end_date	结束时间
	 * @return
	 * @throws Exception
	 */
	public ScAptMtHavaReportDTO[] query(String name_dep,String name_entp,String content_or,String no_applyform,
			String pat_name,String begin_date,String end_date,String days,String name_res) throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("select apt.dt_b,pat.name as pat_name,pat.dt_birth,udoc.name as sex_name,pat.mob,appl.content_or,appl.applyno  as no_applyform,apt.dt_appt,appl.sd_sys_from ");
		sql.append(" from sc_apt apt ");
		sql.append(" inner join sc_apt_mt mt on apt.id_apt = mt.id_apt and mt.ds = 0  and apt.fg_canc = 'N' and apt.sd_sctp = '03' ");
		sql.append(" inner join sc_apt_appl appl on appl.id_aptappl = mt.id_aptappl ");
		if(StringUtils.isNotBlank(content_or)){
			// 医嘱内容过滤
			sql.append(" and appl.content_or like '%");
			sql.append(content_or);
			sql.append("%' ");
		}
		//sql.append(" inner join ci_ap_obs ap_ops on mt.id_or = ap_ops.id_or and ap_ops.ds = 0 ");
		if(StringUtils.isNotBlank(no_applyform) ){
			// 申请单过滤
			sql.append(" and appl.applyno like '%");
			sql.append(no_applyform);
			sql.append("%' ");
		}
		sql.append(" inner join pi_pat pat on pat.id_pat = apt.id_pat and pat.ds = 0 ");
		sql.append(" inner join bd_udidoc udoc on pat.id_sex = udoc.id_udidoc and udoc.ds = 0 ");
		sql.append(" inner join bd_dep dep on mt.id_dep_mp=dep.id_dep ");
		if(StringUtils.isNotBlank(name_dep)){
			// 执行科室过滤
			sql.append(" and dep.name = '");
			sql.append(name_dep);
			sql.append("' ");
		}
		sql.append(" inner join bd_entp entp on appl.Id_entp=entp.Id_entp ");
		if(StringUtils.isNotBlank(name_entp)){
			// 就诊类型过滤
			sql.append(" and entp.Name = '");
			sql.append(name_entp);
			sql.append("' ");
		}
		sql.append(" inner join sc_res res on res.Id_scres=apt.id_scres ");
		if(StringUtils.isNotBlank(name_res)){
			// 就诊类型过滤
			sql.append(" and res.Name = '");
			sql.append(name_res);
			sql.append("' ");
		}
		sql.append(" where apt.ds = 0  ");
		if(StringUtils.isNotBlank(pat_name)){
			// 患者id 过滤
			sql.append(" and pat.name like '%");
			sql.append(pat_name);
			sql.append("%' ");
		}
		if(StringUtils.isNotBlank(begin_date) ){
			// 开始时间 过滤
			sql.append(" and apt.dt_appt >= '");
			sql.append(begin_date);
			sql.append("' ");
		}
		if(StringUtils.isNotBlank(end_date)){
			// 结束时间  过滤
			sql.append(" and apt.dt_appt <= '");
			// 结束时间要对 时分秒做处理 应为数据库中存储的是日期时间格式
			sql.append(end_date+" 23:59:59");
			sql.append("' ");
		}
		if(StringUtils.isNotBlank(days)){
			sql.append(" and (TO_DATE(SUBSTR(apt.dt_b,1,10), 'YYYY-MM-DD')-TO_DATE( SUBSTR(apt.dt_appt,1,10), 'YYYY-MM-DD')) >= ");
			sql.append(days);
		}
		sql.append(" order by apt.dt_b desc");
		ScAptMtHavaReportDTO[] reportDTOs = executeSql(sql.toString());
		if(ArrayUtils.isEmpty(reportDTOs)) return null;
		// 循环 拆分医嘱
		for (ScAptMtHavaReportDTO scAptMtHavaReportDTO : reportDTOs) {
			if(StringUtils.isNotEmpty(scAptMtHavaReportDTO.getContent_or()) && "0".equals(scAptMtHavaReportDTO.getSd_sys_from())){
				String newContent = this.getCiOrderContent(scAptMtHavaReportDTO.getContent_or());
			if(StringUtils.isNotEmpty(newContent)){
				scAptMtHavaReportDTO.setContent_or(newContent);
			}
		}
		}
		return reportDTOs;
	}

	/**
	 * 执行sql语句
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	private ScAptMtHavaReportDTO[] executeSql(String sql) throws Exception{
		SqlReader sql_rdr = new SqlReader(null, sql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(ScAptMtHavaReportDTO.class);
		List<ScAptMtHavaReportDTO> result = (List<ScAptMtHavaReportDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		return result.toArray(new ScAptMtHavaReportDTO[result.size()]);
	}
	/**
	 * 拆分医嘱内容
	 * @param content_or
	 * @return
	 * @modified yu.b 2020-07-10
	 */
	private String getCiOrderContent(String content_or){
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
