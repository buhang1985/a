package iih.ci.event.ord.bps.charge.op.query;

import iih.ci.event.ord.bps.charge.op.sql.OpTreatChargeSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS303门诊收费治疗 医嘱项目信息
 * @author F
 *
 * @date 2019年9月12日下午6:14:31
 *
 * @classpath iih.ci.event.ord.bps.charge.op.query.OpTreatChargeOrdItemInfoQuery
 */
public class OpTreatChargeOrdItemInfoQuery implements ITransQry{

	private String[] _id_ors;
	
	public OpTreatChargeOrdItemInfoQuery(String id_ors){
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
	private String getSql(){//【IEOpTreatOrDTO】
		String sql = new OpTreatChargeSql().getOpTreatChargeOrdItemInfoSql();
		String sqlwhere="";
        for(String idor:_id_ors){
            sqlwhere+=",?";
           }
        sql=String.format(sql, sqlwhere.substring(1));
        OrdEventLogger.info(this.getClass().getSimpleName(), "BS303门诊收费治疗 医嘱项目信息sql:"+sql+"--param:"+sqlwhere);
        return sql;
	}

}
