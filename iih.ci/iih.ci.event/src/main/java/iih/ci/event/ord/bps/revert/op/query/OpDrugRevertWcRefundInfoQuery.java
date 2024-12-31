package iih.ci.event.ord.bps.revert.op.query;

import iih.ci.event.ord.bps.revert.op.sql.OpDrugRevertSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 西药Refund信息 暂不清楚作用
 * @author F
 *
 * @date 2019年9月11日上午11:59:48
 *
 * @classpath iih.ci.event.ord.bps.revert.op.query.OpDrugRevertWcRefundInfoQuery
 */
public class OpDrugRevertWcRefundInfoQuery implements ITransQry{

	private String _id_preses;
	private String _id_orsrvs;
	
	public OpDrugRevertWcRefundInfoQuery(String id_preses,String id_orsrvs){
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
	 private String getSql(){//【IEOpPharmWcOrDTO】
		 String formatsql=new OpDrugRevertSql().getOpDrugWithDrawWcRefundInfoSql();
		 String id_pres4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_preses)+getFilterSql();
		 String id_orsrvs4sql = OrdEventUtil.getSqlInOrEqualStrs(_id_orsrvs);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "西药Refund信息sql："+String.format(formatsql, " A1.Id_Pres"+id_pres4sql+" and A1.id_orsrv " + id_orsrvs4sql));
		 return String.format(formatsql, " A1.Id_Pres"+id_pres4sql+" and A1.id_orsrv " + id_orsrvs4sql);
	 }
	 
	 private String getFilterSql(){
		 return " and (A1.sd_srvtp like '0102%' or A1.sd_srvtp like '0101%')";
	 }
}
