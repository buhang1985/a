package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpLisSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 门诊 检验 签署 就诊信息 IEOpLisOrEnDTO
 * @author F
 *
 * @date 2019年8月19日上午10:14:03
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpLisSignEntInfoQuery
 */
public class OpLisSignEntInfoQuery implements ITransQry{

	private String id_ors;
	public OpLisSignEntInfoQuery(String idors) {
		this.id_ors=idors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		//【IEOpLisOrEnDTO】就诊信息
		String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(id_ors);
		String formatsql=new OpLisSignSql().getOpLisSignEntInfoSql(id_or4sql);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-门诊 检验 签署 就诊信息sql:"+formatsql);
		return formatsql;
	}

}
