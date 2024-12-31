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
 * @date 2019年8月22日下午4:27:43
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpDrugSignWcRefundInfoQuery
 */
public class OpDrugSignWcRefundInfoQuery implements ITransQry{

	private String _id_preses;
	private String _id_orsrvs;
	
	public OpDrugSignWcRefundInfoQuery(String id_preses,String id_orsrvs){
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
		 String formatsql=new OpDrugSignSql().getOpDrugSignWcRefundInfoSql();
		 String id_pres4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_preses)+getFilterSql();
		 String id_orsrvs4sql = OrdEventUtil.getSqlInOrEqualStrs(_id_orsrvs);
		 OrdEventLogger.info(this.getClass().getSimpleName(), "西药Refund信息sql："+String.format(formatsql, " A1.Id_Pres"+id_pres4sql+" and A1.id_orsrv " + id_orsrvs4sql));
		 return String.format(formatsql, " A1.Id_Pres"+id_pres4sql+" and A1.id_orsrv " + id_orsrvs4sql);
	 }
	 
	 private String getFilterSql(){
		 return " and (A1.sd_srvtp like '0102%' or A1.sd_srvtp like '0101%')";
	 }
	 
}
