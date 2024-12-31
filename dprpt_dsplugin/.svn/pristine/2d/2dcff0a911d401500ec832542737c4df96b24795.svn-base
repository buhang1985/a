package iih.en.pv.dischargenotice;

import java.util.List;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.handler.BeanListHandler;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 出院通知单打印服务
 * 
 * @author zhengcm
 * @date 2017-03-28 14:57:13
 *
 */
public class DischargeNoticePrintService {

	/**
	 * 查询
	 *
	 * @param id_ent
	 * @return
	 * @throws Exception
	 * @author zhengcm
	 */
	public DischargeNoticeDTO[] query(String id_ent) throws Exception {
		// 执行查询
		List<DischargeNoticeDTO> datas = this.getResultBySql(this.getSql(id_ent).toString());
		if (ListUtil.isEmpty(datas)) {
			return null;
		}
		return datas.toArray(new DischargeNoticeDTO[0]);
	}

	/**
	 * sql
	 *
	 * @param id_ent
	 * @return
	 * @throws Exception
	 * @author zhengcm
	 */
	private StringBuilder getSql(String id_ent) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct ");
		sb.append("di.name_didef_dis as name_di,");
		sb.append("org.name as name_org,");
		sb.append("sexdoc.name as name_sex,");
		sb.append("dep.name as name_dep_nur,");
		sb.append("dep2.name as name_dep,");
		sb.append("bdsta.name as name_state ");
		sb.append("from ");
		sb.append("en_ent ent ");
		sb.append("inner join pi_pat pat on pat.id_pat = ent.id_pat ");
		sb.append("inner join bd_udidoc sexdoc on sexdoc.id_udidoc = pat.id_sex ");
		sb.append("inner join bd_org org on org.id_org = ent.id_org ");
		sb.append("inner join bd_dep dep on dep.id_dep = ent.id_dep_nur ");
		sb.append("inner join bd_dep dep2 on dep2.id_dep = ent.id_dep_phy ");
		sb.append("left join en_ent_di di on di.id_ent = ent.id_ent and di.fg_maj = 'Y' ");
		sb.append("left join en_ent_state ensta on ensta.id_ent = ent.id_ent and ensta.sd_enstatetp = '22' ");
		sb.append("left join bd_en_state bdsta on bdsta.id_enstatetp = ensta.id_enstatetp and bdsta.val = ensta.val ");
		sb.append("where ");
		sb.append("ent.id_ent = '" + id_ent + "' ");
		return sb;
	}

	/**
	 * 执行报表数据SQL查询
	 * 
	 * @author zhengcm
	 * @param strSql SQL语句
	 * @return 出院通知单打印数据DTO列表
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private List<DischargeNoticeDTO> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(DischargeNoticeDTO.class);
		List<DischargeNoticeDTO> result = (List<DischargeNoticeDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}
}
