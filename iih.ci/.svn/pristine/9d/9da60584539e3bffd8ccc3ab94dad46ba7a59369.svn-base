package iih.ci.event.ord.bps.refund.sql;

import iih.ci.event.ord.utils.OrdEventUtil;

/**
 * 门诊检查检验退费BS005
 * @author F
 *
 * @date 2019年9月16日下午6:08:53
 *
 * @classpath iih.ci.event.ord.bps.refund.sql.OpRisLisRefundSql
 */
public class OpRisLisRefundSql {

	/**
	 * 门诊检查检验退费 主子信息 BS005 就诊1【IEOpOrCancStpEnDTO】医嘱2【IEOpOrCancStpDTO】
	 * @return
	 */
	public String getOpRisLisRefundAllInfoSql() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" cior.id_or as id_or, ");//医嘱id
	    stringBuilder.append(" srv.SD_IEMSGCA as iemsgca_code, ");//1/2集成平台分类
	    stringBuilder.append(" pat.code as patient_id, ");//1.患者ID
	    stringBuilder.append(" entop.times_op as times, ");//1.就诊次数
	    stringBuilder.append(" execdep.code as exec_unit, ");//1/2执行科室编码
	    stringBuilder.append(" execdep.name as exec_unit_name, ");//1/2执行科室
	    stringBuilder.append(" dep1.code as dept_code, ");//1.病人科室编码
	    stringBuilder.append(" dep1.name as dept_name, ");//1.病人科室名称
	    stringBuilder.append(" org.orgcode as org_code, ");//1.医疗机构编码
	    stringBuilder.append(" org.name as org_name, ");//1.医疗机构名称
	    stringBuilder.append(" cior.code_or as order_id, ");//2.医嘱号
	    stringBuilder.append(" (case ");
	    stringBuilder.append("   when substr(cior.sd_srvtp, 0, 2) = '02' then ");
	    stringBuilder.append("    '"+OrdEventUtil.SD_SRVTP_JCL+"' ");
	    stringBuilder.append("   when substr(cior.sd_srvtp, 0, 2) = '03' then ");
	    stringBuilder.append("    '"+OrdEventUtil.SD_SRVTP_HYL+"' ");
	    stringBuilder.append("   else ");
	    stringBuilder.append("    '' ");
	    stringBuilder.append(" end) as order_type, ");//2.医嘱的类型编码
	    stringBuilder.append(" C.code as visitOrdNo, ");//1.就诊流水号
	    stringBuilder.append(" cior.code_entp as visitType, ");//1.就诊类别编码
	    stringBuilder.append(" bd.name as visitTypeName, ");//1.就诊类别名称
	    stringBuilder.append(" b.name as order_type_name, ");//2.医嘱的类型名称
	    stringBuilder.append(" m.code as apply_code ");//2.申请科室编码
		stringBuilder.append(" from ci_order cior ");
		stringBuilder.append(" left join pi_pat pat on cior.id_pat = pat.id_pat ");
		stringBuilder.append(" left join en_ent_op entop on cior.id_en = entop.id_ent ");
		stringBuilder.append(" left join bd_dep execdep on cior.id_dep_mp = execdep.id_dep ");
		stringBuilder.append(" left join bd_dep dep1 on cior.id_dep_or = dep1.id_dep ");
		stringBuilder.append(" left join bd_org org on cior.id_org = org.id_org ");
		stringBuilder.append(" left join bd_srvca srvca on cior.id_srvca = srvca.id_srvca ");
		stringBuilder.append(" left join bd_srv srv on cior.id_srv = srv.id_srv ");
		stringBuilder.append(" left outer join en_ent C ON cior.Id_En = C.Id_Ent ");
		stringBuilder.append(" left outer join BD_ENTP BD ON cior.CODE_ENTP = BD.CODE ");
		stringBuilder.append(" left outer join bd_udidoc b on b.id_udidoc = cior.id_srvtp ");
		stringBuilder.append(" left join bd_dep m on cior.id_dep_or=m.id_dep ");
		stringBuilder.append(" where cior.id_or %s ");
		return stringBuilder.toString();
	}
}
