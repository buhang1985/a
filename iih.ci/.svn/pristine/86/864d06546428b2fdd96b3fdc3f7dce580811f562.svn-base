package iih.ci.mrqc.cimrsendrecallapplydto.s;

import java.util.HashMap;
import java.util.Map;

import iih.ci.mrqc.cimrsendrecallapplydto.d.CiMrSendRecallApplyDTO;
import iih.ci.mrqc.cimrsendrecallapplydto.i.ICiMrSendRecallApplyService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.message.message.i.IGenerateMessageExtdService;

@Service(serviceInterfaces = { ICiMrSendRecallApplyService.class }, binding = Binding.JSONRPC)
public class CiMrSendRecallApplyServiceImpl implements ICiMrSendRecallApplyService {

	@Override
	public void SendRecallApply(CiMrSendRecallApplyDTO sendRecallApply) throws BizException {
		Map<String, Object> msgMap = new HashMap<String, Object>();	
		IGenerateMessageExtdService msgService = ServiceFinder.find(IGenerateMessageExtdService.class);
		msgMap.put("CIMRRecallApply",sendRecallApply);
		msgService.GenerateMessageAndMap("CIMRRecallApply", msgMap, null);
	}
}
