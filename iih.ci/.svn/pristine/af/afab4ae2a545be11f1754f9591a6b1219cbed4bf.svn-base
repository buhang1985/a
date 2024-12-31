package iih.ci.ord.s.bp.iemsg.qry.sql;

import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;

//集成平台  新 治疗类 SQL
public class Tre4IESql {

	
	/**
	 * 住院治疗医嘱信息SQL串
	 * 治疗处置
	 */
	public static String CiIeOrtreatItmSql(){
		StringBuilder sqlSB = new StringBuilder();

		/*sqlSB.append(" select A1.Id_Orsrv as id_ietreator,A.Id_En as id_ietreatoren,A.Code_Or as zl_no,A1.Id_Orsrv as order_code,D.Code as order_type_code,D.Name as order_type_name,A1.NOTE_SRV as yz_memo,E.Code as yz_code,E.Name as yz_name,F.Name as bz_no, ");
		sqlSB.append(" A1.Quan_Medu as yz_unit,F.Name as yz_unit_code,G.code as fre_no,G.name as fre_name,I.code as yz_ward_code,I.name as yz_ward_name,G.code as yz_dept_code,G.name as yz_dept_name,A.Dt_Entry as yz_date,J.Code as yz_doctor_code,J.Name as yz_doctor_name, ");
		sqlSB.append(" A.Dt_Chk as yz_confirm_date,K.code as yz_confirm_doctor_code,K.name as yz_confirm_doctor_name,L.code as exe_dept_code,L.name as exe_dept_name,'' as f_order_code,'' as hc_order_type_code,'' as hc_order_type_name, ");
		sqlSB.append(" A.Dt_Effe as yz_start_time,A.Dt_End as yz_stop_time,A1.Fg_Indic as is_sy,(case when A1.Fg_Indic='Y' then 'true' when A1.Fg_Indic='N' then 'false' else '' end) as is_syresult,(case when G.Sd_Frequnitct='0' and G.Code='ST' then 'Y' else 'N' end) as is_jj, ");
		sqlSB.append(" (case when A.Fg_Urgent='Y' then 'true' when A.Fg_Urgent='N' then 'false' else '' end) as is_jjresult,'' as is_yg,'' as is_ygresult,M.Code as yb_type_code,M.name as yb_type_name,'' as jt,'' as fybj_code,'' as fybj_name ");
	
		sqlSB.append(" from ci_or_srv A1 left outer join ci_order A  ON A1.Id_Or=A.Id_Or ");
		
		sqlSB.append("      left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
		sqlSB.append("      left outer join en_ent C ON A.Id_En=C.Id_Ent ");
		sqlSB.append("      left outer join bd_srvca D ON A1.Id_Srvca=D.Id_Srvca ");
		sqlSB.append("      left outer join bd_srv E ON E.Id_Srv=A1.Id_Srv ");
		sqlSB.append("      left outer join bd_measdoc F ON F.Id_Measdoc=A1.Id_Medu ");
		sqlSB.append("      left outer join bd_freq G ON G.Id_Freq=A1.Id_Freq ");
		sqlSB.append("      left outer join bd_dep H ON H.Id_Dep=C.Id_Dep_Phy ");
		sqlSB.append("      left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Nur ");
		sqlSB.append("      left outer join bd_psndoc J ON J.Id_Psndoc=A1.Id_Emp_Srv ");
		sqlSB.append("      left outer join bd_dep L ON L.Id_Dep=A1.Id_Dep_Mp ");
		sqlSB.append("      left outer join bd_udidoc M ON M.id_udidoc=A1.Id_Hpsrvtp	");
	
		sqlSB.append(" where A.id_or=? and A1.Fg_or='Y'" );*/  //A1.Id_or
		sqlSB.append("select A1.Id_Orsrv as id_ietreator,A.Id_En as id_ietreatoren,A1.id_pres as order_no,A.code_or as yz_no,");
		sqlSB.append("D.Code as order_type,D.Name as order_type_name,A1.Note_Srv as yz_comment,E.Code as yz_code,E.Name as yz_name,F.Name as pack_serial, ");
		sqlSB.append("A.Quan_Medu as charge_amount,F.Name as spe_external,G.code as freq_code,G.name as freq_code_name,H.code as yz_olddept_code,H.name as yz_olddept_name,");
	    sqlSB.append("I.code as yz_oldward_code,I.name as yz_oldward_name,A.Dt_Entry as enter_date,J.Code as doctor_code,J.Name as doctor_name, ");
	    sqlSB.append("A.Dt_Sign as confirm_date,K.code as confirm_opera,K.name as confirm_opera_name,L.code as exec_sn,L.Name as exec_name,A1.Id_Orsrv as parent_no, ");
	    sqlSB.append("'' as incompatibleyz_no,'' as incompatibleyz_type_code,A.Dt_Effe as begin_time,A.Dt_End as end_time,M.Code as charge_gourp,M.Name as charge_group_name_external,'' as comment1,'' as sginfee_code,'' as sginfee_name, ");
	    sqlSB.append("A1.Fg_Skintest as is_ps,(case when A1.Fg_Skintest='Y' then 'true' when A1.Fg_Skintest='N' then 'false' else '' end) as is_psresult, ");
	    sqlSB.append("A1.Fg_Indic as is_syz,(case when A1.Fg_Indic='Y' then 'true' when A1.Fg_Indic='N' then 'false' else '' end) as is_syzresult, ");
        sqlSB.append("(case when G.Sd_Frequnitct='0' and G.Code='ST' then 'Y' else 'N' end) as is_jj,(case when A.Fg_Urgent='Y' then '加急' when A.Fg_Urgent='N' then '非加急' else '' end) as is_jjresult, ");
        //添加就诊次数 begin 2017-06-28 10:53:34);
        sqlSB.append("(case when H1.Times_Ip is null then 0 else H1.Times_Ip end) +(case when J1.Times_Op is null then 0 else J1.Times_Op end) as admiss_times, ");
        sqlSB.append("'' as is_yg,'' as is_ygresult,null as route_code,null as route_no ");
	    sqlSB.append("    from ci_or_srv A1 left outer join ci_order A ON A1.Id_Or=A.Id_Or ");
	    sqlSB.append("      left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
	    sqlSB.append("      left outer join en_ent C ON A.Id_En=C.Id_Ent ");
	    sqlSB.append("      left outer join bd_srv E ON E.Id_Srv=A1.Id_Srv ");
	    sqlSB.append("      left outer join bd_srvca D ON E.Id_Srvca=D.Id_Srvca ");
	    sqlSB.append("      left outer join bd_measdoc F ON F.Id_Measdoc=A1.Id_Medu ");
	    sqlSB.append("      left outer join bd_freq G ON G.Id_Freq=A1.Id_Freq ");
	    sqlSB.append("      left outer join bd_dep H ON H.Id_Dep=C.Id_Dep_Phy ");
	    sqlSB.append("      left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Nur ");
	    sqlSB.append("      left outer join bd_psndoc J ON J.Id_Psndoc=A1.Id_Emp_Srv ");
	    sqlSB.append("      left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Sign ");
	    sqlSB.append("      left outer join bd_dep L ON L.Id_Dep=A1.Id_Dep_Mp ");
	    sqlSB.append("      left outer join bd_udidoc M ON M.id_udidoc=A1.Id_Hpsrvtp ");
	   //添加就诊次数  处方序号 begin 2017-06-28 10:54:05);
	    sqlSB.append("      left outer join en_ent_ip H1 ON C.Id_Ent=H1.Id_Ent  ");
	    sqlSB.append("      left outer join en_ent_op J1 ON A.Id_En=J1.Id_Ent ");
//	   sqlSB.append("	   left outer join ci_pres C1 ON A1.id_pres =C1.id_pres"
   	    sqlSB.append("      where ? and A1.Fg_or='Y'" );
		
//			param.addParam( %1$s );
		
		
		return sqlSB.toString();
		
	}
	
	/**
	 * 门诊治疗医嘱就诊信息SQL串 20170517yjb
	 * 治疗处置
	 */
	 
	public String CiIeOrtreatItmOpSql(){
		
		StringBuilder sqlSB = new StringBuilder();
		
		sqlSB.append("select A1.Id_Orsrv as id_ietreator,A.Id_En as id_ietreatoren,A1.id_pres as order_no,a.code_or as yz_no,");
		sqlSB.append("D.Code as order_type,D.Name as order_type_name,A1.Note_Srv as yz_comment,E.Code as yz_code,E.Name as yz_name,F.Name as pack_serial, ");
		sqlSB.append("A1.Quan_Total_Medu as charge_amount,F.Name as spe_external,G.code as freq_code,G.name as freq_code_name,H.code as yz_olddept_code,H.name as yz_olddept_name,");
		sqlSB.append("I.code as yz_oldward_code,I.name as yz_oldward_name,A.Dt_Entry as enter_date,J.Code as doctor_code,J.Name as doctor_name, ");
		sqlSB.append("A.Dt_Sign as confirm_date,K.code as confirm_opera,K.name as confirm_opera_name,L.code as exec_sn,L.Name as exec_name,A1.Id_Orsrv as parent_no, ");
		sqlSB.append("'' as incompatibleyz_no,'' as incompatibleyz_type_code,A.Dt_Effe as begin_time,A.Dt_End as end_time,M.Code as charge_gourp,M.Name as charge_group_name_external,A.des_or as comment1,'' as sginfee_code,'' as sginfee_name, ");
		sqlSB.append("A1.Fg_Skintest as is_ps,(case when A1.Fg_Skintest='Y' then 'true' when A1.Fg_Skintest='N' then 'false' else '' end) as is_psresult, ");
		sqlSB.append("A1.Fg_Indic as is_syz,(case when A1.Fg_Indic='Y' then 'true' when A1.Fg_Indic='N' then 'false' else '' end) as is_syzresult, ");
		  //添加就诊次数 begin 2017-06-28 10:53:34
		sqlSB.append("(case when G.Sd_Frequnitct='0' and G.Code='ST' then 'Y' else 'N' end) as is_jj,(case when A.Fg_Urgent='Y' then '加急' when A.Fg_Urgent='N' then '非加急' else '' end) as is_jjresult, ");
		sqlSB.append("   (case when H1.Times_Ip is null then 0 else H1.Times_Ip end) +(case when J1.Times_Op is null then 0 else J1.Times_Op end) as admiss_times, ");
		 //end
		sqlSB.append("'' as is_yg,'' as is_ygresult,null as route_code,null as route_no,A1.sortno as Orderseqnum, ");
		//sqlSB.append("C.code as Visitordno,(case when C.code_entp='00' then '01' when C.code_entp='10' then '03' end) as Visittype,BD.name as  Visittypemame,'1' as Orderseqnum,");
		sqlSB.append("(case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as Ordertimetypename,(case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as Ordertimetype,Z3.name as payflag ");
		sqlSB.append("    from ci_or_srv A1 left outer join ci_order A ON A1.Id_Or=A.Id_Or ");
		sqlSB.append("      left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
		sqlSB.append("      left outer join en_ent C ON A.Id_En=C.Id_Ent ");
		sqlSB.append("      left outer join bd_srv E ON E.Id_Srv=A1.Id_Srv ");
		sqlSB.append("      left outer join bd_srvca D ON E.Id_Srvca=D.Id_Srvca ");
		sqlSB.append("      left outer join bd_measdoc F ON F.Id_Measdoc=A1.Id_Medu ");
		sqlSB.append("      left outer join bd_freq G ON G.Id_Freq=A1.Id_Freq ");
		sqlSB.append("      left outer join bd_dep H ON H.Id_Dep=C.Id_Dep_Phy ");
		sqlSB.append("      left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Nur ");
		sqlSB.append("      left outer join bd_psndoc J ON J.Id_Psndoc=A1.Id_Emp_Srv ");
		sqlSB.append("      left outer join bd_psndoc K ON K.Id_Psndoc=A.Id_Emp_Sign ");
		sqlSB.append("      left outer join bd_dep L ON L.Id_Dep=A1.Id_Dep_Mp ");
		sqlSB.append("      left outer join bd_udidoc M ON M.id_udidoc=A1.Id_Hpsrvtp ");
		sqlSB.append("		left outer join BD_ENTP BD ON C.CODE_ENTP = BD.CODE ");
		  //添加就诊次数  处方序号 begin 2017-06-28 10:54:05

		sqlSB.append("      left outer join en_ent_ip H1 ON C.Id_Ent=H1.Id_Ent  ");
		sqlSB.append("      left outer join en_ent_op J1 ON A.Id_En=J1.Id_Ent ");
		  //end
		sqlSB.append("	    left outer join bd_udidoc Z3 ON (Z3.id_udidoc ='"+ICiDictCodeTypeConst.ID_SU_BL_1+"'and Z3.id_udidoclist='"+ICiDictCodeTypeConst.SD_SU_BL+"') ");

		sqlSB.append("      where A.id_or in (%s) and A1.Fg_or='Y'");
		
//		SqlParam param = new SqlParam();
//		param.addParam( %1$s );

		return sqlSB.toString();
		
	}
	
	
	
	/**
	 * 住院医嘱核对确认数据信息SQL串
	 * 其它医嘱
	 */
	public String CiIeOrtreatConfirmOpSql(){
		StringBuilder sqlSB = new StringBuilder();
         
		sqlSB.append("select A.Id_En as id_ietreatoren,'' as ietreatfees,B.code as patient_id,c.code as p_bar_code, ");
		sqlSB.append(" C.Name_Pat as name,C.Sd_Sex_Pat as sex,'' as age,B.DT_BIRTH_HMS as birthday,I.code as apply_unit,I.name as apply_unit_name, ");
		sqlSB.append(" (case when H.Times_Ip is null then 0 else H.Times_Ip end)+(case when J.Times_Op is null then 0 else J.Times_Op end) as admiss_times, ");
		sqlSB.append(" G.code as ward_code,G.Name as ward_code_name,H.NAME_BED as bed_no,A.Dt_Chk as confrim_date, ");
		sqlSB.append(" R.Code as confirm_opera,R.Name as confrim_opera_name,'01' as domain_id,D.orgcode as orgcode,D.name as orgname, ");
		sqlSB.append(" C.code as Visitordno, (case when C.code_entp='00' then '01' when C.code_entp='10' then '03' end) as Visittype,BD.name as Visittypename,");
		sqlSB.append("  L.code as exec_sn,M.code as apply_code ");
		//sqlSB.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as Ordertimetypename, ");
		//sqlSB.append(" (case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as Ordertimetype "); 
		sqlSB.append(" from ci_order A ");
		sqlSB.append("       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
		sqlSB.append("       left outer join en_ent C ON A.Id_En=C.Id_Ent ");
		sqlSB.append("       left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  ");
		sqlSB.append("       left outer join en_ent_op J ON A.Id_En=J.Id_Ent ");
		sqlSB.append("       left outer join bd_dep G ON G.Id_Dep=C.Id_Dep_Nur ");
		sqlSB.append("       left outer join bd_dep I ON I.Id_Dep=C.Id_Dep_Phy ");
		sqlSB.append("       left outer join bd_psndoc R ON R.Id_Psndoc=A.Id_Emp_Chk ");
		sqlSB.append("       left outer join bd_org D ON D.Id_org=A.Id_org ");
		sqlSB.append("  	 left outer join BD_ENTP BD ON C.CODE_ENTP = BD.CODE ");
		//执行科室
		sqlSB.append("       left outer join bd_dep L ON L.Id_Dep=A.Id_Dep_Mp ");
		//申请科室
		sqlSB.append("       left outer join bd_dep M ON M.Id_Dep=A.Id_Dep_Or ");
		sqlSB.append(" where A.id_or in (%s) " );
		
		
		return sqlSB.toString();
		
		
	}
}
