package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOrderDrugsSplitDateNewQry implements ITransQry {
	
	private String _id_en;
	private String idors;
	private String sd_pois;     //毒麻分类编码
	private String _code_entp;
	public GetOrderDrugsSplitDateNewQry(String id_en,String idors,String code_entp){
		
		this._id_en = id_en;
		this.idors = idors;
		this._code_entp=code_entp;
	}
   
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this._id_en);
//		sqlparam.addParam(this._id_pat);
		return sqlparam;
	}
	
	/*
	麻醉药品
	一类精神药品
	二类精神药品
	毒性药品
	放射性药品
	*/
    private String getsd_pois(){
    	
		sd_pois = "'" + IBdMmDictCodeConst.SD_POIS_MAZUI + "','" + IBdMmDictCodeConst.SD_POIS_JINGSHEN_1 + "','"
				+ IBdMmDictCodeConst.SD_POIS_JINGSHEN_2 + "','" + IBdMmDictCodeConst.SD_POIS_POISON + "','"
				+ IBdMmDictCodeConst.SD_POIS_RADIO + "'";

		return sd_pois;
    }
	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		if(_code_entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)
				||_code_entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS)){
			 getsd_pois();
			return getSql_IP();
		}else{
			return getSql();	
		}
		 
	}
     /**
      * 门诊的分方
      * @return
      */
	protected String getSql() {

		String str = "   select distinct ciormm.price_pgku_cur pri, cior.id_or, cior.id_grp, cior.id_org, cior.id_pat, cior.id_en,"
				+ "  cior.id_entp, cior.code_entp, ciorsrv.id_srvtp, ciorsrv.sd_srvtp, bd_srv_drug.sd_mmtp,"
				+ "  cior.fg_bb,cior.no_bb, cior.dt_entry, cior.id_emp_or,"
				+ "  cior.id_dep_or, cior.fg_vip,"
				+ "  cior.fg_research,cior.id_researchproject,rsc.name as name_researchproject," // 添加是否为科研项目，科研项目id,科研项目名称
				+ "  cior.fg_hospital_herbpres,"
				+ "  ciorsrv.id_dep_mp, bd_dep.sd_clinicalprofessiontp, ciorsrv.id_dep_wh, ciorsrv.id_orsrv, ciorsrv.fg_or,"//li_cheng 2017/3/31  增加fg_or 
				+ "  ciorsrv.id_route, ciorsrv.id_routedes, ciorsrv.id_boil, ciorsrv.id_boildes, ciorsrv.fg_self, ciorsrv.fg_base,"
				+ "  ciormm.sd_pharm, ciormm.sd_anti, ciormm.sd_mmtp,"
				//自费标志为N 医保 1，自费标志为Y 非医保 0
				+ "  ciormm.sd_dosage, ciormm.quan_cur, case WHEN (ciorsrv.FG_SELFPAY='N') then '1' else '0' end as fg_hp_pres, "
				+ "  ciormm.sd_pois, ciormm.sd_antipsy mental1, '' mental2, '' control , '' ordinary,"
				+ "  ciorsrv.fg_self, bd_hp_kind.code_hpkind, bd_hp_kind.name_hpkind,"
				+ "  ciorsrv.fg_specill, ciorsrv.fg_extdispense, "
				+ "  cior.Sd_excessive_reason, "
				+ "  bdmm.id_herbpreparationtp,"
				+ "  bdmm.sd_herbpreparationtp, "
				+ "  ciorsrv.sd_nodispense,"
				+ "  cior.id_didef,"
				+ "  ciorsrv.id_dsdef,"
				+ "  ciorsrv.code_dsdef,"
				+ "  ciorsrv.name_dsdef"
				+ "  from ci_order cior inner join ci_or_srv ciorsrv on ciorsrv.ID_OR=cior.ID_OR and (ciorsrv.sd_nodispense != '1' or ciorsrv.sd_nodispense is null ) "
				+ "  inner join ci_or_srv_mm ciormm on ciorsrv.id_orsrv = ciormm.id_orsrv "
				+ "  inner join bd_mm bdmm on bdmm.id_mm = ciormm.id_mm "
				+ "  left join en_ent_hp on en_ent_hp.fg_maj ='Y' and en_ent_hp.id_ent = cior.id_en "
				+ "  left join bd_hp_kind on en_ent_hp.id_hpkind = bd_hp_kind.id_hpkind and ciorsrv.id_hp = bd_hp_kind.id_hp "
				+ "  left join bd_dep on bd_dep.id_dep = cior.id_dep_sign "
				+ "  left join bd_srv_drug on bd_srv_drug.id_srv = ciorsrv.id_srv "
				+ "  left join bd_rsc_project rsc on cior.id_researchproject = rsc.id_researchproject"
				+ "  where cior.id_or in ("+ this.idors+ ")"
				+"   and  cior.fg_canc ='N'  "
				+ "  and nvl(ciorsrv.ID_PRES,'~') = '~' and ciorsrv.SD_SRVTP like '01%' and ciorsrv.fg_self='N' and ciorsrv.fg_extdispense='N'"
				+ "  and cior.sd_su_or='10' and cior.id_en = ? and cior.sd_srvtp not like '02%'";//增加检查的组合定价药品不分方
		return str;

	}
	 
	 /**
	  * 住院的分方
	  * @return
	  */
	protected String getSql_IP() {
		return "   select ciorsrv.pri, cior.id_or, cior.id_grp, cior.id_org, cior.id_pat, cior.id_en,"
				+ "  cior.id_entp, cior.code_entp, ciorsrv.id_srvtp, ciorsrv.sd_srvtp, "
				+ "  cior.fg_bb, cior.no_bb, cior.dt_entry, cior.id_emp_or,"
				+ "  cior.id_dep_or, ciorsrv.id_dep_mp, ciorsrv.id_dep_wh, ciorsrv.id_orsrv, ciorsrv.fg_or,"
				+ "  cior.fg_hospital_herbpres,"
				+ "  ciorsrv.sd_nodispense,"
				+ "  ciorsrv.id_route,ciorsrv.id_routedes, ciorsrv.id_boil, ciorsrv.id_boildes, ciorsrv.fg_base,"
				+ "  ciormm.sd_pharm, ciormm.sd_anti, ciormm.sd_mmtp sd_mmtp,"
				+ "  ciormm.sd_dosage, ciormm.quan_cur, case WHEN (ciorsrv.fg_indic='Y' and (ciorsrv.sd_hpsrvtp='1' or ciorsrv.sd_hpsrvtp='0')) then '1' else '0' end as fg_hp_pres, "
				+ "  ciormm.sd_pois, ciormm.sd_antipsy mental1, '' mental2, '' control , '' ordinary ,"
				+ "  ciorsrv.fg_self"
				+ "  from ci_order cior "
				+ "  inner join ci_or_srv ciorsrv on ciorsrv.ID_OR=cior.ID_OR  and (ciorsrv.sd_nodispense != '1' or ciorsrv.sd_nodispense is null ) "
				+ "  left join ci_or_srv_mm ciormm on ciorsrv.id_orsrv = ciormm.id_orsrv "
				+ "  where cior.id_or in ("+ this.getIdors()+ ") "
				+ "  and (ciorsrv.ID_PRES='~' or ciorsrv.ID_PRES=null) and ciorsrv.fg_self='N' "
				+ "  and ciorsrv.sd_srvtp like '01%' "
				//+ "  and (ciormm.sd_pois in ("+ this.getsd_pois()+ ") "
				//+ "  or (cior.fg_pres_outp  ='Y' and ciorsrv.SD_SRVTP like '01%') or (cior.SD_SRVTP like '0103%' and ciorsrv.SD_SRVTP like '0103%'))"
				+ "  and cior.sd_su_or='10' and cior.id_en = ?"; //li_cheng   出院带药加上是否是药品判断
	}

	public String getIdors() {
		return idors;
	}
	
}
