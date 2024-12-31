package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpOpSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS007  住院 手术 签署
 * @author F
 *
 * @date 2019年8月27日下午3:28:45
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpOpSignEntInfoQuery
 */
public class IpOpSignEntInfoQuery implements ITransQry{

    private String _id_ors;
	
	public IpOpSignEntInfoQuery(String id_ors){
		this._id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam( OrdEventUtil.ID_SU_BL_1 );
		sqlpram.addParam( OrdEventUtil.SD_SU_BL );
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
	 private String getSql(){//【IEOpOpOrEnDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 String formatsql=new IpOpSignSql().getIpOpSignEntInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS007  住院 手术 签署sql:"+formatsql+"param:@@@@AA10000000026638,@@@@ZZ2000000000005S");
		 return formatsql;
	 }
}
