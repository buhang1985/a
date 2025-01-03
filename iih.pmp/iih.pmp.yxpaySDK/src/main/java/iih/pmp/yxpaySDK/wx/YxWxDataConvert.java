package iih.pmp.yxpaySDK.wx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.WXParamUtils2.RFQueryRNTParamConst2;
import iih.pmp.pay.util.WXParamUtils2.WXCommonRntParamCode2;
import iih.pmp.pay.util.wxerrorcode2.WXMicropayErrorCodeConst2;
import iih.pmp.pay.util.wxerrorcode2.WXQueryErrorcode2;
import iih.pmp.pay.util.wxerrorcode2.WXReFundErrorCode2;
import iih.pmp.pay.utils.PmpPayLogUtils;
import iih.pmp.yxpaySDK.bp.YxPayConfig;
import iih.pmp.yxpaySDK.bp.YxPayUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class YxWxDataConvert   implements IPmpDataconvert {
	
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	@Override
	public Map<String, Object> getBarcodeParam(OrdReqDTO dto, OrdDO ord, TradeDO tra) throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("channelid", "1");
		data.put("terminalid", "63");		
		data.put("sceneid", "12");		
		data.put("merchantCode", YxPayConfig.getMchID());
		data.put("auth_code", dto.getAuth_code());
		data.put("totalFee", dto.getAmount().getDouble()+"");
		data.put("body", dto.getSubject());
		data.put("merchantTradeNo", tra.getTrade_no());
		data.put("tradeType", "MICROPAY");
		if(!pmputils.isStrEmpty(dto.getId_pat())) {
			IPatiMDORService  ipat=ServiceFinder.find(IPatiMDORService.class);
			PatDO p=ipat.findById(dto.getId_pat());
			if(p!=null) {
				data.put("name", p.getName());
				data.put("patientid", p.getCode());
				data.put("phone", p.getMob());
				data.put("idNo", p.getId_code());
			}else {
				data.put("name", "张三");
				data.put("patientid", "00012992000");
				data.put("phone", "18888888888");
				data.put("idNo", "42091111111111111");
			}
		}else {
			data.put("name", "张三");
			data.put("patientid", "00012992000");
			data.put("phone", "18888888888");
			data.put("idNo", "42091111111111111");
		}
		PmpPayLogUtils.info("医信聚合支付,微信支付,YxWxDataConvert----->    Biz_scene:"+(dto.getBiz_scene()!=null?dto.getBiz_scene():"")+" ,dto: "+(dto!=null?dto.serializeJson():""));
		if (dto.getBiz_scene()!=null&&(dto.getBiz_scene().equals(IBlDictCodeConst.SD_BIZSCENE_OEP_CHARGE)||dto.getBiz_scene().equals(IBlDictCodeConst.SD_BIZSCENE_OEP_PRE))) {
			data.put("businessid", "17");
		}else if(dto.getBiz_scene()!=null&&dto.getBiz_scene().equals(IBlDictCodeConst.SD_BIZSCENE_IP_CHARGE)){
			data.put("businessid", "71");//住院收费场景编码   bug:0190358: 传给支付平台业务场景编码有误问题 yzh 2020年5月14日13:29:53
		}
		else if(dto.getBiz_scene()!=null&&dto.getBiz_scene().equals(IBlDictCodeConst.SD_BIZSCENE_OEP_ENT)) {
			data.put("businessid", "16");
		}else {
			data.put("businessid", "17");
		}
		
		return data;
	}

	@Override
	public Map<String, Object> getQRCODEParam(OrdReqDTO dto, OrdDO ord, TradeDO tra) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getQueryParam(OrdDO ord, TradeDO tra) throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("merchantTradeNo", tra.getTrade_no());
		return data;
	}

	@Override
	public Map<String, Object> getRefundQueryParam(OrdDO ord, TradeDO tra, TradeDO paidtra) throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("merchantTradeNo", paidtra.getTrade_no());
		data.put("merchantRefundTradeNo", tra.getTrade_no());
		return data;
	}

	@Override
	public Map<String, Object> getReFundParam(OrdDO ord, TradeDO tra, OrdReqDTO dto, TradeDO paidtra)
			throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("merchantTradeNo", paidtra.getTrade_no());
		data.put("merchantRefundTradeNo", tra.getTrade_no());
		data.put("refundFee", tra.getAmount().getDouble()+"");
		data.put("refundDesc", dto.getSubject());
		data.put("totalFee", paidtra.getAmount().getDouble()+"");
		data.put("notify_url", "https://www.baidu.com");
