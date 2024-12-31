package iih.pmp.pay.s;

import java.util.HashMap;
import java.util.Map;

import iih.pmp.pay.d.SdkRefundParamDTO;
import iih.pmp.pay.d.SdkRefundResultDTO;
import iih.pmp.pay.i.IAliPaySdkService;
import iih.pmp.pay.s.bp.AlipaySdk;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;

/**
 * 支付宝支付SDK服务
 * 
 * @author hao_wu 2020-1-13
 *
 */
public class AliPaySdkServiceImpl implements IAliPaySdkService {

	@Override
	public SdkRefundResultDTO refund(SdkRefundParamDTO paramDto) throws BizException {
		PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("trade_no", paramDto.getOutTradeNo());
		data.put("out_trade_no", paramDto.getTradeNo());
		data.put("refund_amount", pmputils.yuanToStr(paramDto.getRefundAmt()));
		data.put("out_request_no", paramDto.getRefundTradeNo());
		data.put("refund_reason", paramDto.getRefundReason());

		AlipaySdk sdk = new AlipaySdk();
		Map<String, String> res = sdk.refund(data);

		SdkRefundResultDTO resultDTO = new SdkRefundResultDTO();

		String tradeStatus = res.get(PmpPayConst.PMP_TRADE_STATUS);
		if (!PmpPayConst.PMP_SUCCESS.equals(tradeStatus)) {
			resultDTO.setCode(SdkRefundResultDTO.CODE_FAIL);
			String msg = String.format("%s|%s", res.get(PmpPayConst.PMP_ERR_CODE), res.get(PmpPayConst.PMP_ERR_MSG));
			resultDTO.setMsg(msg);
			return resultDTO;
		}

		resultDTO.setCode(SdkRefundResultDTO.CODE_SUCCESS);
		resultDTO.setOutTradeNo(res.get(PmpPayConst.PMP_TRADE_CHL_NO));
		return resultDTO;
	}
}
