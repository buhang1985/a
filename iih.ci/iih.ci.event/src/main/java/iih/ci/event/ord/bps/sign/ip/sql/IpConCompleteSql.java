package iih.ci.event.ord.bps.sign.ip.sql;

/**
 * 住院会诊完成  SQL查询BS340
 * @author F
 *
 */
public class IpConCompleteSql {
	
	/**
	 * BS340
	 * 住院会诊完成信息【CiMrIPBaseDTO】主查询
	 * @param id_or4sql
	 * @return
	 */
	public String getIpConSignEntInfoSql(String id_or4sql){
		
		StringBuilder str = new StringBuilder();
		str.append(" select distinct ");
		str.append(" A.id_apcons as id_cimrbase, ");//主键ID
		str.append(" '02' as id_pre,  ");//域ID
		str.append(" CON.id_rptcons as id_mr, ");//0196884: BS340消息没有文档流水号
		str.append(" 'BS340' as id_server,  ");//BS340服务id
		str.append(" P.code as id_pat, ");//患者ID
		str.append(" P.code_amr_ip as id_ent, ");//就诊号
		str.append(" (case when H.Times_Ip is null then 0 else H.Times_Ip end) as times_ip, ");//就诊次数
		str.append(" E.code as en_code_liushui, ");//就诊流水号
		str.append("  C.Code_Entp as code_entp, ");//就诊类别编码
		str.append(" BD.name as name_entp, ");//就诊类别名称
		str.append(" MP.code as code_dept,  ");//就诊科室编码
		str.append(" MP.name as dept, ");//就诊科室名称
		str.append(" NUR.code as code_dep_nuradm, ");///病区编码
		str.append("  NUR.name as dep_nuradm, ");//病区名称
		str.append(" C.code_or as cons_orderid, ");//医嘱号
		str.append("");//病房号
		str.append(" H.name_bed as name_bed, ");//床位号
		str.append(" A.no_applyform as requestno, ");//电子申请单编号【会诊申请单号？？？？】
		str.append(" E.name_pat as name, ");//患者姓名
		str.append(" E.Sd_Sex_Pat as code_sex, ");//性别编码
		str.append(" BD_U.name as sex, ");//性别
		str.append(" P.id_code as id_code, ");//身份证号
		str.append(" '' as age, ");//年龄
		//str.append("");//年龄单位
		str.append(" k.sd_su_bl as payfalg, ");//收费状态标识
		str.append(" P.DT_BIRTH_HMS as dt_birth, ");//出生日期
		str.append("");//记录日期
		str.append("");//记录医生编码
		str.append("");//记录医生姓名
		str.append(" S.Orgcode as code_org, ");//医疗机构编码
		str.append(" S.NAME as org, ");//医疗机构名称
		str.append("");//整张图像编码
		str.append("");//图像格式
		str.append(" psn.code as cons_code_reqdoc, ");//会诊申请医生编码
		str.append(" psn.name as cons_name_reqdoc, ");//会诊申请医生姓名
		str.append(" I.Code as cons_code_reqdept, ");//会诊申请科室编码
		str.append(" I.Name as cons_name_reqdept, ");//会诊申请科室名称
		str.append(" S.Orgcode as cons_code_reqmed, ");//会诊申请医疗机构编码
		str.append(" S.NAME as cons_name_reqmed, ");//会诊申请医疗机构名称
		str.append(" SRV.SD_IEMSGCA as type_message,  ");//--集成平台消息类型
		str.append(" INVDEP.code as cons_dept_code, ");//会诊科室编码
		str.append(" INVDEP.name as cons_dept_name, ");//会诊科室名称
		str.append("");//会诊所在医疗机构编码【会诊申请医疗机构编码---同】
		str.append("");//会诊所在医疗机构名称
		str.append(" E.dt_entry as dt_acpt, ");//入院时间
		str.append(" to_char(A.des_emr) as prog_note, ");//病历摘要
		str.append("");//中医四诊观察结果
		str.append("");//辅助检查结果
		str.append("");//诊疗过程
		str.append("");//治则治法
		//str.append(" CON.des_psp as , ");//会诊目的===会诊原因？？
		str.append(" C.name_or as cons_type, ");//会诊类型
		str.append(" to_char(A.des_psp) as cons_reason, ");//会诊原因
		str.append(" CON.advice as cons_advice ");//会诊意见
		str.append("");//会诊执行情况
		str.append("");//诊疗过程描述
		str.append(" from ci_ap_cons A ");
		str.append(" left outer join ci_order C ON A.Id_Or = C.Id_Or ");
		str.append(" left outer join pi_pat P ON C.Id_Pat = P.Id_Pat ");
		str.append(" left outer join en_ent E ON C.Id_En = E.Id_Ent ");
		str.append(" left outer join bd_dep NUR ON E.id_dep_nur = NUR.ID_DEP ");
		str.append(" left outer join en_ent_ip H ON E.Id_Ent = H.Id_Ent ");
		str.append(" left outer join BD_ENTP BD ON C.CODE_ENTP = BD.CODE ");
		str.append(" left outer join BD_DEP MP ON E.ID_DEP_PHY = mp.id_dep ");
		str.append(" left outer join bd_org S ON C.Id_Org = S.Id_Org ");
		str.append(" left join bd_psndoc psn on psn.id_psndoc = C.id_emp_or ");
		str.append(" left outer join bd_dep I ON I.Id_Dep = C.id_dep_or ");
		str.append(" left outer join bd_udidoc BD_U  on E.id_sex_pat = BD_U.id_udidoc ");
		str.append(" left join bd_srv SRV on C.id_srv=SRV.id_srv ");
		str.append(" left outer join ci_rpt_cons CON on A.id_apcons = CON.id_apcons ");
		str.append(" left outer join bd_dep INVDEP on CON.id_dep_rpt = INVDEP.id_dep ");
		//str.append(" left outer join ci_cons_invite INV on INVDEP.id_dep = INV.id_dep ");
		str.append(" left outer join ci_or_srv K on C.id_or = K.id_or ");
		str.append(" where C.Sd_Srvtp like '09%' ");//会诊
		str.append(" and A.id_or ");
		str.append(id_or4sql);
		
		return str.toString();
	}
	
