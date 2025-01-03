package iih.ci.event.ord.bps.sign.ip.sql;
/**
 * 住院 签署 其他sql查询 BS305
 * @author F
 *
 * @date 2019年8月23日下午6:19:19
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.sql.IpOtherSignSql
 */
public class IpOtherSignSql {

	/**
	 * BS305
	 * 住院 签署 其他 就诊信息 【IEOthOrEnDTO】
	 * @return
	 */
	public String getIpOtherSignEntInfoSql(){
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" A.Id_En as id_ieothoren, ");//就诊id
	    stringBuilder.append(" C.Name_Pat as name, ");//患者姓名
	    stringBuilder.append(" C.Sd_Sex_Pat as sexid, ");//性别编码
	    stringBuilder.append(" '' as age, ");//年龄
	    stringBuilder.append(" B.DT_BIRTH_HMS as birthdaydate, ");//出生日期
	    stringBuilder.append(" B.code_amr_ip as patientseqnum, ");//就诊号
	    stringBuilder.append(" (case when H.Times_Ip is null then 0 else H.Times_Ip end) + (case when J.Times_Op is null then 0 else J.Times_Op end) as admiss_times, ");//就诊次数
	    stringBuilder.append(" B.code as patientid, ");//患者ID
	    stringBuilder.append(" I.Code as deptcode, ");//病人当前科室编码
	    stringBuilder.append(" I.Name as deptname, ");//病人当前科室名称
	    stringBuilder.append(" G.Code as wardcode, ");//病区编码
	    stringBuilder.append(" G.Name as wardname, ");//病区名称
	    stringBuilder.append(" H.NAME_BED as bedcode, ");//床位号
	    stringBuilder.append(" A.Dt_Chk as confirm_date, ");//医嘱确认时间
	    stringBuilder.append(" R.Code as confirm_nurse_code, ");//医嘱确认护士编码
	    stringBuilder.append(" R.Name as confirm_nurse_name, ");//医嘱确认护士姓名
	    stringBuilder.append(" '01' as domain_id, ");//域id
	    stringBuilder.append(" O.orgcode AS org_code, ");//医疗机构编码
	    stringBuilder.append(" O. NAME AS org_name, ");//医疗机构名称
	    stringBuilder.append(" C.code as visit_sort_no, ");//就诊流水号
	    stringBuilder.append(" a.code_entp as visit_type_code, ");//就诊类别编码
	    stringBuilder.append(" BD.name as visit_type_name ");//就诊类别名称
	    stringBuilder.append(" ");//医嘱组套编码
	    stringBuilder.append(" ");//医嘱描述
		stringBuilder.append(" from ci_order A ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		stringBuilder.append(" left outer join en_ent_ip H ON C.Id_Ent = H.Id_Ent ");
		stringBuilder.append(" left outer join en_ent_op J ON A.Id_En = J.Id_Ent ");
		stringBuilder.append(" left outer join bd_dep G ON G.Id_Dep = C.Id_Dep_Nur ");
		stringBuilder.append(" left outer join bd_dep I ON I.Id_Dep = C.Id_Dep_Phy ");
		stringBuilder.append(" left outer join bd_psndoc R ON R.Id_Psndoc = A.Id_Emp_Chk ");
		stringBuilder.append(" LEFT OUTER JOIN bd_org O ON A.id_org_or = O.id_org ");
		stringBuilder.append(" left outer join BD_ENTP BD ON a.CODE_ENTP = BD.CODE ");
		stringBuilder.append(" where A.id_or = ? ");
		return stringBuilder.toString();
	}
	/**
	 * BS305
	 * 住院 签署 其他 医嘱信息 【IEOthOrDTO】
	 * @return
	 */
	public String getIpOtherSignOrdInfoSql() {//0178352 1、BS305消息，属于其他类型医嘱消息，不需要关联ci_or_srv表取数据
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select distinct ");
		stringBuilder.append(" e.sd_iemsgca as sd_iemsgca, ");//集成平台服务分类
	    stringBuilder.append(" A.id_or as id_ieothor, ");//主鍵
	    stringBuilder.append(" A.Id_En as id_ieothoren, ");//就诊id
	    stringBuilder.append(" A.code_or as order_code, ");//医嘱号
	    stringBuilder.append(" D.code as order_type_code, ");//医嘱类别编码
	    stringBuilder.append(" D.Name as order_type_name, ");//医嘱类别名称
	    stringBuilder.append(" a.code_or as yz_code, ");//医嘱编码
	    stringBuilder.append(" a.name_or as yz_name, ");//医嘱名称
	    stringBuilder.append(" H.code as yz_dept_code, ");//医嘱原科室编码
	    stringBuilder.append(" H.name as yz_dept_name, ");//医嘱原科室名称
	    stringBuilder.append(" I.code as yz_ward_code, ");//医嘱原病区编码
	    stringBuilder.append(" I.name as yz_ward_name, ");//医嘱原病区名称
	    stringBuilder.append(" A.Dt_Entry as yz_date, ");//开嘱/开立时间 
	    stringBuilder.append(" J.Code as yz_doctor_code, ");//开嘱医生编码
	    stringBuilder.append(" J.Name as yz_doctor_name, ");//开嘱医生名称
	    stringBuilder.append(" A.Dt_sign as yz_confirm_date, ");// 医嘱确认/签署时间 
	    stringBuilder.append(" K.code as yz_confirm_doctor_code, ");//医嘱确认医生编码
	    stringBuilder.append(" K.name as yz_confirm_doctor_name, ");//医嘱确认医生名称
	    stringBuilder.append(" L.code as exe_dept_code, ");//执行科室编码
	    stringBuilder.append(" L.name as exe_dept_name, ");//执行科室名称
	    stringBuilder.append(" '' as f_order_code, ");//父医嘱号
	    stringBuilder.append(" '' as hc_order_type_code, ");//互斥类别编码
	    stringBuilder.append(" '' as hc_order_type_name, ");//互斥类别名称
	    stringBuilder.append(" (case when substr(A.dt_effe,1,4)>='2099' then null else A.dt_effe end) as yz_start_time, ");//开始时间
	    stringBuilder.append(" (case when substr(A.Dt_End,1,4)>='2099' then null else A.Dt_End end) as yz_stop_time, ");// 停止时间
	    stringBuilder.append(" decode(A.Fg_Urgent,'Y','true','false') as is_jj, ");//是否加急
	    stringBuilder.append(" (case when A.Fg_Urgent = 'Y' then '加急' when A.Fg_Urgent = 'N' then '非加急' else '' end) as is_jjresult, ");//是否加急结果
	    stringBuilder.append(" '' as jt, ");//嘱托
	    stringBuilder.append(" '' as fybj_code, ");//费用标记编码   这个字段貌似收费状态标识占用了
	    stringBuilder.append(" '' as fybj_name, ");//费用标记名称
//	    stringBuilder.append(" A1.Fg_Indic AS is_syz, ");//是否适应
//	    stringBuilder.append(" (CASE WHEN A1.Fg_Indic = 'Y' THEN '适应' ELSE '非适应' END) AS is_syzresult, ");//是否适应结果
	    stringBuilder.append(" A.fg_skintest AS is_ps, ");//是否皮试
	    stringBuilder.append(" r.name AS is_psresult, ");//是否皮试结果
	    stringBuilder.append(" NULL AS route_code, ");//临床路径项目编号
	    stringBuilder.append(" NULL AS route_no, ");//临床路径项目序号
	    stringBuilder.append(" O.orgcode as org_code, ");//医疗机构编码
	    stringBuilder.append(" O.name as org_name, ");//医疗机构名称
	    stringBuilder.append(" '1' as order_sort_no, ");//医嘱序号
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as visit_time_type_name, ");//医嘱时间类型名称
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as visit_time_type_code, ");//医嘱时间类型编码
	    stringBuilder.append(" A.des_or as yz_memo, ");//医嘱备注
	    stringBuilder.append(" p.code as apply_code, ");//申请科室编码
	    stringBuilder.append(" s.name as fybj_name ");//费用标记名称
	    stringBuilder.append(" ");//先诊疗后付费类型编码 
	    stringBuilder.append(" ");//先诊疗后付费类型名称
	    stringBuilder.append(" ");//HIS执行状态
	    stringBuilder.append(" ");//业务操作时间
		stringBuilder.append(" from ci_order A ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		stringBuilder.append(" left outer join bd_udidoc D ON a.id_srvtp = D.id_udidoc ");
		stringBuilder.append(" left outer join bd_srv E ON E.Id_Srv = A.Id_Srv ");
		stringBuilder.append(" left outer join bd_dep H ON H.Id_Dep = C.Id_Dep_Phy ");
		stringBuilder.append(" left outer join bd_dep I ON I.Id_Dep = C.Id_Dep_Nur ");
		stringBuilder.append(" left outer join bd_psndoc J ON J.Id_Psndoc = a.id_emp_or ");
		stringBuilder.append(" left outer join bd_psndoc K ON K.Id_Psndoc = A.Id_Emp_sign ");
		stringBuilder.append(" left outer join bd_dep L ON L.Id_Dep = A.Id_Dep_Mp ");
		stringBuilder.append(" LEFT OUTER JOIN bd_org O ON A.id_org_or = O.id_org ");
		stringBuilder.append(" left outer join bd_dep P ON P.Id_Dep = A.Id_Dep_Or ");
		stringBuilder.append(" left outer join ci_skin_test q on q.id_or=a.id_or ");//这里不用ci_or_srv去关联 效果一样的，有就有，没就没
		stringBuilder.append(" left join bd_udidoc r on r.id_udidoc=q.id_rst_skintest ");
		stringBuilder.append(" left join ci_or_srv v on a.id_or = v.id_or ");
		stringBuilder.append(" left join bd_udidoc s on s.id_udidoc=v.ID_NODISPENSE ");
		stringBuilder.append(" where %1$s ");
		return stringBuilder.toString();
	}
}
