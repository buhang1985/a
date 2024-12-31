package iih.ci.mb.bp.qry;

import iih.bd.utils.BdEnvContextUtil;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者医嘱查询SQL
 * @author yankan
 * @since 2018-03-22
 *
 */
public class GetPatOrderInfoSql implements ITransQry {
	private String id_ent;	
	public GetPatOrderInfoSql(String id_ent){
		this.id_ent=id_ent;
	}	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param=new SqlParam();
		param.addParam(id_ent);
		param.addParam(id_ent);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlBuilder=new StringBuffer();
		sqlBuilder.append(" select");
		sqlBuilder.append(" enent.id_pat as patientid,");//患者ID
		sqlBuilder.append(" enent.name_pat as patientname,");//患者姓名
		sqlBuilder.append(" enent.id_ent as patientvisitid,");//就诊ID
		sqlBuilder.append(" ord.id_or as id,");//医嘱标识
		sqlBuilder.append(" depor.code as dept_code,");//医嘱开立科室编码
		sqlBuilder.append(" depor.name as dept_name,");//医嘱开立科室
		sqlBuilder.append(" orsrv.id_orsrv as comb_no,");//分组号
		sqlBuilder.append(" orsrv.id_or as comno,");//分组号
		sqlBuilder.append(" ord.dt_effe as createdatetime,");//生效时间
		sqlBuilder.append(" ord.dt_effe as startexectuetime,");//开始时间
		sqlBuilder.append(" docord.name as createdoctorname,");//开立医生
		sqlBuilder.append(" chknur.name as CheckNurseName,");//核对护士
		sqlBuilder.append(" ord.dt_chk as CheckDateTime,");//核对时间
		sqlBuilder.append(" docstop.name as enddoctorname,");//停止医生
		sqlBuilder.append(" (case ord.fg_stop when 'Y' then ord.dt_end else null end) as enddatetime,");//停止时间
		sqlBuilder.append(" (case ord.dt_last_mp when '2099-01-01 00:00:00' then null else ord.dt_last_mp end) as StopExecuteTime,");//停止执行时间
		sqlBuilder.append(" case ord.fg_long when 'Y' then '1' else '0' end as islongterm,");//长期临时
		sqlBuilder.append(" ord.note_or as order_note,");//医嘱备注
		sqlBuilder.append(" orsrv.name ||'['||bdmm.spec||']' as content,");//医嘱内容
		
