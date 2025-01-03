package iih.ci.event.ord.bps.sign.op.sql;
/**
 * 门诊 签署 检验sql查询 BS006
 * @author F
 *
 * @date 2019年8月19日下午3:58:24
 *
 * @classpath iih.ci.event.ord.bps.sign.op.sql.OpLisSignSql
 */
public class OpLisSignSql {

	/**
	 * BS006
	 * 门诊 检验 签署 就诊信息【IEOpLisOrEnDTO】
	 * @param id_or4sql
	 * @return
	 */
	public String getOpLisSignEntInfoSql(String id_or4sql){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" a.id_or as id_or,");//医嘱id
		stringBuilder.append(" a.code_or as yz_no, ");//医嘱号 
		stringBuilder.append(" b.code as patient_id, ");//患者id 
		stringBuilder.append(" b.barcode_chis as p_bar_code,");//就诊号 
		stringBuilder.append(" c.code as visitordno,");//就诊流水号
		stringBuilder.append(" (case when F.Times_Ip is null then 0 else F.Times_Ip end) +(case when s.Times_Op is null then 0 else s.Times_Op end) as times, ");//就诊次数 
		stringBuilder.append(" a.code_entp as Visittype, ");//就诊类型编码 
		stringBuilder.append(" d.name as Visittypename, ");//就诊类型名称
		stringBuilder.append(" e.code as ward_code, ");//病区编码
		stringBuilder.append(" e.name as ward_code_name, ");//病区名 
		stringBuilder.append(" f.name_bed as bed_no, ");//床号
		stringBuilder.append(" (select code from pi_pat_card card where A.Id_Pat = card.Id_Pat and card.fg_act = 'Y' and card.sd_patcardtp = '05' and rownum<=1) health_card_no, ");//健康卡号
		stringBuilder.append(" c.name_pat as name, ");//患者姓名
		stringBuilder.append(" b.tel as home_tel, ");//联系电话
		stringBuilder.append(" b.mob as cellphone, ");//移动电话
		stringBuilder.append(" c.sd_sex_pat as sex, ");//性别代码
		stringBuilder.append(" b.dt_birth_hms as birthday, ");//出生日期 
		stringBuilder.append(" '' as age, ");//年龄
		stringBuilder.append(" c.addr_pat as home_street, ");//家庭住址 
		stringBuilder.append(" i.zip as post_code, ");//邮政编码
		stringBuilder.append(" '' as work_place_code, ");//工作单位代码 
		stringBuilder.append(" b.workunit as work_place, ");//工作单位名称 
		stringBuilder.append(" j.code as patient_deptcode, ");//病人科室编码
		stringBuilder.append(" j.name as patient_deptname, ");//病人科室名称
		stringBuilder.append(" k.orgCode as hospital_code, ");//医疗机构代码
		stringBuilder.append(" k.name as hospital_name, ");//医疗机构名称 
		stringBuilder.append(" A.dt_entry as enter_date, ");//开单时间
		stringBuilder.append(" l.code as apply_doctor, ");//开单医生编码
		stringBuilder.append(" l.name as apply_doctor_name, ");//开单医生姓名
		stringBuilder.append(" m.code as apply_unit, ");//申请科室编码 
		stringBuilder.append(" m.name as apply_unit_name, ");//申请科室名称 
		stringBuilder.append(" n.code as exec_code, ");//执行科室编码
		stringBuilder.append(" A.dt_Sign as confirm_date, ");//确认时间 
		stringBuilder.append(" o.code as confirm_opera, ");//确认人编码
		stringBuilder.append(" o.name as confirm_opera_name, ");//确认人姓名
		stringBuilder.append(" a.dt_effe as input_begindate, ");//录入日期 开始时间
		stringBuilder.append(" a.dt_end as input_enddate, ");//录入日期 结束时间 
		stringBuilder.append(" o.code as input_opera, ");//录入人
		stringBuilder.append(" o.name as input_opera_name, ");//录入人姓名
		stringBuilder.append(" ");//就诊院区编码
		stringBuilder.append(" ");//就诊院区名称
		stringBuilder.append(" (case when q.fg_majdi='Y' then '12' when q.fg_majdi='N' then '13' else '' end) as diag_type, ");//诊断类别
		stringBuilder.append(" (case when q.fg_majdi='Y' then '主要诊断' when q.fg_majdi='N' then '次要诊断' else '' end) as diag_type_name, ");//诊断类别名称
		stringBuilder.append(" q.id_didef_code as diag_code, ");//疾病代码
		stringBuilder.append(" q.id_didef_name as diag_str, ");//疾病名称
		stringBuilder.append(" r.name_alcla as allergy, ");//过敏史 
		stringBuilder.append(" '01' as Domain_id, ");//域id
		stringBuilder.append(" B.Id_Code as social_no ");//身份证号(不一定身份证 其他证件号也可)
		stringBuilder.append(" from ci_order a ");
		stringBuilder.append(" left join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left join en_ent c on c.id_ent=a.id_en ");
		stringBuilder.append(" left join bd_entp d on a.code_entp=d.code ");
		stringBuilder.append(" left join bd_dep e on c.id_dep_nur=e.id_dep ");
		stringBuilder.append(" left join en_ent_ip f on c.id_ent=f.id_ent ");
		stringBuilder.append(" left join pi_pat_addr i on i.id_admdiv=c.id_admdiv_addr and i.id_pat=c.id_pat and i.sd_addrtp='9' ");
		stringBuilder.append(" left join bd_dep j on c.id_dep_phy=j.id_dep ");
		stringBuilder.append(" left join bd_org k on A.id_org=k.id_org ");
		stringBuilder.append(" left join bd_psndoc l on l.id_psndoc=a.id_emp_or ");
		stringBuilder.append(" left join bd_dep m on A.id_dep_or=m.id_dep ");
		stringBuilder.append(" left join bd_dep n on n.id_dep=A.id_dep_mp ");
		stringBuilder.append(" left join bd_psndoc o on o.id_psndoc=a.id_emp_sign ");
		stringBuilder.append(" left join en_ent_di p ON A.id_en = p.id_ent ");
		stringBuilder.append(" left join ci_di_itm q ON p.id_diitm=q.id_diitm ");
		//0184716: 集成平台消息将wm__concat替换为LISTAGG，避免版本不兼容
		stringBuilder.append(" left join (select  bb.id_pat,listagg(TO_CHAR(TO_DATE( substr(aa.dt_act, 1, 10),'yyyy-MM-dd'),'yyyy-MM-dd') ||':'||  aa.name_alcla) within group(order by bb.id_pat) as name_alcla from pi_pat_al aa inner join pi_pat bb on bb.id_pat=aa.id_pat group by  bb.id_pat) r ON r.id_pat = B.Id_Pat ");
		stringBuilder.append(" left join en_ent_op s ON A.Id_En=s.Id_Ent ");
		stringBuilder.append(" where p.Fg_Maj='Y' and a.id_or ");
		stringBuilder.append(id_or4sql);
		return stringBuilder.toString();
	}
	/**
	 * BS006
	 * 门诊 检验 签署 申请单信息【IEOpLisOrDTO】
	 * @param id_or4sql
	 * @return
	 */
	public String getOpLisSignApplyInfoSql(String id_or4sql){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" b.id_or as id_or, ");//医嘱id
		stringBuilder.append(" b.code_or as yz_no, ");//医嘱号
		stringBuilder.append(" a.NO_APPLYFORM as jy_applyserial1, ");//检验申请单编号
		stringBuilder.append(" c.Code as order_type, ");//医嘱类型
		stringBuilder.append(" c.Name as order_type_name, ");//医嘱类型名称
		stringBuilder.append(" b.Dt_Effe as apply_date, ");//检验申请日期
		stringBuilder.append(" '' as is_private, ");//是否隐私
		stringBuilder.append(" ");//报告备注类型
		stringBuilder.append(" ");//报告备注
		stringBuilder.append(" ");//药观编码
		stringBuilder.append(" ");//药观名称
		stringBuilder.append(" d.sd_iemsgca as iemsgca_code, ");//集成平台服务分类
		stringBuilder.append(" (case when f.name='未记账' then '099' when f.name='已记账' then  e.name end) as iemsgca_name , ");//集成平台服务分类名称
		stringBuilder.append(" e.ctrl1 as iemsgca_typename, ");//集成消息类型
		stringBuilder.append(" b.id_en as id_ielisoren ");//就诊id
		stringBuilder.append(" from ci_ap_lab a ");
		stringBuilder.append(" left join ci_order b on b.id_or=a.id_or ");
		stringBuilder.append(" left join bd_srvca c on c.Id_Srvca=b.Id_Srvca ");
		stringBuilder.append(" left join bd_srv d on d.id_srv=b.id_srv ");
		stringBuilder.append(" left outer join bd_udidoc e ON d.Id_iemsgca = e.Id_Udidoc ");
		stringBuilder.append(" left outer join bd_udidoc f ON (f.id_udidoc = ? and f.id_udidoclist = ? ) ");
		stringBuilder.append(" where  a.id_or ");
		stringBuilder.append(id_or4sql);
		return stringBuilder.toString();
	}
	/**
	 * BS006
	 * 门诊 检验 签署 医嘱项目信息【IEOpLisOrItmDTO】
	 * @param id_or4sql
	 * @return
	 */
	public String getOpLisSignOrdItmInfoSql(String id_or4sql){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" a.id_or as id_or, ");//医嘱id
		stringBuilder.append(" a.code_or as yz_no, ");//医嘱号
		stringBuilder.append(" b.code as jy_applyserial, ");//检验项目编码
		stringBuilder.append(" b.name as jyname, ");//检验项目名称
		stringBuilder.append(" '' as Priority, ");//检验项目优先级别
		stringBuilder.append(" A.Dt_Effe as yz_start_date, ");//医嘱开始时间
		stringBuilder.append(" A.Dt_End as yz_stop_date, ");//医嘱停止时间
		stringBuilder.append(" c.Code as yz_frequency, ");//医嘱执行频率编码
		stringBuilder.append(" c.Name as yz_frequency_name, ");//医嘱执行频率名称
		stringBuilder.append(" d.Sd_Pps as descp_code, ");//检验描述编码
		stringBuilder.append(" e.Name as description, ");//检验描述名称
		stringBuilder.append(" '' as collect_ragion, ");//采集部位
		stringBuilder.append(" '' as collecter_code, ");//采集人id
		stringBuilder.append(" '' as collecter_code_name, ");//采集人姓名
		stringBuilder.append(" '' as collecter_place, ");//采集地点
		stringBuilder.append(" g.code_app as sample_id, ");//标本条码号
		stringBuilder.append(" d.Sd_Samptp as sample_class, ");//标本类型编码
		stringBuilder.append(" o.Name as sample_code_name, ");//标本类型名称
		stringBuilder.append(" d.SD_CONTP as container_code, ");//测试项目容器类型
		stringBuilder.append(" h.Name as container_code_name, ");//测试项目容器名称
		stringBuilder.append(" i.Code as exec_code, ");//执行科室编码
		stringBuilder.append(" i.Name as exec_code_name, ");//执行科室名称
		stringBuilder.append(" '' as isstest, ");//是否皮试
		stringBuilder.append(" '' as stest, ");//皮试结果
		stringBuilder.append(" (case when A.Fg_Urgent='Y' then '1' else '0' end) as is_em, ");//是否加急
		stringBuilder.append(" (case when A.Fg_Urgent='Y' then 'true' else 'false' end) as is_em_r, ");//是否加急结果
		stringBuilder.append(" '' as isyg, ");//是否药观
		stringBuilder.append(" '' as yg, ");//药观结果
		stringBuilder.append(" ");//身高
		stringBuilder.append(" ");//体重
		stringBuilder.append(" (case when l.code='04' then 'true' else 'false' end) as is_breastfeeding, ");//是否哺乳
		stringBuilder.append(" (case when k.code='02' then 'true' else 'false' end) as is_pregnancy, ");//是否妊娠
		stringBuilder.append(" '' as pregnancy_date, ");//妊娠时间
		stringBuilder.append(" ");//先诊疗后付费类型编码
		stringBuilder.append(" ");//先诊疗后付费类型名称
		stringBuilder.append(" ");//收费状态标识
		stringBuilder.append(" ");//HIS执行状态
		stringBuilder.append(" ");//业务操作时间
		stringBuilder.append(" (case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as Ordertimetypecode, ");//医嘱时间类型编码
		stringBuilder.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as Ordertimetypename, ");//医嘱时间类型名称
		stringBuilder.append(" ");//临床路径项目编号
		stringBuilder.append(" ");//临床路径项目序号
		stringBuilder.append(" n.price_ratio as test_price, ");//测试项目价格
		stringBuilder.append(" ");//耗材价格
		stringBuilder.append(" ");//备注类型
		stringBuilder.append(" d.ANNOUNCEMENTS as sample_request ");//标本要求
		stringBuilder.append(" from ci_order a ");
		stringBuilder.append(" left join bd_srv b on b.id_srv=a.id_srv ");
		stringBuilder.append(" left join bd_freq c ON c.Id_Freq=A.Id_Freq ");
		stringBuilder.append(" left join ci_ap_lab d on d.id_or=a.id_or ");
		stringBuilder.append(" left join bd_udidoc e ON e.Id_Udidoc=d.Id_Pps ");
		stringBuilder.append(" left join ci_app_lis_or f on f.id_orlab=d.id_orlab ");
		stringBuilder.append(" left join ci_app_lis g on f.id_ciapplissheet=g.id_ciapplissheet ");
		stringBuilder.append(" left join bd_udidoc h ON h.Id_Udidoc=d.Id_Contp ");
		stringBuilder.append(" left join bd_dep i ON i.Id_Dep=A.Id_Dep_Mp ");
		stringBuilder.append(" left join pi_pat j on j.id_pat=a.id_pat ");
		stringBuilder.append(" left join (select z0.id_pat,d0.code,z0.sv from pi_pat_phy z0 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind where d0.code='02') k ON k.Id_Pat = j.Id_Pat ");//怀孕/妊娠
		stringBuilder.append(" left join (select z0.id_pat,d0.code from pi_pat_phy z0 left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind where d0.code='04') l on l.Id_Pat = j.Id_Pat ");//哺乳
		stringBuilder.append(" left join en_ent m on m.id_ent=a.id_en ");
		stringBuilder.append(" left join view_price_rp n ON n.Id_Srv=A.Id_Srv and n.id_pripat = m.Id_Pripat ");
		stringBuilder.append(" left join bd_udidoc o ON o.Id_Udidoc=d.Id_Samptp ");
		stringBuilder.append(" where a.id_or ");
		stringBuilder.append(id_or4sql);
		return stringBuilder.toString();
	}
}
