package iih.ci.ord.s.bp.iemsg.qry.sql;

import xap.sys.jdbc.kernel.SqlParam;

//集成平台  新  备血 用血SQL  

public class Blood4IESql {

//	where like
	
	/**
	 * 门诊用血申请数据信息SQL串
	 * 用血医嘱  
	 * ABO Rh血型得单独服务求取
	 */
	public String CiIeOrbuOpSql(String id_or4sql){
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" select a1.sd_su_bl as pay_flag,A1.id_or as id_iebtuseoren,B.code as patient_id,c.code as p_bar_code,C.Name_Pat as name,C.Sd_Sex_Pat as sex,C.Dt_Birth_Pat as brithday,'' as age,I.code as apply_unit,I.name as apply_unit_name,G.code as  ward_code,G.name as ward_code_name,H.NAME_BED as bed_no,S.OrgCode as hospital_code,S.Name as hospital_name ");
		sqlSB.append(" ,(case when H.Times_Ip is null then 0 else H.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times  ");
		sqlSB.append(" ,btor.applyno as bill_id,Q.no_applyform as use_sn,'1' as get_times,A.Code_Or as yz_no,substr(T.code,7) as blood_class,T.name as blood_class_name,A1.Quan_Medu as use_amount,U.code as use_amount_code  ");
		sqlSB.append(" ,Q.Dt_Bu_Plan as use_date,bt.sd_bloodtype_ap as abo_type,aboudi.name as abo_type_name,bt.sd_rhd_ap as rh_d,rhudi.name as rh_d_name,'' as is_lg,'' as is_lg_r,W.code as app_doctor,W.name as app_doctor_name,W.MOBILE as app_tel,'' as op_loc,'' as op_loc_name,'' as op_tel,'' as visit_type,'01' as domain_id");
		sqlSB.append(" ,t.SD_IEMSGCA as iemsgca_code,C.code as visit_ord_no,BD.name as visit_type_name,(case when A.Code_Entp='00'then '01' when A.Code_Entp ='10'then '03' end )as visit_type,v.code as exec_code, ");
		sqlSB.append(" x.code as apply_code ");
		sqlSB.append("  from ci_or_srv A1   ");
		sqlSB.append("       left outer join ci_order A ON A1.Id_Or=A.Id_Or  ");
		sqlSB.append("       left outer join ci_ap_bu Q ON Q.id_or=A.Id_Or  ");
		sqlSB.append("       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat  ");
		sqlSB.append("       left outer join en_ent C ON A.Id_En=C.Id_Ent  ");
		sqlSB.append("       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  " );
		sqlSB.append("       left outer join en_ent_op J ON A.Id_En=J.Id_Ent  ");
		sqlSB.append("       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur  ");
		sqlSB.append("       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy  ");
		sqlSB.append("       left outer join bd_psndoc R ON R.Id_Psndoc=A.Id_Emp_Chk   ");
		sqlSB.append("       left outer join bd_psndoc W ON W.Id_Psndoc=A.Id_Emp_Or  ");
		sqlSB.append("       left outer join bd_org S ON S.Id_Org=A.Id_Org  ");
		sqlSB.append("       left outer join bd_measdoc U ON U.Id_Measdoc=A1.Id_Medu  ");
		sqlSB.append("       left outer join ci_order btor on A.id_or_rel=btor.id_or");
		sqlSB.append("       left outer join ci_ap_bt bt on btor.id_or=bt.id_or");
		sqlSB.append("       left outer join bd_udidoc aboudi on aboudi.id_udidoc=bt.id_bloodtype_ap");
		sqlSB.append("       left outer join bd_udidoc rhudi on rhudi.id_udidoc=bt.id_rhd_ap");
		sqlSB.append("       left outer join bd_srv T ON T.Id_Srv=btor.Id_Srv  ");
		sqlSB.append("		 left outer join BD_ENTP BD ON C.CODE_ENTP = BD.CODE  ");	
		//执行科室
		sqlSB.append("       left outer join bd_dep V ON V.Id_Dep=A.Id_Dep_Mp ");
		//申请科室
		sqlSB.append("       left outer join bd_dep X ON X.Id_Dep=A.Id_Dep_Or ");
		sqlSB.append("		 where A1.Sd_Srvtp like '14%' and A1.id_or ");	 //A1.id_or id_or4sql
		sqlSB.append(id_or4sql);
//		SqlParam param =new SqlParam();
//		param.addParam(param);
		
		
		return sqlSB.toString();
		
		
		
	}
	
	
	/**
	 * 住院用血申请数据信息SQL串
	 * 用血医嘱  
	 * ABO Rh血型得单独服务求取
	 */
	public static String CiIeOrbuSql(){
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" select Q.id_or as id_iebtuseoren,B.code as patientid,C.Name_Pat as name,C.Sd_Sex_Pat as sexid,'' as age,C.Dt_Birth_Pat as birthdaydate,B.BARCODE_CHIS as patientseqnum,I.code as deptcode,I.name as deptname,G.code as wardcode,G.name as wardname,H.NAME_BED as bedcode "
);
		sqlSB.append(" ,(case when H.Times_Ip is null then 0 else H.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as admiss_times,A.Dt_Chk as confirm_date,R.Code as confirm_nurse_code,R.Name as confirm_nurse_name "
);
		sqlSB.append(" ,Q.NO_APPLYFORM as sx_code,'' as qx_code,'' as qx_times,A.Code_Or as order_no,T.code as xy_code,T.name as xy_name,A1.Quan_Medu as qx_count,A1.name as qx_unit "
);
		sqlSB.append(" ,Q.Dt_Bu_Plan as qx_date,'' as abo_code,'' as abo_name,'' as rh_code,'' as rh_name,W.code as doctor_code,W.name as doctor_name,W.MOBILE as doctor_tel,'' as ssj_code,'' ssj_name,'' as ssj_tel,'02' as domain_id,"
);
		sqlSB.append(" S.Orgcode as orgcode,S.NAME as orgname"//lxy20170518
);
		sqlSB.append("  from ci_or_srv A1   "
);
		sqlSB.append("       left outer join ci_order A ON A1.Id_Or=A.Id_Or  "
);
		sqlSB.append("       left outer join ci_ap_bu Q ON Q.id_or=A.Id_Or  "
);
		sqlSB.append("       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat  "
);
		sqlSB.append("       left outer join en_ent C ON A.Id_En=C.Id_Ent  "
);
		sqlSB.append("       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  " 
);
		sqlSB.append("       left outer join en_ent_op J ON A.Id_En=J.Id_Ent  "
);
		sqlSB.append("       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur  "
);
		sqlSB.append("       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy  "
);
		sqlSB.append("       left outer join bd_psndoc R ON R.Id_Psndoc=A.Id_Emp_Chk   "
);
		sqlSB.append("       left outer join bd_psndoc W ON W.Id_Psndoc=A.Id_Emp_Or  "
);
		sqlSB.append("       left outer join bd_org S ON S.Id_Org=A.Id_Org  "
);
		sqlSB.append("       left outer join bd_srv T ON T.Id_Srv=A1.Id_Srv  "
);
		sqlSB.append("       left outer join bd_measdoc U ON U.Id_Measdoc=A1.Id_Medu  "
);
		sqlSB.append("		 where  ? ");	 //A1.id_or	 	  

	
         
		
