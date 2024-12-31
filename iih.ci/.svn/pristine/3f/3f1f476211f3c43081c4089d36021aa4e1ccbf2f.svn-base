package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpOpSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 门诊 签署 手术医嘱信息IEOperationInfoDTO
 * @author F
 *
 * @date 2019年8月19日下午1:42:31
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpOpSignOperationInfoQuery
 */
public class OpOpSignOperationInfoQuery implements ITransQry{

	private String id_ors;
	public OpOpSignOperationInfoQuery(String id_ors) {
		this.id_ors = id_ors;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		//门诊 签署 手术医嘱信息【IEOperationInfoDTO】
		String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(id_ors);
		String formatsql=new OpOpSignSql().getOpOpSignOperationInfoSql(id_or4sql);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS007-门诊 手术 签署 医嘱信息sql:"+formatsql);
		return formatsql;
	}

}
