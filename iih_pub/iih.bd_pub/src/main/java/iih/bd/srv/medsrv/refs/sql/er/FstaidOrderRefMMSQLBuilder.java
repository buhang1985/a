package iih.bd.srv.medsrv.refs.sql.er;

import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefMMSQLBuilder;
import xap.sie.common.utils.StringUtils;
/**
 * 急诊抢救组装物品的参照信息
 * @author liyuelong
 *
 */
public class FstaidOrderRefMMSQLBuilder extends OpOrderRefMMSQLBuilder{
	@Override
	public String getCodeEntp() {
		return "'0102'";
	}
	@Override
	public String getUseScope(String alias) {
		if(StringUtils.isEmpty(alias)){
			return "and fg_use_er1 = 'Y' ";
		}
		return "and "+alias+".fg_use_er1='Y' ";
	}
	@Override
	public String getMmpkugtp() {
		return "and mmpkug.en_er1pkgtp is not null ";
	}
}
