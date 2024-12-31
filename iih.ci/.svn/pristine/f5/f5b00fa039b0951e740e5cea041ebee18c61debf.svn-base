package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.CiIEMsgRelSqlConst;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiPharmWcOrQry implements ITransQry {

	private String _id_ors;
	
	public CiPharmWcOrQry(String id_ors){
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
		 String formatsql = new CiIEMsgRelSqlConst().CI_IE_ORDRUGWC_SQL();
		 String id_or4sql=CiOrdUtils.getSqlInOrEqualStrs(_id_ors);
		 CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		 OrdBizLogger.info(ctx, "BS311西药 IEPharmWcOrDTO sql:"+String.format(formatsql, "A.id_or"+id_or4sql));
		 return String.format(formatsql, "A.id_or"+id_or4sql);
	 }

}
