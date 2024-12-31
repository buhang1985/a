package iih.ci.mb.bp.qry;

import iih.bd.utils.BdEnvContextUtil;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPatCodeInfoSql implements ITransQry {
	private String code_amr_ip;	
	public GetPatCodeInfoSql(String code_amr_ip){
		this.code_amr_ip=code_amr_ip;
	}	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param=new SqlParam();
		param.addParam(code_amr_ip);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select 'H' || PAT.CODE as HID");
		sqlBuilder.append(" FROM EN_ENT ENT ");
		sqlBuilder.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT=ENT.ID_ENT");
		sqlBuilder.append(" LEFT JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT");
		sqlBuilder.append(" where IP.CODE_AMR_IP =?");
		return sqlBuilder.toString();
	}
}
