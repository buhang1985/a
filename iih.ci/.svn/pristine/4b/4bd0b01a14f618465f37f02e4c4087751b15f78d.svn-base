package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpDrugSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS311 住院签署用药 草药明细信息
 * @author F
 *
 * @date 2019年8月29日下午4:43:29
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpDrugSignHerbElementInfoQuery
 */
public class IpDrugSignHerbElementInfoQuery implements ITransQry{

	private String _id_ors;
	
	public IpDrugSignHerbElementInfoQuery(String id_ors){
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
	 private String getSql(){//【IEPharmOrMmDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 String formatsql=new IpDrugSignSql().getIpDrugSignHerbElementsInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS311 住院签署用药 草药明细信息sql:"+formatsql);
		 return formatsql;
	 }
}
