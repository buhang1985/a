package iih.ci.event.ord.bps.cancel.ip.sql;

import iih.ci.event.ord.utils.OrdEventUtil;

/**
 * 住院 作废BS005
 * 
 * 集成平台消息
 * 1、就诊号取值规则：门诊使用pi_pat.barcode_chis，住院使用pi_pat.code_amr_ip
 * 2、就诊流水号取值规则：en_ent.code
 * @author F
 *
 * @date 2019年9月11日上午10:17:42
 *
 * @classpath iih.ci.event.ord.bps.cancel.ip.sql.IpCancelSql
 */
public class IpCancelSql {

	/**
	 * BS005 
	 * 住院作废信息1.【IEOrCancStpEnDTO】 2.【IEOrCancStpDTO】
	 * @param id_or4sql
	 * @return
	 */
	public String getIpInvalidSql(String id_or4sql) {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select distinct ");
		stringBuilder.append(" A.Id_En as id_ieorcancstpen, ");//1.就诊id
	    stringBuilder.append(" B.code as patientid, ");//1.患者id
	    stringBuilder.append(" X.Code as exec_dept_code, ");//1.执行科室编码
	    stringBuilder.append(" X.Name as exec_dept_name, ");//1.执行科室名称
	    stringBuilder.append(" '01' as domain_id, ");//1.域id
	    stringBuilder.append(" n.code as order_type_code, ");
	    stringBuilder.append(" (case when F.Times_Ip is null then 0 else F.Times_Ip end) as admiss_times, ");//1.就诊次数
	    stringBuilder.append(" X.Code as exec_unit, ");//2.执行科室编码
	    stringBuilder.append(" X.Name as exec_unit_name, ");//2.执行科室名称
	    stringBuilder.append(" bu.name as ordertypename, ");//2.医嘱的类型名称
	    stringBuilder.append(" A.ID_OR as id_ieorcancstp, ");//2.医嘱id
	    stringBuilder.append(" a.code_or as orderno, ");//2.医嘱号
	    stringBuilder.append(" a.code_or as ordergroupid, ");//2.医嘱组号
	    stringBuilder.append(" '' as bbno, ");//2.标本号
	    stringBuilder.append(" A.dt_canc as canceltime, ");//2.撤销或停止时间
	    stringBuilder.append(" K.Code as cancelpersoncode, ");//2.撤销或停止人编码
	    stringBuilder.append(" K.Name as cancelpersonname, ");//2.撤销或停止人姓名
	    stringBuilder.append(" (case ");
	    stringBuilder.append("   when substr(A.sd_srvtp, 0, 2) = '02' then '"+OrdEventUtil.SD_SRVTP_JCL+"' ");
	    stringBuilder.append("   when substr(A.sd_srvtp, 0, 2) = '03' then '"+OrdEventUtil.SD_SRVTP_HYL+"' ");
	    stringBuilder.append("   when substr(A.sd_srvtp, 0, 2) = '04' then '"+OrdEventUtil.SD_SRVTP_SXL+"' ");
	    stringBuilder.append("   when substr(A.sd_srvtp, 0, 2) = '05' then '"+OrdEventUtil.SD_SRVTP_ZLL+"' ");
	    stringBuilder.append("   when substr(A.sd_srvtp, 0, 6) = '140101' then '"+OrdEventUtil.SD_SRVTP_SXSQ+"' ");
	    stringBuilder.append("   when substr(A.sd_srvtp, 0, 6) = '140102' then '"+OrdEventUtil.SD_SRVTP_QXSQ+"' ");
	    stringBuilder.append("   when substr(A.sd_srvtp, 0, 2) = '06' then '"+OrdEventUtil.SD_SRVTP_HLL+"' ");
	    stringBuilder.append("   when (substr(A.sd_srvtp, 0, 4) = '0101' and substr(A.sd_srvtp, 0, 6) = '010101') then '"+OrdEventUtil.SD_SRVTP_YP+"' ");//西药
	    stringBuilder.append("   when (substr(A.sd_srvtp, 0, 4) = '0101' and substr(A.sd_srvtp, 0, 6) like '0101%') then '"+OrdEventUtil.SD_SRVTP_ZJYP+"' ");
	    stringBuilder.append("   when substr(A.sd_srvtp, 0, 4) = '0103' then '"+OrdEventUtil.SD_SRVTP_CYL+"' ");
	    stringBuilder.append("   when substr(A.sd_srvtp, 0, 4) = '0902' then '"+OrdEventUtil.SD_SRVTP_HZL+"' ");
	    stringBuilder.append("   else '"+OrdEventUtil.SD_SRVTP_QTL+"' ");
	    stringBuilder.append(" end) as ordertype, ");//2.医嘱的类型编码
	    stringBuilder.append(" '' as yz_cancel_yy, ");//2.医嘱撤消原因
	    stringBuilder.append(" '' as hc_order_no, ");//2.互斥医嘱号
	    stringBuilder.append(" '' as hc_order_type_no, ");//2.互斥医嘱类别编码
	    stringBuilder.append(" '' as hc_order_type_name, ");//2.互斥医嘱类别名称
	    stringBuilder.append(" P.code as dept_code, ");//1.病人科室编码
	    stringBuilder.append(" P.name as dept_name, ");//1.病人科室名称
	    stringBuilder.append(" O.orgcode as org_code, ");//1.医疗结构编码
	    stringBuilder.append(" O.name as org_name, ");//1.医疗机构名称
	    stringBuilder.append(" '1' as sequence_number, ");//2.项目序号
	    stringBuilder.append(" d.SD_IEMSGCA as iemsgca_code, ");//1.集成平台服务分类
	    stringBuilder.append(" C.code as visit_sort_no, ");//1.就诊流水号
	    stringBuilder.append(" a.code_entp as visit_type_code, ");//1.就诊类型编码
	    stringBuilder.append(" bd.name as visit_type_name, ");//1.就诊类型名称
	    stringBuilder.append(" ap.code as apply_code, ");//1.申请科室编码
	    stringBuilder.append(" a1.sd_su_bl as payflag, ");//2.收费状态标识
	    stringBuilder.append(" D.sd_iemsgca as iemsgca_code ");//2.收费状态标识
		stringBuilder.append(" from ci_order A ");
		stringBuilder.append(" left join ci_or_srv A1 on A.id_or = A1.id_or ");
		stringBuilder.append(" left outer join ci_ap_lab H on H.Id_Or = A.Id_Or ");
		stringBuilder.append(" left outer join ci_ap_obs Q on Q.Id_Or = A.Id_Or ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		stringBuilder.append(" left outer join en_ent_ip F ON C.Id_Ent = F.Id_Ent ");
		stringBuilder.append(" left outer join en_ent_op J ON A.Id_En = J.Id_Ent ");
		stringBuilder.append(" left outer join bd_dep X ON X.ID_DEP = A.Id_Dep_Mp ");
		stringBuilder.append(" left outer join bd_srvca N ON N.Id_Srvca = A.Id_Srvca ");
		stringBuilder.append(" left outer join bd_psndoc K ON K.Id_Psndoc = A.Id_Emp_Canc ");
		stringBuilder.append(" left outer join bd_psndoc L ON L.Id_Psndoc = A.Id_Emp_Stop ");
		stringBuilder.append(" LEFT OUTER JOIN bd_dep P ON C.id_dep_phy = P.id_dep ");
		stringBuilder.append(" LEFT OUTER JOIN bd_org O ON A.id_org_or = O.id_org ");
		stringBuilder.append(" left outer join bd_srv D ON a.Id_Srv = D.Id_Srv ");
		stringBuilder.append(" left outer join BD_ENTP BD ON a.CODE_ENTP = BD.CODE ");
		stringBuilder.append(" left outer join bd_udidoc bu on bu.id_udidoc = A.id_srvtp ");
		stringBuilder.append(" left join bd_dep ap on ap.id_dep = a.id_dep_or ");
		stringBuilder.append(" where A1.Fg_Or = 'Y' ");
		stringBuilder.append(" and A.id_or ");
	    stringBuilder.append(id_or4sql);
		return stringBuilder.toString();
	}
}