//		SqlParam param =new SqlParam();
//		param.addParam( %1$s );
		
		
		return sqlSB.toString();
		
	}
	
	/**
	 * 住院备血申请数据信息SQL串
	 * 备血医嘱  rownum要替换为top
	 * ABO Rh血型得单独服务求取
	 */
	
    public String CiIeOrbtMainSql(String id_or4sql){
     StringBuilder sqlSB = new StringBuilder();
     sqlSB.append(     " select c.id_ent as id_ent, "
	    		+ " (case when ITM.FG_MAJDI='Y' then '12' when ITM.FG_MAJDI='N' then '13' else '' end) as diagnosistype,"
	    		+ " (case when ITM.FG_MAJDI='Y' then '主要诊断' when ITM.FG_MAJDI='N' then '次要诊断' else '' end) as diagnosistypename, "
    		    + " A.Dt_Chk as confirm_date, "
	    		+ " (case when phy.code='02' then '是' else '否' end) as is_pregnancy,(case when phy.code='02' then phy.sv else '' end) as pregnancy_date,"
	    		+ " (case when phy2.code='04' then '是' else '否' end) as is_breastfeeding,"
	    		+ " al.name_alcla as allergy,card.code as healthcard_no,"
     		    + "Q.id_apbt,Q.id_or as id_iebtoren,null as iebtdiags,null as iebtillhiss,null as iebtnumlisitms,null as iebtcdlisitms,null as iebtstrlisitms, ");
     sqlSB.append(     " B.code as patientid,C.Name_Pat as name,C.Sd_Sex_Pat as sex,B.DT_BIRTH_HMS as birthday,'' as age,C.Addr_Pat as address,C.Sd_Mari_Pat as marriagecode, ");
     sqlSB.append(     " K.STREET as birthplace,B.Id_Code as socialno,Q.no_db as bloodno,C.code as pbarcode,G.code as wardno,G.name as wardname,H.Name_Bed as bedno,c.telno_pat as tel ,");
     sqlSB.append(     " '' as privatecode,I.Code as deptcode,I.Name as deptname,L.Name as feeclass,(case when H.Times_Ip is null then 0 else H.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times, ");
     //申请单号applyno
     sqlSB.append(     " c.dt_acpt as visit_date,Q.NO_APPLYFORM as applyno,A.Des_Or as comment1,A.Dt_Entry as applytime,A1.Quan_Medu as bloodamount,U.Name as bloodunit,Q.Dt_Bt_Pl as usetime,Q.SD_PPS_BT as sxmdcode,M.Name as sxmdname,substr(T.code,7) as bloodcode,T.name as bloodname ,");
     sqlSB.append(     " W.Code as applydoctor,W.Name as applydoctorname,X.code as applydept,X.Name as applydeptname,W.code as respdoctor,W.Name as respdoctorname,A.Code_Or as yz_no,'01' as domain_id, ");//yz_no 医嘱号
     sqlSB.append(     " S.Orgcode as orgcode,S.NAME as orgname,co.conttel as contacttel,co.name as contactname,");
     sqlSB.append(     " ITM.id_didef_code as didef_code,ITM.id_didef_name as didef_name,Q.id_diitm as didef_id,Q.sd_bloodtype_ap as Abocode,abo.name as Abovalue,");
     sqlSB.append(	   " Q.sd_rhd_ap as Rhcode,rh.name as Rhvalue,Q.sd_demandsu_bt as Emergencycode,deman.name as Emergencyname,t.SD_IEMSGCA as iemsgca_code,C.code as visitordno,BD.name as visittypename,");
     sqlSB.append(     " (case when A.Code_Entp='00'then '01' when A.Code_Entp ='10'then '03' end )as jztype,v.code as exec_code,a1.sd_su_bl as pay_flag ");
     sqlSB.append(     "  from ci_or_srv A1  ");
     sqlSB.append(     "       left outer join ci_order A ON A1.Id_Or=A.Id_Or ");
     sqlSB.append(     "       left outer join ci_ap_bt Q ON Q.id_or=A.Id_Or ");
     sqlSB.append(     "       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
	 //健康卡
     sqlSB.append(	   "       left outer join pi_pat_card card ON A.Id_Pat=card.Id_Pat and card.fg_act='Y' and card.sd_patcardtp='05' ");//健康卡
     sqlSB.append(     "       left outer join pi_pat_cardtp cardtp ON cardtp.id_cardtp=card.id_patcardtp and cardtp.sd_patcardtp='05' ");
     sqlSB.append(     "       left outer join en_ent C ON A.Id_En=C.Id_Ent ");
     sqlSB.append(     "       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  ");
     sqlSB.append(     "       left outer join en_ent_op J ON A.Id_En=J.Id_Ent ");
     sqlSB.append(     "       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur ");
     sqlSB.append(     "       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy ");
     sqlSB.append(     "       left outer join bd_psndoc R ON R.Id_Psndoc=A.Dt_Sign  ");
     sqlSB.append(     "       left outer join bd_psndoc W ON W.Id_Psndoc=A.Id_Emp_Chk ");
     sqlSB.append(     "       left outer join bd_dep X ON X.Id_Dep=A.Id_Dep_Sign ");
     sqlSB.append(     "       left outer join bd_org S ON S.Id_Org=A.Id_Org ");
     sqlSB.append(     "       left outer join bd_srv T ON T.Id_Srv=A1.Id_Srv ");
     sqlSB.append(     "       left outer join bd_measdoc U ON U.Id_Measdoc=A1.Id_Medu  ");
     sqlSB.append(     "       left outer join pi_pat_addr K ON K.Id_Pat=B.Id_Pat and K.Sd_Addrtp='6' ");//出生地
     sqlSB.append(     "       left outer join bd_pri_pat L ON L.Id_Pripat=B.Id_Patpritp ");
     sqlSB.append(     "       left outer join bd_udidoc M ON M.Id_Udidoc=Q.Id_Pps_Bt ");
     sqlSB.append(     "       left join pi_pat_cont co on co.id_pat=b.id_pat ");//联系人
     sqlSB.append(     "       left outer join en_ent_di M1 ON A.Id_En = M1.Id_Ent and M1.Fg_Maj='Y' ");//主要诊断
     sqlSB.append(     "       left outer join ci_di_itm ITM ON M1.ID_DIITM=ITM.ID_DIITM ");
     sqlSB.append(     "       left outer join bd_udidoc abo ON Q.id_bloodtype_ap=abo.id_udidoc ");
     sqlSB.append(     "       left outer join bd_udidoc rh ON Q.id_rhd_ap=rh.id_udidoc ");
     sqlSB.append(     "       left outer join bd_udidoc deman ON Q.id_demandsu_bt=deman.id_udidoc ");
     sqlSB.append(     "  	   left outer join BD_ENTP BD ON C.CODE_ENTP = BD.CODE ");
	 //是否哺乳、妊娠
     sqlSB.append(	   "       left join (select z0.id_pat,d0.code,z0.sv from pi_pat_phy z0 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind where d0.code='02') phy ON phy.Id_Pat = B.Id_Pat ");//--怀孕
     sqlSB.append(     "       left join (select z0.id_pat,d0.code from pi_pat_phy z0 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind where d0.code='04') phy2 on phy2.Id_Pat = B.Id_Pat  ");//--哺乳;
	 //过敏史
	 sqlSB.append("       	 left outer join (select  bb.id_pat,wmsys.wm_concat(distinct TO_CHAR(TO_DATE( substr(aa.dt_act, 1, 10),'yyyy-MM-dd'),'yyyy-MM-dd') ||':'||  aa.name_alcla)as name_alcla from pi_pat_al aa inner join pi_pat bb on bb.id_pat=aa.id_pat group by  bb.id_pat) al ON al.id_pat = B.Id_Pat ");
	 //执行科室
	 sqlSB.append("       left outer join bd_dep V ON V.Id_Dep=A.Id_Dep_Mp ");
     sqlSB.append(     "       where A1.Sd_Srvtp like '14%' and A1.id_or" );	//A1.id_or id_or4sql
	 sqlSB.append(id_or4sql);

     
 //    SqlParam param =new SqlParam();
 //    param.addParam(%1$s);


      return sqlSB.toString();
    }
	/**
	 * 门诊备血申请数据信息SQL串
	 * 备血医嘱  rownum要替换为top
	 * ABO Rh血型得单独服务求取
	 */
	
	public String CiIeOrbtMainOpSql(String id_or4sql){
	    StringBuilder sqlSB = new StringBuilder();
	    sqlSB.append(    " select c.id_ent as id_ent, "
	    		+ " (case when ITM.FG_MAJDI='Y' then '12' when ITM.FG_MAJDI='N' then '13' else '' end) as diagnosistype,"
	    		+ " (case when ITM.FG_MAJDI='Y' then '主要诊断' when ITM.FG_MAJDI='N' then '次要诊断' else '' end) as diagnosistypename, "
	    		+ " A.Dt_Sign as confirm_date, "
	    		+ " (case when phy.code='02' then '是' else '否' end) as is_pregnancy,(case when phy.code='02' then phy.sv else '' end) as pregnancy_date,"
	    		+ " (case when phy2.code='04' then '是' else '否' end) as is_breastfeeding,"
	    		+ " al.name_alcla as allergy,card.code as healthcard_no,"
	    		+ " Q.id_apbt,Q.id_or as id_iebtoren,null as iebtdiags,null as iebtillhiss,null as iebtnumlisitms,null as iebtcdlisitms,null as iebtstrlisitms ");
	    sqlSB.append(    " ,B.code as patientid,C.Name_Pat as name,C.Sd_Sex_Pat as sex,B.DT_BIRTH_HMS as birthday,'' as age,C.Addr_Pat as address,C.Sd_Mari_Pat as marriagecode ");
	    sqlSB.append(    " ,K.STREET as birthplace,B.Id_Code as socialno,Q.no_db as bloodno,C.code as pbarcode,G.code as wardno,G.name as wardname,H.Name_Bed as bedno,c.telno_pat as tel ");
	    sqlSB.append(    " ,'' as privatecode,I.Code as deptcode,I.Name as deptname,L.Name as feeclass,(case when H.Times_Ip is null then 0 else H.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times ");
	    //applyno申请单号
	    sqlSB.append(    " ,J.Dt_Valid_b as visit_date,Q.NO_APPLYFORM as applyno,A.Des_Or as comment1,A.Dt_Entry as applytime,A1.Quan_Medu as bloodamount,U.Name as bloodunit,Q.Dt_Bt_Pl as usetime,Q.SD_PPS_BT as sxmdcode,M.Name as sxmdname,substr(T.code,7) as bloodcode,T.name as bloodname ");
	    //yz_no医嘱号
	    sqlSB.append(    " ,W.Code as applydoctor,W.Name as applydoctorname,X.code as applydept,X.Name as applydeptname,R.code as respdoctor,R.Name as respdoctorname,A.Code_Or as yz_no,'01' as domain_id, ");
	    sqlSB.append(    " S.Orgcode as orgcode,S.NAME as orgname,");
	    sqlSB.append(    " co.conttel as contacttel,co.name as contactname,");
	    //疾病编码 疾病名称
	    sqlSB.append(    " ITM.id_didef_code as didef_code,ITM.id_didef_name as didef_name,Q.id_diitm as didef_id,");
	    sqlSB.append(    " Q.sd_rhd_ap as Rhcode,rh.name as Rhvalue,Q.sd_demandsu_bt as Emergencycode,deman.name as Emergencyname,t.SD_IEMSGCA as iemsgca_code,C.code as visitordno,BD.name as visittypename,");
	    sqlSB.append(    " Q.sd_bloodtype_ap as Abocode,abo.name as Abovalue,");
	    sqlSB.append(    "(case when A.Code_Entp='00'then '01' when A.Code_Entp ='10'then '03' end )as jztype,v.code as exec_code,A1.sd_su_bl as pay_flag ");
	    
	    sqlSB.append(    "  from ci_or_srv A1  ");
	   
	    sqlSB.append(    "       left outer join ci_order A ON A1.Id_Or=A.Id_Or ");
	    sqlSB.append(    "       left outer join ci_ap_bt Q ON Q.id_or=A.Id_Or ");
	    sqlSB.append(    "       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
		//健康卡
		sqlSB.append(    "       left outer join pi_pat_card card ON A.Id_Pat=card.Id_Pat and card.fg_act='Y' and card.sd_patcardtp='05' ");//健康卡
		sqlSB.append(    "       left outer join pi_pat_cardtp cardtp ON cardtp.id_cardtp=card.id_patcardtp and cardtp.sd_patcardtp='05' ");
	    sqlSB.append(    "       left outer join en_ent C ON A.Id_En=C.Id_Ent ");
	    sqlSB.append(    "       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  ");
	    sqlSB.append(    "       left outer join en_ent_op J ON A.Id_En=J.Id_Ent ");
	    sqlSB.append(    "       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur ");
	    sqlSB.append(    "       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy ");
	    sqlSB.append(    "       left outer join bd_psndoc R ON R.Id_Psndoc=A.Id_Emp_Sign  ");
	    sqlSB.append(    "       left outer join bd_psndoc W ON W.Id_Psndoc=A.Id_Emp_Or ");
	    sqlSB.append(    "       left outer join bd_dep X ON X.Id_Dep=A.Id_Dep_Or ");
	    sqlSB.append(    "       left outer join bd_org S ON S.Id_Org=A.Id_Org ");
	    sqlSB.append(    "       left outer join bd_srv T ON T.Id_Srv=A1.Id_Srv ");
	    sqlSB.append(    "       left outer join bd_measdoc U ON U.Id_Measdoc=A1.Id_Medu  ");
	    sqlSB.append(    "       left outer join pi_pat_addr K ON K.Id_Pat=B.Id_Pat and K.Sd_Addrtp='6' ");//出生地
	    sqlSB.append(    "       left outer join bd_pri_pat L ON L.Id_Pripat=B.Id_Patpritp ");
	    sqlSB.append(    "       left outer join bd_udidoc M ON M.Id_Udidoc=Q.Id_Pps_Bt ");
	    sqlSB.append(    "		 left join pi_pat_cont co on co.id_pat=b.id_pat ");//联系人
	    sqlSB.append(    "       left outer join en_ent_di M1 ON A.Id_En = M1.Id_Ent and M1.Fg_Maj='Y' ");//主要诊断
	    sqlSB.append(    "       left outer join ci_di_itm itm ON M1.ID_DIITM=itm.ID_DIITM ");
	    sqlSB.append(    "       left outer join bd_udidoc abo ON Q.id_bloodtype_ap=abo.id_udidoc");
	    sqlSB.append(    "       left outer join bd_udidoc rh ON Q.id_rhd_ap=rh.id_udidoc");
	    sqlSB.append(    "       left outer join bd_udidoc deman ON Q.id_demandsu_bt=deman.id_udidoc");
	    sqlSB.append(    "  	 left outer join BD_ENTP BD ON C.CODE_ENTP = BD.CODE ");
		//是否哺乳、妊娠
	    sqlSB.append(    "       left join (select z0.id_pat,d0.code,z0.sv from pi_pat_phy z0 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind where d0.code='02') phy ON phy.Id_Pat = B.Id_Pat ");//--怀孕
	    sqlSB.append(    "       left join (select z0.id_pat,d0.code from pi_pat_phy z0 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind where d0.code='04') phy2 on phy2.Id_Pat = B.Id_Pat  ");//--哺乳;
		//过敏史
		sqlSB.append(    "       left outer join (select  bb.id_pat,wmsys.wm_concat(distinct TO_CHAR(TO_DATE( substr(aa.dt_act, 1, 10),'yyyy-MM-dd'),'yyyy-MM-dd') ||':'||  aa.name_alcla)as name_alcla from pi_pat_al aa inner join pi_pat bb on bb.id_pat=aa.id_pat group by  bb.id_pat) al ON al.id_pat = B.Id_Pat ");
		//执行科室
		sqlSB.append("       left outer join bd_dep V ON V.Id_Dep=A.Id_Dep_Mp ");
	    sqlSB.append(    "       where A1.Sd_Srvtp like '14%' and A1.id_or" );	//A1.id_or id_or4sql
	    sqlSB.append(id_or4sql);
	   
	    
	//    SqlParam param =new SqlParam();
	//   param.addParam(param);
	
	
	     return sqlSB.toString();	
	}


	/**
	 * 根据门诊备血申请单查询检查动态指标
	 * by yzh 2018年2月25日 10:25:40
	 */

	public static String CiIeOrbtViewitemOpSql(){
	    StringBuilder sqlSB = new StringBuilder();
	    sqlSB.append("	select A.sd_restrptlabtp,A.val_restrptlab,A.id_restrptlabtp,A.val_rstrptla,A.id_unit,B.name as name_unit,A.id_apbtobsindex,A.id_apbt,C.code as code_srv ");
	    sqlSB.append("	from ci_ap_bt_viewitm A ");
	    sqlSB.append("	left outer join bd_measdoc B ON A.id_unit=B.id_measdoc ");
	    sqlSB.append("	left outer join bd_srv C ON A.id_srv=C.id_srv");
	    sqlSB.append("	where ? ");
	    
	   
	 //   SqlParam param =new SqlParam();
	//    param.addParam(%1$s);
	
	
	     return sqlSB.toString();

	}
}
