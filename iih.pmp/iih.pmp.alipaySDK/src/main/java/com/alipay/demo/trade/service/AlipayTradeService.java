package com.alipay.demo.trade.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.demo.trade.model.builder.AlipayTradeCancelRequestBuilder;
import com.alipay.demo.trade.model.builder.AlipayTradePayRequestBuilder;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.builder.AlipayTradeQueryRequestBuilder;
import com.alipay.demo.trade.model.builder.AlipayTradeRefundRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPayResult;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.model.result.AlipayF2FQueryResult;
import com.alipay.demo.trade.model.result.AlipayF2FRefundResult;

/**
 * Created by liuyangkly on 15/7/29.
 */
public interface AlipayTradeService {

	// 当面付2.0流程支付
	public AlipayF2FPayResult tradePay(AlipayTradePayRequestBuilder builder) throws AlipayApiException;

	// 当面付2.0消费查询
	public AlipayF2FQueryResult queryTradeResult(AlipayTradeQueryRequestBuilder builder) throws AlipayApiException;

	// 当面付2.0消费退款
	public AlipayF2FRefundResult tradeRefund(AlipayTradeRefundRequestBuilder builder) throws AlipayApiException;

	// 当面付2.0预下单(生成二维码)
	public AlipayF2FPrecreateResult tradePrecreate(AlipayTradePrecreateRequestBuilder builder)
			throws AlipayApiException;

	// 消费撤销
	public AlipayTradeCancelResponse cancelPayResult(AlipayTradeCancelRequestBuilder builder) throws AlipayApiException;
}
