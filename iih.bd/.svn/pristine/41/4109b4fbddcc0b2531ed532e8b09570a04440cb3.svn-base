package iih.bd.srv.pub.listener;

import org.apache.commons.lang3.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public abstract class AbstractEvent4IEListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		
		//事件源及事件类型判断
		if(!(event.getSourceID().equals(getEventSourceid())
			&& (event.getEventType().equals(IEventType.TYPE_INSERT_AFTER)||event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)||event.getEventType().equals(IEventType.TYPE_DELETE_AFTER))))return;

		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(ArrayUtils.isEmpty(newObjs))return;
	    //发送集成平台消息
		sendIEMsg(newObjs,event.getEventType());
		
	}
	
	protected abstract void sendIEMsg(Object[] newObjs,String eventType) throws BizException;
	
	protected abstract String getEventSourceid() throws BizException;
	
}
