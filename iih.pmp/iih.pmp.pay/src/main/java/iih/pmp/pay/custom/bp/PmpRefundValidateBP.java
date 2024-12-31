package iih.pmp.pay.custom.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;

import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayBaseCost;
import iih.pmp.pay.utils.PmpPayLogUtils;
import iih.pmp.yxpaySDK.bp.YxPayUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDouble;

public class PmpRefundValidateBP {
	IPmpDataconvert dataconvert;
	PmpPayBP paybp;
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	

	public PmpRefundValidateBP(IPmpSdk pay1,IPmpDataconvert dataconvert1) {
		paybp = new PmpPayBP(pay1,dataconvert1);
		dataconvert = dataconvert1;
	}

	public Map<String, Object> isTradecanReFund(OrdReqDTO dto, OrdDO ord,OrdRstDTO rnt,TradeDO paidtra) throws BizException {
		Map<String, Object> map = new HashMap<>();		
		PmpPayLogUtils.info("[1]PMP_PmpRefundValidateBP_isTradecanReFund,获取退款交易信息,入参: 订单_"+(ord==null?"ord is null":ord.serializeJson())+" ,付款交易_"+(paidtra==null?"paidtra is null":paidtra.serializeJson()));
		if(paidtra==null)throw new BizException("无法查询到支付交易记录");
		TradeDO[] tras = pmputils.getRefundTradeDO(ord, dto);
		PmpPayLogUtils.info("[2]PMP_PmpRefundValidateBP_isTradecanReFund,获取退款交易信息:"+(tras==null?"tras为null":JSONArray.toJSONString(tras)));
		map = isTradecanReFund_old(dto, tras, ord, rnt,paidtra);
		PmpPayLogUtils.info("[3]PMP_PmpRefundValidateBP_isTradecanReFund,获取退款校验结果map: "+(map==null?"map为null":map.get(PmpPayBaseCost.PMP_FLAG)));
		return map;
	}

