package iih.ci.event.ord.listeners.diag.ip;

import iih.ci.event.ord.listeners.diag.OpIpDiagCommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 住院诊断BS301判断事件源和事件类型
 * @author F
 *
 * @date 2019年9月18日下午4:03:44
 *
 * @classpath iih.ci.event.ord.listeners.diag.ip.IpDiagEnterListener
 */
public abstract class IpDiagEnterListener extends OpIpDiagCommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(IpDiagEnterListener.class.getSimpleName(), "BS301住院、留观诊断判断事件源和事件类型");
		if (!(IOrdEventSources.IP_DIAG_ENTER.equals(event.getSourceID())
				&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}
	
}
