package iih.bl.cg.s.bp.ip.ipoutpatprice.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 检索床位费(只统计主床)是否划价
 * @author LIM
 *
 */
public class GetPriceBedFeeQry implements ITransQry{
	private String id_ent;

	public GetPriceBedFeeQry(String id_ent) {
		this.id_ent = id_ent;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		param.addParam(id_ent);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		sb.append(" select dt_b,dt_e,dt_chg_bill ");
		sb.append(" from en_ent_bed entbed ");
		sb.append(" inner join  bd_bed  bdbed on entbed.id_bed=bdbed.id_bed");
		sb.append(" where bdbed.sd_bedtp<>'03' and  entbed.id_ent = ?");
		sb.append(" and entbed.sd_usetype= '0'  ");
		sb.append(" and entbed.dt_chg_bill = (select max(dt_chg_bill) from en_ent_bed where id_ent = ? and sd_usetype= '0' ) ");
		return sb.toString();
	}
}
