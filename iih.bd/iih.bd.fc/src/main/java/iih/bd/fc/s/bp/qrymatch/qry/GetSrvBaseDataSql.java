package iih.bd.fc.s.bp.qrymatch.qry;

import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:获取医疗服务的基本信息
 * @author: tiancj@founder.com.cn
 * @version：2019年11月25日 下午3:35:51 创建
 */
public class GetSrvBaseDataSql implements ITransQry {
	
	private String id_srv;

	public GetSrvBaseDataSql(String id_srv) {
		this.id_srv = id_srv;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this.id_srv);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                     ");
		sqlStr.append(" srv.id_srv,                                                ");
		sqlStr.append(" srv.sd_srvtp                                               ");
		sqlStr.append(" from bd_srv srv                                            ");
		sqlStr.append(" where srv.fg_active = 'Y'                                  ");
		sqlStr.append(" and " + new BdFcEnvContextUtil().getWherePart(new MedSrvDO(), "srv"));
		sqlStr.append(" and srv.id_srv = ?                                         ");	
		return sqlStr.toString(); 
	}
}

