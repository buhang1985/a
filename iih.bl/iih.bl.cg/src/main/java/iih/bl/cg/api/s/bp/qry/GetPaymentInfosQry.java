package iih.bl.cg.api.s.bp.qry;

import java.text.SimpleDateFormat;
import java.util.Date;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPaymentInfosQry implements ITransQry {

	String sd_pm;
	String repdate;
	String enddate;

	public GetPaymentInfosQry(String sd_pm, String rep_date,String end_date) {
		this.sd_pm = sd_pm;
		this.repdate = rep_date;
		this.enddate = end_date;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (this.sd_pm != null && this.sd_pm != "") {
			param.addParam(this.sd_pm);
		}
		if (this.repdate != null && this.repdate != "") {
			param.addParam(this.repdate );
		}
		if (this.enddate != null && this.enddate != "") {
			param.addParam(this.enddate );
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT pat.name patName,");
		sb.append("pat.code patCode,");
		sb.append("incoep.incno incno,");
		sb.append("to_date(stoep.dt_st,'yyyy-MM-dd hh24:mi:ss') settleDateTime,");
		sb.append("DECODE(payitem.eu_direct, '1', payitem.amt,0) amt,");
		sb.append("DECODE(payitem.eu_direct, '-1', payitem.amt,0) amtRefund,");
		sb.append("payitem.PAYMODENODE payOrder,");
		sb.append("payitem.SD_PM pmCode,");
		sb.append("STOEP.EU_STTP settleType,");
		sb.append("PAYOEP.sd_pttp terminalType");
		sb.append(" FROM BL_PAY_ITM_PAT_OEP payitem");
		sb.append(" INNER JOIN BL_ST_OEP stoep on PAYITEM.ID_PAYPATOEP=STOEP.ID_PAYPATOEP");
		sb.append(" INNER JOIN PI_PAT pat on pat.id_pat=stoep.id_pat");
		sb.append(" INNER JOIN BL_INC_OEP incoep on incoep.id_stoep=stoep.id_stoep");
		sb.append(" INNER JOIN BL_PAY_PAT_OEP PAYOEP ON PAYOEP.id_paypatoep=payitem.id_paypatoep");
		sb.append(" WHERE STOEP.EU_STTP in ('30','31','40','43')");

		if (this.sd_pm != null && this.sd_pm != "") {
			sb.append(" AND payitem.SD_PM=?");
		}
		if (this.repdate != null && this.repdate != "") {
			sb.append(" AND stoep.dt_st>?");
		}
		if (this.enddate != null && this.enddate != "") {
			sb.append(" AND stoep.dt_st<?");
		}
		return sb.toString();
	}

	String getDateToString(Date date) {
		if (date != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return formatter.format(date);
		}
		return null;
	}
}
