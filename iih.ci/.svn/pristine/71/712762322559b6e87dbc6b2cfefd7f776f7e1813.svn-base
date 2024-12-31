package iih.ci.event.ord.bps.sign.op.sql;

import iih.ci.event.ord.utils.OrdEventUtil;

/**
 * 门诊签署处方/药品sql查询BS302
 * @author F
 *
 * @date 2019年8月22日上午10:51:18
 *
 * @classpath iih.ci.event.ord.bps.sign.op.sql.OpDrugSignSql
 */
public class OpDrugSignSql {
	
	//处方结构图
	//	IEOpPharmOrEnDTO就诊
	//    					IEOpPharmPresDTO处方list  
	//			    								IEOpPharmWcOrDTO西药list
	//			    								IEOpPharmHerbOrDTO草药list
	//						      											  IEOpPharmOrMmDTO草药成分list
	//						      											  ......
	//			    								......
	//    					IEOpPharmOrFeeDTO已收费list
	//    					......
	
	/**
	 * BS302
	 * 门诊 处方/药品签署就诊信息【IEOpPharmOrEnDTO】
	 * @return
	 */
	public String getOpDrugSignEntInfoSql() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" A.id_en as id_iepharmoren, ");//就诊id
	    stringBuilder.append(" B.code as patientid, ");//患者ID
	    stringBuilder.append(" b.barcode_chis as p_bar_code, ");//就诊号
	    stringBuilder.append(" F.Times_Op as times, ");//就诊次数
	    stringBuilder.append(" D.CODE as dept_code, ");//就诊科室编码
	    stringBuilder.append(" D.Name as deptname, ");//就诊科室名称
	    stringBuilder.append(" J.orgcode as orgcode, ");//医疗机构编码
	    stringBuilder.append(" J.name as orgname, ");//医疗机构名称
	    stringBuilder.append(" C.Name_Pat as patientname, ");//患者姓名
	    stringBuilder.append(" C.Sd_Sex_Pat as sex, ");//性别编码
	    stringBuilder.append(" C.Dt_Birth_Pat as birthday, ");//出生日期
	    stringBuilder.append(" '' as age, ");//年龄
	    stringBuilder.append(" ag.sd_conttp as relationcode, ");//与患者关系编码
	    stringBuilder.append(" doc.name as relationname, ");//与患者关系名称
	    stringBuilder.append(" ag.idno_agent as dbsocialid, ");//代办人身份证号
	    stringBuilder.append(" ag.name_agent as dbname, ");//代办人姓名
	    stringBuilder.append(" E.Code as responsetypecode, ");//病人身份编码
	    stringBuilder.append(" E.Name as responsetypename, ");//病人身份名称
	    stringBuilder.append(" H.Code as insurrancecode, ");//保险类别编码
	    stringBuilder.append(" H.Name as insurrancetype, ");//保险类别名称
	    stringBuilder.append(" I.Code as insurranceno, ");//保险机构号
	    stringBuilder.append(" C.code as visitordno, ");//就诊流水号
	    stringBuilder.append(" a.code_entp as visitTypeCode, ");//就诊类别编码
	    stringBuilder.append(" BD.name as visittypename, ");//就诊类别名称
	    stringBuilder.append(" l.code as applydeptcode, ");//申请科室编码
	    stringBuilder.append(" dep.code as exec_code, ");//执行科室编码
	    stringBuilder.append(" dep.name as exec_name ");//执行科室
		stringBuilder.append(" from ci_order A ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		stringBuilder.append(" left outer join bd_dep D ON C.Id_Dep_Phy = D.ID_DEP ");
		stringBuilder.append(" left outer join en_ent_op F ON C.Id_Ent = F.Id_Ent ");
		stringBuilder.append(" left outer join pi_pat_ca E ON E.Id_Patca = B.Id_Paticate ");
		stringBuilder.append(" left outer join bd_hp G ON G.Id_Hp = C.Id_Hp ");
		stringBuilder.append(" left outer join (select * ");
		stringBuilder.append("                  from bd_udidoc ");
		stringBuilder.append("                  where id_udidoclist = '@@@@ZZ200000000000A2') H ON H.Code = G.Sd_Hptp ");
		stringBuilder.append(" left outer join bd_cust I ON I.ID_CUST = G.ID_CUST ");
		stringBuilder.append(" left outer join bd_org J ON J.ID_ORG = A.ID_ORG ");
		stringBuilder.append(" left outer join BD_ENTP BD ON a.CODE_ENTP = BD.CODE ");
		stringBuilder.append(" left join ci_orsrv_agent ag on ag.id_or = a.id_or ");
		stringBuilder.append(" left join bd_udidoc doc on doc.id_udidoc = ag.id_conttp ");
		stringBuilder.append(" left outer join bd_dep L ON A.Id_Dep_Or = L.ID_DEP ");
		stringBuilder.append(" left join bd_dep dep ON A.Id_Dep_Mp = dep.Id_Dep ");
		stringBuilder.append("  where A.id_or = ? ");
		return stringBuilder.toString();
	}
	/**
	 * BS302
	 * 门诊 处方/药品签署 处方信息(收费/未收费)【IEOpPharmPresDTO】
	 * @return
	 */
	public String getOpDrugSignPressInfoSql() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" A.ID_PRES as id_iepharmpres, ");
	    stringBuilder.append(" A.Id_En as id_iepharmoren, ");//就诊id
	    stringBuilder.append(" null as id_iepharmwcors, ");
	    stringBuilder.append(" A.code || '_' || A.id_pres as orderno, ");//处方号
	    stringBuilder.append(" A.Sd_Prestp as ordertypecode, ");//处方类别编码
	    stringBuilder.append(" B.name      as ordertypename, ");//处方类别名称
	    stringBuilder.append(" C.Code      as doctorcode, ");//开方医生编码
	    stringBuilder.append(" C.Name      as doctorname, ");//开方医生姓名
	    stringBuilder.append(" A.Dt_Entry  as ordertime, ");//开方时间
	    stringBuilder.append(" D.Code      as deptcode, ");//开方科室编码
	    stringBuilder.append(" D.Name      as deptname, ");//开方科室名称
	    stringBuilder.append(" E.code      as checkdoctorcode, ");//审核医生编码
	    stringBuilder.append(" E.name      as checkdoctorname, ");//审核医生姓名
	    stringBuilder.append(" A.Dt_Entry  as checktime ");//审核时间
	    stringBuilder.append(" ");//处方有效天数
	    stringBuilder.append(" ");//处方备注信息
		stringBuilder.append(" from ci_pres A ");
		stringBuilder.append(" left outer join bd_udidoc B ON B.Id_Udidoc = A.Id_Prestp ");
		stringBuilder.append(" left outer join bd_psndoc C ON C.Id_Psndoc = A.Id_Emp_Or ");
		stringBuilder.append(" left outer join bd_dep D ON D.Id_Dep = A.Id_Dep_Or ");
		stringBuilder.append(" left outer join bd_psndoc E ON A.Id_Emp = E.Id_Psndoc ");
		stringBuilder.append(" left outer join pi_pat F ON F.id_pat = A.id_pati ");
		stringBuilder.append(" left outer join en_ent_op G ON A.Id_En = G.Id_Ent ");
		stringBuilder.append(" where A.Id_Pres in ");
		stringBuilder.append(" (select distinct p.id_pres from ci_or_srv p ");
		stringBuilder.append(" left join CI_ORDER ord on p.ID_OR = ord.ID_OR ");
		stringBuilder.append(" where p.ID_OR = ? ");
		stringBuilder.append(" and ord.fg_sign = 'Y' and ord.fg_canc = 'N' and ord.sd_srvtp like '01%' ");
		stringBuilder.append("  and p.id_su_bl in (?, ?)) ");
		return stringBuilder.toString();
	}
	/**
	 * BS302
	 * 门诊 签署 处方/药品金额 【IEOpPharmPresDTO】->【IEOpPharmOrFeeDTO】
	 * @return
	 */
	public String getOpDrugSignPressPriceInfoSql() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" sum(round(mm.quan_cur * mm.price_pgku_cur,2)) as prescriptionMoney, ");//处方金额
		stringBuilder.append(" '元' as prescriptionmoneyunit, ");//处方金额单位
		stringBuilder.append(" srv.id_pres as id_iepharmpres ");//处方id
		stringBuilder.append(" from ci_or_srv srv ");
		stringBuilder.append(" left join ci_or_srv_mm mm on srv.id_orsrv =mm.id_orsrv ");
		stringBuilder.append(" left join ci_order ord on ord.id_or=srv.id_or ");
		stringBuilder.append(" where srv.id_en =? and ord.fg_sign='Y' and ord.fg_canc = 'N' "
				+ " and ord.sd_srvtp like '01%' and srv.id_su_bl in (?,?) ");
		stringBuilder.append(" group by srv.id_pres ");
		return stringBuilder.toString();
	}
	/**
	 * BS302
	 * 门诊 处方/药品签署 西药信息【IEOpPharmWcOrDTO】
	 * @return
	 */
	public String getOpDrugSignWcInfoSql() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" a.code_or as durggid, ");//药品组号
	    stringBuilder.append(" drug.sd_dosage as drugformcode, ");//药物剂型编码
	    stringBuilder.append(" doc.name as drugform, ");//药物剂型名称
	    stringBuilder.append(" A1.Id_Orsrv as id_iepharmwcor, ");//服务id
	    stringBuilder.append(" A1.Id_Pres as id_iepharmpres, ");//处方id
	    stringBuilder.append(" A1.id_orsrv as yzno, ");//医嘱号
	    stringBuilder.append(" '03' as medicine_type, ");//药物标识编码
	    stringBuilder.append(" (case ");
	    stringBuilder.append("   when Z2.code_entp = '"+OrdEventUtil.OP+"' then '10' ");
	    stringBuilder.append("   when Z2.code_entp = '"+OrdEventUtil.JZ+"' then '02' ");
	    stringBuilder.append("   when Z2.code_entp = '0101' then '02' ");
	    stringBuilder.append("   when Z2.code_entp = '0102' then '02' ");
	    stringBuilder.append(" end) as ordertypecode, ");//处方类型编码
	    stringBuilder.append(" (case ");
	    stringBuilder.append("   when Z2.code_entp = '"+OrdEventUtil.OP+"' then '门诊西药' ");
	    stringBuilder.append("   when Z2.code_entp = '"+OrdEventUtil.JZ+"' then '急诊西药' ");
	    stringBuilder.append("   when Z2.code_entp = '0101' then '急诊西药' ");
	    stringBuilder.append("   when Z2.code_entp = '0102' then '急诊西药' ");
	    stringBuilder.append(" end) as ordertypename, ");//处方类型名称
	    stringBuilder.append(" A1.Sd_Hpsrvtp as ybtypecode, ");//医保类型编码
	    stringBuilder.append(" R.Name as ybtypename, ");//医保类型名称
	    stringBuilder.append(" S.Code as frqcode, ");//频次编码
	    stringBuilder.append(" S.Name as frqname, ");//频次名称
	    stringBuilder.append(" A.Days_Or as persdays, ");//天数
	    stringBuilder.append(" T.Code as drugscode, ");//给药途径编码
	    stringBuilder.append(" T.Name as drugsname, ");//给药途径名称
	    stringBuilder.append(" A1.Quan_Medu as dosage, ");//次剂量
	    stringBuilder.append(" U.Name as dosageunit, ");//次剂量单位
	    stringBuilder.append(" V.Quan_Cur as amount, ");//总药量
	    stringBuilder.append(" W.Name as amountunit, ");//总药量单位
	    stringBuilder.append(" V.Quan_Cur as getamount, ");//领药量
	    stringBuilder.append(" W.Name as getunit, ");//领药量单位
	    stringBuilder.append(" A3.Code as ypcode, ");//药品编码
	    stringBuilder.append(" V.name_mm as ypname, ");//药品名称
	    stringBuilder.append(" (case when mm.id_unit_pkgbase = V.id_pgku_cur then '00' ELSE '01' END) as packserial, ");//包装序号
	    stringBuilder.append(" '' as parentno, ");//父医嘱号
	    stringBuilder.append(" A1.NOTE_SRV as advice, ");//嘱托
	    stringBuilder.append(" X.Code as exunitcode, ");//执行科室编码
	    stringBuilder.append(" X.Name as exunitname, ");//执行科室名称
	    stringBuilder.append(" (case when A1.Fg_Skintest = 'Y' then 'true' else 'false' end) as is_ps, ");//是否皮试
	    stringBuilder.append(" (case ");
	    stringBuilder.append("   when A1.FG_SKINTEST_RST = 'Y' then ");
	    stringBuilder.append("    (select  ");
	    stringBuilder.append("     t1.name ");
	    stringBuilder.append("     from ci_skin_test t ");
	    stringBuilder.append("     left outer join bd_udidoc t1 on t.id_rst_skintest = t1.id_udidoc ");
	    stringBuilder.append("     where t.id_or = A1.Id_Or) ");
	    stringBuilder.append("   else ");
	    stringBuilder.append("    '' ");
	    stringBuilder.append(" end) as is_psresult, ");//是否皮试结果
	    stringBuilder.append(" (case when A1.Fg_Indic = 'Y' then 'true' else 'false' end) as is_syz, ");//是否适应
	    stringBuilder.append(" (case when A1.Fg_Indic = 'Y' then '适应' else '非适应' end) as is_syzresult, ");//是否适应结果
	    stringBuilder.append(" (case when S.Sd_Frequnitct = '0' and S.Code = 'ST' then 'true' else 'false' end) as is_jj, ");//是否加急
	    stringBuilder.append(" (case when A.Fg_Urgent = 'Y' then '加急' when A.Fg_Urgent = 'N' then '非加急' else '' end) as is_jjresult, ");//是否加急结果
	    stringBuilder.append(" '' as is_yg, ");//是否药观
	    stringBuilder.append(" '' as is_ygresult, ");//是否药观结果
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as temporaryflagname, ");//医嘱时间类型名称
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as temporaryflagcode, ");//医嘱时间类型编码
	    stringBuilder.append(" '1' as Orderseqnum, ");//医嘱序号
	    stringBuilder.append(" ");//先诊疗后付费类型名称
	    stringBuilder.append(" a1.sd_su_bl as payflag ");//收费状态标识
	    stringBuilder.append(" ");//HIS执行状态
	    stringBuilder.append(" ");//业务操作时间
		stringBuilder.append(" from ci_or_srv A1 ");
		stringBuilder.append(" inner join ci_order A ON A.Id_Or = A1.Id_Or ");
		stringBuilder.append(" left outer join ci_pres P ON P.Id_Pres = A1.Id_Pres ");
		stringBuilder.append(" left outer join bd_udidoc Q ON Q.Id_Udidoc = P.Id_Prestp ");
		stringBuilder.append(" left outer join bd_udidoc R ON R.Id_Udidoc = A1.Id_Hpsrvtp ");
		stringBuilder.append(" left outer join bd_freq S ON S.Id_Freq = A1.Id_Freq ");
		stringBuilder.append(" left outer join bd_route T ON T.Id_Route = A1.Id_Route ");
		stringBuilder.append(" left outer join bd_measdoc U ON U.Id_Measdoc = A1.Id_Medu ");
		stringBuilder.append(" left outer join ci_or_srv_mm V ON V.ID_ORSRV = A1.Id_Orsrv ");
		stringBuilder.append(" left outer join bd_measdoc W ON W.Id_Measdoc = V.Id_Pgku_Cur ");
		stringBuilder.append(" left outer join bd_dep X ON X.ID_DEP = A1.Id_Dep_Wh ");
		stringBuilder.append(" LEFT OUTER JOIN CI_OR_SRV_MM Y ON A1.ID_ORSRV = Y.ID_ORSRV ");
		stringBuilder.append(" LEFT OUTER JOIN en_ent Z2 ON A.id_en = Z2.id_ent ");
		stringBuilder.append(" left OUTER join bd_mm A3 ON A3.ID_MM = V.ID_MM ");
		stringBuilder.append(" left outer join bd_mm mm on V.id_mm = mm.id_mm ");
		stringBuilder.append(" left outer join bd_udidoc Z3 ON (Z3.id_udidoc = '" + OrdEventUtil.ID_SU_BL_1 +"' and Z3.id_udidoclist = '" + OrdEventUtil.SD_SU_BL  +"') ");
		stringBuilder.append(" left join bd_srv bdsrv on bdsrv.id_srv = a1.id_srv ");
		stringBuilder.append(" left join bd_srv_drug drug on drug.id_srv = bdsrv.id_srv ");
		stringBuilder.append(" left join bd_udidoc doc on doc.id_udidoc = drug.id_dosage ");
		stringBuilder.append(" where %1$s ");
		return stringBuilder.toString();
	}
	/**
	 * 西药明细 暂不清楚作用
	 * @return
	 */
	public String getOpDrugSignWcRefundInfoSql() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" a.code_or as durggid, ");//药品组号
	    stringBuilder.append(" drug.sd_dosage as drugformcode, ");//药物剂型编码
	    stringBuilder.append(" doc.name as drugform, ");//药物剂型名称
	    stringBuilder.append(" A1.Id_Orsrv as id_iepharmwcor, ");//服务id
	    stringBuilder.append(" A1.Id_Pres as id_iepharmpres, ");//处方id
	    stringBuilder.append(" A1.id_orsrv as yzno, ");//医嘱号
	    stringBuilder.append(" '03' as medicine_type, ");//药物标识编码
	    stringBuilder.append(" (case ");
	    stringBuilder.append("   when Z2.code_entp = '"+OrdEventUtil.OP+"' then '10' ");
	    stringBuilder.append("   when Z2.code_entp = '"+OrdEventUtil.JZ+"' then '02' ");
	    stringBuilder.append("   when Z2.code_entp = '0101' then '02' ");
	    stringBuilder.append("   when Z2.code_entp = '0102' then '02' ");
	    stringBuilder.append(" end) as ordertypecode, ");//处方类型编码
	    stringBuilder.append(" (case ");
	    stringBuilder.append("   when Z2.code_entp = '"+OrdEventUtil.OP+"' then '门诊西药' ");
	    stringBuilder.append("   when Z2.code_entp = '"+OrdEventUtil.JZ+"' then '急诊西药' ");
	    stringBuilder.append("   when Z2.code_entp = '0101' then '急诊西药' ");
	    stringBuilder.append("   when Z2.code_entp = '0102' then '急诊西药' ");
	    stringBuilder.append(" end) as ordertypename, ");//处方类型名称
	    stringBuilder.append(" A1.Sd_Hpsrvtp as ybtypecode, ");//医保类型编码
	    stringBuilder.append(" R.Name as ybtypename, ");//医保类型名称
	    stringBuilder.append(" S.Code as frqcode, ");//频次编码
	    stringBuilder.append(" S.Name as frqname, ");//频次名称
	    stringBuilder.append(" A.Days_Or as persdays, ");//天数
	    stringBuilder.append(" T.Code as drugscode, ");//给药途径编码
	    stringBuilder.append(" T.Name as drugsname, ");//给药途径名称
	    stringBuilder.append(" A1.Quan_Medu as dosage, ");//次剂量
	    stringBuilder.append(" U.Name as dosageunit, ");//次剂量单位
	    stringBuilder.append(" V.Quan_Cur as amount, ");//总药量
	    stringBuilder.append(" W.Name as amountunit, ");//总药量单位
	    stringBuilder.append(" V.Quan_Cur as getamount, ");//领药量
	    stringBuilder.append(" W.Name as getunit, ");//领药量单位
	    stringBuilder.append(" A3.Code as ypcode, ");//药品编码
	    stringBuilder.append(" V.name_mm as ypname, ");//药品名称
	    stringBuilder.append(" (case when mm.id_unit_pkgbase = V.id_pgku_cur then '00' ELSE '01' END) as packserial, ");//包装序号
	    stringBuilder.append(" '' as parentno, ");//父医嘱号
	    stringBuilder.append(" A1.NOTE_SRV as advice, ");//嘱托
	    stringBuilder.append(" X.Code as exunitcode, ");//执行科室编码
	    stringBuilder.append(" X.Name as exunitname, ");//执行科室名称
	    stringBuilder.append(" (case when A1.Fg_Skintest = 'Y' then 'true' else 'false' end) as is_ps, ");//是否皮试
	    stringBuilder.append(" (case ");
	    stringBuilder.append("   when A1.FG_SKINTEST_RST = 'Y' then ");
	    stringBuilder.append("    (select  ");
	    stringBuilder.append("     t1.name ");
	    stringBuilder.append("     from ci_skin_test t ");
	    stringBuilder.append("     left outer join bd_udidoc t1 on t.id_rst_skintest = t1.id_udidoc ");
	    stringBuilder.append("     where t.id_or = A1.Id_Or) ");
	    stringBuilder.append("   else ");
	    stringBuilder.append("    '' ");
	    stringBuilder.append(" end) as is_psresult, ");//是否皮试结果
	    stringBuilder.append(" (case when A1.Fg_Indic = 'Y' then 'true' else 'false' end) as is_syz, ");//是否适应
	    stringBuilder.append(" (case when A1.Fg_Indic = 'Y' then '适应' else '非适应' end) as is_syzresult, ");//是否适应结果
	    stringBuilder.append(" (case when S.Sd_Frequnitct = '0' and S.Code = 'ST' then 'true' else 'false' end) as is_jj, ");//是否加急
	    stringBuilder.append(" (case when A.Fg_Urgent = 'Y' then '加急' when A.Fg_Urgent = 'N' then '非加急' else '' end) as is_jjresult, ");//是否加急结果
	    stringBuilder.append(" '' as is_yg, ");//是否药观
	    stringBuilder.append(" '' as is_ygresult, ");//是否药观结果
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as temporaryflagname, ");//医嘱时间类型名称
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as temporaryflagcode, ");//医嘱时间类型编码
	    stringBuilder.append(" '1' as Orderseqnum, ");//医嘱序号
	    stringBuilder.append(" a1.sd_su_bl as payflag ");//收费状态标识
	    stringBuilder.append(" from ci_or_srv A1 ");
	    stringBuilder.append(" inner join ci_order A ON A.Id_Or = A1.Id_Or ");
		stringBuilder.append(" left outer join ci_pres P ON P.Id_Pres = A1.Id_Pres ");
		stringBuilder.append(" left outer join bd_udidoc Q ON Q.Id_Udidoc = P.Id_Prestp ");
		stringBuilder.append(" left outer join bd_udidoc R ON R.Id_Udidoc = A1.Id_Hpsrvtp ");
	    stringBuilder.append(" left outer join bd_freq S ON S.Id_Freq = A1.Id_Freq ");
		stringBuilder.append(" left outer join bd_route T ON T.Id_Route = A1.Id_Route ");
		stringBuilder.append(" left outer join bd_measdoc U ON U.Id_Measdoc = A1.Id_Medu ");
		stringBuilder.append(" left outer join ci_or_srv_mm V ON V.ID_ORSRV = A1.Id_Orsrv ");
		stringBuilder.append(" left outer join bd_measdoc W ON W.Id_Measdoc = V.Id_Pgku_Cur ");
		stringBuilder.append(" left outer join bd_dep X ON X.ID_DEP = A1.Id_Dep_Wh ");
		stringBuilder.append(" LEFT OUTER JOIN CI_OR_SRV_MM Y ON A1.ID_ORSRV = Y.ID_ORSRV ");
		stringBuilder.append(" LEFT OUTER JOIN en_ent Z2 ON A.id_en = Z2.id_ent ");
		stringBuilder.append(" left OUTER join bd_mm A3 ON A3.ID_MM = V.ID_MM ");
		stringBuilder.append(" left outer join bd_mm mm on V.id_mm = mm.id_mm ");
		stringBuilder.append(" left outer join bd_udidoc Z3 ON (Z3.id_udidoc = '" + OrdEventUtil.ID_SU_BL_1+ "' and Z3.id_udidoclist = '" + OrdEventUtil.SD_SU_BL + "') ");
		stringBuilder.append(" left join bd_srv bdsrv on bdsrv.id_srv = a1.id_srv ");
		stringBuilder.append(" left join bd_srv_drug drug on drug.id_srv = bdsrv.id_srv ");
		stringBuilder.append(" left join bd_udidoc doc on doc.id_udidoc = drug.id_dosage ");
		stringBuilder.append(" where %1$s ");
		return stringBuilder.toString();
	}
	/**
	 * BS302
	 * 门诊 处方/药品签署 草药信息【IEOpPharmHerbOrDTO】
	 * @return
	 */
	public String getOpDrugSignHerbInfoSql() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" route.code as medicationmethodcode, ");//用药方法编码
	    stringBuilder.append(" route.name as medicationmethod, ");//用药方法名称
	    stringBuilder.append(" drug.sd_dosage as drugformcode, ");//药物剂型编码
	    stringBuilder.append(" doc.name as drugform, ");//药物剂型名称
	    stringBuilder.append(" a.code_or as druggid, ");//药品组号
	    stringBuilder.append(" A1.Id_Or as id_iepharmor, ");//医嘱id
	    stringBuilder.append(" A1.Id_Pres as id_iepharmpres, ");//处方id
	    stringBuilder.append(" null as id_iepharmormms, ");//草药明细list
	    stringBuilder.append(" A1.id_or as yzno, ");//医嘱号
	    stringBuilder.append(" '04' as medicine_type, ");//药物标识编码
	    stringBuilder.append(" '04' as ordertypeno, ");//处方类型编码
	    stringBuilder.append(" '草药饮片' as ordertypename, ");//处方类型名称
	    stringBuilder.append(" S.Code as frqcode, ");//频次编码
	    stringBuilder.append(" S.Name as frqname, ");// 频次名称
	    stringBuilder.append(" A.Orders as amount, ");//总用量(付数)
	    stringBuilder.append(" '付' as amountunit, ");//总用量单位(付)
	    stringBuilder.append(" X.Code as execunitcode, ");//执行科室编码
	    stringBuilder.append(" X.Name as exeunitname, ");//执行科室名称
	    stringBuilder.append(" A1.NOTE_SRV as advice, ");//嘱托
	    stringBuilder.append(" (case when A1.Fg_Skintest = 'Y' then 'true' else 'flase' end) as is_ps, ");//是否皮试
	    stringBuilder.append(" (case ");
	    stringBuilder.append("   when A1.FG_SKINTEST_RST = 'Y' then ");
	    stringBuilder.append("    (select  ");
	    stringBuilder.append("     t1.name ");
	    stringBuilder.append("     from ci_skin_test t ");
	    stringBuilder.append("     left outer join bd_udidoc t1 on t.id_rst_skintest = t1.id_udidoc ");
	    stringBuilder.append("     where id_or = A1.Id_Or) ");
	    stringBuilder.append("   else ");
	    stringBuilder.append("    '' ");
	    stringBuilder.append(" end) as is_psresult, ");//是否皮试结果
	    stringBuilder.append(" (case when A1.Fg_Indic = 'Y' then 'true' else 'flase' end) as is_syz, ");//是否适应
	    stringBuilder.append(" (case when A1.Fg_Indic = 'Y' then '适应' else '非适应' end) as is_syzresult, ");//是否适应结果
	    stringBuilder.append(" (case when S.Sd_Frequnitct = '0' and S.Code = 'ST' then 'true' else 'false' end) as is_jj, ");//是否加急
	    stringBuilder.append(" (case when A.Fg_Urgent = 'Y' then '加急' when A.Fg_Urgent = 'N' then '非加急' else '' end) as is_jjresult, ");//是否加急结果
	    stringBuilder.append(" '' as is_yg, ");//是否药观
	    stringBuilder.append(" '' as is_ygresult, ");//是否药观结果
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as temporaryflagname, ");//医嘱时间类型名称
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as temporaryflagcode, ");//医嘱时间类型编码
	    stringBuilder.append(" ");//先诊疗后付费类型编码
	    stringBuilder.append(" ");//先诊疗后付费类型名称
	    stringBuilder.append(" a1.sd_su_bl as payflag ");//收费状态标识
	    stringBuilder.append(" ");//HIS执行状态
	    stringBuilder.append(" ");//业务操作时间
	    stringBuilder.append(" from ci_or_srv A1 ");
	    stringBuilder.append(" inner join ci_order A ON A.Id_Or = A1.Id_Or and A.id_srv = A1.id_srv ");
	    stringBuilder.append(" left outer join ci_pres P ON P.Id_Pres = A1.Id_Pres ");
	    stringBuilder.append(" left outer join bd_udidoc Q ON Q.Id_Udidoc = P.Id_Prestp ");
	    stringBuilder.append(" left outer join bd_freq S ON S.Id_Freq = A1.Id_Freq ");
	    stringBuilder.append(" left outer join bd_dep X ON X.ID_DEP = A1.Id_Dep_Wh ");
	    stringBuilder.append(" left outer join bd_udidoc Z3 ON (Z3.id_udidoc = '" + OrdEventUtil.ID_SU_BL_1 +"' and Z3.id_udidoclist = '" + OrdEventUtil.SD_SU_BL + "') ");
	    stringBuilder.append(" left join bd_srv bdsrv on bdsrv.id_srv = a1.id_srv ");
	    stringBuilder.append(" left join bd_srv_drug drug on drug.id_srv = bdsrv.id_srv ");
	    stringBuilder.append(" left join bd_udidoc doc on doc.id_udidoc = drug.id_dosage ");
	    stringBuilder.append(" left join bd_route route on route.id_route = p.id_route ");
	    stringBuilder.append(" where %1$s ");
		return stringBuilder.toString();
	}
	/**
	 * 草药信息暂不清楚作用
	 * @return
	 */
	public String getOpDrugSignHerbRefundInfoSql() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" route.code as medicationmethodcode, ");//用药方法编码
	    stringBuilder.append(" route.name as medicationmethod, ");//用药方法名称
	    stringBuilder.append(" drug.sd_dosage as drugformcode, ");//药物剂型编码
	    stringBuilder.append(" doc.name as drugform, ");//药物剂型名称
	    stringBuilder.append(" a.code_or as druggid, ");//药品组号
	    stringBuilder.append(" A1.Id_Or as id_iepharmor, ");//医嘱id
	    stringBuilder.append(" A1.Id_Pres as id_iepharmpres, ");//处方id
	    stringBuilder.append(" null as id_iepharmormms, ");//草药明细list
	    stringBuilder.append(" A1.id_or as yzno, ");//医嘱号
	    stringBuilder.append(" '04' as medicine_type, ");//药物标识编码
	    stringBuilder.append(" '04' as ordertypeno, ");//处方类型编码
	    stringBuilder.append(" '草药饮片' as ordertypename, ");//处方类型名称
	    stringBuilder.append(" S.Code as frqcode, ");//频次编码
	    stringBuilder.append(" S.Name as frqname, ");// 频次名称
	    stringBuilder.append(" A.Orders as amount, ");//总用量(付数)
	    stringBuilder.append(" '付' as amountunit, ");//总用量单位(付)
	    stringBuilder.append(" X.Code as execunitcode, ");//执行科室编码
	    stringBuilder.append(" X.Name as exeunitname, ");//执行科室名称
	    stringBuilder.append(" A1.NOTE_SRV as advice, ");//嘱托
	    stringBuilder.append(" (case when A1.Fg_Skintest = 'Y' then 'true' else 'flase' end) as is_ps, ");//是否皮试
	    stringBuilder.append(" (case ");
	    stringBuilder.append("   when A1.FG_SKINTEST_RST = 'Y' then ");
	    stringBuilder.append("    (select  ");
	    stringBuilder.append("     t1.name ");
	    stringBuilder.append("     from ci_skin_test t ");
	    stringBuilder.append("     left outer join bd_udidoc t1 on t.id_rst_skintest = t1.id_udidoc ");
	    stringBuilder.append("     where id_or = A1.Id_Or) ");
	    stringBuilder.append("   else ");
	    stringBuilder.append("    '' ");
	    stringBuilder.append(" end) as is_psresult, ");//是否皮试结果
	    stringBuilder.append(" (case when A1.Fg_Indic = 'Y' then 'true' else 'flase' end) as is_syz, ");//是否适应
	    stringBuilder.append(" (case when A1.Fg_Indic = 'Y' then '适应' else '非适应' end) as is_syzresult, ");//是否适应结果
	    stringBuilder.append(" (case when S.Sd_Frequnitct = '0' and S.Code = 'ST' then 'true' else 'false' end) as is_jj, ");//是否加急
	    stringBuilder.append(" (case when A.Fg_Urgent = 'Y' then '加急' when A.Fg_Urgent = 'N' then '非加急' else '' end) as is_jjresult, ");//是否加急结果
	    stringBuilder.append(" '' as is_yg, ");//是否药观
	    stringBuilder.append(" '' as is_ygresult, ");//是否药观结果
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as temporaryflagname, ");//医嘱时间类型名称
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as temporaryflagcode, ");//医嘱时间类型编码
	    stringBuilder.append(" a1.sd_su_bl as payflag ");//收费状态标识
		stringBuilder.append(" from ci_or_srv A1 ");
		stringBuilder.append(" inner join ci_order A ON A.Id_Or = A1.Id_Or and A.id_srv = A1.id_srv ");
		stringBuilder.append(" left outer join ci_pres P ON P.Id_Pres = A1.Id_Pres ");
		stringBuilder.append(" left outer join bd_udidoc Q ON Q.Id_Udidoc = P.Id_Prestp ");
		stringBuilder.append(" left outer join bd_freq S ON S.Id_Freq = A1.Id_Freq ");
		stringBuilder.append(" left outer join bd_dep X ON X.ID_DEP = A1.Id_Dep_Wh ");
		stringBuilder.append(" left outer join bd_udidoc Z3 ON (Z3.id_udidoc = '" + OrdEventUtil.ID_SU_BL_1 +"' and Z3.id_udidoclist = '" + OrdEventUtil.SD_SU_BL + "') ");
		stringBuilder.append(" left join bd_srv bdsrv on bdsrv.id_srv = a1.id_srv ");
		stringBuilder.append(" left join bd_srv_drug drug on drug.id_srv = bdsrv.id_srv ");
		stringBuilder.append(" left join bd_udidoc doc on doc.id_udidoc = drug.id_dosage ");
		stringBuilder.append(" left join bd_route route on route.id_route = p.id_route ");
		stringBuilder.append(" where %1$s ");
		return stringBuilder.toString();
	}
	/**
	 * BS302
	 * 门诊 处方/药品签署 草药成分信息【IEOpPharmOrMmDTO】
	 * @return
	 */
	public String getOpDrugSignHerbElementsInfoSql() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" A2.Id_Orsrvmm as id_iepharmormm, ");
	    stringBuilder.append(" A1.ID_OR as id_iepharmor, ");
	    stringBuilder.append(" A2.Quan_Cur as weight, ");//重量
	    stringBuilder.append(" T.Name as weightunit, ");//重量单位
	    stringBuilder.append(" A3.CODE as ypcode, ");//药品编码
	    stringBuilder.append(" A2.name_mm as ypname, ");//药品名称
	    stringBuilder.append(" (case when a2.Id_Pgku_Cur = A3.id_unit_pkgsp then '01' ELSE '00' END) as packserial, ");//包装序号
	    stringBuilder.append(" U.Code as methocode, ");//草药煎熬法编码
	    stringBuilder.append(" U.name as methoname, ");//草药煎熬法名称
	    stringBuilder.append(" U.name as piecesdecoctionmethod, ");//中药饮片煎煮法
	    stringBuilder.append(" '07' as nmwamount, ");//与付数无关标记
	    stringBuilder.append(" 'true' as isnmwamount, ");//是否与付数无关标记结果
	    stringBuilder.append(" A1.Sd_Hpsrvtp as ybtypecode, ");//医保类型编码
	    stringBuilder.append(" R.Name as ybtypename, ");//医保类型名称
	    stringBuilder.append(" '1' as orderseqnum ");//医嘱序号
	    stringBuilder.append(" from ci_or_srv A1 ");
		stringBuilder.append(" inner join ci_order A ON A.Id_Or = A1.Id_Or ");
		stringBuilder.append(" left outer join ci_or_srv_mm A2 ON A1.Id_Orsrv = A2.Id_Orsrv ");
		stringBuilder.append(" left outer join ci_pres P ON P.Id_Pres = A1.Id_Pres ");
		stringBuilder.append(" left outer join bd_measdoc T ON T.Id_Measdoc = A2.Id_Pgku_Cur ");
		stringBuilder.append(" left outer join bd_boil U ON U.Id_Boil = A1.Id_Boil ");
		stringBuilder.append(" left outer join bd_udidoc R ON R.Id_Udidoc = A1.Id_Hpsrvtp ");
		stringBuilder.append(" LEFT OUTER JOIN CI_OR_SRV_MM Y ON A1.ID_ORSRV = Y.ID_ORSRV ");
		stringBuilder.append(" left join bd_mm A3 ON A3.ID_MM = A2.ID_MM ");
		stringBuilder.append(" where %1$s and A1.Fg_Or = 'Y' ");
		return stringBuilder.toString();
	}

}
