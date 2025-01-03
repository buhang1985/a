package iih.pmp.yxpaySDK.unify;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.yxpaySDK.bp.YxPayConfig;
import iih.pmp.yxpaySDK.bp.YxPayUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.bdfw.bbd.i.IPsndocRService;
import xap.sys.xbd.paramset.i.ParamsetAccessor;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class YxUnifiedDataConvert   implements IPmpDataconvert{
	
	 PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();

	@Override
	public Map<String, Object> getBarcodeParam(OrdReqDTO dto, OrdDO ord, TradeDO tra) throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("payCode", dto.getAuth_code());
		data.put("branchCode", YxPayConfig.getBranchId());
		data.put("operatorId",dto.getId_user_req());
		data.put("deviceInfo", dto.getDeviceinfo());
		data.put("orderIdHIS", tra.getTrade_no());
		if("API_WXSCAN".equals(tra.getTradetype())||"API_ZFBSCAN".equals(tra.getTradetype())) {
		data.put("payMode", "1");
		}else if("API_POS".equals(tra.getTradetype())){
		data.put("payMode", "301");
		data.put("deviceInfo", Context.get().getClientHost());
		
		}
		data.put("payType", pmputils.isStrEmpty(dto.getBiz_scene())?"02":dto.getBiz_scene());
		data.put("payAmout", pmputils.Yuan2Fen(tra.getAmount()));
		data.put("accountAmout", "0");
		data.put("medicareAmout", "0");
		data.put("totalAmount", pmputils.Yuan2Fen(tra.getAmount()));
		
		IPsndocMDORService service =ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO ps = service.findById(tra.getId_emp_op());
		data.put("operatorName", ps.getName());
		if(!pmputils.isStrEmpty(dto.getId_pat())) {
			IPatiMDORService  ipat=ServiceFinder.find(IPatiMDORService.class);
			PatDO p=ipat.findById(dto.getId_pat());
			if(p!=null) {
				data.put("patinetName", p.getName());
				data.put("patinetID", p.getCode());
				data.put("patinetMobile", p.getMob());
				data.put("patinetIdNo", p.getId_code());
			}else {
				throw new BizException("id_pat查无此患者！");
			}
		}else {
			throw new BizException("请传入id_pat！");
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
		data.put("branchCode", YxPayConfig.getBranchId());
		data.put("orderId", tra.getTrade_no_chl());
		data.put("orderIdHIS", tra.getTrade_no());
//		if(!pmputils.isStrEmpty(tra.getTrade_no_chl())) {
//			data.put("orderId", tra.getTrade_no_chl());
//		}else {
//			data.put("orderIdHIS", tra.getTrade_no());
//		}
		return data;
	}

	@Override
	public Map<String, Object> getRefundQueryParam(OrdDO ord, TradeDO tra, TradeDO paidtra) throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("branchCode", YxPayConfig.getBranchId());
		data.put("orderId", tra.getTrade_no_chl());
		data.put("orderIdHIS", tra.getTrade_no());
//		if(!pmputils.isStrEmpty(tra.getTrade_no_chl())) {
//			data.put("orderId", tra.getTrade_no_chl());
//		}else {
//			data.put("orderIdHIS", tra.getTrade_no());
//		}
		return data;
	}

	@Override
	public Map<String, Object> getReFundParam(OrdDO ord, TradeDO tra, OrdReqDTO dto, TradeDO paidtra)
			throws BizException {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("orderId", paidtra.getTrade_no_chl());
		data.put("branchCode", YxPayConfig.getBranchId());
		data.put("orderIdHIS", paidtra.getTrade_no());
		data.put("refundOrderId", tra.getTrade_no());
		data.put("totalAmount", pmputils.Yuan2Fen(paidtra.getAmount()));
		data.put("refundAmount", pmputils.Yuan2Fen(tra.getAmount()));
		data.put("payType", pmputils.isStrEmpty(dto.getBiz_scene())?"02":dto.getBiz_scene());
		data.put("refundTag", "2");
		IPsndocMDORService service =ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO ps = service.findById(tra.getId_emp_op());
		data.put("operatorName", ps.getName());
		data.put("refundReason", "退款");
		data.put("deviceInfo", Context.get().getClientHost());
		return data;
	}

	@Override
	public Map<String, String> BarcodeRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> result = new HashMap<>();
		if(rnt!=null) {
		String resultCode=rnt.get("resultCode");
		if("0".equals(resultCode)) {
			result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
			result.put(PmpPayConst.PMP_ORDER_NO, rnt.get("thirdNum"));
			result.put(PmpPayConst.PMP_TRADE_NO, rnt.get("serialNumber"));
			result.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get("orderId"));
			result.put(PmpPayConst.PMP_AMOUNT, null);
			result.put(PmpPayConst.PMP__YX_PAYMODE, rnt.get("payMode"));
		}else if("1".equals("resultCode")) {
			result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
			result.put(PmpPayConst.PMP_ERR_CODE, YxPayUtils.handleerrcode(rnt.get("failReason")));
			result.put(PmpPayConst.PMP_ERR_MSG, rnt.get("failReason"));
		}else {
			result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
			result.put(PmpPayConst.PMP_ERR_CODE, YxPayUtils.handleerrcode(rnt.get("failReason")));
			result.put(PmpPayConst.PMP_ERR_MSG, rnt.get("failReason"));
		}
		}else {
			result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
			result.put(PmpPayConst.PMP_ERR_CODE, "unknow");
			result.put(PmpPayConst.PMP_ERR_MSG, "unknow");
		}
		return result;
	}

	@Override
	public Map<String, String> QrcodeRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> QueryRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> result = new HashMap<>();
		if(rnt!=null) {
			result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			String resultCode=rnt.get("resultCode");
			if("0".equals(resultCode)) {
				String payStatus=rnt.get("payStatus");
				if("0".equals(payStatus)) {
					//未支付
					result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
					result.put(PmpPayConst.PMP_ERR_MSG, "NOTPAY，未支付");
				}else if("1".equals(payStatus)) {
					//支付成功
					result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
					result.put(PmpPayConst.PMP_ORDER_NO, rnt.get("thirdNum"));
					result.put(PmpPayConst.PMP_TRADE_NO, rnt.get("serialNumber"));
					result.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get("orderId"));
				//	result.put(PmpPayConst.pmp, rnt.get("orderId"));
					result.put(PmpPayConst.PMP_AMOUNT, Double.toString(pmputils.fenToYuan(rnt.get("amount")).getDouble()));
					result.put(PmpPayConst.PMP__YX_PAYMODE, rnt.get("payMode"));
				}else if("2".equals(payStatus)) {
					//支付失败
					result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
					result.put(PmpPayConst.PMP_ERR_MSG, "支付失败！");
				}else if("3".equals(payStatus)) {
					//支付超时
					result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
					result.put(PmpPayConst.PMP_ERR_MSG, "支付超时");
				}else if("8".equals(payStatus)) {
					//交易关闭
					result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
					result.put(PmpPayConst.PMP_ERR_MSG, "交易关闭！");
				}else if("9".equals(payStatus)) {
					//已撤销
					result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
					result.put(PmpPayConst.PMP_ERR_MSG, "支付平台已撤销该交易！");
				}
			}else {
				result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
				result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
				result.put(PmpPayConst.PMP_ERR_CODE, YxPayUtils.handleerrcode(rnt.get("failReason")));
				result.put(PmpPayConst.PMP_ERR_MSG, rnt.get("failReason"));
			}
		}else {
			result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
			result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
		}
		return result;
	}

	@Override
	public Map<String, String> RefundQueryRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> result = new HashMap<>();
		if(rnt!=null) {
			result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			String resultCode=rnt.get("resultCode");
			if("0".equals(resultCode)) {
				String payStatus=rnt.get("payStatus");
				if("4".equals(payStatus)) {
					//退款开始
					result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
					result.put(PmpPayConst.PMP_ORDER_NO, rnt.get("thirdNum"));
					result.put(PmpPayConst.PMP_TRADE_NO, rnt.get("serialNumber"));
					result.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get("orderId"));
					result.put(PmpPayConst.PMP_AMOUNT, Double.toString(pmputils.fenToYuan(rnt.get("amount")).getDouble()));
					result.put(PmpPayConst.PMP_ERR_MSG, "退费开始");
					result.put(PmpPayConst.PMP__YX_PAYMODE, rnt.get("payMode"));
				}else if("5".equals(payStatus)) {
					result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
					result.put(PmpPayConst.PMP_ERR_MSG, "退费超时");
				}else if("6".equals(payStatus)) {
					result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
					result.put(PmpPayConst.PMP_ORDER_NO, rnt.get("thirdNum"));
					result.put(PmpPayConst.PMP_TRADE_NO, rnt.get("serialNumber"));
					result.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get("orderId"));
					result.put(PmpPayConst.PMP_AMOUNT, Double.toString(pmputils.fenToYuan(rnt.get("amount")).getDouble()));
					result.put(PmpPayConst.PMP__YX_PAYMODE, rnt.get("payMode"));
				}else if("7".equals(payStatus)) {
					//退款失败
					result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
					result.put(PmpPayConst.PMP_ERR_MSG, "退款失败！");
				}else if("8".equals(payStatus)) {
					//交易关闭
					result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
					result.put(PmpPayConst.PMP_ERR_MSG, "交易关闭！");
				}
			}else {
				result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
				result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
				result.put(PmpPayConst.PMP_ERR_CODE, YxPayUtils.handleerrcode(rnt.get("failReason")));
				result.put(PmpPayConst.PMP_ERR_MSG, rnt.get("failReason"));
			}
		}else {
			result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
			result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
		}
		return result;
	}

	@Override
	public Map<String, String> RefundRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> result = new HashMap<>();
		if(rnt!=null) {
			String resultCode=rnt.get("resultCode");
			if("0".equals(resultCode)) {
				result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
				result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
				result.put(PmpPayConst.PMP_ORDER_NO, rnt.get("thirdNum"));
				result.put(PmpPayConst.PMP_TRADE_NO, rnt.get("serialNumber"));
				result.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get("refundOrderId"));
				result.put(PmpPayConst.PMP_AMOUNT,  Double.toString(pmputils.fenToYuan(rnt.get("settlementRefundAmount")).getDouble()));
				result.put(PmpPayConst.PMP__YX_PAYMODE, rnt.get("payMode"));
			}else if("1".equals(resultCode)) {
				result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
				result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
				result.put(PmpPayConst.PMP_ERR_CODE, YxPayUtils.handleerrcode(rnt.get("failReason")));
				result.put(PmpPayConst.PMP_ERR_MSG, rnt.get("failReason"));
			}else {
				result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
				result.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
				result.put(PmpPayConst.PMP_ERR_CODE, YxPayUtils.handleerrcode(rnt.get("failReason")));
				result.put(PmpPayConst.PMP_ERR_MSG, rnt.get("failReason"));
			}
		}else {
			result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
			result.put(PmpPayConst.PMP_ERR_CODE, "unknow");
			result.put(PmpPayConst.PMP_ERR_MSG, "unknow");
		}
		return result;
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
		return "pay.yx.unified.0010";
	}
	
	

}
