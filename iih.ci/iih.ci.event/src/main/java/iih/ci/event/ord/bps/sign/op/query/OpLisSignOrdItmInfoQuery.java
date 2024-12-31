package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpLisSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 *  门诊 检验 签署 医嘱项目信息 IEOpLisOrItmDTO
 * @author F
 *
 * @date 2019年8月19日上午10:14:13
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpLisSignOrdItmInfoSql
 */
public class OpLisSignOrdItmInfoQuery implements ITransQry{

	private String id_ors;
	public OpLisSignOrdItmInfoQuery(String idors) {
		this.id_ors=idors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		//【IEOpLisOrItmDTO】医嘱项目信息
		String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(id_ors);
		String formatsql=new OpLisSignSql().getOpLisSignOrdItmInfoSql(id_or4sql);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-门诊 检验 签署 项目医嘱信息sql:"+formatsql);
		return formatsql;
	}

}
