package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpPathSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊 病理 签署 联系人信息
 * @author F
 *
 * @date 2020年1月16日下午6:31:31
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpPathSignContacterInfoQuery
 */
public class OpPathSignContacterInfoQuery implements ITransQry{
	
	private String id_ors;
	
	public OpPathSignContacterInfoQuery(String id_ors) {
		this.id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}
	@Override
	public String getQrySQLStr() {
		//门诊 签署 病理联系人信息【IEOpPathContactDTO】
		String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(id_ors);
		String formatsql=new OpPathSignSql().getOpPathSignContacterInfoSql(id_or4sql);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS452-门诊 病理 签署 联系人信息sql:"+formatsql);
		return formatsql;
	}

}
