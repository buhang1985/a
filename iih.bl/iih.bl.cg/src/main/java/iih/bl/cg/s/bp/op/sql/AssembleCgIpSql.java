package iih.bl.cg.s.bp.op.sql;

import java.text.SimpleDateFormat;
import java.util.Date;

import iih.bl.params.BlParams;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class AssembleCgIpSql implements ITransQry {
	
	private String _id_ent;
	private Integer _hours;
	
	public AssembleCgIpSql(String id_ent,Integer hours){
		this._hours = hours;
		this._id_ent = id_ent;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(DOStatus.NEW);
		sqlParam.addParam(this._id_ent);
		
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" select  oep.amt  , ");
		sql.append("               oep.amt_hp  , ");
		sql.append("               oep.amt_pat  , ");
		sql.append("               oep.amt_ratio  , ");
		sql.append("               oep.amt_std, ");
		sql.append("               oep.apprno, ");
		sql.append("               oep.Cd_batch, ");
		sql.append("               oep.code_account, ");
		sql.append("               oep.Code_apply, ");
		sql.append("               cgoep.code_cg  as  Code_cg, ");
		sql.append("               oep.Code_inccaitm, ");
		sql.append("               oep.Code_mm, ");
		sql.append("               oep.Code_srv, ");
		sql.append("               oep.Ds, ");
		sql.append("               oep.Dt_or, ");
		sql.append("               oep.Dt_srv, ");
		sql.append("               cgoep.Eu_direct, ");
		sql.append("               oep.Eu_srctp, ");
		sql.append("               oep.Factor, ");
		sql.append("               oep.Fg_additm, ");
		sql.append("               'N'  as  FG_BB, ");
		sql.append("               oep.Fg_free, ");
		sql.append("               DECODE(ent.id_hp,NUll,'N',DECODE(ent.id_hp,'~','N','Y')) as Fg_hp, ");
		sql.append("               oep.Fg_mm, ");
		sql.append("               'N'  as  FG_PAY_UNIT, ");
		sql.append("               oep.Fg_pddisc, ");
		sql.append("               'Y'  as  FG_REAL, ");
		sql.append("               oep.Fg_recg, ");
		sql.append("               oep.Fg_refund, ");
		sql.append("               'N'  as  FG_RESEARCH, ");
		sql.append("               oep.fg_selfpay, ");
		sql.append("               'N'  as  Fg_st, ");
		sql.append("               oep.Fg_susp, ");
		sql.append("               oep.Id_dep_or  as  Id_dep_cg, ");
		sql.append("               oep.Id_dep_mp, ");
		sql.append("               oep.Id_dep_nur, ");
		sql.append("               oep.Id_dep_or, ");
		sql.append("               oep.ID_DEP_PHY, ");
		sql.append("               oep.Id_dep_wh, ");
		sql.append("               oep.id_entbed, ");
		sql.append("               oep.id_entdcg, ");
		sql.append("               oep.Id_emp_or  as  Id_emp_cg, ");
		sql.append("               oep.Id_emp_or, ");
		sql.append("               ent.Id_ent, ");
		sql.append("               oep.Id_grp, ");
		sql.append("               ent.Id_hp, ");
		sql.append("               oep.id_mis, ");
		sql.append("               oep.Id_mm, ");
		sql.append("               oep.Id_mmtp, ");
		sql.append("               oep.Id_or, ");
		sql.append("               oep.id_org, ");
		sql.append("               oep.id_org_or  as  ID_ORG_CG, ");
		sql.append("               oep.id_org_mp, ");
		sql.append("               oep.id_org_or, ");
		sql.append("               oep.Id_orsrv, ");
		sql.append("               oep.Id_or_pr, ");
		sql.append("               oep.Id_or_pr_srv, ");
		sql.append("               oep.Id_par, ");
		sql.append("               oep.Id_pat, ");
		sql.append("               oep.Id_pres, ");
		sql.append("               oep.Id_pripat, ");
		sql.append("               oep.Id_srv, ");
		sql.append("               oep.Id_srvca, ");
		sql.append("               oep.Id_srvtp, ");
		sql.append("               oep.name_account, ");
		sql.append("               oep.Name_inccaitm, ");
		sql.append("               oep.Name_mm, ");
		sql.append("               oep.Name_srv, ");
		sql.append("               oep.Note, ");
		sql.append("               oep.Onlycode, ");
		sql.append("               oep.Pgku_base, ");
		sql.append("               oep.Pgku_cur, ");
		sql.append("               oep.Price, ");
		sql.append("               oep.Price_ratio, ");
		sql.append("               oep.Pri_ss, ");
		sql.append("               oep.Quan, ");
		sql.append("               oep.Quan_base, ");
		sql.append("               '0'  as  QUAN_RET, ");
		sql.append("               oep.Ratio_hp, ");
		sql.append("               oep.Ratio_pripat, ");
		sql.append("               oep.Sd_mmtp, ");
		sql.append("               oep.Sd_srvtp, ");
		sql.append("               oep.Spec, ");
		sql.append("               oep.Srcfunc_des, ");
		sql.append("               oep.Srvu, ");
		sql.append("               entp.id_entp as ID_ENTTP, ");
		sql.append("               entp.code as CODE_ENTTP, ");
		Integer blcg0043 = BlParams.BLCG0043();
		if (blcg0043.intValue()==1) {
			sql.append(" ent.Dt_entry as Dt_cg, ");
			sql.append(" ent.Dt_entry as Dt_oper_cg, ");
		}else if (blcg0043.intValue()==2) {
			Date dateTime = new Date();
			sql.append(" '").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTime)).append("' as Dt_cg, ");
			sql.append(" '").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTime)).append("' as Dt_oper_cg, ");
		}
		sql.append(" ? as Status ");
		sql.append("     from  bl_cg_itm_oep_tfrcd  tfrcd ");
		sql.append("   inner  join  bl_cg_itm_oep  oep ");
		sql.append("         on  tfrcd.id_cgitmoep  =  oep.id_cgitmoep ");
		sql.append("     left  join  bl_cg_oep  cgoep ");
		sql.append("         on  cgoep.id_cgoep  =  oep.id_cgoep ");
		sql.append(" left join en_ent ent ");
		sql.append(" on ent.id_ent= tfrcd.id_ent_tf");
		sql.append("       left join bd_entp entp ");
		sql.append("       on  entp.code='10' ");
		sql.append("   where  tfrcd.id_ent_tf=? and  tfrcd.fg_active  =  'Y' ");
		sql.append("       and  tfrcd.fg_realtf  =  'Y' and tfrcd.fg_tl='N' ");

		return sql.toString();
	}

}
