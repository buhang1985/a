package iih.bd.srv.s.bp.event;

import iih.bd.srv.pub.IBdSrvEventConst;
import iih.bd.srv.pub.listener.AbstractEvent4IEListener;
import iih.ci.ord.i.ems.ICiCacheClearMainService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class FireOrDeptWfModifyEvent4IEBP2 extends AbstractEvent4IEListener {

	@Override
	protected void sendIEMsg(Object[] newObjs, String eventType) throws BizException {
		
		ServiceFinder.find(ICiCacheClearMainService.class).ClearAll();
	}

	@Override
	protected String getEventSourceid() throws BizException {
		// TODO Auto-generated method stub
		return IBdSrvEventConst.ORDEPTWF_ADDDELMOD_EVENT_SOURCEID;
	}

}
