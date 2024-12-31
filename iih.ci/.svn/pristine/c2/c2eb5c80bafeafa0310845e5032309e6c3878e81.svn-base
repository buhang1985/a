package iih.ci.ord.s.bp.ordprn.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医嘱信息
 * @author Young
 */
public class GetOrdInfo8IdorQry implements ITransQry {

	private String[] idors;
	public GetOrdInfo8IdorQry(String[] idors) {
		this.idors = idors;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		for (String idor : this.idors) {
			sqlparam.addParam(idor);
		}
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("select ORD.id_en,ORD.id_or||','||ORSRV.id_srv||','||ORSRV.sortno id_orsrv_key,ORD.id_or,ORD.sd_srvtp,ORSRV.id_srv,ORSRV.sortno,")
		.append("ORD.fg_chk,ORD.fg_chk_stop,ORD.fg_chk_canc,ORSRV.name name_srv ")
		.append("from ci_order ORD inner join ci_or_srv ORSRV on ORD.id_or=ORSRV.id_or and ORSRV.fg_or='Y' and (ORSRV.SD_NODISPENSE!='2' or ORSRV.SD_NODISPENSE is null) ")
		.append("where ORD.id_or in (%s)");
		StringBuilder sbFilter = new StringBuilder(); 
		for (String idor : this.idors) {
			sbFilter.append(",?");
		}
		return String.format(sb.toString(), sbFilter.substring(1));
	}
}
