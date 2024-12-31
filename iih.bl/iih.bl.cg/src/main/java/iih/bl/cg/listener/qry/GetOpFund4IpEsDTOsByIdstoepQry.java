package iih.bl.cg.listener.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据结算编号获取对应的重收与全退的记账数据
 * 
 * @author yang.lu
 * @since 2017年7月11日
 */
public class GetOpFund4IpEsDTOsByIdstoepQry implements ITransQry {

	String id_stoep;

	public GetOpFund4IpEsDTOsByIdstoepQry(String id_stoep) {
		this.id_stoep = id_stoep;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		if (!StringUtil.isEmpty(id_stoep)) {
			param.addParam(id_stoep);
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
		sql.append(" ITMOEP.Dt_st Dt_refund,");
		sql.append(" ITMOEP.Id_emp_or Id_emp_refund,");
		sql.append(" ITMOEP.Id_or,");
		sql.append(" ITMOEP.Id_orsrv,");
		sql.append(" (ITMOEP.Quan*STOEP.EU_DIRECT) Quan,");
		sql.append(" '门诊退费' Reason,");
		sql.append(" ITMOEP.Id_pat,");
		sql.append(" ITMOEP.Id_pres,");
		sql.append(" REPS.SD_PRESTP,");
		sql.append(" REPS.CODE CODE_pres");
		sql.append(" FROM BL_CG_ITM_OEP ITMOEP");
		sql.append(" INNER JOIN BL_ST_OEP STOEP ON STOEP.ID_STOEP = ITMOEP.ID_STOEP");
		sql.append(" LEFT JOIN CI_PRES REPS ON ITMOEP.ID_PRES=REPS.ID_PRES");
		sql.append(" WHERE 1=1");

		if (!StringUtil.isEmpty(id_stoep)) {
			sql.append(" AND STOEP.ID_PAR=?");
		}

		return sql.toString();
	}
}
