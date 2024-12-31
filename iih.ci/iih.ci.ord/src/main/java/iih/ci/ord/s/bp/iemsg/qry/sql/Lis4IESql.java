package iih.ci.ord.s.bp.iemsg.qry.sql;

import org.nutz.mvc.adaptor.convertor.StringParamConvertor;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import xap.sys.jdbc.kernel.SqlParam;

//集成平台  新  检验类SQL  （含检验类综合都在这里）

public class Lis4IESql {
	/**
	 * 医嘱确认数据信息SQL串                      
	 * 药品、检查、检验、。。。。。等均用此   -------------------------------------------------------------------
	 */
	public  static String getCiIeOrConfirmSql(){
		
		StringBuilder strSB= new StringBuilder();
        strSB.append(" select A.id_en as id_iepharmoren,B.code as patientid,B.BARCODE_CHIS as patientseqnum,F.Times_Ip as admiss_times,");
        strSB.append(" D.CODE as deptcode,D.Name as deptname,E.code as wardcode,E.name as wardname,F.NAME_BED as bedcode,");
        strSB.append(" C.Name_Pat as name,C.Sd_Sex_Pat as sexid,C.Dt_Birth_Pat as birthdaydate,null as age, ? as confirm_date,");
        strSB.append(" G.Code as confirm_nurse_code,G.name as confirm_nurse_name,H.orgcode as orgcode,H.name as orgname ");
        strSB.append(" from ci_order A");
        strSB.append("      left outer join pi_pat B ON A.Id_Pat=B.Id_Pat");
        strSB.append("      left outer join en_ent C ON A.Id_En=C.Id_Ent");
        strSB.append("      left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP");
        strSB.append("      left outer join bd_dep E ON C.Id_Dep_Nur=E.Id_Dep");
        strSB.append("      left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent ");
        strSB.append("      left outer join bd_psndoc G ON %2$s=G.Id_Psndoc");
        strSB.append("      left outer join bd_org H ON H.Id_ORG=A.Id_ORG ");
        strSB.append(" where A.id_or= ? ");
       
        SqlParam param =new SqlParam();

        //param.addParam( %1$s );
		//param.addParam( %3$s );
        return strSB.toString();
	}
	
	
	/**
	 * 门急诊检查检验IE集成平台查询SQL    -------------------------------------------------------------------
	 */
	public static String getCiOpLisrisIeSql(){
		StringBuilder strSB= new StringBuilder();
		strSB.append("select cior.id_or as id_or,srv.SD_IEMSGCA as iemsgca_code,pat.code as patient_id,entop.times_op as times,execdep.code as exec_unit,");
		strSB.append(" execdep.name as exec_unit_name,dep1.code as dept_code,dep1.name as dept_name,");
		strSB.append(" org.orgcode as org_code,org.name as org_name,cior.applyno as order_id,");
		strSB.append(" (case when substr(cior.sd_srvtp,0,2)='02' then ? when substr(cior.sd_srvtp,0,2) ='03' then ?  else '' end) as order_type");
		strSB.append(" from ci_order cior" );
		strSB.append(" left join pi_pat pat on cior.id_pat = pat.id_pat");
		strSB.append(" left join en_ent_op entop on cior.id_en = entop.id_ent" );
		strSB.append(" left join bd_dep execdep on cior.id_dep_mp = execdep.id_dep");
		strSB.append(" left join bd_dep dep1 on cior.id_dep_or = dep1.id_dep");
		strSB.append(" left join bd_org org on cior.id_org = org.id_org");
		strSB.append(" left join bd_srvca srvca on cior.id_srvca=srvca.id_srvca");
		strSB.append(" left join bd_srv srv on cior.id_srv = srv.id_srv");
		strSB.append(" where cior.id_or ? ");
		
		SqlParam param =new SqlParam();
		param.addParam( IBdSrvIEEventConst.SD_SRVTP_JCL );
		param.addParam( IBdSrvIEEventConst.SD_SRVTP_HYL );
		//param.addParam( %s );
		
		
		return null;
	}
	
