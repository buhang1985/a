package iih.ci.mr.s.bp.task.bp.MrCheckUnFilnishedTaskBP;

import java.util.HashMap;
import java.util.Map;

import iih.ci.mr.pub.MrConst.IMrSysMsgConst;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.message.message.i.IGenerateMessageExtdService;

public class SendUnFinisherMsgbp {

	public void SendUnFinisherMsg(CiMrmQryListDTO qrylistdto) throws BizException {
		Map<String, Object> msgMap = new HashMap<String, Object>();	
		IGenerateMessageExtdService msgService = ServiceFinder.find(IGenerateMessageExtdService.class);
		msgMap.put(IMrSysMsgConst.SD_CIMR_SUBMIT_EARLYWARNING,qrylistdto);
		msgService.GenerateMessageAndMap(IMrSysMsgConst.SD_CIMR_SUBMIT_EARLYWARNING, msgMap, null);
	}
}
