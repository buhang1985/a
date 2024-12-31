package iih.bl.cg.service.s.bp.qry;

import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOpCancAcc4EsDTOQry  implements ITransQry {

	String[] id_cgitmoeps;


	public GetOpCancAcc4EsDTOQry(String[] id_cgitmoeps) {
		this.id_cgitmoeps = id_cgitmoeps;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		if (!ArrayUtil.isEmpty(id_cgitmoeps)) {
			for (String str : id_cgitmoeps) {
				param.addParam(str);
			}
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" ITMOEP.ID_CGITMOEP id_cgitm,");
		sql.append(" ITMOEP.ID_CGOEP id_cg,");
		sql.append(" REPS.SD_PRESTP");
		sql.append(" FROM BL_CG_ITM_OEP ITMOEP");
		sql.append(" LEFT JOIN CI_PRES REPS ON ITMOEP.ID_PRES=REPS.ID_PRES");
		sql.append(" WHERE 1=1");

		if (!ArrayUtil.isEmpty(id_cgitmoeps)) {
			String sqlstr = "";
			for (String str : id_cgitmoeps) {
				sqlstr += (sqlstr == "" ? "" : ",") + "?";
			}
			sql.append(" AND ITMOEP.ID_CGITMOEP in (" + sqlstr + ")");
		}
		return sql.toString();
	}
}
