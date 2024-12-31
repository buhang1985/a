package iih.bl.cg.service.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBlStOepPayInfoQry implements ITransQry {

	String stOepId;

	/*
	 * 获取退款导入时的相关收款数据
	 */
	public GetBlStOepPayInfoQry(String stOepId) {

		this.stOepId = stOepId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		if (stOepId != null)
			param.addParam(this.stOepId);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  ");
		sql.append("  stoep.DT_ST, ");
		sql.append("   stoep.CODE_ST, ");
		sql.append("   stoep.ID_STOEP, ");
		sql.append("   payitm.Id_cust, ");
		sql.append("   pay.DT_PAY, ");
		sql.append("   payitm.ID_PM,  ");
		sql.append("   PM.NAME NAME_PM, ");
		sql.append("   payitm.AMT, ");
		sql.append("   pay.EU_DIRECT, ");
		sql.append("   payitm.id_payitmpatoep,  ");
		sql.append("   psndoc.NAME NAME_EMP_PAY, ");
		sql.append("   stoep.FG_CANC  ");
		sql.append(" FROM bl_st_oep stoep ");
		sql.append(" LEFT JOIN BL_PAY_PAT_OEP pay ");
		sql.append(" ON stoep.ID_PAYPATOEP=pay.id_paypatoep ");
		sql.append(" LEFT JOIN BL_PAY_ITM_PAT_OEP payitm ");
		sql.append(" ON pay.ID_PAYPATOEP=payitm.id_paypatoep ");
		sql.append(" INNER JOIN BD_PRI_PM PM ");
		sql.append(" ON payitm.ID_PM=PM.ID_PM ");
		sql.append(" LEFT JOIN BL_HP_ERROR ERRO ON ERRO.ID_STOEP=stoep.ID_STOEP AND ERRO.fg_rollback<>'Y'");
		sql.append(" INNER JOIN BD_PSNDOC psndoc ON pay.ID_EMP_PAY=psndoc.ID_PSNDOC ");
		sql.append(
				" WHERE stoep.ID_STOEP in (SELECT ID_STOEP FROM BL_CG_ITM_OEP WHERE EU_SRCTP <> 1 AND ID_STOEP=stoep.ID_STOEP) ");

		if (stOepId != null) {
			sql.append(" AND stoep.ID_STOEP=?");
		}
		sql.append(" ORDER BY stoep.DT_ST DESC");
		return sql.toString();
	}

}
