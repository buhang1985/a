package iih.ci.event.ord.bps.charge.op.query;

import iih.ci.event.ord.bps.charge.op.sql.OpTreatChargeSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS303门诊 治疗收费 就诊信息
 * @author F
 *
 * @date 2019年9月12日下午6:07:16
 *
 * @classpath iih.ci.event.ord.bps.charge.op.query.OpTreatChargeEntInfoQuery
 */
public class OpTreatChargeEntInfoQuery implements ITransQry{

	private String[] _id_ors;
	
	public OpTreatChargeEntInfoQuery(String id_ors){
		String[] idOrs = id_ors.split(",");
		this._id_ors = idOrs;
		
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		for (String idOr : _id_ors) {
			sqlpram.addParam(idOr);
		}
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
	 @SuppressWarnings("unused")
	private String getSql(){//【IEOpTreatOrEnDTO】
		 String sql = new OpTreatChargeSql().getOpTreatChargeEntInfoSql();
		 String sqlwhere="";
         for(String idor:_id_ors){
             sqlwhere+=",?";
            }
         sql=String.format(sql, sqlwhere.substring(1));
 		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS303门诊 治疗收费 就诊信息sql："+sql+"--param:"+sqlwhere);
         return sql;
		 
	 }
}
