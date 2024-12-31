package iih.ci.mr.s.bp.qry;

import java.text.MessageFormat;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiMrHisDataSql implements ITransQry {

	private String Id_ents;
	private String Id_mrtplvt;
	private String Dt_vt;

	public CiMrHisDataSql(String id_ents, String id_mrtplvt, String dt_vt) {
		Id_ents = id_ents;
		Id_mrtplvt = id_mrtplvt;
		Dt_vt = dt_vt;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam = new SqlParam();
		rtnParam.addParam(Dt_vt);
		rtnParam.addParam(Id_mrtplvt);
		rtnParam.addParam(Dt_vt);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		return _getQrySQLStr();
	}

	private String _getQrySQLStr() {
		String SqlStr = ""
				+ "( "
				+ "  select "
				+ "  cimr.id_mr,"
				+ "  cimrvt.id_mrvt,"
				+ "  mrvtitm.id_mrvtitm, "
				+ "  cimr.id_ent, "
				+ "  mrtplitm.id_mrtplvt, "
				+ "  cimrvt.dt_vt, "
				+ "  mrvtitm.id_mrtplvtitm, "
				+ "  mrvtitm.id_vt_pos, "
				+ "  mrvtitm.id_vt_aux, "
				+ "  mrvtitm.value, "
				+ "  mrvtitm.value1, "
				+ "  mrvtitm.value2, "
				+ "  mrvtitm.value3, "
				+ "  ''Signs'' as typecode, "
				+ "  srvvt.id_srvvt "
				+ "  from CI_MR_VT_ITM mrvtitm "
				+ "  inner join CI_MR_VT cimrvt on mrvtitm.id_mrvt=cimrvt.id_mrvt and to_date(cimrvt.dt_vt,''yyyy-mm-dd hh24:mi:ss'')=to_date(?,''yyyy-mm-dd hh24:mi:ss'') "
				+ "  inner join BD_MRTPL_VT_ITM mrtplitm on mrvtitm.id_mrtplvtitm=mrtplitm.id_mrtplvtitm and mrtplitm.id_mrtplvt=? "
				+ "  left join bd_srv_vt srvvt on mrtplitm.id_srv=srvvt.id_srv "
				+ "  inner join CI_MR cimr on cimrvt.id_mr=cimr.id_mr and cimr.id_ent in ({0}) "
				+ "  where mrvtitm.ds=0 "
				+ ") "
				+ "union all "
				+ "( "
				+ "  select "
				+ "  cimr.id_mr, "
				+ "  cimrvt.id_mrvt, "
				+ "  mrvtev.id_mrvtev as id_mrvtitm, "
				+ "  cimr.id_ent, "
				+ "  null as id_mrtplvt, "
				+ "  cimrvt.dt_vt, "
				+ "  null as id_mrtplvtitm, "
				+ "  null as id_vt_pos, "
				+ "  null as id_vt_aux, "
				+ "  null as value, "
				+ "  mrvtev.id_vt_ev as value1, "
				+ "  mrvtev.name_vt_ev as value2, "
				+ "  null as value3, "
				+ "  ''Event'' as typecode, "
				+ "  null as id_srvvt  "
				+ "  from CI_MR_VT_EV mrvtev "
				+ "  left join CI_MR_VT cimrvt on mrvtev.id_mrvt=cimrvt.id_mrvt and to_date(cimrvt.dt_vt,''yyyy-mm-dd hh24:mi:ss'')=to_date(?,''yyyy-mm-dd hh24:mi:ss'') "
				+ "  inner join CI_MR cimr on cimrvt.id_mr=cimr.id_mr and cimr.id_ent in ({0}) "
				+ "  where mrvtev.ds=0 "
				+ ")";
		String Sql = MessageFormat.format(SqlStr, Id_ents);
		return Sql;
	}

}
