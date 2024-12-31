package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.s.bp.iemsg.CiIEMsgRelSqlConst;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiNsOrConfirmQry implements ITransQry {

	private String _id_or;
	
	public CiNsOrConfirmQry(String id_or){
		this._id_or = id_or;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam(_id_or);
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
		 String sqlString=new CiIEMsgRelSqlConst().CI_IE_ORNS_CONFIRM_SQL();
		 OrdBizLogger.info(null, "住院护理医嘱签署确认就诊信息sql:"+sqlString+"param:id_or="+_id_or);
		 return  sqlString;
	 }

}
