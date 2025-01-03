package iih.ci.event.ord.listeners.diag.op;

import iih.ci.event.ord.listeners.diag.OpIpDiagCommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 门诊诊断BS303判断事件源事件类型
 * @author F
 *
 * @date 2019年9月18日下午4:01:42
 *
 * @classpath iih.ci.event.ord.listeners.diag.op.OpDiagEnterListener
 */
public abstract class OpDiagEnterListener extends OpIpDiagCommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(OpDiagEnterListener.class.getSimpleName(), "BS301门诊、急诊流水、急诊抢救诊断判断事件源和事件类型");
		if (!(IOrdEventSources.OP_DIAG_ENTER.equals(event.getSourceID())
				&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}
}
