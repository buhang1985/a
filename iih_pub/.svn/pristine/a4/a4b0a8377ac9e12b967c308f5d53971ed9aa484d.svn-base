package iih.bd.base.utils;

import iih.bd.bc.i.IQuanPriAmtConst;
import xap.mw.coreitf.d.FDouble;

/**
 * 精度帮助类
 * @author yankan
 * @since 2017-07-10
 *
 */
public class PrecisionUtils {
	/**
	 * 格式化价格
	 * @param price 单价
	 * @return
	 */
	public static FDouble formatPrice(FDouble price){
		return formatPresion(price,IQuanPriAmtConst.QPA_PRI_PRECISION);
	}
	/**
	 * 格式化数量
	 * @param quan 数量
	 * @return
	 */
	public static FDouble formatQuan(FDouble quan){
		return formatPresion(quan,IQuanPriAmtConst.QPA_QUAN_PRECISION);
	}
	/**
	 * 格式化金额
	 * @param amt 金额
	 * @return
	 */
	public static FDouble formatAmt(FDouble amt){
		return formatPresion(amt,IQuanPriAmtConst.QPA_AMT_PRECISION);
	}
	/**
	 * 格式化精度
	 * 默认四舍五入
	 * @param value 值
	 * @param precision 精度
	 * @return
	 */
	public static FDouble formatPresion(FDouble value,int precision){
		if(value==null){
			value = FDouble.ZERO_DBL;
		}
		return formatPresion(value,precision,FDouble.ROUND_HALF_UP);
	}
	/**
	 * 格式化精度
	 * @param value 值
	 * @param precision 精度
	 * @param roundingMode 进位方式
	 * @return
	 */
	public static FDouble formatPresion(FDouble value,int precision,int roundingMode){
		if(value==null){
			value = FDouble.ZERO_DBL;
		}
		return value.setScale(precision, roundingMode);
	}
}
