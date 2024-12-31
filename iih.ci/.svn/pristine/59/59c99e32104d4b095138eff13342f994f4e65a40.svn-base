package iih.ci.event.ord.bps.revert.op.sql;
/**
 * 门诊撤回备血sql查询BS309
 * @author F
 *
 * @date 2019年10月10日下午2:07:21
 *
 * @classpath iih.ci.event.ord.bps.revert.op.sql.OpBuRevertSql
 */
public class OpBuRevertSql {

	/**
	 * BS309
	 * 门诊 撤回 用血sql查询【IEOpBtUseOrDTO】(该dto包含了就诊和医嘱信息)
	 * @param id_or4sql
	 * @return
	 */
	public String getOpBuRevertEntAndOrdInfoSql(String id_or4sql){
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select "); 
		stringBuilder.append(" A1.id_or as id_iebtuseoren, ");//医嘱id
	    stringBuilder.append(" B.code as patient_id, ");//患者ID
	    stringBuilder.append(" b.barcode_chis as p_bar_code, ");//就诊号
	    stringBuilder.append(" C.Name_Pat as name, ");//患者姓名
	    stringBuilder.append(" C.Sd_Sex_Pat as sex, ");//性别编码
	    stringBuilder.append(" C.Dt_Birth_Pat as brithday, ");//出生日期
	    stringBuilder.append(" '' as age, ");//年龄
	    stringBuilder.append(" I.code as apply_unit, ");//病人科室编码
	    stringBuilder.append(" I.name as apply_unit_name, ");//病人科室名称
	    stringBuilder.append(" G.code as ward_code, ");//病区
	    stringBuilder.append(" G.name as ward_code_name, ");//病区名称
	    stringBuilder.append(" H.NAME_BED as bed_no, ");//床位号
	    stringBuilder.append(" S.OrgCode as hospital_code, ");//医疗机构编码
	    stringBuilder.append(" S.Name as hospital_name, ");//医疗机构名称
	    stringBuilder.append(" (case when H.Times_Ip is null then 0 else H.Times_Ip end) + (case when J.Times_Op is null then 0 else J.Times_Op end) as times, ");//就诊次数
	    stringBuilder.append(" btor.applyno as bill_id, ");//输血申请单号
	    stringBuilder.append(" Q.no_applyform as use_sn, ");//取血单号
	    stringBuilder.append(" '1' as get_times, ");//取血次数
	    stringBuilder.append(" A.Code_Or as yz_no, ");//医嘱号
	    stringBuilder.append(" substr(T.code, 7) as blood_class, ");//血液成分编码
	    stringBuilder.append(" T.name as blood_class_name, ");//血液成分名称
	    stringBuilder.append(" A1.Quan_Medu as use_amount, ");//取血量
	    stringBuilder.append(" U.code as use_amount_code, ");//取血量单位
	    stringBuilder.append(" Q.Dt_Bu_Plan as use_date, ");//取血日期
	    stringBuilder.append(" bt.sd_bloodtype_ap as abo_type, ");//ABO血型编码
	    stringBuilder.append(" aboudi.name as abo_type_name, ");//ABO血型名称
	    stringBuilder.append(" bt.sd_rhd_ap as rh_d, ");//Rh血型编码
	    stringBuilder.append(" rhudi.name as rh_d_name, ");//Rh血型名称
	    stringBuilder.append(" '' as is_lg, ");//是否留观项目编码
	    stringBuilder.append(" '' as is_lg_r, ");//是否留观项目值
	    stringBuilder.append(" W.code as app_doctor, ");//申请医师编码
	    stringBuilder.append(" W.name as app_doctor_name, ");//申请医师名称
	    stringBuilder.append(" ");//申请日期
	    stringBuilder.append(" W.MOBILE as app_tel, ");//申请医师联系电话
	    stringBuilder.append(" '' as op_loc, ");//手术间编码
	    stringBuilder.append(" '' as op_loc_name, ");//手术间名称(层)
	    stringBuilder.append(" '' as op_tel, ");//手术间电话
	    stringBuilder.append(" '01' as domain_id, ");//域id
	    stringBuilder.append(" t.SD_IEMSGCA as iemsgca_code, ");//集成平台服务分类
	    stringBuilder.append(" C.code as visit_ord_no, ");//就诊流水号
	    stringBuilder.append(" BD.name as visit_type_name, ");//就诊类别名称
	    stringBuilder.append(" A.Code_Entp as visit_type, ");//就诊类别
	    stringBuilder.append(" v.code as exec_code, ");//执行科室编码
	    stringBuilder.append(" x.code as apply_code, ");//申请科室编码
	    stringBuilder.append(" a1.sd_su_bl as pay_flag ");//收费状态标识
	    stringBuilder.append(" from ci_or_srv A1 ");
	    stringBuilder.append(" left outer join ci_order A ON A1.Id_Or = A.Id_Or ");
	    stringBuilder.append(" left outer join ci_ap_bu Q ON Q.id_or = A.Id_Or ");
	    stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
	    stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
	    stringBuilder.append(" left outer join en_ent_ip H ON C.Id_Ent = H.Id_Ent ");
	    stringBuilder.append(" left outer join en_ent_op J ON A.Id_En = J.Id_Ent ");
	    stringBuilder.append(" left outer join bd_dep G ON G.Id_Dep = C.Id_Dep_Nur ");
	    stringBuilder.append(" left outer join bd_dep I ON I.Id_Dep = C.Id_Dep_Phy ");
	    stringBuilder.append(" left outer join bd_psndoc R ON R.Id_Psndoc = A.Id_Emp_Chk ");
	    stringBuilder.append(" left outer join bd_psndoc W ON W.Id_Psndoc = A.Id_Emp_Or ");
	    stringBuilder.append(" left outer join bd_org S ON S.Id_Org = A.Id_Org ");
	    stringBuilder.append(" left outer join bd_measdoc U ON U.Id_Measdoc = A1.Id_Medu ");
	    stringBuilder.append(" left outer join ci_order btor on A.id_or_rel = btor.id_or ");
	    stringBuilder.append(" left outer join ci_ap_bt bt on btor.id_or = bt.id_or ");
	    stringBuilder.append(" left outer join bd_udidoc aboudi on aboudi.id_udidoc = bt.id_bloodtype_ap ");
	    stringBuilder.append(" left outer join bd_udidoc rhudi on rhudi.id_udidoc = bt.id_rhd_ap ");
	    stringBuilder.append(" left outer join bd_srv T ON T.Id_Srv = btor.Id_Srv ");
	    stringBuilder.append(" left outer join BD_ENTP BD ON a.CODE_ENTP = BD.CODE ");
	    stringBuilder.append(" left outer join bd_dep V ON V.Id_Dep = A.Id_Dep_Mp ");
	    stringBuilder.append(" left outer join bd_dep X ON X.Id_Dep = A.Id_Dep_Or ");
	    stringBuilder.append(" where A1.Sd_Srvtp like '14%' and A1.id_or ");
	    stringBuilder.append(id_or4sql);
		return stringBuilder.toString();
	}
}
