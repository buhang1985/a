package iih.ci.event.ord.bps.revert.op.query;

import iih.ci.event.ord.bps.revert.op.sql.OpBtRevertSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS008-备血 门诊撤回 就诊申请信息
 * @author F
 *
 * @date 2019年10月10日上午11:11:40
 *
 * @classpath iih.ci.event.ord.bps.revert.op.query.OpBtRevertEntInfoQuery
 */
public class OpBtRevertEntInfoQuery implements ITransQry{

	private String id_ors;
	
	public OpBtRevertEntInfoQuery(String id_ors){
		this.id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
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
	 private String getSql(){//【IEOpBtOrEnDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(id_ors);
		 String formatsql=new OpBtRevertSql().getOpBtRevertEntInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS008-备血 门诊撤回 就诊申请信息 sql:"+formatsql);
		 return formatsql;
	 }
}
