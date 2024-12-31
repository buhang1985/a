package iih.bd.srv.medsrv.refs.sql.pip;

import iih.bd.srv.medsrv.refs.sql.ip.IpOrderRefSrvSQLBuilder;
/**
 * 组装非物品的参照信息
 * @author zhangwq
 *
 */
public class PipOrderRefSrvSQLBuilder extends IpOrderRefSrvSQLBuilder{
	@Override
	public String getUseScope() {
		return "and srv.fg_use_pip = 'Y'";
	}

	@Override
	public String getPakbasefactorField() {
		return "  '' as pakbasefactor,";
	}
	
}
