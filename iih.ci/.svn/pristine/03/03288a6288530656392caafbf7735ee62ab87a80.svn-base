package iih.ci.event.ord.bps.revert.op.query;

import iih.ci.event.ord.bps.revert.op.sql.OpConRevertSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS318 门诊撤回会诊 申请部门信息
 * @author F
 *
 * @date 2019年11月19日下午4:37:34
 *
 * @classpath iih.ci.event.ord.bps.revert.op.query.OpConRevertDeptInfoQuery
 */
public class OpConRevertDeptInfoQuery implements ITransQry{

	private String _id_ors;
	
	public OpConRevertDeptInfoQuery(String id_ors){
		this._id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer var1) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}
	/**
	 * 获得查询sql串
	 * @return
	 */
	 private String getSql(){//【IEOpOpConsultationDeptDTO】
		 //获得查询条件sql串 含in 或 =
		 String id_or4sql = OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 //主体语句
		 String formatsql = new OpConRevertSql().getOpConDeptInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS318 门诊撤回会诊 申请部门信息sql:"+formatsql);
		 return formatsql;
	 }
}
