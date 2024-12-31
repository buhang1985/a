package iih.bd.fc.s.bp.orwfcfg.qry;

import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.wf.d.WfDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:获取医嘱流向索引
 * @author: xu_xing@founder.com.cn
 * @version：2019年4月26日 下午6:21:53 创建
 * @version: xuxing_2019年8月12日10:01:05，增加多组织管控
 */
public class GetWfSrvtpIndexSql implements ITransQry {

	public GetWfSrvtpIndexSql() {
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
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
		sqlStr.append(" and " + new BdFcEnvContextUtil().getWherePart(new WfDO(), "wf"));
		sqlStr.append(" and wfsrvtp.ds = 0                                ");	
		return sqlStr.toString();
	}

}
