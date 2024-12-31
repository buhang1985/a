package iih.bl.st.opfeeout.bp.qry;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBlStRefundInfoDTOQry implements ITransQry {

	List<String> id_stoeps;

	/**
	 * 查询退费信息
	 * 
	 * @param ID_STOEPs
	 * @throws BizException
	 */
	public GetBlStRefundInfoDTOQry(List<String> ID_STOEPs) throws BizException {

		this.id_stoeps = ID_STOEPs;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();

		for (String id_stoep : id_stoeps) {
			param.addParam(id_stoep);
		}

		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" ST2.CODE_ST code_stoep_old, ");
		sql.append(" ST1.CODE_ST code_stoep_now, ");
		sql.append(" ST1.DT_ST  dt_st_rund, ");
		sql.append(" PSN.name name_emp ");
		sql.append(" FROM ");
		sql.append(" BL_ST_OEP st1 ");
		sql.append(" INNER JOIN BL_ST_OEP st2 ON ST1.id_par=ST2.ID_STOEP ");
		sql.append(" LEFT JOIN BD_PSNDOC PSN ON PSN.id_psndoc=st1.id_emp_st  ");
		sql.append(" WHERE ST1.eu_direct = '-1' ");
		sql.append(" AND ST1.ID_STOEP IN  (");
		for (String id_stoep : this.id_stoeps) {
			sql.append("?,");
		}
		sql.append("'0')");

		return sql.toString();
	}

}
