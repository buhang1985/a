package iih.mp.nr.mpwardprint.qry;

import iih.mp.nr.common.MpUtils;
import iih.mp.nr.dto.mpwardprint.d.WardPrntCondDTO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:门急诊执行打印通用查询服务
 * @author: dukx
 * @version：2019年8月9日 下午5:48:13 创建
 * @version xuxing_2019年10月9日13:54:16，代码整理，支持医嘱ID二次过滤
 * @version dukx_2019年11月21日14:07:01，增加就诊类型为急诊：流水、抢救
 */
public class GetOpMeMpOrPrnPlanSrvInfosSql implements ITransQry {

	private WardPrntCondDTO param;
	private String[] id_freqs;
	private String nameTable;

	public GetOpMeMpOrPrnPlanSrvInfosSql(String nameTable, WardPrntCondDTO param, String[] id_freqs) {
		this.nameTable = nameTable;
		this.param = param;
		this.id_freqs = id_freqs;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this.param.getDt_begin());
		sqlParam.addParam(this.param.getDt_end());
		sqlParam.addParam(this.param.getId_prntp());
		sqlParam.addParam(this.param.getDt_begin());
		sqlParam.addParam(this.param.getDt_end());
		sqlParam.addParam(this.param.getId_prntp());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();

		sqlStr.append("select * from(                                                                                              ");
		sqlStr.append("  (select                                                                                                   ");
		sqlStr.append("  orpr.id_or_pr,                                                                                            ");
		sqlStr.append("  orpr.dt_mp_plan,                                                                                          ");
		sqlStr.append("  orpr.no_bar,                                                                                              ");
		sqlStr.append("  ord.id_or,                                                                                                ");
		sqlStr.append("  ord.code_or,                                                                                              ");
		sqlStr.append("  ord.sd_orsrcfun,                                                                                          ");
		sqlStr.append("  ord.fg_long,                                                                                              ");
		sqlStr.append("  ord.code_entp,                                                                                            ");
		sqlStr.append("  prnt.ct_prnt,                                                                                             ");
		sqlStr.append("  ord.dt_end,																	                           ");
		sqlStr.append("  ord.fg_skintest,                                                                                          ");
		sqlStr.append("  ord.sortno as ord_sortno,                                                                                 ");
		sqlStr.append("  ord.id_freq,                                                                                              ");
		sqlStr.append("  ord.des_or,                                                                                               ");
		sqlStr.append("  ord.fg_pres_outp,                                                                                         ");
		sqlStr.append("  orsrv.id_orsrv,                                                                                           ");
		sqlStr.append("  orsrv.sd_srvtp,                                                                                           ");
		sqlStr.append("  enent.name_pat,                       					                                                   ");
		sqlStr.append("  enent.id_ent,                       					                                                   ");
		sqlStr.append("  enent.dt_birth_pat,                                                                                       ");
		sqlStr.append("  docsex.name as name_sex,                                                                                  ");
		sqlStr.append("  docdripspeed.name name_dripspeed,                                                                         ");//增加滴速
		sqlStr.append("  dep.name as name_dep_phy, 	                                                                               ");
		sqlStr.append("  orsrv.name,                                                                                               ");
		sqlStr.append("  orsrv.sortno as srv_sortno,                                                                               ");
		sqlStr.append("  mm.spec,                                                                                                  ");
		sqlStr.append("  orsrv.quan_medu,                                                                                          ");
		sqlStr.append("  measdoc.name name_medu,                                                                                   ");
		sqlStr.append("  route.name as name_route,                                                                                 ");
		sqlStr.append("  route.code as code_route,                                                                                 ");
		sqlStr.append("  routedes.name as name_routedes,                                                                           ");
		sqlStr.append("  orsrvmm.quan_num_base,                                                                                    ");
		sqlStr.append("  orsrvmm.quan_den_base,                                                                                    ");
		sqlStr.append("  orsrvmm.sd_pois,                                                                                          ");
		sqlStr.append("  measdocmm.name name_mm_medu,                                                                              ");
		sqlStr.append("  freq.code as code_freq,                                                                                   ");
		sqlStr.append("  ord.dt_effe                                                                                               ");
		sqlStr.append("  from ci_order ord                                                                                         ");
		sqlStr.append("  inner join ci_or_srv orsrv on ord.id_or = orsrv.id_or  and orsrv.fg_or = 'Y'                              ");
		if (StringUtil.isEmptyWithTrim(this.param.getId_ors())) {
			// 患者过滤
			sqlStr.append("  inner join " + this.nameTable + " tement on ord.id_pat = tement.id_pat and nvl(tement.id_pat,'~') <> '~'  ");
			// 服务类型过滤
			sqlStr.append("  inner join " + this.nameTable + " temsrvtp on ord.sd_srvtp = temsrvtp.sd_srvtp and nvl(temsrvtp.sd_srvtp,'~') <> '~'                           ");
			// 含有用法的过滤
			sqlStr.append("  inner join " + this.nameTable + " temroute on ord.id_route = temroute.id_route  and nvl(temroute.id_route,'~') <> '~'                          ");
			// 含有仓库的过滤
			if (!StringUtil.isEmptyWithTrim(this.param.getId_dep_whs()))
				sqlStr.append("  inner join " + this.nameTable + " temdepwh on orsrv.id_dep_wh = temdepwh.id_dep_wh  and nvl(temdepwh.id_dep_wh,'~') <> '~'                 ");
			// 含有医疗服务的过滤
			if (!StringUtil.isEmptyWithTrim(this.param.getId_srvs()))
				sqlStr.append("  inner join " + this.nameTable + " temdepsrv on ord.id_srv = temdepsrv.id_srv and nvl(temdepsrv.id_srv,'~') <> '~'                	        ");
		} else {
			// 医嘱过滤
			// 参数请求中有医嘱ID的，属于报表查询的二次过滤，此时仅仅使用医嘱ID条件
			// 二次过滤的医嘱ID基于第一次查询的结果，所以不用重复使用卡的条件
			sqlStr.append("  inner join " + this.nameTable + " temor on ord.id_or = temor.id_or and nvl(temor.id_or,'~') <> '~'    ");
		}
		sqlStr.append("  inner join bd_freq freq on freq.id_freq = orsrv.id_freq                                                   ");
		sqlStr.append("  inner join en_ent enent on ord.id_en = enent.id_ent                                                       ");
		sqlStr.append("  inner join mp_or_pr orpr on orpr.id_or = ord.id_or and orpr.eu_su in(0,1,4)                               ");
		sqlStr.append("  and orpr.id_ent = ord.id_en and orpr.dt_mp_plan >= ? and orpr.dt_mp_plan <= ?                             ");
		sqlStr.append("  inner join bd_dep dep on enent.id_dep_phy = dep.id_dep                                                    ");
		sqlStr.append("  left join ci_or_srv_mm orsrvmm on orsrvmm.id_orsrv = orsrv.id_orsrv                                       ");
		sqlStr.append("  left join bd_mm mm on mm.id_mm = orsrvmm.id_mm                                                            ");
		sqlStr.append("  left join bd_measdoc measdoc on measdoc.id_measdoc = orsrv.id_medu                                        ");
		sqlStr.append("  left join bd_measdoc measdocmm on measdocmm.id_measdoc = orsrvmm.id_pgku_base                             ");
		sqlStr.append("  left join bd_route route on route.id_route = ord.id_route                                                 ");
		sqlStr.append("  left join bd_route_des routedes on routedes.id_routedes = ord.id_routedes                                 ");
		sqlStr.append("  left join bd_udidoc docsex on enent.id_sex_pat = docsex.id_udidoc                                         ");
		sqlStr.append("  left join bd_udidoc docdripspeed on ord.id_dripspeed = docdripspeed.id_udidoc                             ");// 滴速名称
		sqlStr.append("  left join mp_exe_prnt prnt on prnt.id_key = orpr.id_or_pr and prnt.id_prntp = ?                           ");// 关联打印记录
		sqlStr.append("  where substr(ord.sd_srvtp,0,2) = '01'                                                                     ");
		sqlStr.append("  and ord.fg_mp_in ='Y'                                                                                     "); // 在院执行标志
		sqlStr.append("  and ord.fg_sign='Y'                                                                                       "); // 医嘱签署标志
		sqlStr.append("  and ord.fg_pmor='N'                                                                                       "); // 备用医嘱标志
		sqlStr.append(" )                                                                                                          ");
		sqlStr.append(" union all                                                                                                  ");
		sqlStr.append(" (                                                                                                          ");
		sqlStr.append("  select                                                                                                    ");
		sqlStr.append("  orpr.id_or_pr,                                                                                            ");
		sqlStr.append("  orpr.dt_mp_plan,                                                                                          ");
		sqlStr.append("  orpr.no_bar,                                                                                              ");
		sqlStr.append("  ord.id_or,                                                                                                ");
		sqlStr.append("  ord.code_or,                                                                                              ");
		sqlStr.append("  ord.sd_orsrcfun,                                                                                          ");
		sqlStr.append("  ord.fg_long,                                                                                              ");
		sqlStr.append("  ord.code_entp,                                                                                            ");
		sqlStr.append("  prnt.ct_prnt,                                                                                             ");
		sqlStr.append("  ord.dt_end,                                                                                               ");
		sqlStr.append("  ord.fg_skintest,                                                                                          ");
		sqlStr.append("  ord.sortno ord_sortno,                                                                                    ");
		sqlStr.append("  ord.id_freq,                                                                                              ");
		sqlStr.append("  ord.des_or,                                                                                               ");
		sqlStr.append("  ord.fg_pres_outp,                                                                                         ");
		sqlStr.append("  null as id_orsrv,                                                                                         ");
		sqlStr.append("  ord.sd_srvtp,                                                                                             ");
		sqlStr.append("  enent.name_pat,                                                                                           ");
		sqlStr.append("  enent.id_ent,                                                                                             ");
		sqlStr.append("  enent.dt_birth_pat,                                                                                       ");
		sqlStr.append("  docsex.name name_sex,                                                                                     ");
		sqlStr.append("  docdripspeed.name name_dripspeed,                                                                         ");
		sqlStr.append("  dep.name name_dep_phy,                                                                                    ");
		sqlStr.append("  ord.name_or as name,                                                                                      ");
		sqlStr.append("  0 as srv_sortno,                                                                                          ");
		sqlStr.append("  null as spec,                                                                                             ");
		sqlStr.append("  ord.quan_medu,                                                                                            ");
		sqlStr.append("  null as name_medu,                                                                                        ");
		sqlStr.append("  null as name_route,                                                                                       ");
		sqlStr.append("  null as code_route,                                                                                       ");
		sqlStr.append("  null as name_routedes,                                                                                    ");
		sqlStr.append("  null as quan_num_base,                                                                                    ");
		sqlStr.append("  null as quan_den_base,                                                                                    ");
		sqlStr.append("  null as sd_pois,                                                                                          ");
		sqlStr.append("  null as name_mm_medu,                                                                                     ");
		sqlStr.append("  freq.code code_freq,                                                                                      ");
		sqlStr.append("  ord.dt_effe                                                                                               ");
		sqlStr.append("  from ci_order ord                                                                                         ");
		if (StringUtil.isEmptyWithTrim(this.param.getId_ors())) {
			sqlStr.append("  inner join " + this.nameTable + " tement on ord.id_pat = tement.id_pat and nvl(tement.id_pat, '~') <> '~' ");
			sqlStr.append("  inner join " + this.nameTable + " temsrvtp on ord.sd_srvtp = temsrvtp.sd_srvtp  and nvl(temsrvtp.sd_srvtp, '~') <> '~'                    ");
			// 含有医疗服务的过滤
			if (!StringUtil.isEmptyWithTrim(this.param.getId_srvs()))
				sqlStr.append("  inner join " + this.nameTable + " temdepsrv on ord.id_srv = temdepsrv.id_srv  and nvl(temdepsrv.id_srv,'~') <> '~'                	   ");
		} else {
			// 医嘱过滤
			// 参数请求中有医嘱ID的，属于报表查询的二次过滤，此时仅仅使用医嘱ID条件
			// 二次过滤的医嘱ID基于第一次查询的结果，所以不用重复使用卡的条件
			sqlStr.append("  inner join " + this.nameTable + " temor on ord.id_or = temor.id_or and nvl(temor.id_or,'~') <> '~'    ");
		}
		sqlStr.append("  inner join bd_freq freq on freq.id_freq = ord.id_freq                                                     ");
		sqlStr.append("  inner join en_ent enent on ord.id_en = enent.id_ent and enent.fg_ip = 'N'                                 ");
		sqlStr.append("  inner join mp_or_pr orpr on orpr.id_or = ord.id_or and orpr.eu_su in (0, 1, 4)                            ");
		sqlStr.append("  and orpr.id_ent = ord.id_en and orpr.dt_mp_plan >= ? and orpr.dt_mp_plan <= ?                             ");
		sqlStr.append("  inner join bd_dep dep on enent.id_dep_phy = dep.id_dep                                                    ");
		sqlStr.append("  left outer join bd_udidoc docsex on enent.id_sex_pat = docsex.id_udidoc                                   ");
		sqlStr.append("  left outer join bd_udidoc docdripspeed on ord.id_dripspeed = docdripspeed.id_udidoc                       ");//滴速
		sqlStr.append("  left outer join mp_exe_prnt prnt on prnt.id_key = orpr.id_or_pr and prnt.id_prntp = ?                     ");
		sqlStr.append("  where substr(ord.sd_srvtp,0,2) <> '01'                                                                    ");
		sqlStr.append(" and ord.fg_mp_in ='Y'                                                                                      "); // 在院执行标志
		sqlStr.append(" and ord.fg_sign='Y'                                                                                        "); // 医嘱签署标志
		sqlStr.append(" and ord.fg_pmor='N'                                                                                        "); // 备用医嘱标志
		sqlStr.append(" )                                                                                                          ");
		sqlStr.append(")temtable                                                                                                   ");
		sqlStr.append(" where nvl(temtable.sd_orsrcfun ,'~') <> '2'                                                                ");
		sqlStr.append(" and temtable.code_entp in ("+MpUtils.getOpEntpSqlStrs()+")                                                 ");//门诊、急诊：流水、抢救
		// 频次过滤
		if (id_freqs != null && id_freqs.length > 0) {
			String whereIn = "";
			for (String id_freq : id_freqs) {
				whereIn += ((whereIn.length() == 0 ? "" : ",") + ("'" + id_freq + "'"));
			}
			sqlStr.append(" and temtable.id_freq not in (" + whereIn + ")             							                   ");
		}
		// 长临过滤
		if (!StringUtil.isEmptyWithTrim(this.param.getEu_long()))
			sqlStr.append(" and temtable.fg_long = '" + this.param.getEu_long() + "'                                               ");
		// 过滤打印状态
		if ("1".equals(this.param.getEu_print()))
			sqlStr.append("  and temtable.ct_prnt > 0                                                                              ");
		if ("2".equals(this.param.getEu_print()))
			sqlStr.append("  and temtable.ct_prnt is null                                                                          ");

		// 毒麻
		if ("1".equals(this.param.getEu_pois()))
			sqlStr.append("  and temtable.sd_pois > 0                                                                              ");
		// 非毒麻
		if ("2".equals(this.param.getEu_pois()))
			sqlStr.append("  and temtable.sd_pois = 0                                                                              ");

		// 出院带药
		if ("1".equals(this.param.getEu_outp()))
			sqlStr.append("  and temtable.fg_pres_outp ='Y'                                                                        ");
		// 非出院带药
		if ("2".equals(this.param.getEu_outp()))
			sqlStr.append("  and temtable.fg_pres_outp = 'N'                                                                       ");

		sqlStr.append(" order by temtable.dt_effe asc,temtable.id_or_pr asc,temtable.srv_sortno asc                                ");
		return sqlStr.toString();
	}
}