package iih.pmp.pay.s;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.pmp.pay.d.SdkRefundParamDTO;
import iih.pmp.pay.d.SdkRefundResultDTO;
import iih.pmp.pay.i.IWxPaySdkService;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import wxpay.sdk.WXPmpPaySdk;
import wxpay.sdk.WXProConfig;
import xap.mw.core.data.BizException;

/**
 * 微信支付SDK服务
 * 
 * @author hao_wu 2020-1-13
 *
 */
public class WxPaySdkServiceImpl implements IWxPaySdkService {

	@Override
	public SdkRefundResultDTO refund(SdkRefundParamDTO paramDto) throws BizException {
		PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

		HashMap<String, Object> data = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(paramDto.getOutTradeNo())) {
			data.put("transaction_id", paramDto.getOutTradeNo());
		}
		data.put("out_trade_no", paramDto.getTradeNo());
		data.put("out_refund_no", paramDto.getRefundTradeNo());
		data.put("total_fee", pmputils.Yuan2Fen(paramDto.getTradeAmt()));
		data.put("refund_fee", pmputils.Yuan2Fen(paramDto.getRefundAmt()));
		data.put("refund_fee_type", "CNY");
		data.put("refund_desc", paramDto.getRefundReason());
		data.put("op_user_id", PmpPayAppUtils.getWXConfig().getMchID());
		String notifyurl = WXProConfig.getProperty("refund_notify_url");
		if (notifyurl != null && notifyurl.trim().length() != 0) {
			data.put("notify_url", notifyurl);
		}

		WXPmpPaySdk sdk = new WXPmpPaySdk();
		Map<String, String> res = sdk.refund(data);

		SdkRefundResultDTO resultDTO = new SdkRefundResultDTO();

		String returnCode = res.get("return_code");
		if (!"SUCCESS".equals(returnCode)) {
			resultDTO.setCode(SdkRefundResultDTO.CODE_FAIL);
			resultDTO.setMsg(res.get("return_msg"));
			return resultDTO;
		}

		String result_code = res.get("result_code");
		if (!"SUCCESS".equals(result_code)) {
			resultDTO.setCode(SdkRefundResultDTO.CODE_FAIL);
			String msg = String.format("%s|%s", res.get("err_code"), res.get("err_code_des"));
			resultDTO.setMsg(msg);
			return resultDTO;
		}

		resultDTO.setCode(SdkRefundResultDTO.CODE_SUCCESS);
		resultDTO.setOutTradeNo(res.get("refund_id"));
		return resultDTO;
	}
}
