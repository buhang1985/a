package iih.ci.event.ord.bps.charge.op.query;

import iih.ci.event.ord.bps.charge.op.sql.OpLisChargeSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS006 门诊检验收费 所有信息
 * @author F
 *
 * @date 2019年9月11日下午6:37:46
 *
 * @classpath iih.ci.event.ord.bps.charge.op.query.OpLisChargeAllInfoQuery
 */
public class OpLisChargeAllInfoQuery implements ITransQry{

	private String _id_ors;
	
	public OpLisChargeAllInfoQuery(String id_ors){
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
	 private String getSql(){//就诊1【IEOpLisOrEnDTO】 2申请单【IEOpLisOrDTO】 3医嘱项目【IEOpLisOrItmDTO】
		 String formatsql=new OpLisChargeSql().getIpLisChargeAllInfoSql();
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS006 门诊检验收费 所有信息sql:"+String.format(formatsql, " A.id_or "+id_or4sql));
		 return String.format(formatsql, " A.id_or "+id_or4sql);
	 }
}
