package iih.ei.std.s.v1.bp.mp.pacedata.qry;

import iih.bd.bc.udi.pub.IBdSrvTpDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 
* @ClassName: GetObsApInfoSql
* @Description: 查询检查申请单信息
* @author zhy
* @date 2020年7月8日
* @version 2020年7月8日11:32:12 by zhy  申请单des_sympsign临床症状为大字段,系统框架查询报错,所以改为单独查询后赋值
*
 */
public class GetObsApInfoSql implements ITransQry{

	private String patID;//患者id
	private String applyno;//申请单号
	private String code_dep_mp;//执行科室
	private String dt_begin;//开始时间
	private String dt_end;//结束时间
	
	public GetObsApInfoSql(String patID, String applyno, String code_dep_mp,String dt_begin,String dt_end) {
		super();
		this.patID = patID;
		this.applyno = applyno;
		this.code_dep_mp = code_dep_mp;
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		//住院
		param.addParam(patID);// 患者ID
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN);//地址类型 籍贯
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_COMMUNICATE);//地址类型 通讯地址
		param.addParam(IBdSrvTpDictCodeConst.SD_SRVTP_RIS+"%");//服务类型为检查
		param.addParam(patID);// 患者ID
		if(!StringUtil.isEmptyWithTrim(applyno)){
			param.addParam(applyno);
		}
		if(!StringUtil.isEmptyWithTrim(code_dep_mp)){
			param.addParam(code_dep_mp);//执行科室
		}
		
		if(!StringUtil.isEmptyWithTrim(dt_begin)){
			param.addParam(dt_begin);//开始时间
		}
		
		if(!StringUtil.isEmptyWithTrim(dt_end)){
			param.addParam(dt_end);//结束时间
		}
		
		//门诊
		param.addParam(patID);// 患者ID
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN);//地址类型 籍贯
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_COMMUNICATE);//地址类型 通讯地址
		param.addParam(IBdSrvTpDictCodeConst.SD_SRVTP_RIS+"%");//服务类型为检查
		param.addParam(patID);// 患者ID
		if(!StringUtil.isEmptyWithTrim(applyno)){
			param.addParam(applyno);
		}
		if(!StringUtil.isEmptyWithTrim(code_dep_mp)){
			param.addParam(code_dep_mp);//执行科室
		}
		
		if(!StringUtil.isEmptyWithTrim(dt_begin)){
			param.addParam(dt_begin);//开始时间
		}
		
		if(!StringUtil.isEmptyWithTrim(dt_end)){
			param.addParam(dt_end);//结束时间
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuffer sql = new StringBuffer();
		//住院
		sql.append(" select code_or Code_or,              " );//医嘱编码
		sql.append("        pipat.code Code_pat,          " );//患者编码
		sql.append("        pipat.name Name_pat,          " );//患者姓名
		sql.append("        pipat.pycode Pycode_pat,      " );//患者姓名拼音码
		sql.append("        sexudi.code Sd_sex,           " );//患者性别档案编码
		sql.append("        sexudi.name name_sex,         " );//患者性别
		sql.append("        pipat.dt_birth Dt_birth,      " );//出生日期
		sql.append("        marryudi.code Sd_marry,       " );//婚姻档案编码
		sql.append("        birthaddr.street birth_place, " );//出生地
		sql.append("        address.street address,       " );//现住址
		sql.append("        pipat.mob relation_tel,       " );//联系电话
		sql.append("        pipat.tel patient_home_tel,   " );//家庭电话
		sql.append("        pipat.id_code id_card_no,     " );//证件号码
		sql.append("        cior.id_or,                   " );//医嘱ID
		sql.append("        cior.fg_set,                  " );//服务套标识
		sql.append("        dep.name Name_dep_nur,          " );//病区
		sql.append("        enent.code_entp,                " );//患者就诊类型
		sql.append("        entp.name  name_entp,           " );//患者就诊类型
		sql.append("        phydep.name Name_dep_or,      " );//开立科室
		sql.append("        phydep.code Code_dep_or,      " );//开立科室编码
		sql.append("        psn.name Name_emp_or,         " );//开立医生
		sql.append("        psn.code Code_emp_or,         " );//开立医生编码
		sql.append("        depmp.name Name_dep_mp,       " );//执行科室		
		sql.append("        depmp.Code Code_dep_mp,       " );//执行科室		
//		sql.append("        TO_CHAR(apobs.clinicalzztz) as des_sympsign,           " );//症状
		sql.append("        apobs.str_name_di,            " );//诊断
		sql.append("        cior.sd_srvtp,                " );//检查类型编码
		sql.append("        (select LISTAGG(code_srv)  WITHIN GROUP( ORDER BY orsrv.id_or)||'' from ci_or_srv orsrv where orsrv.id_or=cior.id_or ) as Code_srv_exam,      " );//服务编码
		sql.append("        apobs.no_applyform,            " );//申请单号
		sql.append("        enentip.code_amr_ip,           " );//住院号
		sql.append("        enentip.name_bed,              " );//床号
		sql.append("        nvl(pipat.last_times_ip,0)   as times_ent ,   " );//就诊次数 先查住院次数
		sql.append("        enent.code code_ent,           " );//就诊流水
		sql.append("        cior.sd_su_bl,                  ");//申请单费用状态
		sql.append(" ( ");
		sql.append("    select sum(case fg_bl when 'Y' then 1 else 0 end) ");
		sql.append("    from ci_or_srv orsrv where orsrv.id_or=cior.id_or");
		sql.append("    group by orsrv.id_or ");
		sql.append(" ) as num_bl,");// 医嘱需要计费的项目数量
		sql.append("        case cior.fg_set               " );
		sql.append("          when 'Y' then                " );
		sql.append("           concat(cior.name_or,         " );
		sql.append("                  (select '(' || LISTAGG(bodyudi.name, ',') WITHIN GROUP(ORDER BY ciorsrvset.id_or) || ')' " );
		sql.append("                     from ci_or_srv_set ciorsrvset                " );
		sql.append("                     left outer join bd_udidoc bodyudi            " );
		sql.append("                       on bodyudi.id_udidoc = ciorsrvset.id_body    " );
		sql.append("                    where ciorsrvset.id_or = cior.id_or))          " );
		sql.append("          when 'N' then                                           " );
		sql.append("           concat(cior.name_or,                                       " );
		sql.append("                  (select '(' || LISTAGG(bodyudi.name, ',') WITHIN GROUP(ORDER BY ciapobs.id_or) || ')' " );
		sql.append("                     from ci_ap_obs ciapobs                      " );
		sql.append("                     left outer join bd_udidoc bodyudi           " );
		sql.append("                       on bodyudi.id_udidoc = ciapobs.id_body    " );
		sql.append("                    where ciapobs.id_or = cior.id_or))           " );
		sql.append("        end Name_srv_exam,                                       " ); //检查项目名称
		sql.append("        cior.dt_effe                                             " );//医嘱开立时间
		sql.append("   from mp_or_pr orpr                                            " );
		sql.append("  inner join ci_order cior   on cior.id_or = orpr.id_or" );
		sql.append("   left outer join bd_orpltpsta sta on sta.id_orpltpsta = orpr.id_orpltpsta" );
		sql.append("  inner join en_ent enent  on enent.id_ent = cior.id_en" );
		sql.append("   left outer join bd_dep dep  on dep.id_dep = enent.id_dep_nur" );
		sql.append("   left outer join bd_dep phydep on phydep.id_dep = enent.id_dep_phy" );
		sql.append("   left outer join bd_dep depmp on depmp.id_dep = cior.id_dep_mp" );
		sql.append("   left outer join pi_pat pipat on pipat.id_pat = cior.id_pat and cior.id_pat = ?" );
		sql.append("   left outer join bd_udidoc sexudi on sexudi.id_udidoc = pipat.id_sex" );
		sql.append("   left outer join bd_udidoc marryudi  on marryudi.id_udidoc = pipat.id_marry" );
		sql.append("   left outer join pi_pat_addr birthaddr  on birthaddr.id_pat = pipat.id_pat  and birthaddr.sd_addrtp = ? " );
		sql.append("   left outer join pi_pat_addr address on address.id_pat = pipat.id_pat  and address.sd_addrtp = ? " );
		sql.append("   inner join ci_ap_obs apobs  on apobs.id_or = cior.id_or" );
		sql.append("   left outer join bd_srv bdsrv on bdsrv.id_srv = cior.id_srv" );
		sql.append("   left outer join bd_psndoc psn on psn.id_psndoc = cior.id_emp_or" );
		sql.append("   left outer join en_ent_ip enentip on enentip.id_ent = enent.id_ent" );
		sql.append("   left outer join bd_entp entp on entp.id_entp = enent.id_entp" );
		sql.append("  where cior.sd_srvtp like ?  and orpr.id_pat = ?" );
		sql.append("    and cior.fg_chk = 'Y'" );
		sql.append("    and cior.fg_canc = 'N'" );
		sql.append("    and cior.code_entp = '10' ");
		sql.append("    and nvl(sta.sortno, 0) < 2" );
		sql.append("    and enent.fg_ip = 'Y'" );
		if(!StringUtil.isEmptyWithTrim(applyno)){
			sql.append("  and apobs.no_applyform = ?" );
		}
		if(!StringUtil.isEmptyWithTrim(code_dep_mp)){
			sql.append("  and depmp.code = ?" );
		}
		if(!StringUtil.isEmptyWithTrim(dt_begin)){
			sql.append("  and cior.dt_effe >= ?" );
		}
		if(!StringUtil.isEmptyWithTrim(dt_end)){
			sql.append("  and cior.dt_effe <= ?" );
		}
		
		sql.append(" and " + EnvContextUtil.processEnvContext("", new CiOrderDO(), "cior") ); //管控
        
		sql.append(" union ");
		
		//门诊
		sql.append(" select code_or Code_or,              " );//医嘱编码
		sql.append("        pipat.code Code_pat,          " );//患者编码
		sql.append("        pipat.name Name_pat,          " );//患者姓名
		sql.append("        pipat.pycode Pycode_pat,      " );//患者姓名拼音码
		sql.append("        sexudi.code Sd_sex,           " );//患者性别档案编码
		sql.append("        sexudi.name name_sex,         " );//患者性别
		sql.append("        pipat.dt_birth Dt_birth,      " );//出生日期
		sql.append("        marryudi.code Sd_marry,       " );//婚姻档案编码
		sql.append("        birthaddr.street birth_place, " );//出生地
		sql.append("        address.street address,       " );//现住址
		sql.append("        pipat.mob relation_tel,       " );//联系电话
		sql.append("        pipat.tel patient_home_tel,   " );//家庭电话
		sql.append("        pipat.id_code id_card_no,     " );//证件号码
		sql.append("        cior.id_or,                   " );//医嘱ID
		sql.append("        cior.fg_set,                  " );//服务套标识
		sql.append("        dep.name Name_dep_nur,          " );//病区
		sql.append("        enent.code_entp,                " );//患者就诊类型
		sql.append("        entp.name  name_entp,           " );//患者就诊类型
		sql.append("        phydep.name Name_dep_or,      " );//开立科室
		sql.append("        phydep.code Code_dep_or,      " );//开立科室编码
		sql.append("        psn.name Name_emp_or,         " );//开立医生
		sql.append("        psn.code Code_emp_or,         " );//开立医生编码
		sql.append("        depmp.name Name_dep_mp,       " );//执行科室		
		sql.append("        depmp.Code Code_dep_mp,       " );//执行科室	
//		sql.append("        TO_CHAR(apobs.clinicalzztz) as des_sympsign,           " );//症状
		sql.append("        apobs.str_name_di,            " );//诊断
		sql.append("        cior.sd_srvtp,                " );//检查类型编码
		sql.append("        (select LISTAGG(code_srv)  WITHIN GROUP( ORDER BY orsrv.id_or)||'' from ci_or_srv orsrv where orsrv.id_or=cior.id_or ) as Code_srv_exam,      " );//服务编码
		sql.append("        apobs.no_applyform,            " );//申请单号
		sql.append("        enentip.code_amr_ip,           " );//住院号
		sql.append("        null as name_bed,              " );//床号
		sql.append("        nvl(pipat.last_times_ip,0)   as times_ent ,   " );//就诊次数 先查住院次数
		sql.append("        enent.code code_ent,           " );//就诊流水
		sql.append("        cior.sd_su_bl,                  ");//申请单费用状态
		sql.append(" ( ");
		sql.append("    select sum(case fg_bl when 'Y' then 1 else 0 end) ");
		sql.append("    from ci_or_srv orsrv where orsrv.id_or=cior.id_or");
		sql.append("    group by orsrv.id_or ");
		sql.append(" ) as num_bl,");// 医嘱需要计费的项目数量
		sql.append("        case cior.fg_set               " );
		sql.append("          when 'Y' then                " );
		sql.append("           concat(cior.name_or,         " );
		sql.append("                  (select '(' || LISTAGG(bodyudi.name, ',') WITHIN GROUP(ORDER BY ciorsrvset.id_or) || ')' " );
		sql.append("                     from ci_or_srv_set ciorsrvset                " );
		sql.append("                     left outer join bd_udidoc bodyudi            " );
		sql.append("                       on bodyudi.id_udidoc = ciorsrvset.id_body    " );
		sql.append("                    where ciorsrvset.id_or = cior.id_or))          " );
		sql.append("          when 'N' then                                           " );
		sql.append("           concat(cior.name_or,                                       " );
		sql.append("                  (select '(' || LISTAGG(bodyudi.name, ',') WITHIN GROUP(ORDER BY ciapobs.id_or) || ')' " );
		sql.append("                     from ci_ap_obs ciapobs                      " );
		sql.append("                     left outer join bd_udidoc bodyudi           " );
		sql.append("                       on bodyudi.id_udidoc = ciapobs.id_body    " );
		sql.append("                    where ciapobs.id_or = cior.id_or))           " );
		sql.append("        end Name_srv_exam,                                       " ); //检查项目名称
		sql.append("        cior.dt_effe                                             " );//医嘱开立时间
		sql.append("   from mp_or_pr orpr                                            " );
		sql.append("  inner join ci_order cior   on cior.id_or = orpr.id_or" );
		sql.append("   left outer join bd_orpltpsta sta on sta.id_orpltpsta = orpr.id_orpltpsta" );
		sql.append("  inner join en_ent enent  on enent.id_ent = cior.id_en" );
		sql.append("   left outer join bd_dep dep  on dep.id_dep = enent.id_dep_nur" );
		sql.append("   left outer join bd_dep phydep on phydep.id_dep = enent.id_dep_phy" );
		sql.append("   left outer join bd_dep depmp on depmp.id_dep = cior.id_dep_mp" );
		sql.append("   left outer join pi_pat pipat on pipat.id_pat = cior.id_pat and cior.id_pat = ?" );
		sql.append("   left outer join bd_udidoc sexudi on sexudi.id_udidoc = pipat.id_sex" );
		sql.append("   left outer join bd_udidoc marryudi  on marryudi.id_udidoc = pipat.id_marry" );
		sql.append("   left outer join pi_pat_addr birthaddr  on birthaddr.id_pat = pipat.id_pat  and birthaddr.sd_addrtp = ? " );
		sql.append("   left outer join pi_pat_addr address on address.id_pat = pipat.id_pat  and address.sd_addrtp = ? " );
		sql.append("   inner join ci_ap_obs apobs  on apobs.id_or = cior.id_or" );
		sql.append("   left outer join bd_srv bdsrv on bdsrv.id_srv = cior.id_srv" );
		sql.append("   left outer join bd_psndoc psn on psn.id_psndoc = cior.id_emp_or" );
		sql.append("   left outer join en_ent_ip enentip on enentip.id_ent = enent.id_ent" );
		sql.append("   left outer join bd_entp entp on entp.id_entp = enent.id_entp" );
		sql.append("  where cior.sd_srvtp like ?  and orpr.id_pat = ?" );
		sql.append("    and cior.fg_canc = 'N'" );
		sql.append("    and cior.code_entp = '00' ");
		sql.append("    and nvl(sta.sortno, 0) < 2" );
		if(!StringUtil.isEmptyWithTrim(applyno)){
			sql.append("  and apobs.no_applyform = ?" );
		}
		if(!StringUtil.isEmptyWithTrim(code_dep_mp)){
			sql.append("  and depmp.code = ?" );
		}
		if(!StringUtil.isEmptyWithTrim(dt_begin)){
			sql.append("  and cior.dt_effe >= ?" );
		}
		if(!StringUtil.isEmptyWithTrim(dt_end)){
			sql.append("  and cior.dt_effe <= ?" );
		}
		sql.append(" and " + EnvContextUtil.processEnvContext("", new CiOrderDO(), "cior") ); //管控
        
		
		return sql.toString();
	}

}
