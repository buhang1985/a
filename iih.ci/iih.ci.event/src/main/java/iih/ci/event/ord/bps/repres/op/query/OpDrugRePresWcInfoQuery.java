package iih.ci.event.ord.bps.repres.op.query;

import iih.ci.event.ord.bps.repres.op.sql.OpDrugRePresSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS302门诊 重新分方  西药信息
 * @author F
 *
 * @date 2019年9月11日上午11:09:22
 *
 * @classpath iih.ci.event.ord.bps.repres.op.query.OpDrugRePresWcInfoQuery
 */
public class OpDrugRePresWcInfoQuery implements ITransQry{

	private String _id_preses;
	
	public OpDrugRePresWcInfoQuery(String id_preses){
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
		 String formatsql=new OpDrugRePresSql().getOpDrugReDivisionWcInfoSql();
		 String id_pres4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_preses)+getFilterSql();
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS302门诊 重新分方  西药信息sql:"+String.format(formatsql, "A1.Id_Pres"+id_pres4sql));
		 return String.format(formatsql, "A1.Id_Pres"+id_pres4sql);
	 }
	 
	 private String getFilterSql(){
		 return " and (A1.sd_srvtp like '0102%' or A1.sd_srvtp like '0101%')";
	 }
}
