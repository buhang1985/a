package iih.ci.ord.rationaluse.meikang.s.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;

public class MKRationalUseQrySqlConst {

	private static MKRationalUseQrySqlConst mkRationalUseQrySqlConst;

	private MKRationalUseQrySqlConst() {

	}

	public static synchronized MKRationalUseQrySqlConst getSql() {
		if (mkRationalUseQrySqlConst == null) {
			mkRationalUseQrySqlConst = new MKRationalUseQrySqlConst();
		}
		return mkRationalUseQrySqlConst;

	}

	/**
	 * 出院患者列表
	 */
	public String ZYPATIENTLIST = "select '0' as hiscode,p.code as patientid,e.code as visitid "
			+ "from en_ent e inner join en_ent_ip i " + "on e.id_ent = i.id_ent and i.sd_status='"
			+ IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT + "' " + "inner join pi_pat p " + "on e.id_pat=p.id_pat "
			+ "where e.dt_end>=? and e.dt_end<=?";
	
	/**
	 * 出院患者列表(new)
	 */
	public String ZYPATIENTLIST_NEW = "select '0' as hiscode,p.code as patientid,e.code as visitid ,org.code as orgcode ,org.name as orgname "
     +" from en_ent e "
     +" inner join en_ent_ip i on e.id_ent = i.id_ent and i.sd_status='"
			+ IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT + "' "
     +" inner join pi_pat p on e.id_pat=p.id_pat "
     +" left join bd_org org on org.id_org = p.id_org where e.dt_end>=? and e.dt_end<=? and org.code=?";
	/**
	 * 在院患者列表
	 */
	public String ZYINPATIENTLIST = "select '0' as hiscode,p.code as patientid,e.code as visitid "
			+ "from en_ent e inner join en_ent_ip i " + " on e.id_ent = i.id_ent and i.sd_status='"
			+ IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN + "' " + " inner join pi_pat p " + " on e.id_pat=p.id_pat ";
	
	/**
	 * 在院患者列表(new)
	 */
	public String ZYINPATIENTLIST_NEW = "select '0' as hiscode,p.code as patientid,e.code as visitid ,org.code as orgcode ,org.name as orgname "
			+ " from en_ent e inner join en_ent_ip i " + " on e.id_ent = i.id_ent and i.sd_status='"
			+ IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN + "' " + " inner join pi_pat p " + " on e.id_pat=p.id_pat left join bd_org org on org.id_org=e.id_org where  org.code=?";
	/**
	 * 住院病人基本信息
	 */
	public String ZYPATIENT = "select distinct '0' as hiscode,p.code as patientid,e.code as visitid,i.code_amr_ip as hospitalno,p.name as patientname,"
     +" decode(p.sd_sex,'1','男','2','女','不详') as sex,substr(p.dt_birth,0,10) as birthdate,"
     +" to_number(to_char(sysdate,'yyyy'))  - to_number(substr(p.dt_birth,0,4))as age,"
     +" '' as height,"
     +" (select max(mr_vs_itm.value)  from ci_mr_vs_itm mr_vs_itm right join ci_mr_vs mr_vs on  mr_vs_itm.id_mr_vs=mr_vs.id_mr_vs"
     +"  where   mr_vs.id_ent = e.id_ent  and mr_vs_itm.id_srv='0001Z7100000000EZCI3')  as weight,"
     +" decode(p.sd_idtp,'01',p.id_code,'') as identitycard,p.tel as telephone,i.name_bed as bedno,dep.code as deptcode,"
     +" dep.name as deptname,nur.code as wardcode,nur.name as wardname,substr(e.dt_acpt,0,10) as startdate,"
     +" case nvl(e.dt_end,'~') when '~' then '' else substr(e.dt_end,0,10) end as enddate,case nvl(bl.dt_st,'~') when '~' then '' else substr(bl.dt_st,0,10) end as accountdate,"
     +" psn.code as doctorcode,psn.name as doctorname,wg.code as medgroupcode,wg.name as medgroupname,"
     +" l.name as nursingclass,"
     +" case when e.code_entp= '10'  and e.fg_ip='Y'  then  '1'"
     +"      when e.code_entp= '10'  and e.fg_ip='N'  then  '0'"
     +"      else '1' end as i_in,"
     +" ca.name as payclass"
     +"  from pi_pat p"
     +" inner join en_ent e on p.id_pat=e.id_pat and p.code=? and e.code= ?"
     +" inner join en_ent_ip i on e.id_ent=i.id_ent"
     +" left join bd_dep dep on e.id_dep_phy = dep.id_dep"
     +" left join bd_dep nur on e.id_dep_nur = nur.id_dep"
     +" left join (select * from bl_st_ip bi where bi.dt_st = (select max(bl_st_ip.dt_st) from bl_st_ip where bl_st_ip.id_ent=bi.id_ent )) bl on e.id_ent = bl.id_ent"
     +" left join bd_psndoc psn   on e.id_emp_phy = psn.id_psndoc"
     +" left join bd_wg wg  on e.id_wg_phy = wg.id_wg"
     +" left join bd_udidoc l on i.id_level_nur = l.id_udidoc"
     +" left join pi_pat_ca ca on ca.id_patca = e.id_patca"
     +" where e.fg_canc ='N' and e.code_entp in ('10')";
	
	/**
	 * 住院病人基本信息(new)
	 */
	public String ZYPATIENT_NEW = "select distinct '0' as hiscode,p.code as patientid,e.code as visitid,i.code_amr_ip as hospitalno,p.name as patientname,"
     +" decode(p.sd_sex,'1','男','2','女','不详') as sex,substr(p.dt_birth,0,10) as birthdate,"
     +" to_number(to_char(sysdate,'yyyy'))  - to_number(substr(p.dt_birth,0,4))as age,"
     +" '' as height,"
     +" (select max(mr_vs_itm.value)  from ci_mr_vs_itm mr_vs_itm right join ci_mr_vs mr_vs on  mr_vs_itm.id_mr_vs=mr_vs.id_mr_vs"
     +"  where   mr_vs.id_ent = e.id_ent  and mr_vs_itm.id_srv='0001Z7100000000EZCI3')  as weight,"
     +" decode(p.sd_idtp,'01',p.id_code,'') as identitycard,p.tel as telephone,i.name_bed as bedno,dep.code as deptcode,"
     +" dep.name as deptname,nur.code as wardcode,nur.name as wardname,substr(e.dt_acpt,0,10) as startdate,"
     +" case nvl(e.dt_end,'~') when '~' then '' else substr(e.dt_end,0,10) end as enddate,case nvl(bl.dt_st,'~') when '~' then '' else substr(bl.dt_st,0,10) end as accountdate,"
     +" psn.code as doctorcode,psn.name as doctorname,wg.code as medgroupcode,wg.name as medgroupname,"
     +" l.name as nursingclass,"
     +" case when e.code_entp= '10'  and e.fg_ip='Y'  then  '1'"
     +"      when e.code_entp= '10'  and e.fg_ip='N'  then  '0'"
     +"      else '1' end as i_in,"
     +" ca.name as payclass,org.code as orgcode ,org.name as orgname"
     +"  from pi_pat p"
     +" inner join en_ent e on p.id_pat=e.id_pat and p.code=? and e.code= ?"
     +" inner join en_ent_ip i on e.id_ent=i.id_ent"
     +" left join bd_dep dep on e.id_dep_phy = dep.id_dep"
     +" left join bd_dep nur on e.id_dep_nur = nur.id_dep"
     +" left join (select * from bl_st_ip bi where bi.dt_st = (select max(bl_st_ip.dt_st) from bl_st_ip where bl_st_ip.id_ent=bi.id_ent )) bl on e.id_ent = bl.id_ent"
     +" left join bd_psndoc psn   on e.id_emp_phy = psn.id_psndoc"
     +" left join bd_wg wg  on e.id_wg_phy = wg.id_wg"
     +" left join bd_udidoc l on i.id_level_nur = l.id_udidoc"
     +" left join pi_pat_ca ca on ca.id_patca = e.id_patca"
     +" left join bd_org org on org.id_org = p.id_org"
     +" where e.fg_canc ='N' and e.code_entp in ('10') and org.code=?";
	/**
	 * 住院医嘱查询sql
	 */
	public String ZYORDERS = "select   '0' as hiscode,ci.code_or||srv.sortno as cid,pat.code as"
			   +" patientid,e.code as visitid,ci.code_or as orderno,decode(substr(ci.sd_srvtp,0,2),'01','1','04','2','03','3','02','4','06','5','6') as ordertype,"
	           +" ci.code_or as grouptag,decode(ci.fg_long,'Y','0','1') as is_temp,srvmm.code_mm as drug_unique_code,decode(substr(ci.sd_srvtp,0,2),'01',mm.code,srv.code_srv) as ordercode,"
	           +" replace(srv.name|| '('|| boil.name|| ')','()','') as ordername,b.name as drugform,mm.spec as drugspec,route.name as routecode,"
	           +" route.name as routename,srv.quan_medu as singledose,measdoc1.name as doseunit,freq.name as frequency,"
	           +" srvmm.quan_cur as num,measdoc2.name as numunit,psn.code as doctorcode,psn.name as doctorname,"
	           +" dep.code as deptcode,dep.name as deptname,nur.code as wardcode,nur.name as wardname,ci.dt_effe as executetime,"
	           +" ci.dt_effe as startdatetime,ci.dt_end as enddatetime,"
	           +" decode(srv.fg_propc ,'Y',3,'N',0,0) as purpose,"
	           +" ci.des_or as remark,decode(srv.fg_pres_outp,'Y','1','0') as is_out,"
	           +" '' as is_allow,'' as reasonable_desc,'' as meditime,psn1.code as pharm_reviewid,psn1.name as pharm_review,"
	           +" '' as pharm_mixid,'' as pharm_mix,'1' as is_emergency"       
	           +" from ci_order ci"
	           +" left join ci_or_srv srv on ci.id_or=srv.id_or"
	           +" left join ci_or_srv_mm srvmm  on srv.id_orsrv=srvmm.id_orsrv"
	           +" left join bd_udidoc b  on srvmm.id_dosage = b.id_udidoc"
	           +" left join bd_mm mm  on mm.id_mm=srvmm.id_mm"
	           +" left join bd_route route  on ci.id_route = route.id_route"
	           +" left join bd_measdoc measdoc1 on srv.id_medu = measdoc1.id_measdoc"
	           +" left join bd_freq freq on ci.id_freq = freq.id_freq"
	           +" left join bd_measdoc measdoc2  on srvmm.id_pgku_cur=measdoc2.id_measdoc"
	           +" left join bd_psndoc psn  on ci.id_emp_or = psn.id_psndoc"
	           +" left join bd_dep dep on ci.id_dep_or=dep.id_dep"
	           +" left join bd_psndoc psn1  on ci.id_emp_verify_pharm=psn1.id_psndoc"
	           +" left join en_ent e  on ci.id_en=e.id_ent"
	           +" left join pi_pat pat on ci.id_pat = pat.id_pat"
	           +" left join bd_boil_des boil on srv.id_boildes = boil.id_boildes"
	           +" left join bd_dep nur on e.id_dep_nur = nur.id_dep"
	           +" where pat.code=? and e.code=?  and  ci.fg_sign='Y' and ci.fg_canc='N' and srv.sd_srvtp like '01%'";
	
