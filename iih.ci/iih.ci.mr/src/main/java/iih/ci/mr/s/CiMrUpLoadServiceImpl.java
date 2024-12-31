package iih.ci.mr.s;

import iih.bd.bc.event.pub.IMrEventConst;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.i.ICiMrUpLoadService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public class CiMrUpLoadServiceImpl implements ICiMrUpLoadService {

	@Override
	public boolean sendMessage(CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		if (ciMrDO == null || upLoadStatus == null)
			return false;
		// 数据封装
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(ciMrDO);
		paramList.add(upLoadStatus);
		
		BDCommonEvent event = new BDCommonEvent(
				IMrEventConst.EVENT_SOURCE_MR_UPLOAD, IEventType.TYPE_UPDATE_AFTER, paramList.toArray());
		EventDispatcher.fireEvent(event);
		return true;
	}

	@Override
	public boolean sendMessage2(CiMrDO[] ciMrDOs, String upLoadStatus) throws BizException {
		if (ciMrDOs == null || upLoadStatus == null)
			return false;
		// 数据封装
		List<Object> paramList = new ArrayList<Object>();
		paramList.add(ciMrDOs);
		paramList.add(upLoadStatus);
		
		BDCommonEvent event = new BDCommonEvent(
				IMrEventConst.EVENT_SOURCE_MR_UPLOAD, IEventType.TYPE_UPDATE_AFTER, paramList.toArray());
		EventDispatcher.fireEvent(event);
		return true;
	}
	
	@Override
	public boolean sendMessageByEventFlag(String[] msgArr, String eventFlag) throws BizException {
		if (eventFlag == null || "".equals(eventFlag))
			return false;
		if (msgArr == null || msgArr.length <= 0)
			return false;
		// 数据封装
		List<String> paramList = new ArrayList<String>();
		paramList.add(msgArr[0]);
		paramList.add(msgArr[1]);
		
		BDCommonEvent event = 
				new BDCommonEvent(eventFlag, IEventType.TYPE_UPDATE_AFTER, paramList.toArray());
		EventDispatcher.fireEvent(event);
		return true;
	}

}
