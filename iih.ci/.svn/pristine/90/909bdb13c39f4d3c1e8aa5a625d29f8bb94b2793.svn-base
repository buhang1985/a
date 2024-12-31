package iih.ci.mr.s.bp.qry;

import java.text.MessageFormat;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class HisSignsDataSql implements ITransQry {

	private String id_ents;
	private String id_mrtplvt;
	private String dt_vt;
	private String id_srvvt;

	public HisSignsDataSql(String id_ents, String id_mrtplvt, String dt_vt, String id_srvvt) {
		this.id_ents = id_ents;
		this.id_mrtplvt = id_mrtplvt;
		this.dt_vt = dt_vt;
		this.id_srvvt = id_srvvt;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(dt_vt);
		param.addParam(id_mrtplvt);
		param.addParam(id_srvvt);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		return _getQrySQLStr();
	}

	private String _getQrySQLStr() {
		String SqlStr = ""
				+ "( "
				+ "  select "
				+ "  cimr.id_ent, "
				+ "  cimrvt.date_vt, "
				+ "  mrvtitm.value, "
				+ "  srvvt.id_srvvt "
				+ "  from CI_MR_VT_ITM mrvtitm "
				+ "  inner join CI_MR_VT cimrvt on mrvtitm.id_mrvt=cimrvt.id_mrvt and to_date(cimrvt.date_vt,''yyyy-mm-dd hh24:mi:ss'')=to_date(?,''yyyy-mm-dd hh24:mi:ss'') "
				+ "  inner join BD_MRTPL_VT_ITM mrtplitm on mrvtitm.id_mrtplvtitm=mrtplitm.id_mrtplvtitm and mrtplitm.id_mrtplvt=? "
				+ "  left join bd_srv_vt srvvt on mrtplitm.id_srv=srvvt.id_srv "
				+ "  inner join CI_MR cimr on cimrvt.id_mr=cimr.id_mr and cimr.id_ent in ({0}) "
				+ "  where srvvt.id_srvvt=?  and mrvtitm.ds=0 "
				+ ") ";
				
		String Sql = MessageFormat.format(SqlStr, id_ents);
		return Sql;
	}


}
