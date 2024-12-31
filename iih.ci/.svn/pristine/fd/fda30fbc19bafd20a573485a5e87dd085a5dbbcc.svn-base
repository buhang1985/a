package iih.ci.event.ord.bps.sign.ip.sql;
/**
 * BS452 住院 病理 签署sql
 * @author F
 *
 * @date 2020年1月20日下午12:00:31
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.sql.IpPathSignSql
 */
public class IpPathSignSql {

	/**
	 * BS452
	 * 住院 签署 病理【IEIpPathEntDTO】
	 * @param id_pathors
	 * @return
	 */
	public String getIpPathSignEntInfoSql(String id_pathors) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" a.id_en as id_en, ");
		stringBuilder.append(" a.id_or as id_or, ");
		stringBuilder.append(" '01' as patientDomain, ");//域id
		stringBuilder.append(" b.code as patientLid, ");//患者id
		stringBuilder.append(" b.code_amr_ip as visitNo, ");//就诊号
		stringBuilder.append(" (case when d.Times_Ip is null then 0 else d.Times_Ip end) + (case when e.Times_Op is null then 0 else e.Times_Op end) as visittimes, ");//就诊次数
		stringBuilder.append(" c.code as visitOrdNo, ");//就诊流水号
		stringBuilder.append(" a.code_entp as visitTypeCode, ");//就诊类别编码
		stringBuilder.append(" f.name as visitTypeName, ");//就诊类别名称
		stringBuilder.append(" g.code as wardsId, ");//病区编码
		stringBuilder.append(" g.name as wardsName, ");//病区名
		stringBuilder.append(" d.name_bed as bedNo, ");//床号
		stringBuilder.append(" b.Id_Code as identityCard, ");//身份证号
		stringBuilder.append(" h.no_hp as medicareCard, ");//医保卡号
		stringBuilder.append(" c.name_pat as patientName, ");//姓名
		stringBuilder.append(" c.telno_pat as telNum, ");//联系电话
		stringBuilder.append(" c.sd_sex_pat as genderCode, ");//性别编码
		stringBuilder.append(" b.dt_birth_hms as birthDate, ");//出生日期
		stringBuilder.append(" c.addr_pat as address, ");//住址
		stringBuilder.append(" c.sd_mari_pat as marriageStatusCode, ");//婚姻状况类别编码
		stringBuilder.append(" i.code as marriageStatusName, ");//民族编码
		stringBuilder.append(" b.sd_occu as occupationCode, ");//职业编码
		stringBuilder.append(" j.name as occupationName, ");//职业
		stringBuilder.append(" b.workunit as workPlace, ");//工作单位名称
		stringBuilder.append(" k.code as nationalityCode, ");//国籍编码
		stringBuilder.append(" k.name asnationalityName, ");//国家
		stringBuilder.append(" l.code as visitDept, ");//病人科室编码
		stringBuilder.append(" l.name as visitDeptName, ");//病人科室名称
		stringBuilder.append(" m.orgcode as orgCode, ");//医疗机构代码
		stringBuilder.append(" m.name as orgName, ");//医疗机构名称
		stringBuilder.append(" a.dt_effe as orderTime, ");//开单时间
		stringBuilder.append(" n.code as orderDoctorCode, ");//开单医生编码
		stringBuilder.append(" n.name as orderDoctorName, ");//开单医生姓名
		stringBuilder.append(" o.code as orderDept, ");//申请科室编码
		stringBuilder.append(" o.name as orderDeptName, ");//申请科室名称
		stringBuilder.append(" a.dt_sign as confirmTime, ");//确认时间
		stringBuilder.append(" p.code as confirmPerson, ");//确认人编码
		stringBuilder.append(" p.name as confirmPersonName, ");//确认人姓名
		//--标本送检时间
		//--送检医师编码
		//--送检医师姓名
		stringBuilder.append(" n.code as attendingDoctor, ");//主治医师编码
		stringBuilder.append(" n.name as attendingDoctorName, ");//主治医师姓名
		//--送检医师联系电话
		stringBuilder.append(" a.sd_su_bl as sd_su_bl ");//收费标识  （不管收费时 部分收还是全收，就查ci_order ，假如能部分收费,谁知道传收还是不收标识）
		stringBuilder.append(" from ci_order a ");
		stringBuilder.append(" left join pi_pat b on b.id_pat=a.id_pat ");
		stringBuilder.append(" left join en_ent c on a.id_en=c.id_ent ");
		stringBuilder.append(" left join en_ent_ip d on d.id_ent=c.id_ent ");
		stringBuilder.append(" left join en_ent_op e on a.id_en=e.id_ent ");
		stringBuilder.append(" left join bd_entp f on a.code_entp=f.code ");
		stringBuilder.append(" left join bd_dep g on g.id_dep=c.id_dep_nur ");
		stringBuilder.append(" left join en_ent_hp h on h.id_ent=c.id_ent ");
		stringBuilder.append(" left join bd_udidoc i on i.id_udidoc=b.id_nation ");
		stringBuilder.append(" left join bd_udidoc j on j.id_udidoc=b.id_occu ");
		stringBuilder.append(" left join bd_country k on k.id_countryzone=b.id_country ");
		stringBuilder.append(" left join bd_dep l on c.id_dep_phy=l.id_dep ");
		stringBuilder.append(" left join bd_org m on a.id_org=m.id_org ");
		stringBuilder.append(" left join bd_psndoc n on a.id_emp_or=n.id_psndoc ");
		stringBuilder.append(" left join bd_dep o on o.id_dep=a.id_dep_or ");
		stringBuilder.append(" left join bd_psndoc p on p.id_psndoc=a.id_emp_sign ");
		stringBuilder.append(" where a.id_or ");
		stringBuilder.append(id_pathors);
		return stringBuilder.toString();
	}
	/**
	 * BS452
	 * 住院病理签署 获取联系人集合【IEIpPathContactDTO】
	 * @param idOrs
	 * @return
	 */
	public String getIpPathSignContacterInfoSql(String idOrs) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select distinct ");
		stringBuilder.append(" b.code as Id_patient, ");//病人主键(此处取编码 和前面查询的数据保持一致， 便于赋值)
		stringBuilder.append(" c.conttel as Contacttelephone, ");//联系人电话
		stringBuilder.append(" c.name as Contactname ");//联系人姓名
		stringBuilder.append(" from ci_order a ");
		stringBuilder.append(" left join pi_pat b on b.id_pat=a.id_pat ");
		stringBuilder.append(" left join pi_pat_cont c on c.id_pat= b.id_pat ");
		stringBuilder.append(" where a.id_or ");
		stringBuilder.append(idOrs);
		return stringBuilder.toString();
	}
	/**
	 * BS452
	 *  住院病理签署 获取申请单集合【IEIpPathApplyDTO】
	 * @param id_ors
	 * @return
	 */
	public String getIpPathSignApplyInfoSql(String id_ors) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" b.id_or as id_or, ");
		stringBuilder.append(" b.id_en as id_en, ");
		stringBuilder.append(" a.no_applyform as requestNo, ");//检查申请单编号
		stringBuilder.append(" c.code as orderType, ");//医嘱类型编码
		stringBuilder.append(" c.name as orderTypeName, ");//医嘱类型名称
		stringBuilder.append(" b.dt_sign as requestDate, ");//检查申请日期
		stringBuilder.append(" b.dt_last_mp as executeTime, ");//执行时间
		stringBuilder.append(" d.code as executiveDept, ");//执行科室编码
		stringBuilder.append(" d.name as executiveDeptName, ");//执行科室名称
		stringBuilder.append(" a.Announcements as requestNotice, ");//申请注意事项
		//--送检目的
		stringBuilder.append(" sum(e.quan_total_medu * e.pri) as totalSum ");//费用总金额
		stringBuilder.append(" from ci_ap_pathgy a ");
		stringBuilder.append(" left join ci_order b on a.id_or=b.id_or ");
		stringBuilder.append(" left join bd_srvca c on c.id_srvca=b.id_srvca ");
		stringBuilder.append(" left join bd_dep d on d.id_dep=b.id_dep_mp ");
		stringBuilder.append(" left join ci_or_srv e on e.id_or=b.id_or ");
		stringBuilder.append(" where e.fg_bl='Y' ");
		stringBuilder.append(" and b.id_or  ");
		stringBuilder.append(id_ors);
		stringBuilder.append(" group by b.id_or,b.id_en,a.no_applyform,c.code,c.name,b.dt_sign,b.dt_last_mp,d.code,d.name,a.Announcements ");
		return stringBuilder.toString();
	}
	/**
	 * BS452
	 * 住院病理签署 获取诊断集合【IEIpPathDiagDTO】
	 * @param id_ors
	 * @return
	 */
	public String getIpPathSignDiagInfoSql(String id_ors) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" a.id_or as id_or, ");
		stringBuilder.append(" a.id_en as id_en, ");
		stringBuilder.append(" (case when c.fg_majdi = 'Y' then '12' when c.fg_majdi = 'N' then '13' else '' end) as diagnosisType, ");//诊断类别编码
		stringBuilder.append(" (case when c.fg_majdi = 'Y' then '主要诊断' when c.fg_majdi = 'N' then '次要诊断' else '' end) as diagnosisTypeName, ");//诊断类别名称
		stringBuilder.append(" d.dt_sign as diagnosisDate, ");//诊断日期
		stringBuilder.append(" c.id_didef_code as diseaseCode, ");//疾病编码
		stringBuilder.append(" c.id_didef_name as diseaseName ");//疾病名称
		stringBuilder.append(" from ci_order a ");
		stringBuilder.append(" left join en_ent_di b on b.id_ent=a.id_en ");
		stringBuilder.append(" left join ci_di_itm c on b.id_diitm=c.id_diitm ");
		stringBuilder.append(" left join ci_di d on b.id_di=d.id_di ");
		stringBuilder.append(" where b.fg_maj='Y' ");
		stringBuilder.append(" and  a.id_or ");
		stringBuilder.append(id_ors);
		return stringBuilder.toString();
	}
	/**
	 * BS452
	 * 住院病理签署 获取费用项目明细集合【IEIpPathSrvDTO】
	 * @param id_ors
	 * @return
	 */
	public String getIpPathSignSrvInfoSql(String id_ors) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select "); 
		stringBuilder.append(" a.id_or as id_or, ");
		stringBuilder.append(" a.id_en as id_en, ");
		stringBuilder.append(" c.code as chargeItemCode, ");//收费项目编码
		stringBuilder.append(" b.name as chargeItemName, ");//收费项目名
		stringBuilder.append(" b.quan_total_medu as chargeAccount, ");//数量
		stringBuilder.append(" b.pri as chargePrice ");//单价
		stringBuilder.append(" from ci_order a "); 
		stringBuilder.append(" left join ci_or_srv b on a.id_or=b.id_or ");
		stringBuilder.append(" left join bd_srv c on b.id_srv=c.id_srv ");
		stringBuilder.append(" where b.fg_bl='Y' ");
		stringBuilder.append(" and a.id_or ");
		stringBuilder.append(id_ors);
		return stringBuilder.toString();
	}
	/**
	 * BS452
	 * 住院病理签署 获取医嘱项目集合【IEIpPathOrdDTO】
	 * @param id_ors
	 * @return
	 */
	public String getIpPathSignOrdInfoSql(String id_ors) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" a.id_or as id_or, ");
		stringBuilder.append(" a.id_en as id_en, ");
		stringBuilder.append(" a.code_or as orderLid, ");//医嘱号
		stringBuilder.append(" b.code as itemCode, ");//检查项目编码
		stringBuilder.append(" a.name_or as itemName, ");//检查项目名称
		stringBuilder.append(" c.des_sympsign as orderDescribe, ");//医嘱描述
		stringBuilder.append(" (case when a.fg_urgent = 'Y' then 'true' else 'false' end) as urgentFlag, ");//是否加急
		stringBuilder.append(" c.clinicalzztz as Cliniclsign, ");//临床简史体征描述
		//--既往史 
		stringBuilder.append(" (case when c.di_pathgy_old is null then '无' else '有' end) as Pathologydiagnosisflag, ");//是否有既往病理诊断
		stringBuilder.append(" c.no_pathgy_old as previousExamNo, ");//既往检验号(取得既往病理号)
		//--初次月经日期
		stringBuilder.append(" c.def15 as Menstruallasterdate, ");//末次月经日期
		stringBuilder.append(" c.def1 as menstrualCycle, ");//月经周期
		//--是否绝经
		//--末次月经年龄
		//--怀孕次数
		//--是否正常生产
		//--流产次数
		//--末次产期
		//--治疗经过描述
		//--HBsAg检查结果编码
		//--HBsAg检查结果名称
		//--HIV检查结果编码
		//--HIV检查结果名称
		//--实验室及其他有关检查
		stringBuilder.append(" c.collectdes as operationFindings,");//--手术所见描述  采集所见
		//--手术名称编码
		//--手术名称
		stringBuilder.append(" c.dt_coll as operationTime, ");//--操作日期/时间  采集日期
		stringBuilder.append(" f.code as operationDoctorCode, ");//--手术医生编码 采集者
		stringBuilder.append(" f.name as operationDoctorName, ");//--手术医生姓名
		stringBuilder.append(" d.code as itemClassCode, ");//检查类型编码
		stringBuilder.append(" d.name as itemClassName, ");//检查类型名称
		stringBuilder.append(" phy2.code as lactationFlag, ");//是否哺乳
		stringBuilder.append(" (case when phy.code = '02' then 'true' else 'false' end) as pregnancy, ");//是否妊娠
		stringBuilder.append(" '' as pregnancyBeginDate, ");//妊娠时间
		stringBuilder.append(" b.sd_iemsgca as iemsgca_code ");//集成平台服务分类
		stringBuilder.append(" from ci_order a ");
		stringBuilder.append(" left join bd_srv b on a.id_srv=b.id_srv ");
		stringBuilder.append(" left join ci_ap_pathgy c on a.id_or=c.id_or ");
		stringBuilder.append(" left join bd_udidoc d on d.id_udidoc=a.id_srvtp ");
		stringBuilder.append(" left join pi_pat e on a.id_pat=e.id_pat ");
		stringBuilder.append(" left join ( ");//不这样写查出来的数据有问题 暂时就知道这种关联方法
		stringBuilder.append("           select z0.id_pat, d0.code ");
		stringBuilder.append("           from pi_pat_phy z0 ");
		stringBuilder.append("           left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind ");
		stringBuilder.append("           where d0.code = '04' ");
		stringBuilder.append("           ) phy2 on phy2.Id_Pat = e.Id_Pat ");
		stringBuilder.append(" left join ( ");
		stringBuilder.append("            select z0.id_pat, d0.code, z0.sv ");
		stringBuilder.append("            from pi_pat_phy z0 ");
		stringBuilder.append("            left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind ");
		stringBuilder.append("            where d0.code = '02' ");
		stringBuilder.append("            )phy ON phy.Id_Pat = e.Id_Pat ");
		stringBuilder.append(" left join bd_psndoc f on f.Id_Psndoc=c.id_emp ");
		stringBuilder.append(" where a.id_or ");
		stringBuilder.append(id_ors);
		return stringBuilder.toString();
	}
	/**
	 * BS452
	 * 住院病理签署 获取标本集合【IEIpPathSampleDTO】
	 * @param id_ors
	 * @return
	 */
	public String getIpPathSignSampleInfoSql(String id_ors) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select"); 
		stringBuilder.append(" a.id_or as id_or, ");
		stringBuilder.append(" d.id_en as id_en, ");
		stringBuilder.append(" c.code as sampleTypeCode, ");//标本分类编码
		stringBuilder.append(" c.name as sampleTypeName, ");//标本分类名称
		stringBuilder.append(" b.quan_coll as sampleAccounts, ");//数量
		stringBuilder.append(" b.name_labsamp as inspectionSample, ");//送检标本
		stringBuilder.append(" b.sd_body_coll as pathologyBodyCode, ");//病变部位编码
		stringBuilder.append(" b.body_coll as pathologyBodyName, ");//病变部位名称
		stringBuilder.append(" a.dt_coll as inVitroDate ");//--离体时间 采集日期
		//--固定时间
		stringBuilder.append(" from ci_ap_pathgy a ");
		stringBuilder.append(" left join  ci_pathgy_samp b on a.id_appathgy=b.id_appathgy ");
		stringBuilder.append(" left join bd_udidoc c on a.id_samptp=c.id_udidoc ");
		stringBuilder.append(" left join ci_order d on d.id_or=a.id_or ");
		stringBuilder.append(" where a.id_or ");
		stringBuilder.append(id_ors);
		return stringBuilder.toString();
	}
}
