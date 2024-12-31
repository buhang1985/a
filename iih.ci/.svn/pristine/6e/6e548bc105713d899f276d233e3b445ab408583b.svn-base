package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpDrugSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS302 门诊签署 处方/药品 就诊信息
 * @author F
 *
 * @date 2019年8月22日上午11:44:02
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpDrugSignEntInfoQuery
 */
public class OpDrugSignEntInfoQuery implements ITransQry{

	private String _id_or;
	
	public OpDrugSignEntInfoQuery(String id_or){
		this._id_or = id_or;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam(this._id_or);
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
	 private String getSql(){//【IEOpPharmOrEnDTO】
		 String sqlString=new OpDrugSignSql().getOpDrugSignEntInfoSql();
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS302 门诊签署 处方/药品 就诊信息sql:"+sqlString+" param:"+this._id_or);
		 return sqlString;
	 }
}
