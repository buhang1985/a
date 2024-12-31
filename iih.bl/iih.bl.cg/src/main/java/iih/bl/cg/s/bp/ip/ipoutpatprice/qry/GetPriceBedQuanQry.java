package iih.bl.cg.s.bp.ip.ipoutpatprice.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 检索就诊床位的起始日期 以及 对应收费项目数量
 * @author LIM
 *
 */
public class GetPriceBedQuanQry implements ITransQry{

	private String id_ent;

	public GetPriceBedQuanQry(String id_ent) {
		this.id_ent = id_ent;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		return param;
	}

	@Override
	public String getQrySQLStr() {
 		StringBuilder sb = new StringBuilder();
		sb.append(" select ");
		sb.append(" bltpl_itm.id_srv,");
		sb.append(" round(to_number(to_date(enbed.dt_e,'YYYY-MM-DD HH24:MI:SS') - to_date(enbed.dt_b,'YYYY-MM-DD HH24:MI:SS')))* bltpl_itm.quan_medu as quan");
		sb.append(" from en_ent_bed enbed");
		sb.append(" inner join bd_bed bed on enbed.id_bed = bed.id_bed ");
		sb.append(" inner join bd_bltpl bltpl on bed.id_bltpl = bltpl.id_bltpl");
		sb.append(" inner join BD_BLTPL_ITM bltpl_itm on bltpl.id_bltpl = bltpl_itm.id_bltpl");
		sb.append(" inner join bd_pri_srv pri on bltpl_itm.id_srv = pri.id_srv");
		sb.append(" inner join bd_srv srv on bltpl_itm.id_srv= srv.id_srv");
		sb.append(" where id_ent = ?");
		sb.append(" and pri.price > 0 ");
		sb.append(" and pri.dt_e = '2099-12-31 23:59:59' and pri.fg_active='Y'");
		return sb.toString();
	}
}
