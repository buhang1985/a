package iih.ci.ord.s.bp.qry;

import iih.ci.ord.ordfilter.d.CiOrderFilterDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOrdItem4BlBpQry  implements ITransQry{
	
	private CiOrderFilterDTO filterdto;
	
    public GetOrdItem4BlBpQry(CiOrderFilterDTO ordfilter) {
    	this.filterdto=ordfilter;
    }
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		this.getWherePartAndparam(sqlparam);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String sql="select distinct ord.id_or,  " + 
				"       ord.id_grp,  " + 
				"       ord.id_org,  " + 
				"       ord.id_pat,  " + 
				"       ord.id_en,  " + 
				"       ord.id_entp,  " + 
				"       ord.code_entp,  " + 
				"       ord.id_srvtp,  " + 
				"       ord.sd_srvtp,  " + 
				"       ord.id_srv,  " + 
				"       ord.fg_set,  " + 
				"       ord.id_srv_pkg,  " + 
				"       ord.fg_long,  " + 
				"       ord.code_or,  " + 
				"       ord.content_or,  " + 
				"       ord.des_or,  " + 
				"       ord.id_freq,  " + 
				"       ord.orders,  " + 
				"       ord.fg_boil,  " + 
				"       ord.orders_boil,  " + 
				"       ord.id_route,  " + 
				"       ord.id_routedes,  " + 
				"       ord.id_boil,  " + 
				"       ord.id_boildes,  " + 
				"       ord.days_or,  " + 
				"       ord.id_su_or,  " + 
				"       ord.sd_su_or,  " + 
				"       ord.id_su_mp,  " + 
				"       ord.sd_su_mp,  " + 
				"       ord.id_su_bl,  " + 
				"       ord.sd_su_bl,  " + 
				"       ord.id_org_or,  " + 
				"       ord.id_dep_or,  " + 
				"       ord.id_wg_or,  " + 
				"       ord.id_emp_or,  " + 
				"       ord.dt_entry,  " + 
				"       ord.fg_sign,  " + 
				"       ord.id_emp_sign,  " + 
				"       ord.id_dep_sign,  " + 
				"       ord.dt_sign,  " + 
				"       ord.dt_effe,  " + 
				"       ord.dt_end,  " + 
				"       ord.dt_invalid,  " + 
				"       ord.fg_chk,  " + 
				"       ord.id_emp_chk,  " + 
				"       ord.id_dep_chk,  " + 
				"       ord.dt_chk,  " + 
				"       ord.fg_stop,  " + 
				"       ord.id_emp_stop,  " + 
				"       ord.id_dep_stop,  " + 
				"       ord.dt_stop,  " + 
				"       ord.fg_chk_stop,  " + 
				"       ord.id_emp_chk_stop,  " + 
				"       ord.id_dep_chk_stop,  " + 
				"       ord.dt_chk_stop,  " + 
				"       ord.fg_canc,  " + 
				"       ord.id_emp_canc,  " + 
				"       ord.id_dep_canc,  " + 
				"       ord.dt_canc,  " + 
				"       ord.fg_chk_canc,  " + 
				"       ord.id_emp_chk_canc,  " + 
				"       ord.id_dep_chk_canc,  " + 
				"       ord.dt_chk_canc,  " + 
				"       ord.fg_pmor,  " + 
				"       ord.des_pmor,  " + 
				"       ord.fg_active_pm,  " + 
				"       ord.id_reltp,  " + 
				"       ord.sd_reltp,  " + 
				"       ord.id_or_rel,  " + 
				"       ord.fg_bb,  " + 
				"       ord.no_bb,  " + 
				"       ord.fg_ctlcp,  " + 
				"       ord.fg_skintest,  " + 
				"       ord.fg_mp_in,  " + 
				"       ord.times_mp_in,  " + 
				"       ord.fg_mp_bed,  " + 
				"       ord.note_or,  " + 
				"       ord.createdby,  " + 
				"       ord.createdtime,  " + 
				"       ord.modifiedby,  " + 
				"       ord.modifiedtime,  " + 
				"       ord.fg_pkg,  " + 
				"       ord.name_or,  " + 
				"       ord.quan_firday_mp,  " + 
				"       ord.fg_or_form,  " + 
				"       ord.id_skintest_skip_reason,  " + 
				"       ord.sd_skintest_skip_reason,  " + 
				"       ord.fg_pres_outp,  " + 
				"       ord.applyno,  " + 
				"       ord.dt_last_bl,  " + 
				"       ord.fg_urgent,  " + 
				"       ord.id_orpltp,  " + 
				"       ord.id_srvca,  " + 
				"       ord.times_cur,  " + 
				"       ord.id_orrsttp,  " + 
				"       ord.sd_orrsttp,  " + 
				"       ord.id_dep_mp,  " + 
				"       ord.dt_last_mp,  " + 
				"       ord.id_unit_med,  " + 
				"       ord.quan_medu,  " + 
				"       ord.innercode_srvca,  " + 
				"       ord.fg_uncancelable,  " + 
				"       ord.eu_hpindicjudge,  " + 
				"       ord.eu_uncporjudge,  " + 
				"       ord.reason_uncporuse,  " + 
				"       ord.fg_feertnable,  " + 
				"       ord.fg_quickwflow,  " + 
				"       ord.eu_orsrcmdtp,  " + 
				"       ord.id_orsrc_main,  " + 
				"       ord.id_orsrc_sub,  " + 
				"       ord.id_orsrc_subsub,  " + 
				"       ord.bhpjudgerst,  " + 
				"       ord.des_bhpjudgerst,  " + 
				"       ord.fg_vip,  " + 
				"       ord.fg_prepay,  " + 
				"       ord.fg_orhp,  " + 
				"       ord.eu_feereversetp,  " + 
				"       ord.id_excessive_reason,  " + 
				"       ord.sd_excessive_reason,  " + 
				"       ord.sd_totalopenmode,  " + 
				"       ord.sortno,  " + 
				"       ord.fg_hospital_herbpres,  " + 
				"       ord.fg_deliveryroom_use,  " + 
				"       ord.eu_refusechecktp,  " + 
				"       ord.fg_refusecheck,  " + 
				"       ord.id_emp_refusecheck,  " + 
				"       ord.dt_refusecheck,  " + 
				"       ord.fg_pay_unit,  " + 
				"       ord.id_dep_nur_or,  " + 
				"       ord.fg_recheck,  " + 
				"       ord.id_emp_recheck,  " + 
				"       ord.dt_recheck,  " + 
				"       ord.fg_spec_anti_approve,  " + 
				"       ord.sd_spec_anti_approve,  " + 
				"       ord.id_emp_second_chk,  " + 
				"       ord.id_orsrcfun,  " + 
				"       ord.sd_orsrcfun,  " + 
				"       ord.fg_infect_dep_cons,  " + 
				"       ord.id_didef,  " + 
				"       ord.name_didef,  " + 
				"       ord.more_money_reason,  " + 
				"       ord.fg_wholepack,  " + 
				"       ord.eu_hpjudge,  " + 
				"       ord.eu_orhp,  " + 
				"       ord.fg_back,  " + 
				"       ord.id_or_src,  " + 
				"       freq.name                   Freq_name,  " + 
				"       route.name                  route_name,  " + 
				"       org_or.name                 org_or_name,  " + 
				"       ordep.name                  dept_or_name,  " + 
				"       oremp.name                  Emp_phy_name,  " + 
				"       signemp.name                emp_sign_name,  " + 
				"       signdep.name                dep_sign_name,  " + 
				"       empchk.name                 emp_chk_name,  " + 
				"       nurdep.name                 dep_nur_name,  " + 
				"       empstop.name                emp_stop_name,  " + 
				"       stopdep.name                dep_stop_name,  " + 
				"       nurstop.name                emp_chk_stop_name,  " + 
				"       empcanc.name                emp_canc_name,  " + 
				"       depcanc.name                dep_canc_name,  " + 
				"       nurempcanc.name             emp_chk_canc_name,  " + 
				"       nurcanc.name                dep_chk_canc_name,  " +
				"       mpdep.name                  name_dep_mp     "+
				"  from ci_order ord  " + 
				"  left join bd_dep ordep  " + 
				"    on ordep.id_dep = ord.id_dep_or  " + 
				"  left join bd_psndoc oremp  " + 
				"    on oremp.id_psndoc = ord.id_emp_or  " + 
				"  left join bd_freq freq  " + 
				"    on freq.id_freq = ord.id_freq  " + 
				"  left join bd_route route  " + 
				"    on route.id_route = ord.id_route  " + 
				"  left join bd_org org_or  " + 
				"    on org_or.id_org = ord.id_org_or  " + 
				"  left join bd_psndoc signemp  " + 
				"    on ord.id_emp_sign = signemp.id_psndoc  " + 
				"  left join bd_dep signdep  " + 
				"    on ord.id_dep_sign = signdep.id_dep  " + 
				"  left join bd_psndoc empchk  " + 
				"    on empchk.id_psndoc = ord.id_emp_chk  " + 
				"  left join bd_dep nurdep  " + 
				"    on nurdep.id_dep = ord.id_dep_nur_or  " + 
				"  left join bd_psndoc empstop  " + 
				"    on empstop.id_psndoc = ord.id_emp_stop  " + 
				"  left join bd_dep stopdep  " + 
				"    on stopdep.id_dep = ord.id_dep_stop  " + 
				"  left join bd_psndoc nurstop  " + 
				"    on nurstop.id_psndoc = ord.id_emp_chk_stop  " + 
				"  left join bd_psndoc empcanc  " + 
				"    on empcanc.id_psndoc = ord.id_emp_canc  " + 
				"  left join bd_dep depcanc  " + 
				"    on depcanc.id_dep = ord.id_dep_canc  " + 
				"  left join bd_psndoc nurempcanc  " + 
				"    on nurempcanc.id_psndoc = ord.id_emp_chk_canc  " + 
				"  left join bd_dep nurcanc  " + 
				"    on nurcanc.id_dep = ord.id_dep_chk_canc  "
				+"  left join bd_dep mpdep on mpdep.id_dep=ord.id_dep_mp "
				+ "  where  "+this.getWherePartAndparam(null);
		return sql;
	}
	
	private String getstvtpWherePart(SqlParam sqlparam) {
		StringBuilder sb=new StringBuilder();
		if(this.filterdto!=null&&this.filterdto.getStr_code_srvtps()!=null&&this.filterdto.getStr_code_srvtps().trim().length()>0) {
			String srvtps=this.filterdto.getStr_code_srvtps().trim();
			String[] ss=srvtps.split(",");
			for (String srv : ss) {
				sb.append(" ord.sd_srvtp like ? or ");
				sqlparam.addParam(srv+"%");
			}
			String tmp=sb.toString();
			int i= tmp.lastIndexOf("or");
			String sf=tmp.substring(0, i);
			return " and ("+sf+")";
		}
		return "";
	}
	
	private String getWherePartAndparam(SqlParam sqlparam) {
		if(sqlparam==null)sqlparam=new SqlParam();
		StringBuilder sb=new StringBuilder();
		sb.append(" ord.ds=0 and ord.id_en=? ");
		sqlparam.addParam(this.filterdto.getId_en());
		if(this.filterdto.getFg_long()!=null) {			
			if("1".equals(this.filterdto.getFg_long())) {
				sqlparam.addParam("Y");
				sb.append(" and ord.fg_long=? ");
			}else
           if("2".equals(this.filterdto.getFg_long())) {
        	   sqlparam.addParam("N");
        	   sb.append(" and ord.fg_long=? ");
			}
		}
		if(this.filterdto.getSd_orsrcfun()!=null) {
			
			if("1".equals(this.filterdto.getSd_orsrcfun())) {
				sqlparam.addParam("1");
				sb.append(" and ord.Sd_orsrcfun=? ");
			}else
            if("2".equals(this.filterdto.getSd_orsrcfun())) {
            	sqlparam.addParam("2");
            	sb.append(" and ord.Sd_orsrcfun=? ");
			}
		}
		if(this.filterdto.getFg_pres_outp()!=null&&("1".equals(this.filterdto.getFg_pres_outp()))) {
			sqlparam.addParam("Y");
			sb.append(" and ord.Fg_pres_outp=? ");
		}
		if(this.filterdto.getDt_start()!=null) {
			sb.append(" and  ord.Dt_effe>? ");
			sqlparam.addParam(this.filterdto.getDt_start());
		}
		if(this.filterdto.getDt_end()!=null) {
			sb.append(" and  ord.Dt_effe<? ");
			sqlparam.addParam(this.filterdto.getDt_end());
		}
		if(this.filterdto.getOrder_name()!=null&&this.filterdto.getOrder_name().trim().length()>0) {
			sb.append(" and ord.Content_or like ?");
			sqlparam.addParam("%"+this.filterdto.getOrder_name()+"%");
		}
		
		if(this.filterdto.getFg_live()!=null&&("1".equals(this.filterdto.getFg_live()))) {
			sb.append(" and ord.Sd_su_or!='60' and ord.Sd_su_or != '80'  ");
		}
		String sd_su_or=this.filterdto.getSd_su_or();
		if(sd_su_or!=null) {
			if("1".equals(sd_su_or)) {
			  sb.append(" and ord.sd_su_or='0' ");	
			}else
            if("2".equals(sd_su_or)) {
            	sb.append(" and ord.sd_su_or='10' ");
			}else
            if("3".equals(sd_su_or)) {
            	sb.append(" and nvl(ord.id_emp_stop,'~')!='~'  and ord.Dt_end < '2098-01-01 00:00:00' and ord.Sd_su_or!='60' and ord.fg_canc!='Y' ");
			}else
             if("4".equals(sd_su_or)) {
            	 sb.append(" and ord.fg_canc='Y'");
			}

		}
		sb.append(this.getstvtpWherePart(sqlparam));
		return sb.toString();

	}
	
	

}
