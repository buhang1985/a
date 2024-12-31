package iih.ci.event.ord.listeners.stop.ip;

import iih.ci.event.ord.listeners.IpEnterCommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 *  住院停止入口
 * @author F
 *
 * @date 2019年9月2日下午5:44:52
 *
 * @classpath iih.ci.event.ord.listeners.stop.ip.IpStopEnterListener
 */
public abstract class IpStopEnterListener extends IpEnterCommonListener{

	/**
	 *是否满足事件源和事件类型
	 */
	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(IpStopEnterListener.class.getSimpleName(), "住院停止入口");
		if(!(IOrdEventSources.IP_STOP_ENTER.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))){
			return false;
		}
		return true;
	}

}
