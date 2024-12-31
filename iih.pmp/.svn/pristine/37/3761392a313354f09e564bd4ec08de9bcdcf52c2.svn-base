package iih.pmp.pay.custom.bp;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.i.IPmpPayExternalService;
import iih.pmp.pay.i.IPmpPayOperatorService;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import iih.pmp.pay.util.WXPayAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

public class PmpReverseQueryBp {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	PmpPayUtils utilspmp = new PmpPayUtils();
	WXPayAppUtils utils = new WXPayAppUtils();

	public OrdQryRstDTO ReverseQueryOrd(OrdReqDTO dto) throws BizException {
		if (StringUtils.isBlank(dto.getId_user_req())) {
			throw new BizException("请求用户不允许为空");
		}

//		OrdDO[] ords = pmputils.getOrdRService().find(
//				" ord_no='" + dto.getOrd_no() + "' and id_emp_op='" + pmputils.getId_Stuff(dto.getId_user_req()) + "' and ord_status=5",
//				null, FBoolean.FALSE);
		OrdDO[] ords = pmputils.getOrdRService().findByAttrValString(OrdDO.ORD_NO, dto.getOrd_no());

		if (ords == null || ords.length == 0 || ords.length > 1)
			throw new BizException("未查询到已撤回订单：" + dto.getOrd_no());
		if (!dto.getSd_chl().equals(ords[0].getSd_chl())) {
			throw new BizException("传入的渠道不正确！");
		}
		IPmpDataconvert dataconvert = PmpPayAppUtils.getDataconvert(dto.getSd_chl());
		IPmpSdk pay = PmpPayAppUtils.getPmpSdk(dto.getSd_chl());

		TradeDO[] tras = pmputils.getTradeDO8ord(ords[0]);
		if (tras != null && tras.length > 0) {
			for (TradeDO t : tras) {
				if (TradeStatusEnum.PAY_SUCCESS.equals(t.getTrade_status())) {
					dto.setRefund_req_no(dto.getOrd_no());
					dto.setAmount(t.getAmount());
					dto.setId_user_req(dto.getId_user_req());
//					dto.setId_user_req(pmputils.getId_Stuff(dto.getId_user_req()));
					OrdQryRstDTO[] rsts = ServiceFinder.find(IPmpPayOperatorService.class).refundquery(dto);
					if (rsts != null && rsts.length == 1) {
						if (rsts[0].getTrade_status().equals(TradeStatusEnum.REFUND_FAIL)) {
//							OrdRstDTO s=ServiceFinder.find(IPmpPayExternalService.class).refund(dto);
							ServiceFinder.find(IPmpPayExternalService.class).refund(dto);
							OrdQryRstDTO[] qrydrsts = ServiceFinder.find(IPmpPayOperatorService.class).refundquery(dto);
							if (qrydrsts != null && qrydrsts.length > 0)
								return qrydrsts[0];
						} else {
							return rsts[0];
						}
					}
				} else {
					Map<String, Object> data = dataconvert.getQueryParam(ords[0], t);
					Map<String, String> rnt = pay.doQuery(data);
					Map<String, String> m = dataconvert.QueryRntConvert(rnt);
					OrdRstDTO rst = new OrdRstDTO();
					HandleQueryRst(t, m, rst);
					if (t.getTrade_status().equals(TradeStatusEnum.PAY_SUCCESS)) {
						pmputils.getTradeCUDService().save(new TradeDO[] { t });
						dto.setRefund_req_no(dto.getOrd_no());
						dto.setAmount(t.getAmount());
						dto.setId_user_req(dto.getId_user_req());
//						dto.setId_user_req(pmputils.getId_Stuff(dto.getId_user_req()));
//						OrdRstDTO refundrst=ServiceFinder.find(IPmpPayExternalService.class).refund(dto);
						ServiceFinder.find(IPmpPayExternalService.class).refund(dto);
						OrdQryRstDTO[] qrydrsts = ServiceFinder.find(IPmpPayOperatorService.class).refundquery(dto);
						if (qrydrsts != null && qrydrsts.length > 0)
							return qrydrsts[0];
					}
				}
			}
		}
		return null;

	}

	private void HandleQueryRst(TradeDO tra, Map<String, String> m, OrdRstDTO rnt) throws BizException {
		if (m != null) {
			if (PmpPayConst.PMP_SUCCESS.equals(m.get(PmpPayConst.PMP_RESULT))) {
				String trade_state = m.get(PmpPayConst.PMP_TRADE_STATUS);
				String total_fee = m.get(PmpPayConst.PMP_AMOUNT);
				if (PmpPayConst.PMP_SUCCESS.equals(trade_state)) {
					// 支付成功
					tra.setDt_finish(pmputils.getServerDateTime());
					rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
					rnt.setAmount(pmputils.strToYuan(total_fee));
					tra.setTrade_status(TradeStatusEnum.PAY_SUCCESS);
					tra.setStatus(DOStatus.UPDATED);
					pmputils.setTradeAndRntVal(tra, m, pmputils.strToYuan(total_fee), rnt);
				}
			}
		}
	}

}
