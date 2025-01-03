package iih.ci.event.ord.bps.sign.ip.sql;
/**
 * 住院 签署 会诊 sql查询 BS318
 * @author F
 *
 * @date 2019年8月27日下午4:57:30
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.sql.IpConSignSql
 */
public class IpConSignSql {

	/**
	 * BS318
	 * 住院签署 会诊 就诊信息【IEOpConsulationDTO】
	 * @param id_or4sql
	 * @return
	 */
	public String getIpConSignEntInfoSql(String id_or4sql){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select distinct ");
		stringBuilder.append(" a1.id_apcons as id_conculation, ");//--主表主键
		stringBuilder.append(" '01' as patientdomain, ");//--域id
		stringBuilder.append(" B.code as patientlid, ");//--患者id
		stringBuilder.append(" B.code_amr_ip as visitno,  ");//--就诊号
		stringBuilder.append(" (case when H.Times_Ip is null then 0 else H.Times_Ip end) + (case when J.Times_Op is null then 0 else J.Times_Op  end) as Visittimes, ");//--就诊次数
		stringBuilder.append(" C.code as visitordno, ");//--就诊流水号
		stringBuilder.append(" A.Code_Entp as visittype, ");//--就诊类别编码
		stringBuilder.append(" BD.name as visittypename,  ");//--就诊类别名称
		stringBuilder.append(" C.Name_Pat as patientname, ");//--患者姓名
		stringBuilder.append(" C.Sd_Sex_Pat as gendercode, ");//--性别编码
		stringBuilder.append(" B.DT_BIRTH_HMS as birthdate, ");//--出生日期
		stringBuilder.append(" '' as age, ");//--年龄
		stringBuilder.append(" S.Orgcode as orgcode, ");//--医疗机构编码
		stringBuilder.append(" S.NAME as orgname, ");//--医疗机构名称
		stringBuilder.append(" A1.no_applyform as requestno, ");//--会诊申请单号
		stringBuilder.append(" A.code_or as orderlid, ");//--会诊医嘱号
		stringBuilder.append(" srvtp.code as orderCode, ");//医嘱类别编码  0174328: bd_srv的服务编码code-->申请类型编码，服务类型编码sd_srvtp-->医嘱类别编码
		stringBuilder.append(" srvtp.name as orderName,");//医嘱类别名称
		stringBuilder.append(" srv.code as consultationtype, ");//--申请类型编码
		stringBuilder.append(" srv.name as consultationtypename, ");//--申请类型名称
		stringBuilder.append(" A1.fg_urgent as urgencycode, ");//--紧急程度编码
		stringBuilder.append(" (case when A1.fg_urgent = 'Y' then '加急' when A1.fg_urgent = 'N' then  '普通' else '' end) as urgencyname, ");//--紧急程度名称
		stringBuilder.append(" to_char(A1.des_psp) as reason, ");//--会诊原因
		stringBuilder.append(" '' as clinicalpathwaycode, ");//--临床路径项目编号
		stringBuilder.append(" '' as clinicalpathwaysqe, ");//--临床路径项目序号
		stringBuilder.append(" A1.dt_ap as requesttime, ");//--会诊申请时间
		stringBuilder.append(" psn.code as requestdoctor, ");//--申请人编码
		stringBuilder.append(" psn.name as requestdoctorname, ");//-- 申请人名称
		stringBuilder.append(" I.Code as orderdept, ");//--申请人科室编码
		stringBuilder.append(" I.Name as orderdeptname, ");//--申请人科室名称
		stringBuilder.append(" A1.place as consultationplacename,  ");//--会诊地点
		stringBuilder.append(" srv.SD_IEMSGCA as serTypeCode,  ");//--服务类型编码
		stringBuilder.append(" mp.code as execdept, ");//执行科室编码
		stringBuilder.append(" k.sd_su_bl as payflag ");//收费状态标识
		stringBuilder.append(" from ci_ap_cons A1 ");
		stringBuilder.append(" left outer join ci_order A ON A1.Id_Or = A.Id_Or ");
		stringBuilder.append(" left outer join ci_ap_bt Q ON Q.id_or = A.Id_Or ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		stringBuilder.append(" left outer join en_ent_ip H ON C.Id_Ent = H.Id_Ent ");
		stringBuilder.append(" left outer join en_ent_op J ON A.Id_En = J.Id_Ent ");
		stringBuilder.append(" left outer join bd_dep I ON I.Id_Dep = a.id_dep_or ");
		stringBuilder.append(" left outer join bd_org S ON S.Id_Org = A.Id_Org ");
		stringBuilder.append(" left outer join BD_ENTP BD ON a.CODE_ENTP = BD.CODE ");
		stringBuilder.append(" left join bd_udidoc srvtp on srvtp.id_udidoc = a.id_srvtp  ");
		stringBuilder.append(" left join bd_psndoc psn on psn.id_psndoc = a.id_emp_or ");
		stringBuilder.append(" left join bd_srv srv on srv.id_srv=a.id_srv ");
		stringBuilder.append(" left join bd_dep mp on mp.id_dep= a.id_dep_mp ");
		stringBuilder.append(" left join bd_srvca ca ON ca.Id_Srvca=A.Id_Srvca ");
		stringBuilder.append(" left join ci_or_srv k on k.id_or=a.id_or ");
		stringBuilder.append(" where A.Sd_Srvtp like '09%' ");
		stringBuilder.append(" and A1.id_or ");
		stringBuilder.append(id_or4sql);
		return stringBuilder.toString();
	}
	/**
	 * BS318
	 * 住院签署 会诊 部门信息【IEOpConsultationDeptDTO】
	 * @param id_or4sql
	 * @return
	 */
	public String getIpConDeptInfoSql(String id_or4sql){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" b.id_invitecons as id_con_dept, ");//--子表主键
		stringBuilder.append(" a1.id_apcons as id_conculation, ");//--主表主键
		stringBuilder.append(" c.code as consultationorgcode, ");//--所属医院编码
		stringBuilder.append(" c.name as consultationorgname, ");//--所属医院名称
		stringBuilder.append(" d.code as consultationdept, ");//--参加会诊科室编码
		stringBuilder.append(" d.name as consultationdeptname, ");//--参加会诊科室名称
		stringBuilder.append(" e.code as consultationperson, ");//--参与医生编码
		stringBuilder.append(" e.name as consultationpersonname   ");//--参与医生名称
		stringBuilder.append(" from ci_ap_cons A1 ");
		stringBuilder.append(" left join ci_order A on A.ID_OR=A1.ID_OR ");
		stringBuilder.append(" left join ci_invite_cons B on B.id_apcons=A1.ID_APCONS ");
		stringBuilder.append(" left join bd_org C  ON C.Id_Org = B.Id_Org ");
		stringBuilder.append(" left join bd_dep D  on d.id_dep=b.id_dep ");
		stringBuilder.append(" left join bd_psndoc E on e.id_psndoc=b.id_emp ");
		stringBuilder.append(" left join pi_pat f on f.id_pat=a.id_pat ");
		stringBuilder.append(" where A.Sd_Srvtp like '09%' ");
		stringBuilder.append(" and A1.id_or ");
		stringBuilder.append(id_or4sql);
		return stringBuilder.toString();
	}
}
