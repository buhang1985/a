package iih.bd.srv.medsrv.refs.sql.er;

import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefMMSQLBuilder;
import xap.sie.common.utils.StringUtils;
/**
 * 急诊流水组装物品的参照信息
 * @author liyuelong
 *
 */
public class FlowOrderRefMMSQLBuilder extends OpOrderRefMMSQLBuilder{
	@Override
	public String getCodeEntp() {
		return "'0101'";
	}
	@Override
	public String getUseScope(String alias) {
		if(StringUtils.isEmpty(alias)){
			return "and fg_use_er = 'Y' ";
		}
		return "and "+alias+".fg_use_er='Y' ";
	}
	@Override
	public String getMmpkugtp() {
		return "and mmpkug.en_erpkgtp is not null ";
	}
}
