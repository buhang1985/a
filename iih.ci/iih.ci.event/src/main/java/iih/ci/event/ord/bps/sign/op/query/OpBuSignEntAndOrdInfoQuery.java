package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpBuSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS309用血门诊签署就诊和医嘱信息
 * @author F
 *
 * @date 2019年8月23日下午1:39:15
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpBuSignEntAndOrdInfoQuery
 */
public class OpBuSignEntAndOrdInfoQuery implements ITransQry{

	private String _id_ors;
	
	public OpBuSignEntAndOrdInfoQuery(String id_ors){
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
	 private String getSql(){//【IEOpBtUseOrDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 String formatsql= new OpBuSignSql().getOpBuSignEntAndOrdInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS309 用血 门诊签署 就诊和医嘱信息sql:"+formatsql);
		 return formatsql;
	 }
}
