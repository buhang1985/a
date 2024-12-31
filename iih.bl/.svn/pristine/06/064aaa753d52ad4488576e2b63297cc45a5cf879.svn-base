package iih.bl.itf.std.bp.ipcharge.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPrepaymentRecordQry implements ITransQry {
	
	String patCode;
	Integer times;
	

	public GetPrepaymentRecordQry(String patCode, Integer times) {
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
		sql.append("pm.name as payMethod, ");
		sql.append("nvl(c.paymodenode,' ') as payModeNode, ");
		sql.append("c.code_rep as receiptNo, ");
		sql.append("c.dt_pay as dtPay, ");
		sql.append("pat.name as patName, ");
		sql.append("dep.code as deptCode, ");
		sql.append("dep.name as deptName, ");
		sql.append("nur.code as nurCode, ");
		sql.append("nur.name as nurName, ");
		sql.append("c.eu_direct * nvl(c.amt,0) as amt, ");
		sql.append("c.note ");
		sql.append("FROM en_ent a ");
		sql.append("inner join en_ent_ip b on a.id_ent = b.id_ent ");
		sql.append("inner join bl_prepay_pat c on a.id_ent = c.id_ent and a.id_pat= c.id_pat ");
		sql.append("inner join pi_pat pat on a.id_pat= pat.id_pat ");
		sql.append("left join bd_dep dep on b.id_dep_phyadm = dep.id_dep ");
		sql.append("left join bd_dep nur on b.id_dep_nuradm = nur.id_dep ");
		sql.append("left join bd_pri_pm pm on c.id_pm = pm.id_pm ");
		sql.append("WHERE (pat.code = ?) ");
		sql.append(" AND (b.times_ip = ?) ");
		sql.append("ORDER BY c.dt_pay ");
		return sql.toString();
	}

}
