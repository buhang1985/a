package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpOpSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS007 住院手术签署 医嘱信息
 * @author F
 *
 * @date 2019年8月27日下午3:31:38
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpOpSignOperationInfoQuery
 */
public class IpOpSignOperationInfoQuery implements ITransQry{

	private String id_ors;

	public IpOpSignOperationInfoQuery(String id_ors) {
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
	 * 获取手术医嘱
	 * @return
	 */
	public String getSql() {//【IEOperationInfoDTO】
		String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(id_ors);
		String formatsql=new IpOpSignSql().getIpOpSignOperationInfoSql(id_or4sql);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS007 住院手术签署 医嘱信息  sql:"+formatsql);
		return formatsql;
	}
}