		sqlBuilder.append(" ord.sd_su_or as state,");//医嘱状态TODO
		sqlBuilder.append(" ord.sd_su_mp as ExecStatus,");
		sqlBuilder.append(" ord.des_or as Summary,");//医嘱嘱托
		sqlBuilder.append(" freq.name as frequency,");//频次名称
		sqlBuilder.append(" measdoc.name as dosageunit,");//剂量单位
		sqlBuilder.append(" orsrv.quan_medu as dosage,");//剂量
		sqlBuilder.append(" orsrv.quan_total_medu as TotalDosage,");//总量
		sqlBuilder.append(" route.NAME as Performance,");//用法
		sqlBuilder.append(" case ord.sd_su_or||ord.sd_su_mp when '201' then docor1.name else docor.name end  as statestring,");//医嘱状态
		sqlBuilder.append(" docsrvtppar.name as ordertypename,");//医嘱类型
		sqlBuilder.append(" (case substr(docsrvtppar.code,1,2) when '01' then '药品'  when '02' then '检查类' when '03' then '化验类' ");
		sqlBuilder.append(" when '04' then '手术类' when '05' then '治疗类' when '06' then '护理类' else '其它' end) as OrderClassString,");//医嘱类//OrderClassString 移动医生用
		sqlBuilder.append(" (case docord.ID_EMPWKTP when '@@@@AA1000000000SMV6' then 'n' else 'd' end) as InputType,");//医嘱录入方式 d：医生录入，n：护士录入
		sqlBuilder.append(" orsrv.ID_OR as GroupNo");//医嘱分租
		sqlBuilder.append(" from ci_order ord");
		sqlBuilder.append(" inner join ci_or_srv orsrv on ord.id_or = orsrv.id_or");
		sqlBuilder.append(" left join ci_or_srv_mm ormm on orsrv.id_orsrv=ormm.id_orsrv");
		sqlBuilder.append(" left join bd_mm bdmm on bdmm.id_mm=ormm.id_mm");
		sqlBuilder.append(" left join en_ent enent on enent.id_ent = ord.id_en");
		sqlBuilder.append(" left join BD_ROUTE route on route.ID_ROUTE=ord.ID_ROUTE");
		sqlBuilder.append(" left join bd_dep depor on depor.id_dep=ord.id_dep_or");
		sqlBuilder.append(" left join bd_psndoc docord on docord.id_psndoc = ord.id_emp_or");
		sqlBuilder.append(" left join bd_psndoc chknur on chknur.id_psndoc = ord.id_emp_chk");
		sqlBuilder.append(" left join bd_psndoc docstop on docstop.id_psndoc = ord.id_emp_stop");
		sqlBuilder.append(" left join bd_freq freq on freq.id_freq=orsrv.id_freq");
		sqlBuilder.append(" left join bd_measdoc measdoc on measdoc.id_measdoc = orsrv.id_medu");
		sqlBuilder.append(" left join bd_udidoc docor on docor.id_udidoc=ord.id_su_or");
		sqlBuilder.append(" left join bd_udidoc docor1 on docor1.id_udidoc=ord.id_su_mp");
		sqlBuilder.append(" left join bd_udidoc docsrvtp on docsrvtp.id_udidoc=ord.id_srvtp");
		sqlBuilder.append(" left join bd_udidoc docsrvtppar on substr(docsrvtp.innercode,0,4)=docsrvtppar.innercode and docsrvtppar.id_udidoclist = '@@@@ZZ2000000000000T'");//服务类型显示顶层
		sqlBuilder.append(" where 1=1");
		sqlBuilder.append(" and  substr ( docsrvtppar.code, 1, 2 )='01'");//药品选全部
		sqlBuilder.append(" and "+BdEnvContextUtil.processEnvContext(new OrdSrvDO(), "orsrv"));// 增加多组织
		sqlBuilder.append(" and ord.id_en = ? ");
		
