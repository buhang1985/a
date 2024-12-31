package iih.en.pv.opPatDisStats;

import java.util.List;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.dp.report.util.StringUtil;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.handler.BeanListHandler;

import com.sun.rowset.CachedRowSetImpl;

/***
 * 门急诊患者疾病构成
 * 
 * @author fanlq
 *
 */
public class OpPatDisStatsService {
	/**
	 * 获取患者疾病统计
	 * 
	 * @param
	 * @return
	 * @throws BizException
	 * @author fanlq
	 */
	public OpPatDisStatsDTO[] exec(String grp_id,String org_id,String dt_b, String dt_e) throws Exception {

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
			return new OpPatDisStatsDTO[] { new OpPatDisStatsDTO() };
		}

		// 查询数据列字段别名
		String[] columns = { "name_dis", "dis_num" };

		FDate endDate = new FDate(dt_e);
		endDate = endDate.getDateAfter(+1);

		dt_b = dt_b + " 00:00:00";
		dt_e = endDate.toLocalString() + " 23:59:59";

		// 组装查询SQL
		StringBuilder sb = new StringBuilder();

		// 查询疾病及人次
		sb.append("select di.id_didef_dis,di.name_didef_dis as " + columns[0] + ",count(*) as " + columns[1] + " from en_ent ent ");
		sb.append("inner join en_ent_op op on ent.id_ent = op.id_ent ");
		sb.append("inner join en_ent_di di on di.id_ent = ent.id_ent ");
		sb.append("where ent.fg_canc = 'N' ");
		sb.append("and ent.fg_acptvalid ='Y' ");
		sb.append("and ent.code_entp = '00' ");
		sb.append("and ent.id_grp = '" + grp_id + "' ");
		sb.append("and ent.id_org = '" + org_id + "' ");
		sb.append("and ent.dt_entry >= '" + dt_b + "' ");
		sb.append("and ent.dt_entry < '" + dt_e + "' ");
		sb.append("group by di.id_didef_dis,di.name_didef_dis ");

		// 查询数据
		List<OpPatDisStatsDTO> datas = this.getResultBySql(sb.toString());
		if (datas == null) {
			return null;
		}
		return datas.toArray(new OpPatDisStatsDTO[0]);

	}

	// 查询数据SQL
	@SuppressWarnings("unchecked")
	private List<OpPatDisStatsDTO> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(OpPatDisStatsDTO.class);
		List<OpPatDisStatsDTO> result = (List<OpPatDisStatsDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}
}
