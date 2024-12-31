package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.sql.Tre4IESql;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiTreatOpOrCItmQry implements ITransQry {

	private String[] _id_ors;
	
	public CiTreatOpOrCItmQry(String id_ors){
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
		String sql = new Tre4IESql().CiIeOrtreatItmOpSql();
		String sqlwhere="";
        for(String idor:_id_ors){
            sqlwhere+=",?";
           }
        sql=String.format(sql, sqlwhere.substring(1));
        return sql;
	}

}
