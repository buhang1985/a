package iih.pmp.pay.custom.bp;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.i.IPmpPayExternalService;
import iih.pmp.pay.i.IPmpPayOperatorService;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
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

public class PmpReverseOrdBP {

	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	PmpPayUtils utilspmp = new PmpPayUtils();
	WXPayAppUtils utils = new WXPayAppUtils();

	public OrdQryRstDTO ReverseOrd(OrdReqDTO dto) throws BizException {
		if (StringUtils.isBlank(dto.getId_user_req())) {
			throw new BizException("请求用户不允许为空");
		}

//		OrdDO[] ords = pmputils.getOrdRService().find(
//				" ord_no='" + dto.getOrd_no() + "' and id_emp_op='" + pmputils.getId_Stuff(dto.getId_user_req()) + "' and ord_status!=5",
//				null, FBoolean.FALSE);
		OrdDO[] ords = pmputils.getOrdRService().findByAttrValString(OrdDO.ORD_NO, dto.getOrd_no());

		if (ords == null || ords.length == 0 || ords.length > 1)
			throw new BizException("当前账户没有此订单或对应多个订单或者订单已撤回：" + dto.getOrd_no());
		if (!dto.getSd_chl().equals(ords[0].getSd_chl())) {
			throw new BizException("传入的渠道不正确！");
		}
		IPmpDataconvert dataconvert = PmpPayAppUtils.getDataconvert(dto.getSd_chl());
		IPmpSdk pay = PmpPayAppUtils.getPmpSdk(dto.getSd_chl());
		TradeDO paidtra = utilspmp.getPaidTrade(dto, ords[0]);
		if (paidtra != null)
			throw new BizException("已支付，不能撤回，请调用退款接口");
		// 撤回订单
		ords[0].setOrd_status(OrdStatusEnum.REVERSE);
		ords[0].setStatus(DOStatus.UPDATED);
		// ords[0].setAmount_bk(new FDouble(0));
		pmputils.getOrdCudService().save(ords);
		// 订单下的交易全额退款
		TradeDO[] tras = pmputils.getTradeDO8ord(ords[0]);
		OrdQryRstDTO qrydrst = null;
		if (tras != null && tras.length > 0) {
			for (TradeDO t : tras) {
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
//					dto.setId_user_req(pmputils.getId_Stuff(dto.getId_user_req()));
//					OrdRstDTO refundrst = ServiceFinder.find(IPmpPayExternalService.class).refund(dto);
					ServiceFinder.find(IPmpPayExternalService.class).refund(dto);
					OrdQryRstDTO[] qrydrsts = ServiceFinder.find(IPmpPayOperatorService.class).refundquery(dto);
					if (qrydrsts != null && qrydrsts.length > 0)
						qrydrst = qrydrsts[0];
					break;
				}
			}
		}

		return qrydrst;

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
