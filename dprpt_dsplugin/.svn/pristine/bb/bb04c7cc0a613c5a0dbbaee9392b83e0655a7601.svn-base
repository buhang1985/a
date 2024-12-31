package iih.sfda.adsa.sfdaevstatistics.qry;

import iih.sfda.adsa.s.ISfdaAdsaConst;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 整体全部事件Sql
 * 
 * @author lijm
 *
 */
public class GetAerEvStatisAllSql implements ITransQry {
	private String wherePart;
	private String id_org;
	private String id_grp;

	public GetAerEvStatisAllSql(String wherePart, String id_org, String id_grp) {
		this.wherePart = wherePart;
		this.id_grp = id_grp;
		this.id_org = id_org;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(ISfdaAdsaConst.ID_STATIS_TYPE);
		param.addParam(id_org);
		param.addParam(id_grp);	
		param.addParam(id_org);
		param.addParam(id_grp);
	
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("	select udiev.nameevpar,udiev.codeevpar,evpar.countevpar,udiev.codeev,udiev.nameev, ev.countev 													 ");
		sb.append("	from (                                                                                                                                           ");
		sb.append("			select evcapar.code codeevpar, evcapar.name nameevpar, evca.code codeev,evca.name nameev                                                 ");
		sb.append("			from bd_udidoc evcapar                                                                                                                   ");
		sb.append("			left join bd_udidoc evca on evcapar.id_udidoc = evca.id_parent                                                                           ");
		sb.append("			where evcapar.id_udidoclist = ? and length(evcapar.code) = 2) udiev                                                                      ");
		sb.append("	left join(                                                                                                                                       ");
		sb.append("				select aerev.sd_ev_ca , count(*) countev from sfda_aer_ev aerev                                                                      ");
		if (!StringUtil.isEmptyWithTrim(wherePart)) {
			sb.append("                 left join bd_psndoc psndoc on psndoc.id_psndoc= aerev.id_psndoc        ");
			sb.append("                 left join sfda_aer_imprd aerimprd on aerimprd.id_aer_ev= aerev.id_aer_ev");
		}
		sb.append("				where aerev.id_org = ? and aerev.id_grp = ?                                                                                          ");
		if (!StringUtil.isEmptyWithTrim(wherePart)) {
			sb.append("         and  " + wherePart);
		}
		sb.append("				group by aerev.sd_ev_ca ) ev                                                     													 ");
		sb.append("	on ev.sd_ev_ca=udiev.codeev                                                                                                                      ");
		sb.append("	left join(                                                                                                                                       ");
		sb.append("				select substr(sd_ev_ca,0,2) codeevpar , count(*) countevpar  from sfda_aer_ev aerev 												 ");
		if (!StringUtil.isEmptyWithTrim(wherePart)) {
			sb.append("                 left join bd_psndoc psndoc on psndoc.id_psndoc= aerev.id_psndoc        ");
			sb.append("                 left join sfda_aer_imprd aerimprd on aerimprd.id_aer_ev= aerev.id_aer_ev");
		}
		sb.append("				where aerev.id_org = ? and aerev.id_grp = ?                                                                                          ");
		if (!StringUtil.isEmptyWithTrim(wherePart)) {
			sb.append("         and  " + wherePart);
		}
		sb.append("				group by substr(aerev.sd_ev_ca,0,2) ) evpar           																				 ");
		sb.append("	on evpar.codeevpar=udiev.codeevpar 																												 ");
		sb.append("	order by udiev.codeev asc 																					      								 ");
		return sb.toString();
	}
}
