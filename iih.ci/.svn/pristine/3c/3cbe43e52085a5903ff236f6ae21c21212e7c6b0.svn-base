package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpDrugSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS311 住院签署用药 就诊信息
 * @author F
 *
 * @date 2019年8月29日下午3:28:34
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpDrugSignEntInfoQuery
 */
public class IpDrugSignEntInfoQuery implements ITransQry{

    private String _id_ors;
	
	public IpDrugSignEntInfoQuery(String id_ors){
		this._id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer var1) {
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
	 private String getSql(){//【IEPharmOrEnDTO】
		 String id_or4sql = OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 String formatsql = new IpDrugSignSql().getIpTreatSignEntInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS311 住院签署用药 就诊信息sql："+formatsql);
		 return formatsql;
	 }
}
