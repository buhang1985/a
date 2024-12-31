package iih.bd.mm.common;

import iih.bd.bc.i.IQuanPriAmtConst;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

public class CalOperation {

	/**
	 * 价格舍入
	 */
	public static FDouble RoundPrice(FDouble price) {

		if (price == null || price.compareTo(FDouble.ZERO_DBL) == 0) {

			return price;
		}
		return price.setScale(IQuanPriAmtConst.QPA_PRI_PRECISION, FDouble.ROUND_HALF_UP);
	}

	/**
	 * 价格舍入(结存表)
	 */
	public static FDouble RoundBlPrice(FDouble price) {
		if (price != null) {
			price.setTrimZero(true);
		}
		if (price == null || price.compareTo(FDouble.ZERO_DBL) == 0) {

			return price;
		}
		return price.setScale(IQuanPriAmtConst.QPA_PRI4INV_PRECISION, FDouble.ROUND_HALF_UP);
	}

	/**
	 * 数量舍入
	 */
	public static FDouble RoundQuan(FDouble quan) {

		if (quan == null || quan.compareTo(FDouble.ZERO_DBL) == 0) {

			return quan;
		}
		return quan.setScale(IQuanPriAmtConst.QPA_QUAN_PRECISION, FDouble.ROUND_HALF_UP);
	}

	/**
	 * 数量舍入(结存表)
	 */
	public static FDouble RoundBlQuan(FDouble quan) {

		if (quan == null || quan.compareTo(FDouble.ZERO_DBL) == 0) {

			return quan;
		}
		return quan.setScale(IQuanPriAmtConst.QPA_QUAN4INV_PRECISION, FDouble.ROUND_HALF_UP);
	}

	/**
	 * 金额舍入
	 */
	public static FDouble RoundAmt(FDouble amt) {

		if (amt == null || amt.compareTo(FDouble.ZERO_DBL) == 0) {

			return amt;
		}
		return amt.setScale(IQuanPriAmtConst.QPA_AMT_PRECISION, FDouble.ROUND_HALF_UP);
	}

	/**
	 * 金额计算(传入价格、数量舍入后的计算)
	 */
	public static FDouble CalAmt(FDouble price, FDouble quan) {

		if ((price == null || price.compareTo(FDouble.ZERO_DBL) == 0)
				|| (quan == null || quan.compareTo(FDouble.ZERO_DBL) == 0)) {

			return FDouble.ZERO_DBL;
		}

		FDouble price_cal = RoundPrice(price);
		FDouble quan_cal = RoundQuan(quan);
		return RoundAmt(price_cal.multiply(quan_cal));
	}

	/**
	 * 包装单位换算
	 * 
	 * @throws BizException
	 */
	public static FDouble Conversion(String type, FDouble srcNum, FDouble srcFactor, FDouble desFactor)
			throws BizException {

		if (!IMeterialService.TYPE_NUM.equals(type) && !IMeterialService.TYPE_PRICE.equals(type)) {

			throw new BizException(String.format("传入换算类型%s不合法。【%s：数量换算；%s：价格换算.】", type, IMeterialService.TYPE_NUM,
					IMeterialService.TYPE_PRICE));
		}

		if (IMeterialService.TYPE_NUM.equals(type)) {

			return RoundBlQuan(srcNum.multiply(srcFactor, -16).div(desFactor, -16));
		} else {

			return RoundBlPrice(srcNum.multiply(desFactor.div(srcFactor, -16), -16));
		}
	}

	/**
	 * 传入数量向基本包装单位换算(传入数量先舍入有效位数、根据出库精度计算)
	 */
	public static FDouble ConversionToOutBaseNum(FDouble srcNum, FDouble srcFactor) throws BizException {

		FDouble baseNum = Multiply(RoundQuan(srcNum), srcFactor);
		return RoundBlQuan(baseNum);
	}

	/**
	 * 传入数量向基本包装单位换算(传入数量先舍入有效位数、根据库存精度计算)
	 */
	public static FDouble ConversionToInBaseNum(FDouble srcNum, FDouble srcFactor) throws BizException {

		FDouble baseNum = Multiply(RoundBlQuan(srcNum), srcFactor);
		return RoundBlQuan(baseNum);
	}

	/**
	 * 乘法运算
	 */
	public static FDouble Multiply(FDouble num1, FDouble num2) {

		return num1.multiply(num2, -16);
	}

	/**
	 * 除法运算
	 */
	public static FDouble Div(FDouble dividend_num, FDouble divisor_num) {

		return dividend_num.div(divisor_num, -16);
	}
}
