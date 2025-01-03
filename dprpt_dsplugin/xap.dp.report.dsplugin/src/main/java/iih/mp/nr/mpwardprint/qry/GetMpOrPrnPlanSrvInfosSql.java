package iih.mp.nr.mpwardprint.qry;

import iih.mp.nr.common.IMpDictCodeConst;
import iih.mp.nr.common.MpUtils;
import iih.mp.nr.dto.mpwardprint.d.WardPrntCondDTO;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:病区执行打印通用查询服务
 * @author: xu_xing@founder.com.cn
 * @version：2019年5月23日 下午5:48:13 创建
 * @version xuxing_2019年5月24日09:54:28，迭代
 * @version xuxing_2019年6月6日13:30:37，增加毒麻过滤，增加仓库过滤
 * @version fengjj_2019年7月8日16:00:17，增加医疗服务过滤
 * @version fengjj_2019年8月12日09:49:49，增加出院带药过滤
 * @version fengjj_2019年9月5日14:09:55,增加持续医嘱查询逻辑条件
 * @version xuxing_2019年10月9日13:54:16，代码整理，支持医嘱ID二次过滤
 * @version dukx_2019年11月18日15:15:01，增加查询长临、药品打印名称以及支持根据执行状态进行过滤
 * @version dukx_2019年11月21日14:05:01，增加就诊类型为急诊：留观
 * @version xiadz_2019年11月27日10:03:01，增加病区执行打印的输液执行卡、输液贴中的输液滴速名称
 * @version zhy_2019年12月9日11:04:52，病区执行打印药品贴按时间正序排序
 * @version fengjj_2019年12月18日17:25:14,修复持续医嘱查不出来问题，11.18版本漏出;增加作废和医嘱确认过滤
 * @version fengjj_2019年12月27日18:01:40,仓库控件查询无效
 * @version fengjj_2020年5月13日16:46:01,单据分类选择多个配置不同报表的分类时，用医嘱列表过滤，结果会多出来， 由于没有卡条件的限制，所以会多
 */
public class GetMpOrPrnPlanSrvInfosSql implements ITransQry {

	private WardPrntCondDTO param;
	private String[] id_freqs;
	private String nameTable;
	private FBoolean flag;

	public GetMpOrPrnPlanSrvInfosSql(String nameTable, WardPrntCondDTO param, String[] id_freqs, FBoolean flag) {
		this.nameTable = nameTable;
		this.param = param;
		this.id_freqs = id_freqs;
		this.flag = flag;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this.param.getDt_begin());
		sqlParam.addParam(this.param.getDt_end());
		sqlParam.addParam(this.param.getId_prntp());
		sqlParam.addParam(IMpDictCodeConst.ID_FREQ_AWAYS);
		sqlParam.addParam(this.param.getDt_begin());
		sqlParam.addParam(this.param.getDt_end());
		sqlParam.addParam(this.param.getId_prntp());
		sqlParam.addParam(IMpDictCodeConst.ID_FREQ_AWAYS);
		sqlParam.addParam(this.param.getId_prntp());
		sqlParam.addParam(IMpDictCodeConst.ID_FREQ_AWAYS);
		sqlParam.addParam(this.param.getDt_begin());
		sqlParam.addParam(this.param.getDt_end());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();

