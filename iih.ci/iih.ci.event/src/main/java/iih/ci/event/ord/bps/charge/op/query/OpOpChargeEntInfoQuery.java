package iih.ci.event.ord.bps.charge.op.query;

import iih.ci.event.ord.bps.charge.op.sql.OpOpChargeSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS007 门诊手术收费 就诊信息
 * @author F
 *
 * @date 2019年9月12日下午4:55:27
 *
 * @classpath iih.ci.event.ord.bps.charge.op.query.OpOpChargeEntInfoQuery
 */
public class OpOpChargeEntInfoQuery implements ITransQry{

	private String _id_ors;
	
	public OpOpChargeEntInfoQuery(String id_ors){
		this._id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam( OrdEventUtil.ID_SU_BL_1 );
		sqlpram.addParam( OrdEventUtil.SD_SU_BL );
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
	 private String getSql(){//【IEOpOpOrEnDTO】
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_ors);
		 String formatsql=new OpOpChargeSql().getOpOpChargeEntInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS007 门诊手术收费 就诊信息sql:"+formatsql+"param:"+"@@@@AA10000000026638,@@@@ZZ2000000000005S");
		 return formatsql;
	 }
}
