package iih.ci.event.ord.bps.charge.op.query;

import iih.ci.event.ord.bps.charge.op.sql.OpOpChargeSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS007 门诊收费手术  助手护士信息
 * @author F
 *
 * @date 2019年9月12日下午5:13:56
 *
 * @classpath iih.ci.event.ord.bps.charge.op.query.OpOpChargeAssistInfoQuery
 */
public class OpOpChargeAssistInfoQuery implements ITransQry{

	private String _id_or;
	
	public OpOpChargeAssistInfoQuery(String id_or){
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
		 String formatsql=new OpOpChargeSql().getOpOpChargeAssistInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS007 门诊收费手术  助手信息sql:"+formatsql);
		 return formatsql;
	 }

}
