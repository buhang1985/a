package iih.mp.nr.soaplabel.qry;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetSoapLabelDataQry implements ITransQry {

	private List<String> id_preses;
	private String print_code;
	private String sd_exectp;

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		List<Object> params = param.getParameters();
		params.add(sd_exectp);
		params.addAll(id_preses);
		return param;
	}
	
	public GetSoapLabelDataQry(List<String> id_preses, String print_code, String sd_exectp) {
		super();
		this.id_preses = id_preses;
		this.print_code = print_code;
		this.sd_exectp = sd_exectp;
	}
	
	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("      select                                                      ");
		sql.append("       cior.id_or,                                                         ");
		sql.append("      pres.id_pres,                                                        ");
		sql.append("      dep.name      as mp_dep_nur,                                         ");
		sql.append("       ent.name_pat     as name_pat,                                       ");
		sql.append("       pat.code_amr_ip  as code_amr_ip,                                    ");
		sql.append("       entip.name_bed bed_name,                                         ");
		sql.append("       cior.orders_boil as quan_menu,                                      ");
		sql.append("       freq.name as freq_name,                                             ");
		sql.append("       orsrv.name as name_drug,                                           ");
		sql.append("       orsrv.quan_medu as dose,                                           ");
		sql.append("       meadoc.name as name_spec,                                          ");
		sql.append("       route.name as name_route,                                          ");
		sql.append("       routedes.name as name_routedes,                                    ");
		sql.append("       boil.name as name_boil,                                            ");
		sql.append("       boildes.name as name_boildes,                                       ");
		sql.append("       pres.dt_entry                                                       ");
		sql.append(" from ci_order cior                                                        ");
		sql.append(" inner join ci_or_srv orsrv  on cior.id_or = orsrv.id_or                   ");
		sql.append(" inner join ci_pres pres on pres.id_pres = orsrv.id_pres                   ");
		sql.append(" inner join en_ent ent on ent.id_ent = cior.id_en                          ");
		sql.append(" inner join pi_pat pat on pat.id_pat = ent.id_pat                          ");
		sql.append(" inner join mp_dg_presst presst on presst.id_pres = pres.id_pres           ");
		sql.append(" left  join bd_dep dep  on dep.id_dep = pres.id_dep_or                     ");
		sql.append(" left join bd_freq freq on freq.id_freq=cior.id_freq                       ");
		sql.append(" left join en_ent_ip entip on entip.id_ent = ent.id_ent                    ");
		sql.append(" left join bd_measdoc meadoc on meadoc.id_measdoc=orsrv.id_medu            ");
		sql.append(" left join bd_route route on route.id_route=orsrv.id_route                 ");
		sql.append(" left join bd_route_des routedes on routedes.id_routedes=route.id_route    ");
		sql.append(" left join bd_boil boil on boil.id_boil=orsrv.id_boil                     ");
		sql.append(" left join bd_boil_des boildes on boildes.id_boil=boil.id_boil            ");
		sql.append(" left join mp_exe_prnt prnt on prnt.id_key=pres.id_pres and prnt.sd_exectp=? ");
		sql.append("  where 1 = 1                                                              ");
		sql.append(" and presst.eu_su_mpdgop = 1                                               ");
		sql.append(" and cior.fg_boil='Y'                                                      ");
		sql.append(" and pres.sd_srvtp like '0103%'                                            ");
		if("01".equals(this.print_code)){
		sql.append(" and prnt.ct_prnt is not null and prnt.ct_prnt>0                           ");	
		}else{
			if("02".equals(this.print_code)){
				sql.append(" and prnt.ct_prnt is  null                                         ");	
			}
		}
        String appendStr="";
		for (String id_pres : id_preses) {
			appendStr+=StringUtil.isEmptyWithTrim(appendStr)?"?":",?";
		}
		sql.append(" and pres.id_pres in ( "+appendStr+" )"                                    );
		return sql.toString();
	}

}
