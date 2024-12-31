package iih.ci.ord.s.bp.iemsg.qry.sql;

import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 集成平台  药品类(包含草药，西药) 新 SQL
 * 
 */
public class Drug4IESql {
	/**
	 * 西成药医嘱数据信息SQL串  -------------------------------------------------------------------
	 */
	public String CiIeOrdrugwcSql(){
	
		StringBuilder sqlSB = new StringBuilder();
		
		sqlSB.append(" select A.Id_Or as id_iepharmwcor,A.Id_En as id_iepharmoren,A.code_or as xy_zcy_order_code,");
		sqlSB.append(" A3.Code as xy_zcy_order_type_code,A3.name as xy_zcy_order_type_name,A.Des_Or as xy_zcy_yz_memo,A4.Code as xy_zcy_fre_code,");
		sqlSB.append(" A4.name as xy_zcy_fre_name,A5.Code as xy_zcy_yytj_code,A5.Name as xy_zcy_yytj_name,A1.Quan_Medu as xy_zcy_cjl,A6.Name as xy_zcy_cjlunit,");
		sqlSB.append(" A2.Quan_Cur as xy_zcy_zyl,A7.Name as xy_zcy_zylunit,A9.Code as xy_zcy_yz_old_dept_code,A9.Name as xy_zcy_yz_old_dept_name,");
		sqlSB.append(" A10.Code as xy_zcy_yz_old_ward_code,A10.name as xy_zcy_yz_old_ward_name,A2.Code_Mm as xy_zcy_yw_code,");
		sqlSB.append(" (case when Z1.CODE='1000' then '00' when Z1.CODE='1001' THEN '01' ELSE '' END ) as xy_zcy_bz_no,A1.Sd_Hpsrvtp as xy_zcy_yw_yb_code,A12.name as xy_zcy_yw_yb_name,A.Dt_Entry as xy_zcy_yz_date,");
		sqlSB.append(" A13.code as xy_zcy_yz_doctor_no,A13.Name as xy_zcy_yz_doctor_name,A.Dt_Sign as xy_zcy_yz_confirm_date,A14.Code as xy_zcy_yz_confirm_code,");
		sqlSB.append(" A14.Name as xy_zcy_yz_confirm_name,A15.Code as xy_zcy_exe_dept_code,A15.Name as xy_zcy_exe_dept_name,A.Id_Or as xy_zcy_f_order_no,");
		sqlSB.append(" (select p.sd_reacttp from bd_srv_react p inner join bd_srv_react_itm q on p.id_srvreact=q.id_srvreact where q.id_srv=A1.Id_Srv) as xy_zcy_hc_order_type_code,");
		sqlSB.append(" '' as xy_zcy_hc_order_type_name,'' as xy_zcy_fybj_code,");
		sqlSB.append(" '' as xy_zcy_fybj_name,A1.NOTE_SRV as xy_zcy_jt,A1.Fg_Indic as xy_zcy_is_sy,(case when A1.Fg_Indic='Y' then '适应' else '非适应' end) as xy_zcy_is_syresult,A1.Fg_Skintest as xy_zcy_is_ps,");
		sqlSB.append(" (case when A1.FG_SKINTEST_RST='Y' then (select t1.name from ci_skin_test t left outer join bd_udidoc t1 on t.id_rst_skintest=t1.id_udidoc where id_or=A1.Id_Or)  else '' end) as xy_zcy_is_psresult,");
		sqlSB.append(" (case when A4.Sd_Frequnitct='0' and A4.Code='ST' then 'Y' else 'N' end) as xy_zcy_is_jj,'' as xy_zcy_is_jjresult,null as xy_zcy_is_yg,null as xy_zcy_is_ygresult,");
		sqlSB.append(" null as xy_zcy_lyl,null as xy_zcy_lylunit,A1.Dt_Last_Mp as xy_zcy_exe_date,A.Dt_End as xy_zcy_stop_date,A.Orders as cy_fs_count,null as cy_fs_unit,null as route_code,null as route_no ");
		
		sqlSB.append(" from ci_order A ");
		
		sqlSB.append("      inner join ci_or_srv A1 ON A.Id_Or=A1.Id_Or");
		sqlSB.append("      left outer join ci_or_srv_mm A2 ON A1.Id_Orsrv=A2.Id_Orsrv");
		sqlSB.append("      left outer join bd_udidoc A3 ON A.Id_Srvtp=A3.Id_Udidoc");
		sqlSB.append("      left outer join bd_freq A4 ON A.Id_Freq=A4.Id_Freq");
		sqlSB.append("      left outer join bd_route A5 ON A.Id_Route=A5.id_route");
		sqlSB.append("      left outer join bd_measdoc A6 ON A1.Id_Medu=A6.Id_Measdoc");
		sqlSB.append("      left outer join bd_measdoc A7 ON A2.Id_Pgku_Cur=A7.Id_Measdoc");
		sqlSB.append("      left outer join en_ent A8 ON A.Id_En=A8.Id_Ent");
		sqlSB.append("      left outer join bd_dep A9 ON A8.Id_Dep_Phy=A9.Id_Dep");
		sqlSB.append("      left outer join bd_dep A10 ON A8.Id_Dep_Nur=A10.Id_Dep");
		sqlSB.append("      left outer join bd_mm A11 ON A2.Id_Mm=A11.Id_Mm");
		sqlSB.append("      left outer join bd_udidoc A12 ON A1.Id_Hpsrvtp=A12.Id_Udidoc");
		sqlSB.append("      left outer join bd_psndoc A13 ON A.Id_Emp_Or=A13.Id_Psndoc");
		sqlSB.append("      left outer join bd_psndoc A14 ON A.Id_Emp_Sign=A14.Id_Psndoc");
		sqlSB.append("      left outer join bd_dep A15 ON A1.Id_Dep_Mp=A15.Id_Dep");
		sqlSB.append("      LEFT OUTER JOIN CI_OR_SRV_MM Y ON A1.ID_ORSRV=Y.ID_ORSRV ");
		sqlSB.append("      LEFT OUTER JOIN BD_MM_PKGU Z ON (Z.ID_MM = Y.ID_MM AND Z.ID_UNIT_PKG=Y.ID_PGKU_CUR) ");
		sqlSB.append("      LEFT OUTER JOIN BD_MM_PKGUTP Z1 ON Z.ID_MMPKGUTP=Z1.ID_MMPKGUTP ");
		sqlSB.append(" where A1.Fg_Or='Y' and ? order by A1.Id_Or,A1.Sortno");
	
       SqlParam param = new SqlParam();
       
  //   param.addParam( %1$s );
     
		return sqlSB.toString();
		
		
		
	}
	
	
	/**
	 * 草药医嘱数据信息SQL串     -------------------------------------------------------------------
	 */
	
