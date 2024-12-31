package iih.ci.ord.s.ems.event;

import iih.ci.ord.s.ems.listener.AbstractEvent4CIListener;
import xap.ip.log.XLogger;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 煎法需求修改后，进行IC集成平台事件触发监听器 （仅集成平台事件发送用）
 */
public class OrderTisanesReqClear extends AbstractEvent4CIListener{

	@Override
	protected void sendIEMsg(Object[] newObjs, String eventType) throws BizException {

		XLogger.info("煎法需求修改 ，触发缓存清理-->触发点"+this.getClass().getName());
		//查找缓存清除类
		iih.ci.ord.i.ems.ICiCacheClearMainService ciCacheClearMainService=ServiceFinder.find(iih.ci.ord.i.ems.ICiCacheClearMainService.class);
		//判断缓存是否为空，不为空的话全部清除缓存
		if(null !=ciCacheClearMainService){
			ciCacheClearMainService.ClearAll();
		}
	}

	@Override
	protected String getEventSourceid() throws BizException {
		
		return IBdSrvEventConst.TISANESREQ_ADDDELMOD_EVENT_SOURCEID;
	}

}