		sqlStr.append("select * from                                                                                               ");
		sqlStr.append("(                                                                                                           ");
		sqlStr.append(" (                                                                                                          ");
		sqlStr.append("  select                                                                                                    ");
		sqlStr.append("  orpr.id_or_pr,                                                                                            ");
		sqlStr.append("  orpr.dt_mp_plan,                                                                                          ");
		sqlStr.append("  orpr.eu_su,                                                                                               ");
		sqlStr.append("  orpr.no_bar,                                                                                              ");
		sqlStr.append("  ord.id_or,                                                                                                ");
		sqlStr.append("  ord.code_or,                                                                                              ");
		sqlStr.append("  ord.fg_long,                                                                                              ");
		sqlStr.append("  ord.sd_orsrcfun,                                                                                          ");
		sqlStr.append("  ord.code_entp,                                                                                            ");
		sqlStr.append("  prnt.ct_prnt,                                                                                             ");
		sqlStr.append("  ord.dt_end,																	                           ");
		sqlStr.append("  ord.fg_skintest,                                                                                          ");
		sqlStr.append("  ord.sortno as ord_sortno,                                                                                 ");
		sqlStr.append("  ord.id_freq,                                                                                              ");
		sqlStr.append("  ord.des_or,                                                                                               ");
		sqlStr.append("  ord.fg_pres_outp,                                                                                         ");// 出院带药
		sqlStr.append("  orsrv.id_orsrv,                                                                                           ");
		sqlStr.append("  orsrv.sd_srvtp,                                                                                           ");
		sqlStr.append("  enent.name_pat,                       					                                                   ");
		sqlStr.append("  enent.id_ent,                       					                                                   ");
		sqlStr.append("  enent.dt_birth_pat,                                                                                       ");
		sqlStr.append("  enent.id_dep_nur,                                                                                         ");// 护理单元
		sqlStr.append("  enentip.name_bed,                       					                                               ");
		sqlStr.append("  enentip.code_amr_ip,                                                                                      ");
		sqlStr.append("  docsex.name as name_sex,                                                                                  ");
		sqlStr.append("  docdripspeed.name name_dripspeed,                                                                         ");
		sqlStr.append("  dep.name as name_dep_phy, 	                                                                               ");
		sqlStr.append("  orsrv.name,                                                                                               ");
		sqlStr.append("  orsrv.sortno as srv_sortno,                                                                               ");
		sqlStr.append("  mm.spec,                                                                                                  ");
		sqlStr.append("  mm.sd_abrd,                                                                                               ");
		sqlStr.append("  mm.printname as printname,                                                                                ");
		sqlStr.append("  orsrv.quan_medu,                                                                                          ");
		sqlStr.append("  measdoc.name name_medu,                                                                                   ");
		sqlStr.append("  route.name as name_route,                                                                                 ");
		sqlStr.append("  route.code as code_route,                                                                                 ");
		sqlStr.append("  ord.id_routedes ,                                                                                         ");//医嘱用法
		sqlStr.append("  orsrvmm.quan_num_base,                                                                                    ");
		sqlStr.append("  orsrvmm.quan_den_base,                                                                                    ");
		sqlStr.append("  orsrvmm.sd_pois,                                                                                          ");
		sqlStr.append("  measdocmm.name name_mm_medu,                                                                              ");
		sqlStr.append("  orsrv.fg_self,                                                                                            ");
		sqlStr.append("  docsug.name as sug_name,                                                                                  ");//手术名称
		sqlStr.append("  freq.code as code_freq,                                                                                   ");
		sqlStr.append("  enentip.times_ip,                                                                                         ");// 住院次数
		sqlStr.append("  docraw.name  as  name_raw_skin  ,                                                                         ");// 原液皮试
		sqlStr.append("  docdiag.name  as  name_diag_skin  ,                                                                       ");// 诊疗皮试
		sqlStr.append("  ord.dt_entry ,                                                                                            ");
		sqlStr.append(" ord.fg_wholepack,                                                                                          ");// 在院整领
		sqlStr.append(" ord.fg_back,                                                                                               ");// 退药标识
		sqlStr.append(" drug.fg_highrisk,                                                                                          ");// 高危标识
		sqlStr.append("  ord.dt_effe                                                                                               ");
		sqlStr.append("  from ci_order ord                                                                                         ");
		sqlStr.append("  inner join ci_or_srv orsrv on ord.id_or = orsrv.id_or and ord.fg_chk = 'Y'                                ");
		sqlStr.append("  and ord.fg_chk_canc = 'N' and orsrv.fg_or = 'Y' and ord.fg_wholepack='N'                                  ");
		// 患者过滤
		sqlStr.append("  inner join " + this.nameTable + " tement on ord.id_en = tement.id_ent and nvl(tement.id_ent,'~') <> '~'   ");
		// 服务类型过滤
		sqlStr.append("  inner join " + this.nameTable + " temsrvtp on ord.sd_srvtp = temsrvtp.sd_srvtp                            ");
		sqlStr.append("  and nvl(temsrvtp.sd_srvtp,'~') <> '~'                                  								   ");
		// 含有用法的过滤
		sqlStr.append("  inner join " + this.nameTable + " temroute on ord.id_route = temroute.id_route                       	   ");
		sqlStr.append("  and nvl(temroute.id_route,'~') <> '~'                                                                     ");
		// 含有仓库的过滤
		if (!StringUtil.isEmptyWithTrim(this.param.getId_dep_whs())) {
			sqlStr.append("  inner join " + this.nameTable + " temdepwh on orsrv.id_dep_wh = temdepwh.id_dep_whs                   ");
			sqlStr.append("  and nvl(temdepwh.id_dep_whs,'~') <> '~'                                                           	   ");
		}
		// 含有医疗服务的过滤
		if (!StringUtil.isEmptyWithTrim(this.param.getId_srvs())) {
			sqlStr.append("  inner join " + this.nameTable + " temdepsrv on ord.id_srv = temdepsrv.id_srv                	  	   ");
			sqlStr.append("  and nvl(temdepsrv.id_srv,'~') <> '~'                                                             	   ");
		}
		if (!StringUtil.isEmptyWithTrim(this.param.getId_ors()))
			// 医嘱过滤
			// 参数请求中有医嘱ID的，属于报表查询的二次过滤，此时仅仅使用医嘱ID条件
			// 二次过滤的医嘱ID基于第一次查询的结果，所以不用重复使用卡的条件
			sqlStr.append("  inner join " + this.nameTable + " temor on ord.id_or = temor.id_or and nvl(temor.id_or,'~') <> '~'    ");
		sqlStr.append("  inner join bd_freq freq on freq.id_freq = orsrv.id_freq                                                   ");
		sqlStr.append("  inner join en_ent enent on ord.id_en = enent.id_ent and enent.fg_ip = 'Y'                                 ");
		if (flag != null && flag.booleanValue())
			sqlStr.append("  and   enent.id_dep_phy = ord.id_dep_or                                                                ");
		sqlStr.append("  inner join mp_or_pr orpr on orpr.id_or = ord.id_or                                                        ");
		// 表单未增加执行状态筛选
		if (StringUtil.isEmptyWithTrim(this.param.getEu_exec()))
			sqlStr.append(" and orpr.eu_su in(0,1,4)                                                                               ");
		// 全部
		if ("0".equals(this.param.getEu_exec()))
			sqlStr.append(" and orpr.eu_su in(0,1,2,4)                                                                        	   ");
		// 已执行
		if ("1".equals(this.param.getEu_exec()))
			sqlStr.append(" and orpr.eu_su in(2,4)                                                                                 ");
		// 未执行
		if ("2".equals(this.param.getEu_exec()))
			sqlStr.append(" and orpr.eu_su in(0,1)                                                                                 ");
		sqlStr.append("  and orpr.id_ent = ord.id_en and orpr.dt_mp_plan >= ? and orpr.dt_mp_plan <= ?                             ");
		sqlStr.append("  inner join en_ent_ip enentip on orpr.id_ent = enentip.id_ent                                              ");
		sqlStr.append("  inner join bd_dep dep on enent.id_dep_phy = dep.id_dep                                                    ");
		sqlStr.append("  left join ci_or_srv_mm orsrvmm on orsrvmm.id_orsrv = orsrv.id_orsrv                                       ");
		sqlStr.append("  left join bd_srv srv on srv.id_srv = ord.id_srv                                                           ");
		sqlStr.append("  left join bd_srv_drug drug on drug.id_srv = srv.id_srv                                                    ");
		sqlStr.append("  left join bd_mm mm on mm.id_mm = orsrvmm.id_mm                                                            ");
		sqlStr.append("  left join bd_measdoc measdoc on measdoc.id_measdoc = orsrv.id_medu                                        ");
		sqlStr.append("  left join bd_measdoc measdocmm on measdocmm.id_measdoc = orsrvmm.id_pgku_base                             ");
		sqlStr.append("  left join bd_route route on route.id_route = ord.id_route                                                 ");
		sqlStr.append("  left join ci_skin_test raw_skin on raw_skin.id_or = ord.id_or                                             ");// 原液皮试结果
		sqlStr.append("  left join bd_udidoc docraw on docraw.id_udidoc = raw_skin.id_rst_skintest                                 ");
		sqlStr.append("  left join ci_skin_test diag_skin on diag_skin.id_or = orsrv.id_or_rel                                     ");// 诊疗皮试结果
		sqlStr.append("  left join bd_udidoc docdiag on docdiag.id_udidoc = diag_skin.id_rst_skintest                              ");
		sqlStr.append("  left join bd_udidoc docsex on enent.id_sex_pat = docsex.id_udidoc                                         ");
		sqlStr.append("  left join bd_udidoc docdripspeed on ord.id_dripspeed = docdripspeed.id_udidoc                             ");// 滴速名称
		sqlStr.append("  left join ci_ap_sug apsug on apsug.id_or = ord.id_or                                                      ");// 关联手术申请信息
		sqlStr.append("  left join bd_udidoc docsug on docsug.id_udidoc = apsug.id_surgical_site                                   ");
		sqlStr.append("  left join mp_exe_prnt prnt on prnt.id_key = orpr.id_or_pr and prnt.id_prntp = ?                           ");// 关联打印记录
		sqlStr.append("  where substr(ord.sd_srvtp,0,2) = '01'  and ord.id_freq <> ?                                               ");
		sqlStr.append(" )                                                                                                          ");
		sqlStr.append(" union all                                                                                                  ");
		sqlStr.append(" (                                                                                                          ");
		sqlStr.append("  select                                                                                                    ");
		sqlStr.append("  orpr.id_or_pr,                                                                                            ");
		sqlStr.append("  orpr.dt_mp_plan,                                                                                          ");
		sqlStr.append("  orpr.eu_su,                                                                                               ");
		sqlStr.append("  orpr.no_bar,                                                                                              ");
		sqlStr.append("  ord.id_or,                                                                                                ");
		sqlStr.append("  ord.code_or,                                                                                              ");
		sqlStr.append("  ord.fg_long,                                                                                              ");
		sqlStr.append("  ord.sd_orsrcfun,                                                                                          ");
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
		sqlStr.append("  enent.id_dep_nur,                                                                                         ");// 护理单元
		sqlStr.append("  enentip.name_bed,                                                                                         ");
		sqlStr.append("  enentip.code_amr_ip,                                                                                      ");
		sqlStr.append("  docsex.name name_sex,                                                                                     ");
		sqlStr.append("  docdripspeed.name name_dripspeed,                                                                         ");
		sqlStr.append("  dep.name name_dep_phy,                                                                                    ");
		sqlStr.append("  ord.name_or as name,                                                                                      ");
		sqlStr.append("  0 as srv_sortno,                                                                                          ");
		sqlStr.append("  null as spec,                                                                                             ");
		sqlStr.append("  null as sd_abrd,                                                                                          ");
		sqlStr.append("  null as printname,                                                                                        ");
		sqlStr.append("  orsrv.quan_medu,                                                                                          ");
		sqlStr.append("  measdoc.name name_medu,                                                                                   ");
		sqlStr.append("  route.name as name_route,                                                                                 ");
		sqlStr.append("  route.code as code_route,                                                                                 ");
		sqlStr.append("  ord.id_routedes ,                                                                                         ");//医嘱用法
		sqlStr.append("  null as quan_num_base,                                                                                    ");
		sqlStr.append("  null as quan_den_base,                                                                                    ");
		sqlStr.append("  null as sd_pois,                                                                                          ");
		sqlStr.append("  null as name_mm_medu,                                                                                     ");
		sqlStr.append("  'N'  as  fg_self,                                                                                         ");
		sqlStr.append("  docsug.name as sug_name,                                                                                  ");
		sqlStr.append("  freq.code code_freq,                                                                                      ");
		sqlStr.append("  enentip.times_ip,                                                                                         ");//住院次数
		sqlStr.append("  docraw.name  as  name_raw_skin  ,                                                                         ");// 原液皮试
		sqlStr.append("  null  as  name_diag_skin  ,                                                                               ");// 诊疗皮试
		sqlStr.append("  ord.dt_entry ,                                                                                            ");
		sqlStr.append(" null as fg_wholepack,                                                                                      ");// 在院整领
		sqlStr.append(" null as fg_back,                                                                                           ");// 退药标识
		sqlStr.append(" null as fg_highrisk,                                                                                       ");// 高危标识
		sqlStr.append("  ord.dt_effe                                                                                               ");
		sqlStr.append("  from ci_order ord                                                                                         ");
		sqlStr.append("  inner join " + this.nameTable + " tement on ord.id_en = tement.id_ent and nvl(tement.id_ent, '~') <> '~'  ");
		sqlStr.append("  inner join " + this.nameTable + " temsrvtp on ord.sd_srvtp = temsrvtp.sd_srvtp                            ");
		sqlStr.append("  and nvl(temsrvtp.sd_srvtp, '~') <> '~'                                                                	   ");
		// 含有医疗服务的过滤
		if (!StringUtil.isEmptyWithTrim(this.param.getId_srvs())) {
			sqlStr.append("  inner join " + this.nameTable + " temdepsrv on ord.id_srv = temdepsrv.id_srv                      	   ");
			sqlStr.append("  and nvl(temdepsrv.id_srv,'~') <> '~'                                                              	   ");
		}
		if (!StringUtil.isEmptyWithTrim(this.param.getId_ors()))
			// 医嘱过滤
			// 参数请求中有医嘱ID的，属于报表查询的二次过滤，此时仅仅使用医嘱ID条件
			// 二次过滤的医嘱ID基于第一次查询的结果，所以不用重复使用卡的条件
			sqlStr.append("  inner join " + this.nameTable + " temor on ord.id_or = temor.id_or and nvl(temor.id_or,'~') <> '~'    ");
		sqlStr.append("  inner join ci_or_srv orsrv on ord.id_or = orsrv.id_or   and orsrv.fg_or='Y'  and ord.fg_wholepack='N'     ");
		sqlStr.append("  left join bd_measdoc measdoc on measdoc.id_measdoc = orsrv.id_medu                                        ");
		sqlStr.append("  left join bd_route route on route.id_route = ord.id_route                                                 ");// 拼接用法
		sqlStr.append("  inner join bd_freq freq on freq.id_freq = ord.id_freq                                                     ");
		sqlStr.append("  inner join en_ent enent on ord.id_en = enent.id_ent and enent.fg_ip = 'Y'                                 ");
		if (flag != null && flag.booleanValue())
			sqlStr.append("  and   enent.id_dep_phy = ord.id_dep_or                                                                ");
		sqlStr.append("  inner join mp_or_pr orpr on orpr.id_or = ord.id_or                                                        ");
		// 表单未增加执行状态筛选
		if (StringUtil.isEmptyWithTrim(this.param.getEu_exec()))
			sqlStr.append(" and orpr.eu_su in(0,1,4)                                                                      	       ");
		// 全部
		if ("0".equals(this.param.getEu_exec()))
			sqlStr.append(" and orpr.eu_su in(0,1,2,4)                                                                       	   ");
		// 已执行
		if ("1".equals(this.param.getEu_exec()))
			sqlStr.append(" and orpr.eu_su in(2,4)                                                                                 ");
		// 未执行
		if ("2".equals(this.param.getEu_exec()))
			sqlStr.append(" and orpr.eu_su in(0,1)                                                                                 ");
		sqlStr.append("  and orpr.id_ent = ord.id_en and orpr.dt_mp_plan >= ? and orpr.dt_mp_plan <= ?                             ");
		sqlStr.append("  inner join en_ent_ip enentip on orpr.id_ent = enentip.id_ent                                              ");
		sqlStr.append("  inner join bd_dep dep on enent.id_dep_phy = dep.id_dep                                                    ");
		sqlStr.append("  left   join ci_skin_test rawskin  on rawskin.id_or = ord.id_or                                            ");
		sqlStr.append("  left   join bd_udidoc docraw  on docraw.id_udidoc = rawskin.id_rst_skintest                               ");
		sqlStr.append("  left outer join bd_udidoc docsex on enent.id_sex_pat = docsex.id_udidoc                                   ");
		sqlStr.append("  left outer join bd_udidoc docdripspeed on ord.id_dripspeed = docdripspeed.id_udidoc                       ");
		sqlStr.append("  left join ci_ap_sug apsug on apsug.id_or = ord.id_or                                                      ");// 关联手术申请信息
		sqlStr.append("  left join bd_udidoc docsug on docsug.id_udidoc = apsug.id_surgical_site                                   ");
		sqlStr.append("  left outer join mp_exe_prnt prnt on prnt.id_key = orpr.id_or_pr and prnt.id_prntp = ?                     ");
		sqlStr.append("  where substr(ord.sd_srvtp,0,2) <> '01'   and ord.id_freq <> ?                                             ");
		sqlStr.append("  and ord.fg_chk = 'Y'   and ord.fg_chk_canc = 'N'                                             			   ");
		sqlStr.append(" )                                                                                                          ");
		sqlStr.append(" union all                                                                                                  ");
		sqlStr.append(" (                                                                                                          ");
		sqlStr.append("  select                                                                                                    ");
		sqlStr.append("  ord.id_or as id_or_pr,                                                                                    ");
		sqlStr.append("  null as dt_mp_plan,                                                                                       ");
		sqlStr.append("  null as eu_su,                                                                                            ");
		sqlStr.append("  null as no_bar,                                                                                           ");
		sqlStr.append("  ord.id_or,                                                                                                ");
		sqlStr.append("  ord.code_or,                                                                                              ");
		sqlStr.append("  ord.fg_long,                                                                                              ");
		sqlStr.append("  ord.sd_orsrcfun,                                                                                          ");
		sqlStr.append("  ord.code_entp,                                                                                            ");
		sqlStr.append("  (case when prnt.dt_prnt is null  then null 															   ");
		sqlStr.append("  when TRUNC(SYSDATE)-TO_DATE(substr(prnt.dt_prnt,0,10),'YYYY-MM-DD')<=0  then 1  						   ");
		sqlStr.append("  when TRUNC(SYSDATE)-TO_DATE(substr(prnt.dt_prnt,0,10),'YYYY-MM-DD')>0  then null  end ) as ct_prnt,  	   ");
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
		sqlStr.append("  enent.id_dep_nur,                                                                                         ");// 护理单元
		sqlStr.append("  enentip.name_bed,                                                                                         ");
		sqlStr.append("  enentip.code_amr_ip,                                                                                      ");
		sqlStr.append("  docsex.name name_sex,                                                                                     ");
		sqlStr.append("  docdripspeed.name name_dripspeed,                                                                         ");
		sqlStr.append("  dep.name name_dep_phy,                                                                                    ");
		sqlStr.append("  ord.name_or as name,                                                                                      ");
		sqlStr.append("  0 as srv_sortno,                                                                                          ");
		sqlStr.append("  null as spec,                                                                                             ");
		sqlStr.append("  null as sd_abrd,                                                                                          ");
		sqlStr.append("  null as printname,                                                                                         ");
		sqlStr.append("  orsrv.quan_medu,                                                                                          ");
		sqlStr.append("  measdoc.name name_medu,                                                                                   ");
		sqlStr.append("  route.name as name_route,                                                                                 ");
		sqlStr.append("  route.code as code_route,                                                                                 ");
		sqlStr.append("  ord.id_routedes ,                                                                                         ");//医嘱用法
		sqlStr.append("  null as quan_num_base,                                                                                    ");
		sqlStr.append("  null as quan_den_base,                                                                                    ");
		sqlStr.append("  null as sd_pois,                                                                                          ");
		sqlStr.append("  null as name_mm_medu,                                                                                     ");
		sqlStr.append("  'N'  as  fg_self,                                                                                         ");
		sqlStr.append("  docsug.name as sug_name,                                                                                  ");
		sqlStr.append("  freq.code code_freq,                                                                                      ");
		sqlStr.append("  enentip.times_ip,                                                                                         ");//住院次数
		sqlStr.append("  null  as  name_raw_skin  ,                                                                                ");// 原液皮试
		sqlStr.append("  null  as  name_diag_skin  ,                                                                               ");// 诊疗皮试
		sqlStr.append("  ord.dt_entry ,                                                                                            ");
		sqlStr.append(" null as fg_wholepack,                                                                                      ");// 在院整领
		sqlStr.append(" null as fg_back,                                                                                           ");// 退药标识
		sqlStr.append(" null as fg_highrisk,                                                                                       ");// 高危标识
		sqlStr.append("  ord.dt_effe                                                                                               ");
		sqlStr.append("  from ci_order ord                                                                                         ");
		sqlStr.append("  inner join " + this.nameTable + " tement on ord.id_en = tement.id_ent and nvl(tement.id_ent, '~') <> '~'  ");
		sqlStr.append("  inner join " + this.nameTable + " temsrvtp on ord.sd_srvtp = temsrvtp.sd_srvtp                            ");
		sqlStr.append("  and nvl(temsrvtp.sd_srvtp, '~') <> '~'                                                                	   ");
		// 含有医疗服务的过滤
		if (!StringUtil.isEmptyWithTrim(this.param.getId_srvs())) {
			sqlStr.append("  inner join " + this.nameTable + " temdepsrv on ord.id_srv = temdepsrv.id_srv                     	  ");
			sqlStr.append("  and nvl(temdepsrv.id_srv,'~') <> '~'                                                              	  ");
		}
		if (!StringUtil.isEmptyWithTrim(this.param.getId_ors()))
			// 医嘱过滤
			// 参数请求中有医嘱ID的，属于报表查询的二次过滤，此时仅仅使用医嘱ID条件
			// 二次过滤的医嘱ID基于第一次查询的结果，所以不用重复使用卡的条件
			sqlStr.append("  inner join " + this.nameTable + " temor on ord.id_or = temor.id_or and nvl(temor.id_or,'~') <> '~'    ");
		sqlStr.append("  inner join ci_or_srv orsrv on ord.id_or = orsrv.id_or   and orsrv.fg_or='Y' and ord.fg_wholepack='N'      ");
		sqlStr.append("  left join bd_measdoc measdoc on measdoc.id_measdoc = orsrv.id_medu                                        ");
		sqlStr.append("  left join bd_route route on route.id_route = ord.id_route                                                 ");
		sqlStr.append("  inner join bd_freq freq on freq.id_freq = ord.id_freq                                                     ");
		sqlStr.append("  inner join en_ent enent on ord.id_en = enent.id_ent and enent.fg_ip = 'Y'                                 ");
		if (flag != null && flag.booleanValue())
			sqlStr.append("  and   enent.id_dep_phy = ord.id_dep_or                                                                ");
		sqlStr.append("  inner join en_ent_ip enentip on ord.id_en = enentip.id_ent                                                ");
		sqlStr.append("  inner join bd_dep dep on enent.id_dep_phy = dep.id_dep                                                    ");
		sqlStr.append("  left outer join bd_udidoc docsex on enent.id_sex_pat = docsex.id_udidoc                                   ");
		sqlStr.append("  left outer join bd_udidoc docdripspeed on ord.id_dripspeed = docdripspeed.id_udidoc                       ");
		sqlStr.append("  left join ci_ap_sug apsug on apsug.id_or = ord.id_or                                                      ");// 关联手术申请信息
		sqlStr.append("  left join bd_udidoc docsug on docsug.id_udidoc = apsug.id_surgical_site                                   ");
		sqlStr.append("  left outer join mp_exe_prnt prnt on prnt.id_key = ord.id_or  and prnt.id_prntp = ?                        ");
		sqlStr.append("  where ord.id_freq =  ?  and ord.dt_end >= ?  and ord.dt_effe <= ?		        						   ");
		sqlStr.append("  and ord.fg_chk = 'Y'   and ord.fg_chk_canc = 'N'                                             			   ");
		sqlStr.append(" )                                                                                                          ");
		sqlStr.append(")temtable                                                                                                   ");
		sqlStr.append(" where nvl(temtable.sd_orsrcfun ,'~') <> '2'                                                                ");
		sqlStr.append(" and temtable.code_entp in(" + MpUtils.getIpEntpSqlStrs() + ")                                              ");// 住院、急诊：留观
		// 时间区间过滤
		// 频次过滤
		if (id_freqs != null && id_freqs.length > 0) {
			String whereIn = "";
			for (String id_freq : id_freqs) {
				whereIn += ((whereIn.length() == 0 ? "" : ",") + ("'" + id_freq + "'"));
			}
			sqlStr.append(" and temtable.id_freq  not in (" + whereIn + ")             							                  ");
		}
		// 长临过滤
		if (!StringUtil.isEmptyWithTrim(this.param.getEu_long()))
			sqlStr.append(" and temtable.fg_long = '" + this.param.getEu_long() + "'                                              ");
		// 过滤打印状态
		if ("1".equals(this.param.getEu_print()))
			sqlStr.append("  and temtable.ct_prnt > 0                                                                             ");
		if ("2".equals(this.param.getEu_print()))
			sqlStr.append("  and temtable.ct_prnt is null                                                                         ");
		// 毒麻
		if ("1".equals(this.param.getEu_pois()))
			sqlStr.append("  and temtable.sd_pois > 0                                                                             ");
		// 非毒麻
		if ("2".equals(this.param.getEu_pois()))
			sqlStr.append("  and temtable.sd_pois = 0                                                                             ");
		// 出院带药
		if ("1".equals(this.param.getEu_outp()))
			sqlStr.append("  and temtable.fg_pres_outp ='Y'                                                                       ");
		// 非出院带药
		if ("2".equals(this.param.getEu_outp()))
			sqlStr.append("  and temtable.fg_pres_outp = 'N'                                                                      ");
		sqlStr.append("order  by temtable.name_bed asc,temtable.code_freq asc, temtable.dt_effe asc,temtable.id_or asc,temtable.dt_mp_plan asc, temtable.srv_sortno asc         ");
		return sqlStr.toString();
	}
}