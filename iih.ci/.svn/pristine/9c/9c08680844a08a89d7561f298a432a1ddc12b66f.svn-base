package iih.ci.event.ord.bps.sign.ip.sql;
/**
 * 住院 签署 护理 sql查询 BS304
 * @author F
 *
 * @date 2019年8月28日下午2:12:23
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.sql.IpNsSignSql
 */
public class IpNsSignSql {

	/**
	 * BS304
	 * 住院签署 护理 就诊信息 【IENsOrEnDTO】
	 * @return
	 */
	public String getIpOpSignEntInfoSql(String id_or4sql){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select distinct ");
		stringBuilder.append(" A.Id_En as id_iensoren, ");//就诊id
		stringBuilder.append(" a.id_or as id_or, ");//医嘱id 用于关联
	    stringBuilder.append(" B.code as patientid, ");//患者ID
	    stringBuilder.append(" C.Name_Pat as name, ");//患者姓名
	    stringBuilder.append(" C.Sd_Sex_Pat as sexid, ");//性别编码
	    stringBuilder.append(" '' as age, ");//年龄
	    stringBuilder.append(" B.DT_BIRTH_HMS as birthdaydate, ");//出生日期
	    stringBuilder.append(" B.code_amr_ip as patientseqnum, ");//就诊号B.code_amr_ip
	    stringBuilder.append(" (case when H.Times_Ip is null then 0 else H.Times_Ip end) + (case when J.Times_Op is null then 0 else J.Times_Op end) as admiss_times, ");//就诊次数
	    stringBuilder.append(" I.Code as deptcode, ");//病人科室编码
	    stringBuilder.append(" I.Name as deptname, ");//病人科室名称
	    stringBuilder.append(" G.Code as wardcode, ");//病区编码
	    stringBuilder.append(" G.Name as wardname, ");//病区名称
	    stringBuilder.append(" H.NAME_BED as bedcode, ");//床位号
	    stringBuilder.append(" A.Dt_Chk as confirm_date, ");//医嘱确认时间
	    stringBuilder.append(" R.Code as confirm_nurse_code, ");//确认护士编码
	    stringBuilder.append(" R.Name as confirm_nurse_name, ");//确认护士姓名
	    stringBuilder.append(" '01' as domain_id, ");//域id
	    stringBuilder.append(" D.orgcode as orgcode, ");//医疗机构编码
	    stringBuilder.append(" D.name as orgname, ");//医疗机构名称
	    stringBuilder.append(" C.code as visit_sort_no, ");//就诊流水号
	    stringBuilder.append(" a.code_entp as visit_type_code, ");//就诊类别编码
	    stringBuilder.append(" BD.name as visit_type_name, ");//就诊类别名称
	    stringBuilder.append(" x.code as apply_code ");//申请科室编码
		stringBuilder.append(" from ci_order A ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		stringBuilder.append(" left outer join en_ent_ip H ON C.Id_Ent = H.Id_Ent ");
		stringBuilder.append(" left outer join en_ent_op J ON A.Id_En = J.Id_Ent ");
		stringBuilder.append(" left outer join bd_dep G ON G.Id_Dep = C.Id_Dep_Nur ");
		stringBuilder.append(" left outer join bd_dep I ON I.Id_Dep = C.Id_Dep_Phy ");
		stringBuilder.append(" left outer join bd_psndoc R ON R.Id_Psndoc = A.Id_Emp_Chk ");
		stringBuilder.append(" left outer join bd_org D ON D.Id_org = A.Id_org ");
		stringBuilder.append(" left outer join bd_dep X ON X.Id_Dep = A.Id_Dep_Or ");
		stringBuilder.append(" left outer join BD_ENTP BD ON a.CODE_ENTP = BD.CODE ");
		stringBuilder.append(" where A.id_or ");
		stringBuilder.append(id_or4sql);
		return stringBuilder.toString();
	}
	/**
	 * BS304
	 * 住院签署 护理 医嘱信息 【IENsOrDTO】
	 * @return
	 */
	public String getIpOpSignOrdInfoSql(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select distinct ");
		stringBuilder.append(" a1.sd_su_bl  as pay_flag, ");//收费状态标识
	    stringBuilder.append(" e.sd_iemsgca as sd_iemsgca, ");//集成平台服务分类
	    stringBuilder.append(" A.Id_Or      as id_iensor, ");//医嘱id
	    stringBuilder.append(" A.Id_En      as id_iensoren, ");//就诊id
	    stringBuilder.append(" A.code_or    as order_code, ");//医嘱号
	    stringBuilder.append(" D.Code       as order_type_code, ");//医嘱类别编码
	    stringBuilder.append(" D.Name       as order_type_name, ");//医嘱类别名称
	    stringBuilder.append(" H.code       as yz_dept_code, ");//医嘱原科室编码
	    stringBuilder.append(" H.name       as yz_dept_name, ");//医嘱原科室名称
	    stringBuilder.append(" I.code       as yz_ward_code, ");//医嘱原病区编码
	    stringBuilder.append(" I.name       as yz_ward_name, ");//医嘱原病区名称
	    stringBuilder.append(" E.code       as yz_code, ");//医嘱编码
	    stringBuilder.append(" E.name       as yz_name, ");// 医嘱名称
	    stringBuilder.append(" A1.Note_Srv  as yz_memo, ");//医嘱备注
	    stringBuilder.append(" A1.Quan_Medu as yz_unit, ");//数量
	    stringBuilder.append(" F.code       as yz_unit_code, ");//数量单位
	    stringBuilder.append(" G.code       as fre_no, ");//执行频率编码
	    stringBuilder.append(" G.name       as fre_name, ");//执行频率
	    stringBuilder.append(" A.Dt_Effe    as yz_start_time, ");//开始时间
	    stringBuilder.append(" A.Dt_End     as yz_stop_time, ");//停止时间
	    stringBuilder.append(" J.code       as yz_doctor_code, ");//开嘱医生编码
	    stringBuilder.append(" J.name       as yz_doctor_name, ");//开嘱医生姓名
	    stringBuilder.append(" A.Dt_Entry   as yz_date, ");//开嘱时间
	    stringBuilder.append(" L.code as exe_dept_code, ");//执行科室编码
	    stringBuilder.append(" L.name as exe_dept_name, ");//执行科室名称
	    stringBuilder.append(" '' as jt, ");//嘱托
	    stringBuilder.append(" '' as hc_order_type_code, ");//互斥类型编码
	    stringBuilder.append(" '' as hc_order_type_name, ");//互斥类型名称
	    stringBuilder.append(" '' as f_order_code, ");//父医嘱号
	    stringBuilder.append(" K.Code as yz_confirm_doctor_code, ");//确认医生编码
	    stringBuilder.append(" K.name as yz_confirm_doctor_name, ");//确认医生名称
	    stringBuilder.append(" A.Dt_Chk as yz_confirm_date, ");//确认时间
	    stringBuilder.append(" '' as fybj_code, ");//费用标记编码
	    stringBuilder.append(" '' as fybj_name, ");//费用标记名称
	    stringBuilder.append(" A1.Pri as jg, ");//价格
	    stringBuilder.append(" F.Name as jgdw, ");//价格单位
	    stringBuilder.append(" (case when A1.Fg_Skintest = 'Y' then 'true' else 'false' end) as is_ps, ");//是否皮试
	    stringBuilder.append(" (case when A1.Fg_Skintest = 'Y' then '需皮试' when A1.Fg_Skintest = 'N' then '不需皮试' else '' end) as is_psresult, ");//是否皮试结果
	    stringBuilder.append(" (case when A1.Fg_Indic = 'Y' then 'true' else 'false' end) as is_syz, ");//是否适应症
	    stringBuilder.append(" (case when A1.Fg_Indic = 'Y' then '适应症' when A1.Fg_Indic = 'N' then '非适应症' else '' end) as is_syzresult, ");//是否适应症结果
	    stringBuilder.append(" (case when G.Sd_Frequnitct = '0' and G.Code = 'ST' then 'true' else 'false' end) as is_jj, ");//是否加急
	    stringBuilder.append(" (case when A.Fg_Urgent = 'Y' then '加急' when A.Fg_Urgent = 'N' then '非加急' else '' end) as is_jjresult, ");//是否加急结果
	    stringBuilder.append(" '' as is_yg, ");//是否药观
	    stringBuilder.append(" '' as is_ygresult, ");//是否药观结果
	    stringBuilder.append(" null as route_code, ");//临床路径项目编码
	    stringBuilder.append(" null as route_no, ");//临床路径项目序号
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as order_time_type_name, ");//医嘱时间类型名称
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as order_time_type, ");//医嘱时间类型编码
	    stringBuilder.append(" A.des_or as yz_memo ");//医嘱备注
		stringBuilder.append(" from ci_or_srv A1 ");
		stringBuilder.append(" left outer join ci_order A ON A1.Id_Or = A.Id_Or ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		stringBuilder.append(" left outer join bd_srvca D ON A1.Id_Srvca = D.Id_Srvca ");
		stringBuilder.append(" left outer join bd_srv E ON E.Id_Srv = A1.Id_Srv ");
		stringBuilder.append(" left outer join bd_measdoc F ON F.Id_Measdoc = A1.Id_Medu ");
		stringBuilder.append(" left outer join bd_freq G ON G.Id_Freq = A1.Id_Freq ");
		stringBuilder.append(" left outer join bd_dep H ON H.Id_Dep = C.Id_Dep_Phy ");
		stringBuilder.append(" left outer join bd_dep I ON I.Id_Dep = C.Id_Dep_Nur ");
		stringBuilder.append(" left outer join bd_psndoc J ON J.Id_Psndoc = A1.Id_Emp_Srv ");
		stringBuilder.append(" left outer join bd_psndoc K ON K.Id_Psndoc = A.Id_Emp_Chk ");
		stringBuilder.append(" left outer join bd_dep L ON L.Id_Dep = A1.Id_Dep_Mp ");
		stringBuilder.append(" where %1$s ");
		stringBuilder.append(" and A1.Fg_or = 'Y' ");
		return stringBuilder.toString();
	}
}
