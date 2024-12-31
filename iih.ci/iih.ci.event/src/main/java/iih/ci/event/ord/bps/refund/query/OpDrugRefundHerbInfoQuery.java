package iih.ci.event.ord.bps.refund.query;

import iih.ci.event.ord.bps.refund.sql.OpDrugRefundSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS302门诊 退费 药品 草药未退费/B区信息
 * @author F
 *
 * @date 2019年11月19日上午11:49:17
 *
 * @classpath iih.ci.event.ord.bps.refund.query.OpDrugRefundHerbInfoQuery
 */
public class OpDrugRefundHerbInfoQuery implements ITransQry{

	private String _id_preses;
	
	public OpDrugRefundHerbInfoQuery(String id_preses){
		this._id_preses = id_preses;
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
	 private String getSql(){//【IEOpPharmHerbOrDTO】
		 String formatsql=new OpDrugRefundSql().getOpDrugRefundHerbInfoSql();
		 String id_pres4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_preses)+getFilterSql();
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS302门诊 退费 药品 草药未退费/B区信息sql:"+String.format(formatsql, "A1.Id_Pres"+id_pres4sql));
		 return String.format(formatsql, "A1.Id_Pres"+id_pres4sql);
	 }
	 
	 private String getFilterSql(){
		 return " and (A1.sd_srvtp like '0103%' )";
	 }

}
