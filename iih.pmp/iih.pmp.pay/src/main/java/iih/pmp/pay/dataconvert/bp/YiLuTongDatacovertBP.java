package iih.pmp.pay.dataconvert.bp;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.CmbcSceneEnum;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.yilutong.util.ScanPayConst;
import iih.pmp.yilutong.util.YiLuTongParam;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;

/**
 * 医路通数据转换类
 * 
 * @author think
 *
 */
public class YiLuTongDatacovertBP implements IPmpDataconvert {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	@Override
	public Map<String, Object> getBarcodeParam(OrdReqDTO dto, OrdDO ord, TradeDO tra) {
		Map<String, Object> data = new HashMap<String, Object>();
		// 医院id
		data.put("hospital_id", YiLuTongParam.HOSPITAL_ID);
		// 支付授权码
		data.put("auth_code", dto.getAuth_code());
		// 支付金额 格式化为小数点后两位
		FDouble amount = dto.getAmount().setScale(-2, BigDecimal.ROUND_CEILING);
		data.put("order_amount", amount);
		// 业务di
		data.put("biz_id", dto.getTrade_no());
		// 收银员代码 dto中如果为空 从订单do 中取
		if (StringUtil.isEmptyWithTrim(dto.getId_user_req())) {
			data.put("cashier_id", ord.getId_emp_op());
		} else {
			data.put("cashier_id", dto.getId_user_req());
		}
		if (dto.getBiz_scene().equals(IBlDictCodeConst.SD_BIZSCENE_OEP_CHARGE)) {
			data.put("data_src", YiLuTongParam.BIZSCENE_OEP_CHARGE);
		}
		return data;
	}

	@Override
	public Map<String, Object> getReFundParam(OrdDO ord, TradeDO tra, OrdReqDTO dto, TradeDO paidtra) {
		Map<String, Object> data = new HashMap<String, Object>();
		// 医院id
		data.put("hospital_id", YiLuTongParam.HOSPITAL_ID);
		// 订单号
		data.put("trade_no", paidtra.getTrade_no_chl());
		// HIS退款单号
		data.put("his_id", dto.getTrade_no());
		// 支付金额 格式化为小数点后两位
		FDouble amount = dto.getAmount().setScale(-2, BigDecimal.ROUND_CEILING);
		data.put("refund_amount", amount);
		// 收银员代码
		data.put("cashier_id", tra.getId_refund_user());
		return data;
	}

	@Override
	public Map<String, String> BarcodeRntConvert(Map<String, String> rnt) throws BizException {
		Map<String, String> rntmap = this.PayRntConvert(rnt);
		return rntmap;
	}

	@Override
	public Map<String, String> QueryRntConvert(Map<String, String> rnt) throws BizException {
		Map<String, String> rntmap = this.PayRntConvert(rnt);
		return rntmap;
	}

	@Override
	public Map<String, String> RefundQueryRntConvert(Map<String, String> rnt) throws BizException {
		Map<String, String> rntmap = this.ReFundRntConvert(rnt);
		return rntmap;
	}

	@Override
	public Map<String, String> RefundRntConvert(Map<String, String> rnt) throws BizException {
		Map<String, String> rntmap = this.ReFundRntConvert(rnt);
		return rntmap;
	}

	@Override
	public void setTradeVal(TradeDO t, Map<String, String> m, FDouble fee, OrdRstDTO rnt) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, Object> getQueryParam(OrdDO ord, TradeDO tra) {
		Map<String, Object> data = new HashMap<String, Object>();
		// 医院id
		data.put("hospital_id", YiLuTongParam.HOSPITAL_ID);
		// 业务di
		data.put("biz_id", tra.getTrade_no());

		return data;
	}

	@Override
	public Map<String, Object> getRefundQueryParam(OrdDO ord, TradeDO tra,TradeDO paidtra) {
		Map<String, Object> data = new HashMap<String, Object>();
		// 医院id
		data.put("hospital_id", YiLuTongParam.HOSPITAL_ID);
		// 订单号
		data.put("his_id", tra.getTrade_no());
		return data;
	}

	/**
	 * 转化状态编码
	 * 
	 * @param status
	 * @return
	 */
	private String getTradeStatus(String status) {
		if (PmpPayConst.PMP_SUCCESS.equals(status)) {
			return PmpPayConst.PMP_SUCCESS;
		} else if (PmpPayConst.PMP_USERPAYING.equals(status)) {
			return PmpPayConst.PMP_USERPAYING;
		} else if (ScanPayConst.ORDER_STATE_ERROR.equals(status) || ScanPayConst.SYSTEM_ERROR.equals(status)
				|| ScanPayConst.UNKNOW_ERROR.equals(status) || ScanPayConst.ALIPAY_ERROR.equals(status)
				|| ScanPayConst.ALIPAY_ERROR.equals(status) || ScanPayConst.WX_ERROR.equals(status)
				|| ScanPayConst.ORDER_NOT_PAY.equals(status)) {
			return PmpPayConst.PMP_UNKNOW;
		} else if (ScanPayConst.REPEAT_TRADENO.equals(status) || ScanPayConst.REFUNDNO_EXIST.equals(status)) {
			return PmpPayConst.PMP_ERROR;
		} else {
			return PmpPayConst.PMP_ERROR;
		}
	}

