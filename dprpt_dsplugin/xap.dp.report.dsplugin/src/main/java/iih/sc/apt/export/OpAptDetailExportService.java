package iih.sc.apt.export;

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

/**
 * 门诊预约查询数据导出
 * 
 * @author zhengcm
 * @modifier zhengcm 2017-09-08 按照需求文档重新调整界面和数据
 * @date 2017-08-30 09:18:23
 *
 */
public class OpAptDetailExportService {

	/**
	 * 查询
	 *
	 * @author zhengcm
	 * 
	 * @param id_grp 集团ID
	 * @param id_org 组织ID
	 * @param sd_sctp 排班类型编码
	 * @param d_b_appt 操作开始日期
	 * @param d_e_appt 操作结束日期
	 * @param dt_b 就诊开始日期
	 * @param dt_e 就诊结束日期
	 * @param id_dept 科室ID
	 * @param id_scres 排班资源ID
	 * @param id_scsrv 排班服务ID
	 * @param id_dayslot 午别ID
	 * @param name_pat 患者名称
	 * @param code_pat 患者编码
	 * @param id_emp_appt 登记人ID
	 * @param sd_status 预约状态编码
	 * @param code_apt 预约号
	 * @param id_scchl 排班渠道ID
	 * @param id_dep_appt 申请科室ID
	 * @param name_dep_appt 申请科室名称
	 * @param fg_op 是否门诊
	 * @param fg_ip 是否住院
	 * @param fg_jz 是否急诊
	 * @return
	 * @throws Exception
	 */
	public List<OpAptDetailDTO> query(String id_grp, String id_org, String sd_sctp, String d_b_appt, String d_e_appt,
			String dt_b, String dt_e, String id_dept, String id_scres, String id_scsrv, String id_dayslot,
			String name_pat, String code_pat, String id_emp_appt, String sd_status, String code_apt, String id_scchl,
			String id_dept_appt, String fg_op, String fg_ip, String fg_jz) throws Exception {
		StringBuilder sql = this.getSql(id_grp, id_org, sd_sctp, d_b_appt, d_e_appt, dt_b, dt_e, id_dept, id_scres,
				id_scsrv, id_dayslot, name_pat, code_pat, id_emp_appt, sd_status, code_apt, id_scchl, id_dept_appt,
				fg_op, fg_ip, fg_jz);
		List<OpAptDetailDTO> datas = this.getResultBySql(sql.toString());
		this.processDatas(datas);
		return datas;
	}