	/**
	 * 住院医嘱查询sql(new)
	 */
	public String ZYORDERS_NEW = "select   '0' as hiscode,ci.code_or||srv.sortno as cid,pat.code as"
		   +" patientid,e.code as visitid,ci.code_or as orderno,decode(substr(ci.sd_srvtp,0,2),'01','1','04','2','03','3','02','4','06','5','6') as ordertype,"
           +" ci.code_or as grouptag,decode(ci.fg_long,'Y','0','1') as is_temp,srvmm.code_mm as drug_unique_code,decode(substr(ci.sd_srvtp,0,2),'01',mm.code,srv.code_srv) as ordercode,"
           +" replace(srv.name|| '('|| boil.name|| ')','()','') as ordername,b.name as drugform,mm.spec as drugspec,route.name as routecode,"
           +" route.name as routename,srv.quan_medu as singledose,measdoc1.name as doseunit,freq.name as frequency,"
           +" srvmm.quan_cur as num,measdoc2.name as numunit,psn.code as doctorcode,psn.name as doctorname,"
           +" dep.code as deptcode,dep.name as deptname,nur.code as wardcode,nur.name as wardname,ci.dt_effe as executetime,"
           +" ci.dt_effe as startdatetime,ci.dt_end as enddatetime,"
           +" decode(srv.fg_propc ,'Y',3,'N',0,0) as purpose,"
           +" ci.des_or as remark,decode(srv.fg_pres_outp,'Y','1','0') as is_out,"
           +" '' as is_allow,'' as reasonable_desc,'' as meditime,psn1.code as pharm_reviewid,psn1.name as pharm_review,"
           +" '' as pharm_mixid,'' as pharm_mix,'1' as is_emergency,"
           +" org.code as orgcode ,org.name as orgname"
           +" from ci_order ci"
           +" left join ci_or_srv srv on ci.id_or=srv.id_or"
           +" left join ci_or_srv_mm srvmm  on srv.id_orsrv=srvmm.id_orsrv"
           +" left join bd_udidoc b  on srvmm.id_dosage = b.id_udidoc"
           +" left join bd_mm mm  on mm.id_mm=srvmm.id_mm"
           +" left join bd_route route  on ci.id_route = route.id_route"
           +" left join bd_measdoc measdoc1 on srv.id_medu = measdoc1.id_measdoc"
           +" left join bd_freq freq on ci.id_freq = freq.id_freq"
           +" left join bd_measdoc measdoc2  on srvmm.id_pgku_cur=measdoc2.id_measdoc"
           +" left join bd_psndoc psn  on ci.id_emp_or = psn.id_psndoc"
           +" left join bd_dep dep on ci.id_dep_or=dep.id_dep"
           +" left join bd_psndoc psn1  on ci.id_emp_verify_pharm=psn1.id_psndoc"
           +" left join en_ent e  on ci.id_en=e.id_ent"
           +" left join pi_pat pat on ci.id_pat = pat.id_pat"
           +" left join bd_boil_des boil on srv.id_boildes = boil.id_boildes"
           +" left join bd_dep nur on e.id_dep_nur = nur.id_dep"
           +" left join bd_org org on org.id_org=ci.id_org"
           +" where pat.code=? and e.code=? and org.code=? and  ci.fg_sign='Y' and ci.fg_canc='N' and srv.sd_srvtp like '01%'";
	/**
	 * 住院病人过敏信息
	 */
	public String ZYALLERGEN = "select '0' as hiscode,pat.code as patientid,e.code as visitid,al.sd_alcla as allercode,"
		     +"  al.name_alcla as allername,al.des_alcla as symptom"
		     +" from pi_pat_al al"
		     +" left join pi_pat pat on al.id_pat=pat.id_pat"
		     +" inner join en_ent e on pat.id_pat=e.id_pat "
		     +" left join bd_org org on org.id_org=pat.id_org"
		     +" where pat.code=? ";
	
	/**
	 * 住院病人过敏信息(new)
	 */
	public String ZYALLERGEN_NEW = "select '0' as hiscode,pat.code as patientid,e.code as visitid,al.sd_alcla as allercode,"
     +"  al.name_alcla as allername,al.des_alcla as symptom,org.code as orgcode ,org.name as orgname"
     +" from pi_pat_al al"
     +" left join pi_pat pat on al.id_pat=pat.id_pat"
     +" inner join en_ent e on pat.id_pat=e.id_pat "
     +" left join bd_org org on org.id_org=pat.id_org"
     +" where pat.code=? and org.code=?";
	/**
	 * 住院病人诊断信息
	 */
	public String ZYDISEASE = "select distinct  '0' as hiscode,p.code as patientid,ent.code as visitid,di_itm.id_didef_code as discode,replace(di_itm.id_didef_name||'('||di_itm.ID_DIDEF_SYN_NAME||')','()','') as disname,"
      +" decode(ip.sd_outcomes,'00','1','01','2','02','3','05','4','0') as treatment,'' as is_hospinfection,"
      +" decode(di.sd_ditp,'11','1','12','1','0') as diseasetype,decode(di_itm.fg_majdi,'y','1','0') as is_main,di_itm.sortno as sortid"
      +" from  pi_pat p"
      +" left join en_ent ent on  ent.id_pat = p.id_pat"
      +" inner join en_ent_ip ip on ent.id_ent = ip.id_ent"
      +" left join ci_di di on di.id_en = ent.id_ent"
      +" left join ci_di_itm di_itm on di_itm.id_di = di.id_di"
      +" where di_itm.id_didef_code<>'-' and ent.code=? ";
	
	/**
	 * 住院病人诊断信息(new)
	 */
	public String ZYDISEASE_NEW = "select distinct  '0' as hiscode,p.code as patientid,ent.code as visitid,di_itm.id_didef_code as discode,replace(di_itm.id_didef_name||'('||di_itm.ID_DIDEF_SYN_NAME||')','()','') as disname,"
      +" decode(ip.sd_outcomes,'00','1','01','2','02','3','05','4','0') as treatment,'' as is_hospinfection,"
      +" decode(di.sd_ditp,'11','1','12','1','0') as diseasetype,decode(di_itm.fg_majdi,'y','1','0') as is_main,di_itm.sortno as sortid,"
      +" org.code as orgcode ,org.name as orgname"
      +" from  pi_pat p"
      +" left join en_ent ent on  ent.id_pat = p.id_pat"
      +" inner join en_ent_ip ip on ent.id_ent = ip.id_ent"
      +" left join ci_di di on di.id_en = ent.id_ent"
      +" left join ci_di_itm di_itm on di_itm.id_di = di.id_di"
      +" left join bd_org org on org.id_org=p.id_org"
      +" where di_itm.id_didef_code<>'-' and ent.code=? and org.code=?";
	/**
	 * 住院病人费用信息
	 */
	public String ZYCOST = "SELECT  '0' as hiscode,pat.code as patientid,ent.code as visitid,"
		     +"        decode(substr(srv.sd_srvtp,0,2),'01','1','04','2','03','3','02','4','5') as costtype,"
		     +"        decode(substr(srv.sd_srvtp,0,2),'01',mm.code,a0.code_srv) as itemcode,a0.name_srv as itemname,"
		     +"        b.name as drugform,"
		     +"        decode(mm.spec,'','/',mm.spec) drugspec,"
		     +"        mm.sup_name as drugsccj,"
		     +"        c0.name as itemunit,"
		     +"        A0.QUAN*A0.Eu_Direct itemnum,"
		     +"        A0.Amt_Std*A0.EU_DIRECT AS cost,"
		     +"        A0.Dt_cg as costtime,"
		     +"        p.code as doctorcode,"
		     +"        p.name as doctorname,"
		     +"        dep.code deptcode,"
		     +"        dep.name as deptname,"
		     +"        nur.code as wardcode,"
		     +"        nur.name as wardname,"
		     +"        wg.code as medgroupcode,"
		     +"        wg.name as medgroupname,"
		     +"        decode(srv.fg_pres_outp,'Y','1','0') is_out,"
		     +"        route.name as routecode"
		     +"   FROM BL_CG_IP A0"
		     +"   left JOIN BD_SRVCA B0 ON a0.id_srvca=b0.id_srvca"
		     +"   left JOIN PI_PAT pat ON a0.id_pat=pat.id_pat"
		     +"  left JOIN BD_UDIDOC D0 ON A0.ID_SRVTP=D0.ID_UDIDOC"
		     +"  LEFT JOIN BD_MEASDOC c0 ON a0.srvu=c0.id_measdoc"
		     +"  left join bd_mm mm on mm.id_mm = A0.id_mm"
		     +"  left join ci_or_srv srv on a0.id_orsrv=srv.id_orsrv"
		     +"  left join ci_or_srv_mm srvmm on srv.id_orsrv = srvmm.id_orsrv"
		     +"  left join bd_udidoc b on srvmm.id_dosage = b.id_udidoc"
		     +"  left join bd_psndoc p on p.id_psndoc=a0.id_emp_or"
		     +"  left join bd_dep dep on a0.id_dep_or = dep.id_dep"
		     +"  left join en_ent ent on A0.id_ent=ent.id_ent"
		     +"  left join bd_wg wg  on ent.id_wg_phy = wg.id_wg"
		     +"  left join ci_order ci on ci.id_or = a0.id_or"
		     +"  left join bd_route route on ci.id_route = route.id_route"  
		     +"  left join bd_dep nur on ent.id_dep_nur = nur.id_dep"
		     +"  WHERE A0.DS = 0 and ent.code =? ";
	
