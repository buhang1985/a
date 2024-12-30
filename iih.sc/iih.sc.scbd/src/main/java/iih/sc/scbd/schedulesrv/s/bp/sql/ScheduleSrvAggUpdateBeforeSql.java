package iih.sc.scbd.schedulesrv.s.bp.sql;

import java.util.List;

import iih.sc.comm.ScSqlUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 删除父医技排班服务子DO的同时删除子排班服务的子DO
 * @author guoyang
 *
 */
public class ScheduleSrvAggUpdateBeforeSql implements ITransQry {
	
	private String innercode;
	private List<String> idMdSrvList;
	
	public ScheduleSrvAggUpdateBeforeSql(String innercode, List<String> idMdSrvList) {
		this.innercode = innercode;
		this.idMdSrvList = idMdSrvList;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(innercode + "%");
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		String baseSql = getBaseSql();
		sb.append(baseSql);
		sb.append(" AND " + ScSqlUtils.getInSqlByIds("ID_MDSRV", idMdSrvList));
		return sb.toString();
	}

	private String getBaseSql() {
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM SC_SRV_REL ");
		sb.append(" WHERE ID_SCSRV IN (  ");
		sb.append(" 	SELECT ID_SCSRV   ");
		sb.append(" 	FROM SC_SRV ");
		sb.append(" 	WHERE INNERCODE LIKE ? ) ");
		return sb.toString();
	}
}