	/**
	 * BS340  住院会诊医师相关信息【ConsdocDTO】子查询
	 * @param id_or4sql
	 * @return
	 */
	public String getIpConCompleteDocInfoSql(String id_or4sql){
		
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(" select ");
		strBuilder.append(" I.id_apcons as id_cimrbase, ");//主表主键
		strBuilder.append(" rpt.DT_ACTUAL as cons_date, ");//会诊日期
		strBuilder.append(" PSN.code as code_cons_doc, ");//会诊医生编码
		strBuilder.append(" PSN.name as name_cons_doc, ");//会诊医生名称
		strBuilder.append(" A.name_org as cons_doc_medname ");//所在医疗机构名称
		strBuilder.append(" from CI_INVITE_CONS A ");
		strBuilder.append(" left join CI_RPT_CONS rpt on a.ID_APCONS = rpt.ID_APCONS ");
		strBuilder.append(" left outer join ci_ap_cons I on A.ID_APCONS = I.ID_APCONS ");
		strBuilder.append(" left outer join ci_order C ON I.Id_Or = C.Id_Or ");
		strBuilder.append(" left outer join bd_psndoc PSN on A.ID_EMP_RESPONSE = PSN.id_psndoc ");
		strBuilder.append(" where C.Sd_Srvtp like '09%' ");//会诊
		strBuilder.append(" and I.id_or ");
		strBuilder.append(id_or4sql);
		return strBuilder.toString();
	}
	
	/**
	 * BS340 住院会诊诊断【中西医】相关信息【DiaInfoDTO】子查询
	 * @param id_or4sql
	 * @return
	 */
	public String getIpConCompleteDiagInfoSql(String id_or4sql){
		
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(" select distinct ");
		strBuilder.append(" A.id_apcons as id_cimrbase, ");//主表主键
		strBuilder.append(" itm.ID_DIDEF_CODE as code_dia, ");//诊断编码
		strBuilder.append(" itm.ID_DIDEF_NAME as dia, ");//诊断名称
		strBuilder.append(" itm.ID_DIDEF_SYN_CODE as cmsym_code_dia, ");//证候编码
		strBuilder.append(" itm.ID_DIDEF_SYN_NAME as cmsym_name_dia  ");//证候名称
		strBuilder.append(" from CI_AP_CONS A ");
		strBuilder.append(" left join CI_ORDER c on a.ID_OR = c.ID_OR ");
		strBuilder.append(" left join ci_di di on c.ID_PAT = di.ID_PAT ");
		strBuilder.append(" left join CI_DI_ITM itm on DI.id_di = itm.ID_DI ");
		strBuilder.append(" where C.Sd_Srvtp like '09%' ");//会诊
		strBuilder.append(" and A.id_or ");
		strBuilder.append(id_or4sql);
		return strBuilder.toString();
	}
	

}
