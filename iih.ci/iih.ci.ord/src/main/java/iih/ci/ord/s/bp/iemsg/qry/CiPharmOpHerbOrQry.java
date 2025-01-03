package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.CiIEMsgRelSqlConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiPharmOpHerbOrQry implements ITransQry {

	private String _id_preses;
	
	public CiPharmOpHerbOrQry(String id_preses){
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
	 private String getSql(){
		 String formatsql=new CiIEMsgRelSqlConst().CI_IE_ORDRUGHERB_OP_SQL();
		 String id_pres4sql=CiOrdUtils.getSqlInOrEqualStrs(_id_preses)+getFilterSql();
		 System.out.println("BS302 IEOpPharmHerbOrDTO sql:"+String.format(formatsql, "A1.Id_Pres"+id_pres4sql));
		 return String.format(formatsql, "A1.Id_Pres"+id_pres4sql);
	//	 return formatsql+ " and A1.Id_Pres"+id_pres4sql;
	 }
	 
	 private String getFilterSql(){
		 
		 return " and (A1.sd_srvtp like '0103%' )";
	 }

}
