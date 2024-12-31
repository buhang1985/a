package iih.ci.mr.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class MrVtItemSql implements ITransQry {

	private String Id_mrtplvt;

	public MrVtItemSql(String id_mrtplvt) {
		Id_mrtplvt = id_mrtplvt;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam = new SqlParam();
		rtnParam.addParam(Id_mrtplvt);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		return _getQrySQLStr();
	}

	private String _getQrySQLStr() {

		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append("select vtitm.*,bdsrv.name as def1 ");
		SqlStr.append(" from BD_MRTPL_VT_ITM vtitm ");
		SqlStr.append(" inner join bd_srv bdsrv on vtitm.id_srv=bdsrv.id_srv and vtitm.id_mrtplvt=? ");
		SqlStr.append(" where vtitm.ds=0 order by sortno asc ");

		return SqlStr.toString();
	}

}