	/**
	 * 转化支付方式
	 * 
	 * @param channel
	 * @return
	 */
	private String getPayChl(String channel) {
		if (channel.equals("alipay")) {
			return CmbcSceneEnum.ZFBSCAN;
		} else if (channel.equals("wechat")) {
			return CmbcSceneEnum.WXSCAN;
		}
		return null;
	}

	@Override
	public ChlBillItemDO str2BillItem(String str, String sd_chl, FDate dt, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getBillItemParam(FDate dt) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 返回值转化
	 * 
	 * @param rnt
	 * @return
	 * @throws BizException
	 */
	private Map<String, String> PayRntConvert(Map<String, String> rnt) throws BizException {

		Map<String, String> data = new HashMap<String, String>();
		// 判断签名是否有效

		// 判断接口调用成功
		if (PmpPayConst.PMP_SUCCESS.equals(rnt.get(ScanPayConst.RESULT))) {
			// 向调用结果赋值 结果与状态不一个概念
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			// 向状态赋值
			data.put(PmpPayConst.PMP_TRADE_STATUS, this.getTradeStatus(rnt.get(ScanPayConst.CODE)));
			// 成功
			if (PmpPayConst.PMP_SUCCESS.equals(rnt.get(ScanPayConst.CODE))) {
				// 支付渠道
				data.put(PmpPayConst.PMP__CHL_CODE, this.getPayChl(rnt.get(ScanPayConst.CHANNEL)));
				// 订单号
				data.put(PmpPayConst.PMP_TRADE_NO, rnt.get(ScanPayConst.WT_TRADE_NO));
				data.put(PmpPayConst.PMP_ORDER_NO, rnt.get(ScanPayConst.WT_TRADE_NO));
				// 渠道订单号
				data.put(PmpPayConst.PMP_TRADE_CHL_NO, rnt.get(ScanPayConst.TRADE_NO));
				data.put(PmpPayConst.PMP_AMOUNT, null);//
			}

			// 失败
			else {
				data.put(PmpPayConst.PMP_ERR_CODE, rnt.get(ScanPayConst.CODE));
				data.put(PmpPayConst.PMP_ERR_MSG, rnt.get(ScanPayConst.CODEMESSAGE));

			}
			// 当 result 不是succuss时
		} else {
			data.put(PmpPayConst.PMP_RESULT, rnt.get(ScanPayConst.RESULT));
			data.put(PmpPayConst.PMP_ERR_MSG, rnt.get(ScanPayConst.MESSAGE));
		}

		return data;

	}

	/**
	 * 退款返回值转化
	 * 
	 * @param rnt
	 * @return
	 * @throws BizException
	 */
	private Map<String, String> ReFundRntConvert(Map<String, String> rnt) throws BizException {

		Map<String, String> data = new HashMap<String, String>();
		// 判断签名是否有效

		// 判断接口调用成功
		if (PmpPayConst.PMP_SUCCESS.equals(rnt.get(ScanPayConst.RESULT))) {
			// 向调用结果赋值 结果与状态不一个概念
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			// 向状态赋值
			data.put(PmpPayConst.PMP_TRADE_STATUS, this.getTradeStatus(rnt.get(ScanPayConst.CODE)));
			// 成功
			if (PmpPayConst.PMP_SUCCESS.equals(rnt.get(ScanPayConst.CODE))
					|| PmpPayConst.PMP_USERPAYING.equals(rnt.get(ScanPayConst.CODE))) {
				// 渠道退款单号
				data.put(PmpPayConst.PMP_TRADE_NO, rnt.get(ScanPayConst.REFUND_NO));
				// 退款 订单号
				data.put(PmpPayConst.PMP_ORDER_NO, rnt.get(ScanPayConst.WT_REFUND_NO));
			}

			// 失败
			else {

				data.put(PmpPayConst.PMP_ERR_CODE, rnt.get(ScanPayConst.CODE));
				data.put(PmpPayConst.PMP_ERR_MSG, rnt.get(ScanPayConst.CODEMESSAGE));

			}

		}
		// 当 result 不是succuss时
		else {
			// PmpRefundValidateBP.pmprefundquery 中的方法限制 暂且赋值为success
			if (rnt.get(ScanPayConst.MESSAGE).equals("请求的HIS退款单号不存在!")) {
				data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
				data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
				data.put(PmpPayConst.PMP_ERR_CODE, PmpPayConst.PMP_ORD_NOT_EXIST);
			} else {
				data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
				data.put(PmpPayConst.PMP_TRADE_STATUS, this.getTradeStatus(rnt.get(ScanPayConst.CODE)));
			}

			data.put(PmpPayConst.PMP_ERR_MSG, rnt.get(ScanPayConst.MESSAGE));
		}
		return data;

	}

	@Override
	public String getChlCode() {
		// TODO Auto-generated method stub
		return PmpPayConst.YLT_CHANNEL_CODE;
	}

	@Override
	public Map<String, Object> getQRCODEParam(OrdReqDTO dto, OrdDO ord, TradeDO tra) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> QrcodeRntConvert(Map<String, String> rnt) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
}