	/**
	 * 住院病人费用信息
	 */
	public String ZYCOST_NEW = "SELECT  '0' as hiscode,pat.code as patientid,ent.code as visitid,"
     +"        decode(substr(srv.sd_srvtp,0,2),'01','1','04','2','03','3','02','4','5') as costtype,"
     +"        decode(substr(srv.sd_srvtp,0,2),'01',mm.code,a0.code_srv) as itemcode,a0.name_srv as itemname,"
     +"        b.name as drugform,"
     +"        decode(mm.spec,'','/',mm.spec) drugspec,"
     +"        mm.sup_name as drugsccj,"
     +"        c0.name as itemunit,"
     +"        A0.QUAN*A0.Eu_Direct itemnum,"
     +"        A0.Amt_Std*A0.EU_DIRECT AS cost,"
     +"        A0.Dt_cg as costtime,"
     +"        p.code as doctorcode,"
     +"        p.name as doctorname,"
     +"        dep.code deptcode,"
     +"        dep.name as deptname,"
     +"        nur.code as wardcode,"
     +"        nur.name as wardname,"
     +"        wg.code as medgroupcode,"
     +"        wg.name as medgroupname,"
     +"        decode(srv.fg_pres_outp,'Y','1','0') is_out,"
     +"        route.name as routecode,"
     +"        org.code as orgcode ,org.name as orgname"
     +"   FROM BL_CG_IP A0"
     +"   left JOIN BD_SRVCA B0 ON a0.id_srvca=b0.id_srvca"
     +"   left JOIN PI_PAT pat ON a0.id_pat=pat.id_pat"
     +"  left JOIN BD_UDIDOC D0 ON A0.ID_SRVTP=D0.ID_UDIDOC"
     +"  LEFT JOIN BD_MEASDOC c0 ON a0.srvu=c0.id_measdoc"
     +"  left join bd_mm mm on mm.id_mm = A0.id_mm"
     +"  left join ci_or_srv srv on a0.id_orsrv=srv.id_orsrv"
     +"  left join ci_or_srv_mm srvmm on srv.id_orsrv = srvmm.id_orsrv"
     +"  left join bd_udidoc b on srvmm.id_dosage = b.id_udidoc"
     +"  left join bd_psndoc p on p.id_psndoc=a0.id_emp_or"
     +"  left join bd_dep dep on a0.id_dep_or = dep.id_dep"
     +"  left join en_ent ent on A0.id_ent=ent.id_ent"
     +"  left join bd_wg wg  on ent.id_wg_phy = wg.id_wg"
     +"  left join ci_order ci on ci.id_or = a0.id_or"
     +"  left join bd_route route on ci.id_route = route.id_route"  
     +"  left join bd_dep nur on ent.id_dep_nur = nur.id_dep"
     +"  left join bd_org org on org.id_org=A0.ID_ORG"
     +"  WHERE A0.DS = 0 and ent.code =? and org.code=?";
	/**
	 * 住院病人手术信息
	 */
	public String ZYOPERATION = "select '0' hiscode,sug.id_mrfpsug as oprid,pat.code as patientid, e.code as visitid,   sug.sd_sug as operationcode,sug.name_sug as operationname,"
		     +"  case when nvl(sug.sd_incicondi,'~')='~' then '4' when to_number(sug.sd_incitp)=0 then '0'"
		     +"  when to_number(sug.sd_incicondi) between 1 and 4 then '1'"
		     +"  when to_number(sug.sd_incicondi) between 5 and 8 then '2'"
		     +" when to_number(sug.sd_incicondi) between 9 and 12 then '3' else '4' end as incisiontype,"
		     +" -1 as riskfactor, sug.dt_start_sug as startdate,sug.dt_end_sug as enddate,"
		     +" sug.sd_emp_sug as doctorcode,sug.name_emp_sug as doctorname,dep.code as deptcode,dep.name as deptname"
		     +" from ci_mr_fp_sug sug"
		     +" left join en_ent e on sug.id_ent = e.id_ent"
		     +" left join bd_dep dep on e.id_dep_phy=dep.id_dep"
		     +" left join pi_pat pat on e.id_pat = pat.id_pat"
		     +" where e.code=? ";
	
	/**
	 * 住院病人手术信息(new)
	 */
	public String ZYOPERATION_NEW = "select '0' hiscode,sug.id_mrfpsug as oprid,pat.code as patientid, e.code as visitid,   sug.sd_sug as operationcode,sug.name_sug as operationname,"
     +"  case when nvl(sug.sd_incicondi,'~')='~' then '4' when to_number(sug.sd_incitp)=0 then '0'"
     +"  when to_number(sug.sd_incicondi) between 1 and 4 then '1'"
     +"  when to_number(sug.sd_incicondi) between 5 and 8 then '2'"
     +" when to_number(sug.sd_incicondi) between 9 and 12 then '3' else '4' end as incisiontype,"
     +" -1 as riskfactor, sug.dt_start_sug as startdate,sug.dt_end_sug as enddate,"
     +" sug.sd_emp_sug as doctorcode,sug.name_emp_sug as doctorname,dep.code as deptcode,dep.name as deptname,"
     +" org.code as orgcode ,org.name as orgname"
     +" from ci_mr_fp_sug sug"
     +" left join en_ent e on sug.id_ent = e.id_ent"
     +" left join bd_dep dep on e.id_dep_phy=dep.id_dep"
     +" left join pi_pat pat on e.id_pat = pat.id_pat"
     +" left join bd_org org on org.id_org=e.id_org where e.code=? and org.code=?";


	/**
	 * 住院病人体温信息
	 */
	public String ZYTEMPERATURE = "select '0' as hiscode,pi_pat.code as patientid,en_ent.code as visitid,vs.dt_vt as taketime,"
            +" vsitm.value as temperature"
            +"   from ci_mr_vs vs"
            +"   left join ci_mr_vs_itm vsitm on vs.id_mr_vs = vsitm.id_mr_vs"
            +"   left join en_ent on en_ent.id_ent = vs.id_ent"
            +"   left join pi_pat on pi_pat.id_pat = en_ent.id_pat"
            +"   where vsitm.id_srv='0001Z7100000000EZCIF' and en_ent.code=? ";
	/**
	 * 住院病人体温信息(new)
	 */
	public String ZYTEMPERATURE_NEW = "select '0' as hiscode,pi_pat.code as patientid,en_ent.code as visitid,vs.dt_vt as taketime,"
               +" vsitm.value as temperature,org.code as orgcode ,org.name as orgname"
               +"   from ci_mr_vs vs"
               +"   left join ci_mr_vs_itm vsitm on vs.id_mr_vs = vsitm.id_mr_vs"
               +"   left join en_ent on en_ent.id_ent = vs.id_ent"
               +"   left join pi_pat on pi_pat.id_pat = en_ent.id_pat"
               +"   left join bd_org org on org.id_org=vs.id_org"
               +"   where vsitm.id_srv='0001Z7100000000EZCIF' and en_ent.code=? and org.code=?";
	/**
	 * 住院检验信息
	 */
	public String ZYLAB = "select distinct der.id_or,'0' as hiscode,"
		       +"       pat.code as patientid,"
		       +"       e.code as visitid,"
		       +"       pat.code as patcode,"
		       +"       der.applyno as requestno,"
		       +"       bdsrv2.code as labcode,"
		       +"       bdsrv2.name  as labname,"
		       +"       b.name  as sampletype,"
		       +"       srv.dt_create as samplingtime,"
		       +"       itm.lis_code_srv as itemcode,"
		       +"       itm.name_srv  as itemname,"
		       +"       itm.val_rstrptlab as labresult,"
		       +"       itm.sd_val_state as resultflag,"
		       +"       itm.reference_ranges,"
		       +"       itm.name_unit as unit,"
		       +"       rptlab.dt_rptlab as reporttime,"
		       +"       p.name as doctorname"
		       +"  from ci_order der"
		       +"  left join ci_or_srv srv on srv.id_or = der.id_or"
		       +"  left join bd_srv bdsrv2 on der.id_srv = bdsrv2.id_srv"
		       +"  left join ci_ap_lab lab on der.id_or = lab.id_or"
		       +"  left join ci_rpt_lab rptlab on rptlab.id_orlab = lab.id_orlab"
		       +"  right join ci_rpt_lab_itm itm on itm.id_rptlab = rptlab.id_rptlab"
		       +"  left join bd_udidoc b  on lab.id_samptp = b.id_udidoc"
		       +"  left join bd_sampcol_time t  on lab.id_sampcoltime = t.id_sampcollecttime"
		       +"  left join bd_psndoc p on p.id_psndoc = der.id_emp_or"
		       +"  left join en_ent e on e.id_ent = der.id_en"
		       +"  left join pi_pat pat  on pat.id_pat = e.id_pat"
		       +" where e.code_entp in ('10') and der.sd_srvtp like '03%' and srv.fg_bl ='Y' and e.code=? "
		       +"  order by der.id_or";
	/**
	 * 住院检验信息(new)
	 */
	public String ZYLAB_NEW = "select distinct der.id_or,'0' as hiscode,"
       +"       pat.code as patientid,"
       +"       e.code as visitid,"
       +"       pat.code as patcode,"
       +"       der.applyno as requestno,"
       +"       bdsrv2.code as labcode,"
       +"       bdsrv2.name  as labname,"
       +"       b.name  as sampletype,"
       +"       srv.dt_create as samplingtime,"
       +"       itm.lis_code_srv as itemcode,"
       +"       itm.name_srv  as itemname,"
       +"       itm.val_rstrptlab as labresult,"
       +"       itm.sd_val_state as resultflag,"
       +"       itm.reference_ranges,"
       +"       itm.name_unit as unit,"
       +"       rptlab.dt_rptlab as reporttime,"
       +"       p.name as doctorname,"
       +"       org.code as orgcode ,org.name as orgname"
       +"  from ci_order der"
       +"  left join ci_or_srv srv on srv.id_or = der.id_or"
       +"  left join bd_srv bdsrv2 on der.id_srv = bdsrv2.id_srv"
       +"  left join ci_ap_lab lab on der.id_or = lab.id_or"
       +"  left join ci_rpt_lab rptlab on rptlab.id_orlab = lab.id_orlab"
       +"  right join ci_rpt_lab_itm itm on itm.id_rptlab = rptlab.id_rptlab"
       +"  left join bd_udidoc b  on lab.id_samptp = b.id_udidoc"
       +"  left join bd_sampcol_time t  on lab.id_sampcoltime = t.id_sampcollecttime"
       +"  left join bd_psndoc p on p.id_psndoc = der.id_emp_or"
       +"  left join en_ent e on e.id_ent = der.id_en"
       +"  left join pi_pat pat  on pat.id_pat = e.id_pat"
       +"  left join bd_org org on org.id_org=der.id_org"
       +" where e.code_entp in ('10') and der.sd_srvtp like '03%' and srv.fg_bl ='Y' and e.code=? and org.code=?"
       +"  order by der.id_or";
	/**
	 * 住院检查信息
	 */
	public String ZYEXAM = "select '0' as hiscode,pat.code as patientid,e.code as visitid,srv.code as examcode,srv.name as examname,"
		    +"             o.no_applyform as requestno,srv_set.body_name as bodypart,o.des_rptobs || o.des_advice as examresult,"
		    +"             o.dt_rptobs as reporttime,p.name as doctorname"
		    +"             from ci_rpt_obs o"
		    +"             left join ci_order ci on o.id_or = ci.id_or"
		    +"             left join ci_or_srv_set srv_set on o.id_or = srv_set.id_or"
		    +"             left join bd_psndoc p on p.id_psndoc = ci.id_emp_or"
		    +"             left join bd_srv srv on ci.id_srv = srv.id_srv"
		    +"             left join en_ent e on e.id_ent = ci.id_en"
		    +"             left join pi_pat pat on pat.id_pat = e.id_pat"
		    +"             where e.code_entp in ('10') and ci.fg_set='Y' and e.code=? "
		    +"      union all"
		    +" select '0' as hiscode,pat.code as patientid,e.code as visitid,srv.code as examcode,srv.name as examname,"
		    +"             o.no_applyform as requestno,doc.name as bodypart,o.des_rptobs || o.des_advice as examresult,"
		    +"             o.dt_rptobs as reporttime,p.name as doctorname"
		    +"             from ci_rpt_obs o"
		    +"             left join ci_order ci on o.id_or = ci.id_or"
		    +"             left join ci_ap_obs obs on o.id_or = obs.id_or"
		    +"             left join bd_udidoc doc on doc.id_udidoc = obs.id_body"
		    +"             left join bd_psndoc p on p.id_psndoc = ci.id_emp_or"
		    +"             left join bd_srv srv on ci.id_srv = srv.id_srv"
		    +"             left join en_ent e on e.id_ent = ci.id_en"
		    +"             left join pi_pat pat on pat.id_pat = e.id_pat"
		    +"             where e.code_entp in ('10') and  ci.fg_set='N' and e.code=? ";
	/**
	 * 住院检查信息(new)
	 */
	public String ZYEXAM_NEW = "select '0' as hiscode,pat.code as patientid,e.code as visitid,srv.code as examcode,srv.name as examname,"
    +"             o.no_applyform as requestno,srv_set.body_name as bodypart,o.des_rptobs || o.des_advice as examresult,"
    +"             o.dt_rptobs as reporttime,p.name as doctorname,"
    +"             org.code as orgcode ,org.name as orgname"
    +"             from ci_rpt_obs o"
    +"             left join ci_order ci on o.id_or = ci.id_or"
    +"             left join ci_or_srv_set srv_set on o.id_or = srv_set.id_or"
    +"             left join bd_psndoc p on p.id_psndoc = ci.id_emp_or"
    +"             left join bd_srv srv on ci.id_srv = srv.id_srv"
    +"             left join en_ent e on e.id_ent = ci.id_en"
    +"             left join pi_pat pat on pat.id_pat = e.id_pat"
    +"             left join bd_org org on org.id_org=ci.id_org"
    +"             where e.code_entp in ('10') and ci.fg_set='Y' and e.code=? and org.code=?"
    +"      union all"
    +" select '0' as hiscode,pat.code as patientid,e.code as visitid,srv.code as examcode,srv.name as examname,"
    +"             o.no_applyform as requestno,doc.name as bodypart,o.des_rptobs || o.des_advice as examresult,"
    +"             o.dt_rptobs as reporttime,p.name as doctorname,"
    +"             org.code as orgcode ,org.name as orgname"
    +"             from ci_rpt_obs o"
    +"             left join ci_order ci on o.id_or = ci.id_or"
    +"             left join ci_ap_obs obs on o.id_or = obs.id_or"
    +"             left join bd_udidoc doc on doc.id_udidoc = obs.id_body"
    +"             left join bd_psndoc p on p.id_psndoc = ci.id_emp_or"
    +"             left join bd_srv srv on ci.id_srv = srv.id_srv"
    +"             left join en_ent e on e.id_ent = ci.id_en"
    +"             left join pi_pat pat on pat.id_pat = e.id_pat"
    +"             left join bd_org org on org.id_org=ci.id_org"
    +"             where e.code_entp in ('10') and  ci.fg_set='N' and e.code=? and org.code=?";
	/**
	 * 住院转科信息
	 */
	public String ZYTRANSFERRED = "select  '0' as hiscode,pat.code as patientid,ent.code as visitid,dep1.code as dept_stayed, entdep.dt_b as admission_date_time,"
	           +"  entdep.dt_e as discharge_date_time,  dep2.code as dept_transfered_to,ent.id_emp_phy as id_ent"
	           +"  from en_ent_dep entdep"
	           +"  left join en_ent ent on entdep.id_ent = ent.id_ent"
	           +"  left join bd_dep dep1 on entdep.id_dep = dep1.id_dep"
	           +"  left join bd_dep dep2 on entdep.id_dep_to = dep2.id_dep"
	           +"  left join pi_pat pat on pat.id_pat = ent.id_pat"
	           +"  where nvl(entdep.id_dep_to,'~') <> '~' and entdep.sd_entdeprole='1' and ent.code=? ";

