package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpTreatSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS303 住院治疗签署 医嘱信息
 * @author F
 *
 * @date 2019年8月29日下午1:34:23
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpTreatSignOrdInfoQuery
 */
public class IpTreatSignOrdInfoQuery implements ITransQry{

	private String _id_ors;
	
	public IpTreatSignOrdInfoQuery(String id_ors){
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
	 private String getSql(){//【IEOpTreatOrDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 String formatsql=new IpTreatSignSql().getIpTreatSignOrdInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS303 住院治疗签署 医嘱信息sql："+formatsql);
		 return formatsql;
	 }
}
