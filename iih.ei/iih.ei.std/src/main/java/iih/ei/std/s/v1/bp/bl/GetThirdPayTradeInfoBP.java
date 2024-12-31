package iih.ei.std.s.v1.bp.bl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.ei.std.d.v1.bl.thirdpaytradedto.d.ThirdPayInfo;
import iih.ei.std.d.v1.bl.thirdpaytradedto.d.ThirdPayTradeParamDTO;
import iih.ei.std.d.v1.bl.thirdpaytradedto.d.ThirdPayTradeResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/***
 * 微信支付宝对账接口
 * 
 * @author shaokx
 * @date: 2019.10.17
 */
public class GetThirdPayTradeInfoBP extends IIHServiceBaseBP<ThirdPayTradeParamDTO, ThirdPayTradeResultDTO>{

	private static String NOTE_SUCCESS = "查询成功";
	private static String NOTE_FAIL = "查询失败";
	private static String ALIPAY = "11";
	private static String WECHAT = "12";
	
	@Override
	protected void checkParam(ThirdPayTradeParamDTO param) throws BizException {
		
		if (param == null) {
			throw new BizException("查询微信支付宝交易信息入参数据为空");
		}
		
		if (StringUtil.isEmpty(param.getDt_start())) {
			throw new BizException("查询微信支付宝交易信息开始时间为空");
		}
		
		if (StringUtil.isEmpty(param.getDt_end())) {
			throw new BizException("查询微信支付宝交易信息结束时间为空");
		}
		
	}

