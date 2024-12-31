package iih.ci.ord.s.bp.iemsg.qry.sql;


public class ConsulationSql {
	
	/**
	 * BS318-住院(02)获取主表数据集合
	   *     医嘱类别编码、医嘱类型名称会诊系统没有此信息-服务设计书写的
	 * @param id_or4sql
	 * @return
	 */
	public String getConsulationSql(String id_or4sql){
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" select ");
		sqlSB.append(" a1.id_apcons as id_conculation, ");//--主表主键
		sqlSB.append(" '01' as patientdomain, ");//--域id
		sqlSB.append(" B.code as patientlid, ");//--患者id
		sqlSB.append(" B.code_amr_ip as visitno,  ");//--就诊号
		sqlSB.append(" (case when H.Times_Ip is null then 0 else H.Times_Ip end) + (case when J.Times_Op is null then 0 else J.Times_Op  end) as Visittimes, ");//--就诊次数
		sqlSB.append(" C.code as visitordno, ");//--就诊流水号
		sqlSB.append(" (case when A.Code_Entp = '00' then '01' when A.Code_Entp = '10' then  '03' end) as visittype, ");//--就诊类别编码
		sqlSB.append(" BD.name as visittypename,  ");//--就诊类别名称
		sqlSB.append(" C.Name_Pat as patientname, ");//--患者姓名
		sqlSB.append(" C.Sd_Sex_Pat as gendercode, ");//--性别编码
		sqlSB.append(" B.DT_BIRTH_HMS as birthdate, ");//--出生日期
		sqlSB.append(" '' as age, ");//--年龄
		sqlSB.append(" S.Orgcode as orgcode, ");//--医疗机构编码
		sqlSB.append(" S.NAME as orgname, ");//--医疗机构名称
		sqlSB.append(" A1.no_applyform as requestno, ");//--会诊申请单号
		sqlSB.append(" A.code_or as orderlid, ");//--会诊医嘱号
		sqlSB.append(" ca.code as orderCode, ");//医嘱类别编码
		sqlSB.append(" ca.name as orderName,");//医嘱类别名称
		sqlSB.append(" srvtp.code as consultationtype, ");//--申请类型编码
		sqlSB.append(" srvtp.name as consultationtypename, ");//--申请类型名称
		sqlSB.append(" A1.fg_urgent as urgencycode, ");//--紧急程度编码
		sqlSB.append(" (case when A1.fg_urgent = 'Y' then '加急' when A1.fg_urgent = 'N' then  '普通' else '' end) as urgencyname, ");//--紧急程度名称
		sqlSB.append(" A1.des_psp as reason, ");//--会诊原因
		sqlSB.append(" '' as clinicalpathwaycode, ");//--临床路径项目编号
		sqlSB.append(" '' as clinicalpathwaysqe, ");//--临床路径项目序号
		sqlSB.append(" A1.dt_ap as requesttime, ");//--会诊申请时间
		sqlSB.append(" psn.code as requestdoctor, ");//--申请人编码
		sqlSB.append(" psn.name as requestdoctorname, ");//-- 申请人名称
		sqlSB.append(" I.Code as orderdept, ");//--申请人科室编码
		sqlSB.append(" I.Name as orderdeptname, ");//--申请人科室名称
		sqlSB.append(" A1.place as consultationplacename,  ");//--会诊地点
		sqlSB.append(" srv.SD_IEMSGCA as serTypeCode,  ");//--服务类型编码
		sqlSB.append(" mp.code as execdept ");//执行科室编码
		sqlSB.append(" from ci_ap_cons A1 ");
		sqlSB.append(" left outer join ci_order A ON A1.Id_Or = A.Id_Or ");
		sqlSB.append(" left outer join ci_ap_bt Q ON Q.id_or = A.Id_Or ");
		sqlSB.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		sqlSB.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		sqlSB.append(" left outer join en_ent_ip H ON C.Id_Ent = H.Id_Ent ");
		sqlSB.append(" left outer join en_ent_op J ON A.Id_En = J.Id_Ent ");
		sqlSB.append(" left outer join bd_dep I ON I.Id_Dep = a.id_dep_or ");
		sqlSB.append(" left outer join bd_org S ON S.Id_Org = A.Id_Org ");
		sqlSB.append(" left outer join BD_ENTP BD ON C.CODE_ENTP = BD.CODE ");
		sqlSB.append(" left join bd_udidoc srvtp on srvtp.id_udidoc = a.id_srvtp  ");//--申请类型编码和名称
		sqlSB.append(" left join bd_psndoc psn on psn.id_psndoc = a.id_emp_or ");
		sqlSB.append(" left join bd_srv srv on srv.id_srv=a.id_srv ");
		sqlSB.append(" left join bd_dep mp on mp.id_dep= a.id_dep_mp ");
		sqlSB.append(" left join bd_srvca ca ON ca.Id_Srvca=A.Id_Srvca ");
		sqlSB.append(" where A.Sd_Srvtp like '09%' ");
		sqlSB.append(" and A1.id_or ");
		sqlSB.append(id_or4sql);
		return sqlSB.toString();
	}
	/**
	 * BS318-住院(02)获取子表数据集合
	 * 
	 * @param id_or4sql
	 * @return
	 */
	public String getConsulationDeptSql(String id_or4sql){
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" select ");
		sqlSB.append(" b.id_invitecons as id_con_dept, ");//--子表主键
		sqlSB.append(" a1.id_apcons as id_conculation, ");//--主表主键
		sqlSB.append(" c.code as consultationorgcode, ");//--所属医院编码
		sqlSB.append(" c.name as consultationorgname, ");//--所属医院名称
		sqlSB.append(" d.code as consultationdept, ");//--参加会诊科室编码
		sqlSB.append(" d.name as consultationdeptname, ");//--参加会诊科室名称
		sqlSB.append(" e.code as consultationperson, ");//--参与医生编码
		sqlSB.append(" e.name as consultationpersonname   ");//--参与医生名称
		sqlSB.append(" from ci_ap_cons A1 ");
		sqlSB.append(" left join ci_order A on A.ID_OR=A1.ID_OR ");
		sqlSB.append(" left join ci_invite_cons B on B.id_apcons=A1.ID_APCONS ");
		sqlSB.append(" left join bd_org C  ON C.Id_Org = B.Id_Org ");
		sqlSB.append(" left join bd_dep D  on d.id_dep=b.id_dep ");
		sqlSB.append(" left join bd_psndoc E on e.id_psndoc=b.id_emp ");
		sqlSB.append(" left join pi_pat f on f.id_pat=a.id_pat ");
		sqlSB.append(" where A.Sd_Srvtp like '09%' ");
		sqlSB.append(" and A1.id_or ");
		sqlSB.append(id_or4sql);
		return sqlSB.toString();
	}
}
