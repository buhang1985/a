package iih.sc.apt.export;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.handler.BeanListHandler;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 医技预约查询数据导出
 * 
 * @author yaohl
 * @date 2019/4/3
 *
 */
public class MtAptDetailExportService {

	/**
	 * 医技预约查询-导出
	 * @param id_grp
	 * @param id_org
	 * @param sd_sctp
	 * @param d_b_appt
	 * @param d_e_appt
	 * @param dt_b
	 * @param dt_e
	 * @param id_dept
	 * @param id_scres
	 * @param id_scsrv
	 * @param name_pat
	 * @param code_pat
	 * @param id_emp_appt
	 * @param sd_status
	 * @param code_apt
	 * @param id_scchl
	 * @param id_dept_appt
	 * @param id_srv
	 * @param note
	 * @param applyno
	 * @return
	 * @throws Exception
	 */
	public List<OpAptDetailDTO> query(String id_grp, String id_org, String sd_sctp, String d_b_appt, String d_e_appt,
			String dt_b, String dt_e, String id_dept, String id_scres, String id_scsrv, String name_pat,
			String code_pat, String id_emp_appt, String sd_status, String code_apt, String id_scchl,
			String id_dept_appt, String id_srv, String note,String applyno) throws Exception {
		StringBuilder sql = this.getSql(id_grp, id_org, sd_sctp, d_b_appt, d_e_appt, dt_b, dt_e, id_dept, id_scres,
				id_scsrv, name_pat, code_pat, id_emp_appt, sd_status, code_apt, id_scchl, id_dept_appt, id_srv, note,applyno);
		List<OpAptDetailDTO> datas = this.getResultBySql(sql.toString());
		this.processDatas(datas);
		return datas;
	}

