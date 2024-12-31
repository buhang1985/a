package iih.bd.srv.medsrv.refs.sql.er;

import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefSrvSQLBuilder;

/**
 * 急诊流水组装物品的参照信息
 * @author liyuelong
 *
 */
public class FlowOrderRefSrvSQLBuilder extends OpOrderRefSrvSQLBuilder{
	@Override
	public String getUseScope() {
		return "and srv.fg_use_er = 'Y'";
	}
}
