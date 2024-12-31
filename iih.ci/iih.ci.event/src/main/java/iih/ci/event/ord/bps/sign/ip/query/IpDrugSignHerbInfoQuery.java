package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpDrugSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS311 住院签署用药 草药信息
 * @author F
 *
 * @date 2019年8月29日下午4:34:09
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpDrugSignHerbInfoQuery
 */
public class IpDrugSignHerbInfoQuery implements ITransQry{

	private String _id_ors;
	
	public IpDrugSignHerbInfoQuery(String id_ors){
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
	 private String getSql(){//【IEPharmHerbOrDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 String formatsql = new IpDrugSignSql().getIpDrugSignHerbInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS311 住院签署用药 草药信息 sql:"+formatsql);
		 return formatsql;
	 }

}