	public String CiIeOrdrugherbSql(){
		
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" select A.Id_Or as id_iepharmor,A.Id_En as id_iepharmoren,A.code_or as xy_zcy_order_code,");
		sqlSB.append(" A3.Code as xy_zcy_order_type_code,A3.name as xy_zcy_order_type_name,A.Des_Or as xy_zcy_yz_memo,A4.Code as xy_zcy_fre_code,");
		sqlSB.append(" A4.name as xy_zcy_fre_name,A5.Code as xy_zcy_yytj_code,A5.Name as xy_zcy_yytj_name,null as xy_zcy_cjl,null as xy_zcy_cjlunit,");
		sqlSB.append(" null as xy_zcy_zyl,null as xy_zcy_zylunit,A9.Code as xy_zcy_yz_old_dept_code,A9.Name as xy_zcy_yz_old_dept_name,");
		sqlSB.append(" A10.Code as xy_zcy_yz_old_ward_code,A10.name as xy_zcy_yz_old_ward_name,null as xy_zcy_yw_code,");
		sqlSB.append(" (case when Z1.CODE='1000' then '00' when Z1.CODE='1001' THEN '01' ELSE '' END ) as xy_zcy_bz_no,null as xy_zcy_yw_yb_code,null as xy_zcy_yw_yb_name,A.Dt_Entry as xy_zcy_yz_date,");
		sqlSB.append(" A13.code as xy_zcy_yz_doctor_no,A13.Name as xy_zcy_yz_doctor_name,A.Dt_Sign as xy_zcy_yz_confirm_date,A14.Code as xy_zcy_yz_confirm_code,");
		sqlSB.append(" A14.Name as xy_zcy_yz_confirm_name,A15.Code as xy_zcy_exe_dept_code,A15.Name as xy_zcy_exe_dept_name,null as xy_zcy_f_order_no,");
		sqlSB.append(" null as xy_zcy_hc_order_type_code,'' as xy_zcy_hc_order_type_name,'' as xy_zcy_fybj_code,");
		sqlSB.append(" '' as xy_zcy_fybj_name,null as xy_zcy_jt,null as xy_zcy_is_sy,null as xy_zcy_is_syresult,'N' as xy_zcy_is_ps,");
		sqlSB.append(" '' as xy_zcy_is_psresult,(case when A4.Sd_Frequnitct='0' and A4.Code='ST' then 'Y' else 'N' end) as xy_zcy_is_jj,'' as xy_zcy_is_jjresult,null as xy_zcy_is_yg,null as xy_zcy_is_ygresult,");
		sqlSB.append(" null as xy_zcy_lyl,null as xy_zcy_lylunit,A.Dt_Last_Mp as xy_zcy_exe_date,A.Dt_End as xy_zcy_stop_date,A.Orders as cy_fs_count,'付' as cy_fs_unit");
		
