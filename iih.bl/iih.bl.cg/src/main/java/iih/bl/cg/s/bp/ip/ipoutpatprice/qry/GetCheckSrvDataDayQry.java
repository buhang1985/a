package iih.bl.cg.s.bp.ip.ipoutpatprice.qry;

import iih.bd.base.utils.SqlUtils;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/*
 * 获取按天计算数量大于在院时间的服务
 * @param LIM
 */
public class GetCheckSrvDataDayQry implements ITransQry{
	private String id_ent;
	private FDateTime dt_end;
	private String id_srv_list;
	public GetCheckSrvDataDayQry(String id_ent,FDateTime dt_end, String id_srv_list) {
		this.id_ent = id_ent;
		this.dt_end = dt_end;
		this.id_srv_list = id_srv_list;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		param.addParam(dt_end);
		param.addParam(dt_end);
		param.addParam(id_ent);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		sb.append("	select cg.id_srv, ");
		sb.append("		cg.name_srv, ");
		sb.append("		cg.quan, ");
		sb.append("		'day' as note ");
		sb.append(" from ( ");
		sb.append("		select cgip.id_ent, entip.id_bed, cgip.srvu, cgip.id_srv, cgip.name_srv, sum(cgip.eu_direct * cgip.quan) quan");
		sb.append("		from bl_cg_ip cgip ");
		sb.append("		inner join en_ent_ip entip on cgip.id_ent = entip.id_ent ");
		sb.append("		where cgip.id_ent = ? ");
		sb.append("		group by cgip.id_ent, entip.id_bed, cgip.srvu, cgip.id_srv, cgip.name_srv");
		sb.append("  ) cg ");
		sb.append(" where (1 = 1) ");
		sb.append(SqlUtils.getInSqlByIds(" and cg.id_srv ", this.id_srv_list.split(",")));
		sb.append(" and cg.quan > ");
		sb.append("   (select case ceil(to_date(?, 'yyyy-mm-dd hh24:mi:ss') - to_date(ent.dt_acpt, 'yyyy-mm-dd hh24:mi:ss')) ");
		sb.append("   		when 0 then 1 ");
		sb.append("   		else ceil(to_date(?, 'yyyy-mm-dd hh24:mi:ss') - to_date(ent.dt_acpt, 'yyyy-mm-dd hh24:mi:ss')) end ");
		sb.append("   from en_ent ent ");
		sb.append("   where ent.id_ent = ?)");
		return sb.toString();
	}

}
