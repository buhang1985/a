package iih.cssd.dpus.dfpapp.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetDfpusAppListSql implements ITransQry {
	private String id_dfp_app;

	public GetDfpusAppListSql(String id_dfp_app) {
		this.id_dfp_app = id_dfp_app;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("     SELECT app.id_dfp_app,                                                                ");
		sqlStr.append("            app.draw_no,                                                                   ");
		sqlStr.append("            dep.name name_acc_dep,                                                         ");
		sqlStr.append("            emp.name name_acc_emp,                                                         ");
		sqlStr.append("            dt_acc,                                                                        ");
		sqlStr.append("            chkemp.name name_chk_emp,                                                      ");
		sqlStr.append("            dt_chk,                                                                        ");
		sqlStr.append("            pkg.name name_app_pkg,                                                         ");
		sqlStr.append("            app_num,                                                                       ");
		sqlStr.append("            pkgtp.name  name_pkgtp，                                                  									      ");
		sqlStr.append("            clean.name  name_pkgclean，                                                 									  ");
		sqlStr.append("            stz.name  name_pkgstz，                                                									      ");
		sqlStr.append("            mtr.name  name_pkgmtr，                                                  								          ");
		sqlStr.append("            itm.spec，                                                                  											      ");
		sqlStr.append("            itm.days_effec                                                                 ");
		sqlStr.append("     FROM CSSD_DFP_APP app                                                                 ");
		sqlStr.append("            left join CSSD_DFP_APP_itm itm on app.id_dfp_app = itm.id_dfp_app              ");
		sqlStr.append("            left join cssd_pkg pkg on pkg.id_pkg = itm.id_app_pkg                          ");
		sqlStr.append("            left join bd_udidoc pkgtp on pkgtp.id_udidoc = pkg.id_pkgtp                    ");
		sqlStr.append("            left join bd_udidoc clean on clean.id_udidoc = pkg.id_pkgclean                 ");
		sqlStr.append("            left join bd_udidoc stz on stz.id_udidoc = pkg.id_pkgstz                       ");
		sqlStr.append("            left join bd_udidoc mtr on mtr.id_udidoc = pkg.id_pkgmtr                       ");
		sqlStr.append("            left join bd_dep dep on dep.id_dep = app.id_acc_dep                            ");
		sqlStr.append("            left join bd_psndoc emp on emp.id_psndoc = app.id_acc_emp                      ");
		sqlStr.append("            left join bd_psndoc chkemp on chkemp.id_psndoc = app.id_chk_emp                ");
		if (!StringUtil.isEmptyWithTrim(this.id_dfp_app))
			sqlStr.append("    where  app.id_dfp_app  in (" + this.id_dfp_app + ")                                 ");
		else
			sqlStr.append("     where 1=2                                                               		   ");
			
		return sqlStr.toString();
	}
}
