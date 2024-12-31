package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpDrugSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 暂不清楚作用
 * @author F
 *
 * @date 2019年8月22日下午4:56:20
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpDrugSignHerbRefundInfoQuery
 */
public class OpDrugSignHerbRefundInfoQuery implements ITransQry{

	private String _id_preses;
	private String _id_orsrvs;
	
	public OpDrugSignHerbRefundInfoQuery(String id_preses,String id_orsrvs){
		this._id_preses = id_preses;
		this._id_orsrvs = id_orsrvs;
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
		 String formatsql=new OpDrugSignSql().getOpDrugSignHerbRefundInfoSql();
		 String id_pres4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_preses)+getFilterSql();
		 String id_orsrvs4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_orsrvs);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "草药refund信息sql："+String.format(formatsql, "A1.Id_Pres"+id_pres4sql+ " and A1.Id_orsrv"+id_orsrvs4sql));
		 return String.format(formatsql, "A1.Id_Pres"+id_pres4sql+ " and A1.Id_orsrv"+id_orsrvs4sql);
	 }
	 
	 private String getFilterSql(){
		 return " and (A1.sd_srvtp like '0103%' )";
	 }
}
