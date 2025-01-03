package iih.ei.std.s.v1.bp.hr.qry;

import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetDepSchedSiInfoSql implements ITransQry {
	FBoolean is_onlydep = FBoolean.FALSE;
	String id_dep = null;

	public GetDepSchedSiInfoSql(String id_dep, FBoolean is_onlydep) {
		this.id_dep = id_dep;
		this.is_onlydep = is_onlydep;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_dep);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("select hscsi.id_hsc_si,														");
		sb.append("      hscsi.id_grp,                                                          ");
		sb.append("      hscsi.id_org,                                                          ");
		sb.append("      hscsi.name,                                                            ");
		sb.append("      hscsi.code,                                                            ");
		sb.append("      hscsi.name_short,                                                      ");
		sb.append("      hscsi.id_owntp,                                                        ");
		sb.append("      hscsi.sd_owntp,                                                        ");
		sb.append("      udi_own.name name_owntp,                                               ");
		sb.append("      hscsi.id_dep,                                                          ");
		sb.append("      dep.name name_dep,                                                     ");
		sb.append("      hscsi.id_sica,                                                         ");
		sb.append("      hscsi.sd_sica,                                                         ");
		sb.append("      udi_sica.name name_sica,                                               ");
		sb.append("      hscsi.rest_dur,                                                        ");
		sb.append("      hscsi.sortno,                                                          ");
		sb.append("      hscsi.dt_beon,                                                         ");
		sb.append("      hscsi.dt_off,                                                          ");
		sb.append("      hscsi.dur_check,                                                       ");
		sb.append("      hscsi.dt_beon2,                                                        ");
		sb.append("      hscsi.dt_off2,                                                         ");
		sb.append("      hscsi.fg_active,                                                       ");
		sb.append("      hscsi.id_opr,                                                          ");
		sb.append("      psndoc.name name_opr,                                                  ");
		sb.append("      hscsi.dt_opt,                                                          ");
		sb.append("      hscsi.wbcode,                                                          ");
		sb.append("      hscsi.pycode,                                                          ");
		sb.append("      hscsi.mnecode,                                                         ");
		sb.append("      hscsi.memo                                                             ");
		sb.append(" from hr_hsc_si hscsi                                                        ");
		sb.append(" left join bd_dep dep on dep.id_dep = hscsi.id_dep                             ");
		sb.append(" left join bd_udidoc udi_own on udi_own.id_udidoc=hscsi.id_owntp             ");
		sb.append(" left join bd_udidoc udi_sica on udi_sica.id_udidoc=hscsi.id_sica            ");
		sb.append(" left join bd_psndoc psndoc on psndoc.id_psndoc=hscsi.id_opr                 ");
		sb.append(" where hscsi.fg_active='Y'                                                   ");

		if (FBoolean.TRUE.equals(this.is_onlydep)) {
			sb.append(" and dep.code = ?");
		} else {
			sb.append(" and (dep.code = ? or hscsi.sd_owntp='01')");
		}
		return sb.toString();
	}
}
