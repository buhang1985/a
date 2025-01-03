package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.CiIEMsgRelSqlConst;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiPharmOpRefundHerbOrQry implements ITransQry {

	private String _id_preses;
	private String _id_orsrvs;
	
	public CiPharmOpRefundHerbOrQry(String id_preses,String id_orsrvs){
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
	 private String getSql(){//IEOpPharmHerbOrDTO
		 String formatsql=new CiIEMsgRelSqlConst().CI_IE_ORDRUGHERB_OP_SQL();
		 String id_pres4sql=CiOrdUtils.getSqlInOrEqualStrs(_id_preses)+getFilterSql();
		 String id_orsrvs4sql=CiOrdUtils.getSqlInOrEqualStrs(_id_orsrvs);
		 OrdBizLogger.info(null, "草药refund信息sql："+String.format(formatsql, "A1.Id_Pres"+id_pres4sql+ " and A1.Id_orsrv"+id_orsrvs4sql));
		 return String.format(formatsql, "A1.Id_Pres"+id_pres4sql+ " and A1.Id_orsrv"+id_orsrvs4sql);
	//	 return formatsql+ " and A1.Id_Pres"+id_pres4sql;
	 }
	 
	 private String getFilterSql(){
		 
		 return " and (A1.sd_srvtp like '0103%' )";
	 }

}
