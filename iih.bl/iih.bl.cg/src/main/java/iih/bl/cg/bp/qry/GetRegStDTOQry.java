package iih.bl.cg.bp.qry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetRegStDTOQry implements ITransQry {
	String cgid;
	String[] cgIds;

	/*
	 * 获取支付方式明细
	 */
	public GetRegStDTOQry(String cgid) throws BizException {
		this.cgid = cgid;
	}

	/*
	 * 获取支付方式明细
	 */
	public GetRegStDTOQry(String[] cgIds) throws BizException {
		this.cgIds = cgIds;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (!StringUtil.isEmpty(this.cgid)) {
			param.addParam(this.cgid);
		}
		if (!ArrayUtil.isEmpty(this.cgIds)) {
			for (String cgitm : this.cgIds) {
				param.addParam(cgitm);
			}
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" STOEP.Id_stoep,");
		sql.append(" STOEP.Id_paypatoep id_pay,");
		sql.append(" STOEP.Amt_std,");
		sql.append(" STOEP.Amt_ratio,");
		sql.append(" STOEP.Amt_hp,");
		sql.append(" STOEP.Amt_pat,");
		sql.append(" STOEP.Amt,");
		sql.append(" STOEP.Dt_st,");
		sql.append(" ITMOEP.ID_CGOEP Id_cg");
		sql.append(" FROM BL_ST_OEP STOEP");
		sql.append(" INNER JOIN BL_CG_ITM_OEP ITMOEP ON ITMOEP.ID_STOEP=STOEP.ID_STOEP");
		sql.append(" WHERE STOEP.ID_STOEP IN (SELECT ID_STOEP FROM BL_CG_ITM_OEP WHERE 1=1");
		if (!StringUtil.isEmpty(this.cgid)) {
			sql.append(" AND ID_CGOEP=?");
		}
		if (!ArrayUtil.isEmpty(this.cgIds)) {
			String strInWhere = "";
			for (String cgitm : this.cgIds) {
				strInWhere = strInWhere + (StringUtil.isEmpty(strInWhere) ? "" : ",") + "?";
			}
			sql.append(" AND ID_CGOEP in (" + strInWhere + ")");
		}

		sql.append(")");
		sql.append("GROUP BY ");
		sql.append(" STOEP.Id_stoep,");
		sql.append(" STOEP.Id_paypatoep,");
		sql.append(" STOEP.Amt_std,");
		sql.append(" STOEP.Amt_ratio,");
		sql.append(" STOEP.Amt_hp,");
		sql.append(" STOEP.Amt_pat,");
		sql.append(" STOEP.Amt,");
		sql.append(" STOEP.Dt_st,");
		sql.append(" ITMOEP.ID_CGOEP");
		return sql.toString();
	}
}
