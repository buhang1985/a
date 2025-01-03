package iih.ci.event.ord.bps.sign.ip.sql;
/**
 * 住院 签署 用药 sql查询 BS311
 * @author F
 *
 * @date 2019年8月29日下午3:09:02
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.sql.IpDrugSignSql
 */
public class IpDrugSignSql {
	
//	0171119
//	修改方案同下：
//	1)	BS005消息
//	①　	BS005消息增加【医嘱组号】元素
//	②　	医嘱组号：传值为医嘱号，Ci_order.code_or。
//	③　	医嘱号：传值为医嘱号，Ci_order.code_or。
//	2)	BS311消息
//	①　	BS311消息西药类、草药类节点下分别增加【医嘱组号】元素
//	②　	西成药赋值
//	a)	医嘱号：传医嘱下服务号，赋值规则如下
//	非成组医嘱时为医嘱编码：ci_order.code_or
//	成组医嘱时为医嘱编码+服务序号：ci_order.code_or+sortno
//	b)	医嘱组号：传值为医嘱号，Ci_order.code_or。
//	③　	草药赋值
//	a)	医嘱号：传ci_order.code_or（现状保持不变）
//	b)	医嘱组号：赋空值（本不应该添加该字段）
//	④　	BS311消息西药类、草药类节点下分别增加【用药目的编码】【用药目的名称】元素，其中草药类下用药目的两个元素不需要赋值。
//	⑤　	用药目的编码：ci_or_srv. sd_antipurpose
//	⑥　	用药目的名称：ci_or_srv. sd_antipurpose对应档案名称
//	3)	BS307消息
//	①　	该消息门诊和住院都有，当前医嘱号取值规则，门诊同BS302消息，住院同BS311消息。
//	②　	本次BS311调整后，BS307住院西成药的医嘱号取值要做相同处理，传医嘱下服务号，赋值规则如下：
//	非成组医嘱时为医嘱编码：ci_order.code_or
//	成组医嘱时为医嘱编码+服务序号：ci_order.code_or+sortno
	/**
	 * BS311 
	 * 住院用药签署 就诊信息【IEPharmOrEnDTO】
	 * @param id_or4sql
	 * @return
	 */
	public String getIpTreatSignEntInfoSql(String id_or4sql) {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" A.id_en as id_iepharmoren, ");//就诊id
	    stringBuilder.append(" B.code as patientid, ");//患者ID
	    stringBuilder.append(" b.code_amr_ip as patientseqnum, ");//就诊号
	    stringBuilder.append(" F.Times_Ip as admiss_times, ");//就诊次数
	    stringBuilder.append(" D.CODE as deptcode, ");//病人当前科室编码
	    stringBuilder.append(" D.Name as deptname, ");//病人当前科室名称
	    stringBuilder.append(" E.code as wardcode, ");//病人当前病区编码
	    stringBuilder.append(" E.name as wardname, ");//病人当前病区名称
	    stringBuilder.append(" F.NAME_BED as bedcode, ");//床位号
	    stringBuilder.append(" C.Name_Pat as name, ");//患者姓名
	    stringBuilder.append(" C.Sd_Sex_Pat as sexid, ");//性别编码
	    stringBuilder.append(" B.DT_BIRTH_HMS as birthdaydate, ");//出生日期
	    stringBuilder.append(" B.DT_BIRTH_HMS as birthdaydate_hms,");//出生日期
	    stringBuilder.append(" null as age, ");//年龄
	    stringBuilder.append(" A.Dt_Chk as confirm_date, ");//医嘱确认时间(护士)
	    stringBuilder.append(" G.Code as confirm_nurse_code, ");//医嘱确认护士编码
	    stringBuilder.append(" G.name as confirm_nurse_name, ");//医嘱确认护士姓名
	    stringBuilder.append(" H.orgcode as orgcode, ");//医疗机构编码
	    stringBuilder.append(" H.name as orgname, ");//医疗机构名称
	    stringBuilder.append(" C.code as visite_seq_no, ");//就诊流水号
	    stringBuilder.append(" a.code_entp as visite_type_code, ");//就诊类别编码
	    stringBuilder.append(" BD.name as visite_type_name, ");//就诊类别名称
	    stringBuilder.append(" '01' as domain_id, ");//域id
	    stringBuilder.append(" i.code as Apply_dept_code,");//申请科室/签署科室(申请科室取签署科室)
	    stringBuilder.append(" i.name as Apply_dept_name ");//申请科室/签署科室(申请科室取签署科室)
		stringBuilder.append(" from ci_order A ");
		stringBuilder.append(" left outer join pi_pat B ON A.Id_Pat = B.Id_Pat ");
		stringBuilder.append(" left outer join en_ent C ON A.Id_En = C.Id_Ent ");
		stringBuilder.append(" left outer join bd_dep D ON C.Id_Dep_Phy = D.ID_DEP ");
		stringBuilder.append(" left outer join bd_dep E ON C.Id_Dep_Nur = E.Id_Dep ");
		stringBuilder.append(" left outer join en_ent_ip F ON C.Id_Ent = F.Id_Ent ");
		stringBuilder.append(" left outer join bd_psndoc G ON A.Id_Emp_Chk = G.Id_Psndoc ");
		stringBuilder.append(" left outer join bd_org H ON H.Id_ORG = A.Id_ORG ");
		stringBuilder.append(" left outer join BD_ENTP BD ON a.CODE_ENTP = BD.CODE ");
		stringBuilder.append(" left outer join bd_dep i on i.id_dep=a.id_dep_sign ");
		stringBuilder.append(" where A.id_or ");
		stringBuilder.append(id_or4sql);
		return stringBuilder.toString();
	}
	/**
	 * BS311
	 *  住院用药签署 西药信息【IEPharmWcOrDTO】
	 * @param id_or4sql
	 * @return
	 */
	public String getIpDrugSignWcInfoSql(String id_or4sql) {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" A.code_or as order_group_id, ");//医嘱组号
	    stringBuilder.append(" A.Id_Or as id_iepharmwcor, ");//医嘱id
	    stringBuilder.append(" A.Id_En as id_iepharmoren, ");//就诊id
	    stringBuilder.append(" (case when gr.group_count>=2 then (a.code_or || a1.sortno ) else a.code_or end) as xy_zcy_order_code, ");//医嘱号
	    stringBuilder.append(" (case when substr(A.sd_srvtp, 0, 6) = '010101' then 'c' else 'f' end) as xy_zcy_order_type_code, ");//医嘱类别编码
	    stringBuilder.append(" A3.name as xy_zcy_order_type_name, ");//医嘱类别名称
	    stringBuilder.append(" A.Des_Or as xy_zcy_yz_memo, ");//医嘱备注
	    stringBuilder.append(" A4.Code as xy_zcy_fre_code, ");//医嘱执行频率编码
	    stringBuilder.append(" A4.name as xy_zcy_fre_name, ");//医嘱执行频率名称
	    stringBuilder.append(" A5.Code as xy_zcy_yytj_code, ");//用药途径编码
	    stringBuilder.append(" A5.Name as xy_zcy_yytj_name, ");//用药途径名称
	    stringBuilder.append(" A1.Quan_Medu as xy_zcy_cjl, ");//次剂量
	    stringBuilder.append(" A6.Name as xy_zcy_cjlunit, ");//次剂量单位
	    stringBuilder.append(" A2.Quan_Cur as xy_zcy_zyl, ");//总用量
	    stringBuilder.append(" A7.Name as xy_zcy_zylunit, ");//总用量单位       
	    stringBuilder.append(" A9.Code as xy_zcy_yz_old_dept_code, ");//医嘱原科室编码
	    stringBuilder.append(" A9.Name as xy_zcy_yz_old_dept_name, ");//医嘱原科室名称
	    stringBuilder.append(" A10.Code as xy_zcy_yz_old_ward_code, ");//医嘱原病区编码
	    stringBuilder.append(" A10.name as xy_zcy_yz_old_ward_name, ");//医嘱原病区名称
	    stringBuilder.append(" mm.Code as xy_zcy_yw_code, ");//药物编码
	    stringBuilder.append(" mm.name as xy_zcy_yw_name, ");//药物名称
	    stringBuilder.append(" (case when mm.id_unit_pkgbase = A2.id_pgku_cur then '00' ELSE '01' END) as xy_zcy_bz_no, ");//包装序号
	    stringBuilder.append(" A1.Sd_Hpsrvtp as xy_zcy_yw_yb_code, ");//药物医保类别编码
	    stringBuilder.append(" A12.name as xy_zcy_yw_yb_name, ");//药物医保类别名称
	    stringBuilder.append(" A.Dt_Entry as xy_zcy_yz_date, ");//开嘱时间
	    stringBuilder.append(" A13.code as xy_zcy_yz_doctor_no, ");//开嘱医生编码
	    stringBuilder.append(" A13.Name as xy_zcy_yz_doctor_name, ");//开嘱医生姓名
	    stringBuilder.append(" A.Dt_Sign as xy_zcy_yz_confirm_date, ");//医嘱医生确认时间
	    stringBuilder.append(" A14.Code as xy_zcy_yz_confirm_code, ");//医嘱确认医生编码
	    stringBuilder.append(" A14.Name as xy_zcy_yz_confirm_name, ");//医嘱确认医生名称
	    stringBuilder.append(" A15.Code as xy_zcy_exe_dept_code, ");//执行科室编码
	    stringBuilder.append(" A15.Name as xy_zcy_exe_dept_name, ");//执行科室名称
	    stringBuilder.append(" A.Id_Or as xy_zcy_f_order_no, ");//父医嘱号
	    stringBuilder.append(" (select p.sd_reacttp ");
	    stringBuilder.append("  from bd_srv_react p ");
	    stringBuilder.append("  inner join bd_srv_react_itm q on p.id_srvreact = q.id_srvreact ");
	    stringBuilder.append("  where q.id_srv = A1.Id_Srv) as xy_zcy_hc_order_type_code, ");//互斥类型编码
	    stringBuilder.append(" '' as xy_zcy_hc_order_type_name, ");//互斥类型名称
	    stringBuilder.append(" '' as xy_zcy_fybj_code, ");//费用标记编码
	    stringBuilder.append(" A8.code as xy_zcy_visit_ord_no, ");//就诊流水号
	    stringBuilder.append(" '' as xy_zcy_fybj_name, ");//费用标记名称
	    stringBuilder.append(" A1.NOTE_SRV as xy_zcy_jt, ");//嘱托
	    stringBuilder.append(" (case when A1.Fg_Indic = 'N' then 'false' else 'true' end) as xy_zcy_is_sy, ");//是否适应症
	    stringBuilder.append(" (case when A1.Fg_Indic = 'Y' then '适应' else '非适应' end) as xy_zcy_is_syresult, ");//是否适应症结果
	    stringBuilder.append(" (case when A1.Fg_Skintest = 'N' then 'false' else 'true' end) as xy_zcy_is_ps, ");//是否皮试
	    stringBuilder.append(" (case ");
	    stringBuilder.append("   when A1.FG_SKINTEST_RST = 'Y' then ");
	    stringBuilder.append("    (select t1.name ");
	    stringBuilder.append("     from ci_skin_test t ");
	    stringBuilder.append("     left outer join bd_udidoc t1 on t.id_rst_skintest = t1.id_udidoc ");
	    stringBuilder.append("     where id_or = A1.Id_Or) ");
	    stringBuilder.append("   else ");
	    stringBuilder.append("    '' ");
	    stringBuilder.append(" end) as xy_zcy_is_psresult, ");//是否皮试结果
	    stringBuilder.append(" (case when A4.Sd_Frequnitct = '0' and A4.Code = 'ST' then 'true' else 'false' end) as xy_zcy_is_jj, ");//是否加急
	    stringBuilder.append(" '' as xy_zcy_is_jjresult, ");//是否加急结果
	    stringBuilder.append(" null as xy_zcy_is_yg, ");//是否药观
	    stringBuilder.append(" null as xy_zcy_is_ygresult, ");//是否药观结果
	    stringBuilder.append(" null as xy_zcy_lyl, ");//领药量
	    stringBuilder.append(" null as xy_zcy_lylunit, ");//领药量单位
	    stringBuilder.append(" (case when substr(A.dt_effe,1,4)>='2099' then null else A.dt_effe end)as xy_zcy_exe_date, ");//执行时间
	    stringBuilder.append(" (case when substr(A.Dt_End,1,4)>='2099' then null else A.Dt_End end)as xy_zcy_stop_date, ");//停止时间
	    stringBuilder.append(" A.Orders as cy_fs_count, ");//总用量(付数)
	    stringBuilder.append(" null as cy_fs_unit, ");//总用量单位(付)
	    stringBuilder.append(" null as route_code, ");//临床路径项目编码
	    stringBuilder.append(" null as route_no, ");//临床路径项目序号
	    stringBuilder.append(" '1' as xy_zcy_order_seq_num, ");//医嘱序号
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as xy_zcy_ord_date_type_name, ");//医嘱时间类型名称
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as xy_zcy_ord_date_type_code ");//医嘱时间类型编码
		stringBuilder.append(" from ci_order A ");
		stringBuilder.append(" inner join ci_or_srv A1 ON A.Id_Or = A1.Id_Or ");
		stringBuilder.append(" left outer join ci_or_srv_mm A2 ON A1.Id_Orsrv = A2.Id_Orsrv ");
		stringBuilder.append(" left outer join bd_mm mm on A2.id_mm = mm.id_mm ");
		stringBuilder.append(" left outer join bd_udidoc A3 ON A.Id_Srvtp = A3.Id_Udidoc ");
		stringBuilder.append(" left outer join bd_freq A4 ON A.Id_Freq = A4.Id_Freq ");
		stringBuilder.append(" left outer join bd_route A5 ON A.Id_Route = A5.id_route ");
		stringBuilder.append(" left outer join bd_measdoc A6 ON A1.Id_Medu = A6.Id_Measdoc ");
		stringBuilder.append(" left outer join bd_measdoc A7 ON A2.Id_Pgku_Cur = A7.Id_Measdoc ");
		stringBuilder.append(" left outer join en_ent A8 ON A.Id_En = A8.Id_Ent ");
		stringBuilder.append(" left outer join bd_dep A9 ON A8.Id_Dep_Phy = A9.Id_Dep ");
		stringBuilder.append(" left outer join bd_dep A10 ON A8.Id_Dep_Nur = A10.Id_Dep ");
		stringBuilder.append(" left outer join bd_mm A11 ON A2.Id_Mm = A11.Id_Mm ");
		stringBuilder.append(" left outer join bd_udidoc A12 ON A1.Id_Hpsrvtp = A12.Id_Udidoc ");
		stringBuilder.append(" left outer join bd_psndoc A13 ON A.Id_Emp_Or = A13.Id_Psndoc ");
		stringBuilder.append(" left outer join bd_psndoc A14 ON A.Id_Emp_Sign = A14.Id_Psndoc ");
		stringBuilder.append(" left outer join bd_dep A15 ON A1.Id_Dep_Mp = A15.Id_Dep ");
		stringBuilder.append(" LEFT OUTER JOIN CI_OR_SRV_MM Y ON A1.ID_ORSRV = Y.ID_ORSRV ");
		stringBuilder.append(" left outer join ( ");
		stringBuilder.append("	    select aa.id_or, ");
		stringBuilder.append("      count (bb.fg_or) as group_count ");
		stringBuilder.append("      from ci_order aa ");
		stringBuilder.append("      left outer join ci_or_srv bb on bb.id_or=aa.id_or ");
		stringBuilder.append("      where bb.fg_or='Y' and aa.id_or ");
		stringBuilder.append(id_or4sql);
		stringBuilder.append("      group by aa.id_or ");
		stringBuilder.append("    ) gr on gr.id_or=a.id_or ");
		stringBuilder.append(" where A1.Fg_Or = 'Y' ");
		stringBuilder.append(" and A.id_or ");
		stringBuilder.append(id_or4sql);
		stringBuilder.append(" order by A1.Id_Or, A1.Sortno ");
		return stringBuilder.toString();
	}
	/**
	 * BS311
	 * 住院用药签署 草药信息【IEPharmHerbOrDTO】
	 * @param id_or4sql
	 * @return
	 */
	public String getIpDrugSignHerbInfoSql(String id_or4sql) {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		//stringBuilder.append(" null as order_group_id, ");//医嘱组号
	    stringBuilder.append(" A.Id_Or as id_iepharmor, ");//医嘱id
	    stringBuilder.append(" A.Id_En as id_iepharmoren, ");//就诊id
	    stringBuilder.append(" A.code_or as xy_zcy_order_code, ");//医嘱号
	    stringBuilder.append(" 'o' as xy_zcy_order_type_code, ");//医嘱类别编码
	    stringBuilder.append(" A3.name as xy_zcy_order_type_name, ");//医嘱类别名称
	    stringBuilder.append(" A.Des_Or as xy_zcy_yz_memo, ");//医嘱备注
	    stringBuilder.append(" A4.Code as xy_zcy_fre_code, ");//医嘱执行频率编码
	    stringBuilder.append(" A4.name as xy_zcy_fre_name, ");//医嘱执行频率名称
	    stringBuilder.append(" A5.Code as xy_zcy_yytj_code, ");//用药途径编码
	    stringBuilder.append(" A5.Name as xy_zcy_yytj_name, ");//用药途径名称
	    stringBuilder.append(" A9.Code as xy_zcy_yz_old_dept_code, ");//医嘱原科室编码
	    stringBuilder.append(" A9.Name as xy_zcy_yz_old_dept_name, ");//医嘱原科室名称
	    stringBuilder.append(" A10.Code as xy_zcy_yz_old_ward_code, ");//医嘱原病区编码
	    stringBuilder.append(" A10.name as xy_zcy_yz_old_ward_name, ");//医嘱原病区名称
	    stringBuilder.append(" '04' as xy_zcy_yw_code, ");//药物编码
	    stringBuilder.append(" null as xy_zcy_yw_yb_code, ");//药物医保类别编码
	    stringBuilder.append(" null as xy_zcy_yw_yb_name, ");//药物医保类别名称
	    stringBuilder.append(" A.Dt_Entry as xy_zcy_yz_date, ");//开嘱时间
	    stringBuilder.append(" A13.code as xy_zcy_yz_doctor_no, ");//开嘱医生编码
	    stringBuilder.append(" A13.Name as xy_zcy_yz_doctor_name, ");//开嘱医生姓名
	    stringBuilder.append(" A.Dt_Sign as xy_zcy_yz_confirm_date, ");//医嘱医生确认时间
	    stringBuilder.append(" A14.Code as xy_zcy_yz_confirm_code, ");//医嘱确认医生编码
	    stringBuilder.append(" A14.Name as xy_zcy_yz_confirm_name, ");//医嘱确认医生名称
	    stringBuilder.append(" A15.Code as xy_zcy_exe_dept_code, ");//执行科室编码
	    stringBuilder.append(" A15.Name as xy_zcy_exe_dept_name, ");//执行科室名称
	    stringBuilder.append(" null as xy_zcy_f_order_no, ");//父医嘱号
	    stringBuilder.append(" null as xy_zcy_hc_order_type_code, ");//互斥类型编码
	    stringBuilder.append(" '' as xy_zcy_hc_order_type_name, ");//互斥类型名称
	    stringBuilder.append(" '' as xy_zcy_fybj_code, ");//费用标记编码
	    stringBuilder.append(" '' as xy_zcy_fybj_name, ");//费用标记名称
	    stringBuilder.append(" null as xy_zcy_jt, ");//嘱托
	    stringBuilder.append(" null as xy_zcy_is_sy, ");//是否适应症
	    stringBuilder.append(" null as xy_zcy_is_syresult, ");//是否适应症结果
	    stringBuilder.append(" 'flase' as xy_zcy_is_ps, ");//是否皮试
	    stringBuilder.append(" '' as xy_zcy_is_psresult, ");//是否皮试结果
	    stringBuilder.append(" (case when A4.Sd_Frequnitct = '0' and A4.Code = 'ST' then 'true' else 'false' end) as xy_zcy_is_jj, ");//是否加急
	    stringBuilder.append(" '' as xy_zcy_is_jjresult, ");//是否加急结果
	    stringBuilder.append(" null as xy_zcy_is_yg, ");//是否药观
	    stringBuilder.append(" null as xy_zcy_is_ygresult, ");//是否药观结果
	    stringBuilder.append(" null as xy_zcy_lyl, ");//领药量
	    stringBuilder.append(" null as xy_zcy_lylunit, ");//领药量单位
	    stringBuilder.append(" (case when substr(A.dt_effe,1,4)>='2099' then null else A.dt_effe end)as xy_zcy_exe_date, ");//执行时间
	    stringBuilder.append(" (case when substr(A.Dt_End,1,4)>='2099' then null else A.Dt_End end)as xy_zcy_stop_date, ");//停止时间
	    stringBuilder.append(" A.Orders as cy_fs_count, ");//总用量(付数)
	    stringBuilder.append(" '付' as cy_fs_unit, ");//总用量单位(付)
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '长期' when A.fg_long = 'N' then '临时' end) as xy_zcy_ord_date_type_name, ");//医嘱时间类型名称
	    stringBuilder.append(" (case when A.fg_long = 'Y' then '1' when A.fg_long = 'N' then '0' end) as xy_zcy_ord_date_type_code ");//医嘱时间类型编码
	    stringBuilder.append(" from ci_order A ");
	    stringBuilder.append(" left outer join bd_udidoc A3 ON A.Id_Srvtp = A3.Id_Udidoc ");
		stringBuilder.append(" left outer join bd_freq A4 ON A.Id_Freq = A4.Id_Freq ");
		stringBuilder.append(" left outer join bd_route A5 ON A.Id_Route = A5.id_route ");
		stringBuilder.append(" left outer join en_ent A8 ON A.Id_En = A8.Id_Ent ");
		stringBuilder.append(" left outer join bd_dep A9 ON A8.Id_Dep_Phy = A9.Id_Dep ");
		stringBuilder.append(" left outer join bd_dep A10 ON A8.Id_Dep_Nur = A10.Id_Dep ");
		stringBuilder.append(" left outer join bd_psndoc A13 ON A.Id_Emp_Or = A13.Id_Psndoc ");
		stringBuilder.append(" left outer join bd_psndoc A14 ON A.Id_Emp_Sign = A14.Id_Psndoc ");
		stringBuilder.append(" left outer join bd_dep A15 ON A.Id_Dep_Mp = A15.Id_Dep ");
		stringBuilder.append(" where A.id_or ");
		stringBuilder.append(id_or4sql);
		return stringBuilder.toString();
	}
	/**
	 * BS311
	 * 住院用药签署 草药明细信息【IEPharmOrMmDTO】
	 * @param id_or4sql
	 * @return
	 */
	public String getIpDrugSignHerbElementsInfoSql(String id_or4sql) {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" A2.ID_ORSRVMM as id_iepharmormm, ");//主键
	    stringBuilder.append(" A1.Id_Or      as id_iepharmor, ");//医嘱id
	    stringBuilder.append(" A2.QUAN_CUR   as cy_weight, ");//重量   
	    stringBuilder.append(" B1.Name as cy_weightunit, ");//重量单位
	    stringBuilder.append(" mm.Code as cy_yp_code, ");//药品编码
	    stringBuilder.append(" A2.name_mm as cy_yp_name, ");//药品名称
	    stringBuilder.append(" (case when mm.id_unit_pkgbase = A2.id_pgku_cur then '00' ELSE '01' END) as cy_bz_no, ");//包装序号
	    stringBuilder.append(" B2.Code as cy_tsyf_code, ");//特殊用法编码
	    stringBuilder.append(" B2.Name as cy_tsyf, ");//特殊用法
	    stringBuilder.append(" 'false' as cy_fswgbj, ");//与付数无关标记
	    stringBuilder.append(" '' as cy_fswgbj_result, ");//与付数无关标记结果
	    stringBuilder.append(" A1.Sd_Hpsrvtp as cy_ywyb_type_code, ");//药物医保类别编码
	    stringBuilder.append(" B3.Name as cy_ywyb_type_name, ");//药物医保类别名称
	    stringBuilder.append(" '1' as cy_ord_seq_no ");//医嘱序号
		stringBuilder.append(" from ci_or_srv A1 ");
		stringBuilder.append(" left outer join ci_or_srv_mm A2 ON A1.Id_Orsrv = A2.Id_Orsrv ");
		stringBuilder.append(" left outer join bd_mm mm on A2.id_mm = mm.id_mm ");
		stringBuilder.append(" left outer join bd_measdoc B1 ON A2.Id_Pgku_Cur = B1.Id_Measdoc ");
		stringBuilder.append(" left outer join bd_boil B2 ON A1.Id_Boil = B2.Id_Boil ");
		stringBuilder.append(" left outer join bd_udidoc B3 ON A1.Id_Hpsrvtp = B3.Id_Udidoc ");
		stringBuilder.append(" where A1.id_or ");
		stringBuilder.append(id_or4sql);
		stringBuilder.append(" and A1.Fg_Or = 'Y' ");
		stringBuilder.append(" order by A1.ID_OR, A1.Sortno ");
		return stringBuilder.toString();
	}
}
