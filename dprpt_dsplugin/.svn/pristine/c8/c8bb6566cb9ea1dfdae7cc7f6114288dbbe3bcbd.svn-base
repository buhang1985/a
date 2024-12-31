package iih.ci.ord.printmanage.qrcode.rules;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import iih.ci.ord.printmanage.dto.QRCodeParamDTO;
import iih.ci.ord.printmanage.qrcode.IQRCodeRule;
/**
 * @code 产品二维码生成规则
 * @author LiYue
 * @date 2019年4月18日,下午3:41:39
 */
public class SDlanlingQRCodeRule implements IQRCodeRule {

	@Override
	public String getCode(QRCodeParamDTO param) {
		//第三方网站
		String www = "http://mobile.pku-hit.com/ispmultipay/web-pay/prepay?";
		String strParam = "patCode=" + param.getPatCode() + 
				          "&hospitalCode=" + param.getOrgCode() + 
				          "&entpCode=" + param.getEntpCode();
		return www + strParam;
		
	}
}
