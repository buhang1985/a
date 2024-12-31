package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpTreatSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS303 住院治疗签署 就诊信息
 * @author F
 *
 * @date 2019年8月29日上午11:22:43
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpTreatSignEntInfoQuery
 */
public class IpTreatSignEntInfoQuery implements ITransQry{

	private String _id_or;
	
	public IpTreatSignEntInfoQuery(String id_or){
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
	 private String getSql(){//【IEOpTreatOrEnDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_or);
		 String formatsql = new IpTreatSignSql().getIpTreatSignEntInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS303 住院治疗签署 就诊信息sql:"+formatsql);
		 return formatsql;
	 }
}
