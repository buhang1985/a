package iih.ci.event.ord.bps.charge.op.sql;
/**
 * 门诊收费 手术BS007
 * @author F
 *
 * @date 2019年9月12日下午4:13:48
 *
 * @classpath iih.ci.event.ord.bps.charge.op.sql.OpOpChargeSql
 */
public class OpOpChargeSql {

	/**
	 * BS007
	 * 门诊手术 收费 就诊信息【IEOpOpOrEnDTO】
	 * @param id_or4sql
	 * @return
	 */
	public String getOpOpChargeEntInfoSql(String id_or4sql){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" (case ");
		stringBuilder.append("   when q.fg_er_sug = 'Y' then 0 ");
		stringBuilder.append("   when q.fg_xq_sug = 'Y' then 1 ");
		stringBuilder.append("   when q.fg_zq_sug = 'Y' then 2 ");
		stringBuilder.append(" end) as operationKind, ");//--手术性质编码
		stringBuilder.append(" (case ");
		stringBuilder.append("   when q.fg_er_sug = 'Y' then '急症' ");
		stringBuilder.append("   when q.fg_xq_sug = 'Y' then '限期' ");
		stringBuilder.append("   when q.fg_zq_sug = 'Y' then '择期' ");
		stringBuilder.append(" end) as operationKindName, ");//--手术性质名称
		stringBuilder.append(" al.name_alcla as allergy, ");//--过敏史
		stringBuilder.append(" card.code as healthcard_no, ");//--将康卡号
		stringBuilder.append(" Q.Id_Apop as id_ieoporen, ");//--主键
		stringBuilder.append(" B.code as patient_id, ");//--患者id
		stringBuilder.append(" A.Code_Or as yz_no, ");//--医嘱号
		stringBuilder.append(" Q.NO_APPLYFORM as op_record_id, ");//--申请单编号
		stringBuilder.append(" A.des_or as op_describe, ");//--说明
		stringBuilder.append(" A.Dt_Entry as apply_date, ");//--申请日期
		stringBuilder.append(" E.code_ie as op_scale, ");//--手术等级编码
		stringBuilder.append(" E.name as op_scale_name, ");//--手术等级名称 
		stringBuilder.append(" Q.Sd_Anestp as anaesthesia_method_code, ");//--麻醉方式编码
		stringBuilder.append(" F.Name as anaesthesia_method_name, ");//--麻醉方式名称
		stringBuilder.append(" b.barcode_chis as p_bar_code, ");//--就诊号
		stringBuilder.append(" G.name as ward_code_name, ");//--病区名
		stringBuilder.append(" G.Code as ward_code, ");//--病区编码
		stringBuilder.append(" H.NAME_BED as bed_no, ");//--床号
		stringBuilder.append(" B.Id_Code as social_no, ");//--身份证号
		stringBuilder.append(" S.Code as addition_no1, ");//--医保号
		stringBuilder.append(" C.Name_Pat as name, ");//--患者姓名
		stringBuilder.append(" C.Telno_Pat as home_tel, ");//--电话
		stringBuilder.append(" C.Sd_Sex_Pat as sex, ");//--性别编码
		stringBuilder.append(" C.Dt_Birth_Pat as birthday, ");//--出生日期
		stringBuilder.append(" B.dt_birth as birthday, ");//--出生日期
		stringBuilder.append(" '' as age, ");//--派生年龄
		stringBuilder.append(" C.ADDR_PAT as home_street, ");//--地址
		stringBuilder.append(" I.code as patient_dept, ");//--病人科室编码
		stringBuilder.append(" I.name as patient_dept_name, ");//--病人科室名称
		stringBuilder.append(" K.orgcode as hospital_code, ");//-- 医疗机构代码
		stringBuilder.append(" K.name as hospital_name, ");//--医疗机构名称
		stringBuilder.append(" Q.Dt_Plan as op_datetime, ");//--预订手术时间
		stringBuilder.append(" M.code as exec_code, ");//--执行科室编码
		stringBuilder.append(" M.name as exec_code_name, ");//--执行科室
		stringBuilder.append(" N.code as apply_user, ");//--申请医师编码
		stringBuilder.append(" N.name as apply_user_name, ");//--申请医师
		stringBuilder.append(" O.code as dept_code, ");//--申请科室编码
		stringBuilder.append(" O.name as dept_code_name, ");//--申请科室
		stringBuilder.append(" '' as check_date, ");//--审核日期
		stringBuilder.append(" '' as check_opera, ");//--审核人编码
		stringBuilder.append(" '' as check_opera_name, ");//--审核人姓名
		stringBuilder.append(" '' as is_frozen_flag, ");//--是否冰冻
		stringBuilder.append(" '' as frozen_flag, ");//--是否冰冻结果
		stringBuilder.append(" Q.Announcements as comment1, ");//注意事项
		stringBuilder.append(" (case when H.Times_Ip is null then 0 else H.Times_Ip end) + (case when J.Times_Op is null then 0 else J.Times_Op end) as admit_times, ");//-- 就诊次数
		stringBuilder.append(" C.Dt_Entry as visit_date, ");//--就诊(住院)日期
		stringBuilder.append(" (case when P.FG_MAJDI = 'Y' then '12' when P.FG_MAJDI = 'N' then '13' else '' end) as diag_type, ");//--诊断类别编码
		stringBuilder.append(" (case when P.FG_MAJDI = 'Y' then '主要诊断' when P.FG_MAJDI = 'N' then '次要诊断' else '' end) as diag_type_name, ");//--诊断名称
		stringBuilder.append(" P.ID_DIDEF_CODE as diag_code, ");//--疾病编码
		stringBuilder.append(" P.ID_DIDEF_NAME as diag_str, ");//--疾病编名称
		stringBuilder.append(" '01' as domain_id, ");//--域id
		stringBuilder.append(" D.sd_iemsgca as iemsgca_code, ");//--集成平台服务分类
		stringBuilder.append(" (case when Z3.name = '未记账' then '099' when Z3.name = '已记账' then P1.name end) as iemsgca_name, ");//--集成平台服务分类名称
		stringBuilder.append(" C.code as visitOrdNo, ");//--就诊流水号
		stringBuilder.append(" a.code_entp as visitType, ");//--就诊类别编码
		stringBuilder.append(" bd.name as visitTypeName, ");//--就诊类别名称
		stringBuilder.append(" Q.Specialdes as Special_prepare, ");//特殊准备
		stringBuilder.append(" A.Id_or as Idor ");//医嘱id
		stringBuilder.append(" from ci_ap_sug Q ");
		stringBuilder.append(" left outer join ci_order A on Q.Id_Or = A.Id_Or ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join pi_pat_card card ON A.Id_Pat = card.Id_Pat and card.fg_act = 'Y' and card.sd_patcardtp = '05' ");
		stringBuilder.append(" left outer join pi_pat_cardtp cardtp ON cardtp.id_cardtp = card.id_patcardtp and cardtp.sd_patcardtp = '05' ");
		stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		stringBuilder.append(" left outer join bd_srv D ON Q.Id_Srv = D.Id_Srv ");
		stringBuilder.append(" left outer join bd_udidoc P1 ON D.Id_iemsgca = P1.Id_Udidoc ");
		stringBuilder.append(" left outer join bd_udidoc Z3 ON (Z3.id_udidoc = ? and Z3.id_udidoclist = ?) ");
		stringBuilder.append(" left outer join bd_udidoc E ON E.Id_Udidoc = Q.Id_Lvlsug ");
		stringBuilder.append(" left outer join bd_udidoc F ON F.Id_Udidoc = Q.Id_Anestp ");
		stringBuilder.append(" left outer join bd_dep G ON G.Id_Dep = C.Id_Dep_Nur ");
		stringBuilder.append(" left outer join en_ent_ip H ON C.Id_Ent = H.Id_Ent ");
		stringBuilder.append(" left outer join bd_dep I ON I.Id_Dep = C.Id_Dep_Phy ");
		stringBuilder.append(" left outer join en_ent_op J ON A.Id_En = J.Id_Ent ");
		stringBuilder.append(" left outer join pi_pat_card S ON S.ID_PAT = B.Id_Pat and S.Sd_Patcardtp = '04' ");
		stringBuilder.append(" left outer join bd_org K ON A.Id_Org = K.Id_Org ");
		stringBuilder.append(" left outer join bd_psndoc L ON L.Id_Psndoc = Q.Id_Emp_Operate ");
		stringBuilder.append(" left outer join bd_dep M ON M.Id_Dep = A.Id_Dep_Mp ");
		stringBuilder.append(" left outer join bd_psndoc N ON N.Id_Psndoc = A.Id_Emp_Or ");
		stringBuilder.append(" left outer join bd_dep O ON O.Id_Dep = A.Id_Dep_Or ");
		stringBuilder.append(" left outer join en_ent_di M1 ON A.Id_En = M1.Id_Ent ");
		stringBuilder.append(" left outer join ci_di_itm P ON m1.Id_Diitm = P.ID_DIITM ");
		stringBuilder.append(" left outer join BD_ENTP BD ON a.CODE_ENTP = BD.CODE ");
		stringBuilder.append(" left outer join ci_ap_sug R ON R.id_or = Q.id_or ");
		stringBuilder.append(" left outer join bd_psndoc S ON R.id_emp_helper = S.id_psndoc ");
		stringBuilder.append(" left outer join (select bb.id_pat, ");
		//0184716: 集成平台消息将wm__concat替换为LISTAGG，避免版本不兼容
		stringBuilder.append("                         listagg(TO_CHAR(TO_DATE(substr(aa.dt_act,1,10),'yyyy-MM-dd'),'yyyy-MM-dd') || ':' || aa.name_alcla) within group(order by bb.id_pat) as name_alcla ");
		stringBuilder.append("                  from pi_pat_al aa ");
		stringBuilder.append("                  inner join pi_pat bb on bb.id_pat = aa.id_pat ");
		stringBuilder.append("                  group by bb.id_pat) al ON al.id_pat = B.Id_Pat ");
		stringBuilder.append(" where M1.Fg_Maj = 'Y' ");
		stringBuilder.append(" and A.Id_or ");
		stringBuilder.append(id_or4sql);
		return stringBuilder.toString();
	}
	/**
	 * BS007
	 * 门诊 收费 手术医嘱信息【IEOperationInfoDTO】
	 * @param id_or4sql
	 * @return
	 */
	public String getOpOpChargeOperationInfoSql(String id_or4sql){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" a.id_en as id_ent, ");//--就诊id
	    stringBuilder.append(" (case when phy2.code = '04' then 'true' else 'false' end) as is_breastfeeding, ");//--是否哺乳
	    stringBuilder.append(" (case when phy.code = '02' then 'true' else 'false' end) as is_pregnancy, ");//--是否妊娠
	    stringBuilder.append(" (case when phy.code = '02' then phy.sv else '' end) as pregnancy_date, ");//--妊娠时间
	    stringBuilder.append(" A.Code_Or as yz_no, ");//医嘱号
	    stringBuilder.append(" d.code_srv as Op_code, ");//--手术名称编码
	    stringBuilder.append(" d.name as Op_code_name, ");//--手术名称
	    stringBuilder.append(" L.Code as Operatorcode, ");//--手术医生编码
	    stringBuilder.append(" L.name as Operatorname, ");//--手术医生名称
	    stringBuilder.append(" E.code as op_scale, ");//--手术等级编码
	    stringBuilder.append(" E.name as op_scale_name, ");//--手术等级名称
	    stringBuilder.append(" A.fg_skintest as isstest,");//--是否皮试
		stringBuilder.append(" A.fg_skintest as stest, ");//--是否皮试结果
		stringBuilder.append(" '03' as is_em, ");//--是否加急
		stringBuilder.append(" (case  when A.Fg_Urgent = 'Y' then  'true'  else  'false' end) as is_em_r, ");//--是否加急结果 
		stringBuilder.append(" d.sd_su_bl as payflag ");//收费标识
		stringBuilder.append(" from ci_or_srv D ");
		stringBuilder.append(" left outer join ci_order A ON d.id_or = a.id_or ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join (select z0.id_pat, d0.code, z0.sv ");
		stringBuilder.append("                  from pi_pat_phy z0 ");
		stringBuilder.append("                  left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind ");
		stringBuilder.append("                  where d0.code = '02') phy ON phy.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join (select z0.id_pat, d0.code ");
		stringBuilder.append("                  from pi_pat_phy z0 ");
		stringBuilder.append("                  left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind ");
		stringBuilder.append("                  where d0.code = '04') phy2 on phy2.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join ci_ap_sug Q on Q.Id_Or = A.Id_Or ");
		stringBuilder.append(" left outer join bd_psndoc L ON L.Id_Psndoc = Q.Id_Emp_Operate ");
		stringBuilder.append(" left outer join bd_udidoc E ON E.Id_Udidoc = Q.Id_Lvlsug ");
		stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		stringBuilder.append(" where d.fg_or = 'Y' ");
		stringBuilder.append(" and A.Id_Or ");
		stringBuilder.append(id_or4sql);
		return stringBuilder.toString();
	}
	/**
	 * BS007
	 * 门诊 收费 手术 助手信息【IESugAssistDTO】
	 * @param id_or4sql
	 * @return
	 */
	public String getOpOpChargeAssistInfoSql(String id_or4sql){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" a.name as nursename, ");//医护人员姓名
		stringBuilder.append(" a.code as nursecode, ");//医护人员编码
		stringBuilder.append(" c.name as nurserole "); //医护人员角色
		stringBuilder.append(" from bd_psndoc a,bd_udidoc c,ci_ap_sug d,ci_order e ");   
		stringBuilder.append(" where a.Id_Psndoc=d.id_emp_helper ");   
		stringBuilder.append(" and d.id_or = e.id_or ");  
		stringBuilder.append(" and c.name <> '主刀医师' and c.name like '%第一助手%' ");  
		stringBuilder.append(" and e.id_or ");
		stringBuilder.append(id_or4sql);
		return stringBuilder.toString();
	}
}
