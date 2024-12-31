package iih.en.pv.bedcardprint;

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
 * 床头卡\杯卡打印模板DTO查询服务
 * 
 * @author zhengcm
 * @date 2016-07-14 16:22:45
 *
 */

public class BedCardPrintService {

	/**
	 * 床位卡打印报表查询服务
	 * 
	 * @author zhengcm
	 * @param entIds 就诊ID数组
	 * @return
	 * @throws Exception
	 */
	public BedCardPrintDTO[] query(String[] entIds, String fmt) throws Exception {
		if (ArrayUtil.isEmptyNoNull(entIds)) {
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct ");
		sql.append("org.name as name_org,");
		sql.append("nuradm.tel as dep_tel,");
		sql.append("ent.id_ent as id_ent,");
		sql.append("ent.id_pat as id_pat,");
		sql.append("pat.code as code_pat,");
//		sql.append("concat(concat(concat(concat(concat('WB',pat.code),'|'),ip.times_ip),'|'),ip.times_print) as fmt,");
		sql.append("ip.times_ip,");
		sql.append("ip.times_print,");
		sql.append("ent.code as code_ent,");
		sql.append("ent.name_pat as name_pat,");
		sql.append("case ent.sd_sex_pat when '0' then '未知' when '1' then '男性' when '2' then '女性' when '9' then '未说明' else '' end as name_sex,");
		sql.append("ent.dt_birth_pat as dt_birth_pat,");
		sql.append("ent.addr_pat as addr_pat,");
		sql.append("ip.code_amr_ip as code_amr_ip,");
		sql.append("ent.id_dep_phy as id_dep_phyadm,");
		sql.append("phyadm.name as name_dep_phyadm,");
		sql.append("ent.id_dep_nur as id_dep_nuradm,");
		sql.append("nuradm.name as name_dep_nuradm,");
		sql.append("ent.dt_acpt as dt_ip,");// 入院时间:取dt_acpt
		sql.append("ip.id_bed as id_bed,");
		sql.append("ip.name_bed as name_bed,");
		sql.append("def.name as name_didef_dis_ip,");// 就诊诊断名称
		sql.append("ip.id_level_nur as id_level_nur,");
		sql.append("nurl.name as name_level_nur,");
		sql.append("di.id_didef_dis as id_didef_dis,");
		sql.append("di.name_didef_dis as name_didef_dis,");
		sql.append("substr(ent.dt_entry,0,10) as dt_acpt,");// 就诊时间：取dt_entry
		sql.append("adm.name as name_admdiv_addr, ");
		sql.append("psn_phy.name as name_emp_phy,");// 主管医生 责任护士 modified by lilei 20180828
		sql.append("psn_nur.name as name_emp_nur ");
		sql.append("from ");
		sql.append("en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent ");
		sql.append("inner join pi_pat pat on pat.id_pat = ent.id_pat ");
		sql.append("inner join bd_org org on org.id_org = ent.id_org ");
		sql.append("left join bd_di_def def on def.id_didef = ip.id_diag_op ");
		sql.append("left join en_ent_di di on di.id_ent = ent.id_ent and di.fg_maj = 'Y' ");
		sql.append("left join bd_udidoc nurl on nurl.id_udidoc = ip.id_level_nur ");
		sql.append("left join bd_dep phyadm on phyadm.id_dep = ent.id_dep_phy ");
		sql.append("left join bd_dep nuradm on nuradm.id_dep = ent.id_dep_nur ");
		sql.append("left join bd_areacate adm on adm.id_areacate = ent.id_admdiv_addr ");
		sql.append("left join en_ent_emp emp_phy on ent.id_ent = emp_phy.id_ent and emp_phy.sd_emprole = '10' "); //modified by lilei 20180828
		sql.append("and (emp_phy.dt_e is null or emp_phy.dt_e >= ent.dt_end ) ");//	0132788 - fanlq-2018-09-05 add
		sql.append("left join en_ent_emp emp_nur on ent.id_ent = emp_nur.id_ent and emp_nur.sd_emprole = '20' ");
		sql.append("and (emp_nur.dt_e is null or emp_nur.dt_e >= ent.dt_end ) ");//	0132788 - fanlq-2018-09-05 add
		sql.append("left join bd_psndoc psn_phy on  psn_phy.id_psndoc = emp_phy.id_emp ");
		sql.append("left join bd_psndoc psn_nur on  psn_nur.id_psndoc = emp_nur.id_emp ");
		sql.append("where " + this.getInSql("ent.id_ent", entIds));
		sql.append(" order by name_bed");

		// 执行查询
		List<BedCardPrintDTO> datas = this.getResultBySql(sql.toString());

		// 检查诊断数据
		this.checkDiDefData(datas);

		// 计算患者年龄
		this.calcPatAge(datas);
		
		//打印格式
		if (null != fmt) {
			//患者编码
			if (fmt.contains("[patCode]"))
				fmt = fmt.replace("[patCode]", datas.get(0).getCode_pat());
			//住院次数
			if (fmt.contains("[ipTimes]"))
				fmt = fmt.replace("[ipTimes]", datas.get(0).getTimes_ip());
			//打印次数
			if (fmt.contains("[prtTimes]"))
				fmt = fmt.replace("[prtTimes]", datas.get(0).getTimes_print());
			//住院号
			if (fmt.contains("[codeAmrIp]"))
				fmt = fmt.replace("[codeAmrIp]", datas.get(0).getCode_amr_ip());
			datas.get(0).setFmt(fmt);
		}

		if (ListUtil.isEmpty(datas)) {
			return null;
		}
		return datas.toArray(new BedCardPrintDTO[] {});
	}

	/**
	 * 转换IN语句
	 * 
	 * @author zhengcm
	 * @param fieldName 字段名称
	 * @param vals 字段值数组
	 * @return IN查询条件
	 * @throws Exception
	 */
	private String getInSql(String fieldName, String[] vals) throws Exception {
		if (StringUtil.isEmptyWithTrim(fieldName) || ArrayUtil.isEmpty(vals)) {
			return null;
		}
		StringBuilder inSql = new StringBuilder();
		inSql.append(fieldName + " in (");
		for (int i = 0; i < vals.length; i++) {
			inSql.append("'" + vals[i] + "'");
			if (i != vals.length - 1) {
				inSql.append(",");
			}
		}
		inSql.append(")");
		return inSql.toString();
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
	private List<BedCardPrintDTO> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(BedCardPrintDTO.class);
		List<BedCardPrintDTO> result = (List<BedCardPrintDTO>) beanlist_handler
				.processRs(cached_rs);
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
	private void calcPatAge(List<BedCardPrintDTO> datas) throws Exception {
		if (ListUtil.isEmpty(datas)) {
			return;
		}
		for (BedCardPrintDTO dto : datas) {
			if (StringUtil.isEmptyWithTrim(dto.getDt_birth_pat())) {
				continue;
			}
			dto.setAge_pat(this.getAge(new FDate(dto.getDt_birth_pat())));
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
			return String.format("%d岁%d月",
					new Object[] { Integer.valueOf(fullYear), Integer.valueOf(fullMonth) });
		}

		if ((fullMonth >= 1) && (fullYear <= 1)) {
			if (days <= 0) {
				return String.format("%d月", new Object[] { Integer.valueOf(fullMonth) });
			}
			return String.format("%d月零%d天",
					new Object[] { Integer.valueOf(fullMonth), Integer.valueOf(days) });
		}
		if (days <= 0) {
			return String.format("%d天", new Object[] { Integer.valueOf(1) });
		}
		return String.format("%d天", new Object[] { Integer.valueOf(days) });
	}

	/**
	 * 处理诊断名称数据：如果诊断名称为空就取就诊诊断名称
	 * 
	 * @author zhengcm
	 * @param datas 床位卡打印DTO列表
	 * @throws Exception
	 */
	private void checkDiDefData(List<BedCardPrintDTO> datas) throws Exception {
		if (ListUtil.isEmpty(datas)) {
			return;
		}
		for (BedCardPrintDTO dto : datas) {
			if (StringUtil.isEmptyWithTrim(dto.getName_didef_dis())) {
				dto.setName_didef_dis(dto.getName_didef_dis_ip());
			}
		}
	}
}
