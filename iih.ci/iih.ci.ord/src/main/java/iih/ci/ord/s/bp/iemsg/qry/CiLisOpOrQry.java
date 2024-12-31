package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.CiIEMsgRelSqlConst;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊检验查询对象
 *
 */
public class CiLisOpOrQry implements ITransQry {

	private String _id_ors;
	
	public CiLisOpOrQry(String id_ors){
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
		 String formatsql=new CiIEMsgRelSqlConst().CI_IE_APPLIS_OP_ALL_SQL();
		 String id_or4sql=CiOrdUtils.getSqlInOrEqualStrs(_id_ors);
		 CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		 OrdBizLogger.info(ctx, "BS006门诊收费sql:"+String.format(formatsql, "A.id_or"+id_or4sql));
		 return String.format(formatsql, "A.id_or"+id_or4sql);
	 }

}