		sqlSB.append(" from ci_order A " );
		
		sqlSB.append("      left outer join bd_udidoc A3 ON A.Id_Srvtp=A3.Id_Udidoc");
		sqlSB.append("      left outer join bd_freq A4 ON A.Id_Freq=A4.Id_Freq   ");
		sqlSB.append("      left outer join bd_route A5 ON A.Id_Route=A5.id_route");
		sqlSB.append("      left outer join en_ent A8 ON A.Id_En=A8.Id_Ent");
		sqlSB.append("      left outer join bd_dep A9 ON A8.Id_Dep_Phy=A9.Id_Dep");
		sqlSB.append("      left outer join bd_dep A10 ON A8.Id_Dep_Nur=A10.Id_Dep ");
		sqlSB.append("      left outer join bd_psndoc A13 ON A.Id_Emp_Or=A13.Id_Psndoc");
		sqlSB.append("      left outer join bd_psndoc A14 ON A.Id_Emp_Sign=A14.Id_Psndoc");
		sqlSB.append("      left outer join bd_dep A15 ON A.Id_Dep_Mp=A15.Id_Dep");
		sqlSB.append("      left outer join ci_or_srv A1 ON A.id_or=A1.id_or");
		sqlSB.append("      LEFT OUTER JOIN CI_OR_SRV_MM Y ON A1.ID_ORSRV=Y.ID_ORSRV");
		sqlSB.append("      LEFT OUTER JOIN BD_MM_PKGU Z ON (Z.ID_MM = Y.ID_MM AND Z.ID_UNIT_PKG=Y.ID_PGKU_CUR)");
		sqlSB.append("      LEFT OUTER JOIN BD_MM_PKGUTP Z1 ON Z.ID_MMPKGUTP=Z1.ID_MMPKGUTP");
		
		sqlSB.append(" where ？ ");

		SqlParam param = new SqlParam();
		
	//	param.addParam( %1$s );
		
