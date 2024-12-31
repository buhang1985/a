package iih.ci.ord.s.bp.iemsg.qry.sql;

import org.apache.jasper.tagplugins.jstl.core.Param;

import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import xap.sys.jdbc.kernel.SqlParam;

//集成平台  新  手术类SQL
public class Sur4IESql {

	
	/**
	 * 住院手术医嘱数据信息SQL串
	 * 仅住院手术医嘱使用
	 */
	
	public String CiIeOropSql(String id_or4sql){
	
		StringBuilder sqlSB = new StringBuilder();
		
		sqlSB.append(" select (case when q.fg_er_sug ='Y' then 0 when q.fg_xq_sug ='Y' then 1  when q.fg_zq_sug='Y' then 2  end) as operationKind, "
				+ " (case when q.fg_er_sug ='Y' then '急诊' when q.fg_xq_sug ='Y' then '限期'  when q.fg_zq_sug='Y' then '择期'  end) as operationKindName, "
				+ " al.name_alcla as allergy,card.code as healthcard_no,Q.Id_Apop as id_ieoporen,B.dt_birth as birthday,B.code as patient_id,A.Code_Or as yz_no,Q.NO_APPLYFORM as op_record_id,D.Code as op_code,D.Name as op_code_name,Q.name_des as op_describe ");//yz_no 医嘱号 d.code 手术名称编码 op_record_id 申请单号
		sqlSB.append(" ,A.Dt_Entry as apply_date,E.code_ie as op_scale,E.name as op_scale_name,Q.Sd_Anestp as anaesthesia_method_code,F.Name as anaesthesia_method_name,H.code_amr_ip as p_bar_code	");
		sqlSB.append(" ,G.name as ward_code_name,G.Code as ward_code,H.NAME_BED as bed_no,B.Id_Code as social_no,S.Code as addition_no1,C.Name_Pat as name,C.Telno_Pat as home_tel,C.Sd_Sex_Pat as sex,C.Dt_Birth_Pat as birthday,'' as age ");
		sqlSB.append(" ,C.ADDR_PAT as home_street,I.code as patient_dept,I.name as patient_dept_name,K.orgcode as hospital_code,K.name as hospital_name,Q.Dt_Plan as op_datetime ");
		sqlSB.append(" ,L.Code as op_doctor,L.name as op_doctor_name,M.code as exec_code,M.name as exec_code_name,N.code as apply_user,N.name as apply_user_name ");
		sqlSB.append(" ,O.code as dept_code,O.name as dept_code_name,'' as check_date,'' as check_opera,'' as check_opera_name,A.fg_skintest as isstest,A.fg_skintest as stest ");
		sqlSB.append(" ,'03' as is_em,(case when A.Fg_Urgent='Y' then 'true'  else 'false' end) as is_em_r,'' as is_frozen_flag,'' as frozen_flag,'' as is_urgent_select_flag,'' as urgent_select_flag ");
		sqlSB.append(" ,Q.Announcements as comment1,Q.Specialdes as Special_prepare,(case when H.Times_Ip is null then 0 else H.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as admit_times,C.Dt_Entry  as visit_date,'' as response_type_code,'' as response_type_name ");
		sqlSB.append(" ,(case when P.FG_MAJDI='Y' then '12' when P.FG_MAJDI='N' then '13' else '' end) as diag_type,(case when P.FG_MAJDI='Y' then '主要诊断' when P.FG_MAJDI='N' then '次要诊断' else '' end) as diag_type_name,P.ID_DIDEF_CODE as diag_code,P.ID_DIDEF_NAME as diag_str,'' as isyg,'' as yg,'01' as domain_id ");
		sqlSB.append(" ,D.sd_iemsgca as iemsgca_code,(case when Z3.name='未记账' then '099' when Z3.name='已记账' then  P1.name end) as iemsgca_name");
		sqlSB.append(" ,C.code as visitOrdNo,(case when c.code_entp='00' then '01' when c.code_entp='10' then '03' end) as visitType,bd.name as visitTypeName,S.name as op_nurse_name,R.id_emp_helper as op_nurse_code ");
		sqlSB.append(" ,A.Id_or as Idor ");
		sqlSB.append(" from ci_ap_sug Q left outer join ci_order A on Q.Id_Or=A.Id_Or ");
		sqlSB.append("       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
		//健康卡
		sqlSB.append("       left outer join pi_pat_card card ON A.Id_Pat=card.Id_Pat ");
		sqlSB.append("       left outer join pi_pat_cardtp cardtp ON cardtp.id_cardtp=card.id_patcardtp and cardtp.sd_patcardtp='05' ");
		sqlSB.append("       left outer join en_ent C ON A.Id_En=C.Id_Ent ");
		sqlSB.append("       left outer join bd_srv D ON Q.Id_Srv=D.Id_Srv ");
		sqlSB.append("       left outer join bd_udidoc P1 ON D.Id_iemsgca = P1.Id_Udidoc	 ");
		sqlSB.append("       left outer join bd_udidoc Z3 ON (Z3.id_udidoc = ? and Z3.id_udidoclist= ? )");
		sqlSB.append("       left outer join bd_udidoc E ON E.Id_Udidoc=Q.Id_Lvlsug ");
		sqlSB.append("       left outer join bd_udidoc F ON F.Id_Udidoc=Q.Id_Anestp ");
		sqlSB.append("       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur ");
		sqlSB.append("       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  ");
		sqlSB.append("       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy ");
		sqlSB.append("       left outer join en_ent_op J ON A.Id_En=J.Id_Ent ");
		sqlSB.append("       left outer join pi_pat_card S ON S.ID_PAT=B.Id_Pat and S.Sd_Patcardtp='04' ");
		sqlSB.append("       left outer join bd_org K ON A.Id_Org=K.Id_Org ");
		sqlSB.append("       left outer join bd_psndoc L ON L.Id_Psndoc=Q.Id_Emp_Operate ");
		sqlSB.append("       left outer join bd_dep M ON M.Id_Dep=A.Id_Dep_Mp ");
		sqlSB.append("       left outer join bd_psndoc N ON N.Id_Psndoc=A.Id_Emp_Or ");
		sqlSB.append("       left outer join bd_dep O ON O.Id_Dep=A.Id_Dep_Or ");
		sqlSB.append("       left outer join en_ent_di M1 ON A.Id_En = M1.Id_Ent and M1.Fg_Maj='Y' ");//在检查医嘱属性表里ci_ap_sug存储的id_di是就诊诊断表en_ent_di里的ID_entdi，与其他诊断表里的ID_DI不一致，此处临时更改
		sqlSB.append("       left outer join ci_di_itm P ON M1.Id_Diitm=P.ID_DIITM ");
		sqlSB.append("  	 left outer join BD_ENTP BD ON C.CODE_ENTP = BD.CODE ");
		sqlSB.append("  	 left outer join ci_ap_sug R ON R.id_or = Q.id_or ");
		sqlSB.append("  	 left outer join bd_psndoc S ON R.id_emp_helper = S.id_psndoc ");
		//过敏史
		sqlSB.append("       left outer join (select  bb.id_pat,wmsys.wm_concat(distinct TO_CHAR(TO_DATE( substr(aa.dt_act, 1, 10),'yyyy-MM-dd'),'yyyy-MM-dd') ||':'||  aa.name_alcla)as name_alcla from pi_pat_al aa inner join pi_pat bb on bb.id_pat=aa.id_pat group by  bb.id_pat) al ON al.id_pat = B.Id_Pat ");
		sqlSB.append(" where A.Id_or ");  //A.Id_or  id_or4sql

		sqlSB.append(id_or4sql);
		
//		SqlParam param = new SqlParam();
//		
//		param.addParam( ICiDictCodeTypeConst.ID_SU_BL_1 );
//		param.addParam( ICiDictCodeTypeConst.SD_SU_BL );
	
//		param.addParam( %1$s );
		
		
		return sqlSB.toString();
		
		
	}
	
	
	/**
	 * 门诊手术医嘱数据信息SQL串
	 * 仅门诊手术医嘱使用
	 */
	
	public String CiIeOropOpSql(String id_or4sql){
		
		StringBuilder sqlSB = new StringBuilder();
		
		sqlSB.append(" select (case when q.fg_er_sug ='Y' then 0 when q.fg_xq_sug ='Y' then 1  when q.fg_zq_sug='Y' then 2  end) as operationKind,"
				+ " (case when q.fg_er_sug ='Y' then '急症' when q.fg_xq_sug ='Y' then '限期'  when q.fg_zq_sug='Y' then '择期'  end) as operationKindName, "
				+ " al.name_alcla as allergy,card.code as healthcard_no,Q.Id_Apop as id_ieoporen,B.dt_birth as birthday,B.code as patient_id,A.Code_Or as yz_no,Q.NO_APPLYFORM as op_record_id,D.Code as op_code,D.Name as op_code_name,A.des_or as op_describe ");//yz_no 医嘱号 op_record_id申请单号
		sqlSB.append(" ,A.Dt_Entry as apply_date,E.code_ie as op_scale,E.name as op_scale_name,Q.Sd_Anestp as anaesthesia_method_code,F.Name as anaesthesia_method_name,c.code as p_bar_code	");
		sqlSB.append(" ,G.name as ward_code_name,G.Code as ward_code,H.NAME_BED as bed_no,B.Id_Code as social_no,S.Code as addition_no1,C.Name_Pat as name,C.Telno_Pat as home_tel,C.Sd_Sex_Pat as sex,C.Dt_Birth_Pat as birthday,'' as age ");
		sqlSB.append(" ,C.ADDR_PAT as home_street,I.code as patient_dept,I.name as patient_dept_name,K.orgcode as hospital_code,K.name as hospital_name,Q.Dt_Plan as op_datetime ");
		sqlSB.append(" ,L.Code as op_doctor,L.name as op_doctor_name,M.code as exec_code,M.name as exec_code_name,N.code as apply_user,N.name as apply_user_name ");
		sqlSB.append(" ,O.code as dept_code,O.name as dept_code_name,'' as check_date,'' as check_opera,'' as check_opera_name,A.fg_skintest as isstest,A.fg_skintest as stest ");
		sqlSB.append(" ,'03' as is_em,(case when A.Fg_Urgent='Y' then 'true'  else 'false' end) as is_em_r,'' as is_frozen_flag,'' as frozen_flag,'' as is_urgent_select_flag,'' as urgent_select_flag ");
		sqlSB.append(" ,Q.Announcements as comment1,(case when H.Times_Ip is null then 0 else H.Times_Ip end) +(case when J.Times_Op is null then 0 else J.Times_Op end) as admit_times,C.Dt_Entry  as visit_date,'' as response_type_code,'' as response_type_name ");
		sqlSB.append(" ,(case when P.FG_MAJDI='Y' then '12' when P.FG_MAJDI='N' then '13' else '' end) as diag_type,(case when P.FG_MAJDI='Y' then '主要诊断' when P.FG_MAJDI='N' then '次要诊断' else '' end) as diag_type_name,P.ID_DIDEF_CODE as diag_code,P.ID_DIDEF_NAME as diag_str,'' as isyg,'' as yg,'01' as domain_id ");
		sqlSB.append(" ,D.sd_iemsgca as iemsgca_code,(case when Z3.name='未记账' then '099' when Z3.name='已记账' then  P1.name end) as iemsgca_name");
		sqlSB.append(" ,C.code as visitOrdNo,(case when c.code_entp='00' then '01' when c.code_entp='10' then '03' end) as visitType,bd.name as visitTypeName,S.name as op_nurse_name,R.id_emp_helper as op_nurse_code ");
		sqlSB.append(" ,Q.Specialdes as Special_prepare , A.Id_or as Idor  ");
		sqlSB.append(" from ci_ap_sug Q left outer join ci_order A on Q.Id_Or=A.Id_Or ");
		sqlSB.append("       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
		//健康卡
		sqlSB.append("       left outer join pi_pat_card card ON A.Id_Pat=card.Id_Pat and card.fg_act='Y' and card.sd_patcardtp='05' ");//健康卡
		sqlSB.append("       left outer join pi_pat_cardtp cardtp ON cardtp.id_cardtp=card.id_patcardtp and cardtp.sd_patcardtp='05' ");
		sqlSB.append("       left outer join en_ent C ON A.Id_En=C.Id_Ent ");
		sqlSB.append("       left outer join bd_srv D ON Q.Id_Srv=D.Id_Srv ");
		sqlSB.append("       left outer join bd_udidoc P1 ON D.Id_iemsgca = P1.Id_Udidoc	 ");
		sqlSB.append("       left outer join bd_udidoc Z3 ON (Z3.id_udidoc = ? and Z3.id_udidoclist= ? )");
		sqlSB.append("       left outer join bd_udidoc E ON E.Id_Udidoc=Q.Id_Lvlsug ");
		sqlSB.append("       left outer join bd_udidoc F ON F.Id_Udidoc=Q.Id_Anestp ");
		sqlSB.append("       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur ");
		sqlSB.append("       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  ");
		sqlSB.append("       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy ");
		sqlSB.append("       left outer join en_ent_op J ON A.Id_En=J.Id_Ent ");
		sqlSB.append("       left outer join pi_pat_card S ON S.ID_PAT=B.Id_Pat and S.Sd_Patcardtp='04' ");
		sqlSB.append("       left outer join bd_org K ON A.Id_Org=K.Id_Org ");
		sqlSB.append("       left outer join bd_psndoc L ON L.Id_Psndoc=Q.Id_Emp_Operate ");
		sqlSB.append("       left outer join bd_dep M ON M.Id_Dep=A.Id_Dep_Mp ");
		sqlSB.append("       left outer join bd_psndoc N ON N.Id_Psndoc=A.Id_Emp_Or ");
		sqlSB.append("       left outer join bd_dep O ON O.Id_Dep=A.Id_Dep_Or ");
		sqlSB.append("       left outer join en_ent_di M1 ON A.Id_En = M1.Id_Ent ");//在检查医嘱属性表里ci_ap_sug存储的id_di是就诊诊断表en_ent_di里的ID_entdi，与其他诊断表里的ID_DI不一致，此处临时更改
		sqlSB.append("       left outer join ci_di_itm P ON m1.Id_Diitm=P.ID_DIITM ");
		sqlSB.append("  	 left outer join BD_ENTP BD ON C.CODE_ENTP = BD.CODE ");
		sqlSB.append("  	 left outer join ci_ap_sug R ON R.id_or = Q.id_or ");
		sqlSB.append("  	 left outer join bd_psndoc S ON R.id_emp_helper = S.id_psndoc ");
		//过敏史
		sqlSB.append("       left outer join (select  bb.id_pat,wmsys.wm_concat(distinct TO_CHAR(TO_DATE( substr(aa.dt_act, 1, 10),'yyyy-MM-dd'),'yyyy-MM-dd') ||':'||  aa.name_alcla)as name_alcla from pi_pat_al aa inner join pi_pat bb on bb.id_pat=aa.id_pat group by  bb.id_pat) al ON al.id_pat = B.Id_Pat ");
		sqlSB.append(" where M1.Fg_Maj='Y' and A.Id_or ");  //A.Id_or  id_or4sql

		sqlSB.append(id_or4sql);
		
//		SqlParam param = new SqlParam();
//		
//		param.addParam( ICiDictCodeTypeConst.ID_SU_BL_1 );
//		param.addParam( ICiDictCodeTypeConst.SD_SU_BL );
	
//		param.addParam( %1$s );
		
		
		return sqlSB.toString();
		
	}
	
	/**
	 * 查询手术医嘱信息
	 * @param id_or4sql
	 * @return
	 */
	public String IpSugInfoSql(String id_or4sql) {
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" select a.id_en as id_ent, "
				+ " (case when phy2.code='04' then '是' else '否' end) as is_breastfeeding,"
				+ " (case when phy.code='02' then '是' else '否' end) as is_pregnancy,(case when phy.code='02' then phy.sv else '' end) as pregnancy_date,"
				+ " A.Code_Or as yz_no,d.code_srv as Op_code,d.name as Op_code_name,L.Code as Operatorcode,L.name as Operatorname, ");
		sqlSB.append(" E.code as op_scale,E.name as op_scale_name ");
		sqlSB.append(" from ci_or_srv D " );
		sqlSB.append(" left outer join ci_order A ON d.id_or = a.id_or ");
		//是否哺乳、妊娠
		sqlSB.append(" left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
		sqlSB.append(" left join (select z0.id_pat,d0.code,z0.sv from pi_pat_phy z0 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind where d0.code='02') phy ON phy.Id_Pat = B.Id_Pat ");//--怀孕
		sqlSB.append(" left join (select z0.id_pat,d0.code from pi_pat_phy z0 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind where d0.code='04') phy2 on phy2.Id_Pat = B.Id_Pat  ");//--哺乳
		
		sqlSB.append(" left outer join ci_ap_sug Q on Q.Id_Or=A.Id_Or ");
		sqlSB.append(" left outer join bd_psndoc L ON L.Id_Psndoc=Q.Id_Emp_Operate");
		sqlSB.append(" left outer join bd_udidoc E ON E.Id_Udidoc=Q.Id_Lvlsug");
	    sqlSB.append(" left outer join en_ent C ON A.Id_En=C.Id_Ent ");
		sqlSB.append(" where d.fg_or = 'Y' and A.Id_Or ");
		sqlSB.append(id_or4sql);
		return sqlSB.toString();
	}
	
	/**
	 * 助手护士信息住院
	 * @param id_or4sql
	 * @return
	 */
	public String IpSugAssistInfoSql(String id_or4sql){
		
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append("select a.name as nursename ,a.code as nursecode ,c.name as nurserole  ");
		sqlSB.append("from bd_psndoc a,ci_ap_sug_emp b,bd_udidoc c,ci_ap_sug d,ci_order e ");
		sqlSB.append("where b.id_emp = Id_Psndoc ");
		sqlSB.append("and b.id_role = c.id_udidoc ");
		sqlSB.append("and d.id_apop= b.id_apop ");
		sqlSB.append("and d.id_or = e.id_or "); 
//		sqlSB.append("and c.name <> '主刀医师' and c.name like '%助手%' "); 
//		0147085: 【工单】【平台消息】住院BS007手术  
//		xml消息：
//		1.第一助手角色赋成了主刀医生
//		2.缺少相应的医护角色
		sqlSB.append("and c.code <> '00' "); 
		sqlSB.append("and e.id_or "); 
		sqlSB.append(id_or4sql); 
		return sqlSB.toString();
	}
	
	/**
	 * 门诊手术查询助手信息
	 */
	public String OpSugAssistInfoSql(String id_or4sql) {
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append("select a.name as nursename，a.code as nursecode  ,c.name as nurserole ");
		sqlSB.append("from bd_psndoc a,bd_udidoc c,ci_ap_sug d,ci_order e  ");
		sqlSB.append("where a.Id_Psndoc=d.id_emp_helper  ");
		sqlSB.append("and d.id_or = e.id_or ");
		sqlSB.append("and c.name <> '主刀医师' and c.name like '%第一助手%' ");
		sqlSB.append("and e.id_or ");
		sqlSB.append(id_or4sql); 
		return sqlSB.toString();
	}
	
}
