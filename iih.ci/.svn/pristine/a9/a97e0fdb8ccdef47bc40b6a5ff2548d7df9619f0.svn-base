package iih.ci.ord.s.external.blood.ruimei.s.bp;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class UserInfoSql  implements ITransQry {


	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {

		StringBuffer sqlStr = new StringBuffer();

		sqlStr.append(" select                                                            ");
		sqlStr.append(" userinfo.code,                                          		  ");//用户编码
		sqlStr.append(" userinfo.name,                                        			  ");//用户名
		sqlStr.append(" org.code as code_org,                                             ");
		sqlStr.append(" org.name as name_org,                                             ");
		sqlStr.append(" dep.code as code_dep,                                             ");//用户所在科室
		sqlStr.append(" dep.name as name_dep,                                             ");
		sqlStr.append(" psn.code as code_psn,                                             ");
		sqlStr.append(" psn.name as name_psn,                                             ");
		sqlStr.append(" (                                                                 ");
		sqlStr.append("   case concat(contitm.id_dep_cont_itm,'#')                        ");
		sqlStr.append("     when '#' then docwork.code                                    ");
		sqlStr.append("       else depcont.code end                                       ");
		sqlStr.append(" )as code_empwktp,                                                 ");
		sqlStr.append(" (                                                                 ");
		sqlStr.append("   case concat(contitm.id_dep_cont_itm,'#')                        ");
		sqlStr.append("     when '#' then docwork.name                                    ");
		sqlStr.append("       else depcont.name end                                       ");
		sqlStr.append(" )as UserJob,                                                	  ");//工作类别
		sqlStr.append(" doctitle.code as code_title,                                      ");
		sqlStr.append(" doctitle.name as name_title,                                      ");
		sqlStr.append(" userinfo.sv                                                       ");
		sqlStr.append(" from sys_user userinfo                                            ");
		sqlStr.append(" left join bd_org org on org.id_org=userinfo.id_org                ");
		sqlStr.append(" left join bd_psndoc psn on psn.id_psndoc=userinfo.id_psn          ");
		sqlStr.append(" left join bd_dep dep on dep.id_dep=psn.id_dep                     ");
		sqlStr.append(" left join bd_dep_cont_itm contitm on contitm.id_dep=psn.id_dep    ");
		sqlStr.append(" left join bd_dep_cont depcont on depcont.id_dep_cont=contitm.id_dep_cont ");
		sqlStr.append(" left join bd_udidoc docwork on docwork.id_udidoc=psn.id_empwktp   ");
		sqlStr.append(" left join bd_udidoc doctitle on doctitle.id_udidoc=psn.id_psnpost ");
		sqlStr.append(" where userinfo.activestate='2'                                    ");
		sqlStr.append(" and psn.activestate='2'                                           ");
		sqlStr.append(" order by userinfo.code asc                                        ");

		return sqlStr.toString();
	}


}
