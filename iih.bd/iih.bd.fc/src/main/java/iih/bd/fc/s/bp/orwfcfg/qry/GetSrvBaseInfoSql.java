package iih.bd.fc.s.bp.orwfcfg.qry;

import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:获取医疗服务的基本信息
 * @author: xu_xing@founder.com.cn
 * @version：2019年5月5日 下午3:35:51 创建
 * @version: 2019年5月7日13:19:58，移除物品限制（此查询针对全部的服务）
 * @version: xuxing_2019年8月12日10:01:05，增加多组织管控
 */
public class GetSrvBaseInfoSql implements ITransQry {

	private String id_srv;

	public GetSrvBaseInfoSql(String id_srv) {
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
		sqlStr.append(" srv.sd_srvtp,                                              ");
		sqlStr.append(" srv.id_srvca,                                              ");
		sqlStr.append(" drug.id_dosage,                                            ");
		sqlStr.append(" drug.sd_dosage,                                            ");
		sqlStr.append(" drug.sd_pois,                                              ");
		sqlStr.append(" mm.id_mm,                                                  ");
		sqlStr.append(" mm.sd_herbpreparationtp                                    ");
		sqlStr.append(" from bd_srv srv                                            ");
		sqlStr.append(" left join bd_srv_drug drug on drug.id_srv = srv.id_srv     ");
		sqlStr.append(" left join bd_mm mm on mm.id_srv = srv.id_srv               ");
		sqlStr.append(" where srv.fg_active = 'Y'                                  ");
		sqlStr.append(" and " + new BdFcEnvContextUtil().getWherePart(new MedSrvDO(), "srv"));
		sqlStr.append(" and srv.id_srv = ?                                         ");	
		return sqlStr.toString(); 
	}
}
