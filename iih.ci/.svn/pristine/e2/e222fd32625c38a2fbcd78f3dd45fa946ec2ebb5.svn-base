package iih.ci.event.ord.bps.oprsign.ip.listenerbp;

import iih.ci.event.ord.bps.sign.ip.listenerbp.IpOpSignStandardBP;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;

public class IpOpAptSignStandardBP extends IpOpSignStandardBP {

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS007-科室手术审批 手术医嘱签署 判断事件源和事件类型");
		if(!(IOrdEventSources.IP_OP_APT_SIGN.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}
}
