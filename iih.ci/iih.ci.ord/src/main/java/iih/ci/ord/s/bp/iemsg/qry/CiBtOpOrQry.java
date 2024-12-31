package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.sql.Blood4IESql;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CiBtOpOrQry implements ITransQry {

	private String _id_ors;
	
	public CiBtOpOrQry(String id_ors){
		this._id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
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
		 String formatsql=new Blood4IESql().CiIeOrbtMainOpSql(id_or4sql);
		 CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		 OrdBizLogger.info(ctx, "备血门诊签署BS008 sql:"+formatsql);
		 return formatsql;
	 }

}
