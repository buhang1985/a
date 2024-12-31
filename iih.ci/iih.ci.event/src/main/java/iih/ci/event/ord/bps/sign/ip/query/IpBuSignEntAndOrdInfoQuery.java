package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpBuSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS309 住院签署 用血 就诊和医嘱信息
 * @author F
 *
 * @date 2019年8月28日下午1:26:07
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpBuSignEntAndOrdInfoSql
 */
public class IpBuSignEntAndOrdInfoQuery implements ITransQry{

	private String _id_ors;
	
	public IpBuSignEntAndOrdInfoQuery(String id_ors){
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
	 private String getSql(){//【IEOpBtUseOrDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 String formatsql= new IpBuSignSql().getIpBuSignEntAndOrdInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS309 住院签署 用血 就诊和医嘱信息sql:"+formatsql);
		 return formatsql;
	 }
}
