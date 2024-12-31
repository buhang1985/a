package iih.bl.pay.s.bp.qry;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPayPatListByIdPatPmQry implements ITransQry {

	String patId, pmId;

	public GetPayPatListByIdPatPmQry(String patId, String pmId) {
		this.patId = patId;
		this.pmId = pmId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this.patId);
		param.addParam(this.pmId);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT paymod_name,AMT,paymodeno,sd_pttp from");
		sql.append(" (SELECT PM.NAME paymod_name,");
		sql.append(" sum(PAYPAT.AMT*PAYPAT.EU_DIRECT) AMT,");
		sql.append(" (SELECT SD_PTTP FROM BL_PREPAY_PAT WHERE EU_DIRECT=1 AND ID_PAT=PAYPAT.ID_PAT AND PAYMODENODE=PAYPAT.PAYMODENODE AND ROWNUM=1) SD_PTTP,");
		sql.append(" PAYPAT.PAYMODENODE paymodeno");
		sql.append(" FROM BL_PREPAY_PAT PAYPAT");
		sql.append(" INNER JOIN BD_PRI_PM PM ON PM.ID_PM=PAYPAT.ID_PM");
		sql.append(" WHERE PAYPAT.ID_PAYTP='" + IBlDictCodeConst.ID_PAYTP_OPPREPAY + "'");
		sql.append(" AND PAYPAT.ID_PAT=?");
		sql.append(" AND PAYPAT.ID_PM=?");
		sql.append(" GROUP BY PM.NAME,PAYPAT.ID_PAT,PAYPAT.PAYMODENODE)tbl");
		sql.append(" where amt>0");
		return sql.toString();
	}

}