	/**
	 * 住院转科信息(new)
	 */
	public String ZYTRANSFERRED_NEW = "select  '0' as hiscode,pat.code as patientid,ent.code as visitid,dep1.code as dept_stayed, entdep.dt_b as admission_date_time,"
           +"  entdep.dt_e as discharge_date_time,  dep2.code as dept_transfered_to,ent.id_emp_phy as id_ent,"
           +"  org.code as orgcode ,org.name as orgname"
           +"  from en_ent_dep entdep"
           +"  left join en_ent ent on entdep.id_ent = ent.id_ent"
           +"  left join bd_dep dep1 on entdep.id_dep = dep1.id_dep"
           +"  left join bd_dep dep2 on entdep.id_dep_to = dep2.id_dep"
           +"  left join pi_pat pat on pat.id_pat = ent.id_pat"
           +"  left join bd_org org on org.id_org = ent.id_org"
           +"  where nvl(entdep.id_dep_to,'~') <> '~' and entdep.sd_entdeprole='1' and ent.code=? and org.code=?";

	/****************************** 门诊部分开始 ******************************/

	/**
	 * 门诊患者列表
	 */
	public String MZPATIENTLIST = " select '0' as hiscode,p.code as patientid,e.code as clinicno " + " from en_ent e "
			+ " inner join pi_pat p " + " on e.id_pat=p.id_pat and e.code_entp='00' "
			+ " where e.dt_acpt>=? and e.dt_acpt<=? ";
	/**
	 * 门诊患者列表(组织编码)
	 */
	public String MZPATIENTLIST_NEW = " select '0' as hiscode,p.code as patientid,e.code as clinicno ,org.code as orgcode,org.name as orgname"
			+ " from en_ent e " + " inner join pi_pat p " + " on e.id_pat=p.id_pat and e.code_entp='00' "
			+ " left join bd_org org " + " on org.id_org = e.id_org "
			+ " where e.dt_acpt>=? and e.dt_acpt<=?  and org.code=?";
	/**
	 * 门诊患者信息
	 */
	public String MZPATIENT = "select '0' as hiscode,pat.code as patientid,ent.code as clinicno,pat.code as patcode,"
			+ "       pat.name as patientname,decode(pat.sd_sex,'1','男','2','女','未知') as sex,pat.dt_birth as birthdate,"
			+ "       to_number(to_char(sysdate,'yyyy'))  - to_number(substr(pat.dt_birth,0,4)) as age,'' as height,'' as weight,decode(pat.sd_idtp,'01',pat.id_code,'') as identitycard,pat.tel as telephone,   decode(ent.sd_status,'05','1','08','1','0') visited,dep.code as deptcode,dep.name as deptname,"
			+ "       ent.dt_acpt as enddate,psn.code as doctorcode,psn.name as doctorname,'' as medgroupcode,'' as medgroupname,   ca.name as payclass,"
			+ "       case when ent.id_dep_phy in (select id_dep from bd_dep dep where dep.name like '%急诊%') then 1 else 0 end as is_emergency,'' as is_preg,  '' as preg_starttime,-1 as is_lact,-1 as hep_damage,-1 as ren_damage,'' as standby"
			+ "       from pi_pat pat " + "       left join en_ent ent on pat.id_pat=ent.id_pat "
			+ "       left join bd_dep dep on ent.id_dep_phy = dep.id_dep "
			+ "       left join bd_psndoc psn on ent.id_emp_phy = psn.id_psndoc "
			+ "       left join pi_pat_ca ca on ca.id_patca = ent.id_patca "
			+ "       where ent.fg_canc ='N'and ent.code_entp in ('00','01','02') "
			+ "       and pat.code = ? and ent.code= ?";
	/**
	 * 门诊患者信息(组织编码)
	 */
	public String MZPATIENT_NEW = "select '0' as hiscode,pat.code as patientid,ent.code as clinicno,pat.code as patcode,"
			+ "       pat.name as patientname,decode(pat.sd_sex,'1','男','2','女','未知') as sex,pat.dt_birth as birthdate,"
			+ "       to_number(to_char(sysdate,'yyyy'))  - to_number(substr(pat.dt_birth,0,4)) as age,'' as height,'' as weight,decode(pat.sd_idtp,'01',pat.id_code,'') as identitycard,pat.tel as telephone,   decode(ent.sd_status,'05','1','08','1','0') visited,dep.code as deptcode,dep.name as deptname,"
			+ "       ent.dt_acpt as enddate,psn.code as doctorcode,psn.name as doctorname,'' as medgroupcode,'' as medgroupname,   ca.name as payclass,"
			+ "       case when ent.id_dep_phy in (select id_dep from bd_dep dep where dep.name like '%急诊%') then 1 else 0 end as is_emergency,'' as is_preg,  '' as preg_starttime,-1 as is_lact,-1 as hep_damage,-1 as ren_damage,'' as standby,org.code as orgcode,org.name as orgname"
			+ "       from pi_pat pat " + "       left join en_ent ent on pat.id_pat=ent.id_pat "
			+ "       left join bd_dep dep on ent.id_dep_phy = dep.id_dep "
			+ "       left join bd_psndoc psn on ent.id_emp_phy = psn.id_psndoc "
			+ "       left join pi_pat_ca ca on ca.id_patca = ent.id_patca "
			+ "       left join bd_org org on org.id_org = dep.id_org "
			+ "       where ent.fg_canc ='N'and ent.code_entp in ('00','01','02') "
			+ "       and pat.code = ? and ent.code= ? and org.code=?";
	/**
	 * 门诊病人处方信息
	 */
	public String MZPRESC = "select '0' as hiscode, pat.code as patientid,ent.code as clinicno,ent.code||pres.code as prescno,"
			+ "max(decode(substr(srv.sd_srvtp,0,4),'0101','1','0102','2','0103','3','0')) as presctype,"
			+ "doc.name as prescname,max(ci.orders) as prescdose,max(decode(di.fg_chronic,'Y','1','0')) as chronic,sum(mm.quan_cur*mm.price_pgku_cur) as cost,"
			+ "max(dep.code) as deptcode,max(dep.name) as deptname, max(psn.code) as doctorcode,max(psn.name) as doctorname,'' as medgroupcode,"
			+ "'' as medgroupname,max(ci.dt_effe) as enddate, decode(max(psn1.code),'',max(psn2.code),max(psn1.code)) as pharm_reviewid,decode(max(psn1.name),'',max(psn2.name),max(psn1.name) )as pharm_review,max(psn2.code)  as pharm_mixid,max(psn2.name)  as pharm_mix,"
			+ "max(psn2.code) as pharm_checkid,max(psn2.name) as pharm_check,max(psn2.code) as pharm_dispensingid,max(psn2.name) as pharm_dispensing,max(ci.des_or) as remark"
			+ "   from ci_order ci" + "      left join ci_or_srv srv on ci.id_or = srv.id_or"
			+ "      left join ci_or_srv_mm mm on srv.id_orsrv = mm.id_orsrv"
			+ "      left join (select en_ent_di.fg_chronic as fg_chronic, en_ent.id_pat as id_pat from en_ent_di"
			+ "                left join en_ent on en_ent_di.id_ent=en_ent.id_ent"
			+ "                where en_ent.code=? and en_ent_di.fg_chronic='Y') di on di.id_pat = ci.id_pat"
			+ "      left join bd_dep dep on ci.id_dep_or=dep.id_dep"
			+ "      left join bd_psndoc psn on ci.id_emp_or = psn.id_psndoc"
			+ "      left join bd_psndoc psn1 on ci.id_emp_verify_pharm=psn1.id_psndoc"
			+ "      left join mp_dg_op mp on srv.id_pres = mp.id_pres"
			+ "      left join bd_psndoc psn2 on mp.id_emp_dp = psn2.id_psndoc"
			+ "      left join en_ent ent on ci.id_en = ent.id_ent"
			+ "      left join ci_pres pres on srv.id_pres = pres.id_pres"
			+ "      left join bd_udidoc doc on doc.id_udidoc = pres.id_prestp"
			+ "      left join pi_pat pat on pat.id_pat = ci.id_pat"
			+ "      where srv.sd_srvtp like '01%' and ent.code_entp ='00' and ent.code=? \n"
			+ "      group by pres.id_pres,pres.code,ent.code,pat.code,doc.name";

