package iih.ci.event.ord.bps.revert.op.sql;

import iih.ci.event.ord.utils.OrdEventUtil;

/**
 * 门诊 手术撤回BS005
 * @author F
 *
 * @date 2019年9月11日上午11:56:52
 *
 * @classpath iih.ci.event.ord.bps.revert.op.sql.OpOpRevertSql
 */
public class OpOpRevertSql {

	/**
	 * BS005
	 * 门诊 手术撤回所有信息 主1【IEOpOrCancStpEnDTO】子2【IEOpOrCancStpDTO】
	 * @return
	 */
	public String getOpOpWithDrawAllInfoSql(String id_or4sql) {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" A.Id_En as id_ieorcancstpen, ");//1.就诊id 主表主键
	    stringBuilder.append(" B.code as patient_id, ");//1.患者ID
	    stringBuilder.append(" X.Code as exec_unit, ");//1.执行科室编码
	    stringBuilder.append(" X.Name as exec_unit_name, ");//1.执行科室名称
	    stringBuilder.append(" '01' as domain_id, ");//1.域id
	    stringBuilder.append(" (case when F.Times_Ip is null then 0 else F.Times_Ip end) + (case when J.Times_Op is null then 0 else J.Times_Op end) as times, ");//1.就诊次数
	    stringBuilder.append(" A.ID_OR as id_ieorcancstp, ");//2.医嘱id 子表主键
	    stringBuilder.append(" A.Code_Or as order_id, ");//2.医嘱号
	    stringBuilder.append(" (case when substr(A.sd_srvtp, 0, 2) = '04' then '"+OrdEventUtil.SD_SRVTP_SXL+"' else N.Code end) as order_type, ");//2.医嘱的类型编码
	    stringBuilder.append(" '' as sample_no, ");//2.标本号
	    stringBuilder.append(" A.sv as cancel_date, ");//2.撤销或停止时间
	    stringBuilder.append(" K.Code as cancel_opera, ");//2.撤销或停止人编码
	    stringBuilder.append(" K.Name as cancel_opera_name, ");//2.撤销或停止人姓名
	    stringBuilder.append(" ' ' as cancel_reason, ");//2. 医嘱撤消原因
	    stringBuilder.append(" '' as mutex_order_no, ");//2.互斥医嘱号
	    stringBuilder.append(" '' as mutex_order_type, ");//2.互斥医嘱类别编码
	    stringBuilder.append(" '' as mutex_order_name, ");//2.互斥医嘱类别名称    
	    stringBuilder.append(" P.code as dept_code, ");//1.病人科室编码
	    stringBuilder.append(" P.name as dept_name, ");//1.病人科室名称
	    stringBuilder.append(" O.orgcode as org_code, ");//1.医疗机构编码
	    stringBuilder.append(" O.name as org_name, ");//1.医疗机构名称
	    stringBuilder.append(" '1' as sequence_number, ");//2.项目序号
	    stringBuilder.append(" S.sd_iemsgca as Iemsgca_code, ");//1.集成平台服务分类编码    
	    stringBuilder.append(" C.code as visitOrdNo, ");//1.就诊流水号
	    stringBuilder.append(" a.code_entp as visitType, ");//1.就诊类别编码
	    stringBuilder.append(" bd.name as visitTypeName, ");//1.就诊类别名称
	    stringBuilder.append(" N.name as order_type_name, ");//2.医嘱的类型名称
	    stringBuilder.append(" ap.code as apply_code, ");//2.申请科室编码
	    stringBuilder.append(" srv.sd_su_bl as payflag ");//2.收费状态标识
		stringBuilder.append(" from ci_order A ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		stringBuilder.append(" left outer join en_ent_ip F ON C.Id_Ent = F.Id_Ent ");
		stringBuilder.append(" left outer join en_ent_op J ON A.Id_En = J.Id_Ent ");
		stringBuilder.append(" left outer join bd_dep X ON X.ID_DEP = A.Id_Dep_Mp ");
		stringBuilder.append(" left outer join bd_srvca N ON N.Id_Srvca = A.Id_Srvca ");
		stringBuilder.append(" left outer join bd_psndoc K ON K.Id_Psndoc = A.Id_Emp_Or ");
		stringBuilder.append(" LEFT OUTER JOIN bd_org O ON A.id_org_or = O.id_org ");
		stringBuilder.append(" LEFT OUTER JOIN bd_dep P ON C.id_dep_phy = P.id_dep ");
		stringBuilder.append(" LEFT OUTER JOIN bd_srv S ON S.Id_Srv = A.Id_Srv ");
		stringBuilder.append(" left outer join BD_ENTP BD ON a.CODE_ENTP = BD.CODE ");
		stringBuilder.append(" left outer join bd_dep ap on ap.id_dep = a.id_dep_or ");
		stringBuilder.append(" left outer join ci_or_srv srv on srv.id_or=a.id_or ");
		stringBuilder.append(" where A.id_or ");
		stringBuilder.append(id_or4sql);
		return stringBuilder.toString();
	}
}
