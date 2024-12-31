package iih.ci.event.ord.bps.revert.op.query;

import iih.ci.event.ord.bps.revert.op.sql.OpTreatRevertSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS303门诊治疗撤回 就诊信息
 * @author F
 *
 * @date 2019年9月11日上午11:58:33
 *
 * @classpath iih.ci.event.ord.bps.revert.op.query.OpTreatRevertEntInfoQuery
 */
public class OpTreatRevertEntInfoQuery implements ITransQry{

    private String _id_ors;
	
	public OpTreatRevertEntInfoQuery(String id_ors){
		this._id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}
   
	/**
	 * 获得查询sql串
	 * @return
	 */
	private String getSql(){
		 String fString=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 String sql = new OpTreatRevertSql().getOpTreatWithDrawEntInfoSql(fString);
 		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS303门诊治疗撤回 就诊信息sql："+sql);
         return sql;
		 
	 }
}
