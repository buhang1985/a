package iih.ci.event.ord.bps.refund.query;

import iih.ci.event.ord.bps.refund.sql.OpDrugRefundSql;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * BS302门诊退费 药品 西药未退费/B区信息
 * @author F
 *
 * @date 2019年11月19日上午11:37:45
 *
 * @classpath iih.ci.event.ord.bps.refund.query.OpDrugRefundWcInfoQuery
 */
public class OpDrugRefundWcInfoQuery implements ITransQry{

	private String _id_preses;
	
	public OpDrugRefundWcInfoQuery(String id_preses){
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
		 String formatsql=new OpDrugRefundSql().getOpDrugRefundWcInfoSql();
		 String id_pres4sql=OrdEventUtil.getSqlInOrEqualStrs(_id_preses)+getFilterSql();
		 OrdEventLogger.info(this.getClass().getSimpleName(), "BS302门诊退费 药品 西药未退费/B区信息sql:"+String.format(formatsql, "A1.Id_Pres"+id_pres4sql));
		 return String.format(formatsql, "A1.Id_Pres"+id_pres4sql);
	 }
	 
	 private String getFilterSql(){
		 //0184392: BUG:BS302处方信息部分退费时，消息内容不正确
		 return " and (A1.sd_srvtp like '0102%' or A1.sd_srvtp like '0101%') and A1.id_su_bl='"+OrdEventUtil.ID_SU_BL_0+"'";
	 }
}
