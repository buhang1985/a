package iih.bd.srv.s.bp.iemsg;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public class UtilsIE {

	/**
	 * 触发集成平台事件
	 * @param sourceid
	 * @param eventType
	 * @param userObjs
	 * @throws BizException
	 */
	public static void FireEvent(String sourceid, String eventType, Object[] userObjs) throws BizException{
		//触发事件
		for (Object object : userObjs) {
			 BusinessEvent event=new BusinessEvent(sourceid, eventType, object);
		    	EventDispatcher.fireEvent(event);
		}
	}
	
	/**
	 * 触发事件
	 * @param sourceid
	 * @param eventType
	 * @param userObjs
	 * @throws BizException
	 */
	public static void FireBDEvent(String sourceid,String eventType,Object[] userObjs) throws BizException{
		//触发事件
		BDCommonEvent event=new BDCommonEvent(sourceid, eventType,userObjs);
    	EventDispatcher.fireEvent(event);
	}
	
	public static String GetActionStr(String EventType){
		//insert(新增)、update(变更)、delete(删除)
		String action="";
		switch(EventType){
		
		case IEventType.TYPE_INSERT_AFTER:
			action=IBdSrvIEEventConst.ACTION_INSERT;
			break;
		case IEventType.TYPE_UPDATE_AFTER:
			action=IBdSrvIEEventConst.ACTION_UPDATE;
			break;
		case IEventType.TYPE_DELETE_AFTER:
			action=IBdSrvIEEventConst.ACTION_DELETE;
			break;
		
		}
		
		return action;
	}
}
