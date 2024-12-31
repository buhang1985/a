package iih.ci.event.ord.bps.revert.op.query;

import iih.ci.event.ord.bps.revert.op.sql.OpPathRevertSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 门诊 病理 撤回 联系人信息
 * @author F
 *
 * @date 2020年1月19日下午5:58:43
 *
 * @classpath iih.ci.event.ord.bps.revert.op.query.OpPathRevertContacterInfoQuery
 */
public class OpPathRevertContacterInfoQuery implements ITransQry{

	private String id_ors;
	
	public OpPathRevertContacterInfoQuery(String id_ors) {
		this.id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}
	@Override
	public String getQrySQLStr() {
		//门诊 撤回 病理联系人信息【IEOpPathContactDTO】
		String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(id_ors);
		String formatsql=new OpPathRevertSql().getOpPathRevertContacterInfoSql(id_or4sql);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS452-门诊 病理 撤回 联系人信息sql:"+formatsql);
		return formatsql;
	}
}
