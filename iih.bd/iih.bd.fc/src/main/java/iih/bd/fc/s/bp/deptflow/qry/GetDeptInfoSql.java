package iih.bd.fc.s.bp.deptflow.qry;

import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.s.bp.common.WfUtils;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * @Description:获取医嘱流向部门信息
 * @author: xu_xing@founder.com.cn
 * @version：2019年1月10日 下午12:37:43 创建
 * @version: xuxing_2019年8月12日10:01:05，增加多组织管控
 */
public class GetDeptInfoSql implements ITransQry {

	private String[] id_deps;

	public GetDeptInfoSql(String[] id_deps) {
		this.id_deps = id_deps;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		WfUtils.setSqlParam(param, this.id_deps);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                            ");
		sqlStr.append(" dep.id_dep as id_dep_mp,                          ");
		sqlStr.append(" dep.name as name_dep_mp,                          ");
		sqlStr.append(" org.id_org as id_org_mp,                          ");
		sqlStr.append(" org.code as code_org,                             ");
		sqlStr.append(" org.name as name_org                              ");
		sqlStr.append(" from bd_dep dep                                   ");
		sqlStr.append(" left join bd_org org on dep.id_org = org.id_org   ");
		sqlStr.append(" where dep.ds = 0                                  ");
		sqlStr.append(" and " + new BdFcEnvContextUtil().getWherePart(new DeptDO(), "dep"));
		sqlStr.append(" and org.ds = 0                                    ");
		String whereInStr = WfUtils.getSqlParamChars(this.id_deps);
		if (!StringUtil.isEmptyWithTrim(whereInStr)) {
			sqlStr.append(" and dep.id_dep in ( " + whereInStr + " )      ");
		}else{
			sqlStr.append(" and 1 = 2                                     ");
		}
		return sqlStr.toString();
	}
}
