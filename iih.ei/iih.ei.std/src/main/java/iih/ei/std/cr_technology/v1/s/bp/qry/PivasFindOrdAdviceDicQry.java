package iih.ei.std.cr_technology.v1.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医嘱用法资料信息SQL
 * 
 * @author dj.zhang
 *
 */
public class PivasFindOrdAdviceDicQry implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT BDFREQ.CODE YFBH, ");
		sql.append("BDFREQ.NAME YFNAME, ");
		sql.append("BDFREQTIME.TIME_MP YFZXSJ ");
		sql.append("FROM BD_FREQ BDFREQ ");
		sql.append("LEFT JOIN BD_FREQ_TIME BDFREQTIME ");
		sql.append("ON BDFREQ.ID_FREQ = BDFREQTIME.ID_FREQ ");
		return sql.toString();
	}

}
