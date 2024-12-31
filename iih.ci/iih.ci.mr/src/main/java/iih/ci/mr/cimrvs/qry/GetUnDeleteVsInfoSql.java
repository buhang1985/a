package iih.ci.mr.cimrvs.qry;

import iih.bd.bc.udi.pub.IMpNsDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取不能删除的体征信息
 * 
 * @author xuxing_2017年12月7日17:44:53
 *
 */
public class GetUnDeleteVsInfoSql implements ITransQry {

	private String[] id_mr_vs;

	public GetUnDeleteVsInfoSql(String[] id_mr_vs) {
		this.id_mr_vs = id_mr_vs;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(IMpNsDictCodeConst.SD_MRVTEV);
		if (id_mr_vs != null && id_mr_vs.length > 0) {
			for (String id : id_mr_vs) {
				param.addParam(id);
			}
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                          ");
		sqlStr.append(" enent.name_pat,                                                                 ");
		sqlStr.append(" vs.dt_vt,                                                                       ");
		sqlStr.append(" doc.name                                                                        ");
		sqlStr.append(" from ci_mr_vs_itm itm                                                           ");
		sqlStr.append(" inner join ci_mr_vs vs on vs.id_mr_vs=itm.id_mr_vs                              ");
		sqlStr.append(" inner join bd_mrtpl_vs_itm vsitm on itm.id_mrtpl_vs_itm=vsitm.id_mrtpl_vs_itm   ");
		sqlStr.append(" and vsitm.sd_dataorigin=?                                                       ");
		sqlStr.append(" inner join en_ent enent on enent.id_ent=vs.id_ent                               ");
		sqlStr.append(" left join bd_udidoc doc on doc.id_udidoc=itm.id_value                           ");
		sqlStr.append(" where doc.ctrl1='Y'                                                             ");
		if (id_mr_vs != null && id_mr_vs.length > 0) {
			String wherePart = "";
			for (int i = 0; i < id_mr_vs.length; i++) {
				wherePart += ((wherePart.length() == 0 ? "" : ",") + "?");
			}
			sqlStr.append(" and vs.id_mr_vs in (" + wherePart + ")");
		} else {
			sqlStr.append(" and 1=2 ");
		}
		return sqlStr.toString();
	}
}
