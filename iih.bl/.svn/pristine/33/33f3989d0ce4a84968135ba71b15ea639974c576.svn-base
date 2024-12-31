package iih.bl.itf.std.bp.ipcharge.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetTotalCostInfoQry implements ITransQry {
	
	String patCode;
	Integer times;
	

	public GetTotalCostInfoQry(String patCode, Integer times) {
		this.patCode = patCode;
		this.times = times;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		param.addParam(patCode);
		String str = Integer.toString(times);
		param.addParam(str);		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT  ");
		sql.append("pat.name as patName, ");
		sql.append("dep.code as deptCode, ");
		sql.append("b.name_bed as bedNo, ");
		sql.append("cate.name as patCate, ");
		sql.append("udi.name as hpSrvTp, ");
		sql.append("c.dt_cg as cgDate, ");
		sql.append("c.code_srv as srvCode, ");
		sql.append("c.name_srv as srvName, ");
		sql.append("c.name_inccaitm as inccaItm, ");
		sql.append("c.code_cg as charge_no, ");
		sql.append("c.spec as spec, ");
		sql.append("c.price as price, ");
		sql.append("c.quan as quan, ");
		sql.append("(c.amt_ratio*c.eu_direct) as amt, ");
		sql.append("0.00 as totalAmt, ");
	    sql.append("meas.name as packageUnit ");
		sql.append("FROM en_ent a ");
		sql.append("inner join en_ent_ip b on a.id_ent = b.id_ent ");
		sql.append("inner join bl_cg_ip c on a.id_ent = c.id_ent and a.id_pat= c.id_pat ");
		sql.append("left join bd_hp_srvorca d on c.id_srv = d.id_srv and c.id_mm= d.id_mm ");
		sql.append("inner join pi_pat pat on a.id_pat= pat.id_pat ");
		sql.append("left join bd_dep dep on b.id_dep_phyadm = dep.id_dep ");
		sql.append("left join pi_pat_ca cate on a.id_patca = cate.id_patca ");
		sql.append("left join bd_measdoc meas on c.pgku_cur= meas.id_measdoc ");
		sql.append("left join (select * from bd_udidoc where id_udidoclist='@@@@ZZ2000000000003P') udi on d.sd_hpsrvtp = udi.code ");
		sql.append("WHERE (pat.code = ?) ");
		sql.append(" AND (b.times_ip = ?) ");
		sql.append(" AND nvl(c.fg_research,'N')='N' ");
		sql.append("ORDER BY c.dt_cg ");
		return sql.toString();
	}

}
