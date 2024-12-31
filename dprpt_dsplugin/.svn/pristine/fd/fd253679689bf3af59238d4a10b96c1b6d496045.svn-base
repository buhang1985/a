package iih.mp.orm.sugnuremp.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 手术护士工作量统计查询
 * 
 * @author tian.cjFounder
 * @version 2020-01-15 10:11:11
 */
public class GetSugNurWorkWorkSql implements ITransQry {

	private String id_dept_exec;
	private String dt_st_op;
	private String dt_ed_op;

	public GetSugNurWorkWorkSql(String id_dept_exec, String dt_st_op, String dt_ed_op) {
		this.id_dept_exec = id_dept_exec;
		this.dt_st_op = dt_st_op;
		this.dt_ed_op = dt_ed_op;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (!StringUtil.isEmptyWithTrim(this.id_dept_exec)) {
			param.addParam(this.id_dept_exec);
		}
		if (!StringUtil.isEmptyWithTrim(this.dt_st_op)) {
			param.addParam(this.dt_st_op);
		}
		if (!StringUtil.isEmptyWithTrim(this.dt_ed_op)) {
			param.addParam(this.dt_ed_op);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("   select                                                                                                                        ");
		sb.append("   dep.name as id_dep_name,                                                                                                      ");
		sb.append("   dep.id_dep as id_dept_exec,                                                                                                   ");
		sb.append("   docname.name as sug_nur_name,                                                                                                 ");
		sb.append("   sugnur.id_emp as id_emp,                                                                                                      ");
		sb.append("   docvl.name as lvlsug_name,                                                                                                    ");
		sb.append("   sugapp.id_lvlsug  as id_lvlsug,                                                                                               ");
		sb.append("   count(dep.name) as  sug_num                                                                                                   ");
		sb.append("   from mp_orm_sug_emp sugnur                                                                                                    ");
		sb.append("   inner join mp_orm_app_sug sugapp on sugapp.id_apopcf = sugnur.id_apopcf                                                       ");
		sb.append("   inner join mp_or_pr pr on pr.id_or_pr = sugapp.id_or_pr                                                                       ");
		sb.append("   inner join  bd_udidoc roleinfo on roleinfo.id_udidoc= sugnur.id_role                                                          ");
		sb.append("   left join bd_psndoc docname on docname.id_psndoc = sugnur.id_emp                                                              ");
		sb.append("   left join bd_udidoc docvl on docvl.id_udidoc = sugapp.id_lvlsug                                                               ");
		sb.append("   left join bd_dep  dep on dep.id_dep = sugapp.id_dept_exec                                                                     ");
		sb.append("   where pr.eu_su='4'                                                                                                            ");
		sb.append("   and sugnur.id_role in('@@@@Z8100000000HD19T','@@@@Z8100000000HD19E','@@@@Z8100000000HD19O','@@@@Z8100000000HD19Y')            ");
		if (!StringUtil.isEmptyWithTrim(this.id_dept_exec)) {
			sb.append("   and    sugapp.id_dept_exec=?                                                                                               ");
		}
		if (!StringUtil.isEmptyWithTrim(this.dt_st_op)) {
			sb.append("  and     sugapp.dt_st_op>=?                                                                                                  ");
		}
		if (!StringUtil.isEmptyWithTrim(this.dt_ed_op)) {
			sb.append("  and     sugapp.dt_ed_op<=?                                                                                                  ");
		}
		sb.append("   group by  dep.name,docname.name,docvl.name,dep.id_dep,sugnur.id_emp,sugapp.id_lvlsug                                           ");
		sb.append("   order by dep.name, docname.name                                                                                                ");
		return sb.toString();
	}

}
