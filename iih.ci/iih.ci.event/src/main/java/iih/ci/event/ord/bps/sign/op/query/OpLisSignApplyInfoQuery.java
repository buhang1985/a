package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpLisSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊 检验 签署 申请单信息 IEOpLisOrDTO
 * @author F
 *
 * @date 2019年8月19日上午10:13:52
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpLisSignApplyInfoSql
 */
public class OpLisSignApplyInfoQuery implements ITransQry{

private String id_ors;
	
	public OpLisSignApplyInfoQuery(String id_ors){
		this.id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam(OrdEventUtil.ID_SU_BL_1); 
		sqlpram.addParam(OrdEventUtil.SD_SU_BL);
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		 //【IEOpLisOrDTO】申请信息
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(id_ors);
		 String formatsql=new OpLisSignSql().getOpLisSignApplyInfoSql(id_or4sql);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-门诊 检验 签署 申请单信息sql:"+formatsql+"--param:"+OrdEventUtil.ID_SU_BL_1+","+OrdEventUtil.SD_SU_BL);
		 return formatsql;
	}

}
