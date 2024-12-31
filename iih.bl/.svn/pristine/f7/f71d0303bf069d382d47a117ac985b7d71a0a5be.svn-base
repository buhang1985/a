package iih.bl.cg.listener.qry;

import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据记账编号获取退记账的数据
 * 
 * @author yang.lu
 * @since 2017年7月11日
 */
public class GetOpFund4IpEsDTOsByIdsQry implements ITransQry {

	String[] id_cgitmoeps;

	public GetOpFund4IpEsDTOsByIdsQry(String[] id_cgitmoeps) {
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
		sql.append(" ITMOEP.Code_apply,");
		sql.append(" ITMOEP.Code_applytp,");
		sql.append(" ITMOEP.Dt_srv Dt_refund,");
		sql.append(" ITMOEP.Id_emp_or Id_emp_refund,");
		sql.append(" ITMOEP.Id_or,");
		sql.append(" ITMOEP.Id_orsrv,");
		sql.append(" ITMOEP.Quan,");
		sql.append(" '取消记账' Reason,");
		sql.append(" ITMOEP.Id_pat,");
		sql.append(" ITMOEP.Id_pres,");
		sql.append(" REPS.SD_PRESTP,");
		sql.append(" REPS.CODE CODE_pres");
		sql.append(" FROM BL_CG_ITM_OEP ITMOEP");
		sql.append(" LEFT JOIN CI_PRES REPS ON ITMOEP.ID_PRES=REPS.ID_PRES");
		sql.append(" WHERE 1=1");
		if (!ArrayUtil.isEmpty(id_cgitmoeps)) {
			String sqlstr = "";
			for (int i = 0; i < id_cgitmoeps.length; i++) {
				sqlstr += (sqlstr == "" ? "" : ",") + "?";
			}
			sql.append(" AND ITMOEP.ID_CGITMOEP in (" + sqlstr + ")");
		}
		return sql.toString();
	}
}
