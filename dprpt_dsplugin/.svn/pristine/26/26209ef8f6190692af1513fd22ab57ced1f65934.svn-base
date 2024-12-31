package iih.sc.apt.mt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.handler.BeanListHandler;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 医技预约信息打印服务
 * 
 * @author zhengcm
 * @date 2016-12-09 16:06:03
 *
 */
public class MtAptInfoPrintService {

	/**
	 * 医技预约打印信息查询
	 *
	 * @param id_apt
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public List<MtAptInfoDTO> query(String id_apt) throws Exception {

		// 组装查询SQL
		StringBuilder sb = this.getSql(id_apt);

		// 执行查询
		List<MtAptInfoDTO> datas = this.getResultBySql(sb.toString());
		if (ListUtil.isEmpty(datas)) {
			return null;
		}

		MtAptInfoDTO aptDTO = datas.get(0);

		// 计算年龄
		aptDTO.setAge_pat(this.getAge(new FDate(aptDTO.getDt_birth())));

		// 检查日期
		aptDTO.setDt_check(this.getDateStr(aptDTO.getDt_check()));
		
		//检查项目
		aptDTO.setName_or(this.getCiOrderContent(aptDTO.getName_or()));
		
		// 设置到达时间
		FDateTime time = new FDateTime("1900-01-01" + " " + aptDTO.getT_b());
		aptDTO.setT_b(this.getTimeStr(time.getTime()));
		time = time.addSeconds(-Integer.parseInt(aptDTO.getSrvslot())*60);
		aptDTO.setTime_arrive(this.getTimeStr(time.getTime()));
		if(aptDTO.getSd_sctp().equals("03"))
		{
			//时间片
			aptDTO.setTickno(aptDTO.getT_b());
		}
		return datas;
	}

	/**
	 * 查询sql
	 *
	 * @param id_apt
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private StringBuilder getSql(String id_apt) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append(" select ");
		sb.append(" pat.name as name_pat,");
		sb.append(" doc.name as name_sex,");
		sb.append(" pat.dt_birth,");
		sb.append(" appl.applyno as appno,");
		sb.append(" tick.queno as tickno,");
		sb.append(" tick.t_b,");
		sb.append(" srv.name as name_srv,");
		sb.append(" apt.dt_b as dt_check,");
		sb.append(" dep.name as name_dep_mp,");
		sb.append(" sch.sugest_exmint as srvslot,");
		sb.append(" scpl.note as des_scpl ,");
		sb.append(" wrd.name as name_war,");
		sb.append(" appl.content_or as name_or,");
		sb.append(" bed.name_bed as bed,");
		sb.append(" scpl.sd_tickmd as sd_sctp,");
		sb.append(" scpl.des as des_pl");
		sb.append(" from ");
		sb.append(" sc_apt apt ");
		sb.append(" left join sc_apt_mt mt on mt.id_apt = apt.id_apt ");
		sb.append(" left join sc_apt_appl appl on appl.id_aptappl = mt.id_aptappl ");
		sb.append(" left join sc_sch sch on sch.id_sch = apt.id_sch ");
		sb.append(" left join sc_pl scpl on scpl.id_scpl = sch.id_scpl ");
		sb.append(" left join sc_tick tick on tick.id_tick = apt.id_tick ");
		sb.append(" left join pi_pat pat on pat.id_pat = apt.id_pat ");
		sb.append(" left join bd_udidoc doc on doc.id_udidoc = pat.id_sex ");
		sb.append(" left join bd_dep dep on dep.id_dep = mt.id_dep_mp");
		sb.append(" left join en_ent_bed bed on bed.id_ent = appl.id_ent");
		sb.append(" left join bd_dep wrd on wrd.id_dep = bed.id_dep_wrd");
		sb.append(" left join sc_srv srv on srv.id_scsrv = apt.id_scsrv");
		sb.append(" where ");
		sb.append(" apt.id_apt = '" + id_apt + "' ");
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
	private List<MtAptInfoDTO> getResultBySql(String sql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, sql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(MtAptInfoDTO.class);
		List<MtAptInfoDTO> result = (List<MtAptInfoDTO>) beanlist_handler.processRs(cached_rs);
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

	/**
	 * 日期格式化
	 *
	 * @param date
	 * @return
	 * @author zhengcm
	 */
	public String getDateStr(String date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日");
		Calendar newDate = Calendar.getInstance();
		try {
			Date oldDate = df.parse(date);
			newDate.setTime(oldDate);
			newDate.set(Calendar.DATE, newDate.get(Calendar.DATE));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return df2.format(newDate.getTime());
	}

	/**
	 * 时间格式化
	 *
	 * @param date
	 * @return
	 * @author zhengcm
	 */
	public String getTimeStr(String date) {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		Calendar newDate = Calendar.getInstance();
		try {
			Date oldDate = df.parse(date);
			newDate.setTime(oldDate);
			newDate.set(Calendar.DATE, newDate.get(Calendar.DATE));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return df.format(newDate.getTime());
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
