package iih.ci.event.ord.bps.sign.op.query;

import iih.ci.event.ord.bps.sign.op.sql.OpDrugSignSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS302 门诊签署 处方/药品 草药成分信息
 * @author F
 *
 * @date 2019年8月22日下午3:25:20
 *
 * @classpath iih.ci.event.ord.bps.sign.op.query.OpDrugSignHerbElementsInfoQuery
 */
public class OpDrugSignHerbElementsInfoQuery implements ITransQry{

	private String _id_preses;
	
	public OpDrugSignHerbElementsInfoQuery(String id_preses){
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
	 private String getSql(){//【IEOpPharmOrMmDTO】
		 String formatsql=new OpDrugSignSql().getOpDrugSignHerbElementsInfoSql();
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_preses)+getFilterSql();
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS302 门诊签署 处方/药品 草药成分信息sql:"+String.format(formatsql, " A1.Id_Pres "+id_or4sql));
		 return String.format(formatsql, " A1.Id_Pres "+id_or4sql);
	 }
	 
	 private String getFilterSql(){
		 return " and (A1.sd_srvtp like '0103%' )";
	 }

}
