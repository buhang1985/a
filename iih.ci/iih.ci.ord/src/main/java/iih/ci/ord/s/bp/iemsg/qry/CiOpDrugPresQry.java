package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.CiIEMsgRelSqlConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiOpDrugPresQry implements ITransQry {

	private String _id_ors;
	
	public CiOpDrugPresQry(String id_ors){
		this._id_ors = id_ors;
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
		 String formatsql= new CiIEMsgRelSqlConst().CI_IE_ORPHARM_OP_PRES_SQL();
		 String id_or4sql=CiOrdUtils.getSqlInOrEqualStrs(_id_ors);
		 return String.format(formatsql, "p.id_or"+id_or4sql);
	 }

}
