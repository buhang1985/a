package iih.ci.event.ord.bps.repres.op.query;

import iih.ci.event.ord.bps.repres.op.sql.OpDrugRePresSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS302 门诊处方 重新分方就诊信息
 * @author F
 *
 * @date 2019年9月11日上午11:10:50
 *
 * @classpath iih.ci.event.ord.bps.repres.op.query.OpDrugRePresEntInfoQuery
 */
public class OpDrugRePresEntInfoQuery implements ITransQry{

	private String _id_or;
	
	public OpDrugRePresEntInfoQuery(String id_or){
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
		 String sqlString=new OpDrugRePresSql().getOpDrugReDivisionEntInfoSql();
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS302 门诊 重新分方就诊信息sql:"+sqlString+" param:"+this._id_or);
		 return sqlString;
	 }
}
