package iih.mp.nr.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:输液贴数据获取
 * @author: xu_xing@founder.com.cn
 * @version：2018年8月28日 上午9:38:44 创建
 */
public class GetInfuLableSql implements ITransQry {


	private String fg_pois;
	private String orprTemp;

	public void setOrprTemp(String orprTemp) {
		this.orprTemp = orprTemp;
	}


	public GetInfuLableSql(String fg_pois, String paramcode) {
		this.fg_pois = fg_pois;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
//		if(!StringUtil.isEmptyWithTrim(paramcode))
//			param.addParam(this.paramcode);

		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                                        ");
		sqlStr.append(" orpr.id_or_pr,                                                                                ");
		sqlStr.append(" orpr.id_or,                                                                                   ");
		sqlStr.append(" orpr.no_bar,                                                                                  ");
		sqlStr.append(" enent.name_pat,                                                                               ");
		sqlStr.append(" docsex.name as name_sex,                                                                      ");
		sqlStr.append(" enent.dt_birth_pat,                                                                           ");
		sqlStr.append(" enentip.name_bed,                                                                             ");
		sqlStr.append(" freq.code as code_freq,                                                                       ");
		sqlStr.append(" route.name as name_route,                                                                     ");
		sqlStr.append(" enentip.code_amr_ip,                                                                       ");
		sqlStr.append(" orpr.dt_mp_plan,                                                                              ");
		sqlStr.append(" orsrv.id_orsrv,                                                                               ");
		sqlStr.append(" orsrv.name,                                                                                   ");
		sqlStr.append(" ord.des_or,                                                                                   ");
		sqlStr.append(" mm.spec,                                                                                      ");
		sqlStr.append(" orsrv.quan_medu,                                                                              ");
		sqlStr.append(" measdoc.name as name_measdoc,                                                                 ");
		sqlStr.append(" ord.dt_effe as dt_effe,                                                                       ");
		sqlStr.append(" drug.fg_highrisk                                                                              ");
		
		sqlStr.append(" from "+this.orprTemp+" orpr                                                                            ");
	//	sqlStr.append(" inner join mp_or_pr orpr on orpr.id_or_pr = temp.id_or_pr ");
		sqlStr.append(" inner join ci_order  ord on ord.id_or = orpr.id_or                                    ");
		sqlStr.append(" inner join en_ent enent on enent.id_ent = ord.id_en                                          ");
		sqlStr.append(" left join en_ent_ip enentip on enentip.id_ent = enent.id_ent                                  ");
		sqlStr.append(" left join bd_freq freq on freq.id_freq = ord.id_freq                                         ");
		sqlStr.append(" left join bd_route route on route.id_route = ord.id_route                                    ");
		sqlStr.append(" left join bd_udidoc docsex on docsex.id_udidoc = enent.id_sex_pat                             ");
		sqlStr.append(" inner join ci_or_srv orsrv on orsrv.id_or = orpr.id_or and substr(orsrv.sd_srvtp,0,2) = '01'  ");
		sqlStr.append(" left join ci_or_srv_mm orsrvmm on orsrv.id_orsrv = orsrvmm.id_orsrv                           ");
		sqlStr.append(" left join bd_srv_drug drug on drug.id_srv = ord.id_srv                                        ");
		sqlStr.append(" left outer join bd_mm mm  on mm.id_mm = orsrvmm.id_mm                                         ");
		sqlStr.append(" left outer join bd_measdoc measdoc  on measdoc.id_measdoc = orsrv.id_medu                     ");
		sqlStr.append(" where substr(ord.sd_srvtp,0,2) = '01'                                                        ");
		sqlStr.append("        and ord.sd_orsrcfun<>'2'                                                 ");
		sqlStr.append(" and enent.fg_ip = 'Y'                                                                         ");
		//毒麻标识
		if(fg_pois.equals("True")){
			sqlStr.append(" and  orsrvmm.sd_pois not in ('0','5')                                                     ");
		}
		//静配的药不打印输液贴,此字段为物资仓库（药品流向）
//		if(!StringUtil.isEmptyWithTrim(paramcode))
//			sqlStr.append(" and orsrv.id_dep_wh <> ?                                                                  ");
		sqlStr.append(" and enent.code_entp = '10'                                                                    ");
		sqlStr.append(" order by enentip.name_bed asc, enentip.name_bed,orpr.dt_mp_plan,orpr.id_or,orsrv.sortno asc                      ");
		return sqlStr.toString();
	}
}
