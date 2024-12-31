package iih.bl.cg.s.bp.ip.ipoutpatprice.qry;

import org.apache.cxf.common.util.StringUtils;

import iih.bd.base.utils.SqlUtils;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/*
 * 获取按分钟、小时计算数量大于在院时间的服务
 * @param LIM
 */
public class GetCheckSrvDataQry implements ITransQry{
	private String id_ent;
	private FDateTime dt_end;
	private String id_srv_list_hour;
	private String id_srv_list_minutes;
	public GetCheckSrvDataQry(String id_ent,FDateTime dt_end,String id_srv_list_hour, String id_srv_list_minutes) {
		this.id_ent = id_ent;
		this.dt_end = dt_end;
		this.id_srv_list_hour = id_srv_list_hour;
		this.id_srv_list_minutes = id_srv_list_minutes;
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
		sb.append("		vB.time_type as note ");
		sb.append(" from ( ");
		sb.append(" 	select id_ent, srvu, id_srv, name_srv, sum(eu_direct * quan) as quan ");
		sb.append("     from bl_cg_ip ");
		sb.append("     where id_ent = ? ");
		sb.append("       and not exists (select id_srv from BD_SRV_SPEC_ROUND spec ");
		sb.append("       		where spec.id_srv = bl_cg_ip.id_srv and to_date(?,'yyyy-mm-dd hh24:mi:ss') between to_date(dt_b,'yyyy-mm-dd hh24:mi:ss') and to_date(dt_e,'yyyy-mm-dd hh24:mi:ss')) ");
		sb.append("     group by id_ent, srvu, id_srv, name_srv");
		sb.append("  ) cg ");		
		if (!StringUtils.isEmpty(this.id_srv_list_hour) && !StringUtils.isEmpty(this.id_srv_list_minutes)) {
			sb.append(" inner join ( ");
			sb.append(" select id_srv, 3600000 as scalefactor, 'hour' as time_type from bd_srv where 1=1 ");
			sb.append(SqlUtils.getInSqlByIds(" and id_srv ", this.id_srv_list_hour.split(",")));
			sb.append(" union all ");
			sb.append(" select id_srv, 60000 as scalefactor, 'minutes' as time_type from bd_srv where 1=1 ");
			sb.append(SqlUtils.getInSqlByIds(" and id_srv ", this.id_srv_list_minutes.split(",")));
			sb.append(" )vB on cg.id_srv = vB.id_srv ");
		} else if (!StringUtils.isEmpty(this.id_srv_list_hour) && StringUtils.isEmpty(this.id_srv_list_minutes)) {
			sb.append(" inner join ( ");
			sb.append(" select id_srv, 3600000 as scalefactor, 'hour' as time_type from bd_srv where (1=1) ");
			sb.append(SqlUtils.getInSqlByIds(" and id_srv ", this.id_srv_list_hour.split(",")));
			sb.append(" )vB on cg.id_srv = vB.id_srv ");
		} else if (StringUtils.isEmpty(this.id_srv_list_hour) && !StringUtils.isEmpty(this.id_srv_list_minutes)) {
			sb.append(" inner join ( ");
			sb.append(" select id_srv, 60000 as scalefactor, 'minutes' as time_type from bd_srv where 1=1 ");
			sb.append(SqlUtils.getInSqlByIds(" and id_srv ", this.id_srv_list_minutes.split(",")));
			sb.append(" )vB on cg.id_srv = vB.id_srv ");
		}
		sb.append(" where (cg.quan * vB.scalefactor > ");
		sb.append("   (select ceil((to_date(?, 'yyyy-mm-dd hh24:mi:ss') - to_date(ent.dt_acpt, 'yyyy-mm-dd hh24:mi:ss')) * 24 * 60 * 60 * 1000)");
		sb.append("   from en_ent ent ");
		sb.append("   where ent.id_ent = ?))");
		return sb.toString();
	}
}
