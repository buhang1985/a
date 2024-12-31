package iih.bd.srv.medsrv.refs.sql.pip;

import iih.bd.srv.medsrv.refs.sql.ip.IpOrderRefMMSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefMMSQLBuilder;
import xap.sie.common.utils.StringUtils;
/**
 * 组装物品的参照信息
 * @author zhangwq
 *
 */
public class PipOrderRefMMSQLBuilder extends IpOrderRefMMSQLBuilder{
	@Override
	public String getCodeEntp() {
		return "11";
	}
	@Override
	public String getUseScope(String alias) {
		if(StringUtils.isEmpty(alias)){
			return "and fg_use_pip = 'Y' ";
		}
		return "and "+alias+".fg_use_pip='Y' ";
	}
	@Override
	public String getMmpkugtp() {
		return "and mmpkug.EN_PIPPKGTP is not null ";
	}
	@Override
	public String getPakbasefactorField() {
		return " '' as pakbasefactor,";
	}
	@Override
	public String getMMPakbasefactorField() {
		return " '' as pakbasefactor,";
	}
	
}
