package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpNsSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS304 住院护理签署 医嘱信息
 * @author F
 *
 * @date 2019年8月28日下午3:53:18
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpNsSignOrdInfoQuery
 */
public class IpNsSignOrdInfoQuery implements ITransQry{

	private String _id_ors;
	
	public IpNsSignOrdInfoQuery(String id_ors){
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
   
	/**
	 * 获得查询sql串
	 * @return
	 */
	 private String getSql(){//【IENsOrDTO】
		 String formatsql= new IpNsSignSql().getIpOpSignOrdInfoSql();
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS304 住院护理签署 医嘱信息sql:"+String.format(formatsql, "A.id_or"+id_or4sql));
		 return String.format(formatsql, "A.id_or"+id_or4sql);
	 }
}
