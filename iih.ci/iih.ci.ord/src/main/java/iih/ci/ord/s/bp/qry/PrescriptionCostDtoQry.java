package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询未计费服务信息（药品）
 * @ClassName: PrescriptionCostDtoQry
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年4月18日 上午11:23:45
 * @Package iih.ci.ord.s.bp.qry
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class PrescriptionCostDtoQry implements ITransQry {
	
	// 患者id
	private String patid;
	// 签署时间-起始时间
	private FDateTime 	dtSignB;
	// 签署时间-结束时间
	private FDateTime dtSignE;
	// 就诊类型
	private String[] code_entps;
	// 当前组织
	private String id_org;
	
	public PrescriptionCostDtoQry(String patid, FDateTime dtSignB, FDateTime dtSignE, String[] code_entps, String Id_org) {
		this.patid = patid;
		this.dtSignB = dtSignB;
		this.dtSignE = dtSignE;
		this.code_entps = code_entps;
		this.id_org = Id_org;
		}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam rtnParam = new SqlParam();
		rtnParam.addParam(patid);
		rtnParam.addParam(id_org);
		for(String code_entp : this.code_entps) {
			rtnParam.addParam(code_entp);
		}
		if (dtSignB != null) {
			rtnParam.addParam(dtSignB);
		}
		if (dtSignE != null) {
			rtnParam.addParam(dtSignE);
		}
		return rtnParam;
	}
	
	@Override
	public String getQrySQLStr() {

		return   getSql();
	}

	private String getSql(){
		
		StringBuffer sql = new StringBuffer();
		sql.append("select ci_or_srv.id_orsrv,");
		sql.append("ci_or_srv.id_or,");
		sql.append("ci_or_srv.id_pres,");
		sql.append("ci_or_srv.id_pat,");
		sql.append("ci_or_srv.id_entp,");
		sql.append("ci_or_srv.code_entp,");
		sql.append("ci_or_srv.id_en,");
		sql.append("ci_or_srv.sortno,");
		sql.append("ci_or_srv.id_srvtp,");
		sql.append("ci_or_srv.sd_srvtp,");
		sql.append("ci_or_srv.id_srv,");
		sql.append("bd_srv.name as name_srv,");
		sql.append("ci_or_srv.quan_medu as quan_med,");
		sql.append("ci_or_srv.id_medu as id_unit_med,");
		sql.append("ci_or_srv.id_route,");
		sql.append("ci_or_srv.id_routedes,");
		sql.append("ci_or_srv.id_boil,");
		sql.append("ci_or_srv.id_boildes,");
		sql.append("ci_or_srv.id_freq,");
		sql.append("ci_or_srv.id_org_srv,");
		sql.append("ci_or_srv.id_dep_srv,");
		sql.append("ci_or_srv.id_wg_or as id_wg_srv,");
		sql.append("ci_or_srv.id_emp_srv,");
		sql.append("DOC.name name_emp_srv,");
		sql.append("ci_or_srv.id_org_mp,");
		sql.append("ci_or_srv.id_dep_mp,");
		sql.append("ci_or_srv.id_su_mp,");
		sql.append("ci_or_srv.sd_su_mp,");
		sql.append("ci_or_srv.id_su_bl,");
		sql.append("ci_or_srv.sd_su_bl,");
		sql.append("ci_or_srv.dt_last_bl as dt_bl_last,");
		sql.append("ci_or_srv.fg_mm,");
		sql.append("ci_or_srv.fg_or, ");
		sql.append("ci_or_srv.fg_indic,");
		sql.append("ci_or_srv.fg_propc,");
		sql.append("ci_or_srv.fg_self,");
		sql.append("ci_or_srv.fg_selfpay,");
		sql.append("ci_or_srv_mm.id_orsrvmm,");
		sql.append("ci_or_srv_mm.id_mm,");
		sql.append("ci_or_srv_mm.quan_cur,");
		sql.append("ci_or_srv_mm.quan_bed_medu,");
		sql.append("ci_or_srv_mm.id_pgku_cur as id_unit_cur,");
		sql.append("ci_or_srv_mm.id_pgku_base as id_unit_base,");
		sql.append("ci_or_srv_mm.factor as factor_cb,");
		sql.append("ci_or_srv_mm.code_mm,");
		sql.append("ci_or_srv_mm.id_mmtp,");
		sql.append("ci_or_srv_mm.code_mm,");
		sql.append("bd_srv.code as code_srv,");
		sql.append("en_ent.id_pripat as id_pripat,");
		sql.append("ci_or_srv_mm.name_mm,");
		sql.append("ci_order.id_org,ci_order.id_grp,");
		sql.append("ci_order.id_srv id_srv_or,");
		sql.append("ci_order.name_or as des,");
		sql.append("ci_order.fg_bb,");
		sql.append("ci_order.no_bb,");
		sql.append("ci_order.eu_orsrcmdtp,");//医嘱来源方式
		sql.append("ci_order.dt_sign,"); //这是新增的
		sql.append("pres.name as presrption_name, "); 
		sql.append("udi.name prestp_name,");
		sql.append("ci_or_srv.id_hp,ci_or_srv.id_hpsrvtp,ci_or_srv.sd_hpsrvtp ,ci_or_srv.id_dep_wh, ");
		sql.append("bdmm.apprno,");
		sql.append("dep.name name_dep_srv,");
		sql.append("pres.code , ci_order.sv ci_sv,");
		sql.append("depmp.name  name_dep_mp, ");
		sql.append("ci_or_srv.fg_specill, ");
		sql.append("ci_or_srv.fg_extdispense, ");
		sql.append("ci_or_srv.id_srvca, ");
		sql.append("ci_pres.code presno, ");
		sql.append("'01' Prntype, ci_pres.sd_prestpword, ");
		//手动划价 需要查出 eu_blmd,pri,pri_std,pri_ratio by yzh 2017-10-24 09:57:03
		sql.append("ci_or_srv.eu_blmd,ci_or_srv.pri,ci_or_srv.pri_std,ci_or_srv.pri_ratio, ");
		sql.append("en_ent_hp.id_hpkind, ");
		sql.append("ci_or_srv_hp.indicitemid,");
		sql.append("bdmm.hiname,");
		//超量开单原因
		sql.append("ci_order.SD_EXCESSIVE_REASON, ");
		sql.append("ci_order.orders,");
		sql.append("ci_order.id_didef, ");
		sql.append("ci_order.name_didef, ");
		sql.append("didef.code as code_didef ");
		sql.append("  from ci_order ci_order");
		sql.append("  inner join ci_or_srv ci_or_srv");
		sql.append("  on ci_order.id_or=ci_or_srv.id_or ");
		sql.append("  left join ci_or_srv_mm ci_or_srv_mm ");
		sql.append("  on ci_or_srv.id_orsrv = ci_or_srv_mm.id_orsrv ");
		sql.append("  left outer join bd_srv bd_srv");
		sql.append("  on bd_srv.id_srv = ci_or_srv.id_srv ");
		sql.append("  inner join en_ent en_ent ");
		sql.append("  on ci_or_srv.id_en = en_ent.id_ent ");
		sql.append("  INNER JOIN BD_PSNDOC DOC ON DOC.ID_PSNDOC=ci_or_srv.id_emp_srv");
		sql.append(" left join en_ent_hp on en_ent_hp.id_ent = en_ent.id_ent and en_ent_hp.fg_maj='Y'");
		sql.append("    left join ci_pres pres on pres.id_pres = ci_or_srv.id_pres  ");
		sql.append("   left join bd_udidoc udi  on udi.id_udidoc = pres.id_prestp  ");
		sql.append("   left outer join  bd_mm  bdmm  on  bdmm.id_mm = ci_or_srv_mm.id_mm  ");
		sql.append("   left join bd_dep  dep on dep.id_dep = ci_or_srv.id_dep_srv ");
		sql.append("   left join bd_dep  depmp on depmp.id_dep = ci_or_srv.id_dep_mp  ");
		sql.append("   left join ci_pres  on ci_pres.id_pres = ci_or_srv.id_pres  ");	
		sql.append("   left join ci_or_srv_hp ci_or_srv_hp  on ci_or_srv_hp.id_orsrv = ci_or_srv.id_orsrv  ");		
		sql.append(" left join bd_di_def didef on ci_order.id_didef=didef.id_didef");
		sql.append("  where en_ent.fg_canc='N' and ci_or_srv.sd_su_bl='0' and ci_order.sd_su_or in ('10', '20', '30', '40', '50', '60') and ci_or_srv.ds = 0 and ci_order.ds = 0   and ci_or_srv.sd_srvtp like '01%' and  ci_or_srv.fg_self ='N'  and ci_or_srv.fg_bl ='Y' and ci_or_srv.fg_or='Y' ");
		sql.append("  and ci_or_srv.sd_su_mp not in ('"+ICiDictCodeConst.SD_SU_MP_EXECANC+"','"+ICiDictCodeConst.SD_SU_MP_CANCEL+"')");
		sql.append("  and ci_order.id_pat=? and ci_order.id_org=? and ci_order.fg_canc='N' ");
		
		StringBuilder sb = new StringBuilder();
		for(String code_entp : this.code_entps) {
			sb.append(",?");
		}
		sql.append(String.format("and ci_order.code_entp in (%s) ", sb.substring(1)));
		
		if (dtSignB != null) {
			sql.append("and ci_order.dt_sign>=?");
		}
		if (dtSignE != null) {
			sql.append(" and ci_order.dt_sign<= ?");
		}
		sql.append( "  order by ci_pres.id_pres,ci_order.dt_sign desc ");
        return sql.toString();
	}
}
