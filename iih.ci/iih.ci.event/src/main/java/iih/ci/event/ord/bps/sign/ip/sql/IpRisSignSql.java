package iih.ci.event.ord.bps.sign.ip.sql;

import iih.ci.event.ord.utils.OrdEventUtil;

public class IpRisSignSql {
	
	/**
	 * BS002 病理检查
	 * 住院 签署 检查 1就诊 2申请 3医嘱信息 sql 1.【IEOpRisOrEnDTO】+【IEOpRisIllHisDTO】 2.【IEOpRisOrDTO】 3.【IEOpRisOrItmDTO】
	 * @param str_idor_path
	 * @return
	 */
	public String getIpRisSignPathInfoSql(String str_idor_path ){
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" do.code as ser_type_code, ");//3.检查类型编码-新（服务类型）
	    stringBuilder.append(" do.name as ser_type_name, ");//3.检查类型名称-新（服务类型）
	    stringBuilder.append(" free.amounts as amounts, ");//3.费用金额
	    stringBuilder.append(" al.name_alcla as allergy, ");//1.过敏史
	    stringBuilder.append(" (select code from pi_pat_card card where A.Id_Pat = card.Id_Pat and card.fg_act = 'Y' and card.sd_patcardtp = '05' and rownum<=1) health_card_no, ");//1.健康卡号
	    stringBuilder.append(" (case when phy2.code = '04' then 'true' else 'false' end) as is_breastfeeding, ");//3.是否哺乳
	    stringBuilder.append(" (case when phy.code = '02' then 'true' else 'false' end) as is_pregnancy, ");//3.是否妊娠
	    stringBuilder.append(" '' as pregnancy_date, ");//3.妊娠时间
	    stringBuilder.append(" C.Id_Ent as id_ent, ");//就诊id
	    stringBuilder.append(" A.id_en as id_ierisoren, ");//就诊id
	    stringBuilder.append(" B.code as patient_id, ");//1.患者ID
	    stringBuilder.append(" b.code_amr_ip as p_bar_code, ");//1.就诊号
	    stringBuilder.append(" E.code as ward_code, ");//1.病区编码
	    stringBuilder.append(" E.name as ward_code_name, ");//1.病区名
	    stringBuilder.append(" F.NAME_BED as bed_no, ");//1.床号
	    stringBuilder.append(" B.Id_Code as social_no, ");//1.身份证号
	    stringBuilder.append(" S.no_hp as addition_no, ");//1.医保卡号
	    stringBuilder.append(" C.Name_Pat as name, ");//1.姓名
	    stringBuilder.append(" C.Telno_Pat as home_tel, ");//1.联系电话
	    stringBuilder.append(" C.Sd_Sex_Pat as sexid, ");//1.性别编码
	    stringBuilder.append(" B.DT_BIRTH_HMS as birthday, ");//1.出生日期
	    stringBuilder.append(" '' as age, ");//1.年龄
	    stringBuilder.append(" C.ADDR_PAT as home_street, ");//1.住址
	    stringBuilder.append(" C.Sd_Mari_Pat as marry_code, ");//1.婚姻状况类别编码
	    stringBuilder.append(" T.code as nation_code, ");//1.民族编码
	    stringBuilder.append(" u.code as occupation_type, ");//1.职业编码
	    stringBuilder.append(" U.Name as occupation_type_name, ");//1.职业
	    stringBuilder.append(" B.Workunit as work_unit, ");//1.工作单位名称 
	    stringBuilder.append(" o.code as country_code, ");//1.国籍编码
	    stringBuilder.append(" O.Name as country_code_name, ");//1.国家
	    stringBuilder.append(" D.code as code_dep_ns, ");//1.病人科室编码
	    stringBuilder.append(" D.name as name_dep_ns, ");//1.病人科室名称
	    stringBuilder.append(" G.orgCode as org_code, ");//1.医疗机构代码
	    stringBuilder.append(" G.name as org_name, ");//1.医疗机构名称
	    stringBuilder.append(" G.Name as apply_hospital, ");//1.申请医院
	    stringBuilder.append(" A.Dt_Effe as enter_date, ");//1.开单时间
	    stringBuilder.append(" K.code as apply_doctor, ");//1.开单医生编码
	    stringBuilder.append(" K.name as apply_doctor_name, ");//1.开单医生姓名
	    stringBuilder.append(" L.Code as apply_unit, ");//1.申请科室编码
	    stringBuilder.append(" L.Name as apply_unit_name, ");//1.申请科室名称
	    stringBuilder.append(" A.Dt_Chk as confirm_date, ");//1.确认时间
	    stringBuilder.append(" H.Code as confirm_opera, ");//1.确认人编码
	    stringBuilder.append(" H.name as confirm_opera_name, ");//1.确认人姓名
	    stringBuilder.append(" W.Name as response_type, ");//1.病人类型编码
	    stringBuilder.append(" (case when F.Times_Ip is null then 0 else F.Times_Ip end) + (case when J.Times_Op is null then 0 else J.Times_Op end) as times, ");//1.就诊次数
	    stringBuilder.append(" (case when M.FG_MAJDI = 'Y' then '12' when M.FG_MAJDI = 'N' then '13' else '' end) as diag_type_code, ");//1.诊断类别编码
	    stringBuilder.append(" (case when M.FG_MAJDI = 'Y' then '主要诊断' when M.FG_MAJDI = 'N' then '次要诊断' else '' end) as diag_type_name, ");//1.诊断类别名称
	    stringBuilder.append(" X.Dt_Sign as diag_input_date, ");//1.诊断日期
	    stringBuilder.append(" M.ID_DIDEF_CODE as diag_code, ");//1.疾病编码 既往史疾病编码
	    stringBuilder.append(" M.ID_DIDEF_NAME as diag_str, ");//1.疾病名称
	    stringBuilder.append(" A.Id_Or as id_ierisor, ");//医嘱id
	    stringBuilder.append(" '' as id_ierisoritms, ");
	    stringBuilder.append(" Q.NO_APPLYFORM as apply_serial, ");//2.检查申请单编号
	    stringBuilder.append(" N.Code as exam_type, ");//2.医嘱类型 3.检查类型编码-旧
	    stringBuilder.append(" N.Name as exam_type_name, ");//2.医嘱类型名称 3.检查类型名称-旧
	    stringBuilder.append(" null as exam_content, ");//2.申请单详细内容
	    stringBuilder.append(" A.Dt_Sign as exam_request_date, ");//2.检查申请日期
	    stringBuilder.append(" '' as samp_bar_code, ");//2.标本号
	    stringBuilder.append(" Q.sd_samptp as samp_type, ");//2.标本类别编码
	    stringBuilder.append(" '' as samp_content, ");//2.标本要求
	    stringBuilder.append(" A.Dt_Last_Mp as exam_exec_date, ");//2.执行时间
	    stringBuilder.append(" VV.Name as exec_unit, ");//2.执行科室名称
	    stringBuilder.append(" VV.Code as sqd_deptcode, ");//2.执行科室编码
	    stringBuilder.append(" Q.Announcements as note, ");//2.申请注意事项
	    stringBuilder.append(" '' as id_ierisoritm, ");
	    stringBuilder.append(" a.code_or as exam_serial, ");//3.医嘱号
	    stringBuilder.append(" P.code as exam_sub_type, ");//3.检查项目编码
	    stringBuilder.append(" P.name as exam_sub_type_name, ");//3.检查项目名称
	    stringBuilder.append(" ");//3.医嘱描述
	    stringBuilder.append(" '' as order_pri, ");//3.医嘱费用
	    stringBuilder.append(" A.dt_effe as dt_effe, ");//3.医嘱开始时间
	    stringBuilder.append(" A.dt_end as dt_end, ");//3.医嘱停止时间
	    stringBuilder.append(" Y.Code as yz_frequency, ");//3.医嘱执行频率编码
	    stringBuilder.append(" Y.Name as yz_frequency_name, ");//3.医嘱执行频率名称
	    stringBuilder.append(" '' as exam_sub_fftype, ");//3.检查方法编码
	    stringBuilder.append(" '' as exam_sub_fftype_name, ");//3.检查方法名
	    stringBuilder.append(" V.Sd_Body as exam_region, ");//3.检查部位编码
	    stringBuilder.append(" Z.Name as exam_region_name, ");//3.检查部位名称
	    stringBuilder.append(" '' as isstest, ");//3.是否皮试
	    stringBuilder.append(" '' as stest, ");//3.是否皮试结果
	    stringBuilder.append(" A.fg_urgent as is_em, ");//3.是否加急
	    stringBuilder.append(" '' as is_em_r, ");//3.是否加急结果
	    stringBuilder.append(" '' as isyg, ");//3.是否药观
	    stringBuilder.append(" '' as yg, ");//3.是否药观结果
	    stringBuilder.append(" P.sd_iemsgca as iemsgca_code, ");//2.集成平台服务分类服务
	    stringBuilder.append(" (case when Z3.name = '未记账' then '099' when Z3.name = '已记账' then P1.name end) as iemsgca_name, ");//2.集成平台服务分类名称
	    stringBuilder.append(" P1.ctrl1 as iemsgca_typename, ");//2.集成消息类型名称
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as Ordertimetypename, ");//3.医嘱时间类型名称
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as Ordertimetype, ");//3.医嘱时间类型编码
	    stringBuilder.append(" C.code as Visitordno, ");//1.就诊流水号
	    stringBuilder.append(" a.code_entp as Visittypecode, ");//1.就诊类别编码
	    stringBuilder.append(" BD.name as Visittypename ");//1.就诊类别名称
		stringBuilder.append(" from ci_ap_pathgy Q ");
		stringBuilder.append(" left outer join ci_order A on Q.Id_Or = A.Id_Or ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left join (select "); 
		stringBuilder.append("            z0.id_pat, d0.code, z0.sv ");
		stringBuilder.append("            from pi_pat_phy z0 ");
		stringBuilder.append("            left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind ");
		stringBuilder.append("            where d0.code = '02') phy ON phy.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left join (select "); 
		stringBuilder.append("            z0.id_pat, d0.code ");
		stringBuilder.append("            from pi_pat_phy z0 ");
		stringBuilder.append("            left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind ");
		stringBuilder.append("            where d0.code = '04') phy2 on phy2.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		stringBuilder.append(" left outer join bd_dep D ON C.Id_Dep_Phy = D.ID_DEP ");
		stringBuilder.append(" left outer join bd_dep E ON C.Id_Dep_Nur = E.Id_Dep ");
		stringBuilder.append(" left outer join en_ent_ip F ON C.Id_Ent = F.Id_Ent ");
		stringBuilder.append(" left outer join bd_org G ON A.Id_Org = G.Id_Org ");
		stringBuilder.append(" left outer join bd_psndoc H ON H.Id_Psndoc = A.Id_Emp_Chk ");
		stringBuilder.append(" left outer join en_ent_op J ON A.Id_En = J.Id_Ent ");
		stringBuilder.append(" left outer join bd_psndoc K ON K.Id_Psndoc = A.Id_Emp_Or ");
		stringBuilder.append(" left outer join bd_dep L ON A.Id_Dep_Or = L.ID_DEP ");
		stringBuilder.append(" left outer join en_ent_di M1 ON A.Id_En = M1.Id_Ent and M1.Fg_Maj = 'Y' ");
		stringBuilder.append(" left outer join ci_di_itm M ON M1.ID_DIITM = M.ID_DIITM ");
		stringBuilder.append(" left outer join ci_di X ON M1.Id_Di = X.Id_Di ");
		stringBuilder.append(" left outer join bd_srvca N ON N.Id_Srvca = A.Id_Srvca ");
		stringBuilder.append(" left outer join bd_country O ON O.Id_CountryZONE = B.Id_Country ");
		stringBuilder.append(" left outer join bd_srv P ON P.id_srv = A.Id_Srv ");
		stringBuilder.append(" left outer join en_ent_hp S ON S.ID_ENT = C.Id_Ent ");
		stringBuilder.append(" left outer join bd_udidoc T ON T.Id_Udidoc = B.Id_Nation ");
		stringBuilder.append(" left outer join bd_udidoc U ON U.Id_Udidoc = B.Id_Occu ");
		stringBuilder.append(" left outer join bd_dep VV ON VV.Id_Dep = A.Id_Dep_Mp ");
		stringBuilder.append(" left outer join pi_pat_ca W ON W.Id_Patca = B.Id_Paticate ");
		stringBuilder.append(" left outer join bd_freq Y ON A.Id_Freq = Y.Id_Freq ");
		stringBuilder.append(" left outer join bd_srv_obs V ON V.Id_Srv = A.Id_Srv ");
		stringBuilder.append(" left outer join bd_udidoc Z ON V.Id_Body = Z.Id_Udidoc ");
		stringBuilder.append(" left outer join bd_udidoc P1 ON P.Id_iemsgca = P1.Id_Udidoc ");
		stringBuilder.append(" left outer join bd_udidoc Z3 ON (Z3.id_udidoc = ? and Z3.id_udidoclist = ?) ");
		stringBuilder.append(" left outer join ci_or_srv_set Z5 on Z5.id_or = A.id_or and Z5.fg_clinical = 'Y' and Z5.id_body is not null ");
		stringBuilder.append(" left outer join bd_udidoc Z4 ON Z4.Id_Udidoc = Z5.Id_Body ");
		stringBuilder.append(" left outer join BD_ENTP BD ON a.CODE_ENTP = BD.CODE ");
		stringBuilder.append(" left outer join (select "); 
		stringBuilder.append("                  bb.id_pat, ");
		//0184716: 集成平台消息将wm__concat替换为LISTAGG，避免版本不兼容
		stringBuilder.append("                  listagg(TO_CHAR(TO_DATE(substr(aa.dt_act,1,10),'yyyy-MM-dd'),'yyyy-MM-dd') || ':' || aa.name_alcla) within group(order by bb.id_pat) as name_alcla ");
		stringBuilder.append("                  from pi_pat_al aa ");
		stringBuilder.append("                  inner join pi_pat bb on bb.id_pat = aa.id_pat ");
		stringBuilder.append("                  group by bb.id_pat) al ON al.id_pat = B.Id_Pat ");
		stringBuilder.append(" left outer join (select "); 
		stringBuilder.append("                  srv.id_or, ");
		stringBuilder.append("                  ciorder.id_pat, ");
		stringBuilder.append("                  sum(srv.quan_total_medu * srv.pri) as amounts ");
		stringBuilder.append("                  from ci_order ciorder ");
		stringBuilder.append("                  left join ci_or_srv srv on ciorder.id_or = srv.id_or ");
		stringBuilder.append("                  where srv.fg_bl = 'Y' ");
		stringBuilder.append("                  group by ciorder.id_pat, srv.id_or) free on free.id_or = A.id_or ");
		stringBuilder.append(" left outer join BD_UDIDOC do on do.id_udidoc = a.id_srvtp ");
		stringBuilder.append(" where A.id_or ");
		if( str_idor_path.indexOf(",") == -1){
			stringBuilder.append(" =  ");
			stringBuilder.append(OrdEventUtil.getSqlCondStr(str_idor_path));
		}else{
			stringBuilder.append(" in  ");
			stringBuilder.append(OrdEventUtil.getSqlInStrsWithOutIn(str_idor_path));
		}
		return stringBuilder.toString();
	}
	/**
	 * BS002 普通检查
	 * 住院 签署 检查 1就诊 2申请 3医嘱信息 sql 1.【IEOpRisOrEnDTO】+【IEOpRisIllHisDTO】 2.【IEOpRisOrDTO】 3.【IEOpRisOrItmDTO】
	 * @param str_idor_path
	 * @return
	 */
	public String getIpRisSignRisInfoSql(String str_idor_ris) {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" do.code as ser_type_code, ");//3.检查类型编码-新（服务类型）
	    stringBuilder.append(" do.name as ser_type_name, ");//3.检查类型名称-新（服务类型）
	    stringBuilder.append(" free.amounts as amounts, ");//3.费用金额
	    stringBuilder.append(" al.name_alcla as allergy, ");//1.过敏史
	    stringBuilder.append(" (select code from pi_pat_card card where A.Id_Pat = card.Id_Pat and card.fg_act = 'Y' and card.sd_patcardtp = '05' and rownum<=1) health_card_no, ");//1.健康卡号
	    stringBuilder.append(" (case when phy2.code = '04' then 'true' else 'false' end) as is_breastfeeding, ");//3.是否哺乳
	    stringBuilder.append(" (case when phy.code = '02' then 'true' else 'false' end) as is_pregnancy, ");//3.是否妊娠
	    stringBuilder.append(" '' as pregnancy_date, ");//3.妊娠时间
	    stringBuilder.append(" C.Id_Ent as id_ent, ");//就诊id
	    stringBuilder.append(" A.id_en as id_ierisoren, ");//就诊id
	    stringBuilder.append(" B.code as patient_id, ");//1.患者ID
	    stringBuilder.append(" b.code_amr_ip as p_bar_code, ");//1.就诊号
	    stringBuilder.append(" E.code as ward_code, ");//1.病区编码
	    stringBuilder.append(" E.name as ward_code_name, ");//1.病区名
	    stringBuilder.append(" F.name_bed as bed_no, ");//1.床号
	    stringBuilder.append(" B.Id_Code as social_no, ");//1.身份证号
	    stringBuilder.append(" S.no_hp as addition_no, ");//1.医保卡号
	    stringBuilder.append(" C.Name_Pat as name, ");//1.姓名
	    stringBuilder.append(" C.Telno_Pat as home_tel, ");//1.联系电话
	    stringBuilder.append(" C.Sd_Sex_Pat as sexid, ");//1.性别编码
	    stringBuilder.append(" B.DT_BIRTH_HMS as birthday, ");//1.出生日期
	    stringBuilder.append(" '' as age, ");//1.年龄
	    stringBuilder.append(" C.ADDR_PAT as home_street, ");//1.住址
	    stringBuilder.append(" C.Sd_Mari_Pat as marry_code, ");//1.婚姻状况类别编码
	    stringBuilder.append(" T.code as nation_code, ");//1.民族编码
	    stringBuilder.append(" u.code as occupation_type, ");//1.职业编码
	    stringBuilder.append(" U.Name as occupation_type_name, ");//1.职业
	    stringBuilder.append(" B.Workunit as work_unit, ");//1.工作单位名称 
	    stringBuilder.append(" o.code as country_code, ");//1.国籍编码
	    stringBuilder.append(" O.Name as country_code_name, ");//1.国家
	    stringBuilder.append(" D.code as code_dep_ns, ");//1.病人科室编码
	    stringBuilder.append(" D.name as name_dep_ns, ");//1.病人科室名称
	    stringBuilder.append(" G.orgCode as org_code, ");//1.医疗机构代码
	    stringBuilder.append(" G.name as org_name, ");//1.医疗机构名称
	    stringBuilder.append(" G.Name as apply_hospital, ");//1.申请医院
	    stringBuilder.append(" A.dt_sign as enter_date, ");//1.开单时间
	    stringBuilder.append(" K.code as apply_doctor, ");//1.开单医生编码
	    stringBuilder.append(" K.name as apply_doctor_name, ");//1.开单医生姓名
	    stringBuilder.append(" L.Code as apply_unit, ");//1.申请科室编码
	    stringBuilder.append(" L.Name as apply_unit_name, ");//1.申请科室名称
	    stringBuilder.append(" A.Dt_Chk as confirm_date, ");//1.确认时间
	    stringBuilder.append(" H.Code as confirm_opera, ");//1.确认人编码
	    stringBuilder.append(" H.Name as confirm_opera_name, ");//1.确认人姓名
	    stringBuilder.append(" W.Name as response_type, ");//1.病人类型编码
	    stringBuilder.append(" (case when F.Times_Ip is null then 0 else F.Times_Ip end) + (case when J.Times_Op is null then 0 else J.Times_Op end) as times, ");//1.就诊次数
	    stringBuilder.append(" (case when M.FG_MAJDI = 'Y' then '12' when M.FG_MAJDI = 'N' then '13' else '' end) as diag_type_code, ");//1.诊断类别编码
	    stringBuilder.append(" (case when M.FG_MAJDI = 'Y' then '主要诊断' when M.FG_MAJDI = 'N' then '次要诊断' else '' end) as diag_type_name, ");//1.诊断类别名称
	    stringBuilder.append(" X.Dt_Sign as diag_input_date, ");//1.诊断日期
	    stringBuilder.append(" M.ID_DIDEF_CODE as diag_code, ");//1.疾病编码 既往史疾病编码
	    stringBuilder.append(" M.ID_DIDEF_NAME as diag_str, ");//1.疾病名称
	    stringBuilder.append(" A.Id_Or as id_ierisor, ");//医嘱id
	    stringBuilder.append(" '' as id_ierisoritms, ");
	    stringBuilder.append(" Q.NO_APPLYFORM as apply_serial, ");//2.检查申请单编号
	    stringBuilder.append(" (case when substr(A.sd_srvtp, 0, 2) = '02' then ? when substr(A.sd_srvtp, 0, 2) = '03' then ? else '' end) as exam_type, ");//2.医嘱类型 3.检查类型编码-旧
	    stringBuilder.append(" (case when substr(A.sd_srvtp, 0, 2) = '02' then '检查' when substr(A.sd_srvtp, 0, 2) = '03' then '化验' else '' end) as exam_type_name, ");//2.医嘱类型名称 3.检查类型名称-旧
	    stringBuilder.append(" Q.Clinicalzztz as exam_content, ");//2.申请单详细内容	0190248: 检查医嘱中”临床症状及体征“内容上传到平台
	    stringBuilder.append(" A.Dt_Sign as exam_request_date, ");//2.检查申请日期
	    stringBuilder.append(" '' as samp_bar_code, ");//2.标本号
	    stringBuilder.append(" '' as samp_type, ");//2.标本类别编码
	    stringBuilder.append(" '' as samp_content, ");//2.标本要求
	    stringBuilder.append(" A.Dt_Last_Mp as exam_exec_date, ");//2.执行时间
	    stringBuilder.append(" VV.Name as exec_unit, ");//2.执行科室名称
	    stringBuilder.append(" VV.Code as sqd_deptcode, ");//2.执行科室编码
	    stringBuilder.append(" Q.Announcements as note, ");//2.申请注意事项
	    stringBuilder.append(" Q.Id_Orobs as id_ierisoritm, ");
	    stringBuilder.append(" a.code_or as exam_serial, ");//3.医嘱号
	    stringBuilder.append(" P.code as exam_sub_type, ");//3.检查项目编码
	    stringBuilder.append(" P.name as exam_sub_type_name, ");//3.检查项目名称
	    stringBuilder.append(" ");//3.医嘱描述
	    stringBuilder.append(" '' as order_pri, ");//3.医嘱费用
	    stringBuilder.append(" A.dt_effe as dt_effe, ");//3.医嘱开始时间
	    stringBuilder.append(" A.dt_end as dt_end, ");//3.医嘱停止时间
	    stringBuilder.append(" Z1.Code as yz_frequency, ");//3.医嘱执行频率编码
	    stringBuilder.append(" Z1.Name as yz_frequency_name, ");//3.医嘱执行频率名称
	    stringBuilder.append(" '' as exam_sub_fftype, ");//3.检查方法编码
	    stringBuilder.append(" '' as exam_sub_fftype_name, ");//3.检查方法名
	    stringBuilder.append(" (case when P.fg_set = 'N' then V.Sd_Body else Z4.code end) as exam_region, ");//3.检查部位编码
	    stringBuilder.append(" (case when P.fg_set = 'N' then Z.name else Z4.name end) as exam_region_name, ");//3.检查部位名称
	    stringBuilder.append(" '' as isstest, ");//3.是否皮试
	    stringBuilder.append(" '' as stest, ");//3.是否皮试结果
	    stringBuilder.append(" A.fg_urgent as is_em, ");//3.是否加急
	    stringBuilder.append(" '' as is_em_r, ");//3.是否加急结果
	    stringBuilder.append(" '' as isyg, ");//3.是否药观
	    stringBuilder.append(" '' as yg, ");//3.是否药观结果
	    stringBuilder.append(" P.sd_iemsgca as iemsgca_code, ");//2.集成平台服务分类服务
	    stringBuilder.append(" (case when Z3.name = '未记账' then '099' when Z3.name = '已记账' then P1.name end) as iemsgca_name, ");//2.集成平台服务分类名称
	    stringBuilder.append(" P1.ctrl1 as iemsgca_typename, ");//2.集成消息类型名称
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as Ordertimetypename, ");//3.医嘱时间类型名称
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as Ordertimetype, ");//3.医嘱时间类型编码
	    stringBuilder.append(" C.code as Visitordno, ");//1.就诊流水号
	    stringBuilder.append(" a.code_entp as Visittypecode, ");//1.就诊类别编码
	    stringBuilder.append(" BD.name as Visittypename ");//1.就诊类别名称
		stringBuilder.append(" from ci_ap_obs Q ");
		stringBuilder.append(" left outer join ci_order A on Q.Id_Or = A.Id_Or ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join (select "); 
		stringBuilder.append("                 z0.id_pat, d0.code, z0.sv ");
		stringBuilder.append("                 from pi_pat_phy z0 ");
		stringBuilder.append("                 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind ");
		stringBuilder.append("                 where d0.code = '02') phy ON phy.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join (select "); 
		stringBuilder.append("                  z0.id_pat, d0.code ");
		stringBuilder.append("                  from pi_pat_phy z0 ");
		stringBuilder.append("                  left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind ");
		stringBuilder.append("                  where d0.code = '04') phy2 on phy2.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		stringBuilder.append(" left outer join bd_dep D ON C.Id_Dep_Phy = D.ID_DEP ");
		stringBuilder.append(" left outer join bd_dep E ON C.Id_Dep_Nur = E.Id_Dep ");
		stringBuilder.append(" left outer join en_ent_ip F ON C.Id_Ent = F.Id_Ent ");
		stringBuilder.append(" left outer join bd_org G ON A.Id_Org = G.Id_Org ");
		stringBuilder.append(" left outer join bd_psndoc H ON H.Id_Psndoc = A.Id_Emp_Chk ");
		stringBuilder.append(" left outer join en_ent_op J ON A.Id_En = J.Id_Ent ");
		stringBuilder.append(" left outer join bd_psndoc K ON K.Id_Psndoc = A.Id_Emp_Or ");
		stringBuilder.append(" left outer join bd_dep L ON A.Id_Dep_Or = L.ID_DEP ");
		stringBuilder.append(" left outer join en_ent_di M1 ON A.Id_En = M1.Id_Ent and M1.Fg_Maj = 'Y' ");
		stringBuilder.append(" left outer join ci_di_itm M ON M1.ID_DIITM = M.ID_DIITM ");
		stringBuilder.append(" left outer join ci_di X ON M1.Id_Di = X.Id_Di ");
		stringBuilder.append(" left outer join bd_srvca N ON N.Id_Srvca = A.Id_Srvca ");
		stringBuilder.append(" left outer join bd_country O ON O.Id_CountryZONE = B.Id_Country ");
		stringBuilder.append(" left outer join bd_srv P ON P.id_srv = A.Id_Srv ");
		stringBuilder.append(" left outer join bd_udidoc R ON R.Id_Udidoc = Q.Id_Pps ");
		stringBuilder.append(" left outer join en_ent_hp S ON S.ID_ENT = C.Id_Ent ");
		stringBuilder.append(" left outer join bd_udidoc T ON T.Id_Udidoc = B.Id_Nation ");
		stringBuilder.append(" left outer join bd_udidoc U ON U.Id_Udidoc = B.Id_Occu ");
		stringBuilder.append(" left outer join bd_dep VV ON VV.Id_Dep = A.Id_Dep_Mp ");
		stringBuilder.append(" left outer join pi_pat_ca W ON W.Id_Patca = B.Id_Paticate ");
		stringBuilder.append(" left outer join bd_freq Y ON A.Id_Freq = Y.Id_Freq ");
		stringBuilder.append(" left outer join bd_srv_obs V ON V.Id_Srv = A.Id_Srv ");
		stringBuilder.append(" left outer join bd_udidoc Z ON V.Id_Body = Z.Id_Udidoc ");
		stringBuilder.append(" left outer join bd_freq Z1 ON Z1.Id_Freq = A.Id_Freq ");
		stringBuilder.append(" left outer join bd_udidoc P1 ON P.Id_iemsgca = P1.Id_Udidoc ");
		stringBuilder.append(" left outer join ci_or_srv C1 ON A.id_or = C1.id_or and C1.fg_or = 'Y' ");
		stringBuilder.append(" left outer join bd_udidoc Z3 ON (Z3.id_udidoc = ? and Z3.id_udidoclist = ?) ");
		stringBuilder.append(" left outer join ci_or_srv_set Z5 on Z5.id_or = A.id_or and Z5.fg_clinical = 'Y' and Z5.id_body is not null ");
		stringBuilder.append(" left outer join bd_udidoc Z4 ON Z4.Id_Udidoc = Z5.Id_Body ");
		stringBuilder.append(" left outer join BD_ENTP BD ON a.CODE_ENTP = BD.CODE ");
		stringBuilder.append(" left outer join (select "); 
		stringBuilder.append("                  bb.id_pat, ");
		//0184716: 集成平台消息将wm__concat替换为LISTAGG，避免版本不兼容
		stringBuilder.append("                  listagg(TO_CHAR(TO_DATE(substr(aa.dt_act,1,10),'yyyy-MM-dd'),'yyyy-MM-dd') || ':' || aa.name_alcla) within group(order by bb.id_pat) as name_alcla ");
		stringBuilder.append("                  from pi_pat_al aa ");
		stringBuilder.append("                  inner join pi_pat bb on bb.id_pat = aa.id_pat ");
		stringBuilder.append("                  group by bb.id_pat) al ON al.id_pat = B.Id_Pat ");
		stringBuilder.append(" left outer join (select "); 
		stringBuilder.append("                  srv.id_or, ");
		stringBuilder.append("                  ciorder.id_pat, ");
		stringBuilder.append("                  sum(srv.quan_total_medu * srv.pri) as amounts ");
		stringBuilder.append("                  from ci_order ciorder ");
		stringBuilder.append("                  left join ci_or_srv srv on ciorder.id_or = srv.id_or ");
		stringBuilder.append("                  where srv.fg_bl = 'Y' ");
		stringBuilder.append("                  group by ciorder.id_pat, srv.id_or) free on free.id_or = A.id_or ");
		stringBuilder.append(" left outer join BD_UDIDOC do on do.id_udidoc = a.id_srvtp ");
		stringBuilder.append(" where A.id_or ");
		if( str_idor_ris.indexOf(",") == -1){
			stringBuilder.append(" =  ");
			stringBuilder.append(OrdEventUtil.getSqlCondStr(str_idor_ris));
		}else{
			stringBuilder.append(" in  ");
			stringBuilder.append(OrdEventUtil.getSqlInStrsWithOutIn(str_idor_ris));
		}
		return stringBuilder.toString();
	}
	/**
	 * BS002
	 * 住院 签署 检查 联系人 【IEOpRisOrContacterDTO】
	 * @param idOrs
	 * @return
	 */
	public String getIpRisSignContacterInfoSql(String idOrs) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select distinct ");
		stringBuilder.append(" b.code as patient_id, ");//病人主键(此处取编码 和前面查询的数据保持一致， 便于赋值)
		stringBuilder.append(" c.conttel as relation_tel, ");//联系人电话
		stringBuilder.append(" c.name as relation_tel_name ");//联系人姓名
		stringBuilder.append(" from ci_order a ");
		stringBuilder.append(" left join pi_pat b on b.id_pat=a.id_pat ");
		stringBuilder.append(" left join pi_pat_cont c on c.id_pat= b.id_pat ");
		stringBuilder.append(" where a.id_or ");
		stringBuilder.append(idOrs);
		return stringBuilder.toString();
	}
}
