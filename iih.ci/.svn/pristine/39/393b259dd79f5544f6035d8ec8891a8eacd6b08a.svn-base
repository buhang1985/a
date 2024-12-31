package iih.ci.event.ord.bps.repres.op.query;

import iih.ci.event.ord.bps.repres.op.sql.OpDrugRePresSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS302门诊处方 重新分方  处方(收费/未收费)信息
 * @author F
 *
 * @date 2019年9月11日上午11:09:47
 *
 * @classpath iih.ci.event.ord.bps.repres.op.query.OpDrugRePresPressInfoQuery
 */
public class OpDrugRePresPressInfoQuery implements ITransQry{

	private String _iden;
	
	public OpDrugRePresPressInfoQuery(String id_en){
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
	 private String getSql(){//【IEOpPharmPresDTO】
		 String sqlString=new OpDrugRePresSql().getOpDrugReDivisonPressInfoSql();
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS302门诊 重新分方  处方(收费/未收费)信息sql:"+sqlString+" param:"+this._iden+","+OrdEventUtil.ID_SU_BL_1+","+OrdEventUtil.ID_SU_BL_0);
		 return sqlString;
	 }

}
