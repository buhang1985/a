package iih.ci.sdk.utils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import iih.ci.sdk.ems.meta.StringList;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 空对象 判断工具类
 * 
 * @author wangqingzhu
 *
 */
public class ObjectUtils {

	public static boolean isEmpty(Object obj) {
		return null == obj;
	}

	public static boolean isEmpty(String str) {
		return null == str || str.length() == 0;
	}

	public static boolean isEmpty(Object[] szObj) {
		return null == szObj || szObj.length == 0;
	}

	public static boolean isEmpty(Collection<?> c) {
		return null == c || 0 == c.size();
	}
	
	public static boolean isEmpty(CharSequence c) {
		return null == c || 0 == c.length();
	}
	

	public static boolean isEmpty(FDouble d) {
		return d == null;
	}

	public static boolean isEmpty(FDateTime d) {
		return null == d;
	}

	public static boolean isEquals2(Object obj1, Object obj2) {
		return (obj1 == null && obj2 == null)
				|| (obj1 != null ? obj1.equals(obj2) : (obj2 != null ? obj2.equals(obj1) : obj1.equals(obj2)));
	}

	public static boolean isTrue(FBoolean fg) {
		return FBoolean.TRUE.equals(fg);
	}

	public static boolean isTrue(String fg) {
		return !isEmpty(fg) && ("true".equals(fg.toLowerCase()) || "y".equals(fg.toLowerCase())
				|| "1".equals(fg.toLowerCase()) || "ok".equals(fg.toLowerCase()) || "yes".equals(fg.toLowerCase()));
	}

	public static boolean isTrue(char fg) {
		return 'y' == fg || 'Y' == fg || '1' == fg;
	}

	public static boolean isFalse(FBoolean fg) {
		return !isTrue(fg);
	}

	public static boolean isFalse(String fg) {
		return !isTrue(fg);
	}

	public static boolean isFalse(char fg) {
		return !isTrue(fg);
	}

	public static FBoolean nullBoolean(char fg) {
		return new FBoolean(isTrue(fg));
	}

	public static FBoolean nullBoolean(String fg) {
		return new FBoolean(isTrue(fg));
	}

	public static FBoolean nullBoolean(boolean fg) {
		return new FBoolean(fg);
	}

	public static FBoolean nullBoolean(FBoolean fg) {
		return new FBoolean(isTrue(fg));
	}

	public static boolean isEmpty(Map<?, ?> m) {
		return null == m || m.size() == 0;
	}

	public static String asString(Object[] szObj) {
		if (ObjectUtils.isEmpty(szObj)) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (Object obj : szObj) {
			sb.append(",").append(obj.toString());
		}

		return sb.substring(1);
	}

	public static <T extends Object> List<T> asList(T[] szObj) {
		return Arrays.asList(szObj);
	}

	/**
	 * 对比两个FDouble值是否相等
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws BizException
	 * @author ly
	 */
	public static boolean isEqualWithFDouble2(FDouble a, FDouble b) throws BizException {

		if (a == null || b == null)
			return false;

		return Math.abs(a.sub(b).doubleValue()) <= 0.00000001;
	}

	/**
	 * 计算后四舍五入
	 * 
	 * @param retentionNumber
	 *            保留小数
	 * @param pri
	 *            价格
	 * @return
	 */
	public static FDouble CalculationPriRounding(int retentionNumber, FDouble pri) {
		if (pri != null && retentionNumber > 0) {
			return pri.setScale(retentionNumber, BigDecimal.ROUND_HALF_UP);
		} else {
			return pri;
		}
	}

	/**
	 * 
	 * @param szSrc
	 * @param dst
	 * @return
	 */
	public static boolean contains(String[] szSrc, String dst) {
		if (isEmpty(szSrc)) {
			return false;
		}
		return Arrays.asList(szSrc).contains(dst);
	}

	/**
	 * 
	 * @param szSrc
	 * @param dst
	 * @return
	 */
	public static boolean contains(Collection<?> srvList, String dst) {
		if (isEmpty(srvList)) {
			return false;
		}
		return srvList.contains(dst);
	}

	/**
	 * 
	 * @param szSrc
	 * @param dst
	 * @return
	 */
	public static boolean contains(String Src, String dst) {
		if (isEmpty(Src)) {
			return false;
		}
		return Src.contains(dst);
	}

	/**
	 * 给定集合，以及要选择的属性，获取该属性的值
	 * @param ds
	 * @param attri
	 * @return
	 */
	public static StringList selectSubList(BaseDO[] ds, String attri) {
		if (null == ds || ds.length == 0)
			return null;

		StringList dstList = new StringList();
		for (BaseDO item : ds) {
			Object objValue = item.getAttrVal(attri);
			if (null != objValue) {
				dstList.add(objValue.toString());
			}
		}
		
		return dstList;
	}
	
	public static StringList selectSubList(Object[] ds, String attri) {
		if (null == ds || ds.length == 0)
			return null;

		StringList dstList = new StringList();
		for (Object item : ds) {
			if(item instanceof BaseDO) {
			Object objValue = ((BaseDO)item).getAttrVal(attri);
			if (null != objValue) {
				dstList.add(objValue.toString());
			}
			}
		}
		
		return dstList;
	}
	
	/**
	 * 
	 * @param v
	 * @return
	 */
	public static String nullHandle(Object v) {
		return isEmpty(v)?null:v.toString();
	}
	
	public static FArrayList toFarrayList(Collection<?> c) {
		FArrayList rstList = new FArrayList();
		rstList.addAll(c);
		return rstList;
	}
	
	public static FArrayList2 toFArrayList2(Collection<?> c) {
		FArrayList2 rstList = new FArrayList2();
		rstList.addAll(c);
		return rstList;
	}
}