	/**
	 * 门诊病人处方信息(新)
	 */
	public String MZPRESC_NEW = "select '0' as hiscode, pat.code as patientid,ent.code as clinicno,ent.code||pres.code as prescno,"
			+ "max(decode(substr(srv.sd_srvtp,0,4),'0101','1','0102','2','0103','3','0')) as presctype,"
			+ "doc.name as prescname,max(ci.orders) as prescdose,max(decode(di.fg_chronic,'Y','1','0')) as chronic,sum(mm.quan_cur*mm.price_pgku_cur) as cost,"
			+ "max(dep.code) as deptcode,max(dep.name) as deptname, max(psn.code) as doctorcode,max(psn.name) as doctorname,'' as medgroupcode,"
			+ "'' as medgroupname,max(ci.dt_effe) as enddate, decode(max(psn1.code),'',max(psn2.code),max(psn1.code)) as pharm_reviewid,decode(max(psn1.name),'',max(psn2.name),max(psn1.name) )as pharm_review,max(psn2.code)  as pharm_mixid,max(psn2.name)  as pharm_mix,"
			+ "max(psn2.code) as pharm_checkid,max(psn2.name) as pharm_check,max(psn2.code) as pharm_dispensingid,max(psn2.name) as pharm_dispensing,max(ci.des_or) as remark,org.code as orgcode,org.name as orgname"
			+ "   from ci_order ci" + "      left join ci_or_srv srv on ci.id_or = srv.id_or"
			+ "      left join ci_or_srv_mm mm on srv.id_orsrv = mm.id_orsrv"
			+ "      left join (select en_ent_di.fg_chronic as fg_chronic, en_ent.id_pat as id_pat from en_ent_di"
			+ "                left join en_ent on en_ent_di.id_ent=en_ent.id_ent"
			+ "                where en_ent.code=? and en_ent_di.fg_chronic='Y') di on di.id_pat = ci.id_pat"
			+ "      left join bd_dep dep on ci.id_dep_or=dep.id_dep"
			+ "      left join bd_psndoc psn on ci.id_emp_or = psn.id_psndoc"
			+ "      left join bd_psndoc psn1 on ci.id_emp_verify_pharm=psn1.id_psndoc"
			+ "      left join mp_dg_op mp on srv.id_pres = mp.id_pres"
			+ "      left join bd_psndoc psn2 on mp.id_emp_dp = psn2.id_psndoc"
			+ "      left join en_ent ent on ci.id_en = ent.id_ent"
			+ "      left join ci_pres pres on srv.id_pres = pres.id_pres"
			+ "      left join bd_udidoc doc on doc.id_udidoc = pres.id_prestp"
			+ "      left join pi_pat pat on pat.id_pat = ci.id_pat"
			+ "      left join bd_org org on org.id_org = dep.id_org"
			+ "      where srv.sd_srvtp like '01%' and ent.code_entp ='00' and ent.code=? and org.code=?\n"
			+ "      group by pres.id_pres,pres.code,ent.code,pat.code,doc.name,org.code,org.name";

	/**
	 * 获取门诊病人医嘱信息
	 */
	public String MZORDERS = "select '0' as hiscode,ci.code_or||srv.sortno as cid,pat.code as patientid,e.code as clinicno,e.code||pres.code as prescno,ci.code_or as orderno,decode(substr(ci.sd_srvtp,0,2),'01','1','04','2','03','3','02','4','06','5','6') as ordertype,\n"
			+ "    ci.code_or as grouptag,srvmm.code_mm as drug_unique_code,decode(substr(ci.sd_srvtp,0,2),'01',mm.code,srv.code_srv) as ordercode,\n"
			+ "    replace(srv.name|| '('|| boil.name|| ')','()','') as ordername,b.name as drugform,mm.spec as drugspec,route.name as routecode,\n"
			+ "    route.name as routename,srv.quan_medu as singledose,measdoc1.name as doseunit,freq.name as frequency,\n"
			+ "    srvmm.quan_cur as  num ,measdoc2.name as numunit,(srvmm.quan_cur*srvmm.price_pgku_cur)as cost ,'' as ph,'' as taker,\n"
			+ "    dep.code as deptcode,dep.name as deptname,psn.code as doctorcode,psn.name as doctorname,ci.dt_effe as startdatetime,\n"
			+ "    ci.days_or as days, '0' as purpose,\n" + "    '' as remark,'' as is_allow,'' as reasonable_desc \n"
			+ "     from ci_order ci \n" + "    left join ci_or_srv srv  on ci.id_or=srv.id_or \n"
			+ "    left join ci_or_srv_mm srvmm on srv.id_orsrv=srvmm.id_orsrv \n"
			+ "    left join bd_udidoc b on srvmm.id_dosage = b.id_udidoc \n"
			+ "    left join bd_mm mm on mm.id_mm=srvmm.id_mm \n"
			+ "    left join bd_route route on ci.id_route = route.id_route \n"
			+ "    left join bd_measdoc measdoc1 on srv.id_medu = measdoc1.id_measdoc \n"
			+ "    left join bd_freq freq on ci.id_freq = freq.id_freq \n"
			+ "    left join bd_measdoc measdoc2 on srvmm.id_pgku_cur=measdoc2.id_measdoc \n"
			+ "    left join bd_psndoc psn on ci.id_emp_or = psn.id_psndoc \n"
			+ "    left join bd_dep dep on ci.id_dep_or=dep.id_dep \n"
			+ "    left join bd_psndoc psn1 on ci.id_emp_verify_pharm=psn1.id_psndoc \n"
			+ "    left join en_ent e on ci.id_en=e.id_ent \n" + "    left join pi_pat pat on ci.id_pat = pat.id_pat \n"
			+ "    left join ci_pres pres on pres.id_pres=srv.id_pres \n"
			+ "    left join bd_boil_des boil on srv.id_boildes = boil.id_boildes \n"
			+ "    where pat.code=? and e.code=?  and srv.sd_srvtp like '01%' and ci.fg_canc ='N'";

	/**
	 * 获取门诊病人医嘱信息
	 */
	public String MZORDERS_NEW = "select '0' as hiscode,ci.code_or||srv.sortno as cid,pat.code as patientid,e.code as clinicno,e.code||pres.code as prescno,ci.code_or as orderno,decode(substr(ci.sd_srvtp,0,2),'01','1','04','2','03','3','02','4','06','5','6') as ordertype,\n"
			+ "    ci.code_or as grouptag,srvmm.code_mm as drug_unique_code,decode(substr(ci.sd_srvtp,0,2),'01',mm.code,srv.code_srv) as ordercode,\n"
			+ "    replace(srv.name|| '('|| boil.name|| ')','()','') as ordername,b.name as drugform,mm.spec as drugspec,route.name as routecode,\n"
			+ "    route.name as routename,srv.quan_medu as singledose,measdoc1.name as doseunit,freq.name as frequency,\n"
			+ "    srvmm.quan_cur as  num ,measdoc2.name as numunit,(srvmm.quan_cur*srvmm.price_pgku_cur)as cost ,'' as ph,'' as taker,\n"
			+ "    dep.code as deptcode,dep.name as deptname,psn.code as doctorcode,psn.name as doctorname,ci.dt_effe as startdatetime,\n"
			+ "    ci.days_or as days, '0' as purpose,\n"
			+ "    '' as remark,'' as is_allow,'' as reasonable_desc,org.code as orgcode,org.name as orgname \n"
			+ "     from ci_order ci \n" + "    left join ci_or_srv srv  on ci.id_or=srv.id_or \n"
			+ "    left join ci_or_srv_mm srvmm on srv.id_orsrv=srvmm.id_orsrv \n"
			+ "    left join bd_udidoc b on srvmm.id_dosage = b.id_udidoc \n"
			+ "    left join bd_mm mm on mm.id_mm=srvmm.id_mm \n"
			+ "    left join bd_route route on ci.id_route = route.id_route \n"
			+ "    left join bd_measdoc measdoc1 on srv.id_medu = measdoc1.id_measdoc \n"
			+ "    left join bd_freq freq on ci.id_freq = freq.id_freq \n"
			+ "    left join bd_measdoc measdoc2 on srvmm.id_pgku_cur=measdoc2.id_measdoc \n"
			+ "    left join bd_psndoc psn on ci.id_emp_or = psn.id_psndoc \n"
			+ "    left join bd_dep dep on ci.id_dep_or=dep.id_dep \n"
			+ "    left join bd_psndoc psn1 on ci.id_emp_verify_pharm=psn1.id_psndoc \n"
			+ "    left join en_ent e on ci.id_en=e.id_ent \n" + "    left join pi_pat pat on ci.id_pat = pat.id_pat \n"
			+ "    left join ci_pres pres on pres.id_pres=srv.id_pres \n"
			+ "    left join bd_boil_des boil on srv.id_boildes = boil.id_boildes \n"
			+ "    left join bd_org org on org.id_org = dep.id_org \n"
			+ "    where pat.code=? and e.code=? and org.code=? and srv.sd_srvtp like '01%' and ci.fg_canc ='N' and ci.sd_su_bl in ('0','1')";
	/**
	 * 门诊病人过敏信息
	 */
	public String MZALLERGEN = "select '0' as hiscode,pat.code as patientid,ent.code as clinicno,al.sd_alcla as allercode,al.name_alcla as allername,al.des_alcla as symptom \n"
			+ "  from pi_pat_al al \n" + " left join pi_pat pat on al.id_pat=pat.id_pat \n"
			+ " left join en_ent ent on al.id_pat = ent.id_pat \n" + " where pat.code=? ";
	/**
	 * 门诊病人过敏信息(新)
	 */
	public String MZALLERGEN_NEW = "select '0' as hiscode,pat.code as patientid,ent.code as clinicno,al.sd_alcla as allercode,al.name_alcla as allername,al.des_alcla as symptom,org.code as orgcode,org.name as orgname \n"
			+ "  from pi_pat_al al \n" + " left join pi_pat pat on al.id_pat=pat.id_pat \n"
			+ " left join en_ent ent on al.id_pat = ent.id_pat \n"
			+ " left join bd_org org on org.id_org = pat.id_org \n" + " where pat.code=? and org.code=?";
	/**
	 * 门诊病人疾病信息
	 */
	public String MZDISEASE = "select '0' as hiscode,pat.code as patientid,ent.code as clinicno, '' as prescno,di.code_didef_dis as discode, "
			+ "replace(di.name_didef_dis||'('||di.NAME_DIDEF_SYN||')','()','') as disname,di.sortno as sortid "
			+ "from  en_ent_di di " + "left join en_ent ent on di.id_ent = ent.id_ent "
			+ "left join pi_pat pat on pat.id_pat = ent.id_pat " + "where di.code_didef_dis<>'-' and ent.code=? ";

