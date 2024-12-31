package iih.en.pv.opentkeytargetstat;

import java.text.DecimalFormat;
import java.util.List;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.dp.report.util.StringUtil;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.handler.BeanListHandler;

import com.sun.rowset.CachedRowSetImpl;

/***
 * 
 * 获取门诊就诊关键指标数据
 * 
 * @author fanlq
 *
 */
public class GetOpTargetStatsService {

	/**
	 * 获取科室统计信息
	 * 
	 * @param
	 * @return
	 * @throws BizException
	 * @author fanlq
	 */
	public OpEntKeyTargetStatDTO[] exec(String grp_id,String org_id,String dt_b, String dt_e) throws Exception {

		//集团空值判断
		if (StringUtil.isNullOrEmpty(grp_id)) {
			throw new Exception("集团为空！");
		}
		//组织空值判断
		if (StringUtil.isNullOrEmpty(org_id)) {
			throw new Exception("组织为空！");
		}
		// 空数据判断
		if (StringUtil.isNullOrEmpty(dt_b) || StringUtil.isNullOrEmpty(dt_e)) {
			return new OpEntKeyTargetStatDTO[] { new OpEntKeyTargetStatDTO() };
		}

		// 查询数据列字段别名
		String[] columns = { "opureg_num", "er_num", "family_diag_num", "phy_health_num", "avg_op_er_num", "succ_num", "death_num", "er_death_num", "deathed_num", "out_emg_num", "death_emg_num",
				"op_diag_quality", "er_succ_rate" };

		FDate endDate = new FDate(dt_e);
		endDate = endDate.getDateAfter(+1);

		int days = FDate.getDaysBetween(new FDate(dt_b), endDate);

		dt_b = dt_b + " 00:00:00";
		dt_e = endDate.toLocalString() + " 23:59:59";

		// 组装查询SQL
		StringBuilder sb = new StringBuilder();
		sb.append("select * from ");

		// 1、门诊人次
		sb.append("(select count(*) as " + columns[0] + " from en_ent ent ");
		sb.append("inner join en_ent_op op on ent.id_ent = op.id_ent ");
		sb.append("where ent.fg_canc = 'N' ");
		sb.append("and ent.fg_acptvalid ='Y' ");
		sb.append("and ent.code_entp = '00' ");
		sb.append("and ent.id_grp = '" + grp_id + "' ");
		sb.append("and ent.id_org = '" + org_id + "' ");
		sb.append("and ent.dt_entry >= '" + dt_b + "' ");
		sb.append("and ent.dt_entry < '" + dt_e + "') t1, ");

		// 2、急诊人次
		sb.append("(select count(*) as " + columns[1] + " from en_ent ent ");
		sb.append("inner join en_ent_op op on ent.id_ent = op.id_ent ");
		sb.append("where ent.fg_canc = 'N' ");
		sb.append("and ent.fg_acptvalid ='Y' ");
		sb.append("and ent.code_entp = '01' ");
		sb.append("and ent.id_grp = '" + grp_id + "' ");
		sb.append("and ent.id_org = '" + org_id + "' ");
		sb.append("and ent.dt_entry >= '" + dt_b + "' ");
		sb.append("and ent.dt_entry < '" + dt_e + "') t2, ");

		// 3、家庭诊断人次

		// 4、健康检查人次数
		sb.append("(select count(*) as " + columns[3] + " from en_ent ent ");
		sb.append("inner join en_ent_op op on ent.id_ent = op.id_ent ");
		sb.append("where ent.fg_canc = 'N' ");
		sb.append("and ent.fg_acptvalid ='Y' ");
		sb.append("and ent.code_entp = '00' ");
		sb.append("and ent.id_grp = '" + grp_id + "' ");
		sb.append("and ent.id_org = '" + org_id + "' ");
		sb.append("and ent.dt_entry >= '" + dt_b + "' ");
		sb.append("and ent.dt_entry < '" + dt_e + "' ");
		sb.append("and op.id_scsrv in ('xxx')) t4, ");

		// 5、日均门急诊人次(根据1和2的查询结果最后计算)

		// 6、急诊抢救人次
		sb.append("(select sum(op.succ_rescue) as " + columns[5] + ", sum(op.times_rescue - op.succ_rescue) as " + columns[6] + " from en_ent ent ");
		sb.append("inner join en_ent_op op on ent.id_ent = op.id_ent ");
		sb.append("where ent.fg_canc = 'N' ");
		sb.append("and ent.fg_acptvalid ='Y' ");
		sb.append("and op.fg_rescue ='Y' ");
		sb.append("and ent.code_entp = '01' ");
		sb.append("and ent.id_grp = '" + grp_id + "' ");
		sb.append("and ent.id_org = '" + org_id + "' ");
		sb.append("and ent.dt_entry >= '" + dt_b + "' ");
		sb.append("and ent.dt_entry < '" + dt_e + "') t6,");

		// 7、急诊死亡人次
		sb.append("(select count(*) as " + columns[7] + " from en_ent ent ");
		sb.append("inner join en_ent_op op on ent.id_ent = op.id_ent ");
		sb.append("where ent.fg_canc = 'N' ");
		sb.append("and ent.fg_acptvalid ='Y' ");
		sb.append("and ent.code_entp = '01' ");
		sb.append("and op.sd_gowhere ='4' ");
		sb.append("and op.fg_rescue = 'Y' ");
		sb.append("and ent.id_grp = '" + grp_id + "' ");
		sb.append("and ent.id_org = '" + org_id + "' ");
		sb.append("and ent.dt_entry >= '" + dt_b + "' ");
		sb.append("and ent.dt_entry < '" + dt_e + "') t7, ");

		// 8、来院时已死亡人次（不统计不显示）

		// 9、出观察室人次
		sb.append("(select count(*) as " + columns[9] + " from en_ent ent ");
		sb.append("inner join sc_apt_ip apt on ent.id_ent = apt.id_entip ");
		sb.append("inner join en_ent_ip ip on ent.id_ent = ip.id_ent ");
		sb.append("where ent.fg_canc = 'Y' ");
		sb.append("and ent.fg_acptvalid ='N' ");
		sb.append("and apt.fg_emgstay = 'Y' ");
		sb.append("and ent.id_grp = '" + grp_id + "' ");
		sb.append("and ent.id_org = '" + org_id + "' ");
		sb.append("and ent.dt_entry >= '" + dt_b + "' ");
		sb.append("and ent.dt_entry < '" + dt_e + "') t9, ");

		// 10、观察室死亡患者数
		sb.append("(select count(*) as " + columns[10] + " from en_ent ent ");
		sb.append("inner join sc_apt_ip apt on ent.id_ent = apt.id_entip ");
		sb.append("inner join en_ent_ip ip on ent.id_ent = ip.id_ent ");
		sb.append("inner join en_ent_ip_emgstay emg on emg.id_ent = ent.id_ent ");
		sb.append("where ent.fg_canc = 'N' ");
		sb.append("and ent.fg_acptvalid ='Y' ");
		sb.append("and apt.fg_emgstay = 'Y' ");
		sb.append("and emg.sd_gowhere = '5' ");
		sb.append("and ent.id_grp = '" + grp_id + "' ");
		sb.append("and ent.id_org = '" + org_id + "' ");
		sb.append("and ent.dt_entry >= '" + dt_b + "' ");
		sb.append("and ent.dt_entry < '" + dt_e + "') t10, ");

		// 11、门诊诊断质量情况（上住院后统计）

		// 12、急诊抢救成功率
		sb.append("(select sum(op.succ_rescue) / sum(op.times_rescue) as " + columns[12] + " from en_ent ent ");
		sb.append("inner join en_ent_op op on ent.id_ent = op.id_ent ");
		sb.append("where ent.fg_canc = 'Y' ");
		sb.append("and ent.fg_acptvalid ='N' ");
		sb.append("and ent.code_entp = '01' ");
		sb.append("and op.fg_rescue = 'Y' ");
		sb.append("and ent.id_grp = '" + grp_id + "' ");
		sb.append("and ent.id_org = '" + org_id + "' ");
		sb.append("and ent.dt_entry >= '" + dt_b + "' ");
		sb.append("and ent.dt_entry < '" + dt_e + "') t12 ");

		// 查询数据
		List<OpEntKeyTargetStatDTO> datas = this.getResultBySql(sb.toString());
		OpEntKeyTargetStatDTO data = null;
		if (datas != null) {
			data = datas.get(0);
		}
		this.calc(data, days);
		return new OpEntKeyTargetStatDTO[] { data };

	}

	@SuppressWarnings("unchecked")
	private List<OpEntKeyTargetStatDTO> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(OpEntKeyTargetStatDTO.class);
		List<OpEntKeyTargetStatDTO> result = (List<OpEntKeyTargetStatDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}

	/**
	 * 计算日均门急诊人次和其他
	 * 
	 * @param data
	 * @param days
	 * @throws Exception
	 */
	private void calc(OpEntKeyTargetStatDTO data, int days) throws Exception {
		if (data == null) {
			return;
		}
		data.setAvg_op_er_num((data.getOpureg_num() + data.getEr_num()) / days);
		if (data.getSucc_num() == null) {
			data.setSucc_num(0);
		}
		if (data.getDeath_num() == null) {
			data.setDeath_num(0);
		}
		if (data.getEr_succ_rate() == null || data.getEr_succ_rate() == 0) {
			data.setEr_succ_rate_str("0");
		} else {
			DecimalFormat df = new DecimalFormat("0.00%");
			data.setEr_succ_rate_str(df.format(data.getEr_succ_rate()));
		}
	}
}
