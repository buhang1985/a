package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpNsSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS304 住院护理签署 就诊信息
 * @author F
 *
 * @date 2019年8月28日下午3:11:12
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpNsSignEntInfoQuery
 */
public class IpNsSignEntInfoQuery implements ITransQry{

	private String _id_or;
	
	public IpNsSignEntInfoQuery(String id_or){
		this._id_or = id_or;
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
	 private String getSql(){//【IENsOrEnDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_or);
		 String sqlString=new IpNsSignSql().getIpOpSignEntInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS304 住院护理签署 就诊信息sql:"+sqlString);
		 return sqlString;
	 }
}
