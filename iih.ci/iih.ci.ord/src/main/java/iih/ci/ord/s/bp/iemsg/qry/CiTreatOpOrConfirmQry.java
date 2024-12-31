package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.bp.iemsg.qry.sql.Tre4IESql;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiTreatOpOrConfirmQry implements ITransQry {

	private String[] _id_ors;
	
	public CiTreatOpOrConfirmQry(String id_ors){
		String[] idOrs = id_ors.split(",");
		this._id_ors = idOrs;
		
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		for (String idOr : _id_ors) {
			sqlpram.addParam(idOr);
		}
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
		 String sql = new Tre4IESql().CiIeOrtreatConfirmOpSql();
		 String sqlwhere="";
         for(String idor:_id_ors){
             sqlwhere+=",?";
            }
         sql=String.format(sql, sqlwhere.substring(1));
         CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
 		 OrdBizLogger.info(ctx, "BS303治疗门诊签署sql："+sql);
         return sql;
		 
	 }

}
