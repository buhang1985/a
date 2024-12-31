package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpOtherSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS305-其他 住院签署 就诊信息
 * @author F
 *
 * @date 2019年8月23日下午6:29:30
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpOtherSignEntInfoQuery
 */
public class IpOtherSignEntInfoQuery implements ITransQry{

	private String _id_or;
	
	public IpOtherSignEntInfoQuery(String id_or){
		this._id_or = id_or;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam(_id_or);
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
	 private String getSql(){//【IEOthOrEnDTO】
		 String sqlString=new IpOtherSignSql().getIpOtherSignEntInfoSql();
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS305-其他 住院签署 就诊信息 sql:"+sqlString+"param:"+_id_or);
		 return sqlString;
	 }
}
