package iih.ci.mrqc.qcremindmsgdto.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.ci.mrqc.qcremindmsgdto.d.QcRemindMsgDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.message.message.i.IGenerateMessageExtdService;

public class QcRemindMsgBP {

	    // 发送消息
		public void sendQcReminderMsg(QcRemindMsgDTO remindMsgDto)  throws BizException{
			// 组织消息参数
			Map<String, Object> msgMap = new HashMap<String, Object>();	
			
			IGenerateMessageExtdService msgService = ServiceFinder.find(IGenerateMessageExtdService.class);
			if("环节质控".equals(remindMsgDto.getQc_type())){
				msgMap.put("CIMRLINKQC",remindMsgDto);
				msgService.GenerateMessageAndMap("CIMRLINKQC", msgMap, null);

			}
			if("科室质控".equals(remindMsgDto.getQc_type())){
				msgMap.put("CIMRDEPQC",remindMsgDto);
				msgService.GenerateMessageAndMap("CIMRDEPQC", msgMap, null);
			}
			if("终末质控".equals(remindMsgDto.getQc_type())){
				msgMap.put("CIMRTERMINALQC",remindMsgDto);
				msgService.GenerateMessageAndMap("CIMRTERMINALQC", msgMap, null);
			}
		}	
}
