package iih.ci.rcm.contagionrejectremind.bp;

import java.util.HashMap;
import java.util.Map;

import iih.ci.mrqc.qcremindmsgdto.d.QcRemindMsgDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.message.message.i.IGenerateMessageExtdService;

public class ContagionRejectRemindBp {

	 // 发送消息
	public void sendRejectReminderMsg(QcRemindMsgDTO remindMsgDto)  throws BizException{
		// 组织消息参数
		Map<String, Object> msgMap = new HashMap<String, Object>();	
		IGenerateMessageExtdService msgService = ServiceFinder.find(IGenerateMessageExtdService.class);
		msgMap.put("MRCONREJECTREMIND",remindMsgDto);
		msgService.GenerateMessageAndMap("MRCONREJECTREMIND", msgMap, null);
	}	
}
