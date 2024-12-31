package iih.bl.itf.std.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;

import xap.mw.coreitf.d.FDouble;

/**
 * 标准接口金额转换校验工具类
 * @author ly 2018/07/25
 *
 */
public class BlAmtConverUtil {

	/**
	 * 校验是否为数字
	 * @param amt
	 * @return
	 */
	public static boolean isNumeric(String amt){
		return StringUtils.isNumeric(amt);
	}
	
	/**
	 * 转换为内部处理类型
	 * 由分转换为元
	 * @param amt
	 * @return
	 */
	public static FDouble toFDouble(String amt){
		Double i = Double.parseDouble(amt);
		return new FDouble(i / 100, 2);
	}
	
	/**
	 * 转为外部提供类型
	 * 由元转换为分
	 * @param amt
	 */
	public static String toXmlString(FDouble amt){
		
		BigDecimal bg = new BigDecimal(amt.doubleValue() * 100);

        double doubleValue = bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

		DecimalFormat decimalFormat = new DecimalFormat("###################.###########");

		return decimalFormat.format(doubleValue);
		
//      return  String.valueOf(doubleValue);//double转成string时，会在末尾加上一个0，如12 会变为12.0
		//下面这个转换会损失精度，如amt为0.6666会变为67
//		Double d = amt.doubleValue();
//		return Integer.toString((int)Math.ceil(d*100));
	}
}
