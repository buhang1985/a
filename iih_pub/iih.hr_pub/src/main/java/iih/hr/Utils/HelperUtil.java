package iih.hr.Utils;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 人力管理域帮助类
 * 
 * @author lijm
 *
 */
public class HelperUtil {
	/**
	 * 获取FArrayList中元素类表
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getEleListFromFArrayList(FArrayList param) throws BizException {
		if (param != null && param.size() > 0) {
			List<T> res = new ArrayList<T>();
			for (Object obj : param) {
				T ele = (T) obj;
				res.add(ele);
			}
			return res;
		}
		return null;
	}

	/**
	 * 获取FArrayList中第一个元素
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getFirstEleFromFArrayList(FArrayList param) throws BizException {
		if (param != null && param.size() > 0) {
			for (Object obj : param) {
				return (T) obj;
			}
		}
		return null;
	}

}
