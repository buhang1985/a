package iih.bd.srv.medsrv.refs.sql.ip;

import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefSrvSQLBuilder;
/**
 * 组装非物品的参照信息
 * @author zhangwq
 *
 */
public class IpOrderRefSrvSQLBuilder extends OpOrderRefSrvSQLBuilder{
	@Override
	public String getUseScope() {
		return "and srv.fg_use_ip = 'Y'";
	}

	@Override
	public String getPakbasefactorField() {
		return "  '' as pakbasefactor,";
	}
	
}
