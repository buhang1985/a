package iih.ci.mr.s.listener;

import org.apache.commons.lang3.ArrayUtils;
import iih.bd.bc.event.pub.IMrEventConst;
import iih.ci.mr.mrserviceext.s.bp.SendMrFpDataBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public class MrFpCustomComSendMsgListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		if(!(event.getSourceID().equals(IMrEventConst.EVENT_SOURCE_MR_AMR_COMPLETE)
				&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))return;

		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(ArrayUtils.isEmpty(newObjs))return;
		String[] idEnts=(String[])newObjs;
		if (idEnts==null || idEnts.length<=0) {
			return ;
		}
		String id_ent=idEnts[0];
		String sendResult = "false";
		try
		{
			SendMrFpDataBp _service = new SendMrFpDataBp();		
			sendResult=_service.sendCMISMsg(id_ent);
		}catch(Exception e){
			sendResult = "false";
			e.printStackTrace();
			throw new BizException("更新病案表失败");
		}	
		if (!sendResult.contains("true"))
			throw new BizException("更新病案表失败");
	}
}
