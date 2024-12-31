package iih.sc.sch.op;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.handler.BeanListHandler;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 排班停诊预约信息打印服务
 * 
 * @author zhengcm
 * @date 2017-11-21 17:07:39
 *
 */
public class SchCancPrintService {

	/**
	 * 查询数据
	 * 
	 * @author zhengcm
	 * @date 2017-11-21 17:09:02
	 *
	 * @param id_sch
	 * @param isShowCancel
	 * @return
	 * @throws Exception
	 */
	public List<SchCancDTO> query(String id_grp, String id_org, String id_sch, String isShowCancel) throws Exception {
		// 查询排班预约数据
		List<SchCancDTO> datas = this.queryAptDatas(id_grp, id_org, id_sch, isShowCancel);
		// 查询排班挂号数据
		List<SchCancDTO> regDatas = this.queryRegDatas(id_org, id_sch);
		// 合并数据
		datas.addAll(regDatas);
		// 计算患者年龄
		this.calcPatAge(datas);
		return datas;
	}

	private List<SchCancDTO> queryAptDatas(String id_grp, String id_org, String id_sch, String isShowCancel)
			throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("tick.queno,");
		sb.append("pat.barcode_chis as code_chis,");
		sb.append("pat.name as name_pat,");
		sb.append("pat.dt_birth as d_birth,");
		sb.append("pat.mob as mob_pat,");
		sb.append("emp_reg.name as name_emp_reg,");
		sb.append("status.name as name_status,");
		sb.append("emp_canc.name as name_emp_canc,");
		sb.append("chl.name as name_scchl,");
		sb.append("apt2.dt_b as dt_apt_cancto,");
		sb.append("pl2.name as name_scpl_cancto,");
		sb.append("apt2.queno as queno_cancto ");
		sb.append("from ");
		sb.append("sc_apt apt ");
		sb.append("inner join sc_tick tick on tick.id_tick = apt.id_tick ");
		sb.append("inner join sc_chl chl on chl.id_scchl = apt.id_scchl ");
		sb.append("inner join pi_pat pat on pat.id_pat = apt.id_pat ");
		sb.append("inner join bd_psndoc emp_reg on emp_reg.id_psndoc = apt.id_emp_appt ");
		sb.append("inner join sc_chl chl on chl.id_scchl = apt.id_scchl ");
		sb.append("left join bd_udidoc status on status.id_udidoc = apt.id_status ");
		sb.append("left join bd_psndoc emp_canc on emp_canc.id_psndoc = apt.id_emp_canc ");
		sb.append("left join sc_apt apt2 on apt2.id_apt = apt.id_scapt_cancto ");
		sb.append("left join sc_tick tick2 on tick2.id_tick = apt2.id_tick ");
		sb.append("left join sc_sch sch2 on sch2.id_sch = apt2.id_sch ");
		sb.append("left join sc_pl pl2 on pl2.id_scpl = sch2.id_scpl ");
		sb.append("left join sc_apt_op op on op.id_apt = apt.id_apt ");
		sb.append("where 1 = 1 ");
		sb.append("and apt.id_grp = '" + id_grp + "' ");
		sb.append("and apt.id_org = '" + id_org + "' ");
		sb.append("and apt.id_sch = '" + id_sch + "' ");
		if (isShowCancel.toUpperCase().equals("FALSE") || isShowCancel.toUpperCase().equals("N")) {
			sb.append("and apt.fg_canc = 'N' ");
		}
		sb.append("order by apt.queno,apt2.queno ");
		// 执行查询
		List<SchCancDTO> datas = this.getResultBySql(sb.toString());
		return datas;
	}

	/**
	 * 查询排班挂号数据
	 * 
	 * @author zhengcm
	 * @date 2017-12-01 15:04:44
	 *
	 * @param id_sch
	 * @return
	 * @throws BizException
	 */
	private List<SchCancDTO> queryRegDatas(String id_org, String id_sch) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("op.id_sch,");
		sb.append("op.id_tick,");
		sb.append("op.ticketno as queno,");
		sb.append("pat.barcode_chis as code_chis,");
		sb.append("pat.name as name_pat,");
		sb.append("pat.dt_birth as d_birth,");
		sb.append("pat.mob as mob_pat,");
		sb.append("emp.name as name_emp_reg,");
		sb.append("'挂号' as name_status,");
		sb.append("op.eu_regtp as sd_status ");
		sb.append("from ");
		sb.append("en_ent_op op ");
		sb.append("inner join en_ent ent on op.id_ent = ent.id_ent ");
		sb.append("inner join pi_pat pat on pat.id_pat = ent.id_pat ");
		sb.append("inner join bd_psndoc emp on emp.id_psndoc = op.id_emp_reg ");
		sb.append("where 1 = 1 ");
		sb.append("and nvl(ent.fg_canc, 'N') = 'N' ");
		sb.append("and (op.id_schapt is null or op.id_schapt = '~') ");
		sb.append("and ent.id_org = '" + id_org + "' ");
		sb.append("and op.id_sch = '" + id_sch + "' ");
		sb.append("order by op.ticketno ");
		// 执行查询
		List<SchCancDTO> datas = this.getResultBySql(sb.toString());
		// 设置挂号渠道名称
		this.setRegtpName(datas);
		return datas;
	}

	/**
	 * 执行报表数据SQL查询
	 * 
	 * @author zhengcm
	 * @param strSql SQL语句
	 * @return 床位卡打印报表数据DTO列表
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private List<SchCancDTO> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(SchCancDTO.class);
		List<SchCancDTO> result = (List<SchCancDTO>) beanlist_handler.processRs(cached_rs);
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
	private void calcPatAge(List<SchCancDTO> datas) throws Exception {
		if (ListUtil.isEmpty(datas)) {
			return;
		}
		for (SchCancDTO dto : datas) {
			if (StringUtil.isEmptyWithTrim(dto.getD_birth())) {
				continue;
			}
			dto.setAge(this.getAge(new FDate(dto.getD_birth())));
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

	/**
	 * 设置挂号渠道名称
	 * 
	 * @author zhengcm
	 * @date 2017-12-01 14:56:16
	 *
	 * @param datas
	 * @throws BizException
	 */
	private void setRegtpName(List<SchCancDTO> datas) throws BizException {
		if (ListUtil.isEmpty(datas)) {
			return;
		}
		for (SchCancDTO data : datas) {
			data.setName_scchl(this.getRegTpName(data.getSd_status()));
			data.setSd_status(null);
		}
	}

	/**
	 * 获取挂号渠道名称
	 * 
	 * @author zhengcm
	 * @date 2017-12-01 14:54:44
	 *
	 * @param eu_regtp
	 * @return
	 * @throws BizException
	 */
	private String getRegTpName(String eu_regtp) throws BizException {
		if (StringUtil.isEmptyWithTrim(eu_regtp)) {
			return null;
		}
		String regtpName = null;
		switch (eu_regtp) {
		case "0":
			regtpName = "普通挂号";
			break;
		case "1":
			regtpName = "分诊台挂号";
			break;
		case "2":
			regtpName = "先诊疗后付费方式挂号";
			break;
		case "3":
			regtpName = "医生诊间挂号";
			break;
		case "9":
			regtpName = "预约";
			break;
		}
		return regtpName;
	}
}
