package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpOtherSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS305-其他 住院签署 医嘱信息
 * @author F
 *
 * @date 2019年8月23日下午6:42:39
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpOtherSignOrdInfoQuery
 */
public class IpOtherSignOrdInfoQuery implements ITransQry{

	private String _id_ors;
	
	public IpOtherSignOrdInfoQuery(String id_ors){
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
	 private String getSql(){//【IEOthOrDTO】
		 String formatsql=new IpOtherSignSql().getIpOtherSignOrdInfoSql();
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS305-其他 住院签署 医嘱信息 sql:"+String.format(formatsql, "A.id_or"+id_or4sql));
		 return String.format(formatsql, "A.id_or"+id_or4sql);
	 }

}
