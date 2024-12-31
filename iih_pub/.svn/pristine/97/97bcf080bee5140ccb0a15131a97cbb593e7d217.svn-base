package iih.bd.srv.medsrv.refs.sql.er;

import iih.bd.srv.medsrv.refs.sql.ip.IpOrderRefSrvSQLBuilder;

/**
 * 急诊留观组装物品的参照信息
 * @author liyuelong
 *
 */
public class ObsOrderRefSrvSQLBuilder extends IpOrderRefSrvSQLBuilder{
	@Override
	public String getUseScope() {
		return "and srv.fg_use_er2 = 'Y'";
	}

	@Override
	public String getPakbasefactorField() {
		return "  '' as pakbasefactor,";
	}
}
