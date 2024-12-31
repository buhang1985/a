package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpPathSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院 病理 签署就诊信息
 * @author F
 *
 * @date 2020年1月20日下午1:17:48
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpPathSignEntInfoQuery
 */
public class IpPathSignEntInfoQuery implements ITransQry{

	private String id_ors;
	
	public IpPathSignEntInfoQuery(String id_ors) {
		this.id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}
	@Override
	public String getQrySQLStr() {
		//住院 签署 病理就诊信息【IEIpPathEntDTO】
		String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(id_ors);
		String formatsql=new IpPathSignSql().getIpPathSignEntInfoSql(id_or4sql);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS452-住院 病理 签署就诊信息sql:"+formatsql);
		return formatsql;
	}
}