	/**
	 * 查询SQL
	 * @param id_grp
	 * @param id_org
	 * @param sd_sctp
	 * @param d_b_appt
	 * @param d_e_appt
	 * @param dt_b
	 * @param dt_e
	 * @param id_dept
	 * @param id_scres
	 * @param id_scsrv
	 * @param name_pat
	 * @param code_pat
	 * @param id_emp_appt
	 * @param sd_status
	 * @param code_apt
	 * @param id_scchl
	 * @param id_dept_appt
	 * @param id_srv
	 * @param note
	 * @param applyno
	 * @return
	 * @throws Exception
	 */
	private StringBuilder getSql(String id_grp, String id_org, String sd_sctp, String d_b_appt, String d_e_appt,
			String dt_b, String dt_e, String id_dept, String id_scres, String id_scsrv, String name_pat,
			String code_pat, String id_emp_appt, String sd_status, String code_apt, String id_scchl,
			String id_dept_appt, String id_srv, String note,String applyno) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("select rownum as sortno,a.* from ( ");
		sb.append("SELECT ");
		sb.append("dep3.name as name_dept_appt,");// 申请科室
		sb.append("appl.code_entp,");
		sb.append("appl.dt_effe_or,");
		sb.append("PL.EU_EDIT_TP,");
		sb.append("pl.id_dep as id_dept,");//
		sb.append("APT.ID_APT,");
		sb.append("apt.code as code_apt,");
		sb.append("APT.ID_PAT,");
		sb.append("APT.Id_tick,");
		sb.append("pat.code as code_pat,");
		sb.append("PAT.NAME AS name_pat,");
		sb.append("PAT.MOB,");
		sb.append("PAT.DT_BIRTH,");
		sb.append("APT.DT_B,");
		sb.append("APT.DT_E,");
		sb.append("pat.id_sex,");
		sb.append("pat.sd_sex,");
		sb.append("docpat.name as name_sex,");// 性别
		sb.append("LOT.name as name_dateslot,");
		sb.append("RES.NAME AS name_scres,");
		sb.append("SRV.NAME AS NAME_SCSRV,");
		sb.append("APT.QUENO,");
		sb.append("APPTDOC.NAME AS NAME_EMP_APPT,");
		sb.append("APT.DT_APPT,");
		sb.append("APT.SD_STATUS,");
		sb.append("chl.name as name_scchl,");
		sb.append("DEP.NAME AS NAME_DEPT,");// 执行科室
		sb.append("war.name as name_dep_nuradm,");
		sb.append("ip.name_bed,");
		sb.append("appl.id_aptappl as id_apt_appl,");
		sb.append("entp.name as name_enttp, ");
		sb.append("exchl.code_apt as code_apt_exchl,");
		sb.append("docapt.name as name_status,");
		sb.append("(case apt.sd_status when '4' then case apt.dt_canc when null then cancdoc.name else case apt.id_emp_canc when null then '管理员' when '~' then '管理员' else cancdoc.name end end end)NAME_EMP_CANC,");
		sb.append(" appl.id_ent,");
		sb.append(" appl.id_or,");
		sb.append("APT.DT_CANC,");
		sb.append("APT.NOTE_CANC, ");
		sb.append("aptmt.note, ");
		sb.append("appl.content_or, ");
		sb.append("appl.id_srv, ");
		sb.append("bdsrv.name as name_srv,");
		sb.append("appl.fg_bl, ");
		sb.append("appl.id_emp_appl, ");
		sb.append("appl.applyno, ");// 2019.03.21 增加申请单号
		sb.append("psn.name as name_emp_appl, ");
		sb.append("aptmt.fg_manu_tak, ");
		sb.append("aptmt.id_emp_cfm, ");
		sb.append("psn1.name as name_emp_cfm, ");
		sb.append("aptmt.dt_apt_cfm, ");
		sb.append("aptmt.id_aptmt as id_apt_mt, ");
		sb.append("aptmt.url_photo ");
		sb.append("FROM SC_APT APT ");
		sb.append("INNER JOIN PI_PAT PAT ON PAT.ID_PAT = APT.ID_PAT ");
		sb.append("LEFT JOIN SC_SCH SCH ON SCH.ID_SCH = APT.ID_SCH ");
		sb.append("LEFT JOIN SC_PL PL ON PL.ID_SCPL = SCH.ID_SCPL ");
		sb.append("LEFT JOIN BD_DAYSLOT LOT ON LOT.ID_dayslot = APT.ID_dateslot ");
		sb.append("LEFT JOIN SC_RES RES ON RES.id_scres = PL.id_scres ");
		sb.append("LEFT JOIN SC_SRV SRV ON SRV.ID_SCSRV = PL.ID_SCSRV ");
		sb.append("LEFT JOIN BD_PSNDOC APPTDOC ON APPTDOC.ID_PSNDOC = APT.ID_EMP_APPT ");
		sb.append("LEFT JOIN BD_PSNDOC CANCDOC ON CANCDOC.ID_PSNDOC = APT.ID_EMP_CANC ");
		sb.append("left join sc_chl chl on chl.id_scchl = apt.id_scchl ");
		sb.append("left join sc_apt_exchl exchl on exchl.id_apt = apt.id_apt ");
		sb.append("inner join sc_apt_appl appl on appl.id_scapt = apt.id_apt ");
		sb.append("left join en_ent_ip ip  on ip.id_ent = appl.id_ent ");
		sb.append("left join bd_dep war on war.id_dep = ip.id_dep_nuradm ");
		sb.append("LEFT JOIN BD_DEP DEP ON DEP.ID_DEP = appl.id_dep_mp ");// 执行科室
		sb.append("LEFT JOIN sc_apt_mt aptmt ON aptmt.id_apt = APT.ID_APT ");
		sb.append("left join bd_dep dep3 on dep3.id_dep = appl.id_dep_appl ");// 申请科室
		sb.append("left join bd_srv bdsrv on appl.id_srv = bdsrv.id_srv ");
		sb.append("left join bd_psndoc psn on appl.id_emp_appl = psn.id_psndoc  ");
		sb.append("left join bd_psndoc psn1 on aptmt.id_emp_cfm = psn1.id_psndoc  ");
		sb.append("left join bd_entp entp on appl.id_entp = entp.id_entp ");
		sb.append("left join bd_udidoc docapt on apt.id_status = docapt.id_udidoc ");
		sb.append("left join bd_udidoc docpat on pat.id_sex = docpat.id_udidoc ");// 性别
		sb.append("where 1 = 1  and appl.sd_sys_from in ('0','1') ");
		if (!StringUtil.isEmptyWithTrim(sd_sctp)) {
			sb.append("and apt.sd_sctp = '" + sd_sctp + "' ");
		}
		// 患者姓名
		if (!StringUtil.isEmptyWithTrim(name_pat)) {
			sb.append("and pat.name = '" + name_pat + "' ");
		}
		// 申请单号
		if (!StringUtil.isEmptyWithTrim(applyno)) {
			sb.append("and appl.applyno = '" + applyno + "'");
		}
		if (!StringUtil.isEmptyWithTrim(dt_b)) {
			String dbStr = dt_b + " 00:00:00";
			sb.append("and apt.dt_b >= '" + dbStr + "' ");
		}
		if (!StringUtil.isEmptyWithTrim(dt_e)) {
			String deStr = dt_e + " 23:59:59";
			sb.append("and apt.dt_e <= '" + deStr + "' ");
		}
		// 诊疗项目
		if (!StringUtil.isEmptyWithTrim(id_srv)) {
			if (id_srv.split(",").length > 1) {
				String cond = buildIdStr(id_srv.split(","));
				sb.append("and appl.id_srv in (" + cond + ") ");
			} else {
				sb.append("and appl.id_srv = '" + id_srv + "'");
			}
		}
		// 预约资源
		if (!StringUtil.isEmptyWithTrim(id_scres)) {
			if (id_scres.split(",").length > 1) {
				String cond = buildIdStr(id_scres.split(","));
				sb.append("and apt.id_scres in (" + cond + ") ");
			} else {
				sb.append("and apt.id_scres = '" + id_scres + "' ");
			}
		}
		// 预约备注
		if (!StringUtil.isEmptyWithTrim(note)) {
			sb.append("and aptmt.note like '%" + note + "%'");
		}
		// 预约状态
		if (!StringUtil.isEmptyWithTrim(sd_status)) {
			sb.append("and apt.sd_status = '" + sd_status + "' ");
		}
		// 预约渠道
		if (!StringUtil.isEmptyWithTrim(id_scchl)) {
			sb.append("and apt.id_scchl = '" + id_scchl + "' ");
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
		// 预约号
		if (!StringUtil.isEmptyWithTrim(code_apt)) {
			sb.append("and (apt.code = '" + code_apt + "' or exchl.code_apt = '" + code_apt + "' ) ");
		}
		// 患者编码
		if (!StringUtil.isEmptyWithTrim(code_pat)) {
			sb.append("and pat.code = '" + code_pat + "' ");
		}
		// 开单科室
		if (!StringUtil.isEmptyWithTrim(id_dept_appt)) {
			sb.append("and apptdep.id_dep = '" + id_dept_appt + "' ");
		}
		// 操作人
		if (!StringUtil.isEmptyWithTrim(id_emp_appt)) {
			sb.append("and apt.id_emp_appt = '" + id_emp_appt + "' ");
		}
		// 排班服务
		if (!StringUtil.isEmptyWithTrim(id_scsrv)) {
			sb.append("and apt.id_scsrv = '" + id_scsrv + "' ");
		}
		// 预约科室
		if (!StringUtil.isEmptyWithTrim(id_dept)) {
			sb.append("and pl.id_dep = '" + id_dept + "' ");
		}
		// 集团管控
		if (!StringUtil.isEmptyWithTrim(id_grp)) {
			sb.append("and apt.id_grp = '" + id_grp + "' ");
		}
		if (!StringUtil.isEmptyWithTrim(id_org)) {
			sb.append("and apt.id_org = '" + id_org + "' ");
		}
		sb.append(" order by sch.d_sch,sch.id_sch) a  ");
		return sb;
	}

	/**
	 * 生成id的查询串
	 * 
	 * @param ids
	 *            id集合
	 * @return
	 */
	private String buildIdStr(String[] ids) {
		if (ArrayUtil.isEmpty(ids)) {
			return null;
		}

		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (String id : ids) {
			if (StringUtil.isEmpty(id)) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				builder.append(",");
			}
			builder.append(String.format("'%s'", id));
		}
		return builder.toString();
	}

	/**
	 * 查询数据
	 *
	 * @param sql
	 * @return
	 * @throws Exception
	 * @author yhl
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
	 * @author yhl
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
				dto.setD_b_appt(dto.getDt_appt());
			}
			if (!StringUtil.isEmptyWithTrim(dto.getDt_b())) {
				dto.setD_b(dto.getDt_b());
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
	 * @author yhl
	 * @param birth
	 *            生日
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

		int Months = curDate.getLocalMonth() - birth.getLocalMonth()
				+ 12 * (curDate.getLocalYear() - birth.getLocalYear());
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
