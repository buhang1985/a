package iih.ci.ord.outexecprint.s.bp.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOutExecPrintDTOsQry implements ITransQry {

	private String id_ents;
	private String id_srvca = "";
	private String sd_srvtp = "";

	public GetOutExecPrintDTOsQry(String id_ents, String id_srvca,
			String sd_srvtp) {
		this.id_ents = id_ents;
		this.id_srvca = id_srvca;
		this.sd_srvtp = sd_srvtp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer strSql = new StringBuffer();
		
		strSql.append(" SELECT ORD.id_or,");
		strSql.append("  ORD.name_or,");
		strSql.append("  ORD.id_srv,");
		strSql.append("  BDSRV.id_srvca,");
		strSql.append("  BDSRVCA.name as name_srvca,");
		strSql.append("  ORD.id_srvtp,");
		strSql.append("  ORD.sd_srvtp,");
		strSql.append("  BDSRVTP.name as name_srvtp,");
		strSql.append("  ORD.id_su_bl,");
		strSql.append("  ORD.sd_su_bl,");
		strSql.append("  BDSUBL.name as name_su_bl,");
		strSql.append("  ORD.id_emp_or,");
		strSql.append("  psndoc.name as name_emp_or,");
		strSql.append("  ORD.dt_effe,");
		strSql.append("  ORD.sd_su_or");
		strSql.append("  FROM ci_order ORD");
		strSql.append("  LEFT JOIN bd_srv BDSRV ON BDSRV.id_srv=ORD.id_srv");
		strSql.append("  left join bd_psndoc psndoc on psndoc.id_psndoc = ORD.id_emp_or");
		strSql.append("  LEFT JOIN bd_srvca BDSRVCA ON BDSRVCA.id_srvca=BDSRV.id_srvca");
		strSql.append("  LEFT JOIN bd_udidoc BDSRVTP ON BDSRVTP.id_udidoc=ORD.id_srvtp");
		strSql.append("  LEFT JOIN bd_udidoc BDSUBL ON BDSUBL.id_udidoc=ORD.id_su_bl");
		strSql.append("  WHERE ORD.id_en in (" + this.id_ents + ")");

		if(this.id_srvca.length() > 0 ){
			
			strSql.append("  and BDSRV.id_srvca in (" + this.id_srvca + ") ");
		}
		
		if(!StringUtil.isEmptyWithTrim(sd_srvtp)){
			
			strSql.append(" and " + this.sd_srvtp );
		}
		strSql.append(" and ORD.sd_su_or in ('20','30','60') ");
	
		return strSql.toString();
	}

}
