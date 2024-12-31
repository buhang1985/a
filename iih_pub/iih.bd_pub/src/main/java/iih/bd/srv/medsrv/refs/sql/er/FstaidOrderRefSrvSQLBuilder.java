package iih.bd.srv.medsrv.refs.sql.er;

import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefSrvSQLBuilder;

/**
 * 急诊抢救组装物品的参照信息
 * @author liyuelong
 *
 */
public class FstaidOrderRefSrvSQLBuilder extends OpOrderRefSrvSQLBuilder{
	@Override
	public String getUseScope() {
		return "and srv.fg_use_er1 = 'Y'";
	}
}