	/**
	 * 检验申请单数据信息SQL串     -------------------------------------------------------------------
	 * 住院
	 */
	public String getCiIeAppLisAllSql(String ids){
		StringBuilder strSB= new StringBuilder();
		strSB.append(		" select addr.zip as add_post_code,al.name_alcla as allergy,card.code as health_card_no,(case when phy2.code='04' then '是' else '否' end) as is_breastfeeding,(case when phy.code='02' then '是' else '否' end) as is_pregnancy,(case when phy.code='02' then phy.sv else '' end) as pregnancy_date"
				+ ",C.Id_Ent as id_ent,A.id_en as id_ielisoren,B.code as patient_id,B.CODE_AMR_IP as p_bar_code,E.code as ward_code,E.name as ward_code_name,F.NAME_BED as bed_no, ");
		strSB.append(" B.Id_Code as social_no,C.Name_Pat as name,B.Tel as home_tel,B.Mob as cellphone,C.Sd_Sex_Pat as sex,B.DT_BIRTH_HMS as birthday,'' as age, ");
		strSB.append(" C.Addr_Pat as home_street,'' as post_code,'' as work_place_code, D.Code as patient_deptcode,D.NAME as patient_deptname, ");
		strSB.append(" B.Workunit as work_place,G.ORGCODE as hospital_code,G.Name as hospital_name,A.Dt_Entry as enter_date,K.Code as apply_doctor,K.Name as apply_doctor_name, ");
		strSB.append(" L.Code as apply_unit,L.Name as apply_unit_name,A.Dt_Sign as confirm_date,H.Code as confirm_opera,H.Name as confirm_opera_name, ");
		strSB.append(" A.Dt_Effe as input_begindate,A.Dt_End as input_enddate,H.Code as input_opera,H.Name as input_opera_name, ");
		strSB.append(" (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times, ");
		strSB.append(" W.code as visit_type,W.Name as visit_type_name,G.CODE as yq_code,G.Name as yz_code_name, ");
		strSB.append(" (case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type,M.ID_DIDEF_CODE as diag_code,M.ID_DIDEF_NAME as diag_str, ");
		strSB.append(" A.Id_Or as id_ielisor,A.id_en as id_ielisoren,'' as id_ielisoritms,Q.NO_APPLYFORM as jy_applyserial1,N.Code as order_type, ");//检验申请单号jy_applyserial1
		strSB.append(" N.Name as order_type_name,A.Dt_Effe as apply_date,'' as is_private,(case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type,(case when M.FG_MAJDI='Y' then '主要诊断' when M.FG_MAJDI='N' then '次要诊断' else '' end) as diag_type_name,M.ID_DIDEF_CODE as diag_name,M.ID_DIDEF_NAME as diag_str, ");
		//医嘱号yz_no 检验项目编码jy_applyserial
		strSB.append(" Q.ID_ORLAB as id_ielisoritm,A.Id_Or as id_ielisor,A.Code_Or as yz_no,P.code as jy_applyserial,P.name as jyname,'' as priority,A.Dt_Effe as yz_start_date,A.Dt_End as yz_stop_date, ");
		strSB.append(" X.Code as yz_frequency,X.Name as yz_frequency_name,Q.Sd_Pps as descp_code,R.Name as description,'' as collect_ragion, ");
		strSB.append(" lis.code_app as sample_id,Q.Sd_Samptp as sample_class,S.Name as sample_code_name,'' as collect_time,Q.SD_CONTP as container_code, ");
		strSB.append(" T.Name as container_code_name,'' as collecter_code,'' as collecter_code_name,'' as collecter_place,V.Code as exec_code, ");
		strSB.append(" V.Name as exec_code_name,Z4.price_ratio as test_price,'' as supply_price,'' as commenttp,Q.ANNOUNCEMENTS as sample_request,'' as isstest,'' as stest,(case when A.Fg_Urgent='Y' then '1' else '0' end) as is_em,(case when A.Fg_Urgent='Y' then 'true' else 'false' end) as is_em_r,'' as isyg,'' as yg, ");
		strSB.append(" P.sd_iemsgca as iemsgca_code,(case when Z3.name='未记账' then '099' when Z3.name='已记账' then  P1.name end) as iemsgca_name , P1.ctrl1 as iemsgca_typename ,");
		strSB.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as Ordertimetypename,(case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as Ordertimetypecode, ");
		strSB.append(" C.code as Visitordno,(case when C.code_entp='00'then '01'when C.code_entp='10'then '03' end) as Visittype,BD.name as Visittypename");
		strSB.append(" from ci_ap_lab Q left outer join ci_order A on Q.Id_Or=A.Id_Or ");
		strSB.append("       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
		strSB.append("       left outer join pi_pat_card card ON A.Id_Pat=card.Id_Pat and card.fg_act='Y' and card.sd_patcardtp='05' ");//健康卡
		strSB.append("       left outer join pi_pat_cardtp cardtp ON cardtp.id_cardtp=card.id_patcardtp and cardtp.sd_patcardtp='05' ");
		strSB.append("       left join (select z0.id_pat,d0.code,z0.sv from pi_pat_phy z0 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind where d0.code='02') phy ON phy.Id_Pat = B.Id_Pat ");//--怀孕
		strSB.append("       left join (select z0.id_pat,d0.code from pi_pat_phy z0 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind where d0.code='04') phy2 on phy2.Id_Pat = B.Id_Pat  ");//--哺乳;
		strSB.append("       left outer join en_ent C ON A.Id_En=C.Id_Ent ");
		strSB.append("       left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP ");
		strSB.append("       left outer join bd_dep E ON C.Id_Dep_Nur=E.Id_Dep ");  // 病区
		strSB.append("       left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent  ");
		strSB.append("       left outer join bd_org G ON A.Id_Org=G.Id_Org ");
		strSB.append("       left outer join bd_psndoc H ON H.Id_Psndoc=A.Id_Emp_Sign ");
		strSB.append("       left outer join bd_entp I ON I.Id_Entp=A.Id_Entp ");
		strSB.append("       left outer join en_ent_op J ON A.Id_En=J.Id_Ent ");
		strSB.append("       left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Or ");
		strSB.append("       left outer join bd_dep L ON A.Id_Dep_Or=L.ID_DEP ");
		strSB.append("       left outer join en_ent_di M1 ON A.Id_En = M1.Id_Ent and M1.Fg_Maj='Y' ");//主要诊断
		strSB.append("       left outer join ci_di_itm M ON M1.ID_DIITM=M.ID_DIITM ");
		strSB.append("       left outer join bd_srvca N ON N.Id_Srvca=A.Id_Srvca ");
		strSB.append("       left outer join ci_rpt_lab O ON Q.Id_Orlab=O.Id_Orlab ");
		strSB.append("       left outer join bd_srv P ON P.id_srv=A.Id_Srv ");
		strSB.append("       left outer join bd_udidoc R ON R.Id_Udidoc=Q.Id_Pps ");
		strSB.append("       left outer join bd_udidoc S ON S.Id_Udidoc=Q.Id_Samptp ");
		strSB.append("       left outer join bd_udidoc T ON T.Id_Udidoc=Q.Id_Contp ");
		strSB.append("       left outer join bd_udidoc U ON U.Id_Udidoc=Q.Id_Colltp ");
		strSB.append("       left outer join bd_dep V ON V.Id_Dep=A.Id_Dep_Mp ");
		strSB.append("       left outer join pi_pat_ca W ON W.Id_Patca=B.Id_Paticate ");
		strSB.append("       left outer join bd_freq X ON X.Id_Freq=A.Id_Freq	 ");
		strSB.append("		 left outer join bd_udidoc P1 ON P.Code_rel7 = P1.Id_Udidoc	 ");
		strSB.append("		 left outer join bd_udidoc Z3 ON (Z3.id_udidoc = ? and Z3.id_udidoclist = ?) ");
		strSB.append("		 left outer join view_price_rp Z4 ON Z4.Id_Srv=A.Id_Srv and Z4.id_pripat = C.Id_Pripat ");
		strSB.append("       left outer join BD_ENTP BD ON C.CODE_ENTP = BD.CODE ");
		strSB.append("       left outer join (select  bb.id_pat,wmsys.wm_concat(distinct TO_CHAR(TO_DATE( substr(aa.dt_act, 1, 10),'yyyy-MM-dd'),'yyyy-MM-dd') ||':'||  aa.name_alcla)as name_alcla from pi_pat_al aa inner join pi_pat bb on bb.id_pat=aa.id_pat group by  bb.id_pat) al ON al.id_pat = B.Id_Pat ");//过敏史
		//邮编 现住址 9
		strSB.append("       left join pi_pat_addr addr on addr.id_admdiv=c.id_admdiv_addr and addr.id_pat=c.id_pat and addr.sd_addrtp='9'  ");
		//标本
		strSB.append("       left join ci_app_lis_or lisor on lisor.id_orlab=q.id_orlab ");
		strSB.append("       left join ci_app_lis lis on lisor.id_ciapplissheet=lis.id_ciapplissheet ");
		strSB.append(" where A.id_or " );
		strSB.append(ids);
    
    
       
		return strSB.toString();


		
	}
	
	
	
	/**
	 * 检验申请单数据信息SQL串 未记账   -------------------------------------------------------------------
	 * （门诊） G.CODE
	 */
	public String getCiIeAppLisOpAllSql(String id_or4sql){
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(		" select addr.zip as add_post_code,al.name_alcla as allergy,card.code as health_card_no,(case when phy2.code='04' then '是' else '否' end) as is_breastfeeding,(case when phy.code='02' then '是' else '否' end) as is_pregnancy,(case when phy.code='02' then phy.sv else '' end) as pregnancy_date"
				+ ",C.Id_Ent as id_ent, A.id_en as id_ielisoren,B.code as patient_id,c.code as p_bar_code,E.code as ward_code,E.name as ward_code_name,F.NAME_BED as bed_no, ");
	    sqlSB.append(" B.Id_Code as social_no,C.Name_Pat as name,B.Tel as home_tel,B.Mob as cellphone,C.Sd_Sex_Pat as sex,B.DT_BIRTH_HMS as birthday,'' as age, ");
	    sqlSB.append(" C.Addr_Pat as home_street,'' as post_code,'' as work_place_code, D.Code as patient_deptcode,D.NAME as patient_deptname, ");
		sqlSB.append(" B.Workunit as work_place,G.ORGCODE as hospital_code,G.Name as hospital_name,A.Dt_Entry as enter_date,K.Code as apply_doctor,K.Name as apply_doctor_name, ");
		sqlSB.append(" L.Code as apply_unit,L.Name as apply_unit_name,A.Dt_Sign as confirm_date,H.Code as confirm_opera,H.Name as confirm_opera_name, ");
		sqlSB.append(" A.Dt_Effe as input_begindate,A.Dt_End as input_enddate,H.Code as input_opera,H.Name as input_opera_name, ");
		sqlSB.append(" (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times, ");
		sqlSB.append(" W.code as visit_type,W.Name as visit_type_name,G.CODE as yq_code,G.Name as yz_code_name, ");
		sqlSB.append(" (case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type,M.ID_DIDEF_CODE as diag_code,M.ID_DIDEF_NAME as diag_str, ");
		sqlSB.append(" A.Id_Or as id_ielisor,A.id_en as id_ielisoren,'' as id_ielisoritms,Q.NO_APPLYFORM as jy_applyserial1,N.Code as order_type, ");//Q.NO_APPLYFORM as jy_applyserial1 检验申请单编号
		sqlSB.append(" N.Name as order_type_name,A.Dt_Effe as apply_date,'' as is_private,(case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type,(case when M.FG_MAJDI='Y' then '主要诊断' when M.FG_MAJDI='N' then '次要诊断' else '' end) as diag_type_name,M.ID_DIDEF_CODE as diag_name,M.ID_DIDEF_NAME as diag_str, ");
		//A.Code_Or as yz_no医嘱号P.code as jy_applyserial检验项目编码
		sqlSB.append(" Q.ID_ORLAB as id_ielisoritm,A.Id_Or as id_ielisor,A.Code_Or as yz_no,P.code as jy_applyserial,P.name as jyname,'' as priority,A.Dt_Effe as yz_start_date,A.Dt_End as yz_stop_date, ");
		sqlSB.append(" X.Code as yz_frequency,X.Name as yz_frequency_name,Q.Sd_Pps as descp_code,R.Name as description,'' as collect_ragion, ");
		sqlSB.append(" lis.code_app as sample_id,Q.Sd_Samptp as sample_class,S.Name as sample_code_name,'' as collect_time,Q.SD_CONTP as container_code, ");
		sqlSB.append(" T.Name as container_code_name,'' as collecter_code,'' as collecter_code_name,'' as collecter_place,V.Code as exec_code, ");
		sqlSB.append(" V.Name as exec_code_name,Z4.price_ratio as test_price,'' as supply_price,'' as commenttp,Q.ANNOUNCEMENTS as sample_request,'' as isstest,'' as stest,(case when A.Fg_Urgent='Y' then '1' else '0' end) as is_em,(case when A.Fg_Urgent='Y' then 'true' else 'false' end) as is_em_r,'' as isyg,'' as yg, ");
		sqlSB.append(" P.sd_iemsgca as iemsgca_code,(case when Z3.name='未记账' then '099' when Z3.name='已记账' then  P1.name end) as iemsgca_name , P1.ctrl1 as iemsgca_typename, ");
		sqlSB.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as Ordertimetypename,(case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as Ordertimetypecode, ");
		sqlSB.append(" C.code as Visitordno,(case when C.code_entp='00'then '01'when C.code_entp='10'then '03' end) as Visittype,BD.name as Visittypename");
		sqlSB.append(" from ci_ap_lab Q left outer join ci_order A on Q.Id_Or=A.Id_Or ");
		
		sqlSB.append("       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
		sqlSB.append("       left outer join pi_pat_card card ON A.Id_Pat=card.Id_Pat and card.fg_act='Y' and card.sd_patcardtp='05' ");//健康卡
		sqlSB.append("       left outer join pi_pat_cardtp cardtp ON cardtp.id_cardtp=card.id_patcardtp and cardtp.sd_patcardtp='05' ");
		sqlSB.append("       left join (select z0.id_pat,d0.code,z0.sv from pi_pat_phy z0 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind where d0.code='02') phy ON phy.Id_Pat = B.Id_Pat ");//--怀孕
		sqlSB.append("       left join (select z0.id_pat,d0.code from pi_pat_phy z0 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind where d0.code='04') phy2 on phy2.Id_Pat = B.Id_Pat  ");//--哺乳
		sqlSB.append("       left outer join en_ent C ON A.Id_En=C.Id_Ent ");
		sqlSB.append("       left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP ");
		sqlSB.append("       left outer join bd_dep E ON C.Id_Dep_Nur=E.Id_Dep " );
		sqlSB.append("       left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent  ");
		sqlSB.append("       left outer join bd_org G ON A.Id_Org=G.Id_Org ");
		sqlSB.append("       left outer join bd_psndoc H ON H.Id_Psndoc=A.Id_Emp_Sign ");
		sqlSB.append("       left outer join bd_entp I ON I.Id_Entp=A.Id_Entp ");
		sqlSB.append("       left outer join en_ent_op J ON A.Id_En=J.Id_Ent ");
		sqlSB.append("       left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Or ");
		sqlSB.append("       left outer join bd_dep L ON A.Id_Dep_Or=L.ID_DEP ");
		sqlSB.append("       left outer join en_ent_di M1 ON A.Id_En = M1.Id_Ent " );
		sqlSB.append("       left outer join ci_di_itm M ON M1.ID_DIITM=M.ID_DIITM ");
		sqlSB.append("       left outer join bd_srvca N ON N.Id_Srvca=A.Id_Srvca ");
		sqlSB.append("       left outer join ci_rpt_lab O ON Q.Id_Orlab=O.Id_Orlab ");
		sqlSB.append("       left outer join bd_srv P ON P.id_srv=A.Id_Srv ");
		sqlSB.append("       left outer join bd_udidoc R ON R.Id_Udidoc=Q.Id_Pps ");
		sqlSB.append("       left outer join bd_udidoc S ON S.Id_Udidoc=Q.Id_Samptp ");
		sqlSB.append("       left outer join bd_udidoc T ON T.Id_Udidoc=Q.Id_Contp ");
		sqlSB.append("       left outer join bd_udidoc U ON U.Id_Udidoc=Q.Id_Colltp ");
		sqlSB.append("       left outer join bd_dep V ON V.Id_Dep=A.Id_Dep_Mp ");
		sqlSB.append("       left outer join pi_pat_ca W ON W.Id_Patca=B.Id_Paticate ");
		sqlSB.append("       left outer join bd_freq X ON X.Id_Freq=A.Id_Freq	 ");
		sqlSB.append("		 left outer join bd_udidoc P1 ON P.Id_iemsgca = P1.Id_Udidoc	 ");
		sqlSB.append("		 left outer join bd_udidoc Z3 ON (Z3.id_udidoc = ? ");
		sqlSB.append(" and Z3.id_udidoclist = ? )");
		sqlSB.append("		left outer join view_price_rp Z4 ON Z4.Id_Srv=A.Id_Srv and Z4.id_pripat = C.Id_Pripat ");
		sqlSB.append("       left outer join BD_ENTP BD ON C.CODE_ENTP = BD.CODE ");
		sqlSB.append("       left outer join (select  bb.id_pat,wmsys.wm_concat(distinct TO_CHAR(TO_DATE( substr(aa.dt_act, 1, 10),'yyyy-MM-dd'),'yyyy-MM-dd') ||':'||  aa.name_alcla)as name_alcla from pi_pat_al aa inner join pi_pat bb on bb.id_pat=aa.id_pat group by  bb.id_pat) al ON al.id_pat = B.Id_Pat ");//过敏史
		//邮编 现住址 9
		sqlSB.append("  left join pi_pat_addr addr on addr.id_admdiv=c.id_admdiv_addr and addr.id_pat=c.id_pat and addr.sd_addrtp='9'  ");
		//标本
		sqlSB.append("  left join ci_app_lis_or lisor on lisor.id_orlab=q.id_orlab ");
		sqlSB.append("  left join ci_app_lis lis on lisor.id_ciapplissheet=lis.id_ciapplissheet ");
		sqlSB.append(" where M1.Fg_Maj='Y' and A.Id_Or ");
		sqlSB.append(  id_or4sql  );
		 
		return sqlSB.toString();
	}
	
	

}
