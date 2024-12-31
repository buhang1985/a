package iih.ci.event.ord.listeners.cancel.ip;

import iih.ci.event.ord.listeners.IpEnterCommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 住院作废入口
 * @author F
 *
 * @date 2019年9月11日上午10:18:51
 *
 * @classpath iih.ci.event.ord.listeners.cancel.ip.IpCancelEnterListener
 */
public abstract class IpCancelEnterListener extends IpEnterCommonListener{

	/**
	 * 是否满足事件源和事件类型
	 */
	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(IpCancelEnterListener.class.getSimpleName(), "住院作废入口");
		if(!(IOrdEventSources.IP_CANCEL_ENTER.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))){
			return false;
		}
		return true;
	}
	
}
