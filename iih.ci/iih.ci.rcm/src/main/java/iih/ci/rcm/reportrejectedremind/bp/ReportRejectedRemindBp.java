package iih.ci.rcm.reportrejectedremind.bp;

import java.util.HashMap;
import java.util.Map;

import iih.ci.mrqc.qcremindmsgdto.d.QcRemindMsgDTO;
import iih.ci.rcm.reportcarddoc.d.Reportcarddocdto;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.message.message.i.IGenerateMessageExtdService;

public class ReportRejectedRemindBp {
	 // 发送消息
		public void reportRejectReminderMsg(Reportcarddocdto reportcarddocdto)  throws BizException{
			// 组织消息参数
			Map<String, Object> msgMap = new HashMap<String, Object>();	
			IGenerateMessageExtdService msgService = ServiceFinder.find(IGenerateMessageExtdService.class);
			msgMap.put("MR0001",reportcarddocdto);
			msgService.GenerateMessageAndMap("MR0001", msgMap, null);
		}	
}
