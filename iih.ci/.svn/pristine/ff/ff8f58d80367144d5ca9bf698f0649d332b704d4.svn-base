package iih.ci.ord.s.bp.iemsg.qry.sql;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import iih.ci.ord.pub.CiOrdUtils;
import xap.sys.jdbc.kernel.SqlParam;

//集成平台  新  检查类SQL

public class Ris4IESql {
	/**
	 * 检查申请单数据信息SQL串
	 * （住院）普通检查
	 * 套时部位得单独求取         -------------------------------------------------------------------
	 */
	public String CiIeAppRisAllSql(String id_or4sql){
		
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" select do.code as ser_type_code,do.name as ser_type_name,free.amounts as amounts,al.name_alcla as allergy,card.code as health_card_no,(case when phy2.code='04' then '是' else '否' end) as is_breastfeeding,(case when phy.code='02' then '是' else '否' end) as is_pregnancy,(case when phy.code='02' then phy.sv else '' end) as pregnancy_date"
				+ ",C.Id_Ent as id_ent, A.id_en as id_ierisoren,B.code as patient_id,F.code_amr_ip as p_bar_code,E.code as ward_code,E.name as ward_code_name,F.name_bed as bed_no,B.Id_Code as social_no, ");
        sqlSB.append(" S.no_hp as addition_no,C.Name_Pat as name,C.Telno_Pat as home_tel,C.Sd_Sex_Pat as sexid,B.DT_BIRTH_HMS as birthday,'' as age,C.ADDR_PAT as home_street,C.Sd_Mari_Pat as marry_code,T.code as nation_code, ");
        sqlSB.append(" u.code as occupation_type,U.Name as occupation_type_name,B.Workunit as work_unit,o.code as country_code,O.Name as country_code_name, ");
        sqlSB.append(" D.code as  code_dep_ns,D.name as name_dep_ns,G.orgCode as org_code,G.name as org_name,");
        sqlSB.append(" G.Name as apply_hospital,A.dt_sign as enter_date,K.code as apply_doctor,K.name as apply_doctor_name, ");
        sqlSB.append(" L.Code as apply_unit,L.Name as apply_unit_name,A.Dt_Chk as confirm_date,H.Code as confirm_opera,H.Name as confirm_opera_name,W.Name as response_type, ");
        sqlSB.append(" (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times, ");
        sqlSB.append(" (case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type_code,(case when M.FG_MAJDI='Y' then '主要诊断' when M.FG_MAJDI='N' then '次要诊断' else '' end) as diag_type_name,");
        sqlSB.append( "X.Dt_Sign as diag_input_date,M.ID_DIDEF_CODE as diag_code,M.ID_DIDEF_NAME as diag_str ");
        //检查申请编码apply_serial
        sqlSB.append(" ,A.Id_Or as id_ierisor,A.id_en as id_ierisoren,'' as id_ierisoritms,Q.NO_APPLYFORM as apply_serial,(case when substr(A.sd_srvtp,0,2)='02' then ? when substr(A.sd_srvtp,0,2) ='03' then ? else '' end) as exam_type,");
        sqlSB.append("(case when substr(A.sd_srvtp,0,2)='02' then '检查' when substr(A.sd_srvtp,0,2) ='03' then '化验'  else '' end) as exam_type_name ");
        sqlSB.append(" ,R.Name as exam_content,A.Dt_Sign as exam_request_date,'' as samp_bar_code,'' as samp_type,'' as samp_content,A.Dt_Last_Mp as exam_exec_date,VV.Name as exec_unit,VV.Code as sqd_deptcode,Q.Announcements as note, ");
        sqlSB.append(" Q.Id_Orobs as id_ierisoritm,A.Id_Or as id_ierisor,a.code_or as exam_serial,P.code as exam_sub_type,P.name as exam_sub_type_name,");//检查项目编码exam_sub_type、医嘱编码exam_serial
        sqlSB.append(" '' as order_pri,A.dt_effe as dt_effe,A.dt_end as dt_end,");
	    sqlSB.append(" Z1.Code as yz_frequency,Z1.Name as yz_frequency_name,'' as exam_sub_fftype,'' as exam_sub_fftype_name,(case when P.fg_set='N' then V.Sd_Body else  Z4.code end) as exam_region,");
	    sqlSB.append(" (case when P.fg_set='N' then Z.name else Z4.name end) as exam_region_name ,");
	    sqlSB.append(" '' as isstest, '' as stest, A.fg_urgent as is_em, '' as is_em_r,'' as isyg, '' as yg,'' as vip_val, ");
	    sqlSB.append(" P.sd_iemsgca as iemsgca_code,(case when Z3.name='未记账' then '099' when Z3.name='已记账' then  P1.name end) as iemsgca_name , P1.ctrl1 as iemsgca_typename,");
	    sqlSB.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as Ordertimetypename,(case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as Ordertimetype, ");
		sqlSB.append(" C.code as Visitordno,(case when C.code_entp='00'then '01'when C.code_entp='10'then '03' end) as Visittypecode,BD.name as Visittypename");
	    sqlSB.append(" from ci_ap_obs Q left outer join ci_order A on Q.Id_Or=A.Id_Or ");
	    sqlSB.append("       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
		sqlSB.append("       left outer join pi_pat_card card ON A.Id_Pat=card.Id_Pat and card.fg_act='Y' and card.sd_patcardtp='05' ");//健康卡
		sqlSB.append("       left outer join pi_pat_cardtp cardtp ON cardtp.id_cardtp=card.id_patcardtp and cardtp.sd_patcardtp='05' ");
		sqlSB.append("       left join (select z0.id_pat,d0.code,z0.sv from pi_pat_phy z0 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind where d0.code='02') phy ON phy.Id_Pat = B.Id_Pat ");//--怀孕
		sqlSB.append("       left join (select z0.id_pat,d0.code from pi_pat_phy z0 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind where d0.code='04') phy2 on phy2.Id_Pat = B.Id_Pat  ");//--哺乳
		sqlSB.append("       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
	    sqlSB.append("       left outer join en_ent C ON A.Id_En=C.Id_Ent ");
	    sqlSB.append("       left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP "); // D就诊科室
	    sqlSB.append("       left outer join bd_dep E ON C.Id_Dep_Nur=E.Id_Dep " );// E就诊病区
	    sqlSB.append("       left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent  " );// 门诊就诊
	    sqlSB.append("       left outer join bd_org G ON A.Id_Org=G.Id_Org " );// 机构
	    sqlSB.append("       left outer join bd_psndoc H ON H.Id_Psndoc=A.Id_Emp_Chk ");
	    sqlSB.append("       left outer join en_ent_op J ON A.Id_En=J.Id_Ent ");
	    sqlSB.append("       left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Or ");
	    sqlSB.append("       left outer join bd_dep L ON A.Id_Dep_Or=L.ID_DEP ");
	    sqlSB.append("       left outer join en_ent_di M1 ON A.Id_En = M1.Id_Ent and M1.Fg_Maj='Y' ");//在检查医嘱属性表里ci_ap_obs存储的id_di是就诊诊断表en_ent_di里的ID_entdi，与其他诊断表里的ID_DI不一致，此处临时更改
        sqlSB.append("       left outer join ci_di_itm M ON M1.ID_DIITM=M.ID_DIITM ");
	    sqlSB.append("       left outer join ci_di X ON M1.Id_Di=X.Id_Di ");
	    sqlSB.append("       left outer join bd_srvca N ON N.Id_Srvca=A.Id_Srvca ");
		sqlSB.append(		"       left outer join bd_country O ON O.Id_CountryZONE=B.Id_Country ");//国家国家编码
	    sqlSB.append("       left outer join bd_srv P ON P.id_srv=A.Id_Srv ");
	    sqlSB.append("       left outer join bd_udidoc R ON R.Id_Udidoc=Q.Id_Pps "); // 检查目的
	    sqlSB.append("       left outer join en_ent_hp S ON S.ID_ENT=C.Id_Ent "); // 医保卡
	    sqlSB.append("       left outer join bd_udidoc T ON T.Id_Udidoc=B.Id_Nation ");
	    sqlSB.append("       left outer join bd_udidoc U ON U.Id_Udidoc=B.Id_Occu ");
	    sqlSB.append("       left outer join bd_dep VV ON VV.Id_Dep=A.Id_Dep_Mp ");
	    sqlSB.append("       left outer join pi_pat_ca W ON W.Id_Patca=B.Id_Paticate ");
	    sqlSB.append("       left outer join bd_freq Y ON A.Id_Freq=Y.Id_Freq ");
	    sqlSB.append("       left outer join bd_srv_obs V ON V.Id_Srv=A.Id_Srv ");
	    sqlSB.append("       left outer join bd_udidoc Z ON V.Id_Body=Z.Id_Udidoc    ");
	    sqlSB.append("		 left outer join bd_freq Z1 ON Z1.Id_Freq=A.Id_Freq	 ");
	    sqlSB.append("		 left outer join bd_udidoc P1 ON P.Id_iemsgca = P1.Id_Udidoc	 ");
	    sqlSB.append("		 left outer join ci_or_srv C1 ON A.id_or=C1.id_or and C1.fg_or = 'Y'");
	    sqlSB.append("		 left outer join bd_udidoc Z3 ON (Z3.id_udidoc = ? and Z3.id_udidoclist = ? )");
	    sqlSB.append("		 left outer join ci_or_srv_set Z5 on Z5.id_or = A.id_or and  Z5.fg_clinical = 'Y'   and Z5.id_body is not null");
	    sqlSB.append("		 left outer join bd_udidoc Z4 ON Z4.Id_Udidoc = Z5.Id_Body" );
        sqlSB.append("       left outer join BD_ENTP BD ON C.CODE_ENTP = BD.CODE"	 );	
		sqlSB.append(		"       left outer join (select  bb.id_pat,wmsys.wm_concat(distinct TO_CHAR(TO_DATE( substr(aa.dt_act, 1, 10),'yyyy-MM-dd'),'yyyy-MM-dd') ||':'||  aa.name_alcla)as name_alcla from pi_pat_al aa inner join pi_pat bb on bb.id_pat=aa.id_pat group by  bb.id_pat) al ON al.id_pat = B.Id_Pat ");//过敏史
		//费用金额
		sqlSB.append(" left join "
				+ " (select srv.id_or,ciorder.id_pat ,sum(srv.quan_total_medu * srv.pri ) as amounts " + 
				"   from ci_order ciorder " + 
				"   left join ci_or_srv srv on ciorder.id_or = srv.id_or where srv.fg_bl='Y' " + 
				"   group by ciorder.id_pat,srv.id_or) free on free.id_or=A.id_or ");
		//检查类型 但取值为服务类型
		sqlSB.append(		"  left join BD_UDIDOC do on do.id_udidoc= a.id_srvtp  ");
		
		sqlSB.append(" where  A.id_or " );
		if( id_or4sql.indexOf(",") == -1){
			sqlSB.append(" =  ");
			sqlSB.append(CiOrdUtils.getSqlCondStr(id_or4sql));
		}else{
			sqlSB.append(" in  ");
			sqlSB.append(CiOrdUtils.getSqlInStrsWithOutIn(id_or4sql));
		}
		return sqlSB.toString();
		
	}
	/**
	 * 检查申请单数据信息SQL串 已记账     -------------------------------------------------------------------
	 * （门诊）
	 * 套时部位得单独求取
	 */
	public static String CiIeAppRisOpAllSql( String _id_ors ){
		
		StringBuilder sqlSB = new StringBuilder( );
		
		sqlSB.append(" select A.id_en as id_ierisoren,B.code as patient_id,B.BARCODE_CHIS as p_bar_code,E.code as ward_code,E.name as ward_code_name,F.name_bed as bed_no,(case when B.id_idtp = '@@@@AA1000000000MNLZ' then B.Id_Code else '' end) as social_no, ");
		sqlSB.append(" S.CODE as addition_no,C.Name_Pat as name,C.Telno_Pat as home_tel,C.Sd_Sex_Pat as sexid,C.Dt_Birth_Pat as birthday,'' as age,C.ADDR_PAT as home_street,C.Sd_Mari_Pat as marry_code,B.Sd_Nation as nation_code, ");
		sqlSB.append(" B.Sd_Occu as occupation_type,U.Name as occupation_type_name,B.Workunit as work_unit,B.Sd_Country as country_code,O.Name as country_code_name, ");
		sqlSB.append(" '' as relation_tel,'' as relation_tel_name, D.code as  code_dep_ns,D.name as name_dep_ns,G.orgCode as org_code,G.name as org_name,");
		sqlSB.append(" G.Name as apply_hospital,A.dt_sign as enter_date,K.code as apply_doctor,K.name as apply_doctor_name, ");
		sqlSB.append(" L.Code as apply_unit,L.Name as apply_unit_name,A.Dt_Chk as confirm_date,H.Code as confirm_opera,H.Name as confirm_opera_name,W.Name as response_type, ");
		sqlSB.append(" (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times, ");
		sqlSB.append(" (case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type_code,(case when M.FG_MAJDI='Y' then '主要诊断' when M.FG_MAJDI='N' then '次要诊断' else '' end) as diag_type_name,X.Dt_Sign as diag_input_date,M.ID_DIDEF_CODE as diag_code,M.ID_DIDEF_NAME as diag_str ");
		sqlSB.append(" ,A.Id_Or as id_ierisor,A.id_en as id_ierisoren,'' as id_ierisoritms,Q.NO_APPLYFORM as apply_serial,(case when substr(A.sd_srvtp,0,2)='02' then ? when substr(A.sd_srvtp,0,2) ='03' then ?  else '' end) as exam_type,(case when substr(A.sd_srvtp,0,2)='02' then '检查' when substr(A.sd_srvtp,0,2) ='03' then '化验'  else '' end) as exam_type_name ");
		sqlSB.append(" ,R.Name as exam_content,A.Dt_Sign as exam_request_date,'' as samp_bar_code,'' as samp_type,'' as samp_content,A.Dt_Last_Mp as exam_exec_date,VV.Name as exec_unit,VV.Code as sqd_deptcode,Q.Announcements as note, ");
		sqlSB.append(" Q.Id_Orobs as id_ierisoritm,A.Id_Or as id_ierisor,Q.NO_APPLYFORM as exam_serial,P.code as exam_sub_type,P.name as exam_sub_type_name,");
		sqlSB.append(" '' as order_pri,A.dt_effe as dt_effe,A.dt_end as dt_end,");
		sqlSB.append(" Z1.Code as yz_frequency,Z1.Name as yz_frequency_name,'' as exam_sub_fftype,'' as exam_sub_fftype_name,(case when P.fg_set='N' then V.Sd_Body else  Z4.code end) as exam_region,");
		sqlSB.append(" (case when P.fg_set='N' then Z.name else Z4.name end) as exam_region_name ,");
		sqlSB.append(" '' as isstest, '' as stest, A.fg_urgent as is_em, '' as is_em_r,'' as isyg, '' as yg,'' as vip_val, ");
		sqlSB.append(" P.sd_iemsgca as iemsgca_code,(case when Z3.name='未记账' then '099' when Z3.name='已记账' then  P1.name end) as iemsgca_name , P1.ctrl1 as iemsgca_typename");
		
		sqlSB.append(" from ci_ap_obs Q left outer join ci_order A on Q.Id_Or=A.Id_Or ");
		
		sqlSB.append("       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
		sqlSB.append("       left outer join en_ent C ON A.Id_En=C.Id_Ent ");
		sqlSB.append("       left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP " );// D就诊科室
		sqlSB.append("       left outer join bd_dep E ON C.Id_Dep_Nur=E.Id_Dep " );// E就诊病区
		sqlSB.append("       left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent  " );// 门诊就诊
		sqlSB.append("       left outer join bd_org G ON A.Id_Org=G.Id_Org " );// 机构
		sqlSB.append("       left outer join bd_psndoc H ON H.Id_Psndoc=A.Id_Emp_Chk ");
		sqlSB.append("       left outer join en_ent_op J ON A.Id_En=J.Id_Ent ");
		sqlSB.append("       left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Or ");
		sqlSB.append("       left outer join bd_dep L ON A.Id_Dep_Or=L.ID_DEP ");
		sqlSB.append("       left outer join en_ent_di M1 ON Q.Id_Di=M1.ID_entdi ");//在检查医嘱属性表里ci_ap_obs存储的id_di是就诊诊断表en_ent_di里的ID_entdi，与其他诊断表里的ID_DI不一致，此处临时更改
		sqlSB.append("       left outer join ci_di_itm M ON M1.ID_DIITM=M.ID_DIITM ");
		sqlSB.append("       left outer join ci_di X ON M1.Id_Di=X.Id_Di ");
		sqlSB.append("       left outer join bd_srvca N ON N.Id_Srvca=A.Id_Srvca ");
		sqlSB.append("       left outer join bd_udidoc O ON O.Id_Udidoc=B.Id_Country ");
		sqlSB.append("       left outer join bd_srv P ON P.id_srv=A.Id_Srv ");
		sqlSB.append("       left outer join bd_udidoc R ON R.Id_Udidoc=Q.Id_Pps " );// 检查目的
		sqlSB.append("       left outer join pi_pat_card S ON S.ID_PAT=B.Id_Pat and S.Sd_Patcardtp='04' " );// 医保卡
		sqlSB.append("       left outer join bd_udidoc T ON T.Id_Udidoc=B.Id_Nation ");
		sqlSB.append("       left outer join bd_udidoc U ON U.Id_Udidoc=B.Id_Occu ");
		sqlSB.append("       left outer join bd_dep VV ON VV.Id_Dep=A.Id_Dep_Mp ");
		sqlSB.append("       left outer join pi_pat_ca W ON W.Id_Patca=B.Id_Paticate ");
		sqlSB.append("       left outer join bd_freq Y ON A.Id_Freq=Y.Id_Freq ");
		sqlSB.append("       left outer join bd_srv_obs V ON V.Id_Srv=A.Id_Srv ");
		sqlSB.append("       left outer join bd_udidoc Z ON V.Id_Body=Z.Id_Udidoc    ");
		sqlSB.append("		 left outer join bd_freq Z1 ON Z1.Id_Freq=A.Id_Freq	 ");
		sqlSB.append("		 left outer join bd_udidoc P1 ON P.Id_iemsgca = P1.Id_Udidoc	 ");
		sqlSB.append("		 left outer join ci_or_srv C1 ON A.id_or=C1.id_or and C1.fg_or = 'Y'");
		sqlSB.append("		 left outer join bd_udidoc Z3 ON (Z3.id_udidoc = ? and Z3.id_udidoclist= ? )");
		sqlSB.append("		 left outer join ci_or_srv_set Z5 on Z5.id_or = A.id_or and  Z5.fg_clinical = 'Y'   and Z5.id_body is not null");
		sqlSB.append("		 left outer join bd_udidoc Z4 ON Z4.Id_Udidoc = Z5.Id_Body");
		sqlSB.append(" where M1.fg_maj = 'Y' and A.id_or ");
		
		
		if( _id_ors.indexOf(",") == -1){
			sqlSB.append(" = ?");
		}else{
			sqlSB.append(" in (?)");
		}
	
		return sqlSB.toString();
		
	}
	
	
	/**
	 * 检查申请单数据信息SQL串 未记账     -------------------------------------------------------------------
	 * （门诊）普通检查
	 * 套时部位得单独求取
	 * 
	 * CI_IE_APPRIS_OP_ALL_SQL_1
	 */
	public String CiIeAppRisOpAllSql1( String str_idor_ris ){
		
		StringBuilder sqlSB = new StringBuilder();
		
		sqlSB.append(		" select M.ID_DIDEF_CODE as diag_name,do.code as ser_type_code,do.name as ser_type_name,free.amounts as amounts,al.name_alcla as allergy,card.code as health_card_no,"
				+ " (case when phy2.code='04' then '是' else '否' end) as is_breastfeeding,(case when phy.code='02' then '是' else '否' end) as is_pregnancy,(case when phy.code='02' then phy.sv else '' end) as pregnancy_date"
				+ ",C.Id_Ent as id_ent,A.id_en as id_ierisoren,B.code as patient_id,c.code as p_bar_code,E.code as ward_code,E.name as ward_code_name,F.name_bed as bed_no,B.Id_Code as social_no, ");
		sqlSB.append(		" S.no_hp as addition_no,C.Name_Pat as name,C.Telno_Pat as home_tel,C.Sd_Sex_Pat as sexid,B.DT_BIRTH_HMS as birthday,'' as age,C.ADDR_PAT as home_street,C.Sd_Mari_Pat as marry_code,T.code as nation_code, ");
		sqlSB.append(		" B.Sd_Occu as occupation_type,U.Name as occupation_type_name,B.Workunit as work_unit,o.code as country_code,O.Name as country_code_name, ");
		sqlSB.append(		" D.code as  code_dep_ns,D.name as name_dep_ns,G.orgCode as org_code,G.name as org_name,");
		sqlSB.append(		" G.Name as apply_hospital,A.dt_sign as enter_date,K.code as apply_doctor,K.name as apply_doctor_name, ");
		sqlSB.append(		" L.Code as apply_unit,L.Name as apply_unit_name,A.Dt_Sign as confirm_date,H.Code as confirm_opera,H.Name as confirm_opera_name,W.Name as response_type, ");
		sqlSB.append(		" (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as times, ");
		sqlSB.append(		" (case when M.FG_MAJDI='Y' then '12' when M.FG_MAJDI='N' then '13' else '' end) as diag_type_code,(case when M.FG_MAJDI='Y' then '主要诊断' when M.FG_MAJDI='N' then '次要诊断' else '' end) as diag_type_name,X.Dt_Sign as diag_input_date,M.ID_DIDEF_CODE as diag_code,M.ID_DIDEF_NAME as diag_str ");
		//检查申请编码apply_serial
		sqlSB.append(		" ,A.Id_Or as id_ierisor,A.id_en as id_ierisoren,'' as id_ierisoritms,Q.NO_APPLYFORM as apply_serial,(case when substr(A.sd_srvtp,0,2)='02' then ? when substr(A.sd_srvtp,0,2) ='03' then ?  else '' end) as exam_type,(case when substr(A.sd_srvtp,0,2)='02' then '检查' when substr(A.sd_srvtp,0,2) ='03' then '化验'  else '' end) as exam_type_name ");
		sqlSB.append(		" ,R.Name as exam_content,A.Dt_Sign as exam_request_date,'' as samp_bar_code,'' as samp_type,'' as samp_content,A.Dt_Last_Mp as exam_exec_date,VV.Name as exec_unit,VV.Code as sqd_deptcode,Q.Announcements as note, ");
		sqlSB.append(		" Q.Id_Orobs as id_ierisoritm,A.Id_Or as id_ierisor,a.code_or as exam_serial,P.code as exam_sub_type,P.name as exam_sub_type_name,");//检查项目编码exam_sub_type、医嘱编码exam_serial
		sqlSB.append(		" '' as order_pri,A.dt_effe as dt_effe,A.dt_end as dt_end,");
		sqlSB.append(		" Z1.Code as yz_frequency,Z1.Name as yz_frequency_name,'' as exam_sub_fftype,'' as exam_sub_fftype_name,(case when P.fg_set='N' then V.Sd_Body else  Z4.code end) as exam_region,");
		sqlSB.append(		" (case when P.fg_set='N' then Z.name else Z4.name end) as exam_region_name ,");
		sqlSB.append(		" '' as isstest, '' as stest, A.fg_urgent as is_em, '' as is_em_r,'' as isyg, '' as yg,'' as vip_val, ");
		sqlSB.append(		" P.sd_iemsgca as iemsgca_code,(case when Z3.name='未记账' then '099' when Z3.name='已记账' then  P1.name end) as iemsgca_name , P1.ctrl1 as iemsgca_typename,");
		sqlSB.append(       " (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as Ordertimetypename,(case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as Ordertimetype, ");
		sqlSB.append(		" C.code as Visitordno,(case when C.code_entp='00'then '01'when C.code_entp='10'then '03' end) as Visittypecode,BD.name as Visittypename");
		sqlSB.append(		" from ci_ap_obs Q left outer join ci_order A on Q.Id_Or=A.Id_Or ");
		sqlSB.append(		"       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
		sqlSB.append(		"       left outer join pi_pat_card card ON A.Id_Pat=card.Id_Pat and card.fg_act='Y' and card.sd_patcardtp='05' ");//健康卡
		sqlSB.append(		"       left outer join pi_pat_cardtp cardtp ON cardtp.id_cardtp=card.id_patcardtp and cardtp.sd_patcardtp='05' ");
		sqlSB.append(		"       left join (select z0.id_pat,d0.code,z0.sv from pi_pat_phy z0 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind where d0.code='02') phy ON phy.Id_Pat = B.Id_Pat ");//--怀孕
		sqlSB.append(		"       left join (select z0.id_pat,d0.code from pi_pat_phy z0 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind where d0.code='04') phy2 on phy2.Id_Pat = B.Id_Pat  ");//--哺乳
		sqlSB.append(		"       left outer join en_ent C ON A.Id_En=C.Id_Ent ");
		sqlSB.append(		"       left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP " ); // D就诊科室 
		sqlSB.append(		"       left outer join bd_dep E ON C.Id_Dep_Nur=E.Id_Dep " ); // E就诊病区 
		sqlSB.append(		"       left outer join en_ent_ip F ON C.Id_Ent=F.Id_Ent  " ); // 门诊就诊 
		sqlSB.append(		"       left outer join bd_org G ON A.Id_Org=G.Id_Org "     );// 机构 
		sqlSB.append(		"       left outer join bd_psndoc H ON H.Id_Psndoc=A.Id_Emp_Sign ");
		sqlSB.append(		"       left outer join en_ent_op J ON A.Id_En=J.Id_Ent ");
		sqlSB.append(		"       left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Or ");
		sqlSB.append(		"       left outer join bd_dep L ON A.Id_Dep_Or=L.ID_DEP ");
		sqlSB.append(		"       left outer join en_ent_di M1 ON A.Id_En = M1.Id_Ent " );//在检查医嘱属性表里ci_ap_obs存储的id_di是就诊诊断表en_ent_di里的ID_entdi，与其他诊断表里的ID_DI不一致，此处临时更改);
		sqlSB.append(		"       left outer join ci_di_itm M ON M1.ID_DIITM=M.ID_DIITM ");
		sqlSB.append(		"       left outer join ci_di X ON M1.Id_Di=X.Id_Di ");
		sqlSB.append(		"       left outer join bd_srvca N ON N.Id_Srvca=A.Id_Srvca ");
		sqlSB.append(		"       left outer join bd_country O ON O.Id_CountryZONE=B.Id_Country ");//国家 国家编码
		sqlSB.append(		"       left outer join bd_srv P ON P.id_srv=A.Id_Srv ");
		sqlSB.append(		"       left outer join bd_udidoc R ON R.Id_Udidoc=Q.Id_Pps " ); // 检查目的 
		sqlSB.append(		"       left outer join en_ent_hp S ON S.ID_ENT=C.Id_Ent " );// 医保卡
		sqlSB.append(		"       left outer join bd_udidoc T ON T.Id_Udidoc=B.Id_Nation ");
		sqlSB.append(		"       left outer join bd_udidoc U ON U.Id_Udidoc=B.Id_Occu ");
		sqlSB.append(		"       left outer join bd_dep VV ON VV.Id_Dep=A.Id_Dep_Mp ");
		sqlSB.append(		"       left outer join pi_pat_ca W ON W.Id_Patca=B.Id_Paticate ");
		sqlSB.append(		"       left outer join bd_freq Y ON A.Id_Freq=Y.Id_Freq ");
		sqlSB.append(		"       left outer join bd_srv_obs V ON V.Id_Srv=A.Id_Srv ");
		sqlSB.append(		"       left outer join bd_udidoc Z ON V.Id_Body=Z.Id_Udidoc    ");
		sqlSB.append(		"		left outer join bd_freq Z1 ON Z1.Id_Freq=A.Id_Freq	 ");
		sqlSB.append(		"		left outer join bd_udidoc P1 ON P.Id_iemsgca = P1.Id_Udidoc	 ");
		sqlSB.append(		"		left outer join ci_or_srv C1 ON A.id_or=C1.id_or and C1.fg_or = 'Y'");
		sqlSB.append(		"		left outer join bd_udidoc Z3 ON (Z3.id_udidoc = ? and Z3.id_udidoclist= ? )");
		sqlSB.append(		"		left outer join ci_or_srv_set Z5 on Z5.id_or = A.id_or and  Z5.fg_clinical = 'Y'   and Z5.id_body is not null");
		sqlSB.append(		"		left outer join bd_udidoc Z4 ON Z4.Id_Udidoc = Z5.Id_Body");
		sqlSB.append(		"       left outer join BD_ENTP BD ON C.CODE_ENTP = BD.CODE ");
		sqlSB.append(		"       left outer join (select  bb.id_pat,wmsys.wm_concat(distinct TO_CHAR(TO_DATE( substr(aa.dt_act, 1, 10),'yyyy-MM-dd'),'yyyy-MM-dd') ||':'||  aa.name_alcla)as name_alcla from pi_pat_al aa inner join pi_pat bb on bb.id_pat=aa.id_pat group by  bb.id_pat) al ON al.id_pat = B.Id_Pat ");//过敏史
		//费用金额
		sqlSB.append(" left join "
				+ " (select srv.id_or,ciorder.id_pat ,sum(srv.quan_total_medu * srv.pri ) as amounts " + 
				"   from ci_order ciorder " + 
				"   left join ci_or_srv srv on ciorder.id_or = srv.id_or where srv.fg_bl='Y' " + 
				"   group by ciorder.id_pat,srv.id_or) free on free.id_or=A.id_or ");
		//检查类型 但取值为服务类型
		sqlSB.append("  left join BD_UDIDOC do on do.id_udidoc= a.id_srvtp  ");
		
		sqlSB.append(		" where M1.Fg_Maj='Y' and A.id_or  ");

		if( str_idor_ris.indexOf(",") == -1){
			sqlSB.append(" =  ");
			sqlSB.append(CiOrdUtils.getSqlCondStr(str_idor_ris));
		}else{
			sqlSB.append(" in  ");
			sqlSB.append(CiOrdUtils.getSqlInStrsWithOutIn(str_idor_ris));
		}

		return sqlSB.toString();
	}
}