	/**
	 * 查询SQL
	 *
	 * @author zhengcm
	 * 
	 * @param id_grp 集团ID
	 * @param id_org 组织ID
	 * @param sd_sctp 排班类型编码
	 * @param d_b_appt 操作开始日期
	 * @param d_e_appt 操作结束日期
	 * @param dt_b 就诊开始日期
	 * @param dt_e 就诊结束日期
	 * @param id_dept 科室ID
	 * @param id_scres 排班资源ID
	 * @param id_scsrv 排班服务ID
	 * @param id_dayslot 午别ID
	 * @param name_pat 患者名称
	 * @param code_pat 患者编码
	 * @param id_emp_appt 登记人ID
	 * @param sd_status 预约状态编码
	 * @param code_apt 预约号
	 * @param id_scchl 排班渠道ID
	 * @param id_dept_appt 申请科室ID
	 * @param fg_op 是否门诊
	 * @param fg_ip 是否住院
	 * @param fg_jz 是否急诊
	 * @return
	 * @throws Exception
	 */
	private StringBuilder getSql(String id_grp, String id_org, String sd_sctp, String d_b_appt, String d_e_appt,
			String dt_b, String dt_e, String id_dept, String id_scres, String id_scsrv, String id_dayslot,
			String name_pat, String code_pat, String id_emp_appt, String sd_status, String code_apt, String id_scchl,
			String id_dept_appt, String fg_op, String fg_ip, String fg_jz) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("apt.code as code_apt,");
		sb.append("pat.name as name_pat,");
		sb.append("pat.code as code_pat,");
		sb.append("pat.dt_birth,");
		sb.append("pat.mob,");
		sb.append("apt.dt_b,");
		sb.append("apt.dt_e,");
		if (!StringUtil.isEmptyWithTrim(sd_sctp) && sd_sctp.equals("04")) {
			sb.append("apptdep.name as name_dept_appt,");
		}
		sb.append("dep.name as name_dept,");
		sb.append("lot.name as name_dateslot,");
		sb.append("res.name as name_scres,");
		sb.append("srv.name as name_scsrv,");
		sb.append("apt.queno,");
		sb.append("apptdoc.name as name_emp_appt ,");
		sb.append("apt.dt_appt,");
		sb.append("apt.sd_status,");
		sb.append("chl.name as name_scchl,");
		sb.append("exchl.code_apt as code_apt_exchl,");
		sb.append("decode(apt.sd_status,'1','预约','2','支付','3','完成','4','取消') as name_status,");
		sb.append("(case apt.sd_status when '4' then case apt.dt_canc when null then cancdoc.name else case apt.id_emp_canc when null then '管理员' when '~' then '管理员' else cancdoc.name end end end)name_emp_canc,");
		sb.append("apt.dt_canc ");
		sb.append("from sc_apt apt ");
		sb.append("inner join pi_pat pat on pat.id_pat = apt.id_pat ");
		sb.append("left join sc_sch sch on sch.id_sch = apt.id_sch ");
		sb.append("left join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		sb.append("left join bd_dep dep on dep.id_dep = pl.id_dep ");
		sb.append("left join bd_dayslot lot on lot.id_dayslot = apt.id_dateslot ");
		sb.append("left join sc_res res on res.id_scres = pl.id_scres ");
		sb.append("left join sc_srv srv on srv.id_scsrv = pl.id_scsrv ");
		sb.append("left join bd_psndoc apptdoc on apptdoc.id_psndoc = apt.id_emp_appt ");
		sb.append("left join bd_psndoc cancdoc on cancdoc.id_psndoc = apt.id_emp_canc ");
		sb.append("left join sc_chl chl on chl.id_scchl = apt.id_scchl ");
		sb.append("left join sc_apt_exchl exchl on exchl.id_apt = apt.id_apt ");
		if("04".equals(sd_sctp)){
			sb.append("inner join sc_apt_appl appl on appl.id_scapt = apt.id_apt ");
			sb.append("left join bd_dep apptdep on apptdep.id_dep = appl.id_dep_appl ");
		}
		sb.append("where 1 = 1 ");
		if (!StringUtil.isEmptyWithTrim(sd_sctp)) {
			sb.append("and apt.sd_sctp = '" + sd_sctp + "' ");
		}
		if (!StringUtil.isEmptyWithTrim(name_pat)) {
			sb.append("and pat.name = '" + name_pat + "' ");
		}
		if (!StringUtil.isEmptyWithTrim(id_scres)) {
			sb.append("and apt.id_scres = '" + id_scres + "' ");
		}
		if (!StringUtil.isEmptyWithTrim(id_scsrv)) {
			sb.append("and apt.id_scsrv = '" + id_scsrv + "' ");
		}
		if (!StringUtil.isEmptyWithTrim(dt_b)) {
			String dbStr = dt_b + " 00:00:00";
			sb.append("and apt.dt_b >= '" + dbStr + "' ");
		}
		if (!StringUtil.isEmptyWithTrim(dt_e)) {
			String deStr = dt_e + " 23:59:59";
			sb.append("and apt.dt_b <= '" + deStr + "' ");
		}
		if (!StringUtil.isEmptyWithTrim(sd_status)) {
			sb.append("and apt.sd_status = '" + sd_status + "' ");
		}

		// 操作开始日期
		if (!StringUtil.isEmptyWithTrim(d_b_appt)) {
			String dbStr = d_b_appt + " 00:00:00";
			sb.append("and apt.dt_appt >= '" + dbStr + "' ");
		}
		// 操作结束日期
		if (!StringUtil.isEmptyWithTrim(d_e_appt)) {
			String deStr = d_e_appt + " 23:59:59";
			sb.append("and apt.dt_appt <= '" + deStr + "' ");
		}
		// 科室
		if (!StringUtil.isEmptyWithTrim(id_dept)) {
			sb.append("and pl.id_dep = '" + id_dept + "' ");
		}
		// 午别
		if (!StringUtil.isEmptyWithTrim(id_dayslot)) {
			sb.append("and apt.id_dateslot = '" + id_dayslot + "' ");
		}
		// 患者编码
		if (!StringUtil.isEmptyWithTrim(code_pat)) {
			sb.append("and pat.code = '" + code_pat + "' ");
		}
		// 登记人
		if (!StringUtil.isEmptyWithTrim(id_emp_appt)) {
			sb.append("and apt.id_emp_appt = '" + id_emp_appt + "' ");
		}
		// 预约号
		if (!StringUtil.isEmptyWithTrim(code_apt)) {
			sb.append("and (apt.code = '" + code_apt + "' or exchl.code_apt = '" + code_apt + "' ) ");
		}
		// 预约渠道
		if (!StringUtil.isEmptyWithTrim(id_scchl)) {
			sb.append("and apt.id_scchl = '" + id_scchl + "' ");
		}

		// 手术预约查询条件
		if("04".equals(sd_sctp)){
			// 申请科室
			if (!StringUtil.isEmptyWithTrim(id_dept_appt)) {
				sb.append("and apptdep.id_dep = '" + id_dept_appt + "' ");
			}
			// 就诊类型
			if (null != this.getEnttpCond(fg_op, fg_ip, fg_jz)) {
				sb.append("and " + this.getEnttpCond(fg_op, fg_ip, fg_jz));
			}
		}

		// 集团管控
		if (!StringUtil.isEmptyWithTrim(id_grp)) {
			sb.append("and apt.id_grp = '" + id_grp + "' ");
		}
		if (!StringUtil.isEmptyWithTrim(id_org)) {
			sb.append("and apt.id_org = '" + id_org + "' ");
		}
		if("04".equals(sd_sctp)){
			sb.append("order by apt.dt_b,sch.d_sch,sch.id_sch ");
		} else {
		sb.append("order by apt.dt_b desc ");
		}
		return sb;
	}

