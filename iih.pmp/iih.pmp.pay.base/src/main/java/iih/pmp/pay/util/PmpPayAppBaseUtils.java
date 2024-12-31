package iih.pmp.pay.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import iih.pmp.pay.i.IPmpPayService;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ord.i.IOrdCudService;
import iih.pmp.pay.ord.i.IOrdRService;
import iih.pmp.pay.ordqryrstdto.d.CmbcBillTypeEnum;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.CmbcSceneEnum;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.i.ITradeCudService;
import iih.pmp.pay.trade.i.ITradeRService;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.WXParamUtils2.RFQueryRNTParamConst2;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class PmpPayAppBaseUtils {

	/**
	 * 获得系统环境变量 MM
	 * 
	 * @return
	 */
	public Context getEnvContext() {
		return Context.get();
	}

	/***
	 * 获得服务器日期时间
	 * 
	 * @return
	 */
	public FDateTime getServerDateTime() {
		TimeService ts = (TimeService) ServiceFinder.find(TimeService.class.getName());
		return ts.getUFDateTime();
	}

	/**
	 * 金额由元转成分
	 * 
	 * @param amount
	 * @return
	 */
	public String Yuan2Fen(FDouble amount) {
		return amount.setScale(2, FDouble.ROUND_HALF_UP).multiply(new FDouble(100, 0), 0).toString();
	}

	/**
	 * 金额由元转成分
	 * 
	 * @param amount
	 * @return
	 */
	public String Yuan2Fen2(String amount) {
		FDouble amountDouble = new FDouble(amount);
		return Yuan2Fen(amountDouble);
	}

	/**
	 * 将分转换成元
	 * 
	 * @param total_fee
	 * @return
	 */
	public FDouble fenToYuan(String totalFee) {
		if (isStrEmpty(totalFee))
			return null;

		FDouble totalFeeDouble = new FDouble(totalFee, 0);
		totalFeeDouble = totalFeeDouble.div(new FDouble(100), 2);
		return totalFeeDouble;
	}

	/**
	 * 金额字符串转FDouble
	 * 
	 * @param total_fee
	 * @return
	 */
	public FDouble strToYuan(String total_fee) {
		if (isStrEmpty(total_fee))
			return null;
		return new FDouble(total_fee, 2);
	}

	/**
	 * FDouble转金额字符串
	 * 
	 * @param totalFee
	 * @return
	 */
	public String yuanToStr(FDouble totalFee) {
		return totalFee.setScale(2, FDouble.ROUND_HALF_UP).toString();
	}

	/**
	 * 交易查询服务
	 * 
	 * @return
	 */
	public ITradeRService getTradeRService() {
		return ServiceFinder.find(ITradeRService.class);
	}

	/**
	 * 交易增删改服务
	 * 
	 * @return
	 */
	public ITradeCudService getTradeCUDService() {
		return ServiceFinder.find(ITradeCudService.class);
	}

	/**
	 * 订单查询服务
	 * 
	 * @return
	 */
	public IOrdRService getOrdRService() {
		return ServiceFinder.find(IOrdRService.class);
	}

	/**
	 * 订单增删改服务
	 * 
	 * @return
	 */
	public IOrdCudService getOrdCudService() {
		return ServiceFinder.find(IOrdCudService.class);
	}

	/**
	 * 获取时间戳
	 * 
	 * @return
	 */
	public String getTimeStamp() {
//		FDateTime f = getServerDateTime();
//		return f.getMillisAfter(new FDateTime("1970-01-01 0:0:0"))+"";
		return System.currentTimeMillis() + "";
	}

	public IPmpPayService getPmpPayService() {
		return ServiceFinder.find(IPmpPayService.class);
	}

	/**
	 * 判断FDouble的值是否相等
	 * 
	 * @param val1
	 * @param val2
	 * @return
	 */
	public boolean isFDoubleEq(FDouble val1, FDouble val2) {
		return isDoubleEq(val1.toDouble(), val2.toDouble());
	}

	public boolean isDoubleEq(Double val1, Double val2) {
		if (Double.doubleToLongBits(val1) == Double.doubleToLongBits(val2)) {
			return true;
		} else {
			return false;
		}
	}

	public Double getdouble(Object o) {
		if (o == null)
			return null;
		return Double.parseDouble(o.toString());
	}

	public boolean isDatetimeEqual(FDateTime t1, FDateTime t2) {
		if (t1.compareTo(t2) == 0)
			return true;
		return false;
	}

	final static BASE64Encoder encoder = new BASE64Encoder();

	/**
	 * 字符串base64编码
	 * 
	 * @param str
	 * @return
	 */
	public String getBase64Str(String str) {
		if (str == null)
			return null;
		return encoder.encode(str.getBytes());
	}

	public String getBase64Str(byte[] data) {
		if (data == null)
			return null;
		return encoder.encode(data);
	}

	public String getTransDate(FDateTime date, String format) {
		DateFormat format1 = new SimpleDateFormat(format);
		String d = format1.format(date.getDate().toDate());
		return d;
	}

	public String getTransDate(FDate date, String format) {
		DateFormat format1 = new SimpleDateFormat(format);
		String d = format1.format(date.toDate());
		return d;
	}

	public String getOrdErrMsg(OrdReqDTO ordReqDTO, String msg) {
		return "人员ID:" + ordReqDTO.getId_user_req() + ",订单号：" + ordReqDTO.getOrd_no() + " " + msg;
	}
	
	public String getOrdErrMsg(String orderNo, String msg) {
		return "订单号：" + orderNo + " " + msg;
	}

	/**
	 * 根据订单查询支付交易数据，按交易请求时间排序
	 * 
	 * @param ord
	 * @return
	 * @throws BizException
	 */
	public TradeDO[] getTradeDO8ord(OrdDO ord) throws BizException {
		TradeDO[] tras = getTradeRService().find(
				TradeDO.ID_ORD + " = '" + ord.getId_ord() + "' and eu_direct=" + PmpPayConst.TRADE_DIRECT_PAY, "dt_req",
				FBoolean.FALSE);
		return tras;
	}

	/**
	 * 根据外部订单号和退款单号查询退款交易
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public TradeDO[] getRefundTradeDO8ord(OrdReqDTO dto) throws BizException {
		String wherePart = String.format("%s = ? and %s = ? and %s = %s", TradeDO.REFUND_REQ_NO, TradeDO.ORD_NO,
				TradeDO.EU_DIRECT, PmpPayConst.TRADE_DIRECT_REFUND);
		SqlParamDTO sqlParamDTO = new SqlParamDTO();
		sqlParamDTO.addParam(dto.getRefund_req_no());
		sqlParamDTO.addParam(dto.getOrd_no());
		TradeDO[] tras = getTradeRService().find2(wherePart, sqlParamDTO, "dt_req", FBoolean.FALSE);
//		TradeDO[] tras = getTradeRService().find(TradeDO.REFUND_REQ_NO + " ='" + dto.getRefund_req_no() + "' and "
//				+ TradeDO.ORD_NO + "='" + dto.getOrd_no() + "' and eu_direct=" + PmpPayConst.TRADE_DIRECT_REFUND
//				+ " and " + TradeDO.ID_EMP_OP + "='" + getId_Stuff(dto.getId_user_req()) + "'", "dt_req",
//				FBoolean.FALSE);
		return tras;
	}

	/**
	 * 根据外部订单号和退款单号查询退款交易
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public TradeDO[] getRefundTradeDO(OrdDO ord, OrdReqDTO dto) throws BizException {
		TradeDO[] tras = getTradeRService().find(
				TradeDO.REFUND_REQ_NO + " ='" + dto.getRefund_req_no() + "' and " + TradeDO.ID_ORD + "='"
						+ ord.getId_ord() + "' and eu_direct=" + PmpPayConst.TRADE_DIRECT_REFUND,
				"dt_req", FBoolean.FALSE);
		return tras;
	}

	public OrdQryRstDTO ord2qryrst(OrdDO ord) {

		OrdQryRstDTO rst = new OrdQryRstDTO();
		rst.setAmount(ord.getAmount());
		rst.setAmount_bk(ord.getAmount_bk());
		rst.setDt_ord(ord.getDt_ord());
		rst.setBody(ord.getBody());
		rst.setOrd_no(ord.getOrd_no());
		rst.setOrd_status(ord.getOrd_status());
		if (ord.getAmount_bk().getDouble() < ord.getAmount().getDouble()
				&& ord.getOrd_status().equals(OrdStatusEnum.PAID)) {
			rst.setOrd_status(OrdStatusEnum.TURN_REFUND);
			rst.setErr_code_des("订单转入退款！");
		}
		rst.setSubject(ord.getSubject());
		rst.setDt_pay(ord.getDt_pay());
		return rst;
	}

	final static BASE64Decoder decoder = new BASE64Decoder();

	public String Base64Decode(String encodeText) {
		String result = null;
		try {

			result = new String(decoder.decodeBuffer(encodeText));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public byte[] Base64Decodeb(String encodeText) {
		byte[] result = null;
		try {
			result = decoder.decodeBuffer(encodeText);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public OrdQryRstDTO[] tra2Rst(TradeDO tra) {
		if (tra == null)
			return null;
		OrdQryRstDTO qrst = new OrdQryRstDTO();
		qrst.setTrade_no(tra.getTrade_no());
		qrst.setRefund_fee(tra.getAmount());
		qrst.setTrade_status(tra.getTrade_status());
		qrst.setRefund_no(tra.getRefund_req_no());
		qrst.setBankorderno(tra.getBankorderno());
		qrst.setTrade_no_chl(tra.getTrade_no_chl());
		qrst.setOrd_no(tra.getOrd_no());
		return new OrdQryRstDTO[] { qrst };
	}

	public void OrdQryRstcopy(OrdQryRstDTO src, OrdQryRstDTO des) {

		des.setTrade_no(src.getTrade_no());
		des.setTradetime(src.getTradetime());
		des.setBiz_status(src.getBiz_status());
		des.setErr_code(src.getErr_code());
		des.setErr_code_des(src.getErr_code_des());
		des.setBankorderno(src.getBankorderno());
		des.setTrade_no_chl(src.getTrade_no_chl());
		des.setBanktradeno(src.getBanktradeno());
		des.setMch_order_no(src.getMch_order_no());
		des.setTrade_status(src.getTrade_status());
		des.setTradetype(src.getTradetype());
		des.setTrade_amount(src.getTrade_amount());
		des.setBankno(src.getBankno());
		if (des.getOrd_status() == OrdStatusEnum.TURN_REFUND) {
			des.setErr_code_des("订单转入退款！" + des.getErr_code_des());
		}
		if (des.getOrd_status() == OrdStatusEnum.REVERSE) {
			des.setErr_code_des("订单已撤回！" + des.getErr_code_des());
		}

	}

	public String getCmbcSence(String billtype) {
		if (CmbcBillTypeEnum.WX.equals(billtype)) {
			return CmbcSceneEnum.WXSCAN;
		} else if (CmbcBillTypeEnum.ZFB.equals(billtype)) {
			return CmbcSceneEnum.ZFBSCAN;
		} else {
			return null;
		}
	}

	/**
	 * 支付成功时，交易数据回写
	 * 
	 * @param t
	 * @param m
	 * @param fee
	 * @param rnt
	 */
	public void setTradeAndRntVal(TradeDO t, Map<String, String> m, FDouble fee, OrdRstDTO rnt) {
		String Banktradeno = m.get(PmpPayConst.PMP_TRADE_NO);
		String Trade_no_chl = m.get(PmpPayConst.PMP_TRADE_CHL_NO);
		String bandorderno = m.get(PmpPayConst.PMP_ORDER_NO);
		String channelcode = m.get(PmpPayConst.PMP__CHL_CODE);
		String payMode = m.get(PmpPayConst.PMP__YX_PAYMODE);
		String bankno = m.get(PmpPayConst.PMP_BANKNO);
		if (!isStrEmpty(Banktradeno) && !Banktradeno.equals(t.getBanktradeno())) {
			t.setBanktradeno(Banktradeno);
			t.setStatus(DOStatus.UPDATED);
		}
		if (!isStrEmpty(Trade_no_chl) && !Trade_no_chl.equals(t.getTrade_no_chl())) {
			t.setTrade_no_chl(Trade_no_chl);
			t.setStatus(DOStatus.UPDATED);
		}
		if (!isStrEmpty(bandorderno) && !bandorderno.equals(t.getBankorderno())) {
			t.setBankorderno(bandorderno);
			t.setStatus(DOStatus.UPDATED);
		}
		if (fee != null && !isFDoubleEq(t.getAmount(), fee)) {
			t.setAmount(fee);
			t.setStatus(DOStatus.UPDATED);
		}
		if (!isStrEmpty(channelcode) && !channelcode.equals(t.getTradetype())) {
			t.setTradetype(channelcode);
			t.setStatus(DOStatus.UPDATED);
		}
		if (!isStrEmpty(payMode) && !payMode.equals(t.getPaymode())) {
			t.setPaymode(payMode);
			t.setStatus(DOStatus.UPDATED);
		}
		rnt.setBanktradeno(Banktradeno);
		rnt.setBankorderno(bandorderno);
		rnt.setTrade_no_chl(Trade_no_chl);
		rnt.setTradetype(t.getTradetype());
		rnt.setBankno(bankno);
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public boolean isStrEmpty(String str) {
		if (str == null || str.trim().equals(""))
			return true;
		return false;
	}

	/**
	 * 判空
	 * 
	 * @param s
	 * @param dt
	 * @return
	 */
	public String getTimeSpanSql(String s, FDate dt) {
		String start = getTransDate(dt, "yyyy-MM-dd");
		String end = getTransDate(dt.getDateAfter(1), "yyyy-MM-dd");
		return s + ">='" + start + "' and " + s + "<'" + end + "'";
	}

	/**
	 * 判空
	 * 
	 * @param s
	 * @param dt
	 * @return
	 */
	public String getTimeSpanSql2(String s, FDate startDate, FDate endDate) {
		String start = getTransDate(startDate, "yyyy-MM-dd");
		String end = getTransDate(endDate.getDateAfter(1), "yyyy-MM-dd");
		return s + ">='" + start + "' and " + s + "<'" + end + "'";
	}

	/**
	 * 通过条码判断支付类型是支付宝还是微信
	 * 
	 * @param authorcode
	 * @return
	 */
	public String getCmbcSence8Authorcode(String authorcode) {
		if (isStrEmpty(authorcode))
			return null;
		if (authorcode.startsWith("25") || authorcode.startsWith("26") || authorcode.startsWith("27")
				|| authorcode.startsWith("28") || authorcode.startsWith("29") || authorcode.startsWith("30")) {
			if (authorcode.trim().length() >= 16 && authorcode.trim().length() <= 24) {
				return CmbcSceneEnum.ZFBSCAN;
			}
		}
		if (authorcode.startsWith("10") || authorcode.startsWith("11") || authorcode.startsWith("12")
				|| authorcode.startsWith("13") || authorcode.startsWith("14") || authorcode.startsWith("15")) {
			if (authorcode.trim().length() == 18) {
				return CmbcSceneEnum.WXSCAN;
			}
		}
		return null;
	}

	public void setOrdNotExistErrCode(TradeDO t, String err_code) {
		if (err_code != null && err_code.equals(PmpPayConst.PMP_ORD_NOT_EXIST)) {
			t.setErr_code(PmpPayConst.PMP_ORD_NOT_EXIST);
			t.setStatus(DOStatus.UPDATED);
		}
	}

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
			if (key.contains(RFQueryRNTParamConst2.OUT_REFUND_NO)) {
				r.put(RFQueryRNTParamConst2.OUT_REFUND_NO, key);
			} else if (key.contains(RFQueryRNTParamConst2.REFUND_FEE)) {
				r.put(RFQueryRNTParamConst2.REFUND_FEE, key);
			} else if (key.contains(RFQueryRNTParamConst2.REFUND_ID)) {
				r.put(RFQueryRNTParamConst2.REFUND_ID, key);
			} else if (key.contains(RFQueryRNTParamConst2.REFUND_STATUS)) {
				r.put(RFQueryRNTParamConst2.REFUND_STATUS, key);
			}
		}
		return r;
	}

	public String getTradeTypeErrMsg(String tradetype) {
		if (tradetype != null)
			switch (tradetype) {
			case CmbcSceneEnum.ZFBSCAN:
				return "请使用支付宝付钱码进行支付！";
			case CmbcSceneEnum.WXSCAN:
				return "请使用微信付钱码进行支付！";
			}
		return "支付方式与条码号不匹配！";
	}

}
