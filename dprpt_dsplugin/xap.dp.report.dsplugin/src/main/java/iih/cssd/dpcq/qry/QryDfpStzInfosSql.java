package iih.cssd.dpcq.qry;

import java.util.ArrayList;

import com.software.vtreport.data.reader.sql.RptSqlParam;

import xap.dp.report.data.reader.sqlqryutil.InfRptSql;
import xap.dp.report.data.reader.sqlqryutil.RptQryUtil;

/**
 * 查询灭菌锅次信息
 * 
 * @author fengjj
 * @version:2020年1月13日15:07:15,创建
 */
public class QryDfpStzInfosSql implements InfRptSql {

	private String[] no_bars;

	public QryDfpStzInfosSql(String[] no_bar) {
		this.no_bars = no_bar;
	}

	@Override
	public RptSqlParam[] getSqlParams() {
		ArrayList<RptSqlParam> params_list = new ArrayList<>(no_bars.length);
		for (String no_bar : no_bars) {
			params_list.add(new RptSqlParam(no_bar, String.class));
		}
		RptSqlParam[] arr_params = params_list.toArray(new RptSqlParam[0]);
		params_list.clear();
		return arr_params;
	}

	@Override
	public String getQrySql() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("    SELECT stz.sortno,                                                                                    ");
		sqlStr.append("           stz.dt_stz,                                                                                    ");
		sqlStr.append("           stz.no_bar,                                                                                    ");
		sqlStr.append("           inst.name as name_instr,                                                                       ");
		sqlStr.append("           stztp.name as Name_stztp,                                                                      ");
		sqlStr.append("           psn.name as Name_emp_stz,                                                                      ");
		sqlStr.append("           dep.name as name_dep_stz,                                                                      ");
		sqlStr.append("           itm.id_dfp,                                                                                    ");
		sqlStr.append("           dfp.id_pkg,                                                                                    ");
		sqlStr.append("           dfp.name as Name_dfp,                                                                          ");
		sqlStr.append("           pkg.name as Name_pkg,                                                                          ");
		sqlStr.append("           dfp.no_bar as dfp_no_bar,                                                                      ");
		sqlStr.append("           itm.dt_chk,                                                                                    ");
		sqlStr.append("           chkemp.name as name_emp_chk,                                                                   ");
		sqlStr.append("           chkdep.name as name_dep_chk                                                                    ");
		sqlStr.append("     FROM cssd_dfp_stz stz                                                                                ");
		sqlStr.append("    inner join cssd_dfp_stz_itm itm on stz.id_dfp_stz=itm.id_dfp_stz                                      ");
		sqlStr.append("    inner join cssd_dfp dfp on itm.id_dfp = dfp.id_dfp                                                    ");
		sqlStr.append("    inner join cssd_pkg pkg on dfp.id_pkg = pkg.id_pkg                                                    ");
		sqlStr.append("    inner join cssd_instr inst on inst.id_instr = stz.id_dfp_instr                                        ");
		sqlStr.append("    inner join bd_udidoc stztp on stztp.id_udidoc = stz.id_pkgstz                                         ");
		sqlStr.append("    inner join bd_psndoc psn on psn.id_psndoc = stz.id_emp_stz                                            ");
		sqlStr.append("    inner join bd_dep dep on dep.id_dep = stz.id_dep_stz                                                  ");
		sqlStr.append("    left join bd_psndoc chkemp on chkemp.id_psndoc = itm.id_emp_chk                                       ");
		sqlStr.append("    left join bd_dep chkdep on chkdep.id_dep = itm.id_dep_chk                                             ");
		sqlStr.append("    where 1=1												                                             ");
		String sql_wherein_params = RptQryUtil.buildSqlParamsWhereIn(no_bars.length);
		sqlStr.append("    and stz.no_bar in (").append(sql_wherein_params).append(")                                            ");
		sqlStr.append("    order by stz.dt_stz,stz.no_bar                                                                        ");
		return sqlStr.toString();
	}
}
