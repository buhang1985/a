package iih.mp.nr.opreport.qry;

import iih.mp.nr.common.MpUtils;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询注射处方单（门急诊输液登记）
 * 
 * @author fengjj
 * @version  2019年11月20日 17:39:05 dukx迭代  增加查询就诊类型为急诊：流水、抢救
 * @version hjh_2019年11月25日14:21:36 	0176530: PreSkinTestDTO添加“频次名称”字段，使频次显示中文名称 
 */
public class GetPreInjectListInfosSql implements ITransQry {
	private String id_or_prs;

	public GetPreInjectListInfosSql(String id_or_prs) {
		this.id_or_prs = id_or_prs;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" SELECT   orpr.id_or_pr,                                                   ");
		sqlStr.append("          orpr.dt_mp_plan,                                                 ");
		sqlStr.append(" 		 orpr.no_bar,                                                     ");
		sqlStr.append("          cior.dt_entry,                                                   ");
		sqlStr.append("          cior.dt_effe,                                                    ");
		sqlStr.append("          cior.days_or,                                                    ");
		sqlStr.append("          enent.id_ent,                                                    ");
		sqlStr.append("          enent.code,                                                      ");
		sqlStr.append("          enent.name_pat,                                                  ");
		sqlStr.append("          enent.dt_birth_pat,                                              ");
		sqlStr.append("          pipat.code as code_pat,                                          ");
		sqlStr.append("          skinrsn.name       as skin_result,                               ");
		sqlStr.append("          doc.name           doc_name,                                     ");
		sqlStr.append("          docsex.name        gender,                                       ");
		sqlStr.append("          docdrip.name       name_dripspeed,                               ");//滴速
		sqlStr.append("          cior.des_or,                                                     ");
		sqlStr.append("          dep.name           name_dep_or,                                  ");
		sqlStr.append("          orsrv.name    name_srv,                                          ");
		sqlStr.append("          mm.spec,                                                         ");
		sqlStr.append(" 		 grp.no_grp,                                                      ");
		sqlStr.append(" 		 grp.sortno as sort_no ,                                          ");
		sqlStr.append("          orsrv.quan_medu,                                                 ");
		sqlStr.append("          measdoc.name       name_medu,                                    ");
		sqlStr.append("          route.name         name_route,                                   ");
		sqlStr.append("          freq.code          code_freq,                                    ");
		sqlStr.append("          freq.name          name_freq                                     ");//@version hjh 2019年11月25日14:22:17 增加频次名称
		sqlStr.append("     FROM ci_or_srv orsrv                                                  ");
		sqlStr.append("     left outer join ci_order cior  on orsrv.id_or = cior.id_or                        ");
		sqlStr.append("     left outer join en_ent enent   on enent.id_ent = cior.id_en                       ");
		sqlStr.append("     left outer join pi_pat pipat   on enent.id_pat = pipat.id_pat                     ");
		sqlStr.append("     left outer join bd_psndoc doc   on doc.id_psndoc = cior.id_emp_or                 ");
		sqlStr.append("     left outer join mp_or_pr orpr   on cior.id_or = orpr.id_or                        ");
		sqlStr.append("		left join mp_infu_grp grp on grp.id_or_pr = orpr.id_or_pr                         ");
		sqlStr.append("     left outer join ci_or_srv_mm orsrvmm    on orsrvmm.id_orsrv = orsrv.id_orsrv      ");
		sqlStr.append("     left outer join bd_mm mm         on mm.id_mm = orsrvmm.id_mm                      ");
		sqlStr.append("     left outer join bd_measdoc measdoc   on measdoc.id_measdoc = orsrv.id_medu        ");
		sqlStr.append("     left outer join bd_route route   on route.id_route = cior.id_route                ");
		sqlStr.append("     left outer join bd_freq freq     on freq.id_freq = orsrv.id_freq                  ");
		sqlStr.append("     left outer join bd_dep dep       on enent.id_dep_phy = dep.id_dep                 ");
		sqlStr.append("     left outer join bd_udidoc docsex   on enent.id_sex_pat = docsex.id_udidoc         ");
		sqlStr.append("     left outer join bd_udidoc docdrip   on cior.id_dripspeed = docdrip.id_udidoc      ");//新增滴速
		sqlStr.append("     left join ci_skin_test ciskin  on ciskin.id_or = orsrv.id_or_rel                  ");
		sqlStr.append("     left join bd_udidoc skinrsn    on skinrsn.id_udidoc = ciskin.id_rst_skintest      ");
		sqlStr.append("    where enent.code_entp in ("+MpUtils.getOpEntpSqlStrs()+")                          ");//门诊、急诊：流水、抢救
		sqlStr.append("    and orsrv.sd_srvtp like '01%'                                                      ");
		sqlStr.append("      and eu_su <> 3                                                                   ");
		String whereStr = MpUtils.getInSqlStr(this.id_or_prs.split("\\,"));
		if (!StringUtil.isEmptyWithTrim(whereStr)) {
			sqlStr.append("       and orpr.id_or_pr in (" + whereStr + "  )                                   ");
		} else {
			sqlStr.append("       and 1=2                    							                      ");

		}
		return sqlStr.toString();
	}
}
