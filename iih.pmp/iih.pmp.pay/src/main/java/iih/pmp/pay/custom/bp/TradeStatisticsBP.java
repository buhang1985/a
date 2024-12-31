package iih.pmp.pay.custom.bp;

import java.util.HashMap;
import java.util.List;

import iih.pmp.pay.blpmp.d.PmpBlReconciliationDifferencerDTO;
import iih.pmp.pay.blpmp.d.PmpBlReconciliationQryCondDTO;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

public class TradeStatisticsBP {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	@SuppressWarnings("unchecked")
	public PmpBlReconciliationDifferencerDTO exec(PmpBlReconciliationQryCondDTO dto) throws BizException {
		if (dto == null || dto.getDt_transr_start() == null)
			throw new BizException("参数不合法！");
		StringBuilder sb = new StringBuilder();
		sb.append(" a.dt_ord>='" + dto.getDt_transr_start().toString() + "' ");
		if (dto.getDt_transr_last() != null)
			sb.append(" and a.dt_ord<='" + dto.getDt_transr_last().toString() + "' ");
		sb.append(" and a.ord_status=1 ");
		if (!pmputils.isStrEmpty(dto.getCode_serial())) {
			sb.append(" and a.sd_chl='" + dto.getCode_serial() + "'");
		}
		if (!pmputils.isStrEmpty(dto.getId_emp_oper())) {
			sb.append(" and a.Id_emp_op='" + dto.getId_emp_oper() + "'");
		}
		if (!pmputils.isStrEmpty(dto.getId_pm())) {
			sb.append(" and a.id_pri_pm='" + dto.getId_pm() + "' ");
		}
		String sql = "select a.*,b.trade_no,b.amount tra_amount,trade_status from pmp_ord a left join pmp_trade b on a.id_ord=b.id_ord where "
				+ sb.toString() + " and b.trade_status in(1,4)";
		FDouble pay_sum = new FDouble(0);
		FDouble pay_num = new FDouble(0);
		FDouble refund_sum = new FDouble(0);
		FDouble refund_num = new FDouble(0);
		DAFacade da = new DAFacade();
		Object result = da.execQuery(sql, new MapListHandler());
		if (result != null) {
			List<HashMap<String, Object>> b = (List<HashMap<String, Object>>) result;
			for (HashMap<String, Object> m : b) {
				String trade_status = valConvert(m.get("trade_status"));
				if (pmputils.isStrEmpty(trade_status))
					continue;
				if ("1".equals(trade_status)) {
					FDouble pay = pmputils.strToYuan(valConvert(m.get("amount")));
					pay_sum = pay_sum.add(pay);
					pay_num = pay_num.add(new FDouble("1"));
				} else {
					FDouble refund = pmputils.strToYuan(valConvert(m.get("tra_amount")));
					refund_sum = refund_sum.add(refund);
					refund_num = refund_num.add(new FDouble("1"));
				}
			}
		}
//		for (OrdDO o : ords) {
//			paysum.add(o.getAmount());
//			remainsum.add(o.getAmount_bk());
//		}
		PmpBlReconciliationDifferencerDTO rst = new PmpBlReconciliationDifferencerDTO();
		rst.setPayment_amt(pay_sum);
		rst.setPayment_quan(pay_num);
		rst.setRefund_amt(refund_sum);
		rst.setRefund_quan(refund_num);
		rst.setPlatform_type("1");
		rst.setTotal_amt(pay_sum.add(refund_sum));
		return rst;
	}

	private String valConvert(Object o) {
		if (o == null) {
			return "";
		} else {
			return o + "";
		}
	}

}
