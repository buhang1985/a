package iih.ci.event.ord.reissue.common;

import java.util.HashMap;

import iih.ci.event.i.reissue.IRessueAssebleDataService;
import iih.ci.event.ord.reissue.action.lis.IpReissueLisAciton;
import iih.ci.event.ord.reissue.action.lis.OpReissueLisAciton;
import iih.ci.event.ord.reissue.action.ris.IpReissueRisAction;
import iih.ci.event.ord.reissue.action.ris.OpReissueRisAction;
//import iih.ci.event.ord.reissue.action.ris.OpReissueRisAction;
import iih.ci.event.reissue.d.IEMsgReissueConst;
public class ReissueAssebleFactory {
	
	private IRessueAssebleDataService assbleService;
	
	private static final HashMap<String, HashMap<String, ReissueCommonAction>> map =
			new HashMap<>();
	private static final HashMap<String, ReissueCommonAction> opMap = new HashMap<>();
	private static final HashMap<String, ReissueCommonAction> ipMap = new HashMap<>();
	
	static {
		opMap.put(IEMsgReissueConst.ORDERRIS, new OpReissueRisAction());
		opMap.put(IEMsgReissueConst.ORDERLIS, new OpReissueLisAciton());
		map.put(IEMsgReissueConst.OPVISITTYPE, opMap);
		ipMap.put(IEMsgReissueConst.ORDERRIS, new IpReissueRisAction());
		ipMap.put(IEMsgReissueConst.ORDERLIS, new IpReissueLisAciton());
		map.put(IEMsgReissueConst.IPVISITTYPE, ipMap);
	}
	
	public IRessueAssebleDataService getInstace(String visitTypeCode,String orderExamOrLab){
		
		if (map.containsKey(visitTypeCode)) {
			HashMap<String, ReissueCommonAction> rcHashMap = map.get(visitTypeCode);
			if (rcHashMap.containsKey(orderExamOrLab)) {
				assbleService = rcHashMap.get(orderExamOrLab);
			}
		}
		
		return assbleService;
	}
}
