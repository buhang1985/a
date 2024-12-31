package iih.ci.ord.msg;

import java.util.HashMap;
import java.util.Map;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.message.message.i.IGenerateMessageExtdService;

/**
 * 消息发送类
 * 
 * @author HUMS
 *
 */
public class CiMsgSenderUtil {

	/**
	 * 发送给医嘱确认节点消息
	 * 
	 * @throws BizException
	 */
	public static void sendCiOrdConfirmMsg(CiOrderDO[] ciors) throws BizException {

		Context context = CiOrdAppUtils.getEnvContext();

		IGenerateMessageExtdService generateMsg = ServiceFinder.find(IGenerateMessageExtdService.class);
		Map<String, Object> contentMap = new HashMap<String, Object>();
		generateMsg.GenerateMessageAndMap(CiMsgReminderConst.CI_IP_ORDER_CONFIRM, contentMap, null);
	}
}
