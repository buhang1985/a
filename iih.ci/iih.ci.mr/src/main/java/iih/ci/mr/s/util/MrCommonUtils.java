/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mr.s.util;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 〈扼要描述〉
 * 〈功能详细描述〉
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class MrCommonUtils {
	/**
	 * 是否为空串判断
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isEmpty(String input) {

		return StringUtils.isBlank(input);
	}
	/**
	 * 触发事件
	 * 
	 * @param sourceid
	 * @param eventType
	 * @param userObjs
	 * @throws BizException
	 */
	public static void fireBDEvent(String sourceid, String eventType,
			Object[] userObjs) throws BizException {
		// 触发事件
		BDCommonEvent event = new BDCommonEvent(sourceid, eventType, userObjs);
		EventDispatcher.fireEvent(event);
	}
}
