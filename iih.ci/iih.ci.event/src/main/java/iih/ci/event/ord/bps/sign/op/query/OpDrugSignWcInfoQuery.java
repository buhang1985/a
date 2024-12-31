package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpDrugSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS302门诊 签署 处方/药品 西药信息
 * @author F
 *
 * @date 2019年8月22日下午2:25:45
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpDrugSignWcInfoQuery
 */
public class OpDrugSignWcInfoQuery implements ITransQry{

	private String _id_preses;
	
	public OpDrugSignWcInfoQuery(String id_preses){
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
	 private String getSql(){//【IEOpPharmWcOrDTO】
		 String formatsql=new OpDrugSignSql().getOpDrugSignWcInfoSql();
		 String id_pres4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_preses)+getFilterSql();
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS302门诊 签署 处方/药品 西药信息sql:"+String.format(formatsql, "A1.Id_Pres"+id_pres4sql));
		 return String.format(formatsql, "A1.Id_Pres"+id_pres4sql);
	 }
	 
	 private String getFilterSql(){
		 return " and (A1.sd_srvtp like '0102%' or A1.sd_srvtp like '0101%')";
	 }
}
