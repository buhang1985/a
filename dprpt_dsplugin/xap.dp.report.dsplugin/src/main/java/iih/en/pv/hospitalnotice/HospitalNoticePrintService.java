package iih.en.pv.hospitalnotice;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.handler.BeanListHandler;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 入院通知单打印服务
 * 
 * @author zhengcm
 * @date 2018-01-06 11:02:07
 *
 */
public class HospitalNoticePrintService {

	/**
	 * 查询数据
	 * 
	 * @author zhengcm
	 * @date 2018-01-06 11:01:56
	 *
	 * @param id_aptip
	 * @return
	 * @throws Exception
	 */
	public HospitalNoticeDTO[] query(String id_aptip) throws Exception {

		// 组装SQL
		StringBuilder sql = this.getSql(id_aptip);

		// 执行查询
		List<HospitalNoticeDTO> datas = this.getResultBySql(sql.toString());
		if (ListUtil.isEmpty(datas)) {
			return null;
		}

		HospitalNoticeDTO data = datas.get(0);

		// 押金显示格式
		DecimalFormat df = new DecimalFormat("#.00");
		data.setText_deposit(df.format(data.getDeposit()));

		// 计算患者年龄
		data.setText_age(this.getAge(new FDate(data.getD_birth())));

		// 出生日期格式化
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy年MM月dd日");
		Date date = fmt.parse(data.getD_birth());
		data.setD_birth(fmt2.format(date));

		// 当前日期
		Date now = new Date();
		data.setNowdate(fmt2.format(now));
		data.setText_vip((data.getFg_vip() == null || !data.getFg_vip().booleanValue()) ? "否":"是" );
		return new HospitalNoticeDTO[] { data };
	}

	/**
	 * 查询SQL
	 * 
	 * @author zhengcm
	 * @date 2018-01-06 11:00:42
	 *
	 * @param id_aptip
	 * @return
	 * @throws Exception
	 */
	private StringBuilder getSql(String id_aptip) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("pat.id_pat as id_pat,");
		sb.append("pat.name as name_pat,");
		sb.append("pat.barcode_chis as code_chis,");
		sb.append("pat.dt_birth as d_birth,");
		sb.append("pat.mob as tel_pat,");
		//sb.append("(area.name || ent.addr_pat) as addr_pat,");
		sb.append("(area.fullname || addr.street) as addr_pat,");
		sb.append("patca.name as name_patca,");
		sb.append("pat.id_code no_idcard,");
		//sb.append("ent.code as code_ent,");
		sb.append("idtpdoc.name name_idtp,");
		sb.append("disdoc.name as name_crisis,");
		sb.append("sexdoc.name as name_sex,");
		sb.append("refdoc.name as name_route,");
		sb.append("case  aptip.fg_plan when 'Y' then '是' when 'N' then '否' else '其他' end as text_fg_plan,");
		sb.append("aptip.amt_deposit as deposit,");
		sb.append("aptip.note as note,");
		sb.append("phydep.name as name_dept_to,");
		sb.append("nurdep.name as name_ward_to,");
		sb.append("cont.name as name_other_cont,");
		sb.append("cont.conttel as tel_other_cont,");
		sb.append("aptip.name_didef_op as name_main_di,");
		//入院申请单增加字段，fanlq-add-2018.02.05
		sb.append(" aptip.fg_vip  ,");
		sb.append(" aptip.name_cont_phy  ,");
		sb.append(" aptip.tel_cont_phy  ,");
		sb.append(" aptip.supplement_di  ,");//fanlq-2018-04-28
		
		sb.append("aptip.name_emp_phy_op as name_doctor ");
		sb.append("from ");
		sb.append("sc_apt_ip aptip ");
		sb.append("inner join en_ent ent on ent.id_ent = aptip.id_ent ");
		sb.append("inner join pi_pat pat on pat.id_pat = ent.id_pat ");
		sb.append("left join en_ent_ip entip on entip.id_ent = ent.id_ent ");
		sb.append("left join pi_pat_ca patca on patca.id_patca = aptip.id_patca ");
		sb.append("left join pi_pat_addr addr on addr.id_pat = pat.id_pat ");//fanlq,报表地址取患者地址
		sb.append(" and addr.sd_addrtp = '9' ");
		sb.append("left join bd_adminarea area on area.id_adminarea =  addr.id_admdiv ");
		sb.append("left join bd_udidoc disdoc on disdoc.id_udidoc = aptip.id_level_dise ");
		sb.append("left join bd_udidoc idtpdoc on idtpdoc.id_udidoc = pat.id_idtp ");
		sb.append("left join bd_udidoc sexdoc on sexdoc.id_udidoc = pat.id_sex ");
		sb.append("left join bd_dep phydep on phydep.id_dep = aptip.id_dep_phy_ip ");
		sb.append("left join bd_dep nurdep on nurdep.id_dep = aptip.id_dep_nur_ip ");
		sb.append("left join bd_udidoc refdoc on refdoc.id_udidoc = aptip.id_referalsrc ");
		sb.append("left join en_ent_cont cont on cont.id_ent = ent.id_ent ");
		// sb.append("left join en_ent_di di on di.id_ent = ent.id_ent and di.fg_maj = 'Y' ");
		sb.append("where ");
		sb.append("aptip.fg_canc = 'N' ");
		sb.append("and aptip.id_aptip = '" + id_aptip + "' ");
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
	private List<HospitalNoticeDTO> getResultBySql(String sql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, sql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(HospitalNoticeDTO.class);
		List<HospitalNoticeDTO> result = (List<HospitalNoticeDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
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
