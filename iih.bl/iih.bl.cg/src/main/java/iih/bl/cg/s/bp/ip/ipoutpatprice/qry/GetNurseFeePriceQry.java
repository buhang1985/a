package iih.bl.cg.s.bp.ip.ipoutpatprice.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 检索护理费是否划价数据
 * @author LIM
 *
 */
public class GetNurseFeePriceQry implements ITransQry {
	private String id_ent;

	public GetNurseFeePriceQry(String id_ent) {
		this.id_ent = id_ent;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT B.NAME as NAME_BED, A.DT_EFFE DT_B, A.DT_END DT_E, B.ID_SRV as id_bed, B.DT_LAST_cg as dt_chg_bill ");
		sb.append(" FROM CI_ORDER A");
		sb.append(" inner JOIN CI_OR_SRV B ON A.ID_OR = B.ID_OR ");
		sb.append(" where A.id_en =?");
		sb.append(" AND A.SD_SRVTP LIKE '0601%' ");
		sb.append(" AND B.FG_BL = 'Y'");
		sb.append(" AND A.FG_CHK = 'Y'");
		sb.append(" AND A.fg_canc = 'N'");
		return sb.toString();
	}
}
