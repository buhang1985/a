package iih.ci.event.ord.bps.sign.ip.query;

import iih.ci.event.ord.bps.sign.ip.sql.IpOpSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS007 住院手术签署 助手护士信息
 * @author F
 *
 * @date 2019年8月27日下午3:34:13
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.query.IpOpSignAssistInfoQuery
 */
public class IpOpSignAssistInfoQuery implements ITransQry{

	private String _id_or;
	
	public IpOpSignAssistInfoQuery(String id_or){
		this._id_or = id_or;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		return  getSql();
	}
	
	/**
	 * 获得查询sql串
	 * @return
	 */
	 private String getSql(){//【IESugAssistDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_or);
		 String formatsql= new IpOpSignSql().getIpOpSignAssistInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS007 住院手术签署 助手护士信息  sql:"+formatsql);
		 return formatsql;
	 }
}
