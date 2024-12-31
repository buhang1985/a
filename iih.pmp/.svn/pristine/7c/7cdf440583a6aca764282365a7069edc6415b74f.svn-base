package iih.pmp.pay.cmbc.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDouble;

public class CmbcRufundValidateBP {
	public final String errcode = "errcode";
	CmbcPayBP paybp;
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public CmbcRufundValidateBP() {
		paybp=new CmbcPayBP();
	}
	
	public Map<String, Object> isTradecanReFund(OrdReqDTO dto,OrdDO ord )
			throws BizException {
		Map<String, Object> rnt = new HashMap<>();
		TradeDO[] tras = pmputils.getRefundTradeDO(ord,dto);
		rnt = isTradecanReFund_old(dto, tras, ord);
		return rnt;
	}
	
	/**
	 * 退款校验
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private Map<String, Object> isTradecanReFund_old(OrdReqDTO dto,
			TradeDO[] tras,OrdDO ord) throws BizException {
		// 如果申请退款失败，继续用相同的退款单号申请退款
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		List<TradeDO> tralist = new ArrayList<>();
		Map<String, Object> rnt = new HashMap<>();
		if (tras != null && tras.length > 0) {
			for (TradeDO t : tras) {
				// todo 需要查询退款
				flag = this.validaterefundtrade(t, dto, sb, tralist, ord);
				if (flag == false)
					break;
			}
			pmputils.getTradeCUDService().save(tras);
			pmputils.getOrdCudService().save(new OrdDO[] {ord});

			if (flag && tralist.size() > 0) {
				// 存在多笔失败交易，返回第一笔
				rnt.put("tradedo", tralist.get(0));
			} else {
				rnt.put(errcode, sb.toString());
			}
		} else {
			flag = true;
		}
		rnt.put("flag", flag);
		return rnt;
	}
	
	private boolean validaterefundtrade(TradeDO t, OrdReqDTO dto,
			StringBuilder sb, List<TradeDO> tralist,OrdDO ord) throws BizException {
		boolean flag = false;
		if (TradeStatusEnum.REFUND_SUCCESS.equals(t.getTrade_status())) {
			flag = this.cmbcrefundquery(t, dto, sb, tralist,ord);

		} else if (TradeStatusEnum.REFUND_FAIL.equals(t.getTrade_status())) {
			flag = true;
			tralist.add(t);

		} else if (TradeStatusEnum.CLOSED.equals(t.getTrade_status())) {
			flag = true;
		} else if ( TradeStatusEnum.TRADE_UNKNOWN.equals(t.getTrade_status())) {
			// todo 需要查询退款
			flag = this.cmbcrefundquery(t, dto, sb, tralist,ord);
			//如果状态由交易未知变成退款成功,计算订单的可退款金额
			if(TradeStatusEnum.REFUND_SUCCESS.equals(t.getTrade_status())) {
				FDouble fee=t.getAmount();
				FDouble abk=ord.getAmount_bk();
				ord.setAmount_bk(abk.sub(fee));
				ord.setStatus(DOStatus.UPDATED);
			}

		}

		return flag;

	}
	
	private boolean cmbcrefundquery(TradeDO t, OrdReqDTO dto, StringBuilder sb,
			List<TradeDO> tralist,OrdDO ord) throws BizException {
		boolean flag = false;
		Map<String, String> r =paybp.orderQuery((ord.getCode()), t.getTrade_no());
		if (r != null
				&& "S".equals(r
						.get("gateReturnType"))) {

			    String	status = r.get("tradeStatus");
//				}
				if ("S".equals(status)) {
					String total_fee = r.get("amount");
					FDouble fee=pmputils.fenToYuan(total_fee);
					flag = false;
					setNOVal(t,r.get("bankTradeNo"),r.get("centerSeqId"),r.get("bankOrderNo"),fee);
					updateTradeStatusnew(t, TradeStatusEnum.REFUND_SUCCESS);
					sb.append(this.getOrdErrMsg(dto, "已退款"));

				}  else if ("R".equals(status)) {
					flag = false;
					updateTradeStatusnew(t, TradeStatusEnum.TRADE_UNKNOWN);
					sb.append(this.getOrdErrMsg(dto, "退款结果未知"));
//					tralist.add(t);

				} else if ("E".equals(status)) {
					flag = true;
					updateTradeStatusnew(t, TradeStatusEnum.REFUND_FAIL);
					tralist.add(t);
				}


		} else {
			flag = false;
			sb.append(r.get("gateReturnMessage"));
		}
		return flag;
	}
	
	private void updateTradeStatusnew(TradeDO t, int tradestatus)
			throws BizException {
		if (!t.getTrade_status().equals(tradestatus)) {
			t.setTrade_status(tradestatus);
			t.setStatus(DOStatus.UPDATED);
		}
	}
	
	private void setNOVal(TradeDO t,String Banktradeno,String Trade_no_chl,String bandorderno,FDouble fee) {
		if(!Banktradeno.equals(t.getBanktradeno())||(Trade_no_chl!=null&&!Trade_no_chl.equals(t.getTrade_no_chl()))||(bandorderno!=null&&!bandorderno.equals(t.getBankorderno()))||!pmputils.isFDoubleEq(t.getAmount(), fee)){
			t.setBanktradeno(Banktradeno);
			t.setTrade_no_chl(Trade_no_chl);
			t.setBankorderno(bandorderno);
			t.setAmount(fee);
			t.setStatus(DOStatus.UPDATED);
		}
	}

	private String getOrdErrMsg(OrdReqDTO o, String msg) {
		return "订单已存在，用户ID:" + o.getId_user_req()
				+ ",订单号：" + o.getOrd_no() + ",退款单号： " + o.getRefund_req_no()
				+ "," + msg;
	}
}
