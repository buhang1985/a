package iih.bd.fc.s.bp.deptflow.qry;

import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.wf.d.WfDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:获取流向服务类型信息
 * @author: xu_xing@founder.com.cn
 * @version：2019年1月10日 下午12:26:25 创建
 * @version: xuxing_2019年8月12日10:01:05，增加多组织管控
 * @version：zhongcl_2020年3月28日11:54:09，增加就诊类型参数过滤。
 */
public class GetWfSrvtpSql implements ITransQry {

	private String code_ent;

	public GetWfSrvtpSql(String code_ent) {
		super();
		this.code_ent = code_ent;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(code_ent);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                            ");
		sqlStr.append(" wfsrvtp.id_wfsrvtp,                               ");
		sqlStr.append(" wf.id_wf,                                         ");
		sqlStr.append(" wf.code_entp,                                     ");
		sqlStr.append(" wf.eu_wftp,                                       ");
		sqlStr.append(" wfsrvtp.sd_srvtp                                  ");
		sqlStr.append(" from bd_wf_srvtp wfsrvtp                          ");
		sqlStr.append(" inner join bd_wf wf on wf.id_wf = wfsrvtp.id_wf   ");
		sqlStr.append(" where wf.ds = 0                                   ");
		sqlStr.append(" and wfsrvtp.ds = 0                                ");
		sqlStr.append(" and wf.code_entp=?                                ");
		sqlStr.append(" and " + new BdFcEnvContextUtil().getWherePart(new WfDO(), "wf"));
		return sqlStr.toString();
	}
}
