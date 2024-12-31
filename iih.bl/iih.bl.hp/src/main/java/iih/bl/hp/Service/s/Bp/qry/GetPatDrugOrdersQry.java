package iih.bl.hp.Service.s.Bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询患者药品类医嘱
 * @author ly 2017/05/20
 *
 */
public class GetPatDrugOrdersQry implements ITransQry {

	private String patCode;
	private String minTime;
	
	public GetPatDrugOrdersQry(String patCode,String minTime){
		this.patCode = patCode;
		this.minTime = minTime;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {
		
		SqlParam param = new SqlParam();
		sqlSb.append("and pat.code = ? ");
		sqlSb.append("and ord.dt_sign >= ? ");
		
		param.addParam(this.patCode);
		param.addParam(this.minTime);
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ");
		sqlSb.append("pat.code patient_id,");//患者编码
		sqlSb.append("entop.times_op times,");//门诊次数
		sqlSb.append("srvmm.name_mm drugname,");//药品名称
		sqlSb.append("srvmm.code_mm charge_code,");//药品编码
		sqlSb.append("case when srvmm.factor = 1 then '00' else '01' end serial_no,");//大小包装（忽略）00 小包装/01 大包装
		sqlSb.append("case when substr(orsrv.sd_srvtp,0,2) = '0103' then orsrv.quan_medu else srvmm.quan_cur end charge_amount,");//计费数量
		sqlSb.append("nvl(ord.orders,1) caoyao_fu,");//草药付数
		sqlSb.append("ord.dt_effe happen_date,");//开方时间
		sqlSb.append("case when orsrv.fg_selfpay = 'N' then '0' else '1' end fit_type,");//医保内标志 0 保内 1 保外
		sqlSb.append("srvmm.days_available persist_days,");//开药持有天数
		sqlSb.append("'' order_properties,");//处方类型(sql外赋值)
		sqlSb.append("'' charge_status,");//收费状态(sql外赋值)
		sqlSb.append("depphy.code visit_dept,");//就诊科室
		//医嘱大分类 不限量药品9 其他8 
		sqlSb.append("case when exists(select 1 from bd_hp_unlimit_drug uld where uld.id_hp = srvorac.id_hp and uld.code_hp = srvorac.code) then '9' else '8' end infusion_flag,");
		sqlSb.append("depor.code apply_unit,");//开单科室编码
		sqlSb.append("psnor.code doctor_code,");//开单医生编码
		sqlSb.append("freq.code freq_code,");//频次编码
		sqlSb.append("srvmm.sd_pois drug_flag,");//毒麻分类

		sqlSb.append("pres.sd_prestp,");
		sqlSb.append("pres.sd_prestpword,");
		sqlSb.append("orsrv.sd_su_bl, ");
		sqlSb.append("orsrv.id_orsrv, ");
		sqlSb.append("'2' src_sys ");

		sqlSb.append("from ci_or_srv orsrv ");
		sqlSb.append("inner join ci_order ord  on orsrv.id_or = ord.id_or ");
		sqlSb.append("inner join ci_or_srv_mm srvmm  on orsrv.id_orsrv = srvmm.id_orsrv ");
		sqlSb.append("inner join ci_pres pres  on orsrv.id_pres = pres.id_pres ");
		sqlSb.append("inner join pi_pat pat  on ord.id_pat = pat.id_pat ");
		sqlSb.append("inner join en_ent ent  on ord.id_en = ent.id_ent ");
		sqlSb.append("inner join en_ent_op entop  on ord.id_en = entop.id_ent ");

		sqlSb.append("left join bd_dep depphy  on ent.id_dep_phy = depphy.id_dep ");
		sqlSb.append("left join bd_dep depor  on ord.id_dep_or = depor.id_dep ");
		sqlSb.append("left join bd_psndoc psnor  on ord.id_emp_or = psnor.id_psndoc ");
		sqlSb.append("left join bd_freq freq  on orsrv.id_freq = freq.id_freq ");
		sqlSb.append("left join bd_hp_srvorca srvorac  on ent.id_hp = srvorac.id_hp  and orsrv.id_srv = srvorac.id_srv and srvmm.id_mm = srvorac.id_mm ");

		sqlSb.append("where substr(ord.sd_srvtp,0,2) = '01' ");//药品医嘱
		sqlSb.append("and substr(orsrv.sd_srvtp,0,2) = '01' ");//药品服务
		sqlSb.append("and ord.fg_sign = 'Y' ");
		sqlSb.append("and ord.fg_canc = 'N' ");
		sqlSb.append("and orsrv.sd_su_bl <> '2' ");
		sqlSb.append("and orsrv.fg_selfpay='N' ");
		
		return sqlSb.toString();
	}
}
