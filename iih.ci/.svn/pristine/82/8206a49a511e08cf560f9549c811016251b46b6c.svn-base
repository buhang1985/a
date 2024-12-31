package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpTreatSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS303-门诊签署治疗医嘱项目信息
 * @author F
 *
 * @date 2019年8月22日上午11:02:36
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpTreatSignOrdItemInfoQuery
 */
public class OpTreatSignOrdItemInfoQuery implements ITransQry{

	private String _id_ors;
	
	public OpTreatSignOrdItemInfoQuery(String id_ors){
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
	private String getSql(){//【IEOpTreatOrDTO】
		String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		String sql = new OpTreatSignSql().getOpTreatSignOrdItemInfoSql(id_or4sql);
        OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-门诊签署治疗医嘱项目信息sql:"+sql);
        return sql;
	}

}
