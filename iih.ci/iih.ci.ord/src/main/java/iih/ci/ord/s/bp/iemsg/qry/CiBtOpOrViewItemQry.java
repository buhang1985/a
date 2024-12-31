package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.CiIEMsgRelSqlConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiBtOpOrViewItemQry implements ITransQry {

	private String _id_apbtobsindex;
	
	public CiBtOpOrViewItemQry(String id_apbtobsindex){
		this._id_apbtobsindex = id_apbtobsindex;
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
		 String formatsql=new CiIEMsgRelSqlConst().CI_IE_ORBT_VIEWITEM_OP_SQL();
		 String id_or4sql=CiOrdUtils.getSqlInOrEqualStrs(_id_apbtobsindex);
		 if(id_or4sql == null){
			 return formatsql.format(formatsql, "A.id_apbt = "+id_or4sql);
		 }
		 return formatsql.format(formatsql, "A.id_apbt"+id_or4sql);
	 }

}
