package iih.nmr.fivecolor.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:查询孕妇五色卡打印信息
 * @Author:dukx
 * @Version:2019年9月26日上午10:27:54
 *
 */
public class GetFiveColorInfoSql implements ITransQry {

	private String id_ent;

	public GetFiveColorInfoSql(String id_ent) {
		this.id_ent = id_ent;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_ent);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                          ");
		sqlStr.append(" ent.name_pat,                                                   ");
		sqlStr.append(" ent.dt_birth_pat,                                               ");
		sqlStr.append(" pat.id_code as id_card,                                         ");
		sqlStr.append(" ent.addr_pat,                                                   ");
		sqlStr.append(" ent.telno_pat as tel_pat,                                       ");
		sqlStr.append(" di.name_didef_dis as name_didef_dic,                            ");
		sqlStr.append(" fcapp.createdtime as dt_assess,                                 ");
		sqlStr.append(" fcapp.eu_color,                                                 ");
		sqlStr.append(" fcapp.name                                                      ");
		sqlStr.append(" from en_ent ent                                                 ");
		sqlStr.append(" inner join pi_pat pat on pat.id_pat=ent.id_pat                  ");
		sqlStr.append(" left join nmr_pkuf_fcapp fcapp on fcapp.id_ent = ent.id_ent     ");
		sqlStr.append(" left join en_ent_di di on di.id_ent=ent.id_ent and di.fg_maj = 'Y' ");
		sqlStr.append(" where ent.id_ent=?                                              ");
		sqlStr.append(" order by dt_assess desc ");
		return sqlStr.toString();
	}
}
