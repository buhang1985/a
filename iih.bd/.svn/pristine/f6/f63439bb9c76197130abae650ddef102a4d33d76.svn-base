package iih.bd.srv.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取医疗单动态指标查询
 * 
 * @author hao_wu
 *
 */
public class GetEmsDynamicIndexQry implements ITransQry {
	private String _id_ems;

	private String startDate;

	private boolean fg_dyncitm_en;

	String id_ent;

	String id_pat;

	public GetEmsDynamicIndexQry(String id_ems, String startDate, boolean fg_dyncitm_en, String id_ent, String id_pat) {
		this._id_ems = id_ems;
		this.startDate = startDate;
		this.fg_dyncitm_en = fg_dyncitm_en;
		this.id_ent = id_ent;
		this.id_pat = id_pat;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam param = new SqlParam();
		if (fg_dyncitm_en) {
			param.addParam(id_pat);
		} else {
			param.addParam(id_ent);
		}
		param.addParam(startDate);
		param.addParam(_id_ems);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		// 跨就诊
		if (fg_dyncitm_en) {
			return " select A.id_srv,A.name_disp as showname,B.sd_restrptlabtp as datatype, "
					+ " B.std_hi as maxv,B.std_lo as minv,B.id_unit_nuit as id_unit,C.NAME as unitname, "
					+ " B.val_restrptlab as enumvalues ,D.val_rstrptlab as indexva, A.fg_allowempty "
					+ " from bd_srv_of_dyncitm A " + " left outer join bd_srv_lab B ON A.Id_Srv=B.Id_Srv"
					+ " left outer join bd_measdoc C ON B.Id_Unit_Nuit=C.Id_Measdoc " + " left join "
					+ " (select id_srv,val_rstrptlab from "
					+ " (select itm.id_srv,itm.val_rstrptlab,lab.dt_rptlab as nortime, max(lab.dt_rptlab)over(partition by itm.id_srv) as maxTime"
					+ " from  CI_RPT_LAB lab inner join ci_order ci" + " on lab.id_or = ci.id_or and ci.id_pat=?"
					+ " inner join CI_RPT_LAB_ITM itm" + " on lab.id_rptlab=itm.id_rptlab"
					+ " where to_date(lab.dt_rptlab,'yyyy-mm-dd hh24:mi:ss') > to_date(?,'yyyy-mm-dd hh24:mi:ss'))"
					+ " where nortime= maxTime) D " + " on A.id_srv=D.id_srv where A.id_srvof=? order by A.SORTNO";
		} else {
			// 不跨就诊
			return " select A.id_srv,A.name_disp as showname,B.sd_restrptlabtp as datatype, "
					+ " B.std_hi as maxv,B.std_lo as minv,B.id_unit_nuit as id_unit,C.NAME as unitname, "
					+ " B.val_restrptlab as enumvalues ,D.val_rstrptlab as indexval, A.fg_allowempty "
					+ " from bd_srv_of_dyncitm A " + " left outer join bd_srv_lab B ON A.Id_Srv=B.Id_Srv"
					+ " left outer join bd_measdoc C ON B.Id_Unit_Nuit=C.Id_Measdoc" + " left join "
					+ " (select id_srv,val_rstrptlab from (select "
					+ " itm.id_srv,itm.val_rstrptlab,lab.dt_rptlab as nortime, max(lab.dt_rptlab)over(partition by itm.id_srv) as maxTime "
					+ " from CI_RPT_LAB lab " + " inner join CI_RPT_LAB_ITM itm "
					+ " on lab.id_rptlab=itm.id_rptlab and lab.id_ent=? "
					+ " where to_date(lab.dt_rptlab,'yyyy-mm-dd hh24:mi:ss') > to_date(?,'yyyy-mm-dd hh24:mi:ss')) "
					+ " where nortime= maxTime) D " + " on A.id_srv=D.id_srv  where A.id_srvof=? order by A.SORTNO";
		}

	}
}