	/**
	 * 门诊病人疾病信息（新）
	 */
	public String MZDISEASE_NEW = "select '0' as hiscode,pat.code as patientid,ent.code as clinicno, '' as prescno,di.code_didef_dis as discode, "
			+ "replace(di.name_didef_dis||'('||di.NAME_DIDEF_SYN||')','()','') as disname,di.sortno as sortid,org.code as orgcode,org.name as orgname "
			+ "from  en_ent_di di " + "left join en_ent ent on di.id_ent = ent.id_ent "
			+ "left join pi_pat pat on pat.id_pat = ent.id_pat " + "left join bd_org org on org.id_org = pat.id_org "
			+ "where di.code_didef_dis<>'-' and ent.code=? and org.code=?";
	/**
	 * 门诊病人费用信息
	 */
	public String MZCOST = "select  '0' as hiscode,pat.code as patientid,ent.code as clinicno,ent.code||pres.code as prescno,\n"
			+ " 	decode(substr(srv.sd_srvtp,0,2),'01','1','04','2','03','3','02','4','5') as costtype,\n"
			+ " 	decode(substr(srv.sd_srvtp,0,2),'01',mm.code,a0.code_srv) as itemcode,a0.name_srv as itemname,\n"
			+ " 	b.name as drugform, decode(mm.spec,'','/',mm.spec) drugspec,mm.sup_name as drugsccj,\n"
			+ " 	c0.name as itemunit,a0.quan*oep.eu_direct itemnum,\n"
			+ " 	a0.amt_std*oep.eu_direct as cost, oep.dt_cg as costtime, dep.code deptcode,dep.name as deptname,\n"
			+ " 	p.code as doctorcode,p.name as doctorname,'' as medgroupcode,'' as medgroupname,route.name as routecode\n"
			+ " from bl_cg_itm_oep a0\n" + " left join bl_cg_oep oep on a0.id_cgoep=oep.id_cgoep\n"
			+ " left join bd_udidoc d0 on a0.id_srvtp=d0.id_udidoc\n"
			+ " left join bd_measdoc c0 on a0.srvu=c0.id_measdoc\n" + " left join bd_mm mm on mm.id_mm = a0.id_mm\n"
			+ " left join ci_or_srv srv on a0.id_orsrv=srv.id_orsrv\n"
			+ " left join ci_or_srv_mm srvmm on srv.id_orsrv = srvmm.id_orsrv\n"
			+ " left join bd_udidoc b on srvmm.id_dosage = b.id_udidoc\n"
			+ " left join bd_psndoc p on p.id_psndoc=a0.id_emp_or\n"
			+ " left join bd_dep dep on a0.id_dep_or = dep.id_dep\n" + " left join ci_order ci on ci.id_or = a0.id_or\n"
			+ " left join bd_route route on ci.id_route = route.id_route\n"
			+ " left join en_ent ent   on a0.id_ent=ent.id_ent\n"
			+ " left join ci_pres pres on pres.id_pres=srv.id_pres\n"
			+ " left join pi_pat pat on pat.id_pat = a0.id_pat\n" + " where a0.ds = 0 and ent.code =? ";
	/**
	 * 门诊病人费用信息(新)
	 */
	public String MZCOST_NEW = "select  '0' as hiscode,pat.code as patientid,ent.code as clinicno,ent.code||pres.code as prescno,\n"
			+ " 	decode(substr(srv.sd_srvtp,0,2),'01','1','04','2','03','3','02','4','5') as costtype,\n"
			+ " 	decode(substr(srv.sd_srvtp,0,2),'01',mm.code,a0.code_srv) as itemcode,a0.name_srv as itemname,\n"
			+ " 	b.name as drugform, decode(mm.spec,'','/',mm.spec) drugspec,mm.sup_name as drugsccj,\n"
			+ " 	c0.name as itemunit,a0.quan*oep.eu_direct itemnum,\n"
			+ " 	a0.amt_std*oep.eu_direct as cost, oep.dt_cg as costtime, dep.code deptcode,dep.name as deptname,\n"
			+ " 	p.code as doctorcode,p.name as doctorname,'' as medgroupcode,'' as medgroupname,route.name as routecode,org.code as orgcode,org.name as orgname\n"
			+ " from bl_cg_itm_oep a0\n" + " left join bl_cg_oep oep on a0.id_cgoep=oep.id_cgoep\n"
			+ " left join bd_udidoc d0 on a0.id_srvtp=d0.id_udidoc\n"
			+ " left join bd_measdoc c0 on a0.srvu=c0.id_measdoc\n" + " left join bd_mm mm on mm.id_mm = a0.id_mm\n"
			+ " left join ci_or_srv srv on a0.id_orsrv=srv.id_orsrv\n"
			+ " left join ci_or_srv_mm srvmm on srv.id_orsrv = srvmm.id_orsrv\n"
			+ " left join bd_udidoc b on srvmm.id_dosage = b.id_udidoc\n"
			+ " left join bd_psndoc p on p.id_psndoc=a0.id_emp_or\n"
			+ " left join bd_dep dep on a0.id_dep_or = dep.id_dep\n" + " left join ci_order ci on ci.id_or = a0.id_or\n"
			+ " left join bd_route route on ci.id_route = route.id_route\n"
			+ " left join en_ent ent   on a0.id_ent=ent.id_ent\n"
			+ " left join ci_pres pres on pres.id_pres=srv.id_pres\n"
			+ " left join pi_pat pat on pat.id_pat = a0.id_pat\n" + " left join bd_org org on org.id_org = dep.id_org\n"
			+ " where a0.ds = 0 and ent.code =? and org.code=?";
	/**
	 * 门诊病人检验信息
	 */
	public String MZLAB = "select distinct der.id_or,'0' as hiscode,pat.code as patientid,e.code as clinicno,pat.code as patcode,\n"
			+ "      der.applyno as requestno,bdsrv2.code as labcode,bdsrv2.name  as labname, b.name  as sampletype, srv.dt_create as samplingtime,itm.lis_code_srv as itemcode,\n"
			+ "      itm.name_srv  as itemname,itm.val_rstrptlab as labresult,itm.sd_val_state as resultflag,itm.reference_ranges,itm.name_unit as unit,rptlab.dt_rptlab as reporttime,\n"
			+ "      p.name as doctorname\n" + " from ci_order der\n"
			+ " left join ci_or_srv srv on srv.id_or = der.id_or\n"
			+ " left join bd_srv bdsrv2 on der.id_srv = bdsrv2.id_srv\n"
			+ " left join ci_ap_lab lab on der.id_or = lab.id_or\n"
			+ " left join ci_rpt_lab rptlab on rptlab.id_orlab = lab.id_orlab\n"
			+ " right join ci_rpt_lab_itm itm  on itm.id_rptlab = rptlab.id_rptlab\n"
			+ " left join bd_udidoc b on lab.id_samptp = b.id_udidoc\n"
			+ " left join bd_sampcol_time t on lab.id_sampcoltime = t.id_sampcollecttime\n"
			+ " left join bd_psndoc p  on p.id_psndoc = der.id_emp_or\n"
			+ " left join en_ent e on e.id_ent = der.id_en\n" + " left join pi_pat pat on pat.id_pat = e.id_pat\n"
			+ " where e.code_entp in ('00','01','02') and der.sd_srvtp like '03%' and srv.fg_bl ='Y'and e.code=? \n"
			+ " order by der.id_or";

	/**
	 * 门诊病人检验信息（新）
	 */
	public String MZLAB_NEW = "select distinct der.id_or,'0' as hiscode,pat.code as patientid,e.code as clinicno,pat.code as patcode,\n"
			+ "      der.applyno as requestno,bdsrv2.code as labcode,bdsrv2.name  as labname, b.name  as sampletype, srv.dt_create as samplingtime,itm.lis_code_srv as itemcode,\n"
			+ "      itm.name_srv  as itemname,itm.val_rstrptlab as labresult,itm.sd_val_state as resultflag,itm.reference_ranges,itm.name_unit as unit,rptlab.dt_rptlab as reporttime,\n"
			+ "      p.name as doctorname,org.code as orgcode,org.name as orgname\n" + " from ci_order der\n"
			+ " left join ci_or_srv srv on srv.id_or = der.id_or\n"
			+ " left join bd_srv bdsrv2 on der.id_srv = bdsrv2.id_srv\n"
			+ " left join ci_ap_lab lab on der.id_or = lab.id_or\n"
			+ " left join ci_rpt_lab rptlab on rptlab.id_orlab = lab.id_orlab\n"
			+ " right join ci_rpt_lab_itm itm  on itm.id_rptlab = rptlab.id_rptlab\n"
			+ " left join bd_udidoc b on lab.id_samptp = b.id_udidoc\n"
			+ " left join bd_sampcol_time t on lab.id_sampcoltime = t.id_sampcollecttime\n"
			+ " left join bd_psndoc p  on p.id_psndoc = der.id_emp_or\n"
			+ " left join en_ent e on e.id_ent = der.id_en\n" + " left join pi_pat pat on pat.id_pat = e.id_pat\n"
			+ " left join bd_org org on org.id_org = pat.id_org\n"
			+ " where e.code_entp in ('00','01','02') and der.sd_srvtp like '03%' and srv.fg_bl ='Y'and e.code=? and org.code=?\n"
			+ " order by der.id_or";
	/**
	 * 门诊病人检查信息
	 */
	public String MZEXAM = " select '0' as hiscode,pat.code as patientid,e.code as clinicno,srv.code as examcode,srv.name as examname,\n"
			+ "		o.no_applyform as requestno, srv_set.body_name as bodypart,o.des_rptobs || o.des_advice as examresult, o.dt_rptobs as reporttime,p.name  as doctorname\n"
			+ "      from ci_rpt_obs o\n" + "       left join ci_order ci on o.id_or = ci.id_or\n"
			+ "       left join ci_or_srv_set srv_set on o.id_or = srv_set.id_or\n"
			+ "       left join bd_psndoc p on p.id_psndoc = ci.id_emp_or\n"
			+ "       left join bd_srv srv on ci.id_srv = srv.id_srv\n"
			+ "       left join en_ent e on e.id_ent = ci.id_en\n"
			+ "       left join pi_pat pat on pat.id_pat = e.id_pat\n"
		    + "       where e.code_entp in ('00','01') \n"
			+ "       and ci.fg_set='Y'and  e.code=? \n" + "  union      all\n"
			+ "       select '0' as hiscode,pat.code as patientid,e.code as clinicno,srv.code as examcode,srv.name as examname,\n"
			+ "       o.no_applyform as requestno, doc.name as bodypart,o.des_rptobs || o.des_advice as examresult, o.dt_rptobs as reporttime\n"
			+ "       from ci_rpt_obs o\n" + "       left join ci_order ci on o.id_or = ci.id_or\n"
			+ "       left join ci_ap_obs obs on o.id_or = obs.id_or\n"
			+ "       left join bd_udidoc doc on doc.id_udidoc = obs.id_body\n"
			+ "       left join bd_psndoc p on p.id_psndoc = ci.id_emp_or\n"
			+ "       left join bd_srv srv on ci.id_srv = srv.id_srv\n"
			+ "       left join en_ent e on e.id_ent = ci.id_en\n"
			+ "       left join pi_pat pat on pat.id_pat = e.id_pat\n"
			+ "       where e.code_entp in ('00','01')\n"
			+ "       and ci.fg_set='N' and  e.code=? ";
	/**
	 * 门诊病人检查信息（新）
	 */
	public String MZEXAM_NEW = " select '0' as hiscode,pat.code as patientid,e.code as clinicno,srv.code as examcode,srv.name as examname,\n"
			+ "		o.no_applyform as requestno, srv_set.body_name as bodypart,o.des_rptobs || o.des_advice as examresult, o.dt_rptobs as reporttime,p.name  as doctorname,org.code as orgcode,org.name as orgname\n"
			+ "      from ci_rpt_obs o\n" + "       left join ci_order ci on o.id_or = ci.id_or\n"
			+ "       left join ci_or_srv_set srv_set on o.id_or = srv_set.id_or\n"
			+ "       left join bd_psndoc p on p.id_psndoc = ci.id_emp_or\n"
			+ "       left join bd_srv srv on ci.id_srv = srv.id_srv\n"
			+ "       left join en_ent e on e.id_ent = ci.id_en\n"
			+ "       left join pi_pat pat on pat.id_pat = e.id_pat\n"
			+ "       left join bd_org org on org.id_org = pat.id_org\n" + "       where e.code_entp in ('00','01') \n"
			+ "       and ci.fg_set='Y'and  e.code=? and org.code=?\n" + "  union      all\n"
			+ "       select '0' as hiscode,pat.code as patientid,e.code as clinicno,srv.code as examcode,srv.name as examname,\n"
			+ "       o.no_applyform as requestno, doc.name as bodypart,o.des_rptobs || o.des_advice as examresult, o.dt_rptobs as reporttime,p.name  as doctorname,org.code as orgcode,org.name as orgname\n"
			+ "       from ci_rpt_obs o\n" + "       left join ci_order ci on o.id_or = ci.id_or\n"
			+ "       left join ci_ap_obs obs on o.id_or = obs.id_or\n"
			+ "       left join bd_udidoc doc on doc.id_udidoc = obs.id_body\n"
			+ "       left join bd_psndoc p on p.id_psndoc = ci.id_emp_or\n"
			+ "       left join bd_srv srv on ci.id_srv = srv.id_srv\n"
			+ "       left join en_ent e on e.id_ent = ci.id_en\n"
			+ "       left join pi_pat pat on pat.id_pat = e.id_pat\n"
			+ "       left join bd_org org on org.id_org = pat.id_org\n" + "       where e.code_entp in ('00','01')\n"
			+ "       and ci.fg_set='N' and  e.code=? and org.code=?";
	/****************************** 字典部分开始 ******************************/
	/**
	 * 科室字典
	 */
	public String DICTDEPT = "select '0' as hiscode,b.code as deptcode,b.name as deptname,o.code as orgcode,o.name as orgname\n"
			+ " from bd_dep b\n" + " left join bd_org  o on o.id_org = b.id_org\n"
			+ " where b.sd_depttp='01' and b.ds='0'";
	/**
	 * 科室字典(new)
	 */
	public String DICTDEPT_NEW = "select '0' as hiscode,b.code as deptcode,b.name as deptname,o.code as orgcode,o.name as orgname\n"
			+ " from bd_dep b\n" + " left join bd_org  o on o.id_org = b.id_org\n"
			+ " where b.sd_depttp='01' and b.ds='0' and o.code=?";
	/**
	 * 医生字典信息
	 */
	public String DICTDOCTOR = "select\n"
			+ "     '0' as hiscode, p.code as doctorcode,p.name as doctorname,dep.code as deptcode,dep.name as deptname,\n"
			+ "     decode(p.sd_emptitle,'071','临床医师','233','主治医师','232','副主任医师','231','主任医师','') as doctorlevel,\n"
			+ "     decode(p.sd_emptitle,'071','1','233','2','232','3','231','4','') as ilevel,decode(p.sd_empwktp,'01','1','0') as is_clinic,\n"
			+ "     decode(phy.fg_presrt,'Y','1','0') as prespriv,decode(rtphy.code,'04','1','06','2','07','3',0) as antilevel,o.code as orgcode,o.name as orgname\n"
			+ " from bd_psndoc p\n" + "left join bd_dep dep on p.id_dep = dep.id_dep\n"
			+ " left join bd_org  o on o.id_org = dep.id_org \n"
			+ " left join bd_emp_phy phy on p.id_psndoc = phy.id_psndoc\n" + "left join\n"
			+ " (select max(rt.code) as code,rtref.id_emp_phy from bd_srv_rt_emp_ref rtref\n"
			+ " left join bd_srv_rt rt on rtref.id_srvrt=rt.id_srvrt\n"
			+ " where rt.id_srvrtca='0001Z8100000000MID6T' group by rtref.id_emp_phy) rtphy\n"
			+ " on p.id_psndoc=rtphy.id_emp_phy";
	
