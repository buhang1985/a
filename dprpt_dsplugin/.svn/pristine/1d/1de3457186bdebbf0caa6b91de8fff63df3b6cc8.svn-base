package iih.ci.ord.printmanage.qrcode.rules;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import iih.ci.ord.printmanage.dto.QRCodeParamDTO;
import iih.ci.ord.printmanage.qrcode.IQRCodeRule;

/**
 * @code JXncgxh南大医院二维码规则
 * @author LiYue
 * @date 2019年4月15日,上午9:49:37
 */
public class JXncgxhQRCodeRules implements IQRCodeRule   {

	@Override
	public String getCode(QRCodeParamDTO param) {
		// 第三方网站
		String www = "http://mobile.pku-hit.com/ispmultipay/web-pay/prepay?";
		// 使用默认时区和语言环境获得一个日历
		Calendar cal = Calendar.getInstance();
		// 设置日期时间格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 开始时间获取前3天日期
		cal.add(Calendar.DAY_OF_MONTH, -3);
		String dt_start = df.format(cal.getTime());
		// 结束时间获取后三天日期
		cal.add(Calendar.DAY_OF_MONTH, +6);
		String dt_end = df.format(cal.getTime());
		// 拼接字符串
		String strParam = "patCode=" + param.getPatCode() + "&hospitalCode=" + param.getOrgCode() + "&entpCode="
				+ param.getEntpCode() + "&startDate=" + dt_start + "&endDate=" + dt_end;
		// ordpresdto.setDataMatrix(www+strParam);
		return www + strParam;
	}

}
