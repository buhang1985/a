package iih.dg.herbaldelivery.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:获取草药处方配送单信息
 * @author: xu_xing@founder.com.cn
 * @version：2019年3月21日 下午4:44:52 创建
 */
public class GetHerbDelvyQry implements ITransQry {

	private String id_pres;

	public GetHerbDelvyQry(String id_pres) {
		this.id_pres = id_pres;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this.id_pres);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                   ");
		sqlStr.append(" orsrv.id_pres,                                                           ");
		sqlStr.append(" hb.name_recv,                                                            ");
		sqlStr.append(" hb.tel_recv,                                                             ");
		sqlStr.append(" hb.add_recv,                                                             ");
		sqlStr.append(" ent.name_pat,                                                            ");
		sqlStr.append(" ent.code as code_ent,                                                    ");
		sqlStr.append(" ord.orders,                                                              ");
		sqlStr.append(" route.name as name_route,                                                ");
		sqlStr.append(" orsrv.name as name_drug,                                                 ");
		sqlStr.append(" orsrv.quan_medu as quan,                                                 ");
		sqlStr.append(" measdoc.name as pkug,                                                    ");
		sqlStr.append(" fr.code as code_freq,                                                    ");
		sqlStr.append(" bo.name as name_boil,                                                    ");
		sqlStr.append(" bos.name as name_boildes,                                                ");
		sqlStr.append(" ord.des_or                                                               ");
		sqlStr.append(" from ci_or_srv orsrv                                                     ");
		sqlStr.append(" inner join ci_order ord on ord.id_or = orsrv.id_or                       ");
		sqlStr.append(" inner join en_ent ent on ent.id_ent = ord.id_en                          ");
		sqlStr.append(" inner join mp_dg_presst presst on presst.id_pres = orsrv.id_pres         ");
		sqlStr.append(" left join bd_route route on route.id_route = ord.id_route                ");
		sqlStr.append(" left join mp_dg_herbdelvr hb on presst.id_herbdelvr = hb.id_herbdelvr    ");
		sqlStr.append(" left join bd_freq fr on orsrv.id_freq = fr.id_freq                       ");
		sqlStr.append(" left join bd_boil bo on orsrv.id_boil = bo.id_boil                       ");
		sqlStr.append(" left join bd_boil_des bos on orsrv.id_boildes = bos.id_boildes           ");
		sqlStr.append(" left join bd_measdoc measdoc on measdoc.id_measdoc = orsrv.id_medu       ");
		sqlStr.append(" where orsrv.id_pres = ?                                                  ");
		return sqlStr.toString();
	}
}
