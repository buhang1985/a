package iih.pi.reg.s.bp.listener;

import iih.pi.reg.dto.d.PiPatWSCUResultDTO;
import xap.ip.event.WsExcecuteResultEvent;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 患者WS新增更新后监听(BS504,BS505)
 * 
 * @author ly
 * @date 2016-12-01
 */
public class PiPatWsEventListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		
		WsExcecuteResultEvent wsEvent = (WsExcecuteResultEvent)event;
		
		FArrayList2 resultList = (FArrayList2)wsEvent.getUserObject();
		if(resultList == null || resultList.size() == 0)
			throw new BizException();
		
		//TODO
		PiPatWSCUResultDTO result = (PiPatWSCUResultDTO)resultList.get(0);
		System.out.println();
		if(result == null || "0".equals(result.getCode()))
			throw new BizException("发送患者新增更新事件失败！");
		
	}
}
