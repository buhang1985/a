package iih.bd.fc.s.bp.deptflow.qry;

import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.s.bp.common.WfUtils;
import iih.bd.srv.srvcate.d.SrvCateDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:获取指定的服务类型信息
 * @author: xu_xing@founder.com.cn
 * @version：2019年1月10日 下午1:33:30 创建
 * @version: xuxing_2019年8月12日10:01:05，增加多组织管控
 */
public class GetSimpleSrvcaSql implements ITransQry {

	private String[] id_srvcas;

	public GetSimpleSrvcaSql(String[] id_srvcas) {
		this.id_srvcas = id_srvcas;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		WfUtils.setSqlParam(param, this.id_srvcas);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                        ");
		sqlStr.append(" ca.id_srvca,                                  ");
		sqlStr.append(" ca.name,                                      ");
		sqlStr.append(" ca.innercode                                  ");
		sqlStr.append(" from bd_srvca ca                              ");
		sqlStr.append(" inner join                                    ");
		sqlStr.append(" (                                             ");
		sqlStr.append("   select                                      ");
		sqlStr.append("   id_srvca,                                   ");
		sqlStr.append("   name,                                       ");
		sqlStr.append("   id_parent,                                  ");
		sqlStr.append("   innercode                                   ");
		sqlStr.append("   from bd_srvca srvca                         ");
		sqlStr.append("   where srvca.ds = 0                          ");
		sqlStr.append("   and " + new BdFcEnvContextUtil().getWherePart(new SrvCateDO(), "srvca"));
		String whereInStr = WfUtils.getSqlParamChars(this.id_srvcas);
		if (!StringUtil.isEmptyWithTrim(whereInStr))
			sqlStr.append(" and srvca.id_srvca in(" + whereInStr + ") ");
		else
			sqlStr.append(" and 1 = 2                             ");
		sqlStr.append(" )tem on ca.innercode like tem.innercode||'%'  ");
		sqlStr.append(" where ca.ds = 0                               ");
		return sqlStr.toString();
	}
}
