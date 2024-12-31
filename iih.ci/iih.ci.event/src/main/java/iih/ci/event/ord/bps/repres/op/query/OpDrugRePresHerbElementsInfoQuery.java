package iih.ci.event.ord.bps.repres.op.query;

import iih.ci.event.ord.bps.repres.op.sql.OpDrugRePresSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS302 门诊 重新分方 草药成分信息
 * @author F
 *
 * @date 2019年9月11日上午11:10:28
 *
 * @classpath iih.ci.event.ord.bps.repres.op.query.OpDrugRePresHerbElementsInfoQuery
 */
public class OpDrugRePresHerbElementsInfoQuery implements ITransQry{

	private String _id_preses;
	
	public OpDrugRePresHerbElementsInfoQuery(String id_preses){
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
		 String formatsql=new OpDrugRePresSql().getOpDrugReDivisionHerbElementsInfoSql();
		 String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_preses)+getFilterSql();
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS302 门诊 重新分方 草药成分信息sql:"+String.format(formatsql, " A1.Id_Pres "+id_or4sql));
		 return String.format(formatsql, " A1.Id_Pres "+id_or4sql);
	 }
	 
	 private String getFilterSql(){
		 return " and (A1.sd_srvtp like '0103%' )";
	 }

}
