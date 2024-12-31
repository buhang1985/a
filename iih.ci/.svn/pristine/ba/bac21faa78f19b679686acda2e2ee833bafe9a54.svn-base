package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpBtSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 住院备血签署 所有信息
 * @author F
 *
 * @date 2019年8月28日上午11:37:23
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpBtSignInfoQuery
 */
public class IpBtSignInfoQuery implements ITransQry{

	private String _id_ors;
	
	public IpBtSignInfoQuery(String id_ors){
		this._id_ors = id_ors;
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
	 * 获得查询sql串
	 * @return
	 */
	 private String getSql(){//【IEOpBtOrEnDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 String formatsql=new IpBtSignSql().getIpBtSignInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS008  住院备血签署 所有信息sql："+formatsql);
		 return formatsql;
	 }
}
