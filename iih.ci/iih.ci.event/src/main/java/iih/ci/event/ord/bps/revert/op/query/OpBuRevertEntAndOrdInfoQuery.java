package iih.ci.event.ord.bps.revert.op.query;

import iih.ci.event.ord.bps.revert.op.sql.OpBuRevertSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS309 用血 门诊撤回 就诊和医嘱信息
 * @author F
 *
 * @date 2019年10月10日下午2:10:46
 *
 * @classpath iih.ci.event.ord.bps.revert.op.query.OpBuRevertEntAndOrdInfoQuery
 */
public class OpBuRevertEntAndOrdInfoQuery implements ITransQry{

	private String _id_ors;
	
	public OpBuRevertEntAndOrdInfoQuery(String id_ors){
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
	 private String getSql(){//【IEOpBtUseOrDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 String formatsql= new OpBuRevertSql().getOpBuRevertEntAndOrdInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS309 用血 门诊撤回 就诊和医嘱信息sql:"+formatsql);
		 return formatsql;
	 }
}
