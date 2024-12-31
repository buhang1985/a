package iih.ci.ord.s.ems.op.bloodbadreaction.qry;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBloodFetchDO8EnQry implements ITransQry{
	private String iden;
	public GetBloodFetchDO8EnQry(String iden) {
		this.iden = iden;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sql = new StringBuffer();
		//sql.append(" select id_or,name_or from ci_order where id_en ='"+iden+"' and sd_srvtp ='"+IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE+"'");
		sql.append(" select id_or,name_or from ci_order where id_en ='"+iden+"' and sd_srvtp ='140101'");
		return sql.toString();
	}

}
