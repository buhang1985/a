package iih.sc.apt.oral;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.handler.BeanListHandler;

import com.sun.rowset.CachedRowSetImpl;

public class OralAptExportService {

	/**
	 * 查询数据
	 * 
	 * @author zhengcm
	 * @date 2017-12-05 15:37:17
	 *
	 * @param id_grp
	 * @param id_org
	 * @param wherePart
	 * @return
	 * @throws Exception
	 */
	public List<OralAptExportDTO> query(String id_grp, String id_org, String wherePart) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("select * ");
		sb.append("from ");
		sb.append("(select ");
		sb.append("apt.id_grp,");
		sb.append("apt.id_org,");
		sb.append("pl.id_scpl,");
		sb.append("pat.id_pat,");
		sb.append("apt.code as code_apt,");
		sb.append("pat.barcode_chis as pat_code,");
		sb.append("pat.name as name_pat,");
		sb.append("sex.name as name_sex,");
		sb.append("pat.mob as pat_tel,");
		sb.append("pat.id_code as pat_documentnum,");
		sb.append("pat.dt_birth as d_birth,");
		sb.append("proc.name as name_proc,");
		sb.append("apt.dt_appt as dt_apt,");
		sb.append("substr(apt.dt_b, 0, 10) as d_b,");
		sb.append("apt.dt_b as dt_b,");
		sb.append("apt.dt_e as dt_e,");
		sb.append("res.name as name_scres,");
		sb.append("psn.name as name_emp_canc,");
		sb.append("apt.dt_canc,");
		sb.append("oral.d_next_appt as d_next_appt,");
		sb.append("oral.note_next as note,");
		sb.append("status.name as name_status,");
		sb.append("tag.name as name_confirm,");
		sb.append("chl.name as name_scchl ");
		sb.append("from ");
		sb.append("sc_apt apt ");
		sb.append("inner join sc_sch sch on sch.id_sch = apt.id_sch ");
		sb.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl and pl.eu_edit_tp = '1' ");
		sb.append("inner join sc_chl chl on chl.id_scchl = apt.id_scchl ");
		sb.append("inner join pi_pat pat on pat.id_pat = apt.id_pat ");
		sb.append("left join sc_apt_op_oral oral on apt.id_apt = oral.id_apt ");
		sb.append("left join bd_udidoc sex on sex.id_udidoc = pat.id_sex ");
		sb.append("left join bd_udidoc proc on proc.id_udidoc = oral.id_proc_oral ");
		sb.append("left join sc_res res on res.id_scres = apt.id_scres ");
		sb.append("left join bd_udidoc status on status.id_udidoc = apt.id_status ");
		sb.append("left join bd_udidoc tag on tag.id_udidoc = oral.id_statustag ");
		sb.append("left join bd_psndoc psn on psn.id_psndoc = apt.id_emp_canc) sc_apt ");
		sb.append("where 1 = 1 ");
		sb.append("and id_org = '" + id_org + "' ");
		if (StringUtil.isEmptyWithTrim(wherePart)) {
			sb.append("and 1 = 2 ");
		} else {
			sb.append("and " + wherePart);
		}
		sb.append("order by dt_b,code_apt ");
		// 执行查询
		List<OralAptExportDTO> datas = this.getResultBySql(sb.toString());
		// 计算患者年龄
		this.calcPatAge(datas);
		// 如果取消预约人员名称为tokenX，则显示对应渠道的名称 add by zhengcm 2018-01-03
		this.changeExclEmpCanc(datas);
		return datas;
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
	private List<OralAptExportDTO> getResultBySql(String sql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, sql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(OralAptExportDTO.class);
		List<OralAptExportDTO> result = (List<OralAptExportDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}

	/**
	 * 计算患者年龄
	 * 
	 * @author zhengcm
	 * @param datas 床位卡打印报表数据DTO
	 * @throws Exception
	 */
	private void calcPatAge(List<OralAptExportDTO> datas) throws Exception {
		if (ListUtil.isEmpty(datas)) {
			return;
		}
		for (OralAptExportDTO dto : datas) {
			if (StringUtil.isEmptyWithTrim(dto.getD_birth())) {
				continue;
			}
			dto.setAge_pat(this.getAge(new FDate(dto.getD_birth())));
		}
	}

	/**
	 * 如果取消预约人员名称为tokenX，则显示对应渠道的名称 add by zhengcm 2018-01-03
	 * 
	 * @author zhengcm
	 * @date 2018-01-03 14:29:50
	 *
	 * @param datas
	 * @throws Exception
	 */
	private void changeExclEmpCanc(List<OralAptExportDTO> datas) throws Exception {
		if (ListUtil.isEmpty(datas)) {
			return;
		}
		for (OralAptExportDTO data : datas) {
			if (!StringUtil.isEmptyWithTrim(data.getName_emp_canc())
					&& data.getName_emp_canc().toUpperCase().startsWith("TOKEN")) {
				data.setName_emp_canc(data.getName_scchl());
			}
		}
	}

	/**
	 * 计算年龄（因为无法调用公共的方法，为了显示统一，直接拷贝了工具类AgeCalcUtil的方法）
	 * 
	 * @author zhengcm
	 * @param birth 生日
	 * @return
	 */
	private String getAge(FDate birth) {
		if (birth == null) {
			return "不详";
		}
		birth = birth.asBegin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = df.format(new Date());// 获取当前系统时间
		FDateTime curTime = new FDateTime(now);
		FDate curDate = curTime.getDate().asBegin();
		if (birth.after(curDate)) {
			return "不详";
		}

		int Months = curDate.getLocalMonth() - birth.getLocalMonth() + 12
				* (curDate.getLocalYear() - birth.getLocalYear());
		Calendar cal = Calendar.getInstance();
		cal.setTime(birth.toDate());
		cal.add(2, Months);

		int totalMonth = new FDate(cal.getTime()).after(curDate) ? Months - 1 : Months;

		int fullYear = totalMonth / 12;

		int fullMonth = totalMonth % 12;

		cal.setTime(birth.toDate());
		cal.add(2, totalMonth);
		FDate changeDate = new FDate(cal.getTime());
		int days = FDate.getDaysBetween(changeDate, curDate);
		if (fullYear >= 5) {
			return String.format("%d岁", new Object[] { Integer.valueOf(fullYear) });
		}
		if ((fullYear < 5) && (fullYear >= 1)) {
			if (fullMonth <= 0) {
				return String.format("%d岁", new Object[] { Integer.valueOf(fullYear) });
			}
			return String.format("%d岁%d月", new Object[] { Integer.valueOf(fullYear), Integer.valueOf(fullMonth) });
		}

		if ((fullMonth >= 1) && (fullYear <= 1)) {
			if (days <= 0) {
				return String.format("%d月", new Object[] { Integer.valueOf(fullMonth) });
			}
			return String.format("%d月零%d天", new Object[] { Integer.valueOf(fullMonth), Integer.valueOf(days) });
		}
		if (days <= 0) {
			return String.format("%d天", new Object[] { Integer.valueOf(1) });
		}
		return String.format("%d天", new Object[] { Integer.valueOf(days) });
	}

}
