package iih.ci.event.ord.bps.revert.op.sql;
/**
 * 门诊 检验 撤回 BS006
 * @author F
 *
 * @date 2019年9月11日上午11:57:06
 *
 * @classpath iih.ci.event.ord.bps.revert.op.sql.OpLisRevertSql
 */
public class OpLisRevertSql {

	/**
	 * BS006 
	 * 门诊 检验 撤回 所有信息查询sql //就诊【IEOpLisOrEnDTO】 申请单【IEOpLisOrDTO】 医嘱项目【IEOpLisOrItmDTO】
	 * @param ids
	 * @return
	 */
	public String getOpLisWithDrawAllInfoSql(String id_or4sql){
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" addr.zip as add_post_code, ");//邮政编码
	    stringBuilder.append(" al.name_alcla as allergy, ");//过敏史
	    stringBuilder.append(" card.code as health_card_no, ");//健康卡号
	    stringBuilder.append(" (case when phy2.code = '04' then 'true' else 'false' end) as is_breastfeeding, ");//是否哺乳
	    stringBuilder.append(" (case when phy.code = '02' then 'true' else 'false' end) as is_pregnancy, ");//是否妊娠
	    stringBuilder.append(" '' as pregnancy_date, ");//妊娠时间
	    stringBuilder.append(" C.Id_Ent as id_ent, ");//就诊id
	    stringBuilder.append(" A.id_en as id_ielisoren, ");//就诊id
	    stringBuilder.append(" B.code as patient_id, ");//患者ID
	    stringBuilder.append(" b.barcode_chis as p_bar_code, ");//就诊号
	    stringBuilder.append(" E.code as ward_code, ");//病区编码
	    stringBuilder.append(" E.name as ward_code_name, ");//病区名
	    stringBuilder.append(" F.NAME_BED as bed_no, ");//床号
	    stringBuilder.append(" B.Id_Code as social_no, ");//身份证号
	    stringBuilder.append(" C.Name_Pat as name, ");//患者姓名
	    stringBuilder.append(" B.Tel as home_tel, ");//联系电话
	    stringBuilder.append(" B.Mob as cellphone, ");//移动电话
	    stringBuilder.append(" C.Sd_Sex_Pat as sex, ");//性别代码
	    stringBuilder.append(" B.DT_BIRTH_HMS as birthday, ");//出生日期
	    stringBuilder.append(" '' as age, ");//年龄
	    stringBuilder.append(" C.Addr_Pat as home_street, ");//家庭住址
	    stringBuilder.append(" '' as work_place_code, ");//工作单位代码
	    stringBuilder.append(" D.Code as patient_deptcode, ");//病人科室编码
	    stringBuilder.append(" D.NAME as patient_deptname, ");//病人科室名称
	    stringBuilder.append(" B.Workunit as work_place, ");//工作单位名称
	    stringBuilder.append(" G.ORGCODE as hospital_code, ");//医疗机构代码
	    stringBuilder.append(" G.Name as hospital_name, ");//医疗机构名称
	    stringBuilder.append(" A.Dt_Entry as enter_date, ");//开单时间
	    stringBuilder.append(" K.Code as apply_doctor, ");//开单医生编码
	    stringBuilder.append(" K.Name as apply_doctor_name, ");//开单医生姓名
	    stringBuilder.append(" L.Code as apply_unit, ");//申请科室编码
	    stringBuilder.append(" L.Name as apply_unit_name, ");//申请科室名称
	    stringBuilder.append(" A.Dt_Sign as confirm_date, ");//确认时间
	    stringBuilder.append(" H.Code as confirm_opera, ");//确认人编码
	    stringBuilder.append(" H.Name as confirm_opera_name, ");//确认人姓名
	    stringBuilder.append(" A.Dt_Effe as input_begindate, ");//录入日期开始时间
	    stringBuilder.append(" A.Dt_End as input_enddate, ");//录入日期结束时间
	    stringBuilder.append(" H.Code as input_opera, ");//录入人
	    stringBuilder.append(" H.Name as input_opera_name, ");//录入人姓名
	    stringBuilder.append(" (case when F.Times_Ip is null then 0 else F.Times_Ip end) + (case when J.Times_Op is null then 0 else J.Times_Op end) as times, ");//就诊次数
	    stringBuilder.append(" W.code as visit_type, ");//病人类型编码
	    stringBuilder.append(" W.Name as visit_type_name, ");//病人类型名称
	    stringBuilder.append(" G.CODE as yq_code, ");//就诊院区编码
	    stringBuilder.append(" G.Name as yz_code_name, ");//就诊院区名称
	    stringBuilder.append(" M.ID_DIDEF_CODE as diag_code, ");//疾病代码
	    stringBuilder.append(" M.ID_DIDEF_NAME as diag_str, ");//疾病名称
	    stringBuilder.append(" '' as id_ielisoritms, ");
	    stringBuilder.append(" Q.NO_APPLYFORM as jy_applyserial1, ");//检验申请单编号
	    stringBuilder.append(" N.Code as order_type, ");//医嘱类型
	    stringBuilder.append(" N.Name as order_type_name, ");//医嘱类型名称
	    stringBuilder.append(" A.Dt_Effe as apply_date, ");//检验申请日期
	    stringBuilder.append(" '' as is_private, ");//是否隐私
	    stringBuilder.append(" (case when M.FG_MAJDI = 'Y' then '12' when M.FG_MAJDI = 'N' then '13' else '' end) as diag_type, ");//诊断类别
	    stringBuilder.append(" (case when M.FG_MAJDI = 'Y' then '主要诊断' when M.FG_MAJDI = 'N' then '次要诊断' else '' end) as diag_type_name, ");//诊断类别名称
	    stringBuilder.append(" M.ID_DIDEF_CODE as diag_name, ");//疾病名称(冗余)
	    stringBuilder.append(" Q.ID_ORLAB as id_ielisoritm, ");//检验单id
	    stringBuilder.append(" A.Id_Or as id_ielisor, ");//医嘱id
	    stringBuilder.append(" A.Code_Or as yz_no, ");//医嘱号
	    stringBuilder.append(" P.code as jy_applyserial, ");//检验项目编码
	    stringBuilder.append(" P.name as jyname, ");//检验项目名称
	    stringBuilder.append(" '' as priority, ");//检验项目优先级别
	    stringBuilder.append(" A.Dt_Effe as yz_start_date, ");//医嘱开始时间
	    stringBuilder.append(" A.Dt_End as yz_stop_date, ");//医嘱停止时间
	    stringBuilder.append(" X.Code as yz_frequency, ");//医嘱执行频率编码
	    stringBuilder.append(" X.Name as yz_frequency_name, ");//医嘱执行频率名称
	    stringBuilder.append(" Q.Sd_Pps as descp_code, ");//检验描述编码
	    stringBuilder.append(" R.Name as description, ");//检验描述名称
	    stringBuilder.append(" '' as collect_ragion, ");//采集部位
	    stringBuilder.append(" lis.code_app as sample_id, ");//标本号
	    stringBuilder.append(" Q.Sd_Samptp as sample_class, ");//标本类型编码
	    stringBuilder.append(" S.Name as sample_code_name, ");//标本类型名称
	    stringBuilder.append(" '' as collect_time, ");//采集日期
	    stringBuilder.append(" Q.SD_CONTP as container_code, ");//测试项目容器类型
	    stringBuilder.append(" T.Name as container_code_name, ");//测试项目容器名称
	    stringBuilder.append(" '' as collecter_code, ");//采集人id
	    stringBuilder.append(" '' as collecter_code_name, ");//采集人姓名
	    stringBuilder.append(" '' as collecter_place, ");//采集地点
	    stringBuilder.append(" V.Code as exec_code, ");//执行科室编码
	    stringBuilder.append(" V.Name as exec_code_name, ");//执行科室名称
	    stringBuilder.append(" Z4.price_ratio as test_price, ");//测试项目价格
	    stringBuilder.append(" '' as supply_price, ");//耗材价格
	    stringBuilder.append(" '' as commenttp, ");//备注类型
	    stringBuilder.append(" Q.ANNOUNCEMENTS as sample_request, ");//标本要求
	    stringBuilder.append(" '' as isstest, ");//是否皮试
	    stringBuilder.append(" '' as stest, ");//是否皮试结果
	    stringBuilder.append(" (case when A.Fg_Urgent = 'Y' then '1' else '0' end) as is_em, ");//是否加急
	    stringBuilder.append(" (case when A.Fg_Urgent = 'Y' then 'true' else 'false' end) as is_em_r, ");//是否加急结果
	    stringBuilder.append(" '' as isyg, ");//是否药观
	    stringBuilder.append(" '' as yg, ");//是否药观结果
	    stringBuilder.append(" P.sd_iemsgca as iemsgca_code, ");//集成平台服务分类
	    stringBuilder.append(" (case when Z3.name = '未记账' then '099' when Z3.name = '已记账' then P1.name end) as iemsgca_name, ");//集成平台服务分类名称
	    stringBuilder.append(" P1.ctrl1 as iemsgca_typename, ");//集成消息类型名称
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as Ordertimetypename, ");//医嘱时间类型名称
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as Ordertimetypecode, ");//医嘱时间类型编码
	    stringBuilder.append(" C.code as Visitordno, ");//就诊流水号
	    stringBuilder.append(" a.code_entp as Visittype, ");//就诊类型编码
	    stringBuilder.append(" BD.name as Visittypename ");//就诊类型名称
	    stringBuilder.append(" from ci_ap_lab Q ");
	    stringBuilder.append(" left outer join ci_order A on Q.Id_Or = A.Id_Or ");
	    stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
	    stringBuilder.append(" left outer join pi_pat_card card ON A.Id_Pat = card.Id_Pat and card.fg_act = 'Y' and card.sd_patcardtp = '05' ");
	    stringBuilder.append(" left outer join pi_pat_cardtp cardtp ON cardtp.id_cardtp = card.id_patcardtp and cardtp.sd_patcardtp = '05' ");
	    stringBuilder.append(" left outer join (select z0.id_pat, d0.code, z0.sv ");
	    stringBuilder.append("                  from pi_pat_phy z0 ");
	    stringBuilder.append("                  left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind ");
	    stringBuilder.append("                  where d0.code = '02') phy ON phy.Id_Pat = B.Id_Pat ");
	    stringBuilder.append(" left outer join (select z0.id_pat, d0.code ");
	    stringBuilder.append("                  from pi_pat_phy z0 ");
	    stringBuilder.append("                  left join pi_pat_phyind d0 ");
	    stringBuilder.append("                  on d0.id_patphyind = z0.id_patphyind ");
	    stringBuilder.append("                  where d0.code = '04') phy2 on phy2.Id_Pat = B.Id_Pat ");
	    stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
	    stringBuilder.append(" left outer join bd_dep D ON C.Id_Dep_Phy = D.ID_DEP ");
	    stringBuilder.append(" left outer join bd_dep E ON C.Id_Dep_Nur = E.Id_Dep ");
	    stringBuilder.append(" left outer join en_ent_ip F ON C.Id_Ent = F.Id_Ent ");
	    stringBuilder.append(" left outer join bd_org G ON A.Id_Org = G.Id_Org ");
	    stringBuilder.append(" left outer join bd_psndoc H ON H.Id_Psndoc = A.Id_Emp_Sign ");
	    stringBuilder.append(" left outer join bd_entp I ON I.Id_Entp = A.Id_Entp ");
	    stringBuilder.append(" left outer join en_ent_op J ON A.Id_En = J.Id_Ent ");
	    stringBuilder.append(" left outer join bd_psndoc K ON K.Id_Psndoc = A.Id_Emp_Or ");
	    stringBuilder.append(" left outer join bd_dep L ON A.Id_Dep_Or = L.ID_DEP ");
	    stringBuilder.append(" left outer join en_ent_di M1 ON A.Id_En = M1.Id_Ent ");
	    stringBuilder.append(" left outer join ci_di_itm M ON M1.ID_DIITM = M.ID_DIITM ");
	    stringBuilder.append(" left outer join bd_srvca N ON N.Id_Srvca = A.Id_Srvca ");
	    stringBuilder.append(" left outer join ci_rpt_lab O ON Q.Id_Orlab = O.Id_Orlab ");
	    stringBuilder.append(" left outer join bd_srv P ON P.id_srv = A.Id_Srv ");
	    stringBuilder.append(" left outer join bd_udidoc R ON R.Id_Udidoc = Q.Id_Pps ");
	    stringBuilder.append(" left outer join bd_udidoc S ON S.Id_Udidoc = Q.Id_Samptp ");
	    stringBuilder.append(" left outer join bd_udidoc T ON T.Id_Udidoc = Q.Id_Contp ");
	    stringBuilder.append(" left outer join bd_udidoc U ON U.Id_Udidoc = Q.Id_Colltp ");
	    stringBuilder.append(" left outer join bd_dep V ON V.Id_Dep = A.Id_Dep_Mp ");
	    stringBuilder.append(" left outer join pi_pat_ca W ON W.Id_Patca = B.Id_Paticate ");
	    stringBuilder.append(" left outer join bd_freq X ON X.Id_Freq = A.Id_Freq ");
	    stringBuilder.append(" left outer join bd_udidoc P1 ON P.Id_iemsgca = P1.Id_Udidoc ");
	    stringBuilder.append(" left outer join bd_udidoc Z3 ON (Z3.id_udidoc = ? and Z3.id_udidoclist = ?) ");
	    stringBuilder.append(" left outer join view_price_rp Z4 ON Z4.Id_Srv = A.Id_Srv and Z4.id_pripat = C.Id_Pripat ");
	    stringBuilder.append(" left outer join BD_ENTP BD ON a.CODE_ENTP = BD.CODE ");
	    stringBuilder.append(" left outer join (select "); 
	    stringBuilder.append("                  bb.id_pat, ");
		//0184716: 集成平台消息将wm__concat替换为LISTAGG，避免版本不兼容
	    stringBuilder.append("                  listagg(TO_CHAR(TO_DATE(substr(aa.dt_act,1,10),'yyyy-MM-dd'),'yyyy-MM-dd') || ':' || aa.name_alcla) within group(order by bb.id_pat) as name_alcla ");
	    stringBuilder.append("                  from pi_pat_al aa ");
	    stringBuilder.append("                  inner join pi_pat bb on bb.id_pat = aa.id_pat ");
	    stringBuilder.append("                  group by bb.id_pat) al ON al.id_pat = B.Id_Pat ");
	    stringBuilder.append(" left outer join pi_pat_addr addr on addr.id_admdiv = c.id_admdiv_addr and addr.id_pat = c.id_pat and addr.sd_addrtp = '9' ");
	    stringBuilder.append(" left join ci_app_lis_or lisor on lisor.id_orlab = q.id_orlab ");
	    stringBuilder.append(" left join ci_app_lis lis on lisor.id_ciapplissheet = lis.id_ciapplissheet ");
	    stringBuilder.append(" where M1.Fg_Maj = 'Y' ");
	    stringBuilder.append(" and A.Id_Or ");
		stringBuilder.append(id_or4sql);
		return stringBuilder.toString();
	}
}
