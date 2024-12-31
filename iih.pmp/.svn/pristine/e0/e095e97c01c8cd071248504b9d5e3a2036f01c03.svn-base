package iih.pmp.pay.s.bp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.lang.exception.ExceptionUtils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayDataDataserviceBillDownloadurlQueryRequest;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.builder.AlipayTradePayRequestBuilder;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.builder.AlipayTradeRefundRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPayResult;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.model.result.AlipayF2FRefundResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;

import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayBaseCost;
import iih.pmp.pay.utils.PmpAliPayLogUtils;

import com.alipay.demo.trade.utils.AlipayConfigInitUtil;

import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class AlipaySdk implements IPmpSdk {

	private AlipayTradeService tradeService;
	private AlipayClient alipayClient;
	private static PmpPayAppBaseUtils utils = new PmpPayAppBaseUtils();

	public AlipaySdk() throws BizException {

		if (AlipayConfigInitUtil.LoadConfig()) {
			tradeService = new AlipayTradeServiceImpl.ClientBuilder().build();
			if (ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(), PmpPayBaseCost.PMP_PROXYIP) != null
					&& ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(),
							PmpPayBaseCost.PMP_PROXYPORT) != null) {
				alipayClient = new DefaultAlipayClient(Configs.getOpenApiDomain(), Configs.getAppid(),
						Configs.getPrivateKey(), "json", "utf-8", Configs.getAlipayPublicKey(), Configs.getSignType(),
						ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(), PmpPayBaseCost.PMP_PROXYIP),
						Integer.valueOf(Integer.parseInt(ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(),
								PmpPayBaseCost.PMP_PROXYPORT))));
			} else {
				alipayClient = new DefaultAlipayClient(Configs.getOpenApiDomain(), Configs.getAppid(),
						Configs.getPrivateKey(), "json", "utf-8", Configs.getAlipayPublicKey(), Configs.getSignType());
			}

		} else {
			System.out.print("支付宝环境配置文件加载失败");
		}
	}

	@Override
	public Map<String, String> doScanPay(Map<String, Object> map) throws BizException {
		// 组装接口入参
		AlipayTradePayRequestBuilder builder = new AlipayTradePayRequestBuilder();
		builder.setOutTradeNo((String) map.get("out_trade_no"));
		builder.setSubject((String) map.get("subject"));
		builder.setTotalAmount((String) map.get("total_fee"));
		builder.setAuthCode((String) map.get("auth_code"));
		builder.setBody((String) map.get("body"));
		builder.setStoreId("1");

		// 调用接口
		AlipayF2FPayResult result;
		try {
			result = tradeService.tradePay(builder);
		} catch (AlipayApiException e) {
			PmpAliPayLogUtils.logExAndTitle(e, "反扫支付异常");
			handleAlipayApiException(e);
			String msg = String.format("反扫支付异常,异常信息:%s", ExceptionUtils.getFullStackTrace(e));
			throw new BizException(msg);
		}

		Map<String, String> data = new HashMap<String, String>();

		// 根据调用结果组装返回map
		switch (result.getTradeStatus()) {
		case SUCCESS:
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
			data.put(PmpPayConst.PMP_AMOUNT, result.getResponse().getTotalAmount());
			data.put(PmpPayConst.PMP_TRADE_NO, result.getResponse().getOutTradeNo());
			data.put(PmpPayConst.PMP_ORDER_NO, result.getResponse().getOutTradeNo());
			data.put(PmpPayConst.PMP_TRADE_CHL_NO, result.getResponse().getTradeNo());
			break;

		case FAILED:
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
			data.put(PmpPayConst.PMP_ERR_CODE, result.getResponse() == null ? "" : result.getResponse().getMsg());
			data.put(PmpPayConst.PMP_ERR_MSG, result.getResponse() == null ? "" : result.getResponse().getMsg());
			break;

		case UNKNOWN:
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
			data.put(PmpPayConst.PMP_ERR_CODE, result.getResponse() == null ? "" : result.getResponse().getMsg());
			data.put(PmpPayConst.PMP_ERR_MSG, result.getResponse() == null ? "" : result.getResponse().getMsg());
			break;
		}
		return data;
	}

	/**
	 * 统一处理API异常
	 * 
	 * @param e
	 * @throws BizException
	 */
	private void handleAlipayApiException(AlipayApiException e) throws BizException {
		if (e.getCause() != null && e.getCause() instanceof ConnectException) {
			throw new BizException("网络异常，请稍后再试");
		}
	}

	@Override
	public Map<String, String> doQuery(Map<String, Object> map) throws BizException {
		// AlipayTradeQueryRequestBuilder builder = new
		// AlipayTradeQueryRequestBuilder();
		// builder.setOutTradeNo((String)map.get("out_trade_no"));
		//
		// AlipayF2FQueryResult result = tradeService.queryTradeResult(builder);

		Map<String, String> data = new HashMap<String, String>();

		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
		request.setBizContent("{" + "\"out_trade_no\":\"" + map.get("out_trade_no") + "\"" + "  }");
		AlipayTradeQueryResponse response = null;
		try {
			response = alipayClient.execute(request);
		} catch (AlipayApiException e) {
			PmpAliPayLogUtils.logExAndTitle(e, "订单查询异常");
			handleAlipayApiException(e);
			String msg = String.format("订单查询异常,异常信息:%s", ExceptionUtils.getFullStackTrace(e));
			throw new BizException(msg);
		}
		if (response == null || response.getTradeStatus() == null) {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
			data.put(PmpPayConst.PMP_ERR_CODE, "");
			data.put(PmpPayConst.PMP_ERR_MSG, "");
		} else {
			// 根据调用结果组装返回map
			switch (response.getTradeStatus()) {
			case "TRADE_SUCCESS":
				data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
				data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
				data.put(PmpPayConst.PMP_AMOUNT, response.getTotalAmount());
				data.put(PmpPayConst.PMP_TRADE_NO, response.getOutTradeNo());
				data.put(PmpPayConst.PMP_ORDER_NO, response.getOutTradeNo());
				data.put(PmpPayConst.PMP_TRADE_CHL_NO, response.getTradeNo());
				break;
			case "TRADE_FINISHED":
				data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
				data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
				data.put(PmpPayConst.PMP_AMOUNT, response.getTotalAmount());
				data.put(PmpPayConst.PMP_TRADE_NO, response.getOutTradeNo());
				data.put(PmpPayConst.PMP_ORDER_NO, response.getOutTradeNo());
				data.put(PmpPayConst.PMP_TRADE_CHL_NO, response.getTradeNo());
				break;
			case "TRADE_CLOSED":
				data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
				data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
				data.put(PmpPayConst.PMP_ERR_CODE, response.getMsg());
				data.put(PmpPayConst.PMP_ERR_MSG, response.getSubMsg());
				break;

			case "WAIT_BUYER_PAY":
				data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
				data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
				data.put(PmpPayConst.PMP_ERR_CODE, response == null ? "" : response.getMsg());
				data.put(PmpPayConst.PMP_ERR_MSG, response == null ? "" : response.getMsg());
				break;
			}
		}
		return data;
	}

	@Override
	public Map<String, String> reverse(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> refund(Map<String, Object> map) throws BizException {
		// 组装接口入参
		AlipayTradeRefundRequestBuilder builder = new AlipayTradeRefundRequestBuilder();
		builder.setOutTradeNo((String) map.get("out_trade_no"));
		builder.setRefundAmount((String) map.get("refund_amount"));
		builder.setRefundReason((String) map.get("refund_reason"));
		builder.setOutRequestNo((String) map.get("out_request_no"));
		builder.setStoreId("1");

		// 调用接口
		AlipayF2FRefundResult result = null;
		try {
			result = tradeService.tradeRefund(builder);
		} catch (AlipayApiException e) {
			PmpAliPayLogUtils.logExAndTitle(e, "退款异常");
			handleAlipayApiException(e);
			String msg = String.format("退款异常,异常信息:%s", ExceptionUtils.getFullStackTrace(e));
			throw new BizException(msg);
		}

		Map<String, String> data = new HashMap<String, String>();

		// 根据调用结果组装返回map
		switch (result.getTradeStatus()) {
		case SUCCESS:
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
			// data.put(PmpPayConst.PMP_AMOUNT,
			// result.getResponse().getRefundFee());
			// 支付宝的refund_fee,返回的是退款总金额，而不是本次退款的金额，所以金额置为null
			data.put(PmpPayConst.PMP_AMOUNT, null);
			data.put(PmpPayConst.PMP_TRADE_NO, (String) map.get("out_request_no"));
			data.put(PmpPayConst.PMP_ORDER_NO, result.getResponse().getOutTradeNo());
			data.put(PmpPayConst.PMP_TRADE_CHL_NO, result.getResponse().getTradeNo());
			break;

		case FAILED:
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
			data.put(PmpPayConst.PMP_ERR_CODE, result.getResponse().getSubCode());
			data.put(PmpPayConst.PMP_ERR_MSG, result.getResponse().getSubMsg());
			break;

		case UNKNOWN:
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
			data.put(PmpPayConst.PMP_ERR_CODE, result.getResponse() == null ? "" : result.getResponse().getMsg());
			data.put(PmpPayConst.PMP_ERR_MSG, result.getResponse() == null ? "" : result.getResponse().getMsg());
			break;
		}
		return data;
	}

	@Override
	public Map<String, String> dorefundquery(Map<String, Object> map) throws BizException {
		AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
		request.setBizContent("{" + "\"out_trade_no\":\"" + map.get("out_trade_no") + "\"," + "\"out_request_no\":\""
				+ map.get("out_request_no") + "\"" + "  }");

		AlipayTradeFastpayRefundQueryResponse response = null;
		try {
			response = alipayClient.execute(request);
		} catch (AlipayApiException e) {
			PmpAliPayLogUtils.logExAndTitle(e, "退款查询异常");
			handleAlipayApiException(e);
			String msg = String.format("退款查询异常,异常信息:%s", ExceptionUtils.getFullStackTrace(e));
			throw new BizException(msg);
		}

		Map<String, String> data = new HashMap<String, String>();
		if (response == null) {
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
			data.put(PmpPayConst.PMP_ERR_CODE, "");
			data.put(PmpPayConst.PMP_ERR_MSG, "");
		} else {
			if (response.isSuccess()) {
				if (response.getCode() != null && response.getCode().equals("10000")) {
					if (response.getOutRequestNo() != null
							&& response.getOutRequestNo().equals(map.get("out_request_no") + "")) {
						data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
						data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
						data.put(PmpPayConst.PMP_AMOUNT, response.getRefundAmount());
						data.put(PmpPayConst.PMP_TRADE_NO, response.getOutRequestNo());
						data.put(PmpPayConst.PMP_ORDER_NO, response.getOutTradeNo());
						data.put(PmpPayConst.PMP_TRADE_CHL_NO, response.getTradeNo());
					} else {
						data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
						data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
						data.put(PmpPayConst.PMP_ERR_CODE, response.getMsg());
						data.put(PmpPayConst.PMP_ERR_MSG, response.getSubMsg());
					}
				} else {
					data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
					data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
					data.put(PmpPayConst.PMP_ERR_CODE, response.getMsg());
					data.put(PmpPayConst.PMP_ERR_MSG, response.getSubMsg());
				}
			} else {
				data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
				data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
				data.put(PmpPayConst.PMP_ERR_CODE, response.getMsg());
				data.put(PmpPayConst.PMP_ERR_MSG, response.getSubMsg());
			}

		}
		return data;
	}

	@Override
	public Map<String, String> GetCheckLedgerInfo(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> downloadfile(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getBillContent(Map<String, Object> map) throws BizException {
		String downloadbill_url = null;
		String[] bill_data = null;
		File temp = null;

		AlipayDataDataserviceBillDownloadurlQueryResponse response = getDownloadBillResponse(
				(String) map.get("bill_date"));

		if (response != null && "10000".equals(response.getCode())) {
			downloadbill_url = response.getBillDownloadUrl();
		} else {
			return null;
		}

		try {
			temp = File.createTempFile("temp", ".zip");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		if (temp != null) {
			if (!downLoadZip(downloadbill_url, temp)) {
				return null;
			}

			bill_data = readZipToString(temp);

			temp.delete();

			return bill_data;
		}

		return null;
	}

	private String[] readZipToString(File file) {
		List<String> connet = new ArrayList<String>();
		try {
			ZipInputStream in = new ZipInputStream(new FileInputStream(file), Charset.forName("gbk"));
			// 不解压直接读取,加上gbk解决乱码问题
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "gbk"));
			ZipEntry zipFile;
			// 循环读取zip中的cvs文件，无法使用jdk自带，因为文件名中有中文
			while ((zipFile = in.getNextEntry()) != null) {
				if (zipFile.isDirectory()) {
					// 如果是目录，不处理
				}
				// 获得cvs名字
				String fileName = zipFile.getName();
				// 检测文件是否存在
				if (fileName != null && fileName.contains("业务明细") && !fileName.contains("汇总")) {
					String line;
					while ((line = br.readLine()) != null) {
						connet.add(line);
					}
				}
			}

			br.close();
			in.close();

			return connet.subList(5, connet.size() - 4).toArray(new String[0]);
		} catch (Exception e) {
			return null;
		}
	}

	private boolean downLoadZip(String downloadbill_url, File f) {
		boolean down_success = false;
		int byteread = 0;

		InputStream inStream = null;
		FileOutputStream fs = null;

		try {
			URL url = new URL(downloadbill_url);
			URLConnection conn = url.openConnection();
			inStream = conn.getInputStream();

			fs = new FileOutputStream(f);

			byte[] buffer = new byte[4028];

			while ((byteread = inStream.read(buffer)) != -1) {
				fs.write(buffer, 0, byteread);
			}
			down_success = true;
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		} finally {
			try {
				if (inStream != null) {
					inStream.close();
				}
			} catch (IOException e) {
				inStream = null;
			}

			try {
				if (fs != null) {
					fs.close();
				}
			} catch (IOException e) {
				fs = null;
			}
		}
		return down_success;
	}

	private AlipayDataDataserviceBillDownloadurlQueryResponse getDownloadBillResponse(String date) throws BizException {
		AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();// 创建API对应的request类
		request.setBizContent("{" + "    \"bill_type\":\"trade\"," + "    \"bill_date\":\"" + date + "\"}"); // 设置业务参数

		try {
			return alipayClient.execute(request);// 通过alipayClient调用API，获得对应的response类
		} catch (AlipayApiException e) {
			PmpAliPayLogUtils.logExAndTitle(e, "下载账单异常");
			handleAlipayApiException(e);
			String msg = String.format("下载账单异常,异常信息:%s", ExceptionUtils.getFullStackTrace(e));
			throw new BizException(msg);
		}
	}

	@Override
	public String getChlCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> doQRCODEPay(Map<String, Object> map) throws BizException {
		AlipayTradePrecreateRequestBuilder builder = new AlipayTradePrecreateRequestBuilder();
		builder.setOutTradeNo((String) map.get("out_trade_no"));
		builder.setSubject((String) map.get("subject"));
		builder.setTotalAmount((String) map.get("total_fee"));
		builder.setBody((String) map.get("body"));
		builder.setStoreId("1");
		builder.setTimeoutExpress("120m");
		builder.setNotifyUrl("www.baidu.com");

		AlipayF2FPrecreateResult result;
		try {
			result = tradeService.tradePrecreate(builder);
		} catch (AlipayApiException e) {
			PmpAliPayLogUtils.logExAndTitle(e, "正扫支付异常");
			handleAlipayApiException(e);
			String msg = String.format("正扫支付异常,异常信息:%s", ExceptionUtils.getFullStackTrace(e));
			throw new BizException(msg);
		}

		Map<String, String> data = new HashMap<String, String>();

		switch (result.getTradeStatus()) {
		case SUCCESS:
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_SUCCESS);
			data.put(PmpPayConst.PMP__QR_CODE, result.getResponse().getQrCode());
			data.put(PmpPayConst.PMP__PREPAY_ID, null);
			break;

		case FAILED:
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_ERROR);
			data.put(PmpPayConst.PMP_ERR_CODE, result.getResponse().getMsg());
			data.put(PmpPayConst.PMP_ERR_MSG, result.getResponse().getSubMsg());
			break;

		case UNKNOWN:
			data.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
			data.put(PmpPayConst.PMP_TRADE_STATUS, PmpPayConst.PMP_UNKNOW);
			data.put(PmpPayConst.PMP_ERR_CODE, result.getResponse() == null ? "" : result.getResponse().getMsg());
			data.put(PmpPayConst.PMP_ERR_MSG, result.getResponse() == null ? "" : result.getResponse().getMsg());
			break;
		}
		return data;
	}

}
