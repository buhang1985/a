package iih.bd.srv.medsrv.refs.sql.ip;

import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefMMSQLBuilder;
import xap.sie.common.utils.StringUtils;
/**
 * 组装物品的参照信息
 * @author zhangwq
 *
 */
public class IpOrderRefMMSQLBuilder extends OpOrderRefMMSQLBuilder{
	@Override
	public String getCodeEntp() {
		return "10";
	}
	@Override
	public String getUseScope(String alias) {
		if(StringUtils.isEmpty(alias)){
			return "and fg_use_ip = 'Y' ";
		}
		return "and "+alias+".fg_use_ip='Y' ";
	}
	@Override
	public String getMmpkugtp() {
		return "and mmpkug.en_ippkgtp is not null ";
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
