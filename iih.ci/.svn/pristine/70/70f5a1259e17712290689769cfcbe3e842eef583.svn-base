package iih.ci.ord.s.external.provide.bp.partner.qry;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.i.external.provide.meta.partner.IpOrderParamDTO;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 住院医嘱查询
 * @author zhangwq
 *
 */
public class GetIpOrdersQry implements ITransQry {
	protected String drugManagementModel;
	private IpOrderParamDTO param;
	public GetIpOrdersQry(){}
	public GetIpOrdersQry(IpOrderParamDTO paramDTO,String drugManagementModel){
		this.param = paramDTO;
		this.drugManagementModel= drugManagementModel;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		if(!StringUtils.isEmpty(this.param.getCode_entp())){
			sqlParam.addParam(this.param.getCode_entp());
		}
		if(!StringUtils.isEmpty(this.param.getFg_ip())){
			sqlParam.addParam(this.param.getFg_ip());
		}
		if(!StringUtils.isEmpty(this.param.getCode_pat())){
			sqlParam.addParam(this.param.getCode_pat());
		}
		if(this.param.getTimes_ip() != null){
			sqlParam.addParam(this.param.getTimes_ip());
		}
//		if(!StringUtils.isEmpty(this.param.getCode_srvca())){
//			sqlParam.addParam(this.param.getCode_srvca());
//		}
//		if(!StringUtils.isEmpty(this.param.getCode_srvca_ext())){
//			sqlParam.addParam("ip+"+this.param.getCode_srvca_ext());
//		}
		if(!StringUtils.isEmpty(this.param.getFg_long())){
			sqlParam.addParam(this.param.getFg_long()=="0"?"N":"Y");
		}
//		if(!StringUtils.isEmpty(this.param.getDt_b_search())){
//			sqlParam.addParam(this.param.getDt_b_search());
//		}
//		if(!StringUtils.isEmpty(this.param.getDt_e_search())){
//			sqlParam.addParam(this.param.getDt_e_search());
//		}
		if(!StringUtils.isEmpty(this.param.getCode_or())){
			sqlParam.addParam(this.param.getCode_or());
		}
		if(!StringUtils.isEmpty(this.param.getCode_emp_or())){
			sqlParam.addParam(this.param.getCode_emp_or());
		}
//		if(!StringUtils.isEmpty(this.param.getCode_dep_or())){
//			sqlParam.addParam(this.param.getCode_dep_or());
//		}
		if(!StringUtils.isEmpty(this.param.getCode_dep_nur_or())){
			sqlParam.addParam(this.param.getCode_dep_nur_or());
		}
//		if(!StringUtils.isEmpty(this.param.getCode_emp_sign())){
//			sqlParam.addParam(this.param.getCode_emp_sign());
//		}
//		if(!StringUtils.isEmpty(this.param.getCode_dep_sign())){
//			sqlParam.addParam(this.param.getCode_dep_sign());
//		}
		if(!StringUtils.isEmpty(this.param.getFg_sign())){
			sqlParam.addParam(this.param.getFg_sign());
		}
		if(!StringUtils.isEmpty(this.param.getFg_chk())){
			sqlParam.addParam(this.param.getFg_chk());
		}
		if(!StringUtils.isEmpty(this.param.getFg_stop())){
			sqlParam.addParam(this.param.getFg_stop());
		}
		if(!StringUtils.isEmpty(this.param.getFg_chk_stop())){
			sqlParam.addParam(this.param.getFg_chk_stop());
		}
		if(!StringUtils.isEmpty(this.param.getFg_canc())){
			sqlParam.addParam(this.param.getFg_canc());
		}
		if(!StringUtils.isEmpty(this.param.getFg_chk_canc())){
			sqlParam.addParam(this.param.getFg_chk_canc());
		}
		if(!StringUtils.isEmpty(this.param.getSd_su_or())){
			sqlParam.addParam(this.param.getSd_su_or());
		}
		if(!StringUtils.isEmpty(this.param.getCode_wh())){
			sqlParam.addParam(this.param.getCode_wh());
		}
		
		// 时间条件
		if(!StringUtils.isEmpty(this.param.getDt_b_search())){
			sqlParam.addParam(this.param.getDt_b_search());
		}
		if(!StringUtils.isEmpty(this.param.getDt_e_search())){
			sqlParam.addParam(this.param.getDt_e_search());
		}
		
		if(!StringUtils.isEmpty(this.param.getDt_b_search())){
			sqlParam.addParam(this.param.getDt_b_search());
		}
		if(!StringUtils.isEmpty(this.param.getDt_e_search())){
			sqlParam.addParam(this.param.getDt_e_search());
		}
		
		if(!StringUtils.isEmpty(this.param.getDt_b_search())){
			sqlParam.addParam(this.param.getDt_b_search());
		}
		if(!StringUtils.isEmpty(this.param.getDt_e_search())){
			sqlParam.addParam(this.param.getDt_e_search());
		}
		
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("ci.id_or, ");
		sb.append("pat.code as code_pat, "); 
		sb.append("entip.code_amr_ip as code_amr_ip, "); 
		sb.append("entip.times_ip, "); 
		//sb.append("pripat.code as pri_pat_code, "); 
		//sb.append("pripat.name as pri_pat_name, "); 
		sb.append("entip.name_bed, "); 
		sb.append("pat.name as name_pat, "); 
		//sb.append("pat.sd_sex as sd_sex_pat, "); 
		sb.append("sexdoc.name as name_sex_pat, "); 
		sb.append("ent.dt_birth_pat as dt_birth_pat, "); 
		//sb.append("pat.sd_idtp as sd_idtp, "); 
		//sb.append("idtpdoc.name as name_idtp, "); 
		//sb.append("pat.id_code as id_code, "); 
		//sb.append("pat.mob, "); 
		//sb.append("ent.dt_entry, "); 
		//sb.append("ent.dt_acpt as dt_enacpt, "); 
		//sb.append("ent.dt_end as dt_enend, "); 
		//sb.append("org.code as bizorgcode, "); 
		//sb.append("org.name as orgname, "); 
		sb.append("ci.code_or as code_or, "); 
		sb.append("ci.code_or||orsrv.sortno as code_or_itm, "); 
		//sb.append("srvca.code as code_srvca, "); 
		//sb.append("srvca.name as name_srvca, "); 
		//sb.append("decode(substr(ci.sd_srvtp,0,2),'01',bdsrv.sd_srvtp,substr(srvca.code,4)) as code_srvca_ext, "); 
		sb.append("ci.sd_su_or, "); 
		//sb.append("doc.name as name_su_or, "); 
		sb.append("ci.fg_long, "); 
		sb.append("decode(substr(ci.sd_srvtp,0,2),'01',orsrv.name,ci.name_or) as name_or, "); 
		sb.append("freq.code as code_freq, "); 
		sb.append("decode(substr(ci.sd_srvtp,0,2),'01',bdmm.code,bdsrv.code) as code_or_srv, ");
		sb.append("bdmm.spec, "); 
		sb.append("orsrv.quan_medu, "); 
		sb.append("measdoc.name as name_medu, "); 
		sb.append("ci.dt_effe, "); 
		sb.append("(case ci.fg_chk_stop when 'Y' then ci.dt_end else null end) as dt_end, "); 
		//sb.append("orsrv.fg_self, "); 
		//sb.append("ci.fg_urgent, "); 
		//sb.append("ci.orders, "); 
		//sb.append("ci.des_or as des_or, "); 
		//sb.append("mpdep.code as code_dep_mp, "); 
		//sb.append("mpdep.name as name_dep_mp, "); 
		//sb.append("ci.fg_bb, "); 
		//sb.append("ci.dt_entry, "); 
		sb.append("oremp.code as code_emp_or, "); 
		sb.append("oremp.name as name_emp_or, "); 
		//sb.append("ordep.code as code_dep_or, "); 
		//sb.append("ordep.name as name_dep_or, "); 
		sb.append("nurdep.code as code_dep_nur_or, "); 
		sb.append("nurdep.name as name_dep_nur_or, "); 
		//sb.append("ci.fg_sign, "); 
		//sb.append("signemp.code as code_emp_sign, "); 
		//sb.append("signemp.name as name_emp_sign, "); 
		//sb.append("signdep.code as code_dep_sign, "); 
		//sb.append("signdep.name as name_dep_sign, "); 
		//sb.append("ci.fg_chk, "); 
		sb.append("chkemp.code as code_emp_chk, "); 
		sb.append("chkemp.name as name_emp_chk, "); 
		sb.append("ci.fg_stop, "); 
		//sb.append("stopemp.code as code_emp_stop, "); 
		sb.append("stopemp.name as name_emp_stop, "); 
		//sb.append("ci.fg_chk_stop, "); 
		//sb.append("stopchkemp.code as code_emp_chk_stop, "); 
		//sb.append("stopchkemp.name as name_emp_chk_stop, "); 
		sb.append("ci.fg_canc, "); 
		//sb.append("cancemp.code as code_emp_canc, "); 
		//sb.append("cancemp.name as name_emp_canc, "); 
		//sb.append("ci.fg_chk_canc, "); 
		//sb.append("cancchkemp.code as code_emp_chk_canc, "); 
		//sb.append("cancchkemp.name as name_emp_chk_canc, ");
		sb.append("srvmm.QUAN_NUM_BASE,");
		sb.append("srvmm.QUAN_DEN_BASE,");
		sb.append("bm.name as name_pgku_base,");
		//sb.append("sup.name as sup_name,");
		//sb.append("decode(route.code,'099','Y','N'), ");
		//sb.append("route.code as code_route,");
		sb.append("route.name as name_route,");
		sb.append("decode(orsrv.sd_nodispense,'1','Y','N') as fg_nodispense ");
		sb.append(" from "); 
		sb.append(" ci_order ci "); 
		sb.append("left join ci_or_srv orsrv on ci.id_or = orsrv.id_or "); 
		sb.append("left join ci_or_srv_mm srvmm on orsrv.id_orsrv = srvmm.id_orsrv "); 
		sb.append("left join en_ent ent on ci.id_en = ent.id_ent "); 
		//sb.append("left join bd_srvca srvca on srvca.id_srvca = ci.id_srvca "); 
		//sb.append("left join bd_udidoc doc on doc.id_udidoc = ci.id_su_or "); 
		sb.append("left join bd_freq freq on freq.id_freq = ci.id_freq "); 
		sb.append("left join bd_srv bdsrv on bdsrv.id_srv = orsrv.id_srv "); 
		sb.append("left join bd_mm bdmm on bdmm.id_mm = srvmm.id_mm "); 
		sb.append("left join bd_measdoc measdoc on measdoc.id_measdoc=orsrv.id_medu "); 
		sb.append("left join bd_route route on route.id_route = ci.id_route "); 
		//sb.append("left join bd_dep mpdep on mpdep.id_dep = ci.id_dep_mp "); 
		sb.append("left join bd_psndoc oremp on oremp.id_psndoc = ci.id_emp_or "); 
		//sb.append("left join bd_dep ordep on ordep.id_dep = ci.id_dep_or "); 
		//sb.append("left join bd_psndoc signemp on signemp.id_psndoc = ci.id_emp_sign "); 
		//sb.append("left join bd_dep signdep on signdep.id_dep = ci.id_dep_sign "); 
		sb.append("left join bd_psndoc chkemp on chkemp.id_psndoc = ci.id_emp_chk "); 
		sb.append("left join bd_psndoc stopemp on stopemp.id_psndoc = ci.id_emp_sign "); 
		//sb.append("left join bd_psndoc stopchkemp on stopchkemp.id_psndoc = ci.id_emp_chk_stop "); 
		//sb.append("left join bd_psndoc cancemp on cancemp.id_psndoc = ci.id_emp_canc "); 
		//sb.append("left join bd_psndoc cancchkemp on cancchkemp.id_psndoc = ci.id_emp_chk_canc "); 
		sb.append("left join bd_dep nurdep on nurdep.id_dep = ent.id_dep_nur "); 
		sb.append("left join pi_pat pat on pat.id_pat = ci.id_pat "); 
		sb.append("left join en_ent_ip entip on ent.id_ent = entip.id_ent "); 
		//sb.append("left join bd_pri_pat pripat on pripat.id_pripat = ent.id_pripat "); 
		sb.append("left join bd_udidoc sexdoc on sexdoc.id_udidoc = ent.id_sex_pat "); 
		//sb.append("left join bd_org org on org.id_org = pat.id_org "); 
		//sb.append("left join bd_udidoc idtpdoc on idtpdoc.id_udidoc = pat.id_idtp ");
		sb.append("left join bd_measdoc bm on srvmm.id_pgku_base=bm.id_measdoc ");
		//sb.append("left join bd_sup sup on bdmm.id_sup=sup.id_sup ");
		sb.append("left join bd_dep wh on wh.id_dep=orsrv.id_dep_wh ");
		sb.append(this.getWherePart());
		sb.append(this.getDateTIme("ci"));
		return sb.toString();
	}
	protected String getWherePart(){
		StringBuilder sb = new StringBuilder();
		sb.append("where ((ci.sd_srvtp like '01%' and orsrv.fg_or='Y') or (ci.sd_srvtp not like '01%' and ci.id_srv=orsrv.id_srv)) "); 
		sb.append(this.getOrgGroupFilter("ci"));
		if(!StringUtils.isEmpty(this.param.getCode_entp())){
			sb.append("and ent.code_entp= ? "); 
		}
		if(!StringUtils.isEmpty(this.param.getFg_ip())){
			sb.append("and ent.fg_ip= ? "); 
		}
		if(!StringUtils.isEmpty(this.param.getCode_pat())){
			sb.append("and pat.code= ? "); 
		}
		if(this.param.getTimes_ip() != null){
			sb.append("and entip.times_ip= ? "); 
		}
//		if(!StringUtils.isEmpty(this.param.getCode_srvca())){
//			sb.append("and srvca.code = ? "); 
//		}
//		if(!StringUtils.isEmpty(this.param.getCode_srvca_ext())){
//			sb.append("and srvca.code= ? "); 
//		}
		if(!StringUtils.isEmpty(this.param.getFg_long())){
			sb.append("and ci.fg_long= ? "); 
		}
//		if(!StringUtils.isEmpty(this.param.getDt_b_search())){
//			sb.append("and ci.dt_effe >= ? "); 
//		}
//		if(!StringUtils.isEmpty(this.param.getDt_e_search())){
//			sb.append("and ci.dt_effe <= ?"); 
//		}
		if(!StringUtils.isEmpty(this.param.getCode_or())){
			sb.append("and ci.code_or = ? "); 
		}
		if(!StringUtils.isEmpty(this.param.getCode_emp_or())){
			sb.append("and oremp.code = ? "); 
		}
//		if(!StringUtils.isEmpty(this.param.getCode_dep_or())){
//			sb.append("and ordep.code = ? "); 
//		}
		if(!StringUtils.isEmpty(this.param.getCode_dep_nur_or())){
			sb.append("and nurdep.code = ? "); 
		}
//		if(!StringUtils.isEmpty(this.param.getCode_emp_sign())){
//			sb.append("and signemp.code = ? "); 
//		}
//		if(!StringUtils.isEmpty(this.param.getCode_dep_sign())){
//			sb.append("and signdep.code = ? "); 
//		}
		if(!StringUtils.isEmpty(this.param.getFg_sign())){
			sb.append("and ci.fg_sign = ? "); 
		}
		if(!StringUtils.isEmpty(this.param.getFg_chk())){
			sb.append("and ci.fg_chk = ? "); 
		}
		if(!StringUtils.isEmpty(this.param.getFg_stop())){
			sb.append("and ci.fg_stop =? "); 
		}
		if(!StringUtils.isEmpty(this.param.getFg_chk_stop())){
			sb.append("and ci.fg_chk_stop = ? "); 
		}
		if(!StringUtils.isEmpty(this.param.getFg_canc())){
			sb.append("and ci.fg_canc = ? ");
		}
		if(!StringUtils.isEmpty(this.param.getFg_chk_canc())){
			sb.append("and ci.fg_chk_canc = ? "); 
		}
		if(!StringUtils.isEmpty(this.param.getSd_su_or())){
			sb.append("and ci.sd_su_or = ? ");
		}
		if(!StringUtils.isEmpty(this.param.getCode_wh())){
			sb.append("and wh.code = ? ");
		}
		return sb.toString();
	}
	public String getOrgGroupFilter(String className){
		return " and "+className+".id_org='"+Context.get().getOrgId()+"' and "+className+".id_grp='"+Context.get().getGroupId()+"' ";
	}
	/**
	 * 
	 * @param tableName
	 * @return
	 */
	public String getDateTIme(String tableName) {
		StringBuffer sb = new StringBuffer();
		if(!StringUtils.isEmpty(this.param.getDt_b_search()) && !StringUtils.isEmpty(this.param.getDt_e_search())){
			sb.append("  and (");
			if(!StringUtils.isEmpty(this.param.getDt_b_search())){
				sb.append(" ( ci.dt_chk >= ? "); 
			}
			if(!StringUtils.isEmpty(this.param.getDt_e_search())){
				sb.append(" and ci.dt_chk <= ? ").append(")"); 
			}
			if(!StringUtils.isEmpty(this.param.getDt_b_search())){
				sb.append(" or  ( ci.dt_chk_canc >= ? "); 
			}
			if(!StringUtils.isEmpty(this.param.getDt_e_search())){
				sb.append(" and ci.dt_chk_canc <= ? ").append(")"); 
			}
			if(!StringUtils.isEmpty(this.param.getDt_b_search())){
				sb.append(" or  ( ci.dt_chk_stop >= ? "); 
			}
			if(!StringUtils.isEmpty(this.param.getDt_e_search())){
				sb.append(" and ci.dt_chk_stop <= ? ").append(" ) "); 
			}
			sb.append(" ) ");
		}
		return sb.toString();
	}
}
