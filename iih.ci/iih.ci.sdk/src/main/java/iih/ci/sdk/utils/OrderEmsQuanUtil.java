package iih.ci.sdk.utils;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import xap.mw.coreitf.d.FDouble;

/**
 * 总量计算
 * @author Young
 *
 */
public class OrderEmsQuanUtil {

	public static FDouble getMMQuan_cur(String sd_mupakgu, FDouble quan_medu, FDouble factor_mb, FDouble factor, Integer times) {
		if (StringUtils.isNullOrEmpty(sd_mupakgu) || quan_medu == null || factor_mb == null || factor == null || times==null) 
            return new FDouble(0);
	    // 按次取整
	    if (sd_mupakgu.equals(IBdMmDictCodeConst.SD_MUPKGUTP_TIMES)) {
		    return new FDouble(Math.ceil(quan_medu.div(factor_mb.multiply(factor)).doubleValue()) * times);
	    }
	    // 按批取整
	    else if (sd_mupakgu.equals(IBdMmDictCodeConst.SD_MUPKGUTP_BATCH)) {
            return new FDouble(Math.ceil(quan_medu.multiply(times).div(factor_mb.multiply(factor)).doubleValue()));
	    }
	    // 不取整
	    else if (sd_mupakgu.equals(IBdMmDictCodeConst.SD_MUPKGUTP_NO)) {
		    return quan_medu.multiply(times).div(factor_mb.multiply(factor));
	    }
        return null;
    }
	
	/**
	 * 计算总量(非物品)
	 * 
	 * @param quan_medu
	 *            单次剂量
	 * @param times_cur
	 *            总次数
	 * @return
	 */
	public static FDouble getQuan_cur(FDouble quan_medu, Integer times_cur) {
		if (quan_medu == null || times_cur == null) 
            return new FDouble(0);
		return quan_medu.multiply(new FDouble(times_cur));
	}
}
