package iih.en.pv.opRegQryList;

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

/****
 * 门诊挂号查询
 * 
 * @author fanlq
 *
 */
public class OpRegListService {

	/****
	 * 门诊挂号查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<OpRegListDTO> exec(String id_grp, String id_org, String fg_check_insert, String dt_insert_b, String dt_insert_e, String fg_check_entry, String dt_entry_b, String dt_entry_e,
			String id_dep_phy, String id_scres, String id_dayslot, String id_scsrv, String sd_status, String invoice, String name_pat, String code_pat, String id_emp_operator, String ticket_status,
			String id_pat_ca, String id_hp) throws Exception {
		

		 FDate  dt_insert_begin = null;
		 FDate  dt_insert_end = null;
		 FDate dt_entry_begin = null;
		 FDate dt_entry_end = null;
		if (!StringUtil.isEmptyWithTrim(dt_insert_b)) {
			dt_insert_begin = new FDate(dt_insert_b);
		}
		if (!StringUtil.isEmptyWithTrim(dt_insert_e)) {
			 dt_insert_end = new FDate(dt_insert_e).getDateAfter(1);
		}
		if (!StringUtil.isEmptyWithTrim(dt_entry_b)) {
			dt_entry_begin  = new FDate(dt_entry_b);
		}
		if (!StringUtil.isEmptyWithTrim(dt_entry_e)) {
			dt_entry_end = new FDate(dt_entry_e).getDateAfter(1);
		}
		String entsql = this.initSql(id_grp, id_org, fg_check_insert, dt_insert_begin, dt_insert_end, fg_check_entry,  dt_entry_begin,  dt_entry_end,
				id_dep_phy, id_scres, id_dayslot, id_scsrv, sd_status, invoice, name_pat, code_pat, id_emp_operator, ticket_status,
				id_pat_ca, id_hp);
		String aptsql = this.initAptSql(id_grp, id_org, fg_check_insert, dt_insert_begin, dt_insert_end, fg_check_entry, dt_entry_begin, dt_entry_end,
				id_dep_phy, id_scres, id_dayslot, id_scsrv, sd_status, invoice, name_pat, code_pat, id_emp_operator, ticket_status,
				id_pat_ca, id_hp);
		String sql = "select * from ("+entsql+") union select * from ("+aptsql+") ";
		// 查询数据
		List<OpRegListDTO> datas = this.getResultBySql(sql);
		if (ListUtil.isEmpty(datas)) {
			return null;
		}
		for (OpRegListDTO regDTO : datas) {
			if (!StringUtil.isEmptyWithTrim(regDTO.getDt_birth_pat())) {
				regDTO.setAge_pat(this.getAge(new FDate(regDTO.getDt_birth_pat())));
			}
			if (!StringUtil.isEmptyWithTrim(regDTO.getFg_canc())) {
				if (regDTO.getFg_canc().equals("N")) {
					regDTO.setFg_canc("否");
				}
				if (regDTO.getFg_canc().equals("Y")) {
					regDTO.setFg_canc("是");
				}
			}
			if(!StringUtil.isEmptyWithTrim(regDTO.getSd_status()) && "1".equals(regDTO.getSd_status())){
				regDTO.setName_status("预约未缴费");
			}
		}
		return datas;

	}

	// 查询数据SQL
	@SuppressWarnings("unchecked")
	private List<OpRegListDTO> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(OpRegListDTO.class);
		List<OpRegListDTO> result = (List<OpRegListDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}

	/**
	 * 计算年龄（因为无法调用公共的方法，为了显示统一，直接拷贝了工具类AgeCalcUtil的方法）
	 * 
	 * @author zhengcm
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

		int Months = curDate.getLocalMonth() - birth.getLocalMonth() + 12 * (curDate.getLocalYear() - birth.getLocalYear());
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
			return String.format("%d月%d天", new Object[] { Integer.valueOf(fullMonth), Integer.valueOf(days) });
		}
		if (days <= 0) {
			return String.format("%d天", new Object[] { Integer.valueOf(1) });
		}
		return String.format("%d天", new Object[] { Integer.valueOf(days) });
	}
	
	/***
	 * 初始化sql
	 * @author fanlq 
	 * @param id_grp
	 * @param id_org
	 * @param fg_check_insert
	 * @param dt_insert_b
	 * @param dt_insert_e
	 * @param fg_check_entry
	 * @param dt_entry_b
	 * @param dt_entry_e
	 * @param id_dep_phy
	 * @param id_scres
	 * @param id_dayslot
	 * @param id_scsrv
	 * @param sd_status
	 * @param invoice
	 * @param name_pat
	 * @param code_pat
	 * @param id_emp_operator
	 * @param ticket_status
	 * @param id_pat_ca
	 * @param id_hp
	 * @throws Exception
	 */	  
	public String initSql(String id_grp, String id_org, String fg_check_insert, FDate  dt_insert_begin,  FDate  dt_insert_end, String fg_check_entry, FDate dt_entry_b, FDate dt_entry_e,
			String id_dep_phy, String id_scres, String id_dayslot, String id_scsrv, String sd_status, String invoice, String name_pat, String code_pat, String id_emp_operator, String ticket_status,
			String id_pat_ca, String id_hp) throws Exception {
		// 组装SQL
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN.ID_ENT AS ID_ENT,");
		sb.append("EN.ID_PAT AS ID_PAT,");
		sb.append("EN.NAME_PAT AS NAME_PAT,");
		sb.append("PAT.CODE AS CODE_PAT,");
		sb.append("EN.CODE AS CODE_ENT,");
		sb.append("EN.DT_BIRTH_PAT AS DT_BIRTH_PAT,");
		sb.append("CASE WHEN PAT.MOB IS NULL AND PAT.TEL IS NOT NULL THEN PAT.TEL ELSE PAT.MOB END AS Mob,");//手机号，fanlq-2018-04-28


		sb.append("DEP.NAME AS NAME_DEP_PHY,");
		sb.append("SCSRV.NAME  AS NAME_SCSRV,");
		sb.append("SCRES.NAME AS NAME_SCRES,");
		sb.append("PATCA.NAME AS NAME_PATCA,");
		sb.append("PRIPAT.NAME AS NAME_PRIPAT,");
		sb.append("OP.TICKETNO AS TICKETNO,");
		sb.append("OP.TIMES_OP AS TIMES_OP,");
		sb.append("DAYS.NAME AS NAME_DAYSLOT,");
		sb.append("OP.SD_STATUS AS SD_STATUS,");
		sb.append("ENTDOC.NAME AS NAME_STATUS,");
		sb.append("case when upper(OPER.NAME) like 'TOKEN%' and chl.name is not null then chl.name else OPER.NAME end as NAME_EMP_OPERATOR,");
		sb.append("case when upper(CANC.NAME) like 'TOKEN%' and chl.name is not null then chl.name else CANC.NAME end as NAME_EMP_CANC,");
		sb.append("EN.DT_CANC AS DT_CANC,");
		sb.append("OP.FG_NEEDRTN AS FG_NEEDRTN, ");
		sb.append("EN.FG_CANC AS FG_CANC,");
		sb.append("EN.DT_INSERT AS DT_INSERT,");
		sb.append("HP.NAME AS NAME_HP,");
		sb.append("SUBSTR(EN.DT_ENTRY, 0, 10) AS DT_ENTRY ");
		sb.append("FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sb.append("INNER JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");
		//加号
		if("ADD".equals(ticket_status)){
			sb.append("LEFT JOIN SC_TICK TK ON OP.ID_TICK = TK.ID_TICK  ");
		}
		sb.append("LEFT JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");
		sb.append("LEFT JOIN SC_SRV SCSRV ON OP.ID_SCSRV = SCSRV.ID_SCSRV ");
		sb.append("LEFT JOIN SC_RES SCRES ON OP.ID_SCRES = SCRES.ID_SCRES ");
		sb.append("LEFT JOIN PI_PAT_CA PATCA ON EN.ID_PATCA = PATCA.ID_PATCA ");
		sb.append("LEFT JOIN BD_PRI_PAT PRIPAT ON EN.ID_PRIPAT = PRIPAT.ID_PRIPAT ");  
		sb.append("LEFT JOIN BD_DAYSLOT DAYS ON OP.ID_DATESLOT = DAYS.ID_DAYSLOT ");
		sb.append("LEFT JOIN BD_PSNDOC OPER ON OP.ID_EMP_OPERATOR = OPER.ID_PSNDOC "); 
		sb.append("LEFT JOIN BD_PSNDOC CANC ON EN.ID_EMP_CANC = CANC.ID_PSNDOC ");
		
		sb.append("left join pi_pat_ca ca on en.id_patca = ca.id_patca ");
		sb.append("left join en_ent_hp enthp on en.id_ent = enthp.id_ent and enthp.fg_maj='Y' ");
		sb.append("left join bd_hp hp on enthp.id_hp = hp.id_hp ");
		sb.append("left join bd_udidoc entdoc on entdoc.id_udidoclist = '@@@@ZZ2000000000006C' and entdoc.code = op.sd_status ");
		sb.append("left join sc_apt apt on apt.id_apt = op.id_schapt ");
		sb.append("left join sc_chl chl on chl.id_scchl = apt.id_scchl ");
		
		sb.append("WHERE 1=1 ");
		// 集团管控
		if (!StringUtil.isEmptyWithTrim(id_grp)) {
			sb.append(" AND en.id_grp = '" + id_grp + "' ");
		}
		if (!StringUtil.isEmptyWithTrim(id_org)) {
			sb.append(" AND en.id_org = '" + id_org + "' ");
		}
		// 挂号日期
		if ("True".equals(fg_check_insert)) {
			if (dt_insert_begin!=null) {
				sb.append("AND EN.DT_INSERT >= '" + dt_insert_begin + "' ");
			}
			if (dt_insert_end !=null ) {
				sb.append("AND EN.DT_INSERT <= '" + dt_insert_end + "' ");
			}
		}
		// 就诊日期
		if ("True".equals(fg_check_entry)) {
			if (dt_entry_b!=null) {
				sb.append("AND EN.DT_ENTRY >= '" + dt_entry_b + "' ");
			}
			if (dt_entry_e!=null) {
				sb.append("AND EN.DT_ENTRY <= '" + dt_entry_e + "' ");
			}
		}
		// 科室
		if (!StringUtil.isEmptyWithTrim(id_dep_phy)) {
			sb.append("AND EN.ID_DEP_PHY = '" + id_dep_phy + "' ");
		}
		// 挂号资源
		if (!StringUtil.isEmptyWithTrim(id_scres)) {
			sb.append("AND OP.ID_SCRES = '" + id_scres + "' ");
		}
		// 午别
		if (!StringUtil.isEmptyWithTrim(id_dayslot)) {
			sb.append("AND OP.ID_DATESLOT = '" + id_dayslot + "' ");
		}
		// 号别
		if (!StringUtil.isEmptyWithTrim(id_scsrv)) {
			sb.append("AND OP.ID_SCSRV = '" + id_scsrv + "' ");
		}
		// 就诊状态
		if (!StringUtil.isEmptyWithTrim(sd_status) && !"ALL".equals(sd_status)) {
			sb.append("AND OP.SD_STATUS = '" + sd_status + "' ");
		}
		// 发票号
		if (!StringUtil.isEmptyWithTrim(invoice)) {
			sb.append("AND EN.ID_ENT IN (SELECT DISTINCT INC.ID_ENT FROM BL_INC_OEP INC WHERE INC.INCNO = '" + invoice + "' ) ");
		}
		// 患者姓名
		if (!StringUtil.isEmptyWithTrim(name_pat)) {
			sb.append("AND EN.NAME_PAT = '" + name_pat + "' ");
		}
		// 患者编码
		if (!StringUtil.isEmptyWithTrim(code_pat)) {
			sb.append("AND PAT.CODE = '" + code_pat + "' ");
		}
		// 挂号员
		if (!StringUtil.isEmptyWithTrim(id_emp_operator)) {
			sb.append("AND OP.ID_EMP_OPERATOR = '" + id_emp_operator + "' ");
		}
		// 患者分类
		if (!StringUtil.isEmptyWithTrim(id_pat_ca)) {
			sb.append("AND CA.ID_PATCA = '" + id_pat_ca + "' ");
		}
		// 医保名称
		if (!StringUtil.isEmptyWithTrim(id_hp)) {
			sb.append("AND HP.ID_HP = '" + id_hp + "' ");
		}
		// 号使用状态
		if (!StringUtil.isEmptyWithTrim(ticket_status) && !"ALL".equals(ticket_status)) {
			if ("CANC".equals(ticket_status)) {
				sb.append("AND EN.FG_CANC = 'Y' ");
			}
			if ( "ADD".equals(ticket_status)) {
				sb.append(" AND (TK.EU_ADD IN ('1','3') OR OP.EU_REGTP = '4') ");

			}
		}
		sb.append("ORDER BY EN.DT_ENTRY, DT_INSERT ");
		return sb.toString();
	}
	/**
	 * 初始化预约查询条-fanlq-2018.03.19
	 * 
	 * @param regQry
	 * @param sb
	 * @param param
	 */
	private String initAptSql(String id_grp, String id_org, String fg_check_insert, FDate  dt_insert_begin,  FDate  dt_insert_end, String fg_check_entry, FDate dt_entry_b, FDate dt_entry_e,
			String id_dep_phy, String id_scres, String id_dayslot, String id_scsrv, String sd_status, String invoice, String name_pat, String code_pat, String id_emp_operator, String ticket_status,
			String id_pat_ca, String id_hp){
		StringBuilder sb = new StringBuilder();
		sb.append("select '' AS ID_ENT,");
		sb.append("pat.id_pat AS ID_PAT,");
		sb.append("pat.name AS NAME_PAT,");
		sb.append("pat.code AS CODE_PAT,");
		sb.append("'' AS CODE_ENT,");
		sb.append("pat.dt_birth AS DT_BIRTH_PAT,");
		sb.append("dep.name AS NAME_DEP_PHY,");
		sb.append("SCSRV.Name AS NAME_SCSRV,");
		sb.append("SCRES.Name AS NAME_SCRES,");
		sb.append("PATCA.NAME AS NAME_PATCA,");
		sb.append("PRIPAT.NAME AS NAME_PRIPAT,");
		sb.append("apt.queno AS TICKETNO,");
		sb.append("NULL AS TIMES_OP,");
		sb.append("DAYS.NAME AS NAME_DAYSLOT,");
		sb.append("apt.sd_status SD_STATUS,");
		sb.append("'' AS NAME_STATUS,");
		sb.append("doc.name AS NAME_EMP_OPERATOR,");
		sb.append("doc1.name AS NAME_EMP_CANC,");
		sb.append("apt.dt_canc AS DT_CANC,");
		sb.append("'' AS FG_NEEDRTN,");
		sb.append("apt.fg_canc AS FG_CANC,");
		sb.append("apt.dt_appt AS DT_INSERT,");
		sb.append("'' AS NAME_HP,");
		sb.append("sch.d_sch AS DT_ENTRY ");
		sb.append(" from sc_apt apt ");
		sb.append("inner join sc_apt_op opapt on opapt.id_apt = apt.id_apt ");
		sb.append("LEFT join pi_pat pat on pat.id_pat = apt.id_pat ");
		sb.append("LEFT JOIN SC_SRV SCSRV ON apt.ID_SCSRV = SCSRV.ID_SCSRV ");
		sb.append("LEFT JOIN SC_RES SCRES ON apt.ID_SCRES = SCRES.ID_SCRES ");
		sb.append("LEFT JOIN PI_PAT_CA PATCA ON pat.id_paticate = PATCA.ID_PATCA ");
		sb.append("LEFT JOIN BD_PRI_PAT PRIPAT ON pat.id_patpritp = PRIPAT.ID_PRIPAT ");
		sb.append("LEFT JOIN BD_DAYSLOT DAYS ON apt.ID_DATESLOT = DAYS.ID_DAYSLOT ");
		sb.append("left join bd_dep dep on dep.id_dep = opapt.id_dep ");
		sb.append("left join sc_sch sch on sch.id_sch = apt.id_sch ");
		sb.append("left join bd_psndoc doc on doc.id_psndoc = apt.id_emp_appt ");
		sb.append(" left join bd_psndoc doc1 on doc1.id_psndoc = apt.id_emp_canc ");
		sb.append("WHERE 1=1 ");
		// 集团管控
		if (!StringUtil.isEmptyWithTrim(id_grp)) {
			sb.append(" AND apt.id_grp = '" + id_grp + "' ");
		}
		if (!StringUtil.isEmptyWithTrim(id_org)) {
			sb.append(" AND apt.id_org = '" + id_org + "' ");
		}
		// 预约日期
		if ("True".equals(fg_check_insert)) {
			if (dt_insert_begin !=null) {
				sb.append("AND apt.dt_appt  >= '" + dt_insert_begin + "' ");
			}
			if (dt_insert_end !=null) {
				sb.append("AND apt.dt_appt <= '" + dt_insert_end + "' ");
			}
		}
		// 就诊日期
		if ("True".equals(fg_check_entry)) {
			if (dt_entry_b!=null) {
				sb.append("AND sch.d_sch >= '" + dt_entry_b + "' ");
			}
			if (dt_entry_e!=null) {
				sb.append("AND sch.d_sch <= '" + dt_entry_e + "' ");
			}
		}
		// 科室
		if (!StringUtil.isEmptyWithTrim(id_dep_phy)) {
			sb.append("AND opapt.id_dep = '" + id_dep_phy + "' ");
		}
		// 挂号资源
		if (!StringUtil.isEmptyWithTrim(id_scres)) {
			sb.append("AND apt.ID_SCRES = '" + id_scres + "' ");
		}
		// 午别
		if (!StringUtil.isEmptyWithTrim(id_dayslot)) {
			sb.append("AND apt.ID_DATESLOT = '" + id_dayslot + "' ");
		}
		// 号别
		if (!StringUtil.isEmptyWithTrim(id_scsrv)) {
			sb.append("AND apt.ID_SCSRV = '" + id_scsrv + "' ");
		}
		// 就诊状态
		if (!StringUtil.isEmptyWithTrim(sd_status) && !"ALL".equals(sd_status) && "01".equals(sd_status)) {
			sb.append("AND APT.SD_STATUS = '1' ");
		}else if(!StringUtil.isEmptyWithTrim(sd_status)){
			sb.append("AND APT.SD_STATUS = '" + sd_status + "' ");
		}
		// 患者姓名
		if (!StringUtil.isEmptyWithTrim(name_pat)) {
			sb.append("AND PAT.Name = '" + name_pat + "' ");
		}
		// 患者编码
		if (!StringUtil.isEmptyWithTrim(code_pat)) {
			sb.append("AND PAT.CODE = '" + code_pat + "' ");
		}
		// 挂号员
		if (!StringUtil.isEmptyWithTrim(id_emp_operator)) {
			sb.append("AND APT.ID_EMP_APPT = '" + id_emp_operator + "' ");
		}
		// 患者分类
		if (!StringUtil.isEmptyWithTrim(id_pat_ca)) {
			sb.append("AND pat.id_paticate = '" + id_pat_ca + "' ");
		}
		// 号使用状态
		if (!StringUtil.isEmptyWithTrim(ticket_status) && !"ALL".equals(ticket_status)) {
			if ("CANC".equals(ticket_status) || "ADD".equals(ticket_status)) {
				sb.append("AND apt.FG_CANC = 'Y' ");
			}
		}
		sb.append("AND apt.FG_CANC = 'N' ");
		//支付状态
		sb.append("AND apt.fg_payment = 'N' ");
		return sb.toString();
	}
}
