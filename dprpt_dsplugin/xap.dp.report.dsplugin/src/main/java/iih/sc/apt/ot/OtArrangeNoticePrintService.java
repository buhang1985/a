package iih.sc.apt.ot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.sun.rowset.CachedRowSetImpl;
import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.handler.BeanListHandler;

public class OtArrangeNoticePrintService {
	//手术角色类型
    private static final String ID_OP_ROLE_ZDYS = "@@@@AA1000000004IXRX"; //主刀医师
    private static final String ID_OP_ROLE_DYZS = "@@@@AA1000000004IXRY"; //第一助手
    private static final String ID_OP_ROLE_DEZS = "@@@@AA1000000004IXRZ"; //第二助手
    private static final String ID_OP_ROLE_MZYS = "@@@@AA1000000004IXS0"; //麻醉医师
    private static final String ID_OP_ROLE_DRMZYS = "@@@@Z8100000000HD18U"; //第二麻醉医师
    private static final String ID_OP_ROLE_QXHS = "@@@@Z8100000000HD19E"; //器械护士(洗手)
    private static final String ID_OP_ROLE_QXHSE = "@@@@Z8100000000HD19O"; //器械护士二
    private static final String ID_OP_ROLE_XHHS = "@@@@Z8100000000HD19T"; //巡回护士
    private static final String ID_OP_ROLE_XHHSE = "@@@@Z8100000000HD19Y"; //巡回护士二
    private static final String ID_OP_ROLE_DSZS = "@@@@LL100000000497F5";//第三助手
    private static final String ID_OP_ROLE_JS = "@@@@LL100000000497FF";//接送
    private static final String ID_OP_ROLE_CG = "@@@@LL100000000497FJ";//参观
   		 
