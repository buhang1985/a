package iih.pi.acc.s.bp.qry;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import xap.sie.common.utils.StringUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

public class GetPiPrePayListQry  implements ITransQry{

	private String whereStr;
	
	public GetPiPrePayListQry(String whereStr){
		this.whereStr =whereStr;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sq = new SqlParam();
		return sq;
	}

	@Override
	public String getQrySQLStr() {
		        StringBuilder sqlStr = new StringBuilder();
//		        sqlStr.append(" select pat.code Patcode, ");
//				sqlStr.append("        pat.name Patname , ");
//				sqlStr.append("        entp.name  Enttpname ,                                                                          ");
//				sqlStr.append("        '' code_amr_ip,                                                                           ");
//				sqlStr.append("        prepay.code_rep,                                                                             ");
//				sqlStr.append("        pri.name           Name_pm,                                                                   ");
//				sqlStr.append("          ( prepay.amt * prepay.eu_direct )amt,                                                                                 ");
//				sqlStr.append("        emp.code           Emp_code,                                                                  ");
//				sqlStr.append("        emp.name Emp_name,                                                                            ");
//				sqlStr.append("        prepay.paymodenode,                                                                          ");
//				sqlStr.append("        prepay.bankno,                                                                               ");
//				sqlStr.append("        oep.dt_pay Dt_st,                                                                                   ");
//				sqlStr.append("        decode( prepay.note,'','正常',prepay.note) state,                                                                                              ");
//				sqlStr.append("       prepay.fg_canc,                                                                               ");
//				sqlStr.append("       prepay.dt_canc Refund_time                                                                                ");
//				sqlStr.append("   from bl_prepay_pat prepay                                                                         ");
//				sqlStr.append("  inner join pi_pat pat                                                                              ");
//				sqlStr.append("     on prepay.id_pat = pat.id_pat                                                                   ");
//				sqlStr.append("  inner join bd_psndoc emp                                                                           ");
//				sqlStr.append("     on emp.id_psndoc = prepay.id_emp_pay                                                            ");
//				
//				sqlStr.append("  inner join bd_pri_pm pri                                                                           ");
//				sqlStr.append("     on pri.id_pm = prepay.id_pm                                                                     ");
//				sqlStr.append("  inner join bd_entp entp on entp.id_entp = prepay.id_enttp                                          ");
//				sqlStr.append("  left join bl_pay_itm_pat_oep payoep on payoep.id_paypat =prepay.id_paypat                          ");
//				sqlStr.append("  left join bl_pay_pat_oep oep on oep.id_paypatoep = payoep.id_paypatoep                            ");
//				sqlStr.append("  where prepay.code_enttp ='00' and prepay.sd_paytp in ('11','12','21','22')                         ");
//				if(StringUtils.isNotEmpty(whereStr)){
//					sqlStr.append("and "+ whereStr);
//				}
//				sqlStr.append("                                                                                                     ");
//				sqlStr.append("  union all                                                                                          ");
				sqlStr.append("  select pat.code  Patcode   ,                                                                                 ");
				sqlStr.append("        pat.name Patname ,                                                                                    ");
				sqlStr.append("        entp.name  Enttpname ,                                                                          ");
				sqlStr.append("        entip.code_amr_ip,                                                                           ");
				sqlStr.append("        prepay.code_rep,                                                                             ");
				sqlStr.append("        pri.name           Name_pm,                                                                   ");
				sqlStr.append("          ( prepay.amt * prepay.eu_direct ) amt,                                                                             ");
				sqlStr.append("        emp.code           Emp_code,                                                                  ");
				sqlStr.append("        emp.name  Emp_name,                                                                            ");
				sqlStr.append("        prepay.paymodenode,                                                                          ");
				sqlStr.append("        prepay.bankno,                                                                               ");
				sqlStr.append("        prepay.dt_pay Dt_st,                                                                                   ");
//				sqlStr.append("   case when prepay.sd_paytp = '11' and prepay.eu_direct ='-1' then nvl(replace(prepay.note,'作废','退'),'退') when prepay.sd_paytp = '12' then prepay.note when substr(prepay.note,1,2) ='作废' then '' else prepay.note end as state, ");
				sqlStr.append("case ");
				sqlStr.append("   when prepay.sd_paytp = '11' and prepay.eu_direct ='1' then '' " );
				sqlStr.append("   when prepay.sd_paytp = '11' and prepay.eu_direct ='-1' then nvl(replace(prepay.note,'作废','退'),'退') " );
				sqlStr.append("   when prepay.sd_paytp = '12' and prepay.eu_direct ='1' then '' " );
				sqlStr.append("   when prepay.sd_paytp = '12' and prepay.eu_direct ='-1' then nvl(replace(prepay.note,'作废','退'),'退') " );
				sqlStr.append("   when prepay.sd_paytp = '21' and prepay.eu_direct ='-1' then '' " );
				sqlStr.append("   when prepay.sd_paytp = '21' and prepay.eu_direct ='1' then '门诊退费返回' " );
				sqlStr.append("   when prepay.sd_paytp = '22' and prepay.eu_direct ='-1' then '' " );
				sqlStr.append("   when prepay.sd_paytp = '22' and prepay.eu_direct ='1' then '住院退费返回' " );
				sqlStr.append("   else prepay.note end as state, ");

				sqlStr.append("       prepay.eu_direct, ");
				sqlStr.append("         prepay.fg_canc,                                                                             ");
				sqlStr.append("       prepay.dt_canc Refund_time                                                                               ");
				sqlStr.append("   from bl_prepay_pat prepay                                                                         ");
				sqlStr.append("  inner join pi_pat pat                                                                              ");
				sqlStr.append("     on prepay.id_pat = pat.id_pat                                                                   ");
				sqlStr.append("  inner join bd_psndoc emp                                                                           ");
				sqlStr.append("     on emp.id_psndoc = prepay.id_emp_pay                                                            ");
				sqlStr.append("   left join en_ent_ip entip                                                                         ");
				sqlStr.append("     on entip.id_ent = prepay.id_ent                                                                 ");
				sqlStr.append("  inner join bd_pri_pm pri                                                                           ");
				sqlStr.append("     on pri.id_pm = prepay.id_pm                                                                     ");
				sqlStr.append("  inner join bd_entp entp on entp.id_entp = prepay.id_enttp                                          ");
				
				sqlStr.append("  where  prepay.sd_paytp in ('11','12','21','22','18')                           ");
				String sqlContext = " and " + EnvContextUtil.processEnvContext("", new BlPrePayPatDO(), "prepay");//增加组织隔离
				sqlStr.append(sqlContext);
				if(StringUtils.isNotEmpty(whereStr)){
					sqlStr.append("and "+ whereStr);
				}
				//sqlStr.append("  order by Dt_st desc                                                                               ");
				
		return sqlStr.toString();
	}

}
