package iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp.qry;

import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询患者医保特殊病药品限制数量
 * @author LIM
 * @since 2019-09-26
 */
public class GetSpecLimitListQry implements ITransQry {

	String idHp;
	String idPat;
	FDateTime dt;
	Integer orderMode;
	public GetSpecLimitListQry(String idHp,String idPat,FDateTime dt,Integer orderMode){
		this.idHp=idHp;
		this.idPat=idPat;
		this.dt=dt;
		this.orderMode=orderMode;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param= new SqlParam();
		param.addParam(dt);
		param.addParam(idHp);
		param.addParam(idPat);	
		param.addParam(dt);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb= new StringBuilder();
		sb.append("select spec.id_didef,");
		sb.append("spec.id_dsdef,");
		sb.append("specdrug.id_srv,");
		sb.append("specdrug.id_mm,");
		sb.append("specdrug.sd_control,");
		sb.append("decode(sd_control,1,(specdrug.quan_limit + nvl(drugAQuan.Addquan, 0)) * pkgu.factor* mm.factor_mb,nvl(specdrug.quan_limit,0) + nvl(drugAQuan.Addquan, 0)) as quan_limit ,");
		sb.append(" nvl(specdrug.quan_limit,0) + nvl(drugAQuan.Addquan, 0) as quan_ori_limit,");
		sb.append(" decode(sd_control,1, pkgu.mmpkguname,'天')as name_unit,");
		sb.append(" specdrug.id_unit,");
		//sb.append(" mm.id_unit_pkgbase ");
		sb.append(" srv.id_unit_med as id_unit_pkgbase ");
		sb.append(" from MI_MC_SPEC spec");
		sb.append(" inner join MI_MC_SPEC_DRUG specdrug");
		sb.append("   on spec.id_hpspec = specdrug.id_hpspec");
		sb.append(" inner join mi_mc_pat_spec_di specpatdi");
		if(this.orderMode==0){
			// 0：采用病种模式；1:诊断模式
			sb.append("   on nvl(spec.code_ds, '~') = nvl(specpatdi.code_ds, '~')");
		}else{
			sb.append("   on nvl(spec.code_di, '~') = nvl(specpatdi.code_di, '~')");
		}
		sb.append(" inner join mi_mc_pat_spec specpat");
		sb.append("   on specpat.id_mimcpatspec = specpatdi.id_mimcpatspec");
		sb.append(" left join bd_mm_pkgu pkgu");
		sb.append("   on specdrug.id_mm = pkgu.id_mm");
		sb.append("    and specdrug.id_unit = pkgu.id_unit_pkg");
		sb.append(" left join bd_mm mm on specdrug.id_mm=mm.id_mm ");
		sb.append(" left join bd_srv srv on mm.id_srv=srv.id_srv  ");
		sb.append(" left join mi_mc_pat_spec_drugAQuan drugAQuan ");
		sb.append("   on drugAQuan.Id_Mimcpatspecdi = specpatdi.id_mimcpatspecdi  and drugAQuan.Id_Mm=specdrug.id_mm");
		sb.append("   and ? between drugAQuan.Dt_b and drugAQuan.Dt_e");
		sb.append(" inner join pi_pat_hp pathp ");
		sb.append("   on pathp.id_hp = specpat.id_hp and pathp.fg_deft='Y'");
		sb.append("   and (substr(specpat.no_hp, 0, 9) = substr(pathp.no_hp, 0, 9) or  specpat.id_pat=pathp.id_pat)");
		sb.append(" where ");
		sb.append("  spec.id_hp = ? ");
		sb.append("  and pathp.id_pat =? ");
		sb.append("  and ? between specpatdi.dt_b and specpatdi.Dt_e ");
		return sb.toString();
	}

}
