package iih.bd.pp.modifypriplan.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class PriMaxAndNowPriceQry implements ITransQry {
	
	private String id_srv;
	
	public PriMaxAndNowPriceQry(String id_srv){
		this.id_srv = id_srv;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(id_srv);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append(" select a.price as Now_price, b.Pri_max ");
		sb.append(" from bd_pri_srv a ");
		sb.append(" inner join bd_hp_srvorca b ");
		sb.append(" on a.id_srv = b.id_srv ");
		sb.append(" where a.id_srv= ? ");
		sb.append(" and a.dt_e = '2099-12-31 23:59:59' ");
		//sb.append(" and b.dt_b <= to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss') ");
		sb.append(" and (b.dt_e >= to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss') or b.dt_e is null) ");
		sb.append(" and eu_status = 4 ");
		sb.append(" and a.ds = 0 ");
		sb.append(" and b.ds = 0 ");
		return sb.toString();
	}

}