		return sqlSB.toString();
	}
	
	/**
	 * 草药医嘱对应药品数据信息SQL串   -------------------------------------------------------------------
	 */
	public String CiIeOrdrugherbMmSql(){
		
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" select A2.ID_ORSRVMM as id_iepharmormm,A1.Id_Or as id_iepharmor,A2.QUAN_CUR as cy_weight,");
		sqlSB.append(" B1.Name as cy_weightunit,A2.Code_Mm as cy_yp_code,'' as cy_bz_no,B2.Code as cy_tsyf_code,B2.Name as cy_tsyf,");
		sqlSB.append(" 'false' as cy_fswgbj,'' as cy_fswgbj_result,A1.Sd_Hpsrvtp as cy_ywyb_type_code,B3.Name as cy_ywyb_type_name");
		
		sqlSB.append(" from ci_or_srv A1");
		
		sqlSB.append("      left outer join ci_or_srv_mm A2 ON A1.Id_Orsrv=A2.Id_Orsrv");
		sqlSB.append("      left outer join bd_measdoc B1 ON A2.Id_Pgku_Cur=B1.Id_Measdoc");
		sqlSB.append("      left outer join bd_boil_des B2 ON A1.Id_Boildes=B2.Id_Boildes");
		sqlSB.append("      left outer join bd_udidoc B3 ON A1.Id_Hpsrvtp=B3.Id_Udidoc");
		
		sqlSB.append(" where ? and A1.Fg_Or='Y' order by A1.ID_OR,A1.Sortno");

		SqlParam param = new SqlParam();
		
		//param.addParam( %1$s );

		return sqlSB.toString();
		
	}
	
	
	/**
	 * 门诊药品医嘱就诊信息SQL串    -------------------------------------------------------------------
	 * 仅门诊药品用   代理人信息得单独求取
	 * CI_IE_ORPHARM_OP_CONFIRM_SQL
	 */
	public String CiIeOrpharmOpConfirmSql(){
		
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append("select l.code as applydeptcode,A.id_en as id_iepharmoren,B.code as patientid,c.code as p_bar_code,F.Times_Op as times, ");
		sqlSB.append("D.CODE as dept_code,D.Name as deptname,J.orgcode as orgcode,J.name as orgname,");
		sqlSB.append("C.Name_Pat as patientname,C.Sd_Sex_Pat as sex,C.Dt_Birth_Pat as birthday,'' as age, ");
		sqlSB.append("ag.sd_conttp as relationcode,doc.name as relationname,ag.idno_agent as dbsocialid,ag.name_agent as dbname,E.Code as responsetypecode,E.Name as responsetypename, ");
		sqlSB.append("H.Code as insurrancecode,H.Name as insurrancetype,I.Code as insurranceno, ");
		sqlSB.append("C.code as visitordno,(case when C.code_entp='00' then '01' when C.code_entp='10' then '03' end ) as visitTypeCode,BD.name as visittypename");
		sqlSB.append(" from ci_order A ");
		
		sqlSB.append("       left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
		sqlSB.append("       left outer join en_ent C ON A.Id_En=C.Id_Ent ");
		sqlSB.append("       left outer join bd_dep D ON C.Id_Dep_Phy=D.ID_DEP ");
		sqlSB.append("       left outer join en_ent_op F ON C.Id_Ent=F.Id_Ent ");
		sqlSB.append("       left outer join pi_pat_ca E ON E.Id_Patca=B.Id_Paticate ");
		sqlSB.append("       left outer join bd_hp G ON G.Id_Hp=C.Id_Hp ");
		sqlSB.append("       left outer join (select * from bd_udidoc where id_udidoclist='@@@@ZZ200000000000A2' ) H ON H.Code=G.Sd_Hptp ");
		sqlSB.append("       left outer join bd_cust I ON I.ID_CUST=G.ID_CUST ");
		sqlSB.append("       left outer join bd_org J ON J.ID_ORG=A.ID_ORG "	);
		sqlSB.append("       left outer join BD_ENTP BD ON C.CODE_ENTP = BD.CODE ");
		sqlSB.append("   left join ci_orsrv_agent ag on ag.id_or = a.id_or    ");
		sqlSB.append("   left join bd_udidoc doc on doc.id_udidoc = ag.id_conttp    ");
		sqlSB.append("   left outer join bd_dep L ON A.Id_Dep_Or = L.ID_DEP");
		sqlSB.append(" where A.id_or=?");
		
       //  SqlParam param = new SqlParam();
        
       // param.addParam(param);
		
		return sqlSB.toString();
	}
	
	
	/**
	 * 就诊单元门诊药品处方数据信息SQL串   -------------------------------------------------------------------
	 * 仅门诊药品用 
	 * CI_IE_ORPHARM_OP_PRES8IDEN_SQL
	 */
	public String CiIeOrpharmOpPres8idenSql(){
		StringBuilder sqlSB = new StringBuilder();
		
		sqlSB.append("select A.ID_PRES as id_iepharmpres,A.Id_En as id_iepharmoren,null as id_iepharmwcors,A.code||'_'||A.id_pres as orderno , "); //A.Code as orderno  | F.code||'_'||G.times_op||'_'||A.SD_PRESTP||'_'||A.code as orderno
		//sqlSB.append("select A.ID_PRES as id_iepharmpres,A.Id_En as id_iepharmoren,null as id_iepharmwcors,H.id_or as orderno , "); //A.Code as orderno  | F.code||'_'||G.times_op||'_'||A.SD_PRESTP||'_'||A.code as orderno
		sqlSB.append("A.Sd_Prestp as ordertypecode,B.name as ordertypename,C.Code as doctorcode,C.Name as doctorname,A.Dt_Entry as ordertime, ");
		sqlSB.append("D.Code as deptcode,D.Name as deptname,E.code as checkdoctorcode,E.name as checkdoctorname,A.Dt_Entry as checktime ");
		
		sqlSB.append(" from  ci_pres A ");
		
		sqlSB.append("       left outer join bd_udidoc B ON B.Id_Udidoc=A.Id_Prestp ");
		sqlSB.append("       left outer join bd_psndoc C ON C.Id_Psndoc=A.Id_Emp_Or ");
		sqlSB.append("       left outer join bd_dep D ON D.Id_Dep=A.Id_Dep_Or ");
		sqlSB.append("       left outer join bd_psndoc E ON A.Id_Emp=E.Id_Psndoc ");
		sqlSB.append("		 left outer join pi_pat F ON F.id_pat = A.id_pati");
		sqlSB.append("       left outer join en_ent_op G ON A.Id_En=G.Id_Ent ");
		//sqlSB.append("       left outer join ci_or_srv H ON A.id_pres=H.id_pres ");
		sqlSB.append("       where A.Id_Pres in (select distinct p.id_pres  from ci_or_srv p where p.id_or in (select id_or from ci_order where id_en= ? and fg_sign='Y' and fg_canc='N' and sd_srvtp like '01%')  ");
		//sqlSB.append("       where A.Id_Pres in (select distinct p.id_pres  from ci_or_srv p where p.id_or in (select id_or from ci_order where id_en= ? and id_or = ? and fg_sign='Y' and fg_canc='N' and sd_srvtp like '01%')  ");
		//sqlSB.append("       where A.Id_Pres in (select distinct p.id_pres  from ci_or_srv p where p.id_or in (%s)");
		sqlSB.append("		 and p.id_su_bl in(?,?) )");

		return sqlSB.toString();
		
	}
	/**
	 * BS302 查询处方金额
	 * @return
	 */
	public String CiIeOrpharmOpPres8idenPriceSql() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" sum(round(mm.quan_cur * mm.price_pgku_cur,2)) as prescriptionMoney, ");//处方金额
		stringBuilder.append(" '元' as prescriptionmoneyunit, ");//处方金额单位
		stringBuilder.append(" srv.id_pres as id_iepharmpres ");//处方id
		stringBuilder.append(" from ci_or_srv srv ");
		stringBuilder.append(" left join ci_or_srv_mm mm on srv.id_orsrv =mm.id_orsrv ");
		stringBuilder.append(" left join ci_order ord on ord.id_or=srv.id_or ");
		stringBuilder.append(" where srv.id_en =? and ord.fg_sign='Y' and ord.fg_canc = 'N' "
				+ " and ord.sd_srvtp like '01%' and srv.id_su_bl in (?,?) ");
		stringBuilder.append(" group by srv.id_pres ");
		return stringBuilder.toString();
	}
	/**
	 * 就诊单元门诊药品处方数据信息SQL串   -------------------------------------------------------------------
	 * 仅门诊药品用 
	 * CI_IE_ORPHARM_OP_PRES8IDEN_SQL
	 */
	public String CiIeOrpharmOpCanclePres8idenSql(){
		StringBuilder sqlSB = new StringBuilder();
		
		sqlSB.append("select A.ID_PRES as id_iepharmpres,A.Id_En as id_iepharmoren,null as id_iepharmwcors,A.code||'_'||A.id_pres as orderno , "); //A.Code as orderno  | F.code||'_'||G.times_op||'_'||A.SD_PRESTP||'_'||A.code as orderno
		//sqlSB.append("select A.ID_PRES as id_iepharmpres,A.Id_En as id_iepharmoren,null as id_iepharmwcors,H.id_or as orderno , "); //A.Code as orderno  | F.code||'_'||G.times_op||'_'||A.SD_PRESTP||'_'||A.code as orderno
		sqlSB.append("A.Sd_Prestp as ordertypecode,B.name as ordertypename,C.Code as doctorcode,C.Name as doctorname,A.Dt_Entry as ordertime, ");
		sqlSB.append("D.Code as deptcode,D.Name as deptname,E.code as checkdoctorcode,E.name as checkdoctorname,A.Dt_Entry as checktime ");
		
		sqlSB.append(" from  ci_pres A ");
		
		sqlSB.append("       left outer join bd_udidoc B ON B.Id_Udidoc=A.Id_Prestp ");
		sqlSB.append("       left outer join bd_psndoc C ON C.Id_Psndoc=A.Id_Emp_Or ");
		sqlSB.append("       left outer join bd_dep D ON D.Id_Dep=A.Id_Dep_Or ");
		sqlSB.append("       left outer join bd_psndoc E ON A.Id_Emp=E.Id_Psndoc ");
		sqlSB.append("		 left outer join pi_pat F ON F.id_pat = A.id_pati");
		sqlSB.append("       left outer join en_ent_op G ON A.Id_En=G.Id_Ent ");
		//sqlSB.append("       left outer join ci_or_srv H ON A.id_pres=H.id_pres ");
		//sqlSB.append("       where A.Id_Pres in (select distinct p.id_pres  from ci_or_srv p where p.id_or in (select id_or from ci_order where id_en= ? and fg_sign='Y' and fg_canc='N' and sd_srvtp like '01%')  ");
		//sqlSB.append("       where A.Id_Pres in (select distinct p.id_pres  from ci_or_srv p where p.id_or in (select id_or from ci_order where id_en= ? and id_or = ? and fg_sign='Y' and fg_canc='N' and sd_srvtp like '01%')  ");
		sqlSB.append("       where A.Id_Pres in (select distinct p.id_pres  from ci_or_srv p where %1$s) ");
		//sqlSB.append("		 and p.id_su_bl in(?,?) )");
		
		return sqlSB.toString();
		
	}
	
	/**
	 * 门诊西成药处方数据信息SQL串    -------------------------------------------------------------------
	 * 仅门诊西成药用
	 * CI_IE_ORDRUGWC_OP_SQL
	 */
	
	public String CiIeOrdrugwcOpSql (){
		
		StringBuilder sqlSB = new StringBuilder();
		
		sqlSB.append("select  A1.Id_Orsrv as id_iepharmwcor,A1.Id_Pres as id_iepharmpres,A1.id_orsrv as yzno,'03' as medicine_type,");
		sqlSB.append(" (case when Z2.code_entp='00' then '10' when Z2.code_entp='01' then '02' end) as ordertypecode,(case when Z2.code_entp='00' then '门诊西药' when Z2.code_entp='01' then '急诊西药' end) as ordertypename,A1.Sd_Hpsrvtp as ybtypecode,R.Name as ybtypename,S.Code as frqcode,S.Name as frqname, ");
		sqlSB.append(" A.Days_Or as persdays,T.Code as drugscode,T.Name as drugsname,A1.Quan_Medu as dosage,U.Name as dosageunit, ");
		sqlSB.append(" V.Quan_Cur as amount,W.Name as amountunit,V.Quan_Cur as getamount,W.Name as getunit,V.Code_Mm as ypcode,(case when Z1.CODE='1000' then '00' when Z1.CODE='1001' THEN '01' ELSE '' END ) as packserial,'' as parentno,A1.NOTE_SRV as advice, ");
		sqlSB.append(" X.Code as exunitcode,X.Name as exunitname, ");
		sqlSB.append(" (case when A1.Fg_Skintest='Y' then 'true' else 'false' end) as is_ps,(case when A1.FG_SKINTEST_RST='Y' then (select t1.name from ci_skin_test t left outer join bd_udidoc t1 on t.id_rst_skintest=t1.id_udidoc where t.id_or=A1.Id_Or) else '' end) as is_psresult, ");
		sqlSB.append(" (case when A1.Fg_Indic='Y' then 'true' else 'false' end ) as is_syz,(case when A1.Fg_Indic='Y' then '适应' else '非适应' end) as is_syzresult, ");
		sqlSB.append(" (case when S.Sd_Frequnitct='0' and S.Code='ST' then 'true' else 'false' end) as is_jj,(case when A.Fg_Urgent='Y' then '加急' when A.Fg_Urgent='N' then '非加急' else '' end) as is_jjresult, ");
		sqlSB.append(" '' as is_yg,'' as is_ygresult ");
		sqlSB.append(" from ci_or_srv A1 ");
		sqlSB.append("      inner join ci_order A ON A.Id_Or=A1.Id_Or ");
		sqlSB.append("      left outer join ci_pres P ON P.Id_Pres=A1.Id_Pres ");
		sqlSB.append("      left outer join bd_udidoc Q ON Q.Id_Udidoc=P.Id_Prestp ");
		sqlSB.append("      left outer join bd_udidoc R ON R.Id_Udidoc=A1.Id_Hpsrvtp ");
		sqlSB.append("      left outer join bd_freq S ON S.Id_Freq=A1.Id_Freq  ");
		sqlSB.append("      left outer join bd_route T ON T.Id_Route=A1.Id_Route ");
		sqlSB.append("      left outer join bd_measdoc U ON U.Id_Measdoc=A1.Id_Medu ");
		sqlSB.append("      left outer join ci_or_srv_mm V ON V.ID_ORSRV=A1.Id_Orsrv ");
		sqlSB.append("      left outer join bd_measdoc W ON W.Id_Measdoc=V.Id_Pgku_Cur ");
		sqlSB.append("      left outer join bd_dep X ON X.ID_DEP=A1.Id_Dep_Wh ");
		sqlSB.append("	   LEFT OUTER JOIN BD_MM_PKGU Z ON (Z.ID_MM = V.ID_MM AND Z.ID_UNIT_PKG=V.ID_PGKU_CUR) ");
		sqlSB.append("	   LEFT OUTER JOIN BD_MM_PKGUTP Z1 ON Z.ID_MMPKGUTP=Z1.ID_MMPKGUTP ");
		sqlSB.append("	   LEFT OUTER JOIN en_ent Z2 ON A.id_en=Z2.id_ent ");
		sqlSB.append(" where A1.Id_Pres =? and (A1.sd_srvtp like '0102%' or A1.sd_srvtp like '0101%') " ); //A1.Id_Pres	临时方案 将包装序号packserial用单位代替
		

		return sqlSB.toString();
		
	}
	
	/**
	 * 门诊草药处方数据信息SQL串  -------------------------------------------------------------------
	 * 仅门诊草药用
	 * CI_IE_ORDRUGHERB_OP_SQL
	 */
	
	public String CiIeOrdrugherbOpSql (String _id_preses){
	   
		StringBuilder sqlSB = new StringBuilder();
		
		sqlSB.append(" select A1.Id_Orsrv as id_iepharmor,A1.Id_Pres as id_iepharmpres,null as id_iepharmormms,A.id_or as yzno,'04' as medicine_type, ");
		sqlSB.append(" '04' as ordertypeno,'草药饮片' as ordertypename,S.Code as frqcode,S.Name as frqname, ");
		sqlSB.append(" A.Orders as amount,'付' as amountunit,X.Code as execunitcode,X.Name as exeunitname,A1.NOTE_SRV as advice, ");
		sqlSB.append(" A1.Fg_Skintest as is_ps,(case when A1.FG_SKINTEST_RST='Y' then (select t1.name from ci_skin_test t left outer join bd_udidoc t1 on t.id_rst_skintest=t1.id_udidoc where id_or=A1.Id_Or) else '' end) as is_psresult, ");
		sqlSB.append(" A1.Fg_Indic as is_syz,(case when A1.Fg_Indic='Y' then '适应' else '非适应' end) as is_syzresult,");
		sqlSB.append(" (case when S.Sd_Frequnitct='0' and S.Code='ST' then 'Y' else 'N' end) as is_jj,(case when A.Fg_Urgent='Y' then '加急' when A.Fg_Urgent='N' then '非加急' else '' end) as is_jjresult, ");
		sqlSB.append(" '' as is_yg,'' as is_ygresult ");
		
		sqlSB.append(" from ci_or_srv A1 ");
		
		sqlSB.append("      inner join ci_order A ON A.Id_Or=A1.Id_Or ");
		sqlSB.append("      left outer join ci_pres P ON P.Id_Pres=A1.Id_Pres ");
		sqlSB.append("      left outer join bd_udidoc Q ON Q.Id_Udidoc=P.Id_Prestp ");
		sqlSB.append("      left outer join bd_freq S ON S.Id_Freq=A1.Id_Freq  ");
		sqlSB.append("      left outer join bd_dep X ON X.ID_DEP=A1.Id_Dep_Wh ");
		
		sqlSB.append(" where  A1.Id_Pres");
		if(_id_preses.indexOf(",") == -1){
			sqlSB.append(" = ?");
		}else{
			sqlSB.append(" in (?)");
		}
		sqlSB.append("  and (A1.sd_srvtp like '0103%' )" );  //A1.Id_Pres	
		
     
        
		return sqlSB.toString();
		
	}
	
	/**
	 * 门诊草药处方明细成分数据信息SQL串   -------------------------------------------------------------------
	 * 仅门诊草药用
	 * 草药成分数据
	 */
	
	public String CiIiOrdrugherbMmOpSql(){
		
	StringBuilder sqlSB = new StringBuilder();
	
	sqlSB.append(	" select A2.Id_Orsrvmm as id_iepharmormm,A1.ID_PRES as id_iepharmor,A2.Quan_Cur as weight,T.Name as weightunit,A2.CODE_MM as ypcode, ");
	sqlSB.append(	" (case when Z1.CODE='1000' then '00' when Z1.CODE='1001' THEN '01' ELSE '' END ) as packserial,U.Code as methocode,U.name as methoname,'07' as nmwamount,'true' as isnmwamount,A1.Sd_Hpsrvtp as ybtypecode,R.Name as ybtypename ");
	
	sqlSB.append(	" from ci_or_srv A1  ");
	
	sqlSB.append(	"      inner join ci_order A ON A.Id_Or=A1.Id_Or ");
	sqlSB.append(	"      left outer join ci_or_srv_mm A2 ON A1.Id_Orsrv=A2.Id_Orsrv ");
	sqlSB.append(	"      left outer join ci_pres P ON P.Id_Pres=A1.Id_Pres ");
	sqlSB.append(	"      left outer join bd_measdoc T ON T.Id_Measdoc=A2.Id_Pgku_Cur  ");
	sqlSB.append(	"      left outer join bd_boil U ON U.Id_Boil=A1.Id_Boil  ");
	sqlSB.append(	"      left outer join bd_udidoc R ON R.Id_Udidoc=A1.Id_Hpsrvtp ");
	sqlSB.append(	"	   LEFT OUTER JOIN CI_OR_SRV_MM Y ON A1.ID_ORSRV=Y.ID_ORSRV ");
	sqlSB.append(	"	   LEFT OUTER JOIN BD_MM_PKGU Z ON (Z.ID_MM = Y.ID_MM AND Z.ID_UNIT_PKG=Y.ID_PGKU_CUR) ");
	sqlSB.append(	"	   LEFT OUTER JOIN BD_MM_PKGUTP Z1 ON Z.ID_MMPKGUTP=Z1.ID_MMPKGUTP ");
	sqlSB.append(	" where  ?  and A1.Fg_Or='Y' " ); //A1.Id_Pres  临时方案 将包装序号packserial用单位代替

	
    SqlParam param = new SqlParam();
    
//   param.addParam( %1$s );
 
    
	return sqlSB.toString();

		
	}
	
	
	
	
	
}
