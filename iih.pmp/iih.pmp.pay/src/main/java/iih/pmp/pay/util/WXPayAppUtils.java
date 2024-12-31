package iih.pmp.pay.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.WXParamUtils.RFQueryRNTParamConst;
import wxpay.sdk.WXPayConfig;
import wxpay.sdk.WXPayConstants;
import wxpay.sdk.WXPayConstants.SignType;
import wxpay.sdk.WXPayUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public class WXPayAppUtils {
	PmpPayAppBaseUtils utils = new PmpPayAppBaseUtils();

	/**
	 * 生成订单数据
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public OrdDO createOrdDo(OrdReqDTO dto) throws BizException {
		if (StringUtils.isBlank(dto.getId_user_req())) {
			throw new BizException("请求用户不允许为空");
		}
		
		OrdDO ord = new OrdDO();
		String code = PmpPayAppUtils.getOrderCode();
		if (code == null)
			return null;
		ord.setCode(code);
		ord.setBody(dto.getBody());
		ord.setSubject(dto.getSubject());
		ord.setAmount(dto.getAmount());
		ord.setAmount_bk(dto.getAmount());
		ord.setOrd_no(dto.getOrd_no());
		ord.setDt_ord(utils.getServerDateTime());
		ord.setOrd_status(OrdStatusEnum.UNKNOWN);
		ord.setId_chl(PmpPayConst.getUdiID(PmpPayConst.WXPAY_CHANNEL_CODE, PmpPayConst.CHANNEL_DOCLIST_ID));
		ord.setSd_chl(PmpPayConst.WXPAY_CHANNEL_CODE);
		ord.setSd_scene(dto.getSd_scene());
		ord.setId_scene(PmpPayConst.getUdiID(dto.getSd_scene(), PmpPayConst.SCENE_DOCLIST_ID));
		ord.setSpbill_create_ip(dto.getSpbill_create_ip());
		ord.setId_emp_op(dto.getId_user_req());
//		ord.setId_emp_op(utils.getId_Stuff(null));// ????自助机或his是否也能获取
		ord.setId_org(utils.getEnvContext().getOrgId());// ????自助机或his是否也能获取
		ord.setId_grp(utils.getEnvContext().getGroupId());
		ord.setStatus(DOStatus.NEW);
		OrdDO[] ordarr = utils.getOrdCudService().save(new OrdDO[] { ord });
		if (ordarr != null && ordarr.length > 0)
			return ordarr[0];
		return null;
	}

	/**
	 * 微信生成交易数据
	 * 
	 * @param ord
	 * @param fg_precreated
	 * @return
	 * @throws BizException
	 */
	public TradeDO createPayTradeDo(OrdDO ord, FBoolean fg_precreated, OrdReqDTO dto) throws BizException {
		if (StringUtils.isBlank(dto.getId_user_req())) {
			throw new BizException("请求用户不允许为空");
		}

		TradeDO tra = new TradeDO();
		tra.setAmount(dto.getAmount());
		String code = PmpPayAppUtils.getTradeCode();
		if (code == null)
			return null;
		tra.setSd_ord(ord.getCode());
		tra.setTrade_no(code);
		tra.setId_emp_op(dto.getId_user_req());
//		tra.setId_emp_op(utils.getId_Stuff(null));// ????自助机或his是否也能获取
		tra.setId_org(utils.getEnvContext().getOrgId());// ????自助机或his是否也能获取
		tra.setId_grp(utils.getEnvContext().getGroupId());
		tra.setBody(dto.getBody());
		tra.setDt_req(utils.getServerDateTime());
		tra.setId_ord(ord.getId_ord());
		tra.setEu_direct(PmpPayConst.TRADE_DIRECT_PAY);
		tra.setSubject(dto.getSubject());
		tra.setTrade_status(TradeStatusEnum.TRADE_UNKNOWN);
		tra.setFg_precreate(fg_precreated);
		tra.setId_chl(PmpPayConst.getUdiID(PmpPayConst.WXPAY_CHANNEL_CODE, PmpPayConst.CHANNEL_DOCLIST_ID));
		tra.setSd_chl(PmpPayConst.WXPAY_CHANNEL_CODE);
		tra.setOrd_no(dto.getOrd_no());
		tra.setSd_scene(dto.getSd_scene());
		tra.setId_scene(PmpPayConst.getUdiID(dto.getSd_scene(), PmpPayConst.SCENE_DOCLIST_ID));
		tra.setStatus(DOStatus.NEW);
//		TradeDO[] tras=PmpPayAppUtils.getTradeRService().find(" Trade_no='"+code+"'", "", FBoolean.FALSE);
//		if(tras!=null&&tras.length>0)return null;
		TradeDO[] trs = utils.getTradeCUDService().save(new TradeDO[] { tra });
		if (trs != null && trs.length > 0)
			return trs[0];
		return null;
	}

	public TradeDO createReFundTradeDo(OrdDO ord, OrdReqDTO dto, TradeDO reltrade) throws BizException {
		if (StringUtils.isBlank(dto.getId_user_req())) {
			throw new BizException("请求用户不允许为空");
		}

		TradeDO tra = new TradeDO();
		String code = PmpPayAppUtils.getTradeCode();
		if (code == null)
			return null;
		tra.setSd_ord(ord.getCode());
		tra.setTrade_no(code);
		tra.setAmount(dto.getAmount());
		tra.setRefund_req_no(dto.getRefund_req_no());
		tra.setId_emp_op(dto.getId_user_req());
		tra.setId_refund_user(dto.getId_user_req());
//		tra.setId_emp_op(utils.getId_Stuff(dto.getId_user_req()));
//		tra.setId_refund_user(utils.getId_Stuff(null));// ????自助机或his是否也能获取
		tra.setId_org(utils.getEnvContext().getOrgId());// ????自助机或his是否也能获取
		tra.setId_grp(utils.getEnvContext().getGroupId());
		tra.setDt_req(utils.getServerDateTime());
		tra.setId_ord(ord.getId_ord());
		tra.setEu_direct(PmpPayConst.TRADE_DIRECT_REFUND);
		tra.setTrade_status(TradeStatusEnum.TRADE_UNKNOWN);
		tra.setTrade_no_rel(reltrade.getTrade_no());
		tra.setId_chl(PmpPayConst.getUdiID(PmpPayConst.WXPAY_CHANNEL_CODE, PmpPayConst.CHANNEL_DOCLIST_ID));
		tra.setSd_chl(PmpPayConst.WXPAY_CHANNEL_CODE);
		tra.setOrd_no(dto.getOrd_no());
		tra.setId_scene(PmpPayConst.getUdiID(reltrade.getSd_scene(), PmpPayConst.SCENE_DOCLIST_ID));
		tra.setSd_scene(reltrade.getSd_scene());
		tra.setBody(reltrade.getBody());
		tra.setSubject(reltrade.getSubject());
		tra.setStatus(DOStatus.NEW);
//		TradeDO[] tras=PmpPayAppUtils.getTradeRService().find(" Trade_no='"+code+"'", "", FBoolean.FALSE);
//		if(tras!=null&&tras.length>0)return null;
		TradeDO[] trs = utils.getTradeCUDService().save(new TradeDO[] { tra });
		if (trs != null && trs.length > 0)
			return trs[0];
		return null;
	}

	/**
	 * 生成退款交易
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public TradeDO createReFundTradeDo(OrdReqDTO dto, OrdDO ord) throws BizException {

		TradeDO[] tras = utils.getTradeRService().find(TradeDO.ID_ORD + " ='" + ord.getId_ord() + "' and eu_direct="
				+ PmpPayConst.TRADE_DIRECT_PAY + " and trade_status=1 ", null, FBoolean.FALSE);
		if (tras == null || tras.length == 0)
			return null;
		return createReFundTradeDo(ord, dto, tras[0]);
	}

	public OrdDO getPaidOrdDO(OrdReqDTO dto) throws BizException {
//		OrdDO[] ords = utils.getOrdRService().find(" ord_no='" + dto.getOrd_no()
//				+ "' and id_emp_op='"
//				+ utils.getId_Stuff(dto.getId_user_req()) + "' ", null,
//				FBoolean.FALSE);
		OrdDO[] ords = utils.getOrdRService().findByAttrValString(OrdDO.ORD_NO, dto.getOrd_no());
		if (ords == null || ords.length == 0)
			throw new BizException("未查询到已支付的订单");
		if (ords.length > 1)
			throw new BizException("查询到多条订单记录");
//		if(ords[0].getAmount_bk().getDouble()<dto.getAmount().getDouble())return null;
		return ords[0];
	}

	/**
	 * 生成公众号返回数据，默认签名方式是HMACSHA256
	 * 
	 * @param reqData
	 * @param config
	 * @throws Exception
	 */
	public void fillRSTData(Map<String, String> reqData, WXPayConfig config) throws Exception {
		reqData.put("appId", config.getAppID());
		reqData.put("timeStamp", utils.getTimeStamp());
		reqData.put("nonceStr", WXPayUtil.generateUUID());
		reqData.put("signType", WXPayConstants.HMACSHA256);// 仿真测试环境使用md5,真实环境使用HMACSHA256
		reqData.put("paySign", WXPayUtil.generateSignature(reqData, config.getKey(), SignType.HMACSHA256));
	}

	public void HandleExInfo(OrdRstDTO rst, String sd_scene, WXPayConfig config) throws Exception {

		if (PmpPayConst.PUBLICPAU_SCENE_CODE.equals(sd_scene)) {
			Map<String, String> reqData = new HashMap<>();
			reqData.put("package", "prepay_id=" + rst.getPrepay_id());
			fillRSTData(reqData, config);
			rst.setTimestamp(reqData.get("timeStamp"));
			rst.setNoncestr(reqData.get("nonceStr"));
			rst.setSigntype(reqData.get("signType"));
			rst.setSign(reqData.get("paySign"));
			rst.setPackage(reqData.get("package"));
		}
	}

	/**
	 * 处理参数名带下标的情况
	 * 
	 * @param reqData
	 * @return
	 */

	public Map<String, String> HandleRntParam(Map<String, String> reqData) {
		Map<String, String> r = new HashMap<>();
		for (Map.Entry<String, String> entry : reqData.entrySet()) {
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			if (key.contains("$")) {
				int j = key.indexOf("$");
				String keyex = key.substring(0, j - 2);
				r.put(keyex, value);
			} else {
				r.put(key, value);
			}
		}
		return r;
	}

	/**
	 * 处理参数名带下标的情况
	 * 
	 * @param reqData
	 * @return
	 */
	public String getStatusName(Map<String, String> reqData) {
//		Map<String, String> r = new HashMap<>();
		for (Map.Entry<String, String> entry : reqData.entrySet()) {
			String key = entry.getKey().toString();
//			String value = entry.getValue().toString();
			if (key.contains(RFQueryRNTParamConst.REFUND_STATUS)) {
				return key;
			}
		}
		return null;
	}

	public void setOrdState(TradeDO t, OrdDO o) {
		if (t.getTrade_status().equals(TradeStatusEnum.TRADE_UNKNOWN)) {
			o.setOrd_status(OrdStatusEnum.UNKNOWN);
		} else if (t.getTrade_status().equals(TradeStatusEnum.PAY_WAIT)) {
			o.setOrd_status(OrdStatusEnum.WAIT_TO_PAY);
		} else if (t.getTrade_status().equals(TradeStatusEnum.PAY_SUCCESS)) {
//			o.setAmount(t.getAmount());
			o.setDt_pay(utils.getServerDateTime());
			o.setOrd_status(OrdStatusEnum.PAID);
		} else {
			o.setOrd_status(OrdStatusEnum.FAIL);
		}

	}

	public void updateOrdStatus(OrdDO o, int ordstatus) {
		if (!o.getOrd_status().equals(ordstatus)) {
			o.setOrd_status(ordstatus);
			o.setStatus(DOStatus.UPDATED);
		}
	}

	public void updateTradeStatusnew(TradeDO t, int tradestatus) {
		if (!t.getTrade_status().equals(tradestatus)) {
			t.setTrade_status(tradestatus);
			t.setStatus(DOStatus.UPDATED);
		}
	}

	public OrdDO updateOrdStatus(OrdDO o) throws BizException {
		OrdDO ord = utils.getOrdRService().findById(o.getId_ord());
		OrdDO[] ords = null;
		if (!o.getOrd_status().equals(ord.getOrd_status())
				|| !utils.isFDoubleEq(ord.getAmount_bk(), o.getAmount_bk())) {
			ord.setOrd_status(o.getOrd_status());
			ord.setAmount_bk(o.getAmount_bk());
			ord.setStatus(DOStatus.UPDATED);
			ords = utils.getOrdCudService().update(new OrdDO[] { ord });
			return ords[0];
		} else {
			return ord;
		}

	}

	public void updateOrdStatus2(OrdDO o, int ordstatus) throws BizException {
		if (!o.getOrd_status().equals(ordstatus)) {
			o.setOrd_status(ordstatus);

			o.setStatus(DOStatus.UPDATED);
		}
	}

	/**
	 * 设置订单上的可退款金额
	 * 
	 * @param o
	 * @param ordstatus
	 * @param total_fee
	 * @param refund_fee
	 * @throws BizException
	 */
	public void updateOrdStatus2(OrdDO o, int ordstatus, String refund_fee) {
//		FDouble fee = o.getAmount();
		FDouble refund_f = utils.fenToYuan(refund_fee);
		FDouble fee_bk = o.getAmount().sub(refund_f);
		if (!o.getOrd_status().equals(ordstatus) || !utils.isFDoubleEq(o.getAmount_bk(), fee_bk)) {
			o.setOrd_status(ordstatus);
			o.setAmount_bk(fee_bk);
			o.setStatus(DOStatus.UPDATED);
		}
	}

	public void updateOrdStatus(OrdDO o, int ordstatus, FDouble refund_fee, String tradetype) {
//		FDouble fee = o.getAmount();
		FDouble fee_bk = null;
		if (refund_fee != null) {
			FDouble refund_f = refund_fee;
			fee_bk = o.getAmount().sub(refund_f);
		}
		if (!o.getOrd_status().equals(ordstatus)) {
			o.setOrd_status(ordstatus);
			o.setStatus(DOStatus.UPDATED);
		}
		if (fee_bk != null && !utils.isFDoubleEq(o.getAmount_bk(), fee_bk)) {
			o.setAmount_bk(fee_bk);
			o.setStatus(DOStatus.UPDATED);
		}
		if (!utils.isStrEmpty(tradetype) && !tradetype.equals(o.getTradetype())) {
			o.setTradetype(tradetype);
			o.setStatus(DOStatus.UPDATED);
		}
	}

	public void updateTradeStatusnew(TradeDO t, int tradestatus, String total_fee) {
		FDouble fee = utils.fenToYuan(total_fee);
		if (!t.getTrade_status().equals(tradestatus) || !utils.isFDoubleEq(fee, t.getAmount())) {
			t.setTrade_status(tradestatus);
			t.setAmount(fee);
			t.setStatus(DOStatus.UPDATED);
		}
	}

	public void updateTradeStatusnew(TradeDO t, int tradestatus, FDouble fee) {
		if (!t.getTrade_status().equals(tradestatus)) {
			t.setTrade_status(tradestatus);
			t.setStatus(DOStatus.UPDATED);
		}
		if (fee != null && !utils.isFDoubleEq(fee, t.getAmount())) {

			t.setAmount(fee);
			t.setStatus(DOStatus.UPDATED);
		}
	}
//	public void setTradeVal(TradeDO t,String other_trade_no,String trade_no_chl,FDouble fee) {
//		if((other_trade_no!=null&&!other_trade_no.equals(t.getBanktradeno()))||(trade_no_chl!=null&&!trade_no_chl.equals(t.getTrade_no_chl()))||!utils.isFDoubleEq(t.getAmount(), fee)) {
//			t.setBanktradeno(other_trade_no);
//			t.setTrade_no_chl(trade_no_chl);
//			t.setAmount(fee);
//			t.setStatus(DOStatus.UPDATED);
//		}
//	}

	/**
	 * 处理参数名带下标的情况
	 * 
	 * @param reqData
	 * @return
	 */
	public Map<String, String> GetRntParam2(Map<String, String> reqData) {
		Map<String, String> r = new HashMap<>();
		for (Map.Entry<String, String> entry : reqData.entrySet()) {
			String key = entry.getKey().toString();
			if (key.contains(RFQueryRNTParamConst.OUT_REFUND_NO)) {
				r.put(RFQueryRNTParamConst.OUT_REFUND_NO, key);
			} else if (key.contains(RFQueryRNTParamConst.REFUND_FEE)) {
				r.put(RFQueryRNTParamConst.REFUND_FEE, key);
			} else if (key.contains(RFQueryRNTParamConst.REFUND_ID)) {
				r.put(RFQueryRNTParamConst.REFUND_ID, key);
			} else if (key.contains(RFQueryRNTParamConst.REFUND_STATUS)) {
				r.put(RFQueryRNTParamConst.REFUND_STATUS, key);
			}
		}
		return r;
	}

}
