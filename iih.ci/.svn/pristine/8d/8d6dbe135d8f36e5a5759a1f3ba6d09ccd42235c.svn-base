package iih.ci.ord.s.bp.qry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBlCgItemQry  implements ITransQry{
	
	
	private String idor;
	public GetBlCgItemQry(String idor) {
		this.idor=idor;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this.idor);
		return sqlparam;
	}
	
	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" select cg.dt_cg,cg.id_srv,cg.name_srv,cg.fg_mm,cg.spec,cg.price_ratio,cg.price price_std,mr.dt_mp_plan, ");
		sql.append(" (cg.quan*cg.eu_direct) quan_mend,(cg.amt_ratio*cg.eu_direct) amt_ratio,cg.amt amt_std,cg.id_dep_or,cg.name_mm,cg.id_mm, ");
		sql.append(" dep1.name name_dep_or,cg.id_dep_mp,dep2.name name_dep_mp,cg.id_or,cg.eu_direct,cg.fg_bb,cg.fg_research,cg.fg_selfpay, ");
		sql.append(" cg.id_emp_cg,psn.name name_emp_cg,cg.srcfunc_des,ent.id_hp,measdoc.name as srvu ,mr.id_or_pr_srv ");
		sql.append(" from bl_cg_ip cg ");
		sql.append(" left join ci_order ci on ci.id_or=cg.id_or ");
		sql.append(" left join bd_psndoc psn on psn.id_psndoc=cg.id_emp_cg ");
		sql.append(" left join bd_dep dep1 on dep1.id_dep=cg.id_dep_or ");
		sql.append(" left join bd_dep dep2 on dep2.id_dep=cg.id_dep_mp ");
		sql.append(" left join en_ent ent on ent.id_ent=cg.id_ent ");
		sql.append(" left join bd_measdoc measdoc on cg.srvu = measdoc.id_measdoc ");
		sql.append(" left join mp_or_pr_srv mr on mr.id_or_pr_srv=cg.id_or_pr_srv ");
		//sql.append(" left join mp_dg_ip_apde_dt apde on apde.id_or_pr_srv=cg.id_or_pr_srv ");
		sql.append(" where 1=1 ");
		sql.append(" and cg.fg_real = 'Y' ");
//		sql.append(" and cg.id_ent=?");
		sql.append(" and cg.id_or=?");

		sql.append(" order by cg.dt_cg ");
		return sql.toString();
	}

}
