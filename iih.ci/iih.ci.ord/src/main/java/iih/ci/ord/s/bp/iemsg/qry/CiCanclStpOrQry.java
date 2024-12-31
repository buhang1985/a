package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.CiIEMsgRelSqlConst;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiCanclStpOrQry implements ITransQry {

	private String _id_ors;
	
	public CiCanclStpOrQry(String id_ors){
		this._id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		//sqlpram.addParam(CiOrdUtils.getSqlNotInOrEqualStrs(_id_ors));
		//sqlpram.replace(0, CiOrdUtils.getSqlInOrEqualStrs(_id_preses)+getFilterSql());
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}
   
	/**
	 * 获得 SQL串 
	 * @param id_or
	 * @return
	 */
	private String getSql(){
		String id_or4sql=CiOrdUtils.getSqlInOrEqualStrs(_id_ors);
		String formatsql= new CiIEMsgRelSqlConst().CI_IE_ORCANCEL_SQL(id_or4sql);
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "住院BS005 撤销停止作废sql:"+formatsql);
		return formatsql;
	}
	 
	 

}
