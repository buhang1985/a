package iih.ci.ord.s.bp.ordforbl.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊费用药品调入查询
 * @author ly 2019/04/19
 *
 */
public class GetUnchargeDrugOrdQry implements ITransQry {

	private String patId;
	private FDateTime dtSignB;
	private FDateTime dtSignE;
	private String[] code_entps;
	
	public GetUnchargeDrugOrdQry(String patId, FDateTime dtSignB,
			FDateTime dtSignE, String[] code_entps) {

		this.patId = patId;
		this.dtSignB  = dtSignB;
		this.dtSignE = dtSignE;
		this.code_entps = code_entps;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {
		
		SqlParam param = new SqlParam();
		param.addParam(this.patId);
		for(String code_entp : this.code_entps) {
			param.addParam(code_entp);
		}
		param.addParam(this.dtSignB);
		param.addParam(this.dtSignE);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ci_or_srv.id_orsrv, ");
		sqlSb.append("ci_or_srv.id_or, ");
		sqlSb.append("ci_or_srv.id_pres, ");
		sqlSb.append("ci_or_srv.id_pat, ");
		sqlSb.append("ci_or_srv.id_entp, ");
		sqlSb.append("ci_or_srv.code_entp, ");
		sqlSb.append("ci_or_srv.id_en, ");
		sqlSb.append("ci_or_srv.sortno, ");
		sqlSb.append("ci_or_srv.id_srvtp, ");
		sqlSb.append("ci_or_srv.sd_srvtp, ");
		sqlSb.append("ci_or_srv.id_srv, ");
		sqlSb.append("bd_srv.name name_srv, ");
		sqlSb.append("ci_or_srv.quan_medu quan_med, ");
		sqlSb.append("ci_or_srv.id_medu id_unit_med, ");
		sqlSb.append("ci_or_srv.id_route, ");
		sqlSb.append("ci_or_srv.id_routedes, ");
		sqlSb.append("ci_or_srv.id_boil, ");
		sqlSb.append("ci_or_srv.id_boildes, ");
		sqlSb.append("ci_or_srv.id_freq, ");
		sqlSb.append("ci_or_srv.id_org_srv, ");
		sqlSb.append("ci_or_srv.id_dep_srv, ");
		sqlSb.append("ci_or_srv.id_wg_or id_wg_srv, ");
		sqlSb.append("ci_or_srv.id_emp_srv, ");
		sqlSb.append("doc.name name_emp_srv, ");
		sqlSb.append("ci_or_srv.id_org_mp, ");
		sqlSb.append("ci_or_srv.id_dep_mp, ");
		sqlSb.append("ci_or_srv.id_su_mp, ");
		sqlSb.append("ci_or_srv.sd_su_mp, ");
		sqlSb.append("ci_or_srv.id_su_bl, ");
		sqlSb.append("ci_or_srv.sd_su_bl, ");
		sqlSb.append("ci_or_srv.dt_last_bl dt_bl_last, ");
		sqlSb.append("ci_or_srv.fg_or, ");
		sqlSb.append("ci_or_srv.fg_mm, ");
		sqlSb.append("ci_or_srv.fg_indic, ");
		sqlSb.append("ci_or_srv.fg_propc, ");
		sqlSb.append("ci_or_srv.fg_self, ");
		sqlSb.append("ci_or_srv.fg_selfpay, ");
		sqlSb.append("ci_or_srv_mm.id_orsrvmm, ");
		sqlSb.append("ci_or_srv_mm.id_mm, ");
		sqlSb.append("ci_or_srv_mm.quan_cur, ");
		sqlSb.append("ci_or_srv_mm.quan_bed_medu, ");
		sqlSb.append("ci_or_srv_mm.id_pgku_cur id_unit_cur, ");
		sqlSb.append("ci_or_srv_mm.id_pgku_base id_unit_base, ");
		sqlSb.append("ci_or_srv_mm.factor factor_cb, ");
		sqlSb.append("ci_or_srv_mm.code_mm, ");
		sqlSb.append("ci_or_srv_mm.id_mmtp, ");
		sqlSb.append("ci_or_srv_mm.code_mm, ");
		sqlSb.append("bd_srv.code code_srv, ");
		sqlSb.append("en_ent.id_pripat id_pripat, ");
		sqlSb.append("ci_or_srv_mm.name_mm, ");
		sqlSb.append("ci_order.id_org, ");
		sqlSb.append("ci_order.id_grp, ");
		sqlSb.append("ci_order.id_srv id_srv_or, ");
		sqlSb.append("ci_order.name_or des, ");
		sqlSb.append("ci_order.fg_bb, ");
		sqlSb.append("ci_order.no_bb, ");
		sqlSb.append("ci_order.eu_orsrcmdtp, ");
		sqlSb.append("ci_order.dt_sign, ");
		sqlSb.append("pres.name presrption_name, ");
		sqlSb.append("udi.name prestp_name, ");
		sqlSb.append("ci_or_srv.id_hp, ");
		sqlSb.append("ci_or_srv.id_hpsrvtp, ");
		sqlSb.append("ci_or_srv.sd_hpsrvtp, ");
		sqlSb.append("ci_or_srv.id_dep_wh, ");
		sqlSb.append("bdmm.apprno, ");
		sqlSb.append("dep.name name_dep_srv, ");
		sqlSb.append("pres.code, ");
		sqlSb.append("ci_order.sv ci_sv, ");
		sqlSb.append("depmp.name name_dep_mp, ");
		sqlSb.append("ci_or_srv.fg_specill, ");
		sqlSb.append("ci_or_srv.fg_extdispense, ");
		sqlSb.append("ci_or_srv.id_srvca, ");
		sqlSb.append("ci_pres.code presno, ");
		sqlSb.append("'01' prntype, ");
		sqlSb.append("ci_pres.sd_prestpword, ");
		sqlSb.append("ci_or_srv.eu_blmd, ");
		sqlSb.append("ci_or_srv.pri, ");
		sqlSb.append("ci_or_srv.pri_std, ");
		sqlSb.append("ci_or_srv.pri_ratio, ");
		sqlSb.append("en_ent_hp.id_hpkind, ");
		sqlSb.append("ci_or_srv_hp.indicitemid, ");
		sqlSb.append("bdmm.hiname, ");
		sqlSb.append("ci_order.sd_excessive_reason, ");
		sqlSb.append("ci_order.orders, ");
		sqlSb.append("ci_order.id_didef, ");
		sqlSb.append("ci_order.name_didef, ");
		sqlSb.append("didef.code code_didef ");
		sqlSb.append("from ci_order ci_order ");
		sqlSb.append("inner join ci_or_srv ci_or_srv ");
		sqlSb.append("on ci_order.id_or = ci_or_srv.id_or ");
		sqlSb.append("left join ci_or_srv_mm ci_or_srv_mm ");
		sqlSb.append("on ci_or_srv.id_orsrv = ci_or_srv_mm.id_orsrv ");
		sqlSb.append("left outer join bd_srv bd_srv ");
		sqlSb.append("on bd_srv.id_srv = ci_or_srv.id_srv ");
		sqlSb.append("inner join en_ent en_ent ");
		sqlSb.append("on ci_order.id_en = en_ent.id_ent ");
		sqlSb.append("inner join bd_psndoc doc ");
		sqlSb.append("on doc.id_psndoc = ci_or_srv.id_emp_srv ");
		sqlSb.append("left outer join en_ent_hp ");
		sqlSb.append("on en_ent_hp.id_ent = en_ent.id_ent ");
		sqlSb.append("and en_ent_hp.fg_maj = 'Y' ");
		sqlSb.append("left outer join ci_pres pres ");
		sqlSb.append("on pres.id_pres = ci_or_srv.id_pres ");
		sqlSb.append("left outer join bd_udidoc udi ");
		sqlSb.append("on udi.id_udidoc = pres.id_prestp ");
		sqlSb.append("left outer join bd_mm bdmm ");
		sqlSb.append("on bdmm.id_mm = ci_or_srv_mm.id_mm ");
		sqlSb.append("left outer join bd_dep dep ");
		sqlSb.append("on dep.id_dep = ci_or_srv.id_dep_srv ");
		sqlSb.append("left outer join bd_dep depmp ");
		sqlSb.append("on depmp.id_dep = ci_or_srv.id_dep_mp ");
		sqlSb.append("left outer join ci_pres ");
		sqlSb.append("on ci_pres.id_pres = ci_or_srv.id_pres ");
		sqlSb.append("left outer join ci_or_srv_hp ci_or_srv_hp ");
		sqlSb.append("on ci_or_srv_hp.id_orsrv = ci_or_srv.id_orsrv ");
		sqlSb.append("left outer join bd_di_def didef ");
		sqlSb.append("on ci_order.id_didef = didef.id_didef ");
		sqlSb.append("where en_ent.fg_canc = 'N' ");
		sqlSb.append("and ci_order.sd_su_or in ('10', '20', '30', '40', '50', '60') ");
		sqlSb.append("and ci_or_srv.sd_su_bl = '0' ");
		sqlSb.append("and ci_or_srv.ds = 0 ");
		sqlSb.append("and ci_order.ds = 0 ");
		sqlSb.append("and ci_or_srv.sd_srvtp like '01%' ");
		sqlSb.append("and ci_or_srv.fg_self = 'N' ");
		sqlSb.append("and ci_or_srv.fg_bl = 'Y' ");
		//sqlSb.append("and ci_or_srv.fg_or = 'Y' ");
		sqlSb.append("and ci_order.fg_canc = 'N' ");
		sqlSb.append("and ci_order.id_pat = ? ");
		sqlSb.append("and ci_order.sd_su_mp not in  ('"+ICiDictCodeConst.SD_SU_MP_EXECANC+"','"+ICiDictCodeConst.SD_SU_MP_CANCEL+"')");
		StringBuilder sb = new StringBuilder();
		for(String code_entp : this.code_entps) {
			sb.append(",?");
		}
		sqlSb.append(String.format("and ci_order.code_entp in (%s) ", sb.substring(1)));
		
		sqlSb.append("and ci_order.dt_sign >= ? ");
		sqlSb.append("and ci_order.dt_sign <= ? ");
		sqlSb.append("order by ci_pres.id_pres, ci_order.dt_sign desc");

		return sqlSb.toString();
	}

}
