package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.sql.Blood4IESql;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiBuOpOrQry implements ITransQry {

	private String _id_ors;
	
	public CiBuOpOrQry(String id_ors){
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
		 String id_or4sql=CiOrdUtils.getSqlInOrEqualStrs(_id_ors);
		 String formatsql= new Blood4IESql().CiIeOrbuOpSql(id_or4sql);
		 CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		 OrdBizLogger.info(ctx, "用血门诊签署sql:"+formatsql);
		 return formatsql;
	 }

}
