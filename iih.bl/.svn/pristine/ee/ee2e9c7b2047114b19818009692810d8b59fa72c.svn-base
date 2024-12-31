package iih.bl.itf.std.bp.ipcharge.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPrepaymentBalanceQry implements ITransQry {
		
		String patCode;
		int times;
		
		public GetPrepaymentBalanceQry(String patCode, int times) {
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
			sql.append("sum(c.eu_direct * nvl(c.amt,0)) as prepayment, ");
			sql.append("0.00 as prepaidBalance ");
			sql.append("from en_ent a ");
			sql.append("inner join en_ent_ip b on a.id_ent = b.id_ent ");
			sql.append("inner join bl_prepay_Pat c on a.id_ent = c.id_ent and a.id_pat= c.id_pat ");
			sql.append("inner join pi_pat pat on a.id_pat= pat.id_pat ");
			sql.append("WHERE ( pat.code = ? ) ");
			sql.append("AND ( b.times_ip = ? )");
			return sql.toString();
		}

}
