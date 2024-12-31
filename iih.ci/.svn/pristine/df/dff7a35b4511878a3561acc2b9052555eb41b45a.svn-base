package iih.ci.event.ord.bps.revert.op.sql;
/**
 * 门诊撤回备血sql查询BS008
 * @author F
 *
 * @date 2019年10月10日上午10:46:33
 *
 * @classpath iih.ci.event.ord.bps.revert.op.sql.OpBtRevertSql
 */
public class OpBtRevertSql {
	/**
	 * BS008
	 * 门诊 撤回 备血就诊/申请信息【IEOpBtOrEnDTO】
	 * @param id_or4sql
	 * @return
	 */
	public String getOpBtRevertEntInfoSql(String id_or4sql){
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select "); 
		stringBuilder.append(" c.id_ent as id_ent, ");//就诊id
		stringBuilder.append(" (case when ITM.FG_MAJDI = 'Y' then '12' when ITM.FG_MAJDI = 'N' then '13' else '' end) as diagnosistype, ");//诊断类别编码
		stringBuilder.append(" (case when ITM.FG_MAJDI = 'Y' then '主要诊断' when ITM.FG_MAJDI = 'N' then '次要诊断' else '' end) as diagnosistypename, ");//诊断类别名称
		stringBuilder.append(" A.Dt_Sign as confirm_date, ");//审核时间/确认时间
		stringBuilder.append(" (case when phy.code = '02' then 'true' else 'false' end) as is_pregnancy, ");//是否妊娠/怀孕
		stringBuilder.append(" (case when phy.code = '02' then phy.sv else '' end) as pregnancy_date, ");//妊娠/怀孕时间
		stringBuilder.append(" (case when phy2.code = '04' then 'true' else 'false' end) as is_breastfeeding, ");//是否哺乳
		stringBuilder.append(" al.name_alcla as allergy, ");//过敏史
		stringBuilder.append(" card.code as healthcard_no, ");//健康卡号
		stringBuilder.append(" Q.id_apbt, ");//备血申请单id?
		stringBuilder.append(" Q.id_or as id_iebtoren, ");//IE输血申请就诊主键标识?
		stringBuilder.append(" null as iebtdiags, ");//IE输血诊断集合?
		stringBuilder.append(" null as iebtillhiss, ");//IE输血病史集合?
		stringBuilder.append(" null as iebtnumlisitms, ");//IE输血数值检验项目集合?
		stringBuilder.append(" null as iebtcdlisitms, ");//IE输血cd检验项目集合?
		stringBuilder.append(" null as iebtstrlisitms, ");//IE输血字串检验项目集合?
		stringBuilder.append(" B.code as patientid, ");//患者id
		stringBuilder.append(" C.Name_Pat as name, ");//姓名
		stringBuilder.append(" C.Sd_Sex_Pat as sex, ");//性别
		stringBuilder.append(" B.DT_BIRTH_HMS as birthday, ");//生日
		stringBuilder.append(" '' as age, ");//年龄
		stringBuilder.append(" C.Addr_Pat as address, ");//地址
		stringBuilder.append(" C.Sd_Mari_Pat as marriagecode, ");//婚姻状况编码
		stringBuilder.append(" K.STREET as birthplace, ");//出生地
		stringBuilder.append(" B.Id_Code as socialno, ");//身份证号
		stringBuilder.append(" Q.no_db as bloodno, ");//献血证号
		stringBuilder.append(" b.barcode_chis  as pbarcode, ");//就诊号
		stringBuilder.append(" G.code as wardno, ");//病区编码
		stringBuilder.append(" G.name as wardname, ");//病区名称
		stringBuilder.append(" H.Name_Bed as bedno, ");//床号
		stringBuilder.append(" ");//床位编码
		stringBuilder.append(" c.telno_pat as tel, ");//联系电话
		stringBuilder.append(" '' as privatecode, ");//病人信息隐私级别编码
		stringBuilder.append(" ");//病人信息隐私级别名称
		stringBuilder.append(" I.Code as deptcode, ");//病人科室ID
		stringBuilder.append(" I.Name as deptname, ");//病人科室名称
		stringBuilder.append(" L.Name as feeclass, ");//费用类别
		stringBuilder.append(" (case when H.Times_Ip is null then 0 else H.Times_Ip end) + (case when J.Times_Op is null then 0 else J.Times_Op end) as times, ");//就诊次数
		stringBuilder.append(" J.Dt_Valid_b as visit_date, ");//就诊/住院时间
		stringBuilder.append(" Q.NO_APPLYFORM as applyno, ");//申请单号
		stringBuilder.append(" A.Des_Or as comment1, ");//备注
		stringBuilder.append(" A.Dt_Entry as applytime, ");//申请时间
		stringBuilder.append(" A1.Quan_Medu as bloodamount, ");//申请血量
		stringBuilder.append(" U.Name as bloodunit, ");//单位
		stringBuilder.append(" Q.Dt_Bt_Pl as usetime, ");//用血时间
		stringBuilder.append(" Q.SD_PPS_BT as sxmdcode, ");//输血目的编码
		stringBuilder.append(" M.Name as sxmdname, ");//输血目的描述
		stringBuilder.append(" substr(T.code, 7) as bloodcode, ");//输血品种代码
		stringBuilder.append(" T.name as bloodname, ");//输血品种名称?
		stringBuilder.append(" W.Code as applydoctor, ");//申请医师编码
		stringBuilder.append(" W.Name as applydoctorname, ");//申请医师姓名
		stringBuilder.append(" X.code as applydept, ");//申请科室编码
		stringBuilder.append(" X.Name as applydeptname, ");//申请科室名称
		stringBuilder.append(" R.code as respdoctor, ");//审核（主治）医师编码
		stringBuilder.append(" R.Name as respdoctorname, ");//审核（主治）医师姓名
		stringBuilder.append(" A.Code_Or as yz_no, ");//医嘱号?
		stringBuilder.append(" '01' as domain_id, ");//域id
		stringBuilder.append(" S.Orgcode as orgcode, ");//医疗机构代码
		stringBuilder.append(" S.NAME as orgname, ");//医疗机构名称
		stringBuilder.append(" co.conttel as contacttel, ");//联系人电话
		stringBuilder.append(" co.name as contactname, ");//联系人姓名
		stringBuilder.append(" ITM.id_didef_code as didef_code, ");//疾病编码?
		stringBuilder.append(" ITM.id_didef_name as didef_name, ");//疾病名称?
		stringBuilder.append(" Q.id_diitm as didef_id, ");//诊断id?
		stringBuilder.append(" Q.sd_rhd_ap as Rhcode, ");//申请Rh（D）血型编码
		stringBuilder.append(" rh.name as Rhvalue, ");//申请Rh（D）血型值
		stringBuilder.append(" Q.sd_demandsu_bt as Emergencycode, ");//用血紧急程度编码
		stringBuilder.append(" deman.name as Emergencyname, ");//用血紧急程度名称
		stringBuilder.append(" t.SD_IEMSGCA as iemsgca_code, ");//集成平台服务分类
		stringBuilder.append(" C.code as visitordno, ");//就诊流水号
		stringBuilder.append(" BD.name as visittypename, ");//就诊类别名称
		stringBuilder.append(" Q.sd_bloodtype_ap as Abocode, ");//申请ABO血型编码?
		stringBuilder.append(" abo.name as Abovalue, ");//申请ABO血型值?
		stringBuilder.append(" A.Code_Entp as jztype, ");//就诊类别编码
		stringBuilder.append(" v.code as exec_code, ");//执行科室编码
		stringBuilder.append(" A1.sd_su_bl as pay_flag, ");
		stringBuilder.append(" q.id_mode_bt as Id_mode_bt ");
		stringBuilder.append(" ");//业务操作时间
		stringBuilder.append(" ");//临床路径项目序号
		stringBuilder.append(" from ci_or_srv A1 ");
		stringBuilder.append(" left outer join ci_order A ON A1.Id_Or = A.Id_Or ");
		stringBuilder.append(" left outer join ci_ap_bt Q ON Q.id_or = A.Id_Or ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join pi_pat_card card ON A.Id_Pat = card.Id_Pat and card.fg_act = 'Y' and card.sd_patcardtp = '05' ");
		stringBuilder.append(" left outer join pi_pat_cardtp cardtp ON cardtp.id_cardtp = card.id_patcardtp and cardtp.sd_patcardtp = '05' ");
		stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		stringBuilder.append(" left outer join en_ent_ip H ON C.Id_Ent = H.Id_Ent ");
		stringBuilder.append(" left outer join en_ent_op J ON A.Id_En = J.Id_Ent ");
		stringBuilder.append(" left outer join bd_dep G ON G.Id_Dep = C.Id_Dep_Nur ");
		stringBuilder.append(" left outer join bd_dep I ON I.Id_Dep = C.Id_Dep_Phy ");
		stringBuilder.append(" left outer join bd_psndoc R ON R.Id_Psndoc = A.Id_Emp_Sign ");
		stringBuilder.append(" left outer join bd_psndoc W ON W.Id_Psndoc = A.Id_Emp_Or ");
		stringBuilder.append(" left outer join bd_dep X ON X.Id_Dep = A.Id_Dep_Or ");
		stringBuilder.append(" left outer join bd_org S ON S.Id_Org = A.Id_Org ");
		stringBuilder.append(" left outer join bd_srv T ON T.Id_Srv = A1.Id_Srv ");
		stringBuilder.append(" left outer join bd_measdoc U ON U.Id_Measdoc = A1.Id_Medu ");
		stringBuilder.append(" left outer join pi_pat_addr K ON K.Id_Pat = B.Id_Pat and K.Sd_Addrtp = '6' ");
		stringBuilder.append(" left outer join bd_pri_pat L ON L.Id_Pripat = B.Id_Patpritp ");
		stringBuilder.append(" left outer join bd_udidoc M ON M.Id_Udidoc = Q.Id_Pps_Bt ");
		stringBuilder.append(" left join pi_pat_cont co on co.id_pat = b.id_pat ");
		stringBuilder.append(" left outer join en_ent_di M1  ON A.Id_En = M1.Id_Ent ");
		stringBuilder.append(" left outer join ci_di_itm itm ON M1.ID_DIITM = itm.ID_DIITM ");
		stringBuilder.append(" left outer join bd_udidoc abo ON Q.id_bloodtype_ap = abo.id_udidoc ");
		stringBuilder.append(" left outer join bd_udidoc rh ON Q.id_rhd_ap = rh.id_udidoc ");
		stringBuilder.append(" left outer join bd_udidoc deman ON Q.id_demandsu_bt = deman.id_udidoc ");
		stringBuilder.append(" left outer join BD_ENTP BD ON a.CODE_ENTP = BD.CODE ");
		stringBuilder.append(" left join (select ");
		stringBuilder.append("            z0.id_pat, d0.code, z0.sv ");
		stringBuilder.append("            from pi_pat_phy z0 ");
		stringBuilder.append("            left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind ");
		stringBuilder.append("            where d0.code = '02') phy ON phy.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left join (select z0.id_pat, d0.code ");
		stringBuilder.append("            from pi_pat_phy z0 ");
		stringBuilder.append("            left join pi_pat_phyind d0 on d0.id_patphyind = z0.id_patphyind ");
		stringBuilder.append("            where d0.code = '04') phy2 on phy2.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join (select ");
		//0184716: 集成平台消息将wm__concat替换为LISTAGG，避免版本不兼容
		stringBuilder.append("                  bb.id_pat, listagg(TO_CHAR(TO_DATE(substr(aa.dt_act,1,10),'yyyy-MM-dd'),'yyyy-MM-dd') || ':' || aa.name_alcla) within group(order by bb.id_pat) as name_alcla ");
		stringBuilder.append("                  from pi_pat_al aa ");
		stringBuilder.append("                  inner join pi_pat bb on bb.id_pat = aa.id_pat ");
		stringBuilder.append("                  group by bb.id_pat) al ON al.id_pat = B.Id_Pat ");
		stringBuilder.append(" left outer join bd_dep V ON V.Id_Dep = A.Id_Dep_Mp ");
		stringBuilder.append(" where A1.Sd_Srvtp like '14%' and  M1.Fg_Maj = 'Y' ");
		stringBuilder.append(" and A1.id_or ");
		stringBuilder.append(id_or4sql);
		return stringBuilder.toString();
	}
	/**
	 * BS008
	 * 门诊 撤回 备血检验项目【IEOpBtCdLisItmDTO】
	 */
	public String getOpBtRevertCheckInfoSql(String id_apbt){
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" A.sd_restrptlabtp, ");
		stringBuilder.append(" A.val_restrptlab, ");//检验结果
		stringBuilder.append(" A.id_restrptlabtp, ");
		stringBuilder.append(" A.val_rstrptla, ");
		stringBuilder.append(" A.id_unit, ");
		stringBuilder.append(" B.name as name_unit, ");
		stringBuilder.append(" A.id_apbtobsindex, ");
		stringBuilder.append(" A.id_apbt, ");
		stringBuilder.append(" C.code as code_srv ");//输血申请检验项目编码
		stringBuilder.append(" from ci_ap_bt_viewitm A ");
		stringBuilder.append(" left outer join bd_measdoc B ON A.id_unit = B.id_measdoc ");
		stringBuilder.append(" left outer join bd_srv C ON A.id_srv = C.id_srv ");
		stringBuilder.append("  where A.id_apbt ");
		stringBuilder.append(id_apbt);
		return stringBuilder.toString();
	}
}
