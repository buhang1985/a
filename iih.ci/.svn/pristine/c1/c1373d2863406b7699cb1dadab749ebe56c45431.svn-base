package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpRisSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS002-住院 签署 检查 联系人
 * @author F
 *
 * @date 2019年8月27日上午11:46:17
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpRisSignContacterQuery
 */
public class IpRisSignContacterQuery implements ITransQry{
	
	private String _id_ors;
	
	public IpRisSignContacterQuery(String id_ors) {
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
	
	private String getSql() {//【IEOpRisOrContacterDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 String formatsql=new IpRisSignSql().getIpRisSignContacterInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS002-住院 签署 检查 联系人sql:"+formatsql);
		 return formatsql;
	}
}