	/**
	 * 医生字典信息(new)
	 */
	public String DICTDOCTOR_NEW = "select\n"
			+ "     '0' as hiscode, p.code as doctorcode,p.name as doctorname,dep.code as deptcode,dep.name as deptname,\n"
			+ "     decode(p.sd_emptitle,'071','临床医师','233','主治医师','232','副主任医师','231','主任医师','') as doctorlevel,\n"
			+ "     decode(p.sd_emptitle,'071','1','233','2','232','3','231','4','') as ilevel,decode(p.sd_empwktp,'01','1','0') as is_clinic,\n"
			+ "     decode(phy.fg_presrt,'Y','1','0') as prespriv,decode(rtphy.code,'04','1','06','2','07','3',0) as antilevel,o.code as orgcode,o.name as orgname\n"
			+ " from bd_psndoc p\n" + "left join bd_dep dep on p.id_dep = dep.id_dep\n"
			+ " left join bd_org  o on o.id_org = dep.id_org \n"
			+ " left join bd_emp_phy phy on p.id_psndoc = phy.id_psndoc\n" + "left join\n"
			+ " (select max(rt.code) as code,rtref.id_emp_phy from bd_srv_rt_emp_ref rtref\n"
			+ " left join bd_srv_rt rt on rtref.id_srvrt=rt.id_srvrt\n"
			+ " where rt.id_srvrtca='0001Z8100000000MID6T' group by rtref.id_emp_phy) rtphy\n"
			+ " on p.id_psndoc=rtphy.id_emp_phy where o.code=?";
	/**
	 * 药品字典信息
	 *//*
	public String DICTDRUG = "select '0' as hiscode,mm.code as drugcode,mm.code as drug_unique_code,mm.name as drugname,\n"
			+ "       srv.name as tradename,b.name as drugform,mm.spec as drugspec,mm.apprno as approvalcode,mm.sup_name as comp_name,\n"
			+ "       m.name as doseunit,(select max(m1.name) from bd_mm_pkgu pkgu left join bd_measdoc m1 on pkgu.id_unit_pkg=m1.id_measdoc where mm.id_mm=pkgu.id_mm and pkgu.en_oppkgtp is not null and pkgu.en_oppkgtp=1) as costunit,\n"
			+ "       '' as adddate,decode(mm.fg_active,'Y','1','0') as is_use,decode(srvdrug.fg_anti,'Y','1','0') as is_anti,\n"
			+ "       case substr(mmca.code,0,2) when '12' then decode(substr(mmca.code,0,4),'1201','1','1207','2','1204','3','4') else '-1' end as antitype,\n"
			+ "         decode(srvdrug.sd_anti,'1','1','2','2','3','3','-1') as antilevel,mm.ddd as ddd,m1.name as dddunit,\n"
			+ "       '-1' as is_basedrug,mm.price as unitprice,o.code as orgcode,o.name as orgname\n"
			+ "       from bd_mm mm\n" + "       left join bd_srv srv on mm.id_srv=srv.id_srv\n"
			+ "       left join bd_org  o on o.id_org = mm.id_org\n"
			+ "       left join bd_srv_drug srvdrug on srv.id_srv=srvdrug.id_srv and srvdrug.ds=0\n"
			+ "       left join bd_udidoc b on b.id_udidoc = srvdrug.id_dosage\n"
			+ "       left join bd_measdoc m on m.id_measdoc = srv.id_unit_med\n"
			+ "       left join bd_mmca mmca on mm.id_mmca = mmca.id_mmca\n"
			+ "       left join bd_measdoc m1 on mm.id_unit_ddd = m1.id_measdoc\n" + "        where  mm.ds=0";*/
	
	public String DICTDRUG ="select '0' as hiscode,"
      +"       mm.code as drugcode,"
      +"       mm.code as drug_unique_code,"
      +"       srv.name as drugname,"
      +"       mm.name as tradename,"
      +"       b.name as drugform,"
      +"       mm.spec as drugspec,"
      +"       mm.apprno as approvalcode,"
      +"       mm.sup_name as comp_name,"
      +"       m.name as doseunit,"
      +"       s.name as costunit,   "
      +"       '' as adddate,"
      +"       decode(mm.fg_active, 'Y', '1', '0') as is_use,"
      +"       mm.price as unitprice,"
      +"       o.code   as orgcode,"
      +"       o.name   as orgname"
      +"  from bd_mm mm"
      +"  left join bd_srv srv"
      +"    on mm.id_srv = srv.id_srv"
      +"  left join bd_org o"
      +"    on o.id_org = mm.id_org"
      +"  left join bd_srv_drug srvdrug"
      +"    on srv.id_srv = srvdrug.id_srv"
      +"   and srvdrug.ds = 0"
      +"   left  join (select    m1.name ,pkgu.id_mm  from bd_mm_pkgu pkgu"
      +"          left join bd_measdoc m1"
      +"            on pkgu.id_unit_pkg = m1.id_measdoc"
      +"           where "
      +"         pkgu.en_oppkgtp is not null"
      +"  )  s  on  mm.id_mm = s.id_mm   "
      +"  left join bd_udidoc b"
      +"    on b.id_udidoc = srvdrug.id_dosage"
      +"  left join bd_measdoc m"
      +"    on m.id_measdoc = srv.id_unit_med"
      +"  left join bd_mmca mmca"
      +"    on mm.id_mmca = mmca.id_mmca"
      +"  left join bd_measdoc m1"
      +"    on mm.id_unit_ddd = m1.id_measdoc"
      +" where mm.ds = 0 and mm.sd_mmtp in('101','102','103')";
	
