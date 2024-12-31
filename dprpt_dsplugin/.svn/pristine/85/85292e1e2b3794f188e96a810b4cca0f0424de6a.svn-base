package iih.cssd.dfp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:消毒包标签打印查询逻辑
 * @author: xu_xing@founder.com.cn
 * @version：2019年9月22日 上午11:27:21 创建
 */
public class GetDfpInfoSql implements ITransQry {

	private String[] id_dfps;

	public GetDfpInfoSql(String[] id_dfps) {
		this.id_dfps = id_dfps;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam("@@@@ZZ200000000000NL");
		sqlParam.addParam("@@@@ZZ200000000000MQ");
		sqlParam.addParam("@@@@ZZ200000000000MR");
		sqlParam.addParam("@@@@ZZ200000000000MV");
		for (String id_dfp : id_dfps) {
			sqlParam.addParam(id_dfp);
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                                              ");
		sqlStr.append(" dfp.id_dfp,                                                                                         ");
		sqlStr.append(" dfp.name,                                                                                           ");
		sqlStr.append(" dfp.no_bar,                                                                                         ");
		sqlStr.append(" docpkgtp.name as name_pkgtp,                                                                        ");
		sqlStr.append(" dfp.dt_effe,                                                                                        ");
		sqlStr.append(" dfp.dt_inval,                                                                                       ");
		sqlStr.append(" dfp.spec,                                                                                           ");
		sqlStr.append(" doccln.name as name_pkgclean,                                                                       ");
		sqlStr.append(" dfp.dt_srlz,                                                                                        ");
		sqlStr.append(" docsstz.name as name_pkgstz,                                                                        ");
		sqlStr.append(" docmtr.name as name_pkgmtr,                                                                         ");
		sqlStr.append(" psn.name as name_emp_prd,                                                                           ");
		sqlStr.append(" dep.name as name_dep_prd,                                                                           ");
		sqlStr.append(" dfp.dt_prd,                                                                                         ");
		sqlStr.append(" dfp.note,                                                                                           ");
		sqlStr.append(" dfpmm.name as mm_name,                                                                              ");
		sqlStr.append(" dfpmm.quan as mm_quan,                                                                              ");
		sqlStr.append(" pkgunit.name as name_unit_pkgbase                                                                   ");
		sqlStr.append(" FROM cssd_dfp dfp                                                                                   ");
		sqlStr.append(" inner join cssd_dfp_mm dfpmm on dfp.id_dfp = dfpmm.id_dfp                                           ");
		sqlStr.append(" inner join bd_udidoc docpkgtp on docpkgtp.id_udidoc = dfp.id_pkgtp and docpkgtp.id_udidoclist = ?   ");
		sqlStr.append(" left join bd_udidoc doccln on doccln.id_udidoc = dfp.id_pkgclean and doccln.id_udidoclist = ?       ");
		sqlStr.append(" left join bd_udidoc docsstz on docsstz.id_udidoc = dfp.id_pkgstz and docsstz.id_udidoclist = ?      ");
		sqlStr.append(" left join bd_udidoc docmtr on docmtr.id_udidoc = dfp.id_pkgmtr and docmtr.id_udidoclist = ?         ");
		sqlStr.append(" left join bd_psndoc psn on dfp.id_emp_prd = psn.id_psndoc                                           ");
		sqlStr.append(" left join bd_dep dep on dep.id_dep = dfp.id_dep_prd                                                 ");
		sqlStr.append(" left join bd_measdoc pkgunit on dfpmm.id_unit_pkgbase = pkgunit.id_measdoc                          ");
		sqlStr.append(" where dfp.ds = 0                                                                                    ");
		String whereIn = "";
		for (int i = 0; i < id_dfps.length; i++) {
			whereIn += (whereIn.length() == 0 ? "" : ",") + "?";
		}
		sqlStr.append(" and dfp.id_dfp in (" + whereIn + ")                                                                 ");
		sqlStr.append(" order by dfp.no_bar asc                                                                             ");
		return sqlStr.toString();
	}
}
