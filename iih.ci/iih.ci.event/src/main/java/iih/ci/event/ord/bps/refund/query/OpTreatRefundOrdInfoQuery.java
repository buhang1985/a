package iih.ci.event.ord.bps.refund.query;

import iih.ci.event.ord.bps.refund.sql.OpTreatRefundSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS303门诊治疗退费 医嘱信息
 * @author F
 *
 * @date 2019年9月17日下午4:17:38
 *
 * @classpath iih.ci.event.ord.bps.refund.query.OpTreatRefundOrdInfoQuery
 */
public class OpTreatRefundOrdInfoQuery implements ITransQry{

	private String _id_ors;
	private String _id_orsrvs;
	
	public OpTreatRefundOrdInfoQuery(String id_ors,String id_orsrvs){
		this._id_ors = id_ors;
		this._id_orsrvs=id_orsrvs;
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
		String fString=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		String idorsrvString=OrdEventUtil.getSqlInOrEqualStrs(_id_orsrvs);
		String sql = new OpTreatRefundSql().getOpTreatRefundOrdInfoSql(fString,idorsrvString);
        OrdEventLogger.info(this.getClass().getSimpleName(), "BS303门诊治疗退费 医嘱信息sql:"+sql);
        return sql;
	}
}
