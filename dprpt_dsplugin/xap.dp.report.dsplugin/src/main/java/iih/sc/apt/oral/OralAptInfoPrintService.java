package iih.sc.apt.oral;

import java.util.List;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.handler.BeanListHandler;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 口腔科预约信息打印服务
 * 
 * @author zhengcm
 * @date 2016-10-12 20:05:43
 *
 */
public class OralAptInfoPrintService {

	/**
	 * 
	 * 查询口腔科预约单打印信息
	 *
	 * @param id_apt 预约id
	 * @return
	 * @throws Exception
	 * @author zhengcm
	 */
	public OralAptInfoDTO[] query(String id_apt) throws Exception {

		// 组装查询SQL
		StringBuilder sb = this.getSql(id_apt);

		// 执行查询
		List<OralAptInfoDTO> datas = this.getResultBySql(sb.toString());
		if (ListUtil.isEmpty(datas)) {
			return null;
		}

		OralAptInfoDTO data = datas.get(0);

		// 处理预约星期
		FDate date = new FDate(data.getDt_b_apt().substring(0, 10));
		data.setDay_week_apt(this.getDayOfWeek(date));

		// 查询排班服务对应的医疗服务参考价格
		sb = this.getSrvSql(data.getId_scsrv());
		List<OralAptInfoDTO> priDatas = this.getResultBySql(sb.toString());

		// 计算金额
		this.caclulateAmount(data, priDatas);

		return new OralAptInfoDTO[] { data };
	}

	/**
	 * 组装查询SQL
	 *
	 * @param id_apt
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private StringBuilder getSql(String id_apt) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("apt.code as code_apt,");
		sb.append("pat.barcode_chis as code_chis,");
		sb.append("pat.name as name_pat,");
		sb.append("dep.name as name_dep_apt,");
		sb.append("apt.dt_b as dt_b_apt,");
		sb.append("psn.name as name_doctor,");
		sb.append("site.room as name_room,");
		sb.append("site.name as name_quesite,");
		sb.append("apt.id_scsrv,");
		sb.append("srv.name as name_scsrv,");
		sb.append("para.sugest_exmint as time_suggest ");
		sb.append("from ");
		sb.append("sc_apt apt ");
		sb.append("inner join sc_sch sch on sch.id_sch = apt.id_sch ");
		sb.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		sb.append("inner join sc_srv srv on srv.id_scsrv = apt.id_scsrv ");
		sb.append("inner join bd_que_site site on site.id_quesite = sch.id_quesite ");
		sb.append("inner join bd_dep dep on dep.id_dep = pl.id_dep ");
		sb.append("inner join pi_pat pat on pat.id_pat = apt.id_pat ");
		sb.append("inner join sc_dep_param para on para.id_dep = dep.id_dep ");
		sb.append("left join sc_res res on res.id_scres = pl.id_scres ");
		sb.append("left join bd_psndoc psn on psn.id_psndoc = res.id_emp ");
		sb.append("where ");
		sb.append("apt.id_apt = '" + id_apt + "'");
		return sb;
	}

	/**
	 * 查询排班服务对应的医疗服务参考价格Sql
	 * 
	 * @param id_scsrv
	 * @return
	 * @throws Exception
	 */
	private StringBuilder getSrvSql(String id_scsrv) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("select bsrv.pri as price ");
		sb.append("from ");
		sb.append("sc_srv_rel rel ");
		sb.append("inner join sc_srv ssrv on ssrv.id_scsrv = rel.id_scsrv ");
		sb.append("inner join bd_srv bsrv on bsrv.id_srv = rel.id_mdsrv ");
		sb.append("where ");
		sb.append("ssrv.id_scsrv = '" + id_scsrv + "'");
		return sb;
	}

	/**
	 * 查询数据
	 *
	 * @param sql
	 * @return
	 * @throws Exception
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private List<OralAptInfoDTO> getResultBySql(String sql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, sql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(OralAptInfoDTO.class);
		List<OralAptInfoDTO> result = (List<OralAptInfoDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}

	/**
	 * 计算金额（取排班计划对应的排班服务对应下的医疗服务的参考价格之和）
	 * 
	 * @param infoDTO
	 * @param datas
	 * @throws Exception
	 */
	private void caclulateAmount(OralAptInfoDTO infoDTO, List<OralAptInfoDTO> datas) throws Exception {
		if (infoDTO == null || ListUtil.isEmpty(datas)) {
			return;
		}
		double amount = 0;
		for (OralAptInfoDTO data : datas) {
			amount = amount + data.getPrice();
		}
		infoDTO.setAmount(amount);
	}

	/**
	 * 根据日期获取星期几
	 *
	 * @param fdate
	 * @return
	 * @throws Exception
	 * @author zhengcm
	 */
	private String getDayOfWeek(FDate fdate) throws Exception {
		String weekDay = "";
		int day = fdate.getWeek();
		switch (day) {
		case 1:
			weekDay = "星期一";
			break;
		case 2:
			weekDay = "星期二";
			break;
		case 3:
			weekDay = "星期三";
			break;
		case 4:
			weekDay = "星期四";
			break;
		case 5:
			weekDay = "星期五";
			break;
		case 6:
			weekDay = "星期六";
			break;
		case 7:
			weekDay = "星期日";
			break;
		}
		return weekDay;
	}

}
