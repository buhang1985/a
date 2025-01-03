package iih.bd.fc.orwf.s.qry;

import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.wf.d.WfDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description: 医嘱流向2.0树查询逻辑
 * @author: xu_xing@founder.com.cn
 * @version：2019年4月18日 下午1:21:59 创建
 * @version: xuxing_2019年8月12日10:01:05，增加多组织管控
 * @version:zhongcl 2020年3月29日14:13:05,过滤掉非末级的就诊类型.
 */
public class GetWfCfgTreeSql implements ITransQry {

	public GetWfCfgTreeSql() {

	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append(" select* from (                       ");
		sqlStr.append(" (                                    ");
		sqlStr.append("   select                             ");
		sqlStr.append("   en.id_entp as id_entporwf,         ");
		sqlStr.append("   en.code as code,                   ");
		sqlStr.append("   en.name as name,                   ");
		sqlStr.append("   null as id_parent,                 ");
		sqlStr.append("   1 as type,                         ");
		sqlStr.append("   null as eu_wftp                    ");
		sqlStr.append("   from bd_entp en                    ");
		sqlStr.append(" where en.fg_leaf='Y'                 ");
		sqlStr.append(" )                                    ");
		sqlStr.append(" union all                            ");
		sqlStr.append(" (                                    ");
		sqlStr.append(" 	select                           ");
		sqlStr.append(" 	wf.id_wf as id_entporwf,         ");
		sqlStr.append(" 	wf.code,                         ");
		sqlStr.append(" 	wf.name,                         ");
		sqlStr.append(" 	wf.id_entp as id_parent,         ");
		sqlStr.append("     0 as type,                       ");
		sqlStr.append("     wf.eu_wftp as eu_wftp	         ");
		sqlStr.append(" 	from bd_wf wf                    ");
		sqlStr.append("     where " + new BdFcEnvContextUtil().getWherePart(new WfDO(), "wf"));
		sqlStr.append(" )                                    ");
		sqlStr.append(")tem order by code asc                ");
		return sqlStr.toString();
	}
}