	/**
	 * 退款校验
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private Map<String, Object> isTradecanReFund_old(OrdReqDTO dto, TradeDO[] tras, OrdDO ord,OrdRstDTO rnt,TradeDO paidtra) throws BizException {
		// 如果申请退款失败，继续用相同的退款单号申请退款
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		List<TradeDO> tralist = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		PmpPayLogUtils.info("[1]PMP_PmpRefundValidateBP_isTradecanReFund_old,退款校验入参:"+(tras==null?"tras为null":JSONArray.toJSONString(tras)));
		if (tras != null && tras.length > 0) {
			for (TradeDO t : tras) {
				// todo 需要查询退款
				flag = this.validaterefundtrade(t, dto, sb, tralist, ord,paidtra);
				PmpPayLogUtils.info("[2]PMP_PmpRefundValidateBP_isTradecanReFund_old,查询退款结果:"+flag+",入参: "+(tras==null?"tras为null":JSONArray.toJSONString(tras)));
				if (flag == false) {	
						rnt.setTrade_status(t.getTrade_status());
						rnt.setTrade_no(t.getTrade_no());
						rnt.setAmount(t.getAmount());
						rnt.setBanktradeno(t.getBanktradeno());
						rnt.setOrd_no(dto.getOrd_no());
						rnt.setBankorderno(t.getBankorderno());
						rnt.setRefund_no(dto.getRefund_req_no());
						rnt.setTrade_no_chl(t.getTrade_no_chl());
					break;
				}
			}
			pmputils.getTradeCUDService().save(tras);
			pmputils.getOrdCudService().save(new OrdDO[] { ord });
			PmpPayLogUtils.info("[3]PMP_PmpRefundValidateBP_isTradecanReFund_old,tralist长度:"+tralist.size()+" ,tralist:"+JSONArray.toJSONString(tralist)+",入参: "+(tras==null?"tras为null":JSONArray.toJSONString(tras)));
			if (flag && tralist.size() > 0) {
				// 存在多笔失败交易，返回第一笔
				map.put(PmpPayBaseCost.PMP_TRADE, tralist.get(0));
			} else {
				map.put(PmpPayBaseCost.ERR_MSG, sb.toString());
			}
			PmpPayLogUtils.info("[4]PMP_PmpRefundValidateBP_isTradecanReFund_old,map:"+YxPayUtils.m2json(map)+" ,tralist:"+JSONArray.toJSONString(tralist)+",入参: "+(tras==null?"tras为null":JSONArray.toJSONString(tras)));
		} else {
			flag = true;
		}
		map.put(PmpPayBaseCost.PMP_FLAG, flag);
		PmpPayLogUtils.info("PMP_PmpRefundValidateBP_isTradecanReFund_old,最终返回map:"+YxPayUtils.m2json(map)+" ,tralist:"+JSONArray.toJSONString(tralist)+",入参: "+(tras==null?"tras为null":JSONArray.toJSONString(tras)));
		return map;
	}

	private boolean validaterefundtrade(TradeDO t, OrdReqDTO dto, StringBuilder sb, List<TradeDO> tralist, OrdDO ord,TradeDO paidtra)
			throws BizException {
		PmpPayLogUtils.info("[1]PMP_PmpRefundValidateBP_validaterefundtrade,校验退款交易入参: t_"+(t==null?"t为null":t.serializeJson())+" ,ord_"+(ord==null?"ord is null":ord.serializeJson())+" ,paidtra_"+(paidtra==null?"paidtra is null":paidtra.serializeJson()));
		boolean flag = false;
		if (TradeStatusEnum.REFUND_SUCCESS.equals(t.getTrade_status())) {
			//退款状态为成功，则不可修改状态
			flag=false;
//			flag = this.pmprefundquery(t, dto, sb, tralist, ord,paidtra);
//			if(!flag) {
//				//退款成功,查询结果为未知,不修改交易状态
//				updateTradeStatusnew(t, TradeStatusEnum.REFUND_SUCCESS);
//			}

		} else if (TradeStatusEnum.REFUND_FAIL.equals(t.getTrade_status())) {
			flag = true;
			tralist.add(t);
		} else if (TradeStatusEnum.CLOSED.equals(t.getTrade_status())) {
			flag = true;
		} else if (TradeStatusEnum.TRADE_UNKNOWN.equals(t.getTrade_status())) {
			// todo 需要查询退款
			flag = this.pmprefundquery(t, dto, sb, tralist, ord,paidtra);
			PmpPayLogUtils.info("[2]PMP_PmpRefundValidateBP_validaterefundtrade,查询退款结果: "+flag+" ,t.getTrade_status: "+t.getTrade_status());
			// 如果状态由交易未知变成退款成功,计算订单的可退款金额
			if (TradeStatusEnum.REFUND_SUCCESS.equals(t.getTrade_status())) {
				FDouble fee = t.getAmount();
				FDouble abk = ord.getAmount_bk();
				if(abk.floatValue()>0) {
					ord.setAmount_bk(abk.sub(fee));
					ord.setStatus(DOStatus.UPDATED);
				}
				
			}

		}
		PmpPayLogUtils.info("[3]PMP_PmpRefundValidateBP_validaterefundtrade,最终结果: "+flag+" ,t_: "+(t==null?"t为null":t.serializeJson()));
		return flag;

	}

	private boolean pmprefundquery(TradeDO t, OrdReqDTO dto, StringBuilder sb, List<TradeDO> tralist, OrdDO ord,TradeDO paidtra)
			throws BizException {
		PmpPayLogUtils.info("[1]PMP_PmpRefundValidateBP_pmprefundquery,校验退款交易入参: t_"+(t==null?"t为null":t.serializeJson())+" ,ord_"+(ord==null?"ord is null":ord.serializeJson())+" ,paidtra_"+(paidtra==null?"paidtra is null":paidtra.serializeJson()));
		boolean flag = false;
		Map<String, String> r1 = paybp.dorefundquery(t, ord,paidtra);
		
		PmpPayLogUtils.info("[2]PMP_PmpRefundValidateBP_pmprefundquery,退款查询结果: "+(r1==null?"r1为null":YxPayUtils.m2json2(r1)));
		if (r1 != null) {
			Map<String, String> r = this.dataconvert.RefundQueryRntConvert(r1);
			PmpPayLogUtils.info("[3]PMP_PmpRefundValidateBP_pmprefundquery,退款查询参数转换结果: "+(r==null?"r为null":YxPayUtils.m2json2(r)));
			if (PmpPayConst.PMP_SUCCESS.equals(r.get(PmpPayConst.PMP_RESULT))) {
				String status = r.get(PmpPayConst.PMP_TRADE_STATUS);
				if (PmpPayConst.PMP_SUCCESS.equals(status)) {
					String total_fee = r.get(PmpPayConst.PMP_AMOUNT);
					FDouble fee = pmputils.strToYuan(total_fee);
					flag = false;
					OrdRstDTO rnt = new OrdRstDTO();
					pmputils.setTradeAndRntVal(t, r, fee,rnt);
					updateTradeStatusnew(t, TradeStatusEnum.REFUND_SUCCESS);
					sb.append(this.getOrdErrMsg(dto, "已退款"));

				} else if (PmpPayConst.PMP_UNKNOW.equals(status)) {
					flag = false;
					updateTradeStatusnew(t, TradeStatusEnum.TRADE_UNKNOWN);
					sb.append(this.getOrdErrMsg(dto, "退款结果未知"));

				} else if (PmpPayConst.PMP_ERROR.equals(status)) {
					flag = true;
					updateTradeStatusnew(t, TradeStatusEnum.REFUND_FAIL);
					tralist.add(t);
					//如果订单不存在，保存错误码
					pmputils.setOrdNotExistErrCode(t, r.get(PmpPayConst.PMP_ERR_CODE));
				}
			} else {
				sb.append(r.get(PmpPayConst.PMP_ERR_MSG));
			}
		} else {
			flag = false;

		}
		PmpPayLogUtils.info("[4]PMP_PmpRefundValidateBP_pmprefundquery,返回结果: "+flag+" ,t_"+(t==null?"t为null":t.serializeJson()));
		return flag;
	}

	private void updateTradeStatusnew(TradeDO t, int tradestatus) throws BizException {
		if (!t.getTrade_status().equals(tradestatus)) {
			t.setTrade_status(tradestatus);
			t.setStatus(DOStatus.UPDATED);
		}
	}

//	private void setNOVal(TradeDO t,String Banktradeno,String Trade_no_chl,String bandorderno,FDouble fee) {
//		if(!Banktradeno.equals(t.getBanktradeno())||(Trade_no_chl!=null&&!Trade_no_chl.equals(t.getTrade_no_chl()))||(bandorderno!=null&&!bandorderno.equals(t.getBankorderno()))||!pmputils.isFDoubleEq(t.getAmount(), fee)){
//			t.setBanktradeno(Banktradeno);
//			t.setTrade_no_chl(Trade_no_chl);
//			t.setBankorderno(bandorderno);
//			t.setAmount(fee);
//			t.setStatus(DOStatus.UPDATED);
//		}
//	}

	private String getOrdErrMsg(OrdReqDTO o, String msg) {
		return "订单已存在，用户ID:" + o.getId_user_req() + ",订单号：" + o.getOrd_no() + ",退款单号： "
				+ o.getRefund_req_no() + "," + msg;
	}

}
