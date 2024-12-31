package iih.ci.event.ord.bps.cancel.ip.query;

import iih.ci.event.ord.bps.cancel.ip.sql.IpCancelSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS005 住院 作废信息
 * @author F
 *
 * @date 2019年9月11日上午10:17:31
 *
 * @classpath iih.ci.event.ord.bps.cancel.ip.query.IpCancelInfoQuery
 */
public class IpCancelInfoQuery implements ITransQry{


	private String _id_ors;
	
	public IpCancelInfoQuery(String id_ors){
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
		String formatsql= new IpCancelSql().getIpInvalidSql(id_or4sql);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS005 住院 作废信息sql:"+formatsql);
		return formatsql;
	}
}
