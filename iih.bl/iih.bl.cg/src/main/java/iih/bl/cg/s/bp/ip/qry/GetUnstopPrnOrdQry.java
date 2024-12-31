package iih.bl.cg.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取未停止的持续医嘱数量
 * @author LIM
 *
 */
public class GetUnstopPrnOrdQry  implements ITransQry {
	private String patId;
	
	public GetUnstopPrnOrdQry(String patId){
		this.patId = patId;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {
		
		SqlParam param = new SqlParam();
		param.addParam(patId);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		param.addParam(IBdSrvDictCodeConst.ID_FREQNUNITCT_ALWAYS);// 持续
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT  COUNT(ORD.ID_OR)");
		sqlBuilder.append(" FROM CI_ORDER ORD");
		sqlBuilder.append(" INNER JOIN BD_FREQ FREQ ON FREQ.ID_FREQ = ORD.ID_FREQ");
		sqlBuilder.append(" WHERE 1=1 ");
		sqlBuilder.append(" AND ORD.ID_PAT=?");
		sqlBuilder.append(" AND ORD.CODE_ENTP=?");
		sqlBuilder.append(" AND FREQ.ID_FREQUNITCT=?");
		sqlBuilder.append(" AND ORD.FG_STOP = 'N' ");
		sqlBuilder.append(" AND ORD.FG_CANC= 'N' ");

		return sqlBuilder.toString();
	}
}
