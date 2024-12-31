package iih.bl.cg.bp.oep.qry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPayItmListByCgIdQry implements ITransQry{
	String cgid;
	String[] cgids;
	/*
	 * 获取支付方式明细
	 */
	public GetPayItmListByCgIdQry(String cgid) throws BizException {
		this.cgid=cgid;
	}
	/*
	 * 获取支付方式明细
	 */
	public GetPayItmListByCgIdQry(String[] cgids) throws BizException {
		this.cgids=cgids;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (!StringUtil.isEmpty(this.cgid)) {
			param.addParam(this.cgid);
		}
		if (!ArrayUtil.isEmpty(this.cgids)) {
			for (String cgitm : this.cgids) {
				param.addParam(cgitm);
			}
		}
		return param;
	}
	

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" itmpat.ID_PAYITMPATOEP Id_payitm,");
		sql.append(" itmpat.ID_PAYPATOEP Id_pay,");
		sql.append(" itmpat.Id_pm,");
		sql.append(" PRPM.code Code_pm,");
		sql.append(" PRPM.name Name_pm,");
		sql.append(" itmpat.Id_cust,");
		sql.append(" CUST.CODE Code_cust,");
		sql.append(" CUST.NAME Name_cust,");
		sql.append(" Id_bank,");
		sql.append(" Bankno,");
		sql.append(" Paymodenode,");
		sql.append(" Amt,");
		sql.append(" Fg_realpay,");
		sql.append(" Eu_direct");
		sql.append(" FROM BL_PAY_ITM_PAT_OEP itmpat");
		sql.append(" LEFT JOIN BD_CUST cust on CUST.ID_CUST=itmpat.ID_CUST");
		sql.append(" LEFT JOIN BD_PRI_PM PRPM ON PRPM.ID_PM=itmpat.ID_PM");
		sql.append(" WHERE id_paypatoep in(select id_paypatoep from bl_st_oep st inner join bl_cg_itm_oep itm on st.id_stoep=itm.id_stoep where 1=1 ");
		if (!StringUtil.isEmpty(this.cgid)) {
			sql.append(" AND ID_CGOEP=?");
		}
		if (!ArrayUtil.isEmpty(this.cgids)) {
			String strInWhere = "";
			for (String cgitm : this.cgids) {
				strInWhere = strInWhere + (StringUtil.isEmpty(strInWhere) ? "" : ",") + "?";
			}
			sql.append(" AND ID_CGOEP in (" + strInWhere + ")");
		}

		sql.append(")");
		return sql.toString();
	}
}
