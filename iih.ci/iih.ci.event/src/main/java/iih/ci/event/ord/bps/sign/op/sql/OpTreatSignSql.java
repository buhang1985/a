package iih.ci.event.ord.bps.sign.op.sql;

/**
 * 门诊 签署 治疗sql查询BS303
 * @author F
 *
 * @date 2019年8月22日上午10:52:53
 *
 * @classpath iih.ci.event.ord.bps.sign.op.sql.OpTreatSignSql
 */
public class OpTreatSignSql {
	
	/**
	 * BS303
	 * 门诊 签署 治疗就诊信息【IEOpTreatOrEnDTO】
	 * @return
	 */
	public String getOpTreatSignEntInfoSql(String ids){
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" A.Id_En as id_ietreatoren, ");//就诊id
		stringBuilder.append(" a.id_or as id_or, ");//医嘱id
	    stringBuilder.append(" '' as ietreatfees, ");//子表集合
	    stringBuilder.append(" B.code as patient_id, ");//患者ID
	    stringBuilder.append(" '01' as domain_id, ");//域id
	    stringBuilder.append(" b.barcode_chis as p_bar_code, ");//就诊号
	    stringBuilder.append(" (case when H.Times_Ip is null then 0 else H.Times_Ip end) + (case when J.Times_Op is null then 0 else J.Times_Op end) as admiss_times, ");//就诊次数
	    stringBuilder.append(" C.code as Visitordno, ");//就诊流水号
	    stringBuilder.append(" a.code_entp as Visittype, ");//就诊类别编码
	    stringBuilder.append(" BD.name as Visittypename, ");//就诊类别名称
	    stringBuilder.append(" a.des_or as des_or, ");//描述
	    stringBuilder.append(" C.Name_Pat as name, ");//患者姓名
	    stringBuilder.append(" C.Sd_Sex_Pat as sex, ");//性别编码
	    stringBuilder.append(" B.DT_BIRTH_HMS as birthday, ");//出生日期
	    stringBuilder.append(" '' as age, ");//年龄
	    stringBuilder.append(" I.code as apply_unit, ");//病人科室编码
	    stringBuilder.append(" I.name as apply_unit_name, ");//病人科室名称
	    stringBuilder.append(" G.code as ward_code, ");//病区编码
	    stringBuilder.append(" G.Name as ward_code_name, ");//病区名称
	    stringBuilder.append(" H.NAME_BED as bed_no, ");//床位号
	    stringBuilder.append(" D.orgcode as orgcode, ");//医疗机构编码
	    stringBuilder.append(" D.name as orgname, ");//医疗机构名称
	    stringBuilder.append(" A.Dt_Chk as confrim_date, ");//医嘱确认时间
	    stringBuilder.append(" R.Code as confirm_opera, ");//确认护士编码
	    stringBuilder.append(" R.Name as confrim_opera_name, ");//确认护士姓名
	    stringBuilder.append(" L.code as exec_sn, ");//执行科室编码
	    stringBuilder.append(" M.code as apply_code ");//申请科室编码
		stringBuilder.append(" from ci_order A ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		stringBuilder.append(" left outer join en_ent_ip H ON C.Id_Ent = H.Id_Ent ");
		stringBuilder.append(" left outer join en_ent_op J ON A.Id_En = J.Id_Ent ");
		stringBuilder.append(" left outer join bd_dep G ON G.Id_Dep = C.Id_Dep_Nur ");
		stringBuilder.append(" left outer join bd_dep I ON I.Id_Dep = C.Id_Dep_Phy ");
		stringBuilder.append(" left outer join bd_psndoc R ON R.Id_Psndoc = A.Id_Emp_Chk ");
		stringBuilder.append(" left outer join bd_org D ON D.Id_org = A.Id_org ");
		stringBuilder.append(" left outer join BD_ENTP BD ON a.CODE_ENTP = BD.CODE ");
		stringBuilder.append(" left outer join bd_dep L ON L.Id_Dep = A.Id_Dep_Mp ");
		stringBuilder.append(" left outer join bd_dep M ON M.Id_Dep = A.Id_Dep_Or ");
		stringBuilder.append(" where A.id_or ");
		stringBuilder.append(ids);
		return stringBuilder.toString();
	}
	/**
	 * BS303
	 * 门诊 签署 治疗医嘱项目信息【IEOpTreatOrDTO】
	 * @return
	 */
	public String getOpTreatSignOrdItemInfoSql(String id_ors){
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" a.id_or as id_or,");//医嘱id
		stringBuilder.append(" A1.sortno as Orderseqnum, ");//医嘱序号
		stringBuilder.append(" a.code_or as order_no, ");//诊疗处方号 采用医嘱号
		stringBuilder.append(" (a.code_or || a1.sortno)as yz_no, ");//医嘱号 用医嘱号加srv排序号
		stringBuilder.append(" D.Code as order_type, ");//医嘱类别编码
	    stringBuilder.append(" D.Name as order_type_name, ");//医嘱类别名称
	    stringBuilder.append(" a.des_or as yz_comment, ");//医嘱备注
	    stringBuilder.append(" E.Code as yz_code, ");//医嘱编码
	    stringBuilder.append(" E.Name as yz_name, ");//医嘱名称
	    stringBuilder.append(" '' as pack_serial, ");//包装序号
	    stringBuilder.append(" A1.Quan_Total_Medu as charge_amount, ");//数量
	    stringBuilder.append(" F.Name as spe_external, ");//数量单位
	    stringBuilder.append(" G.code as freq_code, ");//执行频率编码
	    stringBuilder.append(" G.name as freq_code_name, ");//执行频率
	    stringBuilder.append(" H.code as yz_olddept_code, ");//医嘱原科室编码
	    stringBuilder.append(" H.name as yz_olddept_name, ");//医嘱原科室名称
	    stringBuilder.append(" I.code as yz_oldward_code, ");//医嘱原病区编码
	    stringBuilder.append(" I.name as yz_oldward_name, ");//医嘱原病区名称
	    stringBuilder.append(" A.Dt_Entry as enter_date, ");//开嘱时间
	    stringBuilder.append(" J.Code as doctor_code, ");//开嘱医生编码
	    stringBuilder.append(" J.Name as doctor_name, ");//开嘱医生名称
	    stringBuilder.append(" A.Dt_Sign as confirm_date, ");//确认时间
	    stringBuilder.append(" K.code as confirm_opera, ");//确认医生编码
	    stringBuilder.append(" K.name as confirm_opera_name, ");//确认医生名称
	    stringBuilder.append(" L.code as exec_sn, ");//执行科室编码
	    stringBuilder.append(" L.Name as exec_name, ");//执行科室名称
	    stringBuilder.append(" A.id_or as parent_no, ");//父医嘱号
	    stringBuilder.append(" '' as incompatibleyz_no, ");//互斥类别编码
	    stringBuilder.append(" '' as incompatibleyz_type_code, ");//互斥类别名称
	    stringBuilder.append(" (case when substr(A.Dt_Effe,1,4)>='2099' then null else A.Dt_Effe end) as begin_time, ");//开始时间
	    stringBuilder.append(" (case when substr(A.Dt_End,1,4)>='2099' then null else A.Dt_End end) as end_time, ");//停止时间
	    stringBuilder.append(" (case when A.Fg_Urgent = 'Y' then 'true' else 'false' end) as is_jj, ");//是否加急
	    stringBuilder.append(" (case when A.Fg_Urgent = 'Y' then '加急' when A.Fg_Urgent = 'N' then '非加急' else '' end) as is_jjresult, ");//是否加急结果
	    stringBuilder.append(" M.Code as charge_gourp, ");//医保类别编码
	    stringBuilder.append(" M.Name as charge_group_name_external, ");//医保类别名称
	    stringBuilder.append(" A.des_or as comment1, ");//嘱托
	    stringBuilder.append(" a1.sd_su_bl as payflag, ");//收费状态标识
	    stringBuilder.append(" '' as sginfee_code, ");//费用标记编码
	    stringBuilder.append(" '' as sginfee_name, ");//费用标记名称
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as Ordertimetypename, ");//医嘱时间类型名称
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as Ordertimetype, ");//医嘱时间类型编码
	    stringBuilder.append(" null as route_code, ");//临床路径项目编码
	    stringBuilder.append(" null as route_no, ");//临床路径项目序号
	    stringBuilder.append(" e.sd_iemsgca as sd_iemsgca, ");//集成平台服务分类编码
	    stringBuilder.append(" A.Id_En as id_ietreatoren ");//就诊id
		stringBuilder.append(" from ci_or_srv A1 ");
		stringBuilder.append(" left outer join ci_order A ON A1.Id_Or = A.Id_Or ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		stringBuilder.append(" left outer join bd_srv E ON E.Id_Srv = A1.Id_Srv ");
		stringBuilder.append(" left outer join bd_measdoc F ON F.Id_Measdoc = A1.Id_Medu ");
		stringBuilder.append(" left outer join bd_udidoc d on d.id_udidoc = A.id_srvtp ");
		stringBuilder.append(" left outer join bd_freq G ON G.Id_Freq = A1.Id_Freq ");
		stringBuilder.append(" left outer join bd_dep H ON H.Id_Dep = C.Id_Dep_Phy ");
		stringBuilder.append(" left outer join bd_dep I ON I.Id_Dep = C.Id_Dep_Nur ");
		stringBuilder.append(" left outer join bd_psndoc J ON J.Id_Psndoc = A1.Id_Emp_Srv ");
		stringBuilder.append(" left outer join bd_psndoc K ON K.Id_Psndoc = A.Id_Emp_Sign ");
		stringBuilder.append(" left outer join bd_dep L ON L.Id_Dep = A1.Id_Dep_Mp ");
	    stringBuilder.append(" left outer join bd_udidoc M ON M.id_udidoc = A1.Id_Hpsrvtp ");
		stringBuilder.append(" left outer join BD_ENTP BD ON C.CODE_ENTP = BD.CODE ");
		stringBuilder.append(" where A1.Fg_bl='Y' ");
		stringBuilder.append(" and A.id_or ");
		stringBuilder.append(id_ors);
		return stringBuilder.toString();
	}
}
