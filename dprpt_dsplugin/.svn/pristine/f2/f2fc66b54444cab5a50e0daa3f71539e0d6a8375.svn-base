package iih.sfda.adsa.sfdaevstatistics.qry;

import iih.sfda.adsa.s.ISfdaAdsaConst;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 大类事件Sql
 * 
 * @author lijm
 *
 */
public class GetAerEvStatisBigSql implements ITransQry {

	private String wherePart;
	private String id_org;
	private String id_grp;

	public GetAerEvStatisBigSql(String wherePart, String id_org, String id_grp) {
		this.wherePart = wherePart;
		this.id_grp = id_grp;
		this.id_org = id_org;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_org);
		param.addParam(id_grp);
		param.addParam(ISfdaAdsaConst.ID_STATIS_TYPE);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("	select udiev.name nameEv, udiev.code codeEv, ev.countEv						        	");
		sb.append("	from bd_udidoc udiev                                                                    ");
		sb.append("	left join (                                                                             ");
		sb.append("					select substr(sd_ev_ca, 0, 2) codeEv, count(*) countEv                  ");
		sb.append("					from sfda_aer_ev aerev                                                  ");
		if (!StringUtil.isEmptyWithTrim(wherePart)) {
			sb.append("                 left join bd_psndoc psndoc on psndoc.id_psndoc= aerev.id_psndoc        ");
			sb.append("                 left join sfda_aer_imprd aerimprd on aerimprd.id_aer_ev= aerev.id_aer_ev");
		}
		sb.append("                 where aerev.id_org=? and aerev.id_grp=?                                             ");
		if (!StringUtil.isEmptyWithTrim(wherePart)) {
			sb.append("                 and " + wherePart);
		}
		sb.append("					group by substr(sd_ev_ca, 0, 2)) ev                                     ");
		sb.append("	on ev.codeEv = udiev.code                                                               ");
		sb.append("	where udiev.id_udidoclist = ? and length(udiev.code) = 2                                ");
		sb.append("	order by udiev.code asc                                                                 ");
		return sb.toString();
	}

}
