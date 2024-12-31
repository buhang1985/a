package iih.ci.event.ord.listeners.sign.ip;

import iih.ci.event.ord.listeners.IpEnterCommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 住院签署入口
 * @author F
 *
 * @date 2019年8月19日上午10:12:57
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.IpSignEnterListener
 */
public abstract class IpSignEnterListener extends IpEnterCommonListener{
	
	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(IpSignEnterListener.class.getSimpleName(), "住院签署入口");
		if(!(IOrdEventSources.IP_SIGN_ENTER.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))){
			return false;
		}
		return true;
	}

}
