package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpOpSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 门诊 手术 签署 就诊信息(手术申请医嘱)
 * @author F
 *
 * @date 2019年8月19日下午1:33:44
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpOpSignEntInfoQuery
 */
public class OpOpSignEntInfoQuery implements ITransQry{

	private String id_ors;
	public OpOpSignEntInfoQuery(String idors) {
		this.id_ors=idors;
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
		//【IEOpOpOrEnDTO】手术就诊信息
		String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(id_ors);
		String formatsql=new OpOpSignSql().getOpOpSignEntInfoSql(id_or4sql);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS007-门诊 手术 签署 就诊信息sql:"+formatsql+"--param:"+OrdEventUtil.ID_SU_BL_1+","+OrdEventUtil.SD_SU_BL);
		return formatsql;
	}

}