//		data.put("payType", "MICROPAY");
		return data;
	}

	@Override
	public Map<String, String> BarcodeRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> data = new HashMap<String, String>();
		// TODO Auto-generated method stub
		if (rnt.get(WXCommonRntParamCode2.RETURN_CODE).equals(WXCommonRntParamCode2.SUCCESS)) {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			if (WXCommonRntParamCode2.SUCCESS.equals(rnt.get(WXCommonRntParamCode2.RESULT_CODE))) {
				setSuccessState(data,rnt);
			}else {
				int status=WXMicropayErrorCodeConst2.getTradeFailStatus(rnt.get(WXCommonRntParamCode2.ERR_CODE));
                if(status==TradeStatusEnum.PAY_FAIL||status==TradeStatusEnum.CLOSED||status==TradeStatusEnum.REVOKED) {
                	data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
                }else {
                	data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
                }
                data.put(PmpPayConst.PMP_ERR_CODE, rnt.get("err_code"));
        		data.put(PmpPayConst.PMP_ERR_MSG, rnt.get("err_code_des"));
			}
		}else {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
			data.put(PmpPayConst.PMP_ERR_MSG, rnt.get(WXCommonRntParamCode2.RETURN_MSG));
		}
		for (Map.Entry<String, String> entry : rnt.entrySet()) {
			data.put(entry.getKey(), entry.getValue());
		}
		return data;
	}
	private void setSuccessState(Map<String, String> data,Map<String, String> rnt) {
		data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
		data.put(PmpPayConst.PMP_AMOUNT, pmputils.fenToYuan(rnt.get("total_fee"))==null?null: pmputils.fenToYuan(rnt.get("total_fee"))+ "");//将金额由分转成元
		data.put(PmpPayConst.PMP_TRADE_NO, rnt.get("out_trade_no"));
		data.put(PmpPayConst.PMP_ORDER_NO, rnt.get("out_trade_no"));
		data.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get("transaction_id"));
	}

	@Override
	public Map<String, String> QrcodeRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> QueryRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> data = new HashMap<String, String>();
		if (rnt != null
				&& WXCommonRntParamCode2.SUCCESS.equals(rnt
						.get(WXCommonRntParamCode2.RETURN_CODE))) {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			if (WXCommonRntParamCode2.SUCCESS.equals(rnt
					.get(WXCommonRntParamCode2.RESULT_CODE))) {		
		String trade_state=rnt.get("trade_state");
		if ("SUCCESS".equals(trade_state)) {
			// 支付成功
			setSuccessState(data,rnt);

		} else if ("REFUND".equals(trade_state)) {
			// 转入退款
			setSuccessState(data,rnt);		
		} else if ("CLOSED".equals(trade_state)) {
			// 已关闭
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
			data.put(PmpPayConst.PMP_ERR_MSG, "CLOSED，已关闭");

		} else if ("REVOKED".equals(trade_state)) {
			// 已撤销（刷卡支付）
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
			data.put(PmpPayConst.PMP_ERR_MSG, "REVOKED，已撤回");

		} else if ("USERPAYING".equals(trade_state)) {
			// 用户支付中
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_USERPAYING);
			data.put(PmpPayConst.PMP_ERR_MSG, "USERPAYING，支付中");

		} else if ("PAYERROR".equals(trade_state)) {
			// 支付失败(其他原因，如银行返回失败)
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
			data.put(PmpPayConst.PMP_ERR_MSG, "PAYERROR，支付失败");
		} else if (trade_state.equals("NOTPAY")) {
			// 未支付
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
			data.put(PmpPayConst.PMP_ERR_MSG, "NOTPAY，未支付");
		}

			}else {
				int state=WXQueryErrorcode2.getTradeFailStatus(rnt.get(WXCommonRntParamCode2.ERR_CODE));
				if(state==TradeStatusEnum.PAY_FAIL) {
					data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
					data.put(PmpPayConst.PMP_ERR_CODE
							, PmpPayConst.PMP_ORD_NOT_EXIST);
					data.put(PmpPayConst.PMP_ERR_MSG, rnt.get("err_code_des"));
				}else {
					data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
					data.put(PmpPayConst.PMP_ERR_MSG, rnt.get("err_code_des"));
				}
			}
		}else {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
		}
		for (Map.Entry<String, String> entry : rnt.entrySet()) {
//			  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			data.put(entry.getKey(), entry.getValue());
		}
		return data;
	}

	@Override
	public Map<String, String> RefundQueryRntConvert(Map<String, String> rnt) throws BizException {
		PmpPayLogUtils.info("[1]PMP_YxWxDataConvert_RefundQueryRntConvert,入参: "+(rnt==null?"rnt为null":YxPayUtils.m2json2(rnt)));
		Map<String, String> data = new HashMap<String, String>();
		if (rnt != null
				&& WXCommonRntParamCode2.SUCCESS.equals(rnt
						.get(WXCommonRntParamCode2.RETURN_CODE))) {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			if (WXCommonRntParamCode2.SUCCESS.equals(rnt
					.get(WXCommonRntParamCode2.RESULT_CODE))) {
				Map<String, String> mr = pmputils.GetRntParam2(rnt);
				Map<String, String> m = rnt;
				String status = m.get(mr.get(RFQueryRNTParamConst2.REFUND_STATUS));

				if ("SUCCESS".equals(status)) {
					data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
					data.put(PmpPayConst.PMP_AMOUNT, pmputils.fenToYuan(rnt.get(mr.get(RFQueryRNTParamConst2.REFUND_FEE)))==null?null: pmputils.fenToYuan(rnt.get(mr.get(RFQueryRNTParamConst2.REFUND_FEE)))+ "");//将金额由分转成元
					data.put(PmpPayConst.PMP_TRADE_NO, rnt.get(mr.get(RFQueryRNTParamConst2.OUT_REFUND_NO)));
					data.put(PmpPayConst.PMP_ORDER_NO, rnt.get(RFQueryRNTParamConst2.OUT_TRADE_NO));
					data.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get(mr.get(RFQueryRNTParamConst2.REFUND_ID)));

				} else if ("REFUNDCLOSE".equals(status)) {
					// todo 退款已关闭是否可以用同样的单号继续退款？？？？
					data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
					data.put(PmpPayConst.PMP_ERR_MSG, "REFUNDCLOSE");

				} else if ("PROCESSING".equals(status)) {
					data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
					data.put(PmpPayConst.PMP_ERR_MSG, "PROCESSING");

				} else if ("CHANGE".equals(status)) {
					data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
					data.put(PmpPayConst.PMP_ERR_MSG, "CHANGE");
				}
			} else if (rnt.get(WXCommonRntParamCode2.ERR_CODE).equals(
					"REFUNDNOTEXIST")) {
				data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
				data.put(PmpPayConst.PMP_ERR_CODE
						, PmpPayConst.PMP_ORD_NOT_EXIST);

			} else {	
				data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
			}

		} else {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_UNKNOW);
		}
		for (Map.Entry<String, String> entry : rnt.entrySet()) {
//			  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			data.put(entry.getKey(), entry.getValue());
		}
		PmpPayLogUtils.info("[2]PMP_YxWxDataConvert_RefundQueryRntConvert,出参: "+(data==null?"data为null":YxPayUtils.m2json2(data)));
		return data;
	}

	@Override
	public Map<String, String> RefundRntConvert(Map<String, String> rnt) throws BizException {
		Map<String, String> data = new HashMap<String, String>();
		PmpPayLogUtils.info("[1]PMP_YxWxDataConvert_RefundRntConvert, 入参: "+(rnt==null?"rnt为null":YxPayUtils.m2json2(rnt)));
		if (rnt.get(WXCommonRntParamCode2.RETURN_CODE).equals(WXCommonRntParamCode2.SUCCESS)) {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			if (WXCommonRntParamCode2.SUCCESS.equals(rnt.get(WXCommonRntParamCode2.RESULT_CODE))) {
				data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
				data.put(PmpPayConst.PMP_AMOUNT, pmputils.fenToYuan(rnt.get("refund_fee"))==null?null: pmputils.fenToYuan(rnt.get("refund_fee"))+ "");//将金额由分转成元
				data.put(PmpPayConst.PMP_TRADE_NO, rnt.get("out_refund_no"));
				data.put(PmpPayConst.PMP_ORDER_NO, rnt.get("out_trade_no"));
				data.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get("refund_id"));
			}else {
				int status=WXReFundErrorCode2.getTradeFailStatus(rnt.get(WXCommonRntParamCode2.ERR_CODE));
                if(status==TradeStatusEnum.REFUND_FAIL) {
                	data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
                }else {
                	data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
                }
                data.put(PmpPayConst.PMP_ERR_CODE, rnt.get("err_code"));
        		data.put(PmpPayConst.PMP_ERR_MSG, rnt.get("err_code_des"));
			}
		}else {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
			data.put(PmpPayConst.PMP_ERR_MSG, rnt.get(WXCommonRntParamCode2.RETURN_MSG));
		}
		for (Map.Entry<String, String> entry : rnt.entrySet()) {
//			  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			data.put(entry.getKey(), entry.getValue());
		}
		PmpPayLogUtils.info("[2]PMP_YxWxDataConvert_RefundRntConvert, 出参: "+(data==null?"data为null":YxPayUtils.m2json2(data)));
		return data;
	}

	@Override
	public void setTradeVal(TradeDO t, Map<String, String> m, FDouble fee, OrdRstDTO rnt) throws BizException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChlBillItemDO str2BillItem(String str, String sd_chl, FDate dt, Map<String, Object> map)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getBillItemParam(FDate dt) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getChlCode() {
		// TODO Auto-generated method stub
		return "pay.yx.wx.0008";
	}

}
