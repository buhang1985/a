package iih.bl.itf.std.bp.balacc;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.balacc.WsParamThirdPay;
import iih.bl.itf.std.bean.input.balacc.WsParamThirdPayBill;
import iih.bl.itf.std.bean.input.balacc.sub.WsParamThirdPayBillItem;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.bp.validator.WsParamThirdPayValidator;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetThirdPayInfoBP extends BlItfBaseBP<WsParamThirdPay, WsParamThirdPayBill> {

	private static String NOTE_SUCCESS = "查询成功";
	private static String NOTE_FAIL = "查询失败";
	private static String ALIPAY = "11";
	private static String WECHAT = "12";

	@Override
	protected String getBusiness() {
		return "查询微信支付宝交易信息";
	}

	@Override
	protected void checkParam(WsParamThirdPay param) throws BizException {
		WsParamThirdPayValidator validate = new WsParamThirdPayValidator();
		validate.validate(param);

	}

	@Override
	protected WsParamThirdPayBill doWork(WsParamThirdPay param) throws BizException {
		if (StringUtils.isEmpty(param.getPayType())) {
			param.setPayType(ALIPAY + "," + WECHAT);
		}
		StringBuilder sql = new StringBuilder();
		//预交金 
		sql.append(
				"  select s.patientid,  s.paytime,    s.payorderid,    s.paynum,    s.amount,   s.receiptid,  s.patientname,  s.type,   s.sourceCode, s.source,   s.typeflag,    s.tradetype,    biz.name bizscename   ");
		sql.append("   from (select pat.code patientid,   ");
		sql.append("   pre.dt_pay paytime,  ");
		sql.append("   pre.bankno payorderid, ");
		sql.append("   pre.paymodenode paynum,  ");
		sql.append("   (pre.amt * pre.eu_direct) amount, ");
		sql.append("    pre.code_rep receiptid,  ");
		sql.append("        pat.name patientname, ");
		sql.append("    pre.sd_pm type, ");
		sql.append("        pre.sd_pttp sourceCode, ");
		sql.append("         pttp.name source, ");
		sql.append("   decode(pre.code_enttp, '00', '01', '10', '04', '') typeflag, ");
		sql.append("    decode(pre.sd_pm, '11', 'API_WXSCAN', '12', 'API_ZFBSCAN') tradetype  ");
		sql.append("      from bl_prepay_pat pre  ");

		sql.append("   inner join pi_pat pat  on pat.id_pat = pre.id_pat   ");
		sql.append("     inner join bd_entp entp    on entp.id_entp = pre.id_enttp ");

		sql.append(
				"     left join bd_udidoc pttp  on pttp.code = pre.sd_pttp  and pttp.id_udidoclist = '@@@@ZZ200000000000JC'  ");
		sql.append("       where 1=1 ");
		sql.append("  and pre.dt_pay >= '"
				+ (param.getStartDate().trim().length() == 10 ? param.getStartDate().trim() + " 00:00:00"
						: param.getStartDate().trim())
				+ "'  and pre.dt_pay <= '" + (param.getEndDate().trim().length() == 10 ? param.getEndDate().trim() + " 23:59:59"
						: param.getEndDate().trim())
				+ "'   ");
		sql.append("and pre.sd_pm in ('11', '12')");
		// 如果终端类型不为空
		if (StringUtils.isNotEmpty(param.getSdPttp())) {
			sql.append(" and pre.sd_pttp  " + SqlUtils.getInSqlByIdsSplit(param.getSdPttp()));
		} 
		sql.append("     and pre.sd_paytp in ('11','12')  ");
		//门诊收费 
		sql.append("     union all ");
		sql.append("   select pat.code patientid,  ");
		sql.append("       pay.dt_pay paytime, ");
		sql.append("    decode(rcd.serial_no_trd,   '',  itmpay.bankno,   rcd.serial_no_trd) payorderid, ");
		sql.append("    decode(rcd.order_no, '', itmpay.paymodenode, rcd.order_no) paynum, ");
		sql.append("     (itmpay.amt * itmpay.eu_direct) amount, ");
		sql.append("    '-' as receiptid, ");
		sql.append("    pat.name patientname,  ");
		sql.append("    itmpay.sd_pm type, ");
		sql.append("   pay.sd_pttp sourceCode,  ");
		sql.append("  pttp.name source,  ");
		sql.append("   case  when stoep.eu_sttp = '31' then   '06' ");
		sql.append("    when stoep.eu_sttp = '43' then  '07'  ");
		sql.append("  when stoep.eu_sttp = '30' then  '02'  ");
		sql.append("  when stoep.eu_sttp = '41' then  '03' ");
		sql.append("   when stoep.pecode is not null then '08'  ");
		sql.append("    when stoep.pecode is not null and stoep.eu_direct = -1 then  '09' ");
		sql.append(
				"    when cust.id_patcust is not null and     stoep.pecode is not null then   '10'  else     '' end typeflag,  ");
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
		sql.append("  where itmpay.sd_pm  " + SqlUtils.getInSqlByIdsSplit(param.getPayType())
				+ "  and  pay.dt_pay >= '"
				+ (param.getStartDate().trim().length() == 10 ? param.getStartDate().trim() + " 00:00:00"
						: param.getStartDate().trim())
				+ "' and pay.dt_pay <= '" + (param.getEndDate().trim().length() == 10 ? param.getEndDate().trim() + " 23:59:59"
						: param.getEndDate().trim())
				+ "'   ");
		// 如果终端类型不为空
		if (StringUtils.isNotEmpty(param.getSdPttp())) {
			sql.append(" and pay.sd_pttp  " + SqlUtils.getInSqlByIdsSplit(param.getSdPttp()));
		} 
		sql.append("   and stoep.id_rootst = '~'   and itmpay.fg_realpay = 'Y'  ");
		sql.append("    and itmpay.amt <> 0 ");
		//门诊半退的时候
		sql.append("     union all  ");
		sql.append("   select pat.code patientid,  ");
		sql.append("  pay.dt_pay paytime,  ");
		sql.append("  decode(rcd.serial_no_trd,  '',  itmpay.bankno,   rcd.serial_no_trd) payorderid,  ");
		sql.append("     decode(rcd.order_no, '', itmpay.paymodenode, rcd.order_no) paynum, ");
		sql.append("   (itmpay.amt * itmpay.eu_direct) amount, ");
		sql.append("   '-' as receiptid,  ");
		sql.append("    pat.name patientname,  ");
		sql.append("   itmpay.sd_pm type, ");
		sql.append("     pay.sd_pttp sourceCode,");
		sql.append("  pttp.name source,  ");
		sql.append("   case  when stoep.eu_sttp = '31' then  '06' ");
		sql.append("   when stoep.eu_sttp = '43' then     '07'  ");
		sql.append("    when stoep.eu_sttp = '30' then  '02' ");
		sql.append("    when stoep.eu_sttp = '41' then  '03' ");
		sql.append("    when stoep.pecode is not null then  '08'");
		sql.append("  when stoep.pecode is not null and stoep.eu_direct = -1 then  '09' ");
		sql.append(
				"  when cust.id_patcust is not null and   stoep.pecode is not null then   '10'  else  ''  end typeflag, ");
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
		sql.append("  where itmpay.sd_pm " + SqlUtils.getInSqlByIdsSplit(param.getPayType())
				+ "  and  pay.dt_pay  >= '"
				+ (param.getStartDate().trim().length() == 10 ? param.getStartDate().trim() + " 00:00:00"
						: param.getStartDate().trim())
				+ "' and pay.dt_pay  <=  '" + (param.getEndDate().trim().length() == 10 ? param.getEndDate().trim() + " 23:59:59"
						: param.getEndDate().trim())
				+ "'   ");
		sql.append("    and itmpay.fg_realpay = 'Y' ");
		// 如果终端类型不为空
		if (StringUtils.isNotEmpty(param.getSdPttp())) {
			sql.append(" and pay.sd_pttp  " + SqlUtils.getInSqlByIdsSplit(param.getSdPttp()));
		} 

		sql.append("   and stoep.id_rootst <> '~' ");
		sql.append("  and itmpay.amt <> 0 ");
		//住院收付款
		sql.append("  union all ");
		sql.append("  select pat.code patientid, ");
		sql.append("  ip.dt_pay paytime, ");
		sql.append("    decode(rcd.serial_no_trd,    '',  payip.bankno,     rcd.serial_no_trd) payorderid, ");
		sql.append("   decode(rcd.order_no, '', payip.paymodenode, rcd.order_no) paynum, ");
		sql.append("   (payip.amt * payip.eu_direct) amount, ");
		sql.append("    '-' as receiptid, ");
		sql.append("   pat.name patientname, ");
		sql.append("  payip.sd_pm type, ");
		sql.append("   ip.sd_pttp sourceCode, ");
		sql.append("   pttpudi.name source, ");
		sql.append("    '05' typeflag,");
		sql.append("   decode(payip.sd_pm, '11', 'API_WXSCAN', '12', 'API_ZFBSCAN') tradetype ");
		sql.append("  from bl_pay_pat_ip ip ");
		sql.append("   inner join bl_pay_itm_pat_ip payip  on payip.id_paypatip = ip.id_paypatip ");
		sql.append("  inner join pi_pat pat on pat.id_pat = ip.id_pat ");
		sql.append("   inner join bl_st_ip stip     on stip.id_stip = ip.id_stip");
		sql.append("   left join bl_trd_trans_rcd rcd on rcd.id_pay = payip.id_payitmpatip ");
		sql.append(
				"   left join bd_udidoc pttpudi  on pttpudi.code = ip.sd_pttp   and pttpudi.id_udidoclist = '@@@@ZZ200000000000JC'");
		sql.append(
				"  where payip.sd_pm " + SqlUtils.getInSqlByIdsSplit(param.getPayType()) + "  and  ip.dt_pay  >= '"
						+ (param.getStartDate().trim().length() == 10 ? param.getStartDate().trim() + " 00:00:00"
								: param.getStartDate().trim())
						+ "' and ip.dt_pay  <= '" + (param.getEndDate().trim().length() == 10
								? param.getEndDate().trim() + " 23:59:59" : param.getEndDate().trim())
						+ "'   ");
		// 如果终端类型不为空
		if (StringUtils.isNotEmpty(param.getSdPttp())) {
			sql.append(" and ip.sd_pttp  " + SqlUtils.getInSqlByIdsSplit(param.getSdPttp()));
		} 
		sql.append(
				" ) s left join bd_udidoc biz     on biz.code = typeflag  and biz.id_udidoclist = '@@@@BZ400000000001UY' ");
		sql.append("  order by paytime ");

		@SuppressWarnings("unchecked")
		List<WsParamThirdPayBillItem> list = (List<WsParamThirdPayBillItem>) new DAFacade().execQuery(sql.toString(),
				null, new BeanListHandler(WsParamThirdPayBillItem.class));
		WsParamThirdPayBill bill = new WsParamThirdPayBill();
		if (list == null || list.size() <= 0) {

			bill.setCode(IBlWsConst.FALSE);
			bill.setMessage(NOTE_FAIL);
			return bill;
		}

		bill.setItems(list);
		bill.setCode(IBlWsConst.RLT_SUCCESS);
		bill.setMessage(NOTE_SUCCESS);
		return bill;
	}
}