    private static final String SD_OP_ROLE_ZDYS = "00"; //主刀医师
    private static final String SD_OP_ROLE_DYZS = "01"; //第一助手
    private static final String SD_OP_ROLE_DEZS = "02"; //第二助手
    private static final String SD_OP_ROLE_MZYS = "03"; //麻醉医师
    private static final String SD_OP_ROLE_DRMZYS = "04"; //第二麻醉医师
    private static final String SD_OP_ROLE_QXHS = "05"; //器械护士(洗手)
    private static final String SD_OP_ROLE_QXHSE = "06"; //器械护士二
    private static final String SD_OP_ROLE_XHHS = "07"; //巡回护士
    private static final String SD_OP_ROLE_XHHSE = "08"; //巡回护士二
    private static final String SD_OP_ROLE_DSZS = "09"; //第三助手
    private static final String SD_OP_ROLE_JS = "10"; //接送
    private static final String SD_OP_ROLE_CG = "11"; //参观
	/**
	 * 手术预约通知单
	 * @param id_apt_appl
	 * @return
	 * @throws Exception
	 */
	public List<OtArrangeNoticeDTO> query(String id_apt_appl) throws Exception {
		StringBuilder sql = this.getSql();
		sql.append(" where appl.id_aptappl = '"+id_apt_appl+"'");
		// 执行查询
		List<OtArrangeNoticeDTO> datas = this.getResultBySql(sql.toString());
		if (ListUtil.isEmpty(datas)) {
			return null;
		}
		OtArrangeNoticeDTO arrangeNoticeDTO = new OtArrangeNoticeDTO();
		arrangeNoticeDTO = datas.get(0);
		for(OtArrangeNoticeDTO dto : datas)
		{
			if(ID_OP_ROLE_ZDYS.equals(dto.getId_role()))//主刀医师
			{
				arrangeNoticeDTO.setDoc_opt_main(dto.getName_emp());
			}
			else if(ID_OP_ROLE_DYZS.equals(dto.getId_role()))//助手一
			{
				arrangeNoticeDTO.setAssistant_one(dto.getName_emp());
			}
			else if(ID_OP_ROLE_DEZS.equals(dto.getId_role()))//助手二
			{
				arrangeNoticeDTO.setAssistant_two(dto.getName_emp());
			}
			else if(ID_OP_ROLE_DSZS.equals(dto.getId_role()))//助手三
			{
				arrangeNoticeDTO.setAssistant_three(dto.getName_emp());
			}
			else if(ID_OP_ROLE_MZYS.equals(dto.getId_role()))//麻醉师--主
			{
				arrangeNoticeDTO.setAnaesthesia_main(dto.getName_emp());
			}
			else if(ID_OP_ROLE_DRMZYS.equals(dto.getId_role()))//麻醉师--辅
			{
				arrangeNoticeDTO.setAnaesthesia_vice(dto.getName_emp());
			}
			else if(ID_OP_ROLE_QXHS.equals(dto.getId_role()))//洗手护士
			{
				arrangeNoticeDTO.setHand_wash_nurse(dto.getName_emp());
			} 
			else if(ID_OP_ROLE_XHHS.equals(dto.getId_role()))//巡回护士
			{
				arrangeNoticeDTO.setTouring_nurse(dto.getName_emp());
			} 
			else if(ID_OP_ROLE_JS.equals(dto.getId_role()))//接送护士
			{
				arrangeNoticeDTO.setArrange_nurse(dto.getName_emp());
			}
			//else if("".equals(dto.getId_role()))//副手术医师
			//{
			//	arrangeNoticeDTO.setDoc_opt_vice(dto.getName_emp());
			//}
		}
		//急诊标识
		if("Y".equals(arrangeNoticeDTO.getFg_urgent()))
		{
			arrangeNoticeDTO.setFg_urgent("√");
		}
		else
		{
			arrangeNoticeDTO.setFg_urgent("");
		}
		// 计算年龄
		arrangeNoticeDTO.setAge(this.getAge(arrangeNoticeDTO.getBirth()));
		List<OtArrangeNoticeDTO> list = new ArrayList<OtArrangeNoticeDTO>();
		list.add(arrangeNoticeDTO);
		return list;
	}
	
	
	private StringBuilder getSql()
	{
		StringBuilder sql = new StringBuilder();
		sql.append(" select apt.dt_appt as dt_notice,");
		sql.append(" appl.applyno as applno,");
		sql.append(" apt.dt_b as dt_apt,");
		sql.append(" mp.name as dep_mp,");
		sql.append(" pi.mnecode as code_pat,");
		sql.append(" pi.name as name_pat,");
		sql.append(" pi.code_amr_ip inpatient_no,");
		sql.append(" sex.name as name_sex,");
		sql.append(" pi.dt_birth as birth,");
		sql.append(" dep.name as dep_appl,");
		sql.append(" appl.name as name_or,");
		sql.append(" appl.fg_urgent as fg_urgent,");
		sql.append(" opt.name as operation_room,");
		sql.append(" apt.queno as operation_platform_number,");
		sql.append(" rol.id_udidoc as id_role,");
		sql.append(" rol.name as name_role,");
		sql.append(" doc.name as name_emp,");
		sql.append(" ip.name_bed as bed,");
		sql.append(" ane.name as anaesthesia_method,");
		sql.append(" wrd.name as dep_pat_nurse,");
		sql.append(" sug.sug_require as requirement,");
		sql.append(" sug.announcements as note,");
		sql.append(" pr.name as pact");
		sql.append(" from sc_apt_appl appl ");
		sql.append(" inner join sc_apt apt on apt.id_apt = appl.id_scapt");
		sql.append(" inner join bd_dep mp on mp.id_dep = appl.id_dep_mp");
		sql.append(" inner join pi_pat pi on pi.id_pat = appl.id_pi");
		sql.append(" inner join bd_dep dep on dep.id_dep = appl.id_dep_appl");
		sql.append(" inner join sc_res res on res.id_scres = apt.id_scres");
		sql.append(" inner join bd_opt opt on opt.id_opt = res.id_opt");
		sql.append(" inner join sc_apt_appl_opt appl_opt on appl_opt.id_aptappl = appl.id_aptappl");
		sql.append(" left join bd_udidoc ane on ane.id_udidoc = appl_opt.id_anestp");
		sql.append(" left join sc_apt_opt_emp emp on emp.id_aptappl = appl.id_aptappl");
		sql.append(" left join bd_udidoc rol on rol.id_udidoc = emp.id_role");
		sql.append(" left join bd_psndoc doc on doc.id_psndoc = emp.id_emp");
		sql.append(" left join bd_udidoc sex on sex.id_udidoc = appl.id_sex");
		sql.append(" left join en_ent_ip ip on ip.id_ent = appl.id_ent");
		sql.append(" left join bd_dep wrd on wrd.id_dep = ip.id_dep_nuradm");
		sql.append(" inner join en_ent ent on ent.id_ent = appl.id_ent");
		sql.append(" inner join bd_pri_pat pr on ent.id_pripat = pr.id_pripat");
		sql.append(" inner join ci_ap_sug sug on sug.no_applyform = appl.applyno ");
		return sql;
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
	private List<OtArrangeNoticeDTO> getResultBySql(String sql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, sql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(OtArrangeNoticeDTO.class);
		List<OtArrangeNoticeDTO> result = (List<OtArrangeNoticeDTO>) beanlist_handler.processRs(cached_rs);
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
