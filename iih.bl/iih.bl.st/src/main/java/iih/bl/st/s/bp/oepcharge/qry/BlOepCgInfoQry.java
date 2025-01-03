package iih.bl.st.s.bp.oepcharge.qry;

import iih.bl.params.BlParams;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeCommonCondDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 查询已记账未缴费信息
 * @author liming06
 *
 */
public class BlOepCgInfoQry  implements ITransQry {

	private BlOepChargeCommonCondDTO cond;
	private boolean qryAcc;//查询预交金记账数据
	private boolean qrySusp;//查询挂起记账数据

	public BlOepCgInfoQry(BlOepChargeCommonCondDTO cond, boolean qryAcc, boolean qrySusp) {
		this.cond=cond;
		this.qryAcc = qryAcc;
		this.qrySusp = qrySusp;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(cond.getId_pat());
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		sb.append("select itm.id_cgitmoep,");
		sb.append("itm.id_pat,");
		sb.append("itm.id_ent,");
		sb.append("ent.code as code_ent,");
		sb.append("itm.id_enttp,");
		sb.append("itm.code_enttp,");
		sb.append("itm.id_pres,");
		sb.append("itm.id_or,");
		sb.append("itm.sd_srvtp,");
		sb.append("ord.code_or,");
		sb.append("ord.content_or,");
		sb.append("itm.code_apply as applyno,");
		sb.append("itm.code_apply as Pres_code,");
		sb.append("ord.name_or,");
		sb.append("itm.dt_or,");
		sb.append("itm.id_orsrv,");
		sb.append("itm.id_srv,");
		sb.append("srv.fg_or,");
		sb.append("itm.code_srv,");
		sb.append("itm.name_srv,");
		sb.append("itm.quan,");
		sb.append("itm.price as Price_std,");
		sb.append("itm.price_ratio,");
		sb.append("itm.amt,");
		sb.append("itm.amt_ratio,");
		sb.append("itm.amt_pat,");
		sb.append("itm.amt_hp,");
		sb.append("itm.amt_std,");
		sb.append("itm.srvu,");
		sb.append("itm.ratio_pripat,");
		sb.append("itm.fg_mm,");
		sb.append("itm.id_mm,");
		sb.append("itm.code_mm,");
		sb.append("itm.name_mm,");
		sb.append("itm.spec,");
		sb.append("itm.pgku_cur,");
		sb.append("itm.id_dep_or,");
		sb.append("itm.id_emp_or,");
		sb.append("itm.id_dep_mp,");
		sb.append("depor.name as name_dep_or,");
		sb.append("depmp.name as Name_dep_mp,");
		sb.append("empor.name as Name_emp_or,");
		sb.append("cg.dt_cg,");
		sb.append("itm.eu_srctp,");
		sb.append("itm.id_pripat,");
		sb.append("pripat.name as Id_pripat_name,");
		sb.append("ent.id_patca id_paticate,");
		sb.append("patca.name Id_paticate_name,");
		sb.append("itm.fg_additm as Fg_addfee,");
		sb.append("cg.id_dep_cg,");
		sb.append("cg.id_emp_cg,");
		sb.append("empcg.name as Name_emp_cg,");
		sb.append("itm.id_hp,");
		sb.append("itm.ratio_hp,");
		sb.append("itm.eu_direct,");
		sb.append("itm.fg_hp,");
		sb.append("itm.srcfunc_des,");
		sb.append("itm.fg_susp,");
		sb.append("itm.fg_acc,");
		sb.append("itm.id_dep_wh,");
		sb.append("itm.code_inccaitm,");
		sb.append("itm.name_inccaitm,");
		sb.append("itm.fg_free,");
		sb.append("entop.TIMES_OP,");
		sb.append("itm.pecode as pe_code,");
		sb.append("ord.id_didef,");
		sb.append("ord.name_didef,");
		sb.append("cg.code_cg ");
		sb.append(" from bl_cg_oep cg");
		sb.append(" inner join bl_cg_itm_oep itm");
		sb.append(" on cg.id_cgoep = itm.id_cgoep");
		sb.append(" left join en_ent ent");
		sb.append(" on itm.id_ent = ent.id_ent");
		sb.append(" left join en_ent_op entop");
		sb.append(" on ent.id_ent = entop.id_ent");
		sb.append(" left join ci_order ord");
		sb.append(" on itm.id_or = ord.id_or");
		sb.append(" left join ci_or_srv srv");
		sb.append(" on ord.id_or = srv.id_orsrv");
		sb.append(" left join bd_dep depor");
		sb.append(" on itm.id_dep_or = depor.id_dep");
		sb.append(" left join bd_dep depmp");
		sb.append(" on itm.id_dep_mp = depmp.id_dep");
		sb.append(" left join bd_psndoc empor");
		sb.append(" on itm.id_emp_or = empor.id_psndoc");
		sb.append(" left join bd_pri_pat pripat");
		sb.append(" on itm.id_pripat = pripat.id_pripat");
		sb.append(" left join pi_pat_ca patca");
		sb.append(" on ent.id_patca = patca.id_patca");
		sb.append(" left join bd_psndoc empcg");
		sb.append(" on cg.id_emp_cg = empcg.id_psndoc");
		sb.append(" where itm.fg_refund = 'N' ");
		sb.append(" and cg.eu_direct = 1");
		//是否结0元
		if(FBoolean.FALSE.equals(BlParams.BLSTOEP0067())){
			sb.append(" and itm.fg_pricinginsertcg='N'and itm.price_ratio>0 ");
		}
		if(this.qryAcc && this.qrySusp){
			sb.append(" and ((and itm.fg_acc='Y' and itm.fg_st = 'N' ) or (itm.fg_susp = 'Y' and itm.eu_srctp = 1)) ");
		}else if(this.qrySusp){
			sb.append(" and itm.fg_susp = 'Y' and itm.eu_srctp = 1 ");
		}else{
			sb.append(" and itm.fg_acc='Y' and itm.fg_st = 'N' ");
		}
		
		sb.append(" and itm.id_pat = ?");
		sb.append(" order by cg.dt_cg ");
		return sb.toString();
	}

}
