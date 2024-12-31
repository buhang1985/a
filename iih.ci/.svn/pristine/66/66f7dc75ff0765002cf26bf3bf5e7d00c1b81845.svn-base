package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpDrugSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS302 门诊 签署 处方/药品 处方(收费/未收费)金额信息
 * @author F
 *
 * @date 2019年8月22日下午3:44:35
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpDrugSignPressPriceInfoQuery
 */
public class OpDrugSignPressPriceInfoQuery implements ITransQry{

	private String _iden;
	
	public OpDrugSignPressPriceInfoQuery(String id_en){
		this._iden = id_en;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam(_iden);
		sqlpram.addParam(OrdEventUtil.ID_SU_BL_1);
		sqlpram.addParam(OrdEventUtil.ID_SU_BL_0);
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
	 private String getSql(){//【IEOpPharmPresDTO】->【IEOpPharmOrFeeDTO】
		 String sqlString=new OpDrugSignSql().getOpDrugSignPressPriceInfoSql();
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS302 门诊 签署 处方/药品 处方(收费/未收费)金额信息sql:"+sqlString+" param:"+this._iden+","+OrdEventUtil.ID_SU_BL_1+","+OrdEventUtil.ID_SU_BL_0);
		 return sqlString;
	 }

}
