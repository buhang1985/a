package iih.bd.srv.s.bp.event;

import iih.bd.srv.pub.IBdSrvEventConst;
import iih.bd.srv.pub.listener.AbstractEvent4IEListener;
import iih.bd.utils.log.BdSrvLogUtils;
import iih.ci.ord.i.ems.ICiCacheClearMainService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 付款策略费用对照修改事件的监听，用于清空缓存
 */
public class FireMedSrvFeeMDEvent4IeBP extends AbstractEvent4IEListener {

	@Override
	protected void sendIEMsg(Object[] newObjs, String eventType) throws BizException {
		ICiCacheClearMainService ciCacheClearMainService = ServiceFinder.find(ICiCacheClearMainService.class);
		if (ciCacheClearMainService == null) {
			BdSrvLogUtils.warn("ICiCacheClearMainService服务获取失败，无法清除缓存。");
			return;

		}
		ciCacheClearMainService.ClearAll();
	}

	@Override
	protected String getEventSourceid() throws BizException {

		return IBdSrvEventConst.MEDSRV_FEECOMPARE_EVENT_SOURCEID;
	}
}
