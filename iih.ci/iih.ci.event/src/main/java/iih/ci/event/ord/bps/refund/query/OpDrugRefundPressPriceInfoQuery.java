package iih.ci.event.ord.bps.refund.query;

import iih.ci.event.ord.bps.refund.sql.OpDrugRefundSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS302 门诊 退费 药品 B区/未退费金额信息
 * @author F
 *
 * @date 2019年11月19日下午3:29:07
 *
 * @classpath iih.ci.event.ord.bps.refund.query.OpDrugRefundPressPriceInfoQuery
 */
public class OpDrugRefundPressPriceInfoQuery implements ITransQry{

	private String _press;
	
	public OpDrugRefundPressPriceInfoQuery(String press){
		this._press = press;
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
	 private String getSql(){//【IEOpPharmPresDTO】
		 String press = OrdEventUtil.getSqlInOrEqualStrs(_press);
		 String sqlString=new OpDrugRefundSql().getOpDrugRefundPressPriceInfoSql(press);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS302 门诊 退费 药品 B区/未退费金额信息sql:"+sqlString+" param:"+this._press);
		 return sqlString;
	 }

}