	/**
	 * 就诊类型查询条件
	 * 
	 * @author zhengcm
	 *
	 * @param fg_op
	 * @param fg_ip
	 * @param fg_jz
	 * @return
	 * @throws Exception
	 */
	private String getEnttpCond(String fg_op, String fg_ip, String fg_jz) throws Exception {
		String cond = "";
		if (!StringUtil.isEmptyWithTrim(fg_op) && fg_op.equals("Y")) {
			cond = "'00'";
		}
		if (!StringUtil.isEmptyWithTrim(fg_ip) && fg_ip.equals("Y")) {
			cond = cond + ",'10'";
		}
		if (!StringUtil.isEmptyWithTrim(fg_jz) && fg_jz.equals("Y")) {
			cond = cond + ",'01'";
		}
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		return "appl.code_entp in (" + cond + ") ";
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
	private List<OpAptDetailDTO> getResultBySql(String sql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, sql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(OpAptDetailDTO.class);
		List<OpAptDetailDTO> result = (List<OpAptDetailDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}

	/**
	 * 处理数据
	 *
	 * @author zhengcm
	 * 
	 * @param datas
	 * @throws Exception
	 */
	private void processDatas(List<OpAptDetailDTO> datas) throws Exception {
		if (ListUtil.isEmpty(datas)) {
			return;
		}
		for (OpAptDetailDTO dto : datas) {
			if (!StringUtil.isEmptyWithTrim(dto.getDt_birth())) {
				dto.setAge_pat(this.getAge(new FDate(dto.getDt_birth())));
			}
			if (!StringUtil.isEmptyWithTrim(dto.getDt_appt())) {
				dto.setD_b_appt(dto.getDt_appt().substring(0, 10));
			}
			if (!StringUtil.isEmptyWithTrim(dto.getDt_b())) {
				dto.setD_b(dto.getDt_b().substring(0, 10));
			}
			// 登记人为token时显示对应的渠道名称 changed by zhengcm 2018-03-13
			if (!StringUtil.isEmptyWithTrim(dto.getName_emp_appt())
					&& dto.getName_emp_appt().toUpperCase().startsWith("TOKEN")) {
				dto.setName_emp_appt(dto.getName_scchl());
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