	@Override
	protected ThirdPayTradeResultDTO process(ThirdPayTradeParamDTO param) throws BizException {
		
		if (StringUtils.isEmpty(param.getCode_pm())) {
			param.setCode_pm(ALIPAY + "," + WECHAT);
		}
		
		StringBuilder sql = new StringBuilder();
		//预交金 
		sql.append(
				"  select s.code_pat,  s.dt_pay,    s.bankno,    s.paymodenode,    s.amt,   s.code_rep,  s.name_pat,  s.code_pm,   s.sd_pttp, s.name_pttp,   s.code_enttp,    s.tradetype,    biz.name bizscename   ");
		sql.append("   from (select pat.code code_pat,   ");
		sql.append("   pre.dt_pay,  ");
		sql.append("   pre.bankno, ");
		sql.append("   pre.paymodenode,  ");
		sql.append("   (pre.amt * pre.eu_direct) amt, ");
		sql.append("    pre.code_rep,  ");
		sql.append("        pat.name name_pat, ");
		sql.append("    pre.sd_pm code_pm, ");
		sql.append("        pre.sd_pttp, ");
		sql.append("         pttp.name name_pttp, ");
		sql.append("   decode(pre.code_enttp, '00', '01', '10', '04', '') code_enttp, ");
		sql.append("    decode(pre.sd_pm, '11', 'API_WXSCAN', '12', 'API_ZFBSCAN') tradetype  ");
		sql.append("      from bl_prepay_pat pre  ");

		sql.append("   inner join pi_pat pat  on pat.id_pat = pre.id_pat   ");
		sql.append("     inner join bd_entp entp    on entp.id_entp = pre.id_enttp ");

		sql.append(
				"     left join bd_udidoc pttp  on pttp.code = pre.sd_pttp  and pttp.id_udidoclist = '@@@@ZZ200000000000JC'  ");
		sql.append("       where 1=1 ");
		sql.append("  and pre.dt_pay >= '"
				+ (param.getDt_start().trim().length() == 10 ? param.getDt_start().trim() + " 00:00:00"
						: param.getDt_start().trim())
				+ "'  and pre.dt_pay <= '" + (param.getDt_end().trim().length() == 10 ? param.getDt_end().trim() + " 23:59:59"
						: param.getDt_end().trim())
				+ "'   ");
		sql.append("and pre.sd_pm in ('11', '12')");
		// 如果终端类型不为空
		if (StringUtils.isNotEmpty(param.getSd_pttp())) {
			sql.append(" and pre.sd_pttp  " + SqlUtils.getInSqlByIdsSplit(param.getSd_pttp()));
		} 
		sql.append("     and pre.sd_paytp in ('11','12')  ");
		//门诊收费 
		sql.append("     union all ");
		sql.append("   select pat.code code_pat,  ");
		sql.append("       pay.dt_pay, ");
		sql.append("    decode(rcd.serial_no_trd,   '',  itmpay.bankno,   rcd.serial_no_trd) bankno, ");
		sql.append("    decode(rcd.order_no, '', itmpay.paymodenode, rcd.order_no) paymodenode, ");
		sql.append("     (itmpay.amt * itmpay.eu_direct) amt, ");
		sql.append("    '-' as code_rep, ");
		sql.append("    pat.name name_pat,  ");
		sql.append("    itmpay.sd_pm code_pm, ");
		sql.append("   pay.sd_pttp,  ");
		sql.append("  pttp.name name_pttp,  ");
		sql.append("   case  when stoep.eu_sttp = '31' then   '06' ");
		sql.append("    when stoep.eu_sttp = '43' then  '07'  ");
		sql.append("  when stoep.eu_sttp = '30' then  '02'  ");
		sql.append("  when stoep.eu_sttp = '41' then  '03' ");
		sql.append("   when stoep.pecode is not null then '08'  ");
		sql.append("    when stoep.pecode is not null and stoep.eu_direct = -1 then  '09' ");
		sql.append(
				"    when cust.id_patcust is not null and     stoep.pecode is not null then   '10'  else     '' end code_enttp,  ");
		sql.append("  decode(itmpay.sd_pm, '11', 'API_WXSCAN', '12', 'API_ZFBSCAN') tradetype ");
		sql.append("   from bl_pay_pat_oep pay ");
		sql.append("     inner join bl_pay_itm_pat_oep itmpay on pay.id_paypatoep = itmpay.id_paypatoep ");
		sql.append("     inner join bl_st_oep stoep  on stoep.id_paypatoep = pay.id_paypatoep  ");
		sql.append("     inner join pi_pat pat on pat.id_pat = pay.id_pat ");
		sql.append("     inner join bd_entp entp     on entp.id_entp = pay.id_enttp  ");
		sql.append("     inner join bd_psndoc emp   on pay.id_emp_pay = emp.id_psndoc ");
		sql.append("     left join bl_trd_trans_rcd rcd on rcd.id_pay = itmpay.id_payitmpatoep ");
		sql.append("     left join pi_pat_cust cust    on cust.id_pat = pat.id_pat ");
		sql.append(
				"   left join bd_udidoc pttp on pttp.code = pay.sd_pttp     and pttp.id_udidoclist = '@@@@ZZ200000000000JC'  ");
		sql.append("  where itmpay.sd_pm  " + SqlUtils.getInSqlByIdsSplit(param.getCode_pm())
				+ "  and  pay.dt_pay >= '"
				+ (param.getDt_start().trim().length() == 10 ? param.getDt_start().trim() + " 00:00:00"
						: param.getDt_start().trim())
				+ "' and pay.dt_pay <= '" + (param.getDt_end().trim().length() == 10 ? param.getDt_end().trim() + " 23:59:59"
						: param.getDt_end().trim())
				+ "'   ");
		// 如果终端类型不为空
		if (StringUtils.isNotEmpty(param.getSd_pttp())) {
			sql.append(" and pay.sd_pttp  " + SqlUtils.getInSqlByIdsSplit(param.getSd_pttp()));
		} 
		sql.append("   and stoep.id_rootst = '~'   and itmpay.fg_realpay = 'Y'  ");
		sql.append("    and itmpay.amt <> 0 ");
		//门诊半退的时候
		sql.append("     union all  ");
		sql.append("   select pat.code code_pat,  ");
		sql.append("  pay.dt_pay,  ");
		sql.append("  decode(rcd.serial_no_trd,  '',  itmpay.bankno,   rcd.serial_no_trd) bankno,  ");
		sql.append("     decode(rcd.order_no, '', itmpay.paymodenode, rcd.order_no) paymodenode, ");
		sql.append("   (itmpay.amt * itmpay.eu_direct) amt, ");
		sql.append("   '-' as code_rep,  ");
		sql.append("    pat.name name_pat,  ");
		sql.append("   itmpay.sd_pm code_pm, ");
		sql.append("     pay.sd_pttp,");
		sql.append("  pttp.name name_pttp,  ");
		sql.append("   case  when stoep.eu_sttp = '31' then  '06' ");
		sql.append("   when stoep.eu_sttp = '43' then     '07'  ");
		sql.append("    when stoep.eu_sttp = '30' then  '02' ");
		sql.append("    when stoep.eu_sttp = '41' then  '03' ");
		sql.append("    when stoep.pecode is not null then  '08'");
		sql.append("  when stoep.pecode is not null and stoep.eu_direct = -1 then  '09' ");
		sql.append(
				"  when cust.id_patcust is not null and   stoep.pecode is not null then   '10'  else  ''  end code_enttp, ");
		sql.append("  decode(itmpay.sd_pm, '11', 'API_WXSCAN', '12', 'API_ZFBSCAN') tradetype");
		sql.append("    from  bl_pay_pat_oep pay ");
		sql.append("  inner join bl_pay_itm_pat_oep itmpay on pay.id_paypatoep = itmpay.id_paypatoep ");
		sql.append("   inner join pi_pat pat on pat.id_pat = pay.id_pat ");
		sql.append("   inner join bl_st_oep stoep  on stoep.id_paypatoep = pay.id_paypatoep ");
		sql.append("  inner join bl_st_oep stroot     on stroot.id_stoep = stoep.id_rootst ");
		sql.append("   inner join bl_pay_pat_oep rootoep   on stroot.id_paypatoep = rootoep.id_paypatoep");
		sql.append("  inner join bl_pay_itm_pat_oep rootitmoep    on rootoep.id_paypatoep = rootitmoep.id_paypatoep ");
		sql.append("   inner join bd_entp entp    on entp.id_entp = pay.id_enttp ");
		sql.append("  inner join bd_psndoc emp   on pay.id_emp_pay = emp.id_psndoc ");
		sql.append("   left join bl_trd_trans_rcd rcd on rcd.id_pay = rootitmoep.id_payitmpatoep ");
		sql.append("   left join pi_pat_cust cust    on cust.id_pat = pat.id_pat ");
		sql.append(
				"   left join bd_udidoc pttp   on pttp.code = pay.sd_pttp   and pttp.id_udidoclist = '@@@@ZZ200000000000JC' ");
		sql.append("  where itmpay.sd_pm " + SqlUtils.getInSqlByIdsSplit(param.getCode_pm())
				+ "  and  pay.dt_pay  >= '"
				+ (param.getDt_start().trim().length() == 10 ? param.getDt_start().trim() + " 00:00:00"
						: param.getDt_start().trim())
				+ "' and pay.dt_pay  <=  '" + (param.getDt_end().trim().length() == 10 ? param.getDt_end().trim() + " 23:59:59"
						: param.getDt_end().trim())
				+ "'   ");
		sql.append("    and itmpay.fg_realpay = 'Y' ");
		// 如果终端类型不为空
		if (StringUtils.isNotEmpty(param.getSd_pttp())) {
			sql.append(" and pay.sd_pttp  " + SqlUtils.getInSqlByIdsSplit(param.getSd_pttp()));
		} 

		sql.append("   and stoep.id_rootst <> '~' ");
		sql.append("  and itmpay.amt <> 0 ");
		//住院收付款
		sql.append("  union all ");
		sql.append("  select pat.code code_pat, ");
		sql.append("  ip.dt_pay, ");
		sql.append("    decode(rcd.serial_no_trd,    '',  payip.bankno,     rcd.serial_no_trd) bankno, ");
		sql.append("   decode(rcd.order_no, '', payip.paymodenode, rcd.order_no) paymodenode, ");
		sql.append("   (payip.amt * payip.eu_direct) amt, ");
		sql.append("    '-' as code_rep, ");
		sql.append("   pat.name name_pat, ");
		sql.append("  payip.sd_pm code_pm, ");
		sql.append("   ip.sd_pttp, ");
		sql.append("   pttpudi.name name_pttp, ");
		sql.append("    '05' code_enttp,");
		sql.append("   decode(payip.sd_pm, '11', 'API_WXSCAN', '12', 'API_ZFBSCAN') tradetype ");
		sql.append("  from bl_pay_pat_ip ip ");
		sql.append("   inner join bl_pay_itm_pat_ip payip  on payip.id_paypatip = ip.id_paypatip ");
		sql.append("  inner join pi_pat pat on pat.id_pat = ip.id_pat ");
		sql.append("   inner join bl_st_ip stip     on stip.id_stip = ip.id_stip");
		sql.append("   left join bl_trd_trans_rcd rcd on rcd.id_pay = payip.id_payitmpatip ");
		sql.append(
				"   left join bd_udidoc pttpudi  on pttpudi.code = ip.sd_pttp   and pttpudi.id_udidoclist = '@@@@ZZ200000000000JC'");
		sql.append(
				"  where payip.sd_pm " + SqlUtils.getInSqlByIdsSplit(param.getCode_pm()) + "  and  ip.dt_pay  >= '"
						+ (param.getDt_start().trim().length() == 10 ? param.getDt_start().trim() + " 00:00:00"
								: param.getDt_start().trim())
						+ "' and ip.dt_pay  <= '" + (param.getDt_end().trim().length() == 10
								? param.getDt_end().trim() + " 23:59:59" : param.getDt_end().trim())
						+ "'   ");
		// 如果终端类型不为空
		if (StringUtils.isNotEmpty(param.getSd_pttp())) {
			sql.append(" and ip.sd_pttp  " + SqlUtils.getInSqlByIdsSplit(param.getSd_pttp()));
		} 
		sql.append(
				" ) s left join bd_udidoc biz     on biz.code = code_enttp  and biz.id_udidoclist = '@@@@BZ400000000001UY' ");
		sql.append("  order by dt_pay ");

		@SuppressWarnings("unchecked")
		List<ThirdPayInfo> list = (List<ThirdPayInfo>) new DAFacade().execQuery(sql.toString(),
				null, new BeanListHandler(ThirdPayInfo.class));
		
		ThirdPayTradeResultDTO bill = new ThirdPayTradeResultDTO();
		if (list == null || list.size() <= 0) {
			return bill;
		}

		FArrayList arr = new FArrayList();
		arr.addAll(list);
		bill.setThirdpayinfo(arr);

		return bill;
	}

}
