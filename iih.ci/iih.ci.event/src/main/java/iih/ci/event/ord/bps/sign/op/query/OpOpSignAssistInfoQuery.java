package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpOpSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 门诊 签署 手术 助手信息IESugAssistDTO
 * @author F
 *
 * @date 2019年8月19日下午1:43:50
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpOpSignAssistInfoQuery
 */
public class OpOpSignAssistInfoQuery implements ITransQry{

	private String id_ors;
	public OpOpSignAssistInfoQuery(String idors) {
		this.id_ors=idors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		//门诊 签署 手术 助手信息【IESugAssistDTO】
		String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(id_ors);
		String formatsql=new OpOpSignSql().getOpOpSignAssistInfoSql(id_or4sql);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS007-门诊 手术 签署助手信息sql:"+formatsql);
		return formatsql;
	}

}
