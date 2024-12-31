package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpDrugSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS302门诊 签署 处方/药品 处方(收费/未收费)信息
 * @author F
 *
 * @date 2019年8月22日下午1:25:41
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpDrugSignPressInfoQuery
 */
public class OpDrugSignPressInfoQuery implements ITransQry{

	private String _id_or;
	
	public OpDrugSignPressInfoQuery(String id_or){
		this._id_or = id_or;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam(_id_or);
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
	 private String getSql(){//【IEOpPharmPresDTO】
		 String sqlString=new OpDrugSignSql().getOpDrugSignPressInfoSql();
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS302门诊 签署 处方/药品 处方(收费/未收费)信息sql:"+sqlString+" param:"+this._id_or+","+OrdEventUtil.ID_SU_BL_1+","+OrdEventUtil.ID_SU_BL_0);
		 return sqlString;
	 }

}