		sqlBuilder.append(" union select");
		sqlBuilder.append(" enent.id_pat as patientid,");//患者ID
		sqlBuilder.append(" enent.name_pat as patientname,");//患者姓名
		sqlBuilder.append(" enent.id_ent as patientvisitid,");//就诊ID
		sqlBuilder.append(" ord.id_or as id,");//医嘱标识
		sqlBuilder.append(" depor.code as dept_code,");//医嘱开立科室编码
		sqlBuilder.append(" depor.name as dept_name,");//医嘱开立科室
		sqlBuilder.append(" orsrv.id_orsrv as comb_no,");//分组号
		sqlBuilder.append(" orsrv.id_or as comno,");//分组号
		sqlBuilder.append(" ord.dt_effe as createdatetime,");//生效时间
		sqlBuilder.append(" ord.dt_effe as startexectuetime,");//开始时间
		sqlBuilder.append(" docord.name as createdoctorname,");//开立医生
		sqlBuilder.append(" chknur.name as CheckNurseName,");//核对护士
		sqlBuilder.append(" ord.dt_chk as CheckDateTime,");//核对时间
		sqlBuilder.append(" docstop.name as enddoctorname,");//停止医生
		sqlBuilder.append(" (case ord.fg_stop when 'Y' then ord.dt_end else null end) as enddatetime,");//停止时间
		sqlBuilder.append(" (case ord.dt_last_mp when '2099-01-01 00:00:00' then null else ord.dt_last_mp end) as StopExecuteTime,");//停止执行时间
		sqlBuilder.append(" case ord.fg_long when 'Y' then '1' else '0' end as islongterm,");//长期临时
		sqlBuilder.append(" ord.note_or as order_note,");//医嘱备注
		sqlBuilder.append(" ord.name_or||bdmm.spec as content,");//医嘱内容
		sqlBuilder.append(" ord.sd_su_or as state,");//医嘱状态TODO
		sqlBuilder.append(" ord.sd_su_mp as ExecStatus,");
		sqlBuilder.append(" ord.des_or as Summary,");//医嘱嘱托
		sqlBuilder.append(" freq.name as frequency,");//频次名称
		sqlBuilder.append(" measdoc.name as dosageunit,");//剂量单位
		sqlBuilder.append(" orsrv.quan_medu as dosage,");//剂量
		sqlBuilder.append(" orsrv.quan_total_medu as TotalDosage,");//总量
		sqlBuilder.append(" route.NAME as Performance,");//用法
		sqlBuilder.append(" case ord.sd_su_or||ord.sd_su_mp when '201' then docor1.name else docor.name end  as statestring,");//医嘱状态
		sqlBuilder.append(" docsrvtppar.name as ordertypename,");//医嘱类型
		sqlBuilder.append(" (case substr(docsrvtppar.code,1,2) when '01' then '药品'  when '02' then '检查类' when '03' then '化验类' ");
		sqlBuilder.append(" when '04' then '手术类' when '05' then '治疗类' when '06' then '护理类' else '其它' end) as OrderClassString,");//医嘱类//OrderClassString 移动医生用
		sqlBuilder.append(" (case docord.ID_EMPWKTP when '@@@@AA1000000000SMV6' then 'n' else 'd' end) as InputType,");//医嘱录入方式 d：医生录入，n：护士录入
		sqlBuilder.append(" orsrv.ID_OR as GroupNo");//医嘱分租
		sqlBuilder.append(" from ci_order ord");
		sqlBuilder.append(" inner join ci_or_srv orsrv on ord.id_or = orsrv.id_or");
		sqlBuilder.append(" left join ci_or_srv_mm ormm on orsrv.id_orsrv=ormm.id_orsrv");
		sqlBuilder.append(" left join bd_mm bdmm on bdmm.id_mm=ormm.id_mm");
		sqlBuilder.append(" left join en_ent enent on enent.id_ent = ord.id_en");
		sqlBuilder.append(" left join BD_ROUTE route on route.ID_ROUTE=ord.ID_ROUTE");
		sqlBuilder.append(" left join bd_dep depor on depor.id_dep=ord.id_dep_or");
		sqlBuilder.append(" left join bd_psndoc docord on docord.id_psndoc = ord.id_emp_or");
		sqlBuilder.append(" left join bd_psndoc chknur on chknur.id_psndoc = ord.id_emp_chk");
		sqlBuilder.append(" left join bd_psndoc docstop on docstop.id_psndoc = ord.id_emp_stop");
		sqlBuilder.append(" left join bd_freq freq on freq.id_freq=orsrv.id_freq");
		sqlBuilder.append(" left join bd_measdoc measdoc on measdoc.id_measdoc = orsrv.id_medu");
		sqlBuilder.append(" left join bd_udidoc docor on docor.id_udidoc=ord.id_su_or");
		sqlBuilder.append(" left join bd_udidoc docor1 on docor1.id_udidoc=ord.id_su_mp");
		sqlBuilder.append(" left join bd_udidoc docsrvtp on docsrvtp.id_udidoc=ord.id_srvtp");
		sqlBuilder.append(" left join bd_udidoc docsrvtppar on substr(docsrvtp.innercode,0,4)=docsrvtppar.innercode and docsrvtppar.id_udidoclist = '@@@@ZZ2000000000000T'");//服务类型显示顶层
		sqlBuilder.append(" where 1=1");
		sqlBuilder.append(" and (substr ( docsrvtppar.code, 1, 2 )<>'01') and orsrv.SORTNO='1'");//非药品
		sqlBuilder.append(" and "+BdEnvContextUtil.processEnvContext(new OrdSrvDO(), "orsrv"));// 增加多组织
		sqlBuilder.append(" and ord.id_en = ? ");
		
		sqlBuilder.append(" order by createdatetime desc ");
		return sqlBuilder.toString();
	}
}
