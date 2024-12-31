package iih.ci.event.ord.bps.stop.ip.query;

import iih.ci.event.ord.bps.stop.ip.sql.IpStopSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS005 住院 停止信息
 * @author F
 *
 * @date 2019年9月3日上午11:44:19
 *
 * @classpath iih.ci.event.ord.bps.stop.ip.query.IpStopInfoQuery
 */
public class IpStopInfoQuery implements ITransQry{


	private String _id_ors;
	
	public IpStopInfoQuery(String id_ors){
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
	 * 获得 SQL串 
	 * @param id_or
	 * @return
	 */
	private String getSql(){//【IEOrCancStpEnDTO】【IEOrCancStpDTO】
		String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		String formatsql= new IpStopSql().getIpStopSql(id_or4sql);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS005 住院 停止信息sql:"+formatsql);
		return formatsql;
	}
}
