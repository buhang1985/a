package iih.ci.rcm.contagionmessagedto.s.bp;

import java.util.HashMap;
import java.util.Map;
import iih.ci.rcm.contagion.dto.d.EntDto;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.message.message.i.IGenerateMessageExtdService;

public class ReportFillinMsgBP {
	
	 // 发送消息
	public void sendReportFillinMsg(EntDto[] entarr)  throws BizException{
		// 组织消息参数
		Map<String, Object> msgMap = new HashMap<String, Object>();		
		IGenerateMessageExtdService msgService = ServiceFinder.find(IGenerateMessageExtdService.class);
		msgMap.put("CIMRCONTAGION",entarr);
		msgService.GenerateMessageAndMap("CIMRCONTAGION", msgMap, null);
	
	}	

}
