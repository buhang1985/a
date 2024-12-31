package iih.bd.srv.medsrv.refs.sql.er;

import iih.bd.srv.medsrv.refs.sql.ip.IpOrderRefMMSQLBuilder;
import xap.sie.common.utils.StringUtils;
/**
 * 急诊留观组装物品的参照信息
 * @author liyuelong
 *
 */
public class ObsOrderRefMMSQLBuilder extends IpOrderRefMMSQLBuilder{
	@Override
	public String getCodeEntp() {
		return "'0103'";
	}
	@Override
	public String getUseScope(String alias) {
		if(StringUtils.isEmpty(alias)){
			return "and fg_use_er2 = 'Y' ";
		}
		return "and "+alias+".fg_use_er2='Y' ";
	}
	@Override
	public String getMmpkugtp() {
		return "and mmpkug.en_er2pkgtp is not null ";
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
