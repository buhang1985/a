package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpConSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS318 住院签署 会诊申请就诊信息
 * @author F
 *
 * @date 2019年8月27日下午5:12:45
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpConSignEntInfoQuery
 */
public class IpConSignEntInfoQuery implements ITransQry{

	private String _id_ors;
	
	public IpConSignEntInfoQuery(String id_ors){
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
	 private String getSql(){//【IEOpConsulationDTO】
		 //获得查询条件sql串 含in 或 =
		 String id_or4sql = OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 //主体语句
		 String formatsql = new IpConSignSql().getIpConSignEntInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS318 住院签署 会诊申请就诊信息sql："+formatsql);
		 return formatsql;
	 }
}
