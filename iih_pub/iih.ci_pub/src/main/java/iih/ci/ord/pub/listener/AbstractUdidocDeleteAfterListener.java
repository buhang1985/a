package iih.ci.ord.pub.listener;

import org.apache.commons.lang3.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.xbd.udi.d.desc.UdidocDODesc;

public abstract class AbstractUdidocDeleteAfterListener extends AbstractUdidocListener implements IBusinessListener{
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//事件源及事件类型判断 
		if(!(UdidocDODesc.CLASS_FULLNAME.equals(event.getSourceID()) && IEventType.TYPE_DELETE_AFTER.equals(event.getEventType()))) {
			return;
		}
		//获取数据
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(ArrayUtils.isEmpty(newObjs)) {
			return;
		}
		//将所有字典数据传进去，子类去筛选符合自身类型的数据，实现自身业务逻辑
		doYourActionAfter(newObjs);
	}
	

}
