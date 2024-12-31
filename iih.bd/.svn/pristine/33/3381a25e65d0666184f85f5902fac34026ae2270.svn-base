package iih.bd.srv.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询特殊诊断
 * @author YANG
 *
 */
public class GetCostCheckQry implements ITransQry {

	private String id_srv;
	
	public GetCostCheckQry(String id_srv) {
		this.id_srv = id_srv;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		StringBuilder strSql = new StringBuilder();
		strSql.append(" select  b.NAME as name_srv,'标本费用对照' as node_name,d.NAME as name_tree from bd_samp_pri_itm a left join BD_SRV b on a.ID_SRV = b.ID_SRV left join bd_samp_pri c on a.ID_SAMP_PRI =c.ID_SAMP_PRI  left join  BD_SRV d on d.ID_SRV =c.ID_SRV ");
		strSql.append(String.format(" where a.ID_SRV = '%s'", this.id_srv));
		strSql.append(" UNION");
		strSql.append(" select  b.NAME as name_srv,'用法费用对照' as node_name,c.NAME as name_tree from BD_PRI_USG a left join BD_SRV  b on a.ID_SRV = b.ID_SRV left join bd_route c on a.ID_ROUTE = c.ID_ROUTE");
		strSql.append(String.format(" where a.ID_SRV = '%s'", this.id_srv));
		strSql.append(" UNION");
		strSql.append(" select  b.NAME as name_srv,'煎法费用对照' as node_name,c.NAME as name_tree from BD_PRI_BOIL a left join BD_SRV  b on a.ID_SRV = b.ID_SRV left join  bd_boil c on a.ID_BOIL = c.ID_BOIL");
		strSql.append(String.format(" where a.ID_SRV = '%s'", this.id_srv));
		strSql.append(" UNION");
		strSql.append(" select  b.NAME as name_srv,'煎法要求费用对照' as node_name,c.NAME as name_tree from BD_PRI_BOIL_DES a left join BD_SRV  b on a.ID_SRV = b.ID_SRV left join bd_boil_des c on a.ID_BOILDES = c.ID_BOILDES");
		strSql.append(String.format(" where a.ID_SRV = '%s'", this.id_srv));
		strSql.append(" UNION");
		strSql.append(" select  b.NAME as name_srv,'关联服务策略配置' as node_name,'' as name_tree from Bd_Relsrv_Tactics a left join BD_SRV  b on a.ID_SRV = b.ID_SRV ");
		strSql.append(String.format(" where a.ID_SRV = '%s'", this.id_srv));
		strSql.append(" UNION");
		strSql.append(" select b.NAME as name_srv,'儿童费用采集' as node_name,'' as name_tree from bd_samp_pri_chldcnst a left join BD_SRV b on a.ID_SRV = b.ID_SRV  ");
		strSql.append(String.format(" where a.ID_SRV = '%s'", this.id_srv));
        return strSql.toString();
	}

}