	/**
	 * 药品字典信息(new)
	 */
	public String DICTDRUG_NEW = "select '0' as hiscode,mm.code as drugcode,mm.code as drug_unique_code, srv.name as drugname,\n"
			+ "       mm.name as tradename,b.name as drugform,mm.spec as drugspec,mm.apprno as approvalcode,mm.sup_name as comp_name,\n"
			+ "       m.name as doseunit,(select max(m1.name) from bd_mm_pkgu pkgu left join bd_measdoc m1 on pkgu.id_unit_pkg=m1.id_measdoc where mm.id_mm=pkgu.id_mm and pkgu.en_oppkgtp is not null and pkgu.en_oppkgtp=1) as costunit,\n"
			+ "       '' as adddate,decode(mm.fg_active,'Y','1','0') as is_use,decode(srvdrug.fg_anti,'Y','1','0') as is_anti,\n"
			+ "       case substr(mmca.code,0,2) when '12' then decode(substr(mmca.code,0,4),'1201','1','1207','2','1204','3','4') else '-1' end as antitype,\n"
			+ "         decode(srvdrug.sd_anti,'1','1','2','2','3','3','-1') as antilevel,mm.ddd as ddd,m1.name as dddunit,\n"
			+ "       '-1' as is_basedrug,mm.price as unitprice,o.code as orgcode,o.name as orgname\n"
			+ "       from bd_mm mm\n" + "       left join bd_srv srv on mm.id_srv=srv.id_srv\n"
			+ "       left join bd_org  o on o.id_org = mm.id_org\n"
			+ "       left join bd_srv_drug srvdrug on srv.id_srv=srvdrug.id_srv and srvdrug.ds=0\n"
			+ "       left join bd_udidoc b on b.id_udidoc = srvdrug.id_dosage\n"
			+ "       left join bd_measdoc m on m.id_measdoc = srv.id_unit_med\n"
			+ "       left join bd_mmca mmca on mm.id_mmca = mmca.id_mmca\n"
			+ "       left join bd_measdoc m1 on mm.id_unit_ddd = m1.id_measdoc\n" + "        where  mm.ds=0 and o.code=? and mm.sd_mmtp in('101','102','103')";
	/**
	 * 疾病定义表
	 */
	public String DICTDISEASE = "select '0' as hiscode,b.code as discode,b.name as disname,org.code as orgcode,org.name as orgname  from bd_di_def b left join bd_org org on org.id_org = b.id_org ";
	/**
	 * 疾病定义表(new)
	 */
	public String DICTDISEASE_NEW = "select '0' as hiscode,b.code as discode,b.name as disname,org.code as orgcode,org.name as orgname  from bd_di_def b left join bd_org org on org.id_org = b.id_org where org.code=?";
	/**
	 * 疾病定义表(总数量)
	 */
	public String DICTDISEASE_COUNT = "select count(*)  from bd_di_def b left join bd_org org on org.id_org = b.id_org where org.code=?";
	/**
	 * 疾病定义表(分页)
	 */
	public String DICTDISEASE_PAGE = "SELECT * FROM (SELECT tt.*, ROWNUM AS rowno"
               +"         FROM (select '0' as hiscode,"
               +"                       b.code as discode,"
               +"                       b.name as disname,"
               +"                       org.code as orgcode,"
               +"                       org.name as orgname"
               +"                  from bd_di_def b"
               +"                  left join bd_org org on org.id_org = b.id_org "
               +"                 where org.code = ?) tt"
               +"         WHERE ROWNUM <= ?) table_alias"
               +" WHERE table_alias.rowno > ?";                                 
	/**
	 * 给药途径字典
	 */
	public String DICTROUTE = "select '0' as hiscode,route.name  as routecode,route.name as routename,org.code as orgcode,org.name as orgname from bd_route route left join bd_org org on org.id_org = route.id_org";
	/**
	 * 给药途径字典(new)
	 */
	public String DICTROUTE_NEW = "select '0' as hiscode,route.name  as routecode,route.name as routename,org.code as orgcode,org.name as orgname from bd_route route left join bd_org org on org.id_org = route.id_org where org.code=?";
	/**
	 * 给药频次字典信息
	 */
	public String DICTFREQUENCY = "select '0' as hiscode,b.name as frequency ,org.code as orgcode,org.name as orgname  from bd_freq b left join bd_org org on org.id_org = b.id_org where  b.ds=0";
	/**
	 * 给药频次字典信息(new)
	 */
	public String DICTFREQUENCY_NEW = "select '0' as hiscode,b.name as frequency ,org.code as orgcode,org.name as orgname  from bd_freq b left join bd_org org on org.id_org = b.id_org where  b.ds=0 and org.code=?";
	/**
	 * 过敏字典信息
	 */
	public String DICTALLERGEN = "select '0' as hiscode,b.name as allercode,b.name as allername,org.code as orgcode,org.name as orgname  from bd_udidoc b left join bd_org org on org.id_org = b.id_org where b.id_udidoclist=(select id_udidoclist from bd_udidoclist where code='PI.PI.1540')";
	/**
	 * 过敏字典信息(new)
	 */
	public String DICTALLERGEN_NEW = "select '0' as hiscode,b.name as allercode,b.name as allername,org.code as orgcode,org.name as orgname  from bd_udidoc b left join bd_org org on org.id_org = b.id_org where b.id_udidoclist=(select id_udidoclist from bd_udidoclist where code='PI.PI.1540') and org.code=?";
	/**
	 * 收费项目字典信息
	 */
	public String DICTCOSTITEM = "select '0' as hiscode,b.code as itemcode,b.name as itemname,\n"
			+ " decode(substr(b.sd_srvtp,0,2),'01','1','04','2','03','3','02','4','06','5','6') as itemtype,org.code as orgcode,org.name as orgname\n"
			+ " from bd_srv b left join bd_org org on org.id_org = b.id_org where b.ds=0";
	/**
	 * 收费项目字典信息(new)
	 */
	public String DICTCOSTITEM_NEW = "select '0' as hiscode,b.code as itemcode,b.name as itemname,\n"
			+ " decode(substr(b.sd_srvtp,0,2),'01','1','04','2','03','3','02','4','06','5','6') as itemtype,org.code as orgcode,org.name as orgname\n"
			+ " from bd_srv b left join bd_org org on org.id_org = b.id_org where b.ds=0 and org.code=?";
	/**
	 * 疾病定义表(分页)
	 */
	public String DICTCOSTITEM_Page = "SELECT * FROM (SELECT tt.*, ROWNUM AS rowno"
               +"         FROM (select '0' as hiscode,b.code as itemcode,b.name as itemname,"
               + " decode(substr(b.sd_srvtp,0,2),'01','1','04','2','03','3','02','4','06','5','6') as itemtype,org.code as orgcode,org.name as orgname\n"
   				+ " from bd_srv b left join bd_org org on org.id_org = b.id_org where b.ds=0 and org.code=?"
               + ") tt"
               +"         WHERE ROWNUM <= ?) table_alias"
               +" WHERE table_alias.rowno > ?";   
	/**
	 * 手术字典信息
	 */
	public String DICTOPERATION = "select '0' as hiscode,srv.name as operationcode,srv.name as operationname,org.code as orgcode,org.name as orgname from bd_srv srv\n"
			+ " left join bd_srv_sug sug on srv.id_srv = sug.id_srv \n"
			+ " left join bd_org org on org.id_org = srv.id_org \n" + " where srv.sd_srvtp like '04%'";
	/**
	 * 手术字典信息(new)
	 */
	public String DICTOPERATION_NEW = "select '0' as hiscode,srv.name as operationcode,srv.name as operationname,org.code as orgcode,org.name as orgname from bd_srv srv\n"
			+ " left join bd_srv_sug sug on srv.id_srv = sug.id_srv \n"
			+ " left join bd_org org on org.id_org = srv.id_org \n" + " where srv.sd_srvtp like '04%' and org.code=?";
	/**
	 * 药品入库信息
	 */
	public String DRUGSTORAGE = "select '0' as hiscode,mi.code as storageid,mi.dt_st as storagetime,mm.code as drugcode,srv.name asdrugname,\n"
			+ "       mm.name as tradename,mm.spec as drugspec,itm.quan_actual as packagenum,m.name as packageunits,\n"
			+ "       b.name as drugform,r.name as routename,'0' as storagenum,itm.pri_act as unitprice,'0' as storagecost,\n"
			+ "       '' as comp_name,'' as wholesaler,'' as inventory\n" + "      from mm_in mi\n"
			+ "      left join mm_in_itm itm on mi.id_in=itm.id_in\n"
			+ "      left join bd_mm mm on itm.id_mm = mm.id_mm\n"
			+ "      left join bd_srv srv on mm.id_srv = srv.id_srv\n"
			+ "      left join bd_srv_drug srvdrug on srv.id_srv=srvdrug.id_srv\n"
			+ "      left join bd_udidoc b on b.id_udidoc = srvdrug.id_dosage\n"
			+ "      left join bd_measdoc m on m.id_measdoc = itm.id_mmpkgu_actual\n"
			+ "      left join bd_route r on r.id_route = srv.id_route" + "      where mi.dt_st>=? and mi.dt_st<=?";

	/**
	 * 药品入库信息
	 */
	public String DRUGSTORAGE_NEW = "select '0' as hiscode,mi.code as storageid,mi.dt_st as storagetime,mm.code as drugcode,srv.name asdrugname,\n"
			+ "       mm.name as tradename,mm.spec as drugspec,itm.quan_actual as packagenum,m.name as packageunits,\n"
			+ "       b.name as drugform,r.name as routename,'0' as storagenum,itm.pri_act as unitprice,'0' as storagecost,\n"
			+ "       '' as comp_name,'' as wholesaler,'' as inventory,org.code as orgcode,org.name as orgname\n"
			+ "      from mm_in mi\n" + "      left join mm_in_itm itm on mi.id_in=itm.id_in\n"
			+ "      left join bd_mm mm on itm.id_mm = mm.id_mm\n"
			+ "      left join bd_srv srv on mm.id_srv = srv.id_srv\n"
			+ "      left join bd_srv_drug srvdrug on srv.id_srv=srvdrug.id_srv\n"
			+ "      left join bd_udidoc b on b.id_udidoc = srvdrug.id_dosage\n"
			+ "      left join bd_measdoc m on m.id_measdoc = itm.id_mmpkgu_actual\n"
			+ "      left join bd_route r on r.id_route = srv.id_route\n"
			+ "      left join bd_org org on org.id_org = mi.id_org\n"
			+ "      where mi.dt_st>=? and mi.dt_st<=? and org.code= ?";
	/**
	 * 检验申请项目字典信息
	 */
	public String DICTLAB = "select '0'as hiscode ,bdsrv.code  as labcode ,bdsrv.name  as labname,org.code as orgcode,org.name as orgname \n"
			+ " from bd_srv  bdsrv \n" + " left join  bd_org org on org.id_org=bdsrv.id_org \n"
			+ " where bdsrv.sd_srvtp like'03%'";
	/**
	 * 检验申请项目字典信息
	 */
	public String DICTLAB_NEW = "select '0'as hiscode ,bdsrv.code  as labcode ,bdsrv.name  as labname,org.code as orgcode,org.name as orgname \n"
			+ " from bd_srv  bdsrv \n" + "  left join  bd_org org on org.id_org=bdsrv.id_org \n"
			+ " where bdsrv.sd_srvtp like'03%' and org.code=?";
	/**
	 * 检验结果项目字典信息
	 */
	public String DICTLABITEM = "select distinct '0' as hiscode,itm.lis_code_srv as itemcode ,itm.name_srv  as itemname,org.code as orgcode,org.name as orgname \n"
			+ " from ci_rpt_lab_itm itm \n" + " left join ci_rpt_lab lab on lab.id_rptlab = itm.id_rptlab \n"
			+ " left join bd_dep d on d.id_dep = lab.id_dep \n" + " left join bd_org org on org.id_org = d.id_org";
	
	/**
	 * 检验结果项目字典信息(NEW)
	 */
	public String DICTLABITEM_NEW = "select distinct '0' as hiscode,itm.lis_code_srv as itemcode ,itm.name_srv  as itemname,org.code as orgcode,org.name as orgname \n"
			+ " from ci_rpt_lab_itm itm \n" + " left join ci_rpt_lab lab on lab.id_rptlab = itm.id_rptlab \n"
			+ " left join bd_dep d on d.id_dep = lab.id_dep \n" + " left join bd_org org on org.id_org = d.id_org and org.code=?";
	/**
	 * 检查申请项目字典信息
	 */
	public String DICTEXAM = "select '0' as hiscode,srv.code examcode,srv.name examname ,org.code as orgcode,org.name as orgname\n"
			+ " from bd_srv srv \n" + " left join bd_org org on org.id_org = srv.id_org\n"
			+ " where srv.sd_srvtp like '02%'";
	/**
	 * 检查申请项目字典信息(new)
	 */
	public String DICTEXAM_NEW = "select '0' as hiscode,srv.code examcode,srv.name examname ,org.code as orgcode,org.name as orgname\n"
			+ " from bd_srv srv \n" + " left join bd_org org on org.id_org = srv.id_org\n"
			+ " where srv.sd_srvtp like '02%' and org.code=?";
	/****************************** 字典部分结束 ******************************/
}
